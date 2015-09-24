package z3fol.xpr;

import com.microsoft.z3.BoolExpr;
import z3fol.model.Operation;
import z3fol.model.Schema;
import z3fol.model.State;

import java.util.Collections;
import java.util.List;

/**
 * Describes the complete structure of the database and operations
 */
public abstract class XPRSchema implements Schema {

    public abstract List<String> getModel();

    private final State state;
    private final List<BoolExpr> invariants;

    public XPRSchema() {
        state = new State();
        invariants = Processor.process(state, getModel());
    }

    @Override
    public State getState() {
        return state.copy();
    }

    @Override
    public List<BoolExpr> getInvariants() {
        return Collections.unmodifiableList(invariants);
    }

}
