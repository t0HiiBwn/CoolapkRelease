package com.coolapk.market.view.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.app.RelateDataListContract;
import com.coolapk.market.view.base.asynclist.AsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.RelatedDataViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.List;

public class RelateDataListFragment extends AsyncListFragment<Result<List<RelatedData>>, RelatedData> implements RelateDataListContract.View {
    private FragmentBindingComponent component;

    public static RelateDataListFragment newInstance() {
        Bundle bundle = new Bundle();
        RelateDataListFragment relateDataListFragment = new RelateDataListFragment();
        relateDataListFragment.setArguments(bundle);
        return relateDataListFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(getString(2131886764), 0);
        this.component = new FragmentBindingComponent(this);
        setAdapter(new DataAdapter());
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558895, 2131231052).last(2131231052).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        setRefreshEnable(false);
        if (getUserVisibleHint()) {
            initData();
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<RelatedData>> result) {
        boolean z2 = false;
        if (result.getData() != null && !result.getData().isEmpty()) {
            if (z) {
                getDataList().addAll(0, result.getData());
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                getDataList().addAll(result.getData());
            }
            z2 = true;
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Override // com.coolapk.market.view.app.RelateDataListContract.View
    public String findFirstItem() {
        if (CollectionUtils.isEmpty(getDataList())) {
            return null;
        }
        return ((RelatedData) getDataList().get(0)).getId();
    }

    @Override // com.coolapk.market.view.app.RelateDataListContract.View
    public String findLastItem() {
        if (CollectionUtils.isEmpty(getDataList())) {
            return null;
        }
        return ((RelatedData) getDataList().get(getDataList().size() - 1)).getId();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558895;
        }

        private DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new RelatedDataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), RelateDataListFragment.this.component, null);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(RelateDataListFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RelateDataListFragment.this.getDataList().size();
        }
    }
}
