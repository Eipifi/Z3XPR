package eipifi.z3.dec;

import eipifi.lispy.Par;
import eipifi.z3.utils.BaseDecoder;
import eipifi.z3.utils.Check;
import eipifi.z3.utils.Context;

@Check(names = "and")
public class AndDecoder extends BaseDecoder {
    @Override
    public Object decode(Par par, Context ctx) {
        return z3().mkAnd(ctx.decodeBool(par.values()));
    }
}
