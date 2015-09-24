package z3fol.model;

import com.microsoft.z3.BoolExpr;

import java.util.List;

public interface Operation {
    List<BoolExpr> getConditions(State state);
    void instantiateArguments(State state);
    void applyEffect(State state);
}
