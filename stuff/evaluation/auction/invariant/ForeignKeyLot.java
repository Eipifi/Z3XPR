package evaluation.auction.invariant;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import invariant.Invariant;

public class ForeignKeyLot implements Invariant  {

	String name;
	
	public ForeignKeyLot(String name) {
		
		this.name=name;
	}
	
	public ForeignKeyLot() {
		
	}


	@Override
	public String getName() {
		
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		
		Expr seller = ctx.MkConst("seller", ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")));	
		Expr auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
		Expr lot = ctx.MkConst("lot", ctx.MkUninterpretedSort(ctx.MkSymbol("LotID")));
		Expr product = ctx.MkConst("product", ctx.MkUninterpretedSort(ctx.MkSymbol("Product")));
	
		Expr[] argLot = new Expr[4];
		argLot[0]=lot;
		argLot[1]=auction;
		argLot[2]=product;
		argLot[3]=ctx.MkConst("lotSize", ctx.IntSort());

	    Expr lotTuple=auctionapp.Lot.MkDecl().Apply(argLot);
	    
		Expr[] argOwner = new Expr[2];
		argOwner[0]= product;
		argOwner[1]=seller;

	    Expr Owner=auctionapp.Owner.MkDecl().Apply(argOwner);
  
	    
		Expr[] argPromoter = new Expr[2];
		argPromoter[0]= auction;
		argPromoter[1]=seller;

	    Expr Promoter=auctionapp.Promoter.MkDecl().Apply(argPromoter);
	    
	 	Expr[] argSeller = new Expr[2];
		argSeller[0]= seller;
		argSeller[1]=ctx.MkConst("auctionLimit", ctx.IntSort());

	    Expr Seller=auctionapp.Seller.MkDecl().Apply(argSeller);
	    
	    Expr limit=ctx.MkLe((ArithExpr) argLot[3], (ArithExpr) argSeller[1]);
		
		
		Expr lotForiegn =  ctx.MkAnd( new BoolExpr[]{(BoolExpr) ctx.MkSetMembership(seller, auctionapp.SellerID_set), (BoolExpr) ctx.MkSetMembership(Seller, auctionapp.Seller_set), 
				(BoolExpr) ctx.MkSetMembership(Owner, auctionapp.Owner_set),
				(BoolExpr) ctx.MkSetMembership(Promoter, auctionapp.Promoter_set), (BoolExpr) limit});
		
	    
		   
	    Sort[] arg = new Sort[1];
	    arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID"));
	    

		Symbol[] names = new Symbol[1];
    	names[0] =  ctx.MkSymbol("seller");

		
		Expr sellerForiegn = ctx.MkExists(arg, names,lotForiegn, 1, null, null, null, null);	  
	

	    Expr lotOwnership =ctx.MkImplies( (BoolExpr)ctx.MkSetMembership(lotTuple, auctionapp.Lot_set), (BoolExpr) sellerForiegn );
	    	
	    
		Sort[] arg2 = new Sort[4];
    	arg2[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("LotID"));
    	arg2[1]=ctx.MkUninterpretedSort(ctx.MkSymbol("Product"));
    	arg2[2]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));
    	arg2[3]=ctx.MkIntSort();

		Symbol[] namesb = new Symbol[4];
    	namesb[0] =  ctx.MkSymbol("lot");
    	namesb[1] =  ctx.MkSymbol("product");
    	namesb[2] =  ctx.MkSymbol("auction");
    	namesb[3] =  ctx.MkSymbol("lotSize");

	    
		Expr foriegn = ctx.MkForall(arg2, namesb, lotOwnership, 1, null, null,null, null);	
		
	   System.out.println("Lot Foriegn key:"+foriegn);

		return (BoolExpr) foriegn;
	}

}
