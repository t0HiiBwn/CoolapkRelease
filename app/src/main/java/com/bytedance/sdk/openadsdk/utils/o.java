package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.openadsdk.h.a.b;
import com.bytedance.sdk.openadsdk.h.d;

/* compiled from: ImageBytesHelper */
public class o {

    /* compiled from: ImageBytesHelper */
    public interface a {
        void a();

        void a(byte[] bArr);
    }

    public static void a(Context context, String str, int i, final a aVar, boolean z) {
        u.f("splashLoadAd", " getImageBytes url " + str);
        d.a(context).f().a(str, new b.AbstractC0054b() {
            /* class com.bytedance.sdk.openadsdk.utils.o.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.h.a.b.AbstractC0054b
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.h.a.b.AbstractC0054b
            public void a(b.c cVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.h.a.b.AbstractC0054b
            public void a(String str, byte[] bArr) {
                if (bArr == null || bArr.length <= 0 || aVar == null) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                u.b("ImageBytesHelper: ", "图片数据返回成功" + bArr.length);
                aVar.a(bArr);
            }

            @Override // com.bytedance.sdk.openadsdk.h.a.b.AbstractC0054b
            public void b(b.c cVar) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }, i, i, z);
    }

    public static Drawable a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return new ColorDrawable(0);
        }
        try {
            return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        } catch (Throwable unused) {
            return new ColorDrawable(0);
        }
    }
}
