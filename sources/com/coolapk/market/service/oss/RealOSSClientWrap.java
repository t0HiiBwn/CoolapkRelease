package com.coolapk.market.service.oss;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.coolapk.market.AppHolder;
import com.coolapk.market.local.DataConfig;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\fJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b2\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/service/oss/RealOSSClientWrap;", "", "()V", "apiHost", "", "kotlin.jvm.PlatformType", "getApiHost", "()Ljava/lang/String;", "oss", "Lcom/alibaba/sdk/android/oss/OSSClient;", "imagePersist", "Lrx/Observable;", "Lcom/coolapk/market/service/oss/OSSImagePersist;", "request", "updateConfig", "", "config", "Lcom/coolapk/market/service/oss/OSSClientConfig;", "updateConfig$presentation_coolapkAppRelease", "uploadImage", "Lcom/coolapk/market/service/oss/OSSPutRequest;", "hasProcess", "", "callbackUrl", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OssHelper.kt */
public final class RealOSSClientWrap {
    private OSSClient oss;

    public static final /* synthetic */ OSSClient access$getOss$p(RealOSSClientWrap realOSSClientWrap) {
        OSSClient oSSClient = realOSSClientWrap.oss;
        if (oSSClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oss");
        }
        return oSSClient;
    }

    /* access modifiers changed from: private */
    public final String getApiHost() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        DataConfig dataConfig = instance.getDataConfig();
        Intrinsics.checkNotNullExpressionValue(dataConfig, "DataManager.getInstance().dataConfig");
        return dataConfig.getApiHost();
    }

    public final void updateConfig$presentation_coolapkAppRelease(OSSClientConfig oSSClientConfig) {
        Intrinsics.checkNotNullParameter(oSSClientConfig, "config");
        OSSStsTokenCredentialProvider oSSStsTokenCredentialProvider = new OSSStsTokenCredentialProvider(oSSClientConfig.getAccessKeyId(), oSSClientConfig.getAccessKeySecret(), oSSClientConfig.getSecurityToken());
        if (this.oss != null) {
            OSSClient oSSClient = this.oss;
            if (oSSClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("oss");
            }
            oSSClient.updateCredentialProvider(oSSStsTokenCredentialProvider);
            return;
        }
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setConnectionTimeout(15000);
        clientConfiguration.setSocketTimeout(15000);
        clientConfiguration.setMaxConcurrentRequest(5);
        clientConfiguration.setMaxErrorRetry(2);
        this.oss = new OSSClient(AppHolder.getApplication(), oSSClientConfig.getEndPoint(), oSSStsTokenCredentialProvider, clientConfiguration);
    }

    public final Observable<OSSPutRequest> uploadImage(OSSPutRequest oSSPutRequest, boolean z, String str) {
        Intrinsics.checkNotNullParameter(oSSPutRequest, "request");
        Intrinsics.checkNotNullParameter(str, "callbackUrl");
        Observable<OSSPutRequest> create = Observable.create(new RealOSSClientWrap$uploadImage$1(this, oSSPutRequest, str, z), Emitter.BackpressureMode.BUFFER);
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create({ emit….BackpressureMode.BUFFER)");
        return create;
    }

    public final Observable<OSSImagePersist> imagePersist(OSSImagePersist oSSImagePersist) {
        Intrinsics.checkNotNullParameter(oSSImagePersist, "request");
        Observable<OSSImagePersist> create = Observable.create(new RealOSSClientWrap$imagePersist$1(this, oSSImagePersist), Emitter.BackpressureMode.BUFFER);
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create({ emit….BackpressureMode.BUFFER)");
        return create;
    }
}
