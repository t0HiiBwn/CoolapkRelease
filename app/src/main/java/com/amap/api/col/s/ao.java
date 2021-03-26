package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;

/* compiled from: TruckRouteSearchHandler */
public final class ao extends b<RouteSearch.TruckRouteQuery, TruckRouteRestult> {
    private final String j = "/direction/truck?";
    private final String k = "|";

    /* renamed from: l  reason: collision with root package name */
    private final String f1199l = ",";

    public ao(Context context, RouteSearch.TruckRouteQuery truckRouteQuery) {
        super(context, truckRouteQuery);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bi.f(this.e));
        if (((RouteSearch.TruckRouteQuery) this.b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(i.a(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getFrom()));
            if (!p.f(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(i.a(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getTo()));
            if (!p.f(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getDestinationPoiID());
            }
            if (!p.f(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getOriginType());
            }
            if (!p.f(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getDestinationType());
            }
            if (!p.f(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getPlateProvince());
            }
            if (!p.f(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getMode());
        if (((RouteSearch.TruckRouteQuery) this.b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getTruckAxis());
        if (!TextUtils.isEmpty(((RouteSearch.TruckRouteQuery) this.b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.b() + "/direction/truck?";
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final /* synthetic */ Object a(String str) throws AMapException {
        return p.i(str);
    }
}
