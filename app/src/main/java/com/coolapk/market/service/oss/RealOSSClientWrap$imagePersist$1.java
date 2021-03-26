package com.coolapk.market.service.oss;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.ImagePersistRequest;
import kotlin.Metadata;
import rx.Emitter;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lrx/Emitter;", "Lcom/coolapk/market/service/oss/OSSImagePersist;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: OssHelper.kt */
final class RealOSSClientWrap$imagePersist$1<T> implements Action1<Emitter<OSSImagePersist>> {
    final /* synthetic */ OSSImagePersist $request;
    final /* synthetic */ RealOSSClientWrap this$0;

    RealOSSClientWrap$imagePersist$1(RealOSSClientWrap realOSSClientWrap, OSSImagePersist oSSImagePersist) {
        this.this$0 = realOSSClientWrap;
        this.$request = oSSImagePersist;
    }

    public final void call(Emitter<OSSImagePersist> emitter) {
        try {
            RealOSSClientWrap.access$getOss$p(this.this$0).imagePersist(new ImagePersistRequest(this.$request.getFromBucket(), this.$request.getFromObjectKey(), this.$request.getToBucket(), this.$request.getToObjectKey(), this.$request.getAction()));
            RealOSSClientWrap.access$getOss$p(this.this$0).headObject(new HeadObjectRequest(this.$request.getToBucket(), this.$request.getToObjectKey()));
            emitter.onNext(this.$request);
            emitter.onCompleted();
        } catch (ClientException e) {
            emitter.onError(e);
        } catch (ServiceException e2) {
            emitter.onError(e2);
        } catch (Throwable th) {
            emitter.onError(th);
        }
    }
}
