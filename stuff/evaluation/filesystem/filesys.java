package evaluation.filesystem;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import com.microsoft.z3.AST;
import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Constructor;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.IntSort;
import com.microsoft.z3.Log;
import com.microsoft.z3.Model;
import com.microsoft.z3.Params;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Status;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Version;
import com.microsoft.z3.Z3Exception;

import evaluation.courseware.courseware;
import evaluation.filesystem.filesystem.TestFailedException;

public class filesys {
	
	
	 @SuppressWarnings("serial")
	    class TestFailedException extends Exception
	    {
	        public TestFailedException()
	        {
	            super("Check FAILED");
	        }
	    };
	
	public static Sort FSObject; 
	
	   // / Shows how to read an SMT2 file.

    void smt2FileTest(String filename) throws Z3Exception
    {
        Date before = new Date();

        System.out.println("SMT2 File test ");
        System.gc();

        {
            HashMap<String, String> cfg = new HashMap<String, String>();
            cfg.put("model", "true");
            Context ctx = new Context(cfg);
            Expr a = ctx.ParseSMTLIB2File(filename, null, null, null, null);

            long t_diff = ((new Date()).getTime() - before.getTime()) / 1000;

            System.out.println("SMT2 file read time: " + t_diff + " sec");
            System.out.println("expr"+a);
            // Iterate over the formula.

            LinkedList<Expr> q = new LinkedList<Expr>();
            q.add(a);
            int cnt = 0;
            while (q.size() > 0)
            {
                AST cur = (AST) q.removeFirst();
                cnt++;

                if (cur.getClass() == Expr.class)
                    if (!(cur.IsVar()))
                        for (Expr c : ((Expr) cur).Args())
                            q.add(c);
        
            }
            System.out.println(cnt + " ASTs");
        }

        long t_diff = ((new Date()).getTime() - before.getTime()) / 1000;
        System.out.println("SMT2 file test took " + t_diff + " sec");
    }
	
    // / Demonstrates how to use the SMTLIB parser.

    public void parserExample1(Context ctx) throws Z3Exception,
            TestFailedException
    {
        System.out.println("ParserExample1");
        Log.Append("ParserExample1");

        ctx.ParseSMTLIB2String(
                "(benchmark tst :extrafuns ((x Int) (y Int)) :formula (> x y) :formula (> x 0))",
                null, null, null, null);
        for (BoolExpr f : ctx.SMTLIBFormulas())
            System.out.println("formula " + f);

        @SuppressWarnings("unused")
        Model m = check(ctx, ctx.MkAnd(ctx.SMTLIBFormulas()),
                Status.SATISFIABLE);
    }

    // / Demonstrates how to initialize the parser symbol table.

    public void parserExample2(Context ctx) throws Z3Exception,
            TestFailedException
    {
        System.out.println("ParserExample2");
        Log.Append("ParserExample2");

        Symbol[] declNames = { ctx.MkSymbol("a"), ctx.MkSymbol("b") };
        FuncDecl a = ctx.MkConstDecl(declNames[0], ctx.MkIntSort());
        FuncDecl b = ctx.MkConstDecl(declNames[1], ctx.MkIntSort());
        FuncDecl[] decls = new FuncDecl[] { a, b };

        ctx.ParseSMTLIB2String("(benchmark tst :formula (> a b))", null, null,
                declNames, decls);
        BoolExpr f = ctx.SMTLIBFormulas()[0];
        System.out.println("formula: " + f);
        check(ctx, f, Status.SATISFIABLE);
    }

    Model check(Context ctx, BoolExpr f, Status sat) throws Z3Exception,
    TestFailedException
{
Solver s = ctx.MkSolver();
s.Assert(f);
if (s.Check() != sat)
    throw new TestFailedException();
if (sat == Status.SATISFIABLE)
    return s.Model();
else
    return null;
}
    // / Demonstrates how to initialize the parser symbol table.

    public void parserExample3(Context ctx) throws Exception
    {
        System.out.println("ParserExample3");
        Log.Append("ParserExample3");

        /* declare function g */
        Sort I = ctx.MkIntSort();
        FuncDecl g = ctx.MkFuncDecl("g", new Sort[] { I, I }, I);

        BoolExpr ca = commAxiom(ctx, g);

        ctx.ParseSMTLIB2String(
                "(benchmark tst :formula (forall (x Int) (y Int) (implies (= x y) (= (gg x 0) (gg 0 y)))))",
                null, null, new Symbol[] { ctx.MkSymbol("gg") },
                new FuncDecl[] { g });

        BoolExpr thm = ctx.SMTLIBFormulas()[0];
        System.out.println("formula: " + thm);
        prove(ctx, thm, false, ca);
    }


    void prove(Context ctx, BoolExpr f, boolean useMBQI) throws Z3Exception,
            TestFailedException
    {
        BoolExpr[] assumptions = new BoolExpr[0];
        prove(ctx, f, useMBQI, assumptions);
    }

    void prove(Context ctx, BoolExpr f, boolean useMBQI,
            BoolExpr... assumptions) throws Z3Exception, TestFailedException
    {
        System.out.println("Proving: " + f);
        Solver s = ctx.MkSolver();
        Params p = ctx.MkParams();
        p.Add("mbqi", useMBQI);
        s.setParameters(p);
        for (BoolExpr a : assumptions)
            s.Assert(a);
        s.Assert(ctx.MkNot(f));
        Status q = s.Check();

        switch (q)
        {
        case UNKNOWN:
            System.out.println("Unknown because: " + s.ReasonUnknown());
            break;
        case SATISFIABLE:
            throw new TestFailedException();
        case UNSATISFIABLE:
            System.out.println("OK, proof: " + s.Proof());
            break;
        }
    }

	public void parserExample4(Context ctx) throws Z3Exception
    {
        System.out.println("ParserExample4");
        Log.Append("ParserExample4");

        ctx.ParseSMTLIB2String(
                "(benchmark tst :extrafuns ((x Int) (y Int)) :assumption (= x 20) :formula (> x y) :formula (> x 0))",
                null, null, null, null);
        for (FuncDecl decl : ctx.SMTLIBDecls())
        {
            System.out.println("Declaration: " + decl);
        }
        for (BoolExpr f : ctx.SMTLIBAssumptions())
        {
            System.out.println("Assumption: " + f);
        }
        for (BoolExpr f : ctx.SMTLIBFormulas())
        {
            System.out.println("Formula: " + f);
        }
    }

    // / Demonstrates how to handle parser errors using Z3 error handling
    // support.

    // / <remarks></remarks>
    public void parserExample5(Context ctx)
    {
        System.out.println("ParserExample5");

        try
        {
            ctx.ParseSMTLIB2String(
                    /*
                     * the following string has a parsing error: missing
                     * parenthesis
                     */
                    "(benchmark tst :extrafuns ((x Int (y Int)) :formula (> x y) :formula (> x 0))",
                    null, null, null, null);
        } catch (Z3Exception e)
        {
            System.out.println("Z3 error: " + e);
        }
    }
    
    
    private BoolExpr commAxiom(Context ctx, FuncDecl f) throws Exception
    {
        Sort t = f.Range();
        Sort[] dom = f.Domain();

        if (dom.length != 2 || !t.equals(dom[0]) || !t.equals(dom[1]))
        {
            System.out.println(Integer.toString(dom.length) + " "
                    + dom[0].toString() + " " + dom[1].toString() + " "
                    + t.toString());
            throw new Exception(
                    "function must be binary, and argument types must be equal to return type");
        }

        String bench = "(benchmark comm :formula (forall (x " + t.Name()
                + ") (y " + t.Name() + ") (= (" + f.Name() + " x y) ("
                + f.Name() + " y x))))";
        ctx.ParseSMTLIBString(bench, new Symbol[] { t.Name() },
                new Sort[] { t }, new Symbol[] { f.Name() },
                new FuncDecl[] { f });
        return ctx.SMTLIBFormulas()[0];
    }
    
    void smt1FileTest(String filename) throws Z3Exception, TestFailedException
    {
        System.out.print("SMT File test ");

        {
            HashMap<String, String> cfg = new HashMap<String, String>();
            Context ctx = new Context(cfg);
            ctx.ParseSMTLIBFile(filename, null, null, null, null);

            BoolExpr a = ctx.MkAnd(ctx.SMTLIBFormulas());
            System.out.println("read formula: " + a);
            Model m =check(ctx, ctx.MkAnd(ctx.SMTLIBFormulas()),
	                Status.SATISFIABLE);
	        System.out.print(m);
        }
    }
    
	public static void main(String [] args) {
		filesys f=new filesys();
        try {
        	
            Context.ToggleWarningMessages(true);
            Log.Open("test.log");

            System.out.print("Z3 Major Version: ");
            System.out.println(Version.Major());
            System.out.print("Z3 Full Version: ");
            System.out.println(Version.getString());
            Context ctx = new Context();
     
            Sort[] userTask = new Sort[2];
            userTask[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
            userTask[0] =ctx.MkIntSort();
            FSObject=ctx.MkUninterpretedSort("FSObject");; 
    		 
    		 FuncDecl father = ctx.MkFuncDecl("father", new Sort[] { FSObject ,FSObject}, ctx.MkBoolSort());
    		 
    		 
    		 FuncDecl exists = ctx.MkFuncDecl("reachable", new Sort[] { ctx.MkIntSort(), FSObject ,FSObject}, ctx.MkBoolSort());
    		 
    		 
    		 IntSort[] tTask =  new IntSort[1];
    		 int i;
    		 tTask[0] =ctx.MkIntSort();
    		 
    		 Symbol[] Tnames = new Symbol[1];
    		 Tnames[0] =  ctx.MkSymbol("i");
    		 
    		 Expr t1 = ctx.MkConst("t1", ctx.MkUninterpretedSort(ctx.MkSymbol("IntSort")));
    		 
    		 Expr t2= ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
    		 Expr t6= ctx.MkConst("node2", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
    		 
    	//	 Expr mt1t3 = ctx.MkApp(assignUser, t1);
    		 IntExpr   capacity=(IntExpr) ctx.MkConst("i", ctx.IntSort());
    		   
    		 
    		 Expr mt1t3=ctx.MkLt(capacity, ctx.MkInt(1));
    		 
    		 Expr[] t =  new Expr[3];
    		 t[1]=t2;
    		 t[2]=t6;
    		 t[0]=capacity;
    		 
    		 Expr mt1t2=ctx.MkApp(exists, t);
    		 
    		 Expr tbody2= ctx.MkImplies((BoolExpr) mt1t3, ctx.MkNot((BoolExpr) mt1t2));  
    		 
    		 
    		 Expr tra = ctx.MkForall(tTask, Tnames, tbody2, 1, null, null,null, null);
    		 
    		 
    		 System.out.println("hereee"+tra);
    		 
    		 Sort[] nodes =  new Sort[2];
    
    		 nodes[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
    		 nodes[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
    		 
    		 
    		 Symbol[] nnames = new Symbol[2];
    		 nnames[0] =  ctx.MkSymbol("node1");
    		 nnames[1] =  ctx.MkSymbol("node2");		 
    		 
    		 Expr[] t4 =  new Expr[3];
    		 t4[1]=t2;
    		 t4[2]=t6;
    		 t4[0]=ctx.MkInt("1");
    		 
    		 
    		 Expr[] fa =  new Expr[2];
    		 fa[0]=t2;
    		 fa[1]=t6;

    		 
    		 Expr tbody= ctx.MkApp(father, fa)  ; 
    		 
    		
    				 
    		//     Expr base= ctx.MkExists(tTask, Tnames, tbody, 1, null, null,null, null);
    		 Expr base=ctx.MkApp(exists, t4)  ;;
    		     
    		    Expr bas1=ctx.MkEq(base,tbody);
    		     
    		     Expr tra2 = ctx.MkForall(nodes, nnames, bas1, 1, null, null,null, null);
    		     
    		     System.out.println("\n\n\n");  
    		     
    		     System.out.println("hereee222"+tra2);
    		     

    		    		 
    		Sort[] nodesr =  new Sort[3];
    
    		nodesr[0] =ctx.MkIntSort();
    	   nodesr[1]	=	 ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
    	   nodesr[2]	=	 ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
    		 
    		 Symbol[] nnamesr = new Symbol[3];
    		 nnamesr[0] = ctx.MkSymbol("i");
    		 nnamesr[1]=		 ctx.MkSymbol("node1");
    		 nnamesr[2]=		 ctx.MkSymbol("node2");
    		 
    		 
    		 Expr mt1t5=ctx.MkGt(capacity, ctx.MkInt(1));
    		 
    		  
    		 
    		 Expr ip=ctx.MkConst("i", ctx.IntSort());

     		 t4[0]= ip;
     		 
     		 
     		  tbody= ctx.MkApp(exists, t4)  ; 
     		  Expr yyy=tbody;
     		  
     		 t4[0]=ctx.MkSub(new ArithExpr[]  { (ArithExpr) ip, ctx.MkInt(1) });
     		  
     		  tbody2= ctx.MkApp(exists, t4)  ; 
    		 
     		  t4[2]=ctx.MkConst("node3", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
     		// t4[2]=nodes[0];
     		tbody= ctx.MkApp(exists, t4)  ; 
     		

     		 Expr[] fa2 =  new Expr[2];
    		 fa2[0]=t2;
    		 fa2[1]=t6;

 		
   		      Sort[] nodesw =  new Sort[1];
   	    
   	     	 nodesw[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));
   		 
   	     	 Symbol[] nnamesw = new Symbol[1];
   		     nnamesw[0] =  ctx.MkSymbol("node3");
   		    
   		
   	 
		 Expr[] fa3 =  new Expr[2];
		 fa3[0]=ctx.MkConst("node3", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
		 fa3[1]=t6;

		 
		  Expr fathert= ctx.MkApp(father, fa3)  ; 
   		
   		
     		
   			Expr r=ctx.MkAnd(new BoolExpr[] { (BoolExpr) tbody,(BoolExpr) fathert} );
   			
   			
   		     
     		
     		  Expr based= ctx.MkExists(nodesw, nnamesw, r, 1, null, null,null, null); 
     		 
     		 base=ctx.MkOr(new BoolExpr[] { (BoolExpr) tbody2, (BoolExpr) based} );
    		  
     		 BoolExpr bas0=ctx.MkEq(yyy, base);
    		 
    		 Expr bas2=ctx.MkImplies((BoolExpr) mt1t5, bas0)	; 
    		 
    		 
    		 
    		 
    	 Expr tra3 = ctx.MkForall(nodesr, nnamesr, bas2, 1, null, null,null, null);
    	 
    	 System.out.println("\n\n\n");  
		 System.out.println("final"+tra3);     
	      
		 
		 
		 FuncDecl succ = ctx.MkFuncDecl("succ", new Sort[] { ctx.MkIntSort()}, ctx.MkIntSort());
		 
		 
		IntExpr gg= (IntExpr) ctx.MkConst("i", ctx.IntSort());
		IntExpr n= (IntExpr) ctx.MkConst("n", ctx.IntSort());
		 
		 Expr[] args2 =  new Expr[1];
		 args2[0]=ctx.MkInt("0");
			
		 
		 Expr ecc=ctx.MkApp(succ, args2);
		 
		 Expr u= ctx.MkAdd(new ArithExpr [] {(ArithExpr) ecc, ctx.MkInt("1")});
		 
		 
		// Expr tbody25= ctx.MkImplies((BoolExpr) ctx.MkEq(n, ctx.MkInt("1")), (BoolExpr) u ); 
		 
		 
		 
		 
		 Expr[] args22 =  new Expr[2];
		 args22[0]=ctx.MkSub(new ArithExpr [] {n, ctx.MkInt("1")});
		 
		 Expr ecc2=ctx.MkApp(succ, args22);
		 Expr g2=ctx.MkAdd(new ArithExpr [] {(ArithExpr) ecc2, ctx.MkInt("1")});
		 
		// Expr tbody252= ctx.MkImplies((BoolExpr) ctx.MkGt(n, ctx.MkInt("1")), (BoolExpr) g2 );  
		 
		 
		// ctx.MkITE((BoolExpr) ctx.MkEq(n, ctx.MkInt("1")), u, ctx.MkITE(BoolExpr) ctx.MkGt(n, ctx.MkInt("1")), g2, arg2));

		// System.out.println("hereeee"+tbody252);
		 
		// System.out.println("hereeee"+tbody25);
		 
		 
		 
		 f.smt2FileTest("/Users/najafzad/Documents/workspace-static/StaticTool/foo.smt2");
		 
		 
		  System.out.println("ParserExample1");
	        Log.Append("ParserExample1");

	        ctx.ParseSMTLIBString(
	                "(benchmark tst :extrafuns ((x Int) (y Int)) :formula (> x y) :formula (> x 0))",
	                null, null, null, null);
	        for (BoolExpr f56 : ctx.SMTLIBFormulas())
	            System.out.println("formula " + f56);
	        
	        @SuppressWarnings("unused")
	        Model m = f.check(ctx, ctx.MkAnd(ctx.SMTLIBFormulas()),
	                Status.SATISFIABLE);
	        System.out.print(m);
	        
           Log.Close();
           if (Log.isOpen())
               System.out.println("Log is still open!");
    } catch (Z3Exception ex) {
        System.out.println("Z3 Managed Exception: " + ex.getMessage());
        System.out.println("Stack trace: ");
        ex.printStackTrace(System.out);
    } catch (Exception ex) {
        System.out.println("Unknown Exception: " + ex.getMessage());
        System.out.println("Stack trace: ");
        ex.printStackTrace(System.out);
      
    }
		
	}

}
