package com.coolapk.market.view.category;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.model.AppCategory;
import com.coolapk.market.view.base.TabActivity;
import com.coolapk.market.view.category.RankingAppFragment;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/category/AppCategoryDetailActivity;", "Lcom/coolapk/market/view/base/TabActivity;", "()V", "category", "Lcom/coolapk/market/model/AppCategory;", "categoryTags", "", "", "[Ljava/lang/String;", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "position", "", "getFragmentItemTag", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateTabs", "()[Ljava/lang/String;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppCategoryDetailActivity.kt */
public final class AppCategoryDetailActivity extends TabActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_APK_TYPE = "apk_type";
    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_INDEX = "index";
    private AppCategory category;
    private String[] categoryTags;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/category/AppCategoryDetailActivity$Companion;", "", "()V", "EXTRA_APK_TYPE", "", "EXTRA_CATEGORY", "EXTRA_INDEX", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppCategoryDetailActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        Parcelable parcelableExtra = getIntent().getParcelableExtra("category");
        Intrinsics.checkNotNull(parcelableExtra);
        this.category = (AppCategory) parcelableExtra;
        AppCategory appCategory = this.category;
        if (appCategory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("category");
        }
        ArrayList arrayList = new ArrayList(appCategory.getTagList().size() + 1);
        AppCategory appCategory2 = this.category;
        if (appCategory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("category");
        }
        String title = appCategory2.getTitle();
        Intrinsics.checkNotNull(title);
        arrayList.add(title);
        AppCategory appCategory3 = this.category;
        if (appCategory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("category");
        }
        arrayList.addAll(appCategory3.getTagList());
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr = (String[]) array;
        this.categoryTags = strArr;
        if (strArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryTags");
        }
        return strArr;
    }

    @Override // com.coolapk.market.view.base.TabActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Toolbar toolbar = getToolbar();
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        AppCategory appCategory = this.category;
        if (appCategory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("category");
        }
        toolbar.setTitle(appCategory.getTitle());
        ViewPager viewPager = getViewPager();
        Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
        viewPager.setCurrentItem(getIntent().getIntExtra("index", 0));
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        if (i == 0) {
            RankingAppFragment.Companion companion = RankingAppFragment.Companion;
            AppCategory appCategory = this.category;
            if (appCategory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("category");
            }
            String id = appCategory.getId();
            Intrinsics.checkNotNull(id);
            AppCategory appCategory2 = this.category;
            if (appCategory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("category");
            }
            return companion.newInstance(id, null, appCategory2.getApkType().toString());
        }
        RankingAppFragment.Companion companion2 = RankingAppFragment.Companion;
        String[] strArr = this.categoryTags;
        if (strArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryTags");
        }
        String str = strArr[i];
        AppCategory appCategory3 = this.category;
        if (appCategory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("category");
        }
        return companion2.newInstance(null, str, appCategory3.getApkType().toString());
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String getFragmentItemTag(int i) {
        String[] strArr = this.categoryTags;
        if (strArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryTags");
        }
        return strArr[i];
    }
}
