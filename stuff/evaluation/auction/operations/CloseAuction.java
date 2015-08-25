package evaluation.auction.operations;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import application.Operation;

public class CloseAuction  implements Operation {
	
	private String name;
	private Expr auction;
	private Expr buyer;

	public CloseAuction(String name, Context ctx) {
		this.name=name;
		try {
			this.auction= ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));	
			this.buyer = ctx.MkConst("buyer", ctx.MkUninterpretedSort(ctx.MkSymbol("Buyer")));	
		} catch (Z3Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr precondition(Context ctx) throws Z3Exception {
	
		
		Sort[] buyerarg = new Sort[1];
		buyerarg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("Buyer"));
		Symbol[] namesb = new Symbol[1];
		namesb[0] =  ctx.MkSymbol("buyer2");
		
        Expr[] argBid = new Expr[3];
        argBid[0]=auction;
        argBid[1]=buyer;
        argBid[2]=ctx.MkConst("bid", ctx.IntSort());
		
        Expr bidTuple =auctionapp.Bid.MkDecl().Apply(argBid);
        Expr existBid =  (BoolExpr) ctx.MkSetMembership(bidTuple,auctionapp.Bid_set );
      
	    Expr bidPrice=argBid[2];
        
        Expr buyer2 = ctx.MkConst("buyer2", ctx.MkUninterpretedSort(ctx.MkSymbol("Buyer")));
        
		Sort[] buyerarg2 = new Sort[1];
		buyerarg2[0]=auctionapp.Bid;
		Symbol[] namesb2 = new Symbol[1];
		namesb2[0] =  ctx.MkSymbol("bidTuple");
		
        Expr[] argBid2 = new Expr[3];
        argBid2[0]=auction;
        argBid2[1]=buyer2;
        argBid2[2]=ctx.MkConst("bid2", ctx.IntSort());
		
        Expr bidTuple2 =auctionapp.Bid.MkDecl().Apply(argBid2);
        Expr existBid2 =   ctx.MkSetMembership(bidTuple2,auctionapp.Bid_set );
        
	    Expr bidPrice2=argBid2[2];
	    
        BoolExpr bidCompare =ctx.MkLt((ArithExpr) bidPrice2, (ArithExpr) bidPrice);
        Expr existBuyer2 =ctx.MkSetMembership(buyer2, auctionapp.Buyer_set);
        
        Expr noMoreWinner=ctx.MkImplies( (BoolExpr) existBid2  , bidCompare);
        
        Expr existBuyer1 =ctx.MkSetMembership(buyer, auctionapp.Buyer_set);
    
		Expr existBids =ctx.MkForall(buyerarg, namesb, noMoreWinner, 1, null, null,
				null, null);
//ctx.MkNot(ctx.MkExists(buyerarg, namesb, noMoreWinner, 1, null, null,
	//	null, null));	
		
		Expr winner= ctx.MkAnd(new BoolExpr[] {(BoolExpr) existBuyer1, (BoolExpr) existBids,(BoolExpr) existBid });
		
		Expr state = ctx.MkConst("state", auctionapp.state);
		
		Expr[] argAuction = new Expr[2];
		argAuction[0]=auction;
		argAuction[1]=auctionapp.state.Consts()[1];

	    Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);

	    Expr existAuction=ctx.MkSetMembership(auctionTuple, auctionapp.Auction_set);
	    
	    Expr activeAuctionExist=ctx.MkAnd(new BoolExpr [] {(BoolExpr) existAuction, ctx.MkEq(state, auctionapp.state.Consts()[1])});

        
		Expr product = ctx.MkConst("product", ctx.MkUninterpretedSort(ctx.MkSymbol("Product")));	
		Expr lot = ctx.MkConst("lot", ctx.MkUninterpretedSort(ctx.MkSymbol("LotID")));	
			
		Sort[] argl = new Sort[1];
		argl[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("LotID"));

		Symbol[] namesl = new Symbol[1];
		namesl[0] =  ctx.MkSymbol("lot");

	    
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
	    
	    Expr autionLotOwnership =ctx.MkImplies( (BoolExpr)existsLot,(BoolExpr) autionLotExist );

	    Expr lotClosed=ctx.MkExists(argl, namesl, autionLotOwnership, 1, null, null,null, null);
	    
	    BoolExpr precondition=ctx.MkAnd(new BoolExpr[] {(BoolExpr) winner, (BoolExpr) existAuction}); 
	    
	    return (BoolExpr) precondition;
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		

		Expr[] argAuction = new Expr[2];
		argAuction[0]=auction;
		argAuction[1]=auctionapp.state.Consts()[2];

	    Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);	    
	    auctionapp.Auction_set= ctx.MkSetAdd(auctionapp.Auction_set,auctionTuple);  
	    
	  
	    Expr[] argAuction2 = new Expr[2];
		argAuction2[0]=auction;
		argAuction2[1]= auctionapp.state.Consts()[1];
	    
	    Expr auctionTuple2=auctionapp.Auction.MkDecl().Apply(argAuction2);	    
	    auctionapp.Auction_set= ctx.MkSetDel(auctionapp.Auction_set,auctionTuple2);
	        
	    Expr[] argWinner = new Expr[2];
	    argWinner[0]=auction;
	    argWinner[1]= buyer;
	    
	    Expr winnerTuple=auctionapp.Winner.MkDecl().Apply(argWinner);	    
	    auctionapp.Winner_set= ctx.MkSetAdd(auctionapp.Winner_set,winnerTuple);
	    
	    return  auctionapp.Auction_set ;
	}

	@Override
	public Expr [] getArgs(String name) {
		Expr args[]= {this.auction, this.buyer};
		return  args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		
		if (op.getName()=="CloseAuction") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.auction));
		}
		else if (op.getName()=="RemoveBid") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.auction));
		}
		
		else if (op.getName()=="RemoveAuction") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.auction));
		}
		
		else if (op.getName()=="UnregisterBuyer") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.buyer));
		}
		else if (op.getName()=="AddBid") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.auction));
		}

		else return ctx.MkTrue();	
	}

	@Override
	public List<Operation> concurrentOps(Context ctx) {
		Operation o1=new AddBid("AddBid",ctx);
		Operation o2=new AddProduct("AddProduct",ctx);
		Operation o3=new AddToLot("AddToLot",ctx);
		Operation o4=new CloseAuction("CloseAuction",ctx);
		Operation o5=new CreateAuction("CreateAuction",ctx);
		Operation o6=new RegisterBuyer("RegisterBuyer",ctx);
		Operation o7=new RegisterSeller("RegisterSeller",ctx);
		Operation o8=new RemoveAuction("RemoveAuction",ctx);
		Operation o9=new RemoveBid("RemoveBid",ctx);
		Operation o10=new RemoveFromLot("RemoveFromLot",ctx);
		Operation o11=new RemoveProduct("RemoveProduct",ctx);
		Operation o12=new StartAuction("StartAuction",ctx);
		Operation o13=new UnregisterBuyer("UnregisterBuyer",ctx);
		Operation o14=new UnregisterSeller("UnregisterSeller",ctx);
		
		List<Operation> op=new ArrayList<Operation>();
		op.add(o1);
		op.add(o2);
		op.add(o3);
		op.add(o4);
		op.add(o5);
		op.add(o6);	
		op.add(o7);
		op.add(o8);
		op.add(o9);
		op.add(o10);
		op.add(o11);
		op.add(o12);	
		op.add(o13);
		op.add(o14);
		
		return op;
	}

	@Override
	public void putReplicaIndex(Context ctx, int replica) throws Z3Exception {
		
	}

	@Override
	public int getReplicaIndex() {
		return 0;
	}

	@Override
	public Expr[] getConditions(Context ctx, Operation op) throws Z3Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
