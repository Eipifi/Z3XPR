package evaluation.filesystem.operations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import token.TokenObj;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Z3Exception;

import evaluation.filesystem.filesystem;
import application.Operation;

public class RemoveFile implements Operation {

	private String name;
	
	private Expr file;
	private Expr fileId;
	private Expr fname;
	
	Operation concurrentOp;
	
	
	public RemoveFile(String name, Context ctx) {
		
		this.name=name;
		try {

	   	 	this.fileId=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
		    Expr[] nodeArgs1 =  new Expr[3];
		    nodeArgs1[0]=this.fileId;
		    nodeArgs1[1]=filesystem.type.Consts()[1];   
		    nodeArgs1[2]=ctx.MkConst("name3", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
		    fname=nodeArgs1[2];
		    
	   	 	this.file=filesystem.Node.MkDecl().Apply(nodeArgs1);
		
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoolExpr precondition(Context ctx) throws Z3Exception {
		// TODO Auto-generated method stub
		return ctx.MkTrue();
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		
		System.out.println("concurrent op:"+concurrentOp);
		
		if (concurrentOp!=null && (concurrentOp.getName()=="UpdateFile" || concurrentOp.getName()=="AddFile")  ) {
			return filesystem.Parent_set ;
		}
		else {
		filesystem.Node_set= ctx.MkSetDel(filesystem.Node_set,file);
		filesystem.FSObject_set= ctx.MkSetDel(filesystem.FSObject_set,fileId);
		
		filesystem.UpdatedFile_set= ctx.MkSetDel(filesystem.UpdatedFile_set,fileId);
		
		Expr parent=ctx.MkConst("dir3", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
		
	    Expr[] argParent= new Expr[2];
	    argParent[0]=parent;
	    argParent[1]=fileId;	
		Expr parentTuple=filesystem.Parent.MkDecl().Apply(argParent);
		filesystem.Parent_set= ctx.MkSetDel(filesystem.Parent_set,parentTuple);   
		}
		
	/*	Expr[] finalArgs =  new Expr[2];
   	 	finalArgs[0]=filesystem.root;
   	 	finalArgs[1]=fileId;
   		
   	 //	Expr tbody= (BoolExpr) ctx.MkApp(filesystem.exists, finalArgs)  ; 
   	 
	    Expr[] arg= new Expr[2];
	    arg[0]=fileId;
	    arg[1]=tbody;	
		Expr parentTuple3=filesystem.Reachability.MkDecl().Apply(arg);
     }*/
		
		
	    return filesystem.Parent_set  ;
	}

	@Override
	public void putReplicaIndex(Context ctx, int r) throws Z3Exception {
	
		
	}

	@Override
	public Expr[] getArgs(String name) {
		Expr args [] ={fname};
		return args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		
		concurrentOp=op;
		
		return ctx.MkTrue();
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
		this.concurrentOp=op;
		
	}

}
