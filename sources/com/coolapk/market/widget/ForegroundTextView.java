package com.coolapk.market.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0015J0\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0014J\u0018\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R0\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0016@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/coolapk/market/widget/ForegroundTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "blockPadding", "", "blockSize", "blockTextLayout", "Ljava/util/HashMap;", "", "Landroid/text/StaticLayout;", "Lkotlin/collections/HashMap;", "minBlockSize", "paint", "Landroid/text/TextPaint;", "textAlpha", "", "textColor", "value", "", "textList", "getTextList", "()Ljava/util/List;", "setTextList", "(Ljava/util/List;)V", "textRotate", "textSize", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ForegroundTextView.kt */
public final class ForegroundTextView extends View {
    private final int blockPadding;
    private int blockSize;
    private final HashMap<String, StaticLayout> blockTextLayout;
    private final int minBlockSize;
    private final TextPaint paint;
    private final float textAlpha;
    private final int textColor;
    private List<String> textList;
    private final float textRotate;
    private final float textSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ForegroundTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        int textColorPrimary = AppHolder.getAppTheme().isDarkTheme() ? -1 : AppHolder.getAppTheme().getTextColorPrimary();
        this.textColor = textColorPrimary;
        this.textRotate = -20.0f;
        float f = AppHolder.getAppTheme().isDarkTheme() ? 0.13f : 0.08f;
        this.textAlpha = f;
        float dpf = NumberExtendsKt.getDpf((Number) 16);
        this.textSize = dpf;
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(dpf);
        textPaint.setColor(textColorPrimary);
        textPaint.setTextAlign(Paint.Align.CENTER);
        Unit unit = Unit.INSTANCE;
        this.paint = textPaint;
        this.textList = CollectionsKt.mutableListOf("没有内容", "@兵定二丢兵定二丢兵定二丢兵定二丢");
        int dp = NumberExtendsKt.getDp((Number) 110);
        this.minBlockSize = dp;
        this.blockSize = dp;
        this.blockPadding = NumberExtendsKt.getDp((Number) 8);
        this.blockTextLayout = new HashMap<>();
        setAlpha(f);
    }

    public final List<String> getTextList() {
        return this.textList;
    }

    public final void setTextList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.textList = list;
        this.blockTextLayout.clear();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.minBlockSize;
        this.blockSize = i3 + ((size % i3) / (size / i3));
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.blockTextLayout.clear();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int ceil = (int) Math.ceil(((double) getWidth()) / ((double) this.blockSize));
        int ceil2 = (int) Math.ceil(((double) getHeight()) / ((double) this.blockSize));
        for (int i = 0; i < ceil; i++) {
            for (int i2 = 0; i2 < ceil2; i2++) {
                int save = canvas.save();
                List<String> list = this.textList;
                String str = list.get((i + i2) % list.size());
                int i3 = this.blockSize;
                canvas.translate((((float) i) + 0.5f) * ((float) i3), (((float) i2) + 0.5f) * ((float) i3));
                HashMap<String, StaticLayout> hashMap = this.blockTextLayout;
                StaticLayout staticLayout = hashMap.get(str);
                if (staticLayout == null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        staticLayout = StaticLayout.Builder.obtain(str, 0, str.length(), this.paint, this.blockSize - (this.blockPadding * 2)).build();
                    } else {
                        staticLayout = new StaticLayout(str, this.paint, this.blockSize - (this.blockPadding * 2), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                    }
                    Intrinsics.checkNotNullExpressionValue(staticLayout, "if (Build.VERSION.SDK_IN…ue)\n                    }");
                    hashMap.put(str, staticLayout);
                }
                StaticLayout staticLayout2 = staticLayout;
                canvas.translate(0.0f, -((((float) staticLayout2.getHeight()) / 2.0f) - ((float) ((this.paint.getFontMetricsInt().bottom + this.paint.getFontMetricsInt().top) / 2))));
                canvas.rotate(this.textRotate);
                staticLayout2.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
    }
}
