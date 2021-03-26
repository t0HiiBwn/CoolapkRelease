package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hms.openid.R;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;

/* compiled from: SecretUtil */
public abstract class d {
    private static RootKeyUtil a;

    private static String a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    private static RootKeyUtil a(Context context, q qVar) {
        if (a == null) {
            if (!TextUtils.isEmpty(qVar.b("Jarvis"))) {
                a = RootKeyUtil.newInstance(qVar.b("CaptainA"), qVar.b("IronMan"), qVar.b("CaptainM"), qVar.b("SpokesMan"));
            } else {
                b(context);
            }
        }
        return a;
    }

    public static String a(Context context) {
        q qVar = new q(context, "LocalAvengers");
        return WorkKeyCryptUtil.decryptWorkKey(qVar.b("Jarvis"), a(context, qVar));
    }

    public static void b(Context context) {
        q qVar = new q(context, "LocalAvengers");
        if (TextUtils.isEmpty(qVar.b("Jarvis"))) {
            byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom2 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom3 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom4 = EncryptUtil.generateSecureRandom(32);
            String a2 = b.a(generateSecureRandom);
            String a3 = b.a(generateSecureRandom2);
            String a4 = b.a(generateSecureRandom3);
            a = RootKeyUtil.newInstance(a2, a3, a4, generateSecureRandom4);
            qVar.a("CaptainA", a2);
            qVar.a("IronMan", a3);
            qVar.a("CaptainM", a4);
            qVar.a("SpokesMan", b.a(generateSecureRandom4));
            qVar.a("Jarvis", WorkKeyCryptUtil.encryptWorkKey(b.a(EncryptUtil.generateSecureRandom(32)), a));
        }
    }

    public static byte[] c(Context context) {
        byte[] a2 = b.a(context.getString(R.string.push_cat_head));
        byte[] a3 = b.a(context.getString(R.string.push_cat_body));
        return a(a(a(a2, a3), b.a(a())));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] >> 2);
        }
        return bArr;
    }
}
