package com.huawei.hms.common.api;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.log.HMSLog;

public class AvailabilityException extends Exception {
    private String a = "AvailabilityException";
    private String b = null;

    private void a(int i) {
        if (i == 0) {
            this.b = "success";
        } else if (i == 1) {
            this.b = "SERVICE_MISSING";
        } else if (i == 2) {
            this.b = "SERVICE_VERSION_UPDATE_REQUIRED";
        } else if (i == 3) {
            this.b = "SERVICE_DISABLED";
        } else if (i != 21) {
            this.b = "INTERNAL_ERROR";
        } else {
            this.b = "ANDROID_VERSION_UNSUPPORT";
        }
    }

    private ConnectionResult b(int i) {
        String str = this.a;
        HMSLog.i(str, "The availability check result is: " + i);
        a(i);
        return new ConnectionResult(i);
    }

    public ConnectionResult getConnectionResult(HuaweiApiCallable huaweiApiCallable) {
        if (huaweiApiCallable == null || huaweiApiCallable.getHuaweiApi() == null) {
            HMSLog.e(this.a, "The huaweiApi is null.");
            return b(8);
        }
        return b(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(huaweiApiCallable.getHuaweiApi().getContext(), 30000000));
    }

    public ConnectionResult getConnectionResult(HuaweiApi<? extends Api.ApiOptions> huaweiApi) {
        if (huaweiApi == null) {
            HMSLog.e(this.a, "The huaweiApi is null.");
            return b(8);
        }
        return b(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(huaweiApi.getContext(), 30000000));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b;
    }
}
