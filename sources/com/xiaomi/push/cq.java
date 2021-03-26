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
import com.xiaomi.push.service.module.PushChannelRegion;
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

public class cq {
    protected static Context a;

    /* renamed from: a  reason: collision with other field name */
    private static a f275a;

    /* renamed from: a  reason: collision with other field name */
    private static cq f276a;

    /* renamed from: a  reason: collision with other field name */
    protected static boolean f277a = false;
    protected static Map<String, cm> b = new HashMap();
    private static String c;
    private static String d;

    /* renamed from: a  reason: collision with other field name */
    private long f278a;

    /* renamed from: a  reason: collision with other field name */
    private cp f279a;

    /* renamed from: a  reason: collision with other field name */
    protected b f280a;

    /* renamed from: a  reason: collision with other field name */
    private String f281a;

    /* renamed from: a  reason: collision with other field name */
    protected Map<String, cn> f282a;

    /* renamed from: b  reason: collision with other field name */
    private final long f283b;

    /* renamed from: b  reason: collision with other field name */
    private String f284b;

    /* renamed from: c  reason: collision with other field name */
    private long f285c;

    public interface a {
        cq a(Context context, cp cpVar, b bVar, String str);
    }

    public interface b {
        String a(String str);
    }

    protected cq(Context context, cp cpVar, b bVar, String str) {
        this(context, cpVar, bVar, str, null, null);
    }

    protected cq(Context context, cp cpVar, b bVar, String str, String str2, String str3) {
        this.f282a = new HashMap();
        this.f281a = "0";
        this.f278a = 0;
        this.f283b = 15;
        this.f285c = 0;
        this.f284b = "isp_prov_city_country_ip";
        this.f280a = bVar;
        this.f279a = cpVar == null ? new cr(this) : cpVar;
        this.f281a = str;
        c = str2 == null ? context.getPackageName() : str2;
        d = str3 == null ? f() : str3;
    }

    public static synchronized cq a() {
        cq cqVar;
        synchronized (cq.class) {
            cqVar = f276a;
            if (cqVar == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return cqVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    static String m185a() {
        NetworkInfo activeNetworkInfo;
        Context context = a;
        if (context == null) {
            return "unknown";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1) {
                WifiManager wifiManager = (WifiManager) a.getSystemService("wifi");
                if (!(wifiManager == null || wifiManager.getConnectionInfo() == null)) {
                    return "WIFI-" + wifiManager.getConnectionInfo().getSSID();
                }
                return "unknown";
            }
            return activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName();
        } catch (Throwable unused) {
        }
    }

    static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                int i2 = b2 & 240;
                if (i2 != 240) {
                    bytes[i] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | i2);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private ArrayList<cm> a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        m194d();
        synchronized (this.f282a) {
            m190a();
            for (String str : this.f282a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        boolean isEmpty = b.isEmpty();
        synchronized (b) {
            for (Object obj : b.values().toArray()) {
                cm cmVar = (cm) obj;
                if (!cmVar.b()) {
                    b.remove(cmVar.f272b);
                    isEmpty = true;
                }
            }
        }
        if (!arrayList.contains(b())) {
            arrayList.add(b());
        }
        ArrayList<cm> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(null);
        }
        try {
            String str2 = bc.d(a) ? "wifi" : "wap";
            String a2 = a(arrayList, str2, this.f281a, isEmpty);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject3 = new JSONObject(a2);
                com.xiaomi.channel.commonutils.logger.b.b(a2);
                if ("OK".equalsIgnoreCase(jSONObject3.getString("S"))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        String str3 = arrayList.get(i2);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.m41a("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            cm cmVar2 = new cm(str3);
                            int i3 = 0;
                            while (i3 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i3);
                                if (!TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                    cmVar2.a(new cv(string6, optJSONArray.length() - i3));
                                } else {
                                    jSONObject2 = jSONObject5;
                                }
                                i3++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i2, cmVar2);
                            cmVar2.g = string5;
                            cmVar2.c = string;
                            cmVar2.e = string3;
                            cmVar2.f = string4;
                            cmVar2.d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                cmVar2.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                cmVar2.b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has("ttl")) {
                                cmVar2.a(((long) jSONObject4.getInt("ttl")) * 1000);
                            }
                            m189a(cmVar2.a());
                        }
                        i2++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j = 604800000;
                        if (jSONObject4.has("reserved-ttl")) {
                            j = ((long) jSONObject4.getInt("reserved-ttl")) * 1000;
                        }
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.b.m41a("no bucket found for " + next);
                            } else {
                                cm cmVar3 = new cm(next);
                                cmVar3.a(j);
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    String string7 = optJSONArray2.getString(i4);
                                    if (!TextUtils.isEmpty(string7)) {
                                        cmVar3.a(new cv(string7, optJSONArray2.length() - i4));
                                    }
                                }
                                synchronized (b) {
                                    if (this.f279a.a(next)) {
                                        b.put(next, cmVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m41a("failed to get bucket " + e.getMessage());
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            cm cmVar4 = arrayList2.get(i5);
            if (cmVar4 != null) {
                a(arrayList.get(i5), cmVar4);
            }
        }
        m193c();
        return arrayList2;
    }

    public static synchronized void a(Context context, cp cpVar, b bVar, String str, String str2, String str3) {
        synchronized (cq.class) {
            Context applicationContext = context.getApplicationContext();
            a = applicationContext;
            if (applicationContext == null) {
                a = context;
            }
            if (f276a == null) {
                a aVar = f275a;
                if (aVar == null) {
                    f276a = new cq(context, cpVar, bVar, str, str2, str3);
                } else {
                    f276a = aVar.a(context, cpVar, bVar, str);
                }
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (cq.class) {
            f275a = aVar;
            f276a = null;
        }
    }

    public static void a(String str, String str2) {
        cm cmVar = b.get(str);
        synchronized (b) {
            if (cmVar == null) {
                cm cmVar2 = new cm(str);
                cmVar2.a(604800000L);
                cmVar2.m178a(str2);
                b.put(str, cmVar2);
            } else {
                cmVar.m178a(str2);
            }
        }
    }

    private String f() {
        try {
            PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public cm m186a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return a(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    public cm a(String str, boolean z) {
        cm d2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        } else if (!this.f279a.a(str)) {
            return null;
        } else {
            cm c2 = c(str);
            return (c2 == null || !c2.b()) ? (!z || !bc.b(a) || (d2 = d(str)) == null) ? new cs(this, str, c2) : d2 : c2;
        }
    }

    protected String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<bb> arrayList3 = new ArrayList();
        arrayList3.add(new az("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new az("conpt", a(bc.m129a(a))));
        }
        if (z) {
            arrayList3.add(new az("reserved", "1"));
        }
        arrayList3.add(new az("uuid", str2));
        arrayList3.add(new az("list", bi.a(arrayList, ",")));
        arrayList3.add(new az("countrycode", com.xiaomi.push.service.a.a(a).b()));
        cm c2 = c(b());
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", b());
        if (c2 == null) {
            arrayList2.add(format);
            synchronized (b) {
                cm cmVar = b.get("resolver.msg.xiaomi.net");
                if (cmVar != null) {
                    Iterator<String> it2 = cmVar.a(true).iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", it2.next()));
                    }
                }
            }
        } else {
            arrayList2 = c2.a(format);
        }
        Iterator<String> it3 = arrayList2.iterator();
        IOException e = null;
        while (it3.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it3.next()).buildUpon();
            for (bb bbVar : arrayList3) {
                buildUpon.appendQueryParameter(bbVar.a(), bbVar.b());
            }
            try {
                b bVar = this.f280a;
                return bVar == null ? bc.a(a, new URL(buildUpon.toString())) : bVar.a(buildUpon.toString());
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m41a("network exception: " + e.getMessage());
        throw e;
    }

    /* renamed from: a  reason: collision with other method in class */
    protected JSONObject m187a() {
        JSONObject jSONObject;
        synchronized (this.f282a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (cn cnVar : this.f282a.values()) {
                jSONArray.put(cnVar.m182a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (cm cmVar : b.values()) {
                jSONArray2.put(cmVar.m177a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m188a() {
        synchronized (this.f282a) {
            this.f282a.clear();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m189a(String str) {
        this.f284b = str;
    }

    public void a(String str, cm cmVar) {
        if (TextUtils.isEmpty(str) || cmVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + cmVar);
        } else if (this.f279a.a(str)) {
            synchronized (this.f282a) {
                m190a();
                if (this.f282a.containsKey(str)) {
                    this.f282a.get(str).a(cmVar);
                } else {
                    cn cnVar = new cn(str);
                    cnVar.a(cmVar);
                    this.f282a.put(str, cnVar);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    protected boolean m190a() {
        synchronized (this.f282a) {
            if (f277a) {
                return true;
            }
            f277a = true;
            this.f282a.clear();
            try {
                String d2 = d();
                if (!TextUtils.isEmpty(d2)) {
                    m192b(d2);
                    com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m41a("load bucket failure: " + th.getMessage());
            }
            return false;
        }
    }

    public cm b(String str) {
        return a(str, true);
    }

    protected String b() {
        String a2 = com.xiaomi.push.service.a.a(a).a();
        return (TextUtils.isEmpty(a2) || PushChannelRegion.China.name().equals(a2)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m191b() {
        ArrayList<String> arrayList;
        synchronized (this.f282a) {
            m190a();
            arrayList = new ArrayList<>(this.f282a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                cn cnVar = this.f282a.get(arrayList.get(size));
                if (!(cnVar == null || cnVar.a() == null)) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<cm> a2 = a(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (a2.get(i) != null) {
                a(arrayList.get(i), a2.get(i));
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m192b(String str) {
        synchronized (this.f282a) {
            this.f282a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") == 2) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    cn a2 = new cn().a(optJSONArray.getJSONObject(i));
                    this.f282a.put(a2.m180a(), a2);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    cm a3 = new cm("").a(optJSONArray2.getJSONObject(i2));
                    b.put(a3.f272b, a3);
                }
            } else {
                throw new JSONException("Bad version");
            }
        }
    }

    protected cm c(String str) {
        cn cnVar;
        cm a2;
        synchronized (this.f282a) {
            m190a();
            cnVar = this.f282a.get(str);
        }
        if (cnVar == null || (a2 = cnVar.a()) == null) {
            return null;
        }
        return a2;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f282a) {
            for (Map.Entry<String, cn> entry : this.f282a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m193c() {
        synchronized (this.f282a) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(a.openFileOutput(e(), 0)));
                String jSONObject = m187a().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m41a("persist bucket failure: " + e.getMessage());
            }
        }
    }

    protected cm d(String str) {
        if (System.currentTimeMillis() - this.f285c <= this.f278a * 60 * 1000) {
            return null;
        }
        this.f285c = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        cm cmVar = a(arrayList).get(0);
        if (cmVar != null) {
            this.f278a = 0;
            return cmVar;
        }
        long j = this.f278a;
        if (j >= 15) {
            return null;
        }
        this.f278a = j + 1;
        return null;
    }

    protected String d() {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            File file = new File(a.getFilesDir(), e());
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
                            y.a(bufferedReader);
                            return sb2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        com.xiaomi.channel.commonutils.logger.b.m41a("load host exception " + th.getMessage());
                        return null;
                    } finally {
                        y.a(bufferedReader);
                    }
                }
            } else {
                y.a((Closeable) null);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            com.xiaomi.channel.commonutils.logger.b.m41a("load host exception " + th.getMessage());
            return null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m194d() {
        synchronized (this.f282a) {
            for (cn cnVar : this.f282a.values()) {
                cnVar.a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    for (String str : this.f282a.keySet()) {
                        if (this.f282a.get(str).m181a().isEmpty()) {
                            this.f282a.remove(str);
                        }
                    }
                }
            }
        }
    }

    protected String e() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) a.getSystemService("activity")).getRunningAppProcesses();
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
}
