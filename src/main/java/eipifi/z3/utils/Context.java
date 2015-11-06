package eipifi.z3.utils;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Expr;
import eipifi.lispy.Par;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public final class Context {

    private final Map<String, Expr> variables;
    private final List<CheckDecoder> decoders;
    private final Function<String, Expr> fallback;

    protected Context(Map<String, Expr> variables, List<CheckDecoder> decoders, Function<String, Expr> fallback) {
        this.variables = variables;
        this.decoders = decoders;
        this.fallback = fallback;
    }

    @SuppressWarnings("unchecked")
    public <T extends Expr> T get(String name) {
        Expr result = variables.containsKey(name) ? variables.get(name) : fallback.apply(name);
        return (T) result;
    }

    public Expr getExpr(String name) {
        return get(name);
    }

    public void set(String name, Expr value) {
        variables.put(name, value);
    }

    public Context child() {
        return new Context(new HashMap<>(), decoders, this::get);
    }

    @SuppressWarnings("unchecked")
    public <T> T decode(Par par) {
        for (CheckDecoder d: decoders) if (d.check(par)) return (T) d.decode(par, this);
        throw new IllegalArgumentException("Failed to decode par \"" + par + "\"");
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> decodeAll(List<Par> pars) {
        return pars.stream().map(this::decode).map(o -> (T) o).collect(Collectors.toList());
    }

    public <T> T[] decodeAll(IntFunction<T[]> allocator, List<Par> pars) {
        return pars.stream().map(this::decode).toArray(allocator);
    }

    public ArithExpr[] decodeArith(List<Par> pars) {
        return decodeAll(ArithExpr[]::new, pars);
    }

    public BoolExpr[] decodeBool(List<Par> pars) {
        return decodeAll(BoolExpr[]::new, pars);
    }

    public static class Builder implements Supplier<Context> {

        private Map<String, Expr> variables = new HashMap<>();
        private List<CheckDecoder> decoders = new ArrayList<>();

        public Builder wrap(Map<String, Expr> map) {
            variables = map;
            return this;
        }

        public Builder add(CheckDecoder... decoder) {
            decoders.addAll(Arrays.asList(decoder));
            return this;
        }

        @Override
        public Context get() {
            return new Context(variables, decoders, (n) -> null);
        }
    }
}
