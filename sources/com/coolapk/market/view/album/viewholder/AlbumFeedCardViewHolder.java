package com.coolapk.market.view.album.viewholder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.RequestListener;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.FeedTopBinding;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.databinding.ItemAlbumWithAvatarBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.imageloader.RequestListenerAdapter;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.node.BitmapSizeTransformation;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.binding.BindingExtensionKt;
import com.dinuscxj.ellipsize.EllipsizeTextView;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AlbumFeedCardViewHolder.kt */
public final class AlbumFeedCardViewHolder extends GenericBindHolder<ItemAlbumWithAvatarBinding, Album> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558585;
    private final List<?> dataList;
    private boolean isCoverLoaded;
    private String signUrl;
    private AlbumDetailViewModel viewModel = new AlbumDetailViewModel(getContext());

    public final List<?> getDataList() {
        return this.dataList;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlbumFeedCardViewHolder(View view, DataBindingComponent dataBindingComponent, List<?> list) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(list, "dataList");
        this.dataList = list;
    }

    /* compiled from: AlbumFeedCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Album album) {
        SpannableStringBuilder spannableStringBuilder;
        ItemAlbumWithAvatarBinding itemAlbumWithAvatarBinding = (ItemAlbumWithAvatarBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumWithAvatarBinding, "binding");
        itemAlbumWithAvatarBinding.setClick(this);
        Objects.requireNonNull(album, "null cannot be cast to non-null type com.coolapk.market.model.Album");
        this.viewModel.setAlbum(album);
        ItemAlbumWithAvatarBinding itemAlbumWithAvatarBinding2 = (ItemAlbumWithAvatarBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumWithAvatarBinding2, "binding");
        itemAlbumWithAvatarBinding2.setModel(this.viewModel);
        ItemAlbumWithAvatarBinding itemAlbumWithAvatarBinding3 = (ItemAlbumWithAvatarBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumWithAvatarBinding3, "binding");
        itemAlbumWithAvatarBinding3.setShowFromView(showFromView(album));
        EllipsizeTextView ellipsizeTextView = ((ItemAlbumWithAvatarBinding) getBinding()).fromWhereView;
        Intrinsics.checkNotNullExpressionValue(ellipsizeTextView, "binding.fromWhereView");
        String infoHtml = album.getInfoHtml();
        boolean z = true;
        int i = 0;
        if (infoHtml == null || infoHtml.length() == 0) {
            spannableStringBuilder = album.getInfo();
        } else {
            spannableStringBuilder = LinkTextUtils.convert(album.getInfoHtml(), AppHolder.getAppTheme().getColorAccent(), null);
        }
        ellipsizeTextView.setText(spannableStringBuilder);
        EllipsizeTextView ellipsizeTextView2 = ((ItemAlbumWithAvatarBinding) getBinding()).fromWhereView;
        Intrinsics.checkNotNullExpressionValue(ellipsizeTextView2, "binding.fromWhereView");
        ViewExtendsKt.makeSpanClickable(ellipsizeTextView2);
        List<String> apkRowsIcon = this.viewModel.getApkRowsIcon();
        ItemAlbumWithAvatarBinding itemAlbumWithAvatarBinding4 = (ItemAlbumWithAvatarBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumWithAvatarBinding4, "binding");
        UserInfo userInfo = album.getUserInfo();
        itemAlbumWithAvatarBinding4.setVerifyStatusIcon(userInfo != null ? userInfo.getVerifyStatusIcon() : null);
        TextView textView = ((ItemAlbumWithAvatarBinding) getBinding()).infoView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.infoView");
        textView.setText("");
        ItemAlbumWithAvatarBinding itemAlbumWithAvatarBinding5 = (ItemAlbumWithAvatarBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumWithAvatarBinding5, "binding");
        itemAlbumWithAvatarBinding5.setIcon5(apkRowsIcon.get(0));
        ItemAlbumWithAvatarBinding itemAlbumWithAvatarBinding6 = (ItemAlbumWithAvatarBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumWithAvatarBinding6, "binding");
        Intrinsics.checkNotNullExpressionValue(apkRowsIcon, "apkRowsIcon");
        itemAlbumWithAvatarBinding6.setIcon3((String) CollectionsKt.getOrNull(apkRowsIcon, 4));
        ItemAlbumWithAvatarBinding itemAlbumWithAvatarBinding7 = (ItemAlbumWithAvatarBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumWithAvatarBinding7, "binding");
        itemAlbumWithAvatarBinding7.setIcon2((String) CollectionsKt.getOrNull(apkRowsIcon, 3));
        ItemAlbumWithAvatarBinding itemAlbumWithAvatarBinding8 = (ItemAlbumWithAvatarBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumWithAvatarBinding8, "binding");
        itemAlbumWithAvatarBinding8.setIcon1((String) CollectionsKt.getOrNull(apkRowsIcon, 2));
        ItemAlbumWithAvatarBinding itemAlbumWithAvatarBinding9 = (ItemAlbumWithAvatarBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumWithAvatarBinding9, "binding");
        itemAlbumWithAvatarBinding9.setIcon0((String) CollectionsKt.getOrNull(apkRowsIcon, 1));
        loadCover(findUrl(apkRowsIcon));
        ItemAlbumWithAvatarBinding itemAlbumWithAvatarBinding10 = (ItemAlbumWithAvatarBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumWithAvatarBinding10, "binding");
        itemAlbumWithAvatarBinding10.setTransformer(new CircleTransform(false, 0, 3, null));
        ((ItemAlbumWithAvatarBinding) getBinding()).executePendingBindings();
        ((ItemAlbumWithAvatarBinding) getBinding()).cardLayout.setOnLongClickListener(new AlbumFeedCardViewHolder$bindToContent$1(this));
        ((ItemAlbumWithAvatarBinding) getBinding()).contentLayout.setOnLongClickListener(new AlbumFeedCardViewHolder$bindToContent$2(this));
        FeedWarningBinding feedWarningBinding = ((ItemAlbumWithAvatarBinding) getBinding()).alertView;
        Intrinsics.checkNotNullExpressionValue(feedWarningBinding, "binding.alertView");
        BindingExtensionKt.updateInfo(feedWarningBinding, album.getInnerInfo());
        FeedTopBinding feedTopBinding = ((ItemAlbumWithAvatarBinding) getBinding()).topView;
        Intrinsics.checkNotNullExpressionValue(feedTopBinding, "binding.topView");
        BindingExtensionKt.updateInfo(feedTopBinding, album.getTopInfo(), album.isTop());
        View view = ((ItemAlbumWithAvatarBinding) getBinding()).topDivider;
        Intrinsics.checkNotNullExpressionValue(view, "binding.topDivider");
        FeedTopBinding feedTopBinding2 = ((ItemAlbumWithAvatarBinding) getBinding()).topView;
        Intrinsics.checkNotNullExpressionValue(feedTopBinding2, "binding.topView");
        View root = feedTopBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.topView.root");
        if (root.getVisibility() != 0) {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        ItemAlbumWithAvatarBinding itemAlbumWithAvatarBinding11 = (ItemAlbumWithAvatarBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumWithAvatarBinding11, "binding");
        View root2 = itemAlbumWithAvatarBinding11.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        instance.traceFeedStayInList(root2, "应用集");
    }

    private final String findUrl(List<String> list) {
        for (T t : list) {
            if (!TextUtils.isEmpty(t) && StringsKt.startsWith$default((String) t, "http", false, 2, (Object) null)) {
                return t;
            }
        }
        return "http://image.coolapk.com/apk_logo/2018/0116/ic_launcher-4599-o_1c3v0ii87s26r0benla7q118eq-uid-97100@192x192.png";
    }

    public final boolean showFromView(Album album) {
        Intrinsics.checkNotNullParameter(album, "album");
        if (!TextUtils.isEmpty(album.getInfoHtml()) || !TextUtils.isEmpty(album.getInfo())) {
            return true;
        }
        return false;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Album album;
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        String str = null;
        switch (view.getId()) {
            case 2131362095:
            case 2131363877:
                Context context = getContext();
                ItemAlbumWithAvatarBinding itemAlbumWithAvatarBinding = (ItemAlbumWithAvatarBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemAlbumWithAvatarBinding, "binding");
                AlbumDetailViewModel model = itemAlbumWithAvatarBinding.getModel();
                if (!(model == null || (album = model.getAlbum()) == null)) {
                    str = album.getUid();
                }
                ActionManager.startUserSpaceActivity(context, str);
                return;
            case 2131362199:
            case 2131362312:
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
                return;
            case 2131362970:
                moreAction();
                return;
            default:
                return;
        }
    }

    public final void moreAction() {
        Album album = this.viewModel.getAlbum();
        if (album != null) {
            Activity activity = UiUtils.getActivity(getContext());
            Intrinsics.checkNotNull(activity);
            EntityExtendsKt.showItemDialog(album, activity);
        }
    }

    private final void loadCover(String str) {
        if (!this.isCoverLoaded || !TextUtils.equals(this.signUrl, str)) {
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                this.isCoverLoaded = true;
                this.signUrl = str;
                GlideRequest listener = GlideApp.with(getContext()).as(PaletteBitmap.class).load(str).transform((Transformation<Bitmap>) new BitmapSizeTransformation(24, 24)).priority(Priority.IMMEDIATE).listener((RequestListener) new RequestListenerAdapter(str, new AlbumFeedCardViewHolder$loadCover$onImageLoadListener$1(this)));
                ImageView imageView = ((ItemAlbumWithAvatarBinding) getBinding()).bgView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.bgView");
                listener.into((GlideRequest) new AlbumCardBackgroundTarget(imageView, ((ItemAlbumWithAvatarBinding) getBinding()).iconView5, false, 4, null));
            }
        }
    }
}
