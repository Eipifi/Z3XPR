package eipifi.z3.utils;

import eipifi.lispy.Par;

import java.util.Objects;
import java.util.regex.Pattern;

public interface CheckDecoder extends Decoder {
    default boolean check(Par par) {

        Check check = this.getClass().getAnnotation(Check.class);
        if (check == null)
            return true;

        if (check.names().length > 0)
            if(! par.is(check.names()))
                return false;

        if (!Objects.equals(check.regexp(), ""))
            return Pattern.compile(check.regexp()).matcher(par.name()).matches();


        if (check.arity() >= 0)
            if (par.arity() != check.arity())
                return false;

        if (check.arityMin() >= 0)
            if (par.arity() < check.arityMin())
                return false;

        if (check.arityMax() >= 0)
            if (par.arity() > check.arityMax())
                return false;

        return true;
    }
}
