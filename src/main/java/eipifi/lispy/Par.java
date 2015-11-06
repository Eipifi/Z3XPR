package eipifi.lispy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Par {

    private final String name;
    private final List<Par> values;

    public Par(String name, List<Par> values) {
        this.name = name;
        this.values = Collections.unmodifiableList(values);
    }

    public Par(String name, Object... values) {
        this(name, Arrays.stream(values).map(Par::convert).collect(Collectors.toList()));
    }

    public String name() {
        return name;
    }

    public List<Par> values() {
        return values;
    }

    public Par child(int n) {
        return values().get(n);
    }

    public int arity() {
        return values.size();
    }

    public boolean is(String... types) {
        for (String type: types)
            if(name.equals(type))
                return true;
        return false;
    }

    public boolean isAtom() {
        return values.size() == 0;
    }

    @Override
    // TODO: could be implemented faster
    public String toString() {
        if (values.size() == 0) return name;
        StringBuilder b = new StringBuilder().append("(").append(name);
        values.forEach(c -> b.append(" ").append(c));
        return b.append(")").toString();
    }

    private static Par convert(Object o) {
        if (o instanceof Par) return (Par) o;
        if (o instanceof String) return new Par((String) o);
        throw new IllegalArgumentException();
    }

    ////////////////////////////////////////////////////////////

    public Par lastChild() {
        return child(arity() - 1);
    }

    public List<Par> values(int num) {
        if (num == 0) return values();
        if (num > 0) return values().subList(0, num);
        return values().subList(arity() + num, arity());
    }
}
