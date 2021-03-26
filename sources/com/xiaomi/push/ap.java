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

class ap implements ar {
    private static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private volatile int f198a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f199a;

    /* renamed from: a  reason: collision with other field name */
    private ServiceConnection f200a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f201a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private volatile String f202a = null;
    private volatile String b = null;

    /* renamed from: b  reason: collision with other field name */
    private volatile boolean f203b = false;

    private class a implements ServiceConnection {
        private a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ap.this.f202a = b.a(iBinder);
                ap.this.f203b = b.m107a(iBinder);
                ap.this.mo106b();
                ap.this.f198a = 2;
                synchronized (ap.this.f201a) {
                    try {
                        ap.this.f201a.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                ap.this.mo106b();
                ap.this.f198a = 2;
                synchronized (ap.this.f201a) {
                    try {
                        ap.this.f201a.notifyAll();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                ap.this.mo106b();
                ap.this.f198a = 2;
                synchronized (ap.this.f201a) {
                    try {
                        ap.this.f201a.notifyAll();
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

        /* renamed from: a  reason: collision with other method in class */
        static boolean m107a(IBinder iBinder) {
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

    public ap(Context context) {
        this.f199a = context;
        mo105a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    private static String a(Context context) {
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

    @Override // com.xiaomi.push.ar
    /* renamed from: a */
    private void mo105a() {
        boolean z;
        this.f200a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        int i = 1;
        try {
            z = this.f199a.bindService(intent, this.f200a, 1);
        } catch (Exception unused) {
            z = false;
        }
        if (!z) {
            i = 2;
        }
        this.f198a = i;
    }

    private void a(String str) {
        if (this.f198a == 1 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.f201a) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.m41a("huawei's " + str + " wait...");
                    this.f201a.wait(3000);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m104a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
            a = packageInfo.versionCode >= 20602000;
            return z;
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public void mo106b() {
        ServiceConnection serviceConnection = this.f200a;
        if (serviceConnection != null) {
            try {
                this.f199a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: a  reason: collision with other method in class */
    public String mo105a() {
        return null;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: a */
    public boolean mo105a() {
        return a;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b  reason: collision with other method in class */
    public String mo106b() {
        a("getOAID");
        return this.f202a;
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return null;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = a(this.f199a);
                }
            }
        }
        return this.b;
    }
}
