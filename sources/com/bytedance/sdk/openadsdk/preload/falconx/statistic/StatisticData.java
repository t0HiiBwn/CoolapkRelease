package com.bytedance.sdk.openadsdk.preload.falconx.statistic;

import com.bytedance.sdk.openadsdk.preload.a.a.c;
import java.util.List;

public class StatisticData {
    public static final String ERROR_CODE_IO_ERROR = "101";
    public static final String ERROR_CODE_NOT_FOUND = "100";
    @c(a = "common")
    public Common mCommon;
    @c(a = "offline")
    public List<InterceptorModel> offline;
}
