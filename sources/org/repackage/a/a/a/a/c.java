package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.repackage.a.a.a.a;

/* compiled from: OpenIDHelper */
public class c {
    public org.repackage.a.a.a.a a = null;
    public String b = null;
    public String c = null;
    public final Object d = new Object();
    public ServiceConnection e = new b(this);

    /* compiled from: OpenIDHelper */
    private static class a {
        public static final c a = new c(null);
    }

    public /* synthetic */ c(b bVar) {
    }

    public boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (Build.VERSION.SDK_INT >= 28) {
                if (packageInfo == null || packageInfo.getLongVersionCode() < 1) {
                    return false;
                }
                return true;
            } else if (packageInfo == null || packageInfo.versionCode < 1) {
                return false;
            } else {
                return true;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final String b(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.c)) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest instance = MessageDigest.getInstance("SHA1");
                    if (instance != null) {
                        byte[] digest = instance.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (NoSuchAlgorithmException e3) {
                    e3.printStackTrace();
                }
            }
            this.c = str2;
        }
        String a2 = ((a.AbstractBinderC0180a.C0181a) this.a).a(this.b, this.c, str);
        return TextUtils.isEmpty(a2) ? "" : a2;
    }

    public synchronized String a(Context context, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot run on MainThread");
        } else if (this.a == null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (context.bindService(intent, this.e, 1)) {
                synchronized (this.d) {
                    try {
                        this.d.wait(3000);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (this.a == null) {
                return "";
            }
            try {
                return b(context, str);
            } catch (RemoteException e3) {
                e3.printStackTrace();
                return "";
            }
        } else {
            try {
                return b(context, str);
            } catch (RemoteException e4) {
                e4.printStackTrace();
                return "";
            }
        }
    }
}
