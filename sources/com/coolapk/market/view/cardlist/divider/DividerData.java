package com.coolapk.market.view.cardlist.divider;

import androidx.core.util.Pools;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VXDividerDecoration.kt */
public final class DividerData {
    public static final Companion Companion = new Companion(null);
    private static final DividerData EMPTY = new DividerData(0, 0, 0, null, false, 11, null);
    private static final DividerData H10DP = new DividerData(0, 0, NumberExtendsKt.getDp((Number) 10), null, false, 11, null);
    private static final DividerData H12DP = new DividerData(0, 0, NumberExtendsKt.getDp((Number) 12), null, false, 11, null);
    private static final DividerData H16DP = new DividerData(0, 0, NumberExtendsKt.getDp((Number) 16), null, false, 11, null);
    private static final DividerData H18DP = new DividerData(0, 0, NumberExtendsKt.getDp((Number) 18), null, false, 11, null);
    private static final DividerData H1DP;
    private static final DividerData H24DP = new DividerData(0, 0, NumberExtendsKt.getDp((Number) 24), null, false, 11, null);
    private static final DividerData H64DP = new DividerData(0, 0, NumberExtendsKt.getDp((Number) 64), null, false, 11, null);
    public static final DividerData H8DP = new DividerData(0, 0, NumberExtendsKt.getDp((Number) 8), null, false, 11, null);
    private static final DividerData L44H1DP;
    private static final DividerData LR12H1DP;
    private static final DividerData LR16H1DP;
    private static final Pools.SimplePool<DividerData> POOLS = new Pools.SimplePool<>(40);
    private Integer color;
    private int height;
    private int leftMargin;
    private final boolean mutable;
    private int rightMargin;

    private DividerData(int i, int i2, int i3, Integer num, boolean z) {
        this.mutable = z;
        this.leftMargin = i;
        this.rightMargin = i2;
        this.height = i3;
        this.color = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ DividerData(int i, int i2, int i3, Integer num, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) == 0 ? i3 : 0, (i4 & 8) != 0 ? null : num, (i4 & 16) != 0 ? true : z);
    }

    public /* synthetic */ DividerData(int i, int i2, int i3, Integer num, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, num, z);
    }

    /* compiled from: VXDividerDecoration.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DividerData getEMPTY() {
            return DividerData.EMPTY;
        }

        public final DividerData getH1DP() {
            return DividerData.H1DP;
        }

        public final DividerData getH10DP() {
            return DividerData.H10DP;
        }

        public final DividerData getH12DP() {
            return DividerData.H12DP;
        }

        public final DividerData getH16DP() {
            return DividerData.H16DP;
        }

        public final DividerData getH18DP() {
            return DividerData.H18DP;
        }

        public final DividerData getH24DP() {
            return DividerData.H24DP;
        }

        public final DividerData getL44H1DP() {
            return DividerData.L44H1DP;
        }

        public final DividerData getLR16H1DP() {
            return DividerData.LR16H1DP;
        }

        public final DividerData getLR12H1DP() {
            return DividerData.LR12H1DP;
        }

        public final DividerData getH64DP() {
            return DividerData.H64DP;
        }

        public static /* synthetic */ DividerData createImmutable$default(Companion companion, int i, int i2, int i3, Integer num, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = 0;
            }
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = 0;
            }
            if ((i4 & 8) != 0) {
                num = null;
            }
            return companion.createImmutable(i, i2, i3, num);
        }

        public final DividerData createImmutable(int i, int i2, int i3, Integer num) {
            return new DividerData(i, i2, i3, num, false, null);
        }

        public static /* synthetic */ DividerData obtain$default(Companion companion, int i, int i2, int i3, Integer num, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = 0;
            }
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = 0;
            }
            if ((i4 & 8) != 0) {
                num = null;
            }
            return companion.obtain(i, i2, i3, num);
        }

        public final DividerData obtain(int i, int i2, int i3, Integer num) {
            DividerData dividerData = (DividerData) DividerData.POOLS.acquire();
            if (dividerData == null) {
                dividerData = new DividerData(0, 0, 0, null, false, 31, null);
            }
            Intrinsics.checkNotNullExpressionValue(dividerData, "(POOLS.acquire() ?: DividerData())");
            dividerData.leftMargin = i;
            dividerData.rightMargin = i2;
            dividerData.height = i3;
            dividerData.color = num;
            return dividerData;
        }

        public final void recycle(DividerData dividerData) {
            Intrinsics.checkNotNullParameter(dividerData, "data");
            if (dividerData.mutable) {
                dividerData.reset();
                DividerData.POOLS.release(dividerData);
            }
        }
    }

    static {
        Double valueOf = Double.valueOf(0.5d);
        H1DP = new DividerData(0, 0, NumberExtendsKt.getDp(valueOf), null, false, 11, null);
        L44H1DP = new DividerData(NumberExtendsKt.getDp((Number) 44), 0, NumberExtendsKt.getDp(valueOf), null, false, 10, null);
        LR16H1DP = new DividerData(NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp(valueOf), null, false, 8, null);
        LR12H1DP = new DividerData(NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp(valueOf), null, false, 8, null);
    }

    public final int getLeftMargin() {
        return this.leftMargin;
    }

    public final int getRightMargin() {
        return this.rightMargin;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final DividerData toImmutable() {
        return this.mutable ? Companion.createImmutable$default(Companion, this.leftMargin, this.rightMargin, this.height, null, 8, null) : this;
    }

    public final void recycle() {
        Companion.recycle(this);
    }

    public final void reset() {
        if (this.mutable) {
            this.leftMargin = 0;
            this.rightMargin = 0;
            this.height = 0;
            this.color = null;
            return;
        }
        throw new IllegalStateException("unmutable DividerData");
    }
}
