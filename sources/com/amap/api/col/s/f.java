package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CloudSearchIdHandler */
public final class f extends e<aa, CloudItemDetail> {
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        return null;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    public f(Context context, aa aaVar) {
        super(context, aaVar);
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.d() + "/datasearch/id";
    }

    private static CloudItemDetail c(String str) throws AMapException {
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            JSONArray a = a(new JSONObject(str));
            if (a == null) {
                return null;
            }
            if (a.length() <= 0) {
                return null;
            }
            JSONObject jSONObject = a.getJSONObject(0);
            CloudItemDetail b = b(jSONObject);
            a(b, jSONObject);
            return b;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a, com.amap.api.col.s.cy
    public final Map<String, String> e() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", bi.f(this.e));
        hashtable.put("layerId", ((aa) this.b).a);
        hashtable.put("output", "json");
        hashtable.put("id", ((aa) this.b).b);
        String a = bl.a();
        String a2 = bl.a(this.e, a, bs.b(hashtable));
        hashtable.put("ts", a);
        hashtable.put("scode", a2);
        return hashtable;
    }
}
