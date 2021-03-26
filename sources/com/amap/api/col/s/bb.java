package com.amap.api.col.s;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.s.s;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* compiled from: NearbySearchCore */
public final class bb implements INearbySearch {
    private static long e;
    private List<NearbySearch.NearbyListener> a = new ArrayList();
    private String b;
    private Context c;
    private s d;
    private ExecutorService f;
    private LatLonPoint g = null;
    private String h = null;
    private boolean i = false;
    private Timer j = new Timer();
    private UploadInfoCallback k;

    /* renamed from: l  reason: collision with root package name */
    private TimerTask f1200l;

    public bb(Context context) {
        this.c = context.getApplicationContext();
        this.d = s.a();
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void addNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        try {
            this.a.add(nearbyListener);
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "addNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void removeNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        if (nearbyListener != null) {
            try {
                this.a.remove(nearbyListener);
            } catch (Throwable th) {
                i.a(th, "NearbySearch", "removeNearbyListener");
            }
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void clearUserInfoAsyn() {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.bb.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = bb.this.d.obtainMessage();
                    obtainMessage.arg1 = 8;
                    obtainMessage.obj = bb.this.a;
                    try {
                        bb.this.a();
                        obtainMessage.what = 1000;
                        if (bb.this.d == null) {
                            return;
                        }
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                        i.a(e, "NearbySearch", "clearUserInfoAsyn");
                        if (bb.this.d == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        if (bb.this.d != null) {
                            bb.this.d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                    bb.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    /* access modifiers changed from: private */
    public int a() throws AMapException {
        try {
            if (this.i) {
                throw new AMapException("已开启自动上传");
            } else if (a(this.b)) {
                q.a(this.c);
                return ((Integer) new t(this.c, this.b).b()).intValue();
            } else {
                throw new AMapException("USERID非法");
            }
        } catch (AMapException e2) {
            throw e2;
        } catch (Throwable unused) {
            throw new AMapException("未知错误");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void setUserID(String str) {
        this.b = str;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i2) {
        TimerTask timerTask;
        if (i2 < 7000) {
            i2 = 7000;
        }
        try {
            this.k = uploadInfoCallback;
            if (this.i && (timerTask = this.f1200l) != null) {
                timerTask.cancel();
            }
            this.i = true;
            a aVar = new a(this, (byte) 0);
            this.f1200l = aVar;
            this.j.schedule(aVar, 0, (long) i2);
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "startUploadNearbyInfoAuto");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void stopUploadNearbyInfoAuto() {
        try {
            TimerTask timerTask = this.f1200l;
            if (timerTask != null) {
                timerTask.cancel();
            }
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "stopUploadNearbyInfoAuto");
        }
        this.i = false;
        this.f1200l = null;
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find();
    }

    /* access modifiers changed from: private */
    public int a(UploadInfo uploadInfo) {
        try {
            q.a(this.c);
            if (uploadInfo == null) {
                return 2202;
            }
            long time = new Date().getTime();
            if (time - e < 6500) {
                return 2203;
            }
            e = time;
            String userID = uploadInfo.getUserID();
            if (!a(userID)) {
                return 2201;
            }
            if (TextUtils.isEmpty(this.h)) {
                this.h = userID;
            }
            if (!userID.equals(this.h)) {
                return 2201;
            }
            LatLonPoint point = uploadInfo.getPoint();
            if (point == null) {
                return 2204;
            }
            if (point.equals(this.g)) {
                return 2204;
            }
            new v(this.c, uploadInfo).b();
            this.g = point.copy();
            return 1000;
        } catch (AMapException e2) {
            return e2.getErrorCode();
        } catch (Throwable unused) {
            return 1900;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void uploadNearbyInfoAsyn(final UploadInfo uploadInfo) {
        if (this.f == null) {
            this.f = Executors.newSingleThreadExecutor();
        }
        this.f.submit(new Runnable() {
            /* class com.amap.api.col.s.bb.AnonymousClass2 */

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Message obtainMessage = bb.this.d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = bb.this.a;
                    obtainMessage.what = bb.a(bb.this, uploadInfo);
                    bb.this.d.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    i.a(th, "NearbySearch", "uploadNearbyInfoAsyn");
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void searchNearbyInfoAsyn(final NearbySearch.NearbyQuery nearbyQuery) {
        try {
            an.a().a(new Runnable() {
                /* class com.amap.api.col.s.bb.AnonymousClass3 */

                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = bb.this.d.obtainMessage();
                    obtainMessage.arg1 = 9;
                    s.f fVar = new s.f();
                    fVar.a = bb.this.a;
                    obtainMessage.obj = fVar;
                    try {
                        fVar.b = bb.this.searchNearbyInfo(nearbyQuery);
                        obtainMessage.what = 1000;
                        if (bb.this.d == null) {
                            return;
                        }
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                        i.a(e, "NearbySearch", "searchNearbyInfoAsyn");
                        if (bb.this.d == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        if (bb.this.d != null) {
                            bb.this.d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                    bb.this.d.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException {
        try {
            q.a(this.c);
            boolean z = false;
            if (nearbyQuery != null) {
                if (nearbyQuery.getCenterPoint() != null) {
                    z = true;
                }
            }
            if (z) {
                return (NearbySearchResult) new u(this.c, nearbyQuery).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            throw e2;
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "searchNearbyInfo");
            throw new AMapException("未知错误");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void destroy() {
        try {
            this.j.cancel();
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "destryoy");
        }
    }

    /* compiled from: NearbySearchCore */
    private class a extends TimerTask {
        private a() {
        }

        /* synthetic */ a(bb bbVar, byte b) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            try {
                if (bb.this.k != null) {
                    int a2 = bb.this.a(bb.this.k.OnUploadInfoCallback());
                    Message obtainMessage = bb.this.d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = bb.this.a;
                    obtainMessage.what = a2;
                    bb.this.d.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                i.a(th, "NearbySearch", "UpdateDataTask");
            }
        }
    }

    static /* synthetic */ int a(bb bbVar, UploadInfo uploadInfo) {
        if (bbVar.i) {
            return 2200;
        }
        return bbVar.a(uploadInfo);
    }
}
