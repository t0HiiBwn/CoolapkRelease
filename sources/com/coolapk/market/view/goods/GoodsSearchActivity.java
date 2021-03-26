package com.coolapk.market.view.goods;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.coolapk.market.databinding.GoodsSearchBinding;
import com.coolapk.market.databinding.SearchBackHeaderBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.feed.pick.GoodsSearchListFragment;
import com.coolapk.market.view.feed.pick.SearchHeaderViewPart;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0002-.B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\u001cH\u0014J\b\u0010'\u001a\u00020(H\u0002J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020\u001cH\u0002R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R2\u0010\u0010\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\r0\r \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\r0\r\u0018\u00010\u00110\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsSearchActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "adapter", "Lcom/coolapk/market/view/goods/GoodsSearchActivity$DataAdapter;", "binding", "Lcom/coolapk/market/databinding/GoodsSearchBinding;", "isAscPriceSort", "", "priceIndicatorView", "Landroid/view/View;", "searchKeyWord", "", "searchViewPart", "Lcom/coolapk/market/view/feed/pick/SearchHeaderViewPart;", "subject", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "subscriber", "Lrx/Subscription;", "updatePricePageOnly", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "position", "", "getViewPagerFragment", "initPriceSortIndicatorView", "", "inputKeywords", "keywords", "isNavigationBarTranslucent", "onAppThemeChange", "appTheme", "Lcom/coolapk/market/AppTheme;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPageChangeListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "setFeedGoodsPickedAndFinished", "goods", "Lcom/coolapk/market/model/FeedGoods;", "setupSearchBar", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsSearchActivity.kt */
public final class GoodsSearchActivity extends FakeStatusBarActivity implements TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    public static final String RESULT_FEED_GOODS = "FEED_GOODS";
    public static final int SUGGEST_REQUEST_CODE = 349;
    private DataAdapter adapter;
    private GoodsSearchBinding binding;
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

    public static final /* synthetic */ GoodsSearchBinding access$getBinding$p(GoodsSearchActivity goodsSearchActivity) {
        GoodsSearchBinding goodsSearchBinding = goodsSearchActivity.binding;
        if (goodsSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return goodsSearchBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsSearchActivity$Companion;", "", "()V", "RESULT_FEED_GOODS", "", "SUGGEST_REQUEST_CODE", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsSearchActivity.kt */
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
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131558572);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…s, R.layout.goods_search)");
        GoodsSearchBinding goodsSearchBinding = (GoodsSearchBinding) contentView;
        this.binding = goodsSearchBinding;
        if (goodsSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsSearchBinding.addGoodsView.setOnClickListener(new GoodsSearchActivity$onCreate$1(this));
        setupSearchBar();
        GoodsSearchBinding goodsSearchBinding2 = this.binding;
        if (goodsSearchBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout = goodsSearchBinding2.tabs;
        ViewExtendsKt.setV9TabColor(tabLayout, true);
        ViewExtendsKt.setV9TabUI(tabLayout, 1);
        this.adapter = new DataAdapter(this, getSupportFragmentManager(), new String[]{"销量", "综合", "价格"});
        GoodsSearchBinding goodsSearchBinding3 = this.binding;
        if (goodsSearchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = goodsSearchBinding3.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        DataAdapter dataAdapter = this.adapter;
        if (dataAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        scrollStateViewPager.setAdapter(dataAdapter);
        GoodsSearchBinding goodsSearchBinding4 = this.binding;
        if (goodsSearchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsSearchBinding4.viewPager.addOnPageChangeListener(onPageChangeListener());
        GoodsSearchBinding goodsSearchBinding5 = this.binding;
        if (goodsSearchBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout2 = goodsSearchBinding5.tabs;
        GoodsSearchBinding goodsSearchBinding6 = this.binding;
        if (goodsSearchBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        tabLayout2.setupWithViewPager(goodsSearchBinding6.viewPager);
        GoodsSearchBinding goodsSearchBinding7 = this.binding;
        if (goodsSearchBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsSearchBinding7.tabs.addOnTabSelectedListener(new GoodsSearchActivity$onCreate$3(this));
        SearchHeaderViewPart searchHeaderViewPart = this.searchViewPart;
        if (searchHeaderViewPart != null) {
            AutoCompleteTextView autoCompleteTextView = ((SearchBackHeaderBinding) searchHeaderViewPart.getBinding()).searchText;
            Intrinsics.checkNotNullExpressionValue(autoCompleteTextView, "it.binding.searchText");
            autoCompleteTextView.setHint("搜索京东好物");
        }
        inputKeywords("");
        GoodsSearchBinding goodsSearchBinding8 = this.binding;
        if (goodsSearchBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsSearchBinding8.tabs.post(new GoodsSearchActivity$sam$java_lang_Runnable$0(new GoodsSearchActivity$onCreate$5(this)));
    }

    /* access modifiers changed from: private */
    public final void initPriceSortIndicatorView() {
        View view;
        TextView textView;
        GoodsSearchBinding goodsSearchBinding = this.binding;
        if (goodsSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View childAt = goodsSearchBinding.tabs.getChildAt(0);
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
            GoodsSearchBinding goodsSearchBinding2 = this.binding;
            if (goodsSearchBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            goodsSearchBinding2.mainContent.addView(imageView2);
            GoodsSearchActivity$initPriceSortIndicatorView$1 goodsSearchActivity$initPriceSortIndicatorView$1 = new GoodsSearchActivity$initPriceSortIndicatorView$1(textView, imageView);
            textView.addOnLayoutChangeListener(new GoodsSearchActivity$initPriceSortIndicatorView$2(goodsSearchActivity$initPriceSortIndicatorView$1));
            goodsSearchActivity$initPriceSortIndicatorView$1.invoke();
            this.priceIndicatorView = imageView2;
        }
    }

    public final Fragment getFragmentItem(int i) {
        String str = "";
        if (i == 0) {
            GoodsSearchListFragment.Companion companion = GoodsSearchListFragment.Companion;
            String str2 = this.searchKeyWord;
            if (str2 == null) {
                str2 = str;
            }
            return GoodsSearchListFragment.Companion.newInstance$default(companion, str2, "inOrderCount30Days", null, 4, null);
        } else if (i == 1) {
            GoodsSearchListFragment.Companion companion2 = GoodsSearchListFragment.Companion;
            String str3 = this.searchKeyWord;
            return GoodsSearchListFragment.Companion.newInstance$default(companion2, str3 != null ? str3 : str, "commissionShare", null, 4, null);
        } else if (i == 2) {
            GoodsSearchListFragment.Companion companion3 = GoodsSearchListFragment.Companion;
            String str4 = this.searchKeyWord;
            if (str4 != null) {
                str = str4;
            }
            return companion3.newInstance(str, "price", this.isAscPriceSort ? "asc" : "desc");
        } else {
            throw new IllegalArgumentException("unknown position " + i);
        }
    }

    /* access modifiers changed from: private */
    public final void inputKeywords(String str) {
        View view;
        String str2 = this.searchKeyWord;
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        String str3 = str;
        if (!Intrinsics.areEqual(str2, StringsKt.trim((CharSequence) str3).toString())) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj = StringsKt.trim((CharSequence) str3).toString();
            this.searchKeyWord = obj;
            String str4 = obj;
            if (str4 == null || str4.length() == 0) {
                GoodsSearchBinding goodsSearchBinding = this.binding;
                if (goodsSearchBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                TabLayout tabLayout = goodsSearchBinding.tabs;
                Intrinsics.checkNotNullExpressionValue(tabLayout, "binding.tabs");
                tabLayout.setVisibility(8);
                GoodsSearchBinding goodsSearchBinding2 = this.binding;
                if (goodsSearchBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                ScrollStateViewPager scrollStateViewPager = goodsSearchBinding2.viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
                scrollStateViewPager.setVisibility(8);
                GoodsSearchBinding goodsSearchBinding3 = this.binding;
                if (goodsSearchBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                LinearLayout linearLayout = goodsSearchBinding3.addGoodsView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.addGoodsView");
                linearLayout.setVisibility(0);
                View view2 = this.priceIndicatorView;
                if (view2 != null) {
                    ViewKt.setVisible(view2, false);
                    return;
                }
                return;
            }
            GoodsSearchBinding goodsSearchBinding4 = this.binding;
            if (goodsSearchBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TabLayout tabLayout2 = goodsSearchBinding4.tabs;
            Intrinsics.checkNotNullExpressionValue(tabLayout2, "binding.tabs");
            tabLayout2.setVisibility(0);
            GoodsSearchBinding goodsSearchBinding5 = this.binding;
            if (goodsSearchBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ScrollStateViewPager scrollStateViewPager2 = goodsSearchBinding5.viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
            scrollStateViewPager2.setVisibility(0);
            GoodsSearchBinding goodsSearchBinding6 = this.binding;
            if (goodsSearchBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout2 = goodsSearchBinding6.addGoodsView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.addGoodsView");
            linearLayout2.setVisibility(8);
            DataAdapter dataAdapter = this.adapter;
            if (dataAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            dataAdapter.notifyDataSetChanged();
            GoodsSearchBinding goodsSearchBinding7 = this.binding;
            if (goodsSearchBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ScrollStateViewPager scrollStateViewPager3 = goodsSearchBinding7.viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager3, "binding.viewPager");
            if (scrollStateViewPager3.getCurrentItem() == 2 && (view = this.priceIndicatorView) != null) {
                ViewKt.setVisible(view, true);
            }
        }
    }

    public final void setFeedGoodsPickedAndFinished(FeedGoods feedGoods) {
        Intrinsics.checkNotNullParameter(feedGoods, "goods");
        setResult(-1, new Intent().putExtra("FEED_GOODS", feedGoods));
        finish();
    }

    private final void setupSearchBar() {
        if (this.searchViewPart == null) {
            GoodsSearchBinding goodsSearchBinding = this.binding;
            if (goodsSearchBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AppBarLayout appBarLayout = goodsSearchBinding.appBar;
            Intrinsics.checkNotNullExpressionValue(appBarLayout, "binding.appBar");
            SearchHeaderViewPart searchHeaderViewPart = new SearchHeaderViewPart(this);
            LayoutInflater from = LayoutInflater.from(this);
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(this)");
            searchHeaderViewPart.createView(from, appBarLayout);
            searchHeaderViewPart.setOnKeyWords(new GoodsSearchActivity$setupSearchBar$1(this));
            appBarLayout.addView(searchHeaderViewPart.getView(), 0);
            appBarLayout.postDelayed(new GoodsSearchActivity$setupSearchBar$2(this, searchHeaderViewPart), 100);
            this.subscriber = this.subject.debounce(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new GoodsSearchActivity$setupSearchBar$3(this));
            ((SearchBackHeaderBinding) searchHeaderViewPart.getBinding()).searchText.addTextChangedListener(new GoodsSearchActivity$setupSearchBar$4(this));
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
        GoodsSearchBinding goodsSearchBinding = this.binding;
        if (goodsSearchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return (Fragment) dataAdapter.instantiateItem((ViewGroup) goodsSearchBinding.viewPager, i);
    }

    private final ViewPager.OnPageChangeListener onPageChangeListener() {
        return new GoodsSearchActivity$onPageChangeListener$1(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\fH\u0016R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/goods/GoodsSearchActivity$DataAdapter;", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "tabs", "", "", "(Lcom/coolapk/market/view/goods/GoodsSearchActivity;Landroidx/fragment/app/FragmentManager;[Ljava/lang/String;)V", "getTabs", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "any", "", "getItemTag", "getPageTitle", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsSearchActivity.kt */
    public final class DataAdapter extends FragmentStatePagerAdapter {
        private final String[] tabs;
        final /* synthetic */ GoodsSearchActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataAdapter(GoodsSearchActivity goodsSearchActivity, FragmentManager fragmentManager, String[] strArr) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(strArr, "tabs");
            this.this$0 = goodsSearchActivity;
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
