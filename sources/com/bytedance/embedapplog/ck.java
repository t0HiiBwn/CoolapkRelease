package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.embedapplog.br;
import com.bytedance.embedapplog.cf;
import com.bytedance.embedapplog.cn;
import java.security.MessageDigest;

final class ck implements cf {
    private final cf a;
    private bs<Boolean> b;

    ck() {
        this(null);
    }

    ck(cf cfVar) {
        this.b = new bs<Boolean>() {
            /* class com.bytedance.embedapplog.ck.AnonymousClass1 */

            /* access modifiers changed from: protected */
            /* renamed from: c */
            public Boolean a(Object... objArr) {
                long j;
                try {
                    PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    if (packageInfo == null) {
                        return false;
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        j = packageInfo.getLongVersionCode();
                    } else {
                        j = (long) packageInfo.versionCode;
                    }
                    return Boolean.valueOf(j >= 1);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return false;
                }
            }
        };
        this.a = cfVar;
    }

    @Override // com.bytedance.embedapplog.cf
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        Boolean b2 = this.b.b(context);
        if (this.a == null || b2.booleanValue()) {
            return b2.booleanValue();
        }
        return this.a.a(context);
    }

    @Override // com.bytedance.embedapplog.cf
    public cf.a b(final Context context) {
        if (this.a != null && !this.b.b(new Object[0]).booleanValue()) {
            return this.a.b(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        cf.a aVar = new cf.a();
        aVar.b = (String) new cn(context, intent, new cn.b<br, String>() {
            /* class com.bytedance.embedapplog.ck.AnonymousClass2 */

            /* renamed from: a */
            public br b(IBinder iBinder) {
                return br.a.a(iBinder);
            }

            public String a(br brVar) {
                if (brVar == null) {
                    return null;
                }
                String c = ck.this.c(context);
                if (!TextUtils.isEmpty(c)) {
                    return brVar.a(context.getPackageName(), c, "OUID");
                }
                return null;
            }
        }).a();
        return aVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d A[Catch:{ Exception -> 0x0054 }] */
    public String c(Context context) {
        Signature[] signatureArr;
        MessageDigest instance;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                signatureArr = packageInfo.signatures;
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    instance = MessageDigest.getInstance("SHA1");
                    if (instance != null) {
                        byte[] digest = instance.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        return sb.toString();
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        signatureArr = null;
        byte[] byteArray = signatureArr[0].toByteArray();
        try {
            instance = MessageDigest.getInstance("SHA1");
            if (instance != null) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
