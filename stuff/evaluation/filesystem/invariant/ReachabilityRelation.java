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

import evaluation.auction.auctionapp;
import evaluation.courseware.courseware;
import evaluation.filesystem.filesystem;
import invariant.Invariant;

public class ReachabilityRelation implements Invariant {

	private String name;
	
	public ReachabilityRelation(String string, Context ctx) {
		
	}

	public ReachabilityRelation(String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return name;
	}

	public Expr reachable(Context ctx) throws Z3Exception{
		
		
		 Expr nodeID=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
		 Expr nodeID2=ctx.MkConst("dir3", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
			
		
    	 Expr[] nodeArgs =  new Expr[3];
    	 nodeArgs[0]=nodeID;
    	 nodeArgs[1]=ctx.MkConst("type", filesystem.type);
    	 nodeArgs[2]=ctx.MkConst("name", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));

		Expr[] fatherindex =  new Expr[2];
    	fatherindex[0]=nodeID2;
		fatherindex[1]=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));


	    Expr parentTuple=filesystem.Parent.MkDecl().Apply(fatherindex);

	  
         Sort[] indexbase = new Sort[1];
         indexbase[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));
         
		 Symbol[] indexBNames = new Symbol[1];
		 indexBNames[0] =  ctx.MkSymbol("dir");
 
		 
		 Sort[] nodesr =  new Sort[2];
		    
    	 nodesr[0]	=	 ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));
    	 nodesr[1]	=	 ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));
  
    		 
    	 Symbol[] nnamesr = new Symbol[2];

    	 nnamesr[0]=ctx.MkSymbol("node1");
    	 nnamesr[1]=ctx.MkSymbol("node3");

     	  	 
    	 Sort[] nodesw =  new Sort[1];
    	   	    
   	     nodesw[0] = ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));
   		 
   	     Symbol[] nnamesw = new Symbol[1];
   		 nnamesw[0] =  ctx.MkSymbol("dir3");
   		 
     	 
     	 Expr[] father23 =  new Expr[3];
     	 father23[0]=ctx.MkConst("dir3", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
     	 father23[1]=filesystem.type.Consts()[0]; 
      	father23[2]=ctx.MkConst("name3", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
     	 
     	 Expr parentTuple23=filesystem.Node.MkDecl().Apply(father23);
     	 
     		  
     	 Expr[] finalArgs =  new Expr[2];
     	 finalArgs[0]=nodeID2;
     	 finalArgs[1]=ctx.MkConst("dir4", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
     		
     	 Expr tbody= ctx.MkApp(filesystem.exists, finalArgs)  ; 
     	 
     	 
  	    Expr[] arg= new Expr[3];
  	    arg[0]=ctx.MkConst("dir4", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
  	    arg[1]=nodeID2;
  	    arg[2]=tbody;	
  		Expr parentTuple3=filesystem.Reachability.MkDecl().Apply(arg);
  
     	 
     	Expr rr=(BoolExpr) ctx.MkSetMembership(parentTuple3, filesystem.Reachable_set);
 
     	 Expr[] father2 =  new Expr[2];
     	 father2[0]=ctx.MkConst("dir4", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
     	 father2[1]=ctx.MkConst("dir3", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
     		

     	 Expr parentTuple2=filesystem.Parent.MkDecl().Apply(father2);


     		  
   		 Expr r=ctx.MkAnd(new BoolExpr[] { (BoolExpr) rr,(BoolExpr) ctx.MkSetMembership(parentTuple2, filesystem.Parent_set)} );

    	 Expr based= ctx.MkExists(nodesw, nnamesw, r, 1, null, null,null, null); 
   	 	    
    	 
    	Expr main=ctx.MkOr(new BoolExpr[]{ (BoolExpr) ctx.MkSetMembership(parentTuple, filesystem.Parent_set),
    			 (BoolExpr) based 	   });
   	
    	
		
		Expr[] finalArgs1 =  new Expr[2];
		finalArgs1[0]=nodeID2;
		finalArgs1[1]=nodeID;
   		
		Expr tbody1= (BoolExpr) ctx.MkApp(filesystem.exists, finalArgs1)  ; 
		
	     Expr[] arg1= new Expr[3];
	     arg1[0]=nodeID;
	     arg1[1]=nodeID2;
	     arg1[2]=tbody1;	
		 Expr parentTuple31=filesystem.Reachability.MkDecl().Apply(arg1);
		 Expr ee= ctx.MkSetMembership(parentTuple31, filesystem.Reachable_set);   
    	
    		
    	 Expr expr=ctx.MkImplies( (BoolExpr) main, (BoolExpr)ee);

    	 Expr ancestor = ctx.MkForall(nodesr, nnamesr, expr, 1, null, null,null, null);
    	
		 System.out.println("reachability relation:"+ancestor); 

 	       
	     return ancestor;
		 
		
	}
	


	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {

		return (BoolExpr) reachable(ctx);
	}


}
