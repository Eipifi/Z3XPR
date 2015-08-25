package escrow;

import invariant.Invariant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.ArrayExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Constructor;
import com.microsoft.z3.Context;
import com.microsoft.z3.DatatypeSort;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.SetSort;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Z3Exception;

import escrow.invariants.BoundedInv;
import escrow.operations.AcquireEscrow;
import escrow.operations.Decrement;
import escrow.operations.DenoteEscrow;
import escrow.operations.Increment;
import analyzer.Pair;
import application.Application;
import application.Operation;

public class counterwithescrow  extends Application {

	public static IntExpr counter;
	public static IntExpr globalEscrow;	
	public List<Operation> op=new ArrayList<Operation>();
	static List<Invariant> inv=new ArrayList<Invariant>();
	public static IntExpr value;	
	public static Map<IntExpr,IntExpr> localEcrow= new HashMap<IntExpr,IntExpr>();

	public static Map<Integer,IntExpr> localEcrowTable= new HashMap<Integer,IntExpr>();
	
    /**
     * The constructor initializes the application with adding operations and invariants
     */
    public  counterwithescrow() {
	    		 
    }
 	
	@Override
	public List<Operation> loadOperations(Context ctx) throws Z3Exception {
		Operation o1=new AcquireEscrow("AcquireEscrow",value);
		Operation o2=new DenoteEscrow("DenoteEscrow",value);
		Operation o3=new Increment("Increment", value);
		Operation o4=new Decrement("Decrement",value);
		op.add(o1);
		op.add(o2);
		op.add(o3);
		op.add(o4);		
		return op;
	}

	@Override
	public List<Invariant> loadInvariants(Context ctx) throws Z3Exception {
		Invariant inv1=new BoundedInv("bounded");
        inv.add(inv1);
        return inv;
	}

	@Override
	public void initializeState(Context ctx) throws Z3Exception {
	    counter=(IntExpr) ctx.MkConst("counter", ctx.IntSort());
	    globalEscrow=(IntExpr) ctx.MkConst("globalEscrow", ctx.IntSort());
	    value=(IntExpr) ctx.MkConst("value", ctx.IntSort());
	    
	    localEcrowTable.put(1, (IntExpr) ctx.MkConst("localescrow1", ctx.IntSort()));
	    localEcrowTable.put(2, (IntExpr) ctx.MkConst("localescrow2", ctx.IntSort()));
	    localEcrowTable.put(3, (IntExpr) ctx.MkConst("localescrow3", ctx.IntSort()));
	    
	}


}
