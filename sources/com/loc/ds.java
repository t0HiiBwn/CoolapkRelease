package com.loc;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import org.json.JSONObject;

/* compiled from: AMapLocationServer */
public final class ds extends AMapLocation {
    protected String d = "";
    boolean e = true;
    String f = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
    private String g = null;
    private String h = "";
    private int i;
    private String j = "";
    private String k = "new";
    private JSONObject l = null;
    private String m = "";
    private String n = "";
    private String o = null;

    public ds(String str) {
        super(str);
    }

    public final String a() {
        return this.g;
    }

    public final void a(String str) {
        this.g = str;
    }

    public final void a(JSONObject jSONObject) {
        this.l = jSONObject;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final String b() {
        return this.h;
    }

    public final void b(String str) {
        this.h = str;
    }

    public final void b(JSONObject jSONObject) {
        try {
            ej.a(this, jSONObject);
            this.k = jSONObject.optString("type", this.k);
            this.j = jSONObject.optString("retype", this.j);
            String optString = jSONObject.optString("cens", this.n);
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split("\\*");
                int length = split.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    String str = split[i2];
                    if (!TextUtils.isEmpty(str)) {
                        String[] split2 = str.split(",");
                        setLongitude(ep.e(split2[0]));
                        setLatitude(ep.e(split2[1]));
                        setAccuracy((float) ep.g(split2[2]));
                        break;
                    }
                    i2++;
                }
                this.n = optString;
            }
            this.d = jSONObject.optString("desc", this.d);
            c(jSONObject.optString("coord", String.valueOf(this.i)));
            this.m = jSONObject.optString("mcell", this.m);
            this.e = jSONObject.optBoolean("isReversegeo", this.e);
            this.f = jSONObject.optString("geoLanguage", this.f);
            if (ep.a(jSONObject, "poiid")) {
                setBuildingId(jSONObject.optString("poiid"));
            }
            if (ep.a(jSONObject, "pid")) {
                setBuildingId(jSONObject.optString("pid"));
            }
            if (ep.a(jSONObject, "floor")) {
                setFloor(jSONObject.optString("floor"));
            }
            if (ep.a(jSONObject, "flr")) {
                setFloor(jSONObject.optString("flr"));
            }
        } catch (Throwable th) {
            ej.a(th, "AmapLoc", "AmapLoc");
        }
    }

    public final int c() {
        return this.i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027  */
    public final void c(String str) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("0")) {
                i2 = 0;
            } else if (str.equals("1")) {
                i2 = 1;
            }
            this.i = i2;
            super.setCoordType(this.i != 0 ? "WGS84" : "GCJ02");
        }
        i2 = -1;
        this.i = i2;
        super.setCoordType(this.i != 0 ? "WGS84" : "GCJ02");
    }

    public final String d() {
        return this.j;
    }

    public final void d(String str) {
        this.j = str;
    }

    public final String e() {
        return this.k;
    }

    public final void e(String str) {
        this.k = str;
    }

    public final JSONObject f() {
        return this.l;
    }

    public final void f(String str) {
        this.f = str;
    }

    public final String g() {
        return this.m;
    }

    public final void g(String str) {
        this.d = str;
    }

    public final ds h() {
        String str = this.m;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length != 3) {
            return null;
        }
        ds dsVar = new ds("");
        dsVar.setProvider(getProvider());
        dsVar.setLongitude(ep.e(split[0]));
        dsVar.setLatitude(ep.e(split[1]));
        dsVar.setAccuracy(ep.f(split[2]));
        dsVar.setCityCode(getCityCode());
        dsVar.setAdCode(getAdCode());
        dsVar.setCountry(getCountry());
        dsVar.setProvince(getProvince());
        dsVar.setCity(getCity());
        dsVar.setTime(getTime());
        dsVar.k = this.k;
        dsVar.c(String.valueOf(this.i));
        if (!ep.a(dsVar)) {
            return null;
        }
        return dsVar;
    }

    public final void h(String str) {
        this.o = str;
    }

    public final boolean i() {
        return this.e;
    }

    public final String j() {
        return this.f;
    }

    public final String k() {
        return this.o;
    }

    @Override // com.amap.api.location.AMapLocation
    public final JSONObject toJson(int i2) {
        try {
            JSONObject json = super.toJson(i2);
            if (i2 == 1) {
                json.put("retype", this.j);
                json.put("cens", this.n);
                json.put("coord", this.i);
                json.put("mcell", this.m);
                json.put("desc", this.d);
                json.put("address", getAddress());
                if (this.l != null && ep.a(json, "offpct")) {
                    json.put("offpct", this.l.getString("offpct"));
                }
            } else if (!(i2 == 2 || i2 == 3)) {
                return json;
            }
            json.put("type", this.k);
            json.put("isReversegeo", this.e);
            json.put("geoLanguage", this.f);
            return json;
        } catch (Throwable th) {
            ej.a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr() {
        return toStr(1);
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr(int i2) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i2);
            jSONObject.put("nb", this.o);
        } catch (Throwable th) {
            ej.a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
