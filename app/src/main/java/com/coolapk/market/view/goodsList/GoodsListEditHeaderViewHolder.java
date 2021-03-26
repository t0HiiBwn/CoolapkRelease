package com.coolapk.market.view.goodsList;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemGoodsListEditHeaderBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequests;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.ImageUploadOption;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UtilExtendsKt;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.AspectRatioImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u000eR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodsListEditHeaderViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemGoodsListEditHeaderBinding;", "Lcom/coolapk/market/model/Feed;", "viewModel", "Lcom/coolapk/market/view/goodsList/GoodsListDetailViewModel;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Lcom/coolapk/market/view/goodsList/GoodsListDetailViewModel;Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "coverUrl", "", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "(Ljava/lang/String;)V", "isNeedUpload", "", "getViewModel", "()Lcom/coolapk/market/view/goodsList/GoodsListDetailViewModel;", "bindToContent", "", "data", "onClick", "view", "submitNewCover", "url", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsListEditHeaderViewHolder.kt */
public final class GoodsListEditHeaderViewHolder extends GenericBindHolder<ItemGoodsListEditHeaderBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558759;
    private String coverUrl;
    private boolean isNeedUpload;
    private final GoodsListDetailViewModel viewModel;

    public final GoodsListDetailViewModel getViewModel() {
        return this.viewModel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoodsListEditHeaderViewHolder(GoodsListDetailViewModel goodsListDetailViewModel, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(goodsListDetailViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.viewModel = goodsListDetailViewModel;
        this.coverUrl = goodsListDetailViewModel.getCoverUrl();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodsListEditHeaderViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsListEditHeaderViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void bindToContent(Feed feed) {
        this.viewModel.setGoodsList(feed);
        ItemGoodsListEditHeaderBinding itemGoodsListEditHeaderBinding = (ItemGoodsListEditHeaderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsListEditHeaderBinding, "binding");
        itemGoodsListEditHeaderBinding.setModel(this.viewModel);
        ItemGoodsListEditHeaderBinding itemGoodsListEditHeaderBinding2 = (ItemGoodsListEditHeaderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsListEditHeaderBinding2, "binding");
        itemGoodsListEditHeaderBinding2.setClick(this);
        ((ItemGoodsListEditHeaderBinding) getBinding()).executePendingBindings();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void submitNewCover(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            AspectRatioImageView aspectRatioImageView = ((ItemGoodsListEditHeaderBinding) getBinding()).ivCover;
            Intrinsics.checkNotNullExpressionValue(aspectRatioImageView, "binding.ivCover");
            aspectRatioImageView.setAspectRatio(0.45f);
        } else {
            int widthDp = DisplayUtils.getWidthDp(getContext());
            AspectRatioImageView aspectRatioImageView2 = ((ItemGoodsListEditHeaderBinding) getBinding()).ivCover;
            Intrinsics.checkNotNullExpressionValue(aspectRatioImageView2, "binding.ivCover");
            aspectRatioImageView2.setAspectRatio(80.0f / ((float) ((widthDp - 16) - 16)));
        }
        GlideRequests with = GlideApp.with(getContext());
        Uri parse = Uri.parse(StringUtils.notNull(str));
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(StringUtils.notNull(url))");
        with.load(UtilExtendsKt.toSafeFileUri(parse)).diskCacheStrategy(DiskCacheStrategy.NONE).into(((ItemGoodsListEditHeaderBinding) getBinding()).ivCover);
        int i = 0;
        boolean startsWith$default = StringsKt.startsWith$default(str, "http", false, 2, (Object) null);
        boolean isEmpty = TextUtils.isEmpty(str2);
        boolean z = true;
        boolean z2 = !startsWith$default && !TextUtils.isEmpty(str2);
        this.isNeedUpload = z2;
        if (isEmpty || z2) {
            z = false;
        }
        ImageView imageView = ((ItemGoodsListEditHeaderBinding) getBinding()).picCloseView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.picCloseView");
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
        if (this.isNeedUpload) {
            DataManager.getInstance().uploadImage(CollectionsKt.listOf(ImageUploadOption.create(str, "feed_cover", "FEED", null))).compose(RxUtils.applyIOSchedulers()).first().subscribe((Subscriber<? super R>) new GoodsListEditHeaderViewHolder$submitNewCover$1(this));
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == 2131362793) {
            DataBindingComponent component = getComponent();
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (!(fragment instanceof GoodGoodsEditListFragment)) {
                fragment = null;
            }
            ActionManager.startPhotoPickerActivity((GoodGoodsEditListFragment) fragment, 1, (List<String>) null, 433);
        } else if (valueOf != null && valueOf.intValue() == 2131362315) {
            Activity activityNullable = UiUtils.getActivityNullable(getContext());
            GoodsListEditDialog newInstance = GoodsListEditDialog.Companion.newInstance(this.viewModel.getGoodsListId(), this.viewModel.getGoodsShowTitle(), this.viewModel.getGoodsShowMessage());
            newInstance.setViewModel(this.viewModel);
            Intrinsics.checkNotNullExpressionValue(activityNullable, "activity");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activityNullable).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
        }
    }
}
