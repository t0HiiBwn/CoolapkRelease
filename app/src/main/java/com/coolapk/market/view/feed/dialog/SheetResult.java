package com.coolapk.market.view.feed.dialog;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/SheetResult;", "", "()V", "Companion", "Lcom/coolapk/market/view/feed/dialog/SheetResultNothing;", "Lcom/coolapk/market/view/feed/dialog/SheetResultClose;", "Lcom/coolapk/market/view/feed/dialog/SheetResultReplace;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SheetData.kt */
public abstract class SheetResult {
    private static final SheetResultClose Close = SheetResultClose.INSTANCE;
    public static final Companion Companion = new Companion(null);
    private static final SheetResultNothing Nothing = SheetResultNothing.INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/SheetResult$Companion;", "", "()V", "Close", "Lcom/coolapk/market/view/feed/dialog/SheetResultClose;", "getClose", "()Lcom/coolapk/market/view/feed/dialog/SheetResultClose;", "Nothing", "Lcom/coolapk/market/view/feed/dialog/SheetResultNothing;", "getNothing", "()Lcom/coolapk/market/view/feed/dialog/SheetResultNothing;", "replace", "Lcom/coolapk/market/view/feed/dialog/SheetResultReplace;", "sheetGroupList", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "backToTop", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SheetData.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SheetResultClose getClose() {
            return SheetResult.Close;
        }

        public final SheetResultNothing getNothing() {
            return SheetResult.Nothing;
        }

        public static /* synthetic */ SheetResultReplace replace$default(Companion companion, List list, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            return companion.replace(list, z);
        }

        public final SheetResultReplace replace(List<SheetGroup> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, "sheetGroupList");
            return new SheetResultReplace(list, z);
        }
    }

    private SheetResult() {
    }

    public /* synthetic */ SheetResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
