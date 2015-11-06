package eipifi.z3;

import com.microsoft.z3.*;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    // Singleton
    private static Context ctx;

    public static Context ctx() {
        if (ctx == null) {
            Global.ToggleWarningMessages(true);
            Log.open("test.log");
            Map<String, String> cfg = new HashMap<>();
            cfg.put("model", "true");
            ctx = new Context(cfg);
        }
        return ctx;
    }
}
