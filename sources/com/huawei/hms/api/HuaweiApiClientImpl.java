package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.core.aidl.c;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.HMSPublishStateHolder;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HuaweiApiClientImpl extends HuaweiApiClient implements ServiceConnection, InnerApiClient {
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private static final Object a = new Object();
    private static final Object b = new Object();
    private Handler A;
    private CheckUpdatelistener B;
    private CheckUpdateCallBack C;
    private int c = -1;
    private final Context d;
    private final String e;
    private String f;
    private String g;
    private volatile com.huawei.hms.core.aidl.d h;
    private String i;
    private WeakReference<Activity> j;
    private WeakReference<Activity> k;
    private boolean l = false;
    private AtomicInteger m = new AtomicInteger(1);
    private List<Scope> n;
    private List<PermissionInfo> o;
    private Map<Api<?>, Api.ApiOptions> p;
    private SubAppInfo q;
    private long r = 0;
    private int s = 0;
    private final Object t = new Object();
    private final ReentrantLock u;
    private final Condition v;
    private ConnectionResult w;
    private HuaweiApiClient.ConnectionCallbacks x;
    private HuaweiApiClient.OnConnectionFailedListener y;
    private Handler z;

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    private void a() {
        this.C = new CheckUpdateCallBack() {
            /* class com.huawei.hms.api.HuaweiApiClientImpl.AnonymousClass1 */

            @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
            public void onUpdateInfo(Intent intent) {
                if (intent != null && HuaweiApiClientImpl.this.B != null) {
                    try {
                        int intExtra = intent.getIntExtra("status", -99);
                        int intExtra2 = intent.getIntExtra("failcause", -99);
                        boolean booleanExtra = intent.getBooleanExtra("compulsoryUpdateCancel", false);
                        HMSLog.i("HuaweiApiClientImpl", "onUpdateInfo status: " + intExtra + ",failcause: " + intExtra2 + ",isExit: " + booleanExtra);
                        if (intExtra == 7) {
                            ApkUpgradeInfo apkUpgradeInfo = (ApkUpgradeInfo) intent.getSerializableExtra("updatesdk_update_info");
                            if (apkUpgradeInfo != null) {
                                HMSLog.i("HuaweiApiClientImpl", "onUpdateInfo: " + apkUpgradeInfo.toString());
                            }
                            HuaweiApiClientImpl.this.B.onResult(1);
                        } else if (intExtra == 3) {
                            HuaweiApiClientImpl.this.B.onResult(0);
                        } else {
                            HuaweiApiClientImpl.this.B.onResult(-1);
                        }
                        HuaweiApiClientImpl.this.B = null;
                    } catch (Exception e) {
                        HMSLog.e("HuaweiApiClientImpl", "intent has some error" + e.getMessage());
                        HuaweiApiClientImpl.this.B.onResult(-1);
                    }
                }
            }

            @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
            public void onMarketInstallInfo(Intent intent) {
                if (intent != null) {
                    int intExtra = intent.getIntExtra("downloadStatus", -99);
                    int intExtra2 = intent.getIntExtra("installState", -99);
                    int intExtra3 = intent.getIntExtra("installType", -99);
                    HMSLog.i("HuaweiApiClientImpl", "onMarketInstallInfo installState: " + intExtra2 + ",installType: " + intExtra3 + ",downloadCode: " + intExtra);
                }
            }

            @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
            public void onMarketStoreError(int i) {
                HMSLog.e("HuaweiApiClientImpl", "onMarketStoreError responseCode: " + i);
            }

            @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
            public void onUpdateStoreError(int i) {
                HMSLog.e("HuaweiApiClientImpl", "onUpdateStoreError responseCode: " + i);
            }
        };
    }

    public HuaweiApiClientImpl(Context context) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.u = reentrantLock;
        this.v = reentrantLock.newCondition();
        this.z = null;
        this.A = null;
        this.B = null;
        this.d = context;
        String appId = Util.getAppId(context);
        this.e = appId;
        this.f = appId;
        this.g = Util.getCpId(context);
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.d;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.d.getPackageName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.g;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public final SubAppInfo getSubAppInfo() {
        return this.q;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<Scope> getScopes() {
        return this.n;
    }

    public void setScopes(List<Scope> list) {
        this.n = list;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<PermissionInfo> getPermissionInfos() {
        return this.o;
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        this.o = list;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Map<Api<?>, Api.ApiOptions> getApiMap() {
        return this.p;
    }

    public void setApiMap(Map<Api<?>, Api.ApiOptions> map) {
        this.p = map;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public com.huawei.hms.core.aidl.d getService() {
        return this.h;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.i;
    }

    public void setHasShowNotice(boolean z2) {
        this.l = z2;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 50000301 ======");
        int i2 = this.m.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i2);
        if (i2 != 3 && i2 != 5 && i2 != 2 && i2 != 4) {
            if (activity != null) {
                this.j = new WeakReference<>(activity);
                this.k = new WeakReference<>(activity);
            }
            this.f = TextUtils.isEmpty(this.e) ? Util.getAppId(this.d) : this.e;
            int d2 = d();
            HMSLog.i("HuaweiApiClientImpl", "connect minVersion:" + d2);
            HuaweiApiAvailability.setServicesVersionCode(d2);
            int isHuaweiMobileServicesAvailable = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.d, d2);
            HMSLog.i("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + isHuaweiMobileServicesAvailable);
            this.s = HMSPackageManager.getInstance(this.d).getHmsVersionCode();
            if (isHuaweiMobileServicesAvailable == 0) {
                c(5);
                if (this.h == null) {
                    g();
                    return;
                }
                c(2);
                l();
                i();
            } else if (this.y == null) {
            } else {
                if (isHuaweiMobileServicesAvailable == 1 && HMSPublishStateHolder.getPublishState() == 0) {
                    a(isHuaweiMobileServicesAvailable);
                } else {
                    b(isHuaweiMobileServicesAvailable);
                }
            }
        }
    }

    private void a(final int i2) {
        Activity activity = this.j.get();
        if (!Util.isAvailableLibExist(activity.getApplicationContext())) {
            b(i2);
        }
        UpdateSdkAPI.checkTargetAppUpdate(activity, "com.huawei.hms", new CheckUpdateCallBack() {
            /* class com.huawei.hms.api.HuaweiApiClientImpl.AnonymousClass2 */

            @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
            public void onUpdateInfo(Intent intent) {
                if (intent != null) {
                    try {
                        int intExtra = intent.getIntExtra("status", -99);
                        HMSLog.i("HuaweiApiClientImpl", "CheckUpdateCallBack status is " + intExtra);
                        String stringExtra = intent.getStringExtra("failreason");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            HMSLog.e("HuaweiApiClientImpl", "checkTargetAppUpdate reason is " + stringExtra);
                        }
                        if (intExtra == 7) {
                            Serializable serializableExtra = intent.getSerializableExtra("updatesdk_update_info");
                            if ((serializableExtra instanceof ApkUpgradeInfo) && ((ApkUpgradeInfo) serializableExtra).getPackage_().equalsIgnoreCase("com.huawei.hms")) {
                                HMSLog.i("HuaweiApiClientImpl", "com.huawei.hms has already be published");
                                HMSPublishStateHolder.setPublishState(1);
                            }
                        }
                    } catch (Exception e) {
                        HMSLog.e("HuaweiApiClientImpl", "intent has some error" + e.getMessage());
                    }
                }
                if (HMSPublishStateHolder.getPublishState() != 1) {
                    HMSPublishStateHolder.setPublishState(2);
                }
                HuaweiApiClientImpl.this.b(i2);
            }

            @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
            public void onMarketInstallInfo(Intent intent) {
                if (HMSPublishStateHolder.getPublishState() != 1) {
                    HMSPublishStateHolder.setPublishState(2);
                }
                HuaweiApiClientImpl.this.b(i2);
            }

            @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
            public void onMarketStoreError(int i) {
                HMSLog.e("HuaweiApiClientImpl", "onMarketStoreError responseCode: " + i);
                if (HMSPublishStateHolder.getPublishState() != 1) {
                    HMSPublishStateHolder.setPublishState(2);
                }
                HuaweiApiClientImpl.this.b(i2);
            }

            @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
            public void onUpdateStoreError(int i) {
                HMSLog.e("HuaweiApiClientImpl", "onUpdateStoreError responseCode: " + i);
                if (HMSPublishStateHolder.getPublishState() != 1) {
                    HMSPublishStateHolder.setPublishState(2);
                }
                HuaweiApiClientImpl.this.b(i2);
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        PendingIntent pendingIntent;
        WeakReference<Activity> weakReference = this.j;
        if (weakReference == null || weakReference.get() == null) {
            pendingIntent = null;
        } else {
            pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.j.get(), i2);
            HMSLog.i("HuaweiApiClientImpl", "connect 2.0 fail: " + i2);
        }
        ConnectionResult connectionResult = new ConnectionResult(i2, pendingIntent);
        this.y.onConnectionFailed(connectionResult);
        this.w = connectionResult;
    }

    private void b() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
        ConnectService.forceConnect(this, m()).setResultCallback(new a());
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connectForeground() {
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 50000301 ======");
        int i2 = this.m.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter forceConnect, Connection Status: " + i2);
        if (i2 != 3 && i2 != 5 && i2 != 2 && i2 != 4) {
            this.f = TextUtils.isEmpty(this.e) ? Util.getAppId(this.d) : this.e;
            b();
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.y != null) {
            int i2 = Util.isBackground(this.d) ? 7 : 6;
            PendingIntent pendingIntent = null;
            WeakReference<Activity> weakReference = this.j;
            if (!(weakReference == null || weakReference.get() == null)) {
                pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.j.get(), i2);
            }
            ConnectionResult connectionResult = new ConnectionResult(i2, pendingIntent);
            this.y.onConnectionFailed(connectionResult);
            this.w = connectionResult;
        }
    }

    private int d() {
        int hmsVersion = Util.getHmsVersion(this.d);
        if (hmsVersion != 0 && hmsVersion >= 20503000) {
            return hmsVersion;
        }
        int e2 = e();
        if (f()) {
            if (e2 < 20503000) {
                return 20503000;
            }
            return e2;
        } else if (e2 < 20600000) {
            return 20600000;
        } else {
            return e2;
        }
    }

    private int e() {
        Integer num;
        int intValue;
        Map<Api<?>, Api.ApiOptions> apiMap = getApiMap();
        int i2 = 0;
        if (apiMap == null) {
            return 0;
        }
        for (Api<?> api : apiMap.keySet()) {
            String apiName = api.getApiName();
            if (!TextUtils.isEmpty(apiName) && (num = HuaweiApiAvailability.getApiMap().get(apiName)) != null && (intValue = num.intValue()) > i2) {
                i2 = intValue;
            }
        }
        return i2;
    }

    private boolean f() {
        Map<Api<?>, Api.ApiOptions> map = this.p;
        if (map == null) {
            return false;
        }
        for (Api<?> api : map.keySet()) {
            if ("HuaweiGame.API".equals(api.getApiName())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        this.m.set(i2);
        if (i2 == 1 || i2 == 3 || i2 == 2) {
            this.u.lock();
            try {
                this.v.signalAll();
            } finally {
                this.u.unlock();
            }
        }
    }

    private void g() {
        Intent intent = new Intent("com.huawei.hms.core.aidlservice");
        intent.setPackage(HMSPackageManager.getInstance(this.d).getHMSPackageName());
        synchronized (a) {
            if (this.d.bindService(intent, this, 1)) {
                h();
                return;
            }
            c(1);
            HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
            c();
        }
    }

    private void h() {
        Handler handler = this.z;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.z = new Handler(Looper.getMainLooper(), new Handler.Callback() {
                /* class com.huawei.hms.api.HuaweiApiClientImpl.AnonymousClass3 */

                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message == null || message.what != 2) {
                        return false;
                    }
                    HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service time out");
                    if (HuaweiApiClientImpl.this.m.get() == 5) {
                        HuaweiApiClientImpl.this.c(1);
                        HuaweiApiClientImpl.this.c();
                    }
                    return true;
                }
            });
        }
        this.z.sendEmptyMessageDelayed(2, 5000);
    }

    private void i() {
        synchronized (b) {
            Handler handler = this.A;
            if (handler != null) {
                handler.removeMessages(3);
            } else {
                this.A = new Handler(Looper.getMainLooper(), new Handler.Callback() {
                    /* class com.huawei.hms.api.HuaweiApiClientImpl.AnonymousClass4 */

                    @Override // android.os.Handler.Callback
                    public boolean handleMessage(Message message) {
                        if (message == null || message.what != 3) {
                            return false;
                        }
                        HMSLog.e("HuaweiApiClientImpl", "In connect, process time out");
                        if (HuaweiApiClientImpl.this.m.get() == 2) {
                            HuaweiApiClientImpl.this.c(1);
                        }
                        return true;
                    }
                });
            }
            boolean sendEmptyMessageDelayed = this.A.sendEmptyMessageDelayed(3, 3000);
            HMSLog.d("HuaweiApiClientImpl", "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : " + sendEmptyMessageDelayed);
        }
    }

    private void d(int i2) {
        if (i2 == 2) {
            synchronized (a) {
                Handler handler = this.z;
                if (handler != null) {
                    handler.removeMessages(i2);
                    this.z = null;
                }
            }
        }
        if (i2 == 3) {
            synchronized (b) {
                Handler handler2 = this.A;
                if (handler2 != null) {
                    handler2.removeMessages(i2);
                    this.A = null;
                }
            }
        }
        synchronized (a) {
            Handler handler3 = this.z;
            if (handler3 != null) {
                handler3.removeMessages(2);
                this.z = null;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disconnect() {
        int i2 = this.m.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i2);
        if (i2 == 2) {
            c(4);
        } else if (i2 == 3) {
            c(4);
            j();
        } else if (i2 == 5) {
            d(2);
            c(4);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient, com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        if (this.s == 0) {
            this.s = HMSPackageManager.getInstance(this.d).getHmsVersionCode();
        }
        if (this.s >= 20504000) {
            return innerIsConnected();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.r;
        if (currentTimeMillis > 0 && currentTimeMillis < 300000) {
            return innerIsConnected();
        }
        if (!innerIsConnected()) {
            return false;
        }
        Status status = ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(2000, TimeUnit.MILLISECONDS).getStatus();
        if (status.isSuccess()) {
            this.r = System.currentTimeMillis();
            return true;
        }
        int statusCode = status.getStatusCode();
        HMSLog.e("HuaweiApiClientImpl", "isConnected is false, statuscode:" + statusCode);
        if (statusCode == 907135004) {
            return false;
        }
        n();
        c(1);
        this.r = System.currentTimeMillis();
        return false;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean isConnecting() {
        int i2 = this.m.get();
        return i2 == 2 || i2 == 5;
    }

    @Override // com.huawei.hms.support.api.client.InnerApiClient
    public boolean innerIsConnected() {
        return this.m.get() == 3 || this.m.get() == 4;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.i("HuaweiApiClientImpl", "Enter setSubAppInfo");
        if (subAppInfo == null) {
            HMSLog.e("HuaweiApiClientImpl", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(TextUtils.isEmpty(this.e) ? Util.getAppId(this.d) : this.e)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is host appid");
            return false;
        }
        this.q = new SubAppInfo(subAppInfo);
        return true;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener) {
        if (Util.isAvailableLibExist(this.d)) {
            HMSLog.i("HuaweiApiClientImpl", "Enter checkUpdate");
            if (checkUpdatelistener == null) {
                HMSLog.e("HuaweiApiClientImpl", "listener is null!");
            } else if (activity == null || activity.isFinishing()) {
                HMSLog.e("HuaweiApiClientImpl", "checkUpdate, activity is illegal: " + activity);
                checkUpdatelistener.onResult(-1);
            } else {
                this.B = checkUpdatelistener;
                if (this.C == null) {
                    a();
                }
                UpdateSdkAPI.checkClientOTAUpdate(activity, this.C, true, 0, true);
            }
        } else {
            HMSLog.e("HuaweiApiClientImpl", "available lib does not exist.");
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onResume(Activity activity) {
        if (activity != null) {
            HMSLog.i("HuaweiApiClientImpl", "onResume");
            this.k = new WeakReference<>(activity);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onPause(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", "onPause");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Activity getTopActivity() {
        WeakReference<Activity> weakReference = this.k;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        this.x = connectionCallbacks;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.y = onConnectionFailedListener;
    }

    private void j() {
        ConnectService.disconnect(this, k()).setResultCallback(new b());
    }

    private DisconnectInfo k() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.p;
        if (map != null) {
            for (Api<?> api : map.keySet()) {
                arrayList.add(api.getApiName());
            }
        }
        return new DisconnectInfo(this.n, arrayList);
    }

    /* access modifiers changed from: private */
    public void a(ResolveResult<DisconnectResp> resolveResult) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + resolveResult.getStatus().getStatusCode());
        n();
        c(1);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onServiceConnected.");
        d(2);
        this.h = d.a.a(iBinder);
        if (this.h == null) {
            HMSLog.e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
            n();
            c(1);
            if (this.y != null) {
                PendingIntent pendingIntent = null;
                WeakReference<Activity> weakReference = this.j;
                if (!(weakReference == null || weakReference.get() == null)) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.j.get(), 10);
                }
                ConnectionResult connectionResult = new ConnectionResult(10, pendingIntent);
                this.y.onConnectionFailed(connectionResult);
                this.w = connectionResult;
            }
        } else if (this.m.get() == 5) {
            c(2);
            l();
            i();
        } else if (this.m.get() != 3) {
            n();
        }
    }

    private void l() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        ConnectService.connect(this, m()).setResultCallback(new a());
    }

    private ConnectInfo m() {
        String packageSignature = new PackageManagerHelper(this.d).getPackageSignature(this.d.getPackageName());
        if (packageSignature == null) {
            packageSignature = "";
        }
        SubAppInfo subAppInfo = this.q;
        return new ConnectInfo(getApiNameList(), this.n, packageSignature, subAppInfo == null ? null : subAppInfo.getSubAppID());
    }

    /* access modifiers changed from: private */
    public void b(ResolveResult<ConnectResp> resolveResult) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult");
        if (this.h == null || this.m.get() != 2) {
            HMSLog.e("HuaweiApiClientImpl", "Invalid onConnectionResult");
            return;
        }
        d(3);
        ConnectResp value = resolveResult.getValue();
        if (value != null) {
            this.i = value.sessionId;
        }
        SubAppInfo subAppInfo = this.q;
        PendingIntent pendingIntent = null;
        String subAppID = subAppInfo == null ? null : subAppInfo.getSubAppID();
        if (!TextUtils.isEmpty(subAppID)) {
            this.f = subAppID;
        }
        int statusCode = resolveResult.getStatus().getStatusCode();
        HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + statusCode);
        if (Status.SUCCESS.equals(resolveResult.getStatus())) {
            if (resolveResult.getValue() != null) {
                ProtocolNegotiate.getInstance().negotiate(resolveResult.getValue().protocolVersion);
            }
            c(3);
            this.w = null;
            HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.x;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnected();
            }
            if (this.j != null) {
                o();
            }
            for (Map.Entry<Api<?>, Api.ApiOptions> entry : getApiMap().entrySet()) {
                if (entry.getKey().getmConnetctPostList() != null && !entry.getKey().getmConnetctPostList().isEmpty()) {
                    HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
                    for (ConnectionPostProcessor connectionPostProcessor : entry.getKey().getmConnetctPostList()) {
                        HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
                        connectionPostProcessor.run(this, this.j);
                    }
                }
            }
        } else if (resolveResult.getStatus() == null || resolveResult.getStatus().getStatusCode() != 1001) {
            n();
            c(1);
            if (this.y != null) {
                WeakReference<Activity> weakReference = this.j;
                if (!(weakReference == null || weakReference.get() == null)) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.j.get(), statusCode);
                }
                ConnectionResult connectionResult = new ConnectionResult(statusCode, pendingIntent);
                this.y.onConnectionFailed(connectionResult);
                this.w = connectionResult;
            }
        } else {
            n();
            c(1);
            HuaweiApiClient.ConnectionCallbacks connectionCallbacks2 = this.x;
            if (connectionCallbacks2 != null) {
                connectionCallbacks2.onConnectionSuspended(3);
            }
        }
    }

    private void n() {
        Util.unBindServiceCatchException(this.d, this);
        this.h = null;
    }

    private void o() {
        if (this.l) {
            HMSLog.i("HuaweiApiClientImpl", "Connect notice has been shown.");
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.d) == 0) {
            ConnectService.getNotice(this, 0, "5.0.0.301").setResultCallback(new c());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.h = null;
        c(1);
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.x;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnectionSuspended(1);
        }
    }

    public int asyncRequest(Bundle bundle, String str, int i2, final ResultCallback<BundleResult> resultCallback) {
        HMSLog.i("HuaweiApiClientImpl", "Enter asyncRequest.");
        if (resultCallback == null || str == null || bundle == null) {
            HMSLog.e("HuaweiApiClientImpl", "arguments is invalid.");
            return 907135000;
        } else if (!innerIsConnected()) {
            HMSLog.e("HuaweiApiClientImpl", "client is unConnect.");
            return 907135003;
        } else {
            com.huawei.hms.core.aidl.b bVar = new com.huawei.hms.core.aidl.b(str, i2);
            e a2 = com.huawei.hms.core.aidl.a.a(bVar.c());
            bVar.a(bundle);
            RequestHeader requestHeader = new RequestHeader(getAppID(), getPackageName(), 50000301, getSessionId());
            requestHeader.setApiNameList(getApiNameList());
            bVar.b = a2.a(requestHeader, new Bundle());
            try {
                getService().a(bVar, new c.a() {
                    /* class com.huawei.hms.api.HuaweiApiClientImpl.AnonymousClass5 */

                    @Override // com.huawei.hms.core.aidl.c
                    public void call(com.huawei.hms.core.aidl.b bVar) {
                        if (bVar != null) {
                            e a2 = com.huawei.hms.core.aidl.a.a(bVar.c());
                            ResponseHeader responseHeader = new ResponseHeader();
                            a2.a(bVar.b, responseHeader);
                            BundleResult bundleResult = new BundleResult(responseHeader.getStatusCode(), bVar.a());
                            HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
                            resultCallback.onResult(bundleResult);
                            return;
                        }
                        HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
                        resultCallback.onResult(new BundleResult(-1, null));
                    }
                });
                return 0;
            } catch (RemoteException e2) {
                HMSLog.e("HuaweiApiClientImpl", "remote exception:" + e2.getMessage());
                return 907135001;
            }
        }
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.p;
        if (map != null) {
            for (Api<?> api : map.keySet()) {
                arrayList.add(api.getApiName());
            }
        }
        return arrayList;
    }

    private class b implements ResultCallback<ResolveResult<DisconnectResp>> {
        private b() {
        }

        /* renamed from: a */
        public void onResult(final ResolveResult<DisconnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.huawei.hms.api.HuaweiApiClientImpl.b.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    HuaweiApiClientImpl.this.a(resolveResult);
                }
            });
        }
    }

    private class a implements ResultCallback<ResolveResult<ConnectResp>> {
        private a() {
        }

        /* renamed from: a */
        public void onResult(final ResolveResult<ConnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.huawei.hms.api.HuaweiApiClientImpl.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    HuaweiApiClientImpl.this.b(resolveResult);
                }
            });
        }
    }

    private class c implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        private c() {
        }

        /* renamed from: a */
        public void onResult(ResolveResult<JosGetNoticeResp> resolveResult) {
            JosGetNoticeResp value;
            Intent noticeIntent;
            if (resolveResult != null && resolveResult.getStatus().isSuccess() && (noticeIntent = (value = resolveResult.getValue()).getNoticeIntent()) != null && value.getStatusCode() == 0) {
                HMSLog.i("HuaweiApiClientImpl", "get notice has intent.");
                Activity validActivity = Util.getValidActivity((Activity) HuaweiApiClientImpl.this.j.get(), HuaweiApiClientImpl.this.getTopActivity());
                if (validActivity == null) {
                    HMSLog.e("HuaweiApiClientImpl", "showNotice no valid activity!");
                    return;
                }
                HuaweiApiClientImpl.this.l = true;
                validActivity.startActivity(noticeIntent);
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.t) {
            if (this.x == connectionCallbacks) {
                return true;
            }
            return false;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.t) {
            if (this.y == onConnectionFailedListener) {
                return true;
            }
            return false;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.t) {
            if (this.x != connectionCallbacks) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
            } else {
                this.x = null;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.t) {
            if (this.y != onConnectionFailedListener) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
            } else {
                this.y = null;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect() {
        ConnectionResult connectionResult;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.u.lock();
            try {
                connect((Activity) null);
                while (isConnecting()) {
                    try {
                        this.v.await();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        connectionResult = new ConnectionResult(15, (PendingIntent) null);
                    }
                }
                if (isConnected()) {
                    this.w = null;
                    connectionResult = new ConnectionResult(0, (PendingIntent) null);
                } else {
                    connectionResult = this.w;
                    if (connectionResult == null) {
                        connectionResult = new ConnectionResult(13, (PendingIntent) null);
                    }
                }
                return connectionResult;
            } finally {
                this.u.unlock();
            }
        } else {
            throw new IllegalStateException("blockingConnect must not be called on the UI thread");
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect(long j2, TimeUnit timeUnit) {
        ConnectionResult connectionResult;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.u.lock();
            try {
                connect((Activity) null);
                long nanos = timeUnit.toNanos(j2);
                while (true) {
                    if (isConnecting()) {
                        if (nanos <= 0) {
                            disconnect();
                            connectionResult = new ConnectionResult(14, (PendingIntent) null);
                            break;
                        }
                        try {
                            nanos = this.v.awaitNanos(nanos);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            connectionResult = new ConnectionResult(15, (PendingIntent) null);
                        }
                    } else if (isConnected()) {
                        this.w = null;
                        connectionResult = new ConnectionResult(0, (PendingIntent) null);
                    } else {
                        connectionResult = this.w;
                        if (connectionResult == null) {
                            connectionResult = new ConnectionResult(13, (PendingIntent) null);
                        }
                    }
                }
                return connectionResult;
            } finally {
                this.u.unlock();
            }
        } else {
            throw new IllegalStateException("blockingConnect must not be called on the UI thread");
        }
    }

    static class d extends PendingResultImpl<Status, IMessageEntity> {
        public d(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        /* renamed from: a */
        public Status onComplete(IMessageEntity iMessageEntity) {
            return new Status(0);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public PendingResult<Status> discardAndReconnect() {
        return new d(this, null, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        if (isConnected()) {
            this.w = null;
            return new ConnectionResult(0, (PendingIntent) null);
        }
        ConnectionResult connectionResult = this.w;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void reconnect() {
        disconnect();
        connect((Activity) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectedApi(Api<?> api) {
        return isConnected();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(int i2) {
        connect((Activity) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disableLifeCycleManagement(Activity activity) {
        if (this.c >= 0) {
            AutoLifecycleFragment instance = AutoLifecycleFragment.getInstance(activity);
            if (instance != null) {
                instance.stopAutoManage(this.c);
                return;
            }
            return;
        }
        throw new IllegalStateException("disableLifeCycleManagement failed");
    }

    protected void setAutoLifecycleClientId(int i2) {
        this.c = i2;
    }
}
