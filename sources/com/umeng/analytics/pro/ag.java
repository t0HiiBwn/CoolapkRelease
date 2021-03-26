package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ModelBuildHelper */
public class ag {
    public static synchronized JSONObject a(Context context) {
        JSONObject b;
        synchronized (ag.class) {
            b = b(context);
            try {
                b.put(ad.f, Build.ID);
                b.put(ad.h, Build.MODEL);
                b.put(ad.i, DeviceConfig.getLocaleInfo(context)[1]);
            } catch (Exception unused) {
            }
        }
        return b;
    }

    public static synchronized JSONObject b(Context context) {
        JSONObject jSONObject;
        synchronized (ag.class) {
            JSONObject jSONObject2 = null;
            try {
                ad adVar = new ad();
                String uMId = UMUtils.getUMId(context);
                if (TextUtils.isEmpty(uMId)) {
                    return null;
                }
                adVar.a(uMId);
                String appkey = UMUtils.getAppkey(context);
                if (TextUtils.isEmpty(appkey)) {
                    return null;
                }
                adVar.b(appkey);
                adVar.c(UMUtils.getAppVersionName(context));
                adVar.d("9.3.3");
                adVar.e(UMUtils.getChannel(context));
                adVar.f(Build.VERSION.SDK_INT + "");
                adVar.g(Build.BRAND);
                adVar.h(Build.MODEL);
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                adVar.i(localeInfo[1]);
                adVar.j(localeInfo[0]);
                int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                adVar.b(Integer.valueOf(resolutionArray[1]));
                adVar.a(Integer.valueOf(resolutionArray[0]));
                adVar.k(a(context, "install_datetime", ""));
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException unused) {
                    ULog.i("jessie", "[getCloudConfigParam] error i");
                    return jSONObject2;
                }
                try {
                    jSONObject.put(ad.a, adVar.a());
                    jSONObject.put(ad.c, adVar.c());
                    jSONObject.put(ad.b, adVar.b());
                    jSONObject.put(ad.d, adVar.d());
                    jSONObject.put(ad.e, adVar.e());
                    jSONObject.put(ad.f, adVar.f());
                    jSONObject.put(ad.g, adVar.g());
                    jSONObject.put(ad.h, adVar.h());
                    jSONObject.put(ad.k, adVar.k());
                    jSONObject.put(ad.j, adVar.j());
                    jSONObject.put(ad.f1457l, adVar.l());
                    jSONObject.put(ad.i, adVar.i());
                    jSONObject.put(ad.m, adVar.m());
                    return jSONObject;
                } catch (JSONException unused2) {
                    jSONObject2 = jSONObject;
                    ULog.i("jessie", "[getCloudConfigParam] error i");
                    return jSONObject2;
                } catch (Exception unused3) {
                    jSONObject2 = jSONObject;
                    ULog.i("jessie", "[getCloudConfigParam] error ii");
                    return jSONObject2;
                }
            } catch (Exception unused4) {
                ULog.i("jessie", "[getCloudConfigParam] error ii");
                return jSONObject2;
            }
        }
    }

    public static synchronized JSONArray a(ae aeVar, Context context) {
        synchronized (ag.class) {
            JSONArray jSONArray = null;
            if (!(aeVar == null || context == null)) {
                try {
                    ac acVar = new ac();
                    String uMId = UMUtils.getUMId(context);
                    if (TextUtils.isEmpty(uMId)) {
                        return null;
                    }
                    acVar.d(uMId);
                    String appkey = UMUtils.getAppkey(context);
                    if (TextUtils.isEmpty(appkey)) {
                        return null;
                    }
                    acVar.c(appkey);
                    acVar.a(Long.valueOf(System.currentTimeMillis()));
                    acVar.a(Integer.valueOf(Integer.parseInt(aeVar.c())));
                    acVar.b(Integer.valueOf(Integer.parseInt(aeVar.d())));
                    acVar.a(aeVar.a());
                    acVar.b(aeVar.b());
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    try {
                        jSONObject.put(ac.a, acVar.c());
                        jSONObject.put(ac.e, acVar.g());
                        jSONObject.put(ac.c, acVar.e());
                        jSONObject.put(ac.d, acVar.f());
                        jSONObject.put(ac.b, acVar.d());
                        jSONObject.put(ac.f, acVar.a());
                        jSONObject.put(ac.g, acVar.b());
                        jSONArray2.put(0, jSONObject);
                        List<JSONObject> d = d(context);
                        if (d != null && d.size() > 0) {
                            for (int i = 1; i <= d.size(); i++) {
                                jSONArray2.put(i, d.get(i - 1));
                            }
                        }
                        c(context);
                        return jSONArray2;
                    } catch (Exception unused) {
                        try {
                            ULog.i("jessie", "[getUpdateAbEventLogParam] error i");
                            jSONArray = jSONArray2;
                        } catch (Exception unused2) {
                            jSONArray = jSONArray2;
                            ULog.i("jessie", "[getUpdateAbEventLogParam] error ii");
                            return jSONArray;
                        }
                    }
                } catch (Exception unused3) {
                    ULog.i("jessie", "[getUpdateAbEventLogParam] error ii");
                    return jSONArray;
                }
            }
            return jSONArray;
        }
    }

    public static void c(Context context) {
        try {
            SharedPreferences a = ab.a(context);
            if (a != null) {
                SharedPreferences.Editor edit = a.edit();
                edit.putString("abtest_sp_last_request_data", "");
                edit.commit();
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, String str) {
        try {
            SharedPreferences a = ab.a(context);
            if (a != null) {
                SharedPreferences.Editor edit = a.edit();
                edit.putString("abtest_sp_last_request_data", str);
                edit.commit();
            }
        } catch (Exception unused) {
        }
    }

    private static List<JSONObject> d(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            SharedPreferences a = ab.a(context);
            if (a != null) {
                String string = a.getString("abtest_sp_last_request_data", "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        JSONArray jSONArray = new JSONArray(string);
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String string2 = jSONArray.getString(i);
                            if (!TextUtils.isEmpty(string2)) {
                                arrayList.add(new JSONObject(string2));
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static String a(Context context, String str, String str2) {
        return context == null ? str2 : ImprintHandler.getImprintService(context.getApplicationContext()).c().a(str, str2);
    }
}
