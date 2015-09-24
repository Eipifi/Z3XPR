package z3fol.model;

import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public final class State {

    private final Map<String, Sort> sorts = new HashMap<>();
    private final Map<String, Expr> exprs = new HashMap<>();

    public Sort getSort(String name) {
        return sorts.get(name);
    }

    public Expr getExpr(String name) {
        return exprs.get(name);
    }

    public void putSort(String name, Sort value) {
        sorts.put(name, value);
    }

    public void putExpr(String name, Expr value) {
        exprs.put(name, value);
    }

    public State copy() {
        State s = new State();
        s.sorts.putAll(sorts);
        s.exprs.putAll(exprs);
        return s;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        sorts.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> s.append("type ").append(e.getKey()).append(" ").append(e.getValue()).append('\n'));

        exprs.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> s.append(e.getValue().getSort()).append(" ").append(e.getKey()).append(" := ").append(e.getValue()).append('\n'));

        return s.toString();
    }

}
