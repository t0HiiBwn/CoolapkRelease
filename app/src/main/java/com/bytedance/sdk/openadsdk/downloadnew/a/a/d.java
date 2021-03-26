package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.g.a;
import com.bytedance.sdk.openadsdk.utils.h;
import com.ss.android.a.a.a.h;
import com.ss.android.a.a.a.q;
import com.ss.android.downloadlib.h.k;
import java.lang.ref.WeakReference;

/* compiled from: LibPermission */
public class d implements h {
    private final WeakReference<Context> a;

    @Override // com.ss.android.a.a.a.h
    public void a(Activity activity, int i, String[] strArr, int[] iArr) {
    }

    public d(Context context) {
        this.a = new WeakReference<>(context);
    }

    @Override // com.ss.android.a.a.a.h
    public void a(Activity activity, final String[] strArr, final q qVar) {
        boolean z;
        TTCustomController e;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z && (e = i.d().e()) != null && qVar != null && !e.isCanUseWriteExternal()) {
                qVar.a("android.permission.WRITE_EXTERNAL_STORAGE");
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 23 || k.a(activity) >= 23) {
            if (strArr != null && strArr.length > 0) {
                long hashCode = (long) hashCode();
                for (String str : strArr) {
                    hashCode += (long) str.hashCode();
                }
                com.bytedance.sdk.openadsdk.utils.h.a(String.valueOf(hashCode), strArr, new h.a() {
                    /* class com.bytedance.sdk.openadsdk.downloadnew.a.a.d.AnonymousClass1 */

                    @Override // com.bytedance.sdk.openadsdk.utils.h.a
                    public void a() {
                        q qVar = qVar;
                        if (qVar != null) {
                            qVar.a();
                        }
                        a.a().a(true, strArr);
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.h.a
                    public void a(String str) {
                        q qVar = qVar;
                        if (qVar != null) {
                            qVar.a(str);
                        }
                        a.a().a(false, new String[]{str});
                    }
                });
            } else if (qVar != null) {
                qVar.a();
            }
        } else if (qVar != null) {
            qVar.a();
        }
    }

    @Override // com.ss.android.a.a.a.h
    public boolean a(Context context, String str) {
        TTCustomController e;
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(str) && (e = i.d().e()) != null && !e.isCanUseWriteExternal()) {
            return false;
        }
        if (context == null) {
            context = p.a();
        }
        return com.bytedance.sdk.openadsdk.core.f.d.a().a(context, str);
    }
}
