package com.coolapk.market.view.album.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.RequestListener;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemAlbumExpandCardBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.imageloader.RequestListenerAdapter;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Album;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.node.BitmapSizeTransformation;
import com.coolapk.market.viewholder.GenericBindHolder;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0002J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016R\u0015\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/album/viewholder/AlbumExpandCardViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemAlbumExpandCardBinding;", "Lcom/coolapk/market/model/Album;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "dataList", "", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Ljava/util/List;)V", "getDataList", "()Ljava/util/List;", "isCoverLoaded", "", "signUrl", "", "viewModel", "Lcom/coolapk/market/view/album/AlbumDetailViewModel;", "bindToContent", "", "data", "findUrl", "list", "loadCover", "url", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumExpandCardViewHolder.kt */
public final class AlbumExpandCardViewHolder extends GenericBindHolder<ItemAlbumExpandCardBinding, Album> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558582;
    private final List<?> dataList;
    private boolean isCoverLoaded;
    private String signUrl;
    private AlbumDetailViewModel viewModel = new AlbumDetailViewModel(getContext());

    public final List<?> getDataList() {
        return this.dataList;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlbumExpandCardViewHolder(View view, DataBindingComponent dataBindingComponent, List<?> list) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(list, "dataList");
        this.dataList = list;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/album/viewholder/AlbumExpandCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumExpandCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Album album) {
        ItemAlbumExpandCardBinding itemAlbumExpandCardBinding = (ItemAlbumExpandCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumExpandCardBinding, "binding");
        itemAlbumExpandCardBinding.setClick(this);
        Objects.requireNonNull(album, "null cannot be cast to non-null type com.coolapk.market.model.Album");
        this.viewModel.setAlbum(album);
        ItemAlbumExpandCardBinding itemAlbumExpandCardBinding2 = (ItemAlbumExpandCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumExpandCardBinding2, "binding");
        itemAlbumExpandCardBinding2.setModel(this.viewModel);
        List<String> apkRowsIcon = this.viewModel.getApkRowsIcon();
        TextView textView = ((ItemAlbumExpandCardBinding) getBinding()).infoView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.infoView");
        textView.setText("");
        ItemAlbumExpandCardBinding itemAlbumExpandCardBinding3 = (ItemAlbumExpandCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumExpandCardBinding3, "binding");
        itemAlbumExpandCardBinding3.setIcon5(apkRowsIcon.get(0));
        ItemAlbumExpandCardBinding itemAlbumExpandCardBinding4 = (ItemAlbumExpandCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumExpandCardBinding4, "binding");
        Intrinsics.checkNotNullExpressionValue(apkRowsIcon, "apkRowsIcon");
        itemAlbumExpandCardBinding4.setIcon3((String) CollectionsKt.getOrNull(apkRowsIcon, 4));
        ItemAlbumExpandCardBinding itemAlbumExpandCardBinding5 = (ItemAlbumExpandCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumExpandCardBinding5, "binding");
        itemAlbumExpandCardBinding5.setIcon2((String) CollectionsKt.getOrNull(apkRowsIcon, 3));
        ItemAlbumExpandCardBinding itemAlbumExpandCardBinding6 = (ItemAlbumExpandCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumExpandCardBinding6, "binding");
        itemAlbumExpandCardBinding6.setIcon1((String) CollectionsKt.getOrNull(apkRowsIcon, 2));
        ItemAlbumExpandCardBinding itemAlbumExpandCardBinding7 = (ItemAlbumExpandCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumExpandCardBinding7, "binding");
        itemAlbumExpandCardBinding7.setIcon0((String) CollectionsKt.getOrNull(apkRowsIcon, 1));
        loadCover(findUrl(apkRowsIcon));
        ItemAlbumExpandCardBinding itemAlbumExpandCardBinding8 = (ItemAlbumExpandCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumExpandCardBinding8, "binding");
        itemAlbumExpandCardBinding8.setTransformer(new CircleTransform(false, 0, 3, null));
        ((ItemAlbumExpandCardBinding) getBinding()).executePendingBindings();
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        ItemAlbumExpandCardBinding itemAlbumExpandCardBinding9 = (ItemAlbumExpandCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumExpandCardBinding9, "binding");
        View root = itemAlbumExpandCardBinding9.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        instance.traceFeedStayInList(root, "应用集");
    }

    private final String findUrl(List<String> list) {
        for (T t : list) {
            if (!TextUtils.isEmpty(t) && StringsKt.startsWith$default((String) t, "http", false, 2, (Object) null)) {
                return t;
            }
        }
        return "http://image.coolapk.com/apk_logo/2018/0116/ic_launcher-4599-o_1c3v0ii87s26r0benla7q118eq-uid-97100@192x192.png";
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Album album;
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        int id = view.getId();
        String str = null;
        if (id == 2131362095) {
            Context context = getContext();
            ItemAlbumExpandCardBinding itemAlbumExpandCardBinding = (ItemAlbumExpandCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemAlbumExpandCardBinding, "binding");
            AlbumDetailViewModel model = itemAlbumExpandCardBinding.getModel();
            if (!(model == null || (album = model.getAlbum()) == null)) {
                str = album.getUid();
            }
            ActionManager.startUserSpaceActivity(context, str);
        } else if (id == 2131362200 || id == 2131362323) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            ActionManagerCompat.startActivityByUrl$default(context2, this.viewModel.getUrl(), null, null, 12, null);
            StatisticHelper instance = StatisticHelper.Companion.getInstance();
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
                str = baseFragment.getFixedRecordId();
            }
            Album album2 = this.viewModel.getAlbum();
            Intrinsics.checkNotNull(album2);
            Intrinsics.checkNotNullExpressionValue(album2, "viewModel.album!!");
            StatisticHelper.recordEntityEvent$default(instance, str, album2, getAdapterPosition(), null, null, 24, null);
        }
    }

    private final void loadCover(String str) {
        if (!this.isCoverLoaded || !TextUtils.equals(this.signUrl, str)) {
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                this.isCoverLoaded = true;
                this.signUrl = str;
                GlideRequest listener = GlideApp.with(getContext()).as(PaletteBitmap.class).load(str).transform((Transformation<Bitmap>) new BitmapSizeTransformation(24, 24)).priority(Priority.IMMEDIATE).listener((RequestListener) new RequestListenerAdapter(str, new AlbumExpandCardViewHolder$loadCover$onImageLoadListener$1(this)));
                ImageView imageView = ((ItemAlbumExpandCardBinding) getBinding()).bgView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.bgView");
                listener.into((GlideRequest) new AlbumCardBackgroundTarget(imageView, ((ItemAlbumExpandCardBinding) getBinding()).iconView5, false, 4, null));
            }
        }
    }
}
