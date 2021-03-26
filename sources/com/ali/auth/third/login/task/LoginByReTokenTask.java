package com.ali.auth.third.login.task;

import android.app.Activity;
import android.text.TextUtils;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.UTConstants;
import com.ali.auth.third.login.a.a;
import com.ali.auth.third.login.util.LoginStatus;
import java.util.HashMap;

public class LoginByReTokenTask extends AbsLoginByCodeTask {
    private LoginCallback a;

    public LoginByReTokenTask(Activity activity, LoginCallback loginCallback) {
        super(activity);
        this.a = loginCallback;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doWhenException(Throwable th) {
        LoginStatus.resetLoginFlag();
        HashMap hashMap = new HashMap();
        hashMap.put("code", "10010");
        hashMap.put("message", "exception");
        ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_AUTO_LOGIN_FAILURE, hashMap);
        CommonUtils.onFailure(this.a, ResultCode.create(10010, th.getMessage()));
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    protected void doWhenResultFail(int i, String str) {
        if (this.a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", i + "");
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("message", str);
            }
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_AUTO_LOGIN_FAILURE, hashMap);
            LoginCallback loginCallback = this.a;
            if (loginCallback != null) {
                loginCallback.onFailure(i, str);
            }
        }
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    protected void doWhenResultOk() {
        LoginStatus.resetLoginFlag();
        if (this.a != null) {
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_AUTO_LOGIN_SUCCESS, null);
            this.a.onSuccess(a.b.getSession());
        }
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    protected RpcResponse<LoginReturnData> login(String[] strArr) {
        LoginComponent loginComponent = LoginComponent.INSTANCE;
        return LoginComponent.loginByRefreshToken();
    }
}
