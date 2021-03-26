package com.coolapk.market.view.dyhv8;

import android.content.Intent;
import android.content.res.ColorStateList;
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
import com.coolapk.market.databinding.DyhIncludBinding;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.dyhv8.DyhEditorFragment;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.SlideUpView;
import com.flyco.tablayout.SlidingTabLayout;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 72\u00020\u0001:\u000278B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020!J\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\n\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u000e\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0015J\u0006\u0010'\u001a\u00020\u001dJ\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0016J\u0012\u0010+\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020\u001dH\u0014J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u001dH\u0014J\u000e\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u0007J\b\u00104\u001a\u00020\u001dH\u0002J\b\u00105\u001a\u00020\u001dH\u0002J\b\u00106\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhIncludActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/DyhIncludBinding;", "dyhMap", "Ljava/util/LinkedHashMap;", "", "Lcom/coolapk/market/model/DyhModel;", "feedId", "isScroll", "", "isSearch", "isSet", "Ljava/lang/Boolean;", "mAdapter", "Lcom/coolapk/market/view/dyhv8/DyhIncludActivity$DataAdapter;", "mTitles", "", "[Ljava/lang/String;", "page", "", "getPage", "()I", "setPage", "(I)V", "subscription", "Lrx/Subscription;", "ActionDone", "", "getActionDoneView", "Landroid/widget/TextView;", "getBottomSheet", "Lcom/coolapk/market/widget/view/SlideUpView;", "getDyhMap", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "getViewPagerFragment", "position", "initSearch", "initTabLayout", "initViewPager", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPageChangeListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onSetStatusBarColor", "searchKey", "text", "setupAutoInputKeyword", "setupFragment", "setupSlideView", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhIncludActivity.kt */
public final class DyhIncludActivity extends BaseActivity {
    public static final Companion Companion = new Companion(null);
    public static final int EXTERNAL_SHARE = 1;
    public static final int INTERNAL_SHARE = 2;
    public static final int REQUEST_CODE = 6666;
    private DyhIncludBinding binding;
    private LinkedHashMap<String, DyhModel> dyhMap = new LinkedHashMap<>();
    private String feedId;
    private boolean isScroll;
    private boolean isSearch;
    private Boolean isSet = false;
    private DataAdapter mAdapter;
    private final String[] mTitles = {"收录到看看号", "分享到广场"};
    private int page;
    private Subscription subscription;

    @JvmStatic
    public static final String getResult(Intent intent) {
        return Companion.getResult(intent);
    }

    public static final /* synthetic */ DyhIncludBinding access$getBinding$p(DyhIncludActivity dyhIncludActivity) {
        DyhIncludBinding dyhIncludBinding = dyhIncludActivity.binding;
        if (dyhIncludBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return dyhIncludBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhIncludActivity$Companion;", "", "()V", "EXTERNAL_SHARE", "", "INTERNAL_SHARE", "REQUEST_CODE", "getResult", "", "intent", "Landroid/content/Intent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhIncludActivity.kt */
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
        ViewDataBinding contentView = DataBindingUtil.setContentView(getActivity(), 2131558544);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…ity, R.layout.dyh_includ)");
        this.binding = (DyhIncludBinding) contentView;
        String stringExtra = getIntent().getStringExtra("id");
        this.feedId = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.feedId = "";
        }
        setupSlideView();
        initViewPager();
        getActionDoneView().setEnabled(false);
        DyhIncludBinding dyhIncludBinding = this.binding;
        if (dyhIncludBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dyhIncludBinding.mainContent.setOnClickListener(new DyhIncludActivity$onCreate$1(this));
        DyhIncludBinding dyhIncludBinding2 = this.binding;
        if (dyhIncludBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dyhIncludBinding2.closeView.setOnClickListener(new DyhIncludActivity$onCreate$2(this));
        initTabLayout();
        ActionDone();
        initSearch();
        setupAutoInputKeyword();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        DyhIncludBinding dyhIncludBinding = this.binding;
        if (dyhIncludBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dyhIncludBinding.bottomSheet.dismissView();
    }

    private final void ActionDone() {
        DyhIncludBinding dyhIncludBinding = this.binding;
        if (dyhIncludBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dyhIncludBinding.actionDone.setOnClickListener(new DyhIncludActivity$ActionDone$1(this));
    }

    private final void setupAutoInputKeyword() {
        DyhIncludBinding dyhIncludBinding = this.binding;
        if (dyhIncludBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dyhIncludBinding.clearButton.setOnClickListener(new DyhIncludActivity$setupAutoInputKeyword$1(this));
        this.subscription = Observable.create(new DyhIncludActivity$setupAutoInputKeyword$2(this), Emitter.BackpressureMode.LATEST).throttleWithTimeout(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new DyhIncludActivity$setupAutoInputKeyword$3(this));
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    public final void searchKey(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        Fragment viewPagerFragment = getViewPagerFragment(1);
        if (viewPagerFragment.isVisible() && (viewPagerFragment instanceof DyhEditorFragment)) {
            ((DyhEditorFragment) viewPagerFragment).searchDyh(str, this.isSearch);
        }
    }

    public final void initSearch() {
        DyhIncludBinding dyhIncludBinding = this.binding;
        if (dyhIncludBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dyhIncludBinding.searchButtonView.setOnClickListener(new DyhIncludActivity$initSearch$1(this));
        DyhIncludBinding dyhIncludBinding2 = this.binding;
        if (dyhIncludBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dyhIncludBinding2.editText.setOnFocusChangeListener(new DyhIncludActivity$initSearch$2(this));
        DyhIncludBinding dyhIncludBinding3 = this.binding;
        if (dyhIncludBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dyhIncludBinding3.editText.setOnEditorActionListener(new DyhIncludActivity$initSearch$3(this));
    }

    public final TextView getActionDoneView() {
        DyhIncludBinding dyhIncludBinding = this.binding;
        if (dyhIncludBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = dyhIncludBinding.actionDone;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionDone");
        return textView;
    }

    public final LinkedHashMap<String, DyhModel> getDyhMap() {
        LinkedHashMap<String, DyhModel> linkedHashMap = this.dyhMap;
        Intrinsics.checkNotNull(linkedHashMap);
        return linkedHashMap;
    }

    public final SlideUpView getBottomSheet() {
        DyhIncludBinding dyhIncludBinding = this.binding;
        if (dyhIncludBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SlideUpView slideUpView = dyhIncludBinding.bottomSheet;
        Intrinsics.checkNotNullExpressionValue(slideUpView, "binding.bottomSheet");
        return slideUpView;
    }

    private final void initViewPager() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        this.mAdapter = new DataAdapter(this, supportFragmentManager);
        DyhIncludBinding dyhIncludBinding = this.binding;
        if (dyhIncludBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = dyhIncludBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        scrollStateViewPager.setAdapter(this.mAdapter);
        DyhIncludBinding dyhIncludBinding2 = this.binding;
        if (dyhIncludBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dyhIncludBinding2.viewPager.addOnPageChangeListener(onPageChangeListener());
    }

    private final ViewPager.OnPageChangeListener onPageChangeListener() {
        return new DyhIncludActivity$onPageChangeListener$1(this);
    }

    public final Fragment getViewPagerFragment(int i) {
        Object obj;
        DataAdapter dataAdapter = this.mAdapter;
        if (dataAdapter != null) {
            DyhIncludBinding dyhIncludBinding = this.binding;
            if (dyhIncludBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            obj = dataAdapter.instantiateItem((ViewGroup) dyhIncludBinding.viewPager, i);
        } else {
            obj = null;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return (Fragment) obj;
    }

    private final void initTabLayout() {
        DyhIncludBinding dyhIncludBinding = this.binding;
        if (dyhIncludBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SlidingTabLayout slidingTabLayout = dyhIncludBinding.tabLayout;
        Intrinsics.checkNotNullExpressionValue(slidingTabLayout, "binding.tabLayout");
        if (slidingTabLayout.getTabCount() <= 0) {
            SlidingTabLayout slidingTabLayout2 = dyhIncludBinding.tabLayout;
            Intrinsics.checkNotNullExpressionValue(slidingTabLayout2, "binding.tabLayout");
            slidingTabLayout2.setTextsize(16.0f);
            SlidingTabLayout slidingTabLayout3 = dyhIncludBinding.tabLayout;
            Intrinsics.checkNotNullExpressionValue(slidingTabLayout3, "binding.tabLayout");
            slidingTabLayout3.setIndicatorColor(AppHolder.getAppTheme().getColorAccent());
            SlidingTabLayout slidingTabLayout4 = dyhIncludBinding.tabLayout;
            Intrinsics.checkNotNullExpressionValue(slidingTabLayout4, "binding.tabLayout");
            slidingTabLayout4.setTextSelectColor(AppHolder.getAppTheme().getColorAccent());
            SlidingTabLayout slidingTabLayout5 = dyhIncludBinding.tabLayout;
            Intrinsics.checkNotNullExpressionValue(slidingTabLayout5, "binding.tabLayout");
            slidingTabLayout5.setTextUnselectColor(AppHolder.getAppTheme().getTextColorSecondary());
            dyhIncludBinding.tabLayout.setViewPager(dyhIncludBinding.viewPager);
            dyhIncludBinding.tabLayout.setOnTabSelectListener(new DyhIncludActivity$initTabLayout$1());
        }
    }

    private final void setupSlideView() {
        DyhIncludBinding dyhIncludBinding = this.binding;
        if (dyhIncludBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dyhIncludBinding.bottomSheet.setInitTranslationY((float) DisplayUtils.dp2px(getActivity(), 240.0f));
        DyhIncludBinding dyhIncludBinding2 = this.binding;
        if (dyhIncludBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SlideUpView slideUpView = dyhIncludBinding2.bottomSheet;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ColorStateList.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
        float dp2px = (float) ConvertUtils.dp2px(8.0f);
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit = Unit.INSTANCE;
        slideUpView.setBackground(gradientDrawable);
        slideUpView.setClickable(true);
        DyhIncludBinding dyhIncludBinding3 = this.binding;
        if (dyhIncludBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dyhIncludBinding3.bottomSheet.setCallback(new DyhIncludActivity$setupSlideView$2(this));
    }

    private final void setupFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        Fragment findFragmentById = supportFragmentManager.findFragmentById(2131362306);
        if (!(findFragmentById instanceof DyhEditorFragment)) {
            findFragmentById = null;
        }
        if (((DyhEditorFragment) findFragmentById) == null) {
            DyhEditorFragment.Companion companion = DyhEditorFragment.Companion;
            String str = this.feedId;
            Intrinsics.checkNotNull(str);
            supportFragmentManager.beginTransaction().add(2131362306, companion.newInstance(str)).commit();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        super.onSetStatusBarColor();
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    /* access modifiers changed from: private */
    public final Fragment getFragmentItem() {
        DyhEditorFragment.Companion companion = DyhEditorFragment.Companion;
        String str = this.feedId;
        Intrinsics.checkNotNull(str);
        return companion.newInstance(str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhIncludActivity$DataAdapter;", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Lcom/coolapk/market/view/dyhv8/DyhIncludActivity;Landroidx/fragment/app/FragmentManager;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "object", "", "getItemTag", "", "getPageTitle", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhIncludActivity.kt */
    public final class DataAdapter extends FragmentStatePagerAdapter {
        final /* synthetic */ DyhIncludActivity this$0;

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "object");
            return -2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataAdapter(DyhIncludActivity dyhIncludActivity, FragmentManager fragmentManager) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(fragmentManager, "fm");
            this.this$0 = dyhIncludActivity;
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
