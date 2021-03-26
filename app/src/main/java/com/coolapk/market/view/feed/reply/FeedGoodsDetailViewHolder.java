package com.coolapk.market.view.feed.reply;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.databinding.ItemFeedGoodsDetailBinding;
import com.coolapk.market.databinding.ItemFeedGoodsDetailImageBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoodsAction;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feedv8.RatingContentHelper;
import com.coolapk.market.view.photo.PhotoActivityCallback;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPart;
import com.coolapk.market.viewholder.FeedGoodsInfoViewPartKt;
import com.coolapk.market.viewholder.FeedRelativeInfoViewPart;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.view.BadBadRatingBar;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.coolapk.market.widget.view.RatingTagShape;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u000267B1\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0016J\u0010\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u0006H\u0016J\u0018\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\fH\u0016J\u0018\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u0006H\u0002J\b\u00105\u001a\u00020,H\u0002R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u001b\u001a\u0004\b(\u0010)¨\u00068"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedGoodsDetailViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedGoodsDetailBinding;", "Lcom/coolapk/market/model/HolderItem;", "Lcom/coolapk/market/view/photo/PhotoActivityCallback;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "flags", "", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;ILcom/coolapk/market/view/feed/reply/FeedDetailPresenter;)V", "feed", "Lcom/coolapk/market/model/Feed;", "getFeed", "()Lcom/coolapk/market/model/Feed;", "getFlags", "()I", "goodsInfoViewPart", "Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart;", "getGoodsInfoViewPart", "()Lcom/coolapk/market/viewholder/FeedGoodsInfoViewPart;", "goodsInfoViewPart$delegate", "Lkotlin/Lazy;", "headerViewPart", "Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "headerViewPart$delegate", "imageList", "", "", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "relativeInfoViewPart", "Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "getRelativeInfoViewPart", "()Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "relativeInfoViewPart$delegate", "bindToContent", "", "data", "onClick", "view", "onDismissPhoto", "source", "index", "onImageClick", "position", "populateViewPage", "Companion", "ImageViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGoodsDetailViewHolder.kt */
public final class FeedGoodsDetailViewHolder extends GenericBindHolder<ItemFeedGoodsDetailBinding, HolderItem> implements PhotoActivityCallback {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558703;
    private final int flags;
    private final Lazy goodsInfoViewPart$delegate;
    private final Lazy headerViewPart$delegate;
    private final List<String> imageList;
    private final FeedDetailPresenter presenter;
    private final Lazy relativeInfoViewPart$delegate;

    private final FeedGoodsInfoViewPart getGoodsInfoViewPart() {
        return (FeedGoodsInfoViewPart) this.goodsInfoViewPart$delegate.getValue();
    }

    private final FeedFollowableHeaderViewPart getHeaderViewPart() {
        return (FeedFollowableHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    private final FeedRelativeInfoViewPart getRelativeInfoViewPart() {
        return (FeedRelativeInfoViewPart) this.relativeInfoViewPart$delegate.getValue();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedGoodsDetailViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, int i, FeedDetailPresenter feedDetailPresenter, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, dataBindingComponent, itemActionHandler, (i2 & 8) != 0 ? 0 : i, feedDetailPresenter);
    }

    public final int getFlags() {
        return this.flags;
    }

    public final FeedDetailPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedGoodsDetailViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, int i, FeedDetailPresenter feedDetailPresenter) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(feedDetailPresenter, "presenter");
        this.flags = i;
        this.presenter = feedDetailPresenter;
        this.imageList = new ArrayList();
        ItemFeedGoodsDetailBinding itemFeedGoodsDetailBinding = (ItemFeedGoodsDetailBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedGoodsDetailBinding, "binding");
        itemFeedGoodsDetailBinding.setClick(this);
        ((ItemFeedGoodsDetailBinding) getBinding()).ratingBar.setHeartShapeProgressBar(NumberExtendsKt.getDp((Number) 22));
        ((ItemFeedGoodsDetailBinding) getBinding()).viewPagerContainer.setAspectRatio(1.0f);
        ViewPager2 viewPager2 = ((ItemFeedGoodsDetailBinding) getBinding()).viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.setAdapter(new RecyclerView.Adapter<ImageViewHolder>(this) {
            /* class com.coolapk.market.view.feed.reply.FeedGoodsDetailViewHolder.AnonymousClass1 */
            final /* synthetic */ FeedGoodsDetailViewHolder this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.this$0.imageList.size();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                ItemFeedGoodsDetailImageBinding itemFeedGoodsDetailImageBinding = (ItemFeedGoodsDetailImageBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), 2131558704, viewGroup, false);
                FeedGoodsDetailViewHolder feedGoodsDetailViewHolder = this.this$0;
                Intrinsics.checkNotNullExpressionValue(itemFeedGoodsDetailImageBinding, "binding");
                View root = itemFeedGoodsDetailImageBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                return new ImageViewHolder(feedGoodsDetailViewHolder, root);
            }

            public void onBindViewHolder(ImageViewHolder imageViewHolder, int i) {
                Intrinsics.checkNotNullParameter(imageViewHolder, "holder");
                imageViewHolder.bindTo((String) this.this$0.imageList.get(i));
            }
        });
        ((ItemFeedGoodsDetailBinding) getBinding()).viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(this) {
            /* class com.coolapk.market.view.feed.reply.FeedGoodsDetailViewHolder.AnonymousClass2 */
            final /* synthetic */ FeedGoodsDetailViewHolder this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                ((ItemFeedGoodsDetailBinding) this.this$0.getBinding()).indicatorView.setSelectedIndex(i);
            }
        });
        this.headerViewPart$delegate = LazyKt.lazy(new FeedGoodsDetailViewHolder$headerViewPart$2(this, dataBindingComponent));
        this.relativeInfoViewPart$delegate = LazyKt.lazy(new FeedGoodsDetailViewHolder$relativeInfoViewPart$2(this));
        this.goodsInfoViewPart$delegate = LazyKt.lazy(new FeedGoodsDetailViewHolder$goodsInfoViewPart$2(this, dataBindingComponent));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedGoodsDetailViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedGoodsDetailViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final Feed getFeed() {
        return this.presenter.getFeed();
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        ItemFeedGoodsDetailBinding itemFeedGoodsDetailBinding = (ItemFeedGoodsDetailBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedGoodsDetailBinding, "binding");
        itemFeedGoodsDetailBinding.setModel(getFeed());
        getHeaderViewPart().bindToContent(getFeed());
        getRelativeInfoViewPart().bindTo(getFeed());
        getGoodsInfoViewPart().bindToContent(FeedGoodsInfoViewPartKt.toGoodsSimpleInfo(getFeed()));
        FeedGoodsAction goodsAction = getFeed().getGoodsAction();
        if (goodsAction == null) {
            goodsAction = FeedGoodsAction.EMPTY;
        }
        TextView textView = itemFeedGoodsDetailBinding.buyTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.buyTextView");
        Intrinsics.checkNotNullExpressionValue(goodsAction, "goodsAction");
        textView.setText(goodsAction.getWishBuyStatus() == 1 ? "买过" : "想买");
        itemFeedGoodsDetailBinding.buyView.setBackgroundColor((int) (goodsAction.getWishBuyStatus() == 1 ? 4280391411L : 4294198070L));
        BadBadRatingBar badBadRatingBar = itemFeedGoodsDetailBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar, "binding.ratingBar");
        badBadRatingBar.setRating((float) goodsAction.getStar());
        RatingContentHelper ratingContentHelper = RatingContentHelper.INSTANCE;
        BadBadRatingBar badBadRatingBar2 = itemFeedGoodsDetailBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar2, "binding.ratingBar");
        BadBadRatingBar badBadRatingBar3 = itemFeedGoodsDetailBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar3, "binding.ratingBar");
        ratingContentHelper.setRatingBarTintColor(badBadRatingBar2, (int) badBadRatingBar3.getRating());
        RatingContentHelper ratingContentHelper2 = RatingContentHelper.INSTANCE;
        BadBadRatingBar badBadRatingBar4 = itemFeedGoodsDetailBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar4, "binding.ratingBar");
        ratingContentHelper2.setRatingBarBackgroundGreyColor(badBadRatingBar4);
        TextView textView2 = itemFeedGoodsDetailBinding.ratingTagsView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.ratingTagsView");
        textView2.setBackground(new ShapeDrawable(new RatingTagShape()));
        populateViewPage();
        itemFeedGoodsDetailBinding.executePendingBindings();
    }

    private final void populateViewPage() {
        List<String> htmlPicArray = EntityExtendsKt.getHtmlPicArray(getFeed());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(htmlPicArray, 10));
        Iterator<T> it2 = htmlPicArray.iterator();
        while (it2.hasNext()) {
            arrayList.add(ImageArgs.Companion.middleSizeProvider(it2.next()));
        }
        ArrayList arrayList2 = arrayList;
        this.imageList.clear();
        ArrayList arrayList3 = arrayList2;
        this.imageList.addAll(arrayList3);
        MaxWidthFrameLayout maxWidthFrameLayout = ((ItemFeedGoodsDetailBinding) getBinding()).viewPagerContainer;
        Intrinsics.checkNotNullExpressionValue(maxWidthFrameLayout, "binding.viewPagerContainer");
        maxWidthFrameLayout.setVisibility(arrayList3.isEmpty() ^ true ? 0 : 8);
        ViewPager2 viewPager2 = ((ItemFeedGoodsDetailBinding) getBinding()).viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        IndicatorView indicatorView = ((ItemFeedGoodsDetailBinding) getBinding()).indicatorView;
        Intrinsics.checkNotNullExpressionValue(indicatorView, "binding.indicatorView");
        if (arrayList2.size() <= 1) {
            indicatorView.setVisibility(8);
            return;
        }
        indicatorView.setVisibility(0);
        indicatorView.setTotalIndicatorCount(arrayList2.size());
        indicatorView.setSelectedIndex(0);
        indicatorView.setSelectedDrawableColor(ResourceUtils.getColorInt(getContext(), 2131100147));
        indicatorView.setUnSelectedDrawableColor(ResourceUtils.getColorInt(getContext(), 2131100150));
    }

    /* access modifiers changed from: private */
    public final void onImageClick(int i, View view) {
        List<String> htmlPicArray = EntityExtendsKt.getHtmlPicArray(getFeed());
        Rect[] rectArr = new Rect[htmlPicArray.size()];
        Rect globalRect = ViewExtendsKt.getGlobalRect(view);
        rectArr[i] = globalRect;
        int size = htmlPicArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 < i) {
                rectArr[i2] = new Rect(globalRect);
            } else if (i2 > i) {
                rectArr[i2] = new Rect(globalRect);
            }
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        Intrinsics.checkNotNull(activityNullable);
        Object[] array = htmlPicArray.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr = (String[]) array;
        List<String> list = htmlPicArray;
        ImageArgs.Companion companion = ImageArgs.Companion;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(companion.middleSizeProvider(it2.next()));
        }
        Object[] array2 = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        ActionManagerCompat.startPhotoViewActivity$default(activityNullable, strArr, (String[]) array2, i, null, null, rectArr, false, null, 432, null);
    }

    @Override // com.coolapk.market.view.photo.PhotoActivityCallback
    public void onDismissPhoto(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "source");
        ((ItemFeedGoodsDetailBinding) getBinding()).viewPager.setCurrentItem(i, false);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedGoodsDetailViewHolder$ImageViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "(Lcom/coolapk/market/view/feed/reply/FeedGoodsDetailViewHolder;Landroid/view/View;)V", "bindTo", "", "data", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedGoodsDetailViewHolder.kt */
    public final class ImageViewHolder extends BindingViewHolder {
        final /* synthetic */ FeedGoodsDetailViewHolder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ImageViewHolder(FeedGoodsDetailViewHolder feedGoodsDetailViewHolder, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = feedGoodsDetailViewHolder;
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemFeedGoodsDetailImageBinding itemFeedGoodsDetailImageBinding = (ItemFeedGoodsDetailImageBinding) getBinding();
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            AppHolder.getContextImageLoader().displayImage(getContext(), str, itemFeedGoodsDetailImageBinding.imageView, 2131231691);
            Intrinsics.checkNotNullExpressionValue(itemFeedGoodsDetailImageBinding, "binding");
            itemFeedGoodsDetailImageBinding.getRoot().setOnClickListener(new FeedGoodsDetailViewHolder$ImageViewHolder$bindTo$1(this, itemFeedGoodsDetailImageBinding));
            TextViewBindingAdapters.setGifIndicatorVisibility(itemFeedGoodsDetailImageBinding.gifIndicator, str, false);
        }
    }
}
