package eipifi.lispy;

import eipifi.lispy.lang.Foobar;
import eipifi.lispy.lang.LispyErrorHandler;
import eipifi.lispy.lang.LispyLexer;
import eipifi.lispy.lang.LispyParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<Par> parse(String... strings) {
        String text = Arrays.stream(strings).collect(Collectors.joining());

        LispyErrorHandler errorHandler = new LispyErrorHandler();

        // Get our lexer
        LispyLexer lexer = new LispyLexer(new ANTLRInputStream(text));
        lexer.addErrorListener(errorHandler);

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        LispyParser parser = new LispyParser(tokens);
        parser.addErrorListener(errorHandler);

        // Specify our entry point
        LispyParser.DocumentContext documentContext = parser.document();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        Foobar listener = new Foobar();
        walker.walk(listener, documentContext);
        return listener.getValues();
    }
}
