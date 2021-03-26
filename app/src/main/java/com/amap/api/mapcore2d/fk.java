package com.amap.api.mapcore2d;

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
public class fk extends fo {
    private Context a;
    private String b;
    private df e;
    private Object[] f;

    public fk(Context context, fo foVar, df dfVar, String str, Object... objArr) {
        super(foVar);
        this.a = context;
        this.b = str;
        this.e = dfVar;
        this.f = objArr;
    }

    @Override // com.amap.api.mapcore2d.fo
    protected byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String a2 = db.a(bArr);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String b2 = b(this.a);
        return db.a("{\"pinfo\":\"" + b2 + "\",\"els\":[" + a2 + "]}");
    }

    private String a(Context context) {
        try {
            return String.format(db.c(this.b), this.f);
        } catch (Throwable th) {
            th.printStackTrace();
            Cdo.c(th, "ofm", "gpj");
            return "";
        }
    }

    private String b(Context context) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return db.a(this.e.b(db.a(a(context))));
    }
}
