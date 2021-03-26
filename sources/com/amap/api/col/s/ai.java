package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: RideRouteSearchHandler */
public final class ai extends b<RouteSearch.RideRouteQuery, RideRouteResult> {
    public ai(Context context, RouteSearch.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bi.f(this.e));
        stringBuffer.append("&origin=");
        stringBuffer.append(i.a(((RouteSearch.RideRouteQuery) this.b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(i.a(((RouteSearch.RideRouteQuery) this.b).getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (!TextUtils.isEmpty(((RouteSearch.RideRouteQuery) this.b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.RideRouteQuery) this.b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.b() + "/direction/bicycling?";
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final /* synthetic */ Object a(String str) throws AMapException {
        return p.g(str);
    }
}
