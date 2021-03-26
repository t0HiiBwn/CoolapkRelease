package com.android.example.text.styling.roundedbg;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Annotation;
import android.text.Layout;
import android.text.Spanned;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/android/example/text/styling/roundedbg/TextRoundedBgHelper;", "", "horizontalPadding", "", "verticalPadding", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableLeft", "drawableMid", "drawableRight", "(IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "getHorizontalPadding", "()I", "multiLineRenderer", "Lcom/android/example/text/styling/roundedbg/TextRoundedBgRenderer;", "getMultiLineRenderer", "()Lcom/android/example/text/styling/roundedbg/TextRoundedBgRenderer;", "multiLineRenderer$delegate", "Lkotlin/Lazy;", "singleLineRenderer", "getSingleLineRenderer", "singleLineRenderer$delegate", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "Landroid/text/Spanned;", "layout", "Landroid/text/Layout;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextRoundedBgHelper.kt */
public final class TextRoundedBgHelper {
    private final int horizontalPadding;
    private final Lazy multiLineRenderer$delegate;
    private final Lazy singleLineRenderer$delegate;

    private final TextRoundedBgRenderer getMultiLineRenderer() {
        return (TextRoundedBgRenderer) this.multiLineRenderer$delegate.getValue();
    }

    private final TextRoundedBgRenderer getSingleLineRenderer() {
        return (TextRoundedBgRenderer) this.singleLineRenderer$delegate.getValue();
    }

    public TextRoundedBgHelper(int i, int i2, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(drawable2, "drawableLeft");
        Intrinsics.checkNotNullParameter(drawable3, "drawableMid");
        Intrinsics.checkNotNullParameter(drawable4, "drawableRight");
        this.horizontalPadding = i;
        this.singleLineRenderer$delegate = LazyKt.lazy(new TextRoundedBgHelper$singleLineRenderer$2(this, i2, drawable));
        this.multiLineRenderer$delegate = LazyKt.lazy(new TextRoundedBgHelper$multiLineRenderer$2(this, i2, drawable2, drawable3, drawable4));
    }

    public final int getHorizontalPadding() {
        return this.horizontalPadding;
    }

    public final void draw(Canvas canvas, Spanned spanned, Layout layout) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(spanned, "text");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Annotation[] annotationArr = (Annotation[]) spanned.getSpans(0, spanned.length(), Annotation.class);
        Intrinsics.checkNotNullExpressionValue(annotationArr, "spans");
        for (Annotation annotation : annotationArr) {
            Intrinsics.checkNotNullExpressionValue(annotation, "span");
            if (annotation.getValue().equals("rounded")) {
                int spanStart = spanned.getSpanStart(annotation);
                int spanEnd = spanned.getSpanEnd(annotation);
                int lineForOffset = layout.getLineForOffset(spanStart);
                int lineForOffset2 = layout.getLineForOffset(spanEnd);
                (lineForOffset == lineForOffset2 ? getSingleLineRenderer() : getMultiLineRenderer()).draw(canvas, layout, lineForOffset, lineForOffset2, (int) (layout.getPrimaryHorizontal(spanStart) + ((float) (layout.getParagraphDirection(lineForOffset) * -1 * this.horizontalPadding))), (int) (layout.getPrimaryHorizontal(spanEnd) + ((float) (layout.getParagraphDirection(lineForOffset2) * this.horizontalPadding))));
            }
        }
    }
}
