package com.coolapk.market.viewholder.v8.image;

import android.graphics.drawable.GradientDrawable;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NinePicViewPart.kt */
final class NinePicViewPart$imageCountView$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ NinePicViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NinePicViewPart$imageCountView$2(NinePicViewPart ninePicViewPart) {
        super(0);
        this.this$0 = ninePicViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final TextView invoke() {
        TextView textView = new TextView(this.this$0.getContext());
        textView.setGravity(17);
        textView.setTextSize(12.0f);
        textView.setTextColor(textView.getResources().getColor(2131100159));
        float dp = (float) NumberExtendsKt.getDp((Number) 2);
        float dp2 = (float) NumberExtendsKt.getDp((Number) 8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColor((int) 3430249845L);
        gradientDrawable.setCornerRadii(new float[]{dp, dp, dp2, dp2, dp, dp, dp, dp});
        Unit unit = Unit.INSTANCE;
        textView.setBackground(gradientDrawable);
        textView.setPadding(NumberExtendsKt.getDp((Number) 6), NumberExtendsKt.getDp((Number) 2), NumberExtendsKt.getDp((Number) 6), NumberExtendsKt.getDp((Number) 2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        Unit unit2 = Unit.INSTANCE;
        textView.setLayoutParams(layoutParams);
        return textView;
    }
}
