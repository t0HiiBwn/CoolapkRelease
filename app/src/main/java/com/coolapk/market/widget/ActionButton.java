package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.R;
import com.coolapk.market.model.ServiceApp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 52\u00020\u0001:\u00015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0014J\u001a\u0010)\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010*\u001a\u00020%H\u0014J\b\u0010+\u001a\u00020%H\u0014J(\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\u0014J\u0006\u00101\u001a\u00020\fJ\u0018\u0010\u0011\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\t2\b\b\u0002\u00102\u001a\u00020\u0014J\b\u00103\u001a\u00020%H\u0002J\b\u00104\u001a\u00020%H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R+\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t8B@BX\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00066"}, d2 = {"Lcom/coolapk/market/widget/ActionButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appActionHelper", "Lcom/coolapk/market/widget/AppActionHelper;", "buttonStyle", "Lcom/coolapk/market/widget/Style;", "getButtonStyle", "()Lcom/coolapk/market/widget/Style;", "setButtonStyle", "(Lcom/coolapk/market/widget/Style;)V", "isCapsule", "", "radius", "", "getRadius", "()F", "setRadius", "(F)V", "style", "<set-?>", "themeColor", "getThemeColor", "()I", "setThemeColor", "(I)V", "themeColor$delegate", "Lkotlin/properties/ReadWriteProperty;", "bindWithApp", "", "serviceApp", "Lcom/coolapk/market/model/ServiceApp;", "updateSelf", "initUI", "onAttachedToWindow", "onDetachedFromWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "requireAppAction", "showSize", "updateBackgroundStyle", "updateTextColorStyle", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActionButton.kt */
public final class ActionButton extends AppCompatTextView {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ActionButton.class, "themeColor", "getThemeColor()I", 0))};
    public static final Companion Companion = new Companion(null);
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_SELECTABLE = 3;
    public static final int STYLE_THEME_BORDER = 4;
    public static final int STYLE_THEME_PROGRESS = 1;
    public static final int STYLE_TRANS_WHITE_PROGRESS = 2;
    private AppActionHelper appActionHelper;
    public Style buttonStyle;
    private boolean isCapsule;
    private float radius;
    private int style;
    private final ReadWriteProperty themeColor$delegate;

    private final int getThemeColor() {
        return ((Number) this.themeColor$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    private final void setThemeColor(int i) {
        this.themeColor$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/widget/ActionButton$Companion;", "", "()V", "STYLE_NORMAL", "", "STYLE_SELECTABLE", "STYLE_THEME_BORDER", "STYLE_THEME_PROGRESS", "STYLE_TRANS_WHITE_PROGRESS", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ActionButton.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Style getButtonStyle() {
        Style style2 = this.buttonStyle;
        if (style2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonStyle");
        }
        return style2;
    }

    public final void setButtonStyle(Style style2) {
        Intrinsics.checkNotNullParameter(style2, "<set-?>");
        this.buttonStyle = style2;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final void setRadius(float f) {
        this.radius = f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActionButton(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.themeColor$delegate = Delegates.INSTANCE.notNull();
        this.isCapsule = true;
        this.style = -1;
        initUI(context, attributeSet);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AppActionHelper appActionHelper2 = this.appActionHelper;
        if (appActionHelper2 != null) {
            appActionHelper2.onDetach();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AppActionHelper appActionHelper2 = this.appActionHelper;
        if (appActionHelper2 != null) {
            appActionHelper2.onAttach();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.isCapsule) {
            float f = ((float) i2) / 2.0f;
            if (f != this.radius) {
                this.radius = f;
                updateBackgroundStyle();
            }
        }
    }

    private final void initUI(Context context, AttributeSet attributeSet) {
        boolean z;
        int i = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionButton);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.ActionButton)");
            int i2 = obtainStyledAttributes.getInt(3, 0);
            this.radius = obtainStyledAttributes.getDimension(1, this.radius);
            this.isCapsule = obtainStyledAttributes.getBoolean(0, this.isCapsule);
            boolean z2 = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
            z = z2;
            i = i2;
        } else {
            z = false;
        }
        setGravity(17);
        if (this.isCapsule) {
            setClipToOutline(true);
            setOutlineProvider(new ActionButton$initUI$1());
        }
        if (isInEditMode()) {
            setThemeColor(ActionButtonKt.access$toColor(2131099784, context));
        } else {
            setThemeColor(AppHolder.getAppTheme().getColorAccent());
        }
        setButtonStyle(i, z);
    }

    public static /* synthetic */ void setButtonStyle$default(ActionButton actionButton, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        actionButton.setButtonStyle(i, z);
    }

    public final void setButtonStyle(int i, boolean z) {
        ThemeProgressStyle themeProgressStyle;
        if (this.style != i) {
            this.style = i;
            if (i == 1) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                themeProgressStyle = new ThemeProgressStyle(context, this, getThemeColor());
            } else if (i == 2) {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                TransWhiteProgressStyle transWhiteProgressStyle = new TransWhiteProgressStyle(context2, this);
                transWhiteProgressStyle.setShowSize(z);
                Unit unit = Unit.INSTANCE;
                themeProgressStyle = transWhiteProgressStyle;
            } else if (i == 3) {
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                themeProgressStyle = new SelectableStyle(context3, this);
            } else if (i != 4) {
                themeProgressStyle = new DefaultStyle(getThemeColor(), this);
            } else {
                Context context4 = getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "context");
                themeProgressStyle = new ThemeBorderStyle(context4, getThemeColor(), this);
            }
            this.buttonStyle = themeProgressStyle;
            updateBackgroundStyle();
            updateTextColorStyle();
        }
    }

    private final void updateTextColorStyle() {
        Style style2 = this.buttonStyle;
        if (style2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonStyle");
        }
        setTextColor(style2.createTextColor());
    }

    private final void updateBackgroundStyle() {
        Style style2 = this.buttonStyle;
        if (style2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonStyle");
        }
        setBackground(style2.createButtonBackground());
    }

    public final AppActionHelper requireAppAction() {
        AppActionHelper appActionHelper2 = this.appActionHelper;
        Intrinsics.checkNotNull(appActionHelper2);
        return appActionHelper2;
    }

    public static /* synthetic */ void bindWithApp$default(ActionButton actionButton, ServiceApp serviceApp, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        actionButton.bindWithApp(serviceApp, z);
    }

    public final void bindWithApp(ServiceApp serviceApp, boolean z) {
        Intrinsics.checkNotNullParameter(serviceApp, "serviceApp");
        if (AppHolder.getAppMetadata().isCommunityMode()) {
            setVisibility(4);
            setAlpha(0.0f);
            return;
        }
        if (this.appActionHelper == null) {
            this.appActionHelper = new AppActionHelper(this, z);
        }
        AppActionHelper appActionHelper2 = this.appActionHelper;
        if (appActionHelper2 != null) {
            appActionHelper2.setServiceApp(serviceApp);
        }
        AppActionHelper appActionHelper3 = this.appActionHelper;
        if (appActionHelper3 != null) {
            appActionHelper3.updateWithApp();
        }
    }
}
