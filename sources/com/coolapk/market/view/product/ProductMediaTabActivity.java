package com.coolapk.market.view.product;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.TabActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0014¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/product/ProductMediaTabActivity;", "Lcom/coolapk/market/view/base/TabActivity;", "()V", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "position", "", "getFragmentItemTag", "", "getTabStyle", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onCreateTabs", "", "()[Ljava/lang/String;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductMediaTabActivity.kt */
public final class ProductMediaTabActivity extends TabActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_PAGE_INDEX = "PAGE_INDEX";
    public static final String EXTRA_PRODUCT_ID = "extra_product_id";
    public static final String EXTRA_RECOMMEND_FLAG = "extra_recommend_flag";
    public static final String EXTRA_TITLE = "extra_title";
    public static final int PAGE_IMAGE = 0;
    public static final int PAGE_VIDEO = 1;
    public static final String REQUEST_TYPE_IMAGE = "image";
    public static final String REQUEST_TYPE_VIDEO = "video";

    @Override // com.coolapk.market.view.base.TabActivity
    protected int getTabStyle() {
        return 1;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/product/ProductMediaTabActivity$Companion;", "", "()V", "EXTRA_PAGE_INDEX", "", "EXTRA_PRODUCT_ID", "EXTRA_RECOMMEND_FLAG", "EXTRA_TITLE", "PAGE_IMAGE", "", "PAGE_VIDEO", "REQUEST_TYPE_IMAGE", "REQUEST_TYPE_VIDEO", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductMediaTabActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        return new String[]{"图片", "视频"};
    }

    @Override // com.coolapk.market.view.base.TabActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("PAGE_INDEX", 0);
        ViewPager viewPager = getViewPager();
        Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
        viewPager.setCurrentItem(intExtra);
        Toolbar toolbar = getToolbar();
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        toolbar.setTitle(getIntent().getStringExtra("extra_title"));
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        boolean booleanExtra = getIntent().getBooleanExtra("extra_recommend_flag", false);
        String stringExtra = getIntent().getStringExtra("extra_product_id");
        Intrinsics.checkNotNull(stringExtra);
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(EXTRA_PRODUCT_ID)!!");
        if (i == 0) {
            return ProductMediaFragment.Companion.newInstance(stringExtra, "image", booleanExtra);
        }
        if (i == 1) {
            return ProductMediaFragment.Companion.newInstance(stringExtra, "video", booleanExtra);
        }
        throw new RuntimeException("Unknown position: " + i);
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String getFragmentItemTag(int i) {
        return getTabTitles()[i];
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(2131623967, menu);
        MenuItem findItem = menu.findItem(2131361933);
        boolean z = false;
        boolean booleanExtra = getIntent().getBooleanExtra("extra_recommend_flag", false);
        Intrinsics.checkNotNullExpressionValue(findItem, "item");
        if (booleanExtra) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            if (loginSession.isAdmin()) {
                z = true;
            }
        }
        findItem.setVisible(z);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131361934) {
            return super.onOptionsItemSelected(menuItem);
        }
        ActionManager.startProductMediaTabActivity(this, getIntent().getStringExtra("extra_product_id"), "待选产品图/视频", false, 0);
        return true;
    }
}
