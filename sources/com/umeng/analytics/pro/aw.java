package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: SamsungDeviceIdSupplier */
public class aw implements aq {
    private static final String a = "DeviceIdService";
    private static final String b = "com.samsung.android.deviceidservice";
    private static final String c = "com.samsung.android.deviceidservice.DeviceIdService";
    private String d = "";
    private CountDownLatch e;
    private final ServiceConnection f = new ServiceConnection() {
        /* class com.umeng.analytics.pro.aw.AnonymousClass1 */

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a a2 = a.AbstractBinderC0139a.a(iBinder);
                aw.this.d = a2.a();
                Log.d("DeviceIdService", "onServiceConnected");
            } catch (RemoteException | NullPointerException e) {
                Log.e("DeviceIdService", "onServiceConnected failed e=" + e.getMessage());
            }
            aw.this.e.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("DeviceIdService", "onServiceDisconnected");
        }
    };

    /* JADX INFO: finally extract failed */
    @Override // com.umeng.analytics.pro.aq
    public String a(Context context) {
        this.e = new CountDownLatch(1);
        try {
            b(context);
            if (!this.e.await(500, TimeUnit.MILLISECONDS)) {
                Log.e("DeviceIdService", "getOAID time-out");
            }
            String str = this.d;
            c(context);
            return str;
        } catch (InterruptedException e2) {
            Log.e("DeviceIdService", "getOAID interrupted. e=" + e2.getMessage());
            c(context);
            return null;
        } catch (Throwable th) {
            c(context);
            throw th;
        }
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (!context.bindService(intent, this.f, 1)) {
                throw new UnsupportedOperationException("not supported service");
            }
        } catch (Error | Exception e2) {
            Log.e("DeviceIdService", "bindService failed. e=" + e2.getMessage());
            this.e.countDown();
        }
    }

    private void c(Context context) {
        try {
            context.unbindService(this.f);
        } catch (Error | Exception e2) {
            Log.e("DeviceIdService", "unbindService failed. e=" + e2.getMessage());
        }
    }
}
