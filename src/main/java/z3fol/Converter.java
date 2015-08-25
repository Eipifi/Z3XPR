package z3fol;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import z3fol.xpr.XPRBaseListener;
import z3fol.xpr.XPRLexer;
import z3fol.xpr.XPRListener;
import z3fol.xpr.XPRParser;

public class Converter {

    public static void folToZ3(String folExpression) {

        // Get our lexer
        XPRLexer lexer = new XPRLexer(new ANTLRInputStream(folExpression));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        XPRParser parser = new XPRParser(tokens);

        // Specify our entry point
        XPRParser.DocumentContext documentContext = parser.document();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        XPRListener listener = new XPRBaseListener();
        walker.walk(listener, documentContext);
    }
}
