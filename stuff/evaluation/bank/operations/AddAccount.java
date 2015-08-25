package evaluation.bank.operations;

import java.util.ArrayList;
import java.util.List;

import application.Operation;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import evaluation.auction.productObj;
import evaluation.auction.operations.AddBid;
import evaluation.auction.operations.AddProduct;
import evaluation.auction.operations.AddToLot;
import evaluation.auction.operations.CloseAuction;
import evaluation.auction.operations.CreateAuction;
import evaluation.auction.operations.RegisterBuyer;
import evaluation.auction.operations.RegisterSeller;
import evaluation.auction.operations.RemoveAuction;
import evaluation.auction.operations.RemoveBid;
import evaluation.auction.operations.RemoveFromLot;
import evaluation.auction.operations.RemoveProduct;
import evaluation.auction.operations.StartAuction;
import evaluation.auction.operations.UnregisterBuyer;
import evaluation.auction.operations.UnregisterSeller;
import evaluation.bank.AccountObject;
import evaluation.bank.bank;
import evaluation.courseware.courseware;


public class AddAccount  implements Operation  {
	
	private String name;
	private Expr accountId;
	private Expr customer;
	private Expr creditLimit;
	private Expr value;
	private Expr accountIndex;
	
	public AddAccount(String name, Context ctx) {
		this.name=name;
		try {		
			AccountObject a=new AccountObject(ctx);
			this.accountId=a.getAccount();
			this.customer=a.getCustomer();
			this.creditLimit=a.getCreditLimit();
			this.accountIndex=a.getIndex();
			this.value=a.getBalance();

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
		
		 return ctx.MkTrue();
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		
		bank.AccountID_set= ctx.MkSetAdd(bank.AccountID_set, accountId);
		
		value=(IntExpr) ctx.MkITE(ctx.MkGe((ArithExpr) value, (ArithExpr) this.creditLimit), value,
				ctx.MkAdd(new ArithExpr[] {ctx.MkAdd(new ArithExpr[] {(ArithExpr) value, ctx.MkSub(new ArithExpr[] {(ArithExpr) this.creditLimit, (ArithExpr) value})} )}));
		
		bank.capacityArray=ctx.MkStore(bank.capacityArray, accountIndex, value);
		
        Expr[] argAccount = new Expr[3];
        argAccount[0]=accountId;
        argAccount[1]=customer;
        argAccount[2]=creditLimit;
		
        Expr account =bank.Account.MkDecl().Apply(argAccount);
        bank.Account_set = ctx.MkSetAdd(bank.Account_set,account );
	    return  bank.Account_set ;
	}

	@Override
	public Expr[] getArgs(String name) {
		Expr args []={accountIndex,value};
		return args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		return ctx.MkTrue();
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
		Expr conditions []={ctx.MkTrue(), ctx.MkTrue() ,ctx.MkTrue(), ctx.MkTrue(), ctx.MkTrue()};
		return conditions;
	}

	
	
	
}
