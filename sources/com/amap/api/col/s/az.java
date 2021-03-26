package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.s;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

/* compiled from: GeocodeSearchCore */
public final class az implements IGeocodeSearch {
    private Context a;
    private GeocodeSearch.OnGeocodeSearchListener b;
    private Handler c = s.a();

    public az(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        try {
            q.a(this.a);
            boolean z = false;
            if (regeocodeQuery != null) {
                if (regeocodeQuery.getPoint() != null) {
                    if (regeocodeQuery.getLatLonType() != null) {
                        z = true;
                    }
                }
            }
            if (z) {
                return (RegeocodeAddress) new ah(this.a, regeocodeQuery).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            i.a(e, "GeocodeSearch", "getFromLocationAsyn");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            q.a(this.a);
            if (geocodeQuery != null) {
                return (List) new n(this.a, geocodeQuery).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            i.a(e, "GeocodeSearch", "getFromLocationName");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.b = onGeocodeSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationAsyn(final RegeocodeQuery regeocodeQuery) {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.az.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 2;
                        obtainMessage.what = 201;
                        s.i iVar = new s.i();
                        iVar.b = az.this.b;
                        obtainMessage.obj = iVar;
                        iVar.a = new RegeocodeResult(regeocodeQuery, az.this.getFromLocation(regeocodeQuery));
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        az.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    az.this.c.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationNameAsyn(final GeocodeQuery geocodeQuery) {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.az.AnonymousClass2 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    try {
                        obtainMessage.what = 200;
                        obtainMessage.arg1 = 2;
                        obtainMessage.arg2 = 1000;
                        s.e eVar = new s.e();
                        eVar.b = az.this.b;
                        obtainMessage.obj = eVar;
                        eVar.a = new GeocodeResult(geocodeQuery, az.this.getFromLocationName(geocodeQuery));
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        az.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    az.this.c.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }
}
