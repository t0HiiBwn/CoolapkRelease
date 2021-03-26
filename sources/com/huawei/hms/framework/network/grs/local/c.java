package com.huawei.hms.framework.network.grs.local;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a {
    public c(Context context) {
        if (a("grs_sdk_global_route_config.json", context) == 0) {
            this.d = true;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.local.a
    public int a(String str) {
        this.a = new a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString("name");
            long j = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.a.a(string);
            this.a.a(j);
            ArrayList arrayList = new ArrayList(16);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add((String) jSONArray.get(i));
                    }
                    return 0;
                }
            }
            return -1;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong.", e);
            return -1;
        }
    }

    public List<b> a(JSONArray jSONArray, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return new ArrayList();
        }
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                b bVar = new b();
                bVar.a(next);
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                bVar.b(jSONObject2.getString("name"));
                bVar.c(jSONObject2.getString("description"));
                JSONArray jSONArray2 = null;
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray2 = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray2 = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray2 != null) {
                    if (jSONArray2.length() != 0) {
                        for (int i = 0; i < jSONArray2.length(); i++) {
                            hashSet.add((String) jSONArray2.get(i));
                        }
                        bVar.a(hashSet);
                        arrayList.add(bVar);
                    }
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong.", e);
            return new ArrayList();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009e A[Catch:{ JSONException -> 0x0116 }, LOOP:2: B:19:0x0098->B:21:0x009e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fa A[Catch:{ JSONException -> 0x0116 }] */
    @Override // com.huawei.hms.framework.network.grs.local.a
    public int b(String str) {
        JSONObject jSONObject;
        String str2;
        String str3;
        JSONObject jSONObject2;
        String str4;
        Iterator<String> keys;
        String str5 = "countryGroup";
        String str6 = "countryOrAreaGroup";
        try {
            JSONObject jSONObject3 = new JSONObject(str).getJSONObject("services");
            Iterator<String> keys2 = jSONObject3.keys();
            while (true) {
                int i = 0;
                if (!keys2.hasNext()) {
                    return 0;
                }
                String next = keys2.next();
                com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
                cVar.a(next);
                if (!this.e.contains(next)) {
                    this.e.add(next);
                    JSONObject jSONObject4 = jSONObject3.getJSONObject(next);
                    cVar.c(jSONObject4.getString("routeBy"));
                    JSONArray jSONArray = jSONObject4.getJSONArray("servings");
                    while (i < jSONArray.length()) {
                        JSONObject jSONObject5 = (JSONObject) jSONArray.get(i);
                        d dVar = new d();
                        String str7 = "no-country";
                        if (jSONObject5.has(str6)) {
                            str7 = jSONObject5.getString(str6);
                        } else if (jSONObject5.has(str5)) {
                            str7 = jSONObject5.getString(str5);
                        } else {
                            str4 = str5;
                            Logger.v("LocalManagerV1", "maybe this service routeBy is unconditional.");
                            dVar.a(str7);
                            JSONObject jSONObject6 = jSONObject5.getJSONObject("addresses");
                            HashMap hashMap = new HashMap(16);
                            keys = jSONObject6.keys();
                            while (keys.hasNext()) {
                                String next2 = keys.next();
                                hashMap.put(next2, jSONObject6.getString(next2));
                                jSONObject3 = jSONObject3;
                                str6 = str6;
                            }
                            dVar.a(hashMap);
                            cVar.a(dVar.a(), dVar);
                            i++;
                            jSONObject3 = jSONObject3;
                            str5 = str4;
                            str6 = str6;
                        }
                        str4 = str5;
                        dVar.a(str7);
                        JSONObject jSONObject6 = jSONObject5.getJSONObject("addresses");
                        HashMap hashMap = new HashMap(16);
                        keys = jSONObject6.keys();
                        while (keys.hasNext()) {
                        }
                        dVar.a(hashMap);
                        cVar.a(dVar.a(), dVar);
                        i++;
                        jSONObject3 = jSONObject3;
                        str5 = str4;
                        str6 = str6;
                    }
                    str3 = str5;
                    str2 = str6;
                    jSONObject = jSONObject3;
                    List<b> list = null;
                    if (jSONObject4.has("countryOrAreaGroups")) {
                        jSONObject2 = jSONObject4.getJSONObject("countryOrAreaGroups");
                    } else if (jSONObject4.has("countryGroups")) {
                        jSONObject2 = jSONObject4.getJSONObject("countryGroups");
                    } else {
                        Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");
                        cVar.a(list);
                        if (this.a == null) {
                            this.a = new a();
                        }
                        this.a.a(next, cVar);
                    }
                    list = a((JSONArray) null, jSONObject2);
                    cVar.a(list);
                    if (this.a == null) {
                    }
                    this.a.a(next, cVar);
                } else {
                    str3 = str5;
                    str2 = str6;
                    jSONObject = jSONObject3;
                }
                jSONObject3 = jSONObject;
                str5 = str3;
                str6 = str2;
            }
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check!", e);
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.local.a
    public int c(String str) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        this.b = new ArrayList(16);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("countryOrAreaGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject2.has("countryGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryGroups");
            } else {
                Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONObject = null;
            }
            if (jSONObject == null) {
                return -1;
            }
            if (jSONObject.length() != 0) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    b bVar = new b();
                    bVar.a(next);
                    JSONObject jSONObject3 = jSONObject.getJSONObject(next);
                    bVar.b(jSONObject3.getString("name"));
                    bVar.c(jSONObject3.getString("description"));
                    if (jSONObject3.has("countriesOrAreas")) {
                        jSONArray = jSONObject3.getJSONArray("countriesOrAreas");
                    } else if (jSONObject3.has("countries")) {
                        jSONArray = jSONObject3.getJSONArray("countries");
                    } else {
                        Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                        jSONArray = null;
                    }
                    HashSet hashSet = new HashSet(16);
                    if (jSONArray != null) {
                        if (jSONArray.length() != 0) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                hashSet.add((String) jSONArray.get(i));
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
            Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong.", e);
            return -1;
        }
    }
}
