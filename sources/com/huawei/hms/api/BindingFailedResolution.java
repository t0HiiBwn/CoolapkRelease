package com.huawei.hms.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.AbstractDialog;
import com.huawei.hms.ui.AbstractPromptDialog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

public class BindingFailedResolution implements ServiceConnection, IBridgeActivityDelegate {
    private static final Object a = new Object();
    private Activity b;
    private boolean c = true;
    private a d;
    private Handler e = null;
    private Handler f = null;

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 2003;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        this.b = activity;
        a.a.a(this.b);
        a();
        a(activity);
    }

    private void a() {
        Handler handler = this.f;
        if (handler != null) {
            handler.removeMessages(3);
        } else {
            this.f = new Handler(Looper.getMainLooper(), new Handler.Callback() {
                /* class com.huawei.hms.api.BindingFailedResolution.AnonymousClass1 */

                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message == null || message.what != 3) {
                        return false;
                    }
                    BindingFailedResolution.this.a(8);
                    return true;
                }
            });
        }
        this.f.sendEmptyMessageDelayed(3, 2000);
    }

    private void a(Activity activity) {
        Intent intent = new Intent();
        intent.setClassName(HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName(), "com.huawei.hms.core.activity.JumpActivity");
        HMSLog.i("BindingFailedResolution", "onBridgeActivityCreate：try to start HMS");
        try {
            activity.startActivityForResult(intent, getRequestCode());
        } catch (Throwable th) {
            HMSLog.e("BindingFailedResolution", "ActivityNotFoundException：" + th.getMessage());
            Handler handler = this.f;
            if (handler != null) {
                handler.removeMessages(3);
                this.f = null;
            }
            b();
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        d();
        a.a.b(this.b);
        this.b = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        HMSLog.i("BindingFailedResolution", "onBridgeActivityResult");
        Handler handler = this.f;
        if (handler != null) {
            handler.removeMessages(3);
            this.f = null;
        }
        b();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        if (this.d != null) {
            HMSLog.i("BindingFailedResolution", "re show prompt dialog");
            e();
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.i("BindingFailedResolution", "On key up when resolve conn error");
    }

    protected Activity getActivity() {
        return this.b;
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (this.c) {
            this.c = false;
            onStartResult(z);
        }
    }

    protected void onStartResult(boolean z) {
        if (getActivity() != null) {
            if (z) {
                a(0);
            } else {
                e();
            }
        }
    }

    private void b() {
        Activity activity = getActivity();
        if (activity == null) {
            HMSLog.e("BindingFailedResolution", "In connect, bind core try fail");
            a(false);
            return;
        }
        Intent intent = new Intent("com.huawei.hms.core.aidlservice");
        intent.setPackage(HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName());
        synchronized (a) {
            if (activity.bindService(intent, this, 1)) {
                c();
                return;
            }
            HMSLog.e("BindingFailedResolution", "In connect, bind core try fail");
            a(false);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d();
        a(true);
        Activity activity = getActivity();
        if (activity != null) {
            Util.unBindServiceCatchException(activity, this);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i) {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            HMSLog.i("BindingFailedResolution", "finishBridgeActivity：" + i);
            Intent intent = new Intent();
            intent.putExtra("intent.extra.RESULT", i);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    private void c() {
        Handler handler = this.e;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.e = new Handler(Looper.getMainLooper(), new Handler.Callback() {
                /* class com.huawei.hms.api.BindingFailedResolution.AnonymousClass2 */

                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message == null || message.what != 2) {
                        return false;
                    }
                    HMSLog.e("BindingFailedResolution", "In connect, bind core try timeout");
                    BindingFailedResolution.this.a(false);
                    return true;
                }
            });
        }
        this.e.sendEmptyMessageDelayed(2, 5000);
    }

    private void d() {
        synchronized (a) {
            Handler handler = this.e;
            if (handler != null) {
                handler.removeMessages(2);
                this.e = null;
            }
        }
    }

    private void e() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            a aVar = this.d;
            if (aVar == null) {
                this.d = new a();
            } else {
                aVar.dismiss();
            }
            HMSLog.e("BindingFailedResolution", "showPromptdlg to resolve conn error");
            this.d.show(activity, new AbstractDialog.Callback() {
                /* class com.huawei.hms.api.BindingFailedResolution.AnonymousClass3 */

                @Override // com.huawei.hms.ui.AbstractDialog.Callback
                public void onDoWork(AbstractDialog abstractDialog) {
                    BindingFailedResolution.this.d = null;
                    BindingFailedResolution.this.a(8);
                }

                @Override // com.huawei.hms.ui.AbstractDialog.Callback
                public void onCancel(AbstractDialog abstractDialog) {
                    BindingFailedResolution.this.d = null;
                    BindingFailedResolution.this.a(8);
                }
            });
        }
    }

    private static class a extends AbstractPromptDialog {
        private a() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        protected String onGetMessageString(Context context) {
            return ResourceLoaderUtil.getString("hms_bindfaildlg_message", Util.getAppName(context, null), Util.getAppName(context, HMSPackageManager.getInstance(context).getHMSPackageName()));
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        protected String onGetPositiveButtonString(Context context) {
            return ResourceLoaderUtil.getString("hms_confirm");
        }
    }
}
