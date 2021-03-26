package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import java.util.HashMap;

/* compiled from: DistrictSearchCore */
public final class ay implements IDistrictSearch {
    private static HashMap<Integer, DistrictResult> f;
    private Context a;
    private DistrictSearchQuery b;
    private DistrictSearch.OnDistrictSearchListener c;
    private DistrictSearchQuery d;
    private int e;
    private Handler g = s.a();

    public ay(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.b = districtSearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictResult searchDistrict() throws AMapException {
        DistrictResult districtResult;
        try {
            DistrictResult districtResult2 = new DistrictResult();
            q.a(this.a);
            boolean z = true;
            if (!(this.b != null)) {
                this.b = new DistrictSearchQuery();
            }
            districtResult2.setQuery(this.b.clone());
            if (!this.b.weakEquals(this.d)) {
                this.e = 0;
                this.d = this.b.clone();
                HashMap<Integer, DistrictResult> hashMap = f;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            if (this.e == 0) {
                districtResult = (DistrictResult) new k(this.a, this.b.clone()).b();
                if (districtResult == null) {
                    return districtResult;
                }
                this.e = districtResult.getPageCount();
                f = new HashMap<>();
                DistrictSearchQuery districtSearchQuery = this.b;
                if (districtSearchQuery != null) {
                    if (districtResult != null) {
                        int i = this.e;
                        if (i > 0 && i > districtSearchQuery.getPageNum()) {
                            f.put(Integer.valueOf(this.b.getPageNum()), districtResult);
                        }
                    }
                }
            } else {
                int pageNum = this.b.getPageNum();
                if (pageNum >= this.e || pageNum < 0) {
                    z = false;
                }
                if (z) {
                    districtResult = f.get(Integer.valueOf(pageNum));
                    if (districtResult == null) {
                        districtResult = (DistrictResult) new k(this.a, this.b.clone()).b();
                        DistrictSearchQuery districtSearchQuery2 = this.b;
                        if (districtSearchQuery2 != null) {
                            if (districtResult != null) {
                                int i2 = this.e;
                                if (i2 > 0 && i2 > districtSearchQuery2.getPageNum()) {
                                    f.put(Integer.valueOf(this.b.getPageNum()), districtResult);
                                }
                            }
                        }
                    }
                } else {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
            }
            return districtResult;
        } catch (AMapException e2) {
            i.a(e2, "DistrictSearch", "searchDistrict");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAsyn() {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.ay.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    DistrictResult districtResult = new DistrictResult();
                    districtResult.setQuery(ay.this.b);
                    try {
                        DistrictResult searchDistrict = ay.this.searchDistrict();
                        if (searchDistrict != null) {
                            searchDistrict.setAMapException(new AMapException());
                        }
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = ay.this.c;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("result", searchDistrict);
                        obtainMessage.setData(bundle);
                        if (ay.this.g != null) {
                            ay.this.g.sendMessage(obtainMessage);
                        }
                    } catch (AMapException e) {
                        districtResult.setAMapException(e);
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = ay.this.c;
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle2);
                        if (ay.this.g != null) {
                            ay.this.g.sendMessage(obtainMessage);
                        }
                    } catch (Throwable th) {
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = ay.this.c;
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle3);
                        if (ay.this.g != null) {
                            ay.this.g.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAnsy() {
        searchDistrictAsyn();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.c = onDistrictSearchListener;
    }
}
