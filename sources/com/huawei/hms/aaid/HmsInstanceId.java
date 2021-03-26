package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.a;
import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.d;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.j;
import com.huawei.hms.opendevice.k;
import com.huawei.hms.opendevice.m;
import com.huawei.hms.opendevice.n;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;

public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";
    private static final byte[] a = new byte[0];
    private static final byte[] b = new byte[0];
    private Context c = null;
    private q d = null;
    private HuaweiApi<Api.ApiOptions.NoOptions> e;

    private HmsInstanceId(Context context) {
        this.c = context.getApplicationContext();
        this.d = new q(context, "aaid");
        Api api = new Api("HuaweiPush.API");
        if (context instanceof Activity) {
            this.e = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new m());
        } else {
            this.e = new HuaweiApi<>(context, api, (Api.ApiOptions) null, new m());
        }
        this.e.setKitSdkVersion(50002300);
    }

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        d.b(context);
        return new HmsInstanceId(context);
    }

    public String getId() {
        return n.b(this.c);
    }

    public Task<AAIDResult> getAAID() {
        try {
            return Tasks.callInBackground(new i(this.c.getApplicationContext()));
        } catch (Exception unused) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(a.a(a.ERROR_INTERNAL_ERROR));
            return taskCompletionSource.getTask();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.d.d("creationTime")) {
                getAAID();
            }
            return this.d.c("creationTime");
        } catch (Exception unused) {
            return 0;
        }
    }

    public void deleteAAID() throws ApiException {
        try {
            if (this.d.d("aaid")) {
                this.d.e("aaid");
                this.d.e("creationTime");
            }
        } catch (RuntimeException unused) {
            throw a.a(a.ERROR_INTERNAL_ERROR);
        } catch (Exception unused2) {
            throw a.a(a.ERROR_INTERNAL_ERROR);
        }
    }

    @Deprecated
    public String getToken() {
        try {
            return getToken(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getToken(String str, String str2) throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw a.a(a.ERROR_MAIN_THREAD);
        } else if (ProxyCenter.getInstance().getProxy() != null) {
            ProxyCenter.getInstance().getProxy().getToken(this.c);
            HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            return null;
        } else {
            String a2 = p.a(this.c, "push.gettoken");
            try {
                TokenReq a3 = n.a(str, str2, this.c);
                a3.setAaid(getId());
                String str3 = TAG;
                HMSLog.d(str3, "getToken req :" + a3.toString());
                return ((TokenResult) Tasks.await(this.e.doWrite(new k("push.gettoken", JsonUtil.createJsonString(a3), this.c, a2)))).getToken();
            } catch (Exception e2) {
                if (e2.getCause() instanceof ApiException) {
                    ApiException apiException = (ApiException) e2.getCause();
                    p.a(this.c, "push.gettoken", a2, apiException.getStatusCode());
                    throw apiException;
                }
                p.a(this.c, "push.gettoken", a2, a.ERROR_INTERNAL_ERROR);
                throw a.a(a.ERROR_INTERNAL_ERROR);
            }
        }
    }

    public void deleteToken(String str, String str2) throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw a.a(a.ERROR_MAIN_THREAD);
        } else if (ProxyCenter.getInstance().getProxy() != null) {
            HMSLog.i(TAG, "use proxy delete token");
            ProxyCenter.getInstance().getProxy().deleteToken(this.c);
        } else {
            String a2 = p.a(this.c, "push.deletetoken");
            try {
                DeleteTokenReq deleteTokenReq = new DeleteTokenReq();
                deleteTokenReq.setAppId(str);
                deleteTokenReq.setScope(str2);
                deleteTokenReq.setPkgName(this.c.getPackageName());
                if (TextUtils.isEmpty(str)) {
                    deleteTokenReq.setAppId(Util.getAppId(this.c));
                }
                if (TextUtils.isEmpty(str2)) {
                    deleteTokenReq.setScope("HCM");
                }
                String a3 = c.a(this.c, "push_client_self_info");
                if (!TextUtils.isEmpty(a3)) {
                    deleteTokenReq.setToken(a3);
                }
                Tasks.await(this.e.doWrite(new j("push.deletetoken", JsonUtil.createJsonString(deleteTokenReq), a2)));
                c.b(this.c, "push_client_self_info");
            } catch (Exception e2) {
                if (e2.getCause() instanceof ApiException) {
                    ApiException apiException = (ApiException) e2.getCause();
                    p.a(this.c, "push.deletetoken", a2, apiException.getStatusCode());
                    throw apiException;
                }
                p.a(this.c, "push.deletetoken", a2, a.ERROR_INTERNAL_ERROR);
                throw a.a(a.ERROR_INTERNAL_ERROR);
            }
        }
    }
}
