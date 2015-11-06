package eipifi.z3.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Check {
    String[] names() default {};
    String regexp() default "";
    int arity() default -1;
    int arityMin() default -1;
    int arityMax() default -1;
}
