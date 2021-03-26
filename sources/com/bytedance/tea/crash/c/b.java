package com.bytedance.tea.crash.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.tea.crash.e.a;
import com.bytedance.tea.crash.g.c;
import com.bytedance.tea.crash.g.i;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.g.l;
import com.bytedance.tea.crash.h;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Header */
public final class b {
    private static final String[] a = {"version_code", "manifest_version_code", "aid", "update_version_code"};
    private Context b;
    private JSONObject c = new JSONObject();

    public b(Context context) {
        this.b = context;
    }

    public static b a(Context context) {
        b bVar = new b(context);
        JSONObject a2 = bVar.a();
        bVar.a(a2);
        bVar.c(a2);
        bVar.d(a2);
        bVar.e(a2);
        bVar.f(a2);
        bVar.g(a2);
        bVar.b(a2);
        return bVar;
    }

    private void a(JSONObject jSONObject) {
        int i;
        try {
            PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0);
            if (packageInfo.applicationInfo != null && (i = packageInfo.applicationInfo.labelRes) > 0) {
                jSONObject.put("display_name", this.b.getString(i));
            }
            jSONObject.put("sdk_version", 22130);
            jSONObject.put("sdk_version_name", "2.2.1-alpha.30");
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", c());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("cpu_abi", b());
        } catch (Exception unused) {
        }
    }

    private String b() {
        try {
            StringBuilder sb = new StringBuilder();
            if (Build.VERSION.SDK_INT < 21 || Build.SUPPORTED_ABIS.length <= 0) {
                sb = new StringBuilder(Build.CPU_ABI);
            } else {
                for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                    sb.append(Build.SUPPORTED_ABIS[i]);
                    if (i != Build.SUPPORTED_ABIS.length - 1) {
                        sb.append(", ");
                    }
                }
            }
            if (TextUtils.isEmpty(sb.toString())) {
                return "unknown";
            }
            return sb.toString();
        } catch (Exception e) {
            j.b(e);
            return "unknown";
        }
    }

    private void b(JSONObject jSONObject) {
        Map<String, Object> b2;
        a a2 = h.a();
        if (a2 != null && jSONObject != null && (b2 = a2.b()) != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (String str : b2.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        Object obj = b2.get(str);
                        if (obj != null) {
                            jSONObject2.put(str, obj);
                        }
                    }
                }
                jSONObject.put("custom", jSONObject2);
            } catch (Exception e) {
                j.b(e);
            }
        }
    }

    private String c() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        return str + ".0";
    }

    private void c(JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            String str = i != 120 ? i != 240 ? i != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    private void d(JSONObject jSONObject) {
        try {
            String language = this.b.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put("region", country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        } catch (Exception unused) {
        }
    }

    private void e(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            if (c.c()) {
                sb.append("MIUI-");
            } else if (c.d()) {
                sb.append("FLYME-");
            } else {
                String a2 = c.a();
                if (c.a(a2)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(a2)) {
                    sb.append(a2);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put("rom", sb.toString());
            }
            jSONObject.put("rom_version", l.a());
        } catch (Throwable unused) {
        }
    }

    private void f(JSONObject jSONObject) {
        try {
            jSONObject.put("access", i.a(this.b));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void g(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.b.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    jSONObject.put("mcc_mnc", networkOperator);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject a(Map<String, Object> map) {
        if (map == null) {
            try {
                return this.c;
            } catch (Throwable unused) {
            }
        } else {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!this.c.has(entry.getKey())) {
                    this.c.put(entry.getKey(), entry.getValue());
                }
            }
            String[] strArr = a;
            for (String str : strArr) {
                if (map.containsKey(str)) {
                    try {
                        this.c.put(str, Integer.parseInt((String) map.get(str)));
                    } catch (Exception unused2) {
                        this.c.put(str, map.get(str));
                    }
                }
            }
            if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
                this.c.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
            }
            if (map.containsKey("iid")) {
                this.c.put("udid", map.get("iid"));
                this.c.remove("iid");
            }
            return this.c;
        }
    }

    public JSONObject a(String str) {
        try {
            this.c.put("device_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.c;
    }

    public JSONObject b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.c.put("user_id", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.c;
    }

    public JSONObject a() {
        return this.c;
    }
}
