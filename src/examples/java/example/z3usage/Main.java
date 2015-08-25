package example.z3usage;

import com.microsoft.z3.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Global.ToggleWarningMessages(true);
        //Log.open("test.log");

        Map<String, String> cfg = new HashMap<>();
        cfg.put("model", "true");
        Context ctx = new Context(cfg);

        solve(ctx, getExpression(ctx));
    }

    public static void solve(Context ctx, BoolExpr... expressions) {

        Goal g = ctx.mkGoal(true, false, false);

        for (BoolExpr e: expressions) g.add(e);

        System.out.println("Goal: " + g);
        Solver solver = ctx.mkSolver();

        for (BoolExpr a : g.getFormulas()) solver.add(a);

        Tactic t = ctx.mkTactic("simplify");

        System.out.println("\nGoal: " + g);

        ApplyResult res = t.apply(g);
        System.out.println("Application result: " + res);

        Status q = Status.UNKNOWN;
        for (Goal sg : res.getSubgoals())
            if (sg.isDecidedSat())
                q = Status.SATISFIABLE;
            else if (sg.isDecidedUnsat())
                q = Status.UNSATISFIABLE;

        System.out.println("Tactic result:" + q);
    }


    public static BoolExpr getExpression(Context ctx) {

        Symbol fName = ctx.mkSymbol("f");
        Symbol x = ctx.mkSymbol("x");
        Symbol y = ctx.mkSymbol("y");

        Sort bs = ctx.mkBoolSort();

        Sort[] domain = { bs, bs };
        FuncDecl f = ctx.mkFuncDecl(fName, domain, bs);
        Expr fApp = ctx.mkApp(f, ctx.mkConst(x, bs), ctx.mkConst(y, bs));

        Expr[] fArgs2 = { ctx.mkFreshConst("cp", bs) };
        Sort[] domain2 = { bs };
        Expr fApp2 = ctx.mkApp(ctx.mkFreshFuncDecl("fp", domain2, bs), fArgs2);

        return ctx.mkEq(fApp, fApp2);
    }
}
