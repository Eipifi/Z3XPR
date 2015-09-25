package example.bank;

import z3fol.xpr.AnnotatedOperation;
import z3fol.xpr.AnnotatedSchema;
import z3fol.xpr.Op;
import z3fol.xpr.XPR;

@XPR({
        // Types and shared variables
        "type AccountID",
        "type Customer",
        "type Account (AccountID, Customer, Int, Int)", // ID, customer, balance, limit
        "Account{} accounts"
})
@XPR(value = {
        // Invariant: each account has a unique ID
        "Forall Account a, Account b: ((a in accounts) & (b in accounts)) => a.0 != b.0",

        // Invariant: balance never lower than limit
        "Forall Account a: a in accounts => a.2 >= a.3"
}, type = XPR.Type.INVARIANT)

@Op(Bank.AddAccount.class)
@Op(Bank.Debit.class)
@Op(Bank.Deposit.class)
@Op(Bank.Transit.class)
public class Bank extends AnnotatedSchema {

    @XPR(value = "Account a", type = XPR.Type.ARGUMENT)
    @XPR(value = "! (Exists Account b: b in accounts & a.0 == b.0)", type = XPR.Type.CONDITION)
    @XPR(value = "accounts := accounts ∪ {a}", type = XPR.Type.EFFECT)
    public static class AddAccount extends AnnotatedOperation { }

    @XPR(value = "Account acc", type = XPR.Type.ARGUMENT)
    @XPR(value = "Int value", type = XPR.Type.ARGUMENT)
    @XPR(value = "accounts := accounts \\ {acc} ∪ {Account(acc.0, acc.1, acc.2 - value, acc.3)}", type = XPR.Type.EFFECT)
    public static class Debit extends AnnotatedOperation { }

    @XPR(value = "Account acc", type = XPR.Type.ARGUMENT)
    @XPR(value = "Int value", type = XPR.Type.ARGUMENT)
    @XPR(value = "accounts := accounts \\ {acc} ∪ {Account(acc.0, acc.1, acc.2 + value, acc.3)}", type = XPR.Type.EFFECT)
    public static class Deposit extends AnnotatedOperation { }

    @XPR(value = "Account a", type = XPR.Type.ARGUMENT)
    @XPR(value = "Account b", type = XPR.Type.ARGUMENT)
    @XPR(value = "Int value", type = XPR.Type.ARGUMENT)
    @XPR(value = "accounts := accounts \\ {a} ∪ {Account(a.0, a.1, a.2 - value, a.3)}", type = XPR.Type.EFFECT)
    @XPR(value = "accounts := accounts \\ {b} ∪ {Account(b.0, b.1, b.2 - value, b.3)}", type = XPR.Type.EFFECT)
    public static class Transit extends AnnotatedOperation { }

}
