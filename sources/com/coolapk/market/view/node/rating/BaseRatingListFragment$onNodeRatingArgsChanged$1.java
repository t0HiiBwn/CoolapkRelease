package com.coolapk.market.view.node.rating;

import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Landroid/os/Parcelable;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseRatingListFragment.kt */
final class BaseRatingListFragment$onNodeRatingArgsChanged$1 extends Lambda implements Function1<List<Parcelable>, Unit> {
    final /* synthetic */ BaseRatingListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseRatingListFragment$onNodeRatingArgsChanged$1(BaseRatingListFragment baseRatingListFragment) {
        super(1);
        this.this$0 = baseRatingListFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<Parcelable> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<Parcelable> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        CollectionsKt.removeAll((List) this.this$0.getDataList(), (Function1) AnonymousClass1.INSTANCE);
    }
}
