package z3fol.analyzer;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Status;
import z3fol.model.Operation;
import z3fol.model.Schema;
import z3fol.model.State;
import z3fol.xpr.Z3Utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SequentialCheck {

    public static Map<String, Status> check(Schema schema) {

        return schema.getOperations().stream().collect(Collectors.toMap(Operation::getName, (op) -> {
            State stateBefore = schema.getState();
            op.instantiateArguments(stateBefore);

            List<BoolExpr> invariantsBefore = schema.getInvariants(stateBefore);
            List<BoolExpr> preconditionsBefore = op.getConditions(stateBefore);

            State stateAfter = stateBefore.copy();
            op.applyEffect(stateAfter);
            List<BoolExpr> invariantsAfter = schema.getInvariants(stateAfter);

            BoolExpr before = Z3Utils.and(invariantsBefore, preconditionsBefore);
            BoolExpr after = Z3Utils.and(invariantsAfter);
            BoolExpr implication = Z3Utils.ctx().mkNot(Z3Utils.ctx().mkImplies(before, after));
            Solver solver = Z3Utils.ctx().mkSolver();
            solver.add(implication);
            return solver.check();

        }));
    }
}
