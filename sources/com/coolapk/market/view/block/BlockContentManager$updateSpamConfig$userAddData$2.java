package com.coolapk.market.view.block;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/view/block/BlockItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: BlockContentManager.kt */
final class BlockContentManager$updateSpamConfig$userAddData$2 extends Lambda implements Function1<BlockItem, CharSequence> {
    public static final BlockContentManager$updateSpamConfig$userAddData$2 INSTANCE = new BlockContentManager$updateSpamConfig$userAddData$2();

    BlockContentManager$updateSpamConfig$userAddData$2() {
        super(1);
    }

    public final CharSequence invoke(BlockItem blockItem) {
        Intrinsics.checkNotNullParameter(blockItem, "it");
        return blockItem.getName();
    }
}
