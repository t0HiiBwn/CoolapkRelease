package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.ad;
import com.amap.api.col.s.af;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchKeywordsHandler */
public final class y extends w<ab, PoiResult> {
    private int j = 0;
    private boolean k = false;
    private List<String> l = new ArrayList();
    private List<SuggestionCity> m = new ArrayList();

    private static String b(boolean z) {
        return z ? "distance" : "weight";
    }

    public y(Context context, ab abVar) {
        super(context, abVar);
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        String str = h.a() + "/place";
        if (((ab) this.b).b == null) {
            return str + "/text?";
        } else if (((ab) this.b).b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.k = true;
            return str2;
        } else if (!((ab) this.b).b.getShape().equals("Rectangle") && !((ab) this.b).b.getShape().equals("Polygon")) {
            return str;
        } else {
            return str + "/polygon?";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public PoiResult a(String str) throws AMapException {
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (str == null) {
            return PoiResult.createPagedResult(((ab) this.b).a, ((ab) this.b).b, this.l, this.m, ((ab) this.b).a.getPageSize(), this.j, arrayList);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.j = jSONObject.optInt("count");
            arrayList = p.c(jSONObject);
            if (!jSONObject.has("suggestion")) {
                return PoiResult.createPagedResult(((ab) this.b).a, ((ab) this.b).b, this.l, this.m, ((ab) this.b).a.getPageSize(), this.j, arrayList);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject == null) {
                return PoiResult.createPagedResult(((ab) this.b).a, ((ab) this.b).b, this.l, this.m, ((ab) this.b).a.getPageSize(), this.j, arrayList);
            }
            this.m = p.a(optJSONObject);
            this.l = p.b(optJSONObject);
            return PoiResult.createPagedResult(((ab) this.b).a, ((ab) this.b).b, this.l, this.m, ((ab) this.b).a.getPageSize(), this.j, arrayList);
        } catch (JSONException e) {
            i.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            i.a(e2, "PoiSearchKeywordHandler", "paseJSONException");
        }
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        return a(true);
    }

    private String a(boolean z) {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (((ab) this.b).b != null) {
            if (((ab) this.b).b.getShape().equals("Bound")) {
                if (z) {
                    double a = i.a(((ab) this.b).b.getCenter().getLongitude());
                    double a2 = i.a(((ab) this.b).b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(a + "," + a2);
                }
                sb.append("&radius=");
                sb.append(((ab) this.b).b.getRange());
                sb.append("&sortrule=");
                sb.append(b(((ab) this.b).b.isDistanceSort()));
            } else if (((ab) this.b).b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((ab) this.b).b.getLowerLeft();
                LatLonPoint upperRight = ((ab) this.b).b.getUpperRight();
                double a3 = i.a(lowerLeft.getLatitude());
                double a4 = i.a(lowerLeft.getLongitude());
                double a5 = i.a(upperRight.getLatitude());
                double a6 = i.a(upperRight.getLongitude());
                sb.append("&polygon=" + a4 + "," + a3 + ";" + a6 + "," + a5);
            } else if (((ab) this.b).b.getShape().equals("Polygon") && (polyGonList = ((ab) this.b).b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + i.a(polyGonList));
            }
        }
        String city = ((ab) this.b).a.getCity();
        if (!c(city)) {
            String b = b(city);
            sb.append("&city=");
            sb.append(b);
        }
        String b2 = b(((ab) this.b).a.getQueryString());
        if (!c(b2)) {
            sb.append("&keywords=");
            sb.append(b2);
        }
        sb.append("&offset=");
        sb.append(((ab) this.b).a.getPageSize());
        sb.append("&page=");
        sb.append(((ab) this.b).a.getPageNum());
        String building = ((ab) this.b).a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((ab) this.b).a.getBuilding());
        }
        String b3 = b(((ab) this.b).a.getCategory());
        if (!c(b3)) {
            sb.append("&types=");
            sb.append(b3);
        }
        if (!c(((ab) this.b).a.getExtensions())) {
            sb.append("&extensions=");
            sb.append(((ab) this.b).a.getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&key=");
        sb.append(bi.f(this.e));
        if (((ab) this.b).a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (((ab) this.b).a.isRequireSubPois()) {
            sb.append("&children=1");
        } else {
            sb.append("&children=0");
        }
        if (this.k) {
            if (((ab) this.b).a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        if (((ab) this.b).b == null && ((ab) this.b).a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(b(((ab) this.b).a.isDistanceSort()));
            double a7 = i.a(((ab) this.b).a.getLocation().getLongitude());
            double a8 = i.a(((ab) this.b).a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(a7 + "," + a8);
        }
        return sb.toString();
    }

    @Override // com.amap.api.col.s.a
    protected final ad.b d() {
        af afVar;
        ad.b bVar = new ad.b();
        if (this.k) {
            ae a = ad.a().a("regeo");
            if (a == null) {
                afVar = null;
            } else {
                afVar = (af) a;
            }
            double d = 0.0d;
            if (afVar != null) {
                d = afVar.a();
            }
            bVar.a = h() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
            if (((ab) this.b).b.getShape().equals("Bound")) {
                bVar.b = new af.a(i.a(((ab) this.b).b.getCenter().getLatitude()), i.a(((ab) this.b).b.getCenter().getLongitude()), d);
            }
        } else {
            bVar.a = h() + a() + "language=" + ServiceSettings.getInstance().getLanguage();
        }
        return bVar;
    }
}
