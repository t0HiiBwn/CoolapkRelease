package com.huawei.hms.common.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.hianalytics.b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HuaweiApiManager implements Handler.Callback {
    private static final Object a = new Object();
    private static HuaweiApiManager b;
    private final Handler c;
    private final AtomicInteger d = new AtomicInteger(0);
    private final Map<ConnectionManagerKey<?>, ConnectionManager<?>> e = new ConcurrentHashMap(5, 0.75f, 1);

    private HuaweiApiManager(Context context, Looper looper, HuaweiApiAvailability huaweiApiAvailability) {
        this.c = new Handler(looper, this);
    }

    public static HuaweiApiManager getInstance(Context context) {
        synchronized (a) {
            if (b == null) {
                HandlerThread handlerThread = new HandlerThread("HuaweiApiManager");
                handlerThread.start();
                b = new HuaweiApiManager(context.getApplicationContext(), handlerThread.getLooper(), HuaweiApiAvailability.getInstance());
            }
        }
        return b;
    }

    public final <TOption extends Api.ApiOptions, TResult> void sendRequest(HuaweiApi<TOption> huaweiApi, TaskApiCall<? extends AnyClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource) {
        TaskApiCallWrapper taskApiCallWrapper = new TaskApiCallWrapper(taskApiCall, taskCompletionSource);
        Handler handler = this.c;
        handler.sendMessage(handler.obtainMessage(4, new b(taskApiCallWrapper, this.d.getAndIncrement(), huaweiApi)));
    }

    /* access modifiers changed from: private */
    public void a(HuaweiApi<?> huaweiApi, TaskCompletionSource<Boolean> taskCompletionSource) {
        ConnectionManager<?> connectionManager = this.e.get(huaweiApi.getConnectionManagerKey());
        if (connectionManager == null) {
            taskCompletionSource.setResult(false);
        } else {
            taskCompletionSource.setResult(Boolean.valueOf(connectionManager.a()));
        }
    }

    public void disconnectService(final HuaweiApi<?> huaweiApi, final TaskCompletionSource<Boolean> taskCompletionSource) {
        if (Looper.myLooper() == this.c.getLooper()) {
            a(huaweiApi, taskCompletionSource);
        } else {
            this.c.post(new Runnable() {
                /* class com.huawei.hms.common.internal.HuaweiApiManager.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    HuaweiApiManager.this.a(huaweiApi, taskCompletionSource);
                }
            });
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 4) {
            HMSLog.w("HuaweiApiManager", "Unknown message id: " + message.what);
            return false;
        }
        a((b) message.obj);
        return true;
    }

    private void a(b bVar) {
        HuaweiApi<?> huaweiApi = bVar.b;
        ConnectionManager<?> connectionManager = this.e.get(huaweiApi.getConnectionManagerKey());
        if (connectionManager == null) {
            connectionManager = new ConnectionManager<>(huaweiApi);
            this.e.put(huaweiApi.getConnectionManagerKey(), connectionManager);
        }
        connectionManager.a((TaskApiCallWrapper) bVar.a);
    }

    private static class a {
        private final TaskApiCallWrapper a;
        private final AnyClient.CallBack b;

        a(TaskApiCallWrapper taskApiCallWrapper, AnyClient.CallBack callBack) {
            this.a = taskApiCallWrapper;
            this.b = callBack;
        }

        TaskApiCallWrapper a() {
            return this.a;
        }

        AnyClient.CallBack b() {
            return this.b;
        }
    }

    public class ConnectionManager<OptionsT extends Api.ApiOptions> implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener {
        private final Queue<a> b = new LinkedList();
        private final AnyClient c;
        private ConnectionResult d;
        private final ConnectionManagerKey e;
        private final HuaweiApi<OptionsT> f;

        ConnectionManager(HuaweiApi<OptionsT> huaweiApi) {
            this.f = huaweiApi;
            this.c = huaweiApi.getClient(HuaweiApiManager.this.c.getLooper(), this);
            this.d = null;
            this.e = huaweiApi.getConnectionManagerKey();
        }

        void a(TaskApiCallWrapper taskApiCallWrapper) {
            HMSLog.i("HuaweiApiManager", "sendRequest");
            Checker.assertHandlerThread(HuaweiApiManager.this.c);
            a b2 = b(taskApiCallWrapper);
            int minApkVersion = taskApiCallWrapper.getTaskApiCall().getMinApkVersion();
            if (!this.c.isConnected()) {
                this.b.add(b2);
                ConnectionResult connectionResult = this.d;
                if (connectionResult == null || connectionResult.getErrorCode() == 0) {
                    a(minApkVersion);
                } else {
                    onConnectionFailed(this.d);
                }
            } else if (HMSPackageManager.getInstance(this.f.getContext()).hmsVerHigherThan(minApkVersion)) {
                a(b2);
            } else {
                a();
                this.b.add(b2);
                a(minApkVersion);
            }
        }

        private String a(String str, String str2) {
            return TextUtils.isEmpty(str) ? TransactionIdCreater.getId(this.f.getAppID(), str2) : str;
        }

        private void a(a aVar) {
            int i;
            String uri = aVar.a().getTaskApiCall().getUri();
            RequestHeader requestHeader = new RequestHeader();
            requestHeader.setSrvName(uri.split("\\.")[0]);
            requestHeader.setApiName(uri);
            requestHeader.setAppID(this.f.getAppID() + "|" + this.f.getSubAppID());
            requestHeader.setPkgName(this.f.getContext().getPackageName());
            requestHeader.setSessionId(this.c.getSessionId());
            TaskApiCall taskApiCall = aVar.a().getTaskApiCall();
            requestHeader.setTransactionId(a(taskApiCall.getTransactionId(), uri));
            requestHeader.setParcelable(taskApiCall.getParcelable());
            requestHeader.setKitSdkVersion(this.f.getKitSdkVersion());
            if (this.f.getApiLevel() > taskApiCall.getApiLevel()) {
                i = this.f.getApiLevel();
            } else {
                i = taskApiCall.getApiLevel();
            }
            requestHeader.setApiLevel(i);
            this.c.post(requestHeader, taskApiCall.getRequestJson(), aVar.b());
        }

        private a b(final TaskApiCallWrapper taskApiCallWrapper) {
            return new a(taskApiCallWrapper, new AnyClient.CallBack() {
                /* class com.huawei.hms.common.internal.HuaweiApiManager.ConnectionManager.AnonymousClass1 */

                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    if (!(iMessageEntity instanceof ResponseHeader)) {
                        HMSLog.e("HuaweiApiManager", "header is not instance of ResponseHeader");
                        return;
                    }
                    ResponseHeader responseHeader = (ResponseHeader) iMessageEntity;
                    if (!TextUtils.isEmpty(responseHeader.getResolution())) {
                        HMSLog.e("HuaweiApiManager", "Response has resolution: " + responseHeader.getResolution());
                    }
                    b.a(ConnectionManager.this.f.getContext(), responseHeader, String.valueOf(ConnectionManager.this.f.getKitSdkVersion()));
                    taskApiCallWrapper.getTaskApiCall().onResponse(ConnectionManager.this.c, responseHeader, str, taskApiCallWrapper.getTaskCompletionSource());
                }
            });
        }

        boolean a() {
            Checker.assertHandlerThread(HuaweiApiManager.this.c);
            this.c.disconnect();
            return true;
        }

        synchronized void a(int i) {
            Checker.assertHandlerThread(HuaweiApiManager.this.c);
            if (this.c.isConnected()) {
                HMSLog.d("HuaweiApiManager", "client is connected");
            } else if (this.c.isConnecting()) {
                HMSLog.d("HuaweiApiManager", "client is isConnecting");
            } else {
                this.c.connect(i);
            }
        }

        /* access modifiers changed from: private */
        public void a(ConnectionResult connectionResult) {
            Checker.assertHandlerThread(HuaweiApiManager.this.c);
            this.d = connectionResult;
            boolean z = true;
            for (a aVar : this.b) {
                TaskApiCallWrapper a2 = aVar.a();
                ResponseHeader responseHeader = new ResponseHeader(1, 907135003, "Connection Failed:" + b(connectionResult) + "(" + connectionResult.getErrorCode() + ")");
                responseHeader.setTransactionId(a2.getTaskApiCall().getTransactionId());
                b.a(this.f.getContext(), responseHeader, String.valueOf(this.f.getKitSdkVersion()));
                if (this.d.getResolution() != null && z) {
                    responseHeader.setParcelable(this.d.getResolution());
                    z = false;
                }
                a2.getTaskApiCall().onResponse(this.c, responseHeader, null, a2.getTaskCompletionSource());
            }
            this.b.clear();
            this.d = null;
            this.c.disconnect();
            HuaweiApiManager.this.e.remove(this.e);
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(final ConnectionResult connectionResult) {
            HMSLog.i("HuaweiApiManager", "onConnectionFailed");
            if (Looper.myLooper() == HuaweiApiManager.this.c.getLooper()) {
                a(connectionResult);
            } else {
                HuaweiApiManager.this.c.post(new Runnable() {
                    /* class com.huawei.hms.common.internal.HuaweiApiManager.ConnectionManager.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectionManager.this.a(connectionResult);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public void b() {
            Checker.assertHandlerThread(HuaweiApiManager.this.c);
            this.d = null;
            for (a aVar : this.b) {
                a(aVar);
            }
            this.b.clear();
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            HMSLog.d("HuaweiApiManager", "onConnected");
            if (Looper.myLooper() == HuaweiApiManager.this.c.getLooper()) {
                b();
            } else {
                HuaweiApiManager.this.c.post(new Runnable() {
                    /* class com.huawei.hms.common.internal.HuaweiApiManager.ConnectionManager.AnonymousClass3 */

                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectionManager.this.b();
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public void b(int i) {
            Checker.assertHandlerThread(HuaweiApiManager.this.c);
            for (a aVar : this.b) {
                TaskApiCallWrapper a2 = aVar.a();
                ResponseHeader responseHeader = new ResponseHeader(1, 907135003, "Connection Suspended");
                responseHeader.setTransactionId(a2.getTaskApiCall().getTransactionId());
                a2.getTaskApiCall().onResponse(this.c, responseHeader, null, a2.getTaskCompletionSource());
            }
            this.b.clear();
            this.d = null;
            this.c.disconnect();
            HuaweiApiManager.this.e.remove(this.e);
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(final int i) {
            HMSLog.i("HuaweiApiManager", "onConnectionSuspended");
            if (Looper.myLooper() == HuaweiApiManager.this.c.getLooper()) {
                b(i);
            } else {
                HuaweiApiManager.this.c.post(new Runnable() {
                    /* class com.huawei.hms.common.internal.HuaweiApiManager.ConnectionManager.AnonymousClass4 */

                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectionManager.this.b(i);
                    }
                });
            }
        }

        private String b(ConnectionResult connectionResult) {
            if (Util.isAvailableLibExist(this.f.getContext())) {
                int errorCode = connectionResult.getErrorCode();
                if (errorCode != -1) {
                    if (errorCode == 3) {
                        return "HuaWei Mobile Service is disabled";
                    }
                    if (errorCode != 8) {
                        if (errorCode != 10) {
                            if (errorCode == 13) {
                                return "update cancelled";
                            }
                            if (errorCode == 21) {
                                return "device is too old to be support";
                            }
                            switch (errorCode) {
                                case 25:
                                    return "failed to get update result";
                                case 26:
                                    return "update failed, because no activity incoming, can't pop update page";
                                case 27:
                                    return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
                                default:
                                    return "unknown errorReason";
                            }
                        }
                    }
                    return "internal error";
                }
                return "get update result, but has other error codes";
            }
            int errorCode2 = connectionResult.getErrorCode();
            if (errorCode2 != -1) {
                if (errorCode2 != 8) {
                    if (errorCode2 != 10) {
                        return "unknown errorReason";
                    }
                }
                return "internal error";
            }
            return "get update result, but has other error codes";
            return "application configuration error, please developer check configuration";
        }
    }
}
