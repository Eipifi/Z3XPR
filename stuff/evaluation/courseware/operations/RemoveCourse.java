package evaluation.courseware.operations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import token.ExclusiveToken;
import token.Token;
import token.TokenObj;
import application.Operation;

import com.microsoft.z3.*;

import evaluation.courseware.courseware;

public class RemoveCourse implements Operation  {
	
    private String name;
    private Expr course ;
	
	public RemoveCourse(String name, Context ctx) {
		this.name=name;
		try {
			this.course = ctx.MkConst("course", ctx.MkUninterpretedSort(ctx.MkSymbol("Course")));	
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
	
	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		if (op.getName()=="Enroll") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.getName())[1], this.getCourse()));
		}
		else
	        return ctx.MkTrue();		
	}
	
	@Override
	public Expr [] getArgs(String name) {
		Expr args []={this.getCourse()};
		return args;
	}
	
	/**
	 * To remove a course, we need to ensure that no student
	 * is  enrolled in the course.
	 * @param ctx Z3 context
	 * @return a boolean expression in z3 context which models the precondition
	 * @throws Z3Exception
	 */
	@Override
	public BoolExpr precondition(Context ctx) throws Z3Exception {

		Expr student = ctx.MkConst("student", ctx.MkUninterpretedSort(ctx.MkSymbol("Student")));	

		//setting the name for the student
		Sort[] Students = new Sort[1];
		Students[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("Student"));
		Symbol[] namess = new Symbol[1];
		namess[0] =  ctx.MkSymbol("student");
		
        Expr[] arg = new Expr[2];
		arg[0]=course;
		arg[1]=student;
        Expr enroll = ctx.MkApp(courseware.mkpair.ConstructorDecl(), arg);
        Expr noEnrolled = ctx.MkNot((BoolExpr) ctx.MkSetMembership(enroll,courseware.Enroll_set ));
		Expr existEnroll = ctx.MkForall(Students, namess, noEnrolled, 1, null, null,
		null, null);	
  	    return (BoolExpr) existEnroll;
	}

	/**
	 * Remove a course from the course list.
	 * @param ctx Z3 context
	 * @return an expression in z3 which models the course list
	 * @throws Z3Exception
	 */
	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		courseware.Course_set = ctx.MkSetDel(courseware.Course_set,this.course);
		
	    return courseware.Course_set;	
	}
	
	@Override
	public List<Operation> concurrentOps(Context ctx) {
		List<Operation> ops=new ArrayList();
		Operation o1=new AddStudent("AddStudent",ctx);
		Operation o2=new AddCourse("AddCourse",ctx);
		Operation o3=new Enroll("Enroll",ctx);
		Operation o4=new RemoveStudent("RemoveStudent",ctx);
		Operation o5=new RemoveCourse("RemoveCourse",ctx);
		Operation o6=new Disenroll("Disenroll",ctx);
		ops.add(o1);
		ops.add(o2);
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
