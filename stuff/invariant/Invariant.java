package invariant;

import com.microsoft.z3.*;

public interface Invariant {
	
    public abstract String getName();
 
    public abstract BoolExpr getInv(Context ctx ) throws Z3Exception ;
  
}
