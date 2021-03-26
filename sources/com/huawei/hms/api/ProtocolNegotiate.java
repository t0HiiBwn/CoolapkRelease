package com.huawei.hms.api;

import java.util.List;

public class ProtocolNegotiate {
    private static ProtocolNegotiate a = new ProtocolNegotiate();
    private int b = 1;

    public static ProtocolNegotiate getInstance() {
        return a;
    }

    public int negotiate(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            this.b = 1;
            return 1;
        }
        if (!list.contains(2)) {
            this.b = list.get(list.size() - 1).intValue();
        } else {
            this.b = 2;
        }
        return this.b;
    }

    public int getVersion() {
        return this.b;
    }
}
