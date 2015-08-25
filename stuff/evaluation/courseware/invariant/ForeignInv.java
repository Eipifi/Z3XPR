package evaluation.courseware.invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.courseware.courseware;
import invariant.Invariant;

public class ForeignInv implements Invariant{

	String name;
	
	public ForeignInv(String name) {
		this.name=name;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		Expr course = ctx.MkConst("course", ctx.MkUninterpretedSort(ctx.MkSymbol("Course")));
		Expr student = ctx.MkConst("student", ctx.MkUninterpretedSort(ctx.MkSymbol("Student")));		
	    Expr e1=ctx.MkSetMembership(student, courseware.Student_set);
		Expr e2=ctx.MkSetMembership(course, courseware.Course_set);
			
	    Expr[] arg = new Expr[2];
		arg[0]=course;
		arg[1]=student;
			
		Sort[] studentCourse = new Sort[2];
		studentCourse[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Course"));
		studentCourse[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("Student"));
		//setting names
		Symbol[] userNames = new Symbol[2];
		userNames[0] =  ctx.MkSymbol("course");
		userNames[1] =  ctx.MkSymbol("student");
		Expr ee = ctx.MkApp(courseware.mkpair.ConstructorDecl(), arg);
	    Expr enrolled = (BoolExpr) ctx.MkSetMembership(ee,courseware.Enroll_set );
	    Expr body=ctx.MkImplies((BoolExpr) enrolled, ctx.MkAnd(new BoolExpr[] { (BoolExpr) e1,(BoolExpr) e2}));
	        
		Expr Enrolledd = ctx.MkForall(studentCourse, userNames, body, 1, null, null,
		null, null);      
		System.out.println(" foriegn key invariant: " + Enrolledd.toString());
	  	return (BoolExpr) Enrolledd;
		    
	}

}
