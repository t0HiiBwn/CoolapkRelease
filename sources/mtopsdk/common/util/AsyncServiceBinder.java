package mtopsdk.common.util;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IInterface;
import android.text.TextUtils;
import mtopsdk.common.util.TBSdkLog;

public abstract class AsyncServiceBinder<T extends IInterface> {
    static final String TAG = "mtopsdk.AsyncServiceBinder";
    private ServiceConnection conn = new a(this);
    Class<? extends IInterface> interfaceCls;
    String interfaceName;
    final byte[] lock = new byte[0];
    volatile boolean mBindFailed = false;
    volatile boolean mBinding = false;
    protected volatile T service = null;
    Class<? extends Service> serviceCls;

    protected abstract void afterAsyncBind();

    public AsyncServiceBinder(Class<? extends IInterface> cls, Class<? extends Service> cls2) {
        this.interfaceCls = cls;
        this.serviceCls = cls2;
    }

    public void asyncBind(Context context) {
        if (this.service == null && context != null && !this.mBindFailed && !this.mBinding) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.AsyncServiceBinder", "[asyncBind] mContext=" + context + ",mBindFailed= " + this.mBindFailed + ",mBinding=" + this.mBinding);
            }
            this.mBinding = true;
            try {
                if (TextUtils.isEmpty(this.interfaceName)) {
                    this.interfaceName = this.interfaceCls.getSimpleName();
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.AsyncServiceBinder", "[asyncBind]try to bind service for " + this.interfaceName);
                }
                Intent intent = new Intent(context.getApplicationContext(), this.serviceCls);
                intent.setAction(this.interfaceCls.getName());
                intent.setPackage(context.getPackageName());
                intent.addCategory("android.intent.category.DEFAULT");
                boolean bindService = context.bindService(intent, this.conn, 1);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.AsyncServiceBinder", "[asyncBind]use intent bind service ret=" + bindService + " for interfaceName=" + this.interfaceName);
                }
                this.mBindFailed = !bindService;
            } catch (Throwable th) {
                this.mBindFailed = true;
                TBSdkLog.e("mtopsdk.AsyncServiceBinder", "[asyncBind] use intent bind service failed. mBindFailed=" + this.mBindFailed + ",interfaceName = " + this.interfaceName, th);
            }
            if (this.mBindFailed) {
                this.mBinding = false;
            }
        }
    }

    public T getService() {
        return this.service;
    }
}
