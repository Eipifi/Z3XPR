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

public class UpdateFile implements Operation {


	private String name;
	
	private Expr dir;
	private Expr file;
	private Expr dirId;
	private Expr fileId;
	private Expr fname;
	
	
	public UpdateFile(String name, Context ctx) {
		
		this.name=name;
		try {

			this.dirId=ctx.MkConst("dir3", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
		    Expr[] nodeArgs =  new Expr[3];
		    nodeArgs[0]=dirId;
		    nodeArgs[1]=filesystem.type.Consts()[0];
		    nodeArgs[2]=ctx.MkConst("name3", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
	   	 
	   	// 	this.dir=filesystem.Node.MkDecl().Apply(nodeArgs);
	   	 	
	   	 	this.fileId=ctx.MkConst("node", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
	   	 	
		    Expr[] nodeArgs1 =  new Expr[3];
		    nodeArgs1[0]=fileId;
		    nodeArgs1[1]=filesystem.type.Consts()[1];
		    nodeArgs1[2]=ctx.MkConst("name1", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
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

		return  (BoolExpr) ctx.MkSetMembership(file, filesystem.Node_set);
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		
		
	    Expr[] argParent= new Expr[2];
	    argParent[0]=dirId;
	    argParent[1]=fileId;	
		Expr parentTuple=filesystem.Parent.MkDecl().Apply(argParent);
		
		filesystem.UpdatedFile_set= ctx.MkSetAdd(filesystem.UpdatedFile_set,fileId);   
		
		return filesystem.UpdatedFile_set;
	}


	@Override
	public void putReplicaIndex(Context ctx, int r) throws Z3Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Expr[] getArgs(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		
	//	if (op.getName()=="RemoveFile") {
//			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.fname));
	//	}

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
		// TODO Auto-generated method stub
		
	}

}
