package z3fol.xpr;

import com.google.common.collect.ImmutableList;
import com.microsoft.z3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import z3fol.antlr.XPRBaseListener;

import java.util.*;

public class XPRParser extends XPRBaseListener {

    private static final Logger log = LoggerFactory.getLogger(XPRParser.class);
    private final Context z3ctx;
    private final TypeStorage types;
    private final VariableScope rootScope = new VariableScope();
    private final List<BoolExpr> facts = new LinkedList<>();

    public XPRParser() {
        z3ctx = z3Context();
        types = new TypeStorage(z3ctx);
    }

    public List<BoolExpr> facts() {
        return ImmutableList.copyOf(facts);
    }

    public Map<String, Expr> variables() {
        return rootScope.view();
    }

    public Map<String, Sort> types() {
        return types.view();
    }

    @Override
    public void enterDocument(z3fol.antlr.XPRParser.DocumentContext ctx) {
        ctx.line().forEach(this::parseLine);
    }

    private void parseLine(z3fol.antlr.XPRParser.LineContext ctx) {
        log.debug("Parsing line: {}", ctx.getText());

        if (ctx.typeDeclaration() != null) parseTypeDeclaration(ctx.typeDeclaration());
        if (ctx.variableDeclaration() != null) parseValDeclaration(ctx.variableDeclaration().variableWithType(), rootScope);
        if (ctx.factDeclaration() != null) facts.add(parseQuantifiedStatement(ctx.factDeclaration().quantifiedStatement(), rootScope.subScope()));
        if (ctx.assignment() != null) parseAssignment(ctx.assignment(), rootScope);

    }

    private void parseAssignment(z3fol.antlr.XPRParser.AssignmentContext ctx, VariableScope scope) {
        String name = ctx.variableIdentifier().getText();
        Expr value = parseAnyExpression(ctx.anyExpression(), scope);
        scope.put(name, value);
    }

    private BoolExpr parseQuantifiedStatement(z3fol.antlr.XPRParser.QuantifiedStatementContext ctx, VariableScope scope) {

        if (ctx.variableWithTypeList() != null) {
            ctx.variableWithTypeList().variableWithType().forEach((v) -> parseValDeclaration(v, scope));
        }

        BoolExpr body = parseStatement(ctx.statement(), scope);
        if (ctx.variableWithTypeList() == null) return body;

        List<z3fol.antlr.XPRParser.VariableWithTypeContext> varsAndTypes = ctx.variableWithTypeList().variableWithType();

        Sort[] argTypes = varsAndTypes.stream()
                .map((c) -> getType(c.type()))
                .toArray(XPRParser::sortAllocator);

        Symbol[] argSymbols = varsAndTypes.stream()
                .map((c) -> c.variableIdentifier().getText())
                .map(z3ctx::mkSymbol)
                .toArray(XPRParser::symbolAllocator);

        if (ctx.FORALL() != null) return z3ctx.mkForall(argTypes, argSymbols, body, 1, null, null, null, null);
        if (ctx.EXISTS() != null) return z3ctx.mkExists(argTypes, argSymbols, body, 1, null, null, null, null);
        throw new IllegalStateException();
    }

    private BoolExpr parseStatement(z3fol.antlr.XPRParser.StatementContext ctx, VariableScope scope) {
        BoolExpr[] res = ctx.disjunction().stream().map(c -> parseDisjunction(c, scope)).toArray(XPRParser::boolExprAllocator);
        if (ctx.logop() != null) {
            if (ctx.logop().IMPLIES() != null) return z3ctx.mkImplies(res[0], res[1]);
            if (ctx.logop().IFF() != null) return z3ctx.mkIff(res[0], res[1]);
            if (ctx.logop().XOR() != null) return z3ctx.mkXor(res[0], res[1]);
            throw new IllegalStateException();
        }
        return res[0];
    }

    private BoolExpr parseDisjunction(z3fol.antlr.XPRParser.DisjunctionContext ctx, VariableScope scope) {
        BoolExpr[] res = ctx.conjunction().stream().map(c -> parseConjunction(c, scope)).toArray(XPRParser::boolExprAllocator);
        return (res.length == 1) ? res[0] : z3ctx.mkOr(res);
    }

    private BoolExpr parseConjunction(z3fol.antlr.XPRParser.ConjunctionContext ctx, VariableScope scope) {
        BoolExpr[] res = ctx.statementAtom().stream().map(c -> parseStatementAtom(c, scope)).toArray(XPRParser::boolExprAllocator);
        return (res.length == 1) ? res[0] : z3ctx.mkAnd(res);
    }

    private BoolExpr parseStatementAtom(z3fol.antlr.XPRParser.StatementAtomContext ctx, VariableScope scope) {
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

    private BoolExpr parseSetStatement(z3fol.antlr.XPRParser.SetStatementContext ctx, VariableScope scope) {
        Expr e1 = parseAnyExpression(ctx.anyExpression(), scope);
        Expr e2 = parseSetExpression(ctx.setExpression(), scope);
        BoolExpr inSet = (BoolExpr) z3ctx.mkSetMembership(e1, e2);
        if (ctx.setop().SET_IN() != null) return inSet;
        if (ctx.setop().SET_NOTIN() != null) return z3ctx.mkNot(inSet);
        throw new IllegalStateException();
    }

    private BoolExpr parseCmpStatement(z3fol.antlr.XPRParser.CmpStatementContext ctx, VariableScope scope) {
        ArithExpr e1 = parseArithExpression(ctx.arithExpression(0), scope);
        ArithExpr e2 = parseArithExpression(ctx.arithExpression(1), scope);
        if (ctx.cmpop().LT() != null) return z3ctx.mkLt(e1, e2);
        if (ctx.cmpop().LE() != null) return z3ctx.mkLe(e1, e2);
        if (ctx.cmpop().GT() != null) return z3ctx.mkGt(e1, e2);
        if (ctx.cmpop().GE() != null) return z3ctx.mkGe(e1, e2);
        throw new IllegalStateException();
    }

    private BoolExpr parseEqStatement(z3fol.antlr.XPRParser.EqStatementContext ctx, VariableScope scope) {
        Expr e1 = parseAnyExpression(ctx.anyExpression(0), scope);
        Expr e2 = parseAnyExpression(ctx.anyExpression(1), scope);
        if (ctx.eqop().EQ() != null) return z3ctx.mkEq(e1, e2);
        if (ctx.eqop().NEQ() != null) return z3ctx.mkNot(z3ctx.mkEq(e1, e2));
        throw new IllegalStateException();
    }

    private Expr parseAnyExpression(z3fol.antlr.XPRParser.AnyExpressionContext ctx, VariableScope scope) {
        if (ctx.arithExpression() != null) return parseArithExpression(ctx.arithExpression(), scope);
        if (ctx.setExpression() != null) return parseSetExpression(ctx.setExpression(), scope);
        if (ctx.variable() != null) return parseVariable(ctx.variable(), scope);
        throw new IllegalStateException();
    }

    private Expr parseVariable(z3fol.antlr.XPRParser.VariableContext ctx, VariableScope scope) {
        if (ctx.variableIdentifier() != null) return scope.mustGet(ctx.variableIdentifier().getText());
        if (ctx.variableTuple() != null) return parseVariableTuple(ctx.variableTuple(), scope);
        throw new IllegalStateException();
    }

    private Expr parseVariableTuple(z3fol.antlr.XPRParser.VariableTupleContext ctx, VariableScope scope) {
        Expr[] vars = ctx.variable().stream().map(c -> parseVariable(c, scope)).toArray(XPRParser::exprAllocator);
        String tupleName = ctx.typeIdentifier().getText();
        Sort sort = types.get(tupleName);
        if (sort == null) throw new IllegalStateException("Cannot use type " + tupleName + " - type not declared");
        if (!(sort instanceof TupleSort)) throw new IllegalStateException("Type " + tupleName + " is not a tuple");
        TupleSort tupleSort = (TupleSort) sort;
        return tupleSort.mkDecl().apply(vars);
    }

    private Expr parseSetExpression(z3fol.antlr.XPRParser.SetExpressionContext ctx, VariableScope scope) {
        return parseSetSum(ctx.setSum(), scope);
    }

    private Expr parseSetSum(z3fol.antlr.XPRParser.SetSumContext ctx, VariableScope scope) {
        Expr[] exprs = ctx.setMul().stream().map(c -> parseSetMul(c, scope)).toArray(XPRParser::exprAllocator);
        return exprs.length == 1 ? exprs[0] : z3ctx.mkSetUnion(exprs);
    }

    private Expr parseSetMul(z3fol.antlr.XPRParser.SetMulContext ctx, VariableScope scope) {
        Expr[] exprs = ctx.setAtom().stream().map(c -> parseSetAtom(c, scope)).toArray(XPRParser::exprAllocator);
        return exprs.length == 1 ? exprs[0] : z3ctx.mkSetIntersection(exprs);
    }

    private Expr parseSetAtom(z3fol.antlr.XPRParser.SetAtomContext ctx, VariableScope scope) {
        if (ctx.variableIdentifier() != null) return scope.mustGet(ctx.variableIdentifier().getText());
        if (ctx.setExpression() != null) return parseSetExpression(ctx.setExpression(), scope);
        if (ctx.inlineSet() != null) return parseInlineSet(ctx.inlineSet(), scope);
        throw new IllegalStateException();
    }

    private Expr parseInlineSet(z3fol.antlr.XPRParser.InlineSetContext ctx, VariableScope scope) {
        Expr[] vars = ctx.arithExpressionList().arithExpression().stream().map(c -> parseArithExpression(c, scope)).toArray(XPRParser::exprAllocator);
        // TODO: check if all elements are of the same sort
        SetSort setSort = z3ctx.mkSetSort(vars[0].getSort());

        return null;
    }

    private ArithExpr parseArithExpression(z3fol.antlr.XPRParser.ArithExpressionContext ctx, VariableScope scope) {
        return parseArithSum(ctx.arithSum(), scope);
    }

    private ArithExpr parseArithSum(z3fol.antlr.XPRParser.ArithSumContext ctx, VariableScope scope) {
        ArithExpr[] values = ctx.arithMul().stream().map(c -> parseArithMul(c, scope)).toArray(XPRParser::arithExprAllocator);

        ArithExpr expr = values[0];
        List<z3fol.antlr.XPRParser.SumopContext> ops = ctx.sumop();
        for (int i = 0; i < ops.size(); ++i) {
            if (ops.get(i).PLUS() != null) {
                expr = z3ctx.mkAdd(expr, values[i + 1]);
            } else {
                expr = z3ctx.mkSub(expr, values[i + 1]);
            }
        }
        return expr;
    }


    private ArithExpr parseArithMul(z3fol.antlr.XPRParser.ArithMulContext ctx, VariableScope scope) {
        ArithExpr[] values = ctx.arithPow().stream().map(c -> parseArithPow(c, scope)).toArray(XPRParser::arithExprAllocator);

        ArithExpr expr = values[0];
        List<z3fol.antlr.XPRParser.MulopContext> ops = ctx.mulop();
        for (int i = 0; i < ops.size(); ++i) {
            if (ops.get(i).TIMES() != null) {
                expr = z3ctx.mkMul(expr, values[i + 1]);
            } else {
                expr = z3ctx.mkDiv(expr, values[i + 1]);
            }
        }
        return expr;
    }

    private ArithExpr parseArithPow(z3fol.antlr.XPRParser.ArithPowContext ctx, VariableScope scope) {
        ArithExpr base = parseArithAtom(ctx.arithAtom(), scope);
        if (ctx.POW() != null) {
            ArithExpr exponent = parseArithExpression(ctx.arithExpression(), scope);
            return z3ctx.mkPower(base, exponent);
        } else return base;
    }

    private ArithExpr parseArithAtom(z3fol.antlr.XPRParser.ArithAtomContext ctx, VariableScope scope) {
        if (ctx.variableIdentifier() != null) return scope.mustGetArith(ctx.variableIdentifier().getText());
        if (ctx.number() != null) return parseNumber(ctx.number());
        if (ctx.arithExpression() != null) return parseArithExpression(ctx.arithExpression(), scope);
        throw new IllegalStateException();
    }

    private ArithExpr parseNumber(z3fol.antlr.XPRParser.NumberContext ctx) {
        return z3ctx.mkInt(ctx.getText());
    }

    private void parseValDeclaration(z3fol.antlr.XPRParser.VariableWithTypeContext ctx, VariableScope scope) {
        String name = ctx.variableIdentifier().getText();
        Sort sort = getType(ctx.type());
        if (scope.get(name) != null) throw new IllegalStateException("Cannot redeclare variable " + name);
        scope.put(name, z3ctx.mkConst(name, sort));
    }

    public void parseTypeDeclaration(z3fol.antlr.XPRParser.TypeDeclarationContext ctx) {
        String name = ctx.typeIdentifier().getText();
        if (ctx.type() == null) {
            types.put(name, z3ctx.mkUninterpretedSort(name));
        } else {
            types.put(name, getType(name, ctx.type()));
        }
    }

    private Sort getType(z3fol.antlr.XPRParser.TypeContext ctx) {
        return getType("__anonymous__", ctx);
    }

    private Sort getType(String name, z3fol.antlr.XPRParser.TypeContext ctx) {
        if (ctx.typeIdentifier() != null) return types.get(ctx.typeIdentifier().getText());

        if (ctx.typeTuple() != null) {
            List<z3fol.antlr.XPRParser.TypeContext> subTypes = ctx.typeTuple().type();
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

    private static Context z3Context() {
        Global.ToggleWarningMessages(true);
        Log.open("test.log");
        Map<String, String> cfg = new HashMap<>();
        cfg.put("model", "true");
        return new Context(cfg);
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
