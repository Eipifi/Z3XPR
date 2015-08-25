package escrow.operations;

import java.util.LinkedList;
import java.util.Random;

import token.TokenObj;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Z3Exception;

import escrow.counterwithescrow;
import application.Operation;

public class Decrement  implements Operation {

	private String name;
	private IntExpr value;
	int  replica;
	
	counterwithescrow c=new counterwithescrow() ;
	
	public Decrement(String name, IntExpr value) {
		this.name=name;
		this.value=value;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr precondition(Context ctx) throws Z3Exception {
		BoolExpr e1=ctx.MkGe(value, ctx.MkInt(0));
		
	//	counterwithescrow.localEcrow.put(site,(IntExpr) ctx.MkConst("localescrow", ctx.IntSort()));		 
		BoolExpr e2=ctx.MkGe(counterwithescrow.localEcrowTable.get(replica) , value);
		//System.out.println("predddf"+counterwithescrow.localEcrow.get(site) );
		return ctx.MkAnd(new BoolExpr[] {  e1,e2});
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		
		System.out.println("sitepost"+replica);
		counterwithescrow.counter=(IntExpr) ctx.MkSub(new ArithExpr[] {  counterwithescrow.counter, value });
		//site=ctx.MkIntConst(ctx.MkSymbol("r1"));
	//	counterwithescrow.localEcrow.put(site,(IntExpr) ctx.MkConst("localescrow", ctx.IntSort()));		
		System.out.println("predddf"+counterwithescrow.localEcrow);
		
		counterwithescrow.localEcrowTable.put(replica, (IntExpr) ctx.MkSub(new ArithExpr[] { counterwithescrow.localEcrowTable.get(replica) , value }));
		System.out.println("predddf"+counterwithescrow.localEcrow.get(replica) );
		return counterwithescrow.localEcrow.get(replica);
	}


	@Override
	public void putReplicaIndex(Context ctx,int r) throws Z3Exception {		
		replica=r;
	}
	
	
	
	@Override
	public int getReplicaIndex() {
		return replica;
	}

}
