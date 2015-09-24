package example.bank;

import com.microsoft.z3.BoolExpr;
import z3fol.model.Operation;
import z3fol.model.Schema;
import z3fol.model.State;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Schema schema = new Bank();
        State state = schema.getState();

        System.out.println("-- State:");
        System.out.println(state);

        for(Operation op: schema.getOperations()) {
            System.out.println("-- Operation: " + op.getClass().getSimpleName());

            State newState = state.copy();

            op.instantiateArguments(newState);
            List<BoolExpr> conditions = op.getConditions(newState);
            System.out.println("----- Conditions:");
            System.out.println(conditions);

            op.applyEffect(newState);
            System.out.println("----- State after:");
            System.out.println(newState);

        }
    }
}
