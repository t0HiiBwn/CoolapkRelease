package com.coolapk.market.view.album.albumv8;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.RequestListener;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.AlbumHeaderViewV2Binding;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.imageloader.RequestListenerAdapter;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.view.album.viewholder.AlbumCardBackgroundTarget;
import com.coolapk.market.view.node.BitmapSizeTransformation;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.binding.BindingExtensionKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumV8HeaderViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/AlbumHeaderViewV2Binding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "isCoverLoaded", "", "mBinding", "bindToContent", "", "entity", "loadCover", "url", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumV8HeaderViewHolder.kt */
public final class AlbumV8HeaderViewHolder extends GenericBindHolder<AlbumHeaderViewV2Binding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558447;
    private boolean isCoverLoaded;
    private final AlbumHeaderViewV2Binding mBinding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlbumV8HeaderViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        AlbumHeaderViewV2Binding albumHeaderViewV2Binding = (AlbumHeaderViewV2Binding) getBinding();
        Intrinsics.checkNotNullExpressionValue(albumHeaderViewV2Binding, "binding");
        this.mBinding = albumHeaderViewV2Binding;
    }

    /* JADX WARN: Type inference failed for: r1v19, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Album album = (Album) entity;
        AlbumDetailViewModel albumDetailViewModel = new AlbumDetailViewModel(getContext());
        albumDetailViewModel.setAlbum(album);
        this.mBinding.setViewModel(albumDetailViewModel);
        loadCover(album.getLogo());
        if (albumDetailViewModel.getAlbumRecommend()) {
            GlideApp.with(getContext()).load((Integer) 2131230832).into(this.mBinding.recommendView);
            ImageView imageView = this.mBinding.recommendView;
            Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.recommendView");
            imageView.setVisibility(0);
        }
        this.mBinding.executePendingBindings();
        this.mBinding.infoView.setOnClickListener(new AlbumV8HeaderViewHolder$bindToContent$1(this, albumDetailViewModel));
        this.mBinding.titleView.setOnClickListener(new AlbumV8HeaderViewHolder$bindToContent$2(this, albumDetailViewModel));
        ViewUtil.clickListener(this.mBinding.introduceView, new AlbumV8HeaderViewHolder$bindToContent$3(this, albumDetailViewModel));
        this.mBinding.introduceView.setOnLongClickListener(new AlbumV8HeaderViewHolder$bindToContent$4(this, albumDetailViewModel));
        this.mBinding.introduceView.post(new AlbumV8HeaderViewHolder$bindToContent$5(this));
        FeedWarningBinding feedWarningBinding = this.mBinding.alertView;
        Intrinsics.checkNotNullExpressionValue(feedWarningBinding, "mBinding.alertView");
        BindingExtensionKt.updateInfo(feedWarningBinding, album.getInnerInfo());
    }

    private final void loadCover(String str) {
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        if (!((Activity) context).isFinishing()) {
            String str2 = str;
            if (!(str2 == null || str2.length() == 0) && !this.isCoverLoaded) {
                this.isCoverLoaded = true;
                ImageView imageView = this.mBinding.coverView;
                Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.coverView");
                imageView.setVisibility(4);
                GlideRequest listener = GlideApp.with(UiUtils.getActivity(getContext())).as(PaletteBitmap.class).load(str).placeholder((Drawable) new ColorDrawable(AppHolder.getAppTheme().getColorAccent())).transform((Transformation<Bitmap>) new BitmapSizeTransformation(24, 24)).priority(Priority.IMMEDIATE).listener((RequestListener) new RequestListenerAdapter(str, new AlbumV8HeaderViewHolder$loadCover$onImageLoadListener$1(this)));
                ImageView imageView2 = this.mBinding.coverView;
                Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.coverView");
                listener.into((GlideRequest) new AlbumCardBackgroundTarget(imageView2, null, false, 4, null));
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumV8HeaderViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumV8HeaderViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
