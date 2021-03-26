package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UMConfigureImpl {
    private static String a = "delayed_transmission_flag_new";
    private static CopyOnWriteArrayList<onMessageSendListener> b = new CopyOnWriteArrayList<>();
    private static int c = 0;
    private static boolean d = false;
    private static final int e = 1000;
    private static ScheduledExecutorService f;
    private static Context g;
    private static int h = 0;
    private static Runnable i = new Runnable() {
        /* class com.umeng.commonsdk.UMConfigureImpl.AnonymousClass1 */

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.c == 0 || UMConfigureImpl.h >= 10) {
                    if (!UMConfigureImpl.d) {
                        boolean unused = UMConfigureImpl.d = true;
                        UMConfigureImpl.b(UMConfigureImpl.g);
                    }
                    if (UMConfigureImpl.f != null) {
                        UMConfigureImpl.f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    static /* synthetic */ int f() {
        int i2 = h;
        h = i2 + 1;
        return i2;
    }

    public static void init(Context context) {
        if (context != null) {
            g = context;
            try {
                if (c < 1) {
                    UMEnvelopeBuild.setTransmissionSendFlag(true);
                } else if (!d(context)) {
                    UMEnvelopeBuild.setTransmissionSendFlag(false);
                    c(context);
                    if (f == null) {
                        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                        f = newScheduledThreadPool;
                        newScheduledThreadPool.scheduleAtFixedRate(i, 0, 100, TimeUnit.MILLISECONDS);
                    }
                } else {
                    UMEnvelopeBuild.setTransmissionSendFlag(true);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static synchronized void b(Context context) {
        synchronized (UMConfigureImpl.class) {
            UMEnvelopeBuild.setTransmissionSendFlag(true);
            CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = b;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                Iterator<onMessageSendListener> it2 = b.iterator();
                while (it2.hasNext()) {
                    it2.next().onMessageSend();
                }
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static synchronized void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList;
        synchronized (UMConfigureImpl.class) {
            CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList2 = b;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.add(onmessagesendlistener);
            }
            if (UMEnvelopeBuild.getTransmissionSendFlag() && (copyOnWriteArrayList = b) != null && copyOnWriteArrayList.size() > 0) {
                Iterator<onMessageSendListener> it2 = b.iterator();
                while (it2.hasNext()) {
                    it2.next().onMessageSend();
                }
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static synchronized void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            CopyOnWriteArrayList<onMessageSendListener> copyOnWriteArrayList = b;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.remove(onmessagesendlistener);
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static synchronized void registerInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            c++;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static synchronized void removeInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            c--;
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            if (sharedPreferences != null && sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(a, true);
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean(a, false);
        } catch (Throwable unused) {
            return false;
        }
    }
}
