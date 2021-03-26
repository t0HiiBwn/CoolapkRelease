package com.coolapk.market.view.product;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.view.base.TabActivity;
import com.coolapk.market.view.product.ProductBuyListFragment;
import com.coolapk.market.view.product.ProductWishListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/product/ProductBuyAndWishListActivity;", "Lcom/coolapk/market/view/base/TabActivity;", "()V", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "position", "", "getTabStyle", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateTabs", "", "", "()[Ljava/lang/String;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductBuyAndWishListActivity.kt */
public final class ProductBuyAndWishListActivity extends TabActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_ID = "EXTRA_ID";
    public static final String EXTRA_PAGE = "EXTRA_PAGE";
    public static final int PAGE_BUY = 1;
    public static final int PAGE_WISH = 0;

    @Override // com.coolapk.market.view.base.TabActivity
    protected int getTabStyle() {
        return 1;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/product/ProductBuyAndWishListActivity$Companion;", "", "()V", "EXTRA_ID", "", "EXTRA_PAGE", "PAGE_BUY", "", "PAGE_WISH", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductBuyAndWishListActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.TabActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Toolbar toolbar = getToolbar();
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        toolbar.setTitle("标记的人");
        ViewPager viewPager = getViewPager();
        Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
        viewPager.setCurrentItem(getIntent().getIntExtra("EXTRA_PAGE", 0));
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        return new String[]{"想买", "买过"};
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        if (i == 0) {
            ProductWishListFragment.Companion companion = ProductWishListFragment.Companion;
            String stringExtra = getIntent().getStringExtra("EXTRA_ID");
            Intrinsics.checkNotNull(stringExtra);
            Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(EXTRA_ID)!!");
            return companion.newInstance(stringExtra);
        } else if (i == 1) {
            ProductBuyListFragment.Companion companion2 = ProductBuyListFragment.Companion;
            String stringExtra2 = getIntent().getStringExtra("EXTRA_ID");
            Intrinsics.checkNotNull(stringExtra2);
            Intrinsics.checkNotNullExpressionValue(stringExtra2, "intent.getStringExtra(EXTRA_ID)!!");
            return companion2.newInstance(stringExtra2);
        } else {
            throw new RuntimeException("fuck fuck fuck...");
        }
    }
}
