
package evaluation.filesystem.invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.filesystem.filesystem;
import invariant.Invariant;

public class Parentship implements Invariant {

	String name;
	
	public Parentship(String name){
		this.name=name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}


	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		
		 Sort[] nodes = new Sort[1];
		 nodes[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
		 //setting names
		 Symbol[] namess = new Symbol[1];
		 namess[0] =  ctx.MkSymbol("node1");

        
        Expr node1=ctx.MkConst("node5", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")) );     
        Expr node2=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")) ); 

        Expr existNode1= ctx.MkSetMembership(node2,filesystem.FSObject_set);  
     
		 Expr[] fatherindex =  new Expr[2];
      	 fatherindex[0]=node1;
		 fatherindex[1]=node2;
		 
	     Expr parentTuple=filesystem.Parent.MkDecl().Apply(fatherindex);
	     
	 	 Expr father1=(BoolExpr) ctx.MkSetMembership(parentTuple, filesystem.Parent_set);

	 	 Expr body=ctx.MkImplies((BoolExpr )father1, (BoolExpr )existNode1);
	   	  
		 
          BoolExpr mustUniqueee =ctx.MkForall(nodes, namess, body, 1, null, null,  null, null);
        
          System.out.println("Correct Parent relation: " + mustUniqueee.toString());
        
        
		 return mustUniqueee;
	
	}

}
