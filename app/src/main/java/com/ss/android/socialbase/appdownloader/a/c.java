package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.g.a;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: CustomJumpDevicePlan */
public class c extends a {
    private final JSONObject d;

    public c(Context context, a aVar, String str, JSONObject jSONObject) {
        super(context, aVar, str);
        this.d = jSONObject;
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String optString = this.d.optString("action");
        String optString2 = this.d.optString("category");
        int optInt = this.d.optInt("flags", 1342210048);
        String optString3 = this.d.optString("path_extra_key");
        String optString4 = this.d.optString("path_data_key");
        JSONObject optJSONObject = this.d.optJSONObject("extra");
        JSONObject optJSONObject2 = this.d.optJSONObject("extra_type");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        Intent intent = new Intent(optString);
        if (!TextUtils.isEmpty(optString2)) {
            intent.addCategory(optString2);
        }
        if (!TextUtils.isEmpty(optString4)) {
            try {
                intent.setData(Uri.parse(String.format(optString4, this.c)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(optInt);
        if (!TextUtils.isEmpty(optString3)) {
            intent.putExtra(optString3, this.c);
        }
        a(intent, optJSONObject, optJSONObject2);
        return intent;
    }

    private static void a(Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys;
        if (jSONObject != null && jSONObject2 != null && jSONObject.length() == jSONObject2.length() && intent != null && (keys = jSONObject.keys()) != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject2.optString(next);
                if (optString != null) {
                    a(jSONObject, next, optString, intent);
                }
            }
        }
    }

    private static void a(JSONObject jSONObject, String str, String str2, Intent intent) {
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case -1325958191:
                if (str2.equals("double")) {
                    c = 0;
                    break;
                }
                break;
            case -891985903:
                if (str2.equals("string")) {
                    c = 1;
                    break;
                }
                break;
            case 104431:
                if (str2.equals("int")) {
                    c = 2;
                    break;
                }
                break;
            case 3327612:
                if (str2.equals("long")) {
                    c = 3;
                    break;
                }
                break;
            case 64711720:
                if (str2.equals("boolean")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                intent.putExtra(str, jSONObject.optDouble(str));
                return;
            case 1:
                intent.putExtra(str, jSONObject.optString(str));
                return;
            case 2:
                intent.putExtra(str, jSONObject.optInt(str));
                return;
            case 3:
                intent.putExtra(str, jSONObject.optLong(str));
                return;
            case 4:
                intent.putExtra(str, jSONObject.optBoolean(str));
                return;
            default:
                return;
        }
    }
}
