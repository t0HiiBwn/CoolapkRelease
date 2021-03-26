package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiboSsoSdkConfig implements Cloneable {
    private Context appContext;
    private String appKey = "";
    private HashMap<String, String> extra = new HashMap<>();
    private String from = "";
    private String oldwm = "";
    private String smApiKey = "";
    private String smid = "";
    private String sub = "";
    private String wm = "";

    private String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public void addExtra(String str, String str2) {
        this.extra.put(str, str2);
    }

    public String getExtraString(boolean z) {
        if (this.extra.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : this.extra.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
                return "";
            }
        }
        if (z) {
            return urlEncode(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String getSub(boolean z) {
        if (z) {
            return urlEncode(this.sub);
        }
        return this.sub;
    }

    public void setSub(String str) {
        this.sub = str;
    }

    public String getWm(boolean z) {
        if (z) {
            return urlEncode(this.wm);
        }
        return this.wm;
    }

    public void setWm(String str) {
        this.wm = str;
    }

    public String getOldWm(boolean z) {
        if (z) {
            return urlEncode(this.oldwm);
        }
        return this.oldwm;
    }

    public void setOldWm(String str) {
        this.oldwm = str;
    }

    public String getFrom(boolean z) {
        if (z) {
            return urlEncode(this.from);
        }
        return this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String getAppKey(boolean z) {
        if (z) {
            return urlEncode(this.appKey);
        }
        return this.appKey;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public Context getApplicationContext() {
        return this.appContext;
    }

    public void setContext(Context context) {
        this.appContext = context.getApplicationContext();
    }

    public String getSmid(boolean z) {
        if (z) {
            return urlEncode(this.smid);
        }
        return this.smid;
    }

    public void setSmid(String str) {
        this.smid = str;
    }

    public void setSmApiKey(String str) {
        this.smApiKey = str;
    }

    public String getSmApiKey() {
        return this.smApiKey;
    }

    public boolean verify() {
        return this.appContext != null && !TextUtils.isEmpty(this.appKey) && !TextUtils.isEmpty(this.from) && !TextUtils.isEmpty(this.wm);
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            WeiboSsoSdkConfig weiboSsoSdkConfig = (WeiboSsoSdkConfig) super.clone();
            HashMap<String, String> hashMap = new HashMap<>();
            for (Map.Entry<String, String> entry : weiboSsoSdkConfig.extra.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            weiboSsoSdkConfig.extra = hashMap;
            return weiboSsoSdkConfig;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
