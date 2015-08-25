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

public class AddBid   implements Operation {
	
	private String name;
	private Expr auction;
	private Expr buyer;
	private IntExpr quantity;


	public AddBid(String name, Context ctx) {
		
		this.name=name;
		try {
			this.auction = ctx.MkConst("auction3", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
			this.buyer = ctx.MkConst("buyer3", ctx.MkUninterpretedSort(ctx.MkSymbol("Buyer")));
			this.quantity=(IntExpr) ctx.MkConst("bid3", ctx.IntSort());			
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
		
	    Expr product = ctx.MkConst("product", ctx.MkUninterpretedSort(ctx.MkSymbol("Product")));
	    Expr lot = ctx.MkConst("lot", ctx.MkUninterpretedSort(ctx.MkSymbol("LotID")));	    
		
		Sort[] args =  new Sort[1];		   	    
		args[0] =ctx.MkTupleSort(ctx.MkSymbol("mk_Auction_tuple"), // name of
		  	    new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second") ,  ctx.MkSymbol("third"), ctx.MkSymbol("forth") }, // names
		  	    new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")), ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")),ctx.MkIntSort(), 
			ctx.MkUninterpretedSort(ctx.MkSymbol("BuyerID")) } );
		 
	    Symbol[] argsname = new Symbol[1];
	    argsname[0] =  ctx.MkSymbol("auction");
		
	    Expr[] argAuction = new Expr[2];
	    argAuction[0]=auction;
	    argAuction[1]=auctionapp.state.Consts()[1];	    
	    	
	    Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);
	    		   		 
		Expr auctionExist=ctx.MkSetMembership(auctionTuple,auctionapp.Auction_set);
		
	 	Expr[] argAuction2 = new Expr[2];
	 	argAuction2[0]= auction;;
	 	argAuction2[1]=auctionapp.state.Consts()[2];

	 	Expr auctionTuple2=auctionapp.Auction.MkDecl().Apply(argAuction2);
	 	
	 		 	
	 	Expr state=ctx.MkNot((BoolExpr) ctx.MkSetMembership(auctionTuple2, auctionapp.Auction_set));
		
		Expr buyerExist=ctx.MkSetMembership(buyer, auctionapp.Buyer_set);
		
		
		Sort[] arg = new Sort[1];
		arg[0]=auctionapp.Auction;

		Symbol[] namesb = new Symbol[1];
		namesb[0] =  ctx.MkSymbol("auction");	    
		
		Expr[] argLot = new Expr[4];
		argLot[0]=lot;
		argLot[1]=auction;
		argLot[2]=product;
		argLot[3]=ctx.MkConst("lotSize", ctx.IntSort());;

	    Expr lotTuple=auctionapp.Lot.MkDecl().Apply(argLot);
	    
	    Expr lotExist= (BoolExpr) ctx.MkSetMembership(lotTuple, auctionapp.Lot_set);	
			
	    Expr precondition=ctx.MkAnd(new BoolExpr[] {(BoolExpr) buyerExist, (BoolExpr) auctionExist, (BoolExpr) lotExist, (BoolExpr) state});
		
		return (BoolExpr) precondition;
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {

	    Expr[] argBid = new Expr[3];
	    argBid[0]=auction;
	    argBid[1]=buyer;
	    argBid[2]=quantity;	
		Expr bidTuple=auctionapp.Bid.MkDecl().Apply(argBid);
	    auctionapp.Bid_set= ctx.MkSetAdd(auctionapp.Bid_set,bidTuple);        
	    return  auctionapp.Bid_set ;
	}

	@Override
	public Expr[] getArgs(String name) {
		Expr [] args={this.auction, this.buyer};
		return args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		
		if (op.getName()=="CloseAuction") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.auction));
		}
		else if (op.getName()=="RemoveAuction") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.auction));
		}
		else if (op.getName()=="UnregisterBuyer") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.buyer));
		}
		else if (op.getName()=="RemoveFromLot") {
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
