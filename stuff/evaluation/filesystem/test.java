package evaluation.filesystem;

import java.util.LinkedList;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Log;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Version;
import com.microsoft.z3.Z3Exception;

import evaluation.courseware.courseware;
import evaluation.filesystem.Node.Tree;

public class test {

	
	public class Node {

		public int value;
		public Tree child; 
		public Node next; 
		public Node father;
		
		Node (Node father) {
			this.father=father;
			
		}
		
	}	
     
	public class Tree {
			
	    public int count ;
	    public int isfile;
		public  Node child_list; 
			

   }
		
		
	public static void main(String [] args) {
		test t=new test ();
		
		  try {
	            Context.ToggleWarningMessages(true);
	            Log.Open("test.log");

	            System.out.print("Z3 Major Version: ");
	            System.out.println(Version.Major());
	            System.out.print("Z3 Full Version: ");
	            System.out.println(Version.getString());
	            Context ctx = new Context();

	            
	            System.out.println("hey"+t.n.father);
	            
	            Expr e=t.find( t.n,t.root, ctx);
	            System.out.println("g"+e);

		       
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
	
	int count_inc;
	Node root=new Node(null);
    Node n=new Node(root);



	int find_node(Tree tree, int value)
	//@ requires sbtree*(tree) /\ ~(tree = nil)
	/*@ ensures  sbtree*(tree) /\ ~(tree = nil)
	             /\ tkeys*(tree) = tkeys*(old(tree)) /\ th*(tree) = th*(old(tree))
	             /\ result = in(value, tkeys*(tree)) */
	{
	  return find_list(tree.child_list, value);
	}
	
	
	int find_list(Node node, int value) 
	//@ requires sbtree_list*(node, isleaf) /\ ~(node = nil)
	/*@ ensures  sbtree_list*(node, isleaf) /\ ~(l = nil)
	             /\ lkeys*(node) = lkeys*(old(node)) /\ lh*(node) = lh*(old(node))
	             /\ len*(node) = len*(old(node))
	             /\ result = in(value, lkeys*(node)) */
	{
	  if (node.next != null && value !=node.next.value)
	    return find_list(node.next, value);
	  else if (node.next != null && node.value == value)
	    return 1;
	  else if (node.child == null)
	    return 0;
	  else
	    return find_node(node.child, value);
	}
	
	
	Expr find(Node node,Node root, Context ctx) throws Z3Exception  {

		System.out.println("hey");
		if (node==root)
			return(ctx.MkTrue());
		else 
			return(find(node.father,root, ctx));
  
	}
	
	
	//Expr findParent(Node node, Context ctx) {
   //    return (ctx.MkITE(ctx.MkBool(node==root), true, find(node,ctx)));
	//}
	
	public Expr effect_G(Context ctx) throws Z3Exception {
		
		Sort[] sStudent =  new Sort[1];
		sStudent[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Student"));
	//	sStudent[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("Student"));
		 
		Symbol[] sNames = new Symbol[1];
	//	sNames[0] =   ctx.MkSymbol("student");
		sNames[0] =   ctx.MkSymbol("student1");
		 
	//	Expr student = ctx.MkConst("student", sStudent[0]);
		Expr student1 = ctx.MkConst("student1", sStudent[0]);
		   
		Expr e2=ctx.MkSetMembership(student1,courseware.Student_set);
		
		courseware.Student_set=ctx.MkSetAdd(courseware.Student_set,student);
		
		 
		Expr e3=ctx.MkDistinct(new Expr[]{student,student1});
		Expr e4=ctx.MkAnd(new BoolExpr[]{(BoolExpr) e3,ctx.MkNot((BoolExpr) ctx.MkSetMembership(student1,courseware.Student_set))});
		 
	    Expr e5=ctx.MkImplies(ctx.MkNot((BoolExpr) e2), (BoolExpr) e4);
		 
		Expr e6=(BoolExpr) ctx.MkSetMembership(student1,courseware.Student_set);
		 
		Expr cBody=ctx.MkAnd(new BoolExpr[]{(BoolExpr) e5,(BoolExpr) e6});
	
	    System .out.println("add effect"+cBody);
		Expr tra = ctx.MkForall(sStudent, sNames, e5, 1, null, null,null, null);
		
		System .out.println("add effect"+tra);
		return tra;
	}
	
	@Override
	public Expr effect_G(Context ctx) throws Z3Exception {
		this.capacity=(IntExpr) ctx.MkAdd(new ArithExpr[] { this.capacity, ctx.MkInt(1) });
		courseware.capacity.put(course, this.capacity);
	/*	Expr course = ctx.MkConst("c", Course);
		Expr student = ctx.MkConst("s", Student);	
        LinkedList<Pair<IntExpr, IntExpr>> aex;
        Pair<Expr, Expr> pair = Pair.createPair(course, student);
        enroll.remove(pair); */
	//	course = ctx.MkConst("course", ctx.MkUninterpretedSort(ctx.MkSymbol("Course")));
	//	student = ctx.MkConst("student", ctx.MkUninterpretedSort(ctx.MkSymbol("Student")));	
        Expr[] arg = new Expr[2];
		arg[0]=course;
		arg[1]=student;
        Expr ee = ctx.MkApp(courseware.mkpair.ConstructorDecl(), arg);
	    courseware.Enroll_set = ctx.MkSetDel(courseware.Enroll_set,ee);
        return ctx.MkNot((BoolExpr) ctx.MkSetMembership(ee, courseware.Enroll_set));	
	}

	
	@Override
	public Expr effect_G(Context ctx) throws Z3Exception {
		courseware.Course_set= ctx.MkSetAdd(courseware.Course_set,course);
		return ctx.MkSetMembership(course,courseware.Course_set);
	}
	
	public BoolExpr precondition(Context ctx) throws Z3Exception {
	//  student = ctx.MkConst("student", ctx.MkUninterpretedSort(ctx.MkSymbol("Student")));	
	    return (ctx.MkNot((BoolExpr) ctx.MkSetMembership(this.student,courseware.Student_set )));
	}
    
	
	@Override
	public Expr effect_G(Context ctx) throws Z3Exception {

		Sort[] cCourse =  new Sort[2];
		cCourse[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Course"));
		cCourse[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("Course"));
		 
		Symbol[] cNames = new Symbol[2];
		cNames[0] =   ctx.MkSymbol("course");
		cNames[1] =   ctx.MkSymbol("course1");
		
		Sort[] sStudent =  new Sort[2];
		sStudent[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Student"));
		sStudent[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("Student"));
		 
		Symbol[] sNames = new Symbol[2];
		sNames[0] =   ctx.MkSymbol("student");
		sNames[1] =   ctx.MkSymbol("student1");
		
		
		//Expr student = ctx.MkConst("student", sStudent[0]);
		Expr student1 = ctx.MkConst("student1", sStudent[1]);
		
	//	Expr course = ctx.MkConst("course", cCourse[0]);
		Expr course1 = ctx.MkConst("course1", cCourse[0]);
		   
		courseware.capacity.put(course1, (IntExpr) ctx.MkConst("capacity", ctx.IntSort()));
	//	courseware.capacity.put(course, (IntExpr) ctx.MkConst("capacity", ctx.IntSort()));
		
		Expr e1=ctx.MkNot((BoolExpr) ctx.MkSetMembership(student1,courseware.Student_set));
		Expr e2=ctx.MkNot((BoolExpr) ctx.MkSetMembership(course1,courseware.Course_set));
		
		
		BoolExpr pre1=ctx.MkGe(courseware.capacity.get(course1), ctx.MkInt("1"));
		
        Expr[] arg = new Expr[2];
		arg[0]=course;
		arg[1]=student;		
        Expr ee = ctx.MkApp(courseware.mkpair.ConstructorDecl(), arg);
        courseware.Enroll_set= ctx.MkSetAdd(courseware.Enroll_set,ee);
       
        this.capacity= (IntExpr) ctx.MkSub(new ArithExpr[] { (ArithExpr) courseware.capacity.get(this.course), ctx.MkInt(1) });
        courseware.capacity.put(this.course, this.capacity);
        
	  //   ctx.MkSetMembership(ee, courseware.Enroll_set) ;
        BoolExpr pre2=ctx.MkGe(courseware.capacity.get(course1), ctx.MkInt("1"));
		
      // courseware.capacity.put(this.course, (IntExpr) ctx.MkSub(new ArithExpr[] { (ArithExpr) courseware.capacity.get(this.course), ctx.MkInt(1) }));
        
	/*	FuncDecl ee = ctx.MkFuncDecl("Enroll", new Sort[] { Course, Student }, ctx.MkBoolSort());
		Expr course = ctx.MkConst("c", Course);
		Expr student = ctx.MkConst("s", Student);		
		Expr[] arg = new Expr[2];
		arg[0]=course;
		arg[1]=student;
        Expr mkEnroll=ctx.MkApp(ee,arg);
	//	e.put(course, student);
	    Pair<Expr, Expr> pair = Pair.createPair(course, student);	 
	    enroll.add(pair);	 */	    
	//	course = ctx.MkConst("course", ctx.MkUninterpretedSort(ctx.MkSymbol("Course")));
	//	student = ctx.MkConst("student", ctx.MkUninterpretedSort(ctx.MkSymbol("Student")));	

	
		 
		Expr e31=ctx.MkDistinct(new Expr[]{course,course1});
		Expr e32=ctx.MkDistinct(new Expr[]{student,student1});
		
		Expr e12=ctx.MkNot((BoolExpr) ctx.MkSetMembership(student1,courseware.Student_set));
		Expr e22=ctx.MkNot((BoolExpr) ctx.MkSetMembership(course1,courseware.Course_set));
		
		
		Expr e4=ctx.MkAnd(new BoolExpr[]{ ctx.MkAnd(new BoolExpr[]{(BoolExpr) e12,(BoolExpr) e22,pre2}),ctx.MkAnd(new BoolExpr[]{(BoolExpr) e31,(BoolExpr) e32})});
		 
	    Expr e5=ctx.MkImplies(ctx.MkAnd(new BoolExpr[]{(BoolExpr) e1,(BoolExpr) e2,pre1}), (BoolExpr) e4);
		 
	//	Expr e6=ctx.MkNot((BoolExpr) ctx.MkSetMembership(course1,courseware.Course_set));
		 
	//	Expr cBody=ctx.MkAnd(new BoolExpr[]{(BoolExpr) e5,(BoolExpr) e6});
	
	//    System .out.println("remove effect"+cBody);
		Expr tra = ctx.MkForall(cCourse, cNames, e5, 1, null, null,null, null);
		
		System .out.println("enroll effect"+tra);
		return tra;
		
		
	}
	
	
	public Expr effect_G(Context ctx) throws Z3Exception {
		
		Sort[] cCourse =  new Sort[2];
		cCourse[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Course"));
		cCourse[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("Course"));
		 
		Symbol[] cNames = new Symbol[2];
		cNames[0] =   ctx.MkSymbol("course");
		cNames[1] =   ctx.MkSymbol("course1");
		 
		Expr course = ctx.MkConst("course", cCourse[0]);
		Expr course1 = ctx.MkConst("course1", cCourse[0]);
		   
		Expr e2=ctx.MkSetMembership(course,courseware.Course_set);
		courseware.Course_set=ctx.MkSetDel(courseware.Course_set,course1);
		
		 
		Expr e3=ctx.MkDistinct(new Expr[]{course,course1});
		Expr e4=ctx.MkAnd(new BoolExpr[]{(BoolExpr) e3,(BoolExpr) ctx.MkSetMembership(course,courseware.Course_set)});
		 
	    Expr e5=ctx.MkImplies((BoolExpr) e2, (BoolExpr) e4);
		 
		Expr e6=ctx.MkNot((BoolExpr) ctx.MkSetMembership(course1,courseware.Course_set));
		 
		Expr cBody=ctx.MkAnd(new BoolExpr[]{(BoolExpr) e5,(BoolExpr) e6});
	
	    System .out.println("remove effect"+cBody);
		Expr tra = ctx.MkForall(cCourse, cNames, e5, 1, null, null,null, null);
		
		System .out.println("remove effect"+tra);
		return tra;
	}
	
	public Expr effect_G(Context ctx) throws Z3Exception {
		
		Sort[] sStudent =  new Sort[2];
		sStudent[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Student"));
		sStudent[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("Student"));
		 
		Symbol[] sNames = new Symbol[2];
		sNames[0] =   ctx.MkSymbol("student");
		sNames[1] =   ctx.MkSymbol("student1");
		 
		Expr student = ctx.MkConst("student", sStudent[0]);
		Expr student1 = ctx.MkConst("student1", sStudent[1]);
		   
		Expr e2=ctx.MkSetMembership(this.student,courseware.Student_set);
		courseware.Student_set=ctx.MkSetDel(courseware.Student_set,student1);
		
		 
		Expr e3=ctx.MkDistinct(new Expr[]{student,student1});
		Expr e4=ctx.MkAnd(new BoolExpr[]{(BoolExpr) e3,(BoolExpr) ctx.MkSetMembership(student,courseware.Student_set)});
		 
	    Expr e5=ctx.MkImplies((BoolExpr) e2, (BoolExpr) e4);
		 
		Expr e6=ctx.MkNot((BoolExpr) ctx.MkSetMembership(student1,courseware.Student_set));
		 
		Expr cBody=ctx.MkAnd(new BoolExpr[]{(BoolExpr) e5,(BoolExpr) e6});
	
	    System .out.println("remove effect"+cBody);
		Expr tra = ctx.MkForall(sStudent, sNames, e5, 1, null, null,null, null);
		
		System .out.println("remove effect"+tra);
		return tra;
	}

    
    BoolExpr I= (BoolExpr) invariants.get(0).getInv(ctx);	
    BoolExpr preOld2= app.preCondition(ctx, concurrentOps.get(k));
    
	 BoolExpr exprOld=ctx.MkAnd(new BoolExpr[] { preOld,I,preOld2});	
	 
    
    
    System.out.println("applying shadowOp"+concurrentOps.get(k).effect(ctx)); 	
    System.out.println("applying op"+op.get(i).effect(ctx)); 	
	 BoolExpr preNew=app.preCondition(ctx, op.get(i));
	 System.out.println("precondition after receiving shadowOp:"+preNew);
    
	 BoolExpr I2= (BoolExpr) invariants.get(0).getInv(ctx);	
	 
//	 BoolExpr exprNew=ctx.MkAnd(new BoolExpr[] { preNew,I2});	
	 
	 BoolExpr correct=ctx.MkImplies(exprOld,I2);	
	 
	 
	
	
}
