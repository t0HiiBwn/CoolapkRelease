package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: BusSearchServerHandler */
public final class d<T> extends b<T, Object> {
    private int j = 0;
    private List<String> k = new ArrayList();
    private List<SuggestionCity> l = new ArrayList();

    public d(Context context, T t) {
        super(context, t);
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        String str;
        if (this.b instanceof BusLineQuery) {
            str = ((BusLineQuery) this.b).getCategory() == BusLineQuery.SearchType.BY_LINE_ID ? "lineid" : ((BusLineQuery) this.b).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "";
        } else {
            str = "stopname";
        }
        return h.a() + "/bus/" + str + "?";
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final Object a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.l = p.a(optJSONObject);
                this.k = p.b(optJSONObject);
            }
            this.j = jSONObject.optInt("count");
            if (this.b instanceof BusLineQuery) {
                return BusLineResult.createPagedResult((BusLineQuery) this.b, this.j, this.l, this.k, p.f(jSONObject));
            }
            return BusStationResult.createPagedResult((BusStationQuery) this.b, this.j, this.l, this.k, p.e(jSONObject));
        } catch (Exception e) {
            i.a(e, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        if (this.b instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) this.b;
            if (!TextUtils.isEmpty(busLineQuery.getExtensions())) {
                sb.append("&extensions=");
                sb.append(busLineQuery.getExtensions());
            } else {
                sb.append("&extensions=base");
            }
            if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb.append("&id=");
                sb.append(b(((BusLineQuery) this.b).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!p.f(city)) {
                    String b = b(city);
                    sb.append("&city=");
                    sb.append(b);
                }
                sb.append("&keywords=" + b(busLineQuery.getQueryString()));
                sb.append("&offset=" + busLineQuery.getPageSize());
                sb.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) this.b;
            String city2 = busStationQuery.getCity();
            if (!p.f(city2)) {
                String b2 = b(city2);
                sb.append("&city=");
                sb.append(b2);
            }
            sb.append("&keywords=" + b(busStationQuery.getQueryString()));
            sb.append("&offset=" + busStationQuery.getPageSize());
            sb.append("&page=" + busStationQuery.getPageNumber());
        }
        sb.append("&key=" + bi.f(this.e));
        return sb.toString();
    }
}
