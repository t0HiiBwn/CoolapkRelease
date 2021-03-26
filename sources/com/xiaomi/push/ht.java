package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ic;
import com.xiaomi.push.im;

public class ht {
    public static short a(Context context, hf hfVar) {
        int i = 0;
        int a = eu.c(context, hfVar.f).a() + 0 + (i.b(context) ? 4 : 0);
        if (i.a(context)) {
            i = 8;
        }
        return (short) (a + i);
    }

    public static <T extends hu<T, ?>> void a(T t, byte[] bArr) {
        if (bArr != null) {
            new hz(new im.a(true, true, bArr.length)).a(t, bArr);
            return;
        }
        throw new ia("the message byte is empty.");
    }

    public static <T extends hu<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new ib(new ic.a()).a(t);
        } catch (ia e) {
            c.a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }
}
