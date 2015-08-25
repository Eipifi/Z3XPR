package evaluation.courseware.invariant;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.courseware.courseObject;
import evaluation.courseware.courseware;
import evaluation.filesystem.filesystem;
import invariant.Invariant;

public class BoundedInv implements Invariant {
	
	String name;

	public BoundedInv(String name) {
		this.name=name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		
		
		 Expr[] capacityindex =  new Expr[1];
		 capacityindex[0]=ctx.MkConst("course", ctx.MkUninterpretedSort(ctx.MkSymbol("Course")));;
	
	     
	     courseObject c1=new courseObject(ctx,1);
	     courseObject c2=new courseObject(ctx,2);

	     IntExpr capacityIndex1=(IntExpr) c1.getIndex();
	     IntExpr capacityIndex2=(IntExpr) c2.getIndex();
	     
	     Expr course1= c1.getCourse();
	     Expr course2= c2.getCourse();
	      
	     courseObject c=new courseObject(ctx);
		 
		 Expr capacity= ctx.MkSelect(courseware.capacityArray, capacityIndex1);
	
		 Expr capacityBound=ctx.MkGe((ArithExpr) capacity, ctx.MkInt("0"));
			
			
		  BoolExpr antecedent = ctx.MkNot(ctx.MkEq(capacityIndex1, capacityIndex2));
			
		  Expr distinctCapacity=ctx.MkImplies(ctx.MkNot(ctx.MkEq(course1, course2)), antecedent);
		  
		  Expr inv=ctx.MkAnd(new BoolExpr[]{(BoolExpr) distinctCapacity,(BoolExpr) capacityBound});
			
	 
          Sort[] indexbase = new Sort[1];
          indexbase[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Course"));
          
		 Symbol[] indexCNames = new Symbol[1];
		 indexCNames[0] =  ctx.MkSymbol("course");
				 
		 Expr bounded = ctx.MkForall(indexbase, indexCNames, inv, 1, null, null,null, null);
		 
         Sort[] indexbase1 = new Sort[2];
         indexbase1[0] =ctx.MkUninterpretedSort(ctx.MkSymbol("Course"));
         indexbase1[1] =ctx.MkUninterpretedSort(ctx.MkSymbol("Course"));
         
		 Symbol[] indexCNames1 = new Symbol[2];
		 indexCNames1[0] =  ctx.MkSymbol("course1");
		 indexCNames1[1] =  ctx.MkSymbol("course2");
		 
		 Expr bounded2 = ctx.MkForall(indexbase1, indexCNames1, inv, 1, null, null,null, null);
 
		 System.out.println(" bounded invariant: " + bounded2.toString());
		 
		 return (BoolExpr) bounded2;
	}


}
