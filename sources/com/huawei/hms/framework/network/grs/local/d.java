package com.huawei.hms.framework.network.grs.local;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends a {
    public d(Context context) {
        if (a("grs_app_global_route_config.json", context) == 0) {
            this.d = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008b A[LOOP:2: B:18:0x0085->B:20:0x008b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cd  */
    private void a(JSONArray jSONArray) {
        String str;
        Iterator<String> keys;
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                c cVar = new c();
                String string = jSONObject.getString("name");
                cVar.a(string);
                if (!this.e.contains(string)) {
                    this.e.add(string);
                    cVar.c(jSONObject.getString("routeBy"));
                    JSONArray jSONArray2 = jSONObject.getJSONArray("servings");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray2.get(i2);
                        com.huawei.hms.framework.network.grs.local.model.d dVar = new com.huawei.hms.framework.network.grs.local.model.d();
                        String str2 = "countryOrAreaGroup";
                        if (!jSONObject2.has(str2)) {
                            str2 = "countryGroup";
                            if (!jSONObject2.has(str2)) {
                                Logger.v("LocalManagerV2", "maybe this service routeBy is unconditional.");
                                str = "no-country";
                                dVar.a(str);
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("addresses");
                                HashMap hashMap = new HashMap(16);
                                keys = jSONObject3.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    hashMap.put(next, jSONObject3.getString(next));
                                }
                                dVar.a(hashMap);
                                cVar.a(dVar.a(), dVar);
                            }
                        }
                        str = jSONObject2.getString(str2);
                        dVar.a(str);
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("addresses");
                        HashMap hashMap = new HashMap(16);
                        keys = jSONObject3.keys();
                        while (keys.hasNext()) {
                        }
                        dVar.a(hashMap);
                        cVar.a(dVar.a(), dVar);
                    }
                    String str3 = "countryOrAreaGroups";
                    List<b> list = null;
                    if (!jSONObject.has(str3)) {
                        str3 = "countryGroups";
                        if (!jSONObject.has(str3)) {
                            Logger.i("LocalManagerV2", "service use default countryOrAreaGroup");
                            cVar.a(list);
                            if (this.a == null) {
                                this.a = new a();
                            }
                            this.a.a(string, cVar);
                        }
                    }
                    list = a(jSONObject.getJSONArray(str3), (JSONObject) null);
                    cVar.a(list);
                    if (this.a == null) {
                    }
                    this.a.a(string, cVar);
                }
            }
        }
    }

    @Override // com.huawei.hms.framework.network.grs.local.a
    public int a(String str) {
        this.a = new a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONArray("applications").getJSONObject(0);
            this.a.a(jSONObject.getString("name"));
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            ArrayList arrayList = new ArrayList(16);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add((String) jSONArray.get(i));
                    }
                    if (jSONObject.has("customservices")) {
                        a(jSONObject.getJSONArray("customservices"));
                    }
                    return 0;
                }
            }
            return -1;
        } catch (JSONException e) {
            Logger.w("LocalManagerV2", "parse appbean failed maybe json style is wrong.", e);
            return -1;
        }
    }

    public List<b> a(JSONArray jSONArray, JSONObject jSONObject) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        try {
            ArrayList arrayList = new ArrayList(16);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                b bVar = new b();
                bVar.a(jSONObject2.getString("id"));
                bVar.b(jSONObject2.getString("name"));
                bVar.c(jSONObject2.getString("description"));
                JSONArray jSONArray2 = null;
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray2 = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray2 = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.w("LocalManagerV2", "current country or area group has not config countries or areas.");
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray2 != null) {
                    if (jSONArray2.length() != 0) {
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            hashSet.add((String) jSONArray2.get(i2));
                        }
                        bVar.a(hashSet);
                        arrayList.add(bVar);
                    }
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e) {
            Logger.w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong.", e);
            return new ArrayList();
        }
    }

    @Override // com.huawei.hms.framework.network.grs.local.a
    public int b(String str) {
        try {
            a(new JSONObject(str).getJSONArray("services"));
            return 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV2", "parse 2.0 services failed maybe because of json style.please check!", e);
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.local.a
    public int c(String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        this.b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.e("LocalManagerV2", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            if (jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    b bVar = new b();
                    bVar.a(jSONObject2.getString("id"));
                    bVar.b(jSONObject2.getString("name"));
                    bVar.c(jSONObject2.getString("description"));
                    if (jSONObject2.has("countriesOrAreas")) {
                        jSONArray2 = jSONObject2.getJSONArray("countriesOrAreas");
                    } else if (jSONObject2.has("countries")) {
                        jSONArray2 = jSONObject2.getJSONArray("countries");
                    } else {
                        Logger.w("LocalManagerV2", "current country or area group has not config countries or areas.");
                        jSONArray2 = null;
                    }
                    HashSet hashSet = new HashSet(16);
                    if (jSONArray2 != null) {
                        if (jSONArray2.length() != 0) {
                            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                hashSet.add((String) jSONArray2.get(i2));
                            }
                            bVar.a(hashSet);
                            this.b.add(bVar);
                        }
                    }
                    return -1;
                }
            }
            return 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong.", e);
            return -1;
        }
    }
}
