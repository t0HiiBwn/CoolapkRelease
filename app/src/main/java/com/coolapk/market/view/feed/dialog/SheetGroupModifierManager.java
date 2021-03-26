package com.coolapk.market.view.feed.dialog;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J$\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/SheetGroupModifierManager;", "", "()V", "globalModifiers", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroupModifier;", "addModifier", "", "interceptor", "applySheetGroup", "data", "activity", "Landroid/app/Activity;", "items", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "removeModifier", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SheetGroupListFactory.kt */
public final class SheetGroupModifierManager {
    public static final SheetGroupModifierManager INSTANCE = new SheetGroupModifierManager();
    private static final List<SheetGroupModifier> globalModifiers = new ArrayList();

    private SheetGroupModifierManager() {
    }

    public final void addModifier(SheetGroupModifier sheetGroupModifier) {
        Intrinsics.checkNotNullParameter(sheetGroupModifier, "interceptor");
        globalModifiers.add(sheetGroupModifier);
    }

    public final void removeModifier(SheetGroupModifier sheetGroupModifier) {
        Intrinsics.checkNotNullParameter(sheetGroupModifier, "interceptor");
        globalModifiers.remove(sheetGroupModifier);
    }

    public final void applySheetGroup(Object obj, Activity activity, List<SheetGroup> list) {
        Intrinsics.checkNotNullParameter(obj, "data");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(list, "items");
        for (T t : globalModifiers) {
            if (t.shouldModify(obj, activity)) {
                t.modifySheet(obj, list);
            }
        }
    }
}
