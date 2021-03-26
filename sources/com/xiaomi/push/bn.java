package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class bn {
    private String a;
    private final ArrayList<bm> b = new ArrayList<>();

    public bn() {
    }

    public bn(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    public synchronized bm a() {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            bm bmVar = this.b.get(size);
            if (bmVar.a()) {
                bq.a().f(bmVar.e());
                return bmVar;
            }
        }
        return null;
    }

    public synchronized bn a(JSONObject jSONObject) {
        this.a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.b.add(new bm(this.a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized void a(bm bmVar) {
        int i = 0;
        while (true) {
            if (i >= this.b.size()) {
                break;
            } else if (this.b.get(i).a(bmVar)) {
                this.b.set(i, bmVar);
                break;
            } else {
                i++;
            }
        }
        if (i >= this.b.size()) {
            this.b.add(bmVar);
        }
    }

    public synchronized void a(boolean z) {
        ArrayList<bm> arrayList;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            bm bmVar = this.b.get(size);
            if (z) {
                if (bmVar.c()) {
                    arrayList = this.b;
                }
            } else if (!bmVar.b()) {
                arrayList = this.b;
            }
            arrayList.remove(size);
        }
    }

    public ArrayList<bm> b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public synchronized JSONObject d() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator<bm> it2 = this.b.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().f());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        Iterator<bm> it2 = this.b.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
        }
        return sb.toString();
    }
}
