package com.coolapk.market.view.node;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupModifier;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0005H\u0016J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001a\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/node/AlbumUserSpaceSheetModifier;", "Lcom/coolapk/market/view/feed/dialog/SheetGroupModifier;", "activity", "Landroid/app/Activity;", "topIds", "", "", "nodeType", "nodeId", "(Landroid/app/Activity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getActivity", "()Landroid/app/Activity;", "bgColor", "", "getNodeId", "()Ljava/lang/String;", "getNodeType", "getTopIds", "()Ljava/util/List;", "userItemColor", "buildTopItem", "Lcom/coolapk/market/view/feed/dialog/SheetDataItem;", "data", "", "checkAndShowSetFeedTopHint", "", "oldValue", "", "feed", "Lcom/coolapk/market/model/Album;", "modifySheet", "items", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "setFeedToNodeTop", "shouldModify", "anchorActivity", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumUserSpaceSheetModifier.kt */
public final class AlbumUserSpaceSheetModifier implements SheetGroupModifier {
    private final Activity activity;
    private final int bgColor;
    private final String nodeId;
    private final String nodeType;
    private final List<String> topIds;
    private final int userItemColor;

    public AlbumUserSpaceSheetModifier(Activity activity2, List<String> list, String str, String str2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(list, "topIds");
        Intrinsics.checkNotNullParameter(str, "nodeType");
        Intrinsics.checkNotNullParameter(str2, "nodeId");
        this.activity = activity2;
        this.topIds = list;
        this.nodeType = str;
        this.nodeId = str2;
        this.bgColor = ResourceUtils.getColorInt(activity2, 2131100054);
        this.userItemColor = ResourceUtils.resolveData(activity2, 2130969438);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final String getNodeType() {
        return this.nodeType;
    }

    public final List<String> getTopIds() {
        return this.topIds;
    }

    public final String getNodeId() {
        return this.nodeId;
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
    public boolean shouldModify(Object obj, Activity activity2) {
        Intrinsics.checkNotNullParameter(obj, "data");
        return (obj instanceof Album) && Intrinsics.areEqual(activity2, this.activity);
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
    public void modifySheet(Object obj, List<SheetGroup> list) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(obj, "data");
        Intrinsics.checkNotNullParameter(list, "items");
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (t.getType() == SheetGroupType.AlbumUser) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            t2.getItems().add(0, buildTopItem(obj));
        }
    }

    private final SheetDataItem buildTopItem(Object obj) {
        if (obj instanceof Album) {
            List<String> list = this.topIds;
            String id = ((Album) obj).getId();
            if (id == null) {
                id = "";
            }
            boolean contains = list.contains(id);
            AlbumUserSpaceSheetModifier$buildTopItem$callback$1 albumUserSpaceSheetModifier$buildTopItem$callback$1 = new AlbumUserSpaceSheetModifier$buildTopItem$callback$1(this, contains, obj);
            if (contains) {
                return new SheetDataItem(SheetGroupModifier.Action.Three, "取消置顶", SheetDataItem.Companion.createIconBgApplyer(2131231637, this.userItemColor, this.bgColor), albumUserSpaceSheetModifier$buildTopItem$callback$1, null, 0, false, false, 240, null);
            }
            return new SheetDataItem(SheetGroupModifier.Action.Three, "置顶", SheetDataItem.Companion.createIconBgApplyer(2131231626, this.userItemColor, this.bgColor), albumUserSpaceSheetModifier$buildTopItem$callback$1, null, 0, false, false, 240, null);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* access modifiers changed from: private */
    public final void checkAndShowSetFeedTopHint(boolean z, Album album) {
        if (z || !(!this.topIds.isEmpty())) {
            setFeedToNodeTop(z, album);
            return;
        }
        AlertDialog create = new AlertDialog.Builder(this.activity).setMessage("已经存在置顶内容，是否用当前应用集替换旧的置顶内容?").setPositiveButton("确定", new AlbumUserSpaceSheetModifier$checkAndShowSetFeedTopHint$1(this, z, album)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
    }

    /* access modifiers changed from: private */
    public final void setFeedToNodeTop(boolean z, Album album) {
        String id = album.getId();
        if (id == null) {
            id = "";
        }
        if (z) {
            DataManager.getInstance().cancelTopFromNode(this.nodeType, this.nodeId, id).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new AlbumUserSpaceSheetModifier$setFeedToNodeTop$1(this, id, album));
        } else {
            DataManager.getInstance().addTopToNode(this.nodeType, this.nodeId, id).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new AlbumUserSpaceSheetModifier$setFeedToNodeTop$2(this, id, album));
        }
    }
}
