package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class a extends d {
    public long a = 0;
    public String b = "";
    public int c = 0;
    public long d = 0;
    public String e = "";
    public ArrayList<p> f = null;

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.a);
        jSONObject.put("accessKey", this.b);
        jSONObject.put("operateType", this.c);
        jSONObject.put("timestamp", this.d);
        jSONObject.put("sdkVersion", this.e);
        if (this.f != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<p> it2 = this.f.iterator();
            while (it2.hasNext()) {
                JSONObject a2 = it2.next().a();
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            jSONObject.put("typeAccounts", jSONArray);
        }
        return jSONObject;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.ACCOUNT;
    }
}
