package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CloudHandler */
public abstract class e<T, V> extends b<T, V> {
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.cy
    public final byte[] g() {
        return null;
    }

    public e(Context context, T t) {
        super(context, t);
        this.a = false;
    }

    protected static JSONArray a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            return optJSONObject.optJSONArray("list");
        }
        return null;
    }

    protected static CloudItemDetail b(JSONObject jSONObject) throws JSONException {
        CloudItemDetail cloudItemDetail = new CloudItemDetail(p.a(jSONObject, "id"), new LatLonPoint(jSONObject.optDouble("point_y"), jSONObject.optDouble("point_x")), p.a(jSONObject, "title"), p.a(jSONObject, "address"));
        cloudItemDetail.setCreatetime(p.a(jSONObject, "gmt_create"));
        cloudItemDetail.setUpdatetime(p.a(jSONObject, "gmt_modified"));
        if (jSONObject.has("_distance")) {
            String optString = jSONObject.optString("_distance");
            if (!(optString == null || optString.equals("") || optString.equals("[]"))) {
                cloudItemDetail.setDistance(Integer.parseInt(optString));
            }
        }
        return cloudItemDetail;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a, com.amap.api.col.s.cy
    public final Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 7.7.0");
        hashMap.put("X-INFO", bl.a(this.e));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "7.7.0", "cloud"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    protected static void a(CloudItem cloudItem, JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        HashMap<String, String> hashMap = new HashMap<>();
        if (keys != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null) {
                    hashMap.put(next.toString(), jSONObject.optString(next.toString()));
                }
            }
            cloudItem.setCustomfield(hashMap);
        }
    }

    @Override // com.amap.api.col.s.a
    protected final V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            i.a(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        i.c(str);
        return a(str);
    }
}
