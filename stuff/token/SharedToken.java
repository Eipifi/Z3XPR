package token;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Z3Exception;

public class SharedToken extends TokenObj  {
	
	public SharedToken() {
	
	}
	
    public SharedToken(IntExpr id,Expr data) {
        super(id,data);
    	this.tokenType=TokenType.Shared;
    }
    
    public SharedToken(Expr data) {
    	super(data);
    	this.tokenType=TokenType.Shared;
    }  

	public SharedToken(Expr expr, String type) {
		super(expr,type);
		this.tokenType=TokenType.Shared;
	}

    public  BoolExpr conflict(TokenObj t,Context ctx) throws Z3Exception{
    	BoolExpr conf = null;
    	if(t.getType()==TokenType.Exclusive )  {
           if(t.getObjectType()==this.getObjectType()) {      	   
    	      conf=ctx.MkEq(this.getData(), t.getData());
    	      return conf;
           }
    	}
        return ctx.MkFalse();		
        
    }	


}
