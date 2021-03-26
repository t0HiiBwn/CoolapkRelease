package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: DriveRouteSearchHandler */
public final class m extends b<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    public m(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x013f: INVOKE  (r2v2 int) = 
      (wrap: com.amap.api.services.route.RouteSearch$DriveRouteQuery : 0x013d: CHECK_CAST (r2v1 com.amap.api.services.route.RouteSearch$DriveRouteQuery) = (com.amap.api.services.route.RouteSearch$DriveRouteQuery) (wrap: java.lang.Object : 0x013b: IGET  (r2v0 java.lang.Object) = (r3v0 'this' com.amap.api.col.s.m A[IMMUTABLE_TYPE, THIS]) com.amap.api.col.s.m.b java.lang.Object))
     type: VIRTUAL call: com.amap.api.services.route.RouteSearch.DriveRouteQuery.getMode():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0191: INVOKE  (r2v5 int) = 
      (wrap: com.amap.api.services.route.RouteSearch$DriveRouteQuery : 0x018f: CHECK_CAST (r2v4 com.amap.api.services.route.RouteSearch$DriveRouteQuery) = (com.amap.api.services.route.RouteSearch$DriveRouteQuery) (wrap: java.lang.Object : 0x018d: IGET  (r2v3 java.lang.Object) = (r3v0 'this' com.amap.api.col.s.m A[IMMUTABLE_TYPE, THIS]) com.amap.api.col.s.m.b java.lang.Object))
     type: VIRTUAL call: com.amap.api.services.route.RouteSearch.DriveRouteQuery.getCarType():int)] */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bi.f(this.e));
        if (((RouteSearch.DriveRouteQuery) this.b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(i.a(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getFrom()));
            if (!p.f(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(i.a(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getTo()));
            if (!p.f(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getDestinationPoiID());
            }
            if (!p.f(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getOriginType());
            }
            if (!p.f(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getDestinationType());
            }
            if (!p.f(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getPlateProvince());
            }
            if (!p.f(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.DriveRouteQuery) this.b).getMode());
        stringBuffer.append(sb.toString());
        if (!TextUtils.isEmpty(((RouteSearch.DriveRouteQuery) this.b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearch.DriveRouteQuery) this.b).isUseFerry());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DriveRouteQuery) this.b).getCarType());
        stringBuffer.append(sb2.toString());
        if (((RouteSearch.DriveRouteQuery) this.b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.b).getPassedPointStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.b).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.b).getAvoidpolygonsStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.b).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(b(((RouteSearch.DriveRouteQuery) this.b).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearch.DriveRouteQuery) this.b).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.b).getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.a() + "/direction/driving?";
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final /* synthetic */ Object a(String str) throws AMapException {
        return p.b(str);
    }
}
