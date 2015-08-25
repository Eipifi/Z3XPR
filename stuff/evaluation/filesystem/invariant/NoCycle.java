package evaluation.filesystem.invariant;


import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import evaluation.filesystem.filesystem;
import evaluation.filesystem.filesystemmodel;
import invariant.Invariant;

public class NoCycle implements Invariant  {

	private String name; 
	
	public NoCycle(String name) {
		this.name=name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {

			
		Expr nodeID=ctx.MkConst("node", ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject")));
		Expr dirId1=ctx.MkConst(ctx.MkSymbol("node1"), ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject")));
		Expr dirId2=ctx.MkConst(ctx.MkSymbol("node2"), ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject")));
		
		
		
		Expr[] nodeindex2 =  new Expr[2];
		nodeindex2[0]=dirId1;
		nodeindex2[1]=ctx.MkConst("name3", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));;

		Expr node1=filesystemmodel.DirNode.MkDecl().Apply(nodeindex2);
		
			
		Expr[] fatherindex =  new Expr[2];
	    fatherindex[0]=node1;
		fatherindex[1]=nodeID;

		Expr parentTuple=filesystemmodel.Parent.MkDecl().Apply(fatherindex);
		
		Expr[] nodeindex22 =  new Expr[2];
		nodeindex22[0]=dirId2;
		nodeindex22[1]=ctx.MkConst("name5", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));;

		Expr node2=filesystemmodel.DirNode.MkDecl().Apply(nodeindex22);
		
		
		Expr[] fatherindex2 =  new Expr[2];
	    fatherindex2[0]=node2;
		fatherindex2[1]=nodeID;

		Expr parentTuple2=filesystemmodel.Parent.MkDecl().Apply(fatherindex2);
		     		 
			 
	    Sort[] nodesr =  new Sort[3];			    
	    nodesr[0] = ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject"));
	    nodesr[1] = ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject"));
	    nodesr[2] = ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject"));
	      		 
	     Symbol[] nnamesr = new Symbol[3];
	     nnamesr[0]=ctx.MkSymbol("node");  
	     nnamesr[1]=ctx.MkSymbol("node5");  
	     nnamesr[2]=ctx.MkSymbol("node3");  
	    	
	     Expr parentUniqness=ctx.MkAnd(new BoolExpr []{(BoolExpr) ctx.MkSetMembership(parentTuple, filesystemmodel.Parent_set),
	    		 (BoolExpr) ctx.MkSetMembership(parentTuple2, filesystemmodel.Parent_set) });
	     
	     Expr equality=ctx.MkEq(dirId1, dirId2);
     
	      Expr dire= ctx.MkAnd(new BoolExpr [] {  (BoolExpr) parentUniqness});
	     
	     Expr p= ctx.MkImplies( (BoolExpr) dire, (BoolExpr) equality);
	     Expr ancestor = ctx.MkForall(nodesr, nnamesr, p, 1, null, null,null, null);

		 System.out.println("cycle invariant:"+ancestor); 
     
		 return (BoolExpr) ancestor;
		 
	}

}
