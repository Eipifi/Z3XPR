package z3fol.xpr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnnotationUtils {

    public static List<String> findXPRs(Class<?> clazz, XPR.Type type) {
        return Arrays
                .stream(clazz.getAnnotationsByType(XPR.class))
                .filter(x -> x.what() == type)
                .flatMap(x -> Arrays.stream(x.value()))
                .collect(Collectors.toList());
    }

}
