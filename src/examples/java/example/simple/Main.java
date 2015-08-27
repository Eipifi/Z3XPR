package example.simple;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import z3fol.xpr.Document;

import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        URL url = Resources.getResource("auction.xpr");
        String text = Resources.toString(url, Charsets.UTF_8);

        Document doc = new Document();
        doc.process(text);

        System.out.println(doc.facts());
    }

}
