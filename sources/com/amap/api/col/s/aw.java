package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.s;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.HashMap;
import java.util.List;

/* compiled from: CloudSearchCore */
public final class aw implements ICloudSearch {
    private Context a;
    private CloudSearch.OnCloudSearchListener b;
    private CloudSearch.Query c;
    private int d;
    private HashMap<Integer, CloudResult> e;
    private Handler f = s.a();

    public aw(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.b = onCloudSearchListener;
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudAsyn(final CloudSearch.Query query) {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.aw.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 12;
                        obtainMessage.what = 700;
                        s.d dVar = new s.d();
                        dVar.b = aw.this.b;
                        obtainMessage.obj = dVar;
                        dVar.a = aw.this.a(query);
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        aw.this.f.sendMessage(obtainMessage);
                        throw th;
                    }
                    aw.this.f.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public CloudItemDetail a(String str, String str2) throws AMapException {
        if (str == null || str.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } else if (str2 == null || str2.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } else {
            try {
                return (CloudItemDetail) new f(this.a, new aa(str, str2)).b();
            } catch (Throwable th) {
                i.a(th, "CloudSearch", "searchCloudDetail");
                if (!(th instanceof AMapException)) {
                    th.printStackTrace();
                    return null;
                }
                throw th;
            }
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudDetailAsyn(final String str, final String str2) {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.aw.AnonymousClass2 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = s.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 12;
                        obtainMessage.what = 701;
                        s.c cVar = new s.c();
                        cVar.b = aw.this.b;
                        obtainMessage.obj = cVar;
                        cVar.a = aw.this.a(str, str2);
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        aw.this.f.sendMessage(obtainMessage);
                        throw th;
                    }
                    aw.this.f.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b1 A[Catch:{ all -> 0x013b }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014c  */
    public CloudResult a(CloudSearch.Query query) throws AMapException {
        AMapException th;
        boolean z;
        boolean z2 = true;
        CloudResult cloudResult = null;
        if (query != null) {
            try {
                if (!i.a(query.getTableID())) {
                    if (query.getBound() != null) {
                        if (query.getBound() == null || !query.getBound().getShape().equals("Bound") || query.getBound().getCenter() != null) {
                            if (query.getBound() != null && query.getBound().getShape().equals("Rectangle")) {
                                LatLonPoint lowerLeft = query.getBound().getLowerLeft();
                                LatLonPoint upperRight = query.getBound().getUpperRight();
                                if (lowerLeft != null) {
                                    if (upperRight != null) {
                                        if (lowerLeft.getLatitude() < upperRight.getLatitude()) {
                                            if (lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                                            }
                                        }
                                    }
                                }
                            }
                            if (query.getBound() != null && query.getBound().getShape().equals("Polygon")) {
                                List<LatLonPoint> polyGonList = query.getBound().getPolyGonList();
                                for (int i = 0; i < polyGonList.size(); i++) {
                                    if (polyGonList.get(i) != null) {
                                    }
                                }
                            }
                            z = true;
                            if (!z) {
                                if (!query.queryEquals(this.c)) {
                                    this.d = 0;
                                    this.c = query.clone();
                                    HashMap<Integer, CloudResult> hashMap = this.e;
                                    if (hashMap != null) {
                                        hashMap.clear();
                                    }
                                }
                                if (this.d == 0) {
                                    CloudResult cloudResult2 = (CloudResult) new g(this.a, query).b();
                                    try {
                                        HashMap<Integer, CloudResult> hashMap2 = new HashMap<>();
                                        this.e = hashMap2;
                                        if (this.d <= 0) {
                                            return cloudResult2;
                                        }
                                        hashMap2.put(Integer.valueOf(query.getPageNum()), cloudResult2);
                                        return cloudResult2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cloudResult = cloudResult2;
                                        i.a(th, "CloudSearch", "searchCloud");
                                        if (th instanceof AMapException) {
                                            th.printStackTrace();
                                            return cloudResult;
                                        }
                                        throw th;
                                    }
                                } else {
                                    int pageNum = query.getPageNum();
                                    if (pageNum > this.d || pageNum <= 0) {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        CloudResult cloudResult3 = this.e.get(Integer.valueOf(pageNum));
                                        if (cloudResult3 != null) {
                                            return cloudResult3;
                                        }
                                        cloudResult = (CloudResult) new g(this.a, query).b();
                                        this.e.put(Integer.valueOf(query.getPageNum()), cloudResult);
                                        return cloudResult;
                                    }
                                    throw new IllegalArgumentException("page out of range");
                                }
                            } else {
                                throw new AMapException("无效的参数 - IllegalArgumentException");
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                i.a(th, "CloudSearch", "searchCloud");
                if (th instanceof AMapException) {
                }
            }
        }
        z = false;
        if (!z) {
        }
    }
}
