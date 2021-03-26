package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: BusRouteSearchHandler */
public final class c extends b<RouteSearch.BusRouteQuery, BusRouteResult> {
    public c(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0085: INVOKE  (r2v7 int) = 
      (wrap: com.amap.api.services.route.RouteSearch$BusRouteQuery : 0x0083: CHECK_CAST (r2v6 com.amap.api.services.route.RouteSearch$BusRouteQuery) = (com.amap.api.services.route.RouteSearch$BusRouteQuery) (wrap: java.lang.Object : 0x0081: IGET  (r2v5 java.lang.Object) = (r3v0 'this' com.amap.api.col.s.c A[IMMUTABLE_TYPE, THIS]) com.amap.api.col.s.c.b java.lang.Object))
     type: VIRTUAL call: com.amap.api.services.route.RouteSearch.BusRouteQuery.getMode():int)] */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bi.f(this.e));
        stringBuffer.append("&origin=");
        stringBuffer.append(i.a(((RouteSearch.BusRouteQuery) this.b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(i.a(((RouteSearch.BusRouteQuery) this.b).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) this.b).getCity();
        if (!p.f(city)) {
            city = b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!p.f(((RouteSearch.BusRouteQuery) this.b).getCity())) {
            String b = b(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.BusRouteQuery) this.b).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) this.b).getNightFlag());
        if (!TextUtils.isEmpty(((RouteSearch.BusRouteQuery) this.b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.BusRouteQuery) this.b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.a() + "/direction/transit/integrated?";
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final /* bridge */ /* synthetic */ Object a(String str) throws AMapException {
        return p.a(str);
    }
}
