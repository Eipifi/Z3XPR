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
import evaluation.courseware.courseware;
import application.Operation;

public class UnregisterBuyer  implements Operation {

	private String name;
	private Expr buyer;
	
	public UnregisterBuyer(String name, Context ctx) {
		this.name=name;
		try {
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
		
		Expr auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));	

		Sort[] auctionarg = new Sort[1];
		auctionarg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("Auction"));
		Symbol[] namesa = new Symbol[1];
		namesa[0] =  ctx.MkSymbol("a");
		
        Expr[] argBid = new Expr[3];
        argBid[0]=auction;
        argBid[1]=buyer;
        argBid[2]=(IntExpr) ctx.MkConst("bid", ctx.IntSort());
		
        Expr bidTuple =auctionapp.Bid.MkDecl().Apply(argBid);
        Expr noBid = ctx.MkNot((BoolExpr) ctx.MkSetMembership(bidTuple,auctionapp.Bid_set ));
		Expr existBid = ctx.MkForall(auctionarg, namesa, noBid, 1, null, null,
		null, null);
		
        Expr[] argWinner = new Expr[2];
        argWinner[0]=auction;
        argWinner[1]=buyer;
     
        Expr winner =auctionapp.Winner.MkDecl().Apply(argWinner);
        Expr noWinner = ctx.MkNot((BoolExpr) ctx.MkSetMembership(winner,auctionapp.Winner_set ));
		Expr existWinner = ctx.MkForall(auctionarg, namesa, noWinner, 1, null, null,
		null, null);	
		
		Expr precondition= ctx.MkAnd(new BoolExpr[] {(BoolExpr) existBid, (BoolExpr) existWinner});
		
  	    return (BoolExpr) precondition;
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		auctionapp.Buyer_set= ctx.MkSetDel(auctionapp.Buyer_set, buyer);
		return auctionapp.Buyer_set;
	}

	@Override
	public Expr [] getArgs(String name) {
		Expr args[]={this.buyer};
		return  args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		
		if (op.getName()=="AddBid") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[1], this.buyer));
		}
		else if (op.getName()=="CloseAuction") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[1], this.buyer));
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
