package com.tencent.android.tpush.service.protocol;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class m extends e {
    public long a = 0;
    public String b = "";
    public long c = 0;
    public long d = 0;
    public String e = "";
    public long f = 0;
    public long g = 0;
    public String h = "";
    public String i = "";
    public int j = -1;
    public ArrayList<String> k = null;

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.a = jSONObject.optLong("confVersion", this.a);
        this.b = jSONObject.optString("token", this.b);
        this.c = jSONObject.optLong("guid", this.c);
        this.d = jSONObject.optLong("otherPushTokenType", this.d);
        this.e = jSONObject.optString("otherPushToken", this.e);
        this.f = jSONObject.optLong("otherPushTokenCrc32", this.f);
        this.g = jSONObject.optLong("tokenCrc32", this.g);
        this.h = jSONObject.optString("reserved", this.h);
        this.i = jSONObject.optString("ticket", this.i);
        this.j = jSONObject.optInt("ticketType", this.j);
        JSONArray optJSONArray = jSONObject.optJSONArray("groupKeys");
        if (optJSONArray != null) {
            this.k = new ArrayList<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                this.k.add(optJSONArray.getString(i2));
            }
        }
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.REGISTER;
    }
}
