package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ab;
import com.xiaomi.push.ax;
import com.xiaomi.push.ba;
import com.xiaomi.push.bc;
import com.xiaomi.push.bi;
import com.xiaomi.push.fj;
import com.xiaomi.push.i;
import com.xiaomi.push.o;
import java.util.TreeMap;
import org.json.JSONObject;

public class l {
    private static k a;

    /* renamed from: a  reason: collision with other field name */
    private static a f1025a;

    public interface a {
        void a();
    }

    public static synchronized k a(Context context) {
        synchronized (l.class) {
            k kVar = a;
            if (kVar != null) {
                return kVar;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            String string = sharedPreferences.getString("uuid", null);
            String string2 = sharedPreferences.getString("token", null);
            String string3 = sharedPreferences.getString("security", null);
            String string4 = sharedPreferences.getString("app_id", null);
            String string5 = sharedPreferences.getString("app_token", null);
            String string6 = sharedPreferences.getString("package_name", null);
            String string7 = sharedPreferences.getString("device_id", null);
            int i = sharedPreferences.getInt("env_type", 1);
            if (!TextUtils.isEmpty(string7) && i.m471a(string7)) {
                string7 = i.k(context);
                sharedPreferences.edit().putString("device_id", string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String k = i.k(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(k) && !TextUtils.isEmpty(string7) && !string7.equals(k)) {
                b.m41a("read_phone_state permission changes.");
            }
            k kVar2 = new k(string, string2, string3, string4, string5, string6, i);
            a = kVar2;
            return kVar2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ad  */
    public static synchronized k a(Context context, String str, String str2, String str3) {
        String str4;
        String b;
        String a2;
        PackageInfo packageInfo;
        int a3;
        ba a4;
        String str5;
        synchronized (l.class) {
            TreeMap treeMap = new TreeMap();
            String a5 = i.a(context, false);
            b.m41a("account register:" + a5 + " mim:" + ax.a(context).e());
            treeMap.put("devid", a5);
            k kVar = a;
            if (kVar != null && !TextUtils.isEmpty(kVar.f1024a)) {
                treeMap.put("uuid", a.f1024a);
                int lastIndexOf = a.f1024a.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str4 = a.f1024a.substring(lastIndexOf + 1);
                    ax.a(context).a(treeMap);
                    b = i.b(context);
                    if (!TextUtils.isEmpty(b)) {
                        treeMap.put("vdevid", b);
                    }
                    a2 = i.a(context);
                    if (!TextUtils.isEmpty(a2)) {
                        treeMap.put("gaid", a2);
                    }
                    if (m662a(context)) {
                        str2 = "1000271";
                    }
                    if (m662a(context)) {
                        str3 = "420100086271";
                    }
                    if (m662a(context)) {
                        str = "com.xiaomi.xmsf";
                    }
                    treeMap.put("appid", str2);
                    treeMap.put("apptoken", str3);
                    packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
                    treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
                    treeMap.put("sdkversion", Integer.toString(30709));
                    treeMap.put("packagename", str);
                    treeMap.put("model", Build.MODEL);
                    treeMap.put("board", Build.BOARD);
                    if (!com.xiaomi.push.l.d()) {
                        String str6 = "";
                        String f = i.f(context);
                        if (!TextUtils.isEmpty(f)) {
                            str6 = str6 + bi.a(f);
                        }
                        String h = i.h(context);
                        if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(h)) {
                            str6 = str6 + "," + h;
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            treeMap.put("imei_md5", str6);
                        }
                    }
                    treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
                    a3 = i.a();
                    if (a3 >= 0) {
                        treeMap.put("space_id", Integer.toString(a3));
                    }
                    treeMap.put("brand", Build.BRAND + "");
                    treeMap.put("ram", i.m468a());
                    treeMap.put("rom", i.m472b());
                    a4 = bc.a(context, m660a(context), treeMap);
                    str5 = "";
                    if (a4 != null) {
                        str5 = a4.a();
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        JSONObject jSONObject = new JSONObject(str5);
                        if (jSONObject.getInt("code") == 0) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            String string = jSONObject2.getString("ssecurity");
                            String string2 = jSONObject2.getString("token");
                            String string3 = jSONObject2.getString("userId");
                            if (TextUtils.isEmpty(str4)) {
                                str4 = "an" + bi.a(6);
                            }
                            k kVar2 = new k(string3 + "@xiaomi.com/" + str4, string2, string, str2, str3, str, ab.a());
                            a(context, kVar2);
                            i.a(context, jSONObject2.optString("vdevid"));
                            a = kVar2;
                            return kVar2;
                        }
                        o.a(context, jSONObject.getInt("code"), jSONObject.optString("description"));
                        b.m41a(str5);
                    }
                    return null;
                }
            }
            str4 = null;
            ax.a(context).a(treeMap);
            b = i.b(context);
            if (!TextUtils.isEmpty(b)) {
            }
            a2 = i.a(context);
            if (!TextUtils.isEmpty(a2)) {
            }
            if (m662a(context)) {
            }
            if (m662a(context)) {
            }
            if (m662a(context)) {
            }
            treeMap.put("appid", str2);
            treeMap.put("apptoken", str3);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            } catch (Exception e) {
                b.a(e);
                packageInfo = null;
            }
            treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(30709));
            treeMap.put("packagename", str);
            treeMap.put("model", Build.MODEL);
            treeMap.put("board", Build.BOARD);
            if (!com.xiaomi.push.l.d()) {
            }
            treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            a3 = i.a();
            if (a3 >= 0) {
            }
            treeMap.put("brand", Build.BRAND + "");
            treeMap.put("ram", i.m468a());
            treeMap.put("rom", i.m472b());
            a4 = bc.a(context, m660a(context), treeMap);
            str5 = "";
            if (a4 != null) {
            }
            if (!TextUtils.isEmpty(str5)) {
            }
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m660a(Context context) {
        StringBuilder sb;
        String str;
        String a2 = a.a(context).a();
        if (ab.b()) {
            sb = new StringBuilder();
            sb.append("http://");
            sb.append(fj.b);
            str = ":9085";
        } else if (o.China.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://cn.register.xmpush.xiaomi.com";
        } else if (o.Global.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://register.xmpush.global.xiaomi.com";
        } else if (o.Europe.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://fr.register.xmpush.global.xiaomi.com";
        } else if (o.Russia.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://ru.register.xmpush.global.xiaomi.com";
        } else if (o.India.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://idmb.register.xmpush.global.xiaomi.com";
        } else {
            sb = new StringBuilder();
            sb.append("https://");
            str = ab.m101a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com";
        }
        sb.append(str);
        sb.append("/pass/v2/register");
        return sb.toString();
    }

    public static void a() {
        a aVar = f1025a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m661a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        a();
    }

    public static void a(Context context, k kVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", kVar.f1024a);
        edit.putString("security", kVar.c);
        edit.putString("token", kVar.b);
        edit.putString("app_id", kVar.d);
        edit.putString("package_name", kVar.f);
        edit.putString("app_token", kVar.e);
        edit.putString("device_id", i.k(context));
        edit.putInt("env_type", kVar.a);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        f1025a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m662a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
