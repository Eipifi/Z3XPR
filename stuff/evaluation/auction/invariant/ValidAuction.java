package evaluation.auction.invariant;

import invariant.Invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;

public class ValidAuction implements Invariant  {

	String name;
	
	public ValidAuction(String name) {
		this.name=name;
	}

	public ValidAuction() {
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		
		Expr auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
	    	   
		Expr[] argAuction = new Expr[2];
		argAuction[0]=auction;
		argAuction[1]=auctionapp.state.Consts()[0];

	    Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);   
	    
 	   
	    Expr[] argAuction2 = new Expr[2];
	    argAuction2[0]=auction;
	    argAuction2[1]=auctionapp.state.Consts()[1];

	    Expr auctionTuple2=auctionapp.Auction.MkDecl().Apply(argAuction2);  
	    
	    Expr[] argAuction3 = new Expr[2];
	    argAuction3[0]=auction;
	    argAuction3[1]=auctionapp.state.Consts()[2];

	    Expr auctionTuple3=auctionapp.Auction.MkDecl().Apply(argAuction3);  

		Sort[] arg = new Sort[1];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));
		
		Symbol[] namesb = new Symbol[1];
		namesb[0] =  ctx.MkSymbol("auction");

		Expr existAuction=ctx.MkOr(new BoolExpr[] {(BoolExpr)ctx.MkSetMembership(auctionTuple, auctionapp.Auction_set), (BoolExpr)ctx.MkSetMembership(auctionTuple2, auctionapp.Auction_set),
				(BoolExpr)ctx.MkSetMembership(auctionTuple3, auctionapp.Auction_set)});
	   
	    Expr auctionValidity =ctx.MkImplies( (BoolExpr)ctx.MkSetMembership(auctionTuple3, auctionapp.Auction_set), (BoolExpr) ctx.MkSetMembership(auction, auctionapp.AuctionID_set)); 
	    
	    Expr auctionForiegn = ctx.MkForall(arg, namesb, auctionValidity, 1, null, null,null, null);	
	   
	    System.out.println("Auction Foriegn key:"+auctionForiegn);
		
	    return (BoolExpr) auctionForiegn;
	}
}