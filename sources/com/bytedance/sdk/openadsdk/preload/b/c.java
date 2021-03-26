package com.bytedance.sdk.openadsdk.preload.b;

import com.bytedance.sdk.openadsdk.preload.b.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Factory */
public class c {
    static <IN> b<IN> a(List<h> list, e eVar, d dVar) {
        if (list != null) {
            if (eVar == null) {
                eVar = new e.a();
            }
            return new i(Collections.unmodifiableList(new ArrayList(list)), 0, eVar, dVar);
        }
        throw new IllegalArgumentException("interceptors == null !");
    }

    public static <IN> b<IN> a(List<h> list, e eVar) {
        return a(list, eVar, null);
    }
}
