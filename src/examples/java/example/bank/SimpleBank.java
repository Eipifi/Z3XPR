package example.bank;

import z3fol.xpr.AnnotatedOperation;
import z3fol.xpr.AnnotatedSchema;
import z3fol.xpr.Op;
import z3fol.xpr.XPR;

@XPR("type Account (Int, Int)")
@XPR("Account{} accounts")
@XPR(value = "Forall Account a: a in accounts => a.1 >= 0", type = XPR.Type.INVARIANT)
@Op(SimpleBank.Deposit.class)
@Op(SimpleBank.Debit.class)
public class SimpleBank extends AnnotatedSchema {

    @XPR(value = {"Account x", "Int value"}, type = XPR.Type.ARGUMENT)
    @XPR(value = "value > 0", type = XPR.Type.CONDITION)
    @XPR(value = "x.1 >= 0", type = XPR.Type.CONDITION)
    @XPR(value = "x in accounts", type = XPR.Type.CONDITION)
    @XPR(value = "accounts := accounts \\ {x} ∪ {Account(x.0, x.1 + value)}", type = XPR.Type.EFFECT)
    public static class Deposit extends AnnotatedOperation { }

    @XPR(value = {"Account x", "Int value"}, type = XPR.Type.ARGUMENT)
    @XPR(value = "value > 0", type = XPR.Type.CONDITION)
    @XPR(value = "x.1 >= 0", type = XPR.Type.CONDITION)
    @XPR(value = "x in accounts", type = XPR.Type.CONDITION)
    @XPR(value = "accounts := accounts \\ {x} ∪ {Account(x.0, x.1 - value)}", type = XPR.Type.EFFECT)
    public static class Debit extends AnnotatedOperation { }
}