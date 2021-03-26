package XI.CA.XI;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

public class K0 {
    public static kM CA;
    public static volatile XI CV;
    public static Handler FL;
    public static HandlerThread J9;
    public static boolean K0;
    public static String WI;

    /* renamed from: XI  reason: collision with root package name */
    public static Context f1165XI;
    public static String bs;
    public static String cs;
    public static kM kM;
    public static volatile K0 q6;
    public static Object vs = new Object();
    public static kM xo;

    public static class XI extends Handler {
        public XI(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 11) {
                int i = message.getData().getInt("type");
                try {
                    String XI2 = K0.CV.XI(i, message.getData().getString("appid"));
                    if (i == 0) {
                        K0.WI = XI2;
                    } else if (i != 1) {
                        if (i == 2) {
                            if (XI2 != null) {
                                K0.cs = XI2;
                            }
                        }
                    } else if (XI2 != null) {
                        K0.bs = XI2;
                    }
                } catch (Exception e) {
                    e.toString();
                }
                Context context = K0.f1165XI;
                synchronized (K0.vs) {
                    K0.vs.notify();
                }
            }
        }
    }

    public K0() {
        XI();
        CV = new XI(f1165XI);
    }

    public static boolean K0() {
        String str = "0";
        if (!K0 && Build.VERSION.SDK_INT >= 28) {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            try {
                str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "persist.sys.identifierid.supported", str);
            } catch (Exception unused) {
            }
            K0 = "1".equals(str);
        }
        return K0;
    }

    public static K0 XI(Context context) {
        if (!K0()) {
            return null;
        }
        if (f1165XI == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f1165XI = context;
        }
        if (q6 == null) {
            synchronized (K0.class) {
                if (q6 == null) {
                    q6 = new K0();
                }
            }
        }
        return q6;
    }

    public static void XI() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        J9 = handlerThread;
        handlerThread.start();
        FL = new XI(J9.getLooper());
    }

    public static synchronized void XI(Context context, int i, String str) {
        ContentResolver contentResolver;
        Uri parse;
        kM kMVar;
        synchronized (K0.class) {
            String packageName = context.getPackageName();
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        if (CA == null) {
                            int i2 = Build.VERSION.SDK_INT;
                            if (i2 >= 29) {
                                CA = new kM(q6, 2, packageName);
                                contentResolver = context.getContentResolver();
                                parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + packageName);
                                kMVar = CA;
                            } else if (i2 == 28) {
                                CA = new kM(q6, 2, str);
                                contentResolver = context.getContentResolver();
                                parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
                                kMVar = CA;
                            }
                        }
                    }
                } else if (xo == null) {
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 >= 29) {
                        xo = new kM(q6, 1, packageName);
                        contentResolver = context.getContentResolver();
                        parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + packageName);
                        kMVar = xo;
                    } else if (i3 == 28) {
                        xo = new kM(q6, 1, str);
                        contentResolver = context.getContentResolver();
                        parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
                        kMVar = xo;
                    }
                }
                contentResolver.registerContentObserver(parse, false, kMVar);
            } else if (kM == null) {
                kM = new kM(q6, 0, null);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, kM);
            }
        }
    }

    public void K0(int i, String str) {
        Message obtainMessage = FL.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        if (i == 1 || i == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        FL.sendMessage(obtainMessage);
    }

    public final void XI(int i, String str) {
        synchronized (vs) {
            K0(i, str);
            SystemClock.uptimeMillis();
            try {
                vs.wait(2000);
            } catch (InterruptedException unused) {
            }
            SystemClock.uptimeMillis();
        }
    }
}
