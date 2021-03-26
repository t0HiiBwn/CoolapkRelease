package com.coolapk.market.view.feed.dialog.feed;

import android.app.Activity;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.feed.dialog.SheetAction;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupModifierManager;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import com.coolapk.market.view.feed.dialog.SheetResult;
import com.coolapk.market.view.feed.goods.FeedBindGoodsHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J*\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/FeedCategorySheetGroupFactory;", "Lcom/coolapk/market/view/feed/dialog/feed/FeedAdminBaseSheetGroupFactory;", "data", "Lcom/coolapk/market/model/Feed;", "activity", "Landroid/app/Activity;", "(Lcom/coolapk/market/model/Feed;Landroid/app/Activity;)V", "dataList", "", "Lcom/coolapk/market/view/feed/dialog/SheetDataItem;", "create", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "insertItem", "", "action", "Lcom/coolapk/market/view/feed/dialog/feed/FeedCategorySheetGroupFactory$CategoryAction;", "title", "", "resource", "", "secondPageHint", "", "onSheetClick", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "wrapAsSheetGroup", "CategoryAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedCategorySheetGroupFactory.kt */
public final class FeedCategorySheetGroupFactory extends FeedAdminBaseSheetGroupFactory {
    private final List<SheetDataItem> dataList = new ArrayList();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/FeedCategorySheetGroupFactory$CategoryAction;", "", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "(Ljava/lang/String;I)V", "Review", "Fold", "Headline", "Node", "Author", "BindGoods", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedCategorySheetGroupFactory.kt */
    public enum CategoryAction implements SheetAction {
        Review,
        Fold,
        Headline,
        Node,
        Author,
        BindGoods
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CategoryAction.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CategoryAction.Review.ordinal()] = 1;
            iArr[CategoryAction.Fold.ordinal()] = 2;
            iArr[CategoryAction.Headline.ordinal()] = 3;
            iArr[CategoryAction.Node.ordinal()] = 4;
            iArr[CategoryAction.Author.ordinal()] = 5;
            iArr[CategoryAction.BindGoods.ordinal()] = 6;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedCategorySheetGroupFactory(Feed feed, Activity activity) {
        super(feed, activity);
        Intrinsics.checkNotNullParameter(feed, "data");
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.coolapk.market.view.feed.dialog.feed.FeedAdminBaseSheetGroupFactory
    public SheetGroup create() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        if (!(!this.dataList.isEmpty())) {
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            if (loginSession.isAdmin()) {
                if (isMachineBlocked()) {
                    insertItem(CategoryAction.Review, "审核", 2131231531, true);
                }
                insertItem(CategoryAction.Fold, "折叠", 2131231694, true);
                insertItem(CategoryAction.Headline, "头条", 2131231353, true);
                if (isNodeFeed()) {
                    insertItem(CategoryAction.Node, "节点相关", 2131231504, true);
                }
                insertItem$default(this, CategoryAction.Author, "作者管理", 2131231682, false, 8, null);
                boolean contains = ArraysKt.contains(new String[]{"feed", "comment", "answer"}, getFeed().getFeedType());
                if (loginSession.isAdmin() && (getFeed().getIsHtmlArticle() == 1 || contains)) {
                    insertItem$default(this, CategoryAction.BindGoods, "关联好物", 2131231169, false, 8, null);
                }
                return wrapAsSheetGroup();
            }
        }
        return wrapAsSheetGroup();
    }

    @Override // com.coolapk.market.view.feed.dialog.feed.FeedAdminBaseSheetGroupFactory, com.coolapk.market.view.feed.dialog.SheetCallback
    public SheetResult onSheetClick(SheetAction sheetAction) {
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        if (!(sheetAction instanceof CategoryAction)) {
            return SheetResult.Companion.getNothing();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[((CategoryAction) sheetAction).ordinal()]) {
            case 1:
                return SheetResult.Companion.replace$default(SheetResult.Companion, CollectionsKt.mutableListOf(new FeedAdminReviewSheetGroupFactory(getData(), getActivity()).create()), false, 2, null);
            case 2:
                return SheetResult.Companion.replace$default(SheetResult.Companion, CollectionsKt.mutableListOf(new FeedAdminFoldSheetGroupFactory(getData(), getActivity()).create()), false, 2, null);
            case 3:
                return SheetResult.Companion.replace$default(SheetResult.Companion, CollectionsKt.mutableListOf(new FeedAdminHeadlineSheetGroupFactory(getData(), getActivity()).create()), false, 2, null);
            case 4:
                SheetResult.Companion companion = SheetResult.Companion;
                List<SheetGroup> mutableListOf = CollectionsKt.mutableListOf(new FeedAdminNodeSheetGroupFactory(getData(), getActivity()).create());
                SheetGroupModifierManager.INSTANCE.applySheetGroup(getData(), getActivity(), mutableListOf);
                Unit unit = Unit.INSTANCE;
                return SheetResult.Companion.replace$default(companion, mutableListOf, false, 2, null);
            case 5:
                String uid = getFeed().getUid();
                Intrinsics.checkNotNullExpressionValue(uid, "feed.uid");
                ActionManager.startWebViewActivity(getActivity(), UriUtils.getUserManageUrl(uid));
                break;
            case 6:
                FeedBindGoodsHelper.INSTANCE.showBindGoodsDialog(getActivity(), getFeed());
                break;
        }
        return SheetResult.Companion.getClose();
    }

    private final SheetGroup wrapAsSheetGroup() {
        return new SheetGroup(SheetGroupType.FeedAdminCategory, this.dataList);
    }

    static /* synthetic */ void insertItem$default(FeedCategorySheetGroupFactory feedCategorySheetGroupFactory, CategoryAction categoryAction, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        feedCategorySheetGroupFactory.insertItem(categoryAction, str, i, z);
    }

    private final void insertItem(CategoryAction categoryAction, String str, int i, boolean z) {
        this.dataList.add(new SheetDataItem(categoryAction, str, SheetDataItem.Companion.createIconBgApplyer(i, -1, (int) 4279213400L), this, null, 0, false, z, 112, null));
    }
}
