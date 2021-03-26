package com.coolapk.market.widget.expandable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0002&'B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\nH\u0002J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\nJ\u0010\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010#\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010\u0016J\u0006\u0010%\u001a\u00020\u0019R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/coolapk/market/widget/expandable/ExpandTextView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionTextView", "Landroid/widget/TextView;", "contentTextView", "isExpand", "", "isInitTextView", "maxCollapsedLines", "onStateChangeListener", "Lcom/coolapk/market/widget/expandable/ExpandTextView$OnStateChangeListener;", "textContent", "", "textLines", "doStatic", "", "init", "defStyleRes", "onClick", "v", "Landroid/view/View;", "setMaxCollapsedLines", "setOnStateChangeListener", "listener", "setState", "setText", "charSequence", "toggle", "Companion", "OnStateChangeListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ExpandTextView.kt */
public final class ExpandTextView extends LinearLayout implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String TEXT_COLLAPSE = "收起";
    public static final String TEXT_EXPAND = "展开";
    private TextView actionTextView;
    private TextView contentTextView;
    private boolean isExpand;
    private boolean isInitTextView = true;
    private int maxCollapsedLines;
    private OnStateChangeListener onStateChangeListener;
    private CharSequence textContent;
    private int textLines;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/widget/expandable/ExpandTextView$OnStateChangeListener;", "", "onStateChange", "", "isExpand", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ExpandTextView.kt */
    public interface OnStateChangeListener {
        void onStateChange(boolean z);
    }

    public static final /* synthetic */ TextView access$getContentTextView$p(ExpandTextView expandTextView) {
        TextView textView = expandTextView.contentTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
        }
        return textView;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/widget/expandable/ExpandTextView$Companion;", "", "()V", "TEXT_COLLAPSE", "", "TEXT_EXPAND", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ExpandTextView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init$default(this, null, 0, 0, 7, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init$default(this, attributeSet, 0, 0, 6, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init$default(this, attributeSet, i, 0, 4, null);
    }

    static /* synthetic */ void init$default(ExpandTextView expandTextView, AttributeSet attributeSet, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            attributeSet = null;
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        expandTextView.init(attributeSet, i, i2);
    }

    private final void init(AttributeSet attributeSet, int i, int i2) {
        TextView textView = new TextView(getContext());
        this.contentTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
        }
        textView.setTextSize(13.0f);
        TextView textView2 = this.contentTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
        }
        textView2.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
        TextView textView3 = this.contentTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
        }
        addView(textView3, new LinearLayout.LayoutParams(-1, -2));
        TextView textView4 = new TextView(getContext());
        this.actionTextView = textView4;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionTextView");
        }
        textView4.setTextSize(13.0f);
        TextView textView5 = this.actionTextView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionTextView");
        }
        textView5.setTextColor(AppHolder.getAppTheme().getColorAccent());
        TextView textView6 = this.actionTextView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionTextView");
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = NumberExtendsKt.getDp((Number) 4);
        Unit unit = Unit.INSTANCE;
        addView(textView6, layoutParams);
        setOrientation(1);
        setOnClickListener(this);
    }

    public final void setText(CharSequence charSequence) {
        this.textContent = charSequence;
        TextView textView = this.contentTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
        }
        textView.setText(this.textContent);
        TextView textView2 = this.contentTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
        }
        textView2.getViewTreeObserver().addOnPreDrawListener(new ExpandTextView$setText$1(this));
        if (!this.isInitTextView) {
            TextView textView3 = this.contentTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
            }
            this.textLines = textView3.getLineCount();
        }
    }

    public final void setState(boolean z) {
        if (!this.isInitTextView) {
            this.isExpand = z;
            if (this.textLines > this.maxCollapsedLines) {
                TextView textView = this.actionTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionTextView");
                }
                textView.setVisibility(0);
                setOnClickListener(this);
                setClickable(true);
                if (z) {
                    TextView textView2 = this.contentTextView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
                    }
                    textView2.setMaxLines(this.textLines);
                    TextView textView3 = this.actionTextView;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionTextView");
                    }
                    textView3.setText("收起");
                } else {
                    TextView textView4 = this.contentTextView;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
                    }
                    textView4.setMaxLines(this.maxCollapsedLines);
                    TextView textView5 = this.actionTextView;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionTextView");
                    }
                    textView5.setText("展开");
                }
            } else {
                doStatic();
            }
            OnStateChangeListener onStateChangeListener2 = this.onStateChangeListener;
            if (onStateChangeListener2 != null) {
                onStateChangeListener2.onStateChange(this.isExpand);
            }
        }
    }

    private final void doStatic() {
        TextView textView = this.contentTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
        }
        textView.setMaxLines(this.maxCollapsedLines);
        TextView textView2 = this.actionTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionTextView");
        }
        textView2.setVisibility(8);
        setOnClickListener(null);
        setClickable(false);
    }

    public final void toggle() {
        setState(!this.isExpand);
    }

    public final void setMaxCollapsedLines(int i) {
        this.maxCollapsedLines = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        toggle();
    }

    public final void setOnStateChangeListener(OnStateChangeListener onStateChangeListener2) {
        this.onStateChangeListener = onStateChangeListener2;
    }
}
