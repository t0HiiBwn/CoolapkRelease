package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.os.SystemClock;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.b;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.huawei.hms.framework.network.grs.local.model.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends b implements Callable<d> {
    private static final String b = "g";

    public g(String str, int i, a aVar, Context context, String str2) {
        super(str, i, aVar, context, str2);
    }

    private String h() {
        HashSet<String> hashSet = new HashSet();
        a a = b.a(d().getPackageName()).a();
        if (a == null) {
            Logger.w(b, "get local assets appGrs is null.");
            return "";
        }
        Map<String, c> b2 = a.b();
        if (b2 != null && !b2.isEmpty()) {
            for (Map.Entry<String, c> entry : b2.entrySet()) {
                hashSet.add(entry.getValue().a());
            }
            if (hashSet.isEmpty()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (String str : hashSet) {
                jSONArray.put(str);
            }
            try {
                jSONObject.put("services", jSONArray);
                Logger.v(b, "post service list is:%s,and appName is:%s", jSONObject.toString(), a.a());
                return jSONObject.toString();
            } catch (JSONException unused) {
            }
        }
        return "";
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cd  */
    /* renamed from: g */
    public d call() {
        long j;
        long j2;
        long j3;
        IOException e;
        byte[] bArr;
        String str = b;
        Logger.i(str, "Post call execute");
        long j4 = 0;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                j2 = System.currentTimeMillis();
                HttpsURLConnection a = com.huawei.hms.framework.network.grs.c.a.a.a(a(), d(), e());
                InputStream inputStream = null;
                if (a == null) {
                    Logger.w(str, "create HttpsURLConnection instance by url return null.");
                    return null;
                }
                a.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                a.setRequestMethod("POST");
                a.setDoOutput(true);
                a.setDoInput(true);
                a.connect();
                OutputStream outputStream = a.getOutputStream();
                outputStream.write(h().getBytes());
                outputStream.close();
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
                Logger.w(b, "RequestCallableV2 run task catch IOException", e);
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
            Logger.w(b, "RequestCallableV2 run task catch IOException", e);
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
