package z3fol.xpr;

import com.microsoft.z3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import z3fol.antlr.XPRBaseListener;
import z3fol.antlr.XPRParser;

import java.util.List;
import java.util.Objects;

public class DocumentParser extends XPRBaseListener {

    private static final Logger log = LoggerFactory.getLogger(DocumentParser.class);
    private final Context z3ctx;
    private final TypeStorage types;
    private final VariableScope rootScope = new VariableScope();

    public DocumentParser(Context z3ctx) {
        this.z3ctx = z3ctx;
        types = new TypeStorage(z3ctx);
    }

    @Override
    public void enterDocument(XPRParser.DocumentContext ctx) {
        ctx.line().forEach(this::parseLine);
    }

    private void parseLine(XPRParser.LineContext ctx) {
        log.debug("Parsing line: {}", ctx.getText());

        if (ctx.typeDeclaration() != null) parseTypeDeclaration(ctx.typeDeclaration());
        if (ctx.variableDeclaration() != null) parseValDeclaration(ctx.variableDeclaration().variableWithType(), rootScope);
        if (ctx.factDeclaration() != null) parseQuantifiedStatement(ctx.factDeclaration().quantifiedStatement(), rootScope.subScope());

    }

    private BoolExpr parseQuantifiedStatement(XPRParser.QuantifiedStatementContext ctx, VariableScope scope) {

        if (ctx.variableWithTypeList() != null) {
            ctx.variableWithTypeList().variableWithType().forEach((v) -> parseValDeclaration(v, scope));
        }

        BoolExpr body = parseStatement(ctx.statement(), scope);
        if (ctx.variableWithTypeList() == null) return body;

        List<XPRParser.VariableWithTypeContext> varsAndTypes = ctx.variableWithTypeList().variableWithType();

        Sort[] argTypes = varsAndTypes.stream()
                .map((c) -> getType(c.type()))
                .toArray(DocumentParser::sortAllocator);

        Symbol[] argSymbols = varsAndTypes.stream()
                .map((c) -> c.variableIdentifier().getText())
                .map(z3ctx::mkSymbol)
                .toArray(DocumentParser::symbolAllocator);

        if (ctx.FORALL() != null) return z3ctx.mkForall(argTypes, argSymbols, body, 1, null, null, null, null);
        if (ctx.EXISTS() != null) return z3ctx.mkExists(argTypes, argSymbols, body, 1, null, null, null, null);
        throw new IllegalStateException();
    }

    private BoolExpr parseStatement(XPRParser.StatementContext ctx, VariableScope scope) {
        BoolExpr[] res = ctx.disjunction().stream().map(c -> parseDisjunction(c, scope)).toArray(DocumentParser::boolExprAllocator);
        if (ctx.logop() != null) {
            if (ctx.logop().IMPLIES() != null) return z3ctx.mkImplies(res[0], res[1]);
            if (ctx.logop().IFF() != null) return z3ctx.mkIff(res[0], res[1]);
            if (ctx.logop().XOR() != null) return z3ctx.mkXor(res[0], res[1]);
            throw new IllegalStateException();
        }
        return res[0];
    }

    private BoolExpr parseDisjunction(XPRParser.DisjunctionContext ctx, VariableScope scope) {
        BoolExpr[] res = ctx.conjunction().stream().map(c -> parseConjunction(c, scope)).toArray(DocumentParser::boolExprAllocator);
        return (res.length == 1) ? res[0] : z3ctx.mkOr(res);
    }

    private BoolExpr parseConjunction(XPRParser.ConjunctionContext ctx, VariableScope scope) {
        BoolExpr[] res = ctx.statementAtom().stream().map(c -> parseStatementAtom(c, scope)).toArray(DocumentParser::boolExprAllocator);
        return (res.length == 1) ? res[0] : z3ctx.mkAnd(res);
    }

    private BoolExpr parseStatementAtom(XPRParser.StatementAtomContext ctx, VariableScope scope) {
        if (ctx.eqStatement() != null) return parseEqStatement(ctx.eqStatement(), scope);
        if (ctx.cmpStatement() != null) return parseCmpStatement(ctx.cmpStatement(), scope);
        if (ctx.setStatement() != null) return parseSetStatement(ctx.setStatement(), scope);
        if (ctx.quantifiedStatement() != null) return parseQuantifiedStatement(ctx.quantifiedStatement(), scope.subScope());
        if (ctx.variableIdentifier() != null) {
            String name = ctx.variableIdentifier().getText();
            return scope.mustGetBool(name);
        }
        // TODO: negation
        return null;
    }

    private BoolExpr parseSetStatement(XPRParser.SetStatementContext ctx, VariableScope scope) {
        Expr e1 = parseAnyExpression(ctx.anyExpression(), scope);
        Expr e2 = parseSetExpression(ctx.setExpression(), scope);
        BoolExpr inSet = (BoolExpr) z3ctx.mkSetMembership(e1, e2);
        if (ctx.setop().SET_IN() != null) return inSet;
        if (ctx.setop().SET_NOTIN() != null) return z3ctx.mkNot(inSet);
        throw new IllegalStateException();
    }

    private BoolExpr parseCmpStatement(XPRParser.CmpStatementContext ctx, VariableScope scope) {
        ArithExpr e1 = parseArithExpression(ctx.arithExpression(0), scope);
        ArithExpr e2 = parseArithExpression(ctx.arithExpression(1), scope);
        if (ctx.cmpop().LT() != null) return z3ctx.mkLt(e1, e2);
        if (ctx.cmpop().LE() != null) return z3ctx.mkLe(e1, e2);
        if (ctx.cmpop().GT() != null) return z3ctx.mkGt(e1, e2);
        if (ctx.cmpop().GE() != null) return z3ctx.mkGe(e1, e2);
        throw new IllegalStateException();
    }

    private BoolExpr parseEqStatement(XPRParser.EqStatementContext ctx, VariableScope scope) {
        Expr e1 = parseAnyExpression(ctx.anyExpression(0), scope);
        Expr e2 = parseAnyExpression(ctx.anyExpression(1), scope);
        if (ctx.eqop().EQ() != null) return z3ctx.mkEq(e1, e2);
        if (ctx.eqop().NEQ() != null) return z3ctx.mkNot(z3ctx.mkEq(e1, e2));
        throw new IllegalStateException();
    }

    private Expr parseAnyExpression(XPRParser.AnyExpressionContext ctx, VariableScope scope) {
        if (ctx.arithExpression() != null) return parseArithExpression(ctx.arithExpression(), scope);
        if (ctx.setExpression() != null) return parseSetExpression(ctx.setExpression(), scope);
        if (ctx.variable() != null) return parseVariable(ctx.variable(), scope);
        throw new IllegalStateException();
    }

    private Expr parseVariable(XPRParser.VariableContext ctx, VariableScope scope) {
        if (ctx.variableIdentifier() != null) return scope.mustGet(ctx.variableIdentifier().getText());
        if (ctx.variableTuple() != null) return parseVariableTuple(ctx.variableTuple(), scope);
        throw new IllegalStateException();
    }

    private Expr parseVariableTuple2(XPRParser.VariableTupleContext ctx, VariableScope scope) {
        Expr[] vars = ctx.variable().stream().map(c -> parseVariable(c, scope)).toArray(DocumentParser::exprAllocator);
        Symbol[] fieldNames = new Symbol[vars.length];
        Sort[] fieldSorts = new Sort[vars.length];
        for (int i = 0; i < fieldNames.length; ++i) fieldNames[i] = z3ctx.mkSymbol(i);
        for (int i = 0; i < fieldSorts.length; ++i) fieldSorts[i] = vars[i].getSort();
        TupleSort tupleSort = z3ctx.mkTupleSort(z3ctx.mkSymbol("__tuple__"), fieldNames, fieldSorts);
        return tupleSort.mkDecl().apply(vars);
    }

    private Expr parseVariableTuple(XPRParser.VariableTupleContext ctx, VariableScope scope) {
        Expr[] vars = ctx.variable().stream().map(c -> parseVariable(c, scope)).toArray(DocumentParser::exprAllocator);
        String tupleName = ctx.typeIdentifier().getText();
        Sort sort = types.get(tupleName);
        if (sort == null) throw new IllegalStateException("Cannot use type " + tupleName + " - type not declared");
        if (!(sort instanceof TupleSort)) throw new IllegalStateException("Type " + tupleName + " is not a tuple");
        TupleSort tupleSort = (TupleSort) sort;
        return tupleSort.mkDecl().apply(vars);
    }

    private Expr parseSetExpression(XPRParser.SetExpressionContext ctx, VariableScope scope) {
        return parseSetSum(ctx.setSum(), scope);
    }

    private Expr parseSetSum(XPRParser.SetSumContext ctx, VariableScope scope) {
        Expr[] exprs = ctx.setMul().stream().map(c -> parseSetMul(c, scope)).toArray(DocumentParser::exprAllocator);
        return exprs.length == 1 ? exprs[0] : z3ctx.mkSetUnion(exprs);
    }

    private Expr parseSetMul(XPRParser.SetMulContext ctx, VariableScope scope) {
        Expr[] exprs = ctx.setAtom().stream().map(c -> parseSetAtom(c, scope)).toArray(DocumentParser::exprAllocator);
        return exprs.length == 1 ? exprs[0] : z3ctx.mkSetIntersection(exprs);
    }

    private Expr parseSetAtom(XPRParser.SetAtomContext ctx, VariableScope scope) {
        if (ctx.variableIdentifier() != null) return scope.mustGet(ctx.variableIdentifier().getText());
        if (ctx.setExpression() != null) return parseSetExpression(ctx.setExpression(), scope);
        if (ctx.inlineSet() != null) return parseInlineSet(ctx.inlineSet(), scope);
        throw new IllegalStateException();
    }

    private Expr parseInlineSet(XPRParser.InlineSetContext ctx, VariableScope scope) {
        Expr[] vars = ctx.arithExpressionList().arithExpression().stream().map(c -> parseArithExpression(c, scope)).toArray(DocumentParser::exprAllocator);
        return null;
    }

    private ArithExpr parseArithExpression(XPRParser.ArithExpressionContext ctx, VariableScope scope) {
        return parseArithSum(ctx.arithSum(), scope);
    }

    private ArithExpr parseArithSum(XPRParser.ArithSumContext ctx, VariableScope scope) {
        ArithExpr[] values = ctx.arithMul().stream().map(c -> parseArithMul(c, scope)).toArray(DocumentParser::arithExprAllocator);

        ArithExpr expr = values[0];
        List<XPRParser.SumopContext> ops = ctx.sumop();
        for (int i = 0; i < ops.size(); ++i) {
            if (ops.get(i).PLUS() != null) {
                expr = z3ctx.mkAdd(expr, values[i + 1]);
            } else {
                expr = z3ctx.mkSub(expr, values[i + 1]);
            }
        }
        return expr;
    }


    private ArithExpr parseArithMul(XPRParser.ArithMulContext ctx, VariableScope scope) {
        ArithExpr[] values = ctx.arithPow().stream().map(c -> parseArithPow(c, scope)).toArray(DocumentParser::arithExprAllocator);

        ArithExpr expr = values[0];
        List<XPRParser.MulopContext> ops = ctx.mulop();
        for (int i = 0; i < ops.size(); ++i) {
            if (ops.get(i).TIMES() != null) {
                expr = z3ctx.mkMul(expr, values[i + 1]);
            } else {
                expr = z3ctx.mkDiv(expr, values[i + 1]);
            }
        }
        return expr;
    }

    private ArithExpr parseArithPow(XPRParser.ArithPowContext ctx, VariableScope scope) {
        ArithExpr base = parseArithAtom(ctx.arithAtom(), scope);
        if (ctx.POW() != null) {
            ArithExpr exponent = parseArithExpression(ctx.arithExpression(), scope);
            return z3ctx.mkPower(base, exponent);
        } else return base;
    }

    private ArithExpr parseArithAtom(XPRParser.ArithAtomContext ctx, VariableScope scope) {
        if (ctx.variableIdentifier() != null) return scope.mustGetArith(ctx.variableIdentifier().getText());
        if (ctx.number() != null) return parseNumber(ctx.number());
        if (ctx.arithExpression() != null) return parseArithExpression(ctx.arithExpression(), scope);
        throw new IllegalStateException();
    }

    private ArithExpr parseNumber(XPRParser.NumberContext ctx) {
        return z3ctx.mkInt(ctx.getText());
    }

    private void parseValDeclaration(XPRParser.VariableWithTypeContext ctx, VariableScope scope) {
        String name = ctx.variableIdentifier().getText();
        Sort sort = getType(ctx.type());
        if (scope.get(name) != null) throw new IllegalStateException("Cannot redeclare variable " + name);
        scope.put(name, z3ctx.mkConst(name, sort));
    }

    public void parseTypeDeclaration(XPRParser.TypeDeclarationContext ctx) {
        String name = ctx.typeIdentifier().getText();
        if (ctx.type() == null) {
            types.put(name, z3ctx.mkUninterpretedSort(name));
        } else {
            types.put(name, getType(name, ctx.type()));
        }
    }

    private Sort getType(XPRParser.TypeContext ctx) {
        return getType("__anonymous__", ctx);
    }

    private Sort getType(String name, XPRParser.TypeContext ctx) {
        if (ctx.typeIdentifier() != null) return types.get(ctx.typeIdentifier().getText());

        if (ctx.typeTuple() != null) {
            List<XPRParser.TypeContext> subTypes = ctx.typeTuple().type();
            Symbol[] fieldNames = new Symbol[subTypes.size()];
            Sort[] fieldSorts = new Sort[subTypes.size()];
            for (int i = 0; i < fieldNames.length; ++i) fieldNames[i] = z3ctx.mkSymbol(i);
            for (int i = 0; i < fieldSorts.length; ++i) fieldSorts[i] = getType(subTypes.get(i));
            return z3ctx.mkTupleSort(z3ctx.mkSymbol(name), fieldNames, fieldSorts);
        }

        if (ctx.typeGeneric() != null) {
            String genericName = ctx.typeGeneric().typeIdentifier().getText();
            if (!Objects.equals(genericName, "Set")) throw new IllegalStateException("Unknown generic type " + genericName);
            return z3ctx.mkSetSort(getType(ctx.typeGeneric().type()));
        }

        throw new IllegalStateException();
    }

    public static Sort[] sortAllocator(int size) {
        return new Sort[size];
    }

    public static Symbol[] symbolAllocator(int size) {
        return new Symbol[size];
    }

    public static Expr[] exprAllocator(int size) {
        return new Expr[size];
    }

    public static BoolExpr[] boolExprAllocator(int size) {
        return new BoolExpr[size];
    }

    public static ArithExpr[] arithExprAllocator(int size) {
        return new ArithExpr[size];
    }
}
