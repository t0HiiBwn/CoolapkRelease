package com.coolapk.market.widget.recyclerviewdivider;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: RecyclerViewDivider.kt */
final class RecyclerViewDivider$onDraw$partialDrawAfter$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.IntRef $bottom;
    final /* synthetic */ int $childLeft;
    final /* synthetic */ int $childRight;
    final /* synthetic */ Function4 $drawWithBounds;
    final /* synthetic */ int $endMargin;
    final /* synthetic */ boolean $isRTL;
    final /* synthetic */ int $lastElementInSpanSize;
    final /* synthetic */ Ref.IntRef $left;
    final /* synthetic */ Ref.IntRef $right;
    final /* synthetic */ Ref.IntRef $top;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecyclerViewDivider$onDraw$partialDrawAfter$1(boolean z, Ref.IntRef intRef, int i, int i2, Ref.IntRef intRef2, int i3, int i4, Function4 function4, Ref.IntRef intRef3, Ref.IntRef intRef4) {
        super(0);
        this.$isRTL = z;
        this.$right = intRef;
        this.$childLeft = i;
        this.$endMargin = i2;
        this.$left = intRef2;
        this.$lastElementInSpanSize = i3;
        this.$childRight = i4;
        this.$drawWithBounds = function4;
        this.$top = intRef3;
        this.$bottom = intRef4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        if (this.$isRTL) {
            this.$right.element = this.$childLeft - this.$endMargin;
            this.$left.element = this.$right.element - this.$lastElementInSpanSize;
        } else {
            this.$right.element = this.$childRight + this.$endMargin;
            this.$left.element = this.$right.element + this.$lastElementInSpanSize;
        }
        this.$drawWithBounds.invoke(Integer.valueOf(this.$left.element), Integer.valueOf(this.$top.element), Integer.valueOf(this.$right.element), Integer.valueOf(this.$bottom.element));
    }
}
