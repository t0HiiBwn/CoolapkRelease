package com.android.example.text.styling.roundedbg;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Spanned;
import android.util.AttributeSet;
import com.coolapk.market.view.danmaku.OutlineTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/example/text/styling/roundedbg/RoundedBgTextView;", "Lcom/coolapk/market/view/danmaku/OutlineTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textRoundedBgHelper", "Lcom/android/example/text/styling/roundedbg/TextRoundedBgHelper;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RoundedBgTextView.kt */
public class RoundedBgTextView extends OutlineTextView {
    private final TextRoundedBgHelper textRoundedBgHelper;

    public RoundedBgTextView(Context context) {
        this(context, null, 0, 6, null);
    }

    public RoundedBgTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RoundedBgTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 16842884 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundedBgTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TextRoundedBgAttributeReader textRoundedBgAttributeReader = new TextRoundedBgAttributeReader(context, attributeSet);
        this.textRoundedBgHelper = new TextRoundedBgHelper(textRoundedBgAttributeReader.getHorizontalPadding(), textRoundedBgAttributeReader.getVerticalPadding(), textRoundedBgAttributeReader.getDrawable(), textRoundedBgAttributeReader.getDrawableLeft(), textRoundedBgAttributeReader.getDrawableMid(), textRoundedBgAttributeReader.getDrawableRight());
    }

    @Override // com.coolapk.market.view.danmaku.OutlineTextView, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if ((getText() instanceof Spanned) && getLayout() != null) {
            int save = canvas.save();
            canvas.translate((float) getTotalPaddingLeft(), (float) getTotalPaddingTop());
            try {
                TextRoundedBgHelper textRoundedBgHelper2 = this.textRoundedBgHelper;
                CharSequence text = getText();
                if (text != null) {
                    Layout layout = getLayout();
                    Intrinsics.checkNotNullExpressionValue(layout, "layout");
                    textRoundedBgHelper2.draw(canvas, (Spanned) text, layout);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.text.Spanned");
                }
            } finally {
                canvas.restoreToCount(save);
            }
        }
        super.onDraw(canvas);
    }
}
