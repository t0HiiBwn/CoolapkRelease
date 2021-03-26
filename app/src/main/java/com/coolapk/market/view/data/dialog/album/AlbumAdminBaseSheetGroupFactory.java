package com.coolapk.market.view.data.dialog.album;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.album.AlbumActionPresenter;
import com.coolapk.market.view.album.AlbumItemDialog;
import com.coolapk.market.view.feed.dialog.SheetAction;
import com.coolapk.market.view.feed.dialog.SheetCallback;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetResult;
import com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001*B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\b\u0010%\u001a\u00020\u001cH\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/coolapk/market/view/data/dialog/album/AlbumAdminBaseSheetGroupFactory;", "Lcom/coolapk/market/view/feed/dialog/SheetCallback;", "data", "Lcom/coolapk/market/model/Album;", "activity", "Landroid/app/Activity;", "(Lcom/coolapk/market/model/Album;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "getData", "()Lcom/coolapk/market/model/Album;", "isBanned", "", "()Z", "isEditorChoice", "isFolded", "isHeadline", "isHomeVisible", "isMachineBlocked", "isRecommend", "isRecommendOrNormal", "isSelfVisible", "presenter", "Lcom/coolapk/market/view/album/AlbumActionPresenter;", "kotlin.jvm.PlatformType", "create", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "handleBan", "", "handleEditorChoice", "handleFold", "handleHeadline", "handleNoHeadlineAnyMore", "handleRecommend", "handleSelfVisible", "handleSoftFold", "handleUserControl", "handleViewFeedStatus", "onSheetClick", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "AdminAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumAdminBaseSheetGroupFactory.kt */
public abstract class AlbumAdminBaseSheetGroupFactory implements SheetCallback {
    private final Activity activity;
    private final Album data;
    private final boolean isBanned;
    private final boolean isEditorChoice;
    private final boolean isFolded;
    private final boolean isHeadline;
    private final boolean isHomeVisible;
    private final boolean isMachineBlocked;
    private final boolean isRecommend;
    private final boolean isRecommendOrNormal;
    private final boolean isSelfVisible;
    private final AlbumActionPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/data/dialog/album/AlbumAdminBaseSheetGroupFactory$AdminAction;", "", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "(Ljava/lang/String;I)V", "Headline", "EditorChoice", "NoHeadlineAnyMore", "SelfVisible", "Ban", "Fold", "SoftFold", "ViewFeedStatus", "UserControl", "Recommend", "NotSupportYet", "Author", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumAdminBaseSheetGroupFactory.kt */
    public enum AdminAction implements SheetAction {
        Headline,
        EditorChoice,
        NoHeadlineAnyMore,
        SelfVisible,
        Ban,
        Fold,
        SoftFold,
        ViewFeedStatus,
        UserControl,
        Recommend,
        NotSupportYet,
        Author
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdminAction.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AdminAction.Headline.ordinal()] = 1;
            iArr[AdminAction.EditorChoice.ordinal()] = 2;
            iArr[AdminAction.SelfVisible.ordinal()] = 3;
            iArr[AdminAction.Ban.ordinal()] = 4;
            iArr[AdminAction.Fold.ordinal()] = 5;
            iArr[AdminAction.SoftFold.ordinal()] = 6;
            iArr[AdminAction.NoHeadlineAnyMore.ordinal()] = 7;
            iArr[AdminAction.ViewFeedStatus.ordinal()] = 8;
            iArr[AdminAction.UserControl.ordinal()] = 9;
            iArr[AdminAction.Recommend.ordinal()] = 10;
            iArr[AdminAction.NotSupportYet.ordinal()] = 11;
            iArr[AdminAction.Author.ordinal()] = 12;
        }
    }

    public abstract SheetGroup create();

    public AlbumAdminBaseSheetGroupFactory(Album album, Activity activity2) {
        Intrinsics.checkNotNullParameter(album, "data");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.data = album;
        this.activity = activity2;
        boolean z = false;
        this.isSelfVisible = album.getStatus() == -1;
        this.isFolded = album.getBlockStatus() == 1 || album.getBlockStatus() == 3;
        this.isHomeVisible = album.getBlockStatus() == 2;
        this.isBanned = album.getStatus() == -3;
        this.isHeadline = album.getIsHeadlineV8() == 1;
        this.isEditorChoice = album.getRecommend() == 3;
        this.isMachineBlocked = album.getStatus() == -20 || album.getStatus() == -21 || album.getStatus() == -22;
        this.isRecommendOrNormal = album.getRecommend() >= 0;
        this.isRecommend = album.getRecommend() > 0 ? true : z;
        this.presenter = AlbumActionPresenter.getInstance();
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Album getData() {
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

    protected final boolean isHeadline() {
        return this.isHeadline;
    }

    protected final boolean isEditorChoice() {
        return this.isEditorChoice;
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

    @Override // com.coolapk.market.view.feed.dialog.SheetCallback
    public SheetResult onSheetClick(SheetAction sheetAction) {
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        if (!(sheetAction instanceof AdminAction)) {
            return SheetResult.Companion.getNothing();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[((AdminAction) sheetAction).ordinal()]) {
            case 1:
                handleHeadline();
                break;
            case 2:
                handleEditorChoice();
                break;
            case 3:
                handleSelfVisible();
                break;
            case 4:
                handleBan();
                break;
            case 5:
                handleFold();
                break;
            case 6:
                handleSoftFold();
                break;
            case 7:
                handleNoHeadlineAnyMore();
                break;
            case 8:
                handleViewFeedStatus();
                break;
            case 9:
                handleUserControl();
                break;
            case 10:
                handleRecommend();
                break;
            case 11:
                Toast.show$default(this.activity, "暂不支持", 0, false, 12, null);
                return SheetResult.Companion.getNothing();
            case 12:
                String uid = this.data.getUid();
                Intrinsics.checkNotNullExpressionValue(uid, "data.uid");
                ActionManager.startWebViewActivity(this.activity, UriUtils.getUserManageUrl(uid));
                break;
        }
        return SheetResult.Companion.getClose();
    }

    private final void handleHeadline() {
        Observable<Result<String>> observable;
        Album album = this.data;
        AlbumAdminBaseSheetGroupFactory$handleHeadline$1 albumAdminBaseSheetGroupFactory$handleHeadline$1 = new AlbumAdminBaseSheetGroupFactory$handleHeadline$1(album);
        if (this.isHeadline) {
            observable = this.presenter.removeFromHeadlineV8(album);
        } else {
            observable = this.presenter.addToHeadlineV8(album);
        }
        observable.map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new AlbumAdminBaseSheetGroupFactory$handleHeadline$2(this, albumAdminBaseSheetGroupFactory$handleHeadline$1, album));
    }

    private final void handleEditorChoice() {
        Observable<Result<String>> observable;
        boolean z = this.isEditorChoice;
        if (z) {
            observable = this.presenter.removeFromEditorChoice(this.data);
        } else {
            observable = this.presenter.addToEditorChoice(this.data);
        }
        observable.map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new AlbumAdminBaseSheetGroupFactory$handleEditorChoice$1(this, z));
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

    private final void handleNoHeadlineAnyMore() {
        this.presenter.removeFromHeadlineV8(this.data).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new AlbumAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$2(this, new AlbumAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$1(this)));
    }

    private final void handleViewFeedStatus() {
        AlbumItemDialog.InfoDialogFragment newInstance = AlbumItemDialog.InfoDialogFragment.Companion.newInstance(this.data);
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }

    private final void handleUserControl() {
        String uid = this.data.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "data.uid");
        ActionManager.startWebViewActivity(this.activity, UriUtils.getUserManageUrl(uid));
    }

    private final void handleRecommend() {
        Observable<Result<String>> observable;
        boolean z = this.isRecommend;
        if (z) {
            observable = this.presenter.cancelRecommendAlbum(this.data);
        } else {
            observable = this.presenter.cancelRecommendAlbum(this.data);
        }
        observable.map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new AlbumAdminBaseSheetGroupFactory$handleRecommend$1(this, z));
    }
}
