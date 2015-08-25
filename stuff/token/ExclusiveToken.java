package token;

import com.microsoft.z3.*;

public class ExclusiveToken extends TokenObj {
	
	
	 public ExclusiveToken() {

	 }
	
    public ExclusiveToken(IntExpr id,Expr data) {
        super(id,data);
    	this.tokenType=TokenType.Exclusive;
    }
    
    public ExclusiveToken(Expr data) {
    	super(data);
    	this.tokenType=TokenType.Exclusive;
    }
    
    public ExclusiveToken(Expr data, String type) {
    	super(data,type);
    	this.tokenType=TokenType.Exclusive;
    }
  
    public  BoolExpr conflict(TokenObj t,Context ctx) throws Z3Exception{
    	BoolExpr conf = null;
        if(t.getObjectType()==this.getObjectType()) {      	   
    	      conf=ctx.MkEq(this.getData(), t.getData());
    	      return conf;
        }
       return ctx.MkFalse();
    		
    }

}
