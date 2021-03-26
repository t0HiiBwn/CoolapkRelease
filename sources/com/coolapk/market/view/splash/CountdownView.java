package com.coolapk.market.view.splash;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0015\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/splash/CountdownView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "textView", "Landroid/widget/TextView;", "init", "", "setNumber", "number", "", "(Ljava/lang/Integer;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CountdownView.kt */
public final class CountdownView extends FrameLayout {
    private TextView textView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CountdownView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    public final void init() {
        setMinimumWidth(NumberExtendsKt.getDp((Number) 54));
        setMinimumHeight(NumberExtendsKt.getDp((Number) 26));
        setBackgroundResource(2131231873);
        TextView textView2 = new TextView(getContext());
        this.textView = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        textView2.setTextColor(-1);
        TextView textView3 = this.textView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        textView3.setTextSize(12.0f);
        TextView textView4 = this.textView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        addView(textView4, new FrameLayout.LayoutParams(-2, -2, 17));
        setNumber(null);
    }

    public final void setNumber(Integer num) {
        String str = "跳过";
        if (num != null) {
            str = str + ' ' + num;
        }
        TextView textView2 = this.textView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        textView2.setText(str);
    }
}
