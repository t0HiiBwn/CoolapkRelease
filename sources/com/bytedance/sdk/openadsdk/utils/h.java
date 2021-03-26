package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.g;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.d;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CommonPermissionUtils */
public class h {
    private static final Map<String, a> a = Collections.synchronizedMap(new HashMap());
    private static IListenerManager b;

    /* compiled from: CommonPermissionUtils */
    public interface a {
        void a();

        void a(String str);
    }

    public static void a(String str, String[] strArr, a aVar) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            a(str, aVar);
            TTDelegateActivity.a(str, strArr);
        }
    }

    public static void a(final String str) {
        if (!TextUtils.isEmpty(str)) {
            if (b.b()) {
                e.b().execute(new g(5) {
                    /* class com.bytedance.sdk.openadsdk.utils.h.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            u.b("MultiProcess", "handleYes-1，key=" + str);
                            h.b().broadcastPermissionListener(str, null);
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            }
            a b2 = b(str);
            if (b2 != null) {
                b2.a();
            }
        }
    }

    public static void a(final String str, final String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (b.b()) {
                e.b().execute(new g(5) {
                    /* class com.bytedance.sdk.openadsdk.utils.h.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            u.b("MultiProcess", "handleNo-1，key=" + str + "，permission=" + str2);
                            h.b().broadcastPermissionListener(str, str2);
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            }
            a b2 = b(str);
            if (b2 != null) {
                b2.a(str2);
            }
        }
    }

    private static void a(final String str, final a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            if (b.b()) {
                e.b(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.utils.h.AnonymousClass3 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            u.f("MultiProcess", "getListenerManager().registerPermissionListener...");
                            h.b().registerPermissionListener(str, new com.bytedance.sdk.openadsdk.multipro.aidl.b.b(aVar));
                        } catch (Throwable th) {
                            th.printStackTrace();
                            u.f("MultiProcess", th.toString());
                        }
                    }
                }, 5);
            } else {
                a.put(str, aVar);
            }
        }
    }

    private static a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a.remove(str);
    }

    /* access modifiers changed from: private */
    public static IListenerManager b() {
        if (b == null) {
            b = d.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(p.a()).a(4));
        }
        return b;
    }
}
