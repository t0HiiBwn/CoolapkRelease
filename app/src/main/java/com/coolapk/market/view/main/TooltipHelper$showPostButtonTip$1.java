package com.coolapk.market.view.main;

import android.os.Build;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.DisplayUtils;
import it.sephiroth.android.library.xtooltip.ClosePolicy;
import it.sephiroth.android.library.xtooltip.Tooltip;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ToolTipHelper.kt */
final class TooltipHelper$showPostButtonTip$1 implements Runnable {
    final /* synthetic */ Tooltip.Gravity $gravity;
    final /* synthetic */ String $tipText;
    final /* synthetic */ View $view;
    final /* synthetic */ TooltipHelper this$0;

    TooltipHelper$showPostButtonTip$1(TooltipHelper tooltipHelper, View view, String str, Tooltip.Gravity gravity) {
        this.this$0 = tooltipHelper;
        this.$view = view;
        this.$tipText = str;
        this.$gravity = gravity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            FragmentActivity requireActivity = this.this$0.getFragment().requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
            int i = 0;
            boolean z = Build.VERSION.SDK_INT >= 30;
            int i2 = -6;
            if (!z) {
                i2 = 0;
            }
            if (z) {
                i = -36;
            }
            final Tooltip create = Tooltip.Builder.anchor$default(new Tooltip.Builder(requireActivity), this.$view, NumberExtendsKt.getDp(Integer.valueOf(i2)), NumberExtendsKt.getDp(Integer.valueOf(i)), false, 8, null).text(this.$tipText).styleId(2131952224).maxWidth(DisplayUtils.getWidthPixels(requireActivity) / 2).arrow(true).floatingAnimation(Tooltip.Animation.Companion.getDEFAULT()).closePolicy(new ClosePolicy.Builder().consume(true).inside(true).outside(true).build()).showDuration(8000).overlay(true).create();
            Tooltip.show$default(create.doOnFailure(AnonymousClass1.INSTANCE).doOnShown(new Function1<Tooltip, Unit>(this) {
                /* class com.coolapk.market.view.main.TooltipHelper$showPostButtonTip$1.AnonymousClass2 */
                final /* synthetic */ TooltipHelper$showPostButtonTip$1 this$0;

                {
                    this.this$0 = r1;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Tooltip tooltip) {
                    invoke(tooltip);
                    return Unit.INSTANCE;
                }

                public final void invoke(Tooltip tooltip) {
                    Intrinsics.checkNotNullParameter(tooltip, "it");
                    this.this$0.this$0.tipPostButton();
                }
            }).doOnHidden(AnonymousClass3.INSTANCE), this.$view, this.$gravity, false, 4, null);
            Lifecycle lifecycle = this.this$0.getFragment().getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "fragment.lifecycle");
            LifeCycleExtendsKt.oneTimeOnPause(lifecycle, new Function0<Unit>() {
                /* class com.coolapk.market.view.main.TooltipHelper$showPostButtonTip$1.AnonymousClass4 */

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    create.dismiss();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
