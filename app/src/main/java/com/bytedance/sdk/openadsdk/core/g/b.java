package com.bytedance.sdk.openadsdk.core.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import java.util.HashMap;

/* compiled from: PlayableEvent */
public class b {
    public static void a(Context context, l lVar) {
        if (lVar == null) {
            return;
        }
        if (lVar.D() || lVar.C()) {
            d.k(context, lVar, "playable_preload", "preload_start", null);
        }
    }

    public static void a(Context context, l lVar, long j, long j2) {
        if (lVar == null) {
            return;
        }
        if (lVar.D() || lVar.C()) {
            HashMap hashMap = new HashMap();
            hashMap.put("loadzip_success_time", Long.valueOf(j));
            hashMap.put("unzip_success_time", Long.valueOf(j2));
            d.k(context, lVar, "playable_preload", "preload_success", hashMap);
        }
    }

    public static void a(Context context, l lVar, int i, String str) {
        if (lVar == null) {
            return;
        }
        if (lVar.D() || lVar.C()) {
            HashMap hashMap = new HashMap();
            hashMap.put("error_code", Integer.valueOf(i));
            hashMap.put("error_reason", str);
            d.k(context, lVar, "playable_preload", "preload_fail", hashMap);
        }
    }
}
