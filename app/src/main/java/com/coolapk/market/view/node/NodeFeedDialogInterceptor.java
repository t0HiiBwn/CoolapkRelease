package com.coolapk.market.view.node;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupModifier;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import com.coolapk.market.view.feed.dialog.feed.FeedCategorySheetGroupFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

/* compiled from: NodeFeedDialogInterceptor.kt */
public final class NodeFeedDialogInterceptor implements SheetGroupModifier {
    private final int GREEN_COLOR;
    private final int RED_COLOR;
    private final Activity activity;
    private final int bgColor;
    private final String nodeId;
    private final String nodeType;
    private final boolean showTopOnly;
    private final List<String> topIds;
    private final int userItemColor;

    public NodeFeedDialogInterceptor(Activity activity2, List<String> list, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(list, "topIds");
        Intrinsics.checkNotNullParameter(str, "nodeType");
        Intrinsics.checkNotNullParameter(str2, "nodeId");
        this.activity = activity2;
        this.topIds = list;
        this.nodeType = str;
        this.nodeId = str2;
        this.showTopOnly = z;
        this.GREEN_COLOR = (int) 4279734087L;
        this.RED_COLOR = (int) 4294198070L;
        this.bgColor = ResourceUtils.getColorInt(activity2, 2131100049);
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NodeFeedDialogInterceptor(Activity activity2, List list, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity2, list, str, str2, (i & 16) != 0 ? false : z);
    }

    public final String getNodeId() {
        return this.nodeId;
    }

    public final boolean getShowTopOnly() {
        return this.showTopOnly;
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
    public boolean shouldModify(Object obj, Activity activity2) {
        Intrinsics.checkNotNullParameter(obj, "data");
        return Intrinsics.areEqual(activity2, this.activity) && (obj instanceof Feed);
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
    public void modifySheet(Object obj, List<SheetGroup> list) {
        T t;
        boolean z;
        T t2;
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(obj, "data");
        Intrinsics.checkNotNullParameter(list, "items");
        T t3 = null;
        if (this.showTopOnly) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                T next = it2.next();
                if (next.getType() == SheetGroupType.FeedUser) {
                    z4 = true;
                    continue;
                } else {
                    z4 = false;
                    continue;
                }
                if (z4) {
                    t3 = next;
                    break;
                }
            }
            T t4 = t3;
            if (t4 != null) {
                t4.getItems().add(0, buildFeedUserTopItem(obj));
                return;
            }
            return;
        }
        List<SheetGroup> list2 = list;
        Iterator<T> it3 = list2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                t = null;
                break;
            }
            t = it3.next();
            if (t.getType() == SheetGroupType.FeedAdminCategory) {
                z3 = true;
                continue;
            } else {
                z3 = false;
                continue;
            }
            if (z3) {
                break;
            }
        }
        T t5 = t;
        if (t5 != null) {
            Iterator<T> it4 = t5.getItems().iterator();
            while (true) {
                if (!it4.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it4.next();
                if (t2.getSheetAction() == FeedCategorySheetGroupFactory.CategoryAction.Node) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            if (t2 == null) {
                Iterator<SheetDataItem> it5 = t5.getItems().iterator();
                int i = 0;
                while (true) {
                    if (!it5.hasNext()) {
                        i = -1;
                        break;
                    }
                    if (it5.next().getSheetAction() == FeedCategorySheetGroupFactory.CategoryAction.Headline) {
                        break;
                    }
                    i++;
                }
                t5.getItems().add(i + 1, buildSheetDataItem(obj));
            }
        }
        Iterator<T> it6 = list2.iterator();
        while (true) {
            if (!it6.hasNext()) {
                break;
            }
            T next2 = it6.next();
            if (next2.getType() == SheetGroupType.NodeSecondPage) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t3 = next2;
                break;
            }
        }
        T t6 = t3;
        if (t6 != null) {
            t6.getItems().addAll(0, ((SheetGroup) CollectionsKt.first((List<? extends Object>) buildChildSheetItems(obj))).getItems());
        }
    }

    private final SheetDataItem buildSheetDataItem(Object obj) {
        return new SheetDataItem(FeedCategorySheetGroupFactory.CategoryAction.Node, "节点相关", SheetDataItem.Companion.createIconBgApplyer(2131231493, -1, (int) 4279213400L), new NodeFeedDialogInterceptor$buildSheetDataItem$1(this, obj), null, 0, false, true, 112, null);
    }

    public final List<SheetGroup> buildChildSheetItems(Object obj) {
        if (obj instanceof Feed) {
            ArrayList arrayList = new ArrayList();
            List<String> list = this.topIds;
            String id = ((Feed) obj).getId();
            if (id == null) {
                id = "";
            }
            boolean contains = list.contains(id);
            NodeFeedDialogInterceptor$buildChildSheetItems$callback$1 nodeFeedDialogInterceptor$buildChildSheetItems$callback$1 = new NodeFeedDialogInterceptor$buildChildSheetItems$callback$1(this, contains, obj);
            if (contains) {
                arrayList.add(new SheetDataItem(SheetGroupModifier.Action.One, "取消置顶", SheetDataItem.Companion.create36dpIconApplyer(2131231295, this.RED_COLOR), nodeFeedDialogInterceptor$buildChildSheetItems$callback$1, null, 0, false, false, 240, null));
            } else {
                arrayList.add(new SheetDataItem(SheetGroupModifier.Action.One, "Feed置顶", SheetDataItem.Companion.create36dpIconApplyer(2131231295, this.GREEN_COLOR), nodeFeedDialogInterceptor$buildChildSheetItems$callback$1, null, 0, false, false, 240, null));
            }
            if (!this.showTopOnly) {
                arrayList.add(new SheetDataItem(SheetGroupModifier.Action.Two, "单行置顶", SheetDataItem.Companion.create36dpIconApplyer(2131231523, this.GREEN_COLOR), new NodeFeedDialogInterceptor$buildChildSheetItems$1(this, obj), null, 0, false, false, 240, null));
            }
            return CollectionsKt.mutableListOf(new SheetGroup(SheetGroupType.SecondPage, arrayList));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final SheetDataItem buildFeedUserTopItem(Object obj) {
        if (obj instanceof Feed) {
            List<String> list = this.topIds;
            String id = ((Feed) obj).getId();
            if (id == null) {
                id = "";
            }
            boolean contains = list.contains(id);
            NodeFeedDialogInterceptor$buildFeedUserTopItem$callback$1 nodeFeedDialogInterceptor$buildFeedUserTopItem$callback$1 = new NodeFeedDialogInterceptor$buildFeedUserTopItem$callback$1(this, contains, obj);
            if (contains) {
                return new SheetDataItem(SheetGroupModifier.Action.Three, "取消置顶", SheetDataItem.Companion.createIconBgApplyer(2131231626, this.userItemColor, this.bgColor), nodeFeedDialogInterceptor$buildFeedUserTopItem$callback$1, null, 0, false, false, 240, null);
            }
            return new SheetDataItem(SheetGroupModifier.Action.Three, "置顶", SheetDataItem.Companion.createIconBgApplyer(2131231615, this.userItemColor, this.bgColor), nodeFeedDialogInterceptor$buildFeedUserTopItem$callback$1, null, 0, false, false, 240, null);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void checkAndShowSetFeedTopHint(boolean z, Feed feed) {
        if (z || !(!this.topIds.isEmpty())) {
            setFeedToNodeTop(z, feed);
            return;
        }
        AlertDialog create = new AlertDialog.Builder(this.activity).setMessage("已经存在Feed置顶，是否用当前动态替换旧的置顶动态?").setPositiveButton("确定", new NodeFeedDialogInterceptor$checkAndShowSetFeedTopHint$1(this, z, feed)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
    }

    public final void setFeedToNodeTop(boolean z, Feed feed) {
        String id = feed.getId();
        if (id == null) {
            id = "";
        }
        if (z) {
            DataManager.getInstance().cancelTopFromNode(this.nodeType, this.nodeId, id).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new NodeFeedDialogInterceptor$setFeedToNodeTop$1(this, id, feed));
        } else {
            DataManager.getInstance().addTopToNode(this.nodeType, this.nodeId, id).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new NodeFeedDialogInterceptor$setFeedToNodeTop$2(this, id, feed));
        }
    }

    public final void setTopFeedToContentTop(Feed feed) {
        String id = feed.getId();
        if (id == null) {
            id = "";
        }
        DialogUtil.showCenterEditTextDialog$default(DialogUtil.INSTANCE, this.activity, "", "", "请输入置顶标题", new NodeFeedDialogInterceptor$setTopFeedToContentTop$1(this, id), null, 32, null);
    }
}
