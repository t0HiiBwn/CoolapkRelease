package mtopsdk.common.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: AsyncServiceBinder */
final class a implements ServiceConnection {
    private /* synthetic */ AsyncServiceBinder a;

    a(AsyncServiceBinder asyncServiceBinder) {
        this.a = asyncServiceBinder;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.a.lock) {
            try {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                    if (TextUtils.isEmpty(this.a.interfaceName)) {
                        AsyncServiceBinder asyncServiceBinder = this.a;
                        asyncServiceBinder.interfaceName = asyncServiceBinder.interfaceCls.getSimpleName();
                    }
                    TBSdkLog.w("mtopsdk.AsyncServiceBinder", "[onServiceDisconnected] Service disconnected called,interfaceName=" + this.a.interfaceName);
                }
            } catch (Exception unused) {
            }
            this.a.service = null;
            this.a.mBinding = false;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a.lock) {
            try {
                if (TextUtils.isEmpty(this.a.interfaceName)) {
                    AsyncServiceBinder asyncServiceBinder = this.a;
                    asyncServiceBinder.interfaceName = asyncServiceBinder.interfaceCls.getSimpleName();
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.AsyncServiceBinder", "[onServiceConnected] Service connected called. interfaceName =" + this.a.interfaceName);
                }
                Class<?>[] declaredClasses = this.a.interfaceCls.getDeclaredClasses();
                for (Class<?> cls : declaredClasses) {
                    if (cls.getSimpleName().equals("Stub")) {
                        this.a.service = (T) ((IInterface) cls.getDeclaredMethod("asInterface", IBinder.class).invoke(cls, iBinder));
                    }
                }
            } catch (Exception unused) {
                this.a.mBindFailed = true;
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                    TBSdkLog.w("mtopsdk.AsyncServiceBinder", "[onServiceConnected] Service bind failed. mBindFailed=" + this.a.mBindFailed + ",interfaceName=" + this.a.interfaceName);
                }
            }
            if (this.a.service != null) {
                this.a.mBindFailed = false;
                this.a.afterAsyncBind();
            }
            this.a.mBinding = false;
        }
    }
}
