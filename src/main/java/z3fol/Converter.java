package z3fol;

import com.microsoft.z3.BoolExpr;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import z3fol.xpr.XPRLexer;
import z3fol.xpr.XPRParser;

public class Converter {

    private static final Logger log = LoggerFactory.getLogger(Converter.class);

    public static BoolExpr folToZ3(String folExpression) {

        log.debug("Parsing expression: {}", folExpression);

        // Get our lexer
        XPRLexer lexer = new XPRLexer(new ANTLRInputStream(folExpression));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        XPRParser parser = new XPRParser(tokens);

        // Specify our entry point
        XPRParser.FormulaContext conditionContext = parser.formula();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        Foobar foobar = new Foobar();
        walker.walk(foobar, conditionContext);

        // Return the expression
        return foobar.getExpression();
    }
}
