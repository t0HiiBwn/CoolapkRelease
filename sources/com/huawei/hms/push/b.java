package com.huawei.hms.push;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: BaseVoidTask */
public class b extends TaskApiCall<h, Void> {
    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 30000000;
    }

    public b(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* access modifiers changed from: protected */
    public void doExecute(h hVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() == 0) {
            HMSLog.i("BaseVoidTask", "Operate succeed");
            taskCompletionSource.setResult(null);
        } else {
            HMSLog.e("BaseVoidTask", "Operate failed with ret=" + responseErrorCode.getErrorCode());
            a a = a.a(responseErrorCode.getErrorCode());
            if (a != a.ERROR_UNKNOWN) {
                taskCompletionSource.setException(a.a(a));
            } else {
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
        g.a(hVar.getContext(), getUri(), responseErrorCode);
    }
}
