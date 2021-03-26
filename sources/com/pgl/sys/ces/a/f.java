package com.pgl.sys.ces.a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import com.pgl.sys.ces.b;
import com.pgl.sys.ces.out.ISdkInfo;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f {

    static class a implements Comparator<Object> {
        a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int abs = Math.abs(((ScanResult) obj).level);
            int abs2 = Math.abs(((ScanResult) obj2).level);
            if (abs > abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }

    public static String a(Context context) {
        String str = null;
        try {
            ISdkInfo e = b.e();
            if (e != null) {
                WifiInfo connectionInfo = e.getConnectionInfo();
                String bssid = connectionInfo.getBSSID();
                String trim = bssid == null ? "" : bssid.trim();
                String ssid = connectionInfo.getSSID();
                String replace = (ssid == null ? "" : ssid.trim()).replace(' ', ' ').replace('\'', ' ').replace('\"', ' ');
                String num = Integer.toString(connectionInfo.getIpAddress());
                str = trim + "[<!>]" + replace + "[<!>]" + (num == null ? "" : num.trim()) + "[<!>]";
            }
        } catch (Throwable unused) {
        }
        return str == null ? "" : str.trim();
    }

    public static String b(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (context == null) {
            return jSONArray.toString();
        }
        String str = null;
        try {
            ISdkInfo e = b.e();
            List<ScanResult> scanResults = e != null ? e.getScanResults() : null;
            if (scanResults != null) {
                if (scanResults.size() > 0) {
                    Collections.sort(scanResults, new a());
                    int i = 0;
                    while (true) {
                        if (i >= scanResults.size()) {
                            break;
                        } else if (i >= 10) {
                            break;
                        } else {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("ss", scanResults.get(i).SSID.replaceAll("\"", "_"));
                                jSONObject.put("bs", scanResults.get(i).BSSID.replaceAll("\"", "_"));
                                jSONArray.put(jSONObject);
                            } catch (JSONException unused) {
                            }
                            i++;
                        }
                    }
                    str = jSONArray.toString();
                    return str == null ? "[]" : str.trim();
                }
            }
            return jSONArray.toString();
        } catch (Throwable unused2) {
        }
    }

    public static String c(Context context) {
        ISdkInfo e;
        String str = null;
        try {
            if (b.f() == 1 && (e = b.e()) != null) {
                str = "" + e.getLongitude() + "," + e.getLatitude();
            }
        } catch (Throwable unused) {
        }
        return str == null ? "" : str.trim();
    }
}
