package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseHmsClient implements AidlApiClient {
    private static final Object a = new Object();
    private int b = 0;
    private final Context c;
    private String d;
    private final ClientSettings e;
    private volatile d f;
    private final AtomicInteger g = new AtomicInteger(1);
    private final ConnectionCallbacks h;
    private final OnConnectionFailedListener i;
    private Handler j = null;
    private BinderAdapter k;
    protected String sessionId;

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public String getServiceAction() {
        return "com.huawei.hms.core.aidlservice";
    }

    public BaseHmsClient(Context context, ClientSettings clientSettings, OnConnectionFailedListener onConnectionFailedListener, ConnectionCallbacks connectionCallbacks) {
        this.c = context;
        this.e = clientSettings;
        this.d = clientSettings.getAppID();
        this.i = onConnectionFailedListener;
        this.h = connectionCallbacks;
    }

    public void onConnecting() {
        connectionConnected();
    }

    protected final void connectionConnected() {
        a(3);
        ConnectionCallbacks connectionCallbacks = this.h;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnected();
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        HMSLog.i("BaseHmsClient", "enter bindCoreService");
        BinderAdapter binderAdapter = new BinderAdapter(this.c, getServiceAction(), HMSPackageManager.getInstance(this.c).getHMSPackageName());
        this.k = binderAdapter;
        binderAdapter.binder(new BinderAdapter.BinderCallBack() {
            /* class com.huawei.hms.common.internal.BaseHmsClient.AnonymousClass1 */

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HMSLog.i("BaseHmsClient", "Enter onServiceConnected.");
                BaseHmsClient.this.f = d.a.a(iBinder);
                if (BaseHmsClient.this.f == null) {
                    HMSLog.e("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
                    BaseHmsClient.this.k.unBind();
                    BaseHmsClient.this.a(1);
                    BaseHmsClient.this.b(10);
                    return;
                }
                BaseHmsClient.this.onConnecting();
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i) {
                onBinderFailed(i, null);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i, PendingIntent pendingIntent) {
                BaseHmsClient.this.a(new ConnectionResult(10, pendingIntent));
                BaseHmsClient.this.f = null;
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceDisconnected(ComponentName componentName) {
                HMSLog.i("BaseHmsClient", "Enter onServiceDisconnected.");
                BaseHmsClient.this.a(1);
                if (BaseHmsClient.this.h != null) {
                    BaseHmsClient.this.h.onConnectionSuspended(1);
                }
            }
        });
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.d;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        return this.g.get() == 3 || this.g.get() == 4;
    }

    public boolean isConnecting() {
        return this.g.get() == 5;
    }

    public void disconnect() {
        int i2 = this.g.get();
        HMSLog.i("BaseHmsClient", "Enter disconnect, Connection Status: " + i2);
        if (i2 == 3) {
            BinderAdapter binderAdapter = this.k;
            if (binderAdapter != null) {
                binderAdapter.unBind();
            }
            a(1);
        } else if (i2 == 5) {
            b();
            a(4);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        this.g.set(i2);
    }

    private void b() {
        synchronized (a) {
            Handler handler = this.j;
            if (handler != null) {
                handler.removeMessages(2);
                this.j = null;
            }
        }
    }

    public void checkAvailabilityAndConnect(int i2) {
        HMSLog.i("BaseHmsClient", "====== HMSSDK version: 50000301 ======");
        int i3 = this.g.get();
        HMSLog.i("BaseHmsClient", "Enter connect, Connection Status: " + i3);
        if (i3 != 3 && i3 != 5 && i3 != 4) {
            a(5);
            if (getMinApkVersion() > i2) {
                i2 = getMinApkVersion();
            }
            HMSLog.i("BaseHmsClient", "connect minVersion:" + i2);
            if (Util.isAvailableLibExist(this.c)) {
                AvailableAdapter availableAdapter = new AvailableAdapter(i2);
                int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(this.c);
                HMSLog.i("BaseHmsClient", "check available result: " + isHuaweiMobileServicesAvailable);
                if (isHuaweiMobileServicesAvailable == 0) {
                    a();
                } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
                    a(availableAdapter);
                } else {
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail: " + isHuaweiMobileServicesAvailable + " is not resolvable.");
                    b(isHuaweiMobileServicesAvailable);
                }
            } else {
                int isHuaweiMobileServicesAvailable2 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.c, i2);
                HMSLog.i("BaseHmsClient", "HuaweiApiAvailability check available result: " + isHuaweiMobileServicesAvailable2);
                if (isHuaweiMobileServicesAvailable2 == 0) {
                    a();
                } else {
                    b(isHuaweiMobileServicesAvailable2);
                }
            }
        }
    }

    private void a(AvailableAdapter availableAdapter) {
        HMSLog.i("BaseHmsClient", "enter HmsCore resolution");
        if (!getClientSettings().isHasActivity()) {
            b(26);
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startResolution(activeActivity, new AvailableAdapter.AvailableCallBack() {
                /* class com.huawei.hms.common.internal.BaseHmsClient.AnonymousClass2 */

                @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                public void onComplete(int i) {
                    if (i == 0) {
                        BaseHmsClient.this.a();
                    } else {
                        BaseHmsClient.this.b(i);
                    }
                }
            });
        } else {
            b(26);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + i2);
        OnConnectionFailedListener onConnectionFailedListener = this.i;
        if (onConnectionFailedListener != null) {
            onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i2));
        }
    }

    /* access modifiers changed from: private */
    public void a(ConnectionResult connectionResult) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + connectionResult.getErrorCode());
        OnConnectionFailedListener onConnectionFailedListener = this.i;
        if (onConnectionFailedListener != null) {
            onConnectionFailedListener.onConnectionFailed(connectionResult);
        }
    }

    public void connect(int i2) {
        checkAvailabilityAndConnect(i2);
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public d getService() {
        return this.f;
    }

    protected final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.c;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public SubAppInfo getSubAppInfo() {
        return this.e.getSubAppID();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.e.getClientPackageName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.e.getCpID();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        return this.e.getApiName();
    }

    protected ClientSettings getClientSettings() {
        return this.e;
    }
}
