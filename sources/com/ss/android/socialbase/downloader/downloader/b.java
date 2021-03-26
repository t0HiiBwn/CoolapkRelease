package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.d.c;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.ad;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.al;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.a;
import com.ss.android.socialbase.downloader.impls.d;
import com.ss.android.socialbase.downloader.impls.e;
import com.ss.android.socialbase.downloader.impls.i;
import com.ss.android.socialbase.downloader.impls.j;
import com.ss.android.socialbase.downloader.impls.l;
import com.ss.android.socialbase.downloader.impls.n;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.network.f;
import com.ss.android.socialbase.downloader.network.g;
import com.ss.android.socialbase.downloader.network.h;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* compiled from: DownloadComponentManager */
public class b {
    private static volatile ac A;
    private static volatile List<al> B = new ArrayList();
    private static volatile boolean C = false;
    private static volatile OkHttpClient D = null;
    private static volatile f E;
    private static volatile f F;
    private static final List<m> G = new ArrayList();
    private static boolean H = false;
    private static int I;
    private static final int J;
    private static final int K = ((Runtime.getRuntime().availableProcessors() * 2) + 1);
    private static final int L;
    private static final int M;
    private static int N = 8192;
    private static boolean O;
    private static final List<k> P = new ArrayList();
    private static final List<ad> Q = new ArrayList();
    private static int R;
    private static boolean S = true;
    private static boolean T = false;
    private static p U;
    private static c V;
    private static volatile boolean W = false;
    private static volatile Context a;
    private static volatile i b;
    private static volatile j c;
    private static volatile g d;
    private static volatile ah e;
    private static volatile a f;
    private static volatile n g;
    private static volatile n h;
    private static volatile IDownloadHttpService i;
    private static volatile h j;
    private static volatile IDownloadHttpService k;

    /* renamed from: l  reason: collision with root package name */
    private static volatile h f1408l;
    private static volatile k m;
    private static volatile ExecutorService n;
    private static volatile ExecutorService o;
    private static volatile ExecutorService p;
    private static volatile ExecutorService q;
    private static volatile ExecutorService r;
    private static volatile ExecutorService s;
    private static volatile ExecutorService t;
    private static volatile ExecutorService u;
    private static volatile f v;
    private static volatile DownloadReceiver w;
    private static volatile q x;
    private static volatile o y;
    private static volatile com.ss.android.socialbase.downloader.d.b z;

    public static void a(p pVar) {
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        J = availableProcessors;
        L = availableProcessors;
        M = availableProcessors;
    }

    private b() {
    }

    static synchronized void a(DownloaderBuilder downloaderBuilder) {
        synchronized (b.class) {
            if (W) {
                com.ss.android.socialbase.downloader.c.a.e("DownloadComponentManager", "component has init");
                return;
            }
            boolean z2 = C;
            c(downloaderBuilder);
            if (b == null) {
                b = new d();
            }
            if (g == null) {
                g = new com.ss.android.socialbase.downloader.impls.h();
            }
            if (h == null) {
                h = new n();
            }
            if (c == null) {
                c = new i();
            }
            if (f == null) {
                f = new e();
            }
            if (d == null) {
                d = new com.ss.android.socialbase.downloader.impls.c();
            }
            if (v == null) {
                v = new com.ss.android.socialbase.downloader.impls.b();
            }
            if (x == null) {
                x = new j();
            }
            int i2 = I;
            if (i2 <= 0 || i2 > J) {
                I = J;
            }
            Q();
            if (C && !z2 && !com.ss.android.socialbase.downloader.i.e.c()) {
                l.a(true).d();
            } else if (com.ss.android.socialbase.downloader.i.e.d()) {
                ExecutorService m2 = m();
                if (m2 != null) {
                    m2.execute(new Runnable() {
                        /* class com.ss.android.socialbase.downloader.downloader.b.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            Context L = b.L();
                            if (L != null) {
                                com.ss.android.socialbase.downloader.i.e.d(L);
                            }
                        }
                    });
                }
            } else {
                Context L2 = L();
                if (L2 != null) {
                    com.ss.android.socialbase.downloader.i.e.d(L2);
                }
            }
            W = true;
        }
    }

    static synchronized void b(DownloaderBuilder downloaderBuilder) {
        synchronized (b.class) {
            c(downloaderBuilder);
        }
    }

    private static void c(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                a(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                a(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                a(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                a(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                a(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                b(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                a(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                a(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                a(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                c(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                d(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                e(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                f(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                g(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                h(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                a(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                b(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                a(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                y = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                N = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                a(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                C = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                R = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                a(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                E = downloaderBuilder.getDownloadDns();
            }
            b(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                a(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    private static void Q() {
        if (w == null) {
            w = new DownloadReceiver();
        }
        if (!H) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                a.registerReceiver(w, intentFilter);
                H = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    static synchronized void a() {
        synchronized (b.class) {
            try {
                if (!(!H || w == null || a == null)) {
                    a.unregisterReceiver(w);
                    H = false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return;
    }

    public static synchronized void b() {
        synchronized (b.class) {
            if (!C) {
                C = true;
                try {
                    Intent intent = new Intent(L(), DownloadHandleService.class);
                    intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
                    L().startService(intent);
                    if (!com.ss.android.socialbase.downloader.i.e.c()) {
                        l.a(true).d();
                    }
                } catch (Throwable th) {
                    C = false;
                    th.printStackTrace();
                }
            }
        }
    }

    public static synchronized boolean c() {
        boolean z2;
        synchronized (b.class) {
            z2 = C;
        }
        return z2;
    }

    public static IDownloadHttpService d() {
        return i;
    }

    public static void a(al alVar) {
        if (alVar != null) {
            synchronized (B) {
                B.add(alVar);
            }
        }
    }

    public static List<al> e() {
        List<al> list;
        synchronized (B) {
            list = B;
        }
        return list;
    }

    public static void a(k kVar) {
        List<k> list = P;
        synchronized (list) {
            if (kVar != null) {
                if (!list.contains(kVar)) {
                    list.add(kVar);
                }
            }
        }
    }

    public static void b(k kVar) {
        List<k> list = P;
        synchronized (list) {
            if (kVar != null) {
                if (list.contains(kVar)) {
                    list.remove(kVar);
                }
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.constants.d dVar) {
        List<k> list = P;
        synchronized (list) {
            for (k kVar : list) {
                if (kVar != null) {
                    if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_START) {
                        kVar.a();
                    } else if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                        kVar.b();
                    }
                }
            }
            if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                P.clear();
            }
        }
    }

    public static void a(DownloadTask downloadTask, int i2) {
        List<ad> list = Q;
        synchronized (list) {
            for (ad adVar : list) {
                if (adVar != null) {
                    adVar.a(downloadTask, i2);
                }
            }
        }
    }

    public static void b(DownloadTask downloadTask, int i2) {
        List<ad> list = Q;
        synchronized (list) {
            for (ad adVar : list) {
                if (adVar != null) {
                    adVar.b(downloadTask, i2);
                }
            }
        }
    }

    public static h f() {
        return j;
    }

    public static com.ss.android.socialbase.downloader.d.b g() {
        return z;
    }

    public static com.ss.android.socialbase.downloader.network.i a(boolean z2, int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        return a(z2, i2, str, null, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.i a(boolean z2, int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.c> list, int i3, boolean z3, DownloadInfo downloadInfo) throws Exception {
        List<com.ss.android.socialbase.downloader.model.c> list2;
        int i4;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.model.c> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i4 = 1;
        } else if (!z2) {
            i4 = 2;
            list2 = list;
        } else {
            list2 = list;
            i4 = i3;
        }
        int[] a2 = a(i4);
        Exception e2 = null;
        for (int i5 : a2) {
            try {
                com.ss.android.socialbase.downloader.network.i a3 = a(i2, str, str2, list2, i5, z3, downloadInfo);
                if (a3 != null) {
                    return a3;
                }
            } catch (Exception e3) {
                e2 = e3;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0044  */
    private static com.ss.android.socialbase.downloader.network.i a(int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.c> list, int i3, boolean z2, DownloadInfo downloadInfo) throws BaseException, IOException {
        Throwable th;
        IOException e2;
        IDownloadHttpService d2 = i3 == 1 ? d() : h();
        if (d2 != null) {
            IOException iOException = null;
            long j2 = 0;
            if (z2) {
                try {
                    j2 = System.currentTimeMillis();
                } catch (IOException e3) {
                    e2 = e3;
                } catch (Throwable th2) {
                    th = th2;
                    if (z2) {
                    }
                    throw th;
                }
            }
            try {
                com.ss.android.socialbase.downloader.network.i downloadWithConnection = d2.downloadWithConnection(i2, str, list);
                if (z2) {
                    com.ss.android.socialbase.downloader.d.a.a(downloadWithConnection, str, str2, System.currentTimeMillis() - j2, "get", i3, null, downloadInfo);
                }
                return downloadWithConnection;
            } catch (IOException e4) {
                e2 = e4;
                try {
                    throw e2;
                } catch (Throwable th3) {
                    th = th3;
                    iOException = e2;
                }
            } catch (Throwable th4) {
                th = th4;
                if (z2) {
                    com.ss.android.socialbase.downloader.d.a.a(null, str, str2, System.currentTimeMillis() - j2, "get", i3, iOException, downloadInfo);
                }
                throw th;
            }
        } else {
            throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i3));
        }
    }

    public static g a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        return a(str, list, 0, false, null);
    }

    public static g a(String str, List<com.ss.android.socialbase.downloader.model.c> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        Exception e2 = null;
        for (int i3 : a(i2)) {
            try {
                g b2 = b(str, list, i3, z2, downloadInfo);
                if (b2 != null) {
                    return b2;
                }
            } catch (Exception e3) {
                e2 = e3;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    private static g b(String str, List<com.ss.android.socialbase.downloader.model.c> list, int i2, boolean z2, DownloadInfo downloadInfo) throws BaseException, IOException {
        Throwable th;
        IOException iOException;
        h f2 = i2 == 1 ? f() : i();
        if (f2 != null) {
            long j2 = 0;
            if (z2) {
                try {
                    j2 = System.currentTimeMillis();
                } catch (IOException e2) {
                    throw e2;
                } catch (Throwable th2) {
                    iOException = e2;
                    th = th2;
                }
            }
            g a2 = f2.a(str, list);
            if (z2) {
                com.ss.android.socialbase.downloader.d.a.a(a2, str, null, System.currentTimeMillis() - j2, "head", i2, null, downloadInfo);
            }
            return a2;
        }
        throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i2));
        if (z2) {
            com.ss.android.socialbase.downloader.d.a.a(null, str, null, System.currentTimeMillis() - 0, "head", i2, iOException, downloadInfo);
        }
        throw th;
    }

    private static int[] a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    public static IDownloadHttpService h() {
        if (k == null) {
            synchronized (b.class) {
                if (k == null) {
                    k = new com.ss.android.socialbase.downloader.impls.g();
                }
            }
        }
        return k;
    }

    public static h i() {
        if (f1408l == null) {
            synchronized (b.class) {
                if (f1408l == null) {
                    f1408l = new com.ss.android.socialbase.downloader.impls.f();
                }
            }
        }
        return f1408l;
    }

    public static synchronized void a(k kVar) {
        synchronized (b.class) {
            if (kVar != null) {
                m = kVar;
                if (b instanceof d) {
                    ((d) b).g();
                }
            }
        }
    }

    private static void c(ExecutorService executorService) {
        if (executorService != null) {
            n = executorService;
        }
    }

    private static void d(ExecutorService executorService) {
        if (executorService != null) {
            o = executorService;
        }
    }

    private static void e(ExecutorService executorService) {
        if (executorService != null) {
            p = executorService;
        }
    }

    private static void f(ExecutorService executorService) {
        if (executorService != null) {
            q = executorService;
        }
    }

    private static void g(ExecutorService executorService) {
        if (executorService != null) {
            r = executorService;
        }
    }

    private static void h(ExecutorService executorService) {
        if (executorService != null) {
            s = executorService;
        }
    }

    public static void a(ExecutorService executorService) {
        if (executorService != null) {
            t = executorService;
        }
    }

    public static void b(ExecutorService executorService) {
        if (executorService != null) {
            u = executorService;
        }
    }

    private static void a(List<m> list) {
        List<m> list2 = G;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void a(boolean z2) {
        T = z2;
    }

    public static boolean j() {
        return com.ss.android.socialbase.downloader.g.a.c().a("switch_not_auto_boot_service", T ? 1 : 0) > 0;
    }

    public static synchronized o k() {
        o oVar;
        synchronized (b.class) {
            oVar = y;
        }
        return oVar;
    }

    public static void a(Runnable runnable) {
        b(runnable, false);
    }

    public static void a(Runnable runnable, boolean z2) {
        if (runnable != null) {
            if (!z2 || com.ss.android.socialbase.downloader.i.e.d()) {
                l().execute(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static void b(Runnable runnable, boolean z2) {
        if (runnable != null) {
            if (!z2 || com.ss.android.socialbase.downloader.i.e.d()) {
                m().execute(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static void b(Runnable runnable) {
        if (runnable != null) {
            if (!com.ss.android.socialbase.downloader.i.e.d()) {
                runnable.run();
            } else {
                r().execute(runnable);
            }
        }
    }

    public static ExecutorService l() {
        if (n == null) {
            synchronized (b.class) {
                if (n == null) {
                    int i2 = J;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-cpu-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    n = threadPoolExecutor;
                }
            }
        }
        return n;
    }

    public static ExecutorService m() {
        return o != null ? o : l();
    }

    public static ExecutorService n() {
        return q != null ? q : p();
    }

    public static ExecutorService o() {
        return r != null ? r : p();
    }

    public static ExecutorService p() {
        if (p == null) {
            synchronized (b.class) {
                if (p == null) {
                    int i2 = L;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-mix-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    p = threadPoolExecutor;
                }
            }
        }
        return p;
    }

    public static ExecutorService q() {
        if (t == null) {
            synchronized (b.class) {
                if (t == null) {
                    int i2 = K;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-chunk-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    t = threadPoolExecutor;
                }
            }
        }
        return t;
    }

    public static ExecutorService r() {
        if (s == null) {
            synchronized (b.class) {
                if (s == null) {
                    int i2 = M;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-db-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    s = threadPoolExecutor;
                }
            }
        }
        return s;
    }

    public static OkHttpClient s() {
        if (D == null) {
            synchronized (b.class) {
                if (D == null) {
                    D = t().build();
                }
            }
        }
        return D;
    }

    public static OkHttpClient.Builder t() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30000, TimeUnit.MILLISECONDS).readTimeout(30000, TimeUnit.MILLISECONDS).writeTimeout(30000, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (u != null) {
            builder.dispatcher(new Dispatcher(u));
        }
        return builder;
    }

    public static f u() {
        return E;
    }

    public static f v() {
        if (F == null) {
            synchronized (b.class) {
                if (F == null) {
                    F = new f() {
                        /* class com.ss.android.socialbase.downloader.downloader.b.AnonymousClass2 */

                        @Override // com.ss.android.socialbase.downloader.network.f
                        public List<InetAddress> a(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return F;
    }

    public static synchronized k w() {
        k kVar;
        synchronized (b.class) {
            kVar = m;
        }
        return kVar;
    }

    public static void a(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            i = iDownloadHttpService;
        }
        O = i != null;
    }

    public static void a(h hVar) {
        if (hVar != null) {
            j = hVar;
        }
    }

    public static i x() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    private static void a(i iVar) {
        if (iVar != null) {
            b = iVar;
        }
    }

    public static n y() {
        if (g == null) {
            synchronized (b.class) {
                if (g == null) {
                    g = new com.ss.android.socialbase.downloader.impls.h();
                }
            }
        }
        return g;
    }

    public static n z() {
        if (h == null) {
            synchronized (b.class) {
                if (h == null) {
                    h = new n();
                }
            }
        }
        return h;
    }

    public static List<m> A() {
        return G;
    }

    public static j B() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new i();
                }
            }
        }
        return c;
    }

    public static a C() {
        if (f == null) {
            synchronized (b.class) {
                if (f == null) {
                    f = new e();
                }
            }
        }
        return f;
    }

    private static void a(j jVar) {
        if (jVar != null) {
            c = jVar;
        }
    }

    private static void b(int i2) {
        if (i2 > 0) {
            I = i2;
        }
    }

    private static void a(com.ss.android.socialbase.downloader.d.b bVar) {
        if (bVar != null) {
            z = bVar;
        }
    }

    public static int D() {
        return R;
    }

    public static JSONObject E() {
        if (A == null || A.a() == null) {
            return com.ss.android.socialbase.downloader.constants.e.i;
        }
        JSONObject a2 = A.a();
        a(a2);
        return a2;
    }

    private static void a(JSONObject jSONObject) {
        if (jSONObject != null && TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.e.c)) {
            com.ss.android.socialbase.downloader.constants.e.c = jSONObject.optString("kllk");
            if (!TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.e.c)) {
                com.ss.android.socialbase.downloader.constants.e.b = com.ss.android.socialbase.downloader.constants.e.c.toUpperCase();
            }
        }
    }

    public static void a(ac acVar) {
        A = acVar;
        com.ss.android.socialbase.downloader.g.a.a();
        a(acVar.a());
    }

    private static void b(boolean z2) {
        S = z2;
    }

    public static boolean F() {
        return S;
    }

    public static synchronized int G() {
        int i2;
        synchronized (b.class) {
            i2 = N;
        }
        return i2;
    }

    public static g H() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new com.ss.android.socialbase.downloader.impls.c();
                }
            }
        }
        return d;
    }

    private static void a(g gVar) {
        if (gVar != null) {
            d = gVar;
        }
    }

    public static void a(ah ahVar) {
        if (ahVar != null) {
            e = ahVar;
        }
    }

    public static ah I() {
        return e;
    }

    public static f J() {
        if (v == null) {
            synchronized (b.class) {
                if (v == null) {
                    v = new com.ss.android.socialbase.downloader.impls.b();
                }
            }
        }
        return v;
    }

    private static void a(f fVar) {
        if (fVar != null) {
            v = fVar;
        }
    }

    public static q K() {
        if (x == null) {
            synchronized (b.class) {
                if (x == null) {
                    x = new j();
                }
            }
        }
        return x;
    }

    public static synchronized Context L() {
        Context context;
        synchronized (b.class) {
            context = a;
        }
        return context;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (context != null) {
                if (a == null) {
                    a = context.getApplicationContext();
                    com.ss.android.socialbase.downloader.a.a.a().a(a);
                }
            }
        }
    }

    public static int a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        return a(downloadInfo.getUrl(), downloadInfo.getSavePath());
    }

    public static int a(String str, String str2) {
        j B2 = B();
        if (B2 == null) {
            return 0;
        }
        return B2.a(str, str2);
    }

    public static synchronized boolean M() {
        boolean z2;
        synchronized (b.class) {
            z2 = O;
        }
        return z2;
    }

    public static c N() {
        if (V == null) {
            V = new c() {
                /* class com.ss.android.socialbase.downloader.downloader.b.AnonymousClass3 */

                @Override // com.ss.android.socialbase.downloader.d.c
                public void a(int i, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.d.c
                public void b(int i, String str, JSONObject jSONObject) {
                }
            };
        }
        return V;
    }

    public static p O() {
        return U;
    }

    public static void a(c cVar) {
        V = cVar;
    }

    public static boolean P() {
        return W;
    }
}
