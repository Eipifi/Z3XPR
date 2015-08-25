package evaluation.auction.invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import invariant.Invariant;

public class ForeignKeyOwner implements Invariant  {

	String name;
	
	public ForeignKeyOwner(String name) {
		
		this.name=name;
	}

	public ForeignKeyOwner() {
	}

	@Override
	public String getName() {
		
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
	
		Expr seller = ctx.MkConst("seller", ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")));	
		Expr product = ctx.MkConst("product", ctx.MkUninterpretedSort(ctx.MkSymbol("Product")));	
	
		Expr[] argOwner = new Expr[2];
		argOwner[0]=product;;
		argOwner[1]=seller;

	    Expr owner=auctionapp.Owner.MkDecl().Apply(argOwner);
	    
		Expr[] argSeller = new Expr[2];
		argSeller[0]=seller;
		argSeller[1]=ctx.MkConst("auctionLimit", ctx.IntSort());;

	    seller=auctionapp.Seller.MkDecl().Apply(argSeller);

		Expr exist= ctx.MkAnd(new BoolExpr[] { (BoolExpr) ctx.MkSetMembership(seller, auctionapp.Seller_set) ,
				   (BoolExpr) ctx.MkSetMembership(product, auctionapp.Product_set)});
		
		Sort[] arg = new Sort[2];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("Product"));
		arg[1]=ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID"));
		
		Symbol[] namesb = new Symbol[2];
		namesb[0] =  ctx.MkSymbol("product");
		namesb[1] =  ctx.MkSymbol("seller");
		
		Expr owenrExist =ctx.MkImplies( (BoolExpr)ctx.MkSetMembership(owner, auctionapp.Owner_set),  (BoolExpr)exist);
	    
		Expr ownerForiegn = ctx.MkForall(arg, namesb, owenrExist, 1, null, null,
		null, null);	
		
		System.out.println("Owner Foriegn key:"+ownerForiegn);
		
		return (BoolExpr) ownerForiegn;
	}

}
