package evaluation.auction.invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import invariant.Invariant;

public class ForeignKeyBidder implements Invariant {

	String name;
	public ForeignKeyBidder(String name) {
		
		this.name=name;
	}

	public ForeignKeyBidder() {
	}

	@Override
	public String getName() {
		
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
	
		Expr auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
		Expr buyer = ctx.MkConst("buyer", ctx.MkUninterpretedSort(ctx.MkSymbol("Buyer")));	
		
		Sort[] arg = new Sort[2];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));
		arg[1]=ctx.MkUninterpretedSort(ctx.MkSymbol("Buyer"));


		Symbol[] namesb = new Symbol[2];
		namesb[0] =  ctx.MkSymbol("auction");
		namesb[1] =  ctx.MkSymbol("buyer");
		    
		Expr[] argBid = new Expr[3];
		argBid[0]=auction;
		argBid[1]=buyer;
		argBid[2]=ctx.MkConst("bid", ctx.IntSort());
		
		
		Expr[] argAuction = new Expr[2];
		argAuction[0]=auction;
		argAuction[1]=ctx.MkConst("state", auctionapp.state);

	    Expr bid=auctionapp.Bid.MkDecl().Apply(argBid);
	    
	    Expr bidder =ctx.MkImplies( (BoolExpr)ctx.MkSetMembership(bid, auctionapp.Bid_set), ctx.MkAnd( new BoolExpr[]{
	    		(BoolExpr) ctx.MkSetMembership(auction, auctionapp.AuctionID_set) , (BoolExpr) ctx.MkSetMembership(buyer, auctionapp.Buyer_set)}));
	    
	    
		Expr bidderForiegn = ctx.MkForall(arg, namesb, bidder, 1, null, null,
		null, null);	
		
		 System.out.println("bidder Foriegn key:"+bidderForiegn);
		
		return (BoolExpr) bidderForiegn;
	}
	
	
	

}
