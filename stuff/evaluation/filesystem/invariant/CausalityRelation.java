package evaluation.filesystem.invariant;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.Z3Exception;

import evaluation.auction.auctionapp;
import evaluation.filesystem.filesystem;
import invariant.Invariant;

public class CausalityRelation implements Invariant{

	
	private String name;
	
	public CausalityRelation(String name) {
		this.name=name;
	}

	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public BoolExpr getInv(Context ctx) throws Z3Exception {
		
			
		Expr node = ctx.MkConst("node1", ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject")));
		
		Sort[] arg = new Sort[1];
		arg[0]=ctx.MkUninterpretedSort(ctx.MkSymbol("FSObject"));

		Symbol[] namesb = new Symbol[1];
		namesb[0] =  ctx.MkSymbol("node1");
	
		
		Expr[] argNode = new Expr[3];
		argNode[0]=node;
		argNode[1]=filesystem.type.Consts()[1];
		argNode[2]=ctx.MkConst("name1", ctx.MkUninterpretedSort(ctx.MkSymbol("Name")));

	    Expr nodeTuple=filesystem.Node.MkDecl().Apply(argNode);	    
	    
	    
	    Expr nodeExist=(BoolExpr) ctx.MkSetMembership(nodeTuple, filesystem.Node_set);


	    Expr ownership2 =ctx.MkImplies( (BoolExpr)ctx.MkSetMembership(node, filesystem.UpdatedFile_set), (BoolExpr) nodeExist );
	    		
	    
		Expr foriegn = ctx.MkForall(arg, namesb, ownership2, 1, null, null,
		null, null);	

		System.out.println("Updated File"+foriegn);
		
		return (BoolExpr) foriegn;
	}

}
