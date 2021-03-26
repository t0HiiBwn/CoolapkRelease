package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NearbySearchHandler */
public final class u extends b<NearbySearch.NearbyQuery, NearbySearchResult> {
    private Context j;
    private NearbySearch.NearbyQuery k;

    public u(Context context, NearbySearch.NearbyQuery nearbyQuery) {
        super(context, nearbyQuery);
        this.j = context;
        this.k = nearbyQuery;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bi.f(this.j));
        LatLonPoint centerPoint = this.k.getCenterPoint();
        if (centerPoint != null) {
            stringBuffer.append("&center=");
            stringBuffer.append(centerPoint.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(centerPoint.getLatitude());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append(this.k.getRadius());
        stringBuffer.append("&limit=30");
        stringBuffer.append("&searchtype=");
        stringBuffer.append(this.k.getType());
        stringBuffer.append("&timerange=");
        stringBuffer.append(this.k.getTimeRange());
        return stringBuffer.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public NearbySearchResult a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z = true;
            if (this.k.getType() != 1) {
                z = false;
            }
            ArrayList<NearbyInfo> a = p.a(jSONObject, z);
            NearbySearchResult nearbySearchResult = new NearbySearchResult();
            nearbySearchResult.setNearbyInfoList(a);
            return nearbySearchResult;
        } catch (JSONException e) {
            i.a(e, "NearbySearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.c() + "/nearby/around";
    }
}
