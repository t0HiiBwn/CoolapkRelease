package com.android.example.text.styling.roundedbg;

import android.graphics.Canvas;
import android.text.Layout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b \u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0003H\u0004J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0003H\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/android/example/text/styling/roundedbg/TextRoundedBgRenderer;", "", "horizontalPadding", "", "verticalPadding", "(II)V", "getHorizontalPadding", "()I", "getVerticalPadding", "draw", "", "canvas", "Landroid/graphics/Canvas;", "layout", "Landroid/text/Layout;", "startLine", "endLine", "startOffset", "endOffset", "getLineBottom", "line", "getLineTop", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextRoundedBgRenderer.kt */
public abstract class TextRoundedBgRenderer {
    private final int horizontalPadding;
    private final int verticalPadding;

    public abstract void draw(Canvas canvas, Layout layout, int i, int i2, int i3, int i4);

    public TextRoundedBgRenderer(int i, int i2) {
        this.horizontalPadding = i;
        this.verticalPadding = i2;
    }

    public final int getHorizontalPadding() {
        return this.horizontalPadding;
    }

    public final int getVerticalPadding() {
        return this.verticalPadding;
    }

    protected final int getLineTop(Layout layout, int i) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        return LayoutExtensionsKt.getLineTopWithoutPadding(layout, i) - this.verticalPadding;
    }

    protected final int getLineBottom(Layout layout, int i) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        return LayoutExtensionsKt.getLineBottomWithoutPadding(layout, i) + this.verticalPadding;
    }
}
