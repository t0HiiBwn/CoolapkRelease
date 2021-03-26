package com.bytedance.sdk.openadsdk.preload.falconx.statistic;

import android.os.Build;
import com.bytedance.sdk.openadsdk.preload.a.a.c;

public class Common {
    @c(a = "app_version")
    public String appVersion;
    @c(a = "device_id")
    public String deviceId;
    @c(a = "device_model")
    public String deviceModel = Build.MODEL;
    @c(a = "os")
    public int os = 0;
    @c(a = "region")
    public String region;
    @c(a = "sdk_version")
    public String sdkVersion = "2.0.3-rc.9-pangle";
}
