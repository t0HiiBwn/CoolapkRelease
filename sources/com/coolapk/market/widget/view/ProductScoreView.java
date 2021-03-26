package com.coolapk.market.widget.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.KotlinExtendKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0014J\u0018\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0011H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\u001a\u0010\u001e\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u000e\u0010&\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R,\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000b0*0)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u00100\u001a\u00020\u000b*\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u0006:"}, d2 = {"Lcom/coolapk/market/widget/view/ProductScoreView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "graphDivider", "", "graphHeight", "graphMarginBottom", "graphMarginLeft", "graphMarginRight", "lineColor", "", "maxScore", "getMaxScore", "()I", "setMaxScore", "(I)V", "paint", "Landroid/graphics/Paint;", "rectTextWidth", "rectWidth", "scoreStep", "getScoreStep", "setScoreStep", "textColor", "getTextColor", "setTextColor", "textPaint", "Landroid/text/TextPaint;", "tintColor", "getTintColor", "setTintColor", "topDivider", "topNumHeight", "typeAndScore", "", "Lkotlin/Pair;", "", "getTypeAndScore", "()Ljava/util/List;", "setTypeAndScore", "(Ljava/util/List;)V", "sp", "getSp", "(I)F", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductScoreView.kt */
public final class ProductScoreView extends View {
    private final GradientDrawable gradientDrawable;
    private final float graphDivider;
    private final float graphHeight;
    private final float graphMarginBottom;
    private final float graphMarginLeft;
    private final float graphMarginRight;
    private final int lineColor;
    private int maxScore = 10;
    private final Paint paint;
    private float rectTextWidth;
    private final int rectWidth;
    private int scoreStep = 2;
    private int textColor;
    private final TextPaint textPaint;
    private int tintColor;
    private final float topDivider;
    private float topNumHeight;
    private List<Pair<String, Float>> typeAndScore;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductScoreView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        Float valueOf = Float.valueOf(5.0f);
        arrayList.add(new Pair("外观", valueOf));
        arrayList.add(new Pair("手感", Float.valueOf(10.0f)));
        arrayList.add(new Pair("做工", Float.valueOf(2.0f)));
        arrayList.add(new Pair("屏幕", Float.valueOf(2.2f)));
        arrayList.add(new Pair("拍照", valueOf));
        arrayList.add(new Pair("续航", Float.valueOf(6.0f)));
        arrayList.add(new Pair("系统流畅度", Float.valueOf(7.0f)));
        arrayList.add(new Pair("游戏体验", valueOf));
        arrayList.add(new Pair("UI人性化", Float.valueOf(1.5f)));
        arrayList.add(new Pair("值得买", Float.valueOf(5.8f)));
        Unit unit = Unit.INSTANCE;
        this.typeAndScore = arrayList;
        this.tintColor = AppHolder.getAppTheme().getColorAccent();
        this.textColor = AppHolder.getAppTheme().getTextColorSecondary();
        this.lineColor = (int) 4291546059L;
        this.topDivider = (float) NumberExtendsKt.getDp((Number) 8);
        this.graphHeight = (float) NumberExtendsKt.getDp((Number) 72);
        this.graphDivider = (float) NumberExtendsKt.getDp((Number) 8);
        this.rectTextWidth = (float) NumberExtendsKt.getDp((Number) 28);
        this.graphMarginRight = (float) NumberExtendsKt.getDp((Number) 8);
        this.graphMarginLeft = (float) NumberExtendsKt.getDp((Number) 18);
        this.graphMarginBottom = (float) NumberExtendsKt.getDp((Number) 6);
        this.rectWidth = NumberExtendsKt.getDp((Number) 10);
        this.textPaint = new TextPaint(1);
        this.paint = new Paint(1);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        float dp = (float) NumberExtendsKt.getDp((Number) 1);
        gradientDrawable2.setCornerRadii(new float[]{dp, dp, dp, dp, 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit2 = Unit.INSTANCE;
        this.gradientDrawable = gradientDrawable2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductScoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        Float valueOf = Float.valueOf(5.0f);
        arrayList.add(new Pair("外观", valueOf));
        arrayList.add(new Pair("手感", Float.valueOf(10.0f)));
        arrayList.add(new Pair("做工", Float.valueOf(2.0f)));
        arrayList.add(new Pair("屏幕", Float.valueOf(2.2f)));
        arrayList.add(new Pair("拍照", valueOf));
        arrayList.add(new Pair("续航", Float.valueOf(6.0f)));
        arrayList.add(new Pair("系统流畅度", Float.valueOf(7.0f)));
        arrayList.add(new Pair("游戏体验", valueOf));
        arrayList.add(new Pair("UI人性化", Float.valueOf(1.5f)));
        arrayList.add(new Pair("值得买", Float.valueOf(5.8f)));
        Unit unit = Unit.INSTANCE;
        this.typeAndScore = arrayList;
        this.tintColor = AppHolder.getAppTheme().getColorAccent();
        this.textColor = AppHolder.getAppTheme().getTextColorSecondary();
        this.lineColor = (int) 4291546059L;
        this.topDivider = (float) NumberExtendsKt.getDp((Number) 8);
        this.graphHeight = (float) NumberExtendsKt.getDp((Number) 72);
        this.graphDivider = (float) NumberExtendsKt.getDp((Number) 8);
        this.rectTextWidth = (float) NumberExtendsKt.getDp((Number) 28);
        this.graphMarginRight = (float) NumberExtendsKt.getDp((Number) 8);
        this.graphMarginLeft = (float) NumberExtendsKt.getDp((Number) 18);
        this.graphMarginBottom = (float) NumberExtendsKt.getDp((Number) 6);
        this.rectWidth = NumberExtendsKt.getDp((Number) 10);
        this.textPaint = new TextPaint(1);
        this.paint = new Paint(1);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        float dp = (float) NumberExtendsKt.getDp((Number) 1);
        gradientDrawable2.setCornerRadii(new float[]{dp, dp, dp, dp, 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit2 = Unit.INSTANCE;
        this.gradientDrawable = gradientDrawable2;
    }

    private final float getSp(int i) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return resources.getDisplayMetrics().scaledDensity * ((float) i);
    }

    public final int getMaxScore() {
        return this.maxScore;
    }

    public final void setMaxScore(int i) {
        this.maxScore = i;
    }

    public final int getScoreStep() {
        return this.scoreStep;
    }

    public final void setScoreStep(int i) {
        this.scoreStep = i;
    }

    public final List<Pair<String, Float>> getTypeAndScore() {
        return this.typeAndScore;
    }

    public final void setTypeAndScore(List<Pair<String, Float>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.typeAndScore = list;
    }

    public final int getTintColor() {
        return this.tintColor;
    }

    public final void setTintColor(int i) {
        this.tintColor = i;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(int i) {
        this.textColor = i;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.textPaint.setTextSize(getSp(10));
        this.topNumHeight = Math.abs(this.textPaint.ascent());
        int size = View.MeasureSpec.getSize(i);
        Iterator<T> it2 = this.typeAndScore.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            int height = new StaticLayout((CharSequence) it2.next().getFirst(), this.textPaint, (int) this.rectTextWidth, Layout.Alignment.ALIGN_NORMAL, 1.2f, 0.0f, false).getHeight();
            if (height > i3) {
                i3 = height;
            }
        }
        setMeasuredDimension(size, (int) (this.topNumHeight + this.topDivider + this.graphDivider + this.graphHeight + this.graphMarginBottom + ((float) i3)));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.textPaint.setTextAlign(Paint.Align.LEFT);
        this.textPaint.setTextSize(getSp(10));
        this.textPaint.setColor(this.textColor);
        float f = this.topNumHeight + this.topDivider;
        float abs = Math.abs(this.textPaint.ascent() + this.textPaint.descent()) / ((float) 2);
        int i = this.maxScore;
        int i2 = this.scoreStep;
        int i3 = (i / i2) + 1;
        float f2 = this.graphHeight / ((float) (i / i2));
        this.paint.setColor(this.lineColor);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = this.maxScore - (this.scoreStep * i4);
            float f3 = f + (((float) i4) * f2);
            if (i5 > 0) {
                canvas.drawText(String.valueOf(i5), 0.0f, f3 + abs, this.textPaint);
            }
            if (i5 >= 0) {
                canvas.drawLine(this.graphMarginLeft, f3, ((float) getWidth()) - this.graphMarginRight, f3, this.paint);
            }
        }
        float width = (((((float) getWidth()) - this.graphMarginLeft) - this.graphMarginRight) - ((float) this.rectWidth)) / ((float) (this.typeAndScore.size() - 1));
        this.paint.setColor(this.tintColor);
        this.gradientDrawable.setColor(this.tintColor);
        int i6 = 0;
        for (T t : this.typeAndScore) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            float floatValue = ((Number) t2.getSecond()).floatValue();
            float f4 = this.graphMarginLeft + (((float) i6) * width);
            int i8 = this.maxScore;
            float f5 = (((float) i8) - floatValue) / ((float) i8);
            float f6 = this.graphHeight;
            this.gradientDrawable.setBounds((int) f4, (int) ((f5 * f6) + f), (int) (((float) this.rectWidth) + f4), (int) (f6 + f));
            this.gradientDrawable.draw(canvas);
            this.textPaint.setTextAlign(Paint.Align.CENTER);
            this.textPaint.setColor(this.tintColor);
            canvas.drawText(KotlinExtendKt.format$default(Float.valueOf(floatValue), 0, 1, null), ((float) (this.rectWidth / 2)) + f4, this.topNumHeight, this.textPaint);
            this.textPaint.setColor(this.textColor);
            int save = canvas.save();
            canvas.translate(f4 + ((float) (this.rectWidth / 2)), this.graphHeight + f + abs + this.graphMarginBottom);
            new StaticLayout((CharSequence) t2.getFirst(), this.textPaint, (int) this.rectTextWidth, Layout.Alignment.ALIGN_NORMAL, 1.2f, 0.0f, false).draw(canvas);
            canvas.restoreToCount(save);
            i6 = i7;
        }
    }
}
