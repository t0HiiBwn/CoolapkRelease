package com.coolapk.market.widget.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.ResourceUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/widget/view/CapsuleView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "imageView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "setImageDrawable", "", "drawable", "Landroid/graphics/drawable/Drawable;", "setImageResource", "res", "", "setText", "text", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CapsuleView.kt */
public final class CapsuleView extends LinearLayout {
    private final ImageView imageView;
    private final TextView textView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CapsuleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
        setGravity(16);
        setPadding(NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 8));
        setBackground(new ColorDrawable(AppHolder.getAppTheme().getColorAccent()));
        ViewExtendsKt.setCompatForeground(this, ResourceUtils.getDrawable(context, ResourceUtils.resolveResId(context, 16843534)));
        ViewExtendsKt.clipView$default(this, 2, 0.0f, 2, null);
        setElevation((float) NumberExtendsKt.getDp((Number) 2));
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageResource(2131231669);
        Unit unit = Unit.INSTANCE;
        this.imageView = imageView2;
        TextView textView2 = new TextView(context);
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setText("发布内容");
        Unit unit2 = Unit.INSTANCE;
        this.textView = textView2;
        addView(imageView2, NumberExtendsKt.getDp((Number) 18), NumberExtendsKt.getDp((Number) 18));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = NumberExtendsKt.getDp((Number) 4);
        Unit unit3 = Unit.INSTANCE;
        addView(textView2, layoutParams);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CapsuleView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.textView.setText(str);
    }

    public final void setImageDrawable(Drawable drawable) {
        this.imageView.setImageDrawable(drawable);
    }

    public final void setImageResource(int i) {
        this.imageView.setImageResource(i);
    }
}
