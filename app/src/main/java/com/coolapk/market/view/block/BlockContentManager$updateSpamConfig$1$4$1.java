package com.coolapk.market.view.block;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/block/BlockItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: BlockContentManager.kt */
final class BlockContentManager$updateSpamConfig$1$4$1 extends Lambda implements Function1<BlockItem, Boolean> {
    final /* synthetic */ BlockItem $node;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlockContentManager$updateSpamConfig$1$4$1(BlockItem blockItem) {
        super(1);
        this.$node = blockItem;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(BlockItem blockItem) {
        return Boolean.valueOf(invoke(blockItem));
    }

    public final boolean invoke(BlockItem blockItem) {
        Intrinsics.checkNotNullParameter(blockItem, "it");
        return Intrinsics.areEqual(blockItem.getTid(), this.$node.getTid()) && Intrinsics.areEqual(blockItem.getName(), this.$node.getName()) && Intrinsics.areEqual(blockItem.getType(), this.$node.getType());
    }
}
