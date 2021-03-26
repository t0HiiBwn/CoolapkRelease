package com.coolapk.market.service.oss;

import com.alibaba.sdk.android.oss.OSSClient;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: OssHelper.kt */
final /* synthetic */ class RealOSSClientWrap$updateConfig$1 extends MutablePropertyReference0Impl {
    RealOSSClientWrap$updateConfig$1(RealOSSClientWrap realOSSClientWrap) {
        super(realOSSClientWrap, RealOSSClientWrap.class, "oss", "getOss()Lcom/alibaba/sdk/android/oss/OSSClient;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return RealOSSClientWrap.access$getOss$p((RealOSSClientWrap) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((RealOSSClientWrap) this.receiver).oss = (OSSClient) obj;
    }
}
