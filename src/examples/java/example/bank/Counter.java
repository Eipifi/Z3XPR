package example.bank;

import z3fol.xpr.AnnotatedOperation;
import z3fol.xpr.AnnotatedSchema;
import z3fol.xpr.Op;
import z3fol.xpr.XPR;

@XPR("Int counter")
@XPR(value = "counter >= 0", type = XPR.Type.INVARIANT)
@Op(Counter.Add.class)
@Op(Counter.Del.class)
public class Counter extends AnnotatedSchema {

    @XPR(value = "Int value", type = XPR.Type.ARGUMENT)
    @XPR(value = "value >= 0", type = XPR.Type.CONDITION)
    @XPR(value = "counter := counter + value", type = XPR.Type.EFFECT)
    public static class Add extends AnnotatedOperation { }

    @XPR(value = "Int value", type = XPR.Type.ARGUMENT)
    @XPR(value = "value >= 0", type = XPR.Type.CONDITION)
    @XPR(value = "counter := counter - value", type = XPR.Type.EFFECT)
    public static class Del extends AnnotatedOperation { }
}
