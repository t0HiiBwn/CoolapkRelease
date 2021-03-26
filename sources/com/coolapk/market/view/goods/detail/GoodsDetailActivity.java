package com.coolapk.market.view.goods.detail;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Transformation;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.GoodsDetailBinding;
import com.coolapk.market.databinding.UserToolbarBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeExtends;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.view.node.BitmapSizeTransformation;
import com.coolapk.market.view.node.NodePaletteBackgroundTarget;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0014J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/goods/detail/GoodsDetailActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/GoodsDetailBinding;", "viewModel", "Lcom/coolapk/market/view/goods/detail/GoodsDetailViewModel;", "getViewModel", "()Lcom/coolapk/market/view/goods/detail/GoodsDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isNavigationBarTranslucent", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onFirstFeedGoodsLoad", "data", "Lcom/coolapk/market/model/FeedGoods;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onSetStatusBarColor", "onSetStatusBarDarkMode", "delay", "", "setupActionToolbar", "setupHeaderViews", "setupLogoAndBackground", "setupViewPager", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsDetailActivity.kt */
public final class GoodsDetailActivity extends FakeStatusBarActivity implements TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_ID = "id";
    private GoodsDetailBinding binding;
    private final Lazy viewModel$delegate = LazyKt.lazy(new GoodsDetailActivity$viewModel$2(this));

    /* access modifiers changed from: private */
    public final GoodsDetailViewModel getViewModel() {
        return (GoodsDetailViewModel) this.viewModel$delegate.getValue();
    }

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public static final /* synthetic */ GoodsDetailBinding access$getBinding$p(GoodsDetailActivity goodsDetailActivity) {
        GoodsDetailBinding goodsDetailBinding = goodsDetailActivity.binding;
        if (goodsDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return goodsDetailBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goods/detail/GoodsDetailActivity$Companion;", "", "()V", "EXTRA_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsDetailActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setContentBarAlwaysTranslucent(true);
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(getActivity(), 2131558571, new ContextBindingComponent(this));
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte….goods_detail, component)");
        GoodsDetailBinding goodsDetailBinding = (GoodsDetailBinding) contentView;
        this.binding = goodsDetailBinding;
        if (goodsDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsDetailBinding.coordinator.setStatusBarBackgroundColor(0);
        GoodsDetailBinding goodsDetailBinding2 = this.binding;
        if (goodsDetailBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        setSupportActionBar(goodsDetailBinding2.toolbar);
        GoodsDetailBinding goodsDetailBinding3 = this.binding;
        if (goodsDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar = goodsDetailBinding3.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        ViewExtendsKt.setTintColor(toolbar, -1);
        GoodsDetailBinding goodsDetailBinding4 = this.binding;
        if (goodsDetailBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsDetailBinding4.toolbar.setNavigationIcon(2131231166);
        GoodsDetailBinding goodsDetailBinding5 = this.binding;
        if (goodsDetailBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsDetailBinding5.toolbar.setNavigationOnClickListener(new GoodsDetailActivity$onCreate$1(this));
        GoodsDetailBinding goodsDetailBinding6 = this.binding;
        if (goodsDetailBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar2 = goodsDetailBinding6.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "binding.toolbar");
        toolbar2.setTitle(" ");
        setTitle(" ");
        String stringExtra = getIntent().getStringExtra("id");
        Intrinsics.checkNotNull(stringExtra);
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(EXTRA_ID)!!");
        GoodsDetailActivity goodsDetailActivity = this;
        getViewModel().loadGoodsDetail(stringExtra).observe(goodsDetailActivity, new GoodsDetailActivity$onCreate$2(this));
        getViewModel().getLoadingStatus().observe(goodsDetailActivity, new GoodsDetailActivity$onCreate$3(this, stringExtra));
        getViewModel().getBgColor().observe(goodsDetailActivity, new GoodsDetailActivity$onCreate$4(this));
        GoodsDetailBinding goodsDetailBinding7 = this.binding;
        if (goodsDetailBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsDetailBinding7.mainContent.addOnInsetChangeListener(new GoodsDetailActivity$onCreate$5(this));
        GoodsDetailBinding goodsDetailBinding8 = this.binding;
        if (goodsDetailBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FloatingActionButton floatingActionButton = goodsDetailBinding8.floatingButton;
        Intrinsics.checkNotNullExpressionValue(floatingActionButton, "binding.floatingButton");
        floatingActionButton.setImageTintList(ColorStateList.valueOf(-1));
        GoodsDetailBinding goodsDetailBinding9 = this.binding;
        if (goodsDetailBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsDetailBinding9.actionView.setOnClickListener(new GoodsDetailActivity$onCreate$6(this));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131623953, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131361856) {
            return super.onOptionsItemSelected(menuItem);
        }
        BaseActivity activity = getActivity();
        FeedGoods value = getViewModel().getFeedGoods().getValue();
        ActionManager.startGoodsListSelectActivity(activity, value != null ? value.getId() : null, "");
        return true;
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode(int i) {
        ThemeUtils.setDarkStatusIconBar(getActivity(), false, i);
    }

    /* access modifiers changed from: private */
    public final void onFirstFeedGoodsLoad(FeedGoods feedGoods) {
        setupLogoAndBackground(feedGoods);
        setupViewPager(feedGoods);
        setupHeaderViews(feedGoods);
        setupActionToolbar();
    }

    private final void setupLogoAndBackground(FeedGoods feedGoods) {
        Integer stringToColor = ColorUtils.stringToColor(feedGoods.getBgColor());
        if (stringToColor != null) {
            getViewModel().setBgColor(NodePaletteBackgroundTarget.Companion.getNodeColors(stringToColor.intValue()).component2().intValue());
            return;
        }
        GlideRequest priority = GlideApp.with((FragmentActivity) getActivity()).as(PaletteBitmap.class).load(feedGoods.getCover()).transform((Transformation<Bitmap>) new BitmapSizeTransformation(24, 24)).priority(Priority.IMMEDIATE);
        GoodsDetailBinding goodsDetailBinding = this.binding;
        if (goodsDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        CoordinatorLayout coordinatorLayout = goodsDetailBinding.coordinator;
        Intrinsics.checkNotNullExpressionValue(coordinatorLayout, "binding.coordinator");
        Intrinsics.checkNotNullExpressionValue(priority.into((GlideRequest) new NodePaletteBackgroundTarget(coordinatorLayout, null, true, new GoodsDetailActivity$setupLogoAndBackground$1(this), 2, null)), "GlideApp.with(activity)\n…)\n                    }))");
    }

    private final void setupViewPager(FeedGoods feedGoods) {
        List<ConfigPage> tabApiList = feedGoods.getTabApiList();
        GoodsDetailActivity$setupViewPager$adapter$1 goodsDetailActivity$setupViewPager$adapter$1 = new GoodsDetailActivity$setupViewPager$adapter$1(this, tabApiList, getSupportFragmentManager());
        GoodsDetailBinding goodsDetailBinding = this.binding;
        if (goodsDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = goodsDetailBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        scrollStateViewPager.setTag(tabApiList);
        GoodsDetailBinding goodsDetailBinding2 = this.binding;
        if (goodsDetailBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager2 = goodsDetailBinding2.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
        scrollStateViewPager2.setVisibility(0);
        GoodsDetailBinding goodsDetailBinding3 = this.binding;
        if (goodsDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager3 = goodsDetailBinding3.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager3, "binding.viewPager");
        scrollStateViewPager3.setAdapter(goodsDetailActivity$setupViewPager$adapter$1);
        GoodsDetailBinding goodsDetailBinding4 = this.binding;
        if (goodsDetailBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout = goodsDetailBinding4.tabs;
        ViewExtendsKt.setV9TabUI(tabLayout, 0);
        ViewExtendsKt.setV9TabColor(tabLayout, false);
        GoodsDetailBinding goodsDetailBinding5 = this.binding;
        if (goodsDetailBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        tabLayout.setupWithViewPager(goodsDetailBinding5.viewPager);
        GoodsDetailBinding goodsDetailBinding6 = this.binding;
        if (goodsDetailBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager4 = goodsDetailBinding6.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager4, "binding.viewPager");
        ViewExtendsKt.setDefaultDoubleClickListener(tabLayout, scrollStateViewPager4);
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        BaseActivity baseActivity = activity;
        GoodsDetailBinding goodsDetailBinding7 = this.binding;
        if (goodsDetailBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager5 = goodsDetailBinding7.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager5, "binding.viewPager");
        Intrinsics.checkNotNullExpressionValue(tabApiList, "tabApiList");
        Object[] array = tabApiList.toArray(new ConfigPage[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        ViewExtendsKt.setDefaultSubTabConfigListener(tabLayout, baseActivity, scrollStateViewPager5, (ConfigPage[]) array);
        tabLayout.setTabIndicatorMarginBottom(NumberExtendsKt.getDp(Double.valueOf(7.5d)));
        int colorInt = ResourceUtils.getColorInt(tabLayout.getContext(), 2131100159);
        tabLayout.setTabTextColors(ResourceUtils.getColorInt(tabLayout.getContext(), 2131099933), colorInt);
        tabLayout.setSelectedTabIndicatorColor(colorInt);
        GoodsDetailBinding goodsDetailBinding8 = this.binding;
        if (goodsDetailBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsDetailBinding8.viewPager.addOnPageChangeListener(new GoodsDetailActivity$setupViewPager$2(this, goodsDetailActivity$setupViewPager$adapter$1));
        GoodsDetailBinding goodsDetailBinding9 = this.binding;
        if (goodsDetailBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout2 = goodsDetailBinding9.tabs;
        GoodsDetailBinding goodsDetailBinding10 = this.binding;
        if (goodsDetailBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsDetailBinding10.floatingButton.setOnClickListener(new GoodsDetailActivity$setupViewPager$4(this));
    }

    private final void setupHeaderViews(FeedGoods feedGoods) {
        GoodsDetailBinding goodsDetailBinding = this.binding;
        if (goodsDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsDetailBinding.appBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new GoodsDetailActivity$setupHeaderViews$1(this));
        GoodsDetailBinding goodsDetailBinding2 = this.binding;
        if (goodsDetailBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = goodsDetailBinding2.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        ViewExtendsKt.applyText(textView, new GoodsDetailActivity$setupHeaderViews$2(feedGoods));
    }

    private final void setupActionToolbar() {
        GoodsDetailBinding goodsDetailBinding = this.binding;
        if (goodsDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsDetailBinding.userToolbar.toolbarUserAvatarView.bind(null, false);
        GoodsDetailBinding goodsDetailBinding2 = this.binding;
        if (goodsDetailBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        UserAvatarView userAvatarView = goodsDetailBinding2.userToolbar.toolbarUserAvatarView;
        Intrinsics.checkNotNullExpressionValue(userAvatarView, "binding.userToolbar.toolbarUserAvatarView");
        ViewExtendsKt.clipView$default(userAvatarView, 0, NumberExtendsKt.getDpf((Number) 4), 1, null);
        GoodsDetailBinding goodsDetailBinding3 = this.binding;
        if (goodsDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = goodsDetailBinding3.userToolbar.toolbarActionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.userToolbar.toolbarActionView");
        textView.setText("购买");
        GoodsDetailBinding goodsDetailBinding4 = this.binding;
        if (goodsDetailBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = goodsDetailBinding4.userToolbar.toolbarActionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.userToolbar.toolbarActionView");
        ShapeExtends shapeExtends = ShapeExtends.INSTANCE;
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        textView2.setBackground(shapeExtends.createNodeCapsuleActionBackground(activity, (float) NumberExtendsKt.getDp((Number) 14)));
        GoodsDetailBinding goodsDetailBinding5 = this.binding;
        if (goodsDetailBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = goodsDetailBinding5.userToolbar.toolbarActionView;
        ShapeExtends shapeExtends2 = ShapeExtends.INSTANCE;
        BaseActivity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        textView3.setTextColor(shapeExtends2.createNodeActionTextColors(activity2));
        GoodsDetailBinding goodsDetailBinding6 = this.binding;
        if (goodsDetailBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        goodsDetailBinding6.userToolbar.toolbarActionView.setOnClickListener(new GoodsDetailActivity$setupActionToolbar$1(this));
        GoodsDetailBinding goodsDetailBinding7 = this.binding;
        if (goodsDetailBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        UserToolbarBinding userToolbarBinding = goodsDetailBinding7.userToolbar;
        Intrinsics.checkNotNullExpressionValue(userToolbarBinding, "binding.userToolbar");
        View root = userToolbarBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.userToolbar.root");
        root.setVisibility(8);
    }
}
