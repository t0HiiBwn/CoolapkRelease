package com.coolapk.market.widget.view;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import cn.lankton.flowlayout.FlowLayout;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J\u0006\u0010 \u001a\u00020\nJ\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0019H\u0002J2\u0010#\u001a\u00020\n2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0%2\u0006\u0010&\u001a\u00020\u00192\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\n\u0018\u00010(J\u0006\u0010)\u001a\u00020\nR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000e¨\u0006*"}, d2 = {"Lcom/coolapk/market/widget/view/FilterLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dismissedListener", "Lkotlin/Function0;", "", "getDismissedListener", "()Lkotlin/jvm/functions/Function0;", "setDismissedListener", "(Lkotlin/jvm/functions/Function0;)V", "flowLayout", "Lcn/lankton/flowlayout/FlowLayout;", "isAnimating", "", "onDismissListener", "getOnDismissListener", "setOnDismissListener", "createBackgroundAnimator", "Landroid/animation/ValueAnimator;", "from", "", "to", "createTextView", "Landroid/widget/TextView;", "title", "", "selected", "dismiss", "dispatchBackgroundColorListener", "color", "setFilterArgs", "titles", "", "selectedIndex", "listener", "Lkotlin/Function1;", "show", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FilterLayout.kt */
public final class FilterLayout extends FrameLayout {
    private Function0<Unit> dismissedListener;
    private FlowLayout flowLayout;
    private boolean isAnimating;
    private Function0<Unit> onDismissListener;

    public final Function0<Unit> getDismissedListener() {
        return this.dismissedListener;
    }

    public final void setDismissedListener(Function0<Unit> function0) {
        this.dismissedListener = function0;
    }

    public final Function0<Unit> getOnDismissListener() {
        return this.onDismissListener;
    }

    public final void setOnDismissListener(Function0<Unit> function0) {
        this.onDismissListener = function0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setBackgroundColor(838860800);
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.widget.view.FilterLayout.AnonymousClass1 */
            final /* synthetic */ FilterLayout this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!this.this$0.isAnimating) {
                    this.this$0.dismiss();
                }
            }
        });
        FlowLayout flowLayout2 = new FlowLayout(getContext());
        flowLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        flowLayout2.setPadding(ConvertUtils.dp2px(10.0f), ConvertUtils.dp2px(10.0f), ConvertUtils.dp2px(10.0f), ConvertUtils.dp2px(10.0f));
        flowLayout2.setElevation((float) ConvertUtils.dp2px(3.0f));
        flowLayout2.setClickable(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ColorStateList.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
        float dp2px = (float) ConvertUtils.dp2px(8.0f);
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dp2px, dp2px, dp2px, dp2px});
        Unit unit = Unit.INSTANCE;
        flowLayout2.setBackground(gradientDrawable);
        Unit unit2 = Unit.INSTANCE;
        this.flowLayout = flowLayout2;
        addView(flowLayout2);
        View view = new View(getContext());
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, ConvertUtils.dp2px(0.5f)));
        view.setElevation((float) ConvertUtils.dp2px(3.0f));
        view.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        addView(view);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setBackgroundColor(838860800);
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.widget.view.FilterLayout.AnonymousClass1 */
            final /* synthetic */ FilterLayout this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!this.this$0.isAnimating) {
                    this.this$0.dismiss();
                }
            }
        });
        FlowLayout flowLayout2 = new FlowLayout(getContext());
        flowLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        flowLayout2.setPadding(ConvertUtils.dp2px(10.0f), ConvertUtils.dp2px(10.0f), ConvertUtils.dp2px(10.0f), ConvertUtils.dp2px(10.0f));
        flowLayout2.setElevation((float) ConvertUtils.dp2px(3.0f));
        flowLayout2.setClickable(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ColorStateList.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
        float dp2px = (float) ConvertUtils.dp2px(8.0f);
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dp2px, dp2px, dp2px, dp2px});
        Unit unit = Unit.INSTANCE;
        flowLayout2.setBackground(gradientDrawable);
        Unit unit2 = Unit.INSTANCE;
        this.flowLayout = flowLayout2;
        addView(flowLayout2);
        View view = new View(getContext());
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, ConvertUtils.dp2px(0.5f)));
        view.setElevation((float) ConvertUtils.dp2px(3.0f));
        view.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        addView(view);
    }

    public final void setFilterArgs(List<String> list, int i, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "titles");
        this.flowLayout.removeAllViews();
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TextView createTextView = createTextView(t, i2 == i);
            createTextView.setOnClickListener(new FilterLayout$setFilterArgs$$inlined$forEachIndexed$lambda$1(i2, this, i, function1));
            this.flowLayout.addView(createTextView);
            i2 = i3;
        }
    }

    private final TextView createTextView(String str, boolean z) {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setMinWidth((DisplayUtils.getDecorViewWidth(getContext()) - ConvertUtils.dp2px(68.0f)) / 4);
        Context context = textView.getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (z) {
            gradientDrawable.setColor(ColorStateList.valueOf(ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getColorAccent(), 26)));
        } else {
            gradientDrawable.setColor(ColorStateList.valueOf(ResourceUtils.resolveData(textView.getContext(), 2130968793)));
        }
        float dp2px = (float) ConvertUtils.dp2px(2.0f);
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px, dp2px});
        Unit unit = Unit.INSTANCE;
        textView.setBackground(ShapeUtils.createSelectableItemBackgroundWith(context, gradientDrawable));
        textView.setText(str);
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        int textColorPrimary = AppHolder.getAppTheme().getTextColorPrimary();
        if (!z) {
            colorAccent = textColorPrimary;
        }
        textView.setTextColor(colorAccent);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        Context context2 = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Resources resources = context2.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        layoutParams.leftMargin = (int) (resources.getDisplayMetrics().density * ((float) 6));
        layoutParams.rightMargin = layoutParams.leftMargin;
        layoutParams.topMargin = layoutParams.leftMargin;
        layoutParams.bottomMargin = layoutParams.leftMargin;
        Unit unit2 = Unit.INSTANCE;
        textView.setLayoutParams(layoutParams);
        textView.setPadding(0, ConvertUtils.dp2px(8.0f), 0, ConvertUtils.dp2px(8.0f));
        return textView;
    }

    public final void show() {
        if (!this.isAnimating) {
            this.isAnimating = true;
            ValueAnimator createBackgroundAnimator = createBackgroundAnimator(0, 838860800);
            createBackgroundAnimator.addListener(new FilterLayout$show$$inlined$apply$lambda$1(this));
            createBackgroundAnimator.start();
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 1, -1.0f, 1, 0.0f);
            translateAnimation.setDuration(300);
            translateAnimation.setFillAfter(true);
            this.flowLayout.startAnimation(translateAnimation);
        }
    }

    public final void dismiss() {
        if (!this.isAnimating) {
            this.isAnimating = true;
            Function0<Unit> function0 = this.onDismissListener;
            if (function0 != null) {
                function0.invoke();
            }
            ValueAnimator createBackgroundAnimator = createBackgroundAnimator(838860800, 0);
            createBackgroundAnimator.addListener(new FilterLayout$dismiss$$inlined$apply$lambda$1(this));
            createBackgroundAnimator.start();
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation.setDuration(300);
            translateAnimation.setFillAfter(true);
            this.flowLayout.startAnimation(translateAnimation);
        }
    }

    private final ValueAnimator createBackgroundAnimator(int i, int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(i, i2);
        valueAnimator.setDuration(300L);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.addUpdateListener(new FilterLayout$createBackgroundAnimator$$inlined$apply$lambda$1(this, i, i2));
        return valueAnimator;
    }

    /* access modifiers changed from: private */
    public final void dispatchBackgroundColorListener(int i) {
        setBackgroundColor(i);
    }
}
