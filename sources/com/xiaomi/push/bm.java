package com.xiaomi.push;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class bm {
    public String a = "";
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    protected String h;
    private long i;
    private ArrayList<bw> j = new ArrayList<>();
    private String k;
    private double l = 0.1d;
    private String m = "s.mi1.cc";
    private long n = 86400000;

    public bm(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i = System.currentTimeMillis();
            this.j.add(new bw(str, -1));
            this.a = bq.b();
            this.b = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    private synchronized void d(String str) {
        Iterator<bw> it2 = this.j.iterator();
        while (it2.hasNext()) {
            if (TextUtils.equals(it2.next().a, str)) {
                it2.remove();
            }
        }
    }

    public synchronized bm a(JSONObject jSONObject) {
        this.a = jSONObject.optString("net");
        this.n = jSONObject.getLong("ttl");
        this.l = jSONObject.getDouble("pct");
        this.i = jSONObject.getLong("ts");
        this.d = jSONObject.optString("city");
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString("cty");
        this.e = jSONObject.optString("isp");
        this.f = jSONObject.optString("ip");
        this.b = jSONObject.optString("host");
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            a(new bw().a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }

    public ArrayList<String> a(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it2 = a(true).iterator();
                while (it2.hasNext()) {
                    bo a2 = bo.a(it2.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), a2.b(), a2.a(), url.getFile()).toString());
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
        int size = this.j.size();
        bw[] bwVarArr = new bw[size];
        this.j.toArray(bwVarArr);
        Arrays.sort(bwVarArr);
        arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < size; i2++) {
            bw bwVar = bwVarArr[i2];
            if (z) {
                substring = bwVar.a;
            } else {
                int indexOf = bwVar.a.indexOf(":");
                substring = indexOf != -1 ? bwVar.a.substring(0, indexOf) : bwVar.a;
            }
            arrayList.add(substring);
        }
        return arrayList;
    }

    public void a(double d2) {
        this.l = d2;
    }

    public void a(long j2) {
        if (j2 > 0) {
            this.n = j2;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j2);
    }

    synchronized void a(bw bwVar) {
        d(bwVar.a);
        this.j.add(bwVar);
    }

    public void a(String str, int i2, long j2, long j3, Exception exc) {
        a(str, new bl(i2, j2, j3, exc));
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

    public synchronized void a(String str, bl blVar) {
        Iterator<bw> it2 = this.j.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            bw next = it2.next();
            if (TextUtils.equals(str, next.a)) {
                next.a(blVar);
                break;
            }
        }
    }

    public synchronized void a(String[] strArr) {
        int i2;
        int size = this.j.size() - 1;
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
                if (TextUtils.equals(this.j.get(size).a, strArr[i2])) {
                    this.j.remove(size);
                    break;
                }
                i2++;
            }
            size--;
        }
        Iterator<bw> it2 = this.j.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            bw next = it2.next();
            if (next.b > i3) {
                i3 = next.b;
            }
        }
        while (i2 < strArr.length) {
            a(new bw(strArr[i2], (strArr.length + i3) - i2));
            i2++;
        }
    }

    public boolean a() {
        return TextUtils.equals(this.a, bq.b());
    }

    public boolean a(bm bmVar) {
        return TextUtils.equals(this.a, bmVar.a);
    }

    public synchronized void b(String str) {
        a(new bw(str));
    }

    public void b(String str, long j2, long j3) {
        a(str, 0, j2, j3, null);
    }

    public void b(String str, long j2, long j3, Exception exc) {
        a(str, -1, j2, j3, exc);
    }

    public boolean b() {
        return System.currentTimeMillis() - this.i < this.n;
    }

    public void c(String str) {
        this.m = str;
    }

    boolean c() {
        long j2 = this.n;
        if (864000000 >= j2) {
            j2 = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.i;
        return currentTimeMillis - j3 > j2 || (currentTimeMillis - j3 > this.n && this.a.startsWith("WIFI-"));
    }

    public synchronized ArrayList<String> d() {
        return a(false);
    }

    public synchronized String e() {
        if (!TextUtils.isEmpty(this.k)) {
            return this.k;
        } else if (TextUtils.isEmpty(this.e)) {
            return "hardcode_isp";
        } else {
            String a2 = ah.a(new String[]{this.e, this.c, this.d, this.g, this.f}, "_");
            this.k = a2;
            return a2;
        }
    }

    public synchronized JSONObject f() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.a);
        jSONObject.put("ttl", this.n);
        jSONObject.put("pct", this.l);
        jSONObject.put("ts", this.i);
        jSONObject.put("city", this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put("cty", this.g);
        jSONObject.put("isp", this.e);
        jSONObject.put("ip", this.f);
        jSONObject.put("host", this.b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator<bw> it2 = this.j.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        sb.append(e());
        Iterator<bw> it2 = this.j.iterator();
        while (it2.hasNext()) {
            sb.append("\n");
            sb.append(it2.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
