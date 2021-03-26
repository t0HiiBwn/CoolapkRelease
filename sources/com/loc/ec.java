package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AMapDnsManager */
public final class ec {
    public static int a = 1;
    public static int b = 2;
    private static ec e;
    private long c = 0;
    private boolean d = false;
    private ArrayList<String> f = new ArrayList<>();
    private dq g = new dq();
    private dq h = new dq();
    private long i = 120000;
    private Context j;
    private String k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1372l = false;

    private ec(Context context) {
        this.j = context;
    }

    public static synchronized ec a(Context context) {
        ec ecVar;
        synchronized (ec.class) {
            if (e == null) {
                e = new ec(context);
            }
            ecVar = e;
        }
        return ecVar;
    }

    static /* synthetic */ boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0 || strArr.length != strArr2.length) {
            return false;
        }
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!strArr[i2].equals(strArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ String[] a(JSONArray jSONArray, int i2) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new String[0];
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            String string = jSONArray.getString(i3);
            if (!TextUtils.isEmpty(string)) {
                if (i2 == b) {
                    string = "[" + string + "]";
                }
                strArr[i3] = string;
            }
        }
        return strArr;
    }

    /* access modifiers changed from: private */
    public dq b(int i2) {
        return i2 == b ? this.h : this.g;
    }

    static /* synthetic */ void b(ec ecVar, int i2) {
        if (ecVar.b(i2).a() != null && ecVar.b(i2).a().length > 0) {
            String str = ecVar.b(i2).a()[0];
            if (!str.equals(ecVar.k) && !ecVar.f.contains(str)) {
                ecVar.k = str;
                SharedPreferences.Editor a2 = eo.a(ecVar.j, "cbG9jaXA");
                eo.a(a2, c(i2), str);
                eo.a(a2);
            }
        }
    }

    private synchronized void b(boolean z, final int i2) {
        if (!z) {
            if (!ei.o() && this.f1372l) {
                return;
            }
        }
        if (this.c != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.c;
            if (currentTimeMillis - j2 < this.i) {
                return;
            }
            if (currentTimeMillis - j2 < 60000) {
                return;
            }
        }
        this.c = System.currentTimeMillis();
        this.f1372l = true;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringBuffer.append(stackTraceElement.getClassName() + "(" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber() + "),");
        }
        ab.d().submit(new Runnable() {
            /* class com.loc.ec.AnonymousClass1 */

            @Override // java.lang.Runnable
            public final void run() {
                JSONObject jSONObject;
                int i;
                StringBuilder sb = new StringBuilder("http://");
                sb.append(ei.r());
                sb.append("?host=dualstack.apilocate.amap.com&query=");
                sb.append(i2 == ec.b ? 6 : 4);
                String sb2 = sb.toString();
                ed edVar = new ed();
                edVar.f = sb2;
                edVar.b(sb2);
                try {
                    aq.a();
                    JSONObject jSONObject2 = new JSONObject(new String(aq.b(edVar)));
                    String[] a2 = ec.a(jSONObject2.optJSONArray("ips"), ec.a);
                    if (a2.length > 0 && !ec.a(a2, ec.this.b(ec.a).a())) {
                        ec.this.b(ec.a).a(a2);
                        ec.b(ec.this, ec.a);
                    }
                    String[] a3 = ec.a(jSONObject2.optJSONArray("ipsv6"), ec.b);
                    if (a3.length > 0 && !ec.a(a3, ec.this.b(ec.b).a())) {
                        ec.this.b(ec.b).a(a3);
                        ec.b(ec.this, ec.b);
                    }
                    if ((jSONObject2.has("ips") || jSONObject2.has("ipsv6")) && jSONObject2.has("ttl") && (i = jSONObject2.getInt("ttl")) > 30) {
                        ec.this.i = (long) (i * 1000);
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                }
                en.a(ec.this.j, "O018", jSONObject);
            }
        });
    }

    private static String c(int i2) {
        return i2 == b ? "last_ip_6" : "last_ip_4";
    }

    private void d(int i2) {
        if (b(i2).d()) {
            SharedPreferences.Editor a2 = eo.a(this.j, "cbG9jaXA");
            eo.a(a2, c(i2));
            eo.a(a2);
            b(i2).a(false);
        }
    }

    private String e(int i2) {
        String str;
        int i3 = 0;
        b(false, i2);
        String[] a2 = b(i2).a();
        if (a2 == null || a2.length <= 0) {
            String a3 = eo.a(this.j, "cbG9jaXA", c(i2), (String) null);
            if (!TextUtils.isEmpty(a3) && !this.f.contains(a3)) {
                b(i2).a(a3);
                b(i2).b(a3);
                b(i2).a(true);
            }
            return b(i2).b();
        }
        int length = a2.length;
        while (true) {
            if (i3 >= length) {
                str = null;
                break;
            }
            str = a2[i3];
            if (!this.f.contains(str)) {
                break;
            }
            i3++;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b(i2).a(str);
        return str;
    }

    public final String a(ef efVar, int i2) {
        try {
            if (ei.p() && efVar != null) {
                String c2 = efVar.c();
                String host = new URL(c2).getHost();
                if (!"http://abroad.apilocate.amap.com/mobile/binary".equals(c2)) {
                    if (!"abroad.apilocate.amap.com".equals(host)) {
                        String str = "apilocate.amap.com".equalsIgnoreCase(host) ? "httpdns.apilocate.amap.com" : host;
                        String e2 = e(i2);
                        if (!TextUtils.isEmpty(e2)) {
                            if (i2 == b) {
                                efVar.h = c2.replace(host, e2);
                            } else {
                                efVar.g = c2.replace(host, e2);
                            }
                            efVar.b().put("host", str);
                            efVar.c(str);
                            return e2;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final void a(int i2) {
        if (!b(i2).e()) {
            this.f.add(b(i2).b());
            d(i2);
            b(true, i2);
            return;
        }
        d(i2);
    }

    public final void a(boolean z, int i2) {
        b(i2).b(z);
        if (z) {
            String c2 = b(i2).c();
            String b2 = b(i2).b();
            if (!TextUtils.isEmpty(b2) && !b2.equals(c2)) {
                SharedPreferences.Editor a2 = eo.a(this.j, "cbG9jaXA");
                eo.a(a2, c(i2), b2);
                eo.a(a2);
            }
        }
    }
}
