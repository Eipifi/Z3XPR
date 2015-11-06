package eipifi.z3.dec;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import eipifi.lispy.Par;
import eipifi.z3.utils.BaseDecoder;
import eipifi.z3.utils.Check;
import eipifi.z3.utils.Context;

import java.util.List;
import java.util.Objects;

@Check(names = {"forall", "exists"}, arityMin = 2)
public class QuantifiedFactDecoder extends BaseDecoder {

    @Override
    public Object decode(Par par, Context ctx) {

        // Parse the predicate
        BoolExpr predicate = ctx.decode(par.lastChild());

        // Fetch the quantified variable names
        List<Par> names = par.values(-1);
        assert names.stream().allMatch(Par::isAtom);

        Sort[] sorts = names.stream().map(n -> ctx.getExpr(n.name()).getSort()).toArray(Sort[]::new);
        Symbol[] symbols = names.stream().map(n -> z3().mkSymbol(n.name())).toArray(Symbol[]::new);

        return Objects.equals(par.name(), "forall")
                ? z3().mkForall(sorts, symbols, predicate, 1, null, null, null, null)
                : z3().mkExists(sorts, symbols, predicate, 1, null, null, null, null);
    }
}
