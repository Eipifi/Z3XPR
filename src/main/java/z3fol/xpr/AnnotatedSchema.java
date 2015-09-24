package z3fol.xpr;

import java.util.List;

public abstract class AnnotatedSchema implements XPRSchema {

    @Override
    public List<String> getModel() {
        return AnnotationUtils.findXPRs(this.getClass(), XPR.Type.MODEL);
    }

}
