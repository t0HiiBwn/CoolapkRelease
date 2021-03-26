package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: WeatherLiveHandler */
public final class ar extends as<WeatherSearchQuery, LocalWeatherLive> {
    private LocalWeatherLive j = new LocalWeatherLive();

    @Override // com.amap.api.col.s.as, com.amap.api.col.s.cy
    public final /* bridge */ /* synthetic */ String h() {
        return super.h();
    }

    public ar(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((WeatherSearchQuery) this.b).getCity();
        if (!p.f(city)) {
            String b = b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&extensions=base");
        stringBuffer.append("&key=" + bi.f(this.e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final /* synthetic */ Object a(String str) throws AMapException {
        LocalWeatherLive d = p.d(str);
        this.j = d;
        return d;
    }
}
