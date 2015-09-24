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
        "Account{} accounts",

        // Invariant: each account has a unique ID
        "Forall Account a, Account b: ((a in accounts) & (b in accounts)) => a.0 != b.0",

        // Invariant: in each account, the balance is greater than limit
        "Forall Account a: a in accounts => a.2 >= a.3"
})
@Op(Bank.AddAccount.class)
@Op(Bank.Debit.class)
public class Bank extends AnnotatedSchema {

    @XPR(value = "Account acc", type = XPR.Type.ARGUMENT)
    @XPR(value = "!(acc in accounts)", type = XPR.Type.CONDITION)
    @XPR(value = "accounts := accounts ∪ {acc}", type = XPR.Type.EFFECT)
    public static class AddAccount extends AnnotatedOperation { }

    @XPR(value = "Account acc", type = XPR.Type.ARGUMENT)
    @XPR(value = "Int value", type = XPR.Type.ARGUMENT)
    @XPR(value = "acc in accounts", type = XPR.Type.CONDITION)
    @XPR(value = "accounts := accounts \\ {acc} ∪ {Account(acc.0, acc.1, acc.2 - value, acc.3)}", type = XPR.Type.EFFECT)
    public static class Debit extends AnnotatedOperation { }

}
