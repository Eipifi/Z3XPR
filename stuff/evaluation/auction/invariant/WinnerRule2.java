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

public class WinnerRule2 implements Invariant {
	
	String name;
	
	public WinnerRule2(String name) {
		this.name=name;
	}
	
	public WinnerRule2() {
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
	    
	    Expr auctionExist=ctx.MkSetMembership(auctionTuple,  auctionapp.Auction_set);
	    	    		
	    Expr closedState= ctx.MkEq(argAuction[1],  auctionapp.state.Consts()[2]);
	    
		Expr[] argWinner = new Expr[2];
		argWinner[0]=auction;
		argWinner[1]=buyer;
		
	    Expr winnerTuple=auctionapp.Winner.MkDecl().Apply(argWinner);
	    
	    Expr winner=(BoolExpr)ctx.MkSetMembership(winnerTuple, auctionapp.Winner_set);
	    	    
	    Expr winnerRule=ctx.MkImplies((BoolExpr) closedState, (BoolExpr) winner);
		
		Sort[] buyerarg = new Sort[2];
		buyerarg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("Buyer"));
		buyerarg[1]=ctx.MkIntSort();
		
		Symbol[] namesbuyer = new Symbol[2];
		namesbuyer[0] =  ctx.MkSymbol("buyer");
		namesbuyer[1] =  ctx.MkSymbol("bid");
		
        Expr[] argBid = new Expr[3];
        argBid[0]=auction;
        argBid[1]=buyer;
        argBid[2]=ctx.MkConst("bid", ctx.IntSort());
		
        Expr bidTuple =auctionapp.Bid.MkDecl().Apply(argBid);
        Expr existBid =  (BoolExpr) ctx.MkSetMembership(bidTuple,auctionapp.Bid_set );
        
        Expr buyer2 = ctx.MkConst("buyer2", ctx.MkUninterpretedSort(ctx.MkSymbol("Buyer")));
        
		Sort[] buyerarg2 = new Sort[1];
		buyerarg2[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("Buyer"));
		Symbol[] namesbuyer2 = new Symbol[1];
		namesbuyer2[0] =  ctx.MkSymbol("buyer2");
		
        Expr[] argBid2 = new Expr[3];
        argBid2[0]=auction;
        argBid2[1]=buyer2;
        argBid2[2]=ctx.MkConst("bid2", ctx.IntSort());
		
        Expr bidTuple2 =auctionapp.Bid.MkDecl().Apply(argBid2);
        Expr existBid2 =   ctx.MkSetMembership(bidTuple2,auctionapp.Bid_set );	    
        
        BoolExpr bidCompare =ctx.MkGt((ArithExpr) argBid[2], (ArithExpr) argBid2[2]);
        
        Expr maxBid=ctx.MkImplies( ctx.MkAnd(new BoolExpr []{  (BoolExpr) existBid2  }),  bidCompare);      
        	    
        Expr exprMaxBidder=ctx.MkForall(buyerarg2, namesbuyer2, maxBid, 1, null, null,null, null);
        		//ctx.MkNot(ctx.MkExists(buyerarg2, namesbuyer2, maxBid, 1, null, null,null, null));
        
        Expr existBuyer=  ctx.MkSetMembership(buyer, auctionapp.Buyer_set);
         
        Expr exprBidder= ctx.MkAnd(new BoolExpr[] {(BoolExpr) existBuyer,(BoolExpr) existBid, (BoolExpr) winner, (BoolExpr) exprMaxBidder });
         
        
		Expr existBids = ctx.MkExists(buyerarg, namesbuyer, exprBidder, 1, null, null,
		null, null);	
	    
		Expr implication =ctx.MkImplies( (BoolExpr)auctionExist,  (BoolExpr) existBids );	    
	    
		Expr invariant = ctx.MkForall(arg, namesb, implication, 1, null, null,
		null, null);	
		
		System.out.println(" Winner Constraint2:"+invariant);
		
		return (BoolExpr) invariant;
	}

}
