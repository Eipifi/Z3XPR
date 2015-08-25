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

public class UnregisterSeller  implements Operation {

	
	private String name;
	private Expr seller;

	
	public UnregisterSeller(String name, Context ctx) {
		this.name=name;
		try {
			this.seller = ctx.MkConst("seller", ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")));			
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
		auctionarg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));
		Symbol[] namesa = new Symbol[1];
		namesa[0] =  ctx.MkSymbol("auction");
		
        Expr[] argPromoter = new Expr[2];
        argPromoter[0]=auction;
        argPromoter[1]=seller;	
		
        Expr promoter =auctionapp.Promoter.MkDecl().Apply(argPromoter);
        Expr noPormoter = ctx.MkNot((BoolExpr) ctx.MkSetMembership(promoter,auctionapp.Promoter_set ));
		Expr existAuction = ctx.MkForall(auctionarg, namesa, noPormoter, 1, null, null,
		null, null);	
		
		Expr product = ctx.MkConst("product", ctx.MkUninterpretedSort(ctx.MkSymbol("Product")));	

		Sort[] productarg = new Sort[1];
		productarg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("Product"));
		Symbol[] namesp = new Symbol[1];
		namesp[0] =  ctx.MkSymbol("product");
		
        Expr[] argOnwer = new Expr[2];
        argOnwer[0]=product;
        argOnwer[1]=seller;

        Expr owner =auctionapp.Owner.MkDecl().Apply(argOnwer);
        Expr noOwner = ctx.MkNot((BoolExpr) ctx.MkSetMembership(owner,auctionapp.Owner_set ));
		Expr existProduct = ctx.MkForall(productarg, namesp, noOwner, 1, null, null,
		null, null);	
		
		Expr precondition=ctx.MkAnd(new BoolExpr[]{(BoolExpr) existAuction,(BoolExpr) existProduct});
				
  	    return (BoolExpr) precondition;
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		auctionapp.SellerID_set= ctx.MkSetDel(auctionapp.SellerID_set, seller);
	    
	    Expr limit = ctx.MkConst("auctionLimit", ctx.MkIntSort());	

		Sort[] limitarg = new Sort[1];
		limitarg[0]=ctx.MkIntSort();
		Symbol[] namesa = new Symbol[1];
		namesa[0] =  ctx.MkSymbol("auctionLimit");
		
		Expr[] argSeller = new Expr[2];
		argSeller[0]=seller;
		argSeller[1]=limit;		
	    Expr sellerTuple =auctionapp.Seller.MkDecl().Apply(argSeller);
	    auctionapp.Seller_set=ctx.MkSetDel(auctionapp.Seller_set,sellerTuple);
	    

	  	// return  auctionapp.Owner_set ;

  	    return (auctionapp.SellerID_set);
	}

	@Override
	public Expr [] getArgs(String name) {
		Expr args[]={this.seller};
		return  args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		
		if (op.getName()=="AddProduct") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.seller));
		}
		else if (op.getName()=="CreateAuction") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[1], this.seller));
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
