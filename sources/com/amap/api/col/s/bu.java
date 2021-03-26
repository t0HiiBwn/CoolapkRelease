package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: AdiuStorageModel */
public final class bu {
    public static final String a = bs.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    private static bu f;
    private List<String> b;
    private String c;
    private final Context d;
    private final Handler e;

    public static bu a(Context context) {
        if (f == null) {
            synchronized (bu.class) {
                if (f == null) {
                    f = new bu(context);
                }
            }
        }
        return f;
    }

    private bu(Context context) {
        this.d = context.getApplicationContext();
        if (Looper.myLooper() == null) {
            this.e = new a(Looper.getMainLooper(), this);
        } else {
            this.e = new a(this);
        }
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void b(String str) {
        List<String> list = this.b;
        if (list != null) {
            list.clear();
            this.b.add(str);
        }
        a(str, 273);
    }

    /* access modifiers changed from: private */
    public synchronized void a(final String str, final int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread() {
                /* class com.amap.api.col.s.bu.AnonymousClass1 */

                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    String b2 = ca.b(str);
                    if (!TextUtils.isEmpty(b2)) {
                        if ((i & 1) > 0) {
                            try {
                                if (Build.VERSION.SDK_INT >= 23) {
                                    Settings.System.putString(bu.this.d.getContentResolver(), bu.this.c, b2);
                                } else {
                                    Settings.System.putString(bu.this.d.getContentResolver(), bu.this.c, b2);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        if ((i & 16) > 0) {
                            bw.a(bu.this.d, bu.this.c, b2);
                        }
                        if ((i & 256) > 0) {
                            SharedPreferences.Editor edit = bu.this.d.getSharedPreferences(bu.a, 0).edit();
                            edit.putString(bu.this.c, b2);
                            if (Build.VERSION.SDK_INT >= 9) {
                                edit.apply();
                            } else {
                                edit.commit();
                            }
                        }
                    }
                }
            }.start();
            return;
        }
        String b2 = ca.b(str);
        if (!TextUtils.isEmpty(b2)) {
            if ((i & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        Settings.System.putString(this.d.getContentResolver(), this.c, b2);
                    } else {
                        Settings.System.putString(this.d.getContentResolver(), this.c, b2);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i & 16) > 0) {
                bw.a(this.d, this.c, b2);
            }
            if ((i & 256) > 0) {
                SharedPreferences.Editor edit = this.d.getSharedPreferences(a, 0).edit();
                edit.putString(this.c, b2);
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                    return;
                }
                edit.commit();
            }
        }
    }

    /* compiled from: AdiuStorageModel */
    private static final class a extends Handler {
        private final WeakReference<bu> a;

        a(bu buVar) {
            this.a = new WeakReference<>(buVar);
        }

        a(Looper looper, bu buVar) {
            super(looper);
            this.a = new WeakReference<>(buVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            bu buVar = this.a.get();
            if (buVar != null && message != null && message.obj != null) {
                buVar.a((String) message.obj, message.what);
            }
        }
    }
}
