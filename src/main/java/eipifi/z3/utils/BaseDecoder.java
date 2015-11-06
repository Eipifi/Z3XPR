package eipifi.z3.utils;

import eipifi.z3.Utils;

public abstract class BaseDecoder implements CheckDecoder {
    protected com.microsoft.z3.Context z3() {
        return Utils.ctx();
    }
}
