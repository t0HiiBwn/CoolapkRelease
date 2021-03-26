package com.coolapk.market.view.block;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/os/Parcelable;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: BlockWordListFragment.kt */
final class BlockWordListFragment$removeBlockWord$1$onNext$1 extends Lambda implements Function1<Parcelable, Boolean> {
    final /* synthetic */ BlockWordListFragment$removeBlockWord$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlockWordListFragment$removeBlockWord$1$onNext$1(BlockWordListFragment$removeBlockWord$1 blockWordListFragment$removeBlockWord$1) {
        super(1);
        this.this$0 = blockWordListFragment$removeBlockWord$1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Parcelable parcelable) {
        return Boolean.valueOf(invoke(parcelable));
    }

    public final boolean invoke(Parcelable parcelable) {
        return (parcelable instanceof BlockItem) && Intrinsics.areEqual(((BlockItem) parcelable).getName(), this.this$0.$item.getName());
    }
}
