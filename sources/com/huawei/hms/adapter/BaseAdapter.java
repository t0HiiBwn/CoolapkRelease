package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.BaseResolutionAdapter;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

public class BaseAdapter {
    private WeakReference<ApiClient> a;
    private WeakReference<Activity> b;
    private BaseCallBack c;
    private String d;
    private String e;
    private Parcelable f;
    private BaseCallBack g;
    private String h;
    private Context i;
    private RequestHeader j = new RequestHeader();
    private ResponseHeader k = new ResponseHeader();
    private SystemObserver l;

    public interface BaseCallBack {
        void onComplete(String str, String str2, Parcelable parcelable);

        void onError(String str);
    }

    public BaseAdapter(ApiClient apiClient) {
        this.a = new WeakReference<>(apiClient);
    }

    public BaseAdapter(ApiClient apiClient, Activity activity) {
        this.a = new WeakReference<>(apiClient);
        this.b = new WeakReference<>(activity);
        this.i = activity.getApplicationContext();
    }

    public void baseRequest(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        a(str, str2, parcelable, baseCallBack);
        WeakReference<ApiClient> weakReference = this.a;
        if (weakReference == null) {
            HMSLog.e("BaseAdapter", "client is null");
            h();
            baseCallBack.onError(a(-2));
            return;
        }
        ApiClient apiClient = weakReference.get();
        this.c = baseCallBack;
        JsonUtil.jsonToEntity(str, this.j);
        CoreBaseRequest coreBaseRequest = new CoreBaseRequest();
        coreBaseRequest.setJsonObject(str2);
        coreBaseRequest.setJsonHeader(str);
        coreBaseRequest.setParcelable(parcelable);
        String apiName = this.j.getApiName();
        if (TextUtils.isEmpty(apiName)) {
            HMSLog.e("BaseAdapter", "get uri null");
            h();
            baseCallBack.onError(a(-5));
            return;
        }
        String transactionId = this.j.getTransactionId();
        this.h = transactionId;
        if (TextUtils.isEmpty(transactionId)) {
            HMSLog.e("BaseAdapter", "get transactionId null");
            h();
            baseCallBack.onError(a(-6));
            return;
        }
        HMSLog.i("BaseAdapter", "in baseRequest + uri is :" + apiName + ", transactionId is : " + this.h);
        a(this.i, this.j);
        a(apiClient, apiName, coreBaseRequest).setResultCallback(new BaseRequestResultCallback());
    }

    private PendingResult<ResolveResult<CoreBaseResponse>> a(ApiClient apiClient, String str, CoreBaseRequest coreBaseRequest) {
        return new a(apiClient, str, coreBaseRequest);
    }

    private static class a extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse> {
        public a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        /* renamed from: a */
        public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse coreBaseResponse) {
            ResolveResult<CoreBaseResponse> resolveResult = new ResolveResult<>(coreBaseResponse);
            resolveResult.setStatus(Status.SUCCESS);
            return resolveResult;
        }
    }

    /* access modifiers changed from: private */
    public Activity a() {
        if (this.b == null) {
            HMSLog.i("BaseAdapter", "activityWeakReference is " + this.b);
            return null;
        }
        ApiClient apiClient = this.a.get();
        if (apiClient == null) {
            HMSLog.i("BaseAdapter", "tmpApi is " + apiClient);
            return null;
        }
        HMSLog.i("BaseAdapter", "activityWeakReference has " + this.b.get());
        return Util.getActiveActivity(this.b.get(), apiClient.getContext());
    }

    public class BaseRequestResultCallback implements ResultCallback<ResolveResult<CoreBaseResponse>> {
        public BaseRequestResultCallback() {
        }

        public void onResult(ResolveResult<CoreBaseResponse> resolveResult) {
            BaseCallBack b = BaseAdapter.this.b();
            if (b == null) {
                HMSLog.e("BaseAdapter", "onResult baseCallBack null");
                BaseAdapter.this.h();
            } else if (resolveResult == null) {
                HMSLog.e("BaseAdapter", "result null");
                b.onError(BaseAdapter.this.a(-1));
                BaseAdapter.this.h();
            } else {
                CoreBaseResponse value = resolveResult.getValue();
                if (value == null) {
                    HMSLog.e("BaseAdapter", "response null");
                    BaseAdapter.this.h();
                    b.onError(BaseAdapter.this.a(-1));
                } else if (TextUtils.isEmpty(value.getJsonHeader())) {
                    HMSLog.e("BaseAdapter", "jsonHeader null");
                    BaseAdapter.this.h();
                    b.onError(BaseAdapter.this.a(-1));
                } else {
                    JsonUtil.jsonToEntity(value.getJsonHeader(), BaseAdapter.this.k);
                    BaseAdapter baseAdapter = BaseAdapter.this;
                    baseAdapter.a(baseAdapter.i, BaseAdapter.this.k);
                    if ("intent".equals(BaseAdapter.this.k.getResolution())) {
                        Activity a2 = BaseAdapter.this.a();
                        HMSLog.i("BaseAdapter", "activity is " + a2);
                        if (a2 == null || a2.isFinishing()) {
                            HMSLog.e("BaseAdapter", "activity null");
                            a(b, value);
                            return;
                        }
                        PendingIntent pendingIntent = value.getPendingIntent();
                        if (pendingIntent == null) {
                            Intent intent = value.getIntent();
                            if (intent == null) {
                                HMSLog.e("BaseAdapter", "hasResolution is true but NO_SOLUTION");
                                BaseAdapter.this.h();
                                b.onError(BaseAdapter.this.a(-4));
                            } else if (Util.isAvailableLibExist(BaseAdapter.this.i)) {
                                BaseAdapter.this.a(a2, intent);
                            } else {
                                b.onError(BaseAdapter.this.a(-9));
                            }
                        } else if (Util.isAvailableLibExist(BaseAdapter.this.i)) {
                            BaseAdapter.this.a(a2, pendingIntent);
                        } else {
                            b.onError(BaseAdapter.this.a(-9));
                        }
                    } else {
                        a(b, value);
                    }
                }
            }
        }

        private void a(BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
            HMSLog.i("BaseAdapter", "baseCallBack.onComplete");
            PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
            if (pendingIntent != null) {
                BaseAdapter.this.h();
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), pendingIntent);
                return;
            }
            Intent intent = coreBaseResponse.getIntent();
            if (intent != null) {
                BaseAdapter.this.h();
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), intent);
                return;
            }
            BaseAdapter.this.h();
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), null);
        }
    }

    /* access modifiers changed from: private */
    public void a(Activity activity, Parcelable parcelable) {
        HMSLog.i("BaseAdapter", "startResolution");
        RequestHeader requestHeader = this.j;
        if (requestHeader != null) {
            b(this.i, requestHeader);
        }
        if (this.l == null) {
            i();
        }
        SystemManager.getSystemNotifier().registerObserver(this.l);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, BaseResolutionAdapter.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable("resolution", parcelable);
        intentStartBridgeActivity.putExtras(bundle);
        intentStartBridgeActivity.putExtra("transaction_id", this.h);
        activity.startActivity(intentStartBridgeActivity);
    }

    /* access modifiers changed from: private */
    public BaseCallBack b() {
        BaseCallBack baseCallBack = this.c;
        if (baseCallBack != null) {
            return baseCallBack;
        }
        HMSLog.e("BaseAdapter", "callback null");
        return null;
    }

    private void a(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put("direction", "req");
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_BASE_CALL_AIDL", mapFromRequestHeader);
    }

    private void b(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put("direction", "req");
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_BASE_START_RESOLUTION", mapFromRequestHeader);
    }

    /* access modifiers changed from: private */
    public void a(Context context, ResponseHeader responseHeader) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put("direction", "rsp");
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.j.getKitSdkVersion())));
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_BASE_CALL_AIDL", mapFromRequestHeader);
    }

    /* access modifiers changed from: private */
    public void a(Context context, ResponseHeader responseHeader, long j2) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put("direction", "rsp");
        mapFromRequestHeader.put("waitTime", String.valueOf(j2));
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.j.getKitSdkVersion())));
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_BASE_START_RESOLUTION", mapFromRequestHeader);
    }

    /* access modifiers changed from: private */
    public String a(int i2) {
        this.k.setTransactionId(this.j.getTransactionId());
        this.k.setAppID(this.j.getAppID());
        this.k.setApiName(this.j.getApiName());
        this.k.setSrvName(this.j.getSrvName());
        this.k.setPkgName(this.j.getPkgName());
        this.k.setStatusCode(1);
        this.k.setErrorCode(i2);
        this.k.setErrorReason("Core error");
        return this.k.toJson();
    }

    private String c() {
        return this.d;
    }

    private void a(String str) {
        this.d = str;
    }

    private String d() {
        return this.e;
    }

    private void b(String str) {
        this.e = str;
    }

    private Parcelable e() {
        return this.f;
    }

    private void a(Parcelable parcelable) {
        this.f = parcelable;
    }

    private BaseCallBack f() {
        return this.g;
    }

    private void a(BaseCallBack baseCallBack) {
        this.g = baseCallBack;
    }

    private void a(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        a(str);
        b(str2);
        a(parcelable);
        a(baseCallBack);
    }

    /* access modifiers changed from: private */
    public void g() {
        this.k = null;
        this.k = new ResponseHeader();
        baseRequest(c(), d(), e(), f());
        h();
    }

    /* access modifiers changed from: private */
    public void h() {
        a((String) null);
        b((String) null);
        a((Parcelable) null);
        a((BaseCallBack) null);
    }

    private void i() {
        this.l = new SystemObserver() {
            /* class com.huawei.hms.adapter.BaseAdapter.AnonymousClass1 */

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onUpdateResult(int i) {
                return false;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onSolutionResult(Intent intent, String str) {
                if (TextUtils.isEmpty(str)) {
                    HMSLog.e("BaseAdapter", "onSolutionResult but id is null");
                    BaseCallBack b = BaseAdapter.this.b();
                    if (b == null) {
                        HMSLog.e("BaseAdapter", "onSolutionResult baseCallBack null");
                        BaseAdapter.this.h();
                        return true;
                    }
                    b.onError(BaseAdapter.this.a(-6));
                    BaseAdapter.this.h();
                    return true;
                } else if (!str.equals(BaseAdapter.this.h)) {
                    return false;
                } else {
                    HMSLog.i("BaseAdapter", "onSolutionResult + id is :" + str);
                    BaseCallBack b2 = BaseAdapter.this.b();
                    if (b2 == null) {
                        HMSLog.e("BaseAdapter", "onResult baseCallBack null");
                        BaseAdapter.this.h();
                        return true;
                    }
                    long j = 0;
                    if (intent == null) {
                        HMSLog.e("BaseAdapter", "onSolutionResult but data is null");
                        String a2 = BaseAdapter.this.a(-7);
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseAdapter.a(baseAdapter.i, BaseAdapter.this.k, 0);
                        b2.onError(a2);
                        BaseAdapter.this.h();
                        return true;
                    } else if (intent.getIntExtra("kit_update_result", 0) == 1) {
                        HMSLog.e("BaseAdapter", "kit update success,replay request");
                        BaseAdapter.this.g();
                        return true;
                    } else {
                        HMSLog.e("BaseAdapter", "onComplete for on activity result");
                        String stringExtra = intent.getStringExtra("json_header");
                        String stringExtra2 = intent.getStringExtra("json_body");
                        Object infoFromJsonobject = JsonUtil.getInfoFromJsonobject(stringExtra, "status_code");
                        Object infoFromJsonobject2 = JsonUtil.getInfoFromJsonobject(stringExtra, "error_code");
                        if (intent.hasExtra("HMS_FOREGROUND_RES_UI")) {
                            Object infoFromJsonobject3 = JsonUtil.getInfoFromJsonobject(intent.getStringExtra("HMS_FOREGROUND_RES_UI"), "uiDuration");
                            if (infoFromJsonobject3 instanceof Long) {
                                j = ((Long) infoFromJsonobject3).longValue();
                            }
                        }
                        if (!(infoFromJsonobject instanceof Integer) || !(infoFromJsonobject2 instanceof Integer)) {
                            BaseAdapter.this.a(-8);
                            BaseAdapter baseAdapter2 = BaseAdapter.this;
                            baseAdapter2.a(baseAdapter2.i, BaseAdapter.this.k, j);
                        } else {
                            int intValue = ((Integer) infoFromJsonobject).intValue();
                            BaseAdapter.this.a(((Integer) infoFromJsonobject2).intValue());
                            BaseAdapter.this.k.setStatusCode(intValue);
                            BaseAdapter baseAdapter3 = BaseAdapter.this;
                            baseAdapter3.a(baseAdapter3.i, BaseAdapter.this.k, j);
                        }
                        b2.onComplete(stringExtra, stringExtra2, null);
                        return true;
                    }
                }
            }
        };
    }
}
