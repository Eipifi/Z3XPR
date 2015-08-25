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


public class UniqeName implements Invariant {
	
	String name;
	
	public UniqeName(String name){
		this.name=name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {

		 Sort[] nodes = new Sort[2];
		 nodes[0] = ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject"));
		 nodes[1] = ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject"));
		 //setting names
		 Symbol[] namess = new Symbol[2];
		 namess[0] =  ctx.MkSymbol("node1");
		 namess[1] =  ctx.MkSymbol("node2");

         
         Expr node1=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject")));
         Expr node2=ctx.MkConst("node2", ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject")));
         
         Expr name2=ctx.MkConst("name2", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")) );
         Expr name1=ctx.MkConst("name1", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")) );
         
         
         Expr node3=ctx.MkConst("node3", ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject")) );
         
        
         
         
     	 Expr[] finalArgs =  new Expr[2];
     	 finalArgs[0]=node1;
     
     	 finalArgs[1]=name1;
     		
     	 Expr Node11= filesystemmodel.DirNode.MkDecl().Apply(finalArgs);
     	 
     	 Expr existNode11= ctx.MkSetMembership(Node11,filesystemmodel.DirNode_set);

     	 
     	 Expr[] finalArgs2 =  new Expr[2];
     	 finalArgs2[0]=node2;

     	 finalArgs2[1]=name2;
     		
     	 Expr Node22= filesystemmodel.DirNode.MkDecl().Apply(finalArgs2);
     	 
     	Expr existNode22= ctx.MkSetMembership(Node22,filesystemmodel.DirNode_set);
     	
    	 Expr[] finalArgs3 =  new Expr[2];
    	 finalArgs3[0]=node3;
    
    	 finalArgs3[1]=ctx.MkConst("name3", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")) );;
    		
    	 Expr Node3= filesystemmodel.DirNode.MkDecl().Apply(finalArgs3);
         
 		 Expr[] fatherindex =  new Expr[2];
    	 fatherindex[0]=Node3;
		 fatherindex[1]=node1;
		 
	     Expr parentTuple=filesystemmodel.Parent.MkDecl().Apply(fatherindex);
	     
	 	 Expr father1=(BoolExpr) ctx.MkSetMembership(parentTuple, filesystemmodel.Parent_set);
	     
 		 Expr[] fatherindex2 =  new Expr[2];
    	 fatherindex2[0]=Node3;
		 fatherindex2[1]=node2;
		 
	     Expr parentTuple2=filesystemmodel.Parent.MkDecl().Apply(fatherindex2);
	     
	     Expr father2=(BoolExpr) ctx.MkSetMembership(parentTuple2, filesystemmodel.Parent_set);
	     
	     Expr eq=ctx.MkEq(name1, name2);
	     
	     Expr same=ctx.MkAnd(new BoolExpr [] {(BoolExpr) existNode11, (BoolExpr) existNode22, (BoolExpr) eq, (BoolExpr) father2, (BoolExpr) father1
	    			 });
	      
	     
	     Expr rt=ctx.MkImplies((BoolExpr) same, ctx.MkEq(node1, node2));
	     
	     

	     
		 Sort[] nodes2 = new Sort[1];
		 nodes2[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject"));

		 //setting names
		 Symbol[] namess2 = new Symbol[1];
		 namess2[0] =  ctx.MkSymbol("node2");


         
         BoolExpr mustUniqueee2 = ctx.MkForall(nodes, namess, rt, 1, null, null,
         null, null);
	 
         
         System.out.println("Quantifier Uniqueness: " + mustUniqueee2.toString());
         
         
		 return mustUniqueee2;
	}

}