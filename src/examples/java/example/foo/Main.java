package example.foo;

import eipifi.lispy.Par;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Par> result = eipifi.xpr.Parser.parse("forall account a, account b: {a, b} ⊂ accounts => a.id != b.id");
        System.out.println(result);
    }

}
