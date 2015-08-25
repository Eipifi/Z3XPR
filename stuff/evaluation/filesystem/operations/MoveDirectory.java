package evaluation.filesystem.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import token.TokenObj;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Model;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Status;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Version;
import com.microsoft.z3.Z3Exception;

import evaluation.filesystem.filesystem;
import application.Operation;

public class MoveDirectory implements Operation  {

	private String name;
	
	private Expr dir;
	private Expr  id;
	private Expr  dirId1;
	private Expr dir1;
	private Expr  dirId2;
	private Expr dir2;
	
	private Expr dname;
	
	
	public MoveDirectory(String name, Context ctx) {
		
		this.name=name;
		try {
   	 	
			dirId1=ctx.MkConst("dir5", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
			
		    Expr[] nodeArgs1 =  new Expr[3];
		    nodeArgs1[0]=dirId1;
		    nodeArgs1[1]=filesystem.type.Consts()[0];
		    nodeArgs1[2]=ctx.MkConst("name5", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
	   	 
	   	 	//this.dir1=filesystem.Node.MkDecl().Apply(nodeArgs1);
	   	 	
	   	 	dirId2=ctx.MkConst("dir3", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
	   	 	
		    Expr[] nodeArgs2 =  new Expr[3];
		    nodeArgs2[0]=dirId2;
		    nodeArgs2[1]=filesystem.type.Consts()[0];
		    nodeArgs2[2]=ctx.MkConst("name3", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
	   	 
	   	 	//this.dir2=filesystem.Node.MkDecl().Apply(nodeArgs2);	
	   	 	
	   	 	
	   	 	id=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
	   	 	
	   	 	Random bi=new Random();
	   	 	int i=bi.nextInt();
	   	 	
		    Expr[] nodeArgs =  new Expr[3];
		    nodeArgs[0]=id;
		    nodeArgs[1]=filesystem.type.Consts()[0];
		    nodeArgs[2]=ctx.MkConst("name1"+i, ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
		    
		    dname=nodeArgs[2];
	   	 
	   	 	//this.dir=filesystem.Node.MkDecl().Apply(nodeArgs);	
		
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

		
		Expr[] finalArgs =  new Expr[2];
		finalArgs[0]=filesystem.root;
		finalArgs[1]=dirId2;
   		
		Expr tbody= ctx.MkApp(filesystem.exists, finalArgs)  ; 
  	 
	     Expr[] arg= new Expr[3];
	     arg[0]=dirId2;
	     arg[1]=filesystem.root;
	     arg[2]=tbody;	
		 Expr reachTuple=filesystem.Reachability.MkDecl().Apply(arg);
		 Expr reachable= ctx.MkSetMembership(reachTuple,filesystem.Reachable_set);  
		 
		 
		 Expr node1=ctx.MkConst("node2", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")) );
		 
 		 Expr[] fatherindex =  new Expr[2];
    	 fatherindex[0]=dirId2;
		 fatherindex[1]=node1;
		 
	     Expr parentTuple1=filesystem.Parent.MkDecl().Apply(fatherindex);
	     
	 	 Expr father1=(BoolExpr) ctx.MkSetMembership(parentTuple1, filesystem.Parent_set);
	 	 
		 Sort[] nodes = new Sort[1];
		 nodes[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));

		 Symbol[] namess = new Symbol[1];
		 namess[0] =  ctx.MkSymbol("node2");
  	 	
		 Expr[] nodeArgs1 =  new Expr[3];
		 nodeArgs1[0]=node1;
		 nodeArgs1[1]=ctx.MkConst("type", filesystem.type);
		 nodeArgs1[2]=ctx.MkConst("name2", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
		 
		 Expr eq=ctx.MkEq(dname,  nodeArgs1[2]);
	   	 
	   	 Expr node=filesystem.Node.MkDecl().Apply(nodeArgs1);
	     
	     Expr body=ctx.MkAnd(new BoolExpr [] {   (BoolExpr) ctx.MkSetMembership(node, filesystem.Node_set), (BoolExpr)father1 , (BoolExpr)  eq});
                
         BoolExpr mustUniqueee = ctx.MkNot(ctx.MkExists(nodes, namess, body, 1, null, null,
         null, null));
         
 		
 		
 		Expr[] finalArgs1 =  new Expr[2];
 		finalArgs1[0]=id;
 		finalArgs1[1]=dirId2; ;
    		
 		Expr tbody1= (BoolExpr) ctx.MkApp(filesystem.exists, finalArgs1)  ; 
 		
 	     Expr[] arg1= new Expr[3];
 	     arg1[0]=dirId2; 
 	     arg1[1]=id;
 	     arg1[2]=tbody1;	
 		 Expr parentTuple3=filesystem.Reachability.MkDecl().Apply(arg1);
 		 Expr notAncestor=ctx.MkSetMembership(parentTuple3, filesystem.Reachable_set);   
         
         
         Expr precondition=ctx.MkAnd(new BoolExpr [] {(BoolExpr) mustUniqueee,(BoolExpr) reachable, 
        		 ctx.MkNot(ctx.MkEq(filesystem.root, id)), ctx.MkNot((BoolExpr) notAncestor)});
		 
		 return (BoolExpr) precondition;
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		
	    Expr[] argParent= new Expr[2];
	    argParent[0]=dirId1;
	    argParent[1]=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));	
		Expr parentTuple=filesystem.Parent.MkDecl().Apply(argParent);
		filesystem.Parent_set= ctx.MkSetDel(filesystem.Parent_set,parentTuple);  
		
	    Expr[] argParent2= new Expr[2];
	    argParent2[0]=dirId2;
	    argParent2[1]=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));	
		Expr parentTuple2=filesystem.Parent.MkDecl().Apply(argParent2);
		filesystem.Parent_set= ctx.MkSetAdd(filesystem.Parent_set,parentTuple2);  
		
		
		
		Expr[] finalArgs =  new Expr[2];
		finalArgs[0]=dirId2;
		finalArgs[1]=id;
   		
		Expr tbody= (BoolExpr) ctx.MkApp(filesystem.exists, finalArgs)  ; 
		
	     Expr[] arg= new Expr[3];
	     arg[0]=id;
	     arg[1]=dirId2;
	     arg[2]=tbody;	
		 Expr parentTuple3=filesystem.Reachability.MkDecl().Apply(arg);
		 filesystem.Reachable_set= ctx.MkSetAdd(filesystem.Reachable_set,parentTuple3);   
		 
		
		return filesystem.Reachable_set;
	}

	@Override
	public void putReplicaIndex(Context ctx, int r) throws Z3Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Expr[] getArgs(String name) {
		Expr [] args={dname, dirId2, id};
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
			//Expr [] expr={op.getArgs(this.name)[1], this.dirId2};
			///return ctx.MkDistinct(expr);
		}
		
		else if (op.getName()=="RemoveDirectory") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.dirId2));
		}
		
		else if (op.getName()=="MoveDirectory") {
		//	return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.dname));
			
			return ctx.MkAnd(new BoolExpr [] {ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[1], dirId2)), ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[2], id))});
			//return ctx.MkTrue();
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
	
	public static void main(String[] args)  {


        System.out.print("Z3 Major Version: ");
        System.out.println(Version.Major());
        System.out.print("Z3 Full Version: ");
        System.out.println(Version.getString());
        Context ctx;
		try {
			ctx = new Context();
		     filesystem p=new filesystem();
    	     p.initializeState(ctx);
		
        String app_name = "";
           MoveDirectory md=new 	MoveDirectory("MoveDirectory",ctx);
           
			Move concurrentOps=new Move("MoveDirectory", ctx);
			
			 BoolExpr preOld= md.precondition(ctx);
	          
		   	     System.out.println("\n");
	    	     System.out.println("Precondition before applying shadowOp:"+preOld);
	    
	    	     
				 BoolExpr exprOld=ctx.MkAnd(new BoolExpr[] { preOld,p.getCompoisteInvariant(ctx)});	
				
				 System.out.println("\n");
				 BoolExpr condition=(BoolExpr) md.getCondition(ctx, concurrentOps);
		//		 BoolExpr condition=ctx.MkTrue(); 
			 	 System.out.println("Concurrency condition:"+condition);

				 System.out.println("\n");
			     System.out.println("Applying shadowOp: "+concurrentOps.effect(ctx));
			     System.out.println("\n");
				 BoolExpr preNew=md.precondition(ctx);
				 System.out.println("Precondition after receiving shadowOp:"+preNew);
				 System.out.println("\n");
				 
				 BoolExpr stabilityCheck=ctx.MkImplies(exprOld,preNew);	
		 	     
		 	//     
		 	//    BoolExpr condition=(BoolExpr) matrix[i+1][k+1];
		 
		      //
		 	  
		 	     BoolExpr correct=ctx.MkImplies(condition, stabilityCheck);
		 	     
		 	     Solver s3 = ctx.MkSolver();
			     s3.Assert(ctx.MkNot(correct));
		         Status status=s3.Check();
		         System.out.println("Assertion formula:"+s3.Assertions()[0]);
		         System.out.println("\n");
		       //  Model model = st.Check(ctx,ctx.MkNot(correct), Status.SATISFIABLE);
				// System.out.println("counter example:"+model);
		       
		     
		         System.out.println("result:"+status);
		     
		}
		catch (Z3Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		     
		    //  System.out.println("check finishes for operation "+ op.get(i).getName()+ ": \n "+ "Conflicting Operations:"+set.get(op.get(i).getName()));
	

	}

}
