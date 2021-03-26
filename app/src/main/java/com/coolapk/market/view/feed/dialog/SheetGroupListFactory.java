package com.coolapk.market.view.feed.dialog;

import android.app.Activity;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J+\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/SheetGroupListFactory;", "T", "", "createSheetGroupListFor", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "data", "activity", "Landroid/app/Activity;", "options", "Lcom/coolapk/market/view/feed/dialog/SheetFactoryOptions;", "(Ljava/lang/Object;Landroid/app/Activity;Lcom/coolapk/market/view/feed/dialog/SheetFactoryOptions;)Ljava/util/List;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SheetGroupListFactory.kt */
public interface SheetGroupListFactory<T> {
    List<SheetGroup> createSheetGroupListFor(T t, Activity activity, SheetFactoryOptions sheetFactoryOptions);
}
