package com.ali.auth.third.mtop.rpc;

import android.text.TextUtils;
import com.ali.auth.third.core.MemberSDK;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.RpcRequest;
import com.ali.auth.third.core.model.RpcRequestCallbackWithCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.rpc.protocol.RpcException;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.JSONUtils;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.mtop.intf.MtopSetting;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static a a;

    /* access modifiers changed from: private */
    public <V> RpcResponse<V> a(MtopResponse mtopResponse, Class<V> cls) {
        if (mtopResponse != null && mtopResponse.isApiSuccess()) {
            return b(mtopResponse, cls);
        }
        if (mtopResponse == null) {
            return null;
        }
        if (mtopResponse.isNetworkError()) {
            throw new RpcException((Integer) 7, mtopResponse.getRetMsg());
        } else if (mtopResponse.isApiLockedResult()) {
            throw new RpcException((Integer) 400, mtopResponse.getRetMsg());
        } else if (mtopResponse.is41XResult()) {
            throw new RpcException((Integer) 401, mtopResponse.getRetMsg());
        } else if (mtopResponse.isExpiredRequest()) {
            throw new RpcException((Integer) 402, mtopResponse.getRetMsg());
        } else if (mtopResponse.isIllegelSign()) {
            throw new RpcException((Integer) 403, mtopResponse.getRetMsg());
        } else if (mtopResponse.isSystemError()) {
            throw new RpcException((Integer) 406, mtopResponse.getRetMsg());
        } else if (mtopResponse.isSessionInvalid()) {
            throw new RpcException((Integer) 407, mtopResponse.getRetMsg());
        } else if (mtopResponse.isMtopServerError()) {
            throw new RpcException((Integer) 406, mtopResponse.getRetMsg());
        } else if (!mtopResponse.isMtopSdkError()) {
            return b(mtopResponse, cls);
        } else {
            throw new RpcException((Integer) 406, mtopResponse.getRetMsg());
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    private <V> RpcResponse<V> b(MtopResponse mtopResponse, Class<V> cls) {
        try {
            return c(mtopResponse, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private MtopRequest b(RpcRequest rpcRequest) throws JSONException {
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(rpcRequest.target);
        mtopRequest.setVersion(rpcRequest.version);
        mtopRequest.setNeedEcode(false);
        mtopRequest.setNeedSession(false);
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < rpcRequest.paramNames.size(); i++) {
            if (rpcRequest.paramNames.get(i) != null) {
                jSONObject.put(rpcRequest.paramNames.get(i), rpcRequest.paramValues.get(i).toString());
            }
        }
        mtopRequest.setData(jSONObject.toString());
        return mtopRequest;
    }

    private <V> RpcResponse<V> c(MtopResponse mtopResponse, Class<V> cls) throws JSONException {
        JSONObject optJSONObject;
        RpcResponse<V> rpcResponse = new RpcResponse<>();
        byte[] bytedata = mtopResponse.getBytedata();
        if (!(bytedata == null || (optJSONObject = new JSONObject(new String(bytedata)).optJSONObject("data")) == null)) {
            rpcResponse.code = optJSONObject.optInt("code");
            rpcResponse.codeGroup = optJSONObject.optString("codeGroup");
            rpcResponse.message = optJSONObject.optString("message");
            rpcResponse.actionType = optJSONObject.optString("actionType");
            rpcResponse.success = optJSONObject.optBoolean("success");
            if (!TextUtils.isEmpty(optJSONObject.optString("returnValue"))) {
                rpcResponse.returnValue = (T) JSONUtils.parseStringValue(optJSONObject.optString("returnValue"), cls);
            }
        }
        return rpcResponse;
    }

    public <V> RpcResponse<V> a(RpcRequest rpcRequest, Class<V> cls) {
        return a(rpcRequest, cls, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0069  */
    public <V> RpcResponse<V> a(RpcRequest rpcRequest, Class<V> cls, String str) {
        MtopResponse mtopResponse;
        MtopResponse mtopResponse2;
        Exception e;
        try {
            MtopBuilder connectionTimeoutMilliSecond = Mtop.instance("OPEN", KernelContext.context).build(b(rpcRequest), MemberSDK.ttid).reqMethod(MethodEnum.POST).setBizId(94).setConnectionTimeoutMilliSecond(10000);
            if (!TextUtils.isEmpty(str)) {
                connectionTimeoutMilliSecond.setReqUserId(str);
            }
            connectionTimeoutMilliSecond.retryTime(1);
            connectionTimeoutMilliSecond.setOpenBiz("baichuan");
            mtopResponse = connectionTimeoutMilliSecond.syncRequest();
            try {
                SDKLogger.d("login.MTOPWrapperImpl", "receive MtopResponse" + mtopResponse);
            } catch (Exception e2) {
                mtopResponse2 = mtopResponse;
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            mtopResponse2 = null;
            SDKLogger.e("login.MTOPWrapperImpl", "MtopResponse error", e);
            e.printStackTrace();
            mtopResponse = mtopResponse2;
            if (mtopResponse == null) {
            }
        }
        if (mtopResponse == null) {
            return a(mtopResponse, cls);
        }
        SDKLogger.e("login.MTOPWrapperImpl", "MtopResponse response=null");
        return null;
    }

    public String a(RpcRequest rpcRequest) {
        return a(rpcRequest, LoginReturnData.class).toString();
    }

    public <T> void a(RpcRequest rpcRequest, final Class<T> cls, final RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        if (rpcRequest != null && rpcRequestCallbackWithCode != null) {
            try {
                MtopSetting.setMtopDomain("OPEN", "", "guide-acs.wapa.taobao.com", "");
                MtopBusiness build = MtopBusiness.build(Mtop.instance("OPEN", KernelContext.context), b(rpcRequest), MemberSDK.ttid);
                build.setOpenBiz("baichuan");
                build.registerListener((IRemoteListener) new IRemoteBaseListener() {
                    /* class com.ali.auth.third.mtop.rpc.a.AnonymousClass1 */

                    @Override // com.taobao.tao.remotebusiness.IRemoteListener
                    public void onError(int i, MtopResponse mtopResponse, Object obj) {
                        rpcRequestCallbackWithCode.onError(mtopResponse != null ? mtopResponse.getRetCode() : "-1", a.this.a(mtopResponse, cls));
                    }

                    @Override // com.taobao.tao.remotebusiness.IRemoteListener
                    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                        rpcRequestCallbackWithCode.onSuccess(a.this.a(mtopResponse, cls));
                    }

                    @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                    public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                        String retCode = mtopResponse != null ? mtopResponse.getRetCode() : "-1";
                        try {
                            rpcRequestCallbackWithCode.onSystemError(retCode, a.this.a(mtopResponse, cls));
                        } catch (RpcException unused) {
                            rpcRequestCallbackWithCode.onSystemError(retCode, null);
                        }
                    }
                });
                build.startRequest();
            } catch (Throwable unused) {
            }
        }
    }
}
