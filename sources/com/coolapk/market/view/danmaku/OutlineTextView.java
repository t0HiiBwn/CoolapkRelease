package com.coolapk.market.view.danmaku;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.coolapk.market.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\tJ\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0017J\u0016\u0010\"\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0017R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/coolapk/market/view/danmaku/OutlineTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isDrawing", "", "<set-?>", "saveTextColor", "getSaveTextColor", "()I", "setSaveTextColor", "(I)V", "saveTextColor$delegate", "Lkotlin/properties/ReadWriteProperty;", "strokeColor", "strokeWidth", "", "initResources", "", "invalidate", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setPaintToOutline", "setPaintToRegular", "setStrokeColor", "color", "setStrokeWidth", "width", "unit", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OutlineTextView.kt */
public class OutlineTextView extends AppCompatTextView {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(OutlineTextView.class, "saveTextColor", "getSaveTextColor()I", 0))};
    private boolean isDrawing;
    private final ReadWriteProperty saveTextColor$delegate;
    private int strokeColor;
    private float strokeWidth;

    private final int getSaveTextColor() {
        return ((Number) this.saveTextColor$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    private final void setSaveTextColor(int i) {
        this.saveTextColor$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OutlineTextView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OutlineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutlineTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.saveTextColor$delegate = Delegates.INSTANCE.notNull();
        initResources(context, attributeSet);
    }

    private final void initResources(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OutlineTextView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.OutlineTextView)");
            this.strokeColor = obtainStyledAttributes.getColor(0, getCurrentTextColor());
            this.strokeWidth = obtainStyledAttributes.getDimension(1, 0.0f);
            obtainStyledAttributes.recycle();
        } else {
            this.strokeColor = getCurrentTextColor();
            this.strokeWidth = 0.0f;
        }
        setStrokeWidth(this.strokeWidth);
    }

    public final void setStrokeColor(int i) {
        this.strokeColor = i;
    }

    public final void setStrokeWidth(float f) {
        this.strokeWidth = f;
    }

    public final void setStrokeWidth(int i, float f) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this.strokeWidth = TypedValue.applyDimension(i, f, resources.getDisplayMetrics());
    }

    @Override // android.view.View
    public void invalidate() {
        if (!this.isDrawing) {
            super.invalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.strokeWidth > ((float) 0)) {
            this.isDrawing = true;
            setSaveTextColor(getCurrentTextColor());
            setPaintToOutline();
            super.onDraw(canvas);
            setPaintToRegular();
            super.onDraw(canvas);
            this.isDrawing = false;
            return;
        }
        super.onDraw(canvas);
    }

    private final void setPaintToOutline() {
        TextPaint paint = getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        TextPaint textPaint = paint;
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(this.strokeWidth);
        super.setTextColor(this.strokeColor);
    }

    private final void setPaintToRegular() {
        TextPaint paint = getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        TextPaint textPaint = paint;
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setStrokeWidth(0.0f);
        super.setTextColor(getSaveTextColor());
    }
}
