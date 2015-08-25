package z3fol.xpr;

import com.microsoft.z3.Expr;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class VariableScope {

    private final Map<String, Expr> values = new HashMap<>();
    private Function<String, Expr> fallback = null;

    public VariableScope() {
        fallback = (k) -> null;
    }

    public void put(String key, Expr value) {
        values.put(key, value);
    }

    public Expr get(String key) {
        Expr expr = values.get(key);
        return (expr == null) ? fallback.apply(key) : expr;
    }

    public VariableScope subScope() {
        VariableScope sub = new VariableScope();
        sub.fallback = this::get;
        return sub;
    }

}
