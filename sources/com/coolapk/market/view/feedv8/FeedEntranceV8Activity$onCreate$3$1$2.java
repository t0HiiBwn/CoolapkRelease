package com.coolapk.market.view.feedv8;

import android.graphics.Color;
import com.coolapk.market.view.feedv8.FeedEntranceV8Activity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity$EntranceItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
final class FeedEntranceV8Activity$onCreate$3$1$2 extends Lambda implements Function1<List<FeedEntranceV8Activity.EntranceItem>, Object> {
    final /* synthetic */ List $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedEntranceV8Activity$onCreate$3$1$2(List list) {
        super(1);
        this.$this_apply = list;
    }

    public final Object invoke(List<FeedEntranceV8Activity.EntranceItem> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return Boolean.valueOf(this.$this_apply.add(new FeedEntranceV8Activity.EntranceItem(FeedEntranceV8Activity.EntranceType.Album, "应用集", Color.parseColor("#EF5350"), 2131231681, false, 16, null)));
    }
}
