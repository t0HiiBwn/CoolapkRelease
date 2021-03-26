package com.coolapk.market.view.feed.reply;

import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemArticleDetailTopBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.feedv8.RatingContentHelper;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.view.BadBadRatingBar;
import com.coolapk.market.widget.view.RatingTagShape;
import com.coolapk.market.widget.view.ScalingImageView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticleFeedTopViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemArticleDetailTopBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;)V", "headerViewPart", "Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "bindToContent", "", "data", "doCoverAnim", "onClick", "view", "populateCover", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleFeedTopViewHolder.kt */
public final class ArticleFeedTopViewHolder extends GenericBindHolder<ItemArticleDetailTopBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558611;
    private final Lazy headerViewPart$delegate;
    private final FeedDetailPresenter presenter;

    private final FeedFollowableHeaderViewPart getHeaderViewPart() {
        return (FeedFollowableHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    public final FeedDetailPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleFeedTopViewHolder(View view, DataBindingComponent dataBindingComponent, FeedDetailPresenter feedDetailPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(feedDetailPresenter, "presenter");
        this.presenter = feedDetailPresenter;
        ItemArticleDetailTopBinding itemArticleDetailTopBinding = (ItemArticleDetailTopBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemArticleDetailTopBinding, "binding");
        itemArticleDetailTopBinding.setClick(this);
        ((ItemArticleDetailTopBinding) getBinding()).ratingBar.setProgressBar(NumberExtendsKt.getDp((Number) 22), true);
        this.headerViewPart$delegate = LazyKt.lazy(new ArticleFeedTopViewHolder$headerViewPart$2(this, dataBindingComponent));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/ArticleFeedTopViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleFeedTopViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        ScalingImageView scalingImageView = ((ItemArticleDetailTopBinding) getBinding()).topImageView;
        Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.topImageView");
        ViewGroup.LayoutParams layoutParams = scalingImageView.getLayoutParams();
        layoutParams.width = DisplayUtils.getDecorViewWidth(getContext());
        layoutParams.height = (int) ((((float) layoutParams.width) / 20.0f) * ((float) 9));
        View view = ((ItemArticleDetailTopBinding) getBinding()).coverViewMask;
        Intrinsics.checkNotNullExpressionValue(view, "binding.coverViewMask");
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        ScalingImageView scalingImageView2 = ((ItemArticleDetailTopBinding) getBinding()).topImageView;
        Intrinsics.checkNotNullExpressionValue(scalingImageView2, "binding.topImageView");
        layoutParams2.height = scalingImageView2.getHeight();
        Feed feed = this.presenter.getFeed();
        ItemArticleDetailTopBinding itemArticleDetailTopBinding = (ItemArticleDetailTopBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemArticleDetailTopBinding, "binding");
        itemArticleDetailTopBinding.setModel(feed);
        ((ItemArticleDetailTopBinding) getBinding()).executePendingBindings();
        getHeaderViewPart().bindToContent(feed);
        populateCover();
        LinearLayout linearLayout = ((ItemArticleDetailTopBinding) getBinding()).scoreViewContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.scoreViewContainer");
        int i = 8;
        linearLayout.setVisibility(Intrinsics.areEqual(feed.getFeedType(), "rating") ? 0 : 8);
        LinearLayout linearLayout2 = ((ItemArticleDetailTopBinding) getBinding()).scoreViewContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.scoreViewContainer");
        boolean z = true;
        if (linearLayout2.getVisibility() == 0) {
            TextView textView = ((ItemArticleDetailTopBinding) getBinding()).ratingTagsView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.ratingTagsView");
            textView.setBackground(new ShapeDrawable(new RatingTagShape()));
            BadBadRatingBar badBadRatingBar = ((ItemArticleDetailTopBinding) getBinding()).ratingBar;
            Intrinsics.checkNotNullExpressionValue(badBadRatingBar, "binding.ratingBar");
            badBadRatingBar.setRating(ProductGlobalData.INSTANCE.ratingScoreToStartScore(feed.getRatingScore()));
            RatingContentHelper ratingContentHelper = RatingContentHelper.INSTANCE;
            BadBadRatingBar badBadRatingBar2 = ((ItemArticleDetailTopBinding) getBinding()).ratingBar;
            Intrinsics.checkNotNullExpressionValue(badBadRatingBar2, "binding.ratingBar");
            BadBadRatingBar badBadRatingBar3 = ((ItemArticleDetailTopBinding) getBinding()).ratingBar;
            Intrinsics.checkNotNullExpressionValue(badBadRatingBar3, "binding.ratingBar");
            ratingContentHelper.setRatingBarTintColor(badBadRatingBar2, (int) badBadRatingBar3.getRating());
            TextView textView2 = ((ItemArticleDetailTopBinding) getBinding()).scoreView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.scoreView");
            textView2.setText(EntityExtendsKt.getDisplayRatingScore(feed) + (char) 20998);
            LinearLayout linearLayout3 = ((ItemArticleDetailTopBinding) getBinding()).buyView;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.buyView");
            LinearLayout linearLayout4 = linearLayout3;
            if (feed.getBuyStatus() != 1) {
                z = false;
            }
            if (z) {
                i = 0;
            }
            linearLayout4.setVisibility(i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bb  */
    private final void populateCover() {
        String str;
        String messageCover;
        Feed feed = this.presenter.getFeed();
        DataBindingComponent component = getComponent();
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (!(fragment instanceof BaseFragment)) {
            fragment = null;
        }
        BaseFragment baseFragment = (BaseFragment) fragment;
        if (baseFragment != null) {
            BaseFragment baseFragment2 = baseFragment;
            AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(feed.getMessageCover());
            int valueOf = size != null ? Integer.valueOf(size.getWidth()) : null;
            if (valueOf == null) {
                valueOf = 720;
            }
            String str2 = "";
            if (valueOf.intValue() >= 720) {
                ImageArgs.Companion companion = ImageArgs.Companion;
                String messageCover2 = feed.getMessageCover();
                if (messageCover2 != null) {
                    str2 = messageCover2;
                }
                str2 = companion.s2xSizeProvider(str2);
            } else {
                String messageCover3 = feed.getMessageCover();
                if (messageCover3 != null) {
                    str = messageCover3;
                    ScalingImageView scalingImageView = ((ItemArticleDetailTopBinding) getBinding()).topImageView;
                    Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.topImageView");
                    ViewExtendsKt.setUtilClickListener(scalingImageView, new ArticleFeedTopViewHolder$populateCover$1(this, feed, str));
                    View view = ((ItemArticleDetailTopBinding) getBinding()).coverViewMask;
                    Intrinsics.checkNotNullExpressionValue(view, "binding.coverViewMask");
                    view.setVisibility(8);
                    messageCover = feed.getMessageCover();
                    if (!(messageCover != null || messageCover.length() == 0)) {
                        ScalingImageView scalingImageView2 = ((ItemArticleDetailTopBinding) getBinding()).topImageView;
                        Intrinsics.checkNotNullExpressionValue(scalingImageView2, "binding.topImageView");
                        scalingImageView2.setVisibility(8);
                        return;
                    }
                    ScalingImageView scalingImageView3 = ((ItemArticleDetailTopBinding) getBinding()).topImageView;
                    Intrinsics.checkNotNullExpressionValue(scalingImageView3, "binding.topImageView");
                    scalingImageView3.setVisibility(4);
                    ScalingImageView scalingImageView4 = ((ItemArticleDetailTopBinding) getBinding()).topImageView;
                    Intrinsics.checkNotNullExpressionValue(scalingImageView4, "binding.topImageView");
                    ViewExtendsKt.measureWithScreenWidth$default(scalingImageView4, 0, 1, null);
                    ArticleFeedTopViewHolder$populateCover$onImageLoadListener$1 articleFeedTopViewHolder$populateCover$onImageLoadListener$1 = new ArticleFeedTopViewHolder$populateCover$onImageLoadListener$1(this);
                    ScalingImageView scalingImageView5 = ((ItemArticleDetailTopBinding) getBinding()).topImageView;
                    Intrinsics.checkNotNullExpressionValue(scalingImageView5, "binding.topImageView");
                    scalingImageView5.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    AppHolder.getFragmentImageLoader().displayImage((Fragment) baseFragment2, str, (ImageView) ((ItemArticleDetailTopBinding) getBinding()).topImageView, ImageLoaderOptions.newBuilder().placeHolderRes(2131231691).useAnimate(true).build(), (OnImageLoadListener) articleFeedTopViewHolder$populateCover$onImageLoadListener$1, (OnBitmapTransformListener) null);
                    ScalingImageView scalingImageView6 = ((ItemArticleDetailTopBinding) getBinding()).topImageView;
                    Intrinsics.checkNotNullExpressionValue(scalingImageView6, "binding.topImageView");
                    scalingImageView6.setScaleType(ImageView.ScaleType.MATRIX);
                    return;
                }
            }
            str = str2;
            ScalingImageView scalingImageView = ((ItemArticleDetailTopBinding) getBinding()).topImageView;
            Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.topImageView");
            ViewExtendsKt.setUtilClickListener(scalingImageView, new ArticleFeedTopViewHolder$populateCover$1(this, feed, str));
            View view = ((ItemArticleDetailTopBinding) getBinding()).coverViewMask;
            Intrinsics.checkNotNullExpressionValue(view, "binding.coverViewMask");
            view.setVisibility(8);
            messageCover = feed.getMessageCover();
            if (!(messageCover != null || messageCover.length() == 0)) {
            }
        }
    }

    /* access modifiers changed from: private */
    public final void doCoverAnim() {
        ScalingImageView scalingImageView = ((ItemArticleDetailTopBinding) getBinding()).topImageView;
        Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.topImageView");
        if (!scalingImageView.isAttachedToWindow()) {
            ScalingImageView scalingImageView2 = scalingImageView;
            scalingImageView2.addOnAttachStateChangeListener(new ArticleFeedTopViewHolder$doCoverAnim$$inlined$doOnNextAttach$1(scalingImageView2, this, scalingImageView));
            return;
        }
        DataBindingComponent component = getComponent();
        View view = null;
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (!(fragment instanceof Fragment)) {
            fragment = null;
        }
        if (fragment != null) {
            view = fragment.getView();
        }
        if (view != null) {
            Intrinsics.checkNotNullExpressionValue(view, "inFragment<Fragment>()?.view.elvis { return }");
            if (!Intrinsics.areEqual(view.getTag(2131362638), (Object) true)) {
                View view2 = ((ItemArticleDetailTopBinding) getBinding()).coverViewMask;
                Intrinsics.checkNotNullExpressionValue(view2, "binding.coverViewMask");
                view2.setVisibility(0);
                view.setTag(2131362638, true);
                View view3 = ((ItemArticleDetailTopBinding) getBinding()).coverViewMask;
                Intrinsics.checkNotNullExpressionValue(view3, "binding.coverViewMask");
                ScalingImageView scalingImageView3 = ((ItemArticleDetailTopBinding) getBinding()).topImageView;
                Intrinsics.checkNotNullExpressionValue(scalingImageView3, "binding.topImageView");
                ViewExtendsKt.startAlphaRevealAnimation$default(view3, scalingImageView3, 0, 0, 0, new ArticleFeedTopViewHolder$doCoverAnim$2(this), 14, null);
            }
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        view.getId();
    }
}
