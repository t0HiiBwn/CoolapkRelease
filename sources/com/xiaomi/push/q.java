package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.xiaomi.a.a.a.c;

class q implements s {
    private static boolean a;
    private Context b;
    private ServiceConnection c;
    private volatile int d = 0;
    private volatile String e = null;
    private volatile boolean f = false;
    private volatile String g = null;
    private final Object h = new Object();

    private class a implements ServiceConnection {
        private a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                q.this.e = b.a(iBinder);
                q.this.f = b.b(iBinder);
                q.this.g();
                q.this.d = 2;
                synchronized (q.this.h) {
                    try {
                        q.this.h.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                q.this.g();
                q.this.d = 2;
                synchronized (q.this.h) {
                    try {
                        q.this.h.notifyAll();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                q.this.g();
                q.this.d = 2;
                synchronized (q.this.h) {
                    try {
                        q.this.h.notifyAll();
                    } catch (Exception unused4) {
                    }
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static class b {
        static String a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        static boolean b(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                boolean z = false;
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z = true;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public q(Context context) {
        this.b = context;
        f();
    }

    private void a(String str) {
        if (this.d == 1 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.h) {
                try {
                    c.a("huawei's " + str + " wait...");
                    this.h.wait(3000);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
            a = packageInfo.versionCode >= 20602000;
            return z;
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    private static String b(Context context) {
        String str;
        String str2;
        String str3 = null;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                str2 = context.createDeviceProtectedStorageContext().getSharedPreferences("aaid", 0).getString("aaid", null);
                if (str2 != null) {
                    return str2;
                }
            } else {
                str2 = null;
            }
            try {
                str = context.getSharedPreferences("aaid", 0).getString("aaid", null);
            } catch (Exception unused) {
                str3 = str2;
            }
        } catch (Exception unused2) {
            str = str3;
            if (str != null) {
            }
        }
        return str != null ? "" : str;
    }

    private void f() {
        boolean z;
        this.c = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        int i = 1;
        try {
            z = this.b.bindService(intent, this.c, 1);
        } catch (Exception unused) {
            z = false;
        }
        if (!z) {
            i = 2;
        }
        this.d = i;
    }

    /* access modifiers changed from: private */
    public void g() {
        ServiceConnection serviceConnection = this.c;
        if (serviceConnection != null) {
            try {
                this.b.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.s
    public boolean a() {
        return a;
    }

    @Override // com.xiaomi.push.s
    public String b() {
        return null;
    }

    @Override // com.xiaomi.push.s
    public String c() {
        a("getOAID");
        return this.e;
    }

    @Override // com.xiaomi.push.s
    public String d() {
        return null;
    }

    @Override // com.xiaomi.push.s
    public String e() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.g = b(this.b);
                }
            }
        }
        return this.g;
    }
}
