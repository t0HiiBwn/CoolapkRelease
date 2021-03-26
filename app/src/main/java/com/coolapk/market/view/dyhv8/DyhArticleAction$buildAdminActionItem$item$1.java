package com.coolapk.market.view.dyhv8;

import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.dyhv8.DyhArticleAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhArticleAction.kt */
final class DyhArticleAction$buildAdminActionItem$item$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ DyhArticle $dyhArticle;
    final /* synthetic */ DyhArticleAction this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DyhArticleAction$buildAdminActionItem$item$1(DyhArticleAction dyhArticleAction, DyhArticle dyhArticle) {
        super(1);
        this.this$0 = dyhArticleAction;
        this.$dyhArticle = dyhArticle;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<ActionItem> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        boolean z = false;
        boolean z2 = this.$dyhArticle.getBlockStatus() > 0;
        this.$dyhArticle.getStatus();
        this.$dyhArticle.getBlockStatus();
        this.$dyhArticle.getStatus();
        boolean z3 = this.$dyhArticle.getIsHeadlineV8() == 0;
        if (this.$dyhArticle.getRecommend() == 3) {
            z = true;
        }
        if (!z) {
            MultiItemDialogFragmentKt.addItem(list, new DyhArticleAction.AddHomePagAction(this.this$0, z3, this.$dyhArticle));
        }
        MultiItemDialogFragmentKt.addItem(list, new DyhArticleAction.EditorChoiceActionItem(this.this$0, z, this.$dyhArticle));
        MultiItemDialogFragmentKt.addItem(list, new DyhArticleAction.BlockAction(this.this$0, z2, this.$dyhArticle));
        MultiItemDialogFragmentKt.addItem(list, new DyhArticleAction.SoftRemoveAction(this.this$0, this.$dyhArticle));
        MultiItemDialogFragmentKt.addItem(list, new DyhArticleAction.StatusActionItem(this.this$0, this.$dyhArticle));
    }
}
