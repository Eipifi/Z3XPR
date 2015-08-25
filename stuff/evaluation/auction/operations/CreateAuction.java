package evaluation.auction.operations;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import application.Operation;

public class CreateAuction  implements Operation  {

	private String name;
	private Expr seller;
	private Expr auction;

	
	public CreateAuction(String name, Context ctx) {
		this.name=name;
		try {
			this.seller = ctx.MkConst("seller", ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")));
			this.auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));	
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
		
		Sort[] args =  new Sort[1];		   	    
		args[0] =ctx.MkIntSort();
		 
	    Symbol[] argsname = new Symbol[1];
	    argsname[0] =  ctx.MkSymbol("auctionLimit");
		
		Expr[] argSeller = new Expr[2];
		argSeller[0]=seller;
		argSeller[1]=(IntExpr) ctx.MkConst("auctionLimit", ctx.IntSort());
			
		Expr sellerTuple=auctionapp.Seller.MkDecl().Apply(argSeller);
			
		Expr existSeller=ctx.MkSetMembership(sellerTuple, auctionapp.Seller_set);
				
		Expr[] argAuction = new Expr[2];
		argAuction[0]=auction;
		argAuction[1]=auctionapp.state.Consts()[1];
	
	    Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);
	    
		Expr[] argAuction2 = new Expr[2];
		argAuction2[0]=auction;
		argAuction2[1]=auctionapp.state.Consts()[2];

	    Expr auctionTuple2=auctionapp.Auction.MkDecl().Apply(argAuction2);
	
	    	
	   Expr noActive =ctx.MkNot((BoolExpr) ctx.MkSetMembership(auctionTuple, auctionapp.Auction_set));
	        
	   Expr noclosed =ctx.MkNot((BoolExpr) ctx.MkSetMembership(auctionTuple2, auctionapp.Auction_set));
 
	   Expr noHigherState=ctx.MkAnd(new BoolExpr[] {(BoolExpr) noActive, (BoolExpr) noclosed});
		    

	   Expr precondition=ctx.MkAnd(new BoolExpr [] {(BoolExpr) existSeller,(BoolExpr) noHigherState});
		
	    return (BoolExpr) precondition;
		
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		
		auctionapp.AuctionID_set= ctx.MkSetAdd(auctionapp.AuctionID_set, auction);
		
		Expr[] argAuction = new Expr[2];
		argAuction[0]=auction;
		argAuction[1]=auctionapp.state.Consts()[0];
		
	    Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);
	    auctionapp.Auction_set= ctx.MkSetAdd(auctionapp.Auction_set,auctionTuple);  
	    
        Expr[] argPromoter = new Expr[2];
        argPromoter[0]=auction;
        argPromoter[1]=seller;

		
        Expr promoter =auctionapp.Promoter.MkDecl().Apply(argPromoter);
        auctionapp.Promoter_set =  ctx.MkSetAdd(auctionapp.Promoter_set,promoter );
        
		Sort[] arg = new Sort[1];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("Product"));

		Symbol[] namesb = new Symbol[1];
		namesb[0] =  ctx.MkSymbol("product");

	    return  auctionapp.Auction_set ;
	    
	}

	@Override
	public Expr [] getArgs(String name) {
		Expr args[]= {this.auction, this.seller};
		return args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		if (op.getName()=="CloseAuction") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.auction));
		}
		else if (op.getName()=="StartAuction") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.auction));
		}
		else if (op.getName()=="UnregisterSeller") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.seller));
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
