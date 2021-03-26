package com.bytedance.sdk.openadsdk.preload.falconx.statistic;

import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.preload.a.a.c;

public class InterceptorModel {
    @c(a = "ac")
    public String ac;
    @c(a = "access_key")
    public String accessKey;
    @c(a = "channel")
    public String channel;
    @c(a = "err_code")
    public String errCode;
    @c(a = "err_msg")
    public String errMsg;
    @c(a = "log_id")
    public String logId;
    @c(a = "mime_type")
    public String mimeType;
    @c(a = "offline_duration")
    public Long offlineDuration;
    @c(a = "offline_rule")
    public String offlineRule;
    @c(a = "offline_status")
    public Integer offlineStatus;
    @c(a = "online_duration")
    public Long onlineDuration;
    @c(a = "page_url")
    public String pageUrl;
    @c(a = "pkg_version")
    public Long pkgVersion;
    @c(a = "res_root_dir")
    public String resRootDir;
    public Long startTime = Long.valueOf(SystemClock.uptimeMillis());
    @c(a = "resource_url")
    public String url;

    public void setErrorCode(String str) {
        this.errCode = str;
    }

    public void setErrorMsg(String str) {
        this.errMsg = str;
    }

    public void loadFinish(boolean z) {
        if (z) {
            this.offlineDuration = Long.valueOf(SystemClock.uptimeMillis() - this.startTime.longValue());
            this.offlineStatus = 1;
            return;
        }
        this.offlineStatus = 0;
    }
}
