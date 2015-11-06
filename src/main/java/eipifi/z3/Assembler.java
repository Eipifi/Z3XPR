package eipifi.z3;

import eipifi.z3.dec.*;
import eipifi.z3.utils.Context;

public class Assembler {
    public static Context context() {
        return new Context.Builder().add(
                new AndDecoder(),
                new AssignDecoder(),
                new ComparisonDecoder(),
                new DeclareDecoder(),
                new EqualityDecoder(),
                new IntegerDecoder(),
                new LetDecoder(),
                new MembershipDecoder(),
                new OrDecoder(),
                new QuantifiedFactDecoder(),
                new SumDecoder(),
                new TypeDecoder(),
                new VariableDecoder(),
                new XorDecoder()
        ).get();
    }
}
