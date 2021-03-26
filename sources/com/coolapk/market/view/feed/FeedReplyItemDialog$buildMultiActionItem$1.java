package com.coolapk.market.view.feed;

import android.text.TextUtils;
import android.text.style.URLSpan;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.CopyActionItem;
import com.coolapk.market.view.base.CopyFreeActionItem;
import com.coolapk.market.view.base.CopyUserActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyItemDialog.kt */
final class FeedReplyItemDialog$buildMultiActionItem$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ FeedReply $feedReply;
    final /* synthetic */ Ref.ObjectRef $spanList;
    final /* synthetic */ FeedReplyItemDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedReplyItemDialog$buildMultiActionItem$1(FeedReplyItemDialog feedReplyItemDialog, FeedReply feedReply, Ref.ObjectRef objectRef) {
        super(1);
        this.this$0 = feedReplyItemDialog;
        this.$feedReply = feedReply;
        this.$spanList = objectRef;
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
        String string = this.this$0.getString(2131886774);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_dialog_copy_content)");
        String string2 = this.this$0.getString(2131886775);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_dialog_copy_free)");
        String allLinkAndText = StringUtils.getAllLinkAndText(this.$feedReply.getMessage());
        Intrinsics.checkNotNullExpressionValue(allLinkAndText, "StringUtils.getAllLinkAndText(feedReply.message)");
        MultiItemDialogFragmentKt.addItem(list, new CopyActionItem(string, LinkTextUtils.reconvert(allLinkAndText)));
        String allLinkAndText2 = StringUtils.getAllLinkAndText(this.$feedReply.getMessage());
        Intrinsics.checkNotNullExpressionValue(allLinkAndText2, "StringUtils.getAllLinkAndText(feedReply.message)");
        MultiItemDialogFragmentKt.addItem(list, new CopyFreeActionItem(string2, LinkTextUtils.reconvert(allLinkAndText2)));
        String userName = this.$feedReply.getUserName();
        Intrinsics.checkNotNullExpressionValue(userName, "feedReply.userName");
        MultiItemDialogFragmentKt.addItem(list, new CopyUserActionItem(userName));
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        String str = "";
        if (loginSession.isAdmin() && !TextUtils.isEmpty(this.$feedReply.getPic())) {
            String pic = this.$feedReply.getPic();
            if (pic == null) {
                pic = str;
            }
            MultiItemDialogFragmentKt.addItem(list, new CopyActionItem("复制图片链接", pic));
        }
        if (this.$feedReply.getReplyId() > 0) {
            String replyUserName = this.$feedReply.getReplyUserName();
            if (replyUserName != null) {
                str = replyUserName;
            }
            MultiItemDialogFragmentKt.addItem(list, new CopyUserActionItem(str));
        }
        HashSet hashSet = new HashSet();
        for (URLSpan uRLSpan : this.$spanList.element) {
            hashSet.add(uRLSpan.getURL());
        }
        for (String str2 : CollectionsKt.toList(hashSet)) {
            if (StringsKt.startsWith$default(str2, "http", false, 2, (Object) null)) {
                String string3 = this.this$0.getString(2131886776, str2);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.str_d…log_copy_something, span)");
                MultiItemDialogFragmentKt.addItem(list, new CopyActionItem(string3, str2));
            }
        }
    }
}
