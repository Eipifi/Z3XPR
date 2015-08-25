package token;

import com.microsoft.z3.*;


/**
 * A base class for implementing tokens 
 * @author Najafzadeh
 *
 * @param <T> the generic type of token
 */

public abstract class TokenObj implements Token {

    protected IntExpr id;
    protected Expr[] data;
    protected TokenType tokenType ;
    protected String objType;   
    
    public TokenObj() {
    
    }
    
    public TokenObj(IntExpr id,Expr data) {
        this.id=id;
        this.data=data;
    }
    
    public TokenObj(Expr data) {
    	 this.data=data;
    }
    
    public TokenObj(IntExpr id, Expr data, TokenType tokenType)  {
        this.id=id;
        this.data=data;
        this.tokenType=tokenType; 
    }
    
	public TokenObj(Expr expr, String type) {
		this.data=expr;
		this.objType=type;
	}
    
    public void setValue(Expr  data) {
        this.data=data;
    } 
      
    public Expr getData() {
        return data;   
     } 
    

    public IntExpr getID() {
        return id;
    }
 
    public TokenType getType() {  
        return tokenType;
    }
       
    public String getObjectType() {  
        return objType;
    }
    
    public abstract BoolExpr conflict(TokenObj t,Context ctx) throws Z3Exception;

    
    
}