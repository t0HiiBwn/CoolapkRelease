package com.tencent.android.tpush.stat.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.RC4;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class d {
    public static String a(Context context) {
        String a = c.a(context, "xg.mta.ui", "");
        if (TextUtils.isEmpty(a)) {
            a = CustomDeviceInfos.getFacilityIdentity(context);
        }
        if (TextUtils.isEmpty(a)) {
            a = Integer.toString(new Random().nextInt(Integer.MAX_VALUE));
        }
        c.b(context, "xg.mta.ui", a);
        return a;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(RC4.decrypt(Base64.decode(str.getBytes("UTF-8"), 0)), "UTF-8");
        } catch (Throwable th) {
            TLogger.e("XgStat", "decode error", th);
            return str;
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
                TLogger.e("XgStat", "jsonPut error", th);
            }
        }
    }
}
