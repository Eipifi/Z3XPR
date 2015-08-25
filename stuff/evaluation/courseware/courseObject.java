package evaluation.courseware;

import com.microsoft.z3.*;

public class courseObject {

	public Expr course;
	public IntExpr capacityArrayIndex;
	public IntExpr capacity;
	
	public  courseObject(Context ctx) throws Z3Exception {
		
		this.course=ctx.MkConst("course", ctx.MkUninterpretedSort(ctx.MkSymbol("Course")));
		this.capacityArrayIndex=(IntExpr) ctx.MkConst("capacityIndex",ctx.MkIntSort());
		this.capacity=(IntExpr) ctx.MkConst("capacity",ctx.MkIntSort());;
		
	}
	
	public  courseObject(Context ctx, int i) throws Z3Exception {
		
    	this.course=ctx.MkConst("course"+i, ctx.MkUninterpretedSort(ctx.MkSymbol("Course")));
		this.capacityArrayIndex=(IntExpr) ctx.MkConst("capacityIndex"+i,ctx.MkIntSort());
		
	}

	public Expr getCourse() {
		return this.course;
	}
	
	
	public Expr getIndex() {
		return this.capacityArrayIndex;
	}
	
	public Expr getCapacity() {
		return this.capacity;
	}
	
	public void putCapacity(IntExpr capacity) {
		 this.capacity=capacity;
	}
	
}
