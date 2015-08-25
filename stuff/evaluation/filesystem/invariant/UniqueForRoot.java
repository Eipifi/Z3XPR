package evaluation.filesystem.invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.filesystem.filesystem;
import evaluation.filesystem.filesystemmodel;
import invariant.Invariant;

public class UniqueForRoot implements Invariant {

	String name;
	
	public UniqueForRoot(String name){
		this.name=name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}


	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		
		 Sort[] nodes = new Sort[1];
		 nodes[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));
		 //setting names
		 Symbol[] namess = new Symbol[1];
		 namess[0] =  ctx.MkSymbol("node");

        
        Expr node1=ctx.MkConst("node", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")) );     
             
              
          BoolExpr mustUniqueee =ctx.MkForall(nodes, namess, (BoolExpr) ctx.MkNot(ctx.MkEq(filesystemmodel.root, node1)), 1, null, null,  null, null);
        
          System.out.println("Root Uniqueness: " + mustUniqueee.toString());
        
        
		 return mustUniqueee;
	
	}

}
