package com.ali.auth.third.mtop.rpc.impl;

import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.config.Environment;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.device.DeviceInfo;
import com.ali.auth.third.core.model.RpcRequest;
import com.ali.auth.third.core.model.RpcRequestCallbackWithCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.service.RpcService;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.mtop.rpc.MtopRemoteLoginImpl;
import com.ali.auth.third.mtop.rpc.a;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopSetting;

public class MtopRpcServiceImpl implements RpcService {
    Mtop a;

    public MtopRpcServiceImpl() {
        Mtop mtop;
        EnvModeEnum envModeEnum;
        if (ConfigManager.DEBUG) {
            TBSdkLog.setTLogEnabled(false);
            TBSdkLog.setPrintLog(true);
        }
        MtopSetting.setAppKeyIndex("OPEN", ConfigManager.APP_KEY_INDEX, ConfigManager.DAILY_APP_KEY_INDEX);
        MtopSetting.setAppVersion("OPEN", CommonUtils.getAppVersion());
        this.a = Mtop.instance("OPEN", KernelContext.context);
        if (KernelContext.getEnvironment() == Environment.TEST) {
            mtop = this.a;
            envModeEnum = EnvModeEnum.TEST;
        } else if (KernelContext.getEnvironment() == Environment.PRE) {
            mtop = this.a;
            envModeEnum = EnvModeEnum.PREPARE;
        } else {
            mtop = this.a;
            envModeEnum = EnvModeEnum.ONLINE;
        }
        mtop.switchEnvMode(envModeEnum);
        RemoteLogin.setLoginImpl(this.a, new MtopRemoteLoginImpl());
    }

    @Override // com.ali.auth.third.core.service.RpcService
    public String getDeviceId() {
        return DeviceInfo.deviceId;
    }

    @Override // com.ali.auth.third.core.service.RpcService
    public <T> RpcResponse<T> invoke(RpcRequest rpcRequest, Class<T> cls) {
        return a.a().a(rpcRequest, cls);
    }

    @Override // com.ali.auth.third.core.service.RpcService
    public String invoke(RpcRequest rpcRequest) {
        return a.a().a(rpcRequest);
    }

    @Override // com.ali.auth.third.core.service.RpcService
    public void logout() {
        this.a.logout();
    }

    @Override // com.ali.auth.third.core.service.RpcService
    public void registerSessionInfo(String str, String str2) {
        this.a.registerSessionInfo(str, str2);
    }

    @Override // com.ali.auth.third.core.service.RpcService
    public <T> void remoteBusiness(RpcRequest rpcRequest, Class<T> cls, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        a.a().a(rpcRequest, cls, rpcRequestCallbackWithCode);
    }
}
