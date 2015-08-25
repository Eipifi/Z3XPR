package evaluation.auction.operations;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.SetSort;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import evaluation.auction.productObj;
import application.Operation;

public class AddToLot  implements Operation {
	
	private String name;
	private Expr product;
	private Expr seller;
	private Expr auction;
	private Expr quantity;
	private Expr stockIndex;
	private Expr lot;

	public AddToLot(String name, Context ctx) {
		this.name=name;
		try {
			this.seller = ctx.MkConst("seller", ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")));
			this.auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
			this.lot = ctx.MkConst("lot", ctx.MkUninterpretedSort(ctx.MkSymbol("LotID")));
			this.quantity=(IntExpr) ctx.MkConst("lotSize", ctx.IntSort());		
			productObj p=new productObj (ctx);
	        this.product=p.getProduct();
	        this.stockIndex=(IntExpr) p.getIndex();			
		} catch (Z3Exception e) {
			e.printStackTrace();
		}
	}

	public AddToLot() {

   }

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr precondition(Context ctx) throws Z3Exception {
	
	 	Expr existProduct=ctx.MkSetMembership(product, auctionapp.Product_set);
			
		Expr stock= ctx.MkSelect(auctionapp.stockArray, stockIndex);		
		Expr stockLimit=ctx.MkGe((ArithExpr) stock, ctx.MkInt("1"));
	 	
	    Expr productLimit=ctx.MkAnd(new BoolExpr[] {(BoolExpr) existProduct,(BoolExpr) stockLimit});
		
	
	    Expr[] argSeller = new Expr[2];
	    argSeller[0]=seller;
	    argSeller[1]=ctx.MkConst("auctionLimit", ctx.IntSort());
	    
		Expr sellerTuple=auctionapp.Seller.MkDecl().Apply(argSeller);
	   	
		Expr existSeller=ctx.MkSetMembership(sellerTuple, auctionapp.Seller_set);
		    
	 	Expr limitExpr=ctx.MkGt((ArithExpr)argSeller[1],(ArithExpr) quantity);	
	 	
	 	Expr sellerConst=ctx.MkAnd(new BoolExpr [] {(BoolExpr) existSeller, (BoolExpr) limitExpr, (BoolExpr) ctx.MkSetMembership(seller, auctionapp.SellerID_set)});
	   
		Expr[] argOwner = new Expr[2];
		argOwner[0]= product;
		argOwner[1]=seller;

	    Expr Owner=auctionapp.Owner.MkDecl().Apply(argOwner);
      
		Expr[] argPromoter = new Expr[2];
		argPromoter[0]= auction;;
		argPromoter[1]=seller;

	    Expr Promoter=auctionapp.Promoter.MkDecl().Apply(argPromoter);
	    
	    Expr existOwner=ctx.MkSetMembership(Owner, auctionapp.Owner_set);
	    Expr existPromoter=ctx.MkSetMembership(Promoter, auctionapp.Promoter_set);       
	    
	 	Expr[] argAuction = new Expr[2];
	 	argAuction[0]= auction;;
	 	argAuction[1]=auctionapp.state.Consts()[2];

	 	Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);
	 	
	 	Expr[] argAuction2 = new Expr[2];
	 	argAuction2[0]= auction;;
	 	argAuction2[1]=auctionapp.state.Consts()[1];

	 	Expr auctionTuple2=auctionapp.Auction.MkDecl().Apply(argAuction2);
	 	
	 //	Expr activeState=ctx.MkOr(new BoolExpr [] {ctx.MkEq(argAuction[1], auctionapp.state.Consts()[1]),ctx.MkEq(argAuction[1], auctionapp.state.Consts()[2])});
	 		 	
	 	Expr activeState=ctx.MkNot((BoolExpr) ctx.MkSetMembership(auctionTuple, auctionapp.Auction_set));
	 	Expr closeState=ctx.MkNot((BoolExpr) ctx.MkSetMembership(auctionTuple2, auctionapp.Auction_set));
	    		
	 	BoolExpr precondition=ctx.MkAnd(new BoolExpr[]{(BoolExpr) existOwner, (BoolExpr) existPromoter, (BoolExpr) sellerConst, 
	 			(BoolExpr) productLimit, (BoolExpr) activeState,(BoolExpr) closeState  });
	 	
		return   precondition ;
	}
	
	@Override
	public Expr effect(Context ctx) throws Z3Exception {
		
		Expr[] argLot = new Expr[4];
		argLot[0]=lot;
		argLot[1]=auction;
		argLot[2]=product;
		argLot[3]=quantity;
			
	    Expr lotTuple =auctionapp.Lot.MkDecl().Apply(argLot);
	    auctionapp.Lot_set = ctx.MkSetAdd(auctionapp.Lot_set, lotTuple );		
	     
	    Expr stock= ctx.MkSelect(auctionapp.stockArray, stockIndex);	
	    stock=(IntExpr) ctx.MkSub(new ArithExpr[] {(ArithExpr) stock,ctx.MkInt("1")});
	    auctionapp.stockArray=ctx.MkStore(auctionapp.stockArray, stockIndex, stock);

		return  auctionapp.Lot_set ;
	}

	@Override
	public Expr [] getArgs(String name) {
		Expr args[]={this.auction, this.seller, this.product};
		return args;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		
		if (op.getName()=="StartAuction") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.auction));
		}
		else if (op.getName()=="RemoveAuction") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.auction));
		}
		else if (op.getName()=="UnregisterSeller") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.seller));
		}
		
		else if (op.getName()=="RemoveProduct") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.product));
		}
		
		else if (op.getName()=="AddToLot") {
			return ctx.MkAnd(new BoolExpr [] {ctx.MkNot( (BoolExpr)ctx.MkEq(op.getArgs(this.name)[1], this.seller)), 
					(BoolExpr) ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.auction)) });
		}
		
		else if (op.getName()=="CloseAuction") {
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
