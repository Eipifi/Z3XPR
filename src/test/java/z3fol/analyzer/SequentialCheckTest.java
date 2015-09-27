package z3fol.analyzer;

import com.microsoft.z3.Status;
import org.junit.Test;
import z3fol.xpr.AnnotatedOperation;
import z3fol.xpr.AnnotatedSchema;
import z3fol.xpr.Op;
import z3fol.xpr.XPR;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SequentialCheckTest {

    @Test
    public void shouldCorrectlyClassifyCounterExample() {
        Map<String, Status> result = SequentialCheck.check(new Counter());
        assertEquals(result.get("Add"), Status.UNSATISFIABLE);
        assertEquals(result.get("Del"), Status.SATISFIABLE);
    }

    @XPR("Int counter")
    @XPR(value = "counter >= 0", type = XPR.Type.INVARIANT)
    @Op(Counter.Add.class)
    @Op(Counter.Del.class)
    public static class Counter extends AnnotatedSchema {

        @XPR(value = "Int value", type = XPR.Type.ARGUMENT)
        @XPR(value = "value >= 0", type = XPR.Type.CONDITION)
        @XPR(value = "counter := counter + value", type = XPR.Type.EFFECT)
        public static class Add extends AnnotatedOperation { }

        @XPR(value = "Int value", type = XPR.Type.ARGUMENT)
        @XPR(value = "value >= 0", type = XPR.Type.CONDITION)
        @XPR(value = "counter := counter - value", type = XPR.Type.EFFECT)
        public static class Del extends AnnotatedOperation { }
    }

    @Test
    public void shouldCorrectlyClassifySetExample() {
        Map<String, Status> result = SequentialCheck.check(new SetOps());
        assertEquals(result.get("AddBig"), Status.UNSATISFIABLE);
        assertEquals(result.get("AddSmall"), Status.SATISFIABLE);
    }

    @XPR("Int{} values")
    @XPR(value = "Forall Int x: x in values => x > 0", type = XPR.Type.INVARIANT)
    @Op(SetOps.AddBig.class)
    @Op(SetOps.AddSmall.class)
    public static class SetOps extends AnnotatedSchema {

        @XPR(value = "Int arg", type = XPR.Type.ARGUMENT)
        @XPR(value = "arg > 5", type = XPR.Type.CONDITION)
        @XPR(value = "values := values ∪ {arg}", type = XPR.Type.EFFECT)
        public static class AddBig extends AnnotatedOperation { }

        @XPR(value = "Int arg", type = XPR.Type.ARGUMENT)
        @XPR(value = "arg < 5", type = XPR.Type.CONDITION)
        @XPR(value = "values := values ∪ {arg}", type = XPR.Type.EFFECT)
        public static class AddSmall extends AnnotatedOperation { }

    }
}