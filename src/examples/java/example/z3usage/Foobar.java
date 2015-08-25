package example.z3usage;

import com.microsoft.z3.*;

import java.util.HashMap;
import java.util.Map;

public class Foobar {

    public static void main(String[] args) throws TestFailedException {

        Global.ToggleWarningMessages(true);
        Log.open("test.log");

        Map<String, String> cfg = new HashMap<>();
        cfg.put("model", "true");
        Context ctx = new Context(cfg);

        basicTests(ctx);

    }

    public static void bigIntCheck(RatNum r)
    {
        System.out.println("Num: " + r.getBigIntNumerator());
        System.out.println("Den: " + r.getBigIntDenominator());
    }

    public static ApplyResult applyTactic(Tactic t, Goal g)
    {
        System.out.println("\nGoal: " + g);

        ApplyResult res = t.apply(g);
        System.out.println("Application result: " + res);

        Status q = Status.UNKNOWN;
        for (Goal sg : res.getSubgoals())
            if (sg.isDecidedSat())
                q = Status.SATISFIABLE;
            else if (sg.isDecidedUnsat())
                q = Status.UNSATISFIABLE;

        switch (q)
        {
            case UNKNOWN:
                System.out.println("Tactic result: Undecided");
                break;
            case SATISFIABLE:
                System.out.println("Tactic result: SATISFIABLE");
                break;
            case UNSATISFIABLE:
                System.out.println("Tactic result: UNSATISFIABLE");
                break;
        }

        return res;
    }

    public static void modelConverterTest(Context ctx) throws TestFailedException
    {
        System.out.println("ModelConverterTest");

        ArithExpr xr = (ArithExpr) ctx.mkConst(ctx.mkSymbol("x"),
                ctx.mkRealSort());
        ArithExpr yr = (ArithExpr) ctx.mkConst(ctx.mkSymbol("y"),
                ctx.mkRealSort());
        Goal g4 = ctx.mkGoal(true, false, false);
        g4.add(ctx.mkGt(xr, ctx.mkReal(10, 1)));
        g4.add(ctx.mkEq(yr, ctx.mkAdd(xr, ctx.mkReal(1, 1))));
        g4.add(ctx.mkGt(yr, ctx.mkReal(1, 1)));

        ApplyResult ar = applyTactic(ctx.mkTactic("simplify"), g4);
        if (ar.getNumSubgoals() == 1
                && (ar.getSubgoals()[0].isDecidedSat() || ar.getSubgoals()[0]
                .isDecidedUnsat()))
            throw new TestFailedException();

        ar = applyTactic(ctx.andThen(ctx.mkTactic("simplify"),
                ctx.mkTactic("solve-eqs")), g4);
        if (ar.getNumSubgoals() == 1
                && (ar.getSubgoals()[0].isDecidedSat() || ar.getSubgoals()[0]
                .isDecidedUnsat()))
            throw new TestFailedException();

        Solver s = ctx.mkSolver();
        for (BoolExpr e : ar.getSubgoals()[0].getFormulas())
            s.add(e);
        Status q = s.check();
        System.out.println("Solver says: " + q);
        System.out.println("Model: \n" + s.getModel());
        System.out.println("Converted Model: \n"
                + ar.convertModel(0, s.getModel()));
        if (q != Status.SATISFIABLE)
            throw new TestFailedException();
    }

    public static void basicTests(Context ctx) throws TestFailedException
    {
        System.out.println("BasicTests");

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

        BoolExpr trivial_eq = ctx.mkEq(fApp, fApp);
        BoolExpr nontrivial_eq = ctx.mkEq(fApp, fApp2);

        Goal g = ctx.mkGoal(true, false, false);
        g.add(trivial_eq);
        g.add(nontrivial_eq);
        System.out.println("Goal: " + g);

        Solver solver = ctx.mkSolver();

        for (BoolExpr a : g.getFormulas())
            solver.add(a);

        if (solver.check() != Status.SATISFIABLE)
            throw new TestFailedException();

        ApplyResult ar = applyTactic(ctx.mkTactic("simplify"), g);
        if (ar.getNumSubgoals() == 1
                && (ar.getSubgoals()[0].isDecidedSat() || ar.getSubgoals()[0]
                .isDecidedUnsat()))
            throw new TestFailedException();

        ar = applyTactic(ctx.mkTactic("smt"), g);
        if (ar.getNumSubgoals() != 1 || !ar.getSubgoals()[0].isDecidedSat())
            throw new TestFailedException();

        g.add(ctx.mkEq(ctx.mkNumeral(1, ctx.mkBitVecSort(32)),
                ctx.mkNumeral(2, ctx.mkBitVecSort(32))));
        ar = applyTactic(ctx.mkTactic("smt"), g);
        if (ar.getNumSubgoals() != 1 || !ar.getSubgoals()[0].isDecidedUnsat())
            throw new TestFailedException();

        Goal g2 = ctx.mkGoal(true, true, false);
        ar = applyTactic(ctx.mkTactic("smt"), g2);
        if (ar.getNumSubgoals() != 1 || !ar.getSubgoals()[0].isDecidedSat())
            throw new TestFailedException();

        g2 = ctx.mkGoal(true, true, false);
        g2.add(ctx.mkFalse());
        ar = applyTactic(ctx.mkTactic("smt"), g2);
        if (ar.getNumSubgoals() != 1 || !ar.getSubgoals()[0].isDecidedUnsat())
            throw new TestFailedException();

        Goal g3 = ctx.mkGoal(true, true, false);
        Expr xc = ctx.mkConst(ctx.mkSymbol("x"), ctx.getIntSort());
        Expr yc = ctx.mkConst(ctx.mkSymbol("y"), ctx.getIntSort());
        g3.add(ctx.mkEq(xc, ctx.mkNumeral(1, ctx.getIntSort())));
        g3.add(ctx.mkEq(yc, ctx.mkNumeral(2, ctx.getIntSort())));
        BoolExpr constraint = ctx.mkEq(xc, yc);
        g3.add(constraint);
        ar = applyTactic(ctx.mkTactic("smt"), g3);
        if (ar.getNumSubgoals() != 1 || !ar.getSubgoals()[0].isDecidedUnsat())
            throw new TestFailedException();

        modelConverterTest(ctx);

        // Real num/den test.
        RatNum rn = ctx.mkReal(42, 43);
        Expr iNum = rn.getNumerator();
        Expr iDen = rn.getDenominator();
        System.out.println("Numerator: " + iNum + " Denominator: " + iDen);
        if (!iNum.toString().equals("42") || !iDen.toString().equals("43"))
            throw new TestFailedException();

        if (!rn.toDecimalString(3).equals("0.976?"))
            throw new TestFailedException();

        bigIntCheck(ctx.mkReal("-1231231232/234234333"));
        bigIntCheck(ctx.mkReal("-123123234234234234231232/234234333"));
        bigIntCheck(ctx.mkReal("-234234333"));
        bigIntCheck(ctx.mkReal("234234333/2"));

        String bn = "1234567890987654321";

        if (!ctx.mkInt(bn).getBigInteger().toString().equals(bn))
            throw new TestFailedException();

        if (!ctx.mkBV(bn, 128).getBigInteger().toString().equals(bn))
            throw new TestFailedException();

        if (ctx.mkBV(bn, 32).getBigInteger().toString().equals(bn))
            throw new TestFailedException();

        // Error handling test.
        try
        {
            @SuppressWarnings("unused")
            IntExpr i = ctx.mkInt("1/2");
            throw new TestFailedException(); // unreachable
        } catch (Z3Exception ignored) { }
    }

    @SuppressWarnings("serial")
    public static class TestFailedException extends Exception
    {
        public TestFailedException()
        {
            super("Check FAILED");
        }
    }
}
