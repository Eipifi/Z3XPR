// Generated from XPR.g4 by ANTLR 4.5.1
package z3fol.xpr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPRParser}.
 */
public interface XPRListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XPRParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(XPRParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(XPRParser.IdentifierContext ctx);
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
	 * Enter a parse tree produced by {@link XPRParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(XPRParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(XPRParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(XPRParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(XPRParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(XPRParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(XPRParser.TypeDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link XPRParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(XPRParser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(XPRParser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#typeTuple}.
	 * @param ctx the parse tree
	 */
	void enterTypeTuple(XPRParser.TypeTupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#typeTuple}.
	 * @param ctx the parse tree
	 */
	void exitTypeTuple(XPRParser.TypeTupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#typeGeneric}.
	 * @param ctx the parse tree
	 */
	void enterTypeGeneric(XPRParser.TypeGenericContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#typeGeneric}.
	 * @param ctx the parse tree
	 */
	void exitTypeGeneric(XPRParser.TypeGenericContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(XPRParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(XPRParser.VarDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link XPRParser#variableAndType}.
	 * @param ctx the parse tree
	 */
	void enterVariableAndType(XPRParser.VariableAndTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#variableAndType}.
	 * @param ctx the parse tree
	 */
	void exitVariableAndType(XPRParser.VariableAndTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#variableAndTypeList}.
	 * @param ctx the parse tree
	 */
	void enterVariableAndTypeList(XPRParser.VariableAndTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#variableAndTypeList}.
	 * @param ctx the parse tree
	 */
	void exitVariableAndTypeList(XPRParser.VariableAndTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFact(XPRParser.FactContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFact(XPRParser.FactContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(XPRParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(XPRParser.QuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#logic_statement}.
	 * @param ctx the parse tree
	 */
	void enterLogic_statement(XPRParser.Logic_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#logic_statement}.
	 * @param ctx the parse tree
	 */
	void exitLogic_statement(XPRParser.Logic_statementContext ctx);
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
	 * Enter a parse tree produced by {@link XPRParser#logop}.
	 * @param ctx the parse tree
	 */
	void enterLogop(XPRParser.LogopContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#logop}.
	 * @param ctx the parse tree
	 */
	void exitLogop(XPRParser.LogopContext ctx);
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
	 * Enter a parse tree produced by {@link XPRParser#mulExpression}.
	 * @param ctx the parse tree
	 */
	void enterMulExpression(XPRParser.MulExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#mulExpression}.
	 * @param ctx the parse tree
	 */
	void exitMulExpression(XPRParser.MulExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link XPRParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(XPRParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(XPRParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#predicate_call}.
	 * @param ctx the parse tree
	 */
	void enterPredicate_call(XPRParser.Predicate_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#predicate_call}.
	 * @param ctx the parse tree
	 */
	void exitPredicate_call(XPRParser.Predicate_callContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link XPRParser#set_theory_statement}.
	 * @param ctx the parse tree
	 */
	void enterSet_theory_statement(XPRParser.Set_theory_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#set_theory_statement}.
	 * @param ctx the parse tree
	 */
	void exitSet_theory_statement(XPRParser.Set_theory_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#setop}.
	 * @param ctx the parse tree
	 */
	void enterSetop(XPRParser.SetopContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#setop}.
	 * @param ctx the parse tree
	 */
	void exitSetop(XPRParser.SetopContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#assignment_op}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_op(XPRParser.Assignment_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#assignment_op}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_op(XPRParser.Assignment_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPRParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(XPRParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPRParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(XPRParser.InstructionContext ctx);
}