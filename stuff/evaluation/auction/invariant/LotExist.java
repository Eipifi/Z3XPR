package evaluation.auction.invariant;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import invariant.Invariant;

public class LotExist implements Invariant {

	String name;
	
	public LotExist(String name) {
        this.name=name;
	}
	
	public LotExist() {
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
		
		Sort[] arg = new Sort[1];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));

		Symbol[] namesb = new Symbol[1];
		namesb[0] =  ctx.MkSymbol("auction");
	    
		Expr[] argLot = new Expr[4];
		argLot[0]=lot;
		argLot[1]=auction;
		argLot[2]=product;
		argLot[3]=ctx.MkConst("lotSize", ctx.IntSort());;

	    Expr lotTuple=auctionapp.Lot.MkDecl().Apply(argLot);
	    
		Expr[] argAuction = new Expr[2];
		argAuction[0]=auction;
		argAuction[1]=auctionapp.state.Consts()[1];

	    Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);
	    
	    Expr  activeState=ctx.MkSetMembership(auctionTuple, auctionapp.Auction_set);
	    	    	    
		Expr[] argAuction2 = new Expr[2];
		argAuction2[0]=auction;
		argAuction2[1]=auctionapp.state.Consts()[2];

	    Expr auctionTuple2=auctionapp.Auction.MkDecl().Apply(argAuction2);
	    
	    Expr closedState=ctx.MkSetMembership(auctionTuple2, auctionapp.Auction_set);
	    
	//   activeState= ctx.MkAnd(new BoolExpr[] {(BoolExpr) activeState, closedState});
	    	    
	    Expr limit=ctx.MkImplies((BoolExpr) ctx.MkOr( new BoolExpr []{(BoolExpr) closedState,
	    		(BoolExpr) activeState }), (BoolExpr) ctx.MkSetMembership(lotTuple, auctionapp.Lot_set));	    
	       
		Expr lotExist = ctx.MkForall(arg, namesb, limit, 1, null, null,null, null);
		
		System.out.println("Lot Exists:"+lotExist);
	
		return (BoolExpr) lotExist;
	}

}
