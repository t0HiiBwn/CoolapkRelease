package com.coolapk.market.view.feed.dialog.feed;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.FeedUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.feed.FeedItemDialog;
import com.coolapk.market.view.feed.dialog.SheetAction;
import com.coolapk.market.view.feed.dialog.SheetCallback;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import com.coolapk.market.view.feed.dialog.SheetResult;
import com.coolapk.market.view.feed.post.ConfirmDeleteDialog;
import com.coolapk.market.view.feed.post.FeedTitleEditDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0002J4\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/FeedUserSheetGroupFactory;", "Lcom/coolapk/market/view/feed/dialog/SheetCallback;", "data", "Lcom/coolapk/market/model/Feed;", "activity", "Landroid/app/Activity;", "(Lcom/coolapk/market/model/Feed;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "bgColor", "", "getData", "()Lcom/coolapk/market/model/Feed;", "dataList", "", "Lcom/coolapk/market/view/feed/dialog/SheetDataItem;", "userItemColor", "create", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "handleCensor", "", "insertItem", "action", "Lcom/coolapk/market/view/feed/dialog/feed/FeedUserSheetGroupFactory$FeedAction;", "title", "", "resource", "iconTintColor", "bandageText", "onSheetClick", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "wrapAsSheetGroup", "FeedAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedUserSheetGroupFactory.kt */
public final class FeedUserSheetGroupFactory implements SheetCallback {
    private final Activity activity;
    private final int bgColor;
    private final Feed data;
    private final List<SheetDataItem> dataList = new ArrayList();
    private final int userItemColor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/FeedUserSheetGroupFactory$FeedAction;", "", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "(Ljava/lang/String;I)V", "EditTitle", "Top", "Copy", "Favor", "Report", "Edit", "Delete", "ViewChat", "Forward", "EditHistory", "AddToGoodsList", "Censor", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedUserSheetGroupFactory.kt */
    public enum FeedAction implements SheetAction {
        EditTitle,
        Top,
        Copy,
        Favor,
        Report,
        Edit,
        Delete,
        ViewChat,
        Forward,
        EditHistory,
        AddToGoodsList,
        Censor
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FeedAction.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[FeedAction.Copy.ordinal()] = 1;
            iArr[FeedAction.EditTitle.ordinal()] = 2;
            iArr[FeedAction.Favor.ordinal()] = 3;
            iArr[FeedAction.Report.ordinal()] = 4;
            iArr[FeedAction.Edit.ordinal()] = 5;
            iArr[FeedAction.Delete.ordinal()] = 6;
            iArr[FeedAction.Forward.ordinal()] = 7;
            iArr[FeedAction.EditHistory.ordinal()] = 8;
            iArr[FeedAction.AddToGoodsList.ordinal()] = 9;
            iArr[FeedAction.Censor.ordinal()] = 10;
        }
    }

    public FeedUserSheetGroupFactory(Feed feed, Activity activity2) {
        Intrinsics.checkNotNullParameter(feed, "data");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.data = feed;
        this.activity = activity2;
        this.bgColor = ResourceUtils.getColorInt(activity2, 2131100054);
        this.userItemColor = ResourceUtils.resolveData(activity2, 2130969438);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Feed getData() {
        return this.data;
    }

    public final SheetGroup create() {
        if (!this.dataList.isEmpty()) {
            return wrapAsSheetGroup();
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        boolean isAdmin = loginSession.isAdmin();
        boolean areEqual = Intrinsics.areEqual(this.data.getUid(), loginSession.getUid());
        boolean z = false;
        boolean z2 = areEqual && ArraysKt.contains(new int[]{-20, -22}, this.data.getStatus());
        boolean z3 = this.data.getStatus() == -21;
        boolean z4 = z2 || z3;
        if (isAdmin) {
            insertItem$default(this, FeedAction.EditTitle, "编辑标题", 2131231623, 0, null, 24, null);
        }
        if (z4 && areEqual) {
            insertItem$default(this, FeedAction.Censor, "催审", 2131231531, 0, z3 ? "催审中" : "", 8, null);
        }
        boolean isGoodsType = FeedUtils.isGoodsType(this.data.getFeedType());
        if (!z4 && isGoodsType) {
            insertItem$default(this, FeedAction.AddToGoodsList, "加入好物单", 2131231386, 0, null, 24, null);
        }
        insertItem$default(this, FeedAction.Copy, "复制", 2131231244, 0, null, 24, null);
        if (!z4) {
            UserAction userAction = this.data.getUserAction();
            if ((userAction != null ? userAction.getCollect() : 0) > 0) {
                z = true;
            }
            if (z) {
                insertItem$default(this, FeedAction.Favor, "已收藏", 2131231633, (int) 4294948626L, null, 16, null);
            } else {
                insertItem$default(this, FeedAction.Favor, "收藏", 2131231213, 0, null, 24, null);
            }
        }
        if (!z4) {
            if (this.data.getEnableModify() == 1 && areEqual) {
                insertItem$default(this, FeedAction.Edit, "编辑", 2131231284, 0, null, 24, null);
            }
            if (this.data.getIsModified() == 1) {
                insertItem$default(this, FeedAction.EditHistory, "编辑历史", 2131231359, 0, null, 24, null);
            }
        }
        if (areEqual || loginSession.isAdmin()) {
            insertItem$default(this, FeedAction.Delete, "删除", 2131231252, 0, null, 24, null);
        }
        if (!z4 && !areEqual) {
            insertItem$default(this, FeedAction.Report, "举报", 2131231657, 0, null, 24, null);
        }
        return wrapAsSheetGroup();
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetCallback
    public SheetResult onSheetClick(SheetAction sheetAction) {
        String str;
        String str2;
        int i;
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        if (!(sheetAction instanceof FeedAction)) {
            return SheetResult.Companion.getNothing();
        }
        Feed feed = this.data;
        String str3 = "";
        switch (WhenMappings.$EnumSwitchMapping$0[((FeedAction) sheetAction).ordinal()]) {
            case 1:
                return SheetResult.Companion.replace$default(SheetResult.Companion, CollectionsKt.mutableListOf(new FeedCopySheetGroupFactory(this.data, this.activity).create()), false, 2, null);
            case 2:
                if (!TextUtils.isEmpty(feed.getEditorTitle())) {
                    str = feed.getEditorTitle();
                } else {
                    str = !TextUtils.isEmpty(feed.getMessageTitle()) ? feed.getMessageTitle() : str3;
                }
                if (!TextUtils.isEmpty(str)) {
                    str2 = str;
                } else {
                    String textFromUlr = StringUtils.getTextFromUlr(feed.getMessage());
                    if (textFromUlr.length() < 60) {
                        i = textFromUlr.length();
                    } else {
                        i = textFromUlr.length() / 2;
                    }
                    Intrinsics.checkNotNullExpressionValue(textFromUlr, "message");
                    Objects.requireNonNull(textFromUlr, "null cannot be cast to non-null type java.lang.String");
                    str2 = textFromUlr.substring(0, i);
                    Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                FeedTitleEditDialog.Companion companion = FeedTitleEditDialog.Companion;
                String id = feed.getId();
                Intrinsics.checkNotNull(id);
                Intrinsics.checkNotNullExpressionValue(id, "feed.id!!");
                FeedTitleEditDialog newInstance = companion.newInstance(id, "编辑标题", str != null ? str : str3, str2 != null ? str2 : str3, new FeedUserSheetGroupFactory$onSheetClick$dialog$1(feed));
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
                break;
            case 3:
                ActionManager.startCollectionSelectActivity(this.activity, feed.getId(), feed.getEntityType());
                break;
            case 4:
                String id2 = feed.getId();
                Intrinsics.checkNotNull(id2);
                Intrinsics.checkNotNullExpressionValue(id2, "feed.id!!");
                ActionManager.startWebViewActivity(this.activity, UriUtils.buildFeedReportUrl(id2));
                break;
            case 5:
                new FeedItemDialog.SecondEditActionItem(this.activity, feed).takeAction();
                break;
            case 6:
                String string = this.activity.getString(2131886784);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str….str_dialog_delete_title)");
                ConfirmDeleteDialog newInstance2 = ConfirmDeleteDialog.newInstance(string, "删除 " + feed.getUserName() + " 的" + feed.getFeedTypeName() + "： " + feed.getMessage());
                newInstance2.setDeleteTarget(feed);
                FragmentManager supportFragmentManager2 = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "activity.requireAppCompa…().supportFragmentManager");
                newInstance2.show(supportFragmentManager2, (String) null);
                break;
            case 7:
                ActionManager.startForwardEntityActivity(this.activity, feed);
                break;
            case 8:
                ActionManagerCompat actionManagerCompat = ActionManagerCompat.INSTANCE;
                Activity activity2 = this.activity;
                String id3 = feed.getId();
                if (id3 != null) {
                    str3 = id3;
                }
                actionManagerCompat.startFeedHistoryListActivity(activity2, str3);
                break;
            case 9:
                ActionManager.startGoodsListSelectActivity(this.activity, feed.getExtraKey(), str3);
                break;
            case 10:
                handleCensor();
                break;
        }
        return SheetResult.Companion.getClose();
    }

    private final SheetGroup wrapAsSheetGroup() {
        return new SheetGroup(SheetGroupType.FeedUser, this.dataList);
    }

    static /* synthetic */ void insertItem$default(FeedUserSheetGroupFactory feedUserSheetGroupFactory, FeedAction feedAction, String str, int i, int i2, String str2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = feedUserSheetGroupFactory.userItemColor;
        }
        if ((i3 & 16) != 0) {
            str2 = "";
        }
        feedUserSheetGroupFactory.insertItem(feedAction, str, i, i2, str2);
    }

    private final void insertItem(FeedAction feedAction, String str, int i, int i2, String str2) {
        this.dataList.add(new SheetDataItem(feedAction, str, SheetDataItem.Companion.createIconBgApplyer(i, i2, this.bgColor), this, str2, 0, false, false, 224, null));
    }

    private final void handleCensor() {
        boolean contains = ArraysKt.contains(new int[]{-20, -22}, this.data.getStatus());
        boolean z = this.data.getStatus() == -21;
        if (!contains || z) {
            AppHolder.getMainThreadHandler().postDelayed(FeedUserSheetGroupFactory$handleCensor$1.INSTANCE, ((long) (new Random().nextInt(2) + 1)) * 1000);
        } else {
            DataManager.getInstance().feedCensor(this.data.getId()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new FeedUserSheetGroupFactory$handleCensor$2(this));
        }
    }
}
