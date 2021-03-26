package com.tencent.imsdk.v2;

import com.tencent.imsdk.TIMSdkConfig;

public class V2TIMSDKConfig {
    public static final int V2TIM_LOG_DEBUG = 3;
    public static final int V2TIM_LOG_ERROR = 6;
    public static final int V2TIM_LOG_INFO = 4;
    public static final int V2TIM_LOG_NONE = 0;
    public static final int V2TIM_LOG_WARN = 5;
    private int logLevel = 4;

    TIMSdkConfig initV1SDKConfig(int i) {
        TIMSdkConfig tIMSdkConfig = new TIMSdkConfig(i);
        tIMSdkConfig.setLogLevel(this.logLevel);
        return tIMSdkConfig;
    }

    public void setLogLevel(int i) {
        this.logLevel = i;
    }
}
