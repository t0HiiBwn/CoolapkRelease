package com.bytedance.embed_dr;

import android.content.Context;
import android.text.TextUtils;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;
import com.bytedance.embedapplog.bx;
import com.bytedance.embedapplog.ce;
import com.bytedance.embedapplog.cf;
import java.util.concurrent.atomic.AtomicBoolean;

public final class VivoIdentifier {
    private IIdentifierListener listener = new IIdentifierListener() {
        /* class com.bytedance.embed_dr.VivoIdentifier.AnonymousClass1 */

        public void OnSupport(boolean z, IdSupplier idSupplier) {
            try {
                String str = ce.a;
                bx.b(str, "OaidMiit#OnSupport isSupport=" + z + ", supplier=" + idSupplier);
                if (!z) {
                    return;
                }
                if (idSupplier != null) {
                    VivoIdentifier.this.setupOaid(idSupplier.getOAID());
                    synchronized (VivoIdentifier.this.mLock) {
                        VivoIdentifier.this.mProloading = false;
                        VivoIdentifier.this.mLock.notifyAll();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private final Object mLock = new Object();
    private volatile boolean mProloading = false;
    private final AtomicBoolean mSecondCallGetDeviceIds = new AtomicBoolean();
    private String oaid;
    private String resultCode;

    /* access modifiers changed from: private */
    public synchronized void setupOaid(String str) {
        String str2 = ce.a;
        bx.b(str2, "OaidMiit#setupOaid id=" + str + ", oaid=" + this.oaid);
        if (!TextUtils.isEmpty(str) && !str.equals(this.oaid)) {
            this.oaid = str;
        }
    }

    public void preloadOaid(Context context) {
        synchronized (this.mLock) {
            this.mProloading = true;
            try {
                int callFromReflect = callFromReflect(context);
                if (callFromReflect == 1008612) {
                    bx.b(ce.a, "OaidMiit#getDeviceIds 不支持的设备");
                    this.resultCode = "不支持的设备";
                } else if (callFromReflect == 1008613) {
                    bx.b(ce.a, "OaidMiit#getDeviceIds 加载配置文件出错");
                    this.resultCode = "加载配置文件出错";
                } else if (callFromReflect == 1008611) {
                    bx.b(ce.a, "OaidMiit#getDeviceIds 不支持的设备厂商");
                    this.resultCode = "不支持的设备厂商";
                } else if (callFromReflect == 1008614) {
                    bx.b(ce.a, "OaidMiit#getDeviceIds 获取接口是异步的，结果会在回调中返回，回调执行的回调可能在工作线程");
                    if (this.mSecondCallGetDeviceIds.compareAndSet(false, true)) {
                        preloadOaid(context);
                    } else {
                        this.resultCode = "结果会在回调中返回";
                    }
                } else if (callFromReflect == 1008615) {
                    bx.b(ce.a, "OaidMiit#getDeviceIds 反射调用出错");
                    this.resultCode = "反射调用出错";
                } else if (callFromReflect == 0) {
                    bx.b(ce.a, "OaidMiit#getDeviceIds 正确");
                    this.resultCode = "正确";
                } else {
                    this.resultCode = "未知 resultCode=" + callFromReflect;
                    String str = ce.a;
                    bx.b(str, "OaidMiit#getDeviceIds 未知 resultCode=" + callFromReflect);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                this.mProloading = false;
            }
        }
    }

    private int callFromReflect(Context context) {
        return MdidSdkHelper.InitSdk(context, true, this.listener);
    }

    public cf.a getOaid(Context context) {
        synchronized (this.mLock) {
            if (this.mProloading) {
                try {
                    this.mLock.wait(10000);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        cf.a aVar = new cf.a();
        aVar.b = this.oaid;
        return aVar;
    }
}
