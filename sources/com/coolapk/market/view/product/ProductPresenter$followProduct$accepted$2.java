package com.coolapk.market.view.product;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductViewModel.kt */
final class ProductPresenter$followProduct$accepted$2 extends Lambda implements Function1<Throwable, Boolean> {
    final /* synthetic */ boolean $newValue;
    final /* synthetic */ boolean $oldValue;
    final /* synthetic */ ProductPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductPresenter$followProduct$accepted$2(ProductPresenter productPresenter, boolean z, boolean z2) {
        super(1);
        this.this$0 = productPresenter;
        this.$oldValue = z;
        this.$newValue = z2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
        return Boolean.valueOf(invoke(th));
    }

    public final boolean invoke(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        this.this$0.getView().onFollowStateChanged(this.$oldValue, this.$newValue, th);
        return false;
    }
}
