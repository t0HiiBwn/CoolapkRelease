package com.bytedance.tea.crash.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import com.bytedance.tea.crash.e.c;
import com.bytedance.tea.crash.e.f;
import com.bytedance.tea.crash.e.h;
import com.bytedance.tea.crash.g.j;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LooperMonitor */
public class g {
    public static long a = -1;
    public static long b = -1;
    private static boolean c = false;
    private static boolean d = true;
    private static int e;
    private static List<a> f;
    private static volatile AtomicLong g = new AtomicLong(-1);
    private static long h = 100;
    private static long i;
    private static HandlerThread j;
    private static long k;

    /* renamed from: l  reason: collision with root package name */
    private static long f1343l;
    private static Handler m;
    private static int n;
    private static boolean o;
    private static volatile String p = null;
    private static volatile boolean q = false;
    private static int r = -1;
    private static int s = -1;
    private static MessageQueue t = null;
    private static Field u = null;
    private static Field v = null;

    static /* synthetic */ int j() {
        int i2 = n;
        n = i2 + 1;
        return i2;
    }

    public static void a(int i2, int i3) {
        if (d) {
            if (i2 > 10) {
                e = i2;
            }
            if (i3 > 10) {
                h = (long) i3;
            }
            f = new ArrayList();
            a();
            a(d());
        }
    }

    /* compiled from: LooperMonitor */
    public static class a {
        public int a;
        public int b;
        public long c;
        public long d;
        public long e;
        public boolean f;
        public String g;

        public String toString() {
            int i = this.b;
            if (i == 0) {
                return "[[[ IDLE  ]]] cost " + this.c + " tick , mDuration：" + this.d + ",cpuTime:" + this.e;
            } else if (i == 1) {
                return "[[[ Long IDLE  ]]] cost " + this.c + " tick , mDuration：" + this.d + ",cpuTime:" + this.e;
            } else if (i == 2) {
                return "[[[  1 msg  ]]] cost " + this.c + " tick , mDuration：" + this.d + ",cpuTime:" + this.e + ", msg:" + this.g;
            } else if (i == 3) {
                return "[[[ 1 msg + IDLE  ]]] cost " + this.c + " tick , mDuration：" + this.d + ",cpuTime:" + this.e;
            } else if (i == 4) {
                return "[[[ " + (this.a - 1) + " msgs  ]]] cost less than 1 tick, [[[  last msg ]]] cost more than " + (this.c - 1) + "tick ,, mDuration：" + this.d + "cpuTime:" + this.e + " msg:" + this.g;
            } else if (i == 5) {
                return "[[[ " + this.a + " msgs ]]] cost less than 1 tick but [[[  IDLE ]]] cost more than" + (this.c - 1) + " ticks, , mDuration：" + this.d + "cpuTime:" + this.e;
            } else if (i == 6) {
                return "[[[  1 msg  ]]] cost less than 1 tick , but [[[  IDLE ]]] cost more than" + (this.c - 1) + ", , mDuration：" + this.d + "cpuTime:" + this.e;
            } else if (i == 7) {
                return "[[[ " + this.a + " msgs + IDLE  ]]] cost 1 tick , mDuration：" + this.d + " cost cpuTime:" + this.e;
            } else if (i == 8) {
                return "[[[ 1 msgs ]]] cost " + this.c + " ticks , mDuration：" + this.d + " cost cpuTime:" + this.e + " msg:" + this.g;
            } else if (i == 9) {
                return "[[[ " + this.a + " msgs ]]] cost 1 tick , mDuration：" + this.d + " cost cpuTime:" + this.e;
            } else {
                return "=========   UNKNOW =========  Type:" + this.b + " cost ticks " + this.c + " msgs:" + this.a;
            }
        }
    }

    public static void a() {
        com.bytedance.tea.crash.e.g.a(4);
        f.a().b();
        f.a().b(new Printer() {
            /* class com.bytedance.tea.crash.a.g.AnonymousClass1 */

            @Override // android.util.Printer
            public void println(String str) {
                int i;
                if (g.d) {
                    String unused = g.p = str;
                    if (!g.o) {
                        boolean unused2 = g.o = true;
                        int unused3 = g.r = Process.myTid();
                        g.u();
                    }
                    g.a = g.g.get();
                    if (g.b != -1) {
                        long j = g.a - g.b;
                        if (j <= 0) {
                            g.j();
                            return;
                        }
                        if (j == 1) {
                            i = g.n > 1 ? 7 : g.n == 1 ? 3 : 0;
                        } else if (g.n > 1) {
                            i = 5;
                        } else {
                            i = g.n == 1 ? 6 : 1;
                        }
                        long v = g.v();
                        long uptimeMillis = SystemClock.uptimeMillis();
                        if (!g.q) {
                            g.b(g.t(), v - g.k, uptimeMillis - g.f1343l, j, i, g.n, null);
                        }
                        long unused4 = g.k = v;
                        long unused5 = g.f1343l = uptimeMillis;
                        int unused6 = g.n = 1;
                    }
                }
            }
        });
        f.a().a(new Printer() {
            /* class com.bytedance.tea.crash.a.g.AnonymousClass2 */

            @Override // android.util.Printer
            public void println(String str) {
                int i;
                g.b = g.g.get();
                if (g.a > 0) {
                    long j = g.b - g.a;
                    if (j > 0) {
                        long v = g.v();
                        long uptimeMillis = SystemClock.uptimeMillis();
                        int i2 = (j > 1 ? 1 : (j == 1 ? 0 : -1));
                        if (i2 == 0 && g.n > 1) {
                            i = 9;
                        } else if (i2 == 0 && g.n == 1) {
                            i = 2;
                        } else if (i2 <= 0 || g.n <= 1) {
                            i = (i2 <= 0 || g.n != 1) ? 0 : 8;
                        } else {
                            i = 4;
                        }
                        if (!g.q) {
                            g.b(g.t(), v - g.k, uptimeMillis - g.f1343l, j, i, g.n, str);
                        }
                        long unused = g.k = v;
                        long unused2 = g.f1343l = uptimeMillis;
                        int unused3 = g.n = 0;
                        g.a = -1;
                    }
                }
            }
        });
        k = v();
        f1343l = SystemClock.uptimeMillis();
    }

    /* access modifiers changed from: private */
    public static a t() {
        int size = f.size();
        int i2 = e;
        if (size == i2) {
            int i3 = (s + 1) % i2;
            s = i3;
            return f.get(i3);
        }
        a aVar = new a();
        f.add(aVar);
        s++;
        return aVar;
    }

    /* access modifiers changed from: private */
    public static void b(a aVar, long j2, long j3, long j4, int i2, int i3, String str) {
        aVar.e = j2;
        aVar.c = j4;
        aVar.d = j3;
        aVar.f = false;
        aVar.a = i3;
        if (str != null) {
            aVar.g = str;
        }
        aVar.b = i2;
    }

    public static JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        List<a> c2 = c();
        if (c2 == null) {
            return jSONArray;
        }
        int i2 = 0;
        for (a aVar : c2) {
            if (aVar != null) {
                i2++;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msg", aVar.g);
                    jSONObject.put("cpuDuration", aVar.e);
                    jSONObject.put("duration", aVar.d);
                    jSONObject.put("tick", aVar.c);
                    jSONObject.put("type", aVar.b);
                    jSONObject.put("count", aVar.a);
                    jSONObject.put("id", i2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public static List<a> c() {
        if (f == null) {
            return null;
        }
        q = true;
        ArrayList arrayList = new ArrayList();
        if (f.size() == e) {
            for (int i2 = s; i2 < f.size(); i2++) {
                arrayList.add(f.get(i2));
            }
            for (int i3 = 0; i3 < s; i3++) {
                arrayList.add(f.get(i3));
            }
        } else {
            arrayList.addAll(f);
        }
        q = false;
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static void u() {
        j = h.a();
        i = SystemClock.uptimeMillis();
        m = new Handler(j.getLooper());
        com.bytedance.tea.crash.e.g.a(8);
        m.postDelayed(new Runnable() {
            /* class com.bytedance.tea.crash.a.g.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                long j;
                g.g.set((SystemClock.uptimeMillis() - g.i) / g.h);
                long uptimeMillis = (SystemClock.uptimeMillis() - g.i) % g.h;
                if (uptimeMillis >= 95) {
                    g.g.incrementAndGet();
                    j = g.h << 1;
                } else {
                    j = g.h;
                }
                g.m.postDelayed(this, j - uptimeMillis);
            }
        }, h);
    }

    public static MessageQueue d() {
        if (t == null && Looper.getMainLooper() != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == Looper.myLooper()) {
                t = Looper.myQueue();
            } else if (Build.VERSION.SDK_INT >= 23) {
                t = mainLooper.getQueue();
            } else {
                try {
                    Field declaredField = mainLooper.getClass().getDeclaredField("mQueue");
                    declaredField.setAccessible(true);
                    t = (MessageQueue) declaredField.get(mainLooper);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return t;
    }

    private static Message a(MessageQueue messageQueue) {
        Field field = u;
        if (field == null) {
            try {
                Field declaredField = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
                u = declaredField;
                declaredField.setAccessible(true);
                return (Message) u.get(messageQueue);
            } catch (Exception unused) {
                return null;
            }
        } else {
            try {
                return (Message) field.get(messageQueue);
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    public static JSONArray a(int i2, long j2) {
        MessageQueue d2 = d();
        JSONArray jSONArray = new JSONArray();
        if (d2 == null) {
            return jSONArray;
        }
        synchronized (d2) {
            Message a2 = a(d2);
            if (a2 == null) {
                return jSONArray;
            }
            int i3 = 0;
            int i4 = 0;
            while (a2 != null && i3 < i2) {
                i3++;
                i4++;
                JSONObject a3 = a(a2, j2);
                try {
                    a3.put("id", i4);
                } catch (JSONException unused) {
                }
                jSONArray.put(a3);
                a2 = a(a2);
            }
            return jSONArray;
        }
    }

    /* access modifiers changed from: private */
    public static long v() {
        return c.a(r);
    }

    public static JSONObject a(long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", p);
            jSONObject.put("currentMessageCost", e());
            jSONObject.put("currentMessageCpu", v() - k);
            jSONObject.put("currentTick", g.get());
        } catch (Throwable th) {
            j.a(th);
        }
        return jSONObject;
    }

    private static JSONObject a(Message message, long j2) {
        JSONObject jSONObject = new JSONObject();
        if (message == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("when", message.getWhen() - j2);
            if (message.getCallback() != null) {
                jSONObject.put("callback", message.getCallback());
            }
            jSONObject.put("what", message.what);
            if (message.getTarget() != null) {
                jSONObject.put("target", message.getTarget());
            } else {
                jSONObject.put("barrier", message.arg1);
            }
            jSONObject.put("arg1", message.arg1);
            jSONObject.put("arg2", message.arg2);
            if (message.obj != null) {
                jSONObject.put("obj", message.obj);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static long e() {
        long uptimeMillis;
        long j2;
        long j3;
        if (a < 0) {
            uptimeMillis = SystemClock.uptimeMillis() - i;
            j2 = b;
            j3 = h;
        } else {
            uptimeMillis = SystemClock.uptimeMillis() - i;
            j2 = a;
            j3 = h;
        }
        return uptimeMillis - (j2 * j3);
    }

    private static Message a(Message message) {
        Field field = v;
        if (field == null) {
            try {
                Field declaredField = Class.forName("android.os.Message").getDeclaredField("next");
                v = declaredField;
                declaredField.setAccessible(true);
                Message message2 = (Message) v.get(message);
                if (c) {
                    Log.i("LooperMonitor", "[getNextMessage] success get next msg :" + message2);
                }
                return message2;
            } catch (Exception unused) {
                return null;
            }
        } else {
            try {
                return (Message) field.get(message);
            } catch (Exception unused2) {
                return null;
            }
        }
    }
}
