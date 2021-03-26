package com.ali.auth.third.login.handler;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.webkit.WebView;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.message.MessageUtils;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.RequestCode;
import com.ali.auth.third.login.UTConstants;
import com.ali.auth.third.login.a.a;
import com.ali.auth.third.login.task.LoginAfterOpenTb;
import com.ali.auth.third.login.task.LoginByIVTokenTask;
import com.ali.auth.third.login.task.RefreshPageAfterOpenTb;
import com.ali.auth.third.login.util.LoginStatus;
import com.ali.auth.third.ui.LoginActivity;
import com.ali.auth.third.ui.context.CallbackContext;
import com.ali.auth.third.ui.support.BaseActivityResultHandler;
import com.ali.auth.third.ui.webview.BaseWebViewActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class LoginActivityResultHandler extends BaseActivityResultHandler {
    /* access modifiers changed from: private */
    public void a(Activity activity, String str, LoginCallback loginCallback) {
        SDKLogger.d("login", "onLoginSuccess ");
        if (loginCallback != null) {
            loginCallback.onSuccess(a.b.getSession());
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_H5_LOGIN_SUCCESS, null);
        }
        if (CallbackContext.mGlobalLoginCallback != null) {
            CallbackContext.mGlobalLoginCallback.onSuccess(a.b.getSession());
        }
        CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGIN_SUCCESS);
        if (activity != null && (activity instanceof LoginActivity)) {
            CallbackContext.activity = null;
            activity.finish();
            CallbackContext.loginCallback = null;
        }
    }

    /* access modifiers changed from: private */
    public void a(Activity activity, String str, LoginCallback loginCallback, int i) {
        UserTrackerService userTrackerService;
        HashMap hashMap;
        String str2;
        UserTrackerService userTrackerService2;
        String str3;
        SDKLogger.d("login", "onLoginFailure ");
        if (loginCallback != null) {
            Message createMessage = MessageUtils.createMessage(i, new Object[0]);
            loginCallback.onFailure(createMessage.code, createMessage.message);
            if (!UTConstants.E_IV_LOGIN_FAILURE.equals(str)) {
                if (i == 10003) {
                    userTrackerService2 = (UserTrackerService) KernelContext.getService(UserTrackerService.class);
                    str3 = UTConstants.E_H5_LOGIN_CANCEL;
                } else if (i == 10004) {
                    userTrackerService2 = (UserTrackerService) KernelContext.getService(UserTrackerService.class);
                    str3 = UTConstants.E_TB_LOGIN_CANCEL;
                } else {
                    if (i == 10005) {
                        hashMap = new HashMap();
                        int i2 = createMessage.code;
                        String str4 = createMessage.message;
                        hashMap.put("code", i2 + "");
                        if (!TextUtils.isEmpty(str4)) {
                            hashMap.put("message", str4);
                        }
                        userTrackerService = (UserTrackerService) KernelContext.getService(UserTrackerService.class);
                        str2 = UTConstants.E_TB_LOGIN_FAILURE;
                    } else {
                        hashMap = new HashMap();
                        int i3 = createMessage.code;
                        String str5 = createMessage.message;
                        hashMap.put("code", i3 + "");
                        if (!TextUtils.isEmpty(str5)) {
                            hashMap.put("message", str5);
                        }
                        userTrackerService = (UserTrackerService) KernelContext.getService(UserTrackerService.class);
                        str2 = UTConstants.E_H5_LOGIN_FAILURE;
                    }
                    userTrackerService.send(str2, hashMap);
                }
                userTrackerService2.send(str3, null);
            }
        }
        if (CallbackContext.mGlobalLoginCallback != null) {
            Message createMessage2 = MessageUtils.createMessage(i, new Object[0]);
            CallbackContext.mGlobalLoginCallback.onFailure(createMessage2.code, createMessage2.message);
        }
        CommonUtils.sendBroadcast((i == 10003 || i == 10004) ? LoginAction.NOTIFY_LOGIN_CANCEL : LoginAction.NOTIFY_LOGIN_FAILED);
        if (activity != null && (activity instanceof LoginActivity)) {
            CallbackContext.activity = null;
            activity.finish();
            CallbackContext.loginCallback = null;
        }
    }

    private void a(Intent intent, final LoginCallback loginCallback) {
        SDKLogger.d("login", "handleCheck");
        final WeakReference<Activity> weakReference = CallbackContext.activity;
        if (weakReference == null || weakReference.get() == null || intent == null) {
            KernelContext.executorService.postUITask(new Runnable() {
                /* class com.ali.auth.third.login.handler.LoginActivityResultHandler.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    CallbackContext.activity = weakReference;
                    LoginActivityResultHandler.this.a((Activity) weakReference.get(), UTConstants.E_H5_OPERATION_BIND_FAILURE, loginCallback, 10003);
                    CallbackContext.activity = null;
                }
            });
        } else if (TextUtils.isEmpty(intent.getStringExtra("token"))) {
            KernelContext.executorService.postUITask(new Runnable() {
                /* class com.ali.auth.third.login.handler.LoginActivityResultHandler.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    CallbackContext.activity = weakReference;
                    LoginActivityResultHandler.this.a((Activity) weakReference.get(), UTConstants.E_IV_LOGIN_FAILURE, loginCallback, 10101);
                    CallbackContext.activity = null;
                }
            });
        } else {
            new LoginByIVTokenTask(weakReference.get(), new LoginCallback() {
                /* class com.ali.auth.third.login.handler.LoginActivityResultHandler.AnonymousClass2 */

                @Override // com.ali.auth.third.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    KernelContext.executorService.postUITask(new Runnable() {
                        /* class com.ali.auth.third.login.handler.LoginActivityResultHandler.AnonymousClass2.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            CallbackContext.activity = weakReference;
                            LoginActivityResultHandler.this.a((Activity) weakReference.get(), UTConstants.E_IV_LOGIN_FAILURE, loginCallback, 10101);
                            CallbackContext.activity = null;
                        }
                    });
                }

                @Override // com.ali.auth.third.core.callback.LoginCallback
                public void onSuccess(Session session) {
                    KernelContext.executorService.postUITask(new Runnable() {
                        /* class com.ali.auth.third.login.handler.LoginActivityResultHandler.AnonymousClass2.AnonymousClass2 */

                        @Override // java.lang.Runnable
                        public void run() {
                            CallbackContext.activity = weakReference;
                            LoginActivityResultHandler.this.a((Activity) weakReference.get(), UTConstants.E_H5_LOGIN_SUCCESS, loginCallback);
                            CallbackContext.activity = null;
                        }
                    });
                }
            }).executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, new String[]{intent.getStringExtra("token"), intent.getStringExtra("scene"), intent.getStringExtra("aliusersdk_h5querystring")});
        }
    }

    @Override // com.ali.auth.third.ui.support.BaseActivityResultHandler
    protected void onCallbackContext(int i, int i2, Intent intent, Activity activity, Map<Class<?>, Object> map, WebView webView) {
        String str;
        String str2;
        int i3;
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append("onCallbackContext requestCode=");
        sb.append(i);
        sb.append(" resultCode = ");
        sb.append(i2);
        sb.append(" authCode = ");
        String str4 = "";
        sb.append(intent == null ? str4 : intent.getStringExtra("result"));
        SDKLogger.d("login", sb.toString());
        LoginStatus.resetLoginFlag();
        LoginCallback loginCallback = (LoginCallback) CallbackContext.loginCallback;
        if (i != RequestCode.OPEN_H5_LOGIN || loginCallback == null) {
            if (i == RequestCode.OPEN_TAOBAO && loginCallback != null) {
                ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send("AUTH_TAOBAO", null);
                if (i2 != -1 || intent == null) {
                    if (i2 == 0) {
                        i3 = 10004;
                        str3 = "E_TB_LOGIN_CANCEL";
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("result from taobao : ");
                        if (intent != null) {
                            str4 = intent.getStringExtra("result");
                        }
                        sb2.append(str4);
                        SDKLogger.d("login", sb2.toString());
                        i3 = 10005;
                        str3 = "E_TB_LOGIN_FAILURE";
                    }
                    a(activity, str3, loginCallback, i3);
                    return;
                }
                new LoginAfterOpenTb(CallbackContext.activity.get(), loginCallback).executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, new String[]{intent.getStringExtra("result")});
                return;
            } else if (i != RequestCode.OPEN_QR_LOGIN || loginCallback == null) {
                if (i != RequestCode.OPEN_QR_LOGIN_CONFIRM || loginCallback == null) {
                    if (i != RequestCode.OPEN_DOUBLE_CHECK) {
                        if (i == RequestCode.OPEN_H5_UNBIND) {
                            if (i2 == ResultCode.SUCCESS.code) {
                                a(activity, "E_H5_UNBIND_SUCCESS", loginCallback);
                            } else {
                                a(activity, "E_H5_UNBIND_FAILURE", loginCallback, 10003);
                            }
                            CallbackContext.loginCallback = null;
                            return;
                        }
                        return;
                    }
                    a(intent, loginCallback);
                    return;
                } else if (i2 == ResultCode.SUCCESS.code) {
                    str2 = "E_QR_LOGIN_CONFIRM_SUCCESS";
                } else {
                    str = "E_QR_LOGIN_CONFIRM_CANCEL";
                    a(activity, str, loginCallback, 10003);
                    return;
                }
            } else if (i2 == ResultCode.SUCCESS.code) {
                str2 = "E_QR_LOGIN_SUCCESS";
            } else {
                str = "E_QR_CANCEL_FAILURE";
                a(activity, str, loginCallback, 10003);
                return;
            }
        } else if (i2 == ResultCode.SUCCESS.code) {
            str2 = "E_H5_LOGIN_SUCCESS";
        } else if (i2 != ResultCode.IGNORE.code) {
            if (i2 != ResultCode.CHECK.code) {
                str = "E_H5_CANCEL_FAILURE";
                a(activity, str, loginCallback, 10003);
                return;
            }
            a(intent, loginCallback);
            return;
        } else {
            return;
        }
        a(activity, str2, loginCallback);
    }

    @Override // com.ali.auth.third.ui.support.BaseActivityResultHandler
    protected void onTaeSDKActivity(int i, int i2, Intent intent, BaseWebViewActivity baseWebViewActivity, Map<Class<?>, Object> map, WebView webView) {
        ResultCode create;
        StringBuilder sb = new StringBuilder();
        sb.append("onTaeSDKActivity requestCode=");
        sb.append(i);
        sb.append(" resultCode = ");
        sb.append(i2);
        sb.append(" authCode = ");
        sb.append(intent == null ? "" : intent.getStringExtra("result"));
        SDKLogger.d("login", sb.toString());
        LoginCallback loginCallback = (LoginCallback) CallbackContext.loginCallback;
        LoginStatus.resetLoginFlag();
        if (i == RequestCode.OPEN_H5_LOGIN) {
            if (i2 == ResultCode.SUCCESS.code) {
                webView.reload();
                return;
            }
            create = ResultCode.create(10003, new Object[0]);
        } else if (i == RequestCode.OPEN_TAOBAO) {
            if (i2 == -1 && intent != null) {
                new RefreshPageAfterOpenTb(baseWebViewActivity, webView).executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, new String[]{intent.getStringExtra("result")});
                return;
            } else if (i2 == 0) {
                create = ResultCode.create(10003, new Object[0]);
            } else {
                SDKLogger.e("login", "taobao return " + i2);
                LoginComponent.INSTANCE.showH5Login(baseWebViewActivity);
                return;
            }
        } else if (i == RequestCode.OPEN_H5_UNBIND) {
            if (i2 == ResultCode.SUCCESS.code) {
                a(baseWebViewActivity, "E_H5_UNBIND_SUCCESS", loginCallback);
            } else {
                a(baseWebViewActivity, "E_H5_UNBIND_FAILURE", loginCallback, 10003);
            }
            CallbackContext.loginCallback = null;
            return;
        } else {
            return;
        }
        baseWebViewActivity.setResult(create);
    }
}
