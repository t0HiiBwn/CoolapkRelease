package com.coolapk.market.view.feed.reply;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.PictureDetailWrapBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideFragmentImageLoader;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.PhotoUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.viewholder.v8.image.CoolPicViewPart;
import com.coolapk.market.widget.decoration.CustomizedItemDecoration;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.view.CollapsingToolbarFixLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.io.File;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u001cH\u0002J\b\u0010&\u001a\u00020\u001cH\u0002J\u001a\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006+"}, d2 = {"Lcom/coolapk/market/view/feed/reply/PictureDetailFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "()V", "backImageFullScreen", "", "getBackImageFullScreen", "()Z", "setBackImageFullScreen", "(Z)V", "binding", "Lcom/coolapk/market/databinding/PictureDetailWrapBinding;", "getBinding", "()Lcom/coolapk/market/databinding/PictureDetailWrapBinding;", "setBinding", "(Lcom/coolapk/market/databinding/PictureDetailWrapBinding;)V", "feed", "Lcom/coolapk/market/model/Feed;", "getFeed", "()Lcom/coolapk/market/model/Feed;", "feed$delegate", "Lkotlin/Lazy;", "headerHeight", "", "getHeaderHeight", "()I", "setHeaderHeight", "(I)V", "fillFragment", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPopulateMultiImg", "onPopulateSingleImg", "onViewCreated", "view", "Companion", "SinglePictureFeedFragment", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PictureDetailFragment.kt */
public final class PictureDetailFragment extends BaseFragment {
    public static final Companion Companion = new Companion(null);
    private boolean backImageFullScreen;
    public PictureDetailWrapBinding binding;
    private final Lazy feed$delegate = LazyKt.lazy(new PictureDetailFragment$feed$2(this));
    private int headerHeight;

    public final Feed getFeed() {
        return (Feed) this.feed$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/reply/PictureDetailFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/reply/PictureDetailFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "flag", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PictureDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ PictureDetailFragment newInstance$default(Companion companion, Feed feed, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.newInstance(feed, i);
        }

        public final PictureDetailFragment newInstance(Feed feed, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            PictureDetailFragment pictureDetailFragment = new PictureDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feed);
            bundle.putInt("extra_flag", i);
            pictureDetailFragment.setArguments(bundle);
            return pictureDetailFragment;
        }
    }

    public final PictureDetailWrapBinding getBinding() {
        PictureDetailWrapBinding pictureDetailWrapBinding = this.binding;
        if (pictureDetailWrapBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return pictureDetailWrapBinding;
    }

    public final void setBinding(PictureDetailWrapBinding pictureDetailWrapBinding) {
        Intrinsics.checkNotNullParameter(pictureDetailWrapBinding, "<set-?>");
        this.binding = pictureDetailWrapBinding;
    }

    public final int getHeaderHeight() {
        return this.headerHeight;
    }

    public final void setHeaderHeight(int i) {
        this.headerHeight = i;
    }

    public final boolean getBackImageFullScreen() {
        return this.backImageFullScreen;
    }

    public final void setBackImageFullScreen(boolean z) {
        this.backImageFullScreen = z;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559087, viewGroup, false, new FragmentBindingComponent(this));
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ntBindingComponent(this))");
        PictureDetailWrapBinding pictureDetailWrapBinding = (PictureDetailWrapBinding) inflate;
        this.binding = pictureDetailWrapBinding;
        if (pictureDetailWrapBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = pictureDetailWrapBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        fillFragment();
        if (getFeed().getPicArray().size() > 1) {
            onPopulateMultiImg();
        } else {
            onPopulateSingleImg();
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0, 1275068416});
        PictureDetailWrapBinding pictureDetailWrapBinding = this.binding;
        if (pictureDetailWrapBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View view2 = pictureDetailWrapBinding.coverMaskView;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.coverMaskView");
        view2.setBackground(gradientDrawable);
        PictureDetailWrapBinding pictureDetailWrapBinding2 = this.binding;
        if (pictureDetailWrapBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        pictureDetailWrapBinding2.toolbarLayout.setContentScrimColor(AppHolder.getAppTheme().getColorPrimary());
        PictureDetailWrapBinding pictureDetailWrapBinding3 = this.binding;
        if (pictureDetailWrapBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        CollapsingToolbarFixLayout collapsingToolbarFixLayout = pictureDetailWrapBinding3.toolbarLayout;
        Intrinsics.checkNotNullExpressionValue(collapsingToolbarFixLayout, "binding.toolbarLayout");
        collapsingToolbarFixLayout.getLayoutParams().height = this.headerHeight;
        PictureDetailWrapBinding pictureDetailWrapBinding4 = this.binding;
        if (pictureDetailWrapBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        pictureDetailWrapBinding4.toolbarLayout.requestLayout();
        int actionBarSize = UiUtils.getActionBarSize(getActivity()) + UiUtils.getStatusBarHeight(getActivity());
        PictureDetailWrapBinding pictureDetailWrapBinding5 = this.binding;
        if (pictureDetailWrapBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar = pictureDetailWrapBinding5.holderView;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.holderView");
        toolbar.getLayoutParams().height = actionBarSize;
        PictureDetailWrapBinding pictureDetailWrapBinding6 = this.binding;
        if (pictureDetailWrapBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        pictureDetailWrapBinding6.holderView.requestLayout();
        if (this.backImageFullScreen) {
            PictureDetailWrapBinding pictureDetailWrapBinding7 = this.binding;
            if (pictureDetailWrapBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            View view3 = pictureDetailWrapBinding7.fakeBgView;
            Intrinsics.checkNotNullExpressionValue(view3, "binding.fakeBgView");
            view3.setAlpha(1.0f);
        }
        PictureDetailWrapBinding pictureDetailWrapBinding8 = this.binding;
        if (pictureDetailWrapBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        pictureDetailWrapBinding8.appBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new PictureDetailFragment$onViewCreated$1(this));
        FragmentActivity activity = getActivity();
        if (activity instanceof AlphableToolbar) {
            AlphableToolbar alphableToolbar = (AlphableToolbar) activity;
            alphableToolbar.setToolbarAlpha(0.0f);
            alphableToolbar.setToolbarTitle("");
        }
    }

    private final void fillFragment() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FeedDetailFragmentV8 feedDetailFragmentV8 = (FeedDetailFragmentV8) childFragmentManager.findFragmentById(2131362325);
        if (feedDetailFragmentV8 == null) {
            childFragmentManager.beginTransaction().add(2131362325, SinglePictureFeedFragment.Companion.newInstance(getFeed())).commit();
        } else if (feedDetailFragmentV8.isAdded()) {
            childFragmentManager.beginTransaction().show(feedDetailFragmentV8).commit();
        } else {
            FeedDetailFragmentV8 feedDetailFragmentV82 = feedDetailFragmentV8;
            childFragmentManager.beginTransaction().remove(feedDetailFragmentV82).commit();
            childFragmentManager.beginTransaction().add(2131362325, feedDetailFragmentV82).commit();
        }
        childFragmentManager.executePendingTransactions();
    }

    private final void onPopulateSingleImg() {
        float picRatio = KotlinExtendKt.getPicRatio(getFeed());
        int widthPixels = (int) (((float) DisplayUtils.getWidthPixels(getActivity())) / picRatio);
        int dp2px = DisplayUtils.dp2px(getActivity(), 360.0f);
        this.headerHeight = dp2px;
        if (widthPixels < dp2px || picRatio >= ((float) 1)) {
            this.backImageFullScreen = false;
        } else {
            dp2px = -1;
            this.backImageFullScreen = true;
        }
        PictureDetailWrapBinding pictureDetailWrapBinding = this.binding;
        if (pictureDetailWrapBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        pictureDetailWrapBinding.setFeed(getFeed());
        PictureDetailWrapBinding pictureDetailWrapBinding2 = this.binding;
        if (pictureDetailWrapBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = pictureDetailWrapBinding2.coverView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.coverView");
        imageView.getLayoutParams().height = dp2px;
        PictureDetailWrapBinding pictureDetailWrapBinding3 = this.binding;
        if (pictureDetailWrapBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = pictureDetailWrapBinding3.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
        progressBar.setVisibility(0);
        ImageLoaderOptions build = ImageLoaderOptions.newBuilder().placeHolderRes(2131231696).build();
        GlideFragmentImageLoader fragmentImageLoader = AppHolder.getFragmentImageLoader();
        PictureDetailFragment pictureDetailFragment = this;
        String middleSizePic = getFeed().getMiddleSizePic();
        PictureDetailWrapBinding pictureDetailWrapBinding4 = this.binding;
        if (pictureDetailWrapBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        fragmentImageLoader.displayImage((Fragment) pictureDetailFragment, middleSizePic, pictureDetailWrapBinding4.coverView, build, (OnImageLoadListener) new PictureDetailFragment$onPopulateSingleImg$1(this), (OnBitmapTransformListener) null);
        PictureDetailWrapBinding pictureDetailWrapBinding5 = this.binding;
        if (pictureDetailWrapBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = pictureDetailWrapBinding5.coverView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.coverView");
        ViewExtendsKt.setUtilClickListener(imageView2, new PictureDetailFragment$onPopulateSingleImg$2(this));
        PictureDetailWrapBinding pictureDetailWrapBinding6 = this.binding;
        if (pictureDetailWrapBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = pictureDetailWrapBinding6.setWallpaperView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.setWallpaperView");
        ViewExtendsKt.setUtilClickListener(textView, new PictureDetailFragment$onPopulateSingleImg$3(this));
    }

    private final void onPopulateMultiImg() {
        PictureDetailWrapBinding pictureDetailWrapBinding = this.binding;
        if (pictureDetailWrapBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = pictureDetailWrapBinding.coverView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.coverView");
        ViewParent parent = imageView.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        CoolPicViewPart coolPicViewPart = new CoolPicViewPart(new FragmentBindingComponent(this));
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewParent.context)");
        coolPicViewPart.createView(from, viewGroup);
        PictureDetailWrapBinding pictureDetailWrapBinding2 = this.binding;
        if (pictureDetailWrapBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.replaceView(pictureDetailWrapBinding2.coverView, coolPicViewPart.getView());
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(coolPicViewPart.getView());
        if (marginParams != null) {
            marginParams.leftMargin = 0;
            marginParams.rightMargin = 0;
            marginParams.topMargin = 0;
            marginParams.bottomMargin = 0;
        }
        coolPicViewPart.bindToContent(getFeed());
        ViewExtendsKt.measureWithScreenWidth$default(coolPicViewPart.getView(), 0, 1, null);
        PictureDetailWrapBinding pictureDetailWrapBinding3 = this.binding;
        if (pictureDetailWrapBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = pictureDetailWrapBinding3.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.progressBar");
        progressBar.setVisibility(8);
        this.headerHeight = coolPicViewPart.getView().getLayoutParams().height;
        this.backImageFullScreen = false;
        PictureDetailWrapBinding pictureDetailWrapBinding4 = this.binding;
        if (pictureDetailWrapBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = pictureDetailWrapBinding4.setWallpaperView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.setWallpaperView");
        textView.setVisibility(8);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/feed/reply/PictureDetailFragment$SinglePictureFeedFragment;", "Lcom/coolapk/market/view/feed/reply/FeedDetailFragmentV8;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "Landroid/view/View;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PictureDetailFragment.kt */
    public static final class SinglePictureFeedFragment extends FeedDetailFragmentV8 {
        public static final Companion Companion = new Companion(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feed/reply/PictureDetailFragment$SinglePictureFeedFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/reply/PictureDetailFragment$SinglePictureFeedFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: PictureDetailFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final SinglePictureFeedFragment newInstance(Feed feed) {
                Intrinsics.checkNotNullParameter(feed, "feed");
                SinglePictureFeedFragment singlePictureFeedFragment = new SinglePictureFeedFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("extra_feed", feed);
                singlePictureFeedFragment.setArguments(bundle);
                return singlePictureFeedFragment;
            }
        }

        @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle bundle) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onViewCreated(view, bundle);
            FragmentActivity activity = getActivity();
            if (activity instanceof AlphableToolbar) {
                AlphableToolbar alphableToolbar = (AlphableToolbar) activity;
                alphableToolbar.setToolbarAlpha(0.0f);
                alphableToolbar.setToolbarTitle("");
            }
            RecyclerView recyclerView = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            recyclerView.setClipChildren(false);
            RecyclerView recyclerView2 = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
            recyclerView2.setClipToPadding(false);
            SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
            ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(swipeRefreshLayout);
            if (marginParams != null) {
                marginParams.topMargin = 0;
            }
            RecyclerView recyclerView3 = getRecyclerView();
            RecyclerView recyclerView4 = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView4, "recyclerView");
            int paddingLeft = recyclerView4.getPaddingLeft();
            RecyclerView recyclerView5 = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView5, "recyclerView");
            int paddingRight = recyclerView5.getPaddingRight();
            RecyclerView recyclerView6 = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView6, "recyclerView");
            recyclerView3.setPadding(paddingLeft, 0, paddingRight, recyclerView6.getPaddingBottom());
        }

        @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            getRecyclerView().setBackgroundColor(0);
            RecyclerView recyclerView = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            ViewExtendsKt.removeAllItemDecorations(recyclerView);
            getRecyclerView().addItemDecoration(new CustomizedItemDecoration(getAdapter$presentation_coolapkAppRelease(), new PictureDetailFragment$SinglePictureFeedFragment$onActivityCreated$1(this, getDataList())));
            BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558693).constructor(new PictureDetailFragment$SinglePictureFeedFragment$onActivityCreated$2(this)).suitedEntityType("ENTITY_TYPE_DETAIL_TOP").resetItemViewType(2131558696).build(), 0, 2, null);
        }

        @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, androidx.fragment.app.Fragment
        public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
            Intrinsics.checkNotNullParameter(menu, "menu");
            Intrinsics.checkNotNullParameter(menuInflater, "inflater");
            menuInflater.inflate(2131623975, menu);
            MenuItem findItem = menu.findItem(2131361932);
            if (findItem != null) {
                findItem.setVisible(true);
            }
            MenuItem findItem2 = menu.findItem(2131361968);
            if (findItem2 != null) {
                findItem2.setVisible(false);
            }
        }

        @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, androidx.fragment.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            Intrinsics.checkNotNullParameter(menuItem, "item");
            int itemId = menuItem.getItemId();
            if (itemId == 2131361959) {
                PhotoUtils.saveImageObservable(getFeed$presentation_coolapkAppRelease().getPic(), false).subscribe((Subscriber<? super File>) new EmptySubscriber());
                return true;
            } else if (itemId == 2131361966) {
                PhotoUtils.saveImageObservable(getFeed$presentation_coolapkAppRelease().getPic(), true).subscribe((Subscriber<? super File>) new PictureDetailFragment$SinglePictureFeedFragment$onOptionsItemSelected$1());
                return true;
            } else if (itemId != 2131361968) {
                return false;
            } else {
                ActionManager.startForwardEntityActivity(getActivity(), getFeed$presentation_coolapkAppRelease());
                return true;
            }
        }
    }
}
