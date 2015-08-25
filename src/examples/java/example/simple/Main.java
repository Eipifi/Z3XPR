package example.simple;


import com.microsoft.z3.*;
import z3fol.Converter;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(Converter.folToZ3("Exists x: x+5=10"));
        System.out.println(byHand(ctx()));
        System.out.println(getExpression(ctx()));
    }

    public static Context ctx() {
        Global.ToggleWarningMessages(true);
        //Log.open("test.log");
        Map<String, String> cfg = new HashMap<>();
        cfg.put("model", "true");
        return new Context(cfg);
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

    public static BoolExpr byHand(Context ctx) {
        Symbol sQwe = ctx.mkSymbol("Qwe");
        Symbol sQsd = ctx.mkSymbol("Qsd");
        Symbol sX = ctx.mkSymbol("?x");
        //FuncDecl fQwe = ctx.mkFuncDecl(sQwe, )
        return null;
    }

}
