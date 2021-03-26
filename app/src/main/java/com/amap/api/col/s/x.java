package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.ad;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchIdHandler */
public final class x extends w<String, PoiItem> {
    private PoiSearch.Query j = null;

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return d(str);
    }

    public x(Context context, String str, PoiSearch.Query query) {
        super(context, str);
        this.j = query;
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.a() + "/place/detail?";
    }

    private static PoiItem d(String str) throws AMapException {
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("pois");
            if (optJSONArray == null) {
                return null;
            }
            if (optJSONArray.length() <= 0) {
                return null;
            }
            JSONObject optJSONObject = optJSONArray.optJSONObject(0);
            if (optJSONObject == null) {
                return null;
            }
            return p.d(optJSONObject);
        } catch (JSONException e) {
            i.a(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e2) {
            i.a(e2, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    @Override // com.amap.api.col.s.a
    protected final ad.b d() {
        ad.b bVar = new ad.b();
        bVar.a = h() + a() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) this.b);
        sb.append("&output=json");
        PoiSearch.Query query = this.j;
        if (query == null || c(query.getExtensions())) {
            sb.append("&extensions=base");
        } else {
            sb.append("&extensions=");
            sb.append(this.j.getExtensions());
        }
        sb.append("&children=1");
        sb.append("&key=" + bi.f(this.e));
        return sb.toString();
    }
}
