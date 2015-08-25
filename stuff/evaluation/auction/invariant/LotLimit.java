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
import evaluation.courseware.courseware;
import invariant.Invariant;

public class LotLimit implements Invariant  {
	
	String name;

	public LotLimit(String name) {
		this.name=name;
	}
	
	public LotLimit() {

	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		
		Expr seller = ctx.MkConst("seller", ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")));	
		Expr auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
		Expr product = ctx.MkConst("product", ctx.MkUninterpretedSort(ctx.MkSymbol("Product")));	
		
		Expr lot = ctx.MkConst("lot", ctx.MkUninterpretedSort(ctx.MkSymbol("LotID")));
		
		Sort[] arg = new Sort[2];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));
		arg[1]=ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID"));

		Symbol[] namesb = new Symbol[2];
		namesb[0] =  ctx.MkSymbol("auction");
		namesb[1] =  ctx.MkSymbol("seller");
	    
		Expr[] argLot = new Expr[4];
		argLot[0]=lot;
		argLot[1]=auction;
		argLot[2]=product;
		argLot[3]=ctx.MkConst("lotSize", ctx.IntSort());;

	    Expr lotTuple=auctionapp.Lot.MkDecl().Apply(argLot);
	    
	    Expr lotExist= ctx.MkSetMembership(lotTuple, auctionapp.Lot_set);
	    
		Expr[] argSeller = new Expr[2];
		argSeller[0]=seller;
		argSeller[1]=ctx.MkConst("auctionLimit", ctx.IntSort());;

	    Expr sellerTuple=auctionapp.Seller.MkDecl().Apply(argSeller);
	    
	    Expr limit=ctx.MkLe((ArithExpr) argLot[3], (ArithExpr) argSeller[1]);
	    
		Expr[] argPromoter = new Expr[2];
		argPromoter[0]=auction;
		argPromoter[1]=seller;

	    Expr promoter = auctionapp.Promoter.MkDecl().Apply(argPromoter);
			    
		Expr[] argAuction = new Expr[2];
		argAuction[0]=auction;
		argAuction[1]=auctionapp.state.Consts()[2];

	    Expr auctionTuple = auctionapp.Auction.MkDecl().Apply(argAuction);
	    	    	    
	    Expr validLot= ctx.MkAnd(new BoolExpr []{(BoolExpr)ctx.MkSetMembership(promoter, auctionapp.Promoter_set), (BoolExpr) lotExist  ,
	    		(BoolExpr)ctx.MkSetMembership(sellerTuple, auctionapp.Seller_set)});
	    
	    Expr boundedImplication =ctx.MkImplies( (BoolExpr)validLot, (BoolExpr) limit );
	  		
		Expr invariant2 = ctx.MkForall(arg, namesb, boundedImplication, 1, null, null,null, null);	
		
		return (BoolExpr) invariant2;
	}

}
