package z3fol.xpr;

import com.microsoft.z3.Context;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Symbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import z3fol.antlr.XPRBaseListener;
import z3fol.antlr.XPRParser;

import java.util.List;
import java.util.Objects;

public class DocumentParser extends XPRBaseListener {

    private static final Logger log = LoggerFactory.getLogger(DocumentParser.class);
    private final Context z3ctx;
    private final TypeStorage types;
    private final VariableScope scope = new VariableScope();

    public DocumentParser(Context z3ctx) {
        this.z3ctx = z3ctx;
        types = new TypeStorage(z3ctx);
    }

    @Override
    public void enterDocument(XPRParser.DocumentContext ctx) {
        ctx.line().forEach(this::parseLine);
    }

    private void parseLine(XPRParser.LineContext ctx) {
        log.debug("Parsing line: {}", ctx.getText());

        if (ctx.typeDeclaration() != null) parseTypeDeclaration(ctx.typeDeclaration());
        if (ctx.varDeclaration() != null) parseValDeclaration(ctx.varDeclaration());

    }

    private void parseValDeclaration(XPRParser.VarDeclarationContext ctx) {
        String name = ctx.identifier().getText();
        Sort sort = getType(ctx.type());
        if (scope.get(name) != null) throw new IllegalStateException("Cannot redeclare variable " + name);
        scope.put(name, z3ctx.mkConst(name, sort));
    }

    public void parseTypeDeclaration(XPRParser.TypeDeclarationContext ctx) {
        String name = ctx.identifier().getText();
        if (ctx.type() == null) {
            types.put(name, z3ctx.mkUninterpretedSort(name));
        } else {
            types.put(name, getType(name, ctx.type()));
        }
    }

    private Sort getType(XPRParser.TypeContext ctx) {
        return getType("__anonymous__", ctx);
    }

    private Sort getType(String name, XPRParser.TypeContext ctx) {
        if (ctx.identifier_uc() != null) return types.get(ctx.identifier_uc().getText());

        if (ctx.typeTuple() != null) {
            List<XPRParser.TypeContext> subTypes = ctx.typeTuple().type();
            Symbol[] fieldNames = new Symbol[subTypes.size()];
            Sort[] fieldSorts = new Sort[subTypes.size()];
            for (int i = 0; i < fieldNames.length; ++i) fieldNames[i] = z3ctx.mkSymbol(i);
            for (int i = 0; i < fieldSorts.length; ++i) fieldSorts[i] = getType(subTypes.get(i));
            return z3ctx.mkTupleSort(z3ctx.mkSymbol(name), fieldNames, fieldSorts);
        }

        if (ctx.typeGeneric() != null) {
            String genericName = ctx.typeGeneric().identifier_uc().getText();
            if (!Objects.equals(genericName, "Set")) throw new IllegalStateException("Unknown generic type " + genericName);
            return z3ctx.mkSetSort(getType(ctx.typeGeneric().type()));
        }

        throw new IllegalStateException();
    }
}
