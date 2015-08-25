package evaluation.auction.invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import invariant.Invariant;

public class StateInvariant implements Invariant {
	
	String name;
	
	public StateInvariant(String name ) {
		
		this.name=name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		
		Expr auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
		Expr anotherAuction = ctx.MkConst("auction2", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
	
		Sort[] arg = new Sort[1];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));
		
		Symbol[] namesb = new Symbol[1];
		namesb[0] =  ctx.MkSymbol("auction");
	   
	    
		Expr[] argClosedAuction = new Expr[2];
		argClosedAuction[0]=auction;
		argClosedAuction[1]= auctionapp.state.Consts()[2];
	
	    Expr closedAuctionTuple=auctionapp.Auction.MkDecl().Apply(argClosedAuction);
			    
		Expr[] argPreparedAuction = new Expr[2];
		argPreparedAuction[0]=anotherAuction;
		argPreparedAuction[1]= auctionapp.state.Consts()[0];
	
	    Expr preparedAuctionTuple=auctionapp.Auction.MkDecl().Apply(argPreparedAuction);
	    
		Expr[] argActiveAuction = new Expr[2];
		argActiveAuction[0]=auction;
		argActiveAuction[1]=auctionapp.state.Consts()[1];
		
	    Expr activeAuctionTuple=auctionapp.Auction.MkDecl().Apply(argActiveAuction);
		
	    
		Expr[] argActiveAuction2 = new Expr[2];
		argActiveAuction2[0]=anotherAuction;
		argActiveAuction2[1]=auctionapp.state.Consts()[1];
		
	    Expr activeAuctionTuple2=auctionapp.Auction.MkDecl().Apply(argActiveAuction2);
	    
  
	    Expr lowerState=ctx.MkAnd(new BoolExpr [] {ctx.MkEq(anotherAuction, auction), (BoolExpr) ctx.MkSetMembership(closedAuctionTuple, auctionapp.Auction_set)  });
	   
		Expr noLowerState =ctx.MkAnd(new BoolExpr[] {(BoolExpr) ctx.MkSetMembership(preparedAuctionTuple, auctionapp.Auction_set),
				(BoolExpr) ctx.MkSetMembership(activeAuctionTuple2, auctionapp.Auction_set)});
			

		Expr existClosedState= ctx.MkImplies(  (BoolExpr)lowerState , (BoolExpr)ctx.MkNot((BoolExpr) noLowerState));

	    	   
		Expr activeAuction=ctx.MkAnd(new BoolExpr [] {ctx.MkEq(anotherAuction, auction), (BoolExpr) ctx.MkSetMembership(activeAuctionTuple, auctionapp.Auction_set)});
		
	 //   Expr noPreparedAuction =ctx.MkNot( ctx.MkExists(arg, namesb, preparedAuction, 1, null, null,
	//		null, null));	
			
	    Expr existActiveState= ctx.MkImplies(  (BoolExpr) activeAuction, (BoolExpr)ctx.MkNot((BoolExpr) ctx.MkSetMembership(preparedAuctionTuple, auctionapp.Auction_set)));
	    
		Sort[] argAll = new Sort[2];
		argAll[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));
		argAll[1]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));
		
		Symbol[] namesbAll = new Symbol[2];
		namesbAll[0] =  ctx.MkSymbol("auction");
		namesbAll[1] =  ctx.MkSymbol("auction2");
					   		    
		Expr stateChange = ctx.MkForall(argAll, namesbAll, ctx.MkAnd(new BoolExpr [] {(BoolExpr) existActiveState, (BoolExpr) existClosedState}), 1, null, null,
			null, null);	
		
		System.out.println("Auction State Invariant"+stateChange);
					
		return (BoolExpr) stateChange;
	}

}
