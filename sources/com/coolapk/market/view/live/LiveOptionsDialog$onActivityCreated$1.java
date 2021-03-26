package com.coolapk.market.view.live;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.CopyActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.base.SimpleDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveOptionsDialog.kt */
final class LiveOptionsDialog$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ Live $live;
    final /* synthetic */ String $liveId;
    final /* synthetic */ String $uid;
    final /* synthetic */ LiveOptionsDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveOptionsDialog$onActivityCreated$1(LiveOptionsDialog liveOptionsDialog, String str, Live live, String str2) {
        super(1);
        this.this$0 = liveOptionsDialog;
        this.$liveId = str;
        this.$live = live;
        this.$uid = str2;
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
        if (this.this$0.getAddToBroadcast()) {
            MultiItemDialogFragmentKt.addItem(list, "上墙", new Function0<Unit>(this) {
                /* class com.coolapk.market.view.live.LiveOptionsDialog$onActivityCreated$1.AnonymousClass1 */
                final /* synthetic */ LiveOptionsDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    LivePresenter livePresenter = this.this$0.this$0.getLiveContext().getLivePresenter();
                    String str = this.this$0.$liveId;
                    LiveMessage liveMessage = this.this$0.this$0.getLiveMessage();
                    Intrinsics.checkNotNullExpressionValue(liveMessage, "liveMessage");
                    String id = liveMessage.getId();
                    Intrinsics.checkNotNull(id);
                    Intrinsics.checkNotNullExpressionValue(id, "liveMessage.id!!");
                    livePresenter.addToBroadcast(str, id);
                }
            });
        }
        StringBuilder sb = new StringBuilder();
        sb.append("复制@");
        LiveMessage liveMessage = this.this$0.getLiveMessage();
        Intrinsics.checkNotNullExpressionValue(liveMessage, "liveMessage");
        sb.append(liveMessage.getUserName());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append('@');
        LiveMessage liveMessage2 = this.this$0.getLiveMessage();
        Intrinsics.checkNotNullExpressionValue(liveMessage2, "liveMessage");
        sb3.append(liveMessage2.getUserName());
        MultiItemDialogFragmentKt.addItem(list, new CopyActionItem(sb2, sb3.toString()));
        LiveMessage liveMessage3 = this.this$0.getLiveMessage();
        Intrinsics.checkNotNullExpressionValue(liveMessage3, "liveMessage");
        String allLinkAndText = StringUtils.getAllLinkAndText(liveMessage3.getMessage());
        Intrinsics.checkNotNullExpressionValue(allLinkAndText, "StringUtils.getAllLinkAndText(liveMessage.message)");
        MultiItemDialogFragmentKt.addItem(list, new CopyActionItem("复制消息", LinkTextUtils.reconvert(allLinkAndText)));
        LiveMessage liveMessage4 = this.this$0.getLiveMessage();
        Intrinsics.checkNotNullExpressionValue(liveMessage4, "liveMessage");
        LiveMessage sourceRow = liveMessage4.getSourceRow();
        if (sourceRow != null) {
            MultiItemDialogFragmentKt.addItem(list, new CopyActionItem("复制@" + sourceRow.getUserName(), '@' + sourceRow.getUserName()));
            String allLinkAndText2 = StringUtils.getAllLinkAndText(sourceRow.getMessage());
            Intrinsics.checkNotNullExpressionValue(allLinkAndText2, "StringUtils.getAllLinkAndText(sourceRow.message)");
            MultiItemDialogFragmentKt.addItem(list, new CopyActionItem("复制被回复", LinkTextUtils.reconvert(allLinkAndText2)));
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (loginSession.isAdmin() || LiveUtils.INSTANCE.currentUserIsPresenter(this.$live)) {
            MultiItemDialogFragmentKt.addItem(list, "删除该发言", new Function0<Unit>(this) {
                /* class com.coolapk.market.view.live.LiveOptionsDialog$onActivityCreated$1.AnonymousClass2 */
                final /* synthetic */ LiveOptionsDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    LivePresenter livePresenter = this.this$0.this$0.getLiveContext().getLivePresenter();
                    LiveMessage liveMessage = this.this$0.this$0.getLiveMessage();
                    Intrinsics.checkNotNullExpressionValue(liveMessage, "liveMessage");
                    String liveId = liveMessage.getLiveId();
                    Intrinsics.checkNotNullExpressionValue(liveId, "liveMessage.liveId");
                    LiveMessage liveMessage2 = this.this$0.this$0.getLiveMessage();
                    Intrinsics.checkNotNullExpressionValue(liveMessage2, "liveMessage");
                    String id = liveMessage2.getId();
                    Intrinsics.checkNotNull(id);
                    Intrinsics.checkNotNullExpressionValue(id, "liveMessage.id!!");
                    livePresenter.deleteMessage(liveId, id);
                }
            });
            MultiItemDialogFragmentKt.addItem(list, "删除此人所有发言并禁言", new Function0<Unit>(this) {
                /* class com.coolapk.market.view.live.LiveOptionsDialog$onActivityCreated$1.AnonymousClass3 */
                final /* synthetic */ LiveOptionsDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    SimpleDialog newInstance = SimpleDialog.newInstance();
                    StringBuilder sb = new StringBuilder();
                    sb.append("确认删除【");
                    LiveMessage liveMessage = this.this$0.this$0.getLiveMessage();
                    Intrinsics.checkNotNullExpressionValue(liveMessage, "liveMessage");
                    sb.append(liveMessage.getUserName());
                    sb.append("】的所有发言并禁言吗？");
                    newInstance.setMessage(sb.toString());
                    newInstance.setPositiveButton("确认", new DialogInterface.OnClickListener(this) {
                        /* class com.coolapk.market.view.live.LiveOptionsDialog$onActivityCreated$1.AnonymousClass3.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass3 this$0;

                        {
                            this.this$0 = r1;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.this$0.this$0.this$0.getLiveContext().getLivePresenter().banUserAndClean(this.this$0.this$0.$liveId, this.this$0.this$0.$uid);
                        }
                    });
                    FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
                    newInstance.show(supportFragmentManager, (String) null);
                }
            });
            MultiItemDialogFragmentKt.addItem(list, "禁止发言", new Function0<Unit>(this) {
                /* class com.coolapk.market.view.live.LiveOptionsDialog$onActivityCreated$1.AnonymousClass4 */
                final /* synthetic */ LiveOptionsDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    SimpleDialog newInstance = SimpleDialog.newInstance();
                    StringBuilder sb = new StringBuilder();
                    sb.append("确认禁止【");
                    LiveMessage liveMessage = this.this$0.this$0.getLiveMessage();
                    Intrinsics.checkNotNullExpressionValue(liveMessage, "liveMessage");
                    sb.append(liveMessage.getUserName());
                    sb.append("】发言吗？");
                    newInstance.setMessage(sb.toString());
                    newInstance.setPositiveButton("确认", new DialogInterface.OnClickListener(this) {
                        /* class com.coolapk.market.view.live.LiveOptionsDialog$onActivityCreated$1.AnonymousClass4.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass4 this$0;

                        {
                            this.this$0 = r1;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.this$0.this$0.this$0.getLiveContext().getLivePresenter().banUser(this.this$0.this$0.$liveId, this.this$0.this$0.$uid, 1);
                        }
                    });
                    FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
                    newInstance.show(supportFragmentManager, (String) null);
                }
            });
            MultiItemDialogFragmentKt.addItem(list, "禁止发图", new Function0<Unit>(this) {
                /* class com.coolapk.market.view.live.LiveOptionsDialog$onActivityCreated$1.AnonymousClass5 */
                final /* synthetic */ LiveOptionsDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    SimpleDialog newInstance = SimpleDialog.newInstance();
                    StringBuilder sb = new StringBuilder();
                    sb.append("确认禁止【");
                    LiveMessage liveMessage = this.this$0.this$0.getLiveMessage();
                    Intrinsics.checkNotNullExpressionValue(liveMessage, "liveMessage");
                    sb.append(liveMessage.getUserName());
                    sb.append("】发图吗？");
                    newInstance.setMessage(sb.toString());
                    newInstance.setPositiveButton("确认", new DialogInterface.OnClickListener(this) {
                        /* class com.coolapk.market.view.live.LiveOptionsDialog$onActivityCreated$1.AnonymousClass5.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass5 this$0;

                        {
                            this.this$0 = r1;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.this$0.this$0.this$0.getLiveContext().getLivePresenter().banUser(this.this$0.this$0.$liveId, this.this$0.this$0.$uid, 2);
                        }
                    });
                    FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
                    newInstance.show(supportFragmentManager, (String) null);
                }
            });
        }
    }
}
