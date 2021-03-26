package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.s;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: WeatherSearchCore */
public final class bg implements IWeatherSearch {
    private Context a;
    private WeatherSearchQuery b;
    private WeatherSearch.OnWeatherSearchListener c;
    private LocalWeatherLiveResult d;
    private LocalWeatherForecastResult e;
    private Handler f = null;

    public bg(Context context) {
        this.a = context.getApplicationContext();
        this.f = s.a();
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final WeatherSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.b = weatherSearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void searchWeatherAsyn() {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.bg.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    s.k kVar;
                    s.l lVar;
                    Message obtainMessage = s.a().obtainMessage();
                    obtainMessage.arg1 = 13;
                    Bundle bundle = new Bundle();
                    if (bg.this.b == null) {
                        try {
                            throw new AMapException("无效的参数 - IllegalArgumentException");
                        } catch (AMapException e) {
                            i.a(e, "WeatherSearch", "searchWeatherAsyn");
                        }
                    } else if (bg.this.b.getType() == 1) {
                        int i = 1301;
                        try {
                            bg bgVar = bg.this;
                            bgVar.d = bg.b(bgVar);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                            i.a(e2, "WeatherSearch", "searchWeatherAsyn");
                        } catch (Throwable th) {
                            i.a(th, "WeatherSearch", "searchWeatherAnsyThrowable");
                        } finally {
                            lVar = new s.l();
                            obtainMessage.what = i;
                            lVar.b = bg.this.c;
                            lVar.a = bg.this.d;
                            obtainMessage.obj = lVar;
                            obtainMessage.setData(bundle);
                            bg.this.f.sendMessage(obtainMessage);
                        }
                    } else if (bg.this.b.getType() == 2) {
                        int i2 = 1302;
                        try {
                            bg bgVar2 = bg.this;
                            bgVar2.e = bg.f(bgVar2);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e3) {
                            bundle.putInt("errorCode", e3.getErrorCode());
                            i.a(e3, "WeatherSearch", "searchWeatherAsyn");
                        } catch (Throwable th2) {
                            i.a(th2, "WeatherSearch", "searchWeatherAnsyThrowable");
                        } finally {
                            kVar = new s.k();
                            obtainMessage.what = i2;
                            kVar.b = bg.this.c;
                            kVar.a = bg.this.e;
                            obtainMessage.obj = kVar;
                            obtainMessage.setData(bundle);
                            bg.this.f.sendMessage(obtainMessage);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.c = onWeatherSearchListener;
    }

    static /* synthetic */ LocalWeatherLiveResult b(bg bgVar) throws AMapException {
        q.a(bgVar.a);
        WeatherSearchQuery weatherSearchQuery = bgVar.b;
        if (weatherSearchQuery != null) {
            ar arVar = new ar(bgVar.a, weatherSearchQuery);
            return LocalWeatherLiveResult.createPagedResult((WeatherSearchQuery) arVar.i(), (LocalWeatherLive) arVar.b());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    static /* synthetic */ LocalWeatherForecastResult f(bg bgVar) throws AMapException {
        q.a(bgVar.a);
        WeatherSearchQuery weatherSearchQuery = bgVar.b;
        if (weatherSearchQuery != null) {
            aq aqVar = new aq(bgVar.a, weatherSearchQuery);
            return LocalWeatherForecastResult.createPagedResult((WeatherSearchQuery) aqVar.i(), (LocalWeatherForecast) aqVar.b());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }
}
