package example.bank;

import com.microsoft.z3.Status;
import z3fol.analyzer.SequentialCheck;

import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        Map<String, Status> result = SequentialCheck.check(new SimpleBank());

        System.out.println(result);

    }
}
