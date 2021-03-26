package com.ali.auth.third.login.task;

import android.text.TextUtils;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.message.MessageUtils;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.rpc.protocol.RpcException;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.task.AbsAsyncTask;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.core.util.ResourceUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.UTConstants;
import com.ali.auth.third.ui.LoginWebViewActivity;
import com.ali.auth.third.ui.context.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginByUsernameTask extends AbsAsyncTask<String, Void, Void> {
    private a a;

    public LoginByUsernameTask(a aVar) {
        this.a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void asyncExecute(String... strArr) {
        a aVar;
        String jSONObject;
        if (!CommonUtils.isNetworkAvailable()) {
            RpcResponse rpcResponse = new RpcResponse();
            rpcResponse.code = -1;
            rpcResponse.message = ResourceUtils.getString("com_taobao_tae_sdk_network_not_available_message");
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("code", rpcResponse.code);
                jSONObject2.put("message", rpcResponse.message);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.a.a(jSONObject2.toString());
            return null;
        }
        RpcResponse<LoginReturnData> loginByUserName = LoginComponent.INSTANCE.loginByUserName(strArr[0]);
        if (loginByUserName == null) {
            this.a.b("");
            return null;
        }
        try {
            if (loginByUserName.code == 3000) {
                com.ali.auth.third.login.a.a.b.refreshWhenLogin(loginByUserName.returnValue);
                this.a.a().setResult(ResultCode.SUCCESS.code);
                this.a.a().finish();
            } else {
                if (loginByUserName.code == 13010) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("code", loginByUserName.code);
                    jSONObject3.put("message", loginByUserName.message);
                    JSONObject jSONObject4 = new JSONObject();
                    if (loginByUserName.returnValue != null) {
                        jSONObject4.put("checkCodeId", loginByUserName.returnValue.checkCodeId);
                        jSONObject4.put("checkCodeUrl", loginByUserName.returnValue.checkCodeUrl);
                    }
                    jSONObject3.put("data", jSONObject4);
                    aVar = this.a;
                    jSONObject = jSONObject3.toString();
                } else if (loginByUserName.code == 13011) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("code", loginByUserName.code);
                    jSONObject5.put("message", loginByUserName.message);
                    JSONObject jSONObject6 = new JSONObject();
                    if (loginByUserName.returnValue != null) {
                        jSONObject6.put("checkCodeId", loginByUserName.returnValue.checkCodeId);
                        jSONObject6.put("checkCodeUrl", loginByUserName.returnValue.checkCodeUrl);
                    }
                    jSONObject5.put("data", jSONObject6);
                    aVar = this.a;
                    jSONObject = jSONObject5.toString();
                } else if (loginByUserName.code == 13059) {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("code", loginByUserName.code);
                    jSONObject7.put("message", loginByUserName.message);
                    JSONObject jSONObject8 = new JSONObject();
                    if (loginByUserName.returnValue != null) {
                        jSONObject8.put("doubleCheckUrl", loginByUserName.returnValue.h5Url);
                    }
                    jSONObject7.put("data", jSONObject8);
                    aVar = this.a;
                    jSONObject = jSONObject7.toString();
                } else if (loginByUserName.code == 13060) {
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put("code", loginByUserName.code);
                    jSONObject9.put("message", loginByUserName.message);
                    JSONObject jSONObject10 = new JSONObject();
                    if (loginByUserName.returnValue != null) {
                        jSONObject10.put("doubleCheckUrl", loginByUserName.returnValue.h5Url);
                    }
                    jSONObject9.put("data", jSONObject10);
                    if (loginByUserName.returnValue != null) {
                        LoginWebViewActivity loginWebViewActivity = (LoginWebViewActivity) this.a.a();
                        LoginWebViewActivity.token = loginByUserName.returnValue.token;
                        LoginWebViewActivity loginWebViewActivity2 = (LoginWebViewActivity) this.a.a();
                        LoginWebViewActivity.scene = loginByUserName.returnValue.scene;
                    }
                    aVar = this.a;
                    jSONObject = jSONObject9.toString();
                } else {
                    JSONObject jSONObject11 = new JSONObject();
                    jSONObject11.put("code", loginByUserName.code);
                    jSONObject11.put("message", loginByUserName.message);
                    this.a.a(jSONObject11.toString());
                    HashMap hashMap = new HashMap();
                    hashMap.put("code", loginByUserName.code + "");
                    if (!TextUtils.isEmpty(loginByUserName.message)) {
                        hashMap.put("message", loginByUserName.message);
                    }
                    ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send(UTConstants.E_H5_LOGIN_FAILURE, hashMap);
                }
                aVar.a(jSONObject);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doFinally() {
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doWhenException(Throwable th) {
        Message createMessage = MessageUtils.createMessage(10010, th.getMessage());
        if (th instanceof RpcException) {
            createMessage = new Message();
            RpcException rpcException = (RpcException) th;
            createMessage.code = rpcException.getCode();
            createMessage.message = rpcException.getMsg();
        }
        SDKLogger.d("login", createMessage.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", createMessage.code);
            jSONObject.put("message", createMessage.message);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.a.a(jSONObject.toString());
    }
}
