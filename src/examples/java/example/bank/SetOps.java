package example.bank;

import z3fol.xpr.AnnotatedOperation;
import z3fol.xpr.AnnotatedSchema;
import z3fol.xpr.Op;
import z3fol.xpr.XPR;

@XPR("Int{} values")
@XPR(value = "Forall Int x: x in values => x > 0", type = XPR.Type.INVARIANT)
@Op(SetOps.AddBig.class)
@Op(SetOps.AddSmall.class)
public class SetOps extends AnnotatedSchema {

    @XPR(value = "Int arg", type = XPR.Type.ARGUMENT)
    @XPR(value = "arg > 5", type = XPR.Type.CONDITION)
    @XPR(value = "values := values ∪ {arg}", type = XPR.Type.EFFECT)
    public static class AddBig extends AnnotatedOperation { }

    @XPR(value = "Int arg", type = XPR.Type.ARGUMENT)
    @XPR(value = "arg < 5", type = XPR.Type.CONDITION)
    @XPR(value = "values := values ∪ {arg}", type = XPR.Type.EFFECT)
    public static class AddSmall extends AnnotatedOperation { }

}
