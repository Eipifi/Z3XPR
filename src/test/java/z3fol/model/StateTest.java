package z3fol.model;

import org.junit.Test;
import z3fol.xpr.Z3Utils;

import static org.junit.Assert.*;

public class StateTest {

    @Test
    public void shouldStoreSorts() {
        State s = new State();
        s.putSort("foo", Z3Utils.ctx().getBoolSort());
        assertNotNull(s.getSort("foo"));
    }

    @Test
    public void shouldStoreExprs() {
        State s = new State();
        s.putExpr("foo", Z3Utils.ctx().mkTrue());
        assertNotNull(s.getExpr("foo"));
    }

    @Test
    public void shouldCopyToSeparateObject() {
        State s = new State();
        s.copy().putSort("foo", Z3Utils.ctx().getBoolSort());
        assertNull(s.getSort("foo"));
    }

}