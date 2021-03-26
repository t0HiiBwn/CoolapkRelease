package com.xiaomi.b.a;

import com.xiaomi.a.a.a.c;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends d {
    public String a;
    public int b;
    public long c;
    public String d;

    @Override // com.xiaomi.b.a.d
    public JSONObject a() {
        try {
            JSONObject a2 = super.a();
            if (a2 == null) {
                return null;
            }
            a2.put("eventId", this.a);
            a2.put("eventType", this.b);
            a2.put("eventTime", this.c);
            String str = this.d;
            if (str == null) {
                str = "";
            }
            a2.put("eventContent", str);
            return a2;
        } catch (JSONException e) {
            c.a(e);
            return null;
        }
    }

    @Override // com.xiaomi.b.a.d
    public String b() {
        return super.b();
    }
}
