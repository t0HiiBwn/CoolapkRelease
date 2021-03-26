package com.coolapk.market.view.user;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.view.base.TabActivity;
import com.coolapk.market.view.main.DataListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/user/MyDigitTabListActivity;", "Lcom/coolapk/market/view/base/TabActivity;", "()V", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "position", "", "getFragmentItemTag", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateTabs", "", "()[Ljava/lang/String;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MyDigitTabListActivity.kt */
public final class MyDigitTabListActivity extends TabActivity {
    public static final Companion Companion = new Companion(null);
    private static final int PAGE_BUY = 3;
    private static final int PAGE_FOLLOW = 0;
    private static final int PAGE_OWNER = 1;
    private static final int PAGE_WISH = 2;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/user/MyDigitTabListActivity$Companion;", "", "()V", "PAGE_BUY", "", "PAGE_FOLLOW", "PAGE_OWNER", "PAGE_WISH", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MyDigitTabListActivity.kt */
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
        getToolbar().setTitle(2131887135);
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        return new String[]{"关注", "机主", "想买", "买过"};
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        DataListFragment dataListFragment = null;
        if (i == 0) {
            dataListFragment = MyDigitDataListFragment.Companion.newInstance("#/product/followProductList?&title=我关注的数码吧");
        } else if (i == 1) {
            dataListFragment = MyDigitDataListFragment.Companion.newInstance("#/product/productList?type=owner");
        } else if (i == 2) {
            dataListFragment = MyDigitDataListFragment.Companion.newInstance("#/product/productList?type=wish");
        } else if (i == 3) {
            dataListFragment = MyDigitDataListFragment.Companion.newInstance("#/product/productList?type=buy");
        }
        Intrinsics.checkNotNull(dataListFragment);
        return dataListFragment;
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String getFragmentItemTag(int i) {
        String str = getTabTitles()[i];
        Intrinsics.checkNotNullExpressionValue(str, "tabTitles[position]");
        return str;
    }
}
