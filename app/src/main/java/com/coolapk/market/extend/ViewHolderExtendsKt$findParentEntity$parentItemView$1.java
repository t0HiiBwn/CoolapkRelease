package com.coolapk.market.extend;

import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/ViewParent;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ViewHolderExtends.kt */
final class ViewHolderExtendsKt$findParentEntity$parentItemView$1 extends Lambda implements Function1<ViewParent, Boolean> {
    public static final ViewHolderExtendsKt$findParentEntity$parentItemView$1 INSTANCE = new ViewHolderExtendsKt$findParentEntity$parentItemView$1();

    ViewHolderExtendsKt$findParentEntity$parentItemView$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ViewParent viewParent) {
        return Boolean.valueOf(invoke(viewParent));
    }

    public final boolean invoke(ViewParent viewParent) {
        Intrinsics.checkNotNullParameter(viewParent, "it");
        return viewParent.getParent() instanceof RecyclerView;
    }
}
