package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.a.f;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.h.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AhUtils */
public class b {
    private static final String a = "b";
    private static c b;
    private static final HashMap<String, g.a> c = new HashMap<>();
    private static a d;

    /* renamed from: com.ss.android.socialbase.appdownloader.b$b  reason: collision with other inner class name */
    /* compiled from: AhUtils */
    interface AbstractC0099b {
        boolean a(Context context);
    }

    /* compiled from: AhUtils */
    public interface c {
        void a(DownloadInfo downloadInfo, a aVar);
    }

    protected static boolean a(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray e2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).e("ah_plans");
        if (e2 == null) {
            return false;
        }
        int length = e2.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = e2.optJSONObject(i);
            if (optJSONObject != null && d(optJSONObject) && a(optJSONObject) && b(optJSONObject) && a(context, downloadInfo, intent, optJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0110  */
    private static boolean a(Context context, DownloadInfo downloadInfo, Intent intent, JSONObject jSONObject, boolean z) {
        char c2;
        a aVar;
        boolean a2;
        boolean z2 = false;
        if (!(jSONObject == null || downloadInfo == null)) {
            a aVar2 = new a();
            String optString = jSONObject.optString("type");
            if (!TextUtils.isEmpty(optString)) {
                com.ss.android.socialbase.downloader.g.a a3 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo);
                aVar2.a = optString;
                optString.hashCode();
                boolean z3 = true;
                switch (optString.hashCode()) {
                    case -985763637:
                        if (optString.equals("plan_a")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -985763636:
                        if (optString.equals("plan_b")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -985763635:
                        if (optString.equals("plan_c")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -985763634:
                        if (optString.equals("plan_d")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -985763633:
                        if (optString.equals("plan_e")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -985763632:
                        if (optString.equals("plan_f")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -985763631:
                        if (optString.equals("plan_g")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                    case 4:
                        if (!downloadInfo.isSavePathRedirected()) {
                            aVar2.b = downloadInfo.getAntiHijackErrorCode(-1);
                            break;
                        }
                        aVar = a(jSONObject, a3);
                        if (aVar.b == 0) {
                            if (optString.equals("plan_f") && TextUtils.isEmpty(downloadInfo.getDBJsonString("file_content_uri"))) {
                                aVar2.b = downloadInfo.getAntiHijackErrorCode(10);
                                break;
                            } else {
                                a2 = a(context, downloadInfo, jSONObject, aVar2);
                                z2 = a2;
                                break;
                            }
                        }
                        aVar2 = aVar;
                        break;
                    case 1:
                        aVar = a(jSONObject, a3);
                        if (aVar.b == 0) {
                            if (downloadInfo.isSavePathRedirected()) {
                                a2 = b(context, downloadInfo, jSONObject, aVar2);
                                z2 = a2;
                                break;
                            } else {
                                aVar2.b = downloadInfo.getAntiHijackErrorCode(-1);
                                break;
                            }
                        }
                        aVar2 = aVar;
                        break;
                    case 2:
                        if (Build.VERSION.SDK_INT >= 26 || com.ss.android.socialbase.appdownloader.f.c.b()) {
                            if ((jSONObject.optInt("enable_for_all", 0) == 1) || z) {
                                if (jSONObject.optInt("show_unknown_source_on_startup") != 1) {
                                    z3 = false;
                                }
                                if (!z3) {
                                    a2 = a(context, intent, jSONObject, downloadInfo.getId(), aVar2);
                                    z2 = a2;
                                    break;
                                }
                            }
                        }
                        break;
                    case 3:
                        a c3 = c(jSONObject);
                        if (c3.b == 0) {
                            try {
                                c.a(context, intent);
                                aVar2.b = 0;
                                z2 = true;
                                break;
                            } catch (Throwable th) {
                                aVar2.b = 4;
                                aVar2.c = th.toString();
                                break;
                            }
                        } else {
                            aVar2 = c3;
                            break;
                        }
                    case 5:
                        aVar = a(jSONObject, a3);
                        if (aVar.b == 0) {
                        }
                        aVar2 = aVar;
                        break;
                    case 6:
                        aVar = b(jSONObject, a3);
                        if (aVar.b == 0) {
                            a2 = a(context, downloadInfo, jSONObject, aVar2, a3);
                            z2 = a2;
                            break;
                        }
                        aVar2 = aVar;
                        break;
                }
                if (z2) {
                    downloadInfo.getTempCacheData().put("ah_attempt", aVar2.a());
                }
                c cVar = b;
                if (cVar != null) {
                    cVar.a(downloadInfo, aVar2);
                }
            }
        }
        return z2;
    }

    private static boolean a(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, a aVar, com.ss.android.socialbase.downloader.g.a aVar2) {
        boolean z;
        String optString = jSONObject.optString("type");
        aVar.a = optString;
        Intent b2 = com.ss.android.socialbase.appdownloader.a.d.a(context, "vbi", jSONObject, downloadInfo).b();
        StringBuilder sb = new StringBuilder();
        try {
            z = b(context, b2);
        } catch (Throwable th) {
            sb.append(optString);
            sb.append(" startActivity failed : ");
            sb.append(a(th));
            a(aVar, 1);
            z = false;
        }
        if (!z) {
            aVar.c = sb.toString();
        } else {
            aVar.b = 0;
        }
        return true;
    }

    private static boolean d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        String optString = jSONObject.optString("device_rom");
        if (TextUtils.isEmpty(optString)) {
            return true;
        }
        String g = com.ss.android.socialbase.appdownloader.f.c.g();
        if (!TextUtils.isEmpty(g) && optString.toLowerCase().contains(g.toLowerCase())) {
            return true;
        }
        return false;
    }

    public static boolean a(JSONObject jSONObject) {
        int optInt;
        if (jSONObject != null && (optInt = jSONObject.optInt("min_os_api", -1)) >= 0 && Build.VERSION.SDK_INT < optInt) {
            return false;
        }
        return true;
    }

    public static boolean b(JSONObject jSONObject) {
        if (jSONObject != null && !com.ss.android.socialbase.appdownloader.f.d.a() && jSONObject.optInt("scy_mode") == 1) {
            return false;
        }
        return true;
    }

    private static boolean a(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, a aVar) {
        boolean z;
        if (!(context == null || jSONObject == null)) {
            String optString = jSONObject.optString("device_plans");
            aVar.e = optString;
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb = new StringBuilder();
                String str = null;
                int length = split.length;
                int i = 0;
                while (true) {
                    z = true;
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    String str2 = split[i];
                    com.ss.android.socialbase.appdownloader.a.a a2 = com.ss.android.socialbase.appdownloader.a.d.a(context, str2, jSONObject, downloadInfo);
                    if (a2 != null) {
                        Intent b2 = a2.b();
                        if (b2 == null) {
                            a(aVar, 3);
                            sb.append(str2);
                            sb.append(" resolveActivity failed! ");
                        } else if (a(file, downloadInfo, jSONObject)) {
                            try {
                                a(context, b2, false);
                                str = str2;
                                break;
                            } catch (Throwable th) {
                                sb.append(str2);
                                sb.append(" startActivity failed : ");
                                sb.append(a(th));
                                a(aVar, 1);
                            }
                        } else {
                            a(aVar, 6);
                            sb.append(str2);
                            sb.append(" createDescFile failed! ");
                        }
                    }
                    sb.append("  ");
                    i++;
                }
                if (!z) {
                    aVar.c = sb.toString();
                } else {
                    aVar.d = str;
                    aVar.b = 0;
                }
                return z;
            }
        }
        return false;
    }

    private static boolean b(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, a aVar) {
        if (!(context == null || jSONObject == null)) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            aVar.d = "custom";
            com.ss.android.socialbase.appdownloader.a.a a2 = com.ss.android.socialbase.appdownloader.a.d.a(context, "custom", jSONObject, downloadInfo);
            if (a2 == null || !a2.a()) {
                aVar.b = 3;
            } else {
                Intent b2 = a2.b();
                if (b2 == null) {
                    return false;
                }
                if (!a(new File(savePath), downloadInfo, jSONObject)) {
                    aVar.b = 6;
                } else if (b(context, b2)) {
                    aVar.b = 0;
                    return true;
                } else {
                    aVar.b = 1;
                }
                return false;
            }
        }
        return false;
    }

    public static int a(com.ss.android.socialbase.downloader.g.a aVar) {
        int i;
        JSONObject d2 = aVar.d("download_dir");
        if (!(d2 != null ? !TextUtils.isEmpty(d2.optString("dir_name")) : false)) {
            return 5;
        }
        if (!com.ss.android.socialbase.downloader.g.a.c().a("get_download_info_by_list")) {
            return 4;
        }
        JSONArray e2 = aVar.e("ah_plans");
        int i2 = -1;
        if (e2 != null) {
            int length = e2.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = e2.optJSONObject(i3);
                if (optJSONObject != null && d(optJSONObject) && a(optJSONObject) && b(optJSONObject)) {
                    String optString = optJSONObject.optString("type");
                    if ("plan_a".equals(optString) || "plan_b".equals(optString) || "plan_e".equals(optString) || "plan_f".equals(optString)) {
                        a a2 = a(optJSONObject, aVar);
                        i = a2.b;
                        if (a2.b == 0) {
                            return 0;
                        }
                    } else if ("plan_d".equalsIgnoreCase(optString)) {
                        a c2 = c(optJSONObject);
                        i = c2.b;
                        if (c2.b == 0) {
                            return 0;
                        }
                    } else {
                        continue;
                    }
                    i2 = i;
                }
            }
        }
        return i2;
    }

    public static a a(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        a aVar2 = new a();
        if (jSONObject == null) {
            return aVar2;
        }
        String optString = jSONObject.optString("type");
        aVar2.a = optString;
        try {
            boolean a2 = a(jSONObject.optJSONArray("device_requirements"));
            com.ss.android.socialbase.downloader.c.a.b(a, "requirements fit ? " + a2);
            if (!a2) {
                a(aVar2, 2);
                return aVar2;
            }
            if ("plan_b".equals(optString)) {
                aVar2.e = "custom";
                if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.b.L(), "custom", jSONObject, aVar)) {
                    aVar2.b = 0;
                    return aVar2;
                }
                a(aVar2, 3);
            } else {
                String optString2 = jSONObject.optString("device_plans");
                aVar2.e = optString2;
                if (!TextUtils.isEmpty(optString2)) {
                    for (String str : optString2.split(",")) {
                        if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.b.L(), str, jSONObject, aVar)) {
                            aVar2.b = 0;
                            return aVar2;
                        }
                        a(aVar2, 3);
                    }
                }
            }
            return aVar2;
        } catch (Throwable th) {
            aVar2.c = "check plan_a Config" + a(th);
            a(aVar2, 4);
            return aVar2;
        }
    }

    public static a b(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        a aVar2 = new a();
        if (jSONObject == null) {
            return aVar2;
        }
        aVar2.a = jSONObject.optString("type");
        try {
            if (!a(jSONObject.optJSONArray("device_requirements"))) {
                a(aVar2, 2);
                return aVar2;
            }
            aVar2.e = "vbi";
            if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.b.L(), "vbi", jSONObject, aVar)) {
                aVar2.b = 0;
            } else {
                a(aVar2, 3);
            }
            return aVar2;
        } catch (Throwable th) {
            aVar2.c = "check plan_g Config" + a(th);
            a(aVar2, 4);
            return aVar2;
        }
    }

    public static a c(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject == null) {
            return aVar;
        }
        aVar.a = jSONObject.optString("type");
        try {
            if (!a(jSONObject.optJSONArray("device_requirements"))) {
                a(aVar, 2);
                return aVar;
            }
            aVar.b = 0;
            return aVar;
        } catch (Throwable th) {
            aVar.c = "check plan_d Config" + a(th);
            a(aVar, 4);
            return aVar;
        }
    }

    private static void a(a aVar, int i) {
        if (aVar.b != -1) {
            aVar.b = (aVar.b * 10) + i;
        } else {
            aVar.b = i;
        }
    }

    public static boolean a(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z = false;
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("package_names");
                JSONArray optJSONArray = optJSONObject.optJSONArray("version_allow");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("version_block");
                String optString2 = optJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                String[] split = optString.split(",");
                for (String str : split) {
                    if ("market".equals(str)) {
                        str = com.ss.android.socialbase.appdownloader.f.c.i();
                    }
                    g.a b2 = b(str);
                    if (!(b2 == null || (z = a(optJSONArray, optJSONArray2, optString2, b2)))) {
                        return false;
                    }
                }
                continue;
            }
        }
        return z;
    }

    private static g.a b(String str) {
        HashMap<String, g.a> hashMap = c;
        if (hashMap.containsKey(str)) {
            g.a aVar = hashMap.get(str);
            if (aVar != null) {
                return aVar;
            }
            return null;
        }
        g.a b2 = g.b(str);
        hashMap.put(str, b2);
        if (b2 != null) {
            return b2;
        }
        return null;
    }

    public static g.a a(String str) {
        g.a b2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split != null) {
                for (String str2 : split) {
                    if (!(TextUtils.isEmpty(str2) || (b2 = b(str2)) == null)) {
                        return b2;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2, String str, g.a aVar) {
        String g = aVar.g();
        int f = aVar.f();
        String str2 = f + "_" + g;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("[-,]");
                for (int i = 0; i < split.length; i += 2) {
                    int parseInt = Integer.parseInt(split[i]);
                    int parseInt2 = Integer.parseInt(split[i + 1]);
                    if (f >= parseInt && f <= parseInt2) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (jSONArray == null || jSONArray.length() <= 0) {
            if (!(jSONArray2 == null || jSONArray2.length() <= 0 || a(jSONArray2, str2))) {
                return true;
            }
        } else if (a(jSONArray, str2)) {
            return true;
        }
        return false;
    }

    private static boolean a(JSONArray jSONArray, String str) {
        if (!(jSONArray == null || str == null)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(File file, DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject d2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).d("download_dir");
        File file2 = null;
        String optString = d2 != null ? d2.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
            file2 = new File(path + File.separator + optString);
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean a(Context context, Intent intent, JSONObject jSONObject, int i, a aVar) {
        if (!(context == null || jSONObject == null)) {
            long optLong = jSONObject.optLong("jump_interval", 0);
            if (optLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong("last_jump_unknown_source_time", 0)) / 60000 >= optLong && !a(context)) {
                sharedPreferences.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i);
                    try {
                        if (a(context, intent2, false)) {
                            d(i, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (aVar != null) {
                            aVar.b = 1;
                            aVar.c = "tryShowUnknownSourceDialog" + a(th);
                        }
                        return false;
                    }
                } else {
                    if (a(context, intent, i, jSONObject)) {
                        c(i, jSONObject);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(Context context, Intent intent, int i, JSONObject jSONObject) {
        try {
            if (!com.ss.android.socialbase.appdownloader.f.c.b() || Build.VERSION.SDK_INT >= 26 || d(context)) {
                if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !e(context)) {
                    com.ss.android.socialbase.appdownloader.a.b bVar = new com.ss.android.socialbase.appdownloader.a.b(context);
                    if (bVar.a()) {
                        a(context, intent, i, jSONObject, new AbstractC0099b() {
                            /* class com.ss.android.socialbase.appdownloader.b.AnonymousClass2 */

                            @Override // com.ss.android.socialbase.appdownloader.b.AbstractC0099b
                            public boolean a(Context context) {
                                return b.e(context);
                            }
                        });
                        return b(context, bVar.b());
                    }
                }
                return false;
            }
            f fVar = new f(context);
            if (fVar.a()) {
                a(context, intent, i, jSONObject, new AbstractC0099b() {
                    /* class com.ss.android.socialbase.appdownloader.b.AnonymousClass1 */

                    @Override // com.ss.android.socialbase.appdownloader.b.AbstractC0099b
                    public boolean a(Context context) {
                        return b.d(context);
                    }
                });
                return b(context, fVar.b());
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return true;
        }
        try {
            if (com.ss.android.socialbase.appdownloader.f.c.b() && Build.VERSION.SDK_INT < 26) {
                return d(context);
            }
            if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
                return e(context);
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static boolean e(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean a() {
        return e.a == 1;
    }

    private static void d(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.b.N().b(i, "guide_auth_dialog_show", jSONObject2);
    }

    public static void a(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.b.N().b(i, "guide_auth_dialog_confirm", jSONObject2);
    }

    public static void b(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.b.N().b(i, "guide_auth_dialog_cancel", jSONObject2);
    }

    public static void c(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.b.N().b(i, "guide_auth_open_setting", jSONObject2);
    }

    /* access modifiers changed from: private */
    public static void b(int i, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        try {
            jSONObject.put("scene", z ? 1 : 2);
            if (!z2) {
                i2 = 2;
            }
            jSONObject.put("result_code", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.b.N().b(i, "guide_auth_result", jSONObject);
    }

    private static void a(Context context, Intent intent, int i, JSONObject jSONObject, AbstractC0099b bVar) {
        if (d != null) {
            com.ss.android.socialbase.downloader.a.a.a().b(d);
            d = null;
        }
        d = new a(context, intent, i, jSONObject, bVar);
        com.ss.android.socialbase.downloader.a.a.a().a(d);
    }

    /* access modifiers changed from: private */
    public static boolean b(Context context, Intent intent) {
        return a(context, intent, true);
    }

    public static boolean a(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        } else {
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        }
    }

    public static String a(Throwable th) {
        String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, 500) : th2;
    }

    /* compiled from: AhUtils */
    private static class d implements Callable<Boolean> {
        private final Context a;
        private final AbstractC0099b b;
        private final Handler c;
        private final long d;

        public d(Handler handler, Context context, AbstractC0099b bVar, long j) {
            this.a = context;
            this.b = bVar;
            this.c = handler;
            this.d = j;
        }

        /* renamed from: a */
        public Boolean call() throws Exception {
            try {
                AbstractC0099b bVar = this.b;
                if (bVar != null) {
                    long j = this.d;
                    if (j > 0) {
                        if (j <= 10000) {
                            Context context = this.a;
                            boolean a2 = context != null ? bVar.a(context) : false;
                            Message obtain = Message.obtain();
                            if (a2) {
                                obtain.what = 2;
                                this.c.sendMessage(obtain);
                            } else {
                                obtain.what = 1;
                                this.c.sendMessageDelayed(obtain, this.d);
                            }
                            return false;
                        }
                    }
                }
                return false;
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(c cVar) {
        b = cVar;
    }

    /* compiled from: AhUtils */
    private static class a implements a.AbstractC0102a {
        private final e a;
        private final int b;
        private JSONObject c;

        public a(Context context, Intent intent, int i, JSONObject jSONObject, AbstractC0099b bVar) {
            this.c = jSONObject;
            int optInt = jSONObject.optInt("query_interval", 1000);
            this.b = optInt;
            this.a = new e(context, intent, i, bVar, (long) optInt);
        }

        @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0102a
        public void b() {
            if (!this.a.i) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.a.f.sendMessage(obtain);
            }
            com.ss.android.socialbase.downloader.a.a.a().b(this);
            a unused = b.d = null;
        }

        @Override // com.ss.android.socialbase.downloader.a.a.AbstractC0102a
        public void c() {
            int optInt = this.c.optInt("time_out_second", 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.a.f.sendMessage(obtain);
            if (optInt > 0 && optInt < 60) {
                Message obtain2 = Message.obtain();
                obtain2.what = 2;
                this.a.f.sendMessageDelayed(obtain2, (long) (optInt * 1000));
            }
        }
    }

    /* compiled from: AhUtils */
    private static class e implements g.a {
        public static int a;
        private static int b;
        private final Context c;
        private final Intent d;
        private final AbstractC0099b e;
        private final Handler f;
        private final long g;
        private Future<Boolean> h;
        private boolean i = false;

        public e(Context context, Intent intent, int i2, AbstractC0099b bVar, long j) {
            this.c = context;
            this.d = intent;
            b = i2;
            this.e = bVar;
            this.f = new com.ss.android.socialbase.downloader.h.g(Looper.getMainLooper(), this);
            this.g = j;
        }

        @Override // com.ss.android.socialbase.downloader.h.g.a
        public void a(Message message) {
            if (message != null) {
                boolean z = true;
                if (message.what == 1) {
                    long j = this.g;
                    if (j > 0 && j <= 10000) {
                        a = 1;
                        this.h = com.ss.android.socialbase.downloader.downloader.b.l().submit(new d(this.f, this.c, this.e, this.g));
                    }
                } else if (message.what == 2) {
                    a = 2;
                    this.f.removeMessages(2);
                    this.f.removeMessages(1);
                    Future<Boolean> future = this.h;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.i && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.a.a.a().b())) {
                        Intent intent = this.d;
                        if (intent != null) {
                            b.b(this.c, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.c).getDownloadInfo(b);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                c.b(this.c, b, false);
                            }
                        }
                        this.i = true;
                    }
                    if (this.d != null) {
                        z = false;
                    }
                    b.b(b, z, b.a(this.c));
                }
            }
        }
    }
}
