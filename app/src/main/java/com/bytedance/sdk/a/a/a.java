package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: AsyncTimeout */
public class a extends t {
    static a a;
    private static final long b;
    private static final long d;
    private boolean e;
    private a f;
    private long g;

    protected void a_() {
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        b = millis;
        d = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void a() {
        if (!this.e) {
            long b_ = b_();
            boolean c = c();
            if (b_ != 0 || c) {
                this.e = true;
                a(this, b_, c);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    private static synchronized void a(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (a == null) {
                a = new a();
                C0027a aVar2 = new C0027a();
                aVar2.setName("tt_pangle_thread_watch_dog");
                aVar2.start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0 && z) {
                aVar.g = Math.min(j, aVar.c_() - nanoTime) + nanoTime;
            } else if (i != 0) {
                aVar.g = j + nanoTime;
            } else if (z) {
                aVar.g = aVar.c_();
            } else {
                throw new AssertionError();
            }
            long b2 = aVar.b(nanoTime);
            a aVar3 = a;
            while (true) {
                a aVar4 = aVar3.f;
                if (aVar4 == null) {
                    break;
                } else if (b2 < aVar4.b(nanoTime)) {
                    break;
                } else {
                    aVar3 = aVar3.f;
                }
            }
            aVar.f = aVar3.f;
            aVar3.f = aVar;
            if (aVar3 == a) {
                a.class.notify();
            }
        }
    }

    public final boolean b() {
        if (!this.e) {
            return false;
        }
        this.e = false;
        return a(this);
    }

    private static synchronized boolean a(a aVar) {
        synchronized (a.class) {
            a aVar2 = a;
            while (aVar2 != null) {
                a aVar3 = aVar2.f;
                if (aVar3 == aVar) {
                    aVar2.f = aVar.f;
                    aVar.f = null;
                    return false;
                }
                aVar2 = aVar3;
            }
            return true;
        }
    }

    private long b(long j) {
        return this.g - j;
    }

    public final r a(final r rVar) {
        return new r() {
            /* class com.bytedance.sdk.a.a.a.AnonymousClass1 */

            @Override // com.bytedance.sdk.a.a.r
            public void a_(c cVar, long j) throws IOException {
                u.a(cVar.b, 0, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        o oVar = cVar.a;
                        while (true) {
                            if (j2 >= 65536) {
                                break;
                            }
                            j2 += (long) (oVar.c - oVar.b);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            oVar = oVar.f;
                        }
                        a.this.a();
                        try {
                            rVar.a_(cVar, j2);
                            j -= j2;
                            a.this.a(true);
                        } catch (IOException e) {
                            throw a.this.a(e);
                        } catch (Throwable th) {
                            a.this.a(false);
                            throw th;
                        }
                    } else {
                        return;
                    }
                }
            }

            @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
            public void flush() throws IOException {
                a.this.a();
                try {
                    rVar.flush();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.a(e);
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                a.this.a();
                try {
                    rVar.close();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.a(e);
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.a.a.r
            public t a() {
                return a.this;
            }

            @Override // java.lang.Object
            public String toString() {
                return "AsyncTimeout.sink(" + rVar + ")";
            }
        };
    }

    public final s a(final s sVar) {
        return new s() {
            /* class com.bytedance.sdk.a.a.a.AnonymousClass2 */

            @Override // com.bytedance.sdk.a.a.s
            public long a(c cVar, long j) throws IOException {
                a.this.a();
                try {
                    long a2 = sVar.a(cVar, j);
                    a.this.a(true);
                    return a2;
                } catch (IOException e) {
                    throw a.this.a(e);
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                a.this.a();
                try {
                    sVar.close();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.a(e);
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.a.a.s
            public t a() {
                return a.this;
            }

            @Override // java.lang.Object
            public String toString() {
                return "AsyncTimeout.source(" + sVar + ")";
            }
        };
    }

    final void a(boolean z) throws IOException {
        if (b() && z) {
            throw b((IOException) null);
        }
    }

    final IOException a(IOException iOException) throws IOException {
        if (!b()) {
            return iOException;
        }
        return b(iOException);
    }

    protected IOException b(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: com.bytedance.sdk.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: AsyncTimeout */
    private static final class C0027a extends Thread {
        C0027a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0015, code lost:
            r1.a_();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    synchronized (a.class) {
                        a d = a.d();
                        if (d != null) {
                            if (d == a.a) {
                                a.a = null;
                                return;
                            }
                        }
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    static a d() throws InterruptedException {
        a aVar = a.f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(b);
            if (a.f != null || System.nanoTime() - nanoTime < d) {
                return null;
            }
            return a;
        }
        long b2 = aVar.b(System.nanoTime());
        if (b2 > 0) {
            long j = b2 / 1000000;
            a.class.wait(j, (int) (b2 - (1000000 * j)));
            return null;
        }
        a.f = aVar.f;
        aVar.f = null;
        return aVar;
    }
}
