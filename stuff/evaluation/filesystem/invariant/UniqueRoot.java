package evaluation.filesystem.invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.filesystem.filesystem;
import invariant.Invariant;

public class UniqueRoot implements Invariant {

	String name;
	
	public UniqueRoot(String name){
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
		 namess[0] =  ctx.MkSymbol("dir1");

        
        Expr node1=ctx.MkConst("dir1", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")) );     
     //   Expr existNode1= ctx.MkSetMembership(node1,filesystem.FSObject_set);  

        Expr node2=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")) );  
        
		 Expr[] fatherindex =  new Expr[2];
      	 fatherindex[0]=node1;
		 fatherindex[1]=node2;
		 
	     Expr parentTuple=filesystem.Parent.MkDecl().Apply(fatherindex);
	     
	 	 Expr father1=(BoolExpr) ctx.MkSetMembership(parentTuple, filesystem.Parent_set);
	     
		  Expr[] nodeArgs1 =  new Expr[3];
		  nodeArgs1[0]=node1;
		  nodeArgs1[1]=filesystem.type.Consts()[0];
		  nodeArgs1[2]=ctx.MkConst("name", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
	   	 
	  // 	  Expr dir1=filesystem.Node.MkDecl().Apply(nodeArgs1);
	   	  
	   //	  Expr dir1Exist=ctx.MkSetMembership(dir1,filesystem.Node_set);
	   	  
	   	  
		  Expr[] nodeArgs2 =  new Expr[3];
		  nodeArgs2[0]=node1;
		  nodeArgs2[1]=ctx.MkConst("type", filesystem.type);
		  nodeArgs2[2]=ctx.MkConst("name", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
	   	 
	//   	  Expr node=filesystem.Node.MkDecl().Apply(nodeArgs2);
	   	  
	   	//  Expr nodeExist=ctx.MkSetMembership(node,filesystem.Node_set);
	   	  
	   //	  Expr rootEquality=ctx.MkAnd(new BoolExpr [] {(BoolExpr) nodeExist, (BoolExpr) ctx.MkNot(ctx.MkEq(filesystem.root, node1))}); ;
	     
	     
	   //   Expr fatherRoot=ctx.MkAnd(new BoolExpr [] {(BoolExpr) father1, (BoolExpr)ctx.MkNot( ctx.MkEq(node2, filesystem.root))});
		  
		  	 Expr[] finalArgs =  new Expr[2];
	    	 finalArgs[0]=ctx.MkConst("dir1", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
	    	 finalArgs[1]=filesystem.root;
	    		
	    	 Expr tbody= (BoolExpr) ctx.MkApp(filesystem.exists, finalArgs)  ; 
	    	 
	 	     Expr[] arg= new Expr[3];
	 	     arg[0]=filesystem.root;
	 	     arg[1]=ctx.MkConst("dir1", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
	 	     arg[2]=tbody;	
	 		 Expr parentTuple3=filesystem.Reachability.MkDecl().Apply(arg);
	 		 Expr ex= ctx.MkSetMembership(parentTuple3,filesystem.Reachable_set);   

		  
	     
	 //     Expr body=ctx.MkImplies((BoolExpr) ctx.MkSetMembership(node1,filesystem.Dir_set), ctx.MkAnd(new BoolExpr [] 
	   // 		  {(BoolExpr) ctx.MkNot(ctx.MkEq(filesystem.root, node1)), ctx.MkNot((BoolExpr) ex) }));
	           
          BoolExpr mustUniqueee =ctx.MkForall(nodes, namess, ctx.MkAnd(new BoolExpr [] 
	    		  {(BoolExpr)  ctx.MkSetMembership(filesystem.root,filesystem.Dir_set), ctx.MkNot(ctx.MkEq(filesystem.root,node1 )),
        		  ctx.MkNot((BoolExpr) ex) }), 1, null, null,  null, null);
        
          System.out.println("Root Uniqueness: " + mustUniqueee.toString());
        

		 return mustUniqueee;
	
	}

}
