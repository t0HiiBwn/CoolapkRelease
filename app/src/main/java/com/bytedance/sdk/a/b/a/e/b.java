package com.bytedance.sdk.a.b.a.e;

/* compiled from: ErrorCode */
public enum b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    
    public final int g;

    private b(int i) {
        this.g = i;
    }

    public static b a(int i) {
        b[] values = values();
        for (b bVar : values) {
            if (bVar.g == i) {
                return bVar;
            }
        }
        return null;
    }
}
