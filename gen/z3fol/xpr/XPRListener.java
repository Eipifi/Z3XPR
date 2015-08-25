// Generated from /Users/eipifi/Sources/z3fol/src/main/java/z3fol/xpr/XPR.g4 by ANTLR 4.5.1
package z3fol.xpr;
package z3fol.xpr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPRParser}.
 */
public interface XPRListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XPRParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(XPRParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(XPRParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(XPRParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(XPRParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void enterExpression_list(XPRParser.Expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void exitExpression_list(XPRParser.Expression_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyingExpression(XPRParser.MultiplyingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyingExpression(XPRParser.MultiplyingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpression(XPRParser.PowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpression(XPRParser.PowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(XPRParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(XPRParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(XPRParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(XPRParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(XPRParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(XPRParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#equation}.
	 * @param ctx the parse tree
	 */
	void enterEquation(XPRParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#equation}.
	 * @param ctx the parse tree
	 */
	void exitEquation(XPRParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#relop}.
	 * @param ctx the parse tree
	 */
	void enterRelop(XPRParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#relop}.
	 * @param ctx the parse tree
	 */
	void exitRelop(XPRParser.RelopContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(XPRParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(XPRParser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(XPRParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(XPRParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(XPRParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(XPRParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#negation}.
	 * @param ctx the parse tree
	 */
	void enterNegation(XPRParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#negation}.
	 * @param ctx the parse tree
	 */
	void exitNegation(XPRParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(XPRParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(XPRParser.PredicateContext ctx);
}