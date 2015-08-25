package evaluation.filesystem.invariant;

import java.util.Random;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.IntSort;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Status;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Version;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import evaluation.courseware.courseware;
import evaluation.filesystem.filesystem;
import invariant.Invariant;

public class ReachabilityInv implements Invariant {

	private String name; 
	public ReachabilityInv(String string, Context ctx) {
		
	}

	@Override
	public String getName() {
		return name;
	}

	public Expr reachable(Context ctx) throws Z3Exception{
		
		 
	filesystem f=new  filesystem();
		f.initializeState(ctx);
	//	 Expr n1= ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
		
		 Expr nodeID=ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
		
    	 Expr[] nodeArgs =  new Expr[3];
    	 nodeArgs[0]=nodeID;
    	 nodeArgs[1]=ctx.MkConst("type", filesystem.type);
    	 nodeArgs[2]=ctx.MkConst("name", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
    	 
    //	 Expr node=filesystem.Node.MkDecl().Apply(nodeArgs);	
    	 
		 Expr root=filesystem.root;

	 //    
		Expr[] fatherindex =  new Expr[2];
    	fatherindex[0]=root;
		fatherindex[1]=nodeID;

		// Expr father= ctx.MkApp(filesystem.Parent, fatherindex)  ; 
	    Expr parentTuple=filesystem.Parent.MkDecl().Apply(fatherindex);
	     
	//	 Expr baseBody=ctx.MkEq(base,ctx.MkSetMembership(parentTuple, filesystem.Parent_set));
	  
         Sort[] indexbase = new Sort[1];
         indexbase[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));
         
		 Symbol[] indexBNames = new Symbol[1];
		 indexBNames[0] =  ctx.MkSymbol("dir3");
		 
		 Sort[] nodesr =  new Sort[1];
		    
    	 nodesr[0]	=	 ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
  
    		 
    	 Symbol[] nnamesr = new Symbol[1];
    //	 nnamesr[0] = ctx.MkSymbol("i");
    	 nnamesr[0]=ctx.MkSymbol("node1");

    		 
    	// Expr finalExpr=ctx.MkGt(i, ctx.MkInt(1));    		 
     		 
    //	 Expr ip=i;

 	 	Random bi=new Random();
    	// 	int i=bi.nextInt();	   	 	  
     	  	 
    	 Sort[] nodesw =  new Sort[1];
    	   	    
   	     nodesw[0] = ctx.MkUninterpretedSort(ctx.MkSymbol("Dir"));
   		 
   	     Symbol[] nnamesw = new Symbol[1];
   		 nnamesw[0] =  ctx.MkSymbol("dir3");
   		 
     	 
     	 Expr[] father23 =  new Expr[3];
     	 father23[0]=ctx.MkConst(ctx.MkSymbol("dir3"), ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
     	 father23[1]=filesystem.type.Consts()[0]; 
      	father23[2]=ctx.MkConst("name3", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));
     	 
     	 Expr parentTuple23=filesystem.Node.MkDecl().Apply(father23);
     	 
     		  
     	 Expr[] finalArgs =  new Expr[2];
     	 finalArgs[0]=root;
     	 finalArgs[1]=ctx.MkConst(ctx.MkSymbol("dir3"), filesystem.Dir);
     		
     	 Expr tbody= ctx.MkApp(filesystem.exists, finalArgs)  ; 
     	 
     	 
  	    Expr[] arg= new Expr[3];
  	    arg[0]=ctx.MkConst(ctx.MkSymbol("dir3"), filesystem.Dir);
  	    arg[1]=root;
  	    arg[2]=tbody;	
  		Expr parentTuple3=filesystem.Reachability.MkDecl().Apply(arg);
  
     	 
     	Expr rr=(BoolExpr) ctx.MkSetMembership(parentTuple3, filesystem.Reachable_set);
 

     	
     	 Expr[] father2 =  new Expr[2];
     	 father2[0]=ctx.MkConst(ctx.MkSymbol("dir3"), filesystem.Dir);
     	 father2[1]=nodeID;
     		

     	 Expr parentTuple2=filesystem.Parent.MkDecl().Apply(father2);


     		  
   		 Expr r=ctx.MkAnd(new BoolExpr[] { (BoolExpr) rr,(BoolExpr) ctx.MkSetMembership(parentTuple2, filesystem.Parent_set)} );

    	 Expr based= ctx.MkExists(nodesw, nnamesw, r, 1, null, null,null,null); 
    	 
   // 	 ctx.MkExists(new Expr[] { father2[0] },  r);
   	 
		// Expr[] exArgs =  new Expr[2];
		// exArgs[0]=ctx.MkSub(new ArithExpr[]  { (ArithExpr) i, ctx.MkInt(1) });
		// exArgs[0]=n1;
		// exArgs[1]=n2;
		   
		 //Expr tbody2= ctx.MkApp(filesystem.exists, exArgs)  ; 
   
       //  base=ctx.MkOr(new BoolExpr[] { (BoolExpr) tbody2, (BoolExpr) based} );
     		 
    // 	 Expr[] exArg3s =  new Expr[2];
      //   exArg3s[0]=i;
    //	 exArg3s[0]=n1;
   // 	 exArg3s[1]=n2;

    	// Expr yyy= ctx.MkApp(filesystem.exists, exArg3s)  ; 
    		  
     	// BoolExpr bas0=ctx.MkEq(yyy, base);
    		 
    //	 Expr bas2=ctx.MkImplies((BoolExpr) finalExpr, bas0)	;
    	 
    //	 Expr main=ctx.MkAnd(new BoolExpr[] {(BoolExpr) bas2,(BoolExpr) baseBody, (BoolExpr) rbody });
    	 

	    
    	 
    	Expr main=ctx.MkOr(new BoolExpr[]{ (BoolExpr) ctx.MkSetMembership(parentTuple, filesystem.Parent_set),
    			 (BoolExpr) based 	   });
    	 
    	 
    	
    		
    	 Expr expr=ctx.MkImplies( (BoolExpr) ctx.MkSetMembership(nodeArgs[0], filesystem.FSObject_set), (BoolExpr)main);

    	 
    	// Expr p= ctx.MkITE((BoolExpr) ctx.MkSetMembership(nodeArgs[0], filesystem.FSObject_set), (BoolExpr)main, (BoolExpr)ctx.MkTrue());
    	 Expr ancestor = ctx.MkForall(nodesr, nnamesr, expr, 1, null, null,null, null);
    	    	 
    	
    	 
         Expr  dirId=ctx.MkConst(ctx.MkSymbol("dir"), ctx.MkUninterpretedSort(ctx.MkSymbol("Dir")));
    	 Expr[] finalArgs1 =  new Expr[2];
    	 finalArgs1[0]=filesystem.root;
    	 finalArgs1[1]=dirId;
    		
    	 Expr tbody1= ctx.MkApp(filesystem.exists, finalArgs1)  ; 
   	 
	     Expr[] arg1= new Expr[3];
	     arg1[0]=dirId;
	     arg1[1]=filesystem.root;	
	     arg1[2]=tbody1;
		 Expr reachTuple=filesystem.Reachability.MkDecl().Apply(arg1);
		 filesystem.Reachable_set= ctx.MkSetAdd(filesystem.Reachable_set, reachTuple); 
		    Expr[] argParent= new Expr[2];
		    argParent[0]=dirId;
		    argParent[1]=ctx.MkConst(ctx.MkSymbol("file"), ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));	
			Expr parentTuple1=filesystem.Parent.MkDecl().Apply(argParent);
			filesystem.Parent_set= ctx.MkSetAdd(filesystem.Parent_set,parentTuple1);  
			
			Expr node=ctx.MkConst(ctx.MkSymbol("file"), ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));

			filesystem.FSObject_set= ctx.MkSetAdd(filesystem.FSObject_set,node);  
	 	  	 
		  //	 ReachabilityInv r1=new ReachabilityInv("", ctx);
	      //   System.out.println("here"+r1.getInv(ctx));
			
			
	    	 Expr expr1=ctx.MkImplies( (BoolExpr) ctx.MkSetMembership(nodeArgs[0], filesystem.FSObject_set), (BoolExpr)main);

	    	 
	     	// Expr p= ctx.MkITE((BoolExpr) ctx.MkSetMembership(nodeArgs[0], filesystem.FSObject_set), (BoolExpr)main, (BoolExpr)ctx.MkTrue());
	     	 Expr ancestor1 = ctx.MkForall(nodesr, nnamesr, expr, 1, null, null,null, null);
	         
	       Expr correct=ctx.MkImplies((BoolExpr) ancestor,(BoolExpr) ancestor1 );
    	 
	//	 System.out.println("reachability invariant:"+ancestor); 
	       
	     return correct;
		 
		
	}
	


	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		// TODO Auto-generated method stub
		return (BoolExpr) reachable(ctx);
	}


	public static void main (String [] args) throws Z3Exception {
		
		

		 System.out.print("Z3 Major Version: ");
         System.out.println(Version.Major());
         System.out.print("Z3 Full Version: ");
         System.out.println(Version.getString());
         Context ctx = new Context();
 	  	 

    //
	    
		
		//filesystem d=new filesystem();
		//d.initializeState(ctx);
		
	  	 ReachabilityInv r=new ReachabilityInv("", ctx);
	  //	 d.loadInvariants(ctx);
	    Expr correct=	r.getInv(ctx);
		

	         
	       System.out.println("formula"+correct); 
	 	       
		       Solver s = ctx.MkSolver();
		       

	           s.Assert(ctx.MkNot((BoolExpr) correct));
               Status status=s.Check();
            
               System.out.println("result"+status);
     
         
    //     System.out.println(r.fg(ctx, filesystem.Parent_set, filesystem.root));
		
		
	}
}
