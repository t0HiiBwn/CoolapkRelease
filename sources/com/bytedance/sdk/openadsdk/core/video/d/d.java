package com.bytedance.sdk.openadsdk.core.video.d;

import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.b.a;
import com.bytedance.sdk.openadsdk.core.video.d.c;
import com.bytedance.sdk.openadsdk.i.f.b;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SSMediaPlayerWrapper */
public class d implements c.a, c.b, c.AbstractC0044c, c.d, c.e, c.f, c.g, al.a {
    private static boolean m;
    private static final SparseIntArray o = new SparseIntArray();
    private c a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private long g;
    private final Handler h;
    private Handler i;
    private ArrayList<Runnable> j;
    private int k;

    /* renamed from: l  reason: collision with root package name */
    private int f1319l;
    private String n;
    private boolean p;
    private Runnable q;
    private boolean r;
    private final Object s;
    private StringBuilder t;
    private boolean u;
    private long v;
    private long w;
    private long x;
    private long y;
    private boolean z;

    public d(Handler handler) {
        this(handler, -1);
    }

    public d(Handler handler, int i2) {
        this.a = null;
        boolean z2 = false;
        this.b = false;
        this.c = false;
        this.f = 201;
        this.g = -1;
        this.k = 0;
        this.n = "0";
        this.q = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.d.d.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                d.this.h.sendEmptyMessageDelayed(100, 0);
                u.b("tag_video_play", "[video] MediaPlayerProxy#start not first play ! sendMsg --> OP_START , video start to play !");
            }
        };
        this.s = new Object();
        this.t = null;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = false;
        this.k = 0;
        this.i = handler;
        HandlerThread handlerThread = new HandlerThread("VideoManager");
        handlerThread.start();
        this.h = new al(handlerThread.getLooper(), this);
        this.z = Build.VERSION.SDK_INT >= 17 ? true : z2;
        q();
    }

    public void a(boolean z2) {
        this.p = z2;
    }

    /* access modifiers changed from: private */
    public void q() {
        if (this.a == null) {
            u.b("SSMediaPlayeWrapper", "SSMediaPlayerWrapper use System Mediaplayer");
            b bVar = new b();
            this.a = bVar;
            this.n = "0";
            bVar.a((c.e) this);
            this.a.a((c.b) this);
            this.a.a((c.AbstractC0044c) this);
            this.a.a((c.a) this);
            this.a.a((c.f) this);
            this.a.a((c.d) this);
            this.a.a((c.g) this);
            try {
                this.a.b(this.b);
            } catch (Throwable th) {
                u.a("SSMediaPlayeWrapper", "setLooping error: ", th);
            }
            this.c = false;
        }
    }

    public MediaPlayer a() throws Throwable {
        c cVar = this.a;
        if (cVar != null) {
            return ((b) cVar).e();
        }
        return null;
    }

    public void a(boolean z2, long j2, boolean z3) {
        u.b("tag_video_play", "[video] MediaPlayerProxy#start firstSeekToPosition=" + j2 + ",firstPlay :" + z2 + ",isPauseOtherMusicVolume=" + z3);
        this.r = false;
        if (!z3) {
            if (this.a != null) {
                b(true);
            }
        } else if (this.a != null) {
            b(false);
        }
        if (z2) {
            u.b("tag_video_play", "[video] first start , SSMediaPlayer  start method !");
            r();
            this.g = j2;
            return;
        }
        C();
        c cVar = this.a;
        if (cVar != null) {
            try {
                if (j2 <= cVar.i()) {
                    j2 = this.a.i();
                }
                this.g = j2;
            } catch (Throwable th) {
                u.b("tag_video_play", "[video] MediaPlayerProxy#start  error: getCurrentPosition :" + th.toString());
            }
        }
        if (this.p) {
            b(this.q);
        } else {
            a(this.q);
        }
    }

    public void b() {
        this.h.removeMessages(100);
        this.r = true;
        this.h.sendEmptyMessage(101);
        D();
    }

    public void c() {
        this.f = 203;
        D();
        z();
        if (this.h != null) {
            try {
                b("release");
                this.h.removeCallbacksAndMessages(null);
                if (this.a != null) {
                    this.e = true;
                    this.h.sendEmptyMessage(103);
                }
            } catch (Throwable th) {
                t();
                u.a("SSMediaPlayeWrapper", "release error: ", th);
            }
        }
    }

    private void r() {
        u.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke !");
        b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.d.d.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.h != null) {
                    d.this.h.sendEmptyMessage(104);
                    u.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
                }
            }
        });
    }

    public void d() {
        b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.d.d.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.h != null) {
                    d.this.h.sendEmptyMessage(105);
                }
            }
        });
    }

    public void a(final long j2) {
        D();
        int i2 = this.f;
        if (i2 == 207 || i2 == 206 || i2 == 209) {
            b(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.video.d.d.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.h != null) {
                        d.this.h.obtainMessage(106, Long.valueOf(j2)).sendToTarget();
                    }
                }
            });
        }
    }

    public void a(final SurfaceTexture surfaceTexture) {
        b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.d.d.AnonymousClass5 */

            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.h != null) {
                    d.this.h.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    public void a(final SurfaceHolder surfaceHolder) {
        b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.d.d.AnonymousClass6 */

            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.h != null) {
                    d.this.h.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public void e() {
        Handler handler = this.h;
        if (handler != null) {
            handler.obtainMessage(108).sendToTarget();
        }
    }

    public void f() {
        Handler handler = this.h;
        if (handler != null) {
            handler.obtainMessage(109).sendToTarget();
        }
    }

    public void a(final a aVar) {
        b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.d.d.AnonymousClass7 */

            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.h != null) {
                    d.this.h.obtainMessage(107, aVar).sendToTarget();
                }
            }
        });
    }

    public boolean g() {
        return (this.f == 206 || this.h.hasMessages(100)) && !this.r;
    }

    public boolean h() {
        return k() || g() || i();
    }

    public boolean i() {
        return (this.f == 207 || this.r) && !this.h.hasMessages(100);
    }

    public boolean j() {
        return this.f == 203;
    }

    public boolean k() {
        return this.f == 205;
    }

    public boolean l() {
        return this.f == 209;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a5 A[Catch:{ all -> 0x01b0 }] */
    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        boolean z2;
        Throwable th;
        Handler handler;
        long j2;
        int i2 = message.what;
        u.b("tag_video_play", "[video]  execute , mCurrentState = " + this.f + " handlerMsg=" + i2);
        if (this.a != null) {
            long j3 = 0;
            switch (message.what) {
                case 100:
                    int i3 = this.f;
                    if (i3 == 205 || i3 == 206 || i3 == 207 || i3 == 209) {
                        try {
                            this.a.f();
                            u.b("tag_video_play", "[video] OP_START execute , mMediaPlayer real start !");
                            this.f = 206;
                            long j4 = this.g;
                            if (j4 >= 0) {
                                this.a.a(j4);
                                this.g = -1;
                            }
                            Handler handler2 = this.i;
                            if (handler2 != null) {
                                handler2.removeMessages(312);
                                this.i.sendEmptyMessage(313);
                            }
                        } catch (Throwable th2) {
                            u.a("tag_video_play", "OP_START error: ", th2);
                        }
                        z2 = false;
                        break;
                    }
                    z2 = true;
                    break;
                case 101:
                    int i4 = this.f;
                    if (i4 == 206 || i4 == 207 || i4 == 209) {
                        try {
                            u.b("tag_video_play", "[video] OP_PAUSE execute , mMediaPlayer  OP_PAUSE !");
                            this.a.h();
                            this.f = 207;
                            try {
                                this.r = false;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            u.a("NativeVideoController", "OP_PAUSE error: ", th);
                            z2 = false;
                            if (z2) {
                            }
                        }
                        z2 = false;
                    }
                    z2 = true;
                    break;
                case 102:
                    try {
                        this.a.l();
                        u.b("tag_video_play", "[video] OP_RELEASE execute , releaseMediaplayer !");
                        this.f = 201;
                        break;
                    } catch (Throwable th5) {
                        u.a("SSMediaPlayeWrapper", "OP_RESET error: ", th5);
                        break;
                    }
                case 103:
                    try {
                        s();
                        u.b("tag_video_play", "[video] OP_RELEASE execute , releaseMediaplayer !");
                    } catch (Throwable th6) {
                        u.c("NativeVideoController", "OP_RELEASE error: ", th6);
                    }
                    this.e = false;
                    a(309, (Object) null);
                    this.f = 203;
                    this.a = null;
                    y();
                    break;
                case 104:
                    int i5 = this.f;
                    if (i5 == 202 || i5 == 208) {
                        try {
                            ((b) this.a).e().prepareAsync();
                            u.b("tag_video_play", "[video] OP_PREPARE_ASYNC execute , mMediaPlayer real prepareAsync !");
                            Handler handler3 = this.i;
                            if (handler3 != null) {
                                handler3.sendEmptyMessageDelayed(312, 10000);
                                break;
                            }
                        } catch (Throwable th7) {
                            u.c("NativeVideoController", "OP_PREPARE_ASYNC error: ", th7);
                            break;
                        }
                    }
                    z2 = true;
                    break;
                case 105:
                    int i6 = this.f;
                    if (i6 == 205 || i6 == 206 || i6 == 208 || i6 == 207 || i6 == 209) {
                        try {
                            this.a.g();
                            this.f = 208;
                            break;
                        } catch (Throwable th8) {
                            u.a("SSMediaPlayeWrapper", "OP_STOP error: ", th8);
                            break;
                        }
                    }
                    z2 = true;
                    break;
                case 106:
                    int i7 = this.f;
                    if (i7 == 206 || i7 == 207 || i7 == 209) {
                        try {
                            this.a.a(((Long) message.obj).longValue());
                            break;
                        } catch (Throwable th9) {
                            u.a("SSMediaPlayeWrapper", "OP_SEEKTO error: ", th9);
                            break;
                        }
                    }
                    z2 = true;
                    break;
                case 107:
                    int i8 = this.f;
                    if (i8 == 201 || i8 == 203) {
                        try {
                            a aVar = (a) message.obj;
                            String str = aVar.a;
                            String c2 = com.bytedance.sdk.openadsdk.core.video.a.a.c(str);
                            if (!TextUtils.isEmpty(c2)) {
                                str = c2;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                if (!str.startsWith("/")) {
                                    if (aVar.c != 1) {
                                        b b2 = new b().a(aVar.a).b(aVar.d);
                                        if (Build.VERSION.SDK_INT < 23 || !str.startsWith("http")) {
                                            String b3 = com.bytedance.sdk.openadsdk.i.f.a.a().b(b2);
                                            u.f("cache009", "使用Video缓存-OP_SET_DATASOURCE-proxyurl=" + b3);
                                            if (b3 == null || !com.bytedance.sdk.openadsdk.multipro.b.b() || !b3.startsWith("file")) {
                                                this.a.a(b3);
                                            } else {
                                                Uri parse = Uri.parse(b3);
                                                u.f("cache010", "使用uri parse =" + parse.getPath());
                                                a(parse.getPath());
                                            }
                                            this.f = 202;
                                            handler = this.i;
                                            if (handler != null) {
                                                handler.obtainMessage(314).sendToTarget();
                                                break;
                                            }
                                        } else {
                                            this.a.a(str, aVar.d);
                                            this.f = 202;
                                            handler = this.i;
                                            if (handler != null) {
                                            }
                                        }
                                    }
                                }
                                if (!com.bytedance.sdk.openadsdk.multipro.b.b() || !str.startsWith("/")) {
                                    this.a.a(str);
                                } else {
                                    a(str);
                                }
                                this.f = 202;
                                handler = this.i;
                                if (handler != null) {
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th10) {
                            u.a("SSMediaPlayeWrapper", "OP_SET_DATASOURCE error: ", th10);
                            break;
                        }
                    }
                    z2 = true;
                    break;
                case 108:
                    int i9 = this.f;
                    if (i9 == 206 || i9 == 207) {
                        try {
                            j3 = this.a.j();
                        } catch (Throwable th11) {
                            u.a("SSMediaPlayeWrapper", "OP_REQUEST_DURATION error: ", th11);
                        }
                    }
                    a(108, Long.valueOf(j3));
                    break;
                case 109:
                    int i10 = this.f;
                    if (i10 == 206 || i10 == 207) {
                        try {
                            j2 = this.a.i();
                        } catch (Throwable th12) {
                            u.a("SSMediaPlayeWrapper", "OP_REQUEST_CUR_POSITION error: ", th12);
                        }
                        if (j2 > 0) {
                            a(109, Long.valueOf(j2));
                            break;
                        }
                    }
                    j2 = 0;
                    if (j2 > 0) {
                    }
                    break;
                case 110:
                    try {
                        this.a.a((SurfaceHolder) message.obj);
                        if (this.k == 2) {
                            this.a.a(p.a(), 10);
                        }
                        this.a.a(true);
                        break;
                    } catch (Throwable th13) {
                        u.a("SSMediaPlayeWrapper", "OP_SET_DISPLAY error: ", th13);
                        break;
                    }
                case 111:
                    try {
                        if (Build.VERSION.SDK_INT >= 14) {
                            this.a.a(new Surface((SurfaceTexture) message.obj));
                        }
                        this.a.a(true);
                        this.a.a(p.a(), 10);
                        x();
                        break;
                    } catch (Throwable th14) {
                        u.a("SSMediaPlayeWrapper", "OP_SET_SURFACE error: ", th14);
                        break;
                    }
            }
            if (z2) {
                this.f = 200;
                if (!this.c) {
                    a(308, Integer.valueOf(i2));
                    this.c = true;
                    return;
                }
                return;
            }
            return;
        }
        z2 = false;
        if (z2) {
        }
    }

    private void a(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.a.a(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void s() {
        c cVar = this.a;
        if (cVar != null) {
            try {
                cVar.l();
            } catch (Throwable th) {
                u.a("SSMediaPlayeWrapper", "releaseMediaplayer error1: ", th);
            }
            this.a.a((c.b) null);
            this.a.a((c.g) null);
            this.a.a((c.a) null);
            this.a.a((c.d) null);
            this.a.a((c.AbstractC0044c) null);
            this.a.a((c.e) null);
            this.a.a((c.f) null);
            try {
                this.a.k();
            } catch (Throwable th2) {
                u.a("SSMediaPlayeWrapper", "releaseMediaplayer error2: ", th2);
            }
        }
    }

    private void t() {
        Handler handler = this.h;
        if (handler != null && handler.getLooper() != null) {
            try {
                u.b("SSMediaPlayeWrapper", "onDestory............");
                this.h.getLooper().quit();
            } catch (Throwable th) {
                u.a("SSMediaPlayeWrapper", "onDestroy error: ", th);
            }
        }
    }

    private void a(int i2, Object obj) {
        if (i2 == 309) {
            B();
        }
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(i2, obj).sendToTarget();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.a
    public void a(c cVar, int i2) {
        Handler handler;
        if (this.a == cVar && (handler = this.i) != null) {
            handler.obtainMessage(301, Integer.valueOf(i2)).sendToTarget();
        }
    }

    private void u() {
        SparseIntArray sparseIntArray = o;
        Integer valueOf = Integer.valueOf(sparseIntArray.get(this.k));
        if (valueOf == null) {
            sparseIntArray.put(this.k, 1);
        } else {
            sparseIntArray.put(this.k, Integer.valueOf(valueOf.intValue() + 1).intValue());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.b
    public void a(c cVar) {
        this.f = !this.b ? 209 : 206;
        o.delete(this.k);
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(302).sendToTarget();
        }
        b("completion");
        D();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.AbstractC0044c
    public boolean a(c cVar, int i2, int i3) {
        u.f("SSMediaPlayeWrapper", "what=" + i2 + "extra=" + i3);
        u();
        this.f = 200;
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(303, i2, i3).sendToTarget();
        }
        Handler handler2 = this.h;
        if (handler2 != null) {
            handler2.removeMessages(108);
            this.h.removeMessages(109);
        }
        if (!this.c) {
            a(308, Integer.valueOf(i2));
            this.c = true;
        }
        if (a(i2, i3)) {
            t();
        }
        return true;
    }

    private boolean a(int i2, int i3) {
        u.b("SSMediaPlayeWrapper", "OnError - Error code: " + i2 + " Extra code: " + i3);
        boolean z2 = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
        if (i3 == 1 || i3 == 700 || i3 == 800) {
            return true;
        }
        return z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.d
    public boolean b(c cVar, int i2, int i3) {
        u.f("SSMediaPlayeWrapper", "what,extra:" + i2 + "," + i3);
        if (this.a != cVar) {
            return false;
        }
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(304, i2, i3).sendToTarget();
            if (i3 == -1004) {
                this.i.obtainMessage(303, i2, i3).sendToTarget();
            }
        }
        b(i2, i3);
        return false;
    }

    private void b(int i2, int i3) {
        if (i2 == 701) {
            D();
            this.x = SystemClock.elapsedRealtime();
        } else if (i2 == 702) {
            if (this.w <= 0) {
                this.w = System.currentTimeMillis();
            }
            if (this.x > 0) {
                this.y += SystemClock.elapsedRealtime() - this.x;
                this.x = 0;
            }
        } else if (this.z && i2 == 3 && this.w <= 0) {
            this.w = System.currentTimeMillis();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.e
    public void b(c cVar) {
        this.f = 205;
        if (this.r) {
            this.h.post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.video.d.d.AnonymousClass8 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.a.h();
                        d.this.f = 207;
                        d.this.r = false;
                    } catch (Throwable th) {
                        u.a("SSMediaPlayeWrapper", "onPrepared error: ", th);
                    }
                }
            });
        } else {
            Handler handler = this.h;
            handler.sendMessage(handler.obtainMessage(100, -1, -1));
        }
        o.delete(this.k);
        Handler handler2 = this.i;
        if (handler2 != null) {
            handler2.sendEmptyMessage(305);
        }
        v();
    }

    private void v() {
        if (!this.z && this.w <= 0) {
            this.w = System.currentTimeMillis();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.f
    public void c(c cVar) {
        Handler handler = this.i;
        if (handler != null) {
            handler.sendEmptyMessage(306);
        }
    }

    private void a(Runnable runnable) {
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.add(runnable);
    }

    private void w() {
        if (!this.d) {
            this.d = true;
            Iterator it2 = new ArrayList(this.j).iterator();
            while (it2.hasNext()) {
                ((Runnable) it2.next()).run();
            }
            this.j.clear();
            this.d = false;
        }
    }

    private void x() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList != null && !arrayList.isEmpty()) {
            w();
        }
    }

    private void y() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList == null || arrayList.isEmpty()) {
            t();
        } else {
            w();
        }
    }

    private void z() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.j.clear();
        }
    }

    private void b(Runnable runnable) {
        if (runnable != null) {
            if (!this.e) {
                runnable.run();
            } else {
                a(runnable);
            }
        }
    }

    private void a(int i2, boolean z2) {
        int A;
        if (z2 && (A = A()) != i2) {
            m = true;
            this.f1319l = A;
        }
        AudioManager audioManager = (AudioManager) p.a().getSystemService("audio");
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i2, 0);
        }
    }

    private int A() {
        AudioManager audioManager = (AudioManager) p.a().getSystemService("audio");
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return -1;
    }

    private void B() {
        if (m) {
            a(this.f1319l, false);
            m = false;
        }
    }

    public void b(boolean z2) {
        if (z2) {
            try {
                this.a.a(0.0f, 0.0f);
            } catch (Throwable th) {
                u.a("SSMediaPlayeWrapper", "setQuietPlay error: ", th);
            }
        } else {
            this.a.a(1.0f, 1.0f);
        }
    }

    private void b(String str) {
        Handler handler = this.h;
        if (handler != null) {
            handler.removeMessages(201);
        }
        synchronized (this.s) {
            if (this.t != null) {
                this.t = null;
            }
        }
    }

    private void C() {
        if (this.w <= 0) {
            this.w = System.currentTimeMillis();
        }
    }

    public void m() {
        this.v = 0;
        this.w = System.currentTimeMillis();
    }

    private void D() {
        if (this.w > 0) {
            this.v += System.currentTimeMillis() - this.w;
            this.w = 0;
        }
    }

    public long n() {
        return this.y;
    }

    public long o() {
        D();
        return this.v;
    }

    public long p() {
        if (this.w > 0) {
            this.v += System.currentTimeMillis() - this.w;
            this.w = System.currentTimeMillis();
        }
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.g
    public void a(c cVar, int i2, int i3, int i4, int i5) {
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(311, i2, i3).sendToTarget();
        }
    }
}
