// Generated from /Users/eipifi/Sources/z3fol/src/main/java/eipifi/xpr/lang/XPR.g4 by ANTLR 4.5.1
package eipifi.xpr.lang;
package eipifi.xpr.lang;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XPRParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XPRVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XPRParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(XPRParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(XPRParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#declarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationList(XPRParser.DeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(XPRParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(XPRParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#arithExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithExpr(XPRParser.ArithExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(XPRParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(XPRParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(XPRParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#membership}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMembership(XPRParser.MembershipContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#quantifiedExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiedExpr(XPRParser.QuantifiedExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#arrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(XPRParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#inlineSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineSet(XPRParser.InlineSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(XPRParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(XPRParser.DocumentContext ctx);
}