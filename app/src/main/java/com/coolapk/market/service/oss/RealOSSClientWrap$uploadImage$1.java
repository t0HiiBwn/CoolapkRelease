package com.coolapk.market.service.oss;

import android.net.Uri;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.coolapk.market.util.CoolFileUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lrx/Emitter;", "Lcom/coolapk/market/service/oss/OSSPutRequest;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: OssHelper.kt */
final class RealOSSClientWrap$uploadImage$1<T> implements Action1<Emitter<OSSPutRequest>> {
    final /* synthetic */ String $callbackUrl;
    final /* synthetic */ boolean $hasProcess;
    final /* synthetic */ OSSPutRequest $request;
    final /* synthetic */ RealOSSClientWrap this$0;

    RealOSSClientWrap$uploadImage$1(RealOSSClientWrap realOSSClientWrap, OSSPutRequest oSSPutRequest, String str, boolean z) {
        this.this$0 = realOSSClientWrap;
        this.$request = oSSPutRequest;
        this.$callbackUrl = str;
        this.$hasProcess = z;
    }

    public final void call(Emitter<OSSPutRequest> emitter) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(this.$request.getBucket(), this.$request.getObjectName(), this.$request.getFilePath());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(CoolFileUtils.mediaType(this.$request.getFilePath()).toString());
        objectMetadata.setContentMD5(BinaryUtil.calculateBase64Md5(this.$request.getFilePath()));
        putObjectRequest.setMetadata(objectMetadata);
        Uri parse = Uri.parse(this.$callbackUrl);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(callbackUrl)");
        String host = parse.getHost();
        if (host == null) {
            host = this.this$0.getApiHost();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("callbackUrl", this.$callbackUrl);
        hashMap.put("callbackHost", host);
        hashMap.put("callbackBodyType", "application/json");
        hashMap.put("callbackBody", "{\"bucket\":${bucket},\"object\":${object},\"hasProcess\":${x:var1}}");
        Unit unit = Unit.INSTANCE;
        putObjectRequest.setCallbackParam(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("x:var1", String.valueOf(this.$hasProcess));
        Unit unit2 = Unit.INSTANCE;
        putObjectRequest.setCallbackVars(hashMap2);
        try {
            RealOSSClientWrap.access$getOss$p(this.this$0).putObject(putObjectRequest);
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
