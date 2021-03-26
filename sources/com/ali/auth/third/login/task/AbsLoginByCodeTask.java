package com.ali.auth.third.login.task;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.task.TaskWithDialog;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.login.RequestCode;
import com.ali.auth.third.login.a.a;
import com.ali.auth.third.ui.LoginWebViewActivity;
import com.ali.auth.third.ui.context.CallbackContext;

public abstract class AbsLoginByCodeTask extends TaskWithDialog<String, Void, Void> {
    public AbsLoginByCodeTask(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public Void asyncExecute(String... strArr) {
        final RpcResponse<LoginReturnData> login = login(strArr);
        if (login == null) {
            KernelContext.executorService.postUITask(new Runnable() {
                /* class com.ali.auth.third.login.task.AbsLoginByCodeTask.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    AbsLoginByCodeTask.this.doWhenResultFail(7, "");
                }
            });
            return null;
        }
        int i = login.code;
        SDKLogger.d("AbsLoginByCodeTask", "asyncExecute code = " + i);
        if (i == 3000) {
            try {
                if (login.returnValue != null) {
                    a.b.refreshWhenLogin(login.returnValue);
                }
                KernelContext.executorService.postUITask(new Runnable() {
                    /* class com.ali.auth.third.login.task.AbsLoginByCodeTask.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        AbsLoginByCodeTask.this.doWhenResultOk();
                    }
                });
            } catch (Exception e) {
                doWhenException(e);
                e.printStackTrace();
            }
        } else if (i == 13060) {
            String str = login.returnValue.h5Url;
            SDKLogger.d("AbsLoginByCodeTask", "asyncExecute doubleCheckUrl = " + str);
            if (!TextUtils.isEmpty(str)) {
                Activity activity = this.activity;
                CallbackContext.setActivity(activity);
                Intent intent = new Intent(activity, LoginWebViewActivity.class);
                intent.putExtra("url", str);
                intent.putExtra("token", login.returnValue.token);
                intent.putExtra("scene", login.returnValue.scene);
                LoginWebViewActivity.token = login.returnValue.token;
                LoginWebViewActivity.scene = login.returnValue.scene;
                this.activity.startActivityForResult(intent, RequestCode.OPEN_DOUBLE_CHECK);
            }
        } else {
            KernelContext.executorService.postUITask(new Runnable() {
                /* class com.ali.auth.third.login.task.AbsLoginByCodeTask.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    AbsLoginByCodeTask.this.doWhenResultFail(login.code, login.message);
                }
            });
        }
        return null;
    }

    protected abstract void doWhenResultFail(int i, String str);

    protected abstract void doWhenResultOk();

    protected abstract RpcResponse<LoginReturnData> login(String[] strArr);
}
