package com.coolapk.market.view.base.refresh;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J:\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/base/refresh/ViewPagerFragment;", "", "isSupportPageMenu", "", "page", "", "obtainViewPage", "Landroidx/viewpager/widget/ViewPager;", "setCurrentItem", "", "showPageMenu", "onDismiss", "Lkotlin/Function0;", "onSelected", "Lkotlin/Function1;", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewPagerFragment.kt */
public interface ViewPagerFragment {
    boolean isSupportPageMenu(int i);

    ViewPager obtainViewPage();

    void setCurrentItem(int i);

    boolean showPageMenu(int i, Function0<Unit> function0, Function1<? super String, Unit> function1);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* compiled from: ViewPagerFragment.kt */
    public static final class DefaultImpls {
        public static boolean isSupportPageMenu(ViewPagerFragment viewPagerFragment, int i) {
            return false;
        }

        public static boolean showPageMenu(ViewPagerFragment viewPagerFragment, int i, Function0<Unit> function0, Function1<? super String, Unit> function1) {
            return false;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.coolapk.market.view.base.refresh.ViewPagerFragment */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean showPageMenu$default(ViewPagerFragment viewPagerFragment, int i, Function0 function0, Function1 function1, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    function0 = null;
                }
                if ((i2 & 4) != 0) {
                    function1 = null;
                }
                return viewPagerFragment.showPageMenu(i, function0, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPageMenu");
        }
    }
}
