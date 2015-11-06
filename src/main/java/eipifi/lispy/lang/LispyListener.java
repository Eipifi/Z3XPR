// Generated from Lispy.g4 by ANTLR 4.5.1
package eipifi.lispy.lang;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LispyParser}.
 */
public interface LispyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LispyParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(LispyParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispyParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(LispyParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispyParser#par}.
	 * @param ctx the parse tree
	 */
	void enterPar(LispyParser.ParContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispyParser#par}.
	 * @param ctx the parse tree
	 */
	void exitPar(LispyParser.ParContext ctx);
	/**
	 * Enter a parse tree produced by {@link LispyParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(LispyParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LispyParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(LispyParser.DocumentContext ctx);
}