package eipifi.z3.dec;

import eipifi.lispy.Par;
import eipifi.z3.utils.BaseDecoder;
import eipifi.z3.utils.Check;
import eipifi.z3.utils.Context;

@Check(names = "type", arity = 1)
public class TypeDecoder extends BaseDecoder {
    @Override
    public Object decode(Par par, Context ctx) {
        Par type = par.child(0);
        if (type.isAtom()) {
            switch (type.toString()) {
                case "int": return z3().mkIntSort();
                case "bool": return z3().mkBoolSort();
                default: throw new IllegalStateException("Unknown type " + type.toString());
            }
        } else {
            throw new IllegalStateException("Not yet implemented");
        }
    }
}
