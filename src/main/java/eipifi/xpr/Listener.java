package eipifi.xpr;

import eipifi.lispy.Par;
import eipifi.xpr.lang.XPRBaseListener;
import eipifi.xpr.lang.XPRParser.*;

import java.util.List;
import java.util.stream.Collectors;

public class Listener extends XPRBaseListener {
    private List<Par> values = null;

    public List<Par> getValues() {
        return values;
    }

    @Override
    public void enterDocument(DocumentContext ctx) {
        values = ctx.boolExpr().stream().map(this::parseBoolExpr).collect(Collectors.toList());
    }

    private Par parseBoolExpr(BoolExprContext ctx) {
        List<Par> sub = ctx.boolExpr().stream().map(this::parseBoolExpr).collect(Collectors.toList());
        if (ctx.LPAREN() != null) return sub.get(0);
        if (ctx.IFF() != null) return new Par("iff", sub);
        if (ctx.XOR() != null) return new Par("xor", sub);
        if (ctx.IMPLIES() != null) return new Par("xor", sub);
        if (ctx.AND() != null) return new Par("xor", sub);
        if (ctx.OR() != null) return new Par("xor", sub);
        if (ctx.id() != null) return parseId(ctx.id());
        if (ctx.KWD_TRUE() != null) return new Par("const", "true");
        if (ctx.KWD_FALSE() != null) return new Par("const", "false");
        if (ctx.membership() != null) return parseMembership(ctx.membership());
        if (ctx.comparison() != null) return parseComparison(ctx.comparison());
        if (ctx.equality() != null) return parseEquality(ctx.equality());
        if (ctx.quantifiedExpr() != null) return parseQuantifiedExpr(ctx.quantifiedExpr());
        throw new IllegalStateException();
    }

    private Par parseMembership(MembershipContext ctx) {
        return new Par("in", parseExpr(ctx.expr()), parseArrayExpr(ctx.arrayExpr()));
    }

    private Par parseExpr(ExprContext ctx) {
        if (ctx.expr() != null) return parseExpr(ctx.expr());
        if (ctx.id() != null) return parseId(ctx.id());
        if (ctx.num() != null) return parseNum(ctx.num());
        if (ctx.arithExpr() != null) return parseArithExpr(ctx.arithExpr());
        if (ctx.boolExpr() != null) return parseBoolExpr(ctx.boolExpr());
        throw new IllegalStateException();
    }

    private Par parseEquality(EqualityContext ctx) {
        List<Par> sub = ctx.expr().stream().map(this::parseExpr).collect(Collectors.toList());
        if (ctx.EQ() != null) return new Par("eq", sub);
        if (ctx.NEQ() != null) return new Par("neq", sub);
        throw new IllegalStateException();
    }

    private Par parseQuantifiedExpr(QuantifiedExprContext ctx) {



        return null;
    }

    private Par parseComparison(ComparisonContext ctx) {
        return null;
    }

    private Par parseArithExpr(ArithExprContext ctx) {
        return null;
    }

    private Par parseNum(NumContext ctx) {
        return new Par("num", ctx.getText());
    }

    private Par parseArrayExpr(ArrayExprContext ctx) {
        return null;
    }

    private Par parseId(IdContext id) {
        return new Par("var", id.getText());
    }
}
