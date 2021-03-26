package com.coolapk.market.design;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.R;
import com.coolapk.market.local.DataConfig;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.google.android.material.card.MaterialCardView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001e\u0018\u0000 =2\u00020\u0001:\u0002<=B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020 H\u0002J\u0006\u0010\"\u001a\u00020\tJ\u001a\u0010#\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006J&\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tJ&\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tJ\u000e\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020 J.\u0010.\u001a\u00020\u00192\b\b\u0002\u00100\u001a\u00020 2\b\b\u0002\u00101\u001a\u00020 2\b\b\u0002\u00102\u001a\u00020 2\b\b\u0002\u00103\u001a\u00020 J\u000e\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\tJ\u000e\u00106\u001a\u00020\u00192\u0006\u00105\u001a\u00020\tJ\u0006\u00107\u001a\u00020\u0019J\u0006\u00108\u001a\u00020\u0019J\u0006\u00109\u001a\u00020\u0019J\u0006\u0010:\u001a\u00020\u0019J\u0006\u0010;\u001a\u00020\u0019R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017XD¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/coolapk/market/design/CoolapkCardView;", "Lcom/google/android/material/card/MaterialCardView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentCardStyle", "debugTextView", "Landroid/widget/TextView;", "value", "defaultBackgroundColor", "getDefaultBackgroundColor", "()Ljava/lang/Integer;", "setDefaultBackgroundColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "defaultCardStyle", "enableDebugTextView", "", "bindWithViewHolder", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "any", "", "checkShouldCopyChildState", "dp2px", "", "dp2pxf", "getCardStyle", "init", "setCardMargin", "marginLeft", "marginTop", "marginRight", "marginBottom", "setCardPadding", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "setCardRoundRadius", "radius", "topLeft", "topRight", "bottomLeft", "bottomRight", "setCardStyle", "cardStyle", "setDefaultStyle", "setRectangleCardStyle", "setRoundBottomOnlyCardStyle", "setRoundCardStyle", "setRoundTopOnlyCardStyle", "setTransparentCardStyle", "CardStyleCallback", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolapkCardView.kt */
public final class CoolapkCardView extends MaterialCardView {
    public static final Companion Companion = new Companion(null);
    public static final int STYLE_DEFAULT = 0;
    public static final int STYLE_RECTANGLE = 3;
    public static final int STYLE_ROUND = 2;
    public static final int STYLE_ROUND_BOTTOM_ONLY = 5;
    public static final int STYLE_ROUND_TOP_ONLY = 4;
    public static final int STYLE_TRANSPARENT = 1;
    private int currentCardStyle;
    private TextView debugTextView;
    private Integer defaultBackgroundColor;
    private int defaultCardStyle = 3;
    private final boolean enableDebugTextView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/design/CoolapkCardView$CardStyleCallback;", "", "onCardStyleDetermined", "", "cardStyle", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CoolapkCardView.kt */
    public interface CardStyleCallback {
        void onCardStyleDetermined(int i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/design/CoolapkCardView$Companion;", "", "()V", "STYLE_DEFAULT", "", "STYLE_RECTANGLE", "STYLE_ROUND", "STYLE_ROUND_BOTTOM_ONLY", "STYLE_ROUND_TOP_ONLY", "STYLE_TRANSPARENT", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CoolapkCardView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Integer getDefaultBackgroundColor() {
        return this.defaultBackgroundColor;
    }

    public final void setDefaultBackgroundColor(Integer num) {
        this.defaultBackgroundColor = num;
        this.currentCardStyle = 0;
        setCardStyle(0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoolapkCardView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoolapkCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoolapkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, attributeSet);
    }

    public static /* synthetic */ void init$default(CoolapkCardView coolapkCardView, Context context, AttributeSet attributeSet, int i, Object obj) {
        if ((i & 2) != 0) {
            attributeSet = null;
        }
        coolapkCardView.init(context, attributeSet);
    }

    public final void init(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoolapkCardView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.CoolapkCardView)");
            this.defaultCardStyle = obtainStyledAttributes.getInt(0, this.defaultCardStyle);
            obtainStyledAttributes.recycle();
        }
        setCardStyle(this.defaultCardStyle);
        if (this.enableDebugTextView && !isInEditMode()) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            DataConfig dataConfig = instance.getDataConfig();
            Intrinsics.checkNotNullExpressionValue(dataConfig, "DataManager.getInstance().dataConfig");
            if (dataConfig.isDebugEnabled()) {
                TextView textView = new TextView(context);
                textView.setTextColor(-65536);
                textView.setTextSize(10.0f);
                Unit unit = Unit.INSTANCE;
                this.debugTextView = textView;
                addView(textView, new FrameLayout.LayoutParams(-2, -2, 5));
            }
        }
    }

    public final void bindWithViewHolder(RecyclerView.ViewHolder viewHolder, Object obj) {
        TextView textView;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (this.enableDebugTextView && (textView = this.debugTextView) != null) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            DataConfig dataConfig = instance.getDataConfig();
            Intrinsics.checkNotNullExpressionValue(dataConfig, "DataManager.getInstance().dataConfig");
            if (dataConfig.isDebugEnabled()) {
                textView.setVisibility(0);
                textView.setZ(100.0f);
                textView.setAlpha(0.5f);
                if (obj instanceof Entity) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(viewHolder.getClass().getSimpleName());
                    sb.append(" => ");
                    Entity entity = (Entity) obj;
                    sb.append(entity.getEntityType());
                    String sb2 = sb.toString();
                    if (entity.getEntityTemplate() != null) {
                        sb2 = sb2 + " -> " + entity.getEntityTemplate();
                    }
                    textView.setText(sb2);
                    return;
                }
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void setDefaultStyle(int i) {
        if (this.defaultCardStyle != i && i != 0) {
            this.defaultCardStyle = i;
            setCardStyle(i);
        }
    }

    public final void setCardStyle(int i) {
        if (i == 0) {
            i = this.defaultCardStyle;
        }
        if (i != this.currentCardStyle) {
            this.currentCardStyle = i;
            if (i == 1) {
                setTransparentCardStyle();
            } else if (i == 2) {
                setRoundCardStyle();
            } else if (i == 3) {
                setRectangleCardStyle();
            } else if (i == 4) {
                setRoundTopOnlyCardStyle();
            } else if (i == 5) {
                setRoundBottomOnlyCardStyle();
            }
        }
    }

    public final int getCardStyle() {
        return this.currentCardStyle;
    }

    public final void setRoundCardStyle() {
        int i;
        setCardElevation(0.0f);
        if (isInEditMode()) {
            i = -1;
        } else {
            Integer num = this.defaultBackgroundColor;
            i = num != null ? num.intValue() : AppHolder.getAppTheme().getContentBackgroundColor();
        }
        setCardBackgroundColor(i);
        setCardRoundRadius(dp2pxf(8.0f));
        checkShouldCopyChildState();
    }

    public final void setRoundTopOnlyCardStyle() {
        int i;
        setCardElevation(0.0f);
        if (isInEditMode()) {
            i = -1;
        } else {
            Integer num = this.defaultBackgroundColor;
            i = num != null ? num.intValue() : AppHolder.getAppTheme().getContentBackgroundColor();
        }
        setCardBackgroundColor(i);
        setCardRoundRadius(dp2pxf(8.0f), dp2pxf(8.0f), 0.0f, 0.0f);
        checkShouldCopyChildState();
    }

    public final void setRoundBottomOnlyCardStyle() {
        int i;
        setCardElevation(0.0f);
        if (isInEditMode()) {
            i = -1;
        } else {
            Integer num = this.defaultBackgroundColor;
            i = num != null ? num.intValue() : AppHolder.getAppTheme().getContentBackgroundColor();
        }
        setCardBackgroundColor(i);
        setCardRoundRadius(0.0f, 0.0f, dp2pxf(8.0f), dp2pxf(8.0f));
        checkShouldCopyChildState();
    }

    public final void setRectangleCardStyle() {
        int i;
        setCardElevation(0.0f);
        if (isInEditMode()) {
            i = -1;
        } else {
            Integer num = this.defaultBackgroundColor;
            i = num != null ? num.intValue() : AppHolder.getAppTheme().getContentBackgroundColor();
        }
        setCardBackgroundColor(i);
        setCardRoundRadius(0.0f);
        checkShouldCopyChildState();
    }

    public final void setTransparentCardStyle() {
        setCardElevation(0.0f);
        setCardBackgroundColor(0);
        setCardRoundRadius(0.0f);
        checkShouldCopyChildState();
    }

    public final void setCardRoundRadius(float f) {
        setCardRoundRadius(f, f, f, f);
    }

    public static /* synthetic */ void setCardRoundRadius$default(CoolapkCardView coolapkCardView, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        coolapkCardView.setCardRoundRadius(f, f2, f3, f4);
    }

    public final void setCardRoundRadius(float f, float f2, float f3, float f4) {
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setTopLeftCorner(0, f).setTopRightCorner(0, f2).setBottomLeftCorner(0, f3).setBottomRightCorner(0, f4).build());
    }

    public final void setCardPadding(int i, int i2, int i3, int i4) {
        setContentPadding(i, i2, i3, i4);
    }

    private final float dp2pxf(float f) {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    private final int dp2px(float f) {
        return (int) (dp2pxf(f) + 0.5f);
    }

    public final void setCardMargin(int i, int i2, int i3, int i4) {
        if (!ViewCompat.isAttachedToWindow(this)) {
            addOnAttachStateChangeListener(new CoolapkCardView$setCardMargin$$inlined$doOnAttach$1(this, this, i, i2, i3, i4));
        } else if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
            marginLayoutParams2.leftMargin = i;
            marginLayoutParams2.topMargin = i2;
            marginLayoutParams2.rightMargin = i3;
            marginLayoutParams2.bottomMargin = i4;
            setLayoutParams(marginLayoutParams);
        }
    }

    private final void checkShouldCopyChildState() {
        if (!ViewCompat.isAttachedToWindow(this)) {
            addOnAttachStateChangeListener(new CoolapkCardView$checkShouldCopyChildState$$inlined$doOnAttach$1(this, this));
        } else if (!isClickable()) {
            boolean z = false;
            int i = this.debugTextView != null ? 1 : 0;
            if (getChildCount() > i) {
                View childAt = getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(childOffset)");
                z = childAt.isClickable();
            }
            setFocusable(z);
            setClickable(z);
            setAddStatesFromChildren(z);
        }
    }
}
