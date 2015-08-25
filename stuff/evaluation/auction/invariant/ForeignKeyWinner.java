package evaluation.auction.invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import invariant.Invariant;

public class ForeignKeyWinner implements Invariant {

	String name;
	
	public ForeignKeyWinner(String name) {
		
        this.name=name;
	}

	public ForeignKeyWinner() {
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
		
		Expr[] argWinner = new Expr[2];
		argWinner[0]=auction;
		argWinner[1]=buyer;

	    Expr winner=auctionapp.Winner.MkDecl().Apply(argWinner);
	    	    
	    Expr winnerExist =ctx.MkImplies( (BoolExpr)ctx.MkSetMembership(winner, auctionapp.Winner_set), (BoolExpr) ctx.MkSetMembership(buyer, auctionapp.Buyer_set));	    
	    
		Expr winnerForiegn = ctx.MkForall(arg, namesb, winnerExist, 1, null, null,null, null);	
		
		System.out.println("Winner Foriegn key:"+winnerForiegn);
			
		return (BoolExpr) winnerForiegn;
	}

}
