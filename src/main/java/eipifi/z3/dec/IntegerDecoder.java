package eipifi.z3.dec;

import com.microsoft.z3.IntExpr;
import eipifi.lispy.Par;
import eipifi.z3.utils.BaseDecoder;
import eipifi.z3.utils.Check;
import eipifi.z3.utils.Context;

@Check(regexp = "-?[0-9]+", arity = 0)
public class IntegerDecoder extends BaseDecoder {
    @Override
    public IntExpr decode(Par par, Context ctx) {
        return z3().mkInt(par.name());
    }
}
