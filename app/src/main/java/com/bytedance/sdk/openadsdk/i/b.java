package com.bytedance.sdk.openadsdk.i;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.i.b.a;
import com.bytedance.sdk.openadsdk.i.c.c;
import com.bytedance.sdk.openadsdk.i.g.d;
import com.bytedance.sdk.openadsdk.i.h;
import com.bytedance.sdk.openadsdk.i.i;
import com.bytedance.sdk.openadsdk.i.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.List;

/* compiled from: DownloadTask */
class b extends a {
    final Object m = this;
    final Object n;
    private final int o;
    private final AbstractC0055b p;
    private volatile h.a q;
    private volatile com.bytedance.sdk.openadsdk.i.c.b r;

    /* renamed from: com.bytedance.sdk.openadsdk.i.b$b  reason: collision with other inner class name */
    /* compiled from: DownloadTask */
    public interface AbstractC0055b {
        void a(b bVar);
    }

    b(a aVar) {
        super(aVar.d, aVar.e);
        this.o = aVar.g;
        this.p = aVar.i;
        this.g = aVar.a;
        this.h = aVar.b;
        this.f = aVar.f;
        this.j = aVar.c;
        this.i = aVar.h;
        this.n = aVar.j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(this.h);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            j();
        } catch (com.bytedance.sdk.openadsdk.i.c.a e) {
            if (e.c) {
                Log.w("TAG_PROXY_DownloadTask", Log.getStackTraceString(e));
            }
        } catch (com.bytedance.sdk.adnet.err.a e2) {
            e2.printStackTrace();
        } catch (VAdError e3) {
            e3.printStackTrace();
        } catch (Throwable th) {
            if (e.c) {
                Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(th));
            }
        }
        this.d.set(SystemClock.elapsedRealtime() - elapsedRealtime);
        this.a.b(this.h);
        AbstractC0055b bVar = this.p;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    h.a h() {
        return this.q;
    }

    com.bytedance.sdk.openadsdk.i.c.b i() {
        return this.r;
    }

    private boolean j() throws com.bytedance.sdk.openadsdk.i.c.a, VAdError {
        while (this.j.a()) {
            e();
            l.a b = this.j.b();
            try {
                a(b);
                return true;
            } catch (c e) {
                b.a();
                a(Boolean.valueOf(g()), this.g, e);
            } catch (IOException e2) {
                if (e2 instanceof SocketTimeoutException) {
                    b.b();
                }
                if (!b()) {
                    a(Boolean.valueOf(g()), this.g, e2);
                } else if (e.c) {
                    if ("Canceled".equalsIgnoreCase(e2.getMessage())) {
                        Log.w("TAG_PROXY_DownloadTask", "okhttp call canceled");
                    } else {
                        Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e2));
                    }
                }
            } catch (h.a e3) {
                this.q = e3;
                a(Boolean.valueOf(g()), this.g, e3);
                return false;
            } catch (com.bytedance.sdk.openadsdk.i.c.b e4) {
                this.r = e4;
                if (e.c) {
                    Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e4));
                }
                return false;
            } catch (Throwable th) {
                if (e.c) {
                    Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(th));
                }
                return false;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01cd, code lost:
        if (com.bytedance.sdk.openadsdk.i.e.c == false) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01cf, code lost:
        android.util.Log.i("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01d6, code lost:
        com.bytedance.sdk.openadsdk.i.g.d.a(r6.d());
        r4.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01e0, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x021b  */
    private void a(l.a aVar) throws IOException, h.a, com.bytedance.sdk.openadsdk.i.c.a, com.bytedance.sdk.openadsdk.i.c.b, VAdError {
        Throwable th;
        int i;
        File c = this.a.c(this.h);
        long length = c.length();
        int i2 = this.o;
        if (i2 <= 0 || length < ((long) i2)) {
            int f = f();
            a a2 = this.b.a(this.h, f);
            if (a2 == null || length < ((long) a2.c)) {
                e();
                int i3 = (int) length;
                com.bytedance.sdk.openadsdk.i.e.a a3 = a(aVar, i3, this.o, "GET");
                if (a3 != null) {
                    h hVar = null;
                    boolean z = true;
                    try {
                        e();
                        String a4 = d.a(a3, this.i == null && e.e, true);
                        if (a4 == null) {
                            int a5 = d.a(a3);
                            if (a2 == null || a2.c == a5) {
                                d.a(a3, this.b, this.h, f);
                                a a6 = this.b.a(this.h, f);
                                if (a6 == null) {
                                    i = 0;
                                } else {
                                    i = a6.c;
                                }
                                InputStream d = a3.d();
                                h hVar2 = new h(c, e.d ? "rwd" : "rw");
                                try {
                                    hVar2.a(length);
                                    if (e.c) {
                                        Log.i("TAG_PROXY_DownloadTask", "preload start from: " + length);
                                    }
                                    byte[] bArr = new byte[8192];
                                    while (true) {
                                        int read = d.read(bArr);
                                        if (read >= 0) {
                                            e();
                                            if (read > 0) {
                                                hVar2.a(bArr, 0, read);
                                                i3 += read;
                                                if (this.i != null) {
                                                    synchronized (this.m) {
                                                        this.m.notifyAll();
                                                    }
                                                }
                                                this.c.addAndGet(read);
                                                a(i, i3);
                                            }
                                            int i4 = this.o;
                                            if (i4 <= 0 || i3 < i4) {
                                                e();
                                            } else {
                                                if (e.c) {
                                                    Log.w("TAG_PROXY_DownloadTask", "download, more data received, currentCacheFileSize: " + i3 + ", max: " + this.o);
                                                }
                                                d.a(a3.d());
                                                hVar2.a();
                                                a();
                                                if (e.c) {
                                                    Log.w("TAG_PROXY_DownloadTask", "cancel call");
                                                    return;
                                                }
                                                return;
                                            }
                                        } else {
                                            try {
                                                break;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                hVar = hVar2;
                                                z = false;
                                                d.a(a3.d());
                                                if (hVar != null) {
                                                    hVar.a();
                                                }
                                                if (z) {
                                                    a();
                                                    if (e.c) {
                                                        Log.w("TAG_PROXY_DownloadTask", "cancel call");
                                                    }
                                                }
                                                throw th;
                                            }
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    hVar = hVar2;
                                    d.a(a3.d());
                                    if (hVar != null) {
                                    }
                                    if (z) {
                                    }
                                    throw th;
                                }
                            } else {
                                if (e.c) {
                                    Log.e("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + a2.c + ", " + a5 + ", key: " + this.h);
                                }
                                throw new com.bytedance.sdk.openadsdk.i.c.b("Content-Length not match, old length: " + a2.c + ", new length: " + a5 + ", rawKey: " + this.g + ", currentUrl: " + aVar + ", previousInfo: " + a2.e);
                            }
                        } else {
                            throw new c(a4 + ", rawKey: " + this.g + ", url: " + aVar);
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        d.a(a3.d());
                        if (hVar != null) {
                        }
                        if (z) {
                        }
                        throw th;
                    }
                }
            } else if (e.c) {
                Log.i("TAG_PROXY_DownloadTask", "file download complete, key: " + this.h);
            }
        } else if (e.c) {
            Log.i("TAG_PROXY_DownloadTask", "no necessary to download for " + this.h + ", cache file size: " + length + ", max: " + this.o);
        }
    }

    /* compiled from: DownloadTask */
    static final class a {
        String a;
        String b;
        l c;
        com.bytedance.sdk.openadsdk.i.a.a d;
        com.bytedance.sdk.openadsdk.i.b.c e;
        List<i.b> f;
        int g;
        i h;
        AbstractC0055b i;
        Object j;

        a() {
        }

        a a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.a = str;
                return this;
            }
            throw new IllegalArgumentException("rawKey == null");
        }

        a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
                return this;
            }
            throw new IllegalArgumentException("key == null");
        }

        a a(l lVar) {
            if (lVar != null) {
                this.c = lVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        a a(com.bytedance.sdk.openadsdk.i.a.a aVar) {
            if (aVar != null) {
                this.d = aVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        a a(com.bytedance.sdk.openadsdk.i.b.c cVar) {
            if (cVar != null) {
                this.e = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        a a(List<i.b> list) {
            this.f = list;
            return this;
        }

        a a(int i2) {
            this.g = i2;
            return this;
        }

        a a(AbstractC0055b bVar) {
            this.i = bVar;
            return this;
        }

        a a(i iVar) {
            this.h = iVar;
            return this;
        }

        a a(Object obj) {
            this.j = obj;
            return this;
        }

        b a() {
            if (this.d != null && this.e != null && !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b) && this.c != null) {
                return new b(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
