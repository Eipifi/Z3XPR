package z3fol.xpr;

import com.google.common.collect.ImmutableMap;
import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
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

    public Expr mustGet(String key) {
        Expr expr = get(key);
        if (expr == null) throw new IllegalStateException("Failed to fetch variable " + key);
        return expr;
    }

    public BoolExpr mustGetBool(String key) {
        Expr expr = mustGet(key);
        if (expr instanceof BoolExpr) return (BoolExpr) expr;
        throw new IllegalStateException("Variable " + key + " is not of type Bool.");
    }

    public ArithExpr mustGetArith(String key) {
        Expr expr = mustGet(key);
        if (expr instanceof ArithExpr) return (ArithExpr) expr;
        throw new IllegalStateException("Variable " + key + " is not an arithmetic type.");
    }

    public Map<String, Expr> view() {
        return ImmutableMap.copyOf(values);
    }
}
