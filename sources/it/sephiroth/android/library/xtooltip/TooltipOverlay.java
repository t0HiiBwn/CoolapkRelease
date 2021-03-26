package it.sephiroth.android.library.xtooltip;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0002R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lit/sephiroth/android/library/xtooltip/TooltipOverlay;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleResId", "(Landroid/content/Context;II)V", "layoutMargins", "init", "", "xtooltip_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: TooltipOverlay.kt */
public final class TooltipOverlay extends AppCompatImageView {
    private HashMap _$_findViewCache;
    private int layoutMargins;

    public TooltipOverlay(Context context) {
        this(context, null, 0, 6, null);
    }

    public TooltipOverlay(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TooltipOverlay(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.style.ToolTipOverlayDefaultStyle : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TooltipOverlay(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        init(context, R.style.ToolTipLayoutDefaultStyle);
    }

    private final void init(Context context, int i) {
        setImageDrawable(new TooltipOverlayDrawable(context, i));
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(i, R.styleable.TooltipOverlay);
        this.layoutMargins = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TooltipOverlay_android_layout_margin, 0);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TooltipOverlay(Context context, int i, int i2) {
        super(context, null, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        init(context, i2);
    }
}
