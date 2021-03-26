package com.coolapk.market.view.goods;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewKt;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.GoodsCouponSearchBinding;
import com.coolapk.market.databinding.SearchBackHeaderBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.feed.pick.GoodsCouponSearchListFragment;
import com.coolapk.market.view.feed.pick.GoodsSearchListFragment;
import com.coolapk.market.view.feed.pick.SearchHeaderViewPart;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0002+,B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\tJ\b\u0010 \u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020\u001cH\u0014J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u001cH\u0002R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R2\u0010\u0010\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\r0\r \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\r0\r\u0018\u00010\u00110\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsCouponSearchActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "adapter", "Lcom/coolapk/market/view/goods/GoodsCouponSearchActivity$DataAdapter;", "binding", "Lcom/coolapk/market/databinding/GoodsCouponSearchBinding;", "isAscPriceSort", "", "priceIndicatorView", "Landroid/view/View;", "searchKeyWord", "", "searchViewPart", "Lcom/coolapk/market/view/feed/pick/SearchHeaderViewPart;", "subject", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "subscriber", "Lrx/Subscription;", "updatePricePageOnly", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "position", "", "getViewPagerFragment", "initPriceSortIndicatorView", "", "inputKeywords", "keywords", "updateSearchText", "isNavigationBarTranslucent", "onAppThemeChange", "appTheme", "Lcom/coolapk/market/AppTheme;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPageChangeListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "setupSearchBar", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsCouponSearchActivity.kt */
public final class GoodsCouponSearchActivity extends FakeStatusBarActivity implements TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_KEYWORD = "extra_key_word";
    private DataAdapter adapter;
    private GoodsCouponSearchBinding binding;
    private boolean isAscPriceSort = true;
    private View priceIndicatorView;
    private String searchKeyWord;
    private SearchHeaderViewPart searchViewPart;
    private PublishSubject<String> subject = PublishSubject.create();
    private Subscription subscriber;
    private boolean updatePricePageOnly;

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public static final /* synthetic */ GoodsCouponSearchBinding access$getBinding$p(GoodsCouponSearchActivity goodsCouponSearchActivity) {
        GoodsCouponSearchBinding goodsCouponSearchBinding = goodsCouponSearchActivity.binding;
        if (goodsCouponSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return goodsCouponSearchBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsCouponSearchActivity$Companion;", "", "()V", "EXTRA_KEYWORD", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsCouponSearchActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131558570);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…yout.goods_coupon_search)");
        this.binding = (GoodsCouponSearchBinding) contentView;
        setupSearchBar();
        GoodsCouponSearchBinding goodsCouponSearchBinding = this.binding;
        if (goodsCouponSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout = goodsCouponSearchBinding.tabs;
        ViewExtendsKt.setV9TabColor(tabLayout, true);
        ViewExtendsKt.setV9TabUI(tabLayout, 1);
        this.adapter = new DataAdapter(this, getSupportFragmentManager(), new String[]{"销量", "综合", "价格"});
        GoodsCouponSearchBinding goodsCouponSearchBinding2 = this.binding;
        if (goodsCouponSearchBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = goodsCouponSearchBinding2.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        DataAdapter dataAdapter = this.adapter;
        if (dataAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        scrollStateViewPager.setAdapter(dataAdapter);
        GoodsCouponSearchBinding goodsCouponSearchBinding3 = this.binding;
        if (goodsCouponSearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsCouponSearchBinding3.viewPager.addOnPageChangeListener(onPageChangeListener());
        GoodsCouponSearchBinding goodsCouponSearchBinding4 = this.binding;
        if (goodsCouponSearchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout2 = goodsCouponSearchBinding4.tabs;
        GoodsCouponSearchBinding goodsCouponSearchBinding5 = this.binding;
        if (goodsCouponSearchBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        tabLayout2.setupWithViewPager(goodsCouponSearchBinding5.viewPager);
        GoodsCouponSearchBinding goodsCouponSearchBinding6 = this.binding;
        if (goodsCouponSearchBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsCouponSearchBinding6.tabs.addOnTabSelectedListener(new GoodsCouponSearchActivity$onCreate$2(this));
        String stringExtra = getIntent().getStringExtra("extra_key_word");
        if (stringExtra == null) {
            stringExtra = "";
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(EXTRA_KEYWORD) ?: \"\"");
        SearchHeaderViewPart searchHeaderViewPart = this.searchViewPart;
        if (searchHeaderViewPart != null) {
            AutoCompleteTextView autoCompleteTextView = ((SearchBackHeaderBinding) searchHeaderViewPart.getBinding()).searchText;
            Intrinsics.checkNotNullExpressionValue(autoCompleteTextView, "it.binding.searchText");
            autoCompleteTextView.setHint("搜索海量优惠券");
        }
        inputKeywords(stringExtra, true);
        GoodsCouponSearchBinding goodsCouponSearchBinding7 = this.binding;
        if (goodsCouponSearchBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsCouponSearchBinding7.tabs.post(new GoodsCouponSearchActivity$sam$java_lang_Runnable$0(new GoodsCouponSearchActivity$onCreate$4(this)));
        if (getSupportFragmentManager().findFragmentById(2131362322) == null) {
            getSupportFragmentManager().beginTransaction().add(2131362322, GoodsSearchMainListFragment.Companion.newInstance()).commit();
        }
    }

    /* access modifiers changed from: private */
    public final void initPriceSortIndicatorView() {
        View view;
        TextView textView;
        GoodsCouponSearchBinding goodsCouponSearchBinding = this.binding;
        if (goodsCouponSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View childAt = goodsCouponSearchBinding.tabs.getChildAt(0);
        ViewGroup viewGroup = null;
        if (!(childAt instanceof ViewGroup)) {
            childAt = null;
        }
        ViewGroup viewGroup2 = (ViewGroup) childAt;
        if (viewGroup2 != null) {
            view = viewGroup2.getChildAt(2);
        } else {
            view = null;
        }
        if (view instanceof ViewGroup) {
            viewGroup = view;
        }
        ViewGroup viewGroup3 = viewGroup;
        if (viewGroup3 != null && (textView = (TextView) UiUtils.findFirstChildViewByType(viewGroup3, TextView.class)) != null) {
            ImageView imageView = new ImageView(getActivity());
            DrawSystemBarFrameLayout.LayoutParams layoutParams = new DrawSystemBarFrameLayout.LayoutParams(NumberExtendsKt.getDp((Number) 24), NumberExtendsKt.getDp((Number) 24));
            layoutParams.drawStatusBar = true;
            Unit unit = Unit.INSTANCE;
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleX(0.75f);
            imageView.setScaleY(0.75f);
            imageView.setImageResource(2131231166);
            AppTheme appTheme = AppHolder.getAppTheme();
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            imageView.setImageTintList(ColorStateList.valueOf(appTheme.getTabIndicatorColor(context)));
            ImageView imageView2 = imageView;
            imageView2.setVisibility(8);
            GoodsCouponSearchBinding goodsCouponSearchBinding2 = this.binding;
            if (goodsCouponSearchBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            goodsCouponSearchBinding2.mainContent.addView(imageView2);
            GoodsCouponSearchActivity$initPriceSortIndicatorView$1 goodsCouponSearchActivity$initPriceSortIndicatorView$1 = new GoodsCouponSearchActivity$initPriceSortIndicatorView$1(textView, imageView);
            textView.addOnLayoutChangeListener(new GoodsCouponSearchActivity$initPriceSortIndicatorView$2(goodsCouponSearchActivity$initPriceSortIndicatorView$1));
            goodsCouponSearchActivity$initPriceSortIndicatorView$1.invoke();
            this.priceIndicatorView = imageView2;
        }
    }

    public final Fragment getFragmentItem(int i) {
        String str = "";
        if (i == 0) {
            GoodsCouponSearchListFragment.Companion companion = GoodsCouponSearchListFragment.Companion;
            String str2 = this.searchKeyWord;
            if (str2 == null) {
                str2 = str;
            }
            return GoodsCouponSearchListFragment.Companion.newInstance$default(companion, str2, "inOrderCount30Days", null, 4, null);
        } else if (i == 1) {
            GoodsCouponSearchListFragment.Companion companion2 = GoodsCouponSearchListFragment.Companion;
            String str3 = this.searchKeyWord;
            return GoodsCouponSearchListFragment.Companion.newInstance$default(companion2, str3 != null ? str3 : str, "commissionShare", null, 4, null);
        } else if (i == 2) {
            GoodsCouponSearchListFragment.Companion companion3 = GoodsCouponSearchListFragment.Companion;
            String str4 = this.searchKeyWord;
            if (str4 != null) {
                str = str4;
            }
            return companion3.newInstance(str, "price", this.isAscPriceSort ? "asc" : "desc");
        } else {
            throw new IllegalArgumentException("unknown position " + i);
        }
    }

    public static /* synthetic */ void inputKeywords$default(GoodsCouponSearchActivity goodsCouponSearchActivity, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        goodsCouponSearchActivity.inputKeywords(str, z);
    }

    public final void inputKeywords(String str, boolean z) {
        View view;
        SearchHeaderViewPart searchHeaderViewPart;
        Intrinsics.checkNotNullParameter(str, "keywords");
        String str2 = str;
        if (!Intrinsics.areEqual(this.searchKeyWord, StringsKt.trim((CharSequence) str2).toString())) {
            this.searchKeyWord = StringsKt.trim((CharSequence) str2).toString();
            if (z && (searchHeaderViewPart = this.searchViewPart) != null) {
                ((SearchBackHeaderBinding) searchHeaderViewPart.getBinding()).searchText.setText(StringsKt.trim((CharSequence) str2).toString());
                ((SearchBackHeaderBinding) searchHeaderViewPart.getBinding()).searchText.setSelection(((SearchBackHeaderBinding) searchHeaderViewPart.getBinding()).searchText.length());
            }
            String str3 = this.searchKeyWord;
            if (str3 == null || str3.length() == 0) {
                GoodsCouponSearchBinding goodsCouponSearchBinding = this.binding;
                if (goodsCouponSearchBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                TabLayout tabLayout = goodsCouponSearchBinding.tabs;
                Intrinsics.checkNotNullExpressionValue(tabLayout, "binding.tabs");
                tabLayout.setVisibility(8);
                GoodsCouponSearchBinding goodsCouponSearchBinding2 = this.binding;
                if (goodsCouponSearchBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                ScrollStateViewPager scrollStateViewPager = goodsCouponSearchBinding2.viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
                scrollStateViewPager.setVisibility(8);
                GoodsCouponSearchBinding goodsCouponSearchBinding3 = this.binding;
                if (goodsCouponSearchBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                FrameLayout frameLayout = goodsCouponSearchBinding3.contentView;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.contentView");
                frameLayout.setVisibility(0);
                View view2 = this.priceIndicatorView;
                if (view2 != null) {
                    ViewKt.setVisible(view2, false);
                    return;
                }
                return;
            }
            GoodsCouponSearchBinding goodsCouponSearchBinding4 = this.binding;
            if (goodsCouponSearchBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TabLayout tabLayout2 = goodsCouponSearchBinding4.tabs;
            Intrinsics.checkNotNullExpressionValue(tabLayout2, "binding.tabs");
            tabLayout2.setVisibility(0);
            GoodsCouponSearchBinding goodsCouponSearchBinding5 = this.binding;
            if (goodsCouponSearchBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ScrollStateViewPager scrollStateViewPager2 = goodsCouponSearchBinding5.viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
            scrollStateViewPager2.setVisibility(0);
            GoodsCouponSearchBinding goodsCouponSearchBinding6 = this.binding;
            if (goodsCouponSearchBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout2 = goodsCouponSearchBinding6.contentView;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.contentView");
            frameLayout2.setVisibility(8);
            DataAdapter dataAdapter = this.adapter;
            if (dataAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            dataAdapter.notifyDataSetChanged();
            GoodsCouponSearchBinding goodsCouponSearchBinding7 = this.binding;
            if (goodsCouponSearchBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ScrollStateViewPager scrollStateViewPager3 = goodsCouponSearchBinding7.viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager3, "binding.viewPager");
            if (scrollStateViewPager3.getCurrentItem() == 2 && (view = this.priceIndicatorView) != null) {
                ViewKt.setVisible(view, true);
            }
            GoodsSearchHistoryHelper.INSTANCE.addWords(str);
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(2131362322);
            if (!(findFragmentById instanceof GoodsSearchMainListFragment)) {
                findFragmentById = null;
            }
            GoodsSearchMainListFragment goodsSearchMainListFragment = (GoodsSearchMainListFragment) findFragmentById;
            if (goodsSearchMainListFragment != null) {
                goodsSearchMainListFragment.loadHistory();
            }
        }
    }

    private final void setupSearchBar() {
        if (this.searchViewPart == null) {
            GoodsCouponSearchBinding goodsCouponSearchBinding = this.binding;
            if (goodsCouponSearchBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AppBarLayout appBarLayout = goodsCouponSearchBinding.appBar;
            Intrinsics.checkNotNullExpressionValue(appBarLayout, "binding.appBar");
            SearchHeaderViewPart searchHeaderViewPart = new SearchHeaderViewPart(this);
            LayoutInflater from = LayoutInflater.from(this);
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(this)");
            searchHeaderViewPart.createView(from, appBarLayout);
            searchHeaderViewPart.setOnKeyWords(new GoodsCouponSearchActivity$setupSearchBar$1(this));
            appBarLayout.addView(searchHeaderViewPart.getView(), 0);
            appBarLayout.postDelayed(new GoodsCouponSearchActivity$setupSearchBar$2(this, searchHeaderViewPart), 100);
            this.subscriber = this.subject.debounce(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new GoodsCouponSearchActivity$setupSearchBar$3(this));
            ((SearchBackHeaderBinding) searchHeaderViewPart.getBinding()).searchText.addTextChangedListener(new GoodsCouponSearchActivity$setupSearchBar$4(this));
            this.searchViewPart = searchHeaderViewPart;
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    public void onAppThemeChange(AppTheme appTheme) {
        Intrinsics.checkNotNullParameter(appTheme, "appTheme");
        recreate();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.subscriber;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.subscriber = null;
    }

    public final Fragment getViewPagerFragment(int i) {
        DataAdapter dataAdapter = this.adapter;
        if (dataAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        GoodsCouponSearchBinding goodsCouponSearchBinding = this.binding;
        if (goodsCouponSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return (Fragment) dataAdapter.instantiateItem((ViewGroup) goodsCouponSearchBinding.viewPager, i);
    }

    private final ViewPager.OnPageChangeListener onPageChangeListener() {
        return new GoodsCouponSearchActivity$onPageChangeListener$1(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\fH\u0016R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsCouponSearchActivity$DataAdapter;", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "tabs", "", "", "(Lcom/coolapk/market/view/goods/GoodsCouponSearchActivity;Landroidx/fragment/app/FragmentManager;[Ljava/lang/String;)V", "getTabs", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "any", "", "getItemTag", "getPageTitle", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsCouponSearchActivity.kt */
    public final class DataAdapter extends FragmentStatePagerAdapter {
        private final String[] tabs;
        final /* synthetic */ GoodsCouponSearchActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataAdapter(GoodsCouponSearchActivity goodsCouponSearchActivity, FragmentManager fragmentManager, String[] strArr) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(strArr, "tabs");
            this.this$0 = goodsCouponSearchActivity;
            this.tabs = strArr;
        }

        public final String[] getTabs() {
            return this.tabs;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return this.this$0.getFragmentItem(i);
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(int i) {
            return this.tabs[i];
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.tabs.length;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.tabs[i];
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "any");
            if (!this.this$0.updatePricePageOnly) {
                return -2;
            }
            if (!(obj instanceof GoodsSearchListFragment) || !Intrinsics.areEqual(((GoodsSearchListFragment) obj).getSortName(), "price")) {
                return -1;
            }
            return -2;
        }
    }
}
