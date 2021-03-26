package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.aa;
import com.xiaomi.push.ah;
import com.xiaomi.push.en;
import com.xiaomi.push.gw;
import com.xiaomi.push.it;
import com.xiaomi.push.iw;
import com.xiaomi.push.v;
import com.xiaomi.push.y;
import java.util.TreeMap;
import org.json.JSONObject;

public class bj {
    private static bi a;
    private static a b;

    public interface a {
        void a();
    }

    public static synchronized bi a(Context context) {
        synchronized (bj.class) {
            bi biVar = a;
            if (biVar != null) {
                return biVar;
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
            if (!TextUtils.isEmpty(string7) && gw.a(string7)) {
                string7 = gw.k(context);
                sharedPreferences.edit().putString("device_id", string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String k = gw.k(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(k) && !TextUtils.isEmpty(string7) && !string7.equals(k)) {
                c.a("read_phone_state permission changes.");
            }
            bi biVar2 = new bi(string, string2, string3, string4, string5, string6, i);
            a = biVar2;
            return biVar2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01c0  */
    public static synchronized bi a(Context context, String str, String str2, String str3) {
        String str4;
        String c;
        String b2;
        PackageInfo packageInfo;
        int b3;
        String n;
        y a2;
        String str5;
        synchronized (bj.class) {
            TreeMap treeMap = new TreeMap();
            String a3 = gw.a(context, false);
            c.a("account register:" + a3);
            treeMap.put("devid", a3);
            treeMap.put("devid1", gw.a(context));
            bi biVar = a;
            if (biVar != null && !TextUtils.isEmpty(biVar.a)) {
                treeMap.put("uuid", a.a);
                int lastIndexOf = a.a.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str4 = a.a.substring(lastIndexOf + 1);
                    v.a(context).a(treeMap);
                    c = gw.c(context);
                    if (c != null) {
                        treeMap.put("vdevid", c);
                    }
                    b2 = gw.b(context);
                    if (!TextUtils.isEmpty(b2)) {
                        treeMap.put("gaid", b2);
                    }
                    if (d(context)) {
                        str2 = "1000271";
                    }
                    if (d(context)) {
                        str3 = "420100086271";
                    }
                    if (d(context)) {
                        str = "com.xiaomi.xmsf";
                    }
                    treeMap.put("appid", str2);
                    treeMap.put("apptoken", str3);
                    packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
                    treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
                    treeMap.put("sdkversion", Integer.toString(30705));
                    treeMap.put("packagename", str);
                    treeMap.put("model", Build.MODEL);
                    treeMap.put("board", Build.BOARD);
                    if (!it.g()) {
                        String str6 = "";
                        String f = gw.f(context);
                        if (!TextUtils.isEmpty(f)) {
                            str6 = str6 + ah.a(f);
                        }
                        String h = gw.h(context);
                        if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(h)) {
                            str6 = str6 + "," + h;
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            treeMap.put("imei_md5", str6);
                        }
                    }
                    treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
                    b3 = gw.b();
                    if (b3 >= 0) {
                        treeMap.put("space_id", Integer.toString(b3));
                    }
                    n = gw.n(context);
                    if (!TextUtils.isEmpty(n)) {
                        treeMap.put("mac_address", ah.a(n));
                    }
                    treeMap.put("android_id", gw.e(context));
                    treeMap.put("brand", Build.BRAND + "");
                    treeMap.put("ram", gw.c());
                    treeMap.put("rom", gw.e());
                    a2 = aa.a(context, b(context), treeMap);
                    str5 = "";
                    if (a2 != null) {
                        str5 = a2.a();
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        JSONObject jSONObject = new JSONObject(str5);
                        if (jSONObject.getInt("code") == 0) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            String string = jSONObject2.getString("ssecurity");
                            String string2 = jSONObject2.getString("token");
                            String string3 = jSONObject2.getString("userId");
                            if (TextUtils.isEmpty(str4)) {
                                str4 = "an" + ah.a(6);
                            }
                            bi biVar2 = new bi(string3 + "@xiaomi.com/" + str4, string2, string, str2, str3, str, com.xiaomi.push.c.c());
                            a(context, biVar2);
                            gw.a(context, jSONObject2.optString("vdevid"));
                            a = biVar2;
                            return biVar2;
                        }
                        bm.a(context, jSONObject.getInt("code"), jSONObject.optString("description"));
                        c.a(str5);
                    }
                    return null;
                }
            }
            str4 = null;
            v.a(context).a(treeMap);
            c = gw.c(context);
            if (c != null) {
            }
            b2 = gw.b(context);
            if (!TextUtils.isEmpty(b2)) {
            }
            if (d(context)) {
            }
            if (d(context)) {
            }
            if (d(context)) {
            }
            treeMap.put("appid", str2);
            treeMap.put("apptoken", str3);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            } catch (Exception e) {
                c.a(e);
                packageInfo = null;
            }
            treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(30705));
            treeMap.put("packagename", str);
            treeMap.put("model", Build.MODEL);
            treeMap.put("board", Build.BOARD);
            if (!it.g()) {
            }
            treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            b3 = gw.b();
            if (b3 >= 0) {
            }
            n = gw.n(context);
            if (!TextUtils.isEmpty(n)) {
            }
            treeMap.put("android_id", gw.e(context));
            treeMap.put("brand", Build.BRAND + "");
            treeMap.put("ram", gw.c());
            treeMap.put("rom", gw.e());
            a2 = aa.a(context, b(context), treeMap);
            str5 = "";
            if (a2 != null) {
            }
            if (!TextUtils.isEmpty(str5)) {
            }
            return null;
        }
    }

    public static void a() {
        a aVar = b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static void a(Context context, bi biVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", biVar.a);
        edit.putString("security", biVar.c);
        edit.putString("token", biVar.b);
        edit.putString("app_id", biVar.d);
        edit.putString("package_name", biVar.f);
        edit.putString("app_token", biVar.e);
        edit.putString("device_id", gw.k(context));
        edit.putInt("env_type", biVar.g);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        b = aVar;
    }

    public static String b(Context context) {
        StringBuilder sb;
        String str;
        String a2 = a.a(context).a();
        if (com.xiaomi.push.c.b()) {
            sb = new StringBuilder();
            sb.append("http://");
            sb.append(en.b);
            str = ":9085";
        } else if (iw.China.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://cn.register.xmpush.xiaomi.com";
        } else if (iw.Global.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://register.xmpush.global.xiaomi.com";
        } else if (iw.Europe.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://fr.register.xmpush.global.xiaomi.com";
        } else if (iw.Russia.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://ru.register.xmpush.global.xiaomi.com";
        } else if (iw.India.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://idmb.register.xmpush.global.xiaomi.com";
        } else {
            sb = new StringBuilder();
            sb.append("https://");
            str = com.xiaomi.push.c.a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com";
        }
        sb.append(str);
        sb.append("/pass/v2/register");
        return sb.toString();
    }

    public static void c(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        a();
    }

    private static boolean d(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
