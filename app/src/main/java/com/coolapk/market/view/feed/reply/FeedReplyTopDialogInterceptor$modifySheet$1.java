package com.coolapk.market.view.feed.reply;

import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupModifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "sheetGroup", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "index", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyTopDialogInterceptor.kt */
final class FeedReplyTopDialogInterceptor$modifySheet$1 extends Lambda implements Function2<SheetGroup, Integer, Unit> {
    final /* synthetic */ Object $data;
    final /* synthetic */ FeedReplyTopDialogInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedReplyTopDialogInterceptor$modifySheet$1(FeedReplyTopDialogInterceptor feedReplyTopDialogInterceptor, Object obj) {
        super(2);
        this.this$0 = feedReplyTopDialogInterceptor;
        this.$data = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(SheetGroup sheetGroup, Integer num) {
        invoke(sheetGroup, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SheetGroup sheetGroup, int i) {
        SheetDataItem sheetDataItem;
        Intrinsics.checkNotNullParameter(sheetGroup, "sheetGroup");
        List<String> topIds = this.this$0.getTopIds();
        String id = ((FeedReply) this.$data).getId();
        if (id == null) {
            id = "";
        }
        boolean contains = topIds.contains(id);
        FeedReplyTopDialogInterceptor$modifySheet$1$callback$1 feedReplyTopDialogInterceptor$modifySheet$1$callback$1 = new FeedReplyTopDialogInterceptor$modifySheet$1$callback$1(this, contains);
        int colorInt = ResourceUtils.getColorInt(this.this$0.getActivity(), 2131100049);
        int resolveData = ResourceUtils.resolveData(this.this$0.getActivity(), 2130969438);
        if (contains) {
            sheetDataItem = new SheetDataItem(SheetGroupModifier.Action.Three, "取消置顶", SheetDataItem.Companion.createIconBgApplyer(2131231626, resolveData, colorInt), feedReplyTopDialogInterceptor$modifySheet$1$callback$1, null, 0, false, false, 240, null);
        } else {
            sheetDataItem = new SheetDataItem(SheetGroupModifier.Action.Three, "置顶", SheetDataItem.Companion.createIconBgApplyer(2131231615, resolveData, colorInt), feedReplyTopDialogInterceptor$modifySheet$1$callback$1, null, 0, false, false, 240, null);
        }
        sheetGroup.getItems().add(i, sheetDataItem);
    }
}
