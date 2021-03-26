package com.bytedance.embedapplog;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

public class ar extends av {
    public String h;
    public String i;
    public ArrayList<String> j;
    public ArrayList<String> k;
    public int l;
    public int m;
    public int n;
    public int o;

    ar() {
        super("bav2b_click", true, null);
    }

    public ar(String str, String str2, int i2, int i3, int i4, int i5, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this();
        this.h = str;
        this.i = str2;
        this.j = arrayList;
        this.k = arrayList2;
        this.l = i2;
        this.m = i3;
        this.n = i4;
        this.o = i5;
    }

    @Override // com.bytedance.embedapplog.av
    protected void i() {
        if (this.p == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("element_path", this.i);
            jSONObject.put("page_key", this.h);
            ArrayList<String> arrayList = this.k;
            if (arrayList != null && arrayList.size() > 0) {
                jSONObject.put("positions", new JSONArray((Collection) this.k));
            }
            ArrayList<String> arrayList2 = this.j;
            if (arrayList2 != null && arrayList2.size() > 0) {
                jSONObject.put("texts", new JSONArray((Collection) this.j));
            }
            jSONObject.put("element_width", this.l);
            jSONObject.put("element_height", this.m);
            jSONObject.put("touch_x", this.n);
            jSONObject.put("touch_y", this.o);
            this.p = jSONObject.toString();
        }
    }
}
