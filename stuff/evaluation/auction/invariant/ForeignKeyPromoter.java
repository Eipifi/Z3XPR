package evaluation.auction.invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import invariant.Invariant;

public class ForeignKeyPromoter implements Invariant  {

	String name;
	
	public ForeignKeyPromoter(String name) {
		this.name=name;
	}

	public ForeignKeyPromoter() {
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		
		Expr seller = ctx.MkConst("seller", ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")));	
		Expr auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
		
		Expr[] argPromoter = new Expr[2];
		argPromoter[0]=auction;
		argPromoter[1]=seller;

	    Expr promoter=auctionapp.Promoter.MkDecl().Apply(argPromoter);
	    
		Expr[] argSeller = new Expr[2];
		argSeller[0]=seller;
		argSeller[1]=ctx.MkConst("auctionLimit", ctx.IntSort());;

	    Expr sellerTuple=auctionapp.Seller.MkDecl().Apply(argSeller);
	    	   
		Expr[] argAuction = new Expr[2];
		argAuction[0]=auction;
		argAuction[1]=ctx.MkConst("state", auctionapp.state);

	 // Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);    

		Sort[] arg = new Sort[2];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));
		arg[1]=ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID"));

		
		Symbol[] namesb = new Symbol[2];
		namesb[0] =  ctx.MkSymbol("auction");
		namesb[1] =  ctx.MkSymbol("seller");
		
	    Expr exist= ctx.MkAnd(new BoolExpr[] { (BoolExpr) ctx.MkSetMembership(sellerTuple, auctionapp.Seller_set) ,
			   (BoolExpr) ctx.MkSetMembership(auction, auctionapp.AuctionID_set)});
	   
	    Expr promoterExist =ctx.MkImplies( (BoolExpr)ctx.MkSetMembership(promoter, auctionapp.Promoter_set), (BoolExpr) exist); 
	    
	    Expr promoterForiegn = ctx.MkForall(arg, namesb, promoterExist, 1, null, null,null, null);	
	   
	    System.out.println("Promoter Foriegn key:"+promoterForiegn);
		
	    return (BoolExpr) promoterForiegn;
	}

}
