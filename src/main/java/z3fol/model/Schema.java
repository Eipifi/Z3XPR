package z3fol.model;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Describes the complete structure of the database and operations
 */
public class Schema {

    public String model() {
        return Arrays.asList(this.getClass().getAnnotationsByType(Def.class))
                .stream()
                .map(Def::value)
                .map(s -> s + ";")
                .collect(Collectors.joining());
    }



}
