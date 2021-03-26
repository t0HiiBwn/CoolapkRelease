package com.coolapk.market.view.dyhv8;

import android.text.TextUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.dyhv8.TemplateChooseDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: TemplateChooseDialog.kt */
final class TemplateChooseDialog$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ TemplateChooseDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TemplateChooseDialog$onActivityCreated$1(TemplateChooseDialog templateChooseDialog) {
        super(1);
        this.this$0 = templateChooseDialog;
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
        if (TextUtils.isEmpty(TemplateChooseDialog.access$getAction$p(this.this$0))) {
            this.this$0.action = "article";
        }
        TemplateChooseDialog templateChooseDialog = this.this$0;
        MultiItemDialogFragmentKt.addItem(list, new TemplateChooseDialog.TemplateAction(templateChooseDialog, TemplateChooseDialog.access$getDyhArticle$p(templateChooseDialog), "article", TemplateChooseDialog.access$getAction$p(this.this$0)));
        TemplateChooseDialog templateChooseDialog2 = this.this$0;
        MultiItemDialogFragmentKt.addItem(list, new TemplateChooseDialog.TemplateAction(templateChooseDialog2, TemplateChooseDialog.access$getDyhArticle$p(templateChooseDialog2), "articleFeed", TemplateChooseDialog.access$getAction$p(this.this$0)));
        TemplateChooseDialog templateChooseDialog3 = this.this$0;
        MultiItemDialogFragmentKt.addItem(list, new TemplateChooseDialog.TemplateAction(templateChooseDialog3, TemplateChooseDialog.access$getDyhArticle$p(templateChooseDialog3), "articleNews", TemplateChooseDialog.access$getAction$p(this.this$0)));
    }
}
