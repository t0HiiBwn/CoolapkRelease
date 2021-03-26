package com.huawei.hms.aaid.task;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.n;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.opendevice.r;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportAaidToken {
    private ReportAaidToken() {
    }

    public static void report(final Context context, final String str) {
        new Thread() {
            /* class com.huawei.hms.aaid.task.ReportAaidToken.AnonymousClass1 */

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if (!o.a()) {
                    HMSLog.d("ReportAaidToken", "Not HW Phone.");
                } else if (!ReportAaidToken.b(context)) {
                    String c = n.c(context);
                    if (TextUtils.isEmpty(c)) {
                        HMSLog.w("ReportAaidToken", "AAID is empty.");
                    } else if (!ReportAaidToken.d(context, c, str)) {
                        HMSLog.d("ReportAaidToken", "This time need not report.");
                    } else {
                        String a2 = f.a(context);
                        if (!TextUtils.isEmpty(a2)) {
                            String c2 = ReportAaidToken.c(context, c, str);
                            Context context = context;
                            ReportAaidToken.b(context, e.a(context, a2 + "/rest/appdata/v1/aaid/report", c2, (Map<String, String>) null), c, str);
                        }
                    }
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public static String c(Context context, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("timezone", TimeZone.getDefault().getID());
            jSONObject2.put("country", SystemUtils.getLocalCountry());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("agent_version", new PackageManagerHelper(context).getPackageVersionName("com.huawei.android.pushagent"));
            jSONObject3.put("hms_version", String.valueOf(Util.getHmsVersion(context)));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("dev_type", a.MOBILE.a());
            jSONObject4.put("dev_sub_type", "phone");
            jSONObject4.put("os_type", b.ANDROID.a());
            jSONObject4.put("os_version", String.valueOf(HwBuildEx.VERSION.EMUI_SDK_INT));
            jSONObject.put("id", UUID.randomUUID().toString());
            jSONObject.put("global", jSONObject2);
            jSONObject.put("push_agent", jSONObject3);
            jSONObject.put("hardware", jSONObject4);
            jSONObject.put("aaid", str);
            jSONObject.put("token", str2);
            jSONObject.put("app_id", AGConnectServicesConfig.fromContext(context).getString("client/app_id"));
            jSONObject.put("region", AGConnectServicesConfig.fromContext(context).getString("region"));
            return jSONObject.toString();
        } catch (JSONException unused) {
            HMSLog.e("ReportAaidToken", "Catch JSONException.");
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(Context context) {
        int packageVersionCode = new PackageManagerHelper(context).getPackageVersionCode("com.huawei.android.pushagent");
        HMSLog.d("ReportAaidToken", "NC version code: " + packageVersionCode);
        return (90101400 <= packageVersionCode && packageVersionCode < 100000000) || packageVersionCode >= 100001301;
    }

    /* access modifiers changed from: private */
    public static boolean d(Context context, String str, String str2) {
        q qVar = new q(context, "push_client_self_info");
        if (!qVar.d("reportAaidAndToken")) {
            HMSLog.d("ReportAaidToken", "It hasn't been reported, this time needs report.");
            return true;
        }
        String b2 = qVar.b("reportAaidAndToken");
        if (TextUtils.isEmpty(b2)) {
            HMSLog.e("ReportAaidToken", "It has been reported, but sp file is empty, this time needs report.");
            return true;
        }
        return !b2.equals(r.a(str2 + str, "SHA-256"));
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            HMSLog.e("ReportAaidToken", "Https response is empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("ret", 256);
            if (optInt == 0) {
                boolean a2 = new q(context, "push_client_self_info").a("reportAaidAndToken", r.a(str3 + str2, "SHA-256"));
                StringBuilder sb = new StringBuilder();
                sb.append("Report success ");
                sb.append(a2 ? "and save success." : "but save failure.");
                HMSLog.d("ReportAaidToken", sb.toString());
                return;
            }
            HMSLog.e("ReportAaidToken", "Https response body's ret code: " + optInt + ", error message: " + jSONObject.optInt("msg"));
        } catch (JSONException unused) {
            HMSLog.e("ReportAaidToken", "Has JSONException.");
        } catch (Exception unused2) {
            HMSLog.e("ReportAaidToken", "Exception occur.");
        }
    }

    enum a {
        MOBILE("1"),
        PC("2"),
        TABLET("3"),
        TV("4"),
        SOUNDBOX("5"),
        GLASS("6"),
        WATCH("7"),
        VEHICLE("8"),
        OFFICE_DEVICE("9"),
        IOT_DEVICES("10"),
        HEALTHY("11"),
        ENTERTAINMENT("12"),
        TRANSPORT_DEVICES("13");
        
        private String n;

        private a(String str) {
            this.n = str;
        }

        public String a() {
            return this.n;
        }
    }

    enum b {
        IOS("ios"),
        ANDROID("android"),
        HARMONY("harmony"),
        WINDOWS("windows"),
        EMBED("embed"),
        OTHERS("others");
        
        private String g;

        private b(String str) {
            this.g = str;
        }

        public String a() {
            return this.g;
        }
    }
}
