package com.android.example.text.styling.roundedbg;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ8\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J0\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J0\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/android/example/text/styling/roundedbg/MultiLineRenderer;", "Lcom/android/example/text/styling/roundedbg/TextRoundedBgRenderer;", "horizontalPadding", "", "verticalPadding", "drawableLeft", "Landroid/graphics/drawable/Drawable;", "drawableMid", "drawableRight", "(IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "getDrawableLeft", "()Landroid/graphics/drawable/Drawable;", "getDrawableMid", "getDrawableRight", "draw", "", "canvas", "Landroid/graphics/Canvas;", "layout", "Landroid/text/Layout;", "startLine", "endLine", "startOffset", "endOffset", "drawEnd", "start", "top", "end", "bottom", "drawStart", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextRoundedBgRenderer.kt */
public final class MultiLineRenderer extends TextRoundedBgRenderer {
    private final Drawable drawableLeft;
    private final Drawable drawableMid;
    private final Drawable drawableRight;

    public final Drawable getDrawableLeft() {
        return this.drawableLeft;
    }

    public final Drawable getDrawableMid() {
        return this.drawableMid;
    }

    public final Drawable getDrawableRight() {
        return this.drawableRight;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiLineRenderer(int i, int i2, Drawable drawable, Drawable drawable2, Drawable drawable3) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(drawable, "drawableLeft");
        Intrinsics.checkNotNullParameter(drawable2, "drawableMid");
        Intrinsics.checkNotNullParameter(drawable3, "drawableRight");
        this.drawableLeft = drawable;
        this.drawableMid = drawable2;
        this.drawableRight = drawable3;
    }

    @Override // com.android.example.text.styling.roundedbg.TextRoundedBgRenderer
    public void draw(Canvas canvas, Layout layout, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(layout, "layout");
        int paragraphDirection = layout.getParagraphDirection(i);
        if (paragraphDirection == -1) {
            f = layout.getLineLeft(i) - ((float) getHorizontalPadding());
        } else {
            f = layout.getLineRight(i) + ((float) getHorizontalPadding());
        }
        int lineBottom = getLineBottom(layout, i);
        drawStart(canvas, i3, getLineTop(layout, i), (int) f, lineBottom);
        for (int i5 = i + 1; i5 < i2; i5++) {
            this.drawableMid.setBounds(((int) layout.getLineLeft(i5)) - getHorizontalPadding(), getLineTop(layout, i5), ((int) layout.getLineRight(i5)) + getHorizontalPadding(), getLineBottom(layout, i5));
            this.drawableMid.draw(canvas);
        }
        if (paragraphDirection == -1) {
            f2 = layout.getLineRight(i) + ((float) getHorizontalPadding());
        } else {
            f2 = layout.getLineLeft(i) - ((float) getHorizontalPadding());
        }
        drawEnd(canvas, (int) f2, getLineTop(layout, i2), i4, getLineBottom(layout, i2));
    }

    private final void drawStart(Canvas canvas, int i, int i2, int i3, int i4) {
        if (i > i3) {
            this.drawableRight.setBounds(i3, i2, i, i4);
            this.drawableRight.draw(canvas);
            return;
        }
        this.drawableLeft.setBounds(i, i2, i3, i4);
        this.drawableLeft.draw(canvas);
    }

    private final void drawEnd(Canvas canvas, int i, int i2, int i3, int i4) {
        if (i > i3) {
            this.drawableLeft.setBounds(i3, i2, i, i4);
            this.drawableLeft.draw(canvas);
            return;
        }
        this.drawableRight.setBounds(i, i2, i3, i4);
        this.drawableRight.draw(canvas);
    }
}
