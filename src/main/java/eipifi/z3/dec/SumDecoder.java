package eipifi.z3.dec;

import com.microsoft.z3.ArithExpr;
import eipifi.lispy.Par;
import eipifi.z3.utils.BaseDecoder;
import eipifi.z3.utils.Check;
import eipifi.z3.utils.Context;

@Check(names = "sum", arityMin = 2)
public class SumDecoder extends BaseDecoder {
    @Override
    public ArithExpr decode(Par par, Context ctx) {
        ArithExpr[] args = ctx.decodeArith(par.values());
        return z3().mkAdd(args);
    }
}
