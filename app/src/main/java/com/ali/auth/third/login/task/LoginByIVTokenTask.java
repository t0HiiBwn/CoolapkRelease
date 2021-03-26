package com.ali.auth.third.login.task;

import android.app.Activity;
import android.text.TextUtils;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.message.MessageUtils;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.task.AbsAsyncTask;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.core.util.ResourceUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.UTConstants;
import java.util.HashMap;

public class LoginByIVTokenTask extends AbsAsyncTask<String, Void, Void> {
    protected boolean a = false;
    private LoginCallback b;
    private Activity c;

    public LoginByIVTokenTask(Activity activity, LoginCallback loginCallback) {
        this.c = activity;
        this.b = loginCallback;
    }

    public LoginByIVTokenTask(Activity activity, LoginCallback loginCallback, boolean z) {
        this.c = activity;
        this.b = loginCallback;
        this.a = true;
    }

    private void a() {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.login.task.LoginByIVTokenTask.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                if (LoginByIVTokenTask.this.b != null) {
                    LoginByIVTokenTask.this.b.onSuccess(KernelContext.credentialService.getSession());
                }
                CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGIN_SUCCESS);
                if (LoginByIVTokenTask.this.a) {
                    LoginByIVTokenTask.this.c.finish();
                }
            }
        });
    }

    private void a(final int i, final String str) {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.login.task.LoginByIVTokenTask.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("code", i + "");
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("message", str);
                }
                ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_H5_LOGIN_FAILURE, hashMap);
                if (LoginByIVTokenTask.this.b != null) {
                    LoginByIVTokenTask.this.b.onFailure(i, str);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void asyncExecute(String... strArr) {
        if (!CommonUtils.isNetworkAvailable()) {
            RpcResponse rpcResponse = new RpcResponse();
            rpcResponse.code = -1;
            rpcResponse.message = ResourceUtils.getString("com_taobao_tae_sdk_network_not_available_message");
            a(rpcResponse.code, rpcResponse.message);
            return null;
        }
        RpcResponse<LoginReturnData> loginByIVToken = LoginComponent.INSTANCE.loginByIVToken(strArr[0], strArr[1], strArr[2]);
        if (loginByIVToken == null || loginByIVToken.returnValue == null) {
            a(ResultCode.SYSTEM_EXCEPTION.code, ResultCode.SYSTEM_EXCEPTION.message);
            return null;
        }
        if (loginByIVToken.code == 3000) {
            KernelContext.credentialService.refreshWhenLogin(loginByIVToken.returnValue);
            a();
        } else {
            a(loginByIVToken.code, loginByIVToken.message);
        }
        return null;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doFinally() {
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doWhenException(Throwable th) {
        Message createMessage = MessageUtils.createMessage(10010, th.getMessage());
        SDKLogger.log("login", createMessage, th);
        HashMap hashMap = new HashMap();
        hashMap.put("code", "10010");
        hashMap.put("message", "exception");
        ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_H5_LOGIN_FAILURE, hashMap);
        a(createMessage.code, createMessage.message);
    }
}
