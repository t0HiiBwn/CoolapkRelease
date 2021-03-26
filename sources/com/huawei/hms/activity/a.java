package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: ForegroundBusDelegate */
public class a implements IBridgeActivityDelegate {
    private RequestHeader a;
    private String b;
    private ForegroundInnerHeader c = new ForegroundInnerHeader();
    private ResponseHeader d;
    private WeakReference<Activity> e;

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 431057;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        this.e = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        String stringExtra = intent.getStringExtra("HMS_FOREGROUND_REQ_HEADER");
        RequestHeader requestHeader = new RequestHeader();
        this.a = requestHeader;
        if (!requestHeader.fromJson(stringExtra)) {
            a(0, "header is invalid");
            return;
        }
        this.b = intent.getStringExtra("HMS_FOREGROUND_REQ_BODY");
        this.c.fromJson(intent.getStringExtra("HMS_FOREGROUND_REQ_INNER"));
        if (this.c == null) {
            a(0, "inner header is invalid");
        } else if (TextUtils.isEmpty(this.a.getApiName())) {
            a(0, "action is invalid");
        } else {
            e();
            c();
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        g();
        this.e = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != 431057) {
            return false;
        }
        if (intent != null && intent.hasExtra("HMS_FOREGROUND_RESP_HEADER")) {
            String stringExtra = intent.getStringExtra("HMS_FOREGROUND_RESP_HEADER");
            ResponseHeader responseHeader = new ResponseHeader();
            this.d = responseHeader;
            JsonUtil.jsonToEntity(stringExtra, responseHeader);
        }
        h();
        BusResponseCallback a2 = a(this.c.getResponseCallbackKey());
        if (a2 == null) {
            a(i2, intent);
            return true;
        }
        BusResponseResult succeedReturn = a2.succeedReturn(this.e.get(), i2, intent);
        if (succeedReturn == null) {
            a(i2, intent);
            return true;
        }
        a(succeedReturn.getCode(), succeedReturn.getIntent());
        return true;
    }

    private BusResponseCallback a(String str) {
        return ForegroundBusResponseMgr.getInstance().get(str);
    }

    private void a(int i, Intent intent) {
        HMSLog.i("ForegroundBusDelegate", "succeedReturn");
        Activity b2 = b();
        if (b2 != null) {
            b2.setResult(i, intent);
            a();
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, String str) {
        HMSLog.e("ForegroundBusDelegate", str);
        Activity b2 = b();
        if (b2 != null) {
            BusResponseCallback a2 = a(this.c.getResponseCallbackKey());
            if (a2 != null) {
                BusResponseResult innerError = a2.innerError(this.e.get(), i, str);
                if (innerError == null) {
                    b2.setResult(0);
                } else {
                    b2.setResult(innerError.getCode(), innerError.getIntent());
                }
            } else {
                b2.setResult(0);
            }
            a();
        }
    }

    private void a() {
        Activity b2 = b();
        if (b2 != null && !b2.isFinishing()) {
            b2.finish();
        }
    }

    private Activity b() {
        WeakReference<Activity> weakReference = this.e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void c() {
        if (b() == null) {
            HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, activity must not be null.");
        } else if (Util.isAvailableLibExist(b().getApplicationContext())) {
            C0072a aVar = new C0072a();
            AvailableAdapter availableAdapter = new AvailableAdapter(this.c.getApkVersion());
            int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(b());
            if (isHuaweiMobileServicesAvailable == 0) {
                aVar.onComplete(isHuaweiMobileServicesAvailable);
            } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                a(b(), availableAdapter, aVar);
            } else {
                aVar.onComplete(isHuaweiMobileServicesAvailable);
            }
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(b().getApplicationContext(), this.c.getApkVersion()) != 0) {
            HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, and no available lib exists.");
        } else {
            d();
        }
    }

    /* renamed from: com.huawei.hms.activity.a$a  reason: collision with other inner class name */
    /* compiled from: ForegroundBusDelegate */
    private class C0072a implements AvailableAdapter.AvailableCallBack {
        private C0072a() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i) {
            if (i == 0) {
                a.this.d();
                return;
            }
            HMSLog.i("ForegroundBusDelegate", "version check failed");
            a.this.a(0, "apk version is invalid");
        }
    }

    private static void a(Activity activity, AvailableAdapter availableAdapter, AvailableAdapter.AvailableCallBack availableCallBack) {
        if (activity == null) {
            HMSLog.i("ForegroundBusDelegate", "null activity, could not start resolution intent");
        }
        availableAdapter.startResolution(activity, availableCallBack);
    }

    /* access modifiers changed from: private */
    public void d() {
        HMSLog.i("ForegroundBusDelegate", "startApkHubActivity");
        Activity b2 = b();
        if (b2 == null) {
            HMSLog.e("ForegroundBusDelegate", "startApkHubActivity but activity is null");
            return;
        }
        String hMSPackageName = HMSPackageManager.getInstance(b2.getApplicationContext()).getHMSPackageName();
        Intent intent = new Intent(this.c.getAction());
        intent.putExtra("HMS_FOREGROUND_REQ_BODY", this.b);
        intent.setPackage(hMSPackageName);
        intent.setClassName(hMSPackageName, "com.huawei.hms.core.activity.UiJumpActivity");
        intent.putExtra("HMS_FOREGROUND_REQ_HEADER", this.a.toJson());
        intent.putExtra("intent.extra.hms.core.DELEGATE_NAME", "com.huawei.hms.core.activity.ForegroundBus");
        try {
            f();
            b2.startActivityForResult(intent, 431057);
        } catch (ActivityNotFoundException e2) {
            HMSLog.e("ForegroundBusDelegate", "Launch sign in Intent failed. hms is probably being updated：", e2);
            a(0, "launch bus intent failed");
        }
    }

    private void e() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.a);
        mapFromForegroundRequestHeader.put("direction", "req");
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.a.getKitSdkVersion())));
        if (b() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(b().getApplicationContext(), "HMS_SDK_BASE_ACTIVITY_STARTED", mapFromForegroundRequestHeader);
        }
    }

    private void f() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.a);
        mapFromForegroundRequestHeader.put("direction", "req");
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.a.getKitSdkVersion())));
        if (b() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(b().getApplicationContext(), "HMS_SDK_BASE_START_CORE_ACTIVITY", mapFromForegroundRequestHeader);
        }
    }

    private void g() {
        if (this.a != null) {
            Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.a);
            mapFromForegroundRequestHeader.put("direction", "rsp");
            mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.a.getKitSdkVersion())));
            ResponseHeader responseHeader = this.d;
            if (responseHeader != null) {
                mapFromForegroundRequestHeader.put("statusCode", String.valueOf(responseHeader.getStatusCode()));
                mapFromForegroundRequestHeader.put("result", String.valueOf(this.d.getErrorCode()));
            }
            if (b() != null) {
                HiAnalyticsUtil.getInstance().onNewEvent(b().getApplicationContext(), "HMS_SDK_BASE_ACTIVITY_STARTED", mapFromForegroundRequestHeader);
            }
        }
    }

    private void h() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.a);
        mapFromForegroundRequestHeader.put("direction", "rsp");
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.a.getKitSdkVersion())));
        ResponseHeader responseHeader = this.d;
        if (responseHeader != null) {
            mapFromForegroundRequestHeader.put("statusCode", String.valueOf(responseHeader.getStatusCode()));
            mapFromForegroundRequestHeader.put("result", String.valueOf(this.d.getErrorCode()));
        }
        if (b() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(b().getApplicationContext(), "HMS_SDK_BASE_START_CORE_ACTIVITY", mapFromForegroundRequestHeader);
        }
    }
}
