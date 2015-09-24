package z3fol.xpr;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import z3fol.antlr.XPRLexer;
import z3fol.antlr.XPRParser;

import java.util.List;
import java.util.Map;

public final class Document {

    private final Parser xprParser = new Parser();

    public void process(String xprCode) {
        // Get our lexer
        XPRLexer lexer = new XPRLexer(new ANTLRInputStream(xprCode));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        XPRParser parser = new XPRParser(tokens);

        // Specify our entry point
        XPRParser.DocumentContext documentContext = parser.document();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(xprParser, documentContext);
    }

    public List<BoolExpr> facts() {
        return xprParser.facts();
    }

    public Map<String, Sort> types() {
        return xprParser.types();
    }

    public Map<String, Expr> variables() {
        return xprParser.variables();
    }

}
