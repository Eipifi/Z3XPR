package evaluation.courseware.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import token.Token;
import token.TokenObj;
import application.Operation;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BitVecExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Z3Exception;

import evaluation.courseware.courseObject;
import evaluation.courseware.courseware;



public class AddCourse  implements Operation  {

	private String name;
	private Expr course;
	private IntExpr capacityIndex;
	private IntExpr capacity;

	
		
	public AddCourse(String name, Context ctx) {
		this.name=name;
		try {
			courseObject c=new courseObject(ctx);
			this.course=c.getCourse();
			this.capacityIndex=(IntExpr) c.getIndex();
		//	this.capacity=c.getCapacity();
			this.capacity= (IntExpr) c.getCapacity();

		} catch (Z3Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public Expr[] getArgs(String name) {
		Expr [] args={this.course};
        return args;	
	}
	
	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {	
	    return ctx.MkTrue();		
	}

	/**
    * The precondition for adding a course is simply true.
	* @param ctx Z3 context
	* @return true 
	* @throws Z3Exception
	*/
	@Override
	public BoolExpr precondition(Context ctx) throws Z3Exception {
        return(ctx.MkTrue());
	}
	
	/**
	 * Add a course into the course list.
	 * @param ctx Z3 context
	 * @return  an expression in Z3 context which models the course list
	 * @throws Z3Exception
	 */
	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		courseware.Course_set= ctx.MkSetAdd(courseware.Course_set,course);
		
		this.capacity=(IntExpr) ctx.MkITE(ctx.MkGe((ArithExpr) capacity, ctx.MkInt("1")), capacity,ctx.MkAdd(new ArithExpr[] 
				{ctx.MkMul(new ArithExpr[] {capacity, ctx.MkInt("-1")}), ctx.MkInt("1")} ));

		
		System.out.println("adding new course"+	this.capacity);
		
		courseware.capacityArray=ctx.MkStore(courseware.capacityArray, capacityIndex, capacity);
	//	ctx.MkITE(ctx.MkGe((ArithExpr) capacity, ctx.MkInt("1")),ctx.MkEq(courseware.capacityArray, 
		//		ctx.MkStore(courseware.capacityArray, capacityIndex, capacity)), ctx.MkTrue());
		
	

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
	public void putReplicaIndex(Context ctx, int rreplica) throws Z3Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Expr[] getConditions(Context ctx, Operation op) throws Z3Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
