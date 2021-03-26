package com.huawei.hms.framework.network.grs.b;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private static final String a = "d";
    private Map<String, List<String>> b;
    private byte[] c;
    private int d = 0;
    private long e;
    private long f;
    private long g;
    private String h;
    private int i = 2;
    private int j = 9001;
    private String k = "";
    private String l = "";
    private String m = "";
    private long n = 0;
    private Exception o;
    private String p;
    private int q;

    public d(int i2, Map<String, List<String>> map, byte[] bArr, long j2) {
        this.d = i2;
        this.b = map;
        this.c = bArr;
        this.e = j2;
        n();
    }

    public d(Exception exc, long j2) {
        this.o = exc;
        this.e = j2;
    }

    private void a(Map<String, String> map) {
        long j2;
        NumberFormatException e2;
        if (map == null || map.size() <= 0) {
            Logger.w(a, "getExpireTime {headers == null} or {headers.size() <= 0}");
            return;
        }
        if (map.containsKey("Cache-Control")) {
            String str = map.get("Cache-Control");
            if (!TextUtils.isEmpty(str) && str.contains("max-age=")) {
                try {
                    j2 = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                    try {
                        Logger.v(a, "Cache-Control value{%s}", Long.valueOf(j2));
                    } catch (NumberFormatException e3) {
                        e2 = e3;
                    }
                } catch (NumberFormatException e4) {
                    e2 = e4;
                    j2 = 0;
                    Logger.w(a, "getExpireTime addHeadersToResult NumberFormatException", e2);
                    j2 = 86400;
                    long j3 = j2 * 1000;
                    Logger.v(a, "convert expireTime{%s}", Long.valueOf(j3));
                    d(String.valueOf(j3 + System.currentTimeMillis()));
                }
                if (j2 <= 0 || j2 > 2592000) {
                    j2 = 86400;
                }
                long j3 = j2 * 1000;
                Logger.v(a, "convert expireTime{%s}", Long.valueOf(j3));
                d(String.valueOf(j3 + System.currentTimeMillis()));
            }
        } else if (map.containsKey("Expires")) {
            String str2 = map.get("Expires");
            Logger.v(a, "expires is{%s}", str2);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
            String str3 = null;
            if (map.containsKey("Date")) {
                str3 = map.get("Date");
            }
            try {
                j2 = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
            } catch (ParseException e5) {
                Logger.w(a, "getExpireTime ParseException.", e5);
            }
            j2 = 86400;
            long j3 = j2 * 1000;
            Logger.v(a, "convert expireTime{%s}", Long.valueOf(j3));
            d(String.valueOf(j3 + System.currentTimeMillis()));
        } else {
            Logger.i(a, "response headers neither contains Cache-Control nor Expires.");
        }
        j2 = 0;
        j2 = 86400;
        long j3 = j2 * 1000;
        Logger.v(a, "convert expireTime{%s}", Long.valueOf(j3));
        d(String.valueOf(j3 + System.currentTimeMillis()));
    }

    private void b(int i2) {
        this.i = i2;
    }

    private void b(String str) {
        this.l = str;
    }

    private void b(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            Logger.w(a, "getExpireTime {headers == null} or {headers.size() <= 0}");
            return;
        }
        long j2 = 0;
        if (map.containsKey("Retry-After")) {
            String str = map.get("Retry-After");
            if (!TextUtils.isEmpty(str)) {
                try {
                    j2 = Long.parseLong(str);
                } catch (NumberFormatException e2) {
                    Logger.w(a, "getRetryAfter addHeadersToResult NumberFormatException", e2);
                }
            }
        }
        long j3 = j2 * 1000;
        Logger.v(a, "convert retry-afterTime{%s}", Long.valueOf(j3));
        c(j3);
    }

    private void c(int i2) {
        this.j = i2;
    }

    private void c(long j2) {
        this.n = j2;
    }

    private void c(String str) {
        this.h = str;
    }

    private void d(String str) {
        this.m = str;
    }

    private void e(String str) {
        this.k = str;
    }

    private void n() {
        o();
        q();
    }

    private void o() {
        if (h() || i()) {
            Map<String, String> p2 = p();
            try {
                if (h()) {
                    a(p2);
                }
                if (i()) {
                    b(p2);
                }
            } catch (JSONException e2) {
                Logger.w(a, "parseHeader catch JSONException", e2);
            }
        }
    }

    private Map<String, String> p() {
        HashMap hashMap = new HashMap(16);
        Map<String, List<String>> map = this.b;
        if (map == null || map.size() <= 0) {
            Logger.v(a, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return hashMap;
        }
        for (Map.Entry<String, List<String>> entry : this.b.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().get(0));
        }
        return hashMap;
    }

    private void q() {
        if (!h()) {
            Logger.i(a, "GRSSDK parse server body all failed.");
            b(2);
            return;
        }
        try {
            String byte2Str = StringUtils.byte2Str(this.c);
            JSONObject jSONObject = new JSONObject(byte2Str);
            int i2 = -1;
            if (jSONObject.has("isSuccess")) {
                i2 = jSONObject.getInt("isSuccess");
            } else if (jSONObject.has("resultCode")) {
                i2 = jSONObject.getInt("resultCode");
            } else {
                Logger.e(a, "sth. wrong because server errorcode's key.");
            }
            b(i2);
            boolean z = i2 == 0 && byte2Str.contains("services");
            String str = "";
            if (i2 == 1 || z) {
                c(jSONObject.getJSONObject("services").toString());
                if (z) {
                    if (jSONObject.has("errorList")) {
                        str = jSONObject.getString("errorList");
                    }
                    b(str);
                    return;
                }
                return;
            }
            b(2);
            c(jSONObject.has("errorCode") ? jSONObject.getInt("errorCode") : 9001);
            if (jSONObject.has("errorDesc")) {
                str = jSONObject.getString("errorDesc");
            }
            e(str);
        } catch (JSONException e2) {
            Logger.w(a, "GrsResponse GrsResponse(String result) JSONException", e2);
            b(2);
        }
    }

    public long a() {
        return this.f;
    }

    public void a(int i2) {
        this.q = i2;
    }

    public void a(long j2) {
        this.f = j2;
    }

    public void a(String str) {
        this.p = str;
    }

    public long b() {
        return this.g;
    }

    public void b(long j2) {
        this.g = j2;
    }

    public String c() {
        return this.h;
    }

    public String d() {
        return this.m;
    }

    public long e() {
        return this.n;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.j;
    }

    public boolean h() {
        return this.d == 200;
    }

    public boolean i() {
        return this.d == 503;
    }

    public Exception j() {
        return this.o;
    }

    public String k() {
        return this.p;
    }

    public int l() {
        return this.d;
    }

    public long m() {
        return this.e;
    }
}
