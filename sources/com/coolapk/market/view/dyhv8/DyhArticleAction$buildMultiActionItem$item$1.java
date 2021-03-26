package com.coolapk.market.view.dyhv8;

import android.text.TextUtils;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.CopyActionItem;
import com.coolapk.market.view.base.CopyFreeActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhArticleAction.kt */
final class DyhArticleAction$buildMultiActionItem$item$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ DyhArticle $dyhArticle;
    final /* synthetic */ DyhArticleAction this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DyhArticleAction$buildMultiActionItem$item$1(DyhArticleAction dyhArticleAction, DyhArticle dyhArticle) {
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
        String string = this.this$0.getString(2131886423);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.menu_action_copy_link)");
        String redirectUrl = this.$dyhArticle.getRedirectUrl();
        Intrinsics.checkNotNull(redirectUrl);
        Intrinsics.checkNotNullExpressionValue(redirectUrl, "dyhArticle.redirectUrl!!");
        MultiItemDialogFragmentKt.addItem(list, new CopyActionItem(string, redirectUrl));
        String string2 = this.this$0.getString(2131886774);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_dialog_copy_content)");
        String string3 = this.this$0.getString(2131886775);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.str_dialog_copy_free)");
        String allLinkAndText = StringUtils.getAllLinkAndText(this.$dyhArticle.getMessage());
        Intrinsics.checkNotNullExpressionValue(allLinkAndText, "StringUtils.getAllLinkAndText(dyhArticle.message)");
        MultiItemDialogFragmentKt.addItem(list, new CopyActionItem(string2, LinkTextUtils.reconvert(allLinkAndText)));
        String allLinkAndText2 = StringUtils.getAllLinkAndText(this.$dyhArticle.getMessage());
        Intrinsics.checkNotNullExpressionValue(allLinkAndText2, "StringUtils.getAllLinkAndText(dyhArticle.message)");
        MultiItemDialogFragmentKt.addItem(list, new CopyFreeActionItem(string3, LinkTextUtils.reconvert(allLinkAndText2)));
        String dyhName = this.$dyhArticle.getDyhName();
        Intrinsics.checkNotNull(dyhName);
        Intrinsics.checkNotNullExpressionValue(dyhName, "dyhArticle.dyhName!!");
        MultiItemDialogFragmentKt.addItem(list, new CopyActionItem("复制看看号", dyhName));
        boolean z = false;
        if (CollectionUtils.safeSize(this.$dyhArticle.getPicArr()) > 0) {
            List<String> picArr = this.$dyhArticle.getPicArr();
            Intrinsics.checkNotNull(picArr);
            if (!TextUtils.isEmpty(picArr.get(0))) {
                z = true;
            }
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (loginSession.isAdmin() && z) {
            String listToString = StringUtils.listToString(this.$dyhArticle.getPicArr());
            Intrinsics.checkNotNullExpressionValue(listToString, "StringUtils.listToString(dyhArticle.picArr)");
            MultiItemDialogFragmentKt.addItem(list, new CopyActionItem("复制图片链接", listToString));
        }
    }
}
