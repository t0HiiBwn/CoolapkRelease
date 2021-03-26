package com.coolapk.market.view.feed.dialog.album;

import android.app.Activity;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.view.data.dialog.album.AlbumAdminBaseSheetGroupFactory;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetDataKt;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J<\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/album/AlbumAdminQuickSheetGroupFactory;", "Lcom/coolapk/market/view/data/dialog/album/AlbumAdminBaseSheetGroupFactory;", "data", "Lcom/coolapk/market/model/Album;", "activity", "Landroid/app/Activity;", "(Lcom/coolapk/market/model/Album;Landroid/app/Activity;)V", "dataList", "", "Lcom/coolapk/market/view/feed/dialog/SheetDataItem;", "create", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "insertItem", "", "action", "Lcom/coolapk/market/view/data/dialog/album/AlbumAdminBaseSheetGroupFactory$AdminAction;", "title", "", "iconRes", "", "iconTintColor", "bandageText", "rightDivider", "", "wrapAsSheetGroup", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumAdminQuickSheetGroupFactory.kt */
public final class AlbumAdminQuickSheetGroupFactory extends AlbumAdminBaseSheetGroupFactory {
    public static final Companion Companion = new Companion(null);
    private static final int GREEN_COLOR = -15233209;
    private static final int RED_COLOR = -1233878;
    private final List<SheetDataItem> dataList = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlbumAdminQuickSheetGroupFactory(Album album, Activity activity) {
        super(album, activity);
        Intrinsics.checkNotNullParameter(album, "data");
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/album/AlbumAdminQuickSheetGroupFactory$Companion;", "", "()V", "GREEN_COLOR", "", "RED_COLOR", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumAdminQuickSheetGroupFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.data.dialog.album.AlbumAdminBaseSheetGroupFactory
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
                insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.Headline, "下头条", 2131231672, -1233878, "", false, 32, null);
            } else {
                insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.Headline, "上头条", 2131231541, -15233209, "", false, 32, null);
            }
        }
        if (isEditorChoice()) {
            insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.EditorChoice, "下编辑精选", 2131231505, -1233878, null, false, 48, null);
        } else {
            insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.EditorChoice, "上编辑精选", 2131231294, -15233209, null, false, 48, null);
        }
        SheetDataKt.makeLastItemDivider(this.dataList);
        if (isRecommendOrNormal()) {
            insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.NoHeadlineAnyMore, "禁止上头条", 2131231377, -1233878, null, false, 48, null);
        }
        if (isFolded()) {
            insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.Fold, "取消折叠", 2131231624, -15233209, null, false, 48, null);
        } else {
            insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.Fold, "折叠", 2131231302, -1233878, null, false, 48, null);
        }
        insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.SoftFold, "去精", 2131231505, -1233878, null, false, 48, null);
        if (!isBanned()) {
            insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.Ban, "手动屏蔽", 2131231554, -1233878, null, false, 48, null);
        } else {
            insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.Ban, "解除屏蔽", 2131231554, -15233209, null, false, 48, null);
        }
        if (isSelfVisible()) {
            insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.SelfVisible, "全站可见", 2131231351, -15233209, null, false, 48, null);
        } else {
            insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.SelfVisible, "仅自己可见", 2131231351, -1233878, null, false, 48, null);
        }
        SheetDataKt.makeLastItemDivider(this.dataList);
        if (isRecommend()) {
            insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.Recommend, "下推荐", 2131231673, -1233878, null, false, 48, null);
        } else {
            insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.Recommend, "上推荐", 2131231542, -15233209, null, false, 48, null);
        }
        insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.ViewFeedStatus, "查看状态", 2131231590, -15233209, null, false, 48, null);
        insertItem$default(this, AlbumAdminBaseSheetGroupFactory.AdminAction.Author, "作者管理", 2131231671, -15233209, null, false, 48, null);
        return wrapAsSheetGroup();
    }

    private final SheetGroup wrapAsSheetGroup() {
        return new SheetGroup(SheetGroupType.AlbumQuickAdmin, this.dataList);
    }

    static /* synthetic */ void insertItem$default(AlbumAdminQuickSheetGroupFactory albumAdminQuickSheetGroupFactory, AlbumAdminBaseSheetGroupFactory.AdminAction adminAction, String str, int i, int i2, String str2, boolean z, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str2 = "";
        }
        albumAdminQuickSheetGroupFactory.insertItem(adminAction, str, i, i2, str2, (i3 & 32) != 0 ? false : z);
    }

    private final void insertItem(AlbumAdminBaseSheetGroupFactory.AdminAction adminAction, String str, int i, int i2, String str2, boolean z) {
        this.dataList.add(new SheetDataItem(adminAction, str, SheetDataItem.Companion.createIconBgApplyer(i, i2, ColorUtils.adjustAlpha(i2, 0.1f)), this, str2, 0, z, false, 160, null));
    }
}
