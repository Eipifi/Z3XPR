package example.bank;

import z3fol.model.Def;
import z3fol.model.Schema;

@Def("type AccountID")
@Def("type Customer")
@Def("type Account (AccountID, Customer, Int, Int)")
@Def("declare Set<Account> accounts")
public class Bank extends Schema {



}
