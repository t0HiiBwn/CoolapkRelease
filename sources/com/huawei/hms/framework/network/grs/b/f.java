package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.os.SystemClock;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.c.a.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;

public class f extends b implements Callable<d> {
    private static final String b = "f";

    public f(String str, int i, a aVar, Context context, String str2) {
        super(str, i, aVar, context, str2);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ac  */
    /* renamed from: g */
    public d call() {
        long j;
        long j2;
        long j3;
        IOException e;
        byte[] bArr;
        String str = b;
        Logger.i(str, "Get call execute");
        long j4 = 0;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                j2 = System.currentTimeMillis();
                HttpsURLConnection a = a.a(a(), d(), e());
                InputStream inputStream = null;
                if (a == null) {
                    Logger.w(str, "create HttpsURLConnection instance by url return null.");
                    return null;
                }
                a.setRequestMethod("GET");
                a.connect();
                int responseCode = a.getResponseCode();
                if (responseCode == 200) {
                    try {
                        inputStream = a.getInputStream();
                        byte[] byteArray = IoUtils.toByteArray(inputStream);
                        IoUtils.closeSecure(inputStream);
                        bArr = byteArray;
                    } catch (Throwable th) {
                        IoUtils.closeSecure(inputStream);
                        throw th;
                    }
                } else {
                    bArr = null;
                }
                Map headerFields = a.getHeaderFields();
                a.disconnect();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                j = System.currentTimeMillis();
                this.a = new d(responseCode, headerFields, bArr, elapsedRealtime2 - elapsedRealtime);
                this.a.a(a());
                this.a.a(c());
                this.a.a(j2);
                this.a.b(j);
                if (b() != null) {
                    b().a(this.a);
                }
                return this.a;
            } catch (IOException e2) {
                e = e2;
                j4 = elapsedRealtime;
                j3 = 0;
                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                j = System.currentTimeMillis();
                Logger.w(b, "RequestCallable run task catch IOException", e);
                this.a = new d(e, elapsedRealtime3 - j4);
                j2 = j3;
                this.a.a(a());
                this.a.a(c());
                this.a.a(j2);
                this.a.b(j);
                if (b() != null) {
                }
                return this.a;
            }
        } catch (IOException e3) {
            e = e3;
            j3 = 0;
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            j = System.currentTimeMillis();
            Logger.w(b, "RequestCallable run task catch IOException", e);
            this.a = new d(e, elapsedRealtime3 - j4);
            j2 = j3;
            this.a.a(a());
            this.a.a(c());
            this.a.a(j2);
            this.a.b(j);
            if (b() != null) {
            }
            return this.a;
        }
    }
}
