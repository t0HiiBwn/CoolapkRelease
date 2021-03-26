package com.coolapk.market.view.base;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import com.coolapk.market.extend.DrawableExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseDialogFragment.kt */
final class BaseDialogFragment$onStart$1 implements Runnable {
    final /* synthetic */ View $decorView;
    final /* synthetic */ BaseDialogFragment this$0;

    BaseDialogFragment$onStart$1(BaseDialogFragment baseDialogFragment, View view) {
        this.this$0 = baseDialogFragment;
        this.$decorView = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Drawable background = this.$decorView.getBackground();
        if (background != null) {
            DrawableExtendsKt.findAndApplyGradientDrawable(background, new Function1<GradientDrawable, Unit>(this) {
                /* class com.coolapk.market.view.base.BaseDialogFragment$onStart$1.AnonymousClass1 */
                final /* synthetic */ BaseDialogFragment$onStart$1 this$0;

                {
                    this.this$0 = r1;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GradientDrawable gradientDrawable) {
                    invoke(gradientDrawable);
                    return Unit.INSTANCE;
                }

                public final void invoke(GradientDrawable gradientDrawable) {
                    Intrinsics.checkNotNullParameter(gradientDrawable, "$receiver");
                    gradientDrawable.setCornerRadius((float) this.this$0.this$0.getDialogCornerRadius());
                }
            });
        }
        Drawable background2 = this.$decorView.getBackground();
        if (background2 instanceof InsetDrawable) {
            Rect rect = new Rect();
            background2.getPadding(rect);
            this.$decorView.setBackground(new InsetDrawable(((InsetDrawable) background2).getDrawable(), rect.left, rect.top, rect.right, rect.bottom));
        }
    }
}
