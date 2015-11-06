package eipifi.z3.dec;

import eipifi.lispy.Par;
import eipifi.z3.utils.BaseDecoder;
import eipifi.z3.utils.Check;
import eipifi.z3.utils.Context;

@Check(names = "or")
public class OrDecoder extends BaseDecoder {
    @Override
    public Object decode(Par par, Context ctx) {
        return z3().mkOr(ctx.decodeBool(par.values()));
    }
}
