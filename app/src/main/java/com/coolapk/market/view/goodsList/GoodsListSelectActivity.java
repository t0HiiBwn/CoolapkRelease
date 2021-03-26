package com.coolapk.market.view.goodsList;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.CollectionSelectBinding;
import com.coolapk.market.model.FunThings;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.goodsList.GoodsListSelectFragment;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.SlideUpView;
import com.flyco.tablayout.SlidingTabLayout;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u000245B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020!J\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\n\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0014J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0016J\u0012\u0010+\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020\u001dH\u0014J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u001dH\u0014J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodsListSelectActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/CollectionSelectBinding;", "cancelMap", "Ljava/util/LinkedHashMap;", "", "Lcom/coolapk/market/model/FunThings;", "feedId", "goodsListMap", "isSet", "", "Ljava/lang/Boolean;", "mAdapter", "Lcom/coolapk/market/view/goodsList/GoodsListSelectActivity$DataAdapter;", "mTitles", "", "[Ljava/lang/String;", "page", "", "getPage", "()I", "setPage", "(I)V", "subscription", "Lrx/Subscription;", "type", "clickDone", "", "getActionDoneView", "Landroid/widget/TextView;", "getBottomSheet", "Lcom/coolapk/market/widget/view/SlideUpView;", "getCancelMap", "getCollectionMap", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "getViewPagerFragment", "position", "initTabLayout", "initViewPager", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPageChangeListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onSetStatusBarColor", "setupFragment", "setupSlideView", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsListSelectActivity.kt */
public final class GoodsListSelectActivity extends BaseActivity {
    public static final Companion Companion = new Companion(null);
    public static final int EXTERNAL_SHARE = 1;
    public static final int INTERNAL_SHARE = 2;
    public static final String KEY_DATA = "KEY_DATA";
    public static final int REQUEST_CODE = 6666;
    private CollectionSelectBinding binding;
    private LinkedHashMap<String, FunThings> cancelMap = new LinkedHashMap<>();
    private String feedId;
    private LinkedHashMap<String, FunThings> goodsListMap = new LinkedHashMap<>();
    private Boolean isSet = false;
    private DataAdapter mAdapter;
    private final String[] mTitles = {"选择好物单"};
    private int page;
    private Subscription subscription;
    private String type;

    @JvmStatic
    public static final String getResult(Intent intent) {
        return Companion.getResult(intent);
    }

    public static final /* synthetic */ CollectionSelectBinding access$getBinding$p(GoodsListSelectActivity goodsListSelectActivity) {
        CollectionSelectBinding collectionSelectBinding = goodsListSelectActivity.binding;
        if (collectionSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return collectionSelectBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodsListSelectActivity$Companion;", "", "()V", "EXTERNAL_SHARE", "", "INTERNAL_SHARE", "KEY_DATA", "", "REQUEST_CODE", "getResult", "intent", "Landroid/content/Intent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsListSelectActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String getResult(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return intent.getStringExtra("RESULT");
        }
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(getActivity(), 2131558480);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…layout.collection_select)");
        this.binding = (CollectionSelectBinding) contentView;
        this.feedId = getIntent().getStringExtra("id");
        this.type = getIntent().getStringExtra("type");
        if (TextUtils.isEmpty(this.feedId)) {
            this.feedId = "";
        }
        setupSlideView();
        initViewPager();
        CollectionSelectBinding collectionSelectBinding = this.binding;
        if (collectionSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = collectionSelectBinding.createView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.createView");
        textView.setText("创建好物单");
        getActionDoneView().setEnabled(false);
        CollectionSelectBinding collectionSelectBinding2 = this.binding;
        if (collectionSelectBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        collectionSelectBinding2.mainContent.setOnClickListener(new GoodsListSelectActivity$onCreate$1(this));
        CollectionSelectBinding collectionSelectBinding3 = this.binding;
        if (collectionSelectBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        collectionSelectBinding3.closeView.setOnClickListener(new GoodsListSelectActivity$onCreate$2(this));
        CollectionSelectBinding collectionSelectBinding4 = this.binding;
        if (collectionSelectBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        collectionSelectBinding4.createView.setOnClickListener(new GoodsListSelectActivity$onCreate$3(this));
        initTabLayout();
        clickDone();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        CollectionSelectBinding collectionSelectBinding = this.binding;
        if (collectionSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        collectionSelectBinding.bottomSheet.dismissView();
    }

    private final void clickDone() {
        CollectionSelectBinding collectionSelectBinding = this.binding;
        if (collectionSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        collectionSelectBinding.actionDone.setOnClickListener(new GoodsListSelectActivity$clickDone$1(this));
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    public final TextView getActionDoneView() {
        CollectionSelectBinding collectionSelectBinding = this.binding;
        if (collectionSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = collectionSelectBinding.actionDone;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionDone");
        return textView;
    }

    public final LinkedHashMap<String, FunThings> getCollectionMap() {
        LinkedHashMap<String, FunThings> linkedHashMap = this.goodsListMap;
        Intrinsics.checkNotNull(linkedHashMap);
        return linkedHashMap;
    }

    public final LinkedHashMap<String, FunThings> getCancelMap() {
        LinkedHashMap<String, FunThings> linkedHashMap = this.cancelMap;
        Intrinsics.checkNotNull(linkedHashMap);
        return linkedHashMap;
    }

    public final SlideUpView getBottomSheet() {
        CollectionSelectBinding collectionSelectBinding = this.binding;
        if (collectionSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SlideUpView slideUpView = collectionSelectBinding.bottomSheet;
        Intrinsics.checkNotNullExpressionValue(slideUpView, "binding.bottomSheet");
        return slideUpView;
    }

    private final void initViewPager() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        this.mAdapter = new DataAdapter(this, supportFragmentManager);
        CollectionSelectBinding collectionSelectBinding = this.binding;
        if (collectionSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = collectionSelectBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        scrollStateViewPager.setAdapter(this.mAdapter);
        CollectionSelectBinding collectionSelectBinding2 = this.binding;
        if (collectionSelectBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        collectionSelectBinding2.viewPager.addOnPageChangeListener(onPageChangeListener());
    }

    private final ViewPager.OnPageChangeListener onPageChangeListener() {
        return new GoodsListSelectActivity$onPageChangeListener$1(this);
    }

    public final Fragment getViewPagerFragment(int i) {
        Object obj;
        DataAdapter dataAdapter = this.mAdapter;
        if (dataAdapter != null) {
            CollectionSelectBinding collectionSelectBinding = this.binding;
            if (collectionSelectBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            obj = dataAdapter.instantiateItem((ViewGroup) collectionSelectBinding.viewPager, i);
        } else {
            obj = null;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return (Fragment) obj;
    }

    private final void initTabLayout() {
        CollectionSelectBinding collectionSelectBinding = this.binding;
        if (collectionSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SlidingTabLayout slidingTabLayout = collectionSelectBinding.tabLayout;
        Intrinsics.checkNotNullExpressionValue(slidingTabLayout, "binding.tabLayout");
        if (slidingTabLayout.getTabCount() <= 0) {
            SlidingTabLayout slidingTabLayout2 = collectionSelectBinding.tabLayout;
            Intrinsics.checkNotNullExpressionValue(slidingTabLayout2, "binding.tabLayout");
            slidingTabLayout2.setTextsize(16.0f);
            SlidingTabLayout slidingTabLayout3 = collectionSelectBinding.tabLayout;
            Intrinsics.checkNotNullExpressionValue(slidingTabLayout3, "binding.tabLayout");
            slidingTabLayout3.setIndicatorHeight(0.0f);
            SlidingTabLayout slidingTabLayout4 = collectionSelectBinding.tabLayout;
            Intrinsics.checkNotNullExpressionValue(slidingTabLayout4, "binding.tabLayout");
            slidingTabLayout4.setIndicatorWidth(0.0f);
            SlidingTabLayout slidingTabLayout5 = collectionSelectBinding.tabLayout;
            Intrinsics.checkNotNullExpressionValue(slidingTabLayout5, "binding.tabLayout");
            slidingTabLayout5.setIndicatorColor(AppHolder.getAppTheme().getColorAccent());
            SlidingTabLayout slidingTabLayout6 = collectionSelectBinding.tabLayout;
            Intrinsics.checkNotNullExpressionValue(slidingTabLayout6, "binding.tabLayout");
            slidingTabLayout6.setTextSelectColor(AppHolder.getAppTheme().getTextColorPrimary());
            SlidingTabLayout slidingTabLayout7 = collectionSelectBinding.tabLayout;
            Intrinsics.checkNotNullExpressionValue(slidingTabLayout7, "binding.tabLayout");
            slidingTabLayout7.setTextUnselectColor(AppHolder.getAppTheme().getTextColorSecondary());
            collectionSelectBinding.tabLayout.setViewPager(collectionSelectBinding.viewPager);
            collectionSelectBinding.tabLayout.setOnTabSelectListener(new GoodsListSelectActivity$initTabLayout$1());
            new ColorDrawable(AppHolder.getAppTheme().getColorAccent()).setAlpha(26);
        }
    }

    private final void setupSlideView() {
        CollectionSelectBinding collectionSelectBinding = this.binding;
        if (collectionSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        collectionSelectBinding.bottomSheet.setInitTranslationY((float) DisplayUtils.dp2px(getActivity(), 240.0f));
        CollectionSelectBinding collectionSelectBinding2 = this.binding;
        if (collectionSelectBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SlideUpView slideUpView = collectionSelectBinding2.bottomSheet;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ColorStateList.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
        float dp2px = (float) ConvertUtils.dp2px(8.0f);
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit = Unit.INSTANCE;
        slideUpView.setBackground(gradientDrawable);
        slideUpView.setClickable(true);
        CollectionSelectBinding collectionSelectBinding3 = this.binding;
        if (collectionSelectBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        collectionSelectBinding3.bottomSheet.setCallback(new GoodsListSelectActivity$setupSlideView$2(this));
    }

    private final void setupFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        Fragment findFragmentById = supportFragmentManager.findFragmentById(2131362306);
        if (!(findFragmentById instanceof GoodsListSelectFragment)) {
            findFragmentById = null;
        }
        if (((GoodsListSelectFragment) findFragmentById) == null) {
            GoodsListSelectFragment.Companion companion = GoodsListSelectFragment.Companion;
            String str = this.feedId;
            Intrinsics.checkNotNull(str);
            String str2 = this.type;
            Intrinsics.checkNotNull(str2);
            supportFragmentManager.beginTransaction().add(2131362306, companion.newInstance(str, str2)).commit();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        super.onSetStatusBarColor();
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    /* access modifiers changed from: private */
    public final Fragment getFragmentItem() {
        GoodsListSelectFragment.Companion companion = GoodsListSelectFragment.Companion;
        String str = this.feedId;
        Intrinsics.checkNotNull(str);
        String str2 = this.type;
        Intrinsics.checkNotNull(str2);
        return companion.newInstance(str, str2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodsListSelectActivity$DataAdapter;", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Lcom/coolapk/market/view/goodsList/GoodsListSelectActivity;Landroidx/fragment/app/FragmentManager;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "object", "", "getItemTag", "", "getPageTitle", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsListSelectActivity.kt */
    public final class DataAdapter extends FragmentStatePagerAdapter {
        final /* synthetic */ GoodsListSelectActivity this$0;

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "object");
            return -2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataAdapter(GoodsListSelectActivity goodsListSelectActivity, FragmentManager fragmentManager) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(fragmentManager, "fm");
            this.this$0 = goodsListSelectActivity;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return this.this$0.getFragmentItem();
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(int i) {
            return "" + i;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.this$0.mTitles.length;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.this$0.mTitles[i];
        }
    }
}
