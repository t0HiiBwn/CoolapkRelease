package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: HeaderAddStrategy */
public final class dj extends dn {
    private Context a;
    private String b;
    private cm e;
    private Object[] f;

    public dj(Context context, dn dnVar, cm cmVar, String str, Object... objArr) {
        super(dnVar);
        this.a = context;
        this.b = str;
        this.e = cmVar;
        this.f = objArr;
    }

    @Override // com.amap.api.col.s.dn
    protected final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String a2 = bs.a(bArr);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String a3 = bs.a(this.e.b(bs.a(b())));
        return bs.a("{\"pinfo\":\"" + a3 + "\",\"els\":[" + a2 + "]}");
    }

    private String b() {
        try {
            return String.format(bs.c(this.b), this.f);
        } catch (Throwable th) {
            th.printStackTrace();
            cg.c(th, "ofm", "gpj");
            return "";
        }
    }
}
