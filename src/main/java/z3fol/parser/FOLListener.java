// Generated from FOL.g4 by ANTLR 4.5.1
package z3fol.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FOLParser}.
 */
public interface FOLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FOLParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(FOLParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(FOLParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(FOLParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(FOLParser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(FOLParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#disjunction}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(FOLParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(FOLParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(FOLParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#negation}.
	 * @param ctx the parse tree
	 */
	void enterNegation(FOLParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#negation}.
	 * @param ctx the parse tree
	 */
	void exitNegation(FOLParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(FOLParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(FOLParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#predicateTuple}.
	 * @param ctx the parse tree
	 */
	void enterPredicateTuple(FOLParser.PredicateTupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#predicateTuple}.
	 * @param ctx the parse tree
	 */
	void exitPredicateTuple(FOLParser.PredicateTupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(FOLParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(FOLParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(FOLParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(FOLParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#functionTuple}.
	 * @param ctx the parse tree
	 */
	void enterFunctionTuple(FOLParser.FunctionTupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#functionTuple}.
	 * @param ctx the parse tree
	 */
	void exitFunctionTuple(FOLParser.FunctionTupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(FOLParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(FOLParser.VariableDeclarationContext ctx);
}