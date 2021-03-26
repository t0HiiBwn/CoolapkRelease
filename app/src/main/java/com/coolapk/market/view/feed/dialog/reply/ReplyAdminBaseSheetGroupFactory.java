package com.coolapk.market.view.feed.dialog.reply;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.feed.FeedItemDialog;
import com.coolapk.market.view.feed.dialog.SheetAction;
import com.coolapk.market.view.feed.dialog.SheetCallback;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetResult;
import com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/feed/dialog/reply/ReplyAdminBaseSheetGroupFactory;", "Lcom/coolapk/market/view/feed/dialog/SheetCallback;", "data", "Lcom/coolapk/market/model/FeedReply;", "activity", "Landroid/app/Activity;", "(Lcom/coolapk/market/model/FeedReply;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "getData", "()Lcom/coolapk/market/model/FeedReply;", "isBanned", "", "()Z", "isFolded", "isHomeVisible", "isSelfVisible", "create", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "handleBan", "", "handleFold", "handleRefuse", "handleSelfVisible", "handleSoftFold", "handleUserControl", "handleViewFeedStatus", "onSheetClick", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "AdminAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReplyAdminBaseSheetGroupFactory.kt */
public abstract class ReplyAdminBaseSheetGroupFactory implements SheetCallback {
    private final Activity activity;
    private final FeedReply data;
    private final boolean isBanned;
    private final boolean isFolded;
    private final boolean isHomeVisible;
    private final boolean isSelfVisible;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/reply/ReplyAdminBaseSheetGroupFactory$AdminAction;", "", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "(Ljava/lang/String;I)V", "SelfVisible", "Ban", "Fold", "SoftFold", "ViewFeedStatus", "UserControl", "NotSupportYet", "Author", "Refuse", "CancelReportSpam", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ReplyAdminBaseSheetGroupFactory.kt */
    public enum AdminAction implements SheetAction {
        SelfVisible,
        Ban,
        Fold,
        SoftFold,
        ViewFeedStatus,
        UserControl,
        NotSupportYet,
        Author,
        Refuse,
        CancelReportSpam
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdminAction.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AdminAction.SelfVisible.ordinal()] = 1;
            iArr[AdminAction.Ban.ordinal()] = 2;
            iArr[AdminAction.Fold.ordinal()] = 3;
            iArr[AdminAction.SoftFold.ordinal()] = 4;
            iArr[AdminAction.ViewFeedStatus.ordinal()] = 5;
            iArr[AdminAction.UserControl.ordinal()] = 6;
            iArr[AdminAction.NotSupportYet.ordinal()] = 7;
            iArr[AdminAction.Author.ordinal()] = 8;
            iArr[AdminAction.Refuse.ordinal()] = 9;
        }
    }

    public abstract SheetGroup create();

    public ReplyAdminBaseSheetGroupFactory(FeedReply feedReply, Activity activity2) {
        Intrinsics.checkNotNullParameter(feedReply, "data");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.data = feedReply;
        this.activity = activity2;
        boolean z = false;
        this.isSelfVisible = feedReply.getStatus() == -1;
        this.isFolded = feedReply.getBlockStatus() == 1 || feedReply.getBlockStatus() == 3;
        this.isHomeVisible = feedReply.getBlockStatus() == 2;
        this.isBanned = feedReply.getStatus() == -3 ? true : z;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final FeedReply getData() {
        return this.data;
    }

    protected final boolean isSelfVisible() {
        return this.isSelfVisible;
    }

    protected final boolean isFolded() {
        return this.isFolded;
    }

    protected final boolean isHomeVisible() {
        return this.isHomeVisible;
    }

    protected final boolean isBanned() {
        return this.isBanned;
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetCallback
    public SheetResult onSheetClick(SheetAction sheetAction) {
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        if (!(sheetAction instanceof AdminAction)) {
            return SheetResult.Companion.getNothing();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[((AdminAction) sheetAction).ordinal()]) {
            case 1:
                handleSelfVisible();
                break;
            case 2:
                handleBan();
                break;
            case 3:
                handleFold();
                break;
            case 4:
                handleSoftFold();
                break;
            case 5:
                handleViewFeedStatus();
                break;
            case 6:
                handleUserControl();
                break;
            case 7:
                Toast.show$default(this.activity, "暂不支持", 0, false, 12, null);
                return SheetResult.Companion.getNothing();
            case 8:
                String uid = this.data.getUid();
                Intrinsics.checkNotNullExpressionValue(uid, "data.uid");
                ActionManager.startWebViewActivity(this.activity, UriUtils.getUserManageUrl(uid));
                break;
            case 9:
                handleRefuse();
                break;
        }
        return SheetResult.Companion.getClose();
    }

    private final void handleSelfVisible() {
        boolean z = this.isSelfVisible;
        if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_PRIVATE", false)) {
            ConfirmFeedBlockDialog.executeAction(this.data, 0, z, this.activity);
            return;
        }
        ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定取消仅作者可见？" : "确定要设为仅作者可见?", z ? "取消后，将恢复成正常动态" : "内容只显示在作者主页，通过作者主页可以访问");
        newInstance.setAction(this.data, 0, z, this.activity);
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_PRIVATE", true).apply();
    }

    private final void handleBan() {
        boolean z = this.isBanned;
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_BANNED", false)) {
            ConfirmFeedBlockDialog.executeAction(this.data, 2, z, this.activity);
            return;
        }
        ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定要取消屏蔽此动态？" : "确定要屏蔽此动态？", z ? "取消屏蔽后，将恢复成正常动态" : "屏蔽后禁止访问，等同于删除，但不会真正删除数据");
        newInstance.setAction(this.data, 2, z, this.activity);
        newInstance.show(supportFragmentManager, (String) null);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_BANNED", true).apply();
    }

    private final void handleFold() {
        boolean z = this.isFolded;
        if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_FLODED", false)) {
            ConfirmFeedBlockDialog.executeAction(this.data, 1, z, this.activity);
            return;
        }
        ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定要取消折叠此动态？" : "确定要折叠此动态？", z ? "取消折叠后将恢复成正常的动态" : "折叠后不在公共区域显示，但还会显示在粉丝的好友圈");
        newInstance.setAction(this.data, 1, z, this.activity);
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_FLODED", true).apply();
    }

    private final void handleSoftFold() {
        if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_SOFT_FLODED", false)) {
            ConfirmFeedBlockDialog.executeAction(this.data, 4, false, this.activity);
            return;
        }
        ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance("确定要去精此动态？", "去精后不在精选区显示，但还会显示在粉丝的好友圈");
        newInstance.setAction(this.data, 4, false, this.activity);
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_SOFT_FLODED", true).apply();
    }

    private final void handleViewFeedStatus() {
        FeedItemDialog.InfoDialogFragment newInstance = FeedItemDialog.InfoDialogFragment.Companion.newInstance(this.data);
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }

    private final void handleUserControl() {
        String uid = this.data.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "data.uid");
        ActionManager.startWebViewActivity(this.activity, UriUtils.getUserManageUrl(uid));
    }

    private final void handleRefuse() {
        DataManager.getInstance().refuseSpamFeedReply(this.data.getId(), this.data.getSpamTime()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new ReplyAdminBaseSheetGroupFactory$handleRefuse$1(this));
    }
}
