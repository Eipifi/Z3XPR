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

public class Increment  implements Operation  {

	private String name;
	private IntExpr value;
	int replica;
	counterwithescrow c=new counterwithescrow() ;
	
	public Increment(String name, IntExpr value) {
		this.name=name;
		this.value=value;
	}
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr precondition(Context ctx) throws Z3Exception {	
		return ctx.MkGe(value, ctx.MkInt(0));
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {		
		counterwithescrow.counter=(IntExpr) ctx.MkAdd(new ArithExpr[] { counterwithescrow.counter, value });	
	//	counterwithescrow.localEcrowTable.put(replica,ctx.MkIntConst(ctx.MkSymbol("localescrow")));		
		counterwithescrow.localEcrowTable.put(replica, (IntExpr) ctx.MkAdd(new ArithExpr[] { counterwithescrow.localEcrowTable.get(replica) , value }));
		return counterwithescrow.counter;
	}

	
	@Override
	public void putReplicaIndex(Context ctx, int r) throws Z3Exception {	
		replica=r;
	}
	
	@Override
	public int getReplicaIndex() {
		return replica;
	}

}
