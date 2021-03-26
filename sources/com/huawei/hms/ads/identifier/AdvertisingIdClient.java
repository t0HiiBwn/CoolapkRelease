package com.huawei.hms.ads.identifier;

import XI.kM.XI.XI.XI.K0;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.IOException;

public class AdvertisingIdClient {
    private static final String SETTINGS_AD_ID = "pps_oaid";
    private static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";

    public static final class Info {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        public Info(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        public final String getId() {
            return this.advertisingId;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    public static class XI implements Runnable {

        /* renamed from: XI  reason: collision with root package name */
        public final /* synthetic */ Context f1350XI;

        public XI(Context context) {
            this.f1350XI = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AdvertisingIdClient.requestAdvertisingIdInfo(this.f1350XI);
            } catch (Throwable unused) {
            }
        }
    }

    public static Info getAdvertisingIdInfo(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    updateAdvertisingIdInfo(context);
                    return new Info(string, Boolean.valueOf(string2).booleanValue());
                }
            } catch (Throwable unused) {
            }
        }
        return requestAdvertisingIdInfo(context);
    }

    public static boolean isAdvertisingIdAvailable(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static Info requestAdvertisingIdInfo(Context context) {
        try {
            boolean z = false;
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            XI.kM.XI.XI.XI.XI xi = new XI.kM.XI.XI.XI.XI();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (context.bindService(intent, xi, 1)) {
                try {
                    if (!xi.f1179XI) {
                        xi.f1179XI = true;
                        IBinder take = xi.K0.take();
                        Parcel obtain = Parcel.obtain();
                        Parcel obtain2 = Parcel.obtain();
                        try {
                            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                            take.transact(1, obtain, obtain2, 0);
                            obtain2.readException();
                            String readString = obtain2.readString();
                            obtain2.recycle();
                            obtain.recycle();
                            Parcel obtain3 = Parcel.obtain();
                            Parcel obtain4 = Parcel.obtain();
                            try {
                                obtain3.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                                take.transact(2, obtain3, obtain4, 0);
                                obtain4.readException();
                                if (obtain4.readInt() != 0) {
                                    z = true;
                                }
                                obtain4.recycle();
                                obtain3.recycle();
                                Info info = new Info(readString, z);
                                try {
                                    context.unbindService(xi);
                                } catch (Throwable th) {
                                    th.getClass().getSimpleName();
                                }
                                return info;
                            } catch (Throwable th2) {
                                obtain4.recycle();
                                obtain3.recycle();
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            obtain2.recycle();
                            obtain.recycle();
                            throw th3;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (InterruptedException unused) {
                    throw new IOException("bind hms service InterruptedException");
                } catch (RemoteException unused2) {
                    throw new IOException("bind hms service RemoteException");
                } catch (Throwable th4) {
                    th4.getClass().getSimpleName();
                }
            } else {
                throw new IOException("bind failed");
            }
            throw th;
        } catch (PackageManager.NameNotFoundException unused3) {
            throw new IOException("Service not found");
        }
    }

    private static void updateAdvertisingIdInfo(Context context) {
        K0.f1178XI.execute(new XI(context));
    }

    public static boolean verifyAdId(Context context, String str, boolean z) {
        try {
            Info requestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
            return requestAdvertisingIdInfo != null && TextUtils.equals(str, requestAdvertisingIdInfo.getId()) && z == requestAdvertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable unused) {
            throw new AdIdVerifyException("Something wrong with verification, please try later.");
        }
    }
}
