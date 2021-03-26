package com.huawei.hms.push;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: SendUpStreamTask */
public class d extends TaskApiCall<h, b> {
    private String a;
    private String b;

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40003000;
    }

    public d(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3);
        this.a = str4;
        this.b = str5;
    }

    /* access modifiers changed from: protected */
    public void doExecute(h hVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<b> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() == 0) {
            HMSLog.i("SendUpStreamTask", "send up stream task,Operate succeed");
            taskCompletionSource.setResult(null);
        } else {
            HMSLog.e("SendUpStreamTask", "send up stream task,Operate failed with ret=" + responseErrorCode.getErrorCode());
            a a2 = a.a(responseErrorCode.getErrorCode());
            if (a2 != a.ERROR_UNKNOWN) {
                taskCompletionSource.setException(a.a(a2));
            } else {
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
        a(hVar, responseErrorCode);
    }

    private void a(h hVar, ResponseErrorCode responseErrorCode) {
        HMSLog.i("SendUpStreamTask", "receive upstream, msgId :" + this.b + " , packageName = " + this.a + " , errorCode = " + responseErrorCode.getErrorCode());
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(this.a);
        Bundle bundle = new Bundle();
        bundle.putString("message_id", this.b);
        bundle.putInt("error", responseErrorCode.getErrorCode());
        if (a.SUCCESS.a() == responseErrorCode.getErrorCode()) {
            bundle.putString("message_type", "sent_message");
        } else {
            bundle.putString("message_type", "send_error");
        }
        if (new l().a(hVar.getContext(), bundle, intent)) {
            HMSLog.i("SendUpStreamTask", "receive upstream, start service success");
            g.a(hVar.getContext(), getUri(), responseErrorCode);
            return;
        }
        HMSLog.w("SendUpStreamTask", "receive upstream, start service failed");
        g.a(hVar.getContext(), getUri(), responseErrorCode.getTransactionId(), a.ERROR_BIND_SERVICE_SELF_MAPPING);
    }
}
