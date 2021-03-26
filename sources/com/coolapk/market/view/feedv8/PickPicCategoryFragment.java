package com.coolapk.market.view.feedv8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemPicCategoryBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.PicCategory;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.asynclist.ShortAsyncListFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/feedv8/PickPicCategoryFragment;", "Lcom/coolapk/market/view/base/asynclist/ShortAsyncListFragment;", "Lcom/coolapk/market/model/PicCategory;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "isRefresh", "", "page", "", "Companion", "PicCategoryViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PickPicCategoryFragment.kt */
public final class PickPicCategoryFragment extends ShortAsyncListFragment<PicCategory> {
    public static final Companion Companion = new Companion(null);
    public static final int REQUEST_CODE = 3423;

    @JvmStatic
    public static final String getResult(Intent intent) {
        return Companion.getResult(intent);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feedv8/PickPicCategoryFragment$Companion;", "", "()V", "REQUEST_CODE", "", "getResult", "", "intent", "Landroid/content/Intent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PickPicCategoryFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String getResult(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return intent.getStringExtra("RESULT");
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.ShortAsyncListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558853, 2131231052).create());
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558853).suitedEntityType("picCategory").constructor(new PickPicCategoryFragment$onActivityCreated$1(this)).build(), 0, 2, null);
        initData();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<PicCategory>> onCreateRequest(boolean z, int i) {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        List<PicCategory> picCategoryList = appSetting.getPicCategoryList();
        Intrinsics.checkNotNullExpressionValue(picCategoryList, "AppHolder.getAppSetting().picCategoryList");
        if (!picCategoryList.isEmpty()) {
            Observable<List<PicCategory>> just = Observable.just(picCategoryList);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(defaultList)");
            return just;
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        Observable<R> doOnNext = instance.getPicCategoryList().compose(RxUtils.apiCommonToData()).doOnNext(PickPicCategoryFragment$onCreateRequest$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(doOnNext, "DataManager.getInstance(…esetPicCategoryList(it) }");
        return doOnNext;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/feedv8/PickPicCategoryFragment$PicCategoryViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemPicCategoryBinding;", "Lcom/coolapk/market/model/PicCategory;", "itemView", "Landroid/view/View;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "(Landroid/view/View;Lcom/coolapk/market/binding/FragmentBindingComponent;)V", "bindToContent", "", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PickPicCategoryFragment.kt */
    public static final class PicCategoryViewHolder extends GenericBindHolder<ItemPicCategoryBinding, PicCategory> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558853;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PicCategoryViewHolder(View view, FragmentBindingComponent fragmentBindingComponent) {
            super(view, fragmentBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(fragmentBindingComponent, "component");
        }

        public void bindToContent(PicCategory picCategory) {
            Intrinsics.checkNotNullParameter(picCategory, "data");
            ItemPicCategoryBinding itemPicCategoryBinding = (ItemPicCategoryBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemPicCategoryBinding, "binding");
            itemPicCategoryBinding.setModel(picCategory);
            ((ItemPicCategoryBinding) getBinding()).executePendingBindings();
            ItemPicCategoryBinding itemPicCategoryBinding2 = (ItemPicCategoryBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemPicCategoryBinding2, "binding");
            View root = itemPicCategoryBinding2.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            ViewExtendsKt.setUtilClickListener(root, new PickPicCategoryFragment$PicCategoryViewHolder$bindToContent$1(this, picCategory));
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/PickPicCategoryFragment$PicCategoryViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: PickPicCategoryFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
