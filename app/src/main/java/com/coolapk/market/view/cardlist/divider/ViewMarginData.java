package com.coolapk.market.view.cardlist.divider;

import androidx.core.util.Pools;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B%\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0000J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0002R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/ViewMarginData;", "", "leftMargin", "", "rightMargin", "mutable", "", "(IIZ)V", "<set-?>", "getLeftMargin", "()I", "getRightMargin", "isEmpty", "mutate", "recycle", "", "reset", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleVXDividerDecoration.kt */
public final class ViewMarginData {
    public static final Companion Companion = new Companion(null);
    private static final ViewMarginData DEFAULT;
    private static final int DEFAULT_SIZE;
    private static final int DEFAULT_SIZE_RAW = 9;
    private static final ViewMarginData EMPTY = new ViewMarginData(0, 0, false);
    private static final Pools.SimplePool<ViewMarginData> POOLS = new Pools.SimplePool<>(40);
    private int leftMargin;
    private final boolean mutable;
    private int rightMargin;

    private ViewMarginData(int i, int i2, boolean z) {
        this.mutable = z;
        this.leftMargin = i;
        this.rightMargin = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ ViewMarginData(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? true : z);
    }

    public /* synthetic */ ViewMarginData(int i, int i2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, z);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bJ\u001a\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/ViewMarginData$Companion;", "", "()V", "DEFAULT", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginData;", "getDEFAULT", "()Lcom/coolapk/market/view/cardlist/divider/ViewMarginData;", "DEFAULT_SIZE", "", "getDEFAULT_SIZE", "()I", "DEFAULT_SIZE_RAW", "getDEFAULT_SIZE_RAW", "EMPTY", "getEMPTY", "POOLS", "Landroidx/core/util/Pools$SimplePool;", "createImmutable", "leftMargin", "rightMargin", "obtain", "recycle", "", "data", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SimpleVXDividerDecoration.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getDEFAULT_SIZE_RAW() {
            return ViewMarginData.DEFAULT_SIZE_RAW;
        }

        public final int getDEFAULT_SIZE() {
            return ViewMarginData.DEFAULT_SIZE;
        }

        public final ViewMarginData getEMPTY() {
            return ViewMarginData.EMPTY;
        }

        public final ViewMarginData getDEFAULT() {
            return ViewMarginData.DEFAULT;
        }

        public static /* synthetic */ ViewMarginData createImmutable$default(Companion companion, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return companion.createImmutable(i, i2);
        }

        public final ViewMarginData createImmutable(int i, int i2) {
            return new ViewMarginData(i, i2, false, null);
        }

        public static /* synthetic */ ViewMarginData obtain$default(Companion companion, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return companion.obtain(i, i2);
        }

        public final ViewMarginData obtain(int i, int i2) {
            ViewMarginData viewMarginData = (ViewMarginData) ViewMarginData.POOLS.acquire();
            if (viewMarginData == null) {
                viewMarginData = new ViewMarginData(0, 0, false, 7, null);
            }
            Intrinsics.checkNotNullExpressionValue(viewMarginData, "(POOLS.acquire() ?: ViewMarginData())");
            viewMarginData.leftMargin = i;
            viewMarginData.rightMargin = i2;
            return viewMarginData;
        }

        public final void recycle(ViewMarginData viewMarginData) {
            Intrinsics.checkNotNullParameter(viewMarginData, "data");
            if (viewMarginData.mutable) {
                viewMarginData.reset();
                ViewMarginData.POOLS.release(viewMarginData);
            }
        }
    }

    static {
        int dp = NumberExtendsKt.getDp((Number) 9);
        DEFAULT_SIZE = dp;
        DEFAULT = new ViewMarginData(dp, dp, false);
    }

    public final int getLeftMargin() {
        return this.leftMargin;
    }

    public final int getRightMargin() {
        return this.rightMargin;
    }

    public final ViewMarginData mutate() {
        if (this.mutable) {
            return this;
        }
        return Companion.obtain(this.leftMargin, this.rightMargin);
    }

    public final boolean isEmpty() {
        return this.leftMargin == 0 && this.rightMargin == 0;
    }

    public final void recycle() {
        Companion.recycle(this);
    }

    /* access modifiers changed from: private */
    public final void reset() {
        this.leftMargin = 0;
        this.rightMargin = 0;
    }
}
