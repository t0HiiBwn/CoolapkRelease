package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.ad;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GeocodingHandler */
public final class n extends b<GeocodeQuery, ArrayList<GeocodeAddress>> {
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    public n(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    private static ArrayList<GeocodeAddress> c(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("count") && jSONObject.getInt("count") > 0) {
                return p.g(jSONObject);
            }
            return arrayList;
        } catch (JSONException e) {
            i.a(e, "GeocodingHandler", "paseJSONJSONException");
            return arrayList;
        } catch (Exception e2) {
            i.a(e2, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.a() + "/geocode/geo?";
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&address=");
        stringBuffer.append(b(((GeocodeQuery) this.b).getLocationName()));
        String city = ((GeocodeQuery) this.b).getCity();
        if (!p.f(city)) {
            String b = b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        if (!p.f(((GeocodeQuery) this.b).getCountry())) {
            stringBuffer.append("&country=");
            stringBuffer.append(b(((GeocodeQuery) this.b).getCountry()));
        }
        stringBuffer.append("&key=" + bi.f(this.e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.a
    protected final ad.b d() {
        ad.b bVar = new ad.b();
        bVar.a = h() + a() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }
}
