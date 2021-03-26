package com.coolapk.market.widget.recyclerviewdivider;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "leftB", "", "topB", "rightB", "bottomB", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: RecyclerViewDivider.kt */
final class RecyclerViewDivider$onDraw$drawWithBounds$1 extends Lambda implements Function4<Integer, Integer, Integer, Integer, Unit> {
    final /* synthetic */ Canvas $c;
    final /* synthetic */ Ref.ObjectRef $divider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecyclerViewDivider$onDraw$drawWithBounds$1(Ref.ObjectRef objectRef, Canvas canvas) {
        super(4);
        this.$divider = objectRef;
        this.$c = canvas;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3, Integer num4) {
        invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2, int i3, int i4) {
        this.$divider.element.setBounds(i, i2, i3, i4);
        this.$divider.element.draw(this.$c);
    }
}
