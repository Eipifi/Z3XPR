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
        if (ctx.varDeclaration() != null) parseValDeclaration(ctx.varDeclaration().variableAndType(), rootScope);
        if (ctx.fact() != null) parseQuantifier(ctx.fact().quantifier(), rootScope.subScope());

    }

    private BoolExpr parseQuantifier(XPRParser.QuantifierContext ctx, VariableScope scope) {

        if (ctx.variableAndTypeList() != null) {
            ctx.variableAndTypeList().variableAndType().forEach((v) -> parseValDeclaration(v, scope));
        }

        BoolExpr body = parseLogicStatement(ctx.logic_statement(), scope);
        if (ctx.variableAndTypeList() == null) return body;

        List<XPRParser.VariableAndTypeContext> varsAndTypes = ctx.variableAndTypeList().variableAndType();

        Sort[] argTypes = varsAndTypes.stream()
                .map((c) -> getType(c.type()))
                .toArray(DocumentParser::sortAllocator);

        Symbol[] argSymbols = varsAndTypes.stream()
                .map((c) -> c.variable().identifier().getText())
                .map(z3ctx::mkSymbol)
                .toArray(DocumentParser::symbolAllocator);

        if (ctx.FORALL() != null) return z3ctx.mkForall(argTypes, argSymbols, body, 1, null, null, null, null);
        if (ctx.EXISTS() != null) return z3ctx.mkExists(argTypes, argSymbols, body, 1, null, null, null, null);
        throw new IllegalStateException();
    }

    private BoolExpr parseLogicStatement(XPRParser.Logic_statementContext ctx, VariableScope scope) {
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
        BoolExpr[] res = ctx.negation().stream().map(c -> parseNegation(c, scope)).toArray(DocumentParser::boolExprAllocator);
        return (res.length == 1) ? res[0] : z3ctx.mkAnd(res);
    }

    private BoolExpr parseNegation(XPRParser.NegationContext ctx, VariableScope scope) {
        BoolExpr result;
        if (ctx.predicate() != null) {
            result = parsePredicate(ctx.predicate(), scope);
        } else {
            result = parseQuantifier(ctx.quantifier(), scope.subScope());
        }

        return (ctx.NOT() == null) ? result : z3ctx.mkNot(result);
    }

    private BoolExpr parsePredicate(XPRParser.PredicateContext ctx, VariableScope scope) {
        return null;
    }

    private void parseValDeclaration(XPRParser.VariableAndTypeContext ctx, VariableScope scope) {
        String name = ctx.variable().identifier().getText();
        Sort sort = getType(ctx.type());
        if (scope.get(name) != null) throw new IllegalStateException("Cannot redeclare variable " + name);
        scope.put(name, z3ctx.mkConst(name, sort));
    }

    public void parseTypeDeclaration(XPRParser.TypeDeclarationContext ctx) {
        String name = ctx.identifier().getText();
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
        if (ctx.identifier_uc() != null) return types.get(ctx.identifier_uc().getText());

        if (ctx.typeTuple() != null) {
            List<XPRParser.TypeContext> subTypes = ctx.typeTuple().type();
            Symbol[] fieldNames = new Symbol[subTypes.size()];
            Sort[] fieldSorts = new Sort[subTypes.size()];
            for (int i = 0; i < fieldNames.length; ++i) fieldNames[i] = z3ctx.mkSymbol(i);
            for (int i = 0; i < fieldSorts.length; ++i) fieldSorts[i] = getType(subTypes.get(i));
            return z3ctx.mkTupleSort(z3ctx.mkSymbol(name), fieldNames, fieldSorts);
        }

        if (ctx.typeGeneric() != null) {
            String genericName = ctx.typeGeneric().identifier_uc().getText();
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

    public static BoolExpr[] boolExprAllocator(int size) {
        return new BoolExpr[size];
    }
}
