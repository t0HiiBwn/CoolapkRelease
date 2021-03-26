package com.coolapk.market.view.feed.dialog.feed;

import android.app.Activity;
import android.text.TextUtils;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.FeedUtils;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import com.coolapk.market.view.feed.dialog.feed.FeedAdminBaseSheetGroupFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J2\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminHeadlineSheetGroupFactory;", "Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminBaseSheetGroupFactory;", "data", "Lcom/coolapk/market/model/Feed;", "activity", "Landroid/app/Activity;", "(Lcom/coolapk/market/model/Feed;Landroid/app/Activity;)V", "dataList", "", "Lcom/coolapk/market/view/feed/dialog/SheetDataItem;", "create", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "insertItem", "", "action", "Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminBaseSheetGroupFactory$AdminAction;", "title", "", "iconRes", "", "tintColor", "bandageText", "wrapAsSheetGroup", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedAdminHeadlineSheetGroupFactory.kt */
public final class FeedAdminHeadlineSheetGroupFactory extends FeedAdminBaseSheetGroupFactory {
    public static final Companion Companion = new Companion(null);
    private static final int GREEN_COLOR = -15233209;
    private static final int RED_COLOR = -769226;
    private final List<SheetDataItem> dataList = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedAdminHeadlineSheetGroupFactory(Feed feed, Activity activity) {
        super(feed, activity);
        Intrinsics.checkNotNullParameter(feed, "data");
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminHeadlineSheetGroupFactory$Companion;", "", "()V", "GREEN_COLOR", "", "RED_COLOR", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedAdminHeadlineSheetGroupFactory.kt */
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
        if (!isEditorChoice()) {
            if (isHeadline()) {
                insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.Headline, "下头条", 2131231683, -769226, null, 16, null);
            } else {
                insertItem(FeedAdminBaseSheetGroupFactory.AdminAction.Headline, "上头条", 2131231552, -15233209, isHeadlined() ? "已上过" : "");
            }
        }
        if (isEditorChoice()) {
            insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.EditorChoice, "下编辑精选", 2131231516, -769226, null, 16, null);
        } else {
            insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.EditorChoice, "上编辑精选", 2131231305, -15233209, null, 16, null);
        }
        if (TextUtils.isEmpty(getFeed().getSpamReason())) {
            if (isRecommend()) {
                insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.Recommend, "下推荐", 2131231684, -769226, null, 16, null);
            } else {
                insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.Recommend, "上推荐", 2131231553, -15233209, null, 16, null);
            }
        }
        if (isRecommendOrNormal()) {
            insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.NoHeadlineAnyMore, "禁止上头条", 2131231388, -769226, null, 16, null);
        }
        if (FeedUtils.isCommentType(getFeed().getFeedType())) {
            if (isPYHeadline()) {
                insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.PYHeadline, "下PY头条", 2131231509, -769226, null, 16, null);
            } else {
                insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.PYHeadline, "PY头条", 2131231509, -15233209, null, 16, null);
            }
            if (isEditorChoice()) {
                insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.PYEditorChoice, "下PY精选", 2131231508, -769226, null, 16, null);
            } else {
                insertItem$default(this, FeedAdminBaseSheetGroupFactory.AdminAction.PYEditorChoice, "PY精选", 2131231508, -15233209, null, 16, null);
            }
        }
        return wrapAsSheetGroup();
    }

    private final SheetGroup wrapAsSheetGroup() {
        return new SheetGroup(SheetGroupType.SecondPage, this.dataList);
    }

    static /* synthetic */ void insertItem$default(FeedAdminHeadlineSheetGroupFactory feedAdminHeadlineSheetGroupFactory, FeedAdminBaseSheetGroupFactory.AdminAction adminAction, String str, int i, int i2, String str2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str2 = "";
        }
        feedAdminHeadlineSheetGroupFactory.insertItem(adminAction, str, i, i2, str2);
    }

    private final void insertItem(FeedAdminBaseSheetGroupFactory.AdminAction adminAction, String str, int i, int i2, String str2) {
        this.dataList.add(new SheetDataItem(adminAction, str, SheetDataItem.Companion.create36dpIconApplyer(i, i2), this, str2, 2, false, false, 192, null));
    }
}
