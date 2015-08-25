package evaluation.auction;

import invariant.Invariant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.microsoft.z3.ArrayExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Constructor;
import com.microsoft.z3.Context;
import com.microsoft.z3.DatatypeSort;
import com.microsoft.z3.EnumSort;
import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.SetSort;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.TupleSort;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.invariant.ForeignKeyBidder;
import evaluation.auction.invariant.ForeignKeyLot;
import evaluation.auction.invariant.ForeignKeyOwner;
import evaluation.auction.invariant.ForeignKeyPromoter;
import evaluation.auction.invariant.ForeignKeyWinner;
import evaluation.auction.invariant.LotExist;
import evaluation.auction.invariant.LotLimit;
import evaluation.auction.invariant.StateInvariant;
import evaluation.auction.invariant.StockLimit;
import evaluation.auction.invariant.ValidAuction;
import evaluation.auction.invariant.ValidLot;
import evaluation.auction.invariant.WinnerRule1;
import evaluation.auction.invariant.WinnerRule2;
import evaluation.auction.invariant.LotInvariant;
import evaluation.auction.operations.AddBid;
import evaluation.auction.operations.AddProduct;
import evaluation.auction.operations.AddToLot;
import evaluation.auction.operations.CloseAuction;
import evaluation.auction.operations.CreateAuction;
import evaluation.auction.operations.RegisterBuyer;
import evaluation.auction.operations.RegisterSeller;
import evaluation.auction.operations.RemoveAuction;
import evaluation.auction.operations.RemoveBid;
import evaluation.auction.operations.RemoveFromLot;
import evaluation.auction.operations.RemoveProduct;
import evaluation.auction.operations.StartAuction;
import evaluation.auction.operations.UnregisterBuyer;
import evaluation.auction.operations.UnregisterSeller;
import application.Application;
import application.Operation;

public class auctionapp extends Application  {

	public static Sort Buyer; 
	public static Sort SellerID;
	public static Sort Product; 
	public static Sort AuctionID; 
	public static Sort BidID; 
	public static Sort LotID; 
	
	public static TupleSort Seller;
	public static TupleSort Auction;
	public static TupleSort Lot;
	public static TupleSort Bid;
	public static TupleSort Winner;
	public static TupleSort Owner;
	public static TupleSort Promoter;
	public static TupleSort Bidder;
	public static TupleSort auctionLot;
	
	public static EnumSort state;
	
	public static DatatypeSort pair;
	  
	public static Constructor mkpair;
	
	public static Expr Buyer_set;
	public static Expr SellerID_set;
	public static Expr Seller_set;
	public static Expr Product_set; 
	public static Expr Auction_set;
	public static Expr AuctionID_set;
	public static Expr Lot_set;
	public static Expr Bid_set;
	public static Expr BidID_set;
	public static Expr LotID_set;	
	public static Expr Winner_set;
	public static Expr Owner_set;
	public static Expr Promoter_set;
	public static Expr Bidder_set;
	public static Expr auctionLot_set;
	
    public static Sort array_type ;
    public static ArrayExpr stockArray;
    public static ArrayExpr sizeArray;
	
	public static List<Operation> op=new ArrayList<Operation>();
	static List<Invariant> inv=new ArrayList<Invariant>();
  
	
	@Override
	public List<Operation> loadOperations(Context ctx) throws Z3Exception {
		
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
	public List<Invariant> loadInvariants(Context ctx) throws Z3Exception {
		Invariant inv1=new ForeignKeyBidder("ForeignKeyBidder");
		Invariant inv2=new ForeignKeyLot("ForeignKeyLot");
		Invariant inv3=new ForeignKeyOwner("ForeignKeyOwner");
		Invariant inv4=new ForeignKeyPromoter("ForeignKeyPromoter");
		Invariant inv5=new ForeignKeyWinner("ForeignKeyWinner");
		Invariant inv6=new LotExist("LotExist");
		Invariant inv7=new ValidAuction("ValidAuction");
		Invariant inv8=new StockLimit("StockLimit");
		Invariant inv9=new WinnerRule1("WinnerRule1");
		Invariant inv10=new WinnerRule2("WinnerRule2");
		Invariant inv11= new LotInvariant("lotsInvarinat");
		Invariant inv12= new StateInvariant("StateInvariant");
				
        inv.add(inv1);
        inv.add(inv2);
        inv.add(inv3);
        inv.add(inv4);;
        inv.add(inv5);
        inv.add(inv6); 
        inv.add(inv7);
        inv.add(inv8);
        inv.add(inv9);
        inv.add(inv10);  
        inv.add(inv11);     
        inv.add(inv12);
        
        return inv;
	}

	@Override
	public void initializeState(Context ctx) throws Z3Exception {
		
		
		Symbol name = ctx.MkSymbol("state");
				
		Symbol[] args={ ctx.MkSymbol("prep"),
                ctx.MkSymbol("active"), ctx.MkSymbol("close")} ;
		
		state= ctx.MkEnumSort(name, args);
		
		Buyer = ctx.MkUninterpretedSort("Buyer");
		Product = ctx.MkUninterpretedSort("Product");
	    SellerID = ctx.MkUninterpretedSort("SellerID");
	    AuctionID = ctx.MkUninterpretedSort("AuctionID");

	    BidID=ctx.MkUninterpretedSort("BidID");
	    
	    LotID=ctx.MkUninterpretedSort("LotID");
	    
	    SetSort bb=ctx.MkSetSort(Buyer);
	    Buyer_set = ctx.MkConst("Buyer_set",bb);
	    
	    SetSort ss=ctx.MkSetSort(SellerID);
	    SellerID_set = ctx.MkConst("SellerID_set",ss);
	    
	    SetSort aa=ctx.MkSetSort(AuctionID);
	    AuctionID_set = ctx.MkConst("AuctionID_set",aa);
	    
	    SetSort pp=ctx.MkSetSort(Product);
	    Product_set = ctx.MkConst("Product_set",pp);
	    
	    SetSort ii=ctx.MkSetSort(BidID);
	    BidID_set = ctx.MkConst("BidID_set",ii);  
	    
    
	    Seller= ctx.MkTupleSort(ctx.MkSymbol("mk_Seller_tuple"), // name of
	  	      new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second") }, // names
	  	      new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")), ctx.MkIntSort()  } );
	  	    
	  	 SetSort st=ctx.MkSetSort(Seller);
	  	 Seller_set = ctx.MkConst("Seller_set",st);
	  	 
	  	 
		 Lot= ctx.MkTupleSort(ctx.MkSymbol("mk_Lot_tuple"), // name of
		  	    new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second") ,  ctx.MkSymbol("third"),  ctx.MkSymbol("forth") }, // names
		  	    new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("LotID")),  ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")), 
			 ctx.MkUninterpretedSort(ctx.MkSymbol("Product")),ctx.MkIntSort()  } );
		  	    
		 SetSort lt=ctx.MkSetSort(Lot);
		  Lot_set = ctx.MkConst("Lot_set",lt);
		 
		  
		 auctionLot=ctx.MkTupleSort(ctx.MkSymbol("mk_AuctionLot_tuple"), // name of
			  	    new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second")  }, // names
			  	    new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")), ctx.MkUninterpretedSort(ctx.MkSymbol("LotID")) } );
			  	    
	     SetSort al=ctx.MkSetSort(auctionLot);
	     auctionLot_set= ctx.MkConst("auctionLot_set",al);
	  
		  
		  
		  
		  Bid= ctx.MkTupleSort(ctx.MkSymbol("mk_Bid_tuple"), // name of
			  	    new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second") ,  ctx.MkSymbol("third") }, // names
			  	    new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")), ctx.MkUninterpretedSort(ctx.MkSymbol("Buyer")),ctx.MkIntSort()  } );
			  	    
		  SetSort bt=ctx.MkSetSort(Bid);
		  Bid_set= ctx.MkConst("Bid_set",bt);
		  
		   
			  
		  Auction= ctx.MkTupleSort(ctx.MkSymbol("mk_Auction_tuple"), // name of
				  	    new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second")  }, // names
				  	    new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")),state } );
				  	    
		  SetSort at=ctx.MkSetSort(Auction);
		  Auction_set= ctx.MkConst("Auction_set",at);
		  
		
		  
		  Winner= ctx.MkTupleSort(ctx.MkSymbol("mk_Winner_tuple"), // name of
			  	    new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second") }, // names
			  	    new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")), ctx.MkUninterpretedSort(ctx.MkSymbol("Buyer"))  } );
	  	    
          SetSort wt=ctx.MkSetSort(Winner);
          Winner_set= ctx.MkConst("Winner_set",wt);
          
          
		  Owner= ctx.MkTupleSort(ctx.MkSymbol("mk_Owner_tuple"), // name of
			  	    new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second") }, // names
			  	    new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("Product")), ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")) } );
	  	    
          SetSort ow=ctx.MkSetSort(Owner);
          Owner_set= ctx.MkConst("Owner_set",ow);
        
		  Promoter= ctx.MkTupleSort(ctx.MkSymbol("mk_Promoter_tuple"), // name of
			  	    new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second") }, // names
			  	    new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("AuctionID")), ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")) } );
	  	    
          SetSort pr=ctx.MkSetSort(Promoter);
          Promoter_set= ctx.MkConst("Promoter_set",pr);
      
		  Bidder= ctx.MkTupleSort(ctx.MkSymbol("mk_Bidder_tuple"), // name of
			  	    new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second") }, // names
			  	    new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("BidID")), ctx.MkUninterpretedSort(ctx.MkSymbol("SellerID")) } );
	  	    
         SetSort bi=ctx.MkSetSort(Bidder);
         Bidder_set= ctx.MkConst("Bidder_set",bi);		  
        
         array_type = ctx.MkArraySort(ctx.MkIntSort(), ctx.MkIntSort());
         stockArray = (ArrayExpr) ctx.MkConst("stockArray", array_type);   
         sizeArray = (ArrayExpr) ctx.MkConst("sizeArray", array_type);   
		  	  	 	
	}

	@Override
	public BoolExpr getCompoisteInvariant(Context ctx) throws Z3Exception {
		
		BoolExpr composite=ctx.MkTrue();
		for (Invariant i:inv )
		 composite=	ctx.MkAnd(new BoolExpr []{composite, (BoolExpr) i.getInv(ctx)});		
		return composite;
	}
	

}
