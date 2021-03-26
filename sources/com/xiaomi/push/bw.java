package com.xiaomi.push;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

class bw implements Comparable<bw> {
    String a;
    protected int b;
    private final LinkedList<bl> c;
    private long d;

    public bw() {
        this(null, 0);
    }

    public bw(String str) {
        this(str, 0);
    }

    public bw(String str, int i) {
        this.c = new LinkedList<>();
        this.d = 0;
        this.a = str;
        this.b = i;
    }

    /* renamed from: a */
    public int compareTo(bw bwVar) {
        if (bwVar == null) {
            return 1;
        }
        return bwVar.b - this.b;
    }

    public synchronized bw a(JSONObject jSONObject) {
        this.d = jSONObject.getLong("tt");
        this.b = jSONObject.getInt("wt");
        this.a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.c.add(new bl().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.d);
        jSONObject.put("wt", this.b);
        jSONObject.put("host", this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator<bl> it2 = this.c.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().b());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    protected synchronized void a(bl blVar) {
        if (blVar != null) {
            this.c.add(blVar);
            int a2 = blVar.a();
            if (a2 > 0) {
                this.b += blVar.a();
            } else {
                int i = 0;
                int size = this.c.size() - 1;
                while (size >= 0 && this.c.get(size).a() < 0) {
                    i++;
                    size--;
                }
                this.b += a2 * i;
            }
            if (this.c.size() > 30) {
                this.b -= this.c.remove().a();
            }
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a + ":" + this.b;
    }
}
