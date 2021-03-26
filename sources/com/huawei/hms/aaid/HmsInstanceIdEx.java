package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.a;
import com.huawei.hms.opendevice.k;
import com.huawei.hms.opendevice.m;
import com.huawei.hms.opendevice.n;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class HmsInstanceIdEx {
    public static final String TAG = "HmsInstanceIdEx";
    private static final byte[] a = new byte[0];
    private Context b = null;
    private q c = null;
    private HuaweiApi<Api.ApiOptions.NoOptions> d;

    private HmsInstanceIdEx(Context context) {
        this.b = context;
        this.c = new q(context, "aaid");
        Api api = new Api("HuaweiPush.API");
        if (context instanceof Activity) {
            this.d = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new m());
        } else {
            this.d = new HuaweiApi<>(context, api, (Api.ApiOptions) null, new m());
        }
        this.d.setKitSdkVersion(50002300);
    }

    public static HmsInstanceIdEx getInstance(Context context) {
        Preconditions.checkNotNull(context);
        return new HmsInstanceIdEx(context);
    }

    public Task<TokenResult> getToken() {
        if (ProxyCenter.getInstance().getProxy() != null) {
            try {
                HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
                ProxyCenter.getInstance().getProxy().getToken(this.b);
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setResult(new TokenResult());
                return taskCompletionSource.getTask();
            } catch (ApiException e) {
                return a(e);
            } catch (Exception unused) {
                return a(a.a(a.ERROR_INTERNAL_ERROR));
            }
        } else {
            String a2 = p.a(this.b, "push.gettoken");
            try {
                TokenReq a3 = n.a(null, null, this.b);
                a3.setAaid(HmsInstanceId.getInstance(this.b).getId());
                return this.d.doWrite(new k("push.gettoken", JsonUtil.createJsonString(a3), this.b, a2));
            } catch (RuntimeException unused2) {
                p.a(this.b, "push.gettoken", a2, a.ERROR_INTERNAL_ERROR);
                return a(a.a(a.ERROR_INTERNAL_ERROR));
            } catch (Exception unused3) {
                p.a(this.b, "push.gettoken", a2, a.ERROR_INTERNAL_ERROR);
                return a(a.a(a.ERROR_INTERNAL_ERROR));
            }
        }
    }

    public String getAAId(String str) throws ApiException {
        if (str != null) {
            try {
                if (this.c.d(str)) {
                    return this.c.b(str);
                }
                String a2 = n.a(this.b);
                String a3 = n.a(str + a2);
                this.c.a(str, a3);
                this.c.a(a(str), Long.valueOf(System.currentTimeMillis()));
                return a3;
            } catch (RuntimeException unused) {
                throw a.a(a.ERROR_INTERNAL_ERROR);
            } catch (Exception unused2) {
                throw a.a(a.ERROR_INTERNAL_ERROR);
            }
        } else {
            throw a.a(a.ERROR_ARGUMENTS_INVALID);
        }
    }

    public long getCreationTime(String str) throws ApiException {
        if (str != null) {
            try {
                if (!this.c.d(a(str))) {
                    getAAId(str);
                }
                return this.c.c(a(str));
            } catch (RuntimeException unused) {
                throw a.a(a.ERROR_INTERNAL_ERROR);
            } catch (Exception unused2) {
                throw a.a(a.ERROR_INTERNAL_ERROR);
            }
        } else {
            throw a.a(a.ERROR_ARGUMENTS_INVALID);
        }
    }

    public void deleteAAID(String str) throws ApiException {
        if (str != null) {
            try {
                if (this.c.d(str)) {
                    this.c.e(str);
                    this.c.e(a(str));
                }
            } catch (RuntimeException unused) {
                throw a.a(a.ERROR_INTERNAL_ERROR);
            } catch (Exception unused2) {
                throw a.a(a.ERROR_INTERNAL_ERROR);
            }
        } else {
            throw a.a(a.ERROR_ARGUMENTS_INVALID);
        }
    }

    private String a(String str) {
        return "creationTime" + str;
    }

    private Task<TokenResult> a(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }
}
