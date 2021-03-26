package com.coolapk.market.widget.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import cn.lankton.flowlayout.FlowLayout;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.widget.LinearAdapterLayout;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FloatExpandedMenuView.kt */
public final class FloatExpandedMenuView extends FrameLayout {
    private int DEFAULT_MASK_COLOR = 838860800;
    private final View bgMaskView;
    private final LinearAdapterLayout contentView;
    private List<? extends Pair<String, ? extends List<? extends Entity>>> data = CollectionsKt.emptyList();
    private Function0<Unit> dismissListener;
    private final View dividerView;
    private boolean isAnimating;
    private Function1<? super Entity, Unit> onPageClickListener;
    private String selectedUrl = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatExpandedMenuView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View view = new View(getContext());
        view.setBackgroundColor(this.DEFAULT_MASK_COLOR);
        Unit unit = Unit.INSTANCE;
        this.bgMaskView = view;
        addView(view, new FrameLayout.LayoutParams(-1, -1));
        LinearAdapterLayout linearAdapterLayout = new LinearAdapterLayout(getContext(), null);
        linearAdapterLayout.setOrientation(1);
        int dp = NumberExtendsKt.getDp((Number) 10);
        linearAdapterLayout.setPadding(dp, NumberExtendsKt.getDp((Number) 4), dp, dp);
        linearAdapterLayout.setElevation((float) NumberExtendsKt.getDp((Number) 3));
        linearAdapterLayout.setClickable(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ColorStateList.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
        float dp2 = (float) NumberExtendsKt.getDp((Number) 8);
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dp2, dp2, dp2, dp2});
        Unit unit2 = Unit.INSTANCE;
        linearAdapterLayout.setBackground(gradientDrawable);
        Unit unit3 = Unit.INSTANCE;
        this.contentView = linearAdapterLayout;
        addView(linearAdapterLayout, new FrameLayout.LayoutParams(-1, -2));
        View view2 = new View(getContext());
        view2.setElevation((float) ConvertUtils.dp2px(3.0f));
        view2.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        Unit unit4 = Unit.INSTANCE;
        this.dividerView = view2;
        addView(view2, new FrameLayout.LayoutParams(-1, NumberExtendsKt.getDp(Double.valueOf(0.5d))));
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.widget.view.FloatExpandedMenuView.AnonymousClass4 */
            final /* synthetic */ FloatExpandedMenuView this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (this.this$0.isAttachedToWindow()) {
                    FloatExpandedMenuView.hideWithAnimator$default(this.this$0, false, 1, null);
                }
            }
        });
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View view = new View(getContext());
        view.setBackgroundColor(this.DEFAULT_MASK_COLOR);
        Unit unit = Unit.INSTANCE;
        this.bgMaskView = view;
        addView(view, new FrameLayout.LayoutParams(-1, -1));
        LinearAdapterLayout linearAdapterLayout = new LinearAdapterLayout(getContext(), null);
        linearAdapterLayout.setOrientation(1);
        int dp = NumberExtendsKt.getDp((Number) 10);
        linearAdapterLayout.setPadding(dp, NumberExtendsKt.getDp((Number) 4), dp, dp);
        linearAdapterLayout.setElevation((float) NumberExtendsKt.getDp((Number) 3));
        linearAdapterLayout.setClickable(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ColorStateList.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
        float dp2 = (float) NumberExtendsKt.getDp((Number) 8);
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dp2, dp2, dp2, dp2});
        Unit unit2 = Unit.INSTANCE;
        linearAdapterLayout.setBackground(gradientDrawable);
        Unit unit3 = Unit.INSTANCE;
        this.contentView = linearAdapterLayout;
        addView(linearAdapterLayout, new FrameLayout.LayoutParams(-1, -2));
        View view2 = new View(getContext());
        view2.setElevation((float) ConvertUtils.dp2px(3.0f));
        view2.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        Unit unit4 = Unit.INSTANCE;
        this.dividerView = view2;
        addView(view2, new FrameLayout.LayoutParams(-1, NumberExtendsKt.getDp(Double.valueOf(0.5d))));
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.widget.view.FloatExpandedMenuView.AnonymousClass4 */
            final /* synthetic */ FloatExpandedMenuView this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (this.this$0.isAttachedToWindow()) {
                    FloatExpandedMenuView.hideWithAnimator$default(this.this$0, false, 1, null);
                }
            }
        });
    }

    public final String getSelectedUrl() {
        return this.selectedUrl;
    }

    public final void setSelectedUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedUrl = str;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends kotlin.Pair<java.lang.String, ? extends java.util.List<? extends com.coolapk.market.model.Entity>>>, java.util.List<kotlin.Pair<java.lang.String, java.util.List<com.coolapk.market.model.Entity>>> */
    public final List<Pair<String, List<Entity>>> getData() {
        return this.data;
    }

    public final void setData(List<? extends Pair<String, ? extends List<? extends Entity>>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.data = list;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.coolapk.market.model.Entity, kotlin.Unit>, kotlin.jvm.functions.Function1<com.coolapk.market.model.Entity, kotlin.Unit> */
    public final Function1<Entity, Unit> getOnPageClickListener() {
        return this.onPageClickListener;
    }

    public final void setOnPageClickListener(Function1<? super Entity, Unit> function1) {
        this.onPageClickListener = function1;
    }

    public final Function0<Unit> getDismissListener() {
        return this.dismissListener;
    }

    public final void setDismissListener(Function0<Unit> function0) {
        this.dismissListener = function0;
    }

    public final void notifyDataSetChange() {
        LinearAdapterLayout linearAdapterLayout = this.contentView;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        linearAdapterLayout.setAdapter(new ConfigPageAdapter(this, context));
    }

    /* compiled from: FloatExpandedMenuView.kt */
    public final class ConfigPageAdapter extends ArrayAdapter<Pair<? extends String, ? extends List<? extends Entity>>> {
        final /* synthetic */ FloatExpandedMenuView this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ConfigPageAdapter(FloatExpandedMenuView floatExpandedMenuView, Context context) {
            super(context, 0, floatExpandedMenuView.getData());
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = floatExpandedMenuView;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Pair<String, List<Entity>> pair = this.this$0.getData().get(i);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            boolean z = true;
            linearLayout.setOrientation(1);
            if (pair.getFirst().length() <= 0) {
                z = false;
            }
            if (z) {
                TextView textView = new TextView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = NumberExtendsKt.getDp((Number) 6);
                layoutParams.topMargin = NumberExtendsKt.getDp((Number) 6);
                Unit unit = Unit.INSTANCE;
                textView.setLayoutParams(layoutParams);
                textView.setText(pair.getFirst());
                textView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
                linearLayout.addView(textView);
            }
            FlowLayout flowLayout = new FlowLayout(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = NumberExtendsKt.getDp((Number) 6);
            layoutParams2.bottomMargin = NumberExtendsKt.getDp((Number) 6);
            Unit unit2 = Unit.INSTANCE;
            flowLayout.setLayoutParams(layoutParams2);
            for (T t : pair.getSecond()) {
                FloatExpandedMenuView floatExpandedMenuView = this.this$0;
                String title = t.getTitle();
                if (title == null) {
                    title = "";
                }
                TextView createTextView = floatExpandedMenuView.createTextView(title, Intrinsics.areEqual(t.getUrl(), this.this$0.getSelectedUrl()));
                createTextView.setOnClickListener(new FloatExpandedMenuView$ConfigPageAdapter$getView$$inlined$forEach$lambda$1(t, this, flowLayout));
                flowLayout.addView(createTextView);
            }
            linearLayout.addView(flowLayout);
            return linearLayout;
        }
    }

    public final TextView createTextView(String str, boolean z) {
        int decorViewWidth = (DisplayUtils.getDecorViewWidth(getContext()) - ConvertUtils.dp2px(68.0f)) / 4;
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setMinWidth(decorViewWidth);
        Context context = textView.getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (z) {
            gradientDrawable.setColor(ColorStateList.valueOf(ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getColorAccent(), 26)));
        } else {
            gradientDrawable.setColor(ColorStateList.valueOf(ResourceUtils.resolveData(textView.getContext(), 2130968793)));
        }
        float dp = (float) NumberExtendsKt.getDp((Number) 2);
        gradientDrawable.setCornerRadii(new float[]{dp, dp, dp, dp, dp, dp, dp, dp});
        Unit unit = Unit.INSTANCE;
        textView.setBackground(ShapeUtils.createSelectableItemBackgroundWith(context, gradientDrawable));
        textView.setText(str);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        int textColorPrimary = AppHolder.getAppTheme().getTextColorPrimary();
        if (!z) {
            colorAccent = textColorPrimary;
        }
        textView.setTextColor(colorAccent);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(decorViewWidth, -2);
        Context context2 = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Resources resources = context2.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        layoutParams.leftMargin = (int) (resources.getDisplayMetrics().density * ((float) 6));
        layoutParams.rightMargin = layoutParams.leftMargin;
        layoutParams.topMargin = NumberExtendsKt.getDp((Number) 4);
        layoutParams.bottomMargin = NumberExtendsKt.getDp((Number) 4);
        Unit unit2 = Unit.INSTANCE;
        textView.setLayoutParams(layoutParams);
        textView.setPadding(NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 8));
        return textView;
    }

    public final void showWithAnimator() {
        if (!this.isAnimating) {
            this.isAnimating = true;
            getViewTreeObserver().addOnPreDrawListener(new FloatExpandedMenuView$showWithAnimator$$inlined$doOnNextPreDraw$1(this, this));
        }
    }

    public static /* synthetic */ void hideWithAnimator$default(FloatExpandedMenuView floatExpandedMenuView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        floatExpandedMenuView.hideWithAnimator(z);
    }

    public final void hideWithAnimator(boolean z) {
        if (!this.isAnimating) {
            this.isAnimating = true;
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(1.0f, 0.0f);
            valueAnimator.addUpdateListener(new FloatExpandedMenuView$hideWithAnimator$$inlined$apply$lambda$1(this, z));
            ExtraExtendsKt.addListeners(valueAnimator, new FloatExpandedMenuView$hideWithAnimator$$inlined$apply$lambda$3(this, z), new FloatExpandedMenuView$hideWithAnimator$$inlined$apply$lambda$2(this, z));
            valueAnimator.start();
        }
    }

    public final void setBackPressToHide() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (!(activityNullable instanceof BaseActivity)) {
            activityNullable = null;
        }
        BaseActivity baseActivity = (BaseActivity) activityNullable;
        if (baseActivity != null) {
            baseActivity.setOnBackPressListener(new FloatExpandedMenuView$setBackPressToHide$1(this));
        }
    }

    public final void removeBackPressListener() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (!(activityNullable instanceof BaseActivity)) {
            activityNullable = null;
        }
        BaseActivity baseActivity = (BaseActivity) activityNullable;
        if (baseActivity != null) {
            baseActivity.setOnBackPressListener(null);
        }
    }
}
