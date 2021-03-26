package com.coolapk.market.view.node.prodcut;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/node/prodcut/SubscriptSpan;", "Landroid/text/style/MetricAffectingSpan;", "ratio", "", "(F)V", "updateDrawState", "", "paint", "Landroid/text/TextPaint;", "updateMeasureState", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SubscriptSpan.kt */
public final class SubscriptSpan extends MetricAffectingSpan {
    private float ratio;

    public SubscriptSpan() {
        this(0.0f, 1, null);
    }

    public SubscriptSpan(float f) {
        this.ratio = f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptSpan(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.5f : f);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        textPaint.baselineShift -= (int) (textPaint.ascent() * this.ratio);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        textPaint.baselineShift -= (int) (textPaint.ascent() * this.ratio);
    }
}
