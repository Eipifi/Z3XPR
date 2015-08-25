package evaluation.auction.operations;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import evaluation.courseware.courseware;
import application.Operation;

public class RegisterSeller   implements Operation {
	
	private String name;
	private Expr seller;
	private IntExpr auctionLimit;
	
	public RegisterSeller(String name, Context ctx) {
		this.name=name;
		try {
			this.seller = ctx.MkConst("seller", ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")));
			this.auctionLimit=(IntExpr) ctx.MkConst("auctionLimit", ctx.IntSort());
			
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
		return ctx.MkTrue();
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		
		auctionapp.SellerID_set= ctx.MkSetAdd(auctionapp.SellerID_set, seller);
		
		Expr[] argSeller = new Expr[2];
		argSeller[0]=seller;
		argSeller[1]=auctionLimit;		
	    Expr sellerTuple =auctionapp.Seller.MkDecl().Apply(argSeller);

	    auctionapp.Seller_set= ctx.MkSetAdd(auctionapp.Seller_set,sellerTuple);        
	    return  auctionapp.Seller_set ;
	}

	@Override
	public Expr [] getArgs(String name) {
		Expr args []={this.seller};
		return args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		return ctx.MkTrue();
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
