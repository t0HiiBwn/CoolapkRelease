package com.tencent.connect.auth;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.open.a.f;
import com.tencent.open.utils.d;
import com.tencent.open.utils.e;
import com.tencent.open.utils.j;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;
    private static SharedPreferences f;
    private String a;
    private String b;
    private String c;
    private int d = 1;
    private long e = -1;

    public QQToken(String str) {
        this.a = str;
    }

    public boolean isSessionValid() {
        return this.b != null && System.currentTimeMillis() < this.e;
    }

    public String getAppId() {
        return this.a;
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public String getAccessToken() {
        return this.b;
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.b = str;
        this.e = 0;
        if (str2 != null) {
            this.e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public String getOpenId() {
        return this.c;
    }

    public void setOpenId(String str) {
        this.c = str;
    }

    public int getAuthSource() {
        return this.d;
    }

    public void setAuthSource(int i) {
        this.d = i;
    }

    public long getExpireTimeInSecond() {
        return this.e;
    }

    public void saveSession(JSONObject jSONObject) {
        try {
            a(this.a, jSONObject);
        } catch (Exception e2) {
            f.c("QQToken", "login saveSession" + e2.toString());
        }
    }

    public JSONObject loadSession(String str) {
        try {
            return a(str);
        } catch (Exception e2) {
            f.c("QQToken", "login loadSession" + e2.toString());
            return null;
        }
    }

    private static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            if (f == null) {
                f = e.a().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = f;
        }
        return sharedPreferences;
    }

    private static synchronized JSONObject a(String str) {
        synchronized (QQToken.class) {
            if (e.a() == null) {
                f.c("QQToken", "loadJsonPreference context null");
                return null;
            } else if (str == null) {
                return null;
            } else {
                String string = a().getString(Base64.encodeToString(j.i(str), 2), null);
                if (string == null) {
                    f.c("QQToken", "loadJsonPreference encoded value null");
                    return null;
                }
                try {
                    return new JSONObject(d.b(string, "asdfghjk"));
                } catch (Exception e2) {
                    f.c("QQToken", "loadJsonPreference decode" + e2.toString());
                    return null;
                }
            }
        }
    }

    private static synchronized void a(String str, JSONObject jSONObject) {
        synchronized (QQToken.class) {
            if (e.a() == null) {
                f.c("QQToken", "saveJsonPreference context null");
            } else if (str != null && jSONObject != null) {
                try {
                    String string = jSONObject.getString("expires_in");
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put("expires_time", System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String encodeToString = Base64.encodeToString(j.i(str), 2);
                        String a2 = d.a(jSONObject.toString(), "asdfghjk");
                        if (encodeToString != null && a2 != null) {
                            a().edit().putString(encodeToString, a2).commit();
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
