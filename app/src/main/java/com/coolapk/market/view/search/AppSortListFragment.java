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
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

/* compiled from: AppSortListFragment.kt */
public final class AppSortListFragment extends NewAsyncListFragment<List<? extends Pair<? extends String, ? extends String>>> {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_APK_TYPE = "APK_TYPE";
    private DataAdapter adapter;
    private String apkType;
    private final ArrayList<Pair<String, String>> dataList = new ArrayList<>();
    private SuperSearchViewModel viewModel;

    public static final /* synthetic */ String access$getApkType$p(AppSortListFragment appSortListFragment) {
        String str = appSortListFragment.apkType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apkType");
        }
        return str;
    }

    public static final /* synthetic */ SuperSearchViewModel access$getViewModel$p(AppSortListFragment appSortListFragment) {
        SuperSearchViewModel superSearchViewModel = appSortListFragment.viewModel;
        if (superSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return superSearchViewModel;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    public /* bridge */ /* synthetic */ boolean onRequestResponse(boolean z, List<? extends Pair<? extends String, ? extends String>> list) {
        return onRequestResponse(z, (List<Pair<String, String>>) list);
    }

    /* compiled from: AppSortListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppSortListFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "apkType");
            AppSortListFragment appSortListFragment = new AppSortListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("APK_TYPE", str);
            Unit unit = Unit.INSTANCE;
            appSortListFragment.setArguments(bundle);
            return appSortListFragment;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("APK_TYPE");
        Intrinsics.checkNotNull(string);
        this.apkType = string;
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
        Observable<List<Pair<String, String>>> just = Observable.just(MapsKt.toList(superSearchViewModel.getAppSortMap()));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(viewModel.appSortMap.toList())");
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

    /* compiled from: AppSortListFragment.kt */
    private final class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
        public DataAdapter() {
            AppSortListFragment.this = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558589, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new DataViewHolder(inflate, AppSortListFragment.access$getApkType$p(AppSortListFragment.this), AppSortListFragment.access$getViewModel$p(AppSortListFragment.this), new AppSortListFragment$DataAdapter$onCreateViewHolder$1(this));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AppSortListFragment.this.dataList.size();
        }

        public void onBindViewHolder(DataViewHolder dataViewHolder, int i) {
            Intrinsics.checkNotNullParameter(dataViewHolder, "holder");
            dataViewHolder.bindTo(AppSortListFragment.this.dataList.get(i));
        }
    }

    /* compiled from: AppSortListFragment.kt */
    private static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558589;
        private final String apkType;
        private final ItemAppCategoryBinding binding;
        private final SuperSearchViewModel viewModel;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(View view, String str, SuperSearchViewModel superSearchViewModel, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(str, "apkType");
            Intrinsics.checkNotNullParameter(superSearchViewModel, "viewModel");
            Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
            this.apkType = str;
            this.viewModel = superSearchViewModel;
            ItemAppCategoryBinding itemAppCategoryBinding = (ItemAppCategoryBinding) getBinding();
            this.binding = itemAppCategoryBinding;
            itemAppCategoryBinding.itemView.setOnClickListener(this);
        }

        public final String getApkType() {
            return this.apkType;
        }

        public final SuperSearchViewModel getViewModel() {
            return this.viewModel;
        }

        /* compiled from: AppSortListFragment.kt */
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
            String str = this.apkType;
            int hashCode = str.hashCode();
            if (hashCode != 49) {
                if (hashCode == 50 && str.equals("2")) {
                    z = Intrinsics.areEqual((String) pair.getFirst(), this.viewModel.getGameSort());
                }
                throw new RuntimeException("Unknown apkType: " + this.apkType);
            }
            if (str.equals("1")) {
                z = Intrinsics.areEqual((String) pair.getFirst(), this.viewModel.getAppSort());
            }
            throw new RuntimeException("Unknown apkType: " + this.apkType);
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
