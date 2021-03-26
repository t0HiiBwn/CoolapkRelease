package com.ali.auth.third.login.task;

import android.app.Activity;
import android.text.TextUtils;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.service.MemberExecutorService;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.task.TaskWithDialog;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.a.a;
import com.ali.auth.third.login.callback.LogoutCallback;
import com.ali.auth.third.login.util.LoginStatus;

public class LogoutTask extends TaskWithDialog<Void, Void, Void> {
    private LogoutCallback a;

    public LogoutTask(Activity activity, LogoutCallback logoutCallback) {
        super(activity);
        this.a = logoutCallback;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void asyncExecute(Void... voidArr) {
        ResultCode logout;
        MemberExecutorService memberExecutorService;
        AnonymousClass1 r0;
        try {
            SDKLogger.e("logout task", "into logout " + CredentialManager.INSTANCE.getInternalSession().toString());
            if (!TextUtils.isEmpty(CredentialManager.INSTANCE.getInternalSession().user.userId)) {
                LoginComponent loginComponent = LoginComponent.INSTANCE;
                LoginComponent.logout();
            }
            LoginStatus.resetLoginFlag();
            logout = a.b.logout();
            if (ResultCode.SUCCESS.equals(logout)) {
                a.d.logout();
                CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGOUT);
                memberExecutorService = KernelContext.executorService;
                r0 = new Runnable() {
                    /* class com.ali.auth.third.login.task.LogoutTask.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        LogoutTask.this.a.onSuccess();
                    }
                };
                memberExecutorService.postUITask(r0);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            LoginStatus.resetLoginFlag();
            logout = a.b.logout();
            if (ResultCode.SUCCESS.equals(logout)) {
                a.d.logout();
                CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGOUT);
                memberExecutorService = KernelContext.executorService;
                r0 = new Runnable() {
                    /* class com.ali.auth.third.login.task.LogoutTask.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        LogoutTask.this.a.onSuccess();
                    }
                };
            }
        } catch (Throwable th) {
            LoginStatus.resetLoginFlag();
            ResultCode logout2 = a.b.logout();
            if (ResultCode.SUCCESS.equals(logout2)) {
                a.d.logout();
                CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGOUT);
                KernelContext.executorService.postUITask(new Runnable() {
                    /* class com.ali.auth.third.login.task.LogoutTask.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        LogoutTask.this.a.onSuccess();
                    }
                });
            } else {
                CommonUtils.onFailure(this.a, logout2);
            }
            throw th;
        }
        CommonUtils.onFailure(this.a, logout);
        return null;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doWhenException(Throwable th) {
        CommonUtils.onFailure(this.a, ResultCode.create(10010, th.getMessage()));
    }
}
