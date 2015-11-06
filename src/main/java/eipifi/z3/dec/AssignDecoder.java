package eipifi.z3.dec;

import eipifi.lispy.Par;
import eipifi.z3.utils.Check;
import eipifi.z3.utils.CheckDecoder;
import eipifi.z3.utils.Context;

@Check(names = "assign", arity = 2)
public class AssignDecoder implements CheckDecoder {
    @Override
    public Object decode(Par par, Context ctx) {
        assert par.child(0).isAtom();
        ctx.set(par.child(0).name(), ctx.decode(par.child(1)));
        return null;
    }
}
