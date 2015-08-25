package evaluation.bank;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Z3Exception;


public class AccountObject {

	public Expr account;
	public Expr customer;
	public IntExpr limitArrayIndex;
	public IntExpr balance;
	public IntExpr creditLimit;

	
	public  AccountObject(Context ctx) throws Z3Exception {
		
		this.account=ctx.MkConst("account", ctx.MkUninterpretedSort(ctx.MkSymbol("AccountID")));
		this.customer=ctx.MkConst("customer", ctx.MkUninterpretedSort(ctx.MkSymbol("Customer")));
		this.limitArrayIndex=(IntExpr) ctx.MkConst("balanceIndex",ctx.MkIntSort());
		this.balance=(IntExpr) ctx.MkConst("balance",ctx.MkIntSort());;
		this.creditLimit=(IntExpr) ctx.MkConst("creditLimit",ctx.MkIntSort());;
		
	}
	
	public  AccountObject(Context ctx, int i) throws Z3Exception {
		
    	this.account=ctx.MkConst("account"+i, ctx.MkUninterpretedSort(ctx.MkSymbol("AccountID")));
    	this.customer=ctx.MkConst("customer"+i, ctx.MkUninterpretedSort(ctx.MkSymbol("Customer")));
		this.limitArrayIndex=(IntExpr) ctx.MkConst("balanceIndex"+i,ctx.MkIntSort());
		this.balance=(IntExpr) ctx.MkConst("balance"+i,ctx.MkIntSort());;
		this.creditLimit=(IntExpr) ctx.MkConst("creditLimit",ctx.MkIntSort());;
	
		
	}

	public Expr getAccount() {
		return this.account;
	}
	
	public Expr getCustomer() {
		return this.customer;
	}
	
	
	public Expr getIndex() {
		return this.limitArrayIndex;
	}
	
	public Expr getBalance() {
		return this.balance;
	}
	
	public Expr getCreditLimit() {
		return this.creditLimit;
	}
	
	
	public void putBalance(IntExpr creditLimit) {
		 this.balance=creditLimit;
	}
	
}