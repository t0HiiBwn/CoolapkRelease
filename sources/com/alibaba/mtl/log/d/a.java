package com.alibaba.mtl.log.d;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ApiResponseParse */
public class a {
    public static C0013a a(String str) {
        C0013a aVar = new C0013a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("success")) {
                String string = jSONObject.getString("success");
                if (!TextUtils.isEmpty(string) && string.equals("success")) {
                    aVar.I = true;
                }
            }
            if (jSONObject.has("ret")) {
                aVar.ad = jSONObject.getString("ret");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aVar;
    }

    /* renamed from: com.alibaba.mtl.log.d.a$a  reason: collision with other inner class name */
    /* compiled from: ApiResponseParse */
    public static class C0013a {
        public static C0013a a = new C0013a();
        public boolean I = false;
        public String ad = null;

        public boolean g() {
            return "E0102".equalsIgnoreCase(this.ad);
        }

        public boolean h() {
            return "E0111".equalsIgnoreCase(this.ad) || "E0112".equalsIgnoreCase(this.ad);
        }
    }
}
