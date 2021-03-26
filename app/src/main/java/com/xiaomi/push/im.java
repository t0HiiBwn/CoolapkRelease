package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.iu;
import com.xiaomi.push.je;

public class im {
    public static short a(Context context, hy hyVar) {
        int i = 0;
        int a = g.a(context, hyVar.f703b, false).a() + 0 + (ah.b(context) ? 4 : 0);
        if (ah.a(context)) {
            i = 8;
        }
        return (short) (a + i);
    }

    public static <T extends in<T, ?>> void a(T t, byte[] bArr) {
        if (bArr != null) {
            new ir(new je.a(true, true, bArr.length)).a(t, bArr);
            return;
        }
        throw new is("the message byte is empty.");
    }

    public static <T extends in<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new it(new iu.a()).a(t);
        } catch (is e) {
            b.a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }
}
