package z3fol.xpr;

import com.google.common.collect.Lists;
import com.microsoft.z3.*;

import java.util.*;

public class Z3Utils {
    // Singleton
    private static Context ctx;

    public static Context ctx() {
        if (ctx == null) {
            Global.ToggleWarningMessages(true);
            Log.open("test.log");
            Map<String, String> cfg = new HashMap<>();
            cfg.put("model", "true");
            ctx = new Context(cfg);
        }
        return ctx;
    }

    public static Status check(BoolExpr... conditions) {
        return check(Lists.newArrayList(conditions));
    }

    public static Status check(List<BoolExpr> conditions) {
        Solver s = ctx().mkSolver();
        s.add(and(conditions));
        return s.check();
    }

    @SafeVarargs
    public static BoolExpr and(List<BoolExpr>... expressions) {
        BoolExpr[] array = Arrays.stream(expressions).flatMap(Collection::stream).toArray(BoolExpr[]::new);
        if (array.length == 0) return ctx().mkTrue();
        if (array.length == 1) return array[0];
        return ctx().mkAnd(array);
    }
}
