package com.coolapk.market.view.feed.dialog.feed;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.feed.dialog.SheetAction;
import com.coolapk.market.view.feed.dialog.SheetCallback;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import com.coolapk.market.view.feed.dialog.SheetResult;
import com.coolapk.market.view.feed.dialog.album.AlbumCopySheetGroupFactory;
import com.coolapk.market.view.feed.post.ConfirmDeleteDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0002J4\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/AlbumUserSheetGroupFactory;", "Lcom/coolapk/market/view/feed/dialog/SheetCallback;", "data", "Lcom/coolapk/market/model/Album;", "activity", "Landroid/app/Activity;", "(Lcom/coolapk/market/model/Album;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "bgColor", "", "getData", "()Lcom/coolapk/market/model/Album;", "dataList", "", "Lcom/coolapk/market/view/feed/dialog/SheetDataItem;", "userItemColor", "create", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "handleCensor", "", "insertItem", "action", "Lcom/coolapk/market/view/feed/dialog/feed/AlbumUserSheetGroupFactory$AlbumAction;", "title", "", "resource", "iconTintColor", "bandageText", "onSheetClick", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "wrapAsSheetGroup", "AlbumAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumUserSheetGroupFactory.kt */
public final class AlbumUserSheetGroupFactory implements SheetCallback {
    private final Activity activity;
    private final int bgColor;
    private final Album data;
    private final List<SheetDataItem> dataList = new ArrayList();
    private final int userItemColor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/feed/AlbumUserSheetGroupFactory$AlbumAction;", "", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "(Ljava/lang/String;I)V", "Copy", "Favor", "Report", "Delete", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumUserSheetGroupFactory.kt */
    public enum AlbumAction implements SheetAction {
        Copy,
        Favor,
        Report,
        Delete
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AlbumAction.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AlbumAction.Copy.ordinal()] = 1;
            iArr[AlbumAction.Favor.ordinal()] = 2;
            iArr[AlbumAction.Report.ordinal()] = 3;
            iArr[AlbumAction.Delete.ordinal()] = 4;
        }
    }

    public AlbumUserSheetGroupFactory(Album album, Activity activity2) {
        Intrinsics.checkNotNullParameter(album, "data");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.data = album;
        this.activity = activity2;
        this.bgColor = ResourceUtils.getColorInt(activity2, 2131100049);
        this.userItemColor = ResourceUtils.resolveData(activity2, 2130969438);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Album getData() {
        return this.data;
    }

    public final SheetGroup create() {
        boolean z = true;
        if (!this.dataList.isEmpty()) {
            return wrapAsSheetGroup();
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        String uid = this.data.getUid();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        boolean areEqual = Intrinsics.areEqual(uid, loginSession.getUid());
        insertItem$default(this, AlbumAction.Copy, "复制", 2131231233, 0, null, 24, null);
        UserAction userAction = this.data.getUserAction();
        if ((userAction != null ? userAction.getFavorite() : 0) <= 0) {
            z = false;
        }
        if (z) {
            insertItem$default(this, AlbumAction.Favor, "已收藏", 2131231622, (int) 4294948626L, null, 16, null);
        } else {
            insertItem$default(this, AlbumAction.Favor, "收藏", 2131231202, 0, null, 24, null);
        }
        if (areEqual || loginSession.isAdmin()) {
            insertItem$default(this, AlbumAction.Delete, "删除", 2131231241, 0, null, 24, null);
        }
        if (!areEqual) {
            insertItem$default(this, AlbumAction.Report, "举报", 2131231646, 0, null, 24, null);
        }
        return wrapAsSheetGroup();
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetCallback
    public SheetResult onSheetClick(SheetAction sheetAction) {
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        if (!(sheetAction instanceof AlbumAction)) {
            return SheetResult.Companion.getNothing();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[((AlbumAction) sheetAction).ordinal()];
        if (i == 1) {
            return SheetResult.Companion.replace$default(SheetResult.Companion, CollectionsKt.mutableListOf(new AlbumCopySheetGroupFactory(this.data, this.activity).create()), false, 2, null);
        }
        if (i == 2) {
            ActionManager.startCollectionSelectActivity(this.activity, this.data.getId(), this.data.getEntityType());
        } else if (i == 3) {
            Activity activity2 = this.activity;
            String id = this.data.getId();
            if (id == null) {
                id = "";
            }
            ActionManager.startWebViewActivity(activity2, UriUtils.buildFeedReportUrl(id));
        } else if (i == 4) {
            String string = this.activity.getString(2131886722);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str….str_dialog_delete_title)");
            ConfirmDeleteDialog newInstance = ConfirmDeleteDialog.newInstance(string, "删除 " + this.data.getUserName() + " 的应用集： " + this.data.getIntroduce());
            newInstance.setDeleteTarget(this.data);
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
        }
        return SheetResult.Companion.getClose();
    }

    private final SheetGroup wrapAsSheetGroup() {
        return new SheetGroup(SheetGroupType.AlbumUser, this.dataList);
    }

    static /* synthetic */ void insertItem$default(AlbumUserSheetGroupFactory albumUserSheetGroupFactory, AlbumAction albumAction, String str, int i, int i2, String str2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = albumUserSheetGroupFactory.userItemColor;
        }
        if ((i3 & 16) != 0) {
            str2 = "";
        }
        albumUserSheetGroupFactory.insertItem(albumAction, str, i, i2, str2);
    }

    private final void insertItem(AlbumAction albumAction, String str, int i, int i2, String str2) {
        this.dataList.add(new SheetDataItem(albumAction, str, SheetDataItem.Companion.createIconBgApplyer(i, i2, this.bgColor), this, str2, 0, false, false, 224, null));
    }

    private final void handleCensor() {
        boolean contains = ArraysKt.contains(new int[]{-20, -22}, this.data.getStatus());
        boolean z = this.data.getStatus() == -21;
        if (!contains || z) {
            AppHolder.getMainThreadHandler().postDelayed(AlbumUserSheetGroupFactory$handleCensor$1.INSTANCE, ((long) (new Random().nextInt(2) + 1)) * 1000);
        } else {
            DataManager.getInstance().feedCensor(this.data.getId()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new AlbumUserSheetGroupFactory$handleCensor$2(this));
        }
    }
}
