package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InputtipsHandler */
public final class o extends b<InputtipsQuery, ArrayList<Tip>> {
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    public o(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    private static ArrayList<Tip> c(String str) throws AMapException {
        try {
            return p.h(new JSONObject(str));
        } catch (JSONException e) {
            i.a(e, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.a() + "/assistant/inputtips?";
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String b = b(((InputtipsQuery) this.b).getKeyword());
        if (!TextUtils.isEmpty(b)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(b);
        }
        String city = ((InputtipsQuery) this.b).getCity();
        if (!p.f(city)) {
            String b2 = b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b2);
        }
        String type = ((InputtipsQuery) this.b).getType();
        if (!p.f(type)) {
            String b3 = b(type);
            stringBuffer.append("&type=");
            stringBuffer.append(b3);
        }
        if (((InputtipsQuery) this.b).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) this.b).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(bi.f(this.e));
        return stringBuffer.toString();
    }
}
