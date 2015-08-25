package evaluation.filesystem.operations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import token.TokenObj;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.filesystem.filesystem;
import application.Operation;

public class AddFile implements Operation  {

	private String name;
	
	//private Expr dir;
	private Expr file;
	private Expr dirId;
	private Expr fileId;
	
	private Expr fname;
	int i;
	
	
	public AddFile(String name, Context ctx) {
		
		this.name=name;
		try {

		 	Random bi=new Random();
	   	 	 i=bi.nextInt();
			dirId=ctx.MkConst(ctx.MkSymbol("dir"), ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
			
		
		    Expr[] nodeArgs =  new Expr[3];
		    nodeArgs[0]=dirId;
		    nodeArgs[1]=filesystem.type.Consts()[0];
		    nodeArgs[2]=ctx.MkConst("name3", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
	   	 
	 //  	 	this.dir=filesystem.Node.MkDecl().Apply(nodeArgs);
	 	
	   	 	fileId=ctx.MkConst("node1"+i, ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
	   	 	
	  
	   	 	
		    Expr[] nodeArgs1 =  new Expr[3];
		    nodeArgs1[0]=fileId;
		    nodeArgs1[1]=filesystem.type.Consts()[1];
		    nodeArgs1[2]=ctx.MkConst("name1"+i, ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
		    fname=nodeArgs1[2];
		//    System.out.println("lll"+fname);
	   	 
	   	 	this.file=filesystem.Node.MkDecl().Apply(nodeArgs1);
	   	 	
		
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
    	 finalArgs[1]=dirId;
    		
    	 Expr tbody= ctx.MkApp(filesystem.exists, finalArgs)  ; 
   	 
	     Expr[] arg= new Expr[3];
	     arg[0]=dirId;
	     arg[1]=filesystem.root;	
	     arg[2]=tbody;
		 Expr reachTuple=filesystem.Reachability.MkDecl().Apply(arg);
		 Expr reachable= ctx.MkSetMembership(reachTuple,filesystem.Reachable_set); 
		 
 	  	 
	     Sort[] nodesw =  new Sort[1];
	   	    
	     nodesw[0] = ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));
		 
	     Symbol[] nnamesw = new Symbol[1];
		 nnamesw[0] =  ctx.MkSymbol("dir3"+i);
		 
		 Expr based= ctx.MkExists(nodesw, nnamesw, reachable, 1, null, null,null,null); 
		 
		// Expr pt=ctx.MkOr(new BoolExpr []{(BoolExpr) reachable, ctx.MkEq(dir1, filesystem.root) });
   	 
   	    //Expr precondition=ctx.MkAnd(new BoolExpr [] {ctx.MkNot(ctx.MkEq(id2, filesystem.root)), (BoolExpr) reachable});
		 
		 Expr node1=ctx.MkConst("node2", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")) );
		 
 		 Expr[] fatherindex =  new Expr[2];
    	 fatherindex[0]=dirId;
		 fatherindex[1]=node1;
		 
	     Expr parentTuple=filesystem.Parent.MkDecl().Apply(fatherindex);
	     
	 	 Expr father1=(BoolExpr) ctx.MkSetMembership(parentTuple, filesystem.Parent_set);
	 	 
		 Sort[] nodes = new Sort[1];
		 nodes[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
	

		 Symbol[] namess = new Symbol[1];
		 namess[0] =  ctx.MkSymbol("node2");
		
	   	 	Random bi=new Random();
	   	 	int i=bi.nextInt();
  	 	
		 Expr[] nodeArgs1 =  new Expr[3];
		 nodeArgs1[0]=node1;
		 nodeArgs1[1]=ctx.MkConst("type", filesystem.type);
		 nodeArgs1[2]=ctx.MkConst("name2", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
		 
		 Expr eq=ctx.MkEq(fname,  nodeArgs1[2]);
	   	 
	   	 Expr node=filesystem.Node.MkDecl().Apply(nodeArgs1);
	     
	     Expr body=ctx.MkAnd(new BoolExpr [] {   (BoolExpr) ctx.MkSetMembership(node, filesystem.Node_set), (BoolExpr)father1 , (BoolExpr)  eq, ctx.MkNot(ctx.MkEq(node1, fileId))});
                
         BoolExpr mustUniqueee = ctx.MkNot(ctx.MkExists(nodes, namess, body, 1, null, null,
         null, null));
         
 		 Expr[] parentIndex =  new Expr[2];
 		 parentIndex[0]=ctx.MkConst("dir5", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")) );
 		 parentIndex[1]=fileId;
		 
	     Expr parentTuple1=filesystem.Parent.MkDecl().Apply(parentIndex);
	     
		 Sort[] nodes1 = new Sort[1];
		 nodes1[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Name"));

		 Symbol[] namess1 = new Symbol[1];
		 namess1[0] =  ctx.MkSymbol("name2");
		 
	     
	 	 Expr parent1=ctx.MkNot((BoolExpr) ctx.MkSetMembership(parentTuple1, filesystem.Parent_set));
	 	 
	 	 BoolExpr notExist= ctx.MkForall(nodes1, namess1, mustUniqueee, 1, null, null,
	 	         null, null);
         

		 Sort[] nodes13 = new Sort[1];
		 nodes13[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));

		 Symbol[] namess13 = new Symbol[1];
		 namess13[0] =  ctx.MkSymbol("node2");
		 
	     
	 	 Expr po=ctx.MkAnd(new BoolExpr [] { (BoolExpr) ctx.MkSetMembership(node1, filesystem.FSObject_set) , ctx.MkEq(node1, fileId) });
	 	 
	 	 BoolExpr notExist2= ctx.MkForall(nodes13, namess13, po, 1, null, null,
	 	         null, null);
         
	   	  
	  // 	 Expr dir1Exist=ctx.MkSetMembership(dir,filesystem.Node_set);
	 	 
	//   	ctx.MkNot((BoolExpr) ctx.MkSetMembership(fileId, filesystem.FSObject_set) ),
	 	 Expr precondition=ctx.MkAnd(new BoolExpr [] {(BoolExpr) notExist,(BoolExpr) reachable
	 	  });

		 return (BoolExpr) precondition;
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		
		filesystem.Node_set= ctx.MkSetAdd(filesystem.Node_set,file);
		
		filesystem.FSObject_set= ctx.MkSetAdd(filesystem.FSObject_set,fileId);
		
		
	    Expr[] argParent= new Expr[2];
	    argParent[0]=dirId;
	    argParent[1]=fileId;	
		Expr parentTuple=filesystem.Parent.MkDecl().Apply(argParent);
		filesystem.Parent_set= ctx.MkSetAdd(filesystem.Parent_set,parentTuple);   
		
		Expr[] finalArgs =new Expr[2];
		finalArgs[0]=filesystem.root;
		finalArgs[1]=fileId;
   		
		//Expr tbody= (BoolExpr) ctx.MkApp(filesystem.exists, finalArgs)  ; 
   	 
	 //   Expr[] arg= new Expr[3];
	 //   arg[0]=fileId;
	 //   arg[1]=filesystem.root;	
	 // //  arg[2]=tbody;	
	//	Expr parentTuple3=filesystem.Reachability.MkDecl().Apply(arg);
	  //  filesystem.Reachable_set= ctx.MkSetAdd(filesystem.Reachable_set,parentTuple3); 

		
	 //   Expr[] arg4= new Expr[3];
	 //   arg4[0]=fileId;
	 //   arg4[1]=dirId;	
	   // arg4[2]=tbody;	
	//	Expr parentTuple4=filesystem.Reachability.MkDecl().Apply(arg4);
	 //   filesystem.Reachable_set= ctx.MkSetAdd(filesystem.Reachable_set,parentTuple3); 
	    
	//    filesystem.Reachable_set= ctx.MkITE(ctx.MkEq(dirId, filesystem.root), ctx.MkSetAdd(filesystem.Reachable_set,parentTuple3), ctx.MkSetAdd(filesystem.Reachable_set,parentTuple4));
	    
		
	    return   filesystem.Parent_set;
	}

	@Override
	public void putReplicaIndex(Context ctx, int r) throws Z3Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Expr[] getArgs(String name) {
		Expr [] args={fname, dirId};
		return args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		
		if (op.getName()=="AddFile") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.fname));
		}
		else if (op.getName()=="MoveFile") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.fname));
		}
		
		else if (op.getName()=="AddDirectory") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.fname));
		}
		
		else if (op.getName()=="RemoveDirectory") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.dirId));
		}
		else if (op.getName()=="MoveDirectory") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.fname));
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
		Expr [] args = null;
		return args;
	}

	@Override
	public void putConcurrentOp(Context ctx, Operation op) throws Z3Exception {
		// TODO Auto-generated method stub
		
	}

}
