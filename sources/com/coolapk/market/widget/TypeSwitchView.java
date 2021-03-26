package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.core.graphics.ColorUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import group.infotech.drawable.dsl.ShapesKt;
import group.infotech.drawable.dsl.ViewStates;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R4\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/widget/TypeSwitchView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "spaceView", "Landroid/view/View;", "value", "", "", "switchList", "getSwitchList", "()Ljava/util/List;", "setSwitchList", "(Ljava/util/List;)V", "createSelectedBackground", "Landroid/graphics/drawable/StateListDrawable;", "createSelectedTextColor", "Landroid/content/res/ColorStateList;", "getSwitchView", "Landroid/widget/CheckedTextView;", "string", "init", "", "onClick", "v", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TypeSwitchView.kt */
public final class TypeSwitchView extends LinearLayout implements View.OnClickListener {
    private final View spaceView = new View(getContext());
    private List<String> switchList;

    public final List<String> getSwitchList() {
        return this.switchList;
    }

    public final void setSwitchList(List<String> list) {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        Intrinsics.checkNotNull(list);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            addView(getSwitchView(context, it2.next()));
        }
        this.switchList = list;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeSwitchView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, null);
    }

    private final void init(Context context, AttributeSet attributeSet) {
        setOrientation(0);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final CheckedTextView getSwitchView(Context context, String str) {
        int i;
        switch (str.hashCode()) {
            case 640464:
                if (str.equals("个人")) {
                    i = 2131363346;
                    break;
                }
                i = 0;
                break;
            case 672372:
                if (str.equals("出售")) {
                    i = 2131361965;
                    break;
                }
                i = 0;
                break;
            case 700208:
                if (str.equals("商家")) {
                    i = 2131363344;
                    break;
                }
                i = 0;
                break;
            case 815128:
                if (str.equals("换机")) {
                    i = 2131361964;
                    break;
                }
                i = 0;
                break;
            case 839351:
                if (str.equals("收购")) {
                    i = 2131361963;
                    break;
                }
                i = 0;
                break;
            default:
                i = 0;
                break;
        }
        CheckedTextView checkedTextView = new CheckedTextView(context);
        checkedTextView.setId(i);
        checkedTextView.setText(str);
        checkedTextView.setOnClickListener(this);
        checkedTextView.setTextColor(createSelectedTextColor());
        checkedTextView.setBackground(createSelectedBackground());
        checkedTextView.setPadding(NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 4));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.rightMargin = NumberExtendsKt.getDp((Number) 14);
        checkedTextView.setLayoutParams(marginLayoutParams);
        return checkedTextView;
    }

    private final ColorStateList createSelectedTextColor() {
        return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().getTextColorPrimary()});
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == 2131363346) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            getSwitchView(context, "个人").setSelected(true);
        } else if (valueOf != null && valueOf.intValue() == 2131363344) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            getSwitchView(context2, "商家").setSelected(true);
        }
    }

    private final StateListDrawable createSelectedBackground() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] selected = ViewStates.INSTANCE.selected();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
        ShapesKt.setSolidColor(gradientDrawable, ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getColorAccent(), 26));
        stateListDrawable.addState(selected, gradientDrawable);
        int[] iArr = StateSet.WILD_CARD;
        Intrinsics.checkExpressionValueIsNotNull(iArr, "StateSet.WILD_CARD");
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
        ShapesKt.setSolidColor(gradientDrawable2, Color.parseColor(AppHolder.getAppTheme().isDarkTheme() ? "#282828" : "#F5F5F5"));
        stateListDrawable.addState(iArr, gradientDrawable2);
        return stateListDrawable;
    }
}
