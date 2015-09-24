package z3fol.xpr;

import z3fol.model.Operation;

import java.util.List;

public abstract class AnnotatedSchema extends XPRSchema {

    @Override
    public List<String> getModel() {
        return AnnotationUtils.findXPRs(this.getClass(), XPR.Type.MODEL);
    }

    @Override
    public List<Operation> getOperations() {
        return AnnotationUtils.findOps(this.getClass());
    }

}
