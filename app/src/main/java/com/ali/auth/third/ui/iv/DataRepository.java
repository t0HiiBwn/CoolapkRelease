package com.ali.auth.third.ui.iv;

import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.RpcRequest;
import com.ali.auth.third.core.model.RpcRequestCallbackWithCode;
import com.ali.auth.third.core.service.RpcService;
import com.ali.auth.third.core.util.CommonUtils;
import org.json.JSONObject;

public class DataRepository {
    public static void checkCommonCode(String str, String str2, String str3, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.alibaba.havanaappiv.checkCommonCode";
        rpcRequest.version = "1.0";
        rpcRequest.addParam("ivToken", str);
        rpcRequest.addParam("codes", str2);
        rpcRequest.addParam("mobile", str3);
        ((RpcService) KernelContext.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void fetchIVStrategys(String str, String str2, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.alibaba.havanaappiv.getStrategyForNative";
        rpcRequest.version = "1.0";
        rpcRequest.addParam("trustToken", str);
        rpcRequest.addParam("validatorTags", str2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appKey", KernelContext.getAppKey());
            jSONObject.put("sdkVersion", KernelContext.sdkVersion);
            jSONObject.put("appVersion", CommonUtils.getAppVersion());
            jSONObject.put("site", "0");
            rpcRequest.addParam("ext", jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        ((RpcService) KernelContext.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }

    public static void sendSMSCode(String str, String str2, String str3, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.alibaba.havanaappiv.sendCommonCode";
        rpcRequest.version = "1.0";
        rpcRequest.addParam("ivToken", str);
        rpcRequest.addParam("tag", str2);
        rpcRequest.addParam("mobile", str3);
        ((RpcService) KernelContext.getService(RpcService.class)).remoteBusiness(rpcRequest, String.class, rpcRequestCallbackWithCode);
    }
}
