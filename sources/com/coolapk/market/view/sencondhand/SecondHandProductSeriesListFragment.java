package com.coolapk.market.view.sencondhand;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemProductSeriesErshouBinding;
import com.coolapk.market.databinding.ItemProductSeriesListTitleBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.MainSecondHandType;
import com.coolapk.market.model.Product;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.product.SupportVerticalModeFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u00182\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0004H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandProductSeriesListFragment;", "Lcom/coolapk/market/view/product/SupportVerticalModeFragment;", "()V", "dataType", "", "getDataType", "()I", "dataType$delegate", "Lkotlin/Lazy;", "dealType", "getDealType", "dealType$delegate", "convertToBrandProductData", "", "Landroid/os/Parcelable;", "data", "Lcom/coolapk/market/model/Entity;", "verticalModel", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "isRefresh", "page", "Companion", "LocalData", "ProductSeriesHorizonHolder", "ProductSeriesTitleHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondHandProductSeriesListFragment.kt */
public final class SecondHandProductSeriesListFragment extends SupportVerticalModeFragment {
    public static final Companion Companion = new Companion(null);
    private static final String ENTITY_TYPE_GROUP_TITLE = "productGroupTitle";
    public static final String EXTRA_BRAND_ID = "extra_brand_id";
    public static final String EXTRA_BRAND_TYPE = "extra_brand_type";
    public static final String EXTRA_DEAL_TYPE = "extra_deal_type";
    public static final String EXTRA_KEY_DATA_TYPE = "extra_key_data_type";
    public static final String LOCAL_TYPE_HORIZON_PRODUCTS = "horizon_products";
    public static final String LOCAL_TYPE_SERIES_MORE = "series_more";
    public static final String LOCAL_TYPE_SERIES_TITLE = "series_title";
    private final Lazy dataType$delegate = LazyKt.lazy(new SecondHandProductSeriesListFragment$dataType$2(this));
    private final Lazy dealType$delegate = LazyKt.lazy(new SecondHandProductSeriesListFragment$dealType$2(this));

    /* access modifiers changed from: private */
    public final int getDataType() {
        return ((Number) this.dataType$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public final int getDealType() {
        return ((Number) this.dealType$delegate.getValue()).intValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandProductSeriesListFragment$Companion;", "", "()V", "ENTITY_TYPE_GROUP_TITLE", "", "EXTRA_BRAND_ID", "EXTRA_BRAND_TYPE", "EXTRA_DEAL_TYPE", "EXTRA_KEY_DATA_TYPE", "LOCAL_TYPE_HORIZON_PRODUCTS", "LOCAL_TYPE_SERIES_MORE", "LOCAL_TYPE_SERIES_TITLE", "newInstance", "Lcom/coolapk/market/view/sencondhand/SecondHandProductSeriesListFragment;", "brandID", "brandType", "type", "", "dealType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondHandProductSeriesListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SecondHandProductSeriesListFragment newInstance(String str, String str2, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "brandID");
            Intrinsics.checkNotNullParameter(str2, "brandType");
            SecondHandProductSeriesListFragment secondHandProductSeriesListFragment = new SecondHandProductSeriesListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("extra_brand_id", str);
            bundle.putString("extra_brand_type", str2);
            bundle.putInt("extra_deal_type", i2);
            bundle.putInt("extra_key_data_type", i);
            Unit unit = Unit.INSTANCE;
            secondHandProductSeriesListFragment.setArguments(bundle);
            return secondHandProductSeriesListFragment;
        }
    }

    @Override // com.coolapk.market.view.product.SupportVerticalModeFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new SecondHandProductSeriesListFragment$onActivityCreated$1());
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558884).suitedMethod(SecondHandProductSeriesListFragment$onActivityCreated$2.INSTANCE).constructor(new SecondHandProductSeriesListFragment$onActivityCreated$3(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558881).suitedMethod(SecondHandProductSeriesListFragment$onActivityCreated$4.INSTANCE).constructor(new SecondHandProductSeriesListFragment$onActivityCreated$5(this)).build(), 0, 2, null);
        initData();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String string = requireArguments().getString("extra_brand_type");
        String string2 = requireArguments().getString("extra_brand_id");
        DataManager instance = DataManager.getInstance();
        Entity entity = (Entity) CollectionsKt.firstOrNull((List<? extends Object>) getLoadedDataList());
        String entityId = entity != null ? entity.getEntityId() : null;
        Entity entity2 = (Entity) CollectionsKt.lastOrNull((List<? extends Object>) getLoadedDataList());
        Observable<R> compose = instance.getSecondHandProductSeries(string2, string, i, entityId, entity2 != null ? entity2.getEntityId() : null).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    @Override // com.coolapk.market.view.product.SupportVerticalModeFragment
    public List<Parcelable> convertToBrandProductData(List<? extends Entity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "data");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : list) {
            if (t instanceof Product) {
                arrayList2.add(t);
                if (arrayList2.size() == 2) {
                    Object[] array = arrayList2.toArray(new Product[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    arrayList.add(new LocalData("horizon_products", null, null, (Product[]) array, null, 22, null));
                    arrayList2.clear();
                }
            } else if (t instanceof MainSecondHandType) {
                T t2 = t;
                arrayList2.add(Product.newBuilder().setTitle(t2.getTitle()).setLogo(t2.getLogo()).setEntityTemplate("ershouProduct").setEntityTypeName(t2.getEntityType()).setReleaseStatus(1).setSecondHandSthType(t2.getId()).setConfigRows(new ArrayList()).setTagArr(new ArrayList()).setTabApiList(new ArrayList()).setCoverPicList(new ArrayList()).setSecondHandFeedNum(t2.getSecondHandFeedNum()).build());
                if (arrayList2.size() == 2) {
                    Object[] array2 = arrayList2.toArray(new Product[0]);
                    Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                    arrayList.add(new LocalData("horizon_products", null, null, (Product[]) array2, null, 22, null));
                    arrayList2.clear();
                }
            } else {
                ArrayList arrayList3 = arrayList2;
                if (true ^ arrayList3.isEmpty()) {
                    Object[] array3 = arrayList3.toArray(new Product[0]);
                    Objects.requireNonNull(array3, "null cannot be cast to non-null type kotlin.Array<T>");
                    arrayList.add(new LocalData("horizon_products", null, null, (Product[]) array3, null, 22, null));
                    arrayList2.clear();
                }
                if (Intrinsics.areEqual(t.getEntityTemplate(), "productGroupTitle")) {
                    String title = t.getTitle();
                    if (title == null) {
                        title = "";
                    }
                    arrayList.add(new LocalData("series_title", title, null, null, null, 28, null));
                } else {
                    arrayList.add(t);
                }
            }
        }
        ArrayList arrayList4 = arrayList2;
        if (!arrayList4.isEmpty()) {
            Object[] array4 = arrayList4.toArray(new Product[0]);
            Objects.requireNonNull(array4, "null cannot be cast to non-null type kotlin.Array<T>");
            arrayList.add(new LocalData("horizon_products", null, null, (Product[]) array4, null, 22, null));
            arrayList2.clear();
        }
        return arrayList;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandProductSeriesListFragment$ProductSeriesTitleHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondHandProductSeriesListFragment.kt */
    private static final class ProductSeriesTitleHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558884;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProductSeriesTitleHolder(View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandProductSeriesListFragment$ProductSeriesTitleHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: SecondHandProductSeriesListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            if (obj instanceof LocalData) {
                ItemProductSeriesListTitleBinding itemProductSeriesListTitleBinding = (ItemProductSeriesListTitleBinding) getBinding();
                TextView textView = itemProductSeriesListTitleBinding.titleView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
                textView.setText(((LocalData) obj).getTitle());
                itemProductSeriesListTitleBinding.executePendingBindings();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandProductSeriesListFragment$ProductSeriesHorizonHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "dataType", "", "dealType", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;II)V", "binding", "Lcom/coolapk/market/databinding/ItemProductSeriesErshouBinding;", "kotlin.jvm.PlatformType", "data", "Lcom/coolapk/market/view/sencondhand/SecondHandProductSeriesListFragment$LocalData;", "getDataType", "()I", "getDealType", "bindTo", "", "", "onClick", "view", "takeAction", "product", "Lcom/coolapk/market/model/Product;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondHandProductSeriesListFragment.kt */
    private static final class ProductSeriesHorizonHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558881;
        private final ItemProductSeriesErshouBinding binding;
        private LocalData data;
        private final int dataType;
        private final int dealType;

        public final int getDataType() {
            return this.dataType;
        }

        public final int getDealType() {
            return this.dealType;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProductSeriesHorizonHolder(View view, DataBindingComponent dataBindingComponent, int i, int i2) {
            super(view, dataBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            this.dataType = i;
            this.dealType = i2;
            ItemProductSeriesErshouBinding itemProductSeriesErshouBinding = (ItemProductSeriesErshouBinding) getBinding();
            this.binding = itemProductSeriesErshouBinding;
            Intrinsics.checkNotNullExpressionValue(itemProductSeriesErshouBinding, "binding");
            itemProductSeriesErshouBinding.setClick(this);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandProductSeriesListFragment$ProductSeriesHorizonHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: SecondHandProductSeriesListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            if (obj instanceof LocalData) {
                LocalData localData = (LocalData) obj;
                this.data = localData;
                ItemProductSeriesErshouBinding itemProductSeriesErshouBinding = this.binding;
                Product[] products = localData.getProducts();
                Product product = null;
                itemProductSeriesErshouBinding.setModel1(products != null ? (Product) ArraysKt.getOrNull(products, 0) : null);
                Product[] products2 = localData.getProducts();
                if (products2 != null) {
                    product = (Product) ArraysKt.getOrNull(products2, 1);
                }
                itemProductSeriesErshouBinding.setModel2(product);
                this.binding.executePendingBindings();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            int id = view.getId();
            if (id == 2131362780) {
                ItemProductSeriesErshouBinding itemProductSeriesErshouBinding = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemProductSeriesErshouBinding, "binding");
                Product model1 = itemProductSeriesErshouBinding.getModel1();
                if (model1 != null) {
                    Intrinsics.checkNotNullExpressionValue(model1, "it");
                    takeAction(model1);
                }
            } else if (id == 2131362784) {
                ItemProductSeriesErshouBinding itemProductSeriesErshouBinding2 = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemProductSeriesErshouBinding2, "binding");
                Product model2 = itemProductSeriesErshouBinding2.getModel2();
                if (model2 != null) {
                    Intrinsics.checkNotNullExpressionValue(model2, "it");
                    takeAction(model2);
                }
            }
        }

        private final void takeAction(Product product) {
            String str;
            String str2;
            if (this.dataType == 3) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String brandId = product.getBrandId();
                String str3 = brandId != null ? brandId : "";
                Intrinsics.checkNotNullExpressionValue(str3, "product.brandId ?: \"\"");
                String id = product.getId();
                if (id != null) {
                    str = id;
                } else {
                    str = "";
                }
                Intrinsics.checkNotNullExpressionValue(str, "product.id ?: \"\"");
                String secondHandSthType = product.getSecondHandSthType();
                if (secondHandSthType != null) {
                    str2 = secondHandSthType;
                } else {
                    str2 = "";
                }
                Intrinsics.checkNotNullExpressionValue(str2, "product.secondHandSthType ?: \"\"");
                ActionManagerCompat.startDataListActivity$default(context, UriUtils.getSecondhandFilterUrl$default(str3, str, str2, null, 8, null), String.valueOf(product.getTitle()), null, 0, 24, null);
                return;
            }
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Activity activityNullable = UiUtils.getActivityNullable(context2);
            if (activityNullable instanceof SecondHandProductBrandListActivity) {
                ((SecondHandProductBrandListActivity) activityNullable).setProduct(product);
            }
            String id2 = product.getId();
            String secondHandSthType2 = product.getSecondHandSthType();
            if (secondHandSthType2 == null) {
                secondHandSthType2 = "100";
            }
            ActionManager.startSelectParamsAction(activityNullable, id2, secondHandSthType2, String.valueOf(this.dealType));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JL\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001eHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001eHÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006*"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandProductSeriesListFragment$LocalData;", "Landroid/os/Parcelable;", "type", "", "title", "product", "Lcom/coolapk/market/model/Product;", "products", "", "moreCard", "Lcom/coolapk/market/model/Entity;", "(Ljava/lang/String;Ljava/lang/String;Lcom/coolapk/market/model/Product;[Lcom/coolapk/market/model/Product;Lcom/coolapk/market/model/Entity;)V", "getMoreCard", "()Lcom/coolapk/market/model/Entity;", "getProduct", "()Lcom/coolapk/market/model/Product;", "getProducts", "()[Lcom/coolapk/market/model/Product;", "[Lcom/coolapk/market/model/Product;", "getTitle", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coolapk/market/model/Product;[Lcom/coolapk/market/model/Product;Lcom/coolapk/market/model/Entity;)Lcom/coolapk/market/view/sencondhand/SecondHandProductSeriesListFragment$LocalData;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondHandProductSeriesListFragment.kt */
    public static final class LocalData implements Parcelable {
        public static final Parcelable.Creator<LocalData> CREATOR = new Creator();
        private final Entity moreCard;
        private final Product product;
        private final Product[] products;
        private final String title;
        private final String type;

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<LocalData> {
            @Override // android.os.Parcelable.Creator
            public final LocalData createFromParcel(Parcel parcel) {
                Product[] productArr;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Product product = (Product) parcel.readParcelable(LocalData.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    productArr = new Product[readInt];
                    for (int i = 0; readInt > i; i++) {
                        productArr[i] = (Product) parcel.readParcelable(LocalData.class.getClassLoader());
                    }
                } else {
                    productArr = null;
                }
                return new LocalData(readString, readString2, product, productArr, (Entity) parcel.readParcelable(LocalData.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            public final LocalData[] newArray(int i) {
                return new LocalData[i];
            }
        }

        public static /* synthetic */ LocalData copy$default(LocalData localData, String str, String str2, Product product2, Product[] productArr, Entity entity, int i, Object obj) {
            if ((i & 1) != 0) {
                str = localData.type;
            }
            if ((i & 2) != 0) {
                str2 = localData.title;
            }
            if ((i & 4) != 0) {
                product2 = localData.product;
            }
            if ((i & 8) != 0) {
                productArr = localData.products;
            }
            if ((i & 16) != 0) {
                entity = localData.moreCard;
            }
            return localData.copy(str, str2, product2, productArr, entity);
        }

        public final String component1() {
            return this.type;
        }

        public final String component2() {
            return this.title;
        }

        public final Product component3() {
            return this.product;
        }

        public final Product[] component4() {
            return this.products;
        }

        public final Entity component5() {
            return this.moreCard;
        }

        public final LocalData copy(String str, String str2, Product product2, Product[] productArr, Entity entity) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(str2, "title");
            return new LocalData(str, str2, product2, productArr, entity);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalData)) {
                return false;
            }
            LocalData localData = (LocalData) obj;
            return Intrinsics.areEqual(this.type, localData.type) && Intrinsics.areEqual(this.title, localData.title) && Intrinsics.areEqual(this.product, localData.product) && Intrinsics.areEqual(this.products, localData.products) && Intrinsics.areEqual(this.moreCard, localData.moreCard);
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.type;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.title;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Product product2 = this.product;
            int hashCode3 = (hashCode2 + (product2 != null ? product2.hashCode() : 0)) * 31;
            Product[] productArr = this.products;
            int hashCode4 = (hashCode3 + (productArr != null ? Arrays.hashCode(productArr) : 0)) * 31;
            Entity entity = this.moreCard;
            if (entity != null) {
                i = entity.hashCode();
            }
            return hashCode4 + i;
        }

        @Override // java.lang.Object
        public String toString() {
            return "LocalData(type=" + this.type + ", title=" + this.title + ", product=" + this.product + ", products=" + Arrays.toString(this.products) + ", moreCard=" + this.moreCard + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.type);
            parcel.writeString(this.title);
            parcel.writeParcelable(this.product, i);
            Product[] productArr = this.products;
            if (productArr != null) {
                parcel.writeInt(1);
                int length = productArr.length;
                parcel.writeInt(length);
                for (int i2 = 0; length > i2; i2++) {
                    parcel.writeParcelable(productArr[i2], i);
                }
            } else {
                parcel.writeInt(0);
            }
            parcel.writeParcelable(this.moreCard, i);
        }

        public LocalData(String str, String str2, Product product2, Product[] productArr, Entity entity) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.type = str;
            this.title = str2;
            this.product = product2;
            this.products = productArr;
            this.moreCard = entity;
        }

        public final String getType() {
            return this.type;
        }

        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LocalData(String str, String str2, Product product2, Product[] productArr, Entity entity, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : product2, (i & 8) != 0 ? null : productArr, (i & 16) != 0 ? null : entity);
        }

        public final Product getProduct() {
            return this.product;
        }

        public final Product[] getProducts() {
            return this.products;
        }

        public final Entity getMoreCard() {
            return this.moreCard;
        }
    }
}
