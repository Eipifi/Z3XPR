package eipifi.xpr;

import eipifi.lispy.Par;
import eipifi.xpr.lang.XPRLexer;
import eipifi.xpr.lang.XPRParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static List<Par> parse(String... strings) {
        String text = Arrays.stream(strings).collect(Collectors.joining());

        XPRErrorHandler errorHandler = new XPRErrorHandler();

        // Get our lexer
        XPRLexer lexer = new XPRLexer(new ANTLRInputStream(text));
        lexer.addErrorListener(errorHandler);

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        XPRParser parser = new XPRParser(tokens);
        parser.addErrorListener(errorHandler);

        // Specify our entry point
        XPRParser.DocumentContext documentContext = parser.document();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        Listener listener = new Listener();
        walker.walk(listener, documentContext);
        return listener.getValues();
    }
}
