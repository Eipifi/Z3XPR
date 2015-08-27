package z3fol.xpr;

import com.google.common.collect.ImmutableMap;
import com.microsoft.z3.Context;
import com.microsoft.z3.Sort;

import java.util.HashMap;
import java.util.Map;

public class TypeStorage {

    private Map<String, Sort> types = new HashMap<>();

    public TypeStorage(Context ctx) {
        put("Int", ctx.getIntSort());
        put("Bool", ctx.getBoolSort());
    }

    public void put(String name, Sort sort) {
        if (types.containsKey(name)) throw new IllegalStateException("Can not declare type " + name + "- name already used");
        types.put(name, sort);
    }

    public Sort get(String name) {
        Sort sort = types.get(name);
        if (sort == null) throw new IllegalStateException("Can not use type " + name + "- type not declared");
        return sort;
    }

    public Map<String, Sort> view() {
        return ImmutableMap.copyOf(types);
    }

}
