package com.xiaomi.push;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class cm {
    private double a = 0.1d;

    /* renamed from: a  reason: collision with other field name */
    private long f269a;

    /* renamed from: a  reason: collision with other field name */
    public String f270a = "";

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<cv> f271a = new ArrayList<>();
    private long b = 86400000;

    /* renamed from: b  reason: collision with other field name */
    public String f272b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    protected String h;
    private String i;
    private String j = "s.mi1.cc";

    public cm(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f269a = System.currentTimeMillis();
            this.f271a.add(new cv(str, -1));
            this.f270a = cq.m185a();
            this.f272b = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    private synchronized void c(String str) {
        Iterator<cv> it2 = this.f271a.iterator();
        while (it2.hasNext()) {
            if (TextUtils.equals(it2.next().f288a, str)) {
                it2.remove();
            }
        }
    }

    public synchronized cm a(JSONObject jSONObject) {
        this.f270a = jSONObject.optString("net");
        this.b = jSONObject.getLong("ttl");
        this.a = jSONObject.getDouble("pct");
        this.f269a = jSONObject.getLong("ts");
        this.d = jSONObject.optString("city");
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString("cty");
        this.e = jSONObject.optString("isp");
        this.f = jSONObject.optString("ip");
        this.f272b = jSONObject.optString("host");
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            a(new cv().a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        } else if (TextUtils.isEmpty(this.e)) {
            return "hardcode_isp";
        } else {
            String a2 = bi.a(new String[]{this.e, this.c, this.d, this.g, this.f}, "_");
            this.i = a2;
            return a2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m176a() {
        return a(false);
    }

    public ArrayList<String> a(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f272b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it2 = a(true).iterator();
                while (it2.hasNext()) {
                    co a2 = co.a(it2.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), a2.m184a(), a2.a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        String substring;
        int size = this.f271a.size();
        cv[] cvVarArr = new cv[size];
        this.f271a.toArray(cvVarArr);
        Arrays.sort(cvVarArr);
        arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < size; i2++) {
            cv cvVar = cvVarArr[i2];
            if (z) {
                substring = cvVar.f288a;
            } else {
                int indexOf = cvVar.f288a.indexOf(":");
                substring = indexOf != -1 ? cvVar.f288a.substring(0, indexOf) : cvVar.f288a;
            }
            arrayList.add(substring);
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m177a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f270a);
        jSONObject.put("ttl", this.b);
        jSONObject.put("pct", this.a);
        jSONObject.put("ts", this.f269a);
        jSONObject.put("city", this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put("cty", this.g);
        jSONObject.put("isp", this.e);
        jSONObject.put("ip", this.f);
        jSONObject.put("host", this.f272b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator<cv> it2 = this.f271a.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public void a(double d2) {
        this.a = d2;
    }

    public void a(long j2) {
        if (j2 > 0) {
            this.b = j2;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j2);
    }

    synchronized void a(cv cvVar) {
        c(cvVar.f288a);
        this.f271a.add(cvVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m178a(String str) {
        a(new cv(str));
    }

    public void a(String str, int i2, long j2, long j3, Exception exc) {
        a(str, new cl(i2, j2, j3, exc));
    }

    public void a(String str, long j2, long j3) {
        try {
            b(new URL(str).getHost(), j2, j3);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j2, long j3, Exception exc) {
        try {
            b(new URL(str).getHost(), j2, j3, exc);
        } catch (MalformedURLException unused) {
        }
    }

    public synchronized void a(String str, cl clVar) {
        Iterator<cv> it2 = this.f271a.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            cv next = it2.next();
            if (TextUtils.equals(str, next.f288a)) {
                next.a(clVar);
                break;
            }
        }
    }

    public synchronized void a(String[] strArr) {
        int i2;
        int size = this.f271a.size() - 1;
        while (true) {
            i2 = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (TextUtils.equals(this.f271a.get(size).f288a, strArr[i2])) {
                    this.f271a.remove(size);
                    break;
                }
                i2++;
            }
            size--;
        }
        Iterator<cv> it2 = this.f271a.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            cv next = it2.next();
            if (next.a > i3) {
                i3 = next.a;
            }
        }
        while (i2 < strArr.length) {
            a(new cv(strArr[i2], (strArr.length + i3) - i2));
            i2++;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m179a() {
        return TextUtils.equals(this.f270a, cq.m185a());
    }

    public boolean a(cm cmVar) {
        return TextUtils.equals(this.f270a, cmVar.f270a);
    }

    public void b(String str) {
        this.j = str;
    }

    public void b(String str, long j2, long j3) {
        a(str, 0, j2, j3, null);
    }

    public void b(String str, long j2, long j3, Exception exc) {
        a(str, -1, j2, j3, exc);
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f269a < this.b;
    }

    boolean c() {
        long j2 = this.b;
        if (864000000 >= j2) {
            j2 = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f269a;
        return currentTimeMillis - j3 > j2 || (currentTimeMillis - j3 > this.b && this.f270a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f270a);
        sb.append("\n");
        sb.append(a());
        Iterator<cv> it2 = this.f271a.iterator();
        while (it2.hasNext()) {
            sb.append("\n");
            sb.append(it2.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
