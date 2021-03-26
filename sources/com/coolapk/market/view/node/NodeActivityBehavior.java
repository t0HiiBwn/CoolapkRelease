package com.coolapk.market.view.node;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JB\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000bH&¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/node/NodeActivityBehavior;", "", "installBackgroundView", "", "view", "Landroid/view/View;", "installFloatingView", "tabApiList", "", "Lcom/coolapk/market/model/ConfigPage;", "selectedTab", "", "factor", "Lkotlin/Function1;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "pageChangedListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "installToolbarContentView", "setAppBarBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setToolbarAlphaScrollYStartThreshold", "value", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeBehavior.kt */
public interface NodeActivityBehavior {
    void installBackgroundView(View view);

    void installFloatingView(List<? extends ConfigPage> list, int i, Function1<? super ConfigPage, ? extends EntityListFragment> function1, ViewPager.OnPageChangeListener onPageChangeListener);

    void installToolbarContentView(View view);

    void setAppBarBackground(Drawable drawable);

    void setToolbarAlphaScrollYStartThreshold(int i);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* compiled from: NodeBehavior.kt */
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.view.node.NodeActivityBehavior */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void installFloatingView$default(NodeActivityBehavior nodeActivityBehavior, List list, int i, Function1 function1, ViewPager.OnPageChangeListener onPageChangeListener, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = 0;
                }
                if ((i2 & 4) != 0) {
                    function1 = null;
                }
                nodeActivityBehavior.installFloatingView(list, i, function1, onPageChangeListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: installFloatingView");
        }
    }
}
