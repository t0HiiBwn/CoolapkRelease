package com.coolapk.market.view.main;

import android.os.Build;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.LogUtils;
import it.sephiroth.android.library.xtooltip.ClosePolicy;
import it.sephiroth.android.library.xtooltip.Tooltip;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainFragment.kt */
final class MainFragment$showTips$1 implements Runnable {
    final /* synthetic */ TooltipHelper $tipsHelper;
    final /* synthetic */ MainFragment this$0;

    MainFragment$showTips$1(MainFragment mainFragment, TooltipHelper tooltipHelper) {
        this.this$0 = mainFragment;
        this.$tipsHelper = tooltipHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Tooltip doOnHidden;
        Tooltip doOnShown;
        if (this.this$0.isVisible() && this.this$0.isAdded() && !this.$tipsHelper.getCoolPicSign()) {
            boolean z = Build.VERSION.SDK_INT >= 30;
            try {
                Tooltip tooltip = this.this$0.tooltip;
                if (tooltip != null) {
                    tooltip.dismiss();
                }
                MainFragment mainFragment = this.this$0;
                FragmentActivity requireActivity = mainFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                Tooltip.Builder builder = new Tooltip.Builder(requireActivity);
                AHBottomNavigation aHBottomNavigation = MainFragment.access$getBinding$p(this.this$0).bottomNavigation;
                Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
                AHBottomNavigation aHBottomNavigation2 = aHBottomNavigation;
                int i = -NumberExtendsKt.getDp((Number) 32);
                if (!z) {
                    i = 0;
                }
                mainFragment.tooltip = Tooltip.Builder.anchor$default(builder, aHBottomNavigation2, 0, i, false, 8, null).text("酷图搬到这里啦").styleId(2131952224).maxWidth(DisplayUtils.getWidthPixels(this.this$0.getActivity()) / 2).arrow(true).floatingAnimation(Tooltip.Animation.Companion.getSLOW()).closePolicy(new ClosePolicy.Builder().consume(true).inside(true).outside(true).build()).showDuration(10000).overlay(true).create();
                Tooltip tooltip2 = this.this$0.tooltip;
                if (tooltip2 != null && (doOnHidden = tooltip2.doOnHidden(new Function1<Tooltip, Unit>(this) {
                    /* class com.coolapk.market.view.main.MainFragment$showTips$1.AnonymousClass1 */
                    final /* synthetic */ MainFragment$showTips$1 this$0;

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
                        this.this$0.this$0.tooltip = null;
                    }
                })) != null && (doOnShown = doOnHidden.doOnShown(new Function1<Tooltip, Unit>(this) {
                    /* class com.coolapk.market.view.main.MainFragment$showTips$1.AnonymousClass2 */
                    final /* synthetic */ MainFragment$showTips$1 this$0;

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
                        this.this$0.$tipsHelper.tipCoolPic();
                        this.this$0.this$0.isCoolPicTipsShow = true;
                    }
                })) != null) {
                    FrameLayout frameLayout = MainFragment.access$getBinding$p(this.this$0).mainContent;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContent");
                    doOnShown.show(frameLayout, Tooltip.Gravity.TOP, true);
                }
            } catch (Exception e) {
                LogUtils.e(e);
            }
        }
    }
}
