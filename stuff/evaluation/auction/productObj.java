package evaluation.auction;


import com.microsoft.z3.*;

public class productObj {

	public Expr product;
	public IntExpr stockArrayIndex;
	public IntExpr stock;
	
	public  productObj(Context ctx) throws Z3Exception {
		
		this.product=ctx.MkConst("product", ctx.MkUninterpretedSort(ctx.MkSymbol("Product")));
		this.stockArrayIndex=(IntExpr) ctx.MkConst("stockIndex",ctx.MkIntSort());
		this.stock=(IntExpr) ctx.MkConst("stock",ctx.MkIntSort());;
		
	}
	
	public  productObj(Context ctx, int i) throws Z3Exception {
		
    	this.product=ctx.MkConst("product"+i, ctx.MkUninterpretedSort(ctx.MkSymbol("Product")));
		this.stockArrayIndex=(IntExpr) ctx.MkConst("stockIndex"+i,ctx.MkIntSort());
		
	}

	public Expr getProduct() {
		return this.product;
	}
	
	
	public Expr getIndex() {
		return this.stockArrayIndex;
	}
	
	public Expr getStock() {
		return this.stock;
	}
	
	public void putStock(IntExpr stock) {
		 this.stock=stock;
	}
	
}