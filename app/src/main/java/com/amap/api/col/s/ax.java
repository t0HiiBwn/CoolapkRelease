package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistanceSearch;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;

/* compiled from: DistanceSearchCore */
public class ax implements IDistanceSearch {
    private static final String a = "ax";
    private Context b;
    private Handler c = s.a();
    private DistanceSearch.OnDistanceSearchListener d;

    public ax(Context context) {
        this.b = context.getApplicationContext();
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery distanceQuery) throws AMapException {
        try {
            q.a(this.b);
            if (distanceQuery != null) {
                boolean z = true;
                if (!(distanceQuery.getDestination() == null || distanceQuery.getOrigins() == null || distanceQuery.getOrigins().size() <= 0)) {
                    z = false;
                }
                if (!z) {
                    DistanceSearch.DistanceQuery clone = distanceQuery.clone();
                    DistanceResult distanceResult = (DistanceResult) new j(this.b, clone).b();
                    if (distanceResult != null) {
                        distanceResult.setDistanceQuery(clone);
                    }
                    return distanceResult;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            i.a(e, a, "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void calculateRouteDistanceAsyn(final DistanceSearch.DistanceQuery distanceQuery) {
        an.a().a(new Runnable() {
            /* class com.amap.api.col.s.ax.AnonymousClass1 */

            @Override // java.lang.Runnable
            public final void run() {
                Message obtainMessage = s.a().obtainMessage();
                obtainMessage.what = 400;
                obtainMessage.arg1 = 16;
                Bundle bundle = new Bundle();
                DistanceResult distanceResult = null;
                try {
                    distanceResult = ax.this.calculateRouteDistance(distanceQuery);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                } catch (Throwable th) {
                    obtainMessage.obj = ax.this.d;
                    bundle.putParcelable("result", distanceResult);
                    obtainMessage.setData(bundle);
                    ax.this.c.sendMessage(obtainMessage);
                    throw th;
                }
                obtainMessage.obj = ax.this.d;
                bundle.putParcelable("result", distanceResult);
                obtainMessage.setData(bundle);
                ax.this.c.sendMessage(obtainMessage);
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener onDistanceSearchListener) {
        this.d = onDistanceSearchListener;
    }
}
