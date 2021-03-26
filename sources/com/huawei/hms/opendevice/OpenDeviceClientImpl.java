package com.huawei.hms.opendevice;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.JsonUtil;

public class OpenDeviceClientImpl extends HuaweiApi<OpenDeviceOptions> implements OpenDeviceClient {
    private static final OpenDeviceHmsClientBuilder a = new OpenDeviceHmsClientBuilder();
    private static final Api<OpenDeviceOptions> b = new Api<>("HuaweiOpenDevice.API");
    private static OpenDeviceOptions c = new OpenDeviceOptions();

    OpenDeviceClientImpl(Activity activity) {
        super(activity, b, c, (AbstractClientBuilder) a);
        super.setKitSdkVersion(50002300);
    }

    OpenDeviceClientImpl(Context context) {
        super(context, b, c, a);
        super.setKitSdkVersion(50002300);
    }

    @Override // com.huawei.hms.opendevice.OpenDeviceClient
    public Task<OdidResult> getOdid() {
        return doWrite(new OpenDeviceTaskApiCall("opendevice.getodid", JsonUtil.createJsonString(null), HiAnalyticsClient.reportEntry(getContext(), "opendevice.getodid", 50002300)));
    }
}
