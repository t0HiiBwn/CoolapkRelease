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
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

/* compiled from: AppCategoryListFragment.kt */
public final class AppCategoryListFragment extends NewAsyncListFragment<List<? extends Entity>> {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_APK_TYPE = "APK_TYPE";
    private DataAdapter adapter;
    private String apkType;
    private final ArrayList<Entity> dataList = new ArrayList<>();
    private SuperSearchViewModel viewModel;

    public static final /* synthetic */ String access$getApkType$p(AppCategoryListFragment appCategoryListFragment) {
        String str = appCategoryListFragment.apkType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apkType");
        }
        return str;
    }

    public static final /* synthetic */ SuperSearchViewModel access$getViewModel$p(AppCategoryListFragment appCategoryListFragment) {
        SuperSearchViewModel superSearchViewModel = appCategoryListFragment.viewModel;
        if (superSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return superSearchViewModel;
    }

    /* compiled from: AppCategoryListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppCategoryListFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "apkType");
            AppCategoryListFragment appCategoryListFragment = new AppCategoryListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("APK_TYPE", str);
            Unit unit = Unit.INSTANCE;
            appCategoryListFragment.setArguments(bundle);
            return appCategoryListFragment;
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

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001c  */
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        String str;
        int hashCode;
        DataAdapter dataAdapter;
        this.dataList.clear();
        boolean z2 = true;
        if (list != null) {
            List<? extends Entity> list2 = list;
            if (!list2.isEmpty()) {
                this.dataList.addAll(list2);
                str = this.apkType;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("apkType");
                }
                hashCode = str.hashCode();
                if (hashCode == 49) {
                    if (hashCode == 50 && str.equals("2")) {
                        SuperSearchViewModel superSearchViewModel = this.viewModel;
                        if (superSearchViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        }
                        superSearchViewModel.setGameCategoryList(this.dataList);
                    }
                } else if (str.equals("1")) {
                    SuperSearchViewModel superSearchViewModel2 = this.viewModel;
                    if (superSearchViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    superSearchViewModel2.setAppCategoryList(this.dataList);
                }
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
        str = this.apkType;
        if (str == null) {
        }
        hashCode = str.hashCode();
        if (hashCode == 49) {
        }
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
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        DataManager instance = DataManager.getInstance();
        String str = this.apkType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apkType");
        }
        Observable<R> map = instance.getAppCategoryList(str).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowEmptyView() {
        return super.shouldShowEmptyView();
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return this.dataList.size() > 0;
    }

    public final void setSuperSearchViewModel(SuperSearchViewModel superSearchViewModel) {
        Intrinsics.checkNotNullParameter(superSearchViewModel, "viewModel");
        this.viewModel = superSearchViewModel;
    }

    /* compiled from: AppCategoryListFragment.kt */
    private final class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
        public DataAdapter() {
            AppCategoryListFragment.this = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558589, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new DataViewHolder(inflate, AppCategoryListFragment.access$getApkType$p(AppCategoryListFragment.this), AppCategoryListFragment.access$getViewModel$p(AppCategoryListFragment.this), new AppCategoryListFragment$DataAdapter$onCreateViewHolder$1(this));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AppCategoryListFragment.this.dataList.size() + 1;
        }

        public void onBindViewHolder(DataViewHolder dataViewHolder, int i) {
            Intrinsics.checkNotNullParameter(dataViewHolder, "holder");
            if (i == 0) {
                dataViewHolder.bindTo(null);
            } else {
                dataViewHolder.bindTo(AppCategoryListFragment.this.dataList.get(i - 1));
            }
        }
    }

    /* compiled from: AppCategoryListFragment.kt */
    private static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558589;
        private final String apkType;
        private final ItemAppCategoryBinding binding;
        private final SuperSearchViewModel viewModel;

        public final String getApkType() {
            return this.apkType;
        }

        public final SuperSearchViewModel getViewModel() {
            return this.viewModel;
        }

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

        /* compiled from: AppCategoryListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            String str;
            String str2;
            boolean z;
            if (obj == null) {
                str = "全部分类";
                str2 = "";
            } else {
                Entity entity = (Entity) obj;
                String title = entity.getTitle();
                Intrinsics.checkNotNull(title);
                String id = entity.getId();
                Intrinsics.checkNotNull(id);
                str2 = id;
                str = title;
            }
            TextView textView = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            textView.setText(str);
            this.binding.textView.setTextColor(createSelectedTextColor());
            String str3 = this.apkType;
            int hashCode = str3.hashCode();
            if (hashCode != 49) {
                if (hashCode == 50 && str3.equals("2")) {
                    z = Intrinsics.areEqual(str2, this.viewModel.getGameCat());
                }
                throw new RuntimeException("Unknown apkType: " + this.apkType);
            }
            if (str3.equals("1")) {
                z = Intrinsics.areEqual(str2, this.viewModel.getAppCat());
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
