package com.ali.auth.third.login.task;

import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.message.MessageUtils;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.task.AbsAsyncTask;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.ui.QRView;
import com.ali.auth.third.ui.context.CallbackContext;
import com.ali.auth.third.ui.context.a;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginByQrCodeTask extends AbsAsyncTask<String, Void, Void> {
    private a a;
    private boolean b;

    public LoginByQrCodeTask(a aVar, boolean z) {
        this.a = aVar;
        this.b = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void asyncExecute(String... strArr) {
        JSONObject optJSONObject;
        JSONObject jSONObject;
        a aVar;
        try {
            JSONObject optJSONObject2 = new JSONObject(strArr[0]).optJSONObject("params");
            if (!(optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("qrCodeInfo")) == null)) {
                RpcResponse<LoginReturnData> loginByQRCode = LoginComponent.INSTANCE.loginByQRCode(optJSONObject.optString("at"), optJSONObject.optLong("t"), this.b);
                if (loginByQRCode == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", 10010);
                    jSONObject2.put("message", "");
                    this.a.a(jSONObject2.toString());
                    return null;
                }
                try {
                    int i = loginByQRCode.code;
                    SDKLogger.d("login", "get qrcode of " + optJSONObject + " status " + i);
                    if (i == 3000) {
                        com.ali.auth.third.login.a.a.b.refreshWhenLogin(loginByQRCode.returnValue);
                        if (CallbackContext.loginCallback != null) {
                            ((LoginCallback) CallbackContext.loginCallback).onSuccess(com.ali.auth.third.login.a.a.b.getSession());
                        }
                        if (this.a.a() != null) {
                            this.a.a().setResult(ResultCode.SUCCESS.code);
                            this.a.a().finish();
                        } else if (QRView.mLoginCallback != null) {
                            QRView.mLoginCallback.onSuccess(com.ali.auth.third.login.a.a.b.getSession());
                            QRView.mLoginCallback = null;
                        }
                    } else {
                        if (i == 14030) {
                            jSONObject = new JSONObject();
                            jSONObject.put("code", 4);
                            jSONObject.put("message", loginByQRCode.message);
                            aVar = this.a;
                        } else if (i == 14031) {
                            jSONObject = new JSONObject();
                            jSONObject.put("code", 5);
                            jSONObject.put("message", loginByQRCode.message);
                            aVar = this.a;
                        } else if (i == 14042) {
                            jSONObject = new JSONObject();
                            jSONObject.put("code", 6);
                            jSONObject.put("message", loginByQRCode.message);
                            aVar = this.a;
                        } else if (i == 13060) {
                            JSONObject jSONObject3 = new JSONObject();
                            if (loginByQRCode.returnValue.extMap != null) {
                                jSONObject3.put("nativeIv", loginByQRCode.returnValue.extMap.get("nativeIv"));
                                jSONObject3.put("iv_token", loginByQRCode.returnValue.extMap.get("nativeIvToken"));
                                jSONObject3.put("scene", loginByQRCode.returnValue.scene);
                                jSONObject3.put("login_token", loginByQRCode.returnValue.token);
                            }
                            this.a.a(13060, jSONObject3.toString());
                        } else if (i == 1) {
                            jSONObject = new JSONObject();
                            jSONObject.put("code", 10010);
                            jSONObject.put("message", loginByQRCode.message);
                            aVar = this.a;
                        } else {
                            jSONObject = new JSONObject();
                            jSONObject.put("code", i);
                            jSONObject.put("message", loginByQRCode.message);
                            aVar = this.a;
                        }
                        aVar.a(jSONObject.toString());
                    }
                } catch (Throwable unused) {
                }
            }
            return null;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doFinally() {
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doWhenException(Throwable th) {
        Message createMessage = MessageUtils.createMessage(10010, th.getMessage());
        SDKLogger.log("login", createMessage, th);
        this.a.a(createMessage.code, createMessage.message);
    }
}
