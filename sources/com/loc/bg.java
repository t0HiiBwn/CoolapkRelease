package com.loc;

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
public final class bg extends bk {
    private Context a;
    private String b;
    private ak e;
    private Object[] f;

    public bg(Context context, bk bkVar, ak akVar, String str, Object... objArr) {
        super(bkVar);
        this.a = context;
        this.b = str;
        this.e = akVar;
        this.f = objArr;
    }

    private String b() {
        try {
            return String.format(u.c(this.b), this.f);
        } catch (Throwable th) {
            th.printStackTrace();
            ab.b(th, "ofm", "gpj");
            return "";
        }
    }

    @Override // com.loc.bk
    protected final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String a2 = u.a(bArr);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String a3 = u.a(this.e.b(u.a(b())));
        return u.a("{\"pinfo\":\"" + a3 + "\",\"els\":[" + a2 + "]}");
    }
}
