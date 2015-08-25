package z3fol;

import com.microsoft.z3.Context;
import com.microsoft.z3.Global;
import com.microsoft.z3.Log;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import z3fol.xpr.DocumentParser;
import z3fol.antlr.*;

import java.util.HashMap;
import java.util.Map;

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
        XPRListener listener = freshListener();
        walker.walk(listener, documentContext);
    }

    private static XPRListener freshListener() {
        Global.ToggleWarningMessages(true);
        Log.open("test.log");

        Map<String, String> cfg = new HashMap<>();
        cfg.put("model", "true");
        Context ctx = new Context(cfg);
        return new DocumentParser(ctx);
    }
}
