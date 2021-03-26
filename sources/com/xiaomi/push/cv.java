package com.xiaomi.push;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

class cv implements Comparable<cv> {
    protected int a;

    /* renamed from: a  reason: collision with other field name */
    private long f287a;

    /* renamed from: a  reason: collision with other field name */
    String f288a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<cl> f289a;

    public cv() {
        this(null, 0);
    }

    public cv(String str) {
        this(str, 0);
    }

    public cv(String str, int i) {
        this.f289a = new LinkedList<>();
        this.f287a = 0;
        this.f288a = str;
        this.a = i;
    }

    /* renamed from: a */
    public int compareTo(cv cvVar) {
        if (cvVar == null) {
            return 1;
        }
        return cvVar.a - this.a;
    }

    public synchronized cv a(JSONObject jSONObject) {
        this.f287a = jSONObject.getLong("tt");
        this.a = jSONObject.getInt("wt");
        this.f288a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f289a.add(new cl().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f287a);
        jSONObject.put("wt", this.a);
        jSONObject.put("host", this.f288a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cl> it2 = this.f289a.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().m175a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    protected synchronized void a(cl clVar) {
        if (clVar != null) {
            this.f289a.add(clVar);
            int a2 = clVar.a();
            if (a2 > 0) {
                this.a += clVar.a();
            } else {
                int i = 0;
                int size = this.f289a.size() - 1;
                while (size >= 0 && this.f289a.get(size).a() < 0) {
                    i++;
                    size--;
                }
                this.a += a2 * i;
            }
            if (this.f289a.size() > 30) {
                this.a -= this.f289a.remove().a();
            }
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return this.f288a + ":" + this.a;
    }
}
