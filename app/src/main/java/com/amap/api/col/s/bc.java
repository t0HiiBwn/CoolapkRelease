package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.s;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.HashMap;
import java.util.List;

/* compiled from: PoiSearchCore */
public final class bc implements IPoiSearch {
    private static HashMap<Integer, PoiResult> i;
    private PoiSearch.SearchBound a;
    private PoiSearch.Query b;
    private Context c;
    private PoiSearch.OnPoiSearchListener d;
    private String e = "zh-CN";
    private PoiSearch.Query f;
    private PoiSearch.SearchBound g;
    private int h;
    private Handler j = null;

    public bc(Context context, PoiSearch.Query query) {
        this.c = context.getApplicationContext();
        setQuery(query);
        this.j = s.a();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.e = "en";
        } else {
            this.e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final String getLanguage() {
        return this.e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        if (r0.getCenter() == null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b7, code lost:
        if (r1.getLongitude() < r0.getLongitude()) goto L_0x00ba;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01d2  */
    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiResult searchPOI() throws AMapException {
        boolean z;
        int i2;
        try {
            q.a(this.c);
            PoiSearch.SearchBound bound = getBound();
            boolean z2 = true;
            if (!(bound != null && bound.getShape().equals("Bound"))) {
                PoiSearch.Query query = this.b;
                if (!(query != null && (!i.a(query.getQueryString()) || !i.a(this.b.getCategory())))) {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
            }
            PoiSearch.SearchBound bound2 = getBound();
            if (bound2 != null) {
                if (!bound2.getShape().equals("Bound")) {
                    if (bound2.getShape().equals("Polygon")) {
                        List<LatLonPoint> polyGonList = bound2.getPolyGonList();
                        if (polyGonList != null && polyGonList.size() != 0) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= polyGonList.size()) {
                                    break;
                                } else if (polyGonList.get(i3) == null) {
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                        }
                    } else if (bound2.getShape().equals("Rectangle")) {
                        LatLonPoint lowerLeft = bound2.getLowerLeft();
                        LatLonPoint upperRight = bound2.getUpperRight();
                        if (lowerLeft != null) {
                            if (upperRight != null) {
                                if (lowerLeft.getLatitude() < upperRight.getLatitude()) {
                                }
                            }
                        }
                    }
                }
                z = false;
                if (!z) {
                    PoiSearch.Query query2 = this.b;
                    if (query2 != null) {
                        if ((!query2.queryEquals(this.f) && this.a == null) || (!this.b.queryEquals(this.f) && !this.a.equals(this.g))) {
                            this.h = 0;
                            this.f = this.b.clone();
                            PoiSearch.SearchBound searchBound = this.a;
                            if (searchBound != null) {
                                this.g = searchBound.clone();
                            }
                            HashMap<Integer, PoiResult> hashMap = i;
                            if (hashMap != null) {
                                hashMap.clear();
                            }
                        }
                        PoiSearch.SearchBound searchBound2 = null;
                        PoiSearch.SearchBound searchBound3 = this.a;
                        if (searchBound3 != null) {
                            searchBound2 = searchBound3.clone();
                        }
                        ag.a().a(this.b.getQueryString());
                        this.b.setPageNum(ag.a().a(this.b.getPageNum()));
                        this.b.setPageSize(ag.a().b(this.b.getPageSize()));
                        if (this.h == 0) {
                            PoiResult poiResult = (PoiResult) new y(this.c, new ab(this.b.clone(), searchBound2)).b();
                            i = new HashMap<>();
                            PoiSearch.Query query3 = this.b;
                            if (query3 == null || poiResult == null || (i2 = this.h) <= 0 || i2 <= query3.getPageNum()) {
                                return poiResult;
                            }
                            i.put(Integer.valueOf(this.b.getPageNum()), poiResult);
                            return poiResult;
                        }
                        int pageNum = this.b.getPageNum();
                        if (pageNum > this.h || pageNum < 0) {
                            z2 = false;
                        }
                        if (z2) {
                            PoiResult poiResult2 = i.get(Integer.valueOf(pageNum));
                            if (poiResult2 != null) {
                                return poiResult2;
                            }
                            PoiResult poiResult3 = (PoiResult) new y(this.c, new ab(this.b.clone(), searchBound2)).b();
                            i.put(Integer.valueOf(this.b.getPageNum()), poiResult3);
                            return poiResult3;
                        }
                        throw new IllegalArgumentException("page out of range");
                    }
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            z = true;
            if (!z) {
            }
        } catch (AMapException e2) {
            i.a(e2, "PoiSearch", "searchPOI");
            throw new AMapException(e2.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIAsyn() {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.bc.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    s.h hVar;
                    Message obtainMessage = bc.this.j.obtainMessage();
                    obtainMessage.arg1 = 6;
                    obtainMessage.what = 600;
                    Bundle bundle = new Bundle();
                    PoiResult poiResult = null;
                    try {
                        poiResult = bc.this.searchPOI();
                        bundle.putInt("errorCode", 1000);
                        hVar = new s.h();
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                        hVar = new s.h();
                    } catch (Throwable th) {
                        s.h hVar2 = new s.h();
                        hVar2.b = bc.this.d;
                        hVar2.a = poiResult;
                        obtainMessage.obj = hVar2;
                        obtainMessage.setData(bundle);
                        bc.this.j.sendMessage(obtainMessage);
                        throw th;
                    }
                    hVar.b = bc.this.d;
                    hVar.a = poiResult;
                    obtainMessage.obj = hVar;
                    obtainMessage.setData(bundle);
                    bc.this.j.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiItem searchPOIId(String str) throws AMapException {
        q.a(this.c);
        PoiSearch.Query query = this.b;
        return (PoiItem) new x(this.c, str, query != null ? query.clone() : null).b();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIIdAsyn(final String str) {
        an.a().a(new Runnable() {
            /* class com.amap.api.col.s.bc.AnonymousClass2 */

            @Override // java.lang.Runnable
            public final void run() {
                s.g gVar;
                Message obtainMessage = s.a().obtainMessage();
                obtainMessage.arg1 = 6;
                obtainMessage.what = 602;
                Bundle bundle = new Bundle();
                PoiItem poiItem = null;
                try {
                    poiItem = bc.this.searchPOIId(str);
                    bundle.putInt("errorCode", 1000);
                    gVar = new s.g();
                } catch (AMapException e) {
                    i.a(e, "PoiSearch", "searchPOIIdAsyn");
                    bundle.putInt("errorCode", e.getErrorCode());
                    gVar = new s.g();
                } catch (Throwable th) {
                    s.g gVar2 = new s.g();
                    gVar2.b = bc.this.d;
                    gVar2.a = poiItem;
                    obtainMessage.obj = gVar2;
                    obtainMessage.setData(bundle);
                    bc.this.j.sendMessage(obtainMessage);
                    throw th;
                }
                gVar.b = bc.this.d;
                gVar.a = poiItem;
                obtainMessage.obj = gVar;
                obtainMessage.setData(bundle);
                bc.this.j.sendMessage(obtainMessage);
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setQuery(PoiSearch.Query query) {
        this.b = query;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setBound(PoiSearch.SearchBound searchBound) {
        this.a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.Query getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.SearchBound getBound() {
        return this.a;
    }
}
