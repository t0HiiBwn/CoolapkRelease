package com.amap.api.mapcore2d;

import com.amap.api.maps2d.AMapException;
import com.amap.api.maps2d.MapsInitializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* compiled from: AsyncServer */
abstract class f<T, V> extends aw {
    protected bo<T> a;
    private volatile boolean c = true;
    private Vector<Thread> d = null;
    private Runnable e = new Runnable() {
        /* class com.amap.api.mapcore2d.f.AnonymousClass1 */

        @Override // java.lang.Runnable
        public void run() {
            Thread currentThread = Thread.currentThread();
            if (currentThread != null) {
                currentThread.setName("TaskRunDownLoad");
            }
            try {
                if (f.this.d != null) {
                    f.this.d.add(currentThread);
                }
                ArrayList<T> arrayList = null;
                ArrayList<T> arrayList2 = null;
                while (f.this.c && !Thread.interrupted()) {
                    if (f.this.b == null) {
                        f.this.c = false;
                    } else if (!MapsInitializer.getNetworkEnable()) {
                        try {
                            if (!Thread.interrupted()) {
                                Thread.sleep(200);
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        } catch (Exception e) {
                            cm.a(e, "AsyncServer", "run");
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        if (f.this.a != null) {
                            arrayList = f.this.a.a(f.this.g(), false);
                        }
                        if (arrayList == null || arrayList.size() != 0) {
                            if (f.this.c) {
                                if (arrayList != null) {
                                    if (f.this.c) {
                                        if (f.this.b != null) {
                                            try {
                                                arrayList2 = f.this.a(arrayList);
                                            } catch (AMapException e2) {
                                                cm.a(e2, "AsyncServer", "run");
                                            }
                                            if (!(arrayList2 == null || f.this.a == null)) {
                                                f.this.a.a((List) arrayList2, false);
                                            }
                                        }
                                    } else {
                                        return;
                                    }
                                }
                                if (f.this.c && !Thread.interrupted()) {
                                    try {
                                        Thread.sleep(50);
                                    } catch (InterruptedException unused2) {
                                        Thread.currentThread().interrupt();
                                    } catch (Exception e3) {
                                        cm.a(e3, "AsyncServer", "run");
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                cm.a(th, "AsyncServer", "run");
            }
        }
    };
    private Runnable f = new Runnable() {
        /* class com.amap.api.mapcore2d.f.AnonymousClass2 */

        @Override // java.lang.Runnable
        public void run() {
            Thread currentThread = Thread.currentThread();
            if (currentThread != null) {
                currentThread.setName("TaskRunCach");
            }
            try {
                if (!(f.this.d == null || currentThread == null)) {
                    f.this.d.add(currentThread);
                }
                ArrayList<T> arrayList = null;
                ArrayList<T> arrayList2 = null;
                while (f.this.c && !Thread.interrupted()) {
                    if (f.this.b == null) {
                        f.this.c = false;
                    } else {
                        if (f.this.a != null) {
                            arrayList = f.this.a.a(f.this.g(), true);
                        }
                        if (arrayList == null || arrayList.size() != 0) {
                            if (f.this.c) {
                                try {
                                    arrayList2 = f.this.b(arrayList);
                                } catch (Throwable th) {
                                    cm.a(th, "AsyncServer", "run");
                                }
                                if (!(arrayList2 == null || f.this.a == null || !cm.a(ar.a))) {
                                    f.this.a.a((List) arrayList2, false);
                                }
                                if (f.this.c && !Thread.interrupted()) {
                                    try {
                                        Thread.sleep(50);
                                    } catch (InterruptedException unused) {
                                        Thread.currentThread().interrupt();
                                    } catch (Throwable th2) {
                                        cm.a(th2, "AsyncServer", "run");
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                cm.a(th3, "AsyncServer", "run");
            }
        }
    };
    private bq g;

    protected abstract ArrayList<T> a(ArrayList<T> arrayList) throws AMapException;

    protected abstract ArrayList<T> b(ArrayList<T> arrayList) throws AMapException;

    protected abstract int f();

    protected abstract int g();

    public f(az azVar) {
        super(azVar);
    }

    protected void a() {
        if (this.d == null) {
            this.d = new Vector<>();
        }
        bq bqVar = new bq(f(), this.f, this.e);
        this.g = bqVar;
        bqVar.a();
    }

    @Override // com.amap.api.mapcore2d.aw
    public void b() {
        bo<T> boVar = this.a;
        if (boVar != null) {
            boVar.a();
        }
        e();
        bo<T> boVar2 = this.a;
        if (boVar2 != null) {
            boVar2.b();
        }
        this.a = null;
        this.f = null;
        this.e = null;
        this.b = null;
    }

    @Override // com.amap.api.mapcore2d.aw
    public void c() {
        super.c();
        e();
    }

    @Override // com.amap.api.mapcore2d.aw
    public void d() {
        try {
            if (!this.c) {
                this.c = true;
                if (this.d == null) {
                    this.d = new Vector<>();
                }
                if (this.g == null) {
                    bq bqVar = new bq(f(), this.f, this.e);
                    this.g = bqVar;
                    bqVar.a();
                }
            }
        } catch (Throwable th) {
            cm.a(th, "AsyncServer", "onResume");
        }
    }

    public void e() {
        try {
            this.c = false;
            Vector<Thread> vector = this.d;
            if (vector != null) {
                int size = vector.size();
                for (int i = 0; i < size; i++) {
                    Thread thread = this.d.get(0);
                    if (thread != null) {
                        thread.interrupt();
                        this.d.remove(0);
                    }
                }
                this.d = null;
            }
            bq bqVar = this.g;
            if (bqVar != null) {
                bqVar.b();
                this.g = null;
            }
        } catch (Throwable th) {
            cm.a(th, "AsyncServer", "stopThreads");
        }
    }
}
