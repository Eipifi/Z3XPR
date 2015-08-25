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

public class DenoteEscrow  implements Operation {

	private String name;
	private IntExpr value;
	int replica1;
	int replica2;
	counterwithescrow c=new counterwithescrow() ;
	
	public DenoteEscrow(String name, IntExpr value) {
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
	//	counterwithescrow.localEcrowTable.put(replica1,ctx.MkIntConst(ctx.MkSymbol("localescrow1")));		
		BoolExpr e2=ctx.MkGe(counterwithescrow.localEcrowTable.get(replica1), value);
		return ctx.MkAnd(new BoolExpr[] {  e1, e2});
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		  
		counterwithescrow.localEcrowTable.put(replica1,(IntExpr) ctx.MkSub(new ArithExpr[] {counterwithescrow.localEcrowTable.get(replica1) , value }));		
		counterwithescrow.localEcrowTable.put(replica2, (IntExpr) ctx.MkAdd(new ArithExpr[] { counterwithescrow.localEcrowTable.get(replica2) , value }));
		return counterwithescrow.localEcrowTable.get(replica1);
	}

	
	@Override
	public void putReplicaIndex(Context ctx ,int replica) throws Z3Exception {	
		replica1=replica;
		replica2=3;
	}
	

	@Override
	public int getReplicaIndex() {
		return replica1;
	}

}

