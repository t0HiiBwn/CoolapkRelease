package com.coolapk.market.view.node.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemAppNodeThumbnailBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideImageHelper;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.Size;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\r\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0016J\f\u0010 \u001a\u00020!*\u00020\u0019H\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/coolapk/market/view/node/app/ItemThumbnailViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Lcom/coolapk/market/view/node/app/AppNodeViewModel;)V", "binding", "Lcom/coolapk/market/databinding/ItemAppNodeThumbnailBinding;", "kotlin.jvm.PlatformType", "imageTarget", "com/coolapk/market/view/node/app/ItemThumbnailViewHolder$imageTarget$1", "Lcom/coolapk/market/view/node/app/ItemThumbnailViewHolder$imageTarget$1;", "thumbnailHeight", "", "url", "", "bindTo", "", "item", "", "getImageWidth", "size", "Lcom/coolapk/market/imageloader/Size;", "getPlaceholder", "getPlaceholderDrawable", "Landroid/graphics/drawable/Drawable;", "loadImage", "onClick", "view", "isLongPic", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemThumbnailViewHolder.kt */
public final class ItemThumbnailViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558596;
    public static final float MAX_RATIO = 0.45f;
    private final ItemAppNodeThumbnailBinding binding;
    private final ItemThumbnailViewHolder$imageTarget$1 imageTarget;
    private final RecyclerView recyclerView;
    private final int thumbnailHeight = NumberExtendsKt.getDp((Number) 185);
    private String url;
    private final AppNodeViewModel viewModel;

    public static final /* synthetic */ String access$getUrl$p(ItemThumbnailViewHolder itemThumbnailViewHolder) {
        String str = itemThumbnailViewHolder.url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        }
        return str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemThumbnailViewHolder(View view, RecyclerView recyclerView2, AppNodeViewModel appNodeViewModel) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
        this.recyclerView = recyclerView2;
        this.viewModel = appNodeViewModel;
        ItemAppNodeThumbnailBinding itemAppNodeThumbnailBinding = (ItemAppNodeThumbnailBinding) getBinding();
        this.binding = itemAppNodeThumbnailBinding;
        this.imageTarget = new ItemThumbnailViewHolder$imageTarget$1(this, itemAppNodeThumbnailBinding.imageView);
        itemAppNodeThumbnailBinding.imageView.setOnClickListener(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/node/app/ItemThumbnailViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "MAX_RATIO", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemThumbnailViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
        this.url = (String) obj;
        this.binding.imageView.setTag(2131362703, obj);
        this.binding.executePendingBindings();
        ImageView imageView = this.binding.imageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView");
        ViewExtendsKt.darkForegroundIfNeed(imageView);
        ImageView imageView2 = this.binding.imageView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.imageView");
        imageView2.setContentDescription("应用截图 " + (getAdapterPosition() + 1));
        TextView textView = this.binding.longPicTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.longPicTextView");
        textView.setVisibility(4);
        GlideImageHelper.setClickToLoad(this.binding.imageView, true);
        Object tag = this.binding.imageView.getTag(2131362703);
        Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
        Size size = this.viewModel.getImageSizeCache().get((String) tag);
        if (size != null) {
            ImageView imageView3 = this.binding.imageView;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.imageView");
            ImageView imageView4 = imageView3;
            ViewGroup.LayoutParams layoutParams = imageView4.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = getImageWidth(size);
                imageView4.setLayoutParams(layoutParams);
                loadImage(size);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        this.binding.imageView.setImageDrawable(getPlaceholderDrawable());
        ImageView imageView5 = this.binding.imageView;
        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.imageView");
        Context context = imageView5.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.imageView.context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable == null || !activityNullable.isDestroyed()) {
            GlideRequest as = GlideApp.with(getContext()).as(Size.class);
            String str = this.url;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("url");
            }
            as.load(str).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA).into((GlideRequest) this.imageTarget);
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        ServiceApp serviceApp = this.viewModel.getServiceApp().get();
        Intrinsics.checkNotNull(serviceApp);
        Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get()!!");
        ServiceApp serviceApp2 = serviceApp;
        if (!(serviceApp2.getThumbList() == null || serviceApp2.getScreenList() == null)) {
            List<String> screenList = serviceApp2.getScreenList();
            Intrinsics.checkNotNull(screenList);
            int size = screenList.size();
            Rect[] rectArr = new Rect[size];
            for (int i = 0; i < size; i++) {
                ItemThumbnailViewHolder itemThumbnailViewHolder = (ItemThumbnailViewHolder) this.recyclerView.findViewHolderForAdapterPosition(i);
                if (itemThumbnailViewHolder != null) {
                    View view2 = itemThumbnailViewHolder.itemView;
                    Intrinsics.checkNotNullExpressionValue(view2, "childHolder.itemView");
                    rectArr[i] = ViewExtendsKt.getGlobalRect(view2);
                }
            }
            Activity activity = UiUtils.getActivity(getContext());
            List<String> screenList2 = serviceApp2.getScreenList();
            Intrinsics.checkNotNull(screenList2);
            Intrinsics.checkNotNullExpressionValue(screenList2, "serviceApp.screenList!!");
            Object[] array = screenList2.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            List<String> thumbList = serviceApp2.getThumbList();
            Intrinsics.checkNotNull(thumbList);
            Intrinsics.checkNotNullExpressionValue(thumbList, "serviceApp.thumbList!!");
            Object[] array2 = thumbList.toArray(new String[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            ActionManager.startPhotoViewActivity(activity, (String[]) array, (String[]) array2, getAdapterPosition(), null, null, rectArr);
        }
    }

    /* access modifiers changed from: private */
    public final void loadImage(Size size) {
        int width = size.getWidth();
        int width2 = isLongPic(size) ? (int) (((float) size.getWidth()) / 0.45f) : size.getHeight();
        ImageView imageView = this.binding.imageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.imageView.context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable == null || !activityNullable.isDestroyed()) {
            GlideRequest<Bitmap> asBitmap = GlideApp.with(this.binding.imageView).asBitmap();
            String str = this.url;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("url");
            }
            asBitmap.load(str).placeholder(getPlaceholderDrawable()).transform((Transformation<Bitmap>) new ThumbnailCropTransformation(width, width2)).into(this.binding.imageView);
        }
    }

    private final Drawable getPlaceholderDrawable() {
        return new ColorDrawable(Color.parseColor(AppHolder.getAppTheme().isDarkTheme() ? "#424242" : "#EBEBEB"));
    }

    private final int getPlaceholder() {
        return AppHolder.getAppTheme().isNightTheme() ? 2131231692 : 2131231691;
    }

    /* access modifiers changed from: private */
    public final int getImageWidth(Size size) {
        float width;
        float f;
        if (isLongPic(size)) {
            f = 0.45f;
            width = (float) this.thumbnailHeight;
        } else {
            width = ((float) size.getWidth()) / ((float) size.getHeight());
            f = (float) this.thumbnailHeight;
        }
        return (int) (width * f);
    }

    private final boolean isLongPic(Size size) {
        return 0.45f > ((float) size.getWidth()) / ((float) size.getHeight());
    }
}
