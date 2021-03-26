package com.bytedance.tea.crash.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import com.bytedance.tea.crash.g.j;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/* compiled from: LooperMessageManager */
public class f implements Handler.Callback {
    private static Printer a;
    private static f b;
    private static final Printer j = new Printer() {
        /* class com.bytedance.tea.crash.e.f.AnonymousClass1 */

        @Override // android.util.Printer
        public void println(String str) {
            if (str != null) {
                if (str.startsWith(">>>>> Dispatching")) {
                    f.a().a(str);
                } else if (str.startsWith("<<<<< Finished")) {
                    f.a().b(str);
                }
                if (f.a != null && f.a != f.j) {
                    f.a.println(str);
                }
            }
        }
    };
    private Handler c = new Handler(h.a().getLooper(), this);
    private int d = 0;
    private long e;
    private long f;
    private final SparseArray<List<Runnable>> g = new SparseArray<>();
    private final List<Printer> h = new LinkedList();
    private final List<Printer> i = new LinkedList();
    private boolean k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1345l;

    private f() {
        b();
    }

    public static f a() {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new f();
                }
            }
        }
        return b;
    }

    public void b() {
        if (!this.k) {
            this.k = true;
            Printer e2 = e();
            a = e2;
            Printer printer = j;
            if (e2 == printer) {
                a = null;
            }
            Looper.getMainLooper().setMessageLogging(printer);
        }
    }

    private Printer e() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e2) {
            j.b(e2);
            return null;
        }
    }

    public void a(long j2, Runnable runnable) {
        a(j2, runnable, 1, 0);
    }

    public void a(long j2, Runnable runnable, int i2, long j3) {
        if (j2 >= 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = (int) j2;
                List<Runnable> list = this.g.get(i4);
                if (list == null) {
                    synchronized (this.g) {
                        list = this.g.get(i4);
                        if (list == null) {
                            list = new LinkedList<>();
                            this.g.put(i4, list);
                        }
                    }
                }
                list.add(runnable);
                j2 += j3;
            }
        }
    }

    public void a(Printer printer) {
        this.i.add(printer);
    }

    public synchronized void b(Printer printer) {
        this.h.add(printer);
    }

    void a(String str) {
        if (!this.f1345l) {
            g.a(32);
            this.f1345l = true;
        }
        this.e = SystemClock.uptimeMillis();
        try {
            a(this.h, str);
            this.c.sendEmptyMessage(0);
        } catch (Exception e2) {
            j.a(e2);
        }
    }

    void b(String str) {
        this.f = SystemClock.uptimeMillis();
        try {
            this.c.removeMessages(2);
            a(this.i, str);
            this.c.sendEmptyMessage(1);
        } catch (Exception e2) {
            j.b(e2);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.c.hasMessages(0)) {
            return true;
        }
        int i2 = message.what;
        if (i2 == 0) {
            this.d = 0;
            if (this.g.size() != 0 && this.g.keyAt(0) == 0) {
                a(this.g.valueAt(0));
                this.d++;
            }
        } else if (i2 == 1) {
            this.c.removeMessages(2);
            if (this.g.size() != 0) {
                SparseArray<List<Runnable>> sparseArray = this.g;
                if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                    a(this.g.get(Integer.MAX_VALUE));
                }
            }
            return true;
        } else if (i2 == 2) {
            a(this.g.valueAt(this.d));
            this.d++;
        }
        if (this.d >= this.g.size()) {
            return true;
        }
        long keyAt = (long) this.g.keyAt(this.d);
        if (keyAt != 2147483647L) {
            this.c.sendEmptyMessageAtTime(2, this.e + keyAt);
        }
        return true;
    }

    private static void a(List<? extends Runnable> list) {
        if (list != null && !list.isEmpty()) {
            try {
                for (Runnable runnable : list) {
                    runnable.run();
                }
            } catch (Exception e2) {
                j.a(e2);
            }
        }
    }

    private synchronized void a(List<? extends Printer> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    for (Printer printer : list) {
                        printer.println(str);
                    }
                } catch (Exception e2) {
                    j.a(e2);
                }
            }
        }
    }
}
