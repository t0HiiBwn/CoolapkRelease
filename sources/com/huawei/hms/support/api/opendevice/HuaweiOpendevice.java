package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.api.Api;

public class HuaweiOpendevice {
    public static final HuaweiOpendeviceApi HuaweiOpendeviceApi = new HuaweiOpendeviceApiImpl();
    public static final Api<Api.ApiOptions.NoOptions> OPEN_DEVICE_API = new Api<>("HuaweiOpenDevice.API");
}
