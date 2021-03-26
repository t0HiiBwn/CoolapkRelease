package com.coolapk.market.view.cardlist;

import com.coolapk.market.model.Feed;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityBlockSpamHelper.kt */
final class EntityBlockSpamHelper$findAndRemoveWordSpam$1 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ List $deletedFeeds;
    final /* synthetic */ Regex $wordRegex;
    final /* synthetic */ EntityBlockSpamHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityBlockSpamHelper$findAndRemoveWordSpam$1(EntityBlockSpamHelper entityBlockSpamHelper, Regex regex, List list) {
        super(1);
        this.this$0 = entityBlockSpamHelper;
        this.$wordRegex = regex;
        this.$deletedFeeds = list;
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        if (!(obj instanceof Feed) || !this.this$0.isFeedNeedToBlock((Feed) obj, this.$wordRegex)) {
            return null;
        }
        this.$deletedFeeds.add(obj);
        return 1;
    }
}
