package evaluation.courseware.invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.courseware.courseware;
import invariant.Invariant;

public class UniqneInv implements Invariant {

	
	String name;
	
	public UniqneInv(String name){
		this.name=name;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		 courseware.Student = ctx.MkUninterpretedSort("Student");	
         Sort[] students = new Sort[1];
         students[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Student"));
    
         Expr[] arg = new Expr[2];
		 arg[0]=ctx.MkConst("s1", ctx.MkUninterpretedSort(ctx.MkSymbol("Student")));;
		 arg[1]=ctx.MkConst("s2", ctx.MkUninterpretedSort(ctx.MkSymbol("Student")));;
		
		 Sort[] studentset = new Sort[2];
		 studentset[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Student"));
		 studentset[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("Student"));
		 //setting names
		 Symbol[] namess = new Symbol[2];
		 namess[0] =  ctx.MkSymbol("s1");
		 namess[1] =  ctx.MkSymbol("s2");
         Expr body = ctx.MkNot(ctx.MkEq(arg[0], arg[1]));
         BoolExpr mustUniqueee = ctx.MkForall(studentset, namess, body, 1, null, null,
         null, null);
         System.out.println("Quantifier Uniqueness: " + mustUniqueee.toString());
		 return mustUniqueee;
	}

}
