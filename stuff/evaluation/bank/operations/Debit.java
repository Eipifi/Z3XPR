package evaluation.bank.operations;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import evaluation.bank.AccountObject;
import evaluation.bank.bank;
import evaluation.courseware.courseObject;
import evaluation.courseware.courseware;
import application.Operation;

public class Debit implements Operation {
		
	private String name;
	private Expr account;
	private Expr value;
	private IntExpr limitIndex;
	private Expr creditLimit;
	private Expr customer;

	
	public Debit(String name, Context ctx) {
		this.name=name;
		try {
			AccountObject a=new AccountObject(ctx);
			this.account=a.getAccount();
			this.limitIndex=(IntExpr)a.getIndex();
			this.creditLimit= (IntExpr) a.getCreditLimit();		
			this.value=ctx.MkConst("value", ctx.MkIntSort());
			this.customer=a.getCustomer();
			

		} catch (Z3Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public BoolExpr precondition(Context ctx) throws Z3Exception {

		Expr newBalance= ctx.MkSub(new ArithExpr []{(ArithExpr) ctx.MkSelect(bank.capacityArray, limitIndex), (ArithExpr) value });
	
		Expr precondition=ctx.MkGe((ArithExpr)newBalance,(ArithExpr) creditLimit);
		
		return (BoolExpr) precondition;
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {

	    Expr balance= ctx.MkSelect(bank.capacityArray, limitIndex);	
	 //   balance=(IntExpr) ctx.MkSub(new ArithExpr[] {(ArithExpr) balance,(ArithExpr) value});
		Expr[] argAccount = new Expr[3];
		argAccount[0]=account;
		argAccount[1]=customer;
		argAccount[2]=balance;

	    Expr accountTuple =bank.Account.MkDecl().Apply(argAccount);
	    bank.Account_set = ctx.MkSetDel(bank.Account_set, accountTuple );	
	    
	    balance=ctx.MkITE( ctx.MkGe((ArithExpr) value, ctx.MkInt(0)), (IntExpr) ctx.MkSub(new ArithExpr[] {(ArithExpr) balance,(ArithExpr) value}), balance);
		bank.capacityArray=ctx.MkStore(bank.capacityArray, limitIndex, balance);
	
		Expr[] argAccountNew = new Expr[3];
		argAccountNew[0]=account;
		argAccountNew[1]=customer;
		argAccountNew[2]=balance;

	    Expr accountTupleNew =bank.Account.MkDecl().Apply(argAccountNew);
	    bank.Account_set = ctx.MkSetAdd(bank.Account_set, accountTupleNew );		
	     
	     return bank.Account_set;
	}

	@Override
	public Expr[] getArgs(String name) {
		Expr args [] ={limitIndex};
		return args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {

		return null;
	}

	@Override
	public List<Operation> concurrentOps(Context ctx) {
			
		List<Operation> op=new ArrayList<Operation>();
		Operation o1=new Deposit("Deposit",ctx);
		Operation o2=new Debit("Debit",ctx);
		Operation o3=new Transit("Transit",ctx);
		Operation o4=new AddAccount("AddAccount",ctx);
		Operation o5=new Interest("Interest",ctx);
	
		op.add(o1);
		op.add(o2);
		op.add(o3);
		op.add(o4);
		op.add(o5);
		
		return op;

	}

	@Override
	public void putReplicaIndex(Context ctx, int replica) throws Z3Exception {

	}

	@Override
	public int getReplicaIndex() {

		return 0;
	}

	@Override
	public Expr[] getConditions(Context ctx, Operation op) throws Z3Exception {
		Expr conditions [] = {ctx.MkTrue(),ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.limitIndex)), ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.limitIndex)),
				ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.limitIndex)), ctx.MkTrue() };
		return conditions;
	}
	// ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.limitIndex))

}
