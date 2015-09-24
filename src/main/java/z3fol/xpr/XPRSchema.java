package z3fol.xpr;

import z3fol.model.Schema;
import z3fol.model.State;

import java.util.List;

/**
 * Describes the complete structure of the database and operations
 */
public interface XPRSchema extends Schema {

    List<String> getModel();
    List<XPROperation> getOperations();

    @Override
    default State getState() {
        State state = new State();
        Processor.process(state, getModel());
        return state;
    }

}
