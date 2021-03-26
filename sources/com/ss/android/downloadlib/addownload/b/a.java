package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.h.k;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppInfo */
public class a {
    public long a;
    public long b;
    public long c;
    public String d;
    public String e;
    public String f;
    public String g;
    public volatile long h;

    public a() {
    }

    public a(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.a);
            jSONObject.put("mAdId", this.b);
            jSONObject.put("mExtValue", this.c);
            jSONObject.put("mPackageName", this.d);
            jSONObject.put("mAppName", this.e);
            jSONObject.put("mLogExtra", this.f);
            jSONObject.put("mFileName", this.g);
            jSONObject.put("mTimeStamp", this.h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.a = k.a(jSONObject, "mDownloadId");
            aVar.b = k.a(jSONObject, "mAdId");
            aVar.c = k.a(jSONObject, "mExtValue");
            aVar.d = jSONObject.optString("mPackageName");
            aVar.e = jSONObject.optString("mAppName");
            aVar.f = jSONObject.optString("mLogExtra");
            aVar.g = jSONObject.optString("mFileName");
            aVar.h = k.a(jSONObject, "mTimeStamp");
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
