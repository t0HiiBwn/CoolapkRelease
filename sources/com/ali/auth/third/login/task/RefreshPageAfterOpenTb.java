package com.ali.auth.third.login.task;

import android.app.Activity;
import android.webkit.WebView;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.a.a;
import com.ali.auth.third.ui.context.CallbackContext;
import com.ali.auth.third.ui.support.WebViewActivitySupport;

public class RefreshPageAfterOpenTb extends AbsLoginByCodeTask {
    private WebView a;

    public RefreshPageAfterOpenTb(Activity activity, WebView webView) {
        super(activity);
        this.a = webView;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doWhenException(Throwable th) {
        CommonUtils.toastSystemException();
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    protected void doWhenResultFail(int i, String str) {
        CommonUtils.toastSystemException();
        if (CallbackContext.loginCallback != null) {
            ((LoginCallback) CallbackContext.loginCallback).onFailure(i, str);
        }
        if (CallbackContext.mGlobalLoginCallback != null) {
            CallbackContext.mGlobalLoginCallback.onFailure(i, str);
        }
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    protected void doWhenResultOk() {
        if (this.a != null) {
            WebViewActivitySupport.getInstance().safeReload(this.a);
        }
        if (CallbackContext.loginCallback != null) {
            ((LoginCallback) CallbackContext.loginCallback).onSuccess(a.b.getSession());
        }
        if (CallbackContext.mGlobalLoginCallback != null) {
            CallbackContext.mGlobalLoginCallback.onSuccess(a.b.getSession());
        }
    }

    @Override // com.ali.auth.third.login.task.AbsLoginByCodeTask
    protected RpcResponse<LoginReturnData> login(String[] strArr) {
        return LoginComponent.INSTANCE.loginByCode(strArr[0]);
    }
}
