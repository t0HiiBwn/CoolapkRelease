package com.coolapk.market.view.block;

import android.app.Activity;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupModifier;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import com.coolapk.market.view.feed.dialog.feed.FeedUserSheetGroupFactory;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/block/FeedBlockSpamInterceptor;", "Lcom/coolapk/market/view/feed/dialog/SheetGroupModifier;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "modifySheet", "", "data", "", "items", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedBlockSpamInterceptor.kt */
public abstract class FeedBlockSpamInterceptor implements SheetGroupModifier {
    private final Activity activity;

    public FeedBlockSpamInterceptor(Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
    public boolean shouldModify(Object obj, Activity activity2) {
        Intrinsics.checkNotNullParameter(obj, "data");
        return SheetGroupModifier.DefaultImpls.shouldModify(this, obj, activity2);
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
    public void modifySheet(Object obj, List<SheetGroup> list) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(obj, "data");
        Intrinsics.checkNotNullParameter(list, "items");
        SheetGroupModifier.DefaultImpls.modifySheet(this, obj, list);
        int colorInt = ResourceUtils.getColorInt(this.activity, 2131100049);
        int resolveData = ResourceUtils.resolveData(this.activity, 2130969438);
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (t.getType() == SheetGroupType.FeedUser) {
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
            Iterator<SheetDataItem> it3 = t2.getItems().iterator();
            int i = 0;
            while (true) {
                if (!it3.hasNext()) {
                    i = -1;
                    break;
                }
                if (it3.next().getSheetAction() == FeedUserSheetGroupFactory.FeedAction.Report) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                t2.getItems().add(i, new SheetDataItem(SheetGroupModifier.Action.One, "屏蔽", SheetDataItem.Companion.createIconBgApplyer(2131231302, resolveData, colorInt), new FeedBlockSpamInterceptor$modifySheet$$inlined$also$lambda$1(this, resolveData, colorInt, obj), null, 0, false, false, 240, null));
            }
        }
    }
}
