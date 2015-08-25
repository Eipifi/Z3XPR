package evaluation.filesystem.operations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import token.TokenObj;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import evaluation.filesystem.filesystem;
import application.Operation;

public class RemoveDirectory implements Operation  {
	
	private String name;
	
	
 	private Expr dir2;
	private Expr dirId1;
	private Expr dirId2;
	private Expr dir1;
	Operation concurrentOp;
	
	
	public RemoveDirectory(String name, Context ctx) {
		
		this.name=name;
		try {

			dirId2=ctx.MkConst("dir3", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
			
		    Expr[] nodeArgs =  new Expr[3];
		    nodeArgs[0]=ctx.MkConst("dir3", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));;
		    nodeArgs[1]=filesystem.type.Consts()[0];
		    nodeArgs[2]=ctx.MkConst("name3", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
		    
	   	 	this.dir2=filesystem.Node.MkDecl().Apply(nodeArgs);

	   	 	this.dirId1=ctx.MkConst("dir5", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
		    Expr[] nodeArgs1 =  new Expr[3];
		    nodeArgs1[0]=dirId1;
		    nodeArgs1[1]=filesystem.type.Consts()[0];
		    nodeArgs1[2]=ctx.MkConst("name1", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
		    
	   	 //	dir1=filesystem.Node.MkDecl().Apply(nodeArgs1);
	   	 	
		
		} catch (Z3Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getReplicaIndex() {
		return 0;
	}

	@Override
	public BoolExpr precondition(Context ctx) throws Z3Exception {
	
	    Expr[] nodeArgs1 =  new Expr[3];
	    nodeArgs1[0]=ctx.MkConst("node2", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
	    nodeArgs1[1]=ctx.MkConst("type", filesystem.type);
	    nodeArgs1[2]=ctx.MkConst("name1", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
   	 
   	 	Expr child=filesystem.Node.MkDecl().Apply(nodeArgs1);
		
		
	    Expr[] argParent= new Expr[2];
	    argParent[0]=dirId2;
	    argParent[1]= nodeArgs1[0];	
		Expr parentTuple=filesystem.Parent.MkDecl().Apply(argParent);
		
		Expr empty=ctx.MkAnd(new BoolExpr []{(BoolExpr) ctx.MkSetMembership(nodeArgs1[0], filesystem.FSObject_set),
				 (BoolExpr)ctx.MkSetMembership(parentTuple,filesystem.Parent_set )});
		
		Sort[] nodearg = new Sort[1];
		nodearg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
		Symbol[] namesp = new Symbol[1];
		namesp[0] =  ctx.MkSymbol("node2");
		
		Expr isEmpty=ctx.MkNot(ctx.MkExists(nodearg, namesp, empty, 1, null, null,null, null));	

		Expr precondition=ctx.MkAnd(new BoolExpr []{(BoolExpr) isEmpty, ctx.MkNot(ctx.MkEq(filesystem.root, dirId2))})	;	
		
	
  	    return (BoolExpr) precondition;
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		
		
		System.out.println("concurrent op:"+concurrentOp);
		
		if (concurrentOp!=null && concurrentOp.getName()=="AddDirectory"  ) {
			return filesystem.Parent_set ;
		}
		else {
		
		filesystem.Node_set= ctx.MkSetDel(filesystem.Node_set,dir2);
		filesystem.Dir_set= ctx.MkSetDel(filesystem.Dir_set,dirId2);
		filesystem.FSObject_set= ctx.MkSetDel(filesystem.FSObject_set,ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"))));
		
		
	    Expr[] argParent= new Expr[2];
	    argParent[0]=dirId1;
	    argParent[1]=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));	
		Expr parentTuple=filesystem.Parent.MkDecl().Apply(argParent);
		filesystem.Parent_set= ctx.MkSetDel(filesystem.Parent_set,parentTuple);  
		
   	 
    	 Expr[] finalArgs =  new Expr[2];
    	 finalArgs[0]=filesystem.root ;
    	 finalArgs[1]=dirId2;
    		
    	 Expr tbody= (BoolExpr) ctx.MkApp(filesystem.exists, finalArgs)  ; 
    	 
 	    Expr[] arg= new Expr[3];
 	    arg[0]=dirId2;
 	    arg[1]=filesystem.root;
 	    arg[2]=tbody;	
 		Expr parentTuple3=filesystem.Reachability.MkDecl().Apply(arg);
 		filesystem.Reachable_set= ctx.MkSetDel(filesystem.Reachable_set,parentTuple3); 
 		
		}
 		
    	 
	    return   filesystem.Reachable_set ;
	}

	@Override
	public void putReplicaIndex(Context ctx, int r) throws Z3Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Expr[] getArgs(String name) {
		Expr [] args={dirId2};
		return args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {

		if (op.getName()=="AddFile") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[1], this.dirId2));
		}
		else if (op.getName()=="MoveFile") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[1], this.dirId2));
		}
		
		else if (op.getName()=="AddDirectory") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[1], this.dirId2));
			//Expr [] expr={op.getArgs(this.name)[1], this.dirId2};
			///return ctx.MkDistinct(expr);
		}
		
		else if (op.getName()=="MoveDirectory") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[1], this.dirId2));
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
