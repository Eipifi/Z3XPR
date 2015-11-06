package eipifi.z3.dec;

import com.microsoft.z3.Expr;
import eipifi.lispy.Par;
import eipifi.z3.utils.BaseDecoder;
import eipifi.z3.utils.Check;
import eipifi.z3.utils.Context;

@Check(names = {"eq", "ne"}, arity = 2)
public class EqualityDecoder extends BaseDecoder {
    @Override
    public Object decode(Par par, Context ctx) {

        Expr e1 = ctx.decode(par.child(0));
        Expr e2 = ctx.decode(par.child(1));

        switch (par.name()) {
            case "eq": return z3().mkEq(e1, e2);
            case "ne": return z3().mkNot(z3().mkEq(e1, e2));
            default: throw new IllegalStateException();
        }
    }
}
