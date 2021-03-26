package XI.K0.XI;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface XI extends IInterface {

    public class K0 {
        public ServiceConnection CA = new ServiceConnectionC0001XI();
        public String K0 = null;

        /* renamed from: XI  reason: collision with root package name */
        public XI f174XI = null;
        public String kM = null;
        public final Object xo = new Object();

        /* renamed from: XI.K0.XI.XI$K0$K0  reason: collision with other inner class name */
        public static class C0000K0 {

            /* renamed from: XI  reason: collision with root package name */
            public static final K0 f175XI = new K0();
        }

        /* renamed from: XI.K0.XI.XI$K0$XI  reason: collision with other inner class name */
        public class ServiceConnectionC0001XI implements ServiceConnection {
            public ServiceConnectionC0001XI() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                XI xi;
                K0 k0 = K0.this;
                int i = AbstractBinderC0002XI.f177XI;
                if (iBinder == null) {
                    xi = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                    xi = (queryLocalInterface == null || !(queryLocalInterface instanceof XI)) ? new AbstractBinderC0002XI.C0003XI(iBinder) : (XI) queryLocalInterface;
                }
                k0.f174XI = xi;
                synchronized (K0.this.xo) {
                    K0.this.xo.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                K0.this.f174XI = null;
            }
        }

        /* JADX INFO: finally extract failed */
        public final String K0(Context context, String str) {
            Signature[] signatureArr;
            if (TextUtils.isEmpty(this.K0)) {
                this.K0 = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.kM)) {
                String str2 = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.K0, 64).signatures;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        MessageDigest instance = MessageDigest.getInstance("SHA1");
                        if (instance != null) {
                            byte[] digest = instance.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b : digest) {
                                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                            }
                            str2 = sb.toString();
                        }
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                    }
                }
                this.kM = str2;
            }
            XI xi = this.f174XI;
            if (xi == null) {
                context.getPackageName();
                return "";
            }
            String str3 = this.K0;
            String str4 = this.kM;
            AbstractBinderC0002XI.C0003XI xi2 = (AbstractBinderC0002XI.C0003XI) xi;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str3);
                obtain.writeString(str4);
                obtain.writeString(str);
                xi2.f178XI.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                if (TextUtils.isEmpty(readString)) {
                    return "";
                }
                return readString;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }

        public synchronized String XI(Context context, String str) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return "";
            }
            if (this.f174XI == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.CA, 1)) {
                    synchronized (this.xo) {
                        try {
                            this.xo.wait(3000);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
                if (this.f174XI == null) {
                    return "";
                }
                try {
                    return K0(context, str);
                } catch (RemoteException unused2) {
                    return "";
                }
            } else {
                try {
                    return K0(context, str);
                } catch (RemoteException unused3) {
                    return "";
                }
            }
        }
    }

    /* renamed from: XI.K0.XI.XI$XI  reason: collision with other inner class name */
    public static abstract class AbstractBinderC0002XI extends Binder implements XI {

        /* renamed from: XI  reason: collision with root package name */
        public static final /* synthetic */ int f177XI = 0;

        /* renamed from: XI.K0.XI.XI$XI$XI  reason: collision with other inner class name */
        public static class C0003XI implements XI {

            /* renamed from: XI  reason: collision with root package name */
            public IBinder f178XI;

            public C0003XI(IBinder iBinder) {
                this.f178XI = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f178XI;
            }
        }
    }
}
