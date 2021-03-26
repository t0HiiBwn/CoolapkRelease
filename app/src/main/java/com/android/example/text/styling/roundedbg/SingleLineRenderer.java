package com.android.example.text.styling.roundedbg;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J8\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/android/example/text/styling/roundedbg/SingleLineRenderer;", "Lcom/android/example/text/styling/roundedbg/TextRoundedBgRenderer;", "horizontalPadding", "", "verticalPadding", "drawable", "Landroid/graphics/drawable/Drawable;", "(IILandroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "layout", "Landroid/text/Layout;", "startLine", "endLine", "startOffset", "endOffset", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextRoundedBgRenderer.kt */
public final class SingleLineRenderer extends TextRoundedBgRenderer {
    private final Drawable drawable;

    public final Drawable getDrawable() {
        return this.drawable;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleLineRenderer(int i, int i2, Drawable drawable2) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(drawable2, "drawable");
        this.drawable = drawable2;
    }

    @Override // com.android.example.text.styling.roundedbg.TextRoundedBgRenderer
    public void draw(Canvas canvas, Layout layout, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(layout, "layout");
        int lineTop = getLineTop(layout, i);
        int lineBottom = getLineBottom(layout, i);
        this.drawable.setBounds(Math.min(i3, i4), lineTop, Math.max(i3, i4), lineBottom);
        this.drawable.draw(canvas);
    }
}
