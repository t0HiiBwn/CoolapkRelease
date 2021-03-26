package com.coolapk.market.view.feed.dialog;

import android.app.Activity;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/DefaultSheetGroupListFactory;", "Lcom/coolapk/market/view/feed/dialog/SheetGroupListFactory;", "", "()V", "createSheetGroupListFor", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "data", "activity", "Landroid/app/Activity;", "options", "Lcom/coolapk/market/view/feed/dialog/SheetFactoryOptions;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SheetGroupListFactory.kt */
public final class DefaultSheetGroupListFactory implements SheetGroupListFactory<Object> {
    public static final DefaultSheetGroupListFactory INSTANCE = new DefaultSheetGroupListFactory();

    private DefaultSheetGroupListFactory() {
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetGroupListFactory
    public List<SheetGroup> createSheetGroupListFor(Object obj, Activity activity, SheetFactoryOptions sheetFactoryOptions) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(obj, "data");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sheetFactoryOptions, "options");
        if (obj instanceof Feed) {
            arrayList = FeedSheetGroupListFactory.INSTANCE.createSheetGroupListFor((Feed) obj, activity, sheetFactoryOptions);
        } else if (obj instanceof Album) {
            arrayList = AlbumSheetGroupListFactory.INSTANCE.createSheetGroupListFor((Album) obj, activity, sheetFactoryOptions);
        } else if (obj instanceof FeedReply) {
            arrayList = ReplySheetGroupListFactory.INSTANCE.createSheetGroupListFor((FeedReply) obj, activity, sheetFactoryOptions);
        } else {
            arrayList = new ArrayList();
        }
        if (sheetFactoryOptions.getApplyModifier()) {
            SheetGroupModifierManager.INSTANCE.applySheetGroup(obj, activity, arrayList);
        }
        return arrayList;
    }
}
