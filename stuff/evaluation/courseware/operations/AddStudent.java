package evaluation.courseware.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import analyzer.RelyGuarantee;
import token.ExclusiveToken;
import token.Token;
import token.TokenObj;
import analyzer.RelyGuarantee;
import application.Operation;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.courseware.courseware;

public class AddStudent  implements Operation {

	private String name;
	private Expr  student ;
	
	public AddStudent(String name, Context ctx) {
		this.name=name;
		try {
			this.student = ctx.MkConst("student", ctx.MkUninterpretedSort(ctx.MkSymbol("Student")));
		} catch (Z3Exception e) {
			e.printStackTrace();
		}			
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {	
	    return ctx.MkTrue();		
	}
	
	@Override
	public Expr [] getArgs(String name) {
		Expr [] args={this.student};
        return args;
		
	}
	
	/**
	* To  add a student into the student list, 
	* we have to check that the student is not registered before.
	* @param ctx Z3 context
	* @return  an expression in Z3 contexts implying the precondition 
    * @throws Z3Exception
	*/
    @Override
	public BoolExpr precondition(Context ctx) throws Z3Exception {
         return ctx.MkTrue();
	}
    
	/**
	 * Register a student by adding her student id 
	 * into the student list.
	 * @param ctx Z3 context
	 * @return  An expression in Z3 context which models the student list
	 * @throws Z3Exception
	 */
	@Override
	public Expr effect(Context ctx) throws Z3Exception {	
		courseware.Student_set= ctx.MkSetAdd(courseware.Student_set,student);
		return courseware.Student_set;
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
