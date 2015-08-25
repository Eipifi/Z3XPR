package evaluation.auction.invariant;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import evaluation.auction.productObj;
import evaluation.courseware.courseObject;
import evaluation.courseware.courseware;
import invariant.Invariant;

public class StockLimit implements Invariant  {

	
	String name;
	
	public StockLimit(String name) {
		
		this.name=name;
	}
	
	public StockLimit() {
		
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		
		Sort[] arg = new Sort[1];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("Product"));

		Symbol[] namesb = new Symbol[1];
		namesb[0] =  ctx.MkSymbol("product");

		Expr[] stockindex =  new Expr[1];
		stockindex[0]=ctx.MkConst("product", ctx.MkUninterpretedSort(ctx.MkSymbol("Product")));;
		     
	     productObj p1=new productObj(ctx,1);
	     productObj p2=new productObj(ctx,2);

	     IntExpr stockIndex1=(IntExpr) p1.getIndex();
	     IntExpr stockIndex2=(IntExpr) p2.getIndex();
	     
	     Expr product1= p1.getProduct();
	     Expr product2= p2.getProduct();
		 
		 Expr stock= ctx.MkSelect(auctionapp.stockArray, stockIndex1);
	
		 Expr productBound=ctx.MkGe((ArithExpr) stock, ctx.MkInt("0"));
			
		 BoolExpr antecedent = ctx.MkNot(ctx.MkEq(stockIndex1, stockIndex2));
			
		 Expr distinctStock=ctx.MkImplies(ctx.MkNot(ctx.MkEq(product1, product2)), antecedent);
		  
		 Expr inv=ctx.MkAnd(new BoolExpr[]{(BoolExpr) distinctStock,(BoolExpr) productBound});
	    
		 Expr stockLimit = ctx.MkForall(arg, namesb, inv, 1, null, null,
		 null, null);	
		
		 System.out.println("Stock Limit:"+stockLimit);
		
		 return (BoolExpr) stockLimit;
	}

}
