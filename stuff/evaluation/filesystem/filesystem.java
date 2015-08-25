package evaluation.filesystem;

import invariant.Invariant;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Constructor;
import com.microsoft.z3.Context;
import com.microsoft.z3.DatatypeSort;
import com.microsoft.z3.EnumSort;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Log;
import com.microsoft.z3.Model;
import com.microsoft.z3.SetSort;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Status;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.TupleSort;
import com.microsoft.z3.Version;
import com.microsoft.z3.Z3Exception;

import evaluation.courseware.courseware;
import evaluation.courseware.invariant.BoundedInv;
import evaluation.courseware.invariant.UniqneInv;
import evaluation.courseware.operations.AddCourse;
import evaluation.courseware.operations.AddStudent;
import evaluation.courseware.operations.Disenroll;
import evaluation.courseware.operations.Enroll;
import evaluation.courseware.operations.RemoveCourse;
import evaluation.courseware.operations.RemoveStudent;
import evaluation.filesystem.invariant.CausalityRelation;
import evaluation.filesystem.invariant.NoCycleInv;
import evaluation.filesystem.invariant.Parentship;
import evaluation.filesystem.invariant.ReachabilityInv;
import evaluation.filesystem.invariant.ReachabilityRelation;
import evaluation.filesystem.invariant.Uniqness;
import evaluation.filesystem.invariant.UniqueRoot;
import evaluation.filesystem.operations.AddDirectory;
import evaluation.filesystem.operations.AddFile;
import evaluation.filesystem.operations.MoveDirectory;
import evaluation.filesystem.operations.MoveFile;
import evaluation.filesystem.operations.RemoveDirectory;
import evaluation.filesystem.operations.RemoveFile;
import evaluation.filesystem.operations.UpdateFile;
import analyzer.Pair;
import analyzer.StabilityCheck;
import application.Application;
import application.Operation;

public class filesystem extends Application{
	
	
	public static Sort FSObject; 
	public static Expr FSObject_set;
	public static Sort Dir; 
	public static Expr Dir_set;
	
	public static Sort File; 
	public static Expr File_set;
	
	public static Expr UpdatedFile_set;
	
	
	public static TupleSort Parent;
	public static TupleSort Node;
	public static TupleSort Reachability;
	
	public static EnumSort type;
	
	public List<Operation> op=new ArrayList<Operation>();
	static List<Invariant> inv=new ArrayList<Invariant>();

	//static Sort node;

	public static FuncDecl father,exists ;
	public static Expr rootNode; 
	public static Expr root; 
	
	public static Expr Parent_set;
	public static Expr Node_set;
	
	public static Expr Reachable_set;
	
	public static  Sort Name;
	
	public static EnumSort FsObject;
	public static Expr FsObject_set;
	
	public static TupleSort Parent1;
	public static TupleSort Node1;
	public static Expr Node1_set;
	
	public static Expr root1;
	

	public List<Operation> loadOperations(Context ctx) throws Z3Exception {

		Operation o1=new AddFile("AddFile",ctx);
		Operation o2=new RemoveFile("RemoveFile",ctx);
		Operation o3=new UpdateFile("UpdateFile",ctx);
		Operation o4=new MoveFile("MoveFile",ctx);
		Operation o5=new AddDirectory("AddDirectory",ctx);
		Operation o6=new RemoveDirectory("RemoveDirectory",ctx);
		Operation o7=new MoveDirectory("MoveDirectory", ctx);
	
		op.add(o1);
	//	op.add(o2);
		
	//	op.add(o3);
	 //   op.add(o4);
	    /*    op.add(o5);
	    op.add(o6);		
	    op.add(o7);	*/
		return op;
		
	}

	@Override
	public List<Invariant> loadInvariants(Context ctx) throws Z3Exception {
		
		Invariant inv1=new  ReachabilityInv("Reachable",ctx);
		Invariant inv2=new NoCycleInv("Nocylce");
		Invariant inv3=new Uniqness("Uniqness");
		Invariant inv4=new UniqueRoot("UniqueRoot");
		Invariant inv5=new CausalityRelation("CausalityRelation");
	//	Invariant inv6=new ReachabilityRelation("ReachabilityRelation");
		
       inv.add(inv1);		
    //    inv.add(inv2);
	   // inv.add(inv3);
	//  inv.add(inv4);
	//    inv.add(inv5);

        return inv;
	}
	
	
	@Override
	public void initializeState(Context ctx) throws Z3Exception {
		
		FSObject = ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
		
	    SetSort ff=ctx.MkSetSort(FSObject);
	    FSObject_set = ctx.MkConst("FSObject_set",ff);
	
		Dir = ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));
		
	    SetSort dd=ctx.MkSetSort(Dir);
	    Dir_set = ctx.MkConst("Dir_set",dd);
	    
	    
		File = ctx.MkUninterpretedSort("Dir");
		
	    SetSort fl=ctx.MkSetSort(File);
	    File_set = ctx.MkConst("File_set",fl);
	    
	    
	    SetSort uf=ctx.MkSetSort(FSObject);
	    UpdatedFile_set = ctx.MkConst("UpdatedFile_set",uf);
	        
	  
		Symbol name = ctx.MkSymbol("type");		
		Symbol[] args={ ctx.MkSymbol("Dir"), ctx.MkSymbol("File")} 	;	
		type= ctx.MkEnumSort(name, args);
	
		Symbol FSname = ctx.MkSymbol("FsObject");
		Symbol[] FSargs={ ctx.MkSymbol("Dir"), ctx.MkSymbol("File")} ;
		
		FsObject= ctx.MkEnumSort(FSname, FSargs);
		
	    
	  //  root = ctx.MkConst("root", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));   
		Name = ctx.MkUninterpretedSort("Name");
	    
	    Node= ctx.MkTupleSort(ctx.MkSymbol("mk_Node_tuple"), // name of
		  	      new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second") , ctx.MkSymbol("third")}, // names
		  	      new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")), type , Name} );
	    
  	    
	    SetSort os=ctx.MkSetSort(Node);
	    Node_set = ctx.MkConst("Node_set",os);
	   
	
	    root=ctx.MkConst("root", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
	    
	  //  Expr[] nodeArgs =  new Expr[3];
	  //  nodeArgs[0]=root;
	 //   nodeArgs[1]=type.Consts()[0];
	  //  nodeArgs[2]=ctx.MkConst("root", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
   	 
   	 //	rootNode=filesystem.Node.MkDecl().Apply(nodeArgs);
   	 	

	    filesystem.Dir_set= ctx.MkSetAdd(filesystem.Dir_set,root);
	    
	    Parent= ctx.MkTupleSort(ctx.MkSymbol("mk_Parent_tuple"), // name of
		  	      new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second") }, // names
		  	      new Sort[] { 	ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")), ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"))  } );
	    
	    SetSort ps=ctx.MkSetSort(Parent);
	    Parent_set = ctx.MkConst("Parent_set",ps);
	    
	    
	    Reachability= ctx.MkTupleSort(ctx.MkSymbol("mk_Reachability_tuple"), // name of
		  	      new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second"), ctx.MkSymbol("third") }, // names
		  	      new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")), ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")), ctx.MkBoolSort()  } );
	    
	    SetSort re=ctx.MkSetSort(Reachability);
	    Reachable_set = ctx.MkConst("Reachable_set",re);


		father= ctx.MkFuncDecl("father", new Sort[] { Node ,Node}, ctx.MkBoolSort());
	    exists = ctx.MkFuncDecl("reachable", new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")) ,ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")) }, ctx.MkBoolSort()); 
		
	}
	

	@Override
	public BoolExpr getCompoisteInvariant(Context ctx) throws Z3Exception {
		
		BoolExpr composite=ctx.MkTrue();
		for (Invariant i:inv )
		 composite=	ctx.MkAnd(new BoolExpr []{composite, (BoolExpr) i.getInv(ctx)});		
		return composite;
	}

}
