package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class cn {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<cm> f273a = new ArrayList<>();

    public cn() {
    }

    public cn(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    public synchronized cm a() {
        for (int size = this.f273a.size() - 1; size >= 0; size--) {
            cm cmVar = this.f273a.get(size);
            if (cmVar.m179a()) {
                cq.a().m189a(cmVar.a());
                return cmVar;
            }
        }
        return null;
    }

    public synchronized cn a(JSONObject jSONObject) {
        this.a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f273a.add(new cm(this.a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m180a() {
        return this.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<cm> m181a() {
        return this.f273a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m182a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cm> it2 = this.f273a.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().m177a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized void a(cm cmVar) {
        int i = 0;
        while (true) {
            if (i >= this.f273a.size()) {
                break;
            } else if (this.f273a.get(i).a(cmVar)) {
                this.f273a.set(i, cmVar);
                break;
            } else {
                i++;
            }
        }
        if (i >= this.f273a.size()) {
            this.f273a.add(cmVar);
        }
    }

    public synchronized void a(boolean z) {
        ArrayList<cm> arrayList;
        for (int size = this.f273a.size() - 1; size >= 0; size--) {
            cm cmVar = this.f273a.get(size);
            if (z) {
                if (cmVar.c()) {
                    arrayList = this.f273a;
                }
            } else if (!cmVar.b()) {
                arrayList = this.f273a;
            }
            arrayList.remove(size);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        Iterator<cm> it2 = this.f273a.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
        }
        return sb.toString();
    }
}
