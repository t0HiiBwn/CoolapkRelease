package com.coolapk.market.view.app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.TabActivity;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/app/AppCategoryTabActivity;", "Lcom/coolapk/market/view/base/TabActivity;", "()V", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "position", "", "getTabStyle", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateTabs", "", "", "()[Ljava/lang/String;", "CategoryList", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppCategoryTabActivity.kt */
public final class AppCategoryTabActivity extends TabActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_APK_TYPE = "EXTRA_APK_TYPE";

    @Override // com.coolapk.market.view.base.TabActivity
    protected int getTabStyle() {
        return 1;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/app/AppCategoryTabActivity$Companion;", "", "()V", "EXTRA_APK_TYPE", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppCategoryTabActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.TabActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        getToolbar().setTitle(2131887293);
        String stringExtra = getIntent().getStringExtra("EXTRA_APK_TYPE");
        if (stringExtra != null) {
            int i = 0;
            switch (stringExtra.hashCode()) {
                case 48:
                    str = "0";
                    stringExtra.equals(str);
                    break;
                case 49:
                    str = "1";
                    stringExtra.equals(str);
                    break;
                case 50:
                    if (stringExtra.equals("2")) {
                        i = 1;
                        break;
                    }
                    break;
            }
            int intValue = Integer.valueOf(i).intValue();
            ViewPager viewPager = getViewPager();
            Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
            viewPager.setCurrentItem(intValue);
        }
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        String string = getString(2131886665);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_app_category_title_app)");
        String string2 = getString(2131886666);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_app_category_title_game)");
        return new String[]{string, string2};
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        if (i == 0) {
            return CategoryList.Companion.newInstance("1");
        }
        return CategoryList.Companion.newInstance("2");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/app/AppCategoryTabActivity$CategoryList;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppCategoryTabActivity.kt */
    public static final class CategoryList extends EntityListFragment {
        public static final Companion Companion = new Companion(null);

        @JvmStatic
        public static final CategoryList newInstance(String str) {
            return Companion.newInstance(str);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/app/AppCategoryTabActivity$CategoryList$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/app/AppCategoryTabActivity$CategoryList;", "type", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: AppCategoryTabActivity.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final CategoryList newInstance(String str) {
                Intrinsics.checkNotNullParameter(str, "type");
                CategoryList categoryList = new CategoryList();
                Bundle bundle = new Bundle();
                bundle.putString("TYPE", str);
                Unit unit = Unit.INSTANCE;
                categoryList.setArguments(bundle);
                return categoryList;
            }
        }

        @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            setLoadMoreEnable(false);
            setRefreshEnable(false);
            if (getUserVisibleHint()) {
                initData();
            }
            BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558826).suitedEntityType("category").constructor(new AppCategoryTabActivity$CategoryList$onActivityCreated$1(this)).build(), 0, 2, null);
        }

        @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
        public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
            Observable<R> compose = DataManager.getInstance().getAppCategoryList(requireArguments().getString("TYPE")).compose(RxUtils.apiCommonToData());
            Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
            return compose;
        }
    }
}
