
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

import evaluation.filesystem.invariant.NoCycle;
import evaluation.filesystem.invariant.NoCycleInv;
import evaluation.filesystem.invariant.UniqeName;
import evaluation.filesystem.invariant.Uniqness;
import evaluation.filesystem.invariant.UniqueForRoot;
import evaluation.filesystem.invariant.UniqueRoot;
import evaluation.filesystem.invariant.Reachability;
import evaluation.filesystem.operations.AddDirectory;
import evaluation.filesystem.operations.AddDirectoryOp;
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

public class filesystemmodel extends Application{
	

	public static Sort Dir; 
	public static Expr Dir_set;
	
	public static Sort File; 
	public static Expr File_set;

	public static TupleSort Reachability;
	

	public List<Operation> op=new ArrayList<Operation>();
	static List<Invariant> inv=new ArrayList<Invariant>();

	//static Sort node;

	public static FuncDecl father,exists ;
	
	
	public static Expr Parent_set;

	
	public static Expr Reachable_set;
	
	public static  Sort Name;
	
	
	
	public static EnumSort type;
	public static Expr type_set;
	
	public static TupleSort Parent;
	public static TupleSort DirNode;
	public static TupleSort FileNode;

	public static Expr DirNode_set;
	public static Expr FileNode_set;
	
	
	public static TupleSort FsObject;
	public static Expr FsObject_set;
	
	public static Expr root;
	public static Expr rootNode; 

	public List<Operation> loadOperations(Context ctx) throws Z3Exception {

	/*	Operation o1=new AddFile("AddFile",ctx);
		Operation o2=new RemoveFile("RemoveFile",ctx);
		Operation o3=new UpdateFile("UpdateFile",ctx);
		Operation o4=new MoveFile("MoveFile",ctx); */
	//	Operation o5=new AddDirectoryOp("AddDirectory",ctx);
	//	Operation o6=new RemoveDirectory("RemoveDirectory",ctx);
	//	Operation o7=new MoveDirectory("MoveDirectory", ctx);
	/*	op.add(o1);
		op.add(o2);
		op.add(o3);
		op.add(o4); */
//		op.add(o5);
	//	op.add(o6);		
	//	op.add(o7);	*/
		return op;
		
	}

	@Override
	public List<Invariant> loadInvariants(Context ctx) throws Z3Exception {
		
		Invariant inv1=new  Reachability("Reachable",ctx);
		Invariant inv2=new NoCycle("Nocylce");
		Invariant inv3=new UniqeName("Uniqness");
		Invariant inv4=new UniqueForRoot("UniqueRoot");
		inv.add(inv1);
		inv.add(inv2);
	    inv.add(inv3);
		inv.add(inv4);
        return inv;
	}
	
	
	@Override
	public void initializeState(Context ctx) throws Z3Exception {
		

	
		Dir = ctx.MkUninterpretedSort("Dir");
		
	    SetSort dd=ctx.MkSetSort(Dir);
	    Dir_set = ctx.MkConst("Dir_set",dd);
	    
	    
		File = ctx.MkUninterpretedSort("Dir");
		
	    SetSort fl=ctx.MkSetSort(File);
	    File_set = ctx.MkConst("File_set",fl);
	    

			
		Symbol FSname = ctx.MkSymbol("type");
		Symbol[] FSargs={ ctx.MkSymbol("Dir"), ctx.MkSymbol("File")} ;
		
		type= ctx.MkEnumSort(FSname, FSargs);
		
		
	    SetSort fo=ctx.MkSetSort(ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject")));
	    FsObject_set = ctx.MkConst("FsObject_set",fo);
	    
	    
	    
	  //  root = ctx.MkConst("root", ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));   
		Name = ctx.MkUninterpretedSort("Name");

	    

	    
	    DirNode= ctx.MkTupleSort(ctx.MkSymbol("mk_DirNode_tuple"), // name of
		  	      new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second") }, // names
		  	      new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject")) , Name} );
	    
	    
  	    
	    SetSort os1=ctx.MkSetSort(DirNode);
	    DirNode_set = ctx.MkConst("DirNode_set",os1);
	    
	    
	    FileNode= ctx.MkTupleSort(ctx.MkSymbol("mk_FileNode_tuple"), // name of
		  	      new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second")}, // names
		  	      new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject"))  , Name} );
	    
	    
	    
	    SetSort os11=ctx.MkSetSort(FileNode);
	    FileNode_set = ctx.MkConst("FileNode_set",os11);

	    
	    root=ctx.MkConst("root", ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject")));
	   
	    Expr[] nodeArgs =  new Expr[2];
	    nodeArgs[0]=root;
	    nodeArgs[1]=ctx.MkConst("root", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
   	 
   	 	rootNode=filesystemmodel.DirNode.MkDecl().Apply(nodeArgs); 
		
    
	   filesystem.Dir_set= ctx.MkSetAdd(filesystem.Dir_set,root);
	    
	    Parent= ctx.MkTupleSort(ctx.MkSymbol("mk_Parent_tuple"), // name of
		  	      new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second") }, // names
		  	      new Sort[] { 	DirNode, ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject"))  } );
	    
	    SetSort ps=ctx.MkSetSort(Parent);
	    Parent_set = ctx.MkConst("Parent_set",ps);
	    
	    
	    Reachability= ctx.MkTupleSort(ctx.MkSymbol("mk_Reachability_tuple"), // name of
		  	      new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second") }, // names
		  	      new Sort[] {  ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject")), ctx.MkBoolSort()  } );
	    
	    SetSort re=ctx.MkSetSort(Reachability);
	    Reachable_set = ctx.MkConst("Reachable_set",re);


	//	father= ctx.MkFuncDecl("father", new Sort[] { DirNode ,FsObject}, ctx.MkBoolSort());
	    exists = ctx.MkFuncDecl("reachable", new Sort[] {  DirNode , ctx.MkUninterpretedSort(ctx.MkSymbol("FsObject"))}, ctx.MkBoolSort());
	    
	    
		
	}
	

	@Override
	public BoolExpr getCompoisteInvariant(Context ctx) throws Z3Exception {
		
		BoolExpr composite=ctx.MkTrue();
		for (Invariant i:inv )
		 composite=	ctx.MkAnd(new BoolExpr []{composite, (BoolExpr) i.getInv(ctx)});		
		return composite;
	}

	
	

}
