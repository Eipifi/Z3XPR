package evaluation.courseware.operations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import token.ExclusiveToken;
import token.SharedToken;
import token.Token;
import token.TokenObj;
import application.Operation;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BitVecNum;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.TupleSort;
import com.microsoft.z3.Z3Exception;

import escrow.counterwithescrow;
import evaluation.auction.auctionapp;
import evaluation.courseware.courseObject;
import evaluation.courseware.courseware;

public class Enroll implements Operation  {

	
    private String name;
    private Expr student ;
    private Expr course;
    private IntExpr capacityIndex;
	
	public Enroll(String name, Context ctx) {
		this.name=name;
		try {
			this.student = ctx.MkConst("student", ctx.MkUninterpretedSort(ctx.MkSymbol("Student")));
			courseObject c=new courseObject (ctx);
	        this.course=c.getCourse();
	        this.capacityIndex=(IntExpr) c.getIndex();
	  		
		} catch (Z3Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	public Expr getCourse() {
		return this.course;
	}
	
	public Expr getStudent() {
		return this.student;
	}
	
	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		
		if (op.getName()=="RemoveCourse") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.getCourse()));
		}
		else if (op.getName()=="RemoveStudent") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.getStudent()));
		}
		else if (op.getName()=="Enroll") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[1], this.getCourse()));
		}
		
		else return ctx.MkTrue();	
	
	}
	
	@Override
	public Expr [] getArgs(String name) {
		Expr [] args= {this.getStudent(),this.getCourse()} ;
		return args;
	}
	

    /**
     * To enroll a student in a course, 
     * the course and the student must exist and  
     * also the course has sufficient capacity.
     * @param ctx Z3 context
     * @return an expression in Z3 context which models the precondition of enroll in z3 context
     * @throws Z3Exception
     */
	@Override
	public BoolExpr precondition(Context ctx) throws Z3Exception {
    		
	    Expr existS=ctx.MkSetMembership(student, courseware.Student_set);
	    Expr existC=ctx.MkSetMembership(course, courseware.Course_set);

		Expr capacity= ctx.MkSelect(courseware.capacityArray, capacityIndex);
			
		Expr capacityBound=ctx.MkGe((ArithExpr) capacity, ctx.MkInt("1"));
	
	    
		return ctx.MkAnd(new BoolExpr[] { (BoolExpr) existS,(BoolExpr) existC, (BoolExpr) capacityBound});
	}
	
	/**
	 * Enroll a student in a course and 
	 * add the pair into a list of enrollments.
	 *  A symbolic  pair of the student
	 *  and the  course will be added into the
	 * enroll set. 
	 * @param ctx Z3 context
	 * @return an expression in Z3 context which models the effect of 
	 * enroll over the state
	 * @throws Z3Exception 
	 */
	@Override
	public Expr effect(Context ctx) throws Z3Exception {

	     
	    Expr capacity= ctx.MkSelect(courseware.capacityArray, capacityIndex);	
		capacity=(IntExpr) ctx.MkSub(new ArithExpr[] {(ArithExpr) capacity,ctx.MkInt("1")});
		courseware.capacityArray=ctx.MkStore(courseware.capacityArray, capacityIndex, capacity);
        		
        Expr[] arg = new Expr[2];
		arg[0]=course;
		arg[1]=student;		
        Expr enroll = ctx.MkApp(courseware.mkpair.ConstructorDecl(), arg);
        courseware.Enroll_set= ctx.MkSetAdd(courseware.Enroll_set,enroll);
         
		return  courseware.Enroll_set ;
	}
	
	@Override
	public List<Operation> concurrentOps(Context ctx) {
		List<Operation> ops=new ArrayList();

		Operation o2=new AddCourse("AddCourse",ctx);
		Operation o1=new AddStudent("AddStudent",ctx);
		Operation o3=new Enroll("Enroll",ctx);
		Operation o4=new RemoveStudent("RemoveStudent",ctx);
		Operation o5=new RemoveCourse("RemoveCourse",ctx);
		Operation o6=new Disenroll("Disenroll",ctx);
		ops.add(o2);
		ops.add(o1);
		ops.add(o3);
		ops.add(o4);
		ops.add(o5);
		ops.add(o6);	
		return ops;
		
	}
	
	@Override
	public int getReplicaIndex() {
		return 0;
	}
	
	@Override
	public void putReplicaIndex(Context ctx, int replica) throws Z3Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Expr[] getConditions(Context ctx, Operation op) throws Z3Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
