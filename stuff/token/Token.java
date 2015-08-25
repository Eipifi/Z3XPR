package token;

import com.microsoft.z3.*;

/**
 * Common interface for tokens.
 * Tokens are defined over the state of data items(objects) 
 * either all or a part of that.
 * @author Najafzadeh
 *
 * @param <T> 
 */

public interface Token {

    /**
     * Return the identifier of the token.
     * @return the identifier of the token
     */
    public IntExpr getID();
      
    /**
     * Return the state of data item  that the token is acquired over.
     * @return  An expression in Z3 specifying the state of data item  
     */
    public Expr getData() ;

    /**
     * Check whether the token conflicts with a specified token.  
     * @param t a specified token
     * @param ctx Z3 context
     * @return true if the tokens conflict 
     * @throws Z3Exception  the exception base class for error reporting from Z3
     */
    public BoolExpr conflict(TokenObj t, Context ctx)  throws Z3Exception;
    
    
}