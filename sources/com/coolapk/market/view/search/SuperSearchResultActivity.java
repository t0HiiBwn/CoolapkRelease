package com.coolapk.market.view.search;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.SearchResultBinding;
import com.coolapk.market.event.TabEvent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.TabLayout;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u00012\u00020\u00022\u00020\u0003:\u000267B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020\u0018H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020$H\u0014J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0007J\b\u00103\u001a\u00020$H\u0002J\b\u00104\u001a\u00020$H\u0002J\b\u00105\u001a\u00020$H\u0002R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00128BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0014R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/coolapk/market/view/search/SuperSearchResultActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Landroid/view/View$OnClickListener;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "adapter", "Lcom/coolapk/market/view/search/SuperSearchResultActivity$DataAdapter;", "binding", "Lcom/coolapk/market/databinding/SearchResultBinding;", "feedPageParam", "", "feedPageType", "keyword", "rect", "Landroid/graphics/Rect;", "returnType", "searchType", "searchTypes", "", "getSearchTypes", "()[Ljava/lang/String;", "searchTypes$delegate", "Lkotlin/Lazy;", "shouldUpdateFragment", "", "titles", "getTitles", "titles$delegate", "viewModel", "Lcom/coolapk/market/view/search/SuperSearchViewModel;", "getViewPagerFragment", "Landroidx/fragment/app/Fragment;", "position", "", "isNavigationBarTranslucent", "onClick", "", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onPageChangeListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onSetStatusBarColor", "onTabEventChanged", "tabEvent", "Lcom/coolapk/market/event/TabEvent;", "setCurrentIndex", "setTabLayoutDoubleClickListener", "setupViewPager", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SuperSearchResultActivity.kt */
public final class SuperSearchResultActivity extends FakeStatusBarActivity implements View.OnClickListener, TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_FEED_PAGE_PARAM = "FEED_PAGE_PARAM";
    public static final String KEY_FEED_PAGE_TYPE = "FEED_PAGE_TYPE";
    public static final String KEY_KEYWORD = "keyword";
    public static final String KEY_RETURN_TYPE = "returnType";
    public static final String KEY_SEARCH_TYPE = "searchType";
    public static final String SEARCH_TYPE_ALBUM = "album";
    public static final String SEARCH_TYPE_ALL = "all";
    public static final String SEARCH_TYPE_APK = "apk";
    public static final String SEARCH_TYPE_ASK = "ask";
    public static final String SEARCH_TYPE_DYH_MIX = "dyhMix";
    public static final String SEARCH_TYPE_FEED = "feed";
    public static final String SEARCH_TYPE_FEED_TOPIC = "feedTopic";
    public static final String SEARCH_TYPE_GAME = "game";
    public static final String SEARCH_TYPE_GOODS = "goods";
    public static final String SEARCH_TYPE_GOODS_LIST = "goods_list";
    public static final String SEARCH_TYPE_PRODUCT = "product";
    public static final String SEARCH_TYPE_SECONDHAND = "ershou";
    public static final String SEARCH_TYPE_USER = "user";
    private DataAdapter adapter;
    private SearchResultBinding binding;
    private String feedPageParam;
    private String feedPageType;
    private String keyword;
    private Rect rect;
    private String returnType;
    private String searchType = "all";
    private final Lazy searchTypes$delegate = LazyKt.lazy(SuperSearchResultActivity$searchTypes$2.INSTANCE);
    private boolean shouldUpdateFragment;
    private final Lazy titles$delegate = LazyKt.lazy(new SuperSearchResultActivity$titles$2(this));
    private SuperSearchViewModel viewModel;

    /* access modifiers changed from: private */
    public final String[] getSearchTypes() {
        return (String[]) this.searchTypes$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String[] getTitles() {
        return (String[]) this.titles$delegate.getValue();
    }

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public static final /* synthetic */ SearchResultBinding access$getBinding$p(SuperSearchResultActivity superSearchResultActivity) {
        SearchResultBinding searchResultBinding = superSearchResultActivity.binding;
        if (searchResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return searchResultBinding;
    }

    public static final /* synthetic */ String access$getKeyword$p(SuperSearchResultActivity superSearchResultActivity) {
        String str = superSearchResultActivity.keyword;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyword");
        }
        return str;
    }

    public static final /* synthetic */ SuperSearchViewModel access$getViewModel$p(SuperSearchResultActivity superSearchResultActivity) {
        SuperSearchViewModel superSearchViewModel = superSearchResultActivity.viewModel;
        if (superSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return superSearchViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/search/SuperSearchResultActivity$Companion;", "", "()V", "KEY_FEED_PAGE_PARAM", "", "KEY_FEED_PAGE_TYPE", "KEY_KEYWORD", "KEY_RETURN_TYPE", "KEY_SEARCH_TYPE", "SEARCH_TYPE_ALBUM", "SEARCH_TYPE_ALL", "SEARCH_TYPE_APK", "SEARCH_TYPE_ASK", "SEARCH_TYPE_DYH_MIX", "SEARCH_TYPE_FEED", "SEARCH_TYPE_FEED_TOPIC", "SEARCH_TYPE_GAME", "SEARCH_TYPE_GOODS", "SEARCH_TYPE_GOODS_LIST", "SEARCH_TYPE_PRODUCT", "SEARCH_TYPE_SECONDHAND", "SEARCH_TYPE_USER", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SuperSearchResultActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i;
        int i2;
        int hashCode;
        setContentBarAlwaysTranslucent(true);
        super.onCreate(bundle);
        this.viewModel = new SuperSearchViewModel();
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559136);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…, R.layout.search_result)");
        this.binding = (SearchResultBinding) contentView;
        String stringExtra = getIntent().getStringExtra("searchType");
        String str = "all";
        if (stringExtra == null) {
            stringExtra = str;
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KE…_TYPE) ?: SEARCH_TYPE_ALL");
        String appMode = AppHolder.getAppMetadata().getAppMode();
        if (appMode == null || appMode.hashCode() != -1480249367 || !appMode.equals("community") || ((hashCode = stringExtra.hashCode()) == 96796 ? !stringExtra.equals("apk") : hashCode == 3165170 ? !stringExtra.equals("game") : hashCode != 92896879 || !stringExtra.equals("album"))) {
            str = stringExtra;
        }
        this.searchType = str;
        this.returnType = getIntent().getStringExtra("returnType");
        this.feedPageType = getIntent().getStringExtra("FEED_PAGE_TYPE");
        this.feedPageParam = getIntent().getStringExtra("FEED_PAGE_PARAM");
        String stringExtra2 = getIntent().getStringExtra("keyword");
        Intrinsics.checkNotNull(stringExtra2);
        this.keyword = stringExtra2;
        SearchResultBinding searchResultBinding = this.binding;
        if (searchResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = searchResultBinding.searchResultTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.searchResultTextView");
        String str2 = this.keyword;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyword");
        }
        textView.setText(str2);
        SearchResultBinding searchResultBinding2 = this.binding;
        if (searchResultBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding2.searchResultTextView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        SearchResultBinding searchResultBinding3 = this.binding;
        if (searchResultBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SuperSearchResultActivity superSearchResultActivity = this;
        ViewUtil.clickListener(searchResultBinding3.navigationButton, superSearchResultActivity);
        SearchResultBinding searchResultBinding4 = this.binding;
        if (searchResultBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.clickListener(searchResultBinding4.qrView, superSearchResultActivity);
        SearchResultBinding searchResultBinding5 = this.binding;
        if (searchResultBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.clickListener(searchResultBinding5.searchButton, superSearchResultActivity);
        SearchResultBinding searchResultBinding6 = this.binding;
        if (searchResultBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.clickListener(searchResultBinding6.searchBoxLayout, superSearchResultActivity);
        setupViewPager();
        SearchResultBinding searchResultBinding7 = this.binding;
        if (searchResultBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding7.mainContent.post(new SuperSearchResultActivity$onCreate$1(this));
        SearchResultBinding searchResultBinding8 = this.binding;
        if (searchResultBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding8.mainContent.addOnInsetChangeListener(new SuperSearchResultActivity$onCreate$2(this));
        SearchResultBinding searchResultBinding9 = this.binding;
        if (searchResultBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = searchResultBinding9.searchBoxLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.searchBoxLayout");
        UiUtils.setDrawableSolidColors(linearLayout.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorPrimary());
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        if (appSetting.isAppHeaderSearchBackgroundTransparent()) {
            i = AppHolder.getAppTheme().getColorPrimary();
        } else {
            i = ShapeUtils.createSearchBoxColor();
        }
        SearchResultBinding searchResultBinding10 = this.binding;
        if (searchResultBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = searchResultBinding10.searchBoxLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.searchBoxLayout");
        UiUtils.setDrawableSolidColors(linearLayout2.getBackground(), new int[]{1}, i);
        if (AppHolder.getAppTheme().isDarkTheme()) {
            i2 = Color.parseColor("#757575");
        } else if (AppHolder.getAppTheme().isLightColorTheme()) {
            i2 = Color.parseColor("#757575");
        } else {
            i2 = Color.parseColor("#ffffff");
        }
        SearchResultBinding searchResultBinding11 = this.binding;
        if (searchResultBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding11.searchResultTextView.setTextColor(i2);
        SearchResultBinding searchResultBinding12 = this.binding;
        if (searchResultBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding12.searchResultTextView.setHintTextColor(i2);
        SearchResultBinding searchResultBinding13 = this.binding;
        if (searchResultBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = searchResultBinding13.navigationIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.navigationIcon");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView.getDrawable()).mutate(), i2);
        SearchResultBinding searchResultBinding14 = this.binding;
        if (searchResultBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = searchResultBinding14.qrIcon;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.qrIcon");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView2.getDrawable()).mutate(), i2);
        SearchResultBinding searchResultBinding15 = this.binding;
        if (searchResultBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView3 = searchResultBinding15.searchIcon;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.searchIcon");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView3.getDrawable()).mutate(), i2);
        if (bundle != null) {
            for (String str3 : getSearchTypes()) {
                Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(str3);
                if (!(findFragmentByTag instanceof SuperSearchFragment)) {
                    findFragmentByTag = null;
                }
                SuperSearchFragment superSearchFragment = (SuperSearchFragment) findFragmentByTag;
                if (superSearchFragment != null) {
                    SuperSearchViewModel superSearchViewModel = this.viewModel;
                    if (superSearchViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    superSearchFragment.setSuperSearchViewModel(superSearchViewModel);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setTabLayoutDoubleClickListener() {
        SearchResultBinding searchResultBinding = this.binding;
        if (searchResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.setChildViewDoubleClickListener(searchResultBinding.tabs.getChildAt(0), new SuperSearchResultActivity$setTabLayoutDoubleClickListener$1(this));
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("keyword");
        if (stringExtra == null) {
            stringExtra = "";
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KEY_KEYWORD) ?: \"\"");
        String stringExtra2 = intent.getStringExtra("searchType");
        if (stringExtra2 == null) {
            stringExtra2 = "all";
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra2, "intent.getStringExtra(KE…_TYPE) ?: SEARCH_TYPE_ALL");
        String str = this.keyword;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyword");
        }
        if ((!Intrinsics.areEqual(stringExtra, str)) || (!Intrinsics.areEqual(stringExtra2, this.searchType))) {
            this.keyword = stringExtra;
            this.searchType = stringExtra2;
            SearchResultBinding searchResultBinding = this.binding;
            if (searchResultBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = searchResultBinding.searchResultTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.searchResultTextView");
            String str2 = this.keyword;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyword");
            }
            textView.setText(str2);
            setCurrentIndex();
            this.shouldUpdateFragment = true;
            DataAdapter dataAdapter = this.adapter;
            if (dataAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            dataAdapter.notifyDataSetChanged();
            this.shouldUpdateFragment = false;
        }
    }

    private final void setupViewPager() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        this.adapter = new DataAdapter(this, supportFragmentManager);
        SearchResultBinding searchResultBinding = this.binding;
        if (searchResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = searchResultBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        DataAdapter dataAdapter = this.adapter;
        if (dataAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        scrollStateViewPager.setAdapter(dataAdapter);
        SearchResultBinding searchResultBinding2 = this.binding;
        if (searchResultBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding2.viewPager.addOnPageChangeListener(onPageChangeListener());
        SuperSearchResultActivity superSearchResultActivity = this;
        int tabIndicatorColor = AppHolder.getAppTheme().getTabIndicatorColor(superSearchResultActivity);
        SearchResultBinding searchResultBinding3 = this.binding;
        if (searchResultBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding3.tabs.setSelectedTabIndicatorWidth(NumberExtendsKt.getDp((Number) 12));
        SearchResultBinding searchResultBinding4 = this.binding;
        if (searchResultBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding4.tabs.setTabIndicatorMarginBottom(NumberExtendsKt.getDp((Number) 5));
        SearchResultBinding searchResultBinding5 = this.binding;
        if (searchResultBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding5.tabs.setSelectTabIndicatorRadius(NumberExtendsKt.getDp((Number) 1));
        SearchResultBinding searchResultBinding6 = this.binding;
        if (searchResultBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding6.tabs.setSelectedTabIndicatorHeight(NumberExtendsKt.getDp((Number) 2));
        SearchResultBinding searchResultBinding7 = this.binding;
        if (searchResultBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding7.tabs.setTabTextColors(ResourceUtils.resolveData(superSearchResultActivity, 2130969533), tabIndicatorColor);
        SearchResultBinding searchResultBinding8 = this.binding;
        if (searchResultBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding8.tabs.setSelectedTabIndicatorColor(tabIndicatorColor);
        SearchResultBinding searchResultBinding9 = this.binding;
        if (searchResultBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding9.tabs.setTabTextSize((float) NumberExtendsKt.getSp((Number) 16));
        SearchResultBinding searchResultBinding10 = this.binding;
        if (searchResultBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding10.tabs.setTabSelectedTextSize((float) NumberExtendsKt.getSp((Number) 18));
        SearchResultBinding searchResultBinding11 = this.binding;
        if (searchResultBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding11.tabs.setTabSelectedTextStyle(1);
        SearchResultBinding searchResultBinding12 = this.binding;
        if (searchResultBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout = searchResultBinding12.tabs;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "binding.tabs");
        tabLayout.setTabMode(0);
        SearchResultBinding searchResultBinding13 = this.binding;
        if (searchResultBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding13.tabs.setTabMinWidth(NumberExtendsKt.getDp((Number) 48));
        SearchResultBinding searchResultBinding14 = this.binding;
        if (searchResultBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding14.tabs.setScrollableTabMinWidth(NumberExtendsKt.getDp((Number) 48));
        SearchResultBinding searchResultBinding15 = this.binding;
        if (searchResultBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding15.tabs.setTabPaddingStart(NumberExtendsKt.getDp((Number) 12));
        SearchResultBinding searchResultBinding16 = this.binding;
        if (searchResultBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding16.tabs.setTabPaddingEnd(NumberExtendsKt.getDp((Number) 12));
        SearchResultBinding searchResultBinding17 = this.binding;
        if (searchResultBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding17.tabs.setTabBackgroundResId(0);
        SearchResultBinding searchResultBinding18 = this.binding;
        if (searchResultBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding18.tabs.setPadding(NumberExtendsKt.getDp((Number) 6), 0, NumberExtendsKt.getDp((Number) 6), 0);
        SearchResultBinding searchResultBinding19 = this.binding;
        if (searchResultBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout2 = searchResultBinding19.tabs;
        Intrinsics.checkNotNullExpressionValue(tabLayout2, "binding.tabs");
        tabLayout2.setClipToPadding(false);
        SearchResultBinding searchResultBinding20 = this.binding;
        if (searchResultBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout3 = searchResultBinding20.tabs;
        Intrinsics.checkNotNullExpressionValue(tabLayout3, "binding.tabs");
        tabLayout3.setClipChildren(false);
        SearchResultBinding searchResultBinding21 = this.binding;
        if (searchResultBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchResultBinding21.tabs.applyModeAndGravity();
        SearchResultBinding searchResultBinding22 = this.binding;
        if (searchResultBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout4 = searchResultBinding22.tabs;
        SearchResultBinding searchResultBinding23 = this.binding;
        if (searchResultBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        tabLayout4.setupWithViewPager(searchResultBinding23.viewPager);
        setCurrentIndex();
    }

    private final void setCurrentIndex() {
        int indexOf = ArraysKt.indexOf(getSearchTypes(), this.searchType);
        if (indexOf < getTitles().length) {
            SearchResultBinding searchResultBinding = this.binding;
            if (searchResultBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            searchResultBinding.viewPager.setCurrentItem(indexOf, false);
            StatisticHelper.Companion.getInstance().recordEvent("V9搜索界面", getTitles()[indexOf]);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        switch (view.getId()) {
            case 2131363018:
                onBackPressed();
                return;
            case 2131363171:
                StatisticHelper.Companion.getInstance().recordEvent("V9搜索界面", "二维码");
                ActionManager.startQrcodeActivity(getActivity());
                return;
            case 2131363318:
            case 2131363319:
                SuperSearchResultActivity superSearchResultActivity = this;
                String str = this.keyword;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("keyword");
                }
                String[] searchTypes = getSearchTypes();
                SearchResultBinding searchResultBinding = this.binding;
                if (searchResultBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                ScrollStateViewPager scrollStateViewPager = searchResultBinding.viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
                ActionManager.startSearchActivity(superSearchResultActivity, str, null, searchTypes[scrollStateViewPager.getCurrentItem()], false, null, this.returnType, this.feedPageType, this.feedPageParam);
                return;
            default:
                return;
        }
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    public final Fragment getViewPagerFragment(int i) {
        DataAdapter dataAdapter = this.adapter;
        if (dataAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        SearchResultBinding searchResultBinding = this.binding;
        if (searchResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Object instantiateItem = dataAdapter.instantiateItem((ViewGroup) searchResultBinding.viewPager, i);
        Objects.requireNonNull(instantiateItem, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return (Fragment) instantiateItem;
    }

    private final ViewPager.OnPageChangeListener onPageChangeListener() {
        return new SuperSearchResultActivity$onPageChangeListener$1(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onTabEventChanged(TabEvent tabEvent) {
        Intrinsics.checkNotNullParameter(tabEvent, "tabEvent");
        int indexOf = ArraysKt.indexOf(getSearchTypes(), tabEvent.getName());
        SearchResultBinding searchResultBinding = this.binding;
        if (searchResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = searchResultBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        scrollStateViewPager.setCurrentItem(indexOf);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/search/SuperSearchResultActivity$DataAdapter;", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Lcom/coolapk/market/view/search/SuperSearchResultActivity;Landroidx/fragment/app/FragmentManager;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "any", "", "getItemTag", "", "getPageTitle", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SuperSearchResultActivity.kt */
    private final class DataAdapter extends FragmentStatePagerAdapter {
        final /* synthetic */ SuperSearchResultActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataAdapter(SuperSearchResultActivity superSearchResultActivity, FragmentManager fragmentManager) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(fragmentManager, "fm");
            this.this$0 = superSearchResultActivity;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            SuperSearchFragment newInstance = SuperSearchFragment.Companion.newInstance(this.this$0.getSearchTypes()[i], SuperSearchResultActivity.access$getKeyword$p(this.this$0), this.this$0.feedPageType, this.this$0.feedPageParam);
            newInstance.setSuperSearchViewModel(SuperSearchResultActivity.access$getViewModel$p(this.this$0));
            return newInstance;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(int i) {
            return this.this$0.getSearchTypes()[i];
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.this$0.getTitles().length;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.this$0.getTitles()[i];
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "any");
            return this.this$0.shouldUpdateFragment ? -2 : -1;
        }
    }
}
