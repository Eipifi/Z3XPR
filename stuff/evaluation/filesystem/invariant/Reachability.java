
package evaluation.filesystem.invariant;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.IntSort;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Version;
import com.microsoft.z3.Z3Exception;

import evaluation.filesystem.filesystem;
import evaluation.filesystem.filesystemmodel;
import invariant.Invariant;

public class Reachability implements Invariant {

	private String name; 
	
	public Reachability(String string, Context ctx) {
		
	}

	@Override
	public String getName() {
		return name;
	}

	public Expr reachable(Context ctx) throws Z3Exception{
		

		
		 Expr nodeID=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject")));
		
    	 Expr[] nodeArgs =  new Expr[2];
    	 nodeArgs[0]=nodeID;
    	 nodeArgs[1]=ctx.MkConst("name", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));

		 Expr root=filesystemmodel.rootNode;
		 
		Expr[] fatherindex =  new Expr[2];
    	fatherindex[0]=root;
		fatherindex[1]=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject")));

	    Expr parentTuple=filesystemmodel.Parent.MkDecl().Apply(fatherindex);
	     
	  
         Sort[] indexbase = new Sort[1];
         indexbase[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject"));
         
		 Symbol[] indexBNames = new Symbol[1];
		 indexBNames[0] =  ctx.MkSymbol("node1");
				 
		// Expr basee = ctx.MkForall(indexbase, indexBNames, baseBody, 1, null, null,null, null);
		 
		// System.out.println("father"+basee);	 
		 
		 Sort[] nodesr =  new Sort[1];
		    
    	 nodesr[0]	= ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject"));
  
    		 
    	 Symbol[] nnamesr = new Symbol[1];
    //	 nnamesr[0] = ctx.MkSymbol("i");
    	 nnamesr[0]=ctx.MkSymbol("node1");


     		   	 	  
     	  	 
    	 Sort[] nodesw =  new Sort[1];
    	   	    
   	     nodesw[0] = ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject"));
   		 
   	     Symbol[] nnamesw = new Symbol[1];
   		 nnamesw[0] =  ctx.MkSymbol("node3");
   		 
     	 
     	 Expr[] father23 =  new Expr[2];
     	 father23[0]=ctx.MkConst("node3", ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject")));
        father23[1]=ctx.MkConst("name3", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
     	 
     	Expr parentTuple23=filesystemmodel.DirNode.MkDecl().Apply(father23);
     	 
     		  
     	 Expr[] finalArgs =  new Expr[2];
     	 finalArgs[0]=root;
     	 finalArgs[1]=father23[0];
     		
     	 Expr tbody= ctx.MkApp(filesystemmodel.exists, finalArgs)  ; 
     	 
     	 
  	    Expr[] arg= new Expr[2];
  	    arg[0]=father23[0];
  	    arg[1]=tbody;	
  		Expr parentTuple3=filesystemmodel.Reachability.MkDecl().Apply(arg);
 	 
     	Expr rr=(BoolExpr) ctx.MkSetMembership(parentTuple3, filesystemmodel.Reachable_set);
 
     	 Expr[] father2 =  new Expr[2];
     	 father2[0]=parentTuple23;
     	 father2[1]=nodeID;

     	 Expr parentTuple2=filesystemmodel.Parent.MkDecl().Apply(father2);
     		  
   		 Expr r=ctx.MkAnd(new BoolExpr[] { (BoolExpr) rr,(BoolExpr) ctx.MkSetMembership(parentTuple2, filesystemmodel.Parent_set)} );

    	 Expr based= ctx.MkExists(nodesw, nnamesw, r, 1, null, null,null, null); 
   	 
    	 
    	 Expr main=ctx.MkOr(new BoolExpr[]{(BoolExpr) ctx.MkSetMembership(parentTuple, filesystemmodel.Parent_set),
    			 (BoolExpr) based 	   });
    		
    	 Expr expr=ctx.MkImplies( (BoolExpr) ctx.MkSetMembership(nodeArgs[0], filesystemmodel.FsObject_set), (BoolExpr)main);
    
    	 Expr ancestor = ctx.MkForall(nodesr, nnamesr, expr, 1, null, null,null, null);

		 System.out.println("reachability invariant:"+ancestor); 

	      
	     return ancestor;
		 
		
	}
	


	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		// TODO Auto-generated method stub
		return (BoolExpr) reachable(ctx);
	}

}
