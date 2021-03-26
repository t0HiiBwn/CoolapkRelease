package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ae;
import com.xiaomi.push.fv;
import com.xiaomi.push.gi;
import com.xiaomi.push.gy;
import com.xiaomi.push.gz;
import com.xiaomi.push.ha;
import com.xiaomi.push.he;
import com.xiaomi.push.hf;
import com.xiaomi.push.hi;
import com.xiaomi.push.hk;
import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
import com.xiaomi.push.ho;
import com.xiaomi.push.hq;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import java.nio.ByteBuffer;

public class aj {
    protected static <T extends hu<T, ?>> hf a(Context context, T t, gi giVar) {
        return a(context, t, giVar, !giVar.equals(gi.Registration), context.getPackageName(), b.m54a(context).m55a());
    }

    protected static <T extends hu<T, ?>> hf a(Context context, T t, gi giVar, boolean z, String str, String str2) {
        String str3;
        byte[] a = ht.a(t);
        if (a == null) {
            str3 = "invoke convertThriftObjectToBytes method, return null.";
        } else {
            hf hfVar = new hf();
            if (z) {
                String d = b.m54a(context).d();
                if (TextUtils.isEmpty(d)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        a = fv.b(ae.c(d), a);
                    } catch (Exception unused) {
                        c.d("encryption error. ");
                    }
                }
            }
            gy gyVar = new gy();
            gyVar.a = 5;
            gyVar.b = "fakeid";
            hfVar.a(gyVar);
            hfVar.a(ByteBuffer.wrap(a));
            hfVar.a(giVar);
            hfVar.c(true);
            hfVar.b(str);
            hfVar.a(z);
            hfVar.a(str2);
            return hfVar;
        }
        c.a(str3);
        return null;
    }

    public static hu a(Context context, hf hfVar) {
        byte[] bArr;
        if (hfVar.c()) {
            try {
                bArr = fv.a(ae.c(b.m54a(context).d()), hfVar.f());
            } catch (Exception e) {
                throw new t("the aes decrypt failed.", e);
            }
        } else {
            bArr = hfVar.f();
        }
        hu a = a(hfVar.a(), hfVar.c);
        if (a != null) {
            ht.a(a, bArr);
        }
        return a;
    }

    private static hu a(gi giVar, boolean z) {
        switch (ak.a[giVar.ordinal()]) {
            case 1:
                return new hk();
            case 2:
                return new hq();
            case 3:
                return new ho();
            case 4:
                return new hs();
            case 5:
                return new hm();
            case 6:
                return new gz();
            case 7:
                return new he();
            case 8:
                return new hl();
            case 9:
                if (z) {
                    return new hi();
                }
                ha haVar = new ha();
                haVar.a(true);
                return haVar;
            case 10:
                return new he();
            default:
                return null;
        }
    }
}
