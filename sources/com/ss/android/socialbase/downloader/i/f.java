package com.ss.android.socialbase.downloader.i;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.g;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.al;
import com.ss.android.socialbase.downloader.depend.c;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.s;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IPCUtils */
public class f {
    private static Handler a = new Handler(Looper.getMainLooper());

    public static a a(final DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new a.AbstractBinderC0122a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass1 */

            @Override // com.ss.android.socialbase.downloader.model.a
            public DownloadInfo a() throws RemoteException {
                return downloadTask.getDownloadInfo();
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public e b() throws RemoteException {
                return f.a(downloadTask.getChunkStrategy());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public i b(int i) throws RemoteException {
                return f.a(downloadTask.getSingleDownloadListener(e.e(i)), i != g.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int a(int i) throws RemoteException {
                return downloadTask.getDownloadListenerSize(e.e(i));
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public i a(int i, int i2) throws RemoteException {
                return f.a(downloadTask.getDownloadListenerByIndex(e.e(i), i2), i != g.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public aa c() throws RemoteException {
                return f.a(downloadTask.getNotificationEventListener());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ag d() throws RemoteException {
                return f.a(downloadTask.getNotificationClickCallback());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public h e() throws RemoteException {
                return f.a(downloadTask.getInterceptor());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.f f() throws RemoteException {
                return f.a(downloadTask.getDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public j j() throws RemoteException {
                return f.a(downloadTask.getMonitorDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public v g() throws RemoteException {
                return f.a(downloadTask.getForbiddenHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public ai h() throws RemoteException {
                return f.a(downloadTask.getRetryDelayTimeCalculator());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public p i() throws RemoteException {
                return f.a(downloadTask.getDiskSpaceHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public com.ss.android.socialbase.downloader.depend.g k() throws RemoteException {
                return f.a(downloadTask.getFileUriProvider());
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public int l() throws RemoteException {
                return downloadTask.getDownloadCompleteHandlers().size();
            }

            @Override // com.ss.android.socialbase.downloader.model.a
            public l c(int i) throws RemoteException {
                return f.a(downloadTask.getDownloadCompleteHandlerByIndex(i));
            }
        };
    }

    public static i a(final IDownloadListener iDownloadListener, final boolean z) {
        if (iDownloadListener == null) {
            return null;
        }
        return new i.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass12 */

            @Override // com.ss.android.socialbase.downloader.depend.i
            public int a() throws RemoteException {
                return iDownloadListener.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void a(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.a.post(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass12.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPrepare(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void b(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.a.post(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass12.AnonymousClass5 */

                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void c(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.a.post(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass12.AnonymousClass6 */

                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onProgress(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onProgress(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void d(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.a.post(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass12.AnonymousClass7 */

                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPause(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPause(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void e(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.a.post(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass12.AnonymousClass8 */

                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onSuccessed(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void a(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    f.a.post(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass12.AnonymousClass9 */

                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFailed(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onFailed(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void f(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.a.post(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass12.AnonymousClass10 */

                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onCanceled(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void g(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.a.post(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass12.AnonymousClass11 */

                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void h(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    f.a.post(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass12.AnonymousClass12 */

                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstSuccess(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void b(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    f.a.post(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass12.AnonymousClass2 */

                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetry(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void c(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    f.a.post(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass12.AnonymousClass3 */

                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetryDelay(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public void i(final DownloadInfo downloadInfo) throws RemoteException {
                IDownloadListener iDownloadListener = iDownloadListener;
                if (!(iDownloadListener instanceof s)) {
                    return;
                }
                if (z) {
                    f.a.post(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass12.AnonymousClass4 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ((s) iDownloadListener).a(downloadInfo);
                        }
                    });
                } else {
                    ((s) iDownloadListener).a(downloadInfo);
                }
            }
        };
    }

    public static aa a(final ab abVar) {
        if (abVar == null) {
            return null;
        }
        return new aa.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass23 */

            @Override // com.ss.android.socialbase.downloader.depend.aa
            public void a(int i, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                abVar.a(i, downloadInfo, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.depend.aa
            public boolean a(boolean z) throws RemoteException {
                return abVar.a(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.aa
            public String a() throws RemoteException {
                return abVar.a();
            }
        };
    }

    public static ag a(final ah ahVar) {
        if (ahVar == null) {
            return null;
        }
        return new ag.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass26 */

            @Override // com.ss.android.socialbase.downloader.depend.ag
            public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                return ahVar.a(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.ag
            public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                return ahVar.b(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.ag
            public boolean c(DownloadInfo downloadInfo) throws RemoteException {
                return ahVar.c(downloadInfo);
            }
        };
    }

    public static ai a(final q qVar) {
        if (qVar == null) {
            return null;
        }
        return new ai.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass27 */

            @Override // com.ss.android.socialbase.downloader.depend.ai
            public long a(int i, int i2) throws RemoteException {
                return qVar.a(i, i2);
            }
        };
    }

    public static v a(final x xVar) {
        if (xVar == null) {
            return null;
        }
        return new v.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass28 */

            @Override // com.ss.android.socialbase.downloader.depend.v
            public boolean a(u uVar) throws RemoteException {
                return xVar.a(f.a(uVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.g a(final t tVar) {
        if (tVar == null) {
            return null;
        }
        return new g.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass29 */

            @Override // com.ss.android.socialbase.downloader.depend.g
            public Uri a(String str, String str2) throws RemoteException {
                return tVar.a(str, str2);
            }
        };
    }

    public static w a(final u uVar) {
        if (uVar == null) {
            return null;
        }
        return new w() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass30 */

            @Override // com.ss.android.socialbase.downloader.depend.w
            public void a(List<String> list) {
                try {
                    uVar.a(list);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.w
            public boolean a() {
                try {
                    return uVar.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static p a(final r rVar) {
        if (rVar == null) {
            return null;
        }
        return new p.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass31 */

            @Override // com.ss.android.socialbase.downloader.depend.p
            public boolean a(long j, long j2, o oVar) throws RemoteException {
                return rVar.a(j, j2, f.a(oVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.q a(final o oVar) {
        if (oVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.q() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass2 */

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void a() {
                try {
                    oVar.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.f a(final n nVar) {
        if (nVar == null) {
            return null;
        }
        return new f.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass3 */

            @Override // com.ss.android.socialbase.downloader.depend.f
            public void a(DownloadInfo downloadInfo, BaseException baseException, int i) throws RemoteException {
                nVar.a(downloadInfo, baseException, i);
            }
        };
    }

    public static j a(final z zVar) {
        if (zVar == null) {
            return null;
        }
        return new j.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass4 */

            @Override // com.ss.android.socialbase.downloader.depend.j
            public void a(String str) throws RemoteException {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        zVar.a(new JSONObject(str));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public String a() throws RemoteException {
                return zVar.b();
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public int[] b() throws RemoteException {
                z zVar = zVar;
                if (zVar instanceof c) {
                    return ((c) zVar).a();
                }
                return null;
            }
        };
    }

    public static e a(final com.ss.android.socialbase.downloader.downloader.g gVar) {
        if (gVar == null) {
            return null;
        }
        return new e.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass5 */

            @Override // com.ss.android.socialbase.downloader.depend.e
            public int a(long j) throws RemoteException {
                return gVar.a(j);
            }
        };
    }

    public static h a(final y yVar) {
        if (yVar == null) {
            return null;
        }
        return new h.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass6 */

            @Override // com.ss.android.socialbase.downloader.depend.h
            public boolean a() throws RemoteException {
                return yVar.a();
            }
        };
    }

    public static DownloadTask a(a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(aVar.a());
            downloadTask.chunkStategy(a(aVar.b())).notificationEventListener(a(aVar.c())).interceptor(a(aVar.e())).depend(a(aVar.f())).monitorDepend(a(aVar.j())).forbiddenHandler(a(aVar.g())).diskSpaceHandler(a(aVar.i())).fileUriProvider(a(aVar.k())).notificationClickCallback(a(aVar.d())).retryDelayTimeCalculator(a(aVar.h()));
            i b = aVar.b(com.ss.android.socialbase.downloader.constants.g.MAIN.ordinal());
            if (b != null) {
                downloadTask.mainThreadListenerWithHashCode(b.hashCode(), a(b));
            }
            i b2 = aVar.b(com.ss.android.socialbase.downloader.constants.g.SUB.ordinal());
            if (b2 != null) {
                downloadTask.subThreadListenerWithHashCode(b2.hashCode(), a(b2));
            }
            i b3 = aVar.b(com.ss.android.socialbase.downloader.constants.g.NOTIFICATION.ordinal());
            if (b3 != null) {
                downloadTask.notificationListenerWithHashCode(b3.hashCode(), a(b3));
            }
            a(downloadTask, aVar, com.ss.android.socialbase.downloader.constants.g.MAIN);
            a(downloadTask, aVar, com.ss.android.socialbase.downloader.constants.g.SUB);
            a(downloadTask, aVar, com.ss.android.socialbase.downloader.constants.g.NOTIFICATION);
            a(downloadTask, aVar);
            return downloadTask;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void a(DownloadTask downloadTask, a aVar, com.ss.android.socialbase.downloader.constants.g gVar) throws RemoteException {
        SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
        for (int i = 0; i < aVar.a(gVar.ordinal()); i++) {
            i a2 = aVar.a(gVar.ordinal(), i);
            if (a2 != null) {
                sparseArray.put(a2.a(), a(a2));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, gVar);
    }

    private static void a(DownloadTask downloadTask, a aVar) throws RemoteException {
        for (int i = 0; i < aVar.l(); i++) {
            l c = aVar.c(i);
            if (c != null) {
                downloadTask.addDownloadCompleteHandler(a(c));
            }
        }
    }

    public static ab a(final aa aaVar) {
        if (aaVar == null) {
            return null;
        }
        return new ab() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass7 */

            @Override // com.ss.android.socialbase.downloader.depend.ab
            public void a(int i, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    aaVar.a(i, downloadInfo, str, str2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ab
            public boolean a(boolean z) {
                try {
                    return aaVar.a(z);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ab
            public String a() {
                try {
                    return aaVar.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static m a(final l lVar) {
        if (lVar == null) {
            return null;
        }
        return new m() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass8 */

            @Override // com.ss.android.socialbase.downloader.depend.m
            public void a(DownloadInfo downloadInfo) throws BaseException {
                try {
                    lVar.a(downloadInfo);
                } catch (RemoteException e) {
                    throw new BaseException(1008, e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.m
            public boolean b(DownloadInfo downloadInfo) {
                try {
                    return lVar.b(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static l a(final m mVar) {
        if (mVar == null) {
            return null;
        }
        return new l.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass9 */

            @Override // com.ss.android.socialbase.downloader.depend.l
            public void a(DownloadInfo downloadInfo) throws RemoteException {
                try {
                    mVar.a(downloadInfo);
                } catch (BaseException e) {
                    throw new IllegalArgumentException(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.l
            public boolean b(DownloadInfo downloadInfo) throws RemoteException {
                return mVar.b(downloadInfo);
            }
        };
    }

    public static ah a(final ag agVar) {
        if (agVar == null) {
            return null;
        }
        return new ah() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass10 */

            @Override // com.ss.android.socialbase.downloader.depend.ah
            public boolean a(DownloadInfo downloadInfo) {
                try {
                    return agVar.a(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ah
            public boolean b(DownloadInfo downloadInfo) {
                try {
                    return agVar.b(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ah
            public boolean c(DownloadInfo downloadInfo) {
                try {
                    return agVar.c(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.g a(final e eVar) {
        if (eVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.g() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass11 */

            @Override // com.ss.android.socialbase.downloader.downloader.g
            public int a(long j) {
                try {
                    return eVar.a(j);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        };
    }

    public static n a(final com.ss.android.socialbase.downloader.depend.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new n() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass13 */

            @Override // com.ss.android.socialbase.downloader.depend.n
            public void a(DownloadInfo downloadInfo, BaseException baseException, int i) {
                if (downloadInfo != null) {
                    try {
                        fVar.a(downloadInfo, baseException, i);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    public static z a(final j jVar) {
        if (jVar == null) {
            return null;
        }
        return new c() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass14 */

            @Override // com.ss.android.socialbase.downloader.depend.z
            public void a(JSONObject jSONObject) {
                if (jSONObject != null) {
                    try {
                        jVar.a(jSONObject.toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public String b() {
                try {
                    return jVar.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.c
            public int[] a() {
                try {
                    return jVar.b();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static x a(final v vVar) {
        if (vVar == null) {
            return null;
        }
        return new x() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass15 */

            @Override // com.ss.android.socialbase.downloader.depend.x
            public boolean a(w wVar) {
                try {
                    return vVar.a(f.a(wVar));
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static u a(final w wVar) {
        if (wVar == null) {
            return null;
        }
        return new u.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass16 */

            @Override // com.ss.android.socialbase.downloader.depend.u
            public void a(List<String> list) {
                wVar.a(list);
            }

            @Override // com.ss.android.socialbase.downloader.depend.u
            public boolean a() {
                return wVar.a();
            }
        };
    }

    public static ak a(final al alVar) {
        if (alVar == null) {
            return null;
        }
        return new ak.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass17 */

            @Override // com.ss.android.socialbase.downloader.depend.ak
            public void a(int i, int i2) {
                alVar.a(i, i2);
            }
        };
    }

    public static al a(final ak akVar) {
        if (akVar == null) {
            return null;
        }
        return new al() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass18 */

            @Override // com.ss.android.socialbase.downloader.depend.al
            public void a(int i, int i2) {
                try {
                    akVar.a(i, i2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static r a(final p pVar) {
        if (pVar == null) {
            return null;
        }
        return new r() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass19 */

            @Override // com.ss.android.socialbase.downloader.depend.r
            public boolean a(long j, long j2, com.ss.android.socialbase.downloader.depend.q qVar) {
                try {
                    return pVar.a(j, j2, f.a(qVar));
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static o a(final com.ss.android.socialbase.downloader.depend.q qVar) {
        if (qVar == null) {
            return null;
        }
        return new o.a() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass20 */

            @Override // com.ss.android.socialbase.downloader.depend.o
            public void a() throws RemoteException {
                qVar.a();
            }
        };
    }

    public static q a(final ai aiVar) {
        if (aiVar == null) {
            return null;
        }
        return new q() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass21 */

            @Override // com.ss.android.socialbase.downloader.downloader.q
            public long a(int i, int i2) {
                try {
                    return aiVar.a(i, i2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        };
    }

    public static y a(final h hVar) {
        if (hVar == null) {
            return null;
        }
        return new y() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass22 */

            @Override // com.ss.android.socialbase.downloader.depend.y
            public boolean a() {
                try {
                    return hVar.a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static t a(final com.ss.android.socialbase.downloader.depend.g gVar) {
        if (gVar == null) {
            return null;
        }
        return new t() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass24 */

            @Override // com.ss.android.socialbase.downloader.depend.t
            public Uri a(String str, String str2) {
                try {
                    return gVar.a(str, str2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static IDownloadListener a(final i iVar) {
        if (iVar == null) {
            return null;
        }
        return new s() {
            /* class com.ss.android.socialbase.downloader.i.f.AnonymousClass25 */

            @Override // com.ss.android.socialbase.downloader.depend.s
            public void a(DownloadInfo downloadInfo) {
                try {
                    iVar.i(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    iVar.a(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    iVar.b(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    iVar.c(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    iVar.d(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    iVar.e(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    iVar.a(downloadInfo, baseException);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    iVar.f(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    iVar.g(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    iVar.h(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    iVar.b(downloadInfo, baseException);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    iVar.c(downloadInfo, baseException);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
