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

public class NoCycleInv implements Invariant  {

	private String name; 
	
	public NoCycleInv(String name) {
		this.name=name;
	}

	public NoCycleInv(String string, Context ctx) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {

			
		Expr nodeID=ctx.MkConst("node", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
		Expr dirId1=ctx.MkConst("dir1", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
		Expr dirId2=ctx.MkConst("dir3", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
			
	    Expr[] nodeArgs =  new Expr[3];
	    nodeArgs[0]=nodeID;
	    nodeArgs[1]=ctx.MkConst("type", filesystem.type);
	    nodeArgs[2]=ctx.MkConst("name", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
	    	 
	    Expr node=filesystem.Node.MkDecl().Apply(nodeArgs);
			
		Expr root=filesystem.root;
			 

		Expr[] fatherindex =  new Expr[2];
	    fatherindex[0]=dirId1;
		fatherindex[1]=nodeID;

		Expr parentTuple=filesystem.Parent.MkDecl().Apply(fatherindex);
		
		Expr[] fatherindex2 =  new Expr[2];
	    fatherindex2[0]=dirId2;
		fatherindex2[1]=nodeID;

		Expr parentTuple2=filesystem.Parent.MkDecl().Apply(fatherindex2);
		     		 
			 
	    Sort[] nodesr =  new Sort[1];			    
	    nodesr[0] = ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
	  //  nodesr[1] = ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
	  //  nodesr[2] = ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
	      		 
	     Symbol[] nnamesr = new Symbol[1];
	     nnamesr[0]=ctx.MkSymbol("node");  
	  //   nnamesr[1]=ctx.MkSymbol("node5");  
	  //   nnamesr[2]=ctx.MkSymbol("node3");  
	    	
	     Expr parentUniqness=ctx.MkAnd(new BoolExpr []{(BoolExpr) ctx.MkSetMembership(parentTuple, filesystem.Parent_set),
	    		 (BoolExpr) ctx.MkSetMembership(parentTuple2, filesystem.Parent_set) });
	     
	     Expr equality=ctx.MkEq(dirId1, dirId2);
	     
	   	 	
		  Expr[] nodeArgs2 =  new Expr[3];
		  nodeArgs2[0]=dirId2;
		  nodeArgs2[1]=filesystem.type.Consts()[0];
		  nodeArgs2[2]=ctx.MkConst("name3", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
	   	 
	 //  	  Expr dir2=filesystem.Node.MkDecl().Apply(nodeArgs2);
	   	  
	 //  	 Expr dir2Exist=ctx.MkSetMembership(dir2,filesystem.Node_set);
	   	  
		  Expr[] nodeArgs1 =  new Expr[3];
		  nodeArgs1[0]=dirId1;
		  nodeArgs1[1]=filesystem.type.Consts()[0];
		  nodeArgs1[2]=ctx.MkConst("name3", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
		  
	   	 
	   	//  Expr dir1=filesystem.Node.MkDecl().Apply(nodeArgs1);
	   	  
	  // 	 Expr dir1Exist=ctx.MkSetMembership(dir2,filesystem.Node_set);
	   	 
	   //  Expr dirExist=ctx.MkSetMembership(nodeID,filesystem.Dir_set);
	     
	      Expr dire= ctx.MkAnd(new BoolExpr [] {  (BoolExpr) parentUniqness });
	     
	     Expr p= ctx.MkImplies( (BoolExpr) dire, (BoolExpr) equality);
	     Expr ancestor = ctx.MkForall(nodesr, nnamesr, p, 1, null, null,null, null);
	     
	     
     	 Expr[] finalArgs =  new Expr[2];
     	 finalArgs[0]=dirId2;
     	 finalArgs[1]=dirId1;
     		
     	 Expr tbody= ctx.MkApp(filesystem.exists, finalArgs)  ; 
     	 
     	 
  	    Expr[] arg= new Expr[3];
  	    arg[0]=dirId1;
  	    arg[1]=dirId2;
  	    arg[2]=tbody;	
  		Expr parentTuple3=filesystem.Reachability.MkDecl().Apply(arg);
  
     	 
     	Expr rr=(BoolExpr) ctx.MkSetMembership(parentTuple3, filesystem.Reachable_set);
     	
     	
    	 Expr[] finalArgs2 =  new Expr[2];
    	 finalArgs2[0]=dirId1;
    	 finalArgs2[1]=dirId2;
    		
    	 Expr tbody2= ctx.MkApp(filesystem.exists, finalArgs2)  ; 
    	 
    	 
 	    Expr[] arg2= new Expr[3];
 	    arg2[0]=dirId2;
 	    arg2[1]=dirId1;
 	    arg2[2]=tbody2;	
 		Expr parentTuple32=filesystem.Reachability.MkDecl().Apply(arg2);
 
    	 
    	Expr rr1=(BoolExpr) ctx.MkSetMembership(parentTuple32, filesystem.Reachable_set);
    	
    	
    	Expr f=ctx.MkImplies(ctx.MkAnd(new BoolExpr [] { (BoolExpr) rr,  (BoolExpr) rr1}), (BoolExpr) ctx.MkEq(dirId2, dirId1));
    	
    	
		 Sort[] nodes = new Sort[2];
		 nodes[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));
		 nodes[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));
	//	 nodes[2] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
		 //setting names
		 Symbol[] namess = new Symbol[2];
		 namess[0] =  ctx.MkSymbol("dir1");
		 namess[1] =  ctx.MkSymbol("dir3");   
	//	 namess[2] =  ctx.MkSymbol("node1");   
              

      	 Sort[] nodes2 = new Sort[2];
		 nodes2[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));
		 nodes2[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));
		 //setting names
		 Symbol[] namess2 = new Symbol[2];
		 namess2[0] =  ctx.MkSymbol("dir1");
		 namess2[1] =  ctx.MkSymbol("FSObject");  
		 
		 
    	 Expr[] finalArgs22 =  new Expr[2];
    	 finalArgs22[0]=dirId1;
    	 finalArgs22[1]=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
    		
 		Expr parentTuple322=filesystem.Parent.MkDecl().Apply(finalArgs22); 
    	 
    	 
    	 Expr er=ctx.MkSetMembership(parentTuple322, filesystem.Parent_set);
    	 
    	 
  	    Expr[] arg23= new Expr[3];
  	    arg23[0]=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
  	    arg23[1]=dirId1;
  	    arg23[2]=tbody2;	
  		Expr parentTuple323=filesystem.Reachability.MkDecl().Apply(arg23);
  
     	 
     	Expr rr3=(BoolExpr) ctx.MkSetMembership(parentTuple323, filesystem.Reachable_set);
    	 
         Expr f3=ctx.MkImplies( (BoolExpr)er, (BoolExpr)ctx.MkNot((BoolExpr) rr3))   ;
         
         Expr inv= ctx.MkAnd(new BoolExpr[] {(BoolExpr) f3,(BoolExpr) f });
         
         BoolExpr mustUniqueee =ctx.MkForall(nodes, namess, f, 1, null, null,  null, null);
  
    
		 System.out.println("cycle invariant:"+mustUniqueee); 
     
		 return (BoolExpr) mustUniqueee;
		 
	}

}
