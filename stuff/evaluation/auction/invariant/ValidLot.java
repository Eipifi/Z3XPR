

package evaluation.auction.invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import evaluation.courseware.courseware;
import invariant.Invariant;

public class ValidLot implements Invariant  {

	String name;
	
	public ValidLot(String name) {
	
		this.name=name;
	}
	
	public ValidLot() {	
	}


	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		Expr seller = ctx.MkConst("seller", ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")));	
		Expr auction = ctx.MkConst("auction", ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")));
		Expr lot = ctx.MkConst("lot", ctx.MkUninterpretedSort(ctx.MkSymbol("LotID")));		
		Expr product = ctx.MkConst("product", ctx.MkUninterpretedSort(ctx.MkSymbol("Product")));
		
		Sort[] arg = new Sort[2];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID"));
		arg[1]=ctx.MkUninterpretedSort(ctx.MkSymbol("LotID"));		

		Symbol[] namesb = new Symbol[2];
		namesb[0] =  ctx.MkSymbol("auction");
		namesb[1] =  ctx.MkSymbol("lot");
		
		Expr[] argAuction = new Expr[2];
		argAuction[0]=auction;
		argAuction[1]=ctx.MkConst("state", auctionapp.state);

	    Expr auctionTuple=auctionapp.Auction.MkDecl().Apply(argAuction);	    

		Expr[] argAuctionLot = new Expr[2];
		argAuctionLot[0]=auction;
		argAuctionLot[1]=lot;

	    Expr auctioLlotTuple=auctionapp.auctionLot.MkDecl().Apply(argAuctionLot);
	    		   
	    Sort[] arg2 = new Sort[1];
	    arg2[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID"));

		Symbol[] namesb2 = new Symbol[1];
    	namesb2[0] =  ctx.MkSymbol("seller");
	    
		Expr[] argLot = new Expr[3];
		argLot[0]= lot;
		argLot[1]=product;
		argLot[2]=ctx.MkConst("lotSize", ctx.MkIntSort());;

	    Expr lotTuple=auctionapp.Lot.MkDecl().Apply(argLot);
	    
	    
	    Expr lotExist=(BoolExpr) ctx.MkSetMembership(lotTuple, auctionapp.Lot_set);
	    Expr auctionExist= (BoolExpr) ctx.MkSetMembership(auctionTuple, auctionapp.Auction_set);
	    
		Expr[] argPromoter = new Expr[2];
		argPromoter[0]= auction;
		argPromoter[1]=seller;

	    Expr Promoter=auctionapp.Promoter.MkDecl().Apply(argPromoter);
	        
		Expr[] argOwner = new Expr[2];
		argOwner[0]= product;
		argOwner[1]=seller;

	    Expr Owner=auctionapp.Owner.MkDecl().Apply(argOwner);
	    
		Expr foriegn2 = ctx.MkExists(arg2, namesb2, ctx.MkAnd(new BoolExpr []{(BoolExpr) ctx.MkSetMembership(Promoter, auctionapp.Promoter_set),
				(BoolExpr) ctx.MkSetMembership(Owner, auctionapp.Owner_set)}), 1, null, null,
		null, null);	  
		
		
	    Expr rr= ctx.MkAnd(new BoolExpr []{(BoolExpr) lotExist,(BoolExpr) auctionExist,(BoolExpr) foriegn2});
	    
		Expr foriegn3 =  ctx.MkAnd( new BoolExpr[]{(BoolExpr) ctx.MkSetMembership(auction, auctionapp.AuctionID_set),
				(BoolExpr) ctx.MkSetMembership(product, auctionapp.Product_set)});
	

	    Expr ownership2 =ctx.MkImplies( (BoolExpr)ctx.MkSetMembership(lot, auctionapp.auctionLot_set), (BoolExpr) rr );
	    		
	    
		Expr foriegn = ctx.MkForall(arg, namesb, ownership2, 1, null, null,
		null, null);	

		System.out.println("Valid Lot"+foriegn);
		
		return (BoolExpr) foriegn;
	}

}
