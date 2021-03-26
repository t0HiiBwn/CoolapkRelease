package com.coolapk.market.view.feed.dialog;

import android.app.Activity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/SheetGroupModifier;", "", "modifySheet", "", "data", "items", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "shouldModify", "", "anchorActivity", "Landroid/app/Activity;", "Action", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SheetGroupListFactory.kt */
public interface SheetGroupModifier {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/SheetGroupModifier$Action;", "", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "(Ljava/lang/String;I)V", "One", "Two", "Three", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SheetGroupListFactory.kt */
    public enum Action implements SheetAction {
        One,
        Two,
        Three
    }

    void modifySheet(Object obj, List<SheetGroup> list);

    boolean shouldModify(Object obj, Activity activity);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* compiled from: SheetGroupListFactory.kt */
    public static final class DefaultImpls {
        public static void modifySheet(SheetGroupModifier sheetGroupModifier, Object obj, List<SheetGroup> list) {
            Intrinsics.checkNotNullParameter(obj, "data");
            Intrinsics.checkNotNullParameter(list, "items");
        }

        public static boolean shouldModify(SheetGroupModifier sheetGroupModifier, Object obj, Activity activity) {
            Intrinsics.checkNotNullParameter(obj, "data");
            return false;
        }

        public static /* synthetic */ boolean shouldModify$default(SheetGroupModifier sheetGroupModifier, Object obj, Activity activity, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 2) != 0) {
                    activity = null;
                }
                return sheetGroupModifier.shouldModify(obj, activity);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shouldModify");
        }
    }
}
