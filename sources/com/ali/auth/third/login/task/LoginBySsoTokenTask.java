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
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.UTConstants;
import com.ali.auth.third.login.a.a;
import com.ali.auth.third.ui.LoginActivity;
import com.ali.auth.third.ui.context.CallbackContext;
import java.util.HashMap;

public class LoginBySsoTokenTask extends AbsLoginByCodeTask {
    private LoginCallback a;

    public LoginBySsoTokenTask(Activity activity, LoginCallback loginCallback) {
        super(activity);
        this.a = loginCallback;
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    public Void asyncExecute(String... strArr) {
        final RpcResponse<LoginReturnData> login = login(strArr);
        if (login == null) {
            return null;
        }
        final int i = login.code;
        SDKLogger.d("login", "asyncExecute code = " + i);
        if (i == 3000) {
            try {
                if (login.returnValue != null) {
                    a.b.refreshWhenLogin(login.returnValue);
                }
                KernelContext.executorService.postUITask(new Runnable() {
                    /* class com.ali.auth.third.login.task.LoginBySsoTokenTask.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        LoginBySsoTokenTask.this.doWhenResultOk();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            KernelContext.executorService.postUITask(new Runnable() {
                /* class com.ali.auth.third.login.task.LoginBySsoTokenTask.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    Message createMessage = MessageUtils.createMessage(15, "login", "code " + i + " " + login.message);
                    SDKLogger.d("login", createMessage.toString());
                    LoginBySsoTokenTask.this.doWhenResultFail(createMessage.code, createMessage.message);
                }
            });
        }
        return null;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doWhenException(Throwable th) {
        CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED);
        HashMap hashMap = new HashMap();
        hashMap.put("code", "10010");
        hashMap.put("message", "exception");
        ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_TB_LOGIN_FAILURE, hashMap);
        CommonUtils.onFailure(this.a, ResultCode.create(10010, th.getMessage()));
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    protected void doWhenResultFail(int i, String str) {
        LoginCallback loginCallback = this.a;
        if (loginCallback != null) {
            loginCallback.onFailure(i, str);
            HashMap hashMap = new HashMap();
            hashMap.put("code", i + "");
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("message", str);
            }
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_TB_LOGIN_FAILURE, hashMap);
        }
        if (CallbackContext.mGlobalLoginCallback != null) {
            CallbackContext.mGlobalLoginCallback.onFailure(i, str);
        }
        CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGIN_FAILED);
        if (this.activity != null && (this.activity instanceof LoginActivity)) {
            CallbackContext.activity = null;
            this.activity.finish();
        }
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    protected void doWhenResultOk() {
        LoginCallback loginCallback = this.a;
        if (loginCallback != null) {
            loginCallback.onSuccess(a.b.getSession());
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_TB_LOGIN_SUCCESS, null);
        }
        if (CallbackContext.mGlobalLoginCallback != null) {
            CallbackContext.mGlobalLoginCallback.onSuccess(a.b.getSession());
        }
        CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGIN_SUCCESS);
        if (this.activity != null && (this.activity instanceof LoginActivity)) {
            CallbackContext.activity = null;
            this.activity.finish();
        }
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    protected RpcResponse<LoginReturnData> login(String[] strArr) {
        return LoginComponent.INSTANCE.loginBySsoToken(strArr[0]);
    }
}
