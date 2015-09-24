package example.bank;

import z3fol.xpr.XPR;

@XPR({
        // Types and shared variables
        "type AccountID",
        "type Customer",
        "type Account (AccountID, Customer, Int, Int)", // ID, customer, balance, limit
        "Account{} accounts",

        // Invariant: each account has a unique ID
        "forall Account a, Account b: (a in accounts & b in accounts) => a.0 != b.0",

        // Invariant: in each account, the balance is greater than limit
        "forall Account a: a in accounts => a.2 >= a.3"
})
public class Bank {

    @XPR("Account account") // arguments
    @XPR(value = "! (account in accounts)", what = XPR.Type.CONDITION)
    @XPR(value = "accounts := accounts ∪ {account}", what = XPR.Type.EFFECT)
    public void operationAddAccount() {}

    @XPR("Account account") // arguments
    @XPR(value = "account in accounts", what = XPR.Type.CONDITION)
    @XPR(value = "accounts := accounts \\ {account} ∪ {Account(account.0, account.1, account.2 - value, account.3)};", what = XPR.Type.EFFECT)
    public void operationDebit() {}

}
