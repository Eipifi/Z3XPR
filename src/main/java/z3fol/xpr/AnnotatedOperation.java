package z3fol.xpr;

import java.util.List;

public abstract class AnnotatedOperation implements XPROperation {

    @Override
    public List<String> getArgumentsXPR() {
        return AnnotationUtils.findXPRs(this.getClass(), XPR.Type.ARGUMENT);
    }

    @Override
    public List<String> getConditionsXPR() {
        return AnnotationUtils.findXPRs(this.getClass(), XPR.Type.CONDITION);
    }

    @Override
    public List<String> getEffectsXPR() {
        return AnnotationUtils.findXPRs(this.getClass(), XPR.Type.EFFECT);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
