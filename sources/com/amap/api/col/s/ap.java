package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;

/* compiled from: WalkRouteSearchHandler */
public final class ap extends b<RouteSearch.WalkRouteQuery, WalkRouteResult> {
    public ap(Context context, RouteSearch.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bi.f(this.e));
        stringBuffer.append("&origin=");
        stringBuffer.append(i.a(((RouteSearch.WalkRouteQuery) this.b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(i.a(((RouteSearch.WalkRouteQuery) this.b).getFromAndTo().getTo()));
        stringBuffer.append("&multipath=0");
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (!TextUtils.isEmpty(((RouteSearch.WalkRouteQuery) this.b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.WalkRouteQuery) this.b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.a() + "/direction/walking?";
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final /* synthetic */ Object a(String str) throws AMapException {
        return p.c(str);
    }
}
