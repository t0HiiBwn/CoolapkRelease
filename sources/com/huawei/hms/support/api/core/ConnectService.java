package com.huawei.hms.support.api.core;

import android.text.TextUtils;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolvePendingResult;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CheckConnectResp;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeReq;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;

public final class ConnectService {
    private ConnectService() {
    }

    public static PendingResult<ResolveResult<ConnectResp>> connect(ApiClient apiClient, ConnectInfo connectInfo) {
        return new PendingResultImpl<ResolveResult<ConnectResp>, ConnectResp>(apiClient, "core.connect", connectInfo) {
            /* class com.huawei.hms.support.api.core.ConnectService.AnonymousClass1 */

            @Override // com.huawei.hms.support.api.PendingResultImpl
            protected boolean checkApiClient(ApiClient apiClient) {
                return apiClient != null;
            }

            /* renamed from: a */
            public ResolveResult<ConnectResp> onComplete(ConnectResp connectResp) {
                ResolveResult<ConnectResp> resolveResult = new ResolveResult<>(connectResp);
                resolveResult.setStatus(Status.SUCCESS);
                HMSLog.d("connectservice", "connect - onComplete: success");
                return resolveResult;
            }
        };
    }

    public static PendingResult<ResolveResult<ConnectResp>> forceConnect(ApiClient apiClient, ConnectInfo connectInfo) {
        return new PendingResultImpl<ResolveResult<ConnectResp>, ConnectResp>(apiClient, "core.foreconnect", connectInfo) {
            /* class com.huawei.hms.support.api.core.ConnectService.AnonymousClass2 */

            @Override // com.huawei.hms.support.api.PendingResultImpl
            protected boolean checkApiClient(ApiClient apiClient) {
                return apiClient != null;
            }

            /* renamed from: a */
            public ResolveResult<ConnectResp> onComplete(ConnectResp connectResp) {
                ResolveResult<ConnectResp> resolveResult = new ResolveResult<>(connectResp);
                resolveResult.setStatus(Status.SUCCESS);
                HMSLog.d("connectservice", "forceConnect - onComplete: success");
                return resolveResult;
            }
        };
    }

    public static ResolvePendingResult<DisconnectResp> disconnect(ApiClient apiClient, DisconnectInfo disconnectInfo) {
        return ResolvePendingResult.build(apiClient, "core.disconnect", disconnectInfo, DisconnectResp.class);
    }

    public static InnerPendingResult<ResolveResult<CheckConnectResp>> checkconnect(ApiClient apiClient, CheckConnectInfo checkConnectInfo) {
        return ResolvePendingResult.build(apiClient, "core.checkconnect", checkConnectInfo, CheckConnectResp.class);
    }

    public static PendingResult<ResolveResult<JosGetNoticeResp>> getNotice(ApiClient apiClient, int i, String str) {
        JosGetNoticeReq josGetNoticeReq = new JosGetNoticeReq();
        josGetNoticeReq.setNoticeType(i);
        josGetNoticeReq.setHmsSdkVersionName(str);
        if (!TextUtils.isEmpty(apiClient.getCpID())) {
            josGetNoticeReq.setCpID(apiClient.getCpID());
        }
        return new PendingResultImpl<ResolveResult<JosGetNoticeResp>, JosGetNoticeResp>(apiClient, "core.getNoticeIntent", josGetNoticeReq) {
            /* class com.huawei.hms.support.api.core.ConnectService.AnonymousClass3 */

            /* renamed from: a */
            public ResolveResult<JosGetNoticeResp> onComplete(JosGetNoticeResp josGetNoticeResp) {
                if (josGetNoticeResp == null) {
                    HMSLog.e("connectservice", "JosNoticeResp is null");
                    return null;
                }
                HMSLog.i("connectservice", "josNoticeResp status code :" + josGetNoticeResp.getStatusCode());
                ResolveResult<JosGetNoticeResp> resolveResult = new ResolveResult<>(josGetNoticeResp);
                resolveResult.setStatus(Status.SUCCESS);
                return resolveResult;
            }
        };
    }
}
