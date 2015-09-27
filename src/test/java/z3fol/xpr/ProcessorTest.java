package z3fol.xpr;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Status;
import org.junit.Test;
import static org.junit.Assert.*;
import z3fol.model.State;

import java.util.List;

public class ProcessorTest {

    @Test
    public void shouldProduceVariables() {
        State s = new State();
        String xpr = "Int x;";
        Processor.process(s, xpr);
        assertNotNull(s.getExpr("x"));
    }

    @Test
    public void shouldProduceSort() {
        State s = new State();
        String xpr = "type Foo Int;";
        Processor.process(s, xpr);
        assertNotNull(s.getSort("Foo"));
    }

    @Test
    public void shouldProduceFact() {
        List<BoolExpr> facts = Processor.process(new State(), "2 == 2;");
        assertEquals(facts.size(), 1);
    }

    @Test(expected = UnknownSortException.class)
    public void shouldThrowExceptionOnUnknownType() {
        process("Foo x;");
    }

    @Test(expected = UnknownVariableException.class)
    public void shouldThrowExceptionOnUnknownVariable() {
        process("x == 2;");
    }

    @Test(expected = XPRSyntaxErrorException.class)
    public void shouldThrowExceptionOnIllegalSyntax() {
        process("this text makes no sense;");
    }

    @Test
    public void shouldAcceptForallQuantifier() {
        process("Forall Int x: x > 0;");
    }

    @Test
    public void shouldAcceptExistsQuantifier() {
        process("Exists Int x: x > 0;");
    }

    @Test
    public void shouldAcceptInlineAssignment() {
        process("Int x := 2;");
    }

    @Test(expected = XPRTypeMismatchException.class)
    public void shouldRejectInvalidValueInline() {
        process("type Foo; Foo foo := 1;");
    }

    @Test(expected = XPRTypeMismatchException.class)
    public void shouldRejectInvalidValueAfter() {
        process("type Foo; Foo foo; foo := 1;");
    }

    @Test(expected = XPRTypeMismatchException.class)
    public void shouldRejectInvalidSetType() {
        process("type Foo;",
                "Foo foo;",
                "Int{} set := {1, 2, foo};");
    }

    @Test
    public void shouldAcceptInlineSet() {
        process("Int{} set := {1, 2, 3};");
    }

    @Test
    public void shouldParseInlineSet() {
        process("{1, 2, 3} == Int{};"); // each set must have a defined type, even if it is empty
    }

    @Test
    public void shouldSatisfyWithNoVariables() {
        assertEquals(Status.SATISFIABLE, solve("2 == 2;"));
    }

    @Test
    public void shouldNotSatisfyFalse() {
        assertEquals(Status.UNSATISFIABLE, solve("1 == 2;"));
    }

    @Test
    public void shouldSatisfyUnboundVariables() {
        assertEquals(Status.SATISFIABLE, solve("Int x; x == 2;"));
    }

    @Test
    public void shouldUseDependantStatements() {
        assertEquals(Status.UNSATISFIABLE, solve(
                "Int{} s;",
                "Forall Int x: !(x in s)",
                "Exists Int x: x in s;"));
    }

    @Test
    public void shouldUnderstandUnequalities() {
        assertEquals(Status.UNSATISFIABLE, solve(
                "Int{} s;",
                "Forall Int x: x in s => x > 3;",
                "Exists Int x: x in s & x < 2;"));
    }

    private Status solve(String... xpr) {
        BoolExpr statement = Z3Utils.and(Processor.process(new State(), xpr));
        Solver s = Z3Utils.ctx().mkSolver();
        s.add(statement);
        return s.check();
    }

    private void process(String... xpr) {
        Processor.process(new State(), xpr);
    }

}