package z3fol.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Operation {
    public String preconditions() {
        return Arrays.asList(this.getClass().getAnnotationsByType(Precondition.class))
                .stream()
                .map(Precondition::value)
                .map(s -> s + ";")
                .collect(Collectors.joining());
    }

    public String postconditions() {
        return Arrays.asList(this.getClass().getAnnotationsByType(Postcondition.class))
                .stream()
                .map(Postcondition::value)
                .map(s -> s + ";")
                .collect(Collectors.joining());
    }
}
