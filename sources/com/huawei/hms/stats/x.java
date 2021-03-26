package com.huawei.hms.stats;

import android.text.TextUtils;
import com.huawei.hms.stats.e;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class x implements y {
    private List<w> a;
    private u b;
    private v c;
    private y d;
    private String e = "";
    private String f;

    public x(String str) {
        this.f = str;
    }

    public void a(bl blVar) {
        this.d = blVar;
    }

    public void a(u uVar) {
        this.b = uVar;
    }

    public void a(v vVar) {
        this.c = vVar;
    }

    public void a(String str) {
        if (str != null) {
            this.e = str;
        }
    }

    public void a(List<w> list) {
        this.a = list;
    }

    @Override // com.huawei.hms.stats.y
    public JSONObject c() {
        String str;
        List<w> list = this.a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.b == null || this.c == null || this.d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.b.c());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject c2 = this.d.c();
            c2.put("properties", this.c.c());
            try {
                c2.put("events_global_properties", new JSONObject(this.e));
            } catch (JSONException unused) {
                c2.put("events_global_properties", this.e);
            }
            jSONObject2.put("events_common", c2);
            JSONArray jSONArray = new JSONArray();
            for (w wVar : this.a) {
                JSONObject c3 = wVar.c();
                if (c3 != null) {
                    jSONArray.put(c3);
                } else {
                    af.c("EventUploadModel", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put("events", jSONArray);
            try {
                String a2 = e.a().a(e.a.AES).a(this.f, ba.a(jSONObject2.toString().getBytes("UTF-8")));
                if (TextUtils.isEmpty(a2)) {
                    af.c("EventUploadModel", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", a2);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        af.c("EventUploadModel", str);
        return null;
    }
}
