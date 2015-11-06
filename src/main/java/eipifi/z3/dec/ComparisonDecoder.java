package eipifi.z3.dec;

import com.microsoft.z3.ArithExpr;
import eipifi.lispy.Par;
import eipifi.z3.utils.BaseDecoder;
import eipifi.z3.utils.Check;
import eipifi.z3.utils.Context;

@Check(names = {"le", "ge", "lt", "gt"}, arity = 2)
public class ComparisonDecoder extends BaseDecoder {
    @Override
    public Object decode(Par par, Context ctx) {

        ArithExpr e1 = ctx.decode(par.child(0));
        ArithExpr e2 = ctx.decode(par.child(1));

        switch (par.name()) {
            case "le": return z3().mkLe(e1, e2);
            case "ge": return z3().mkGe(e1, e2);
            case "lt": return z3().mkLt(e1, e2);
            case "gt": return z3().mkGt(e1, e2);
            default: throw new IllegalStateException();
        }
    }
}
