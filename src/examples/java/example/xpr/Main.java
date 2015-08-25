package example.xpr;

import com.microsoft.z3.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import z3fol.Foobar;
import z3fol.xpr.XPRLexer;
import z3fol.xpr.XPRParser;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Global.ToggleWarningMessages(true);
        Log.open("test.log");

        Map<String, String> cfg = new HashMap<>();
        cfg.put("model", "true");
        Context ctx = new Context(cfg);
        System.out.println(qwe(ctx));
    }

    public static BoolExpr qwe(Context ctx) {

        TupleSort winnerTupleSort = ctx.mkTupleSort(ctx.mkSymbol("WinnerTuple"), // name of
                new Symbol[]{ctx.mkSymbol("first"), ctx.mkSymbol("second")}, // names
                new Sort[]{ctx.mkUninterpretedSort(ctx.mkSymbol("AuctionID")), ctx.mkUninterpretedSort(ctx.mkSymbol("Buyer"))});

        SetSort wt = ctx.mkSetSort(winnerTupleSort);
        Expr winnerSet = ctx.mkConst("WinnerSet", wt);

        UninterpretedSort buyerSort = ctx.mkUninterpretedSort("Buyer");
        SetSort buyerSetSort = ctx.mkSetSort(buyerSort);
        Expr buyerSet = ctx.mkConst("BuyerSet", buyerSetSort);


        Expr auction = ctx.mkConst("auction", ctx.mkUninterpretedSort(ctx.mkSymbol("AuctionID")));
        Expr buyer = ctx.mkConst("buyer", ctx.mkUninterpretedSort(ctx.mkSymbol("Buyer")));

        Sort[] arg = new Sort[2];
        arg[0] = ctx.mkUninterpretedSort(ctx.mkSymbol("AuctionID"));
        arg[1] = ctx.mkUninterpretedSort(ctx.mkSymbol("Buyer"));
        Symbol[] names = new Symbol[2];
        names[0] = ctx.mkSymbol("auction");
        names[1] = ctx.mkSymbol("buyer");

        Expr[] argWinner = new Expr[2];
        argWinner[0] = auction;
        argWinner[1] = buyer;

        Expr winner = winnerTupleSort.mkDecl().apply(argWinner);

        Expr winnerExist =ctx.mkImplies( (BoolExpr)ctx.mkSetMembership(winner, winnerSet), (BoolExpr) ctx.mkSetMembership(buyer, buyerSet));

        return ctx.mkForall(arg, names, winnerExist, 1, null, null, null, null);
    }

    public static void parse(String folExpression) {

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

    }
}
