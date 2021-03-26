package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONObject;

class ah extends u {
    private final Context e;

    ah(Context context) {
        super(false, false);
        this.e = context;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        String str;
        try {
            str = Settings.Secure.getString(this.e.getContentResolver(), "android_id");
        } catch (Exception e2) {
            bo.c("", e2);
            str = null;
        }
        if (!aa.d(str) || "9774d56d682e549c".equals(str)) {
            SharedPreferences sharedPreferences = this.e.getSharedPreferences("snssdk_openudid", 0);
            String string = sharedPreferences.getString("openudid", null);
            if (!aa.d(string)) {
                string = new BigInteger(64, new SecureRandom()).toString(16);
                if (string.charAt(0) == '-') {
                    string = string.substring(1);
                }
                int length = 13 - string.length();
                if (length > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (length > 0) {
                        sb.append('F');
                        length--;
                    }
                    sb.append(string);
                    string = sb.toString();
                }
                try {
                    string = a("openudid.dat", string);
                } catch (Exception unused) {
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("openudid", string);
                edit.apply();
            }
            str = string;
        }
        jSONObject.put("openudid", str);
        return true;
    }
}
