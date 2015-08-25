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
import evaluation.courseware.courseware;
import application.Operation;

public class StartAuction  implements Operation {
	
	
	private String name;
	private Expr auction;
	private Expr lot;

	public StartAuction(String name, Context ctx) {
		this.name=name;
		try {
			this.auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));	
			 this.lot = ctx.MkConst("lot", ctx.MkUninterpretedSort(ctx.MkSymbol("LotID")));
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
		
    	Sort[] productarg = new Sort[1];
		productarg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("Product"));
		Symbol[] namesa = new Symbol[1];
		namesa[0] =  ctx.MkSymbol("product");
		
        Expr[] argLot = new Expr[4];
        argLot[0]=lot;
        argLot[1]=auction;
        argLot[2]=product;
        argLot[3]=ctx.MkConst("lotSize", ctx.IntSort());
		
        Expr lotTuple =auctionapp.Lot.MkDecl().Apply(argLot);
             
   	    Expr lotSizeBound= ctx.MkGe((ArithExpr) argLot[3], ctx.MkInt("0")) ;
   	    Expr lotExists= (BoolExpr) ctx.MkSetMembership(lotTuple,auctionapp.Lot_set );
        
		Expr existLots = ctx.MkExists(productarg, namesa, lotSizeBound, 1, null, null,
		null, null);	

	    Expr auctionId = ctx.MkConst("auction1", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
	    
		Sort[] auctions = new Sort[1];
		auctions[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));
		Symbol[] namess = new Symbol[1];
		namess[0] =  ctx.MkSymbol("auction1");
		
		Expr[] argAuction = new Expr[2];
		argAuction[0]=auctionId;
		argAuction[1]=auctionapp.state.Consts()[1];
		
	    Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);

    
     //   Expr noclosed =ctx.MkAnd(new BoolExpr [] {
    //    		(BoolExpr) ctx.MkEq(auction, auctionId), (BoolExpr) ctx.MkSetMembership(auctionTuple, auctionapp.Auction_set)
     //   });
        
	//	Expr existAuction1 = ctx.MkNot(ctx.MkExists(auctions, namess, noclosed, 1, null, null,
	//	null, null));	
		
	    
		Expr[] argAuction2 = new Expr[2];
		argAuction2[0]=auction;
		argAuction2[1]=auctionapp.state.Consts()[2];

	    Expr auctionTuple2=auctionapp.Auction.MkDecl().Apply(argAuction2);
	
	    	
	   Expr noActive =ctx.MkNot((BoolExpr) ctx.MkSetMembership(auctionTuple, auctionapp.Auction_set));
	        
	   Expr noclosed =ctx.MkNot((BoolExpr) ctx.MkSetMembership(auctionTuple2, auctionapp.Auction_set));
 
	   Expr noHigherState=ctx.MkAnd(new BoolExpr[] {(BoolExpr) noActive, (BoolExpr) noclosed});
		
	
	    BoolExpr precondition=ctx.MkAnd(new BoolExpr[] {(BoolExpr) lotExists,(BoolExpr) noHigherState });
	    
	    return  (BoolExpr) precondition;
	    
	}

	@Override
	public Expr effect(Context ctx) throws Z3Exception {
			
		Expr[] argAuction = new Expr[2];
		argAuction[0]=auction;
		argAuction[1]=auctionapp.state.Consts()[1];
	

	    Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);	    
	    auctionapp.Auction_set= ctx.MkSetAdd(auctionapp.Auction_set,auctionTuple);  
	    
		Expr[] argAuction2 = new Expr[2];
		argAuction2[0]=auction;
		argAuction2[1]=auctionapp.state.Consts()[0];;
	    
	    Expr auctionTuple2=auctionapp.Auction.MkDecl().Apply(argAuction2);	    
	    auctionapp.Auction_set= ctx.MkSetDel(auctionapp.Auction_set,auctionTuple2);  
	    
		Expr[] argAuctionLot = new Expr[2];
		argAuctionLot[0]=auction;
		argAuctionLot[1]=lot;
	    
	    Expr auctionLotTuple=auctionapp.auctionLot.MkDecl().Apply(argAuctionLot);	  

	    auctionapp.auctionLot_set= ctx.MkSetAdd(auctionapp.auctionLot_set,auctionLotTuple);  

	    return  auctionapp.Auction_set ;
	}

	@Override
	public Expr [] getArgs(String name) {
		Expr args[]={this.auction};
		return args ;
	}

	@Override
	public BoolExpr getCondition(Context ctx, Operation op) throws Z3Exception {
		
		if (op.getName()=="RemoveFromLot") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.auction));
		}
		else if (op.getName()=="CloseAuction") {
			return ctx.MkNot(ctx.MkEq(op.getArgs(this.name)[0], this.auction));
		}		
		else if (op.getName()=="StartAuction") {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getReplicaIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Expr[] getConditions(Context ctx, Operation op) throws Z3Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
