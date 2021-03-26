package mtopsdk.mtop.global;

import android.content.Context;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.intf.Mtop;

@Deprecated
public class SDKConfig {
    private static final SDKConfig a = new SDKConfig();

    private SDKConfig() {
    }

    public static SDKConfig getInstance() {
        return a;
    }

    @Deprecated
    public Context getGlobalContext() {
        return Mtop.instance(null).getMtopConfig().context;
    }

    @Deprecated
    public String getGlobalAppKey() {
        return Mtop.instance(null).getMtopConfig().appKey;
    }

    @Deprecated
    public String getGlobalAuthCode() {
        return Mtop.instance(null).getMtopConfig().authCode;
    }

    @Deprecated
    public String getGlobalDeviceId() {
        return Mtop.instance(null).getMtopConfig().deviceId;
    }

    @Deprecated
    public String getGlobalUtdid() {
        return Mtop.instance(null).getMtopConfig().utdid;
    }

    @Deprecated
    public String getGlobalTtid() {
        return Mtop.instance(null).getMtopConfig().ttid;
    }

    @Deprecated
    public EnvModeEnum getGlobalEnvMode() {
        return Mtop.instance(null).getMtopConfig().envMode;
    }

    @Deprecated
    public String getGlobalAppVersion() {
        return Mtop.instance(null).getMtopConfig().appVersion;
    }

    @Deprecated
    public int getGlobalDailyAppKeyIndex() {
        return Mtop.instance(null).getMtopConfig().dailyAppkeyIndex;
    }

    @Deprecated
    public int getGlobalOnlineAppKeyIndex() {
        return Mtop.instance(null).getMtopConfig().onlineAppKeyIndex;
    }
}
