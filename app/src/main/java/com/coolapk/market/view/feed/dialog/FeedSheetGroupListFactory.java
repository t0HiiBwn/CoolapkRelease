package com.coolapk.market.view.feed.dialog;

import android.app.Activity;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.feed.dialog.feed.FeedAdminQuickSheetGroupFactory;
import com.coolapk.market.view.feed.dialog.feed.FeedCategorySheetGroupFactory;
import com.coolapk.market.view.feed.dialog.feed.FeedUserSheetGroupFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/FeedSheetGroupListFactory;", "Lcom/coolapk/market/view/feed/dialog/SheetGroupListFactory;", "Lcom/coolapk/market/model/Feed;", "()V", "createSheetGroupListFor", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "data", "activity", "Landroid/app/Activity;", "options", "Lcom/coolapk/market/view/feed/dialog/SheetFactoryOptions;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleSheetGroupListFactory.kt */
public final class FeedSheetGroupListFactory implements SheetGroupListFactory<Feed> {
    public static final FeedSheetGroupListFactory INSTANCE = new FeedSheetGroupListFactory();

    private FeedSheetGroupListFactory() {
    }

    public List<SheetGroup> createSheetGroupListFor(Feed feed, Activity activity, SheetFactoryOptions sheetFactoryOptions) {
        Intrinsics.checkNotNullParameter(feed, "data");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sheetFactoryOptions, "options");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        List<SheetGroup> mutableListOf = CollectionsKt.mutableListOf(new FeedUserSheetGroupFactory(feed, activity).create());
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (loginSession.isAdmin()) {
            mutableListOf.add(new FeedAdminQuickSheetGroupFactory(feed, activity).create());
            mutableListOf.add(new FeedCategorySheetGroupFactory(feed, activity).create());
        } else {
            mutableListOf.add(new ShareSheetGroupFactory(feed, activity).create());
        }
        return mutableListOf;
    }
}
