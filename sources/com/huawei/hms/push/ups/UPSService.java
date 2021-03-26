package com.huawei.hms.push.ups;

import android.content.Context;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.a;
import com.huawei.hms.push.ups.entity.CodeResult;
import com.huawei.hms.push.ups.entity.TokenResult;
import com.huawei.hms.push.ups.entity.UPSRegisterCallBack;
import com.huawei.hms.push.ups.entity.UPSTurnCallBack;
import com.huawei.hms.push.ups.entity.UPSUnRegisterCallBack;
import com.huawei.hms.push.w;
import com.huawei.hms.support.log.HMSLog;

public final class UPSService {
    private UPSService() {
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        HMSLog.i("UPSService", "invoke registerToken");
        Preconditions.checkNotNull(uPSRegisterCallBack);
        if (!w.a()) {
            uPSRegisterCallBack.onResult(new TokenResult(a.ERROR_OPERATION_NOT_SUPPORTED.b()));
            return;
        }
        try {
            uPSRegisterCallBack.onResult(new TokenResult(HmsInstanceId.getInstance(context).getToken(str, null)));
        } catch (ApiException e) {
            uPSRegisterCallBack.onResult(new TokenResult(e.getStatusCode(), e.getMessage()));
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        HMSLog.i("UPSService", "invoke unRegisterToken");
        Preconditions.checkNotNull(uPSUnRegisterCallBack);
        if (!w.a()) {
            uPSUnRegisterCallBack.onResult(new TokenResult(a.ERROR_OPERATION_NOT_SUPPORTED.b()));
            return;
        }
        try {
            HmsInstanceId.getInstance(context).deleteToken(null, null);
            uPSUnRegisterCallBack.onResult(new TokenResult());
        } catch (ApiException e) {
            uPSUnRegisterCallBack.onResult(new TokenResult(e.getStatusCode(), e.getMessage()));
        }
    }

    public static void turnOnPush(Context context, final UPSTurnCallBack uPSTurnCallBack) {
        HMSLog.i("UPSService", "invoke turnOnPush");
        Preconditions.checkNotNull(uPSTurnCallBack);
        if (!w.a()) {
            uPSTurnCallBack.onResult(new TokenResult(a.ERROR_OPERATION_NOT_SUPPORTED.b()));
        } else {
            HmsMessaging.getInstance(context).turnOnPush().addOnCompleteListener(new OnCompleteListener<Void>() {
                /* class com.huawei.hms.push.ups.UPSService.AnonymousClass1 */

                @Override // com.huawei.hmf.tasks.OnCompleteListener
                public void onComplete(Task<Void> task) {
                    if (task.isSuccessful()) {
                        uPSTurnCallBack.onResult(new CodeResult());
                        return;
                    }
                    ApiException apiException = (ApiException) task.getException();
                    uPSTurnCallBack.onResult(new CodeResult(apiException.getStatusCode(), apiException.getMessage()));
                }
            });
        }
    }

    public static void turnOffPush(Context context, final UPSTurnCallBack uPSTurnCallBack) {
        HMSLog.i("UPSService", "invoke turnOffPush");
        Preconditions.checkNotNull(uPSTurnCallBack);
        if (!w.a()) {
            uPSTurnCallBack.onResult(new TokenResult(a.ERROR_OPERATION_NOT_SUPPORTED.b()));
        } else {
            HmsMessaging.getInstance(context).turnOffPush().addOnCompleteListener(new OnCompleteListener<Void>() {
                /* class com.huawei.hms.push.ups.UPSService.AnonymousClass2 */

                @Override // com.huawei.hmf.tasks.OnCompleteListener
                public void onComplete(Task<Void> task) {
                    if (task.isSuccessful()) {
                        uPSTurnCallBack.onResult(new CodeResult());
                        return;
                    }
                    ApiException apiException = (ApiException) task.getException();
                    uPSTurnCallBack.onResult(new CodeResult(apiException.getStatusCode(), apiException.getMessage()));
                }
            });
        }
    }
}