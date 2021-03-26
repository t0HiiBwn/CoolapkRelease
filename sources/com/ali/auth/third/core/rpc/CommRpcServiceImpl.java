package com.ali.auth.third.core.rpc;

import android.text.TextUtils;
import com.ali.auth.third.core.model.RpcRequest;
import com.ali.auth.third.core.model.RpcRequestCallbackWithCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.service.RpcService;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.JSONUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class CommRpcServiceImpl implements RpcService {
    @Override // com.ali.auth.third.core.service.RpcService
    public String getDeviceId() {
        return "";
    }

    @Override // com.ali.auth.third.core.service.RpcService
    public <T> RpcResponse<T> invoke(RpcRequest rpcRequest, Class<T> cls) {
        try {
            String str = rpcRequest.target;
            String str2 = rpcRequest.version;
            JSONArray jSONArray = new JSONArray();
            Iterator<Object> it2 = rpcRequest.paramValues.iterator();
            while (it2.hasNext()) {
                jSONArray.put(it2.next());
            }
            String a = b.a(str, str2, jSONArray.toString());
            SDKLogger.d("", "post response = " + a);
            JSONObject jSONObject = new JSONObject(a);
            RpcResponse<T> rpcResponse = new RpcResponse<>();
            rpcResponse.code = jSONObject.optInt("code");
            rpcResponse.message = jSONObject.optString("message");
            rpcResponse.codeGroup = jSONObject.optString("codeGroup");
            rpcResponse.msgCode = jSONObject.optString("msgCode");
            rpcResponse.msgInfo = jSONObject.optString("msgInfo");
            rpcResponse.actionType = jSONObject.optString("actionType");
            if (!TextUtils.isEmpty(jSONObject.optString("returnValue"))) {
                rpcResponse.returnValue = (T) JSONUtils.parseStringValue(jSONObject.optString("returnValue"), cls);
            }
            return rpcResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ali.auth.third.core.service.RpcService
    public String invoke(RpcRequest rpcRequest) {
        try {
            String str = rpcRequest.target;
            String str2 = rpcRequest.version;
            JSONArray jSONArray = new JSONArray();
            Iterator<Object> it2 = rpcRequest.paramValues.iterator();
            while (it2.hasNext()) {
                jSONArray.put(it2.next());
            }
            return b.a(str, str2, jSONArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ali.auth.third.core.service.RpcService
    public void logout() {
    }

    @Override // com.ali.auth.third.core.service.RpcService
    public void registerSessionInfo(String str, String str2) {
    }

    @Override // com.ali.auth.third.core.service.RpcService
    public <T> void remoteBusiness(RpcRequest rpcRequest, Class<T> cls, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        if (rpcRequestCallbackWithCode != null) {
            rpcRequestCallbackWithCode.onError("usage not support.", null);
        }
    }
}
