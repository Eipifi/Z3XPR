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
 
public class WinnerRule1 implements Invariant {

	String name;
	
	public WinnerRule1(String name) {
		this.name=name;
	}
	
	public WinnerRule1() {
		
	}

	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		
		Expr auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
		Expr buyer = ctx.MkConst("buyer", ctx.MkUninterpretedSort(ctx.MkSymbol("Buyer")));	
		
		Sort[] arg = new Sort[1];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));

		Symbol[] namesb = new Symbol[1];
		namesb[0] =  ctx.MkSymbol("auction");	    
	    
		Expr[] argAuction = new Expr[2];
		argAuction[0]=auction;
		argAuction[1]=auctionapp.state.Consts()[2];
		
	    Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);

	    Expr closedAuctionExist=ctx.MkSetMembership(auctionTuple,auctionapp.Auction_set);
	    
		Expr[] argWinner = new Expr[2];
		argWinner[0]=auction;
		argWinner[1]=buyer;

	    Expr winner=auctionapp.Winner.MkDecl().Apply(argWinner);	    
	    
	    Expr ownership =ctx.MkImplies( (BoolExpr)ctx.MkSetMembership(winner, auctionapp.Winner_set),(BoolExpr) closedAuctionExist );
	    	    
		Expr winnerConst = ctx.MkForall(arg, namesb, ownership, 1, null, null,
		null, null);
		
		System.out.println("Winner Constraint1:"+winnerConst);
		
		return (BoolExpr) winnerConst;
	}

}
