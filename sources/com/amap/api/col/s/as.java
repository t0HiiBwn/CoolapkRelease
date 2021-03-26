package com.amap.api.col.s;

import android.content.Context;

/* compiled from: WeatherSearchHandler */
abstract class as<T, V> extends b<T, V> {
    public as(Context context, T t) {
        super(context, t);
    }

    public final T i() {
        return (T) this.b;
    }

    @Override // com.amap.api.col.s.cy
    public String h() {
        return h.a() + "/weather/weatherInfo?";
    }
}
