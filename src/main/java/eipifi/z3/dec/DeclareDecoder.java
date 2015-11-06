package eipifi.z3.dec;

import com.microsoft.z3.Sort;
import eipifi.lispy.Par;
import eipifi.z3.utils.BaseDecoder;
import eipifi.z3.utils.Check;
import eipifi.z3.utils.Context;

@Check(names = "declare", arity = 2)
public class DeclareDecoder extends BaseDecoder {
    @Override
    public Object decode(Par par, Context ctx) {

        Par name = par.child(0);
        Par type = par.child(1);

        assert name.isAtom();
        assert name.is("type");

        Sort ttype = ctx.decode(type);

        ctx.set(name.toString(), z3().mkConst(name.toString(), ttype));
        return null;
    }
}
