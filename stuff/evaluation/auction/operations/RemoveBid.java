package evaluation.auction.operations;

import java.util.ArrayList;
import java.util.List;


import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import application.Operation;

public class RemoveBid  implements Operation  {
	
	private String name;
	private Expr auction;
	private Expr buyer;
	private IntExpr bid;


	public RemoveBid(String name, Context ctx) {
		this.name=name;
		try {
			this.auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
			this.buyer = ctx.MkConst("buyer", ctx.MkUninterpretedSort(ctx.MkSymbol("Buyer")));
			this.bid=(IntExpr) ctx.MkConst("bid", ctx.IntSort());
			
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
	     
		Sort[] arg = new Sort[1];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));
		
		Symbol[] namesb = new Symbol[1];
		namesb[0] =  ctx.MkSymbol("auction");

        
        Expr[] argWinner = new Expr[2];
        argWinner[0]=auction;
        argWinner[1]=buyer;
	
        Expr winnerTuple =auctionapp.Winner.MkDecl().Apply(argWinner);
        Expr noWinner = ctx.MkNot((BoolExpr) ctx.MkSetMembership(winnerTuple,auctionapp.Winner_set ));
        
		Expr closedState = ctx.MkForall(arg, namesb, noWinner, 1, null, null,
		null, null);	
		
		return (BoolExpr) closedState ;
	    
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		
	    Expr[] argBid = new Expr[3];
	    argBid[0]=auction;
	    argBid[1]=buyer;
	    argBid[2]=bid;	
		Expr bidTuple=auctionapp.Bid.MkDecl().Apply(argBid);
	    auctionapp.Bid_set= ctx.MkSetDel(auctionapp.Bid_set,bidTuple);        
	    return  auctionapp.Bid_set ;
	}

	@Override
	public Expr [] getArgs(String name) {
		Expr args[]={this.auction};
		return args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		
		if (op.getName()=="CloseAuction") {
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
