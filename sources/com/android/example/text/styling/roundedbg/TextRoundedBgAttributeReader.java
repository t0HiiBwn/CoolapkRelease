package com.android.example.text.styling.roundedbg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayKt;
import com.coolapk.market.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/android/example/text/styling/roundedbg/TextRoundedBgAttributeReader;", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "drawableLeft", "getDrawableLeft", "drawableMid", "getDrawableMid", "drawableRight", "getDrawableRight", "horizontalPadding", "", "getHorizontalPadding", "()I", "verticalPadding", "getVerticalPadding", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextRoundedBgAttributeReader.kt */
public final class TextRoundedBgAttributeReader {
    private final Drawable drawable;
    private final Drawable drawableLeft;
    private final Drawable drawableMid;
    private final Drawable drawableRight;
    private final int horizontalPadding;
    private final int verticalPadding;

    public TextRoundedBgAttributeReader(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextRoundedBgHelper, 0, 2131951955);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…undedBgTextView\n        )");
        this.horizontalPadding = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.verticalPadding = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.drawable = TypedArrayKt.getDrawableOrThrow(obtainStyledAttributes, 0);
        this.drawableLeft = TypedArrayKt.getDrawableOrThrow(obtainStyledAttributes, 1);
        this.drawableMid = TypedArrayKt.getDrawableOrThrow(obtainStyledAttributes, 2);
        this.drawableRight = TypedArrayKt.getDrawableOrThrow(obtainStyledAttributes, 3);
        obtainStyledAttributes.recycle();
    }

    public final int getHorizontalPadding() {
        return this.horizontalPadding;
    }

    public final int getVerticalPadding() {
        return this.verticalPadding;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public final Drawable getDrawableLeft() {
        return this.drawableLeft;
    }

    public final Drawable getDrawableMid() {
        return this.drawableMid;
    }

    public final Drawable getDrawableRight() {
        return this.drawableRight;
    }
}
