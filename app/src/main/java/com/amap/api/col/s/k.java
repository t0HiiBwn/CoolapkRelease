package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DistrictServerHandler */
public final class k extends b<DistrictSearchQuery, DistrictResult> {
    public k(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=");
        stringBuffer.append(((DistrictSearchQuery) this.b).getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((DistrictSearchQuery) this.b).getPageSize());
        if (((DistrictSearchQuery) this.b).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((DistrictSearchQuery) this.b).checkKeyWords()) {
            String b = b(((DistrictSearchQuery) this.b).getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&key=" + bi.f(this.e));
        stringBuffer.append("&subdistrict=" + String.valueOf(((DistrictSearchQuery) this.b).getSubDistrict()));
        return stringBuffer.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public DistrictResult a(String str) throws AMapException {
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) this.b, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt("count"));
            JSONArray optJSONArray = jSONObject.optJSONArray("districts");
            if (optJSONArray == null) {
                return districtResult;
            }
            p.a(optJSONArray, arrayList, null);
            return districtResult;
        } catch (JSONException e) {
            i.a(e, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            i.a(e2, "DistrictServerHandler", "paseJSONException");
        }
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.a() + "/config/district?";
    }
}
