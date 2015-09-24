package example.file;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.microsoft.z3.BoolExpr;
import z3fol.model.State;
import z3fol.xpr.Processor;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        URL url = Resources.getResource("bank.xpr");
        String text = Resources.toString(url, Charsets.UTF_8);

        State s = new State();
        List<BoolExpr> facts = Processor.process(s, text);

        System.out.println(s);
        System.out.println(facts);
    }

}
