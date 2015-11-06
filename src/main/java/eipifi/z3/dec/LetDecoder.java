package eipifi.z3.dec;

import eipifi.lispy.Par;
import eipifi.z3.utils.Check;
import eipifi.z3.utils.CheckDecoder;
import eipifi.z3.utils.Context;

import java.util.List;

@Check(names = "let", arityMin = 1)
public class LetDecoder implements CheckDecoder {
    @Override
    public Object decode(Par par, Context ctx) {
        // Make a child context
        ctx = ctx.child();

        // Fetch scope operations and the final expression
        List<Par> ops = par.values(-1);
        Par expression = par.lastChild();

        // Ensure the type is correct
        assert ops.stream().allMatch(op -> op.is("declare", "assign"));

        ctx.decodeAll(ops);
        return ctx.decode(expression);
    }
}
