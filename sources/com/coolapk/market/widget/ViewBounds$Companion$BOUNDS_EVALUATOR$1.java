package com.coolapk.market.widget;

import android.animation.IntEvaluator;
import android.animation.TypeEvaluator;
import com.coolapk.market.widget.ViewBounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"com/coolapk/market/widget/ViewBounds$Companion$BOUNDS_EVALUATOR$1", "Landroid/animation/TypeEvaluator;", "Lcom/coolapk/market/widget/ViewBounds;", "evaluator", "Landroid/animation/IntEvaluator;", "evaluate", "fraction", "", "startValue", "endValue", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewBounds.kt */
public final class ViewBounds$Companion$BOUNDS_EVALUATOR$1 implements TypeEvaluator<ViewBounds> {
    private final IntEvaluator evaluator = new IntEvaluator();

    ViewBounds$Companion$BOUNDS_EVALUATOR$1() {
    }

    public ViewBounds evaluate(float f, ViewBounds viewBounds, ViewBounds viewBounds2) {
        Intrinsics.checkNotNullParameter(viewBounds, "startValue");
        Intrinsics.checkNotNullParameter(viewBounds2, "endValue");
        ViewBounds acquire$default = ViewBounds.Companion.acquire$default(ViewBounds.Companion, null, 1, null);
        Integer evaluate = this.evaluator.evaluate(f, Integer.valueOf(viewBounds.getLeftMargin()), Integer.valueOf(viewBounds2.getLeftMargin()));
        Intrinsics.checkNotNullExpressionValue(evaluate, "evaluator.evaluate(fract…gin, endValue.leftMargin)");
        acquire$default.setLeftMargin(evaluate.intValue());
        Integer evaluate2 = this.evaluator.evaluate(f, Integer.valueOf(viewBounds.getTopMargin()), Integer.valueOf(viewBounds2.getTopMargin()));
        Intrinsics.checkNotNullExpressionValue(evaluate2, "evaluator.evaluate(fract…rgin, endValue.topMargin)");
        acquire$default.setTopMargin(evaluate2.intValue());
        Integer evaluate3 = this.evaluator.evaluate(f, Integer.valueOf(viewBounds.getWidth()), Integer.valueOf(viewBounds2.getWidth()));
        Intrinsics.checkNotNullExpressionValue(evaluate3, "evaluator.evaluate(fract…ue.width, endValue.width)");
        acquire$default.setWidth(evaluate3.intValue());
        Integer evaluate4 = this.evaluator.evaluate(f, Integer.valueOf(viewBounds.getHeight()), Integer.valueOf(viewBounds2.getHeight()));
        Intrinsics.checkNotNullExpressionValue(evaluate4, "evaluator.evaluate(fract….height, endValue.height)");
        acquire$default.setHeight(evaluate4.intValue());
        return acquire$default;
    }
}
