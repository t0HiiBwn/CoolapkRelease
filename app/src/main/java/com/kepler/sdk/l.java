package com.kepler.sdk;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l {
    long a;
    private Context b;
    private String c;
    private HashMap<String, m> d = new HashMap<>();

    public l(Context context) {
        this.b = context;
    }

    public o a(String str) {
        if (af.c(str)) {
            return null;
        }
        HashMap hashMap = (HashMap) this.d.clone();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("updateTime");
            if (!af.c(optString)) {
                if (!optString.equals(this.c)) {
                    this.c = optString;
                    JSONArray optJSONArray = jSONObject.optJSONArray("updateList");
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            String optString2 = optJSONObject.optString("url");
                            m mVar = new m(optString2, optJSONObject.optString("targetUrl"), optJSONObject.optString("md5"), optJSONObject.optString("version"), optJSONObject.optString("updateTime"), optJSONObject.optString("mime"), optJSONObject.optString("encoding"));
                            m mVar2 = (m) hashMap.remove(optString2);
                            if (mVar2 == null) {
                                arrayList.add(mVar);
                            } else if (!mVar2.equals(mVar)) {
                                arrayList.add(mVar);
                            } else {
                                arrayList2.add(mVar);
                            }
                        }
                    }
                    if (hashMap.size() > 0) {
                        for (Object obj : hashMap.keySet()) {
                            arrayList3.add((m) hashMap.get(obj));
                        }
                    }
                    ae.a(this.b, "AccelerateCacheJsonKey", str);
                    return new o(arrayList, arrayList2, arrayList3);
                }
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public o a() {
        return a(ae.b(this.b, "AccelerateCacheJsonKey", (String) null));
    }

    public long b() {
        if (this.a <= 0) {
            this.a = ae.b(this.b, "AccelerateCacheLastTimeNet", -1L);
        }
        return this.a;
    }

    public void a(long j) {
        ae.a(this.b, "AccelerateCacheLastTimeNet", j);
        this.a = j;
    }

    public void a(HashMap<String, m> hashMap) {
        if (hashMap != null) {
            this.d = hashMap;
        }
    }
}
