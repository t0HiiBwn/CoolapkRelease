package com.coolapk.market.view.feed;

import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.FeedUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.feed.FeedItemDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedItemDialog.kt */
final class FeedItemDialog$buildAdminActionItem$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ Feed $feed;
    final /* synthetic */ FeedItemDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedItemDialog$buildAdminActionItem$1(FeedItemDialog feedItemDialog, Feed feed) {
        super(1);
        this.this$0 = feedItemDialog;
        this.$feed = feed;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<ActionItem> list) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(list, "it");
        boolean z = true;
        boolean z2 = this.$feed.getStatus() == -1;
        boolean z3 = this.$feed.getBlockStatus() == 1;
        boolean z4 = this.$feed.getBlockStatus() == 2;
        boolean z5 = this.$feed.getIsHeadlineV8() == 0;
        boolean z6 = this.$feed.getIsHeadlined() == 1;
        boolean z7 = this.$feed.getIsHeadlineCommentV8() == 0;
        if (this.$feed.getRecommend() != 3) {
            z = false;
        }
        MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.HeadlineActionItem(z6, this.$feed));
        if (!z) {
            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.HomePageActionItem(this.this$0, z5, this.$feed));
        }
        MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.EditorChoiceActionItem(this.this$0, z, this.$feed));
        if (FeedUtils.isCommentType(this.$feed.getFeedType())) {
            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.HomePagePYActionItem(this.this$0, z7, this.$feed));
        }
        if (FeedUtils.isCommentType(this.$feed.getFeedType())) {
            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.EditorChoicePYActionItem(this.this$0, z, this.$feed));
        }
        MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.PrivateActionItem(this.this$0, z2, this.$feed));
        MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.HomeSelfActionItem(this.this$0, z4, this.$feed));
        String ttype = this.$feed.getTtype();
        if (((ttype == null || (intOrNull = StringsKt.toIntOrNull(ttype)) == null) ? 0 : intOrNull.intValue()) > 0) {
            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.FeedUnLinkActionItem(this.this$0, false, this.$feed));
        }
        if (FeedItemDialog.UnbannedFromMachineActionItem.Companion.shouldShow(this.$feed)) {
            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.UnbannedFromMachineActionItem(this.this$0, this.$feed));
        }
        MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.BannedActionItem(this.this$0, this.$feed));
        MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.FoldedActionItem(this.this$0, z3, this.$feed));
        MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.SoftFoldedActionItem(this.this$0, this.$feed));
        if (this.$feed.getRecommend() >= 0) {
            MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.NoHomePageActionItem(this.this$0, this.$feed));
        }
        MultiItemDialogFragmentKt.addItem(list, new FeedItemDialog.StatusActionItem(this.this$0, this.$feed));
        MultiItemDialogFragmentKt.addItem(list, "作者管理", new Function0<Unit>(this) {
            /* class com.coolapk.market.view.feed.FeedItemDialog$buildAdminActionItem$1.AnonymousClass1 */
            final /* synthetic */ FeedItemDialog$buildAdminActionItem$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                String uid = this.this$0.$feed.getUid();
                Intrinsics.checkNotNullExpressionValue(uid, "feed.uid");
                ActionManager.startWebViewActivity(this.this$0.this$0.getActivity(), UriUtils.getUserManageUrl(uid));
            }
        });
    }
}
