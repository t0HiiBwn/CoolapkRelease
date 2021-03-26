package com.coolapk.market.view.base.refresh;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.app.InitBehavior;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.AdapterListChangedCallback;
import java.util.List;

public abstract class LocalDataFragment<DATA> extends RefreshRecyclerFragment implements InitBehavior {
    private ObservableArrayList<DATA> dataList = new ObservableArrayList<>();
    private LocalDataFragment<DATA>.DataAdapter mAdapter;
    private FragmentBindingComponent mComponent;
    private ObservableList.OnListChangedCallback onListChangeCallback;

    public abstract int getItemViewType(int i);

    public abstract BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i);

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onEmptyViewClick() {
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onLoadMore() {
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onRefresh() {
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowEmptyView() {
        return false;
    }

    public List<DATA> getDataList() {
        return this.dataList;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.dataList.removeOnListChangedCallback(this.onListChangeCallback);
        this.onListChangeCallback = null;
        super.onDestroyView();
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        if (this.onListChangeCallback == null) {
            AdapterListChangedCallback adapterListChangedCallback = new AdapterListChangedCallback(adapter);
            this.onListChangeCallback = adapterListChangedCallback;
            this.dataList.addOnListChangedCallback(adapterListChangedCallback);
        }
    }

    public void setNotifyAdapter(boolean z) {
        this.dataList.removeOnListChangedCallback(this.onListChangeCallback);
        if (z) {
            this.dataList.addOnListChangedCallback(this.onListChangeCallback);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setAutoUpdateContentUiOnDataChanged(true);
        LocalDataFragment<DATA>.DataAdapter dataAdapter = new DataAdapter();
        this.mAdapter = dataAdapter;
        setAdapter(dataAdapter);
    }

    public LocalDataFragment<DATA>.DataAdapter getAdapter() {
        return this.mAdapter;
    }

    public FragmentBindingComponent getComponent() {
        if (this.mComponent == null) {
            this.mComponent = new FragmentBindingComponent(this);
        }
        return this.mComponent;
    }

    protected class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        protected DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return LocalDataFragment.this.onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return LocalDataFragment.this.getItemViewType(i);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(LocalDataFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return LocalDataFragment.this.getDataList().size();
        }
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }
}
