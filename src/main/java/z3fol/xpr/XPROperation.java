package z3fol.xpr;

import com.microsoft.z3.BoolExpr;
import z3fol.model.Operation;
import z3fol.model.State;
import java.util.List;

public interface XPROperation extends Operation {

    List<String> getArgumentsXPR();
    List<String> getConditionsXPR();
    List<String> getEffectsXPR();

    @Override
    default List<BoolExpr> getConditions(State state) {
        return Processor.process(state.copy(), getConditionsXPR());
    }

    @Override
    default void instantiateArguments(State state) {
        Processor.process(state, getArgumentsXPR());
    }

    @Override
    default void applyEffect(State state) {
        Processor.process(state, getEffectsXPR());
    }

}
