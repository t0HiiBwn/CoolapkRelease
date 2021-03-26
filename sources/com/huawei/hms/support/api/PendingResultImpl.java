package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PendingResultImpl<R extends Result, T extends IMessageEntity> extends InnerPendingResult<R> {
    private CountDownLatch a;
    private R b = null;
    private WeakReference<ApiClient> c;
    private String d = null;
    private String e = null;
    private boolean f = true;
    protected DatagramTransport transport = null;

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void cancel() {
    }

    protected boolean checkApiClient(ApiClient apiClient) {
        return true;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    public abstract R onComplete(T t);

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        a(apiClient, str, iMessageEntity, getResponseType(), 0);
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        a(apiClient, str, iMessageEntity, cls, 0);
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, int i) {
        a(apiClient, str, iMessageEntity, getResponseType(), i);
    }

    private void a(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls, int i) {
        HMSLog.i("PendingResultImpl", "init uri:" + str);
        this.d = str;
        if (apiClient == null) {
            HMSLog.e("PendingResultImpl", "client is null");
            return;
        }
        this.c = new WeakReference<>(apiClient);
        this.a = new CountDownLatch(1);
        try {
            this.transport = (DatagramTransport) Class.forName(apiClient.getTransportName()).getConstructor(String.class, IMessageEntity.class, Class.class, Integer.TYPE).newInstance(str, iMessageEntity, cls, Integer.valueOf(i));
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            HMSLog.e("PendingResultImpl", "gen transport error:" + e2.getMessage());
            throw new IllegalStateException("Instancing transport exception, " + e2.getMessage(), e2);
        }
    }

    protected Class<T> getResponseType() {
        Type type;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1]) == null) {
            return null;
        }
        return (Class) type;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        HMSLog.i("PendingResultImpl", "await");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread();
        }
        HMSLog.e("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread() {
        HMSLog.i("PendingResultImpl", "awaitOnAnyThread");
        WeakReference<ApiClient> weakReference = this.c;
        if (weakReference == null) {
            HMSLog.e("PendingResultImpl", "api is null");
            a(907135003, (IMessageEntity) null);
            return this.b;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e("PendingResultImpl", "client invalid");
            a(907135003, (IMessageEntity) null);
            return this.b;
        }
        if (this.f) {
            a(0, 1);
        }
        this.transport.send(apiClient, new DatagramTransport.a() {
            /* class com.huawei.hms.support.api.PendingResultImpl.AnonymousClass1 */

            @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
            public void a(int i, IMessageEntity iMessageEntity) {
                PendingResultImpl.this.a(i, iMessageEntity);
                PendingResultImpl.this.a.countDown();
            }
        });
        try {
            this.a.await();
        } catch (InterruptedException unused) {
            HMSLog.e("PendingResultImpl", "await in anythread InterruptedException");
            a(907135001, (IMessageEntity) null);
        }
        return this.b;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j, TimeUnit timeUnit) {
        HMSLog.i("PendingResultImpl", "await timeout:" + j + " unit:" + timeUnit.toString());
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread(j, timeUnit);
        }
        HMSLog.i("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread(long j, TimeUnit timeUnit) {
        HMSLog.i("PendingResultImpl", "awaitOnAnyThread timeout:" + j + " unit:" + timeUnit.toString());
        WeakReference<ApiClient> weakReference = this.c;
        if (weakReference == null) {
            HMSLog.e("PendingResultImpl", "api is null");
            a(907135003, (IMessageEntity) null);
            return this.b;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e("PendingResultImpl", "client invalid");
            a(907135003, (IMessageEntity) null);
            return this.b;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        if (this.f) {
            a(0, 1);
        }
        this.transport.post(apiClient, new DatagramTransport.a() {
            /* class com.huawei.hms.support.api.PendingResultImpl.AnonymousClass2 */

            @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
            public void a(int i, IMessageEntity iMessageEntity) {
                if (!atomicBoolean.get()) {
                    PendingResultImpl.this.a(i, iMessageEntity);
                }
                PendingResultImpl.this.a.countDown();
            }
        });
        try {
            if (!this.a.await(j, timeUnit)) {
                atomicBoolean.set(true);
                a(907135004, (IMessageEntity) null);
            }
        } catch (InterruptedException unused) {
            HMSLog.e("PendingResultImpl", "awaitOnAnyThread InterruptedException");
            a(907135001, (IMessageEntity) null);
        }
        return this.b;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> resultCallback) {
        this.f = !(resultCallback instanceof BaseAdapter.BaseRequestResultCallback);
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(Looper looper, final ResultCallback<R> resultCallback) {
        HMSLog.i("PendingResultImpl", "setResultCallback");
        if (looper == null) {
            looper = Looper.myLooper();
        }
        final a aVar = new a(looper);
        WeakReference<ApiClient> weakReference = this.c;
        if (weakReference == null) {
            HMSLog.e("PendingResultImpl", "api is null");
            a(907135003, (IMessageEntity) null);
            return;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.e("PendingResultImpl", "client is invalid");
            a(907135003, (IMessageEntity) null);
            aVar.a(resultCallback, this.b);
            return;
        }
        if (this.f) {
            a(0, 1);
        }
        this.transport.post(apiClient, new DatagramTransport.a() {
            /* class com.huawei.hms.support.api.PendingResultImpl.AnonymousClass3 */

            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.huawei.hms.support.api.PendingResultImpl$a */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
            public void a(int i, IMessageEntity iMessageEntity) {
                PendingResultImpl.this.a(i, iMessageEntity);
                aVar.a(resultCallback, PendingResultImpl.this.b);
            }
        });
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.huawei.hms.core.aidl.IMessageEntity */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    public void a(int i, IMessageEntity iMessageEntity) {
        Status status;
        HMSLog.i("PendingResultImpl", "setResult:" + i);
        Status commonStatus = iMessageEntity instanceof AbstractMessageEntity ? ((AbstractMessageEntity) iMessageEntity).getCommonStatus() : null;
        if (i == 0) {
            this.b = onComplete(iMessageEntity);
        } else {
            this.b = onError(i);
        }
        if (this.f) {
            a(i, 2);
        }
        R r = this.b;
        if (r != null && (status = r.getStatus()) != null && commonStatus != null) {
            int statusCode = status.getStatusCode();
            String statusMessage = status.getStatusMessage();
            int statusCode2 = commonStatus.getStatusCode();
            String statusMessage2 = commonStatus.getStatusMessage();
            if (statusCode != statusCode2) {
                HMSLog.e("PendingResultImpl", "rstStatus code (" + statusCode + ") is not equal commonStatus code (" + statusCode2 + ")");
                HMSLog.e("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
            } else if (TextUtils.isEmpty(statusMessage) && !TextUtils.isEmpty(statusMessage2)) {
                HMSLog.i("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
                this.b.setStatus(new Status(statusCode, statusMessage2, status.getResolution()));
            }
        }
    }

    protected R onError(int i) {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Type type = genericSuperclass != null ? ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0] : null;
        Class<?> type2 = type != null ? GenericTypeReflector.getType(type) : null;
        if (type2 != null) {
            try {
                R r = (R) ((Result) type2.newInstance());
                this.b = r;
                r.setStatus(new Status(i));
            } catch (Exception e2) {
                HMSLog.e("PendingResultImpl", "on Error:" + e2.getMessage());
                return null;
            }
        }
        return this.b;
    }

    protected static class a<R extends Result> extends Handler {
        public a() {
            this(Looper.getMainLooper());
        }

        public void a(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.huawei.hms.support.api.PendingResultImpl$a<R extends com.huawei.hms.support.api.client.Result> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                Pair pair = (Pair) message.obj;
                b((ResultCallback) pair.first, (Result) pair.second);
            }
        }

        public a(Looper looper) {
            super(looper);
        }

        protected void b(ResultCallback<? super R> resultCallback, R r) {
            resultCallback.onResult(r);
        }
    }

    private void a(int i, int i2) {
        SubAppInfo subAppInfo;
        HMSLog.i("PendingResultImpl", "biReportEvent ====== ");
        ApiClient apiClient = this.c.get();
        if (apiClient != null && this.d != null && !HiAnalyticsUtil.getInstance().hasError(apiClient.getContext())) {
            HashMap hashMap = new HashMap();
            hashMap.put("package", apiClient.getPackageName());
            hashMap.put("baseVersion", "5.0.0.301");
            if (i2 == 1) {
                hashMap.put("direction", "req");
            } else {
                hashMap.put("direction", "rsp");
                hashMap.put("result", String.valueOf(i));
                R r = this.b;
                if (!(r == null || r.getStatus() == null)) {
                    hashMap.put("statusCode", String.valueOf(this.b.getStatus().getStatusCode()));
                }
            }
            hashMap.put("version", "0");
            String appId = Util.getAppId(apiClient.getContext());
            if (TextUtils.isEmpty(appId) && (subAppInfo = apiClient.getSubAppInfo()) != null) {
                appId = subAppInfo.getSubAppID();
            }
            hashMap.put("appid", appId);
            if (TextUtils.isEmpty(this.e)) {
                String id = TransactionIdCreater.getId(appId, this.d);
                this.e = id;
                hashMap.put("transId", id);
            } else {
                hashMap.put("transId", this.e);
                this.e = null;
            }
            String[] split = this.d.split("\\.");
            if (split.length >= 2) {
                hashMap.put("service", split[0]);
                hashMap.put("apiName", split[1]);
            }
            hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
            HiAnalyticsUtil.getInstance().onEvent(apiClient.getContext(), "HMS_SDK_BASE_CALL_AIDL", hashMap);
        }
    }
}
