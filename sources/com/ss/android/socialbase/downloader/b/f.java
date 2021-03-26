package com.ss.android.socialbase.downloader.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.b.b;
import com.ss.android.socialbase.downloader.b.c;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.f.i;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: SqlDownloadCacheAidlWrapper */
public class f implements ServiceConnection, r {
    private static boolean b;
    private static int c;
    private static long d;
    private c a;
    private Handler e = new Handler(Looper.getMainLooper());
    private b f = null;
    private a g;
    private Runnable h = new Runnable() {
        /* class com.ss.android.socialbase.downloader.b.f.AnonymousClass1 */

        @Override // java.lang.Runnable
        public void run() {
            if (!f.b && f.this.g != null) {
                f.this.g.a();
            }
        }
    };
    private Future<?> i;
    private CountDownLatch j = new CountDownLatch(1);

    /* compiled from: SqlDownloadCacheAidlWrapper */
    public interface a {
        void a();
    }

    /* renamed from: a */
    public ArrayList<i> n(int i2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean a(int i2, Map<Long, i> map) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public Map<Long, i> l(int i2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void m(int i2) {
    }

    public f() {
        SqlDownloadCacheService.a(b.L(), this);
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        b = true;
        this.e.removeCallbacks(this.h);
        try {
            this.a = c.a.a(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.i = b.l().submit(new Runnable() {
            /* class com.ss.android.socialbase.downloader.b.f.AnonymousClass2 */

            /* JADX INFO: finally extract failed */
            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinder;
                AnonymousClass1 r2;
                synchronized (this) {
                    try {
                        if (!(f.this.f == null || f.this.a == null)) {
                            f.this.a.a(f.this.f);
                        }
                        f.this.j.countDown();
                        try {
                            iBinder = iBinder;
                            r2 = new IBinder.DeathRecipient() {
                                /* class com.ss.android.socialbase.downloader.b.f.AnonymousClass2.AnonymousClass1 */

                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = f.b = false;
                                    if (!f.this.f() && f.this.g != null) {
                                        f.this.e.postDelayed(f.this.h, 2000);
                                    }
                                }
                            };
                            iBinder.linkToDeath(r2, 0);
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th) {
                        f.this.j.countDown();
                        try {
                            iBinder.linkToDeath(new IBinder.DeathRecipient() {
                                /* class com.ss.android.socialbase.downloader.b.f.AnonymousClass2.AnonymousClass1 */

                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = f.b = false;
                                    if (!f.this.f() && f.this.g != null) {
                                        f.this.e.postDelayed(f.this.h, 2000);
                                    }
                                }
                            }, 0);
                        } catch (Throwable unused2) {
                        }
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a = null;
        b = false;
    }

    /* access modifiers changed from: private */
    public boolean f() {
        if (Build.VERSION.SDK_INT >= 26 || b) {
            return false;
        }
        if (c > 5) {
            com.ss.android.socialbase.downloader.c.a.d("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - d < 15000) {
            com.ss.android.socialbase.downloader.c.a.d("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        c++;
        d = currentTimeMillis;
        this.e.postDelayed(new Runnable() {
            /* class com.ss.android.socialbase.downloader.b.f.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCacheService.a(b.L(), f.this);
            }
        }, 1000);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.r
    public void a(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2, final d dVar) {
        b.l().submit(new Runnable() {
            /* class com.ss.android.socialbase.downloader.b.f.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                d dVar;
                Future future;
                f.this.a(new b.a() {
                    /* class com.ss.android.socialbase.downloader.b.f.AnonymousClass4.AnonymousClass1 */

                    @Override // com.ss.android.socialbase.downloader.b.b
                    public void a(Map map, Map map2) {
                        e.a(sparseArray, map);
                        e.a(sparseArray2, map2);
                        dVar.a();
                        f.this.a((b) null);
                    }
                });
                try {
                    z = !f.this.j.await(5000, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                    z = false;
                }
                if (z && (future = f.this.i) != null) {
                    future.cancel(true);
                }
                f.this.a();
                if (z && (dVar = dVar) != null) {
                    dVar.a();
                }
            }
        });
    }

    public void a(b bVar) {
        synchronized (this) {
            c cVar = this.a;
            if (cVar != null) {
                try {
                    cVar.a(bVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else {
                this.f = bVar;
            }
        }
    }

    public void a() {
        try {
            c cVar = this.a;
            if (cVar != null) {
                cVar.a();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo b(int i2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.b(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> a(String str) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.a(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> b(String str) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.b(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> c(String str) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.c(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> d(String str) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.d(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.c(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void d(int i2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                cVar.d(i2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                cVar.a(bVar);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                cVar.b(bVar);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3, long j2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                cVar.a(i2, i3, j2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3, int i4, long j2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                cVar.a(i2, i3, i4, j2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3, int i4, int i5) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                cVar.a(i2, i3, i4, i5);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo a(int i2, int i3) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.a(i2, i3);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean a(DownloadInfo downloadInfo) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.a(downloadInfo);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean e(int i2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.e(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean f(int i2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.f(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b() {
        try {
            c cVar = this.a;
            if (cVar != null) {
                cVar.b();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo g(int i2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.g(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.a(i2, j2, str, str2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo a(int i2, long j2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.a(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo b(int i2, long j2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.b(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo h(int i2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.h(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo c(int i2, long j2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.c(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo d(int i2, long j2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.d(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo i(int i2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.i(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo j(int i2) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.j(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean c() {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.c();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean d() {
        try {
            c cVar = this.a;
            if (cVar != null) {
                return cVar.d();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(DownloadInfo downloadInfo) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                cVar.b(downloadInfo);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                cVar.a(i2, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            c cVar = this.a;
            if (cVar != null) {
                cVar.b(i2, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
