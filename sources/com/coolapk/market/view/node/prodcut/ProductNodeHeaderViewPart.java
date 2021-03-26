package com.coolapk.market.view.node.prodcut;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ViewDataBinding;
import androidx.percentlayout.widget.PercentFrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.databinding.ProductNodeHeaderBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.NewHeadLine;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeExtends;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.node.BitmapSizeTransformation;
import com.coolapk.market.view.node.NodeHelper;
import com.coolapk.market.view.node.NodePaletteBackgroundTarget;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.view.product.ProductPresenter;
import com.coolapk.market.view.product.ProductViewModel;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.coolapk.market.widget.viewpart.TripleAvatarViewPart;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u000256B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0018H\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0002J(\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u00032\u0018\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001a0&J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0003H\u0014J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0016J\u001a\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u00020\u001aH\u0014J\b\u00101\u001a\u00020\u001aH\u0002J\b\u00102\u001a\u00020\u001aH\u0002J\u0012\u00103\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u0018H\u0002J\b\u00104\u001a\u00020\u001aH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/coolapk/market/view/node/prodcut/ProductNodeHeaderViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ProductNodeHeaderBinding;", "Lcom/coolapk/market/model/Product;", "activity", "Landroid/app/Activity;", "viewModel", "Lcom/coolapk/market/view/product/ProductViewModel;", "presenter", "Lcom/coolapk/market/view/product/ProductPresenter;", "(Landroid/app/Activity;Lcom/coolapk/market/view/product/ProductViewModel;Lcom/coolapk/market/view/product/ProductPresenter;)V", "getActivity", "()Landroid/app/Activity;", "getPresenter", "()Lcom/coolapk/market/view/product/ProductPresenter;", "tripleViewPart", "Lcom/coolapk/market/widget/viewpart/TripleAvatarViewPart;", "getTripleViewPart", "()Lcom/coolapk/market/widget/viewpart/TripleAvatarViewPart;", "tripleViewPart$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/coolapk/market/view/product/ProductViewModel;", "viewRatingType", "", "applyWindowsInset", "", "rect", "Landroid/graphics/Rect;", "buildRatingData", "Lcom/coolapk/market/view/node/prodcut/ProductNodeHeaderViewPart$RatingData;", "viewType", "createTagsIntoContainer", "tag", "", "loadLogoAndBG", "data", "callback", "Lkotlin/Function2;", "onBindToContent", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "updateFollowState", "updateRatingState", "updateRatingType", "updateWishState", "Companion", "RatingData", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductNodeHeaderViewPart.kt */
public final class ProductNodeHeaderViewPart extends BindingViewPart<ProductNodeHeaderBinding, Product> {
    public static final Companion Companion = new Companion(null);
    private static final float MIN_PERCENT = 0.01f;
    public static final int VIEW_ALL_RATING = 2;
    public static final int VIEW_OWNERS_RATING = 1;
    private final Activity activity;
    private final ProductPresenter presenter;
    private final Lazy tripleViewPart$delegate = LazyKt.lazy(new ProductNodeHeaderViewPart$tripleViewPart$2(this));
    private final ProductViewModel viewModel;
    private int viewRatingType = 2;

    private final TripleAvatarViewPart getTripleViewPart() {
        return (TripleAvatarViewPart) this.tripleViewPart$delegate.getValue();
    }

    public ProductNodeHeaderViewPart(Activity activity2, ProductViewModel productViewModel, ProductPresenter productPresenter) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(productViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(productPresenter, "presenter");
        this.activity = activity2;
        this.viewModel = productViewModel;
        this.presenter = productPresenter;
        productViewModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback(this) {
            /* class com.coolapk.market.view.node.prodcut.ProductNodeHeaderViewPart.AnonymousClass1 */
            final /* synthetic */ ProductNodeHeaderViewPart this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (i != 43) {
                    if (i == 122) {
                        this.this$0.updateFollowState();
                        return;
                    } else if (i == 229) {
                        this.this$0.updateRatingState();
                        return;
                    } else if (i != 322) {
                        return;
                    }
                }
                this.this$0.updateWishState();
            }
        });
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final ProductPresenter getPresenter() {
        return this.presenter;
    }

    public final ProductViewModel getViewModel() {
        return this.viewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/node/prodcut/ProductNodeHeaderViewPart$Companion;", "", "()V", "MIN_PERCENT", "", "VIEW_ALL_RATING", "", "VIEW_OWNERS_RATING", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductNodeHeaderViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ProductNodeHeaderBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559116, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…header, viewGroup, false)");
        return (ProductNodeHeaderBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        TextView textView = ((ProductNodeHeaderBinding) getBinding()).actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        textView.setBackground(ShapeExtends.INSTANCE.createNodeCapsuleActionBackground(this.activity, (float) NumberExtendsKt.getDp((Number) 14)));
        ((ProductNodeHeaderBinding) getBinding()).actionView.setTextColor(ShapeExtends.INSTANCE.createNodeActionTextColors(this.activity));
        TextView textView2 = ((ProductNodeHeaderBinding) getBinding()).ratingView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.ratingView");
        textView2.setBackground(ShapeExtends.INSTANCE.createNodeCapsuleActionBackground(this.activity, (float) NumberExtendsKt.getDp((Number) 14)));
        ((ProductNodeHeaderBinding) getBinding()).ratingView.setTextColor(ShapeExtends.INSTANCE.createNodeActionTextColors(this.activity));
        TextView textView3 = ((ProductNodeHeaderBinding) getBinding()).wishView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.wishView");
        textView3.setBackground(ShapeExtends.INSTANCE.createNodeCapsuleActionBackground(this.activity, (float) NumberExtendsKt.getDp((Number) 14)));
        ((ProductNodeHeaderBinding) getBinding()).wishView.setTextColor(ShapeExtends.INSTANCE.createNodeActionTextColors(this.activity));
        ((ProductNodeHeaderBinding) getBinding()).setClick(this);
        TextView textView4 = ((ProductNodeHeaderBinding) getBinding()).scoreView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.scoreView");
        textView4.setTypeface(ProductGlobalData.getNumberTypeface(getContext()));
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Product product) {
        Intrinsics.checkNotNullParameter(product, "data");
        super.onBindToContent((ProductNodeHeaderViewPart) product);
        Product model = ((ProductNodeHeaderBinding) getBinding()).getModel();
        int i = 1;
        if (model == null || (!Intrinsics.areEqual(model.getId(), product.getId()))) {
            NodeHelper nodeHelper = NodeHelper.INSTANCE;
            LinearAdapterLayout linearAdapterLayout = ((ProductNodeHeaderBinding) getBinding()).linearView;
            Intrinsics.checkNotNullExpressionValue(linearAdapterLayout, "binding.linearView");
            List<NewHeadLine> recommendRows = product.getRecommendRows();
            Intrinsics.checkNotNullExpressionValue(recommendRows, "data.recommendRows");
            nodeHelper.setupRecommendRows(linearAdapterLayout, recommendRows);
            NodeHelper nodeHelper2 = NodeHelper.INSTANCE;
            ViewPager viewPager = ((ProductNodeHeaderBinding) getBinding()).imageViewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager, "binding.imageViewPager");
            IndicatorView indicatorView = ((ProductNodeHeaderBinding) getBinding()).indicatorView;
            Intrinsics.checkNotNullExpressionValue(indicatorView, "binding.indicatorView");
            List<String> coverPicList = product.getCoverPicList();
            Intrinsics.checkNotNullExpressionValue(coverPicList, "data.coverPicList");
            NodeHelper.setupIndicatorAndViewPager$default(nodeHelper2, viewPager, indicatorView, coverPicList, null, 8, null);
            updateFollowState();
            TripleAvatarViewPart tripleViewPart = getTripleViewPart();
            List<RelatedData> recentFollowList = product.getRecentFollowList();
            Intrinsics.checkNotNullExpressionValue(recentFollowList, "data.recentFollowList");
            List<RelatedData> list = recentFollowList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                String userAvatar = t.getUserAvatar();
                if (userAvatar == null) {
                    userAvatar = "";
                }
                arrayList.add(userAvatar);
            }
            tripleViewPart.bindToContent(arrayList);
            TextView textView = ((ProductNodeHeaderBinding) getBinding()).descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.descriptionView");
            int i2 = 8;
            textView.setVisibility(8);
            List<String> tagArr = product.getTagArr();
            ((ProductNodeHeaderBinding) getBinding()).tagsContainer.removeAllViews();
            if (tagArr.isEmpty()) {
                HorizontalScrollView horizontalScrollView = ((ProductNodeHeaderBinding) getBinding()).horizontalScrollView;
                Intrinsics.checkNotNullExpressionValue(horizontalScrollView, "binding.horizontalScrollView");
                horizontalScrollView.setVisibility(8);
            } else {
                HorizontalScrollView horizontalScrollView2 = ((ProductNodeHeaderBinding) getBinding()).horizontalScrollView;
                Intrinsics.checkNotNullExpressionValue(horizontalScrollView2, "binding.horizontalScrollView");
                horizontalScrollView2.setVisibility(0);
                Intrinsics.checkNotNullExpressionValue(tagArr, "tags");
                for (T t2 : tagArr) {
                    Intrinsics.checkNotNullExpressionValue(t2, "it");
                    createTagsIntoContainer(t2);
                }
            }
            TextView textView2 = ((ProductNodeHeaderBinding) getBinding()).hotNumView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.hotNumView");
            textView2.setText(KotlinExtendKt.toDisplayString(product.getHotNum()) + "热度  " + KotlinExtendKt.toDisplayString(product.getFeedCommentNum()) + "讨论");
            Product model2 = this.viewModel.getModel();
            boolean z = EntityExtendsKt.isPhoneOrTablet(model2) && model2.isReleased();
            if (z) {
                if (this.viewModel.getModel().getOwnerStarTotalCount() <= 0) {
                    i = 2;
                }
                this.viewRatingType = i;
            }
            LinearLayout linearLayout = ((ProductNodeHeaderBinding) getBinding()).ratingOwnerContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.ratingOwnerContainer");
            LinearLayout linearLayout2 = linearLayout;
            if (z) {
                i2 = 0;
            }
            linearLayout2.setVisibility(i2);
            updateRatingState();
        }
        ((ProductNodeHeaderBinding) getBinding()).setModel(product);
        ((ProductNodeHeaderBinding) getBinding()).executePendingBindings();
        updateWishState();
    }

    public final void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Product model = ((ProductNodeHeaderBinding) getBinding()).getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            MaxWidthFrameLayout maxWidthFrameLayout = ((ProductNodeHeaderBinding) getBinding()).coverViewContainer;
            List<String> coverPicList = model.getCoverPicList();
            Intrinsics.checkNotNullExpressionValue(coverPicList, "data.coverPicList");
            if (!coverPicList.isEmpty()) {
                MaxWidthFrameLayout maxWidthFrameLayout2 = maxWidthFrameLayout;
                ViewGroup.LayoutParams layoutParams = maxWidthFrameLayout2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = NumberExtendsKt.getDp((Number) 203);
                    maxWidthFrameLayout2.setLayoutParams(layoutParams);
                    maxWidthFrameLayout2.setVisibility(0);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            MaxWidthFrameLayout maxWidthFrameLayout3 = maxWidthFrameLayout;
            ViewGroup.LayoutParams layoutParams2 = maxWidthFrameLayout3.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = UiUtils.getActionBarSize(maxWidthFrameLayout.getContext()) + rect.top;
                maxWidthFrameLayout3.setLayoutParams(layoutParams2);
                maxWidthFrameLayout3.setVisibility(4);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    private final void createTagsIntoContainer(String str) {
        int dp = NumberExtendsKt.getDp((Number) 6);
        int colorInt = ResourceUtils.getColorInt(getContext(), 2131100165);
        TextView textView = new TextView(getContext());
        TextView textView2 = textView;
        ViewExtendsKt.clipView(textView2, 0, (float) NumberExtendsKt.getDp((Number) 2));
        textView.setPadding(dp, dp, dp, dp);
        textView.setTextColor(ResourceUtils.getColorInt(textView.getContext(), 2131100162));
        textView.setBackground(ShapeUtils.createSelectableItemBackgroundWith(textView.getContext(), new ColorDrawable(colorInt)));
        textView.setIncludeFontPadding(false);
        textView.setTextSize(12.0f);
        textView.setText(str);
        ((ProductNodeHeaderBinding) getBinding()).tagsContainer.addView(textView2, -2, -2);
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(textView2);
        if (marginParams != null) {
            marginParams.rightMargin = NumberExtendsKt.getDp((Number) 6);
        }
    }

    /* access modifiers changed from: private */
    public final void updateFollowState() {
        boolean followState = this.viewModel.getFollowState();
        TextView textView = ((ProductNodeHeaderBinding) getBinding()).actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        textView.setSelected(followState);
        if (followState) {
            ((ProductNodeHeaderBinding) getBinding()).actionView.setText(2131887204);
        } else {
            ((ProductNodeHeaderBinding) getBinding()).actionView.setText(2131887205);
        }
        TextView textView2 = ((ProductNodeHeaderBinding) getBinding()).followNumView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.followNumView");
        textView2.setText(KotlinExtendKt.toDisplayString(this.viewModel.getFollowCount()) + "关注");
    }

    /* access modifiers changed from: private */
    public final void updateRatingState() {
        this.viewModel.getRatingNum();
        TextView textView = ((ProductNodeHeaderBinding) getBinding()).ratingView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.ratingView");
        textView.setSelected(this.viewModel.getRatingState());
        if (this.viewModel.getRatingState()) {
            TextView textView2 = ((ProductNodeHeaderBinding) getBinding()).ratingView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.ratingView");
            textView2.setText("已打分");
        } else if (!this.viewModel.getModel().isReleased()) {
            TextView textView3 = ((ProductNodeHeaderBinding) getBinding()).ratingView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.ratingView");
            textView3.setText("未发布");
        } else if (this.viewModel.getModel().getAllowRating() == 0) {
            TextView textView4 = ((ProductNodeHeaderBinding) getBinding()).ratingView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.ratingView");
            textView4.setText("未开放");
        } else {
            TextView textView5 = ((ProductNodeHeaderBinding) getBinding()).ratingView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.ratingView");
            textView5.setText("打个分");
        }
        updateRatingType(this.viewRatingType);
        if (!this.viewModel.getModel().isReleased()) {
            LinearLayout linearLayout = ((ProductNodeHeaderBinding) getBinding()).ratingSubContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.ratingSubContainer");
            linearLayout.setVisibility(8);
            TextView textView6 = ((ProductNodeHeaderBinding) getBinding()).buySubView;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.buySubView");
            textView6.setVisibility(0);
        } else if (this.viewModel.getModel().getStarTotalCount() > 0) {
            LinearLayout linearLayout2 = ((ProductNodeHeaderBinding) getBinding()).ratingSubContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.ratingSubContainer");
            linearLayout2.setVisibility(0);
            TextView textView7 = ((ProductNodeHeaderBinding) getBinding()).buySubView;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.buySubView");
            textView7.setVisibility(8);
        } else {
            LinearLayout linearLayout3 = ((ProductNodeHeaderBinding) getBinding()).ratingSubContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.ratingSubContainer");
            linearLayout3.setVisibility(8);
            TextView textView8 = ((ProductNodeHeaderBinding) getBinding()).buySubView;
            Intrinsics.checkNotNullExpressionValue(textView8, "binding.buySubView");
            textView8.setVisibility(0);
            TextView textView9 = ((ProductNodeHeaderBinding) getBinding()).buySubView;
            Intrinsics.checkNotNullExpressionValue(textView9, "binding.buySubView");
            textView9.setText("暂无评分");
        }
    }

    /* access modifiers changed from: private */
    public final void updateWishState() {
        String str;
        ProductViewModel productViewModel = this.viewModel;
        if (productViewModel != null) {
            TextView textView = ((ProductNodeHeaderBinding) getBinding()).wishView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.wishView");
            textView.setText(productViewModel.getWishState() ? "已想买" : "想买");
            TextView textView2 = ((ProductNodeHeaderBinding) getBinding()).wishView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.wishView");
            textView2.setSelected(productViewModel.getWishState());
            TextView textView3 = ((ProductNodeHeaderBinding) getBinding()).wishCountView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.wishCountView");
            textView3.setText(productViewModel.getWishCount() + "人想买 ");
            TextView textView4 = ((ProductNodeHeaderBinding) getBinding()).buyCountView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.buyCountView");
            if (EntityExtendsKt.isPhoneOrTablet(productViewModel.getModel())) {
                str = "";
            } else {
                str = ' ' + productViewModel.getBuyCount() + "人买过";
            }
            textView4.setText(str);
            TextView textView5 = ((ProductNodeHeaderBinding) getBinding()).buySubView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.buySubView");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(productViewModel.getWishCount()));
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(20, true), 0, spannableStringBuilder.length(), 33);
            Unit unit = Unit.INSTANCE;
            textView5.setText(spannableStringBuilder.append((CharSequence) " 人想买"));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        int i = 0;
        String str = "";
        switch (view.getId()) {
            case 2131361982:
                ProductPresenter productPresenter = this.presenter;
                String id = this.viewModel.getModel().getId();
                if (id != null) {
                    str = id;
                }
                productPresenter.followProduct(str, this.viewModel.getFollowState(), true ^ this.viewModel.getFollowState());
                return;
            case 2131362190:
                ActionManager.startProductBuyAndWishListActivity(getContext(), this.viewModel.getModel().getId(), 1);
                return;
            case 2131362192:
            case 2131363995:
                ActionManager.startProductBuyAndWishListActivity(getContext(), this.viewModel.getModel().getId(), 0);
                return;
            case 2131362554:
                ActionManager.startProductCouponActivity(getContext(), this.viewModel.getModel());
                return;
            case 2131362973:
                Context context = getContext();
                String id2 = this.viewModel.getModel().getId();
                if (id2 != null) {
                    str = id2;
                }
                ActionManager.startProductFansListActivity(context, str);
                return;
            case 2131363227:
                StatisticHelper.Companion.getInstance().recordPhoneBarAction("点击写点评");
                ProductPresenter.ratingProduct$default(this.presenter, this.viewModel, this.activity, 0, true, 4, null);
                return;
            case 2131363228:
                Product model = this.viewModel.getModel();
                Context context2 = getContext();
                String str2 = model.getTitle() + "的评分";
                String id3 = model.getId();
                int i2 = EntityExtendsKt.isPhoneOrTablet(model) ? -1 : 0;
                if (!EntityExtendsKt.isPhoneOrTablet(model)) {
                    i = -1;
                }
                ActionManager.startNodeRatingListActivity(context2, str2, "7", id3, null, i2, i);
                return;
            case 2131363945:
                updateRatingType(2);
                return;
            case 2131363958:
                updateRatingType(1);
                return;
            case 2131363996:
                boolean wishState = this.viewModel.getWishState();
                ProductPresenter productPresenter2 = this.presenter;
                String id4 = this.viewModel.getModel().getId();
                if (id4 != null) {
                    str = id4;
                }
                productPresenter2.wishProduct(str, wishState, !wishState);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r1v20, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARN: Type inference failed for: r1v25, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final void loadLogoAndBG(Product product, Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(product, "data");
        Intrinsics.checkNotNullParameter(function2, "callback");
        String squareLogo = product.getSquareLogo();
        String str = squareLogo;
        boolean z = false;
        if (str == null || str.length() == 0) {
            GlideApp.with(this.activity).load((Integer) 2131231628).into(((ProductNodeHeaderBinding) getBinding()).logoView);
        } else {
            GlideApp.with(this.activity).load(squareLogo).placeholder(2131231628).diskCacheStrategy(DiskCacheStrategy.DATA).into(((ProductNodeHeaderBinding) getBinding()).logoView);
        }
        List<String> coverPicList = product.getCoverPicList();
        Intrinsics.checkNotNullExpressionValue(coverPicList, "data.coverPicList");
        Object firstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) coverPicList);
        String str2 = (String) firstOrNull;
        if (!(!(str2 == null || str2.length() == 0))) {
            firstOrNull = null;
        }
        String str3 = (String) firstOrNull;
        if (str3 == null || str3.length() == 0) {
            z = true;
        }
        ProductNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1 productNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1 = new ProductNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1(this, !z, function2);
        Integer stringToColor = ColorUtils.stringToColor(product.getBgColor());
        if (stringToColor != null) {
            Pair<Integer, Integer> nodeColors = NodePaletteBackgroundTarget.Companion.getNodeColors(stringToColor.intValue());
            int intValue = nodeColors.component1().intValue();
            int intValue2 = nodeColors.component2().intValue();
            View view = ((ProductNodeHeaderBinding) getBinding()).backgroundTopView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.backgroundTopView");
            view.setBackground(NodePaletteBackgroundTarget.Companion.createShapeDrawable(intValue, intValue2));
            productNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1.invoke((ProductNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1) Integer.valueOf(intValue), Integer.valueOf(intValue2));
            return;
        }
        GlideRequest priority = GlideApp.with(this.activity).as(PaletteBitmap.class).load(squareLogo).transform((Transformation<Bitmap>) new BitmapSizeTransformation(24, 24)).priority(Priority.IMMEDIATE);
        View view2 = ((ProductNodeHeaderBinding) getBinding()).backgroundTopView;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.backgroundTopView");
        Intrinsics.checkNotNullExpressionValue(priority.into((GlideRequest) new NodePaletteBackgroundTarget(view2, ((ProductNodeHeaderBinding) getBinding()).backgroundBottomView, false, productNodeHeaderViewPart$loadLogoAndBG$wrapCallback$1, 4, null)), "GlideApp.with(activity)\n…callback = wrapCallback))");
    }

    static /* synthetic */ void updateRatingType$default(ProductNodeHeaderViewPart productNodeHeaderViewPart, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        productNodeHeaderViewPart.updateRatingType(i);
    }

    private final void updateRatingType(int i) {
        StringBuilder sb;
        String str;
        if (!(i == 2 || i == 1)) {
            i = 2;
        }
        RatingData buildRatingData = buildRatingData(i);
        boolean z = i == 2;
        int[] iArr = {buildRatingData.getRatingNum1(), buildRatingData.getRatingNum2(), buildRatingData.getRatingNum3(), buildRatingData.getRatingNum4(), buildRatingData.getRatingNum5()};
        int i2 = iArr[0];
        int lastIndex = ArraysKt.getLastIndex(iArr);
        if (1 <= lastIndex) {
            int i3 = 1;
            while (true) {
                i2 = Math.max(i2, iArr[i3]);
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        ProductNodeHeaderViewPart$updateRatingType$1 productNodeHeaderViewPart$updateRatingType$1 = new ProductNodeHeaderViewPart$updateRatingType$1(RangesKt.coerceAtLeast(i2, 1));
        TextView textView = ((ProductNodeHeaderBinding) getBinding()).rateNum1;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.rateNum1");
        textView.setText(String.valueOf(buildRatingData.getRatingNum1()));
        TextView textView2 = ((ProductNodeHeaderBinding) getBinding()).rateNum2;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.rateNum2");
        textView2.setText(String.valueOf(buildRatingData.getRatingNum2()));
        TextView textView3 = ((ProductNodeHeaderBinding) getBinding()).rateNum3;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.rateNum3");
        textView3.setText(String.valueOf(buildRatingData.getRatingNum3()));
        TextView textView4 = ((ProductNodeHeaderBinding) getBinding()).rateNum4;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.rateNum4");
        textView4.setText(String.valueOf(buildRatingData.getRatingNum4()));
        TextView textView5 = ((ProductNodeHeaderBinding) getBinding()).rateNum5;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.rateNum5");
        textView5.setText(String.valueOf(buildRatingData.getRatingNum5()));
        ((ProductNodeHeaderBinding) getBinding()).ratingImageView.setImageResource(z ? 2131231747 : 2131231752);
        int i4 = 2131100161;
        ((ProductNodeHeaderBinding) getBinding()).viewAllView.setTextColor(ResourceUtils.getColorInt(this.activity, z ? 2131100161 : 2131100162));
        TextView textView6 = ((ProductNodeHeaderBinding) getBinding()).viewOwnerView;
        Activity activity2 = this.activity;
        if (z) {
            i4 = 2131100162;
        }
        textView6.setTextColor(ResourceUtils.getColorInt(activity2, i4));
        RatingBar ratingBar = ((ProductNodeHeaderBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar, "binding.ratingBar");
        ratingBar.setRating(ProductGlobalData.INSTANCE.ratingScoreToStartScore(buildRatingData.getRatingAverageScore()));
        TextView textView7 = ((ProductNodeHeaderBinding) getBinding()).scoreView;
        Intrinsics.checkNotNullExpressionValue(textView7, "binding.scoreView");
        textView7.setText(KotlinExtendKt.toDisplayScore(buildRatingData.getStarAverageScore()));
        TextView textView8 = ((ProductNodeHeaderBinding) getBinding()).countView;
        Intrinsics.checkNotNullExpressionValue(textView8, "binding.countView");
        if (z) {
            sb.append(buildRatingData.getRatingNum());
            str = "位酷友打分";
        } else {
            sb = new StringBuilder();
            sb.append(buildRatingData.getRatingNum());
            str = "位机主打分";
        }
        sb.append(str);
        textView8.setText(sb.toString());
        int i5 = this.viewRatingType;
        if (!(i5 == 0 || i5 == i)) {
            ImageView imageView = ((ProductNodeHeaderBinding) getBinding()).ratingImageView1;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ratingImageView1");
            ViewParent parent = imageView.getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            TransitionManager.beginDelayedTransition((ViewGroup) parent);
            ImageView imageView2 = ((ProductNodeHeaderBinding) getBinding()).ratingImageView2;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ratingImageView2");
            ViewParent parent2 = imageView2.getParent();
            Objects.requireNonNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
            TransitionManager.beginDelayedTransition((ViewGroup) parent2);
            ImageView imageView3 = ((ProductNodeHeaderBinding) getBinding()).ratingImageView3;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ratingImageView3");
            ViewParent parent3 = imageView3.getParent();
            Objects.requireNonNull(parent3, "null cannot be cast to non-null type android.view.ViewGroup");
            TransitionManager.beginDelayedTransition((ViewGroup) parent3);
            ImageView imageView4 = ((ProductNodeHeaderBinding) getBinding()).ratingImageView4;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ratingImageView4");
            ViewParent parent4 = imageView4.getParent();
            Objects.requireNonNull(parent4, "null cannot be cast to non-null type android.view.ViewGroup");
            TransitionManager.beginDelayedTransition((ViewGroup) parent4);
            ImageView imageView5 = ((ProductNodeHeaderBinding) getBinding()).ratingImageView5;
            Intrinsics.checkNotNullExpressionValue(imageView5, "binding.ratingImageView5");
            ViewParent parent5 = imageView5.getParent();
            Objects.requireNonNull(parent5, "null cannot be cast to non-null type android.view.ViewGroup");
            TransitionManager.beginDelayedTransition((ViewGroup) parent5);
        }
        ImageView imageView6 = ((ProductNodeHeaderBinding) getBinding()).ratingImageView1;
        Intrinsics.checkNotNullExpressionValue(imageView6, "binding.ratingImageView1");
        ImageView imageView7 = imageView6;
        ViewGroup.LayoutParams layoutParams = imageView7.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
        PercentFrameLayout.LayoutParams layoutParams2 = (PercentFrameLayout.LayoutParams) layoutParams;
        layoutParams2.getPercentLayoutInfo().widthPercent = productNodeHeaderViewPart$updateRatingType$1.invoke(buildRatingData.getRatingNum1());
        imageView7.setLayoutParams(layoutParams2);
        ImageView imageView8 = ((ProductNodeHeaderBinding) getBinding()).ratingImageView2;
        Intrinsics.checkNotNullExpressionValue(imageView8, "binding.ratingImageView2");
        ImageView imageView9 = imageView8;
        ViewGroup.LayoutParams layoutParams3 = imageView9.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
        PercentFrameLayout.LayoutParams layoutParams4 = (PercentFrameLayout.LayoutParams) layoutParams3;
        layoutParams4.getPercentLayoutInfo().widthPercent = productNodeHeaderViewPart$updateRatingType$1.invoke(buildRatingData.getRatingNum2());
        imageView9.setLayoutParams(layoutParams4);
        ImageView imageView10 = ((ProductNodeHeaderBinding) getBinding()).ratingImageView3;
        Intrinsics.checkNotNullExpressionValue(imageView10, "binding.ratingImageView3");
        ImageView imageView11 = imageView10;
        ViewGroup.LayoutParams layoutParams5 = imageView11.getLayoutParams();
        Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
        PercentFrameLayout.LayoutParams layoutParams6 = (PercentFrameLayout.LayoutParams) layoutParams5;
        layoutParams6.getPercentLayoutInfo().widthPercent = productNodeHeaderViewPart$updateRatingType$1.invoke(buildRatingData.getRatingNum3());
        imageView11.setLayoutParams(layoutParams6);
        ImageView imageView12 = ((ProductNodeHeaderBinding) getBinding()).ratingImageView4;
        Intrinsics.checkNotNullExpressionValue(imageView12, "binding.ratingImageView4");
        ImageView imageView13 = imageView12;
        ViewGroup.LayoutParams layoutParams7 = imageView13.getLayoutParams();
        Objects.requireNonNull(layoutParams7, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
        PercentFrameLayout.LayoutParams layoutParams8 = (PercentFrameLayout.LayoutParams) layoutParams7;
        layoutParams8.getPercentLayoutInfo().widthPercent = productNodeHeaderViewPart$updateRatingType$1.invoke(buildRatingData.getRatingNum4());
        imageView13.setLayoutParams(layoutParams8);
        ImageView imageView14 = ((ProductNodeHeaderBinding) getBinding()).ratingImageView5;
        Intrinsics.checkNotNullExpressionValue(imageView14, "binding.ratingImageView5");
        ImageView imageView15 = imageView14;
        ViewGroup.LayoutParams layoutParams9 = imageView15.getLayoutParams();
        Objects.requireNonNull(layoutParams9, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
        PercentFrameLayout.LayoutParams layoutParams10 = (PercentFrameLayout.LayoutParams) layoutParams9;
        layoutParams10.getPercentLayoutInfo().widthPercent = productNodeHeaderViewPart$updateRatingType$1.invoke(buildRatingData.getRatingNum5());
        imageView15.setLayoutParams(layoutParams10);
        this.viewRatingType = i;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006&"}, d2 = {"Lcom/coolapk/market/view/node/prodcut/ProductNodeHeaderViewPart$RatingData;", "", "ratingNum1", "", "ratingNum2", "ratingNum3", "ratingNum4", "ratingNum5", "ratingAverageScore", "", "starAverageScore", "ratingNum", "(IIIIIFFI)V", "getRatingAverageScore", "()F", "getRatingNum", "()I", "getRatingNum1", "getRatingNum2", "getRatingNum3", "getRatingNum4", "getRatingNum5", "getStarAverageScore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductNodeHeaderViewPart.kt */
    private static final class RatingData {
        private final float ratingAverageScore;
        private final int ratingNum;
        private final int ratingNum1;
        private final int ratingNum2;
        private final int ratingNum3;
        private final int ratingNum4;
        private final int ratingNum5;
        private final float starAverageScore;

        public static /* synthetic */ RatingData copy$default(RatingData ratingData, int i, int i2, int i3, int i4, int i5, float f, float f2, int i6, int i7, Object obj) {
            return ratingData.copy((i7 & 1) != 0 ? ratingData.ratingNum1 : i, (i7 & 2) != 0 ? ratingData.ratingNum2 : i2, (i7 & 4) != 0 ? ratingData.ratingNum3 : i3, (i7 & 8) != 0 ? ratingData.ratingNum4 : i4, (i7 & 16) != 0 ? ratingData.ratingNum5 : i5, (i7 & 32) != 0 ? ratingData.ratingAverageScore : f, (i7 & 64) != 0 ? ratingData.starAverageScore : f2, (i7 & 128) != 0 ? ratingData.ratingNum : i6);
        }

        public final int component1() {
            return this.ratingNum1;
        }

        public final int component2() {
            return this.ratingNum2;
        }

        public final int component3() {
            return this.ratingNum3;
        }

        public final int component4() {
            return this.ratingNum4;
        }

        public final int component5() {
            return this.ratingNum5;
        }

        public final float component6() {
            return this.ratingAverageScore;
        }

        public final float component7() {
            return this.starAverageScore;
        }

        public final int component8() {
            return this.ratingNum;
        }

        public final RatingData copy(int i, int i2, int i3, int i4, int i5, float f, float f2, int i6) {
            return new RatingData(i, i2, i3, i4, i5, f, f2, i6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RatingData)) {
                return false;
            }
            RatingData ratingData = (RatingData) obj;
            return this.ratingNum1 == ratingData.ratingNum1 && this.ratingNum2 == ratingData.ratingNum2 && this.ratingNum3 == ratingData.ratingNum3 && this.ratingNum4 == ratingData.ratingNum4 && this.ratingNum5 == ratingData.ratingNum5 && Float.compare(this.ratingAverageScore, ratingData.ratingAverageScore) == 0 && Float.compare(this.starAverageScore, ratingData.starAverageScore) == 0 && this.ratingNum == ratingData.ratingNum;
        }

        public int hashCode() {
            return (((((((((((((this.ratingNum1 * 31) + this.ratingNum2) * 31) + this.ratingNum3) * 31) + this.ratingNum4) * 31) + this.ratingNum5) * 31) + Float.floatToIntBits(this.ratingAverageScore)) * 31) + Float.floatToIntBits(this.starAverageScore)) * 31) + this.ratingNum;
        }

        public String toString() {
            return "RatingData(ratingNum1=" + this.ratingNum1 + ", ratingNum2=" + this.ratingNum2 + ", ratingNum3=" + this.ratingNum3 + ", ratingNum4=" + this.ratingNum4 + ", ratingNum5=" + this.ratingNum5 + ", ratingAverageScore=" + this.ratingAverageScore + ", starAverageScore=" + this.starAverageScore + ", ratingNum=" + this.ratingNum + ")";
        }

        public RatingData(int i, int i2, int i3, int i4, int i5, float f, float f2, int i6) {
            this.ratingNum1 = i;
            this.ratingNum2 = i2;
            this.ratingNum3 = i3;
            this.ratingNum4 = i4;
            this.ratingNum5 = i5;
            this.ratingAverageScore = f;
            this.starAverageScore = f2;
            this.ratingNum = i6;
        }

        public final int getRatingNum1() {
            return this.ratingNum1;
        }

        public final int getRatingNum2() {
            return this.ratingNum2;
        }

        public final int getRatingNum3() {
            return this.ratingNum3;
        }

        public final float getRatingAverageScore() {
            return this.ratingAverageScore;
        }

        public final int getRatingNum4() {
            return this.ratingNum4;
        }

        public final int getRatingNum5() {
            return this.ratingNum5;
        }

        public final int getRatingNum() {
            return this.ratingNum;
        }

        public final float getStarAverageScore() {
            return this.starAverageScore;
        }
    }

    static /* synthetic */ RatingData buildRatingData$default(ProductNodeHeaderViewPart productNodeHeaderViewPart, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        return productNodeHeaderViewPart.buildRatingData(i);
    }

    private final RatingData buildRatingData(int i) {
        boolean z = true;
        if (!(i == 2 || i == 1)) {
            z = false;
        }
        if (z) {
            Product model = this.viewModel.getModel();
            if (i != 2) {
                return new RatingData(model.getOwnerStar1Count(), model.getOwnerStar2Count(), model.getOwnerStar3Count(), model.getOwnerStar4Count(), model.getOwnerStar5Count(), model.getOwnerStarAverageScore(), model.getOwnerStarAverageScore(), model.getOwnerStarTotalCount());
            }
            return new RatingData(model.getStar1Count(), model.getStar2Count(), model.getStar3Count(), model.getStar4Count(), model.getStar5Count(), model.getRatingAverageScore(), model.getStarAverageScore(), model.getStarTotalCount());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
