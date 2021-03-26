package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.HmsInstanceIdEx;
import com.huawei.hms.aaid.entity.TokenResp;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.task.ReportAaidToken;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* compiled from: GetTokenTask */
public class k extends TaskApiCall<l, TokenResult> {
    private Context a;

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 30000000;
    }

    public k(String str, String str2, Context context, String str3) {
        super(str, str2, str3);
        this.a = context;
    }

    /* access modifiers changed from: protected */
    public void doExecute(l lVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<TokenResult> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() != 0) {
            String str2 = HmsInstanceIdEx.TAG;
            HMSLog.e(str2, "TokenTask failed, ErrorCode: " + responseErrorCode.getErrorCode());
            a a2 = a.a(responseErrorCode.getErrorCode());
            if (a2 != a.ERROR_UNKNOWN) {
                taskCompletionSource.setException(a.a(a2));
            } else {
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        } else {
            TokenResp tokenResp = (TokenResp) JsonUtil.jsonToEntity(str, new TokenResp());
            a a3 = a.a(tokenResp.getRetCode());
            if (a3 != a.SUCCESS) {
                taskCompletionSource.setException(a.a(a3));
                String str3 = HmsInstanceIdEx.TAG;
                HMSLog.e(str3, "TokenTask failed, StatusCode:" + a3.a());
            } else {
                TokenResult tokenResult = new TokenResult();
                tokenResult.setToken(tokenResp.getToken());
                tokenResult.setBelongId(tokenResp.getBelongId());
                tokenResult.setRetCode(a.a(tokenResp.getRetCode()).a());
                taskCompletionSource.setResult(tokenResult);
                String token = tokenResp.getToken();
                if (TextUtils.isEmpty(token)) {
                    HMSLog.i(HmsInstanceId.TAG, "GetTokenTask receive a empty token, please check HmsMessageService.onNewToken receive result.");
                    p.a(lVar.getContext(), getUri(), responseErrorCode);
                    return;
                }
                if (!c.a(this.a, "push_client_self_info").equals(token)) {
                    HMSLog.i(HmsInstanceId.TAG, "receive a token, refresh the local token");
                    c.a(this.a, "push_client_self_info", token);
                }
                ReportAaidToken.report(this.a, token);
            }
        }
        p.a(lVar.getContext(), getUri(), responseErrorCode);
    }
}
