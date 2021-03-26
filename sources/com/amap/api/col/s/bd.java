package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.s;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* compiled from: RoutePOISearchCore */
public final class bd implements IRoutePOISearch {
    private RoutePOISearchQuery a;
    private Context b;
    private RoutePOISearch.OnRoutePOISearchListener c;
    private Handler d = null;

    public bd(Context context, RoutePOISearchQuery routePOISearchQuery) {
        this.b = context;
        this.a = routePOISearchQuery;
        this.d = s.a();
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.c = onRoutePOISearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void searchRoutePOIAsyn() {
        an.a().a(new Runnable() {
            /* class com.amap.api.col.s.bd.AnonymousClass1 */

            @Override // java.lang.Runnable
            public final void run() {
                s.j jVar;
                Message obtainMessage = bd.this.d.obtainMessage();
                obtainMessage.arg1 = 14;
                Bundle bundle = new Bundle();
                RoutePOISearchResult routePOISearchResult = null;
                try {
                    routePOISearchResult = bd.this.searchRoutePOI();
                    bundle.putInt("errorCode", 1000);
                    jVar = new s.j();
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                    jVar = new s.j();
                } catch (Throwable th) {
                    s.j jVar2 = new s.j();
                    jVar2.b = bd.this.c;
                    jVar2.a = routePOISearchResult;
                    obtainMessage.obj = jVar2;
                    obtainMessage.setData(bundle);
                    bd.this.d.sendMessage(obtainMessage);
                    throw th;
                }
                jVar.b = bd.this.c;
                jVar.a = routePOISearchResult;
                obtainMessage.obj = jVar;
                obtainMessage.setData(bundle);
                bd.this.d.sendMessage(obtainMessage);
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        this.a = routePOISearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchQuery getQuery() {
        return this.a;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchResult searchRoutePOI() throws AMapException {
        try {
            q.a(this.b);
            RoutePOISearchQuery routePOISearchQuery = this.a;
            boolean z = false;
            if (routePOISearchQuery != null) {
                if (routePOISearchQuery.getSearchType() != null) {
                    if (this.a.getFrom() != null || this.a.getTo() != null || this.a.getPolylines() != null) {
                        z = true;
                    }
                }
            }
            if (z) {
                return (RoutePOISearchResult) new aj(this.b, this.a.clone()).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            i.a(e, "RoutePOISearchCore", "searchRoutePOI");
            throw e;
        }
    }
}
