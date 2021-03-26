package com.coolapk.market.view.feed.dialog.feed;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.view.feed.FeedActionPresenter;
import com.coolapk.market.view.feed.FeedItemDialog;
import com.coolapk.market.view.feed.dialog.SheetAction;
import com.coolapk.market.view.feed.dialog.SheetCallback;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetResult;
import com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u00019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010 \u001a\u00020!H&J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020#H\u0002J\u0010\u0010(\u001a\u00020#2\u0006\u0010&\u001a\u00020\u000eH\u0002J\b\u0010)\u001a\u00020#H\u0002J\b\u0010*\u001a\u00020#H\u0002J\b\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020#H\u0002J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020#H\u0002J\b\u0010/\u001a\u00020#H\u0002J\b\u00100\u001a\u00020#H\u0002J\b\u00101\u001a\u00020#H\u0002J\b\u00102\u001a\u00020#H\u0002J\b\u00103\u001a\u00020#H\u0002J\b\u00104\u001a\u00020#H\u0002J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0014\u0010\u001b\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0014\u0010\u001c\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0016\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001eX\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminBaseSheetGroupFactory;", "Lcom/coolapk/market/view/feed/dialog/SheetCallback;", "data", "Lcom/coolapk/market/model/Feed;", "activity", "Landroid/app/Activity;", "(Lcom/coolapk/market/model/Feed;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "getData", "()Lcom/coolapk/market/model/Feed;", "feed", "getFeed", "isBanned", "", "()Z", "isEditorChoice", "isFolded", "isHeadline", "isHeadlined", "isHomeVisible", "isMachineBlocked", "isNodeFeed", "isPYHeadline", "isRecommend", "isRecommendOrNormal", "isRecommendVote", "isSelfVisible", "isVoteCommentFeed", "presenter", "Lcom/coolapk/market/view/feed/FeedActionPresenter;", "kotlin.jvm.PlatformType", "create", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "handleBan", "", "handleCancelReportSpam", "handleEditorChoice", "py", "handleFold", "handleHeadline", "handleHomeVisible", "handleMachineBlock", "handleNoHeadlineAnyMore", "handleRecommend", "handleRecommendVote", "handleReject", "handleSelfVisible", "handleSoftFold", "handleUnbanWithOnlyHomeSelf", "handleUnlinkNode", "handleUserControl", "handleViewFeedStatus", "onSheetClick", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "AdminAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedAdminBaseSheetGroupFactory.kt */
public abstract class FeedAdminBaseSheetGroupFactory implements SheetCallback {
    private final Activity activity;
    private final Feed data;
    private final Feed feed;
    private final boolean isBanned;
    private final boolean isEditorChoice;
    private final boolean isFolded;
    private final boolean isHeadline;
    private final boolean isHeadlined;
    private final boolean isHomeVisible;
    private final boolean isMachineBlocked;
    private final boolean isNodeFeed;
    private final boolean isPYHeadline;
    private final boolean isRecommend;
    private final boolean isRecommendOrNormal;
    private final boolean isRecommendVote;
    private final boolean isSelfVisible;
    private final boolean isVoteCommentFeed;
    private final FeedActionPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminBaseSheetGroupFactory$AdminAction;", "", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "(Ljava/lang/String;I)V", "Headline", "EditorChoice", "PYHeadline", "PYEditorChoice", "SelfVisible", "HomeVisible", "UnlinkNode", "MachineBlock", "Ban", "Fold", "SoftFold", "NoHeadlineAnyMore", "ViewFeedStatus", "UserControl", "Recommend", "UnbanWithOnlyHomeSelf", "NotSupportYet", "RecommendVote", "CancelReportSpam", "Reject", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedAdminBaseSheetGroupFactory.kt */
    public enum AdminAction implements SheetAction {
        Headline,
        EditorChoice,
        PYHeadline,
        PYEditorChoice,
        SelfVisible,
        HomeVisible,
        UnlinkNode,
        MachineBlock,
        Ban,
        Fold,
        SoftFold,
        NoHeadlineAnyMore,
        ViewFeedStatus,
        UserControl,
        Recommend,
        UnbanWithOnlyHomeSelf,
        NotSupportYet,
        RecommendVote,
        CancelReportSpam,
        Reject
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdminAction.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AdminAction.Headline.ordinal()] = 1;
            iArr[AdminAction.EditorChoice.ordinal()] = 2;
            iArr[AdminAction.PYHeadline.ordinal()] = 3;
            iArr[AdminAction.PYEditorChoice.ordinal()] = 4;
            iArr[AdminAction.SelfVisible.ordinal()] = 5;
            iArr[AdminAction.HomeVisible.ordinal()] = 6;
            iArr[AdminAction.UnlinkNode.ordinal()] = 7;
            iArr[AdminAction.MachineBlock.ordinal()] = 8;
            iArr[AdminAction.Ban.ordinal()] = 9;
            iArr[AdminAction.Fold.ordinal()] = 10;
            iArr[AdminAction.SoftFold.ordinal()] = 11;
            iArr[AdminAction.NoHeadlineAnyMore.ordinal()] = 12;
            iArr[AdminAction.ViewFeedStatus.ordinal()] = 13;
            iArr[AdminAction.UserControl.ordinal()] = 14;
            iArr[AdminAction.Recommend.ordinal()] = 15;
            iArr[AdminAction.NotSupportYet.ordinal()] = 16;
            iArr[AdminAction.UnbanWithOnlyHomeSelf.ordinal()] = 17;
            iArr[AdminAction.RecommendVote.ordinal()] = 18;
            iArr[AdminAction.CancelReportSpam.ordinal()] = 19;
            iArr[AdminAction.Reject.ordinal()] = 20;
        }
    }

    public abstract SheetGroup create();

    public FeedAdminBaseSheetGroupFactory(Feed feed2, Activity activity2) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(feed2, "data");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.data = feed2;
        this.activity = activity2;
        this.feed = feed2;
        boolean z = false;
        this.isSelfVisible = feed2.getStatus() == -1;
        this.isFolded = feed2.getBlockStatus() == 1 || feed2.getBlockStatus() == 3;
        this.isHomeVisible = feed2.getBlockStatus() == 2;
        this.isBanned = feed2.getStatus() == -3;
        this.isHeadline = feed2.getIsHeadlineV8() == 1;
        this.isHeadlined = feed2.getIsHeadlined() == 1;
        this.isPYHeadline = feed2.getIsHeadlineCommentV8() > 0;
        this.isEditorChoice = feed2.getRecommend() == 3;
        String ttype = feed2.getTtype();
        this.isNodeFeed = ((ttype == null || (intOrNull = StringsKt.toIntOrNull(ttype)) == null) ? 0 : intOrNull.intValue()) > 0;
        this.isMachineBlocked = feed2.getStatus() == -20 || feed2.getStatus() == -21 || feed2.getStatus() == -22;
        this.isRecommendOrNormal = feed2.getRecommend() >= 0;
        this.isRecommend = feed2.getRecommend() > 0;
        boolean areEqual = Intrinsics.areEqual(feed2.getFeedType(), "voteComment");
        this.isVoteCommentFeed = areEqual;
        if (areEqual && feed2.getIsRecommendVoteComment() == 1) {
            z = true;
        }
        this.isRecommendVote = z;
        this.presenter = FeedActionPresenter.getInstance();
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Feed getData() {
        return this.data;
    }

    protected final Feed getFeed() {
        return this.feed;
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

    protected final boolean isHeadline() {
        return this.isHeadline;
    }

    protected final boolean isHeadlined() {
        return this.isHeadlined;
    }

    protected final boolean isPYHeadline() {
        return this.isPYHeadline;
    }

    protected final boolean isEditorChoice() {
        return this.isEditorChoice;
    }

    protected final boolean isNodeFeed() {
        return this.isNodeFeed;
    }

    protected final boolean isMachineBlocked() {
        return this.isMachineBlocked;
    }

    protected final boolean isRecommendOrNormal() {
        return this.isRecommendOrNormal;
    }

    protected final boolean isRecommend() {
        return this.isRecommend;
    }

    protected final boolean isVoteCommentFeed() {
        return this.isVoteCommentFeed;
    }

    protected final boolean isRecommendVote() {
        return this.isRecommendVote;
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetCallback
    public SheetResult onSheetClick(SheetAction sheetAction) {
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        if (!(sheetAction instanceof AdminAction)) {
            return SheetResult.Companion.getNothing();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[((AdminAction) sheetAction).ordinal()]) {
            case 1:
                handleHeadline(false);
                break;
            case 2:
                handleEditorChoice(false);
                break;
            case 3:
                handleHeadline(true);
                break;
            case 4:
                handleEditorChoice(true);
                break;
            case 5:
                handleSelfVisible();
                break;
            case 6:
                handleHomeVisible();
                break;
            case 7:
                handleUnlinkNode();
                break;
            case 8:
                handleMachineBlock();
                break;
            case 9:
                handleBan();
                break;
            case 10:
                handleFold();
                break;
            case 11:
                handleSoftFold();
                break;
            case 12:
                handleNoHeadlineAnyMore();
                break;
            case 13:
                handleViewFeedStatus();
                break;
            case 14:
                handleUserControl();
                break;
            case 15:
                handleRecommend();
                break;
            case 16:
                Toast.show$default(this.activity, "暂不支持", 0, false, 12, null);
                return SheetResult.Companion.getNothing();
            case 17:
                handleUnbanWithOnlyHomeSelf();
                break;
            case 18:
                handleRecommendVote();
                break;
            case 19:
                handleCancelReportSpam();
                break;
            case 20:
                handleReject();
                break;
        }
        return SheetResult.Companion.getClose();
    }

    private final void handleHeadline(boolean z) {
        Observable<Result<String>> observable;
        Feed feed2 = this.data;
        FeedAdminBaseSheetGroupFactory$handleHeadline$1 feedAdminBaseSheetGroupFactory$handleHeadline$1 = new FeedAdminBaseSheetGroupFactory$handleHeadline$1(feed2);
        if (this.isHeadline) {
            observable = this.presenter.removeFromHeadlineV8(feed2, z);
        } else {
            observable = this.presenter.addToHeadlineV8(feed2, z);
        }
        observable.map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedAdminBaseSheetGroupFactory$handleHeadline$2(this, feedAdminBaseSheetGroupFactory$handleHeadline$1, feed2));
    }

    private final void handleEditorChoice(boolean z) {
        Observable<Result<String>> observable;
        boolean z2 = this.isEditorChoice;
        if (z2) {
            observable = this.presenter.removeFromEditorChoice(this.feed, z);
        } else {
            observable = this.presenter.addToEditorChoice(this.feed, z);
        }
        observable.map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedAdminBaseSheetGroupFactory$handleEditorChoice$1(this, z2));
    }

    private final void handleSelfVisible() {
        boolean z = this.isSelfVisible;
        if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_PRIVATE", false)) {
            ConfirmFeedBlockDialog.executeAction(this.feed, 0, z, this.activity);
            return;
        }
        ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定取消仅作者可见？" : "确定要设为仅作者可见?", z ? "取消后，将恢复成正常动态" : "内容只显示在作者主页，通过作者主页可以访问");
        newInstance.setAction(this.feed, 0, z, this.activity);
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_PRIVATE", true).apply();
    }

    private final void handleHomeVisible() {
        Observable<Result<String>> observable;
        FeedAdminBaseSheetGroupFactory$handleHomeVisible$1 feedAdminBaseSheetGroupFactory$handleHomeVisible$1 = new FeedAdminBaseSheetGroupFactory$handleHomeVisible$1(this);
        if (this.isHomeVisible) {
            observable = this.presenter.unOnlyHomeSelf(this.feed);
        } else {
            observable = this.presenter.onlyHomeSelf(this.feed);
        }
        observable.map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedAdminBaseSheetGroupFactory$handleHomeVisible$2(this, feedAdminBaseSheetGroupFactory$handleHomeVisible$1));
    }

    private final void handleUnlinkNode() {
        if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_UNLINK", false)) {
            ConfirmFeedBlockDialog.executeAction(this.feed, 3, false, this.activity);
            return;
        }
        ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance("确定要取消与节点的关联？", "解除节点关联后，将不会出现在该节点评论列表里");
        newInstance.setAction(this.feed, 3, false, this.activity);
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_UNLINK", true).apply();
    }

    private final void handleMachineBlock() {
        ConfirmFeedBlockDialog.executeAction(this.feed, 2, true, this.activity);
    }

    private final void handleBan() {
        boolean z = this.isBanned;
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_BANNED", false)) {
            ConfirmFeedBlockDialog.executeAction(this.feed, 2, z, this.activity);
            return;
        }
        ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定要取消屏蔽此动态？" : "确定要屏蔽此动态？", z ? "取消屏蔽后，将恢复成正常动态" : "屏蔽后禁止访问，等同于删除，但不会真正删除数据");
        newInstance.setAction(this.feed, 2, z, this.activity);
        newInstance.show(supportFragmentManager, (String) null);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_BANNED", true).apply();
    }

    private final void handleUnbanWithOnlyHomeSelf() {
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_BANNED", false)) {
            ConfirmFeedBlockDialog.executeAction(this.feed, 5, true, this.activity);
            return;
        }
        ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance("确定要取消屏蔽并降权吗？", "解除屏蔽后，并仅主页可见");
        newInstance.setAction(this.feed, 5, true, this.activity);
        newInstance.show(supportFragmentManager, (String) null);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_BANNED", true).apply();
    }

    private final void handleFold() {
        boolean z = this.isFolded;
        if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_FLODED", false)) {
            ConfirmFeedBlockDialog.executeAction(this.feed, 1, z, this.activity);
            return;
        }
        ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance(z ? "确定要取消折叠此动态？" : "确定要折叠此动态？", z ? "取消折叠后将恢复成正常的动态" : "折叠后不在公共区域显示，但还会显示在粉丝的好友圈");
        newInstance.setAction(this.feed, 1, z, this.activity);
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_FLODED", true).apply();
    }

    private final void handleSoftFold() {
        if (DataManager.getInstance().getPreferencesBoolean("DIALOG_CONFIRM_SOFT_FLODED", false)) {
            ConfirmFeedBlockDialog.executeAction(this.feed, 4, false, this.activity);
            return;
        }
        ConfirmFeedBlockDialog newInstance = ConfirmFeedBlockDialog.newInstance("确定要去精此动态？", "去精后不在精选区显示，但还会显示在粉丝的好友圈");
        newInstance.setAction(this.feed, 4, false, this.activity);
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putBoolean("DIALOG_CONFIRM_SOFT_FLODED", true).apply();
    }

    private final void handleNoHeadlineAnyMore() {
        FeedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$2 feedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$2 = new FeedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$2(this, new FeedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$1(this));
        if (this.feed.getType() == 10) {
            ConfirmDialog newInstance = ConfirmDialog.newInstance("确定要禁止该问题上头条？", "禁止该问题上头条后，该问题下的回答都不会再上头条，是否继续？");
            newInstance.setOnOkRunnable(new FeedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$3(feedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$2));
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
            return;
        }
        feedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$2.invoke();
    }

    private final void handleViewFeedStatus() {
        FeedItemDialog.InfoDialogFragment newInstance = FeedItemDialog.InfoDialogFragment.Companion.newInstance(this.feed);
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }

    private final void handleUserControl() {
        String uid = this.feed.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "feed.uid");
        ActionManager.startWebViewActivity(this.activity, UriUtils.getUserManageUrl(uid));
    }

    private final void handleRecommend() {
        Observable<Result<String>> observable;
        boolean z = this.isRecommend;
        if (z) {
            observable = this.presenter.cancelRecommendFeed(this.feed);
        } else {
            observable = this.presenter.RecommendFeed(this.feed);
        }
        observable.map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new FeedAdminBaseSheetGroupFactory$handleRecommend$1(this, z));
    }

    private final void handleRecommendVote() {
        String fid = this.feed.getFid();
        String str = "";
        if (fid == null) {
            fid = str;
        }
        String id = this.feed.getId();
        if (id != null) {
            str = id;
        }
        int i = !this.isRecommendVote ? 1 : 0;
        DataManager.getInstance().updateVoteRecommendComment(fid, str, i).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new FeedAdminBaseSheetGroupFactory$handleRecommendVote$1(this, i, str, fid));
    }

    private final void handleCancelReportSpam() {
        DataManager.getInstance().cancelReportSpam(this.feed.getId(), this.feed.getEntityType()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedAdminBaseSheetGroupFactory$handleCancelReportSpam$1(this));
    }

    private final void handleReject() {
        DataManager.getInstance().refuseSpamFeed(this.feed.getId(), this.feed.getSpamTime()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedAdminBaseSheetGroupFactory$handleReject$1(this));
    }
}
