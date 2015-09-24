package z3fol.xpr;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(XPR.All.class)
public @interface XPR {
    String[] value();
    Type what() default Type.MODEL;

    @Retention(RetentionPolicy.RUNTIME)
    @interface All {
        XPR[] value();
    }

    enum Type {
        MODEL,
        ARGUMENT,
        CONDITION,
        EFFECT,
    }
}
