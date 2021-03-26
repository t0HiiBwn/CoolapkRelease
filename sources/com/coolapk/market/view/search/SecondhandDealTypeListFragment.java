package com.coolapk.market.view.search;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemAppCategoryBinding;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u0000 \u001f2\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0003\u001f !B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J0\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J,\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u001a\u0010\u001c\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002H\u0014J\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u001e\u001a\u00020\u0015H\u0014R\u0012\u0010\u0006\u001a\u00060\u0007R\u00020\u0000X.¢\u0006\u0002\n\u0000R6\u0010\b\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\tj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003`\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/search/SecondhandDealTypeListFragment;", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "", "Lkotlin/Pair;", "", "()V", "adapter", "Lcom/coolapk/market/view/search/SecondhandDealTypeListFragment$DataAdapter;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "viewModel", "Lcom/coolapk/market/view/search/SuperSearchViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateRequest", "Lrx/Observable;", "isRefresh", "", "page", "", "onRequestFailure", "error", "", "onRequestResponse", "result", "setSuperSearchViewModel", "shouldShowList", "Companion", "DataAdapter", "DataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondhandDealTypeListFragment.kt */
public final class SecondhandDealTypeListFragment extends NewAsyncListFragment<List<? extends Pair<? extends String, ? extends String>>> {
    public static final Companion Companion = new Companion(null);
    private DataAdapter adapter;
    private final ArrayList<Pair<String, String>> dataList = new ArrayList<>();
    private SuperSearchViewModel viewModel;

    public static final /* synthetic */ SuperSearchViewModel access$getViewModel$p(SecondhandDealTypeListFragment secondhandDealTypeListFragment) {
        SuperSearchViewModel superSearchViewModel = secondhandDealTypeListFragment.viewModel;
        if (superSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return superSearchViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object] */
    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    public /* bridge */ /* synthetic */ boolean onRequestResponse(boolean z, List<? extends Pair<? extends String, ? extends String>> list) {
        return onRequestResponse(z, (List<Pair<String, String>>) list);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/search/SecondhandDealTypeListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/search/SecondhandDealTypeListFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondhandDealTypeListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SecondhandDealTypeListFragment newInstance() {
            return new SecondhandDealTypeListFragment();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.adapter = new DataAdapter();
        RecyclerView recyclerView3 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
        DataAdapter dataAdapter = this.adapter;
        if (dataAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView3.setAdapter(dataAdapter);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        if (getUserVisibleHint()) {
            initData();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001c  */
    protected boolean onRequestResponse(boolean z, List<Pair<String, String>> list) {
        DataAdapter dataAdapter;
        this.dataList.clear();
        boolean z2 = true;
        if (list != null) {
            List<Pair<String, String>> list2 = list;
            if (!list2.isEmpty()) {
                this.dataList.addAll(list2);
                dataAdapter = this.adapter;
                if (dataAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                dataAdapter.notifyDataSetChanged();
                updateContentUI();
                return z2;
            }
        }
        z2 = false;
        dataAdapter = this.adapter;
        if (dataAdapter == null) {
        }
        dataAdapter.notifyDataSetChanged();
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Pair<String, String>>> onCreateRequest(boolean z, int i) {
        SuperSearchViewModel superSearchViewModel = this.viewModel;
        if (superSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Observable<List<Pair<String, String>>> just = Observable.just(MapsKt.toList(superSearchViewModel.getDealTypeMap()));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(viewModel.dealTypeMap.toList())");
        return just;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return this.dataList.size() > 0;
    }

    public final void setSuperSearchViewModel(SuperSearchViewModel superSearchViewModel) {
        Intrinsics.checkNotNullParameter(superSearchViewModel, "viewModel");
        this.viewModel = superSearchViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/search/SecondhandDealTypeListFragment$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/view/search/SecondhandDealTypeListFragment$DataViewHolder;", "(Lcom/coolapk/market/view/search/SecondhandDealTypeListFragment;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondhandDealTypeListFragment.kt */
    private final class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558589, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new DataViewHolder(inflate, SecondhandDealTypeListFragment.access$getViewModel$p(SecondhandDealTypeListFragment.this), new SecondhandDealTypeListFragment$DataAdapter$onCreateViewHolder$1(this));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SecondhandDealTypeListFragment.this.dataList.size();
        }

        public void onBindViewHolder(DataViewHolder dataViewHolder, int i) {
            Intrinsics.checkNotNullParameter(dataViewHolder, "holder");
            dataViewHolder.bindTo(SecondhandDealTypeListFragment.this.dataList.get(i));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/search/SecondhandDealTypeListFragment$DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "viewModel", "Lcom/coolapk/market/view/search/SuperSearchViewModel;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Lcom/coolapk/market/view/search/SuperSearchViewModel;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "binding", "Lcom/coolapk/market/databinding/ItemAppCategoryBinding;", "kotlin.jvm.PlatformType", "getViewModel", "()Lcom/coolapk/market/view/search/SuperSearchViewModel;", "bindTo", "", "data", "", "createSelectedTextColor", "Landroid/content/res/ColorStateList;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondhandDealTypeListFragment.kt */
    private static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558589;
        private final ItemAppCategoryBinding binding;
        private final SuperSearchViewModel viewModel;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(View view, SuperSearchViewModel superSearchViewModel, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(superSearchViewModel, "viewModel");
            Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
            this.viewModel = superSearchViewModel;
            ItemAppCategoryBinding itemAppCategoryBinding = (ItemAppCategoryBinding) getBinding();
            this.binding = itemAppCategoryBinding;
            itemAppCategoryBinding.itemView.setOnClickListener(this);
        }

        public final SuperSearchViewModel getViewModel() {
            return this.viewModel;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/search/SecondhandDealTypeListFragment$DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: SecondhandDealTypeListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Pair<kotlin.String, kotlin.String>");
            Pair pair = (Pair) obj;
            TextView textView = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            textView.setText((CharSequence) pair.getSecond());
            this.binding.textView.setTextColor(createSelectedTextColor());
            boolean areEqual = Intrinsics.areEqual((String) pair.getFirst(), this.viewModel.getDealType());
            TextView textView2 = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
            textView2.setSelected(areEqual);
            this.binding.executePendingBindings();
        }

        private final ColorStateList createSelectedTextColor() {
            return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().getTextColorPrimary()});
        }
    }
}
