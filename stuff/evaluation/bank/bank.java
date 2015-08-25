package evaluation.bank;

import invariant.Invariant;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.z3.ArrayExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.SetSort;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.TupleSort;
import com.microsoft.z3.Z3Exception;

import evaluation.bank.invariant.BoundedInv;
import evaluation.bank.operations.AddAccount;
import evaluation.bank.operations.Debit;
import evaluation.bank.operations.Deposit;
import evaluation.bank.operations.Interest;
import evaluation.bank.operations.Transit;
import application.Application;
import application.Operation;

public class bank extends Application {
		
	public static Sort Customer; 
	public static Sort AccountID; 	
	public static TupleSort Account;
	
	public static Sort Operation; 
	

	public static Expr Customer_set;
	public static Expr AccountID_set;
	public static Expr Account_set; 
	
	public static Expr Operation_set;
	
	public static List<Operation> op=new ArrayList<Operation>();
	public static List<Invariant> inv=new ArrayList<Invariant>();
    public static Sort array_type ;
    public static ArrayExpr capacityArray;
    
    public static  Expr[][] matrix;

	@Override
	public BoolExpr getCompoisteInvariant(Context ctx) throws Z3Exception {
		
		BoolExpr composite=ctx.MkTrue();
		for (Invariant i:inv )
		 composite=	ctx.MkAnd(new BoolExpr []{composite, (BoolExpr) i.getInv(ctx)});		
		return composite;
	}

	@Override
	public List<Operation> loadOperations(Context ctx) throws Z3Exception {
		
		Operation o1=new Deposit("Deposit",ctx);
		Operation o2=new Debit("Debit",ctx);
		Operation o3=new Transit("Transit",ctx);
		Operation o4=new AddAccount("AddAccount",ctx);
		Operation o5=new Interest("Interest",ctx);
	
		op.add(o1);
		op.add(o2);
		op.add(o3);
		op.add(o4);
		op.add(o5);

		return op;
	}

	@Override
	public List<Invariant> loadInvariants(Context ctx) throws Z3Exception {
		
		Invariant inv1=new BoundedInv("BoundedInv");

        inv.add(inv1);
       
        return inv;
	}

	@Override
	public void initializeState(Context ctx) throws Z3Exception {
		
		Customer = ctx.MkUninterpretedSort("Customer");
	    AccountID = ctx.MkUninterpretedSort("AccountID");

	    SetSort cc=ctx.MkSetSort(Customer);
	    Customer_set = ctx.MkConst("Customer_set",cc);
	    
	    Operation = ctx.MkUninterpretedSort("Operation");
	    SetSort oo=ctx.MkSetSort(Operation);
	    Operation_set = ctx.MkConst("Operation_set",oo);

	    SetSort aa=ctx.MkSetSort(AccountID);
	    AccountID_set = ctx.MkConst("AccountID_set",aa);

		Account= ctx.MkTupleSort(ctx.MkSymbol("mk_Account_tuple"), // name of
			  	    new Symbol[] { ctx.MkSymbol("first"), ctx.MkSymbol("second"),  ctx.MkSymbol("third") }, // names
			  	    new Sort[] { ctx.MkUninterpretedSort(ctx.MkSymbol("AccountID")), ctx.MkUninterpretedSort(ctx.MkSymbol("Customer")), ctx.MkIntSort()} );
			  	    
		SetSort at=ctx.MkSetSort(Account);
		Account_set= ctx.MkConst("Account_set",at);
	
        array_type = ctx.MkArraySort(ctx.MkIntSort(), ctx.MkIntSort());
        capacityArray = (ArrayExpr) ctx.MkConst("capacityArray", array_type);   
        
        



	}
	
	
	public Expr [][] getConcurrenyMatrix (Context ctx) throws Z3Exception {
		matrix = new Expr[6][6];
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		matrix[0][0]=ctx.MkConst("Operations", ctx.MkUninterpretedSort(ctx.MkSymbol("Operation")));
		matrix[0][1]= ctx.MkConst("Deposit", ctx.MkUninterpretedSort(ctx.MkSymbol("Operation")));
		matrix[0][2]= ctx.MkConst("Debit", ctx.MkUninterpretedSort(ctx.MkSymbol("Operation")));
		matrix[0][3]= ctx.MkConst("Transit", ctx.MkUninterpretedSort(ctx.MkSymbol("Operation")));
		matrix[0][4]= ctx.MkConst("AddAccount", ctx.MkUninterpretedSort(ctx.MkSymbol("Operation")));
		matrix[0][5]= ctx.MkConst("Interest", ctx.MkUninterpretedSort(ctx.MkSymbol("Operation")));
		matrix[1][0]= ctx.MkConst("Deposit", ctx.MkUninterpretedSort(ctx.MkSymbol("Operation")));
		matrix[2][0]= ctx.MkConst("Debit", ctx.MkUninterpretedSort(ctx.MkSymbol("Operation")));
		matrix[3][0]= ctx.MkConst("Transit", ctx.MkUninterpretedSort(ctx.MkSymbol("Operation")));
		matrix[4][0]= ctx.MkConst("AddAccount", ctx.MkUninterpretedSort(ctx.MkSymbol("Operation")));
		matrix[5][0]= ctx.MkConst("Interest", ctx.MkUninterpretedSort(ctx.MkSymbol("Operation")));
    

    
		for(int line=1 ; line < 6; line++){
			for(int column = 1; column < 6 ; column ++){
				matrix[line][column]=op.get(line-1).getConditions(ctx,op.get(0).concurrentOps(ctx).get(column-1))[column-1];
			}
		}
	
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++)
				System.out.print(matrix[i][j] + " |");
			System.out.println();
			
		}
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");	
        return matrix;
     
	}
	
	
	public static void main(String[] args)  throws Z3Exception {
		
		bank b=new bank();
		
		Context ctx=new Context();
		
		Operation o1=new Deposit("Deposit",ctx);
		Operation o2=new Debit("Debit",ctx);
		Operation o3=new Transit("Transit",ctx);
		
		op.add(o1);
		op.add(o2);
		op.add(o3);  
		
		b.initializeState(ctx);
		
		
	}
	

}
