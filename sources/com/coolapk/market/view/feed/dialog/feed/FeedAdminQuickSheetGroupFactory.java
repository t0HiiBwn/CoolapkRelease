package com.coolapk.market.view.feed.dialog.feed;

import android.app.Activity;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetDataKt;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import com.coolapk.market.view.feed.dialog.feed.FeedAdminBaseSheetGroupFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J<\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminQuickSheetGroupFactory;", "Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminBaseSheetGroupFactory;", "data", "Lcom/coolapk/market/model/Feed;", "activity", "Landroid/app/Activity;", "(Lcom/coolapk/market/model/Feed;Landroid/app/Activity;)V", "dataList", "", "Lcom/coolapk/market/view/feed/dialog/SheetDataItem;", "create", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "insertItem", "", "action", "Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminBaseSheetGroupFactory$AdminAction;", "title", "", "iconRes", "", "iconTintColor", "bandageText", "rightDivider", "", "wrapAsSheetGroup", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedAdminQuickSheetGroupFactory.kt */
public final class FeedAdminQuickSheetGroupFactory extends FeedAdminBaseSheetGroupFactory {
    public static final Companion Companion = new Companion(null);
    private static final int GREEN_COLOR = -15233209;
    private static final int RED_COLOR = -1233878;
    private final List<SheetDataItem> dataList = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedAdminQuickSheetGroupFactory(Feed feed, Activity activity) {
        super(feed, activity);
        Intrinsics.checkNotNullParameter(feed, "data");
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminQuickSheetGroupFactory$Companion;", "", "()V", "GREEN_COLOR", "", "RED_COLOR", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedAdminQuickSheetGroupFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.feed.dialog.feed.FeedAdminBaseSheetGroupFactory
    public SheetGroup create() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (!loginSession.isAdmin() || (!this.dataList.isEmpty())) {
            return wrapAsSheetGroup();
        }
        if (isVoteCommentFeed()) {
            if (isRecommendVote()) {
                insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.RecommendVote, "下精选观点", 2131231684, -1233878, null, false, 48, null);
            } else {
                insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.RecommendVote, "精选观点", 2131231553, -15233209, null, false, 48, null);
            }
        }
        if (!isEditorChoice()) {
            String str = isHeadlined() ? "已上过" : "";
            if (isHeadline()) {
                insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.Headline, "下头条", 2131231683, -1233878, str, false, 32, null);
            } else {
                insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.Headline, "上头条", 2131231552, -15233209, str, false, 32, null);
            }
        }
        SheetDataKt.makeLastItemDivider(this.dataList);
        if (isMachineBlocked()) {
            insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.MachineBlock, "通过审核", 2131231611, -15233209, null, false, 48, null);
        } else if (isFolded()) {
            insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.Fold, "取消折叠", 2131231635, -15233209, null, false, 48, null);
        } else {
            insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.Fold, "折叠", 2131231313, -1233878, null, false, 48, null);
        }
        insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.SoftFold, "去精", 2131231516, -1233878, null, false, 48, null);
        if (isHomeVisible()) {
            insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.HomeVisible, "全站可见", 2131231362, -15233209, null, false, 48, null);
        } else {
            insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.HomeVisible, "仅主页可见", 2131231362, -1233878, null, false, 48, null);
        }
        SheetDataKt.makeLastItemDivider(this.dataList);
        if (isRecommend()) {
            insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.Recommend, "下推荐", 2131231684, -1233878, null, false, 48, null);
        } else {
            insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.Recommend, "上推荐", 2131231553, -15233209, null, false, 48, null);
        }
        insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.ViewFeedStatus, "查看状态", 2131231601, -15233209, null, false, 48, null);
        return wrapAsSheetGroup();
    }

    private final SheetGroup wrapAsSheetGroup() {
        return new SheetGroup(SheetGroupType.FeedAdminQuick, this.dataList);
    }

    static /* synthetic */ void insertItem$default(FeedAdminQuickSheetGroupFactory feedAdminQuickSheetGroupFactory, FeedAdminBaseSheetGroupFactory.AdminAction adminAction, String str, int i, int i2, String str2, boolean z, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str2 = "";
        }
        feedAdminQuickSheetGroupFactory.insertItem(adminAction, str, i, i2, str2, (i3 & 32) != 0 ? false : z);
    }

    private final void insertItem(FeedAdminBaseSheetGroupFactory.AdminAction adminAction, String str, int i, int i2, String str2, boolean z) {
        this.dataList.add(new SheetDataItem(adminAction, str, SheetDataItem.Companion.createIconBgApplyer(i, i2, ColorUtils.adjustAlpha(i2, 0.1f)), this, str2, 0, z, false, 160, null));
    }
}
