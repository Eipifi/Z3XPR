package eipifi.z3.dec;

import eipifi.lispy.Par;
import eipifi.z3.utils.BaseDecoder;
import eipifi.z3.utils.Check;
import eipifi.z3.utils.Context;

@Check(names = "xor", arity = 2)
public class XorDecoder extends BaseDecoder{
    @Override
    public Object decode(Par par, Context ctx) {
        return z3().mkXor(ctx.decode(par.child(0)), ctx.decode(par.child(1)));
    }
}
