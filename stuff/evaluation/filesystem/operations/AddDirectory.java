package evaluation.filesystem.operations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import token.TokenObj;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.filesystem.filesystem;
import application.Operation;

public class AddDirectory implements Operation {
	
	private String name;
	
//	private Expr dir1;
	private Expr  id1;
	private Expr  id2;
	private Expr dir2;
	private  Expr dname;

	
	public AddDirectory(String name, Context ctx) {
		
		this.name=name;
		try {
   	 	
			this.dname=ctx.MkConst("name1", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
			
			this.id1=ctx.MkConst("dir3", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
			
		    Expr[] nodeArgs1 =  new Expr[3];
		    nodeArgs1[0]=id1;
		    nodeArgs1[1]=filesystem.type.Consts()[0];
		    nodeArgs1[2]=ctx.MkConst("name3", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
	   	 
	   	 	//this.dir1=filesystem.Node.MkDecl().Apply(nodeArgs1);
	   	 	
	   	 	this.id2=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
	   	 	
		    Expr[] nodeArgs =  new Expr[3];
		    nodeArgs[0]=id2;
		    nodeArgs[1]=ctx.MkConst("type", filesystem.type);
		    nodeArgs[2]=ctx.MkConst("name1", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
		    
	   	 
	   	 	this.dir2=filesystem.Node.MkDecl().Apply(nodeArgs);	
		
		} catch (Z3Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getReplicaIndex() {
		return 0;
	}

	@Override
	public BoolExpr precondition(Context ctx) throws Z3Exception {
		
		
		
     	 Expr[] finalArgs =  new Expr[2];
     	 finalArgs[0]=filesystem.root;
     	 finalArgs[1]=id1;
     		
     	 Expr tbody= ctx.MkApp(filesystem.exists, finalArgs)  ; 
    	 
 	     Expr[] arg= new Expr[3];
 	     arg[0]=id1;
 	     arg[1]=filesystem.root;	
 	     arg[2]=tbody;	
 		 Expr reachTuple=filesystem.Reachability.MkDecl().Apply(arg);
 		 Expr reachable= ctx.MkSetMembership(reachTuple,filesystem.Reachable_set);  
 		 
 		// Expr pt=ctx.MkOr(new BoolExpr []{(BoolExpr) reachable, ctx.MkEq(dir1, filesystem.root) });
 		 
		 Sort[] nodes = new Sort[1];
		 nodes[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));

		 Symbol[] namess = new Symbol[1];
		 namess[0] =  ctx.MkSymbol("node2");
		 
		 Expr node1=ctx.MkConst("node2", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")) );
		 
 		 Expr[] fatherindex =  new Expr[2];
    	 fatherindex[0]=id1;
		 fatherindex[1]=node1;
		 
	     Expr parentTuple=filesystem.Parent.MkDecl().Apply(fatherindex);
	     
	 	 Expr father1=(BoolExpr) ctx.MkSetMembership(parentTuple, filesystem.Parent_set);
 	 	
		 Expr[] nodeArgs1 =  new Expr[3];
		 nodeArgs1[0]=node1;
		 nodeArgs1[1]=ctx.MkConst("type", filesystem.type);
		 nodeArgs1[2]=ctx.MkConst("name2", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
		 
		 
		 
		 Expr eq=ctx.MkEq(this.dname,  nodeArgs1[2]);
	   	 
	   	 Expr node=filesystem.Node.MkDecl().Apply(nodeArgs1);
	     
	     Expr body=ctx.MkAnd(new BoolExpr [] {   (BoolExpr) ctx.MkSetMembership(node, filesystem.Node_set), (BoolExpr)father1 , (BoolExpr)  eq});
                
         BoolExpr mustUniqueee = ctx.MkNot(ctx.MkExists(nodes, namess, body, 1, null, null,
         null, null));
         
 		 Expr[] parentIndex =  new Expr[2];
 		 parentIndex[0]=ctx.MkConst("dir5", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")) );
 		 parentIndex[1]=ctx.MkConst("dir1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")) );
		 
	     Expr parentTuple1=filesystem.Parent.MkDecl().Apply(parentIndex);
	     
		 Sort[] nodes1 = new Sort[1];
		 nodes1[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));

		 Symbol[] namess1 = new Symbol[1];
		 namess1[0] =  ctx.MkSymbol("dir5");
 		 
	 	 Expr parent1=ctx.MkNot((BoolExpr) ctx.MkSetMembership(parentTuple1, filesystem.Parent_set));
	 	 
	 	 BoolExpr notExist= ctx.MkForall(nodes1, namess1, parent1, 1, null, null,
	 	         null, null);
    	 
    	 Expr precondition=ctx.MkAnd(new BoolExpr [] { (BoolExpr) reachable, mustUniqueee});
    	    		  
		 return (BoolExpr) precondition;
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		
		filesystem.Node_set= ctx.MkSetAdd(filesystem.Node_set,dir2);
		filesystem.FSObject_set= ctx.MkSetAdd(filesystem.FSObject_set,id2);
		
		filesystem.Dir_set= ctx.MkSetAdd(filesystem.Dir_set,ctx.MkConst("dir1", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"))));
		
	    Expr[] argParent= new Expr[2];
	    argParent[0]=id1;
	    argParent[1]=id2;	
		Expr parentTuple=filesystem.Parent.MkDecl().Apply(argParent);
		filesystem.Parent_set= ctx.MkSetAdd(filesystem.Parent_set,parentTuple);   
		
    	 Expr[] finalArgs =  new Expr[2];
    	 finalArgs[0]=filesystem.root;
    	 finalArgs[1]=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
    		
    	 Expr tbody= (BoolExpr) ctx.MkApp(filesystem.exists, finalArgs)  ; 
    	 
 	     Expr[] arg= new Expr[3];
 	     arg[0]=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
 	     arg[1]=filesystem.root;
 	     arg[2]=tbody;	
 		 Expr parentTuple3=filesystem.Reachability.MkDecl().Apply(arg);
 		 filesystem.Reachable_set= ctx.MkSetAdd(filesystem.Reachable_set,parentTuple3);   

    	 
	     return filesystem.Parent_set ;

	}

	@Override
	public void putReplicaIndex(Context ctx, int r) throws Z3Exception {
		
	}

	@Override
	public Expr[] getArgs(String name) {
		
		Expr  [] args={dname, id1};
		return args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {

		if (op.getName()=="AddFile") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.dname));
		}
		else if (op.getName()=="MoveFile") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.dname));
		}
		
		else if (op.getName()=="AddDirectory") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.dname));
		}
		
		else if (op.getName()=="RemoveDirectory") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.id1));
		}
		else if (op.getName()=="MoveDirectory") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.dname));
		}

		else return ctx.MkTrue();	
	}

	@Override
	public List<Operation> concurrentOps(Context ctx) {
		
		List<Operation> op=new ArrayList<Operation>();

		Operation o1=new AddFile("AddFile",ctx);
		Operation o2=new RemoveFile("RemoveFile",ctx);
		Operation o3=new UpdateFile("UpdateFile",ctx);
		Operation o4=new MoveFile("MoveFile",ctx);
		Operation o5=new AddDirectory("AddDirectory",ctx);
		Operation o6=new RemoveDirectory("RemoveDirectory",ctx);
		Operation o7=new MoveDirectory("MoveDirectory", ctx);
		
		op.add(o1);
		op.add(o2);
		op.add(o3);
		op.add(o4);
		op.add(o5);
		op.add(o6);		
		op.add(o7);	
		
		return op;
	}

	@Override
	public Expr[] getConditions(Context ctx, Operation op) throws Z3Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putConcurrentOp(Context ctx, Operation op) throws Z3Exception {
		// TODO Auto-generated method stub
		
	}

}
