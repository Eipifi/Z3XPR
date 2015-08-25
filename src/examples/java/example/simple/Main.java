package example.simple;


import com.microsoft.z3.Context;
import com.microsoft.z3.Global;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

    public static Context ctx() {
        Global.ToggleWarningMessages(true);
        //Log.open("test.log");
        Map<String, String> cfg = new HashMap<>();
        cfg.put("model", "true");
        return new Context(cfg);
    }

}
