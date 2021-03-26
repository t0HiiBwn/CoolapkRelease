package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UMSysLocationCache */
public class ao {
    public static final String a = "lng";
    public static final String b = "lat";
    public static final String c = "ts";
    public static final long d = 30000;
    public static final int e = 200;
    private static final String f = "UMSysLocationCache";
    private static final String g = "1.0";

    public static void a(final Context context) {
        ULog.i("UMSysLocationCache", "begin location");
        if (context != null) {
            try {
                new Thread(new Runnable() {
                    /* class com.umeng.analytics.pro.ao.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            JSONArray b = ao.b(context);
                            if (b == null || b.length() < 200) {
                                ULog.i("UMSysLocationCache", "location status is ok, time is " + System.currentTimeMillis());
                                final an anVar = new an(context);
                                anVar.a(new ap() {
                                    /* class com.umeng.analytics.pro.ao.AnonymousClass1.AnonymousClass1 */

                                    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x011d: APUT  (r0v15 java.lang.Object[]), (0 ??[int, short, byte, char]), ("location same") */
                                    @Override // com.umeng.analytics.pro.ap
                                    public void a(Location location) {
                                        String str;
                                        int i;
                                        Throwable th;
                                        if (location != null) {
                                            try {
                                                double longitude = location.getLongitude();
                                                double latitude = location.getLatitude();
                                                float accuracy = location.getAccuracy();
                                                double altitude = location.getAltitude();
                                                ULog.i("UMSysLocationCache", "lon is " + longitude + ", lat is " + latitude + ", acc is " + accuracy + ", alt is " + altitude);
                                                if (!(longitude == 0.0d || latitude == 0.0d)) {
                                                    long time = location.getTime();
                                                    JSONObject jSONObject = new JSONObject();
                                                    try {
                                                        jSONObject.put("lng", longitude);
                                                        jSONObject.put("lat", latitude);
                                                        jSONObject.put("ts", time);
                                                        jSONObject.put("acc", (double) accuracy);
                                                        jSONObject.put("alt", altitude);
                                                    } catch (JSONException e) {
                                                        ULog.i("UMSysLocationCache", "e is " + e);
                                                    }
                                                    ULog.i("UMSysLocationCache", "locationJSONObject is " + jSONObject.toString());
                                                    SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_common_location", 0);
                                                    if (sharedPreferences != null) {
                                                        String string = sharedPreferences.getString("location_json_lon", "");
                                                        String string2 = sharedPreferences.getString("location_json_lat", "");
                                                        String decryptEx = DataHelper.decryptEx(string);
                                                        String decryptEx2 = DataHelper.decryptEx(string2);
                                                        str = "";
                                                        try {
                                                            ULog.i("UMSysLocationCache", "--->>> get lon is " + string + ", lat is " + string2);
                                                            if (TextUtils.isEmpty(decryptEx) || Double.parseDouble(decryptEx) != longitude || TextUtils.isEmpty(decryptEx2) || Double.parseDouble(decryptEx2) != latitude) {
                                                                JSONArray b2 = ao.b(context);
                                                                if (b2 == null) {
                                                                    b2 = new JSONArray();
                                                                }
                                                                b2.put(jSONObject);
                                                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                                                edit.putString("location_json_lon", DataHelper.encryptEx(String.valueOf(longitude)));
                                                                edit.putString("location_json_lat", DataHelper.encryptEx(String.valueOf(latitude)));
                                                                edit.putString("location_json_array", DataHelper.encryptEx(b2.toString()));
                                                                edit.putString("location_json_ver", DataHelper.encryptEx("1.0"));
                                                                edit.commit();
                                                                ULog.i("UMSysLocationCache", "location put is ok~~");
                                                            } else {
                                                                i = 1;
                                                                try {
                                                                    Object[] objArr = new Object[1];
                                                                    objArr[0] = "location same";
                                                                    ULog.i("UMSysLocationCache", objArr);
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    Object[] objArr2 = new Object[i];
                                                                    objArr2[0] = str + th.getMessage();
                                                                    ULog.i("UMSysLocationCache", objArr2);
                                                                    anVar.a();
                                                                }
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            i = 1;
                                                            Object[] objArr2 = new Object[i];
                                                            objArr2[0] = str + th.getMessage();
                                                            ULog.i("UMSysLocationCache", objArr2);
                                                            anVar.a();
                                                        }
                                                    }
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                str = "";
                                                i = 1;
                                                Object[] objArr2 = new Object[i];
                                                objArr2[0] = str + th.getMessage();
                                                ULog.i("UMSysLocationCache", objArr2);
                                                anVar.a();
                                            }
                                        }
                                        anVar.a();
                                    }
                                });
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }).start();
            } catch (Exception unused) {
            }
        }
    }

    public static JSONArray b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_common_location", 0);
        JSONArray jSONArray = null;
        if (sharedPreferences == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(sharedPreferences.getString("location_json_ver", ""))) {
                d(context);
            }
        } catch (Throwable unused) {
        }
        try {
            String decryptEx = DataHelper.decryptEx(sharedPreferences.getString("location_json_array", ""));
            if (!TextUtils.isEmpty(decryptEx)) {
                jSONArray = new JSONArray(decryptEx);
            }
        } catch (JSONException e2) {
            ULog.i("UMSysLocationCache", "e is " + e2);
        } catch (Throwable th) {
            ULog.i("UMSysLocationCache", "e is " + th);
        }
        if (jSONArray != null) {
            ULog.i("UMSysLocationCache", "get json str is " + jSONArray.toString());
        }
        return jSONArray;
    }

    public static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_common_location", 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("location_json_array", "");
                edit.commit();
                ULog.i("UMSysLocationCache", "delete is ok~~");
            }
        } catch (Throwable unused) {
        }
    }

    private static void d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_common_location", 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("location_json_array", "");
                edit.putString("location_json_lat", "");
                edit.putString("location_json_lon", "");
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }
}
