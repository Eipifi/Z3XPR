package evaluation.auction.invariant;

import invariant.Invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;

public class LotInvariant  implements Invariant   {
	
	String name;
	
	public LotInvariant(String name) {
		
		this.name=name;
	}
	
	public LotInvariant() {		
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
			
		Expr auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
		Expr product = ctx.MkConst("product", ctx.MkUninterpretedSort(ctx.MkSymbol("Product")));	
		Expr lot = ctx.MkConst("lot", ctx.MkUninterpretedSort(ctx.MkSymbol("LotID")));	
			
		Sort[] arg = new Sort[2];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));
		arg[1]=ctx.MkUninterpretedSort(ctx.MkSymbol("LotID"));

		Symbol[] namesb = new Symbol[2];
		namesb[0] =  ctx.MkSymbol("auction");
		namesb[1] =  ctx.MkSymbol("lot");

	    
		Expr[] argAuctionLot = new Expr[2];
		argAuctionLot[0]=auction;
		argAuctionLot[1]=lot;
		
	    Expr auctionLotTuple=auctionapp.auctionLot.MkDecl().Apply(argAuctionLot);
	    
	    Expr autionLotExist=ctx.MkSetMembership(auctionLotTuple,auctionapp.auctionLot_set);

		Expr[] argLot = new Expr[4];
		argLot[0]=lot;
		argLot[1]=auction;
		argLot[2]=product;
		argLot[3]= ctx.MkConst("lotSize", ctx.MkIntSort());
		
	    Expr lotTuple=auctionapp.Lot.MkDecl().Apply(argLot);
	    
	    Expr existsLot=ctx.MkSetMembership(lotTuple, auctionapp.Lot_set);    

		Expr[] argAuction = new Expr[2];
		argAuction[0]=auction;
		argAuction[1]=auctionapp.state.Consts()[1];
	
	    Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);	    
	    
	    Expr existsActiveAuction=ctx.MkSetMembership(auctionTuple,auctionapp.Auction_set);
	    
	    
		Expr[] argAuction2 = new Expr[2];
		argAuction2[0]=auction;
		argAuction2[1]=auctionapp.state.Consts()[2];
	
	    Expr auctionTuple2=auctionapp.Auction.MkDecl().Apply(argAuction2);	    
	    
	    Expr existsClosedAuction=ctx.MkSetMembership(auctionTuple2,auctionapp.Auction_set);
	    
	    Expr activeState=ctx.MkOr(new BoolExpr [] {(BoolExpr) existsActiveAuction,(BoolExpr) existsClosedAuction });
	    
	    Expr exprLot=ctx.MkAnd(new BoolExpr [] {(BoolExpr) activeState,(BoolExpr) existsLot });
	    	    
	    Expr autionLotOwnership =ctx.MkImplies( (BoolExpr)exprLot,(BoolExpr) autionLotExist );
	    	    
		Expr autionLot = ctx.MkForall(arg, namesb, autionLotOwnership, 1, null, null,null, null);
		
		System.out.println("Auction Lot Invariant:"+autionLot);
		
		return (BoolExpr) autionLot;
	}


}
