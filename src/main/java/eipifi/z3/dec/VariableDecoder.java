package eipifi.z3.dec;

import com.microsoft.z3.Expr;
import eipifi.lispy.Par;
import eipifi.z3.utils.BaseDecoder;
import eipifi.z3.utils.Check;
import eipifi.z3.utils.Context;

@Check(names = "var", arity = 1)
public class VariableDecoder extends BaseDecoder {
    @Override
    public Expr decode(Par par, Context ctx) {
        Par name = par.child(0);
        assert name.isAtom();
        return ctx.get(name.toString());
    }
}
