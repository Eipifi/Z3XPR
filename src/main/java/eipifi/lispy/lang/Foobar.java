package eipifi.lispy.lang;

import eipifi.lispy.Par;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Foobar extends LispyBaseListener {

    private final List<Par> values = new LinkedList<>();

    @Override
    public void enterDocument(LispyParser.DocumentContext ctx) {
        ctx.par().stream().map(this::parsePar).forEach(getValues()::add);
    }

    private Par parsePar(LispyParser.ParContext ctx) {
        return new Par(ctx.atom().getText(), ctx.par().stream().map(this::parsePar).collect(Collectors.toList()));
    }

    public List<Par> getValues() {
        return values;
    }
}
