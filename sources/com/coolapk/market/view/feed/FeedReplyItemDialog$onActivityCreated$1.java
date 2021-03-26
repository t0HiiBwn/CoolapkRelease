package com.coolapk.market.view.feed;

import android.text.TextUtils;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.CopyActionItem;
import com.coolapk.market.view.base.MultiActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.feed.FeedReplyItemDialog;
import com.coolapk.market.view.feed.vote.DialogBuilderHelper;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyItemDialog.kt */
final class FeedReplyItemDialog$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ FeedReply $feedReply;
    final /* synthetic */ FeedReplyItemDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedReplyItemDialog$onActivityCreated$1(FeedReplyItemDialog feedReplyItemDialog, FeedReply feedReply) {
        super(1);
        this.this$0 = feedReplyItemDialog;
        this.$feedReply = feedReply;
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
        FeedReplyItemDialog feedReplyItemDialog = this.this$0;
        String string = feedReplyItemDialog.getString(2131887214);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_view_session)");
        MultiItemDialogFragmentKt.addItem(list, new FeedReplyItemDialog.DetailViewActionItem(feedReplyItemDialog, string, this.$feedReply));
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        MultiItemDialogFragmentKt.addItem(list, this.this$0.buildMultiActionItem(this.$feedReply));
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (loginSession.isAdmin()) {
            MultiItemDialogFragmentKt.addItem(list, this.this$0.buildAdminActionItem(this.$feedReply));
        }
        if (!TextUtils.isEmpty(this.$feedReply.getPic())) {
            String string2 = this.this$0.getString(2131886865);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_feed_reply_view_photo)");
            MultiItemDialogFragmentKt.addItem(list, string2, new Function0<Unit>(this) {
                /* class com.coolapk.market.view.feed.FeedReplyItemDialog$onActivityCreated$1.AnonymousClass1 */
                final /* synthetic */ FeedReplyItemDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    String pic = this.this$0.$feedReply.getPic();
                    Intrinsics.checkNotNull(pic);
                    ActionManager.startPhotoViewActivity(this.this$0.this$0.getActivity(), new String[]{pic}, new String[]{this.this$0.$feedReply.getMiddleSizePic()}, 0);
                }
            });
        }
        if (loginSession.isAdmin()) {
            String string3 = this.this$0.getString(2131886792);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.str_dialog_report)");
            MultiItemDialogFragmentKt.addItem(list, new MultiActionItem(string3, new FeedReplyItemDialog$onActivityCreated$1$item$1(this)));
        } else {
            String string4 = this.this$0.getString(2131886792);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.str_dialog_report)");
            MultiItemDialogFragmentKt.addItem(list, string4, new Function0<Unit>(this) {
                /* class com.coolapk.market.view.feed.FeedReplyItemDialog$onActivityCreated$1.AnonymousClass2 */
                final /* synthetic */ FeedReplyItemDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    String id = this.this$0.$feedReply.getId();
                    Intrinsics.checkNotNull(id);
                    Intrinsics.checkNotNullExpressionValue(id, "feedReply.id!!");
                    ActionManager.startWebViewActivity(this.this$0.this$0.getActivity(), UriUtils.buildFeedReplyReportUrl(id));
                }
            });
        }
        if (loginSession.isLogin()) {
            if (EntityExtendsKt.isShowCancelReportSpam(this.$feedReply) && loginSession.isAdmin()) {
                MultiItemDialogFragmentKt.addItem(list, new FeedReplyItemDialog.CancelReportSpamActionItem(this.this$0, this.$feedReply));
            }
            if (Intrinsics.areEqual(this.$feedReply.getUid(), loginSession.getUid()) || loginSession.isAdmin()) {
                FeedReplyItemDialog feedReplyItemDialog2 = this.this$0;
                String string5 = feedReplyItemDialog2.getString(2131886778);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.str_dialog_delete)");
                MultiItemDialogFragmentKt.addItem(list, new FeedReplyItemDialog.DeleteActionItem(feedReplyItemDialog2, string5, this.$feedReply));
            }
        }
        if (loginSession.isAdmin() && !TextUtils.isEmpty(this.$feedReply.getSpamReason())) {
            MultiItemDialogFragmentKt.addItem(list, new FeedReplyItemDialog.RefuseActionItem(this.this$0, this.$feedReply));
            String spamContent = this.$feedReply.getSpamContent();
            if (spamContent == null) {
                spamContent = "";
            }
            MultiItemDialogFragmentKt.addItem(list, new CopyActionItem("复制违规内容", spamContent));
        }
        DialogBuilderHelper.Companion companion = DialogBuilderHelper.Companion;
        String name = FeedReply.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "T::class.java.name");
        DialogBuilderHelper<?> ofClassName = companion.ofClassName(name);
        Objects.requireNonNull(ofClassName, "null cannot be cast to non-null type com.coolapk.market.view.feed.vote.DialogBuilderHelper<T>");
        ofClassName.handleDataList(list, this.$feedReply, this.this$0.getActivity());
    }
}
