// Generated from /Users/eipifi/Sources/z3fol/src/main/java/eipifi/xpr/lang/XPR.g4 by ANTLR 4.5.1
package eipifi.xpr.lang;
package eipifi.xpr.lang;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPRParser}.
 */
public interface XPRListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XPRParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(XPRParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(XPRParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(XPRParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(XPRParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationList(XPRParser.DeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationList(XPRParser.DeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(XPRParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(XPRParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(XPRParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(XPRParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void enterArithExpr(XPRParser.ArithExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void exitArithExpr(XPRParser.ArithExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(XPRParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(XPRParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(XPRParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(XPRParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(XPRParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(XPRParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#membership}.
	 * @param ctx the parse tree
	 */
	void enterMembership(XPRParser.MembershipContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#membership}.
	 * @param ctx the parse tree
	 */
	void exitMembership(XPRParser.MembershipContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#quantifiedExpr}.
	 * @param ctx the parse tree
	 */
	void enterQuantifiedExpr(XPRParser.QuantifiedExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#quantifiedExpr}.
	 * @param ctx the parse tree
	 */
	void exitQuantifiedExpr(XPRParser.QuantifiedExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#arrayExpr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(XPRParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#arrayExpr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(XPRParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#inlineSet}.
	 * @param ctx the parse tree
	 */
	void enterInlineSet(XPRParser.InlineSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#inlineSet}.
	 * @param ctx the parse tree
	 */
	void exitInlineSet(XPRParser.InlineSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(XPRParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(XPRParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(XPRParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(XPRParser.DocumentContext ctx);
}