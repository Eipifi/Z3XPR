package evaluation.courseware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import invariant.Invariant;
import token.ExclusiveToken;
import token.SharedToken;
import token.TokenObj;
import token.Token;
import analyzer.Pair;
import application.Application;
import application.Operation;

import com.microsoft.z3.*;

import evaluation.courseware.invariant.BoundedInv;
import evaluation.courseware.invariant.ForeignInv;
import evaluation.courseware.invariant.UniqneInv;
import evaluation.courseware.operations.AddCourse;
import evaluation.courseware.operations.AddStudent;
import evaluation.courseware.operations.Disenroll;
import evaluation.courseware.operations.Enroll;
import evaluation.courseware.operations.RemoveCourse;
import evaluation.courseware.operations.RemoveStudent;


/**
 *  Model a courseware applicatio system.
 *  Each  student registers in the system 
 *   and she can enroll or dis-enroll in courses.
 *   The list of courses is updated by 
 *   adding a new course or removing an existing course.
 *   There are global invariants that must be preserved. 
 *   Constraint I1 is a simple bounded constraint on course;
 *   it states that the number of students enrolled in 
 *   a course must not exceed its capacity.
 *   Constraint I2 is a unique key constraint,
 *   stating that students should have unique identifiers.
 *   Invariant I3 implies the referential constraint, stating 
 *   students must be enrolled in an existing course.
 * 
 * @author Najafzadeh
 *
 */
public  class courseware extends Application {
	
	public static Sort Student; 
	public static Sort Course;
	public static Expr Student_set;
	public static Expr Course_set;
	public static SetSort ss;
	public static LinkedList<Pair<Expr,Expr>> enroll;
	public static DatatypeSort pair;
	public static Expr Enroll_set;  
	public static Constructor mkpair;
	public static Constructor mkpair2;
	public static Map<String, Operation> opList=new HashMap();
	public static List<Operation> op=new ArrayList<Operation>();
	public static List<Invariant> inv=new ArrayList<Invariant>();
    public static Sort array_type ;
    public static ArrayExpr capacityArray;
    
	public static DatatypeSort nat;
	
	 public static Sort array_type2 ;
	 public static ArrayExpr capacityArray2;
    
    /**
     * The constructor initializes the application with adding operations and invariants
     */
    public  courseware() {
	    		 
    }
    
	public  List<Operation> loadOperations(Context ctx) throws Z3Exception {
		
		Operation o1=new AddStudent("AddStudent",ctx);
		Operation o2=new AddCourse("AddCourse",ctx);
		Operation o3=new Enroll("Enroll",ctx);
		Operation o4=new RemoveStudent("RemoveStudent",ctx);
		Operation o5=new RemoveCourse("RemoveCourse",ctx);
		Operation o6=new Disenroll("Disenroll",ctx);
		op.add(o1);
		op.add(o2);
		op.add(o3);
		op.add(o4);
		op.add(o5);
		op.add(o6);	
		
		return op;
	}

	public List<Invariant> loadInvariants(Context ctx) throws Z3Exception  {
		Invariant inv1=new BoundedInv("bounded");
		Invariant inv2=new ForeignInv("referential");
        inv.add(inv1);
        inv.add(inv2);
        return inv;
	}
		
	public void initializeState(Context ctx) throws Z3Exception {
		
	    Student = ctx.MkUninterpretedSort("Student");
	    Course = ctx.MkUninterpretedSort("Course");
	   // capacity=(IntExpr) ctx.MkConst("capacity", ctx.IntSort());	    
	    ss=ctx.MkSetSort(Student);
		SetSort cc=ctx.MkSetSort(Course);
	    Student_set = ctx.MkConst("Student_set",ss);
	    Course_set = ctx.MkConst("Course_set",cc);
		//enroll=new LinkedList<Pair<Expr,Expr>>();
	    String[] argnames = new String[]{"first","second"};
	    Sort[] argsorts = new Sort[]{ ctx.MkUninterpretedSort(ctx.MkSymbol("Course")),  ctx.MkUninterpretedSort(ctx.MkSymbol("Student"))};
	    mkpair = ctx.MkConstructor("mkpair", "ispair", argnames, argsorts, null);
	    Constructor[] cons=new Constructor[]{mkpair};
	    DatatypeSort pair = ctx.MkDatatypeSort("pair", cons);
	    SetSort setOfPairs = ctx.MkSetSort(pair);
	    Enroll_set=ctx.MkConst("Enroll_set", setOfPairs);
 
        array_type = ctx.MkArraySort(ctx.MkIntSort(), ctx.MkIntSort());
        ctx.MkBound(1, array_type);
        capacityArray = (ArrayExpr) ctx.MkConst("capacityArray", array_type);  
        
        array_type2 = ctx.MkArraySort(ctx.MkIntSort(), ctx.MkBitVecSort(32));
        capacityArray2 = (ArrayExpr) ctx.MkConst("capacityArray", array_type2);
	    
	}

	@Override
	public BoolExpr getCompoisteInvariant(Context ctx) throws Z3Exception {
		
		BoolExpr composite=ctx.MkTrue();
		for (Invariant i:inv )
		 composite=	ctx.MkAnd(new BoolExpr []{composite, (BoolExpr) i.getInv(ctx)});		
		return composite;
	}

	


}
	
	
	

