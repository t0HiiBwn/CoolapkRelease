package com.coolapk.market.view.cardlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.TintHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0015R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/cardlist/StateView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "emptyMessage", "", "(Landroid/content/Context;Landroid/util/AttributeSet;ILjava/lang/String;)V", "progress", "Landroid/widget/ProgressBar;", "tempEmptyMessage", "getTempEmptyMessage", "()Ljava/lang/String;", "setTempEmptyMessage", "(Ljava/lang/String;)V", "textView", "Landroid/widget/TextView;", "init", "", "showEmpty", "showProgress", "showRetry", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: StateView.kt */
public final class StateView extends LinearLayout {
    private final String emptyMessage;
    private ProgressBar progress;
    private String tempEmptyMessage;
    private TextView textView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StateView(Context context, AttributeSet attributeSet, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StateView(Context context, AttributeSet attributeSet, int i, String str) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "emptyMessage");
        this.emptyMessage = str;
        init();
    }

    public final String getTempEmptyMessage() {
        return this.tempEmptyMessage;
    }

    public final void setTempEmptyMessage(String str) {
        this.tempEmptyMessage = str;
    }

    private final void init() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setGravity(17);
        TextView textView2 = new TextView(getContext());
        this.textView = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        textView2.setTextSize(18.0f);
        TextView textView3 = this.textView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        textView3.setText(this.emptyMessage);
        TextView textView4 = this.textView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        addView(textView4, new LinearLayout.LayoutParams(-2, -2));
        ProgressBar progressBar = new ProgressBar(getContext());
        this.progress = progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progress");
        }
        addView(progressBar, new LinearLayout.LayoutParams(ConvertUtils.dp2px(48.0f), ConvertUtils.dp2px(48.0f)));
        ProgressBar progressBar2 = this.progress;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progress");
        }
        TintHelper.setTint(progressBar2, AppHolder.getAppTheme().getColorAccent());
    }

    public final void showEmpty() {
        ProgressBar progressBar = this.progress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progress");
        }
        progressBar.setVisibility(8);
        TextView textView2 = this.textView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        textView2.setVisibility(0);
        TextView textView3 = this.textView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        String str = this.tempEmptyMessage;
        if (str == null) {
            str = this.emptyMessage;
        }
        textView3.setText(str);
    }

    public final void showProgress() {
        ProgressBar progressBar = this.progress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progress");
        }
        progressBar.setVisibility(0);
        TextView textView2 = this.textView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        textView2.setVisibility(8);
        this.tempEmptyMessage = null;
    }

    public final void showRetry() {
        ProgressBar progressBar = this.progress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progress");
        }
        progressBar.setVisibility(8);
        TextView textView2 = this.textView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        textView2.setVisibility(0);
        TextView textView3 = this.textView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        }
        textView3.setText(getContext().getString(2131887024));
    }
}
