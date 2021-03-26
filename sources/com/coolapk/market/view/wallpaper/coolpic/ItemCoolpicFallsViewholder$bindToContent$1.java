package com.coolapk.market.view.wallpaper.coolpic;

import android.content.Context;
import android.view.View;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Feed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ItemCoolpicFallsViewholder.kt */
final class ItemCoolpicFallsViewholder$bindToContent$1 implements View.OnLongClickListener {
    final /* synthetic */ Feed $feed;
    final /* synthetic */ ItemCoolpicFallsViewholder this$0;

    ItemCoolpicFallsViewholder$bindToContent$1(ItemCoolpicFallsViewholder itemCoolpicFallsViewholder, Feed feed) {
        this.this$0 = itemCoolpicFallsViewholder;
        this.$feed = feed;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Feed feed = this.$feed;
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        EntityExtendsKt.showItemDialog(feed, context);
        return true;
    }
}
