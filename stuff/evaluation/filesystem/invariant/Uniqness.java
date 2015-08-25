package evaluation.filesystem.invariant;


import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.filesystem.filesystem;
import invariant.Invariant;


public class Uniqness implements Invariant {
	
	String name;
	
	public Uniqness(String name){
		this.name=name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {

		 Sort[] nodes = new Sort[2];
		 nodes[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
		 nodes[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
		 //setting names
		 Symbol[] namess = new Symbol[2];
		 namess[0] =  ctx.MkSymbol("node1");
		 namess[1] =  ctx.MkSymbol("node2");

         
         Expr node1=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")) );
         Expr node2=ctx.MkConst("node2", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")) );
         
         Expr name2=ctx.MkConst("name2", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")) );
         Expr name1=ctx.MkConst("name1", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")) );
         
         
         Expr node3=ctx.MkConst("dir3", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")) );
         
         
         Expr existNode1= ctx.MkSetMembership(node1,filesystem.FSObject_set);  
         Expr existNode2= ctx.MkSetMembership(node2,filesystem.FSObject_set);
         
         
     	 Expr[] finalArgs =  new Expr[3];
     	 finalArgs[0]=node1;
     	 finalArgs[1]=ctx.MkConst("type", filesystem.type);
     	 finalArgs[2]=name1;
     		
     	 Expr Node11= filesystem.Node.MkDecl().Apply(finalArgs);
     	 
     	 Expr existNode11= ctx.MkSetMembership(Node11,filesystem.Node_set);
     	 
     	 Expr[] finalArgs2 =  new Expr[3];
     	 finalArgs2[0]=node2;
     	 finalArgs2[1]=ctx.MkConst("type", filesystem.type);
     	 finalArgs2[2]=name2;
     		
     	 Expr Node22= filesystem.Node.MkDecl().Apply(finalArgs2);
     	 
     	Expr existNode22= ctx.MkSetMembership(Node22,filesystem.Node_set);
         
 		 Expr[] fatherindex =  new Expr[2];
    	 fatherindex[0]=node3;
		 fatherindex[1]=node1;
		 
	     Expr parentTuple=filesystem.Parent.MkDecl().Apply(fatherindex);
	     
	 	 Expr father1=(BoolExpr) ctx.MkSetMembership(parentTuple, filesystem.Parent_set);
	     
 		 Expr[] fatherindex2 =  new Expr[2];
    	 fatherindex2[0]=node3;
		 fatherindex2[1]=node2;
		 
	     Expr parentTuple2=filesystem.Parent.MkDecl().Apply(fatherindex2);
	     
	     Expr father2=(BoolExpr) ctx.MkSetMembership(parentTuple2, filesystem.Parent_set);
	     
	     Expr eq=ctx.MkEq(name1, name2);
	     
	     Expr same=ctx.MkAnd(new BoolExpr [] {(BoolExpr) existNode11, (BoolExpr) existNode22, (BoolExpr) eq, (BoolExpr) father2, (BoolExpr) father1
	    			 });
	      
	     Expr body=ctx.MkAnd(new BoolExpr [] {ctx.MkEq(node1, node2), (BoolExpr) ctx.MkSetMembership( node1, filesystem.FSObject_set)});
	     
	     Expr rt=ctx.MkImplies((BoolExpr) same,(BoolExpr) ctx.MkEq(node1, node2) );
	     
	 //    Expr eq1=ctx.MkEq(node1, node2);
	     
	     
	//     Expr body2=ctx.MkAnd(new BoolExpr [] {(BoolExpr)existNode1, (BoolExpr) father1});
	     
	//     Expr body3=ctx.MkAnd(new BoolExpr [] {(BoolExpr)existNode2, (BoolExpr) father2 ,(BoolExpr) eq1 });
	     

	     
		 Sort[] nodes2 = new Sort[1];
		 nodes2[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
	//	 nodes[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
		 //setting names
		 Symbol[] namess2 = new Symbol[1];
		 namess2[0] =  ctx.MkSymbol("node2");
	//	 namess[1] =  ctx.MkSymbol("node2");

		 
                
      //   BoolExpr mustUniqueee = ctx.MkNot(ctx.MkExists(nodes2, namess2, body3, 1, null, null,
      //   null, null));
         
	
 	 //   Expr rr=ctx.MkImplies((BoolExpr) body2, mustUniqueee);
         
         BoolExpr mustUniqueee2 = ctx.MkForall(nodes, namess, rt, 1, null, null,
         null, null);
	 
         
         System.out.println("Quantifier Uniqueness: " + mustUniqueee2.toString());
         
         
		 return mustUniqueee2;
	}

}