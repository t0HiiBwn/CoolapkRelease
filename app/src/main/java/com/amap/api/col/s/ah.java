package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.ad;
import com.amap.api.col.s.af;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReverseGeocodingHandler */
public final class ah extends b<RegeocodeQuery, RegeocodeAddress> {
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    public ah(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.a() + "/geocode/regeo?";
    }

    private static RegeocodeAddress c(String str) throws AMapException {
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("regeocode");
            if (optJSONObject == null) {
                return regeocodeAddress;
            }
            regeocodeAddress.setFormatAddress(p.a(optJSONObject, "formatted_address"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
            if (optJSONObject2 != null) {
                p.a(optJSONObject2, regeocodeAddress);
            }
            regeocodeAddress.setPois(p.c(optJSONObject));
            JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
            if (optJSONArray != null) {
                p.b(optJSONArray, regeocodeAddress);
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
            if (optJSONArray2 != null) {
                p.a(optJSONArray2, regeocodeAddress);
            }
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
            if (optJSONArray3 != null) {
                p.c(optJSONArray3, regeocodeAddress);
            }
            return regeocodeAddress;
        } catch (JSONException e) {
            i.a(e, "ReverseGeocodingHandler", "paseJSON");
        }
    }

    private String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json&location=");
        if (z) {
            sb.append(i.a(((RegeocodeQuery) this.b).getPoint().getLongitude()));
            sb.append(",");
            sb.append(i.a(((RegeocodeQuery) this.b).getPoint().getLatitude()));
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.b).getPoiType())) {
            sb.append("&poitype=");
            sb.append(((RegeocodeQuery) this.b).getPoiType());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.b).getMode())) {
            sb.append("&mode=");
            sb.append(((RegeocodeQuery) this.b).getMode());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.b).getExtensions())) {
            sb.append("&extensions=");
            sb.append(((RegeocodeQuery) this.b).getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&radius=");
        sb.append((int) ((RegeocodeQuery) this.b).getRadius());
        sb.append("&coordsys=");
        sb.append(((RegeocodeQuery) this.b).getLatLonType());
        sb.append("&key=");
        sb.append(bi.f(this.e));
        return sb.toString();
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        return a(true);
    }

    @Override // com.amap.api.col.s.a
    protected final ad.b d() {
        af afVar;
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
        ad.b bVar = new ad.b();
        bVar.a = h() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        if (!(this.b == null || ((RegeocodeQuery) this.b).getPoint() == null)) {
            bVar.b = new af.a(((RegeocodeQuery) this.b).getPoint().getLatitude(), ((RegeocodeQuery) this.b).getPoint().getLongitude(), d);
        }
        return bVar;
    }
}
