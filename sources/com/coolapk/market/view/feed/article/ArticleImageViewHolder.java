package com.coolapk.market.view.feed.article;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemArticleViewImageBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.RequestListenerAdapter;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feed.reply.FeedArticleDetailFragment;
import com.coolapk.market.view.feedv8.ArticleImage;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.view.ImageLoadProgressBar;
import com.coolapk.market.widget.view.ScalingImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0002R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/feed/article/ArticleImageViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "presenter", "Lcom/coolapk/market/view/feed/article/ArticleFragmentPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;Lcom/coolapk/market/view/feed/article/ArticleFragmentPresenter;)V", "model", "Lcom/coolapk/market/view/feedv8/ArticleImage;", "modelPicIndex", "", "getPresenter", "()Lcom/coolapk/market/view/feed/article/ArticleFragmentPresenter;", "bindTo", "", "data", "", "onImageClick", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleImageViewHolder.kt */
public final class ArticleImageViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558620;
    private ArticleImage model;
    private int modelPicIndex;
    private final ArticleFragmentPresenter presenter;

    public final ArticleFragmentPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleImageViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, ArticleFragmentPresenter articleFragmentPresenter) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
        Intrinsics.checkNotNullParameter(articleFragmentPresenter, "presenter");
        this.presenter = articleFragmentPresenter;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1, 16777215});
        FrameLayout frameLayout = ((ItemArticleViewImageBinding) getBinding()).longPicTextContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.longPicTextContainer");
        frameLayout.setBackground(gradientDrawable);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/article/ArticleImageViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleImageViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r3v23, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARN: Type inference failed for: r3v27, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        String str;
        Intrinsics.checkNotNullParameter(obj, "data");
        List<ArticleModel> articleModelList = this.presenter.getArticleModelList();
        Integer intValue = ((HolderItem) obj).getIntValue();
        Intrinsics.checkNotNullExpressionValue(intValue, "(data as HolderItem).intValue");
        ArticleModel articleModel = articleModelList.get(intValue.intValue());
        Objects.requireNonNull(articleModel, "null cannot be cast to non-null type com.coolapk.market.view.feedv8.ArticleImage");
        this.model = (ArticleImage) articleModel;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = this.presenter.getArticleModelList().iterator();
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            if (next.getType() != ArticleModel.Type.Image) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        Iterator it3 = arrayList.iterator();
        int i = 0;
        while (true) {
            if (!it3.hasNext()) {
                i = -1;
                break;
            }
            ArticleModel articleModel2 = (ArticleModel) it3.next();
            ArticleImage articleImage = this.model;
            if (articleImage == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
            }
            if (articleModel2 == articleImage) {
                break;
            }
            i++;
        }
        this.modelPicIndex = i;
        ItemArticleViewImageBinding itemArticleViewImageBinding = (ItemArticleViewImageBinding) getBinding();
        TextView textView = itemArticleViewImageBinding.descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.descriptionView");
        ArticleImage articleImage2 = this.model;
        if (articleImage2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        textView.setText(articleImage2.getText());
        TextView textView2 = itemArticleViewImageBinding.descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
        ArticleImage articleImage3 = this.model;
        if (articleImage3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        textView2.setVisibility(TextUtils.isEmpty(articleImage3.getText()) ? 8 : 0);
        AppPictureSizeManager instance = AppPictureSizeManager.getInstance();
        ArticleImage articleImage4 = this.model;
        if (articleImage4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        AppPictureSizeManager.PictureSize size = instance.getSize(articleImage4.getImageUrl());
        ArticleImageViewHolder$bindTo$4 articleImageViewHolder$bindTo$4 = null;
        ArticleImage articleImage5 = this.model;
        if (articleImage5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        String imageUrl = articleImage5.getImageUrl();
        String str2 = "";
        if (imageUrl == null) {
            imageUrl = str2;
        }
        Objects.requireNonNull(imageUrl, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = imageUrl.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        boolean z2 = StringsKt.endsWith$default(lowerCase, ".gif", false, 2, null) && AppHolder.getAppSetting().shouldLoadSourcePhoto();
        ImageArgs.Companion companion = ImageArgs.Companion;
        ArticleImage articleImage6 = this.model;
        if (articleImage6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        String imageUrl2 = articleImage6.getImageUrl();
        if (imageUrl2 == null) {
            imageUrl2 = str2;
        }
        String s2xSizeProvider = companion.s2xSizeProvider(imageUrl2);
        if (z2) {
            ArticleImage articleImage7 = this.model;
            if (articleImage7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
            }
            str = articleImage7.getImageUrl();
        } else {
            str = s2xSizeProvider;
        }
        ImageLoadProgressBar imageLoadProgressBar = itemArticleViewImageBinding.progressBar;
        if (z2) {
            str2 = str;
        }
        imageLoadProgressBar.setMonitorUrl(str2);
        if (size != null) {
            ScalingImageView scalingImageView = itemArticleViewImageBinding.ivCover;
            Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.ivCover");
            scalingImageView.setScaleType(ImageView.ScaleType.MATRIX);
            float width = ((float) size.getWidth()) / ((float) size.getHeight());
            if (width < 0.45f) {
                FrameLayout frameLayout = itemArticleViewImageBinding.longPicTextContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.longPicTextContainer");
                frameLayout.setVisibility(0);
                width = 0.45f;
            } else {
                FrameLayout frameLayout2 = itemArticleViewImageBinding.longPicTextContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.longPicTextContainer");
                frameLayout2.setVisibility(4);
            }
            int decorViewWidth = DisplayUtils.getDecorViewWidth(getContext()) - DisplayUtils.dp2px(getContext(), 32.0f);
            ScalingImageView scalingImageView2 = itemArticleViewImageBinding.ivCover;
            Intrinsics.checkNotNullExpressionValue(scalingImageView2, "binding.ivCover");
            ViewGroup.LayoutParams layoutParams = scalingImageView2.getLayoutParams();
            layoutParams.width = decorViewWidth;
            layoutParams.height = (int) (((float) decorViewWidth) / width);
        } else {
            FrameLayout frameLayout3 = itemArticleViewImageBinding.longPicTextContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.longPicTextContainer");
            frameLayout3.setVisibility(4);
            ScalingImageView scalingImageView3 = itemArticleViewImageBinding.ivCover;
            Intrinsics.checkNotNullExpressionValue(scalingImageView3, "binding.ivCover");
            scalingImageView3.setScaleType(ImageView.ScaleType.FIT_CENTER);
            articleImageViewHolder$bindTo$4 = new ArticleImageViewHolder$bindTo$4(this, str, itemArticleViewImageBinding, obj);
        }
        ScalingImageView scalingImageView4 = itemArticleViewImageBinding.ivCover;
        Intrinsics.checkNotNullExpressionValue(scalingImageView4, "binding.ivCover");
        scalingImageView4.setContentDescription("图片 " + (this.modelPicIndex + 1));
        ScalingImageView scalingImageView5 = itemArticleViewImageBinding.ivCover;
        Intrinsics.checkNotNullExpressionValue(scalingImageView5, "binding.ivCover");
        ViewExtendsKt.setUtilClickListener(scalingImageView5, new ArticleImageViewHolder$bindTo$5(this));
        itemArticleViewImageBinding.executePendingBindings();
        if (z2) {
            GlideRequest thumbnail = GlideApp.with(getContext()).load(str).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(2131231702).thumbnail((RequestBuilder) GlideApp.with(getContext()).load(s2xSizeProvider).diskCacheStrategy(DiskCacheStrategy.DATA));
            if (articleImageViewHolder$bindTo$4 != null) {
                thumbnail = thumbnail.listener((RequestListener) new RequestListenerAdapter(str, articleImageViewHolder$bindTo$4));
            }
            Intrinsics.checkNotNullExpressionValue(thumbnail.into(itemArticleViewImageBinding.ivCover), "GlideApp.with(context)\n …   .into(binding.ivCover)");
            return;
        }
        AppHolder.getContextImageLoader().displayImage(getContext(), str, (ImageView) itemArticleViewImageBinding.ivCover, ImageLoaderOptions.newBuilder().placeHolderRes(2131231702).build(), articleImageViewHolder$bindTo$4, (OnBitmapTransformListener) null);
    }

    /* access modifiers changed from: private */
    public final void onImageClick() {
        DataBindingComponent component = getComponent();
        LifecycleOwner lifecycleOwner = null;
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (lifecycleOwner2 instanceof FeedArticleDetailFragment) {
            lifecycleOwner = lifecycleOwner2;
        }
        FeedArticleDetailFragment feedArticleDetailFragment = (FeedArticleDetailFragment) lifecycleOwner;
        if (feedArticleDetailFragment != null) {
            List<String> htmlPicArray = EntityExtendsKt.getHtmlPicArray(feedArticleDetailFragment.getFeed$presentation_coolapkAppRelease());
            Rect[] rectArr = new Rect[htmlPicArray.size()];
            ScalingImageView scalingImageView = ((ItemArticleViewImageBinding) getBinding()).ivCover;
            Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.ivCover");
            Rect globalRect = ViewExtendsKt.getGlobalRect(scalingImageView);
            int i = this.modelPicIndex;
            rectArr[i] = globalRect;
            int adapterPosition = getAdapterPosition();
            while (adapterPosition >= 0) {
                adapterPosition--;
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = feedArticleDetailFragment.getRecyclerView().findViewHolderForAdapterPosition(adapterPosition);
                if (findViewHolderForAdapterPosition == null) {
                    adapterPosition = -1;
                } else if (findViewHolderForAdapterPosition instanceof ArticleImageViewHolder) {
                    ArticleImageViewHolder articleImageViewHolder = (ArticleImageViewHolder) findViewHolderForAdapterPosition;
                    int i2 = articleImageViewHolder.modelPicIndex;
                    ScalingImageView scalingImageView2 = ((ItemArticleViewImageBinding) articleImageViewHolder.getBinding()).ivCover;
                    Intrinsics.checkNotNullExpressionValue(scalingImageView2, "viewholder.getBinding<It…ewImageBinding>().ivCover");
                    rectArr[i2] = ViewExtendsKt.getGlobalRect(scalingImageView2);
                }
            }
            int adapterPosition2 = getAdapterPosition();
            while (adapterPosition2 < htmlPicArray.size()) {
                adapterPosition2++;
                RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = feedArticleDetailFragment.getRecyclerView().findViewHolderForAdapterPosition(adapterPosition2);
                if (findViewHolderForAdapterPosition2 == null) {
                    adapterPosition2 = Integer.MAX_VALUE;
                } else if (findViewHolderForAdapterPosition2 instanceof ArticleImageViewHolder) {
                    ArticleImageViewHolder articleImageViewHolder2 = (ArticleImageViewHolder) findViewHolderForAdapterPosition2;
                    int i3 = articleImageViewHolder2.modelPicIndex;
                    ScalingImageView scalingImageView3 = ((ItemArticleViewImageBinding) articleImageViewHolder2.getBinding()).ivCover;
                    Intrinsics.checkNotNullExpressionValue(scalingImageView3, "viewholder.getBinding<It…ewImageBinding>().ivCover");
                    rectArr[i3] = ViewExtendsKt.getGlobalRect(scalingImageView3);
                }
            }
            for (int i4 = 0; i4 < htmlPicArray.size(); i4++) {
                if (rectArr[i4] == null) {
                    if (i4 < i) {
                        Rect rect = new Rect(globalRect);
                        rect.offset(0, -DisplayUtils.getHeightPixels(getContext()));
                        Unit unit = Unit.INSTANCE;
                        rectArr[i4] = rect;
                    } else if (i4 > i) {
                        Rect rect2 = new Rect(globalRect);
                        rect2.offset(0, DisplayUtils.getHeightPixels(getContext()));
                        Unit unit2 = Unit.INSTANCE;
                        rectArr[i4] = rect2;
                    }
                }
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Activity activityNullable = UiUtils.getActivityNullable(context);
            Object[] array = htmlPicArray.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr = (String[]) array;
            List<String> list = htmlPicArray;
            ImageArgs.Companion companion = ImageArgs.Companion;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(companion.s2xSizeProvider(it2.next()));
            }
            Object[] array2 = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            ActionManager.startPhotoViewActivity(activityNullable, strArr, (String[]) array2, this.modelPicIndex, null, null, rectArr);
        }
    }
}
