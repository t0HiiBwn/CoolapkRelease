package com.coolapk.market.view.search;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.SearchExtendBinding;
import com.coolapk.market.extend.StringExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.ThemeUtilsCompat;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.view.search.SearchMainListFragment;
import com.coolapk.market.view.search.SuperSearchFragment;
import com.coolapk.market.widget.TriangleDrawable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004=>?@B\u0005¢\u0006\u0002\u0010\u0004J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010#\u001a\u00020$H\u0016J\u000e\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\bJ\b\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020$H\u0016J\u0012\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\"\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u000205H\u0014J\b\u00106\u001a\u00020$H\u0014J\b\u00107\u001a\u00020$H\u0002J\u0006\u00108\u001a\u00020$J\u000e\u00109\u001a\u00020$2\u0006\u0010&\u001a\u00020\bJ&\u0010:\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\b2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\b8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0013\u0010\u000bR\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001c\u0010\u001d¨\u0006A"}, d2 = {"Lcom/coolapk/market/view/search/SuperSearchActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Landroid/widget/TextView$OnEditorActionListener;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/SearchExtendBinding;", "defaultSearchHint", "", "feedPageParam", "getFeedPageParam", "()Ljava/lang/String;", "feedPageParam$delegate", "Lkotlin/Lazy;", "feedPageType", "getFeedPageType", "feedPageType$delegate", "keyword", "returnType", "getReturnType", "returnType$delegate", "sceneMode", "", "sceneTitle", "searchType", "shouldBackThrough", "viewModel", "Lcom/coolapk/market/view/search/SuperSearchViewModel;", "getViewModel", "()Lcom/coolapk/market/view/search/SuperSearchViewModel;", "viewModel$delegate", "findContentFragment", "Landroidx/fragment/app/Fragment;", "findPopupFragment", "Lcom/coolapk/market/view/search/SuperSearchActivity$PopLayoutBehavior;", "finish", "", "inputKeyword", "input", "isNavigationBarTranslucent", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEditorAction", "v", "Landroid/widget/TextView;", "actionId", "", "event", "Landroid/view/KeyEvent;", "onNewIntent", "intent", "Landroid/content/Intent;", "onSetStatusBarColor", "setSearchText", "setupFilter", "updateDatabase", "updateMode", "title", "query", "BridgeAdapter", "Companion", "OnBackPressedBehavior", "PopLayoutBehavior", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SuperSearchActivity.kt */
public final class SuperSearchActivity extends FakeStatusBarActivity implements TextView.OnEditorActionListener, TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_FEED_PAGE_PARAM = "FEED_PAGE_PARAM";
    public static final String KEY_FEED_PAGE_TYPE = "FEED_PAGE_TYPE";
    public static final String KEY_KEYWORD = "KEYWORD";
    public static final String KEY_RETURN_TYPE = "RETURN_TYPE";
    public static final String KEY_SCENE_MODE = "SCENE_MODE";
    public static final String KEY_SCENE_TITLE = "SCENE_TITLE";
    public static final String KEY_SEARCH_HINT = "SEARCH_HINT";
    public static final String KEY_SEARCH_TYPE = "SEARCH_TYPE";
    public static final String RETURN_TYPE_ALL = "all";
    public static final String RETURN_TYPE_EXCLUDE_QUICK_LINK = "excludeQuickLink";
    public static final String RETURN_TYPE_ONLY_QUICK_LINK_WITH_ALL = "onlyQuickLinkWithAll";
    private SearchExtendBinding binding;
    private String defaultSearchHint;
    private final Lazy feedPageParam$delegate = LazyKt.lazy(new SuperSearchActivity$feedPageParam$2(this));
    private final Lazy feedPageType$delegate = LazyKt.lazy(new SuperSearchActivity$feedPageType$2(this));
    private String keyword;
    private final Lazy returnType$delegate = LazyKt.lazy(new SuperSearchActivity$returnType$2(this));
    private boolean sceneMode;
    private String sceneTitle;
    private String searchType;
    private boolean shouldBackThrough;
    private final Lazy viewModel$delegate = LazyKt.lazy(SuperSearchActivity$viewModel$2.INSTANCE);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/coolapk/market/view/search/SuperSearchActivity$OnBackPressedBehavior;", "", "onBackPressed", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SuperSearchActivity.kt */
    public interface OnBackPressedBehavior {
        boolean onBackPressed();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/coolapk/market/view/search/SuperSearchActivity$PopLayoutBehavior;", "Lcom/coolapk/market/view/search/SuperSearchActivity$OnBackPressedBehavior;", "Landroid/widget/Filterable;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SuperSearchActivity.kt */
    public interface PopLayoutBehavior extends OnBackPressedBehavior, Filterable {
    }

    private final String getFeedPageParam() {
        return (String) this.feedPageParam$delegate.getValue();
    }

    private final String getFeedPageType() {
        return (String) this.feedPageType$delegate.getValue();
    }

    private final String getReturnType() {
        return (String) this.returnType$delegate.getValue();
    }

    private final SuperSearchViewModel getViewModel() {
        return (SuperSearchViewModel) this.viewModel$delegate.getValue();
    }

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public static final /* synthetic */ SearchExtendBinding access$getBinding$p(SuperSearchActivity superSearchActivity) {
        SearchExtendBinding searchExtendBinding = superSearchActivity.binding;
        if (searchExtendBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return searchExtendBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/search/SuperSearchActivity$Companion;", "", "()V", "KEY_FEED_PAGE_PARAM", "", "KEY_FEED_PAGE_TYPE", "KEY_KEYWORD", "KEY_RETURN_TYPE", "KEY_SCENE_MODE", "KEY_SCENE_TITLE", "KEY_SEARCH_HINT", "KEY_SEARCH_TYPE", "RETURN_TYPE_ALL", "RETURN_TYPE_EXCLUDE_QUICK_LINK", "RETURN_TYPE_ONLY_QUICK_LINK_WITH_ALL", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SuperSearchActivity.kt */
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
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559131);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…, R.layout.search_extend)");
        this.binding = (SearchExtendBinding) contentView;
        String stringExtra = getIntent().getStringExtra("KEYWORD");
        this.keyword = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("SEARCH_HINT");
        if (stringExtra2 == null) {
            stringExtra2 = getString(2131887027);
        }
        this.defaultSearchHint = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("SEARCH_TYPE");
        if (stringExtra3 == null) {
            stringExtra3 = "all";
        }
        this.searchType = stringExtra3;
        this.sceneMode = getIntent().getBooleanExtra("SCENE_MODE", false);
        this.sceneTitle = getIntent().getStringExtra("SCENE_TITLE");
        setSearchText();
        SearchExtendBinding searchExtendBinding = this.binding;
        if (searchExtendBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = searchExtendBinding.searchPopupLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.searchPopupLayout");
        ViewExtendsKt.gone(linearLayout);
        SearchExtendBinding searchExtendBinding2 = this.binding;
        if (searchExtendBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = searchExtendBinding2.searchHeader.loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.searchHeader.loadingView");
        ViewExtendsKt.gone(progressBar);
        SearchExtendBinding searchExtendBinding3 = this.binding;
        if (searchExtendBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AutoCompleteTextView autoCompleteTextView = searchExtendBinding3.searchHeader.searchText;
        Intrinsics.checkNotNullExpressionValue(autoCompleteTextView, "binding.searchHeader.searchText");
        autoCompleteTextView.setThreshold(1);
        SearchExtendBinding searchExtendBinding4 = this.binding;
        if (searchExtendBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchExtendBinding4.searchHeader.searchText.setOnEditorActionListener(this);
        SearchExtendBinding searchExtendBinding5 = this.binding;
        if (searchExtendBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchExtendBinding5.searchHeader.searchText.addTextChangedListener(new SuperSearchActivity$onCreate$1(this));
        SearchExtendBinding searchExtendBinding6 = this.binding;
        if (searchExtendBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchExtendBinding6.searchHeader.searchButton.setOnClickListener(new SuperSearchActivity$onCreate$2(this));
        SearchExtendBinding searchExtendBinding7 = this.binding;
        if (searchExtendBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchExtendBinding7.searchHeader.navigationButton.setOnClickListener(new SuperSearchActivity$onCreate$3(this));
        SearchExtendBinding searchExtendBinding8 = this.binding;
        if (searchExtendBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchExtendBinding8.searchHeader.qrOrClearButton.setOnClickListener(new SuperSearchActivity$onCreate$4(this));
        SearchExtendBinding searchExtendBinding9 = this.binding;
        if (searchExtendBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = searchExtendBinding9.searchHeader.searchBoxLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.searchHeader.searchBoxLayout");
        UiUtils.setDrawableSolidColors(linearLayout2.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorPrimary());
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        if (appSetting.isAppHeaderSearchBackgroundTransparent()) {
            i = AppHolder.getAppTheme().getColorPrimary();
        } else {
            i = ShapeUtils.createSearchBoxColor();
        }
        SearchExtendBinding searchExtendBinding10 = this.binding;
        if (searchExtendBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout3 = searchExtendBinding10.searchHeader.searchBoxLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.searchHeader.searchBoxLayout");
        UiUtils.setDrawableSolidColors(linearLayout3.getBackground(), new int[]{1}, i);
        int pickThemeColor = ThemeUtilsCompat.INSTANCE.pickThemeColor(StringExtendsKt.colorInt("#757575"), StringExtendsKt.colorInt("#757575"), StringExtendsKt.colorInt("#FFFFFF"));
        int pickThemeColor2 = ThemeUtilsCompat.INSTANCE.pickThemeColor(StringExtendsKt.colorInt("#525252"), StringExtendsKt.colorInt("#C1C1C1"), StringExtendsKt.colorInt("#7FFFFFFF"));
        SearchExtendBinding searchExtendBinding11 = this.binding;
        if (searchExtendBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchExtendBinding11.searchHeader.searchText.setTextColor(pickThemeColor);
        SearchExtendBinding searchExtendBinding12 = this.binding;
        if (searchExtendBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchExtendBinding12.searchHeader.searchText.setHintTextColor(pickThemeColor2);
        SearchExtendBinding searchExtendBinding13 = this.binding;
        if (searchExtendBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchExtendBinding13.searchHeader.searchTypeText.setTextColor(pickThemeColor);
        SearchExtendBinding searchExtendBinding14 = this.binding;
        if (searchExtendBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = searchExtendBinding14.searchHeader.navigationIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.searchHeader.navigationIcon");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView.getDrawable()).mutate(), pickThemeColor);
        SearchExtendBinding searchExtendBinding15 = this.binding;
        if (searchExtendBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = searchExtendBinding15.searchHeader.qrView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.searchHeader.qrView");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView2.getDrawable()).mutate(), pickThemeColor);
        SearchExtendBinding searchExtendBinding16 = this.binding;
        if (searchExtendBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView3 = searchExtendBinding16.searchHeader.clearButton;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.searchHeader.clearButton");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView3.getDrawable()).mutate(), pickThemeColor);
        SearchExtendBinding searchExtendBinding17 = this.binding;
        if (searchExtendBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView4 = searchExtendBinding17.searchHeader.searchIcon;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.searchHeader.searchIcon");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView4.getDrawable()).mutate(), pickThemeColor);
        SearchExtendBinding searchExtendBinding18 = this.binding;
        if (searchExtendBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchExtendBinding18.searchHeader.arrowView.setImageDrawable(new TriangleDrawable(pickThemeColor));
        if (bundle == null) {
            String str = this.searchType;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchType");
            }
            updateMode(str, this.sceneTitle, stringExtra);
        } else {
            PopLayoutBehavior findPopupFragment = findPopupFragment();
            if (findPopupFragment instanceof SuperSearchFragment) {
                ((SuperSearchFragment) findPopupFragment).setSuperSearchViewModel(getViewModel());
            }
        }
        SearchExtendBinding searchExtendBinding19 = this.binding;
        if (searchExtendBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AutoCompleteTextView autoCompleteTextView2 = searchExtendBinding19.searchHeader.searchText;
        Intrinsics.checkNotNullExpressionValue(autoCompleteTextView2, "binding.searchHeader.searchText");
        ViewExtents2Kt.checkAndOpenKeyboard$default(autoCompleteTextView2, getActivity(), 0, 2, null);
    }

    private final void setSearchText() {
        String str = this.keyword;
        SearchExtendBinding searchExtendBinding = this.binding;
        if (searchExtendBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        String str2 = str;
        searchExtendBinding.searchHeader.searchText.setText(str2);
        if (str != null) {
            boolean z = true;
            int i = 0;
            if (str2.length() > 0) {
                SearchExtendBinding searchExtendBinding2 = this.binding;
                if (searchExtendBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                searchExtendBinding2.searchHeader.searchText.setSelection(str.length());
                SearchExtendBinding searchExtendBinding3 = this.binding;
                if (searchExtendBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                FrameLayout frameLayout = searchExtendBinding3.searchHeader.qrOrClearButton;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.searchHeader.qrOrClearButton");
                if (str2.length() <= 0) {
                    z = false;
                }
                if (!z) {
                    i = 8;
                }
                frameLayout.setVisibility(i);
                return;
            }
        }
        SearchExtendBinding searchExtendBinding4 = this.binding;
        if (searchExtendBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout2 = searchExtendBinding4.searchHeader.qrOrClearButton;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.searchHeader.qrOrClearButton");
        ViewExtendsKt.gone(frameLayout2);
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(textView, "v");
        if (i != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        if (this.sceneMode) {
            return true;
        }
        inputKeyword(textView.getText().toString());
        return true;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("KEYWORD");
        String stringExtra2 = intent.getStringExtra("SEARCH_TYPE");
        Intrinsics.checkNotNull(stringExtra2);
        Intrinsics.checkNotNullExpressionValue(stringExtra2, "intent.getStringExtra(KEY_SEARCH_TYPE)!!");
        String stringExtra3 = intent.getStringExtra("SCENE_TITLE");
        if (!(!Intrinsics.areEqual(stringExtra, this.keyword))) {
            String str = this.searchType;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchType");
            }
            if (!(!Intrinsics.areEqual(stringExtra2, str)) && !(!Intrinsics.areEqual(stringExtra3, this.sceneTitle))) {
                return;
            }
        }
        setSearchText();
        updateMode(stringExtra2, stringExtra3, stringExtra);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            if (this.shouldBackThrough) {
                super.onBackPressed();
                return;
            }
            PopLayoutBehavior findPopupFragment = findPopupFragment();
            if (findPopupFragment != null ? findPopupFragment.onBackPressed() : false) {
                SearchExtendBinding searchExtendBinding = this.binding;
                if (searchExtendBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                LinearLayout linearLayout = searchExtendBinding.searchPopupLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.searchPopupLayout");
                ViewExtendsKt.gone(linearLayout);
                return;
            }
            super.onBackPressed();
        } catch (Exception e) {
            e.printStackTrace();
            super.onBackPressed();
        }
    }

    public static /* synthetic */ void updateMode$default(SuperSearchActivity superSearchActivity, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        superSearchActivity.updateMode(str, str2, str3);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void updateMode(String str, String str2, String str3) {
        SuperSearchFragment superSearchFragment;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str, "searchType");
        boolean z = false;
        this.shouldBackThrough = false;
        this.keyword = str8;
        this.sceneTitle = str2;
        this.searchType = str;
        Integer num = null;
        if (this.sceneMode) {
            SearchExtendBinding searchExtendBinding = this.binding;
            if (searchExtendBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AutoCompleteTextView autoCompleteTextView = searchExtendBinding.searchHeader.searchText;
            Intrinsics.checkNotNullExpressionValue(autoCompleteTextView, "binding.searchHeader.searchText");
            autoCompleteTextView.setImeOptions(6);
            SearchExtendBinding searchExtendBinding2 = this.binding;
            if (searchExtendBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AutoCompleteTextView autoCompleteTextView2 = searchExtendBinding2.searchHeader.searchText;
            Intrinsics.checkNotNullExpressionValue(autoCompleteTextView2, "binding.searchHeader.searchText");
            String str9 = str2;
            if (str9 == null || str9.length() == 0) {
                z = true;
            }
            if (z) {
                str7 = this.defaultSearchHint;
            } else {
                str7 = "搜索" + str2;
            }
            autoCompleteTextView2.setHint(str7);
            SearchExtendBinding searchExtendBinding3 = this.binding;
            if (searchExtendBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout = searchExtendBinding3.searchHeader.searchButton;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.searchHeader.searchButton");
            ViewExtendsKt.gone(frameLayout);
            String str10 = null;
            String str11 = str8;
            if (!TextUtils.isEmpty(str11)) {
                SearchExtendBinding searchExtendBinding4 = this.binding;
                if (searchExtendBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                searchExtendBinding4.searchHeader.searchText.setText(str11);
                SearchExtendBinding searchExtendBinding5 = this.binding;
                if (searchExtendBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                AutoCompleteTextView autoCompleteTextView3 = searchExtendBinding5.searchHeader.searchText;
                Intrinsics.checkNotNull(str3);
                autoCompleteTextView3.setSelection(str3.length());
            } else {
                SearchExtendBinding searchExtendBinding6 = this.binding;
                if (searchExtendBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                AutoCompleteTextView autoCompleteTextView4 = searchExtendBinding6.searchHeader.searchText;
                Intrinsics.checkNotNullExpressionValue(autoCompleteTextView4, "binding.searchHeader.searchText");
                String obj = autoCompleteTextView4.getText().toString();
                str8 = !TextUtils.isEmpty(obj) ? obj : str10;
            }
            if (!TextUtils.isEmpty(str8)) {
                SearchExtendBinding searchExtendBinding7 = this.binding;
                if (searchExtendBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                LinearLayout linearLayout = searchExtendBinding7.searchPopupLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.searchPopupLayout");
                ViewExtendsKt.visible(linearLayout);
                this.shouldBackThrough = true;
            }
            SearchSceneListFragment newInstance = SearchSceneListFragment.Companion.newInstance(str);
            SuperSearchFragment newInstance$default = SuperSearchFragment.Companion.newInstance$default(SuperSearchFragment.Companion, str, str8, null, null, 12, null);
            newInstance$default.setUseFilter(true);
            newInstance$default.setSuperSearchViewModel(getViewModel());
            getSupportFragmentManager().beginTransaction().replace(2131363322, newInstance).replace(2131363330, newInstance$default).commit();
            return;
        }
        if (getFeedPageType() == null) {
            superSearchFragment = SearchRecommendListFragment.Companion.newInstance();
            SearchExtendBinding searchExtendBinding8 = this.binding;
            if (searchExtendBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AutoCompleteTextView autoCompleteTextView5 = searchExtendBinding8.searchHeader.searchText;
            Intrinsics.checkNotNullExpressionValue(autoCompleteTextView5, "binding.searchHeader.searchText");
            autoCompleteTextView5.setImeOptions(3);
            SearchExtendBinding searchExtendBinding9 = this.binding;
            if (searchExtendBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout2 = searchExtendBinding9.searchHeader.searchButton;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.searchHeader.searchButton");
            ViewExtendsKt.visible(frameLayout2);
            SearchExtendBinding searchExtendBinding10 = this.binding;
            if (searchExtendBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AutoCompleteTextView autoCompleteTextView6 = searchExtendBinding10.searchHeader.searchText;
            Intrinsics.checkNotNullExpressionValue(autoCompleteTextView6, "binding.searchHeader.searchText");
            autoCompleteTextView6.setHint(this.defaultSearchHint);
        } else {
            superSearchFragment = SuperSearchFragment.Companion.newInstance("feed", this.keyword, getFeedPageType(), getFeedPageParam());
            SuperSearchFragment superSearchFragment2 = superSearchFragment;
            superSearchFragment2.setUseFilter(true);
            superSearchFragment2.setSuperSearchViewModel(getViewModel());
            SearchExtendBinding searchExtendBinding11 = this.binding;
            if (searchExtendBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AutoCompleteTextView autoCompleteTextView7 = searchExtendBinding11.searchHeader.searchText;
            Intrinsics.checkNotNullExpressionValue(autoCompleteTextView7, "binding.searchHeader.searchText");
            autoCompleteTextView7.setImeOptions(6);
            SearchExtendBinding searchExtendBinding12 = this.binding;
            if (searchExtendBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout3 = searchExtendBinding12.searchHeader.searchButton;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.searchHeader.searchButton");
            ViewExtendsKt.gone(frameLayout3);
            SearchExtendBinding searchExtendBinding13 = this.binding;
            if (searchExtendBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AutoCompleteTextView autoCompleteTextView8 = searchExtendBinding13.searchHeader.searchText;
            Intrinsics.checkNotNullExpressionValue(autoCompleteTextView8, "binding.searchHeader.searchText");
            String feedPageType = getFeedPageType();
            if (feedPageType != null) {
                switch (feedPageType.hashCode()) {
                    case 96796:
                        if (feedPageType.equals("apk")) {
                            break;
                        }
                        break;
                    case 114586:
                        if (feedPageType.equals("tag")) {
                            break;
                        }
                        break;
                    case 3599307:
                        if (feedPageType.equals("user")) {
                            String feedPageParam = getFeedPageParam();
                            List split$default = feedPageParam != null ? StringsKt.split$default((CharSequence) feedPageParam, new String[]{"|"}, false, 0, 6, (Object) null) : null;
                            if (!(split$default == null || (str6 = (String) split$default.get(1)) == null)) {
                                num = Integer.valueOf(Integer.parseInt(str6));
                            }
                            if (num != null && num.intValue() == 1) {
                                str5 = "搜索他的动态";
                            } else {
                                str5 = (num != null && num.intValue() == 0) ? "搜索她的动态" : "搜索TA的动态";
                            }
                            str4 = str5;
                            break;
                        }
                        break;
                    case 1382923806:
                        if (feedPageType.equals("product_phone")) {
                            break;
                        }
                        break;
                }
                autoCompleteTextView8.setHint(str4);
            }
            autoCompleteTextView8.setHint(str4);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        SearchMainListFragment.Companion companion = SearchMainListFragment.Companion;
        String returnType = getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "returnType");
        beginTransaction.replace(2131363322, companion.newInstance(returnType)).replace(2131363330, superSearchFragment).commit();
    }

    public final void setupFilter() {
        SearchExtendBinding searchExtendBinding = this.binding;
        if (searchExtendBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        searchExtendBinding.searchHeader.searchText.setAdapter(new BridgeAdapter());
    }

    public final void inputKeyword(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        if (TextUtils.isEmpty(str)) {
            SearchExtendBinding searchExtendBinding = this.binding;
            if (searchExtendBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AutoCompleteTextView autoCompleteTextView = searchExtendBinding.searchHeader.searchText;
            Intrinsics.checkNotNullExpressionValue(autoCompleteTextView, "binding.searchHeader.searchText");
            CharSequence hint = autoCompleteTextView.getHint();
            if (hint != null && !TextUtils.equals(hint, getString(2131887027))) {
                str = hint.toString();
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            updateDatabase(str);
            BaseActivity activity = getActivity();
            String str2 = this.searchType;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchType");
            }
            ActionManager.startSuperSearchResultActivity(activity, str, str2, getReturnType(), getFeedPageType(), getFeedPageParam());
            finish();
        }
    }

    public final void updateDatabase(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        Cursor query = instance.getDataBase().query("SELECT * FROM searchHistory WHERE keyword =?", str);
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("keyword", str);
        contentValues.put("modified", Long.valueOf(currentTimeMillis));
        if (query != null) {
            if (query.moveToFirst()) {
                long j = query.getLong(0);
                DataManager instance2 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                instance2.getDataBase().update("searchHistory", contentValues, "_id =?", String.valueOf(j));
            } else {
                contentValues.put("created", Long.valueOf(currentTimeMillis));
                DataManager instance3 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
                instance3.getDataBase().insert("searchHistory", contentValues);
            }
            query.close();
        }
        finish();
    }

    private final Fragment findContentFragment() {
        return getSupportFragmentManager().findFragmentById(2131363322);
    }

    /* access modifiers changed from: private */
    public final PopLayoutBehavior findPopupFragment() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(2131363330);
        if (!(findFragmentById instanceof PopLayoutBehavior)) {
            findFragmentById = null;
        }
        return (PopLayoutBehavior) findFragmentById;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/search/SuperSearchActivity$BridgeAdapter;", "Landroid/widget/BaseAdapter;", "Landroid/widget/Filterable;", "(Lcom/coolapk/market/view/search/SuperSearchActivity;)V", "getCount", "", "getFilter", "Landroid/widget/Filter;", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SuperSearchActivity.kt */
    private final class BridgeAdapter extends BaseAdapter implements Filterable {
        @Override // android.widget.Adapter
        public int getCount() {
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(view, "convertView");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return null;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public BridgeAdapter() {
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            PopLayoutBehavior findPopupFragment = SuperSearchActivity.this.findPopupFragment();
            if (findPopupFragment != null) {
                return findPopupFragment.getFilter();
            }
            return null;
        }
    }
}
