package com.coolapk.market.view.product;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemProductMediaBinding;
import com.coolapk.market.event.ProductEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ProductMedia;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.view.base.asynclist.ShortAsyncListFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.video.VideoModel;
import com.coolapk.market.widget.video.VideoModelKt;
import com.coolapk.market.widget.view.ControlGifImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;

/* compiled from: ProductMediaFragment.kt */
public final class ProductMediaFragment extends ShortAsyncListFragment<ProductMedia> {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_PRODUCT_ID = "extra_id";
    public static final String EXTRA_RECOMMEND_FLAG = "extra_recommend_flag";
    public static final String EXTRA_TYPE = "extra_type";

    /* compiled from: ProductMediaFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductMediaFragment newInstance(String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "type");
            ProductMediaFragment productMediaFragment = new ProductMediaFragment();
            Bundle bundle = new Bundle();
            bundle.putString("extra_type", str2);
            bundle.putString("extra_id", str);
            bundle.putBoolean("extra_recommend_flag", z);
            Unit unit = Unit.INSTANCE;
            productMediaFragment.setArguments(bundle);
            return productMediaFragment;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.ShortAsyncListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        RecyclerView recyclerView = getRecyclerView();
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setClipToPadding(false);
        recyclerView.setClipChildren(false);
        recyclerView.setPadding(NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 4));
        recyclerView.setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        ViewExtendsKt.removeAllItemDecorations(recyclerView);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558868).suitedEntityType("productMedia").constructor(new ProductMediaFragment$onActivityCreated$2(this)).build(), 0, 2, null);
        setRefreshEnable(true);
        setLoadMoreEnable(true);
        initData();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    public final void onMediaClick(ProductMedia productMedia, int i, View view) {
        Intrinsics.checkNotNullParameter(productMedia, "data");
        Intrinsics.checkNotNullParameter(view, "view");
        if (Intrinsics.areEqual(productMedia.getType(), "image")) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : getDataList()) {
                ProductMedia productMedia2 = (ProductMedia) obj;
                Intrinsics.checkNotNullExpressionValue(productMedia2, "it");
                if (Intrinsics.areEqual(productMedia2.getType(), "image")) {
                    arrayList.add(obj);
                }
            }
            ArrayList<ProductMedia> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (ProductMedia productMedia3 : arrayList2) {
                Intrinsics.checkNotNullExpressionValue(productMedia3, "it");
                arrayList3.add(productMedia3.getId());
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList();
            for (Object obj2 : getDataList()) {
                ProductMedia productMedia4 = (ProductMedia) obj2;
                Intrinsics.checkNotNullExpressionValue(productMedia4, "it");
                if (Intrinsics.areEqual(productMedia4.getType(), "image")) {
                    arrayList5.add(obj2);
                }
            }
            ArrayList<ProductMedia> arrayList6 = arrayList5;
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
            for (ProductMedia productMedia5 : arrayList6) {
                Intrinsics.checkNotNullExpressionValue(productMedia5, "it");
                String url = productMedia5.getUrl();
                if (url == null) {
                    url = "";
                }
                arrayList7.add(url);
            }
            ArrayList arrayList8 = arrayList7;
            Rect[] rectArr = new Rect[arrayList8.size()];
            String[] strArr = new String[arrayList8.size()];
            RecyclerView recyclerView = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            int childCount = recyclerView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RecyclerView.ViewHolder childViewHolder = getRecyclerView().getChildViewHolder(getRecyclerView().getChildAt(i2));
                if (!(childViewHolder instanceof ProductMediaViewHolder)) {
                    childViewHolder = null;
                }
                ProductMediaViewHolder productMediaViewHolder = (ProductMediaViewHolder) childViewHolder;
                if (productMediaViewHolder != null && productMediaViewHolder.getAdapterPosition() >= 0) {
                    ProductMedia productMedia6 = (ProductMedia) getDataList().get(productMediaViewHolder.getAdapterPosition());
                    Intrinsics.checkNotNullExpressionValue(productMedia6, "viewHolderData");
                    int indexOf = arrayList4.indexOf(productMedia6.getId());
                    if (indexOf >= 0) {
                        ControlGifImageView controlGifImageView = ((ItemProductMediaBinding) productMediaViewHolder.getBinding()).imageView;
                        Intrinsics.checkNotNullExpressionValue(controlGifImageView, "viewHolder.binding.imageView");
                        rectArr[indexOf] = ViewExtendsKt.getGlobalRect(controlGifImageView);
                        strArr[indexOf] = productMedia6.getUrl();
                    }
                }
            }
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentActivity fragmentActivity = requireActivity;
            Object[] array = arrayList8.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr2 = (String[]) array;
            ArrayList<String> arrayList9 = arrayList8;
            ImageArgs.Companion companion = ImageArgs.Companion;
            ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList9, 10));
            for (String str : arrayList9) {
                arrayList10.add(companion.smallSizeProvider(str));
            }
            Object[] array2 = arrayList10.toArray(new String[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            int indexOf2 = arrayList4.indexOf(productMedia.getId());
            Object[] array3 = arrayList4.toArray(new String[0]);
            Objects.requireNonNull(array3, "null cannot be cast to non-null type kotlin.Array<T>");
            ActionManagerCompat.startPhotoViewActivity(fragmentActivity, strArr2, (String[]) array2, indexOf2, "", strArr, rectArr, false, (String[]) array3);
        } else if (Intrinsics.areEqual(productMedia.getType(), "video")) {
            VideoModel videoModel = VideoModelKt.toVideoModel(productMedia);
            if (videoModel.isValid()) {
                ActionManager.startVideoDetailListActivity(getActivity(), videoModel, view, "");
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    public final void onProductEvent(ProductEvent productEvent) {
        Intrinsics.checkNotNullParameter(productEvent, "event");
        String type = productEvent.getType();
        int hashCode = type.hashCode();
        if (hashCode != -516728727) {
            if (hashCode != 337546950 || !type.equals("add_media")) {
                return;
            }
        } else if (!type.equals("remove_media")) {
            return;
        }
        ArrayList<ProductMedia> arrayList = new ArrayList();
        for (Object obj : getDataList()) {
            ProductMedia productMedia = (ProductMedia) obj;
            Intrinsics.checkNotNullExpressionValue(productMedia, "it");
            if (Intrinsics.areEqual(productMedia.getId(), productEvent.getId())) {
                arrayList.add(obj);
            }
        }
        for (ProductMedia productMedia2 : arrayList) {
            getDataList().remove(productMedia2);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<ProductMedia>> onCreateRequest(boolean z, int i) {
        String string = requireArguments().getString("extra_id");
        String string2 = requireArguments().getString("extra_type");
        boolean z2 = requireArguments().getBoolean("extra_recommend_flag");
        DataManager instance = DataManager.getInstance();
        ProductMedia productMedia = (ProductMedia) CollectionsKt.firstOrNull((List<? extends Object>) getDataList());
        String entityId = productMedia != null ? productMedia.getEntityId() : null;
        ProductMedia productMedia2 = (ProductMedia) CollectionsKt.lastOrNull((List<? extends Object>) getDataList());
        Observable<R> compose = instance.getMediaList(string, string2, z2, i, entityId, productMedia2 != null ? productMedia2.getEntityId() : null).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    /* compiled from: ProductMediaFragment.kt */
    public static final class ProductMediaViewHolder extends GenericBindHolder<ItemProductMediaBinding, ProductMedia> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558868;
        private ProductMedia data;

        public static final /* synthetic */ ProductMedia access$getData$p(ProductMediaViewHolder productMediaViewHolder) {
            ProductMedia productMedia = productMediaViewHolder.data;
            if (productMedia == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
            }
            return productMedia;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProductMediaViewHolder(View view, FragmentBindingComponent fragmentBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, fragmentBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(fragmentBindingComponent, "component");
            Intrinsics.checkNotNullParameter(itemActionHandler, "onItemClick");
            ((ItemProductMediaBinding) getBinding()).itemView.setAspectRatio(1.0f);
            ((ItemProductMediaBinding) getBinding()).imageView.setOnClickListener(this);
            ((ItemProductMediaBinding) getBinding()).imageView.setOnLongClickListener(new View.OnLongClickListener(this) {
                /* class com.coolapk.market.view.product.ProductMediaFragment.ProductMediaViewHolder.AnonymousClass1 */
                final /* synthetic */ ProductMediaViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    LoginSession loginSession = instance.getLoginSession();
                    Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                    if (!loginSession.isAdmin()) {
                        return true;
                    }
                    this.this$0.showProductMediaDialog();
                    return true;
                }
            });
        }

        public void bindToContent(ProductMedia productMedia) {
            Intrinsics.checkNotNullParameter(productMedia, "data");
            this.data = productMedia;
            if (Intrinsics.areEqual(productMedia.getType(), "image")) {
                ItemProductMediaBinding itemProductMediaBinding = (ItemProductMediaBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemProductMediaBinding, "binding");
                ImageArgs.Companion companion = ImageArgs.Companion;
                String url = productMedia.getUrl();
                if (url == null) {
                    url = "";
                }
                itemProductMediaBinding.setImgUrl(companion.middleSizeProvider(url));
                FrameLayout frameLayout = ((ItemProductMediaBinding) getBinding()).videoMaskView;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.videoMaskView");
                frameLayout.setVisibility(8);
            } else {
                VideoModel videoModel = VideoModelKt.toVideoModel(productMedia);
                ItemProductMediaBinding itemProductMediaBinding2 = (ItemProductMediaBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemProductMediaBinding2, "binding");
                itemProductMediaBinding2.setImgUrl(videoModel.getCoverUrl());
                FrameLayout frameLayout2 = ((ItemProductMediaBinding) getBinding()).videoMaskView;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.videoMaskView");
                frameLayout2.setVisibility(0);
            }
            ((ItemProductMediaBinding) getBinding()).executePendingBindings();
        }

        public final void showProductMediaDialog() {
            MultiItemDialogFragment initBuilder = MultiItemDialogFragment.Companion.newInstance().setInitBuilder(new ProductMediaFragment$ProductMediaViewHolder$showProductMediaDialog$1(this));
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
            initBuilder.show(supportFragmentManager, (String) null);
        }

        /* compiled from: ProductMediaFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
