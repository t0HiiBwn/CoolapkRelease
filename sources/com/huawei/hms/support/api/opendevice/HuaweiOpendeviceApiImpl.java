package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.opendevice.OdidReq;
import com.huawei.hms.support.api.entity.opendevice.OdidResp;
import com.huawei.hms.support.log.HMSLog;

public class HuaweiOpendeviceApiImpl implements HuaweiOpendeviceApi {
    @Override // com.huawei.hms.support.api.opendevice.HuaweiOpendeviceApi
    public PendingResult<OdidResult> getOdid(HuaweiApiClient huaweiApiClient) {
        HMSLog.i("OpenIdentifierApiImpl", "Enter getOdid");
        return new PendingResultImpl<OdidResult, OdidResp>(huaweiApiClient, "opendevice.getodid", new OdidReq()) {
            /* class com.huawei.hms.support.api.opendevice.HuaweiOpendeviceApiImpl.AnonymousClass1 */

            /* renamed from: a */
            public OdidResult onComplete(OdidResp odidResp) {
                if (odidResp == null) {
                    HMSLog.e("OpenIdentifierApiImpl", "getOdid OaidResp is null");
                    return null;
                }
                Status commonStatus = odidResp.getCommonStatus();
                if (commonStatus == null) {
                    HMSLog.e("OpenIdentifierApiImpl", "getOdid commonStatus is null");
                    return null;
                }
                HMSLog.i("OpenIdentifierApiImpl", "getOdid onComplete:" + commonStatus.getStatusCode());
                OdidResult odidResult = new OdidResult();
                odidResult.setStatus(commonStatus);
                odidResult.setId(odidResp.getId());
                return odidResult;
            }
        };
    }
}
