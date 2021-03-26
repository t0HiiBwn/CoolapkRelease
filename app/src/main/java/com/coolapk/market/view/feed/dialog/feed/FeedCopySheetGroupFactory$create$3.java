package com.coolapk.market.view.feed.dialog.feed;

import com.coolapk.market.extend.EntityExtendsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedCopySheetGroupFactory.kt */
final class FeedCopySheetGroupFactory$create$3 extends Lambda implements Function0<String> {
    final /* synthetic */ FeedCopySheetGroupFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedCopySheetGroupFactory$create$3(FeedCopySheetGroupFactory feedCopySheetGroupFactory) {
        super(0);
        this.this$0 = feedCopySheetGroupFactory;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return CollectionsKt.joinToString$default(EntityExtendsKt.getHtmlPicArray(this.this$0.getData()), "\n", null, null, 0, null, null, 62, null);
    }
}
