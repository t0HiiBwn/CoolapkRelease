package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.b;
import com.bytedance.sdk.openadsdk.core.d.l;

/* compiled from: DownloadUtils */
public class f {
    public static String a(l lVar) {
        if (lVar == null) {
            return "";
        }
        b ah = lVar.ah();
        if (ah != null && !TextUtils.isEmpty(ah.c())) {
            return ah.c();
        }
        if (!TextUtils.isEmpty(lVar.S())) {
            return lVar.S();
        }
        if (!TextUtils.isEmpty(lVar.ae())) {
            return lVar.ae();
        }
        if (!TextUtils.isEmpty(lVar.az())) {
            return lVar.az();
        }
        return "";
    }
}
