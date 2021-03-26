package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.s;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import java.util.ArrayList;

/* compiled from: BusStationSearchCore */
public final class av implements IBusStationSearch {
    private Context a;
    private BusStationSearch.OnBusStationSearchListener b;
    private BusStationQuery c;
    private BusStationQuery d;
    private ArrayList<BusStationResult> e = new ArrayList<>();
    private int f;
    private Handler g;

    public av(Context context, BusStationQuery busStationQuery) {
        this.a = context.getApplicationContext();
        this.c = busStationQuery;
        this.g = s.a();
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationResult searchBusStation() throws AMapException {
        int i;
        try {
            q.a(this.a);
            BusStationQuery busStationQuery = this.c;
            boolean z = true;
            int i2 = 0;
            if (busStationQuery != null && !i.a(busStationQuery.getQueryString())) {
                if (!this.c.weakEquals(this.d)) {
                    this.d = this.c.clone();
                    this.f = 0;
                    ArrayList<BusStationResult> arrayList = this.e;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
                if (this.f == 0) {
                    BusStationResult busStationResult = (BusStationResult) new d(this.a, this.c).b();
                    this.f = busStationResult.getPageCount();
                    this.e = new ArrayList<>();
                    while (true) {
                        i = this.f;
                        if (i2 > i) {
                            break;
                        }
                        this.e.add(null);
                        i2++;
                    }
                    if (i <= 0) {
                        return busStationResult;
                    }
                    this.e.set(this.c.getPageNumber(), busStationResult);
                    return busStationResult;
                }
                int pageNumber = this.c.getPageNumber();
                if (pageNumber > this.f || pageNumber < 0) {
                    z = false;
                }
                if (z) {
                    BusStationResult busStationResult2 = this.e.get(pageNumber);
                    if (busStationResult2 != null) {
                        return busStationResult2;
                    }
                    BusStationResult busStationResult3 = (BusStationResult) new d(this.a, this.c).b();
                    this.e.set(this.c.getPageNumber(), busStationResult3);
                    return busStationResult3;
                }
                throw new IllegalArgumentException("page out of range");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            i.a(e2, "BusStationSearch", "searchBusStation");
            throw new AMapException(e2.getErrorMessage());
        } catch (Throwable th) {
            i.a(th, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.b = onBusStationSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void searchBusStationAsyn() {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.av.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 7;
                        s.b bVar = new s.b();
                        bVar.b = av.this.b;
                        obtainMessage.obj = bVar;
                        BusStationResult searchBusStation = av.this.searchBusStation();
                        obtainMessage.what = 1000;
                        bVar.a = searchBusStation;
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        av.this.g.sendMessage(obtainMessage);
                        throw th;
                    }
                    av.this.g.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setQuery(BusStationQuery busStationQuery) {
        if (!busStationQuery.weakEquals(this.c)) {
            this.c = busStationQuery;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationQuery getQuery() {
        return this.c;
    }
}
