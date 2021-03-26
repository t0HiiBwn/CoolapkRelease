package com.xiaomi.push;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bq {
    protected static Map<String, bm> b = new HashMap();
    protected static Context c;
    protected static boolean e = false;
    private static bq l;
    private static a m;
    private static String n;
    private static String o;
    protected Map<String, bn> a;
    protected b d;
    private bp f;
    private String g;
    private long h;
    private final long i;
    private long j;
    private String k;

    public interface a {
        bq a(Context context, bp bpVar, b bVar, String str);
    }

    public interface b {
        String a(String str);
    }

    protected bq(Context context, bp bpVar, b bVar, String str) {
        this(context, bpVar, bVar, str, null, null);
    }

    protected bq(Context context, bp bpVar, b bVar, String str, String str2, String str3) {
        this.a = new HashMap();
        this.g = "0";
        this.h = 0;
        this.i = 15;
        this.j = 0;
        this.k = "isp_prov_city_country_ip";
        this.d = bVar;
        this.f = bpVar == null ? new bs(this) : bpVar;
        this.g = str;
        n = str2 == null ? context.getPackageName() : str2;
        o = str3 == null ? m() : str3;
    }

    public static synchronized bq a() {
        bq bqVar;
        synchronized (bq.class) {
            bqVar = l;
            if (bqVar == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return bqVar;
    }

    private ArrayList<bm> a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        k();
        synchronized (this.a) {
            h();
            for (String str : this.a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        boolean isEmpty = b.isEmpty();
        synchronized (b) {
            for (Object obj : b.values().toArray()) {
                bm bmVar = (bm) obj;
                if (!bmVar.b()) {
                    b.remove(bmVar.b);
                    isEmpty = true;
                }
            }
        }
        if (!arrayList.contains(c())) {
            arrayList.add(c());
        }
        ArrayList<bm> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(null);
        }
        try {
            String str2 = aa.e(c) ? "wifi" : "wap";
            String a2 = a(arrayList, str2, this.g, isEmpty);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject3 = new JSONObject(a2);
                c.b(a2);
                if ("OK".equalsIgnoreCase(jSONObject3.getString("S"))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    c.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i3 = 0;
                    while (i3 < arrayList.size()) {
                        String str3 = arrayList.get(i3);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            c.a("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            bm bmVar2 = new bm(str3);
                            int i4 = 0;
                            while (i4 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i4);
                                if (!TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                    bmVar2.a(new bw(string6, optJSONArray.length() - i4));
                                } else {
                                    jSONObject2 = jSONObject5;
                                }
                                i4++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i3, bmVar2);
                            bmVar2.g = string5;
                            bmVar2.c = string;
                            bmVar2.e = string3;
                            bmVar2.f = string4;
                            bmVar2.d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                bmVar2.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                bmVar2.c(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has("ttl")) {
                                bmVar2.a(((long) jSONObject4.getInt("ttl")) * 1000);
                            }
                            f(bmVar2.e());
                        }
                        i3++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j2 = 604800000;
                        if (jSONObject4.has("reserved-ttl")) {
                            j2 = ((long) jSONObject4.getInt("reserved-ttl")) * 1000;
                        }
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                c.a("no bucket found for " + next);
                            } else {
                                bm bmVar3 = new bm(next);
                                bmVar3.a(j2);
                                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                    String string7 = optJSONArray2.getString(i5);
                                    if (!TextUtils.isEmpty(string7)) {
                                        bmVar3.a(new bw(string7, optJSONArray2.length() - i5));
                                    }
                                }
                                synchronized (b) {
                                    if (this.f.a(next)) {
                                        b.put(next, bmVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            c.a("failed to get bucket " + e2.getMessage());
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            bm bmVar4 = arrayList2.get(i6);
            if (bmVar4 != null) {
                a(arrayList.get(i6), bmVar4);
            }
        }
        i();
        return arrayList2;
    }

    public static synchronized void a(Context context, bp bpVar, b bVar, String str, String str2, String str3) {
        synchronized (bq.class) {
            Context applicationContext = context.getApplicationContext();
            c = applicationContext;
            if (applicationContext == null) {
                c = context;
            }
            if (l == null) {
                a aVar = m;
                if (aVar == null) {
                    l = new bq(context, bpVar, bVar, str, str2, str3);
                } else {
                    l = aVar.a(context, bpVar, bVar, str);
                }
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (bq.class) {
            m = aVar;
            l = null;
        }
    }

    public static void a(String str, String str2) {
        bm bmVar = b.get(str);
        synchronized (b) {
            if (bmVar == null) {
                bm bmVar2 = new bm(str);
                bmVar2.a(604800000L);
                bmVar2.b(str2);
                b.put(str, bmVar2);
            } else {
                bmVar.b(str2);
            }
        }
    }

    static String b() {
        NetworkInfo activeNetworkInfo;
        Context context = c;
        if (context == null) {
            return "unknown";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1) {
                WifiManager wifiManager = (WifiManager) c.getSystemService("wifi");
                if (!(wifiManager == null || wifiManager.getConnectionInfo() == null)) {
                    return "WIFI-" + wifiManager.getConnectionInfo().getSSID();
                }
                return "unknown";
            }
            return activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName();
        } catch (Throwable unused) {
        }
    }

    static String e(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i2 = 0; i2 < bytes.length; i2++) {
                byte b2 = bytes[i2];
                int i3 = b2 & 240;
                if (i3 != 240) {
                    bytes[i2] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | i3);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private String m() {
        try {
            PackageInfo packageInfo = c.getPackageManager().getPackageInfo(c.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    public bm a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return a(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    public bm a(String str, boolean z) {
        bm d2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        } else if (!this.f.a(str)) {
            return null;
        } else {
            bm c2 = c(str);
            return (c2 == null || !c2.b()) ? (!z || !aa.c(c) || (d2 = d(str)) == null) ? new bt(this, str, c2) : d2 : c2;
        }
    }

    protected String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<z> arrayList3 = new ArrayList();
        arrayList3.add(new x("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new x("conpt", e(aa.k(c))));
        }
        if (z) {
            arrayList3.add(new x("reserved", "1"));
        }
        arrayList3.add(new x("uuid", str2));
        arrayList3.add(new x("list", ah.a(arrayList, ",")));
        arrayList3.add(new x("countrycode", com.xiaomi.push.service.a.a(c).b()));
        bm c2 = c(c());
        String format = String.format(Locale.US, "http://%1$s/gslb/?ver=4.0", c());
        if (c2 == null) {
            arrayList2.add(format);
            synchronized (b) {
                bm bmVar = b.get("resolver.msg.xiaomi.net");
                if (bmVar != null) {
                    Iterator<String> it2 = bmVar.a(true).iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "http://%1$s/gslb/?ver=4.0", it2.next()));
                    }
                }
            }
        } else {
            arrayList2 = c2.a(format);
        }
        Iterator<String> it3 = arrayList2.iterator();
        IOException e2 = null;
        while (it3.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it3.next()).buildUpon();
            for (z zVar : arrayList3) {
                buildUpon.appendQueryParameter(zVar.a(), zVar.b());
            }
            try {
                b bVar = this.d;
                return bVar == null ? aa.a(c, new URL(buildUpon.toString())) : bVar.a(buildUpon.toString());
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 == null) {
            return null;
        }
        c.a("network exception: " + e2.getMessage());
        throw e2;
    }

    public void a(String str, bm bmVar) {
        if (TextUtils.isEmpty(str) || bmVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + bmVar);
        } else if (this.f.a(str)) {
            synchronized (this.a) {
                h();
                if (this.a.containsKey(str)) {
                    this.a.get(str).a(bmVar);
                } else {
                    bn bnVar = new bn(str);
                    bnVar.a(bmVar);
                    this.a.put(str, bnVar);
                }
            }
        }
    }

    public bm b(String str) {
        return a(str, true);
    }

    protected bm c(String str) {
        bn bnVar;
        bm a2;
        synchronized (this.a) {
            h();
            bnVar = this.a.get(str);
        }
        if (bnVar == null || (a2 = bnVar.a()) == null) {
            return null;
        }
        return a2;
    }

    protected String c() {
        String a2 = com.xiaomi.push.service.a.a(c).a();
        return (TextUtils.isEmpty(a2) || com.xiaomi.push.service.a.a.China.name().equals(a2)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    protected bm d(String str) {
        if (System.currentTimeMillis() - this.j <= this.h * 60 * 1000) {
            return null;
        }
        this.j = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        bm bmVar = a(arrayList).get(0);
        if (bmVar != null) {
            this.h = 0;
            return bmVar;
        }
        long j2 = this.h;
        if (j2 >= 15) {
            return null;
        }
        this.h = j2 + 1;
        return null;
    }

    public void d() {
        synchronized (this.a) {
            this.a.clear();
        }
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.a) {
            for (Map.Entry<String, bn> entry : this.a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void f() {
        ArrayList<String> arrayList;
        synchronized (this.a) {
            h();
            arrayList = new ArrayList<>(this.a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                bn bnVar = this.a.get(arrayList.get(size));
                if (!(bnVar == null || bnVar.a() == null)) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<bm> a2 = a(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (a2.get(i2) != null) {
                a(arrayList.get(i2), a2.get(i2));
            }
        }
    }

    public void f(String str) {
        this.k = str;
    }

    protected String g() {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            File file = new File(c.getFilesDir(), j());
            if (file.isFile()) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            String sb2 = sb.toString();
                            jg.a(bufferedReader);
                            return sb2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        c.a("load host exception " + th.getMessage());
                        return null;
                    } finally {
                        jg.a(bufferedReader);
                    }
                }
            } else {
                jg.a((Closeable) null);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            c.a("load host exception " + th.getMessage());
            return null;
        }
    }

    protected void g(String str) {
        synchronized (this.a) {
            this.a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") == 2) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    bn a2 = new bn().a(optJSONArray.getJSONObject(i2));
                    this.a.put(a2.c(), a2);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    bm a3 = new bm("").a(optJSONArray2.getJSONObject(i3));
                    b.put(a3.b, a3);
                }
            } else {
                throw new JSONException("Bad version");
            }
        }
    }

    protected boolean h() {
        synchronized (this.a) {
            if (e) {
                return true;
            }
            e = true;
            this.a.clear();
            try {
                String g2 = g();
                if (!TextUtils.isEmpty(g2)) {
                    g(g2);
                    c.b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                c.a("load bucket failure: " + th.getMessage());
            }
            return false;
        }
    }

    public void i() {
        synchronized (this.a) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(c.openFileOutput(j(), 0)));
                String jSONObject = l().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e2) {
                c.a("persist bucket failure: " + e2.getMessage());
            }
        }
    }

    protected String j() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) c.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "com.xiaomi";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return "com.xiaomi";
    }

    public void k() {
        synchronized (this.a) {
            for (bn bnVar : this.a.values()) {
                bnVar.a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    for (String str : this.a.keySet()) {
                        if (this.a.get(str).b().isEmpty()) {
                            this.a.remove(str);
                        }
                    }
                }
            }
        }
    }

    protected JSONObject l() {
        JSONObject jSONObject;
        synchronized (this.a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (bn bnVar : this.a.values()) {
                jSONArray.put(bnVar.d());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (bm bmVar : b.values()) {
                jSONArray2.put(bmVar.f());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }
}
