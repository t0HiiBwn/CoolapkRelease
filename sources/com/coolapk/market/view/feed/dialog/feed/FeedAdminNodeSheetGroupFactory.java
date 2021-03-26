package com.coolapk.market.view.feed.dialog.feed;

import android.app.Activity;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import com.coolapk.market.view.feed.dialog.feed.FeedAdminBaseSheetGroupFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminNodeSheetGroupFactory;", "Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminBaseSheetGroupFactory;", "data", "Lcom/coolapk/market/model/Feed;", "activity", "Landroid/app/Activity;", "(Lcom/coolapk/market/model/Feed;Landroid/app/Activity;)V", "dataList", "", "Lcom/coolapk/market/view/feed/dialog/SheetDataItem;", "create", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "insertItem", "", "action", "Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminBaseSheetGroupFactory$AdminAction;", "title", "", "iconRes", "", "tintColor", "wrapAsSheetGroup", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedAdminNodeSheetGroupFactory.kt */
public final class FeedAdminNodeSheetGroupFactory extends FeedAdminBaseSheetGroupFactory {
    public static final Companion Companion = new Companion(null);
    private static final int GREEN_COLOR = -15233209;
    private static final int RED_COLOR = -769226;
    private final List<SheetDataItem> dataList = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedAdminNodeSheetGroupFactory(Feed feed, Activity activity) {
        super(feed, activity);
        Intrinsics.checkNotNullParameter(feed, "data");
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminNodeSheetGroupFactory$Companion;", "", "()V", "GREEN_COLOR", "", "RED_COLOR", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedAdminNodeSheetGroupFactory.kt */
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
        if (isNodeFeed()) {
            insertItem(FeedAdminBaseSheetGroupFactory.AdminAction.UnlinkNode, "解除关联", 2131231376, -769226);
        }
        return wrapAsSheetGroup();
    }

    private final SheetGroup wrapAsSheetGroup() {
        return new SheetGroup(SheetGroupType.NodeSecondPage, this.dataList);
    }

    private final void insertItem(FeedAdminBaseSheetGroupFactory.AdminAction adminAction, String str, int i, int i2) {
        this.dataList.add(new SheetDataItem(adminAction, str, SheetDataItem.Companion.create36dpIconApplyer(i, i2), this, null, 0, false, false, 240, null));
    }
}
