package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.c.h;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.r;
import java.util.List;
import org.json.JSONObject;

/* compiled from: NetApi */
public interface q<T> {

    /* compiled from: NetApi */
    public interface a {
        void a(boolean z, long j, long j2);
    }

    /* compiled from: NetApi */
    public interface b {
        void a(int i, String str);

        void a(com.bytedance.sdk.openadsdk.core.d.a aVar);
    }

    /* compiled from: NetApi */
    public interface c {
        void a(int i, String str);

        void a(r.c cVar);
    }

    h a(List<T> list);

    h a(JSONObject jSONObject);

    com.bytedance.sdk.openadsdk.core.d.q a();

    String a(AdSlot adSlot);

    String a(AdSlot adSlot, boolean z, int i);

    void a(AdSlot adSlot, m mVar, int i, b bVar);

    void a(l lVar, List<FilterWord> list);

    void a(String str, String str2, a aVar);

    void a(JSONObject jSONObject, c cVar);

    boolean a(JSONObject jSONObject, int i);
}
