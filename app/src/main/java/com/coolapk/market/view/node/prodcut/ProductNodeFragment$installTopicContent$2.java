package com.coolapk.market.view.node.prodcut;

import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Product;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.node.NodeActivityBehavior;
import com.coolapk.market.view.product.ProductDataListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductNodeFragment.kt */
final class ProductNodeFragment$installTopicContent$2 implements Runnable {
    final /* synthetic */ NodeActivityBehavior $behavior;
    final /* synthetic */ Product $data;
    final /* synthetic */ int $selectedPageIndex;
    final /* synthetic */ ProductNodeFragment this$0;

    ProductNodeFragment$installTopicContent$2(ProductNodeFragment productNodeFragment, NodeActivityBehavior nodeActivityBehavior, Product product, int i) {
        this.this$0 = productNodeFragment;
        this.$behavior = nodeActivityBehavior;
        this.$data = product;
        this.$selectedPageIndex = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NodeActivityBehavior nodeActivityBehavior = this.$behavior;
        List<ConfigPage> tabApiList = this.$data.getTabApiList();
        Intrinsics.checkNotNullExpressionValue(tabApiList, "data.tabApiList");
        nodeActivityBehavior.installFloatingView(tabApiList, this.$selectedPageIndex, new Function1<ConfigPage, EntityListFragment>(this) {
            /* class com.coolapk.market.view.node.prodcut.ProductNodeFragment$installTopicContent$2.AnonymousClass1 */
            final /* synthetic */ ProductNodeFragment$installTopicContent$2 this$0;

            {
                this.this$0 = r1;
            }

            public final EntityListFragment invoke(ConfigPage configPage) {
                Intrinsics.checkNotNullParameter(configPage, "it");
                ProductDataListFragment newInstance = ProductDataListFragment.Companion.newInstance(configPage);
                newInstance.setViewModel$presentation_coolapkAppRelease(ProductNodeFragment.access$getViewModel$p(this.this$0.this$0));
                newInstance.setPresenter$presentation_coolapkAppRelease(ProductNodeFragment.access$getPresenter$p(this.this$0.this$0));
                return newInstance;
            }
        }, new ViewPager.SimpleOnPageChangeListener(this) {
            /* class com.coolapk.market.view.node.prodcut.ProductNodeFragment$installTopicContent$2.AnonymousClass2 */
            final /* synthetic */ ProductNodeFragment$installTopicContent$2 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                ConfigPage configPage = this.this$0.$data.getTabApiList().get(i);
                Intrinsics.checkNotNullExpressionValue(configPage, "data.tabApiList[position]");
                String title = configPage.getTitle();
                if (title == null) {
                    title = "";
                }
                instance.recordPhoneBarTabShowEvent(title);
            }
        });
    }
}
