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
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u0000 '2\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0003'()B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J0\u0010\u001b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fH\u0016J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J,\u0010#\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e2\u001a\u0010$\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002H\u0014J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010&\u001a\u00020\u001eH\u0014R\u0012\u0010\u0006\u001a\u00060\u0007R\u00020\u0000X.¢\u0006\u0002\n\u0000R6\u0010\b\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\tj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003`\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R9\u0010\u0011\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\tj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/coolapk/market/view/search/SecondhandFilterListFragment;", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "", "Lkotlin/Pair;", "", "()V", "adapter", "Lcom/coolapk/market/view/search/SecondhandFilterListFragment$DataAdapter;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "outDataList", "getOutDataList", "()Ljava/util/ArrayList;", "viewModel", "Lcom/coolapk/market/view/search/SuperSearchViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateRequest", "Lrx/Observable;", "isRefresh", "", "page", "onRequestFailure", "error", "", "onRequestResponse", "result", "setSuperSearchViewModel", "shouldShowList", "Companion", "DataAdapter", "DataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondhandFilterListFragment.kt */
public final class SecondhandFilterListFragment extends NewAsyncListFragment<List<? extends Pair<? extends String, ? extends String>>> {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_INDEX = "KEY_INDEX";
    private DataAdapter adapter;
    private final ArrayList<Pair<String, String>> dataList = new ArrayList<>();
    private int index = -1;
    private final ArrayList<Pair<String, String>> outDataList = new ArrayList<>();
    private SuperSearchViewModel viewModel;

    public static final /* synthetic */ SuperSearchViewModel access$getViewModel$p(SecondhandFilterListFragment secondhandFilterListFragment) {
        SuperSearchViewModel superSearchViewModel = secondhandFilterListFragment.viewModel;
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/search/SecondhandFilterListFragment$Companion;", "", "()V", "KEY_INDEX", "", "newInstance", "Lcom/coolapk/market/view/search/SecondhandFilterListFragment;", "index", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondhandFilterListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SecondhandFilterListFragment newInstance(int i) {
            SecondhandFilterListFragment secondhandFilterListFragment = new SecondhandFilterListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_INDEX", i);
            Unit unit = Unit.INSTANCE;
            secondhandFilterListFragment.setArguments(bundle);
            return secondhandFilterListFragment;
        }
    }

    public final ArrayList<Pair<String, String>> getOutDataList() {
        return this.outDataList;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.index = requireArguments().getInt("KEY_INDEX");
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
        this.outDataList.clear();
        if (this.index != 0) {
            ArrayList<Pair<String, String>> arrayList = this.outDataList;
            SuperSearchViewModel superSearchViewModel = this.viewModel;
            if (superSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            arrayList.addAll(MapsKt.toList(superSearchViewModel.getOtherMapRemoveLink()));
        } else {
            ArrayList<Pair<String, String>> arrayList2 = this.outDataList;
            SuperSearchViewModel superSearchViewModel2 = this.viewModel;
            if (superSearchViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            arrayList2.addAll(MapsKt.toList(superSearchViewModel2.getOtherMap()));
        }
        SuperSearchViewModel superSearchViewModel3 = this.viewModel;
        if (superSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        superSearchViewModel3.setActionType(String.valueOf(this.index));
        Observable<List<Pair<String, String>>> just = Observable.just(this.outDataList);
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(outDataList)");
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/search/SecondhandFilterListFragment$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/view/search/SecondhandFilterListFragment$DataViewHolder;", "(Lcom/coolapk/market/view/search/SecondhandFilterListFragment;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondhandFilterListFragment.kt */
    private final class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558589, viewGroup, false);
            int index = SecondhandFilterListFragment.this.getIndex();
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new DataViewHolder(index, inflate, SecondhandFilterListFragment.access$getViewModel$p(SecondhandFilterListFragment.this), new SecondhandFilterListFragment$DataAdapter$onCreateViewHolder$1(this));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SecondhandFilterListFragment.this.dataList.size();
        }

        public void onBindViewHolder(DataViewHolder dataViewHolder, int i) {
            Intrinsics.checkNotNullParameter(dataViewHolder, "holder");
            dataViewHolder.bindTo(SecondhandFilterListFragment.this.dataList.get(i));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/search/SecondhandFilterListFragment$DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "dealType", "", "itemView", "Landroid/view/View;", "viewModel", "Lcom/coolapk/market/view/search/SuperSearchViewModel;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(ILandroid/view/View;Lcom/coolapk/market/view/search/SuperSearchViewModel;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "binding", "Lcom/coolapk/market/databinding/ItemAppCategoryBinding;", "kotlin.jvm.PlatformType", "getDealType", "()I", "getViewModel", "()Lcom/coolapk/market/view/search/SuperSearchViewModel;", "bindTo", "", "data", "", "createSelectedTextColor", "Landroid/content/res/ColorStateList;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondhandFilterListFragment.kt */
    private static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558589;
        private final ItemAppCategoryBinding binding;
        private final int dealType;
        private final SuperSearchViewModel viewModel;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(int i, View view, SuperSearchViewModel superSearchViewModel, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(superSearchViewModel, "viewModel");
            Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
            this.dealType = i;
            this.viewModel = superSearchViewModel;
            ItemAppCategoryBinding itemAppCategoryBinding = (ItemAppCategoryBinding) getBinding();
            this.binding = itemAppCategoryBinding;
            itemAppCategoryBinding.itemView.setOnClickListener(this);
        }

        public final int getDealType() {
            return this.dealType;
        }

        public final SuperSearchViewModel getViewModel() {
            return this.viewModel;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/search/SecondhandFilterListFragment$DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: SecondhandFilterListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            boolean z;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Pair<kotlin.String, kotlin.String>");
            Pair pair = (Pair) obj;
            TextView textView = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            textView.setText((CharSequence) pair.getSecond());
            this.binding.textView.setTextColor(createSelectedTextColor());
            if (Intrinsics.areEqual(this.viewModel.getActionType(), "2")) {
                z = Intrinsics.areEqual((String) pair.getFirst(), this.viewModel.getSecondHandOther());
            } else {
                z = Intrinsics.areEqual(this.viewModel.getActionType(), "4") ? Intrinsics.areEqual((String) pair.getFirst(), this.viewModel.getSecondHandFilterInBuy()) : false;
            }
            TextView textView2 = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
            textView2.setSelected(z);
            this.binding.executePendingBindings();
        }

        private final ColorStateList createSelectedTextColor() {
            return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().getTextColorPrimary()});
        }
    }
}
