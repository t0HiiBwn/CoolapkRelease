package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.s;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import java.util.ArrayList;

/* compiled from: BusLineSearchCore */
public final class au implements IBusLineSearch {
    private Context a;
    private BusLineSearch.OnBusLineSearchListener b;
    private BusLineQuery c;
    private BusLineQuery d;
    private int e;
    private ArrayList<BusLineResult> f = new ArrayList<>();
    private Handler g = null;

    public au(Context context, BusLineQuery busLineQuery) {
        this.a = context.getApplicationContext();
        this.c = busLineQuery;
        if (busLineQuery != null) {
            this.d = busLineQuery.clone();
        }
        this.g = s.a();
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineResult searchBusLine() throws AMapException {
        int i;
        try {
            q.a(this.a);
            if (this.d != null) {
                BusLineQuery busLineQuery = this.c;
                int i2 = 0;
                if (busLineQuery != null && !i.a(busLineQuery.getQueryString())) {
                    if (!this.c.weakEquals(this.d)) {
                        this.d = this.c.clone();
                        this.e = 0;
                        ArrayList<BusLineResult> arrayList = this.f;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                    }
                    if (this.e == 0) {
                        BusLineResult busLineResult = (BusLineResult) new d(this.a, this.c.clone()).b();
                        this.f = new ArrayList<>();
                        while (true) {
                            i = this.e;
                            if (i2 >= i) {
                                break;
                            }
                            this.f.add(null);
                            i2++;
                        }
                        if (i < 0 || !a(this.c.getPageNumber())) {
                            return busLineResult;
                        }
                        this.f.set(this.c.getPageNumber(), busLineResult);
                        return busLineResult;
                    }
                    int pageNumber = this.c.getPageNumber();
                    if (a(pageNumber)) {
                        BusLineResult busLineResult2 = this.f.get(pageNumber);
                        if (busLineResult2 != null) {
                            return busLineResult2;
                        }
                        BusLineResult busLineResult3 = (BusLineResult) new d(this.a, this.c).b();
                        this.f.set(this.c.getPageNumber(), busLineResult3);
                        return busLineResult3;
                    }
                    throw new IllegalArgumentException("page out of range");
                }
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            i.a(e2, "BusLineSearch", "searchBusLine");
            throw new AMapException(e2.getErrorMessage());
        }
    }

    private boolean a(int i) {
        return i < this.e && i >= 0;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.b = onBusLineSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void searchBusLineAsyn() {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.au.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 3;
                        obtainMessage.what = 1000;
                        s.a aVar = new s.a();
                        obtainMessage.obj = aVar;
                        aVar.b = au.this.b;
                        aVar.a = au.this.searchBusLine();
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        au.this.g.sendMessage(obtainMessage);
                        throw th;
                    }
                    au.this.g.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setQuery(BusLineQuery busLineQuery) {
        if (!this.c.weakEquals(busLineQuery)) {
            this.c = busLineQuery;
            this.d = busLineQuery.clone();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineQuery getQuery() {
        return this.c;
    }
}
