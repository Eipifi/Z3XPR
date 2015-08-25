// Generated from /Users/eipifi/Sources/z3fol/src/main/java/z3fol/xpr/XPR.g4 by ANTLR 4.5.1
package z3fol.xpr;
package z3fol.xpr;
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
	 * Visit a parse tree produced by {@link XPRParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(XPRParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(XPRParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_list(XPRParser.Expression_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyingExpression(XPRParser.MultiplyingExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#powExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpression(XPRParser.PowExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(XPRParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(XPRParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(XPRParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#equation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(XPRParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#relop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop(XPRParser.RelopContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(XPRParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#disjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(XPRParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(XPRParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#negation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(XPRParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPRParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(XPRParser.PredicateContext ctx);
}