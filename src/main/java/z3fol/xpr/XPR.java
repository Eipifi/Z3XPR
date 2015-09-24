package z3fol.xpr;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Global;
import com.microsoft.z3.Log;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import z3fol.antlr.XPRLexer;
import z3fol.antlr.XPRParser;
import z3fol.utils.State;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class XPR {

    public static List<BoolExpr> process(State state, String... xpr) {
        String text = Arrays.asList(xpr).stream().map(s -> s + ";").collect(Collectors.joining());

        // Get our lexer
        XPRLexer lexer = new XPRLexer(new ANTLRInputStream(text));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        XPRParser parser = new z3fol.antlr.XPRParser(tokens);

        // Specify our entry point
        XPRParser.DocumentContext documentContext = parser.document();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        NewParser listener = new NewParser(z3Context(), state);
        walker.walk(listener, documentContext);
        return listener.facts();
    }

    // Singleton
    private static Context ctx;

    private static Context z3Context() {
        if (ctx == null) {
            Global.ToggleWarningMessages(true);
            Log.open("test.log");
            Map<String, String> cfg = new HashMap<>();
            cfg.put("model", "true");
            ctx = new Context(cfg);
        }
        return ctx;
    }

}
