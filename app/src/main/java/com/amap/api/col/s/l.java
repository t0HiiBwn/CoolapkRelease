package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: DrivePlanSearchHandler */
public final class l extends b<RouteSearch.DrivePlanQuery, DriveRoutePlanResult> {
    public l(Context context, RouteSearch.DrivePlanQuery drivePlanQuery) {
        super(context, drivePlanQuery);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0165: INVOKE  (r2v2 int) = 
      (wrap: com.amap.api.services.route.RouteSearch$DrivePlanQuery : 0x0163: CHECK_CAST (r2v1 com.amap.api.services.route.RouteSearch$DrivePlanQuery) = (com.amap.api.services.route.RouteSearch$DrivePlanQuery) (wrap: java.lang.Object : 0x0161: IGET  (r2v0 java.lang.Object) = (r3v0 'this' com.amap.api.col.s.l A[IMMUTABLE_TYPE, THIS]) com.amap.api.col.s.l.b java.lang.Object))
     type: VIRTUAL call: com.amap.api.services.route.RouteSearch.DrivePlanQuery.getMode():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0181: INVOKE  (r2v5 int) = 
      (wrap: com.amap.api.services.route.RouteSearch$DrivePlanQuery : 0x017f: CHECK_CAST (r2v4 com.amap.api.services.route.RouteSearch$DrivePlanQuery) = (com.amap.api.services.route.RouteSearch$DrivePlanQuery) (wrap: java.lang.Object : 0x017d: IGET  (r2v3 java.lang.Object) = (r3v0 'this' com.amap.api.col.s.l A[IMMUTABLE_TYPE, THIS]) com.amap.api.col.s.l.b java.lang.Object))
     type: VIRTUAL call: com.amap.api.services.route.RouteSearch.DrivePlanQuery.getCarType():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x019d: INVOKE  (r2v8 int) = 
      (wrap: com.amap.api.services.route.RouteSearch$DrivePlanQuery : 0x019b: CHECK_CAST (r2v7 com.amap.api.services.route.RouteSearch$DrivePlanQuery) = (com.amap.api.services.route.RouteSearch$DrivePlanQuery) (wrap: java.lang.Object : 0x0199: IGET  (r2v6 java.lang.Object) = (r3v0 'this' com.amap.api.col.s.l A[IMMUTABLE_TYPE, THIS]) com.amap.api.col.s.l.b java.lang.Object))
     type: VIRTUAL call: com.amap.api.services.route.RouteSearch.DrivePlanQuery.getFirstTime():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x01b9: INVOKE  (r2v11 int) = 
      (wrap: com.amap.api.services.route.RouteSearch$DrivePlanQuery : 0x01b7: CHECK_CAST (r2v10 com.amap.api.services.route.RouteSearch$DrivePlanQuery) = (com.amap.api.services.route.RouteSearch$DrivePlanQuery) (wrap: java.lang.Object : 0x01b5: IGET  (r2v9 java.lang.Object) = (r3v0 'this' com.amap.api.col.s.l A[IMMUTABLE_TYPE, THIS]) com.amap.api.col.s.l.b java.lang.Object))
     type: VIRTUAL call: com.amap.api.services.route.RouteSearch.DrivePlanQuery.getInterval():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x01d5: INVOKE  (r2v14 int) = 
      (wrap: com.amap.api.services.route.RouteSearch$DrivePlanQuery : 0x01d3: CHECK_CAST (r2v13 com.amap.api.services.route.RouteSearch$DrivePlanQuery) = (com.amap.api.services.route.RouteSearch$DrivePlanQuery) (wrap: java.lang.Object : 0x01d1: IGET  (r2v12 java.lang.Object) = (r3v0 'this' com.amap.api.col.s.l A[IMMUTABLE_TYPE, THIS]) com.amap.api.col.s.l.b java.lang.Object))
     type: VIRTUAL call: com.amap.api.services.route.RouteSearch.DrivePlanQuery.getCount():int)] */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bi.f(this.e));
        if (((RouteSearch.DrivePlanQuery) this.b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(i.a(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getFrom()));
            if (!p.f(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(i.a(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getTo()));
            if (!p.f(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getDestinationPoiID());
            }
            if (!p.f(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getOriginType());
            }
            if (!p.f(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getDestinationType());
            }
            if (!p.f(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getPlateProvince());
            }
            if (!p.f(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getPlateNumber());
            }
        }
        if (((RouteSearch.DrivePlanQuery) this.b).getDestParentPoiID() != null) {
            stringBuffer.append("&parentid=");
            stringBuffer.append(((RouteSearch.DrivePlanQuery) this.b).getDestParentPoiID());
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.DrivePlanQuery) this.b).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DrivePlanQuery) this.b).getCarType());
        stringBuffer.append(sb2.toString());
        stringBuffer.append("&firsttime=");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((RouteSearch.DrivePlanQuery) this.b).getFirstTime());
        stringBuffer.append(sb3.toString());
        stringBuffer.append("&interval=");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(((RouteSearch.DrivePlanQuery) this.b).getInterval());
        stringBuffer.append(sb4.toString());
        stringBuffer.append("&count=");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(((RouteSearch.DrivePlanQuery) this.b).getCount());
        stringBuffer.append(sb5.toString());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.b() + "/etd/driving?";
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final /* synthetic */ Object a(String str) throws AMapException {
        return p.j(str);
    }
}
