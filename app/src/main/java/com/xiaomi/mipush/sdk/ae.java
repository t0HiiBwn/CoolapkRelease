package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bf;
import com.xiaomi.push.h;
import com.xiaomi.push.hc;
import com.xiaomi.push.hr;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hx;
import com.xiaomi.push.hy;
import com.xiaomi.push.ib;
import com.xiaomi.push.id;
import com.xiaomi.push.ie;
import com.xiaomi.push.ih;
import com.xiaomi.push.ij;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.in;
import java.nio.ByteBuffer;

public class ae {
    protected static <T extends in<T, ?>> hy a(Context context, T t, hc hcVar) {
        return a(context, t, hcVar, !hcVar.equals(hc.Registration), context.getPackageName(), b.m75a(context).m76a());
    }

    protected static <T extends in<T, ?>> hy a(Context context, T t, hc hcVar, boolean z, String str, String str2) {
        return a(context, t, hcVar, z, str, str2, true);
    }

    protected static <T extends in<T, ?>> hy a(Context context, T t, hc hcVar, boolean z, String str, String str2, boolean z2) {
        String str3;
        byte[] a = im.a(t);
        if (a == null) {
            str3 = "invoke convertThriftObjectToBytes method, return null.";
        } else {
            hy hyVar = new hy();
            if (z) {
                String d = b.m75a(context).d();
                if (TextUtils.isEmpty(d)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        a = h.b(bf.m137a(d), a);
                    } catch (Exception unused) {
                        b.d("encryption error. ");
                    }
                }
            }
            hr hrVar = new hr();
            hrVar.f624a = 5;
            hrVar.f625a = "fakeid";
            hyVar.a(hrVar);
            hyVar.a(ByteBuffer.wrap(a));
            hyVar.a(hcVar);
            hyVar.b(z2);
            hyVar.b(str);
            hyVar.a(z);
            hyVar.a(str2);
            return hyVar;
        }
        b.m41a(str3);
        return null;
    }

    public static in a(Context context, hy hyVar) {
        byte[] bArr;
        if (hyVar.m464b()) {
            try {
                bArr = h.a(bf.m137a(b.m75a(context).d()), hyVar.m462a());
            } catch (Exception e) {
                throw new s("the aes decrypt failed.", e);
            }
        } else {
            bArr = hyVar.m462a();
        }
        in a = a(hyVar.a(), hyVar.f704b);
        if (a != null) {
            im.a(a, bArr);
        }
        return a;
    }

    private static in a(hc hcVar, boolean z) {
        switch (af.a[hcVar.ordinal()]) {
            case 1:
                return new id();
            case 2:
                return new ij();
            case 3:
                return new ih();
            case 4:
                return new il();
            case 5:
                return new Cif();
            case 6:
                return new hs();
            case 7:
                return new hx();
            case 8:
                return new ie();
            case 9:
                if (z) {
                    return new ib();
                }
                ht htVar = new ht();
                htVar.a(true);
                return htVar;
            case 10:
                return new hx();
            default:
                return null;
        }
    }

    protected static <T extends in<T, ?>> hy b(Context context, T t, hc hcVar, boolean z, String str, String str2) {
        return a(context, t, hcVar, z, str, str2, false);
    }
}
