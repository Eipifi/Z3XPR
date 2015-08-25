package tokeng;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Z3Exception;

public interface Token {
	
	public  Expr[] getArgus() ;
	
	public BoolExpr conflict(Token t, Context ctx) throws Z3Exception ;
	
	
	public Expr Gaurantee(Context ctx);
	
	
	
	

}


