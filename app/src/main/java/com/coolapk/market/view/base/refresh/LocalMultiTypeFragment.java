package com.coolapk.market.view.base.refresh;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.app.InitBehavior;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import java.util.List;

public abstract class LocalMultiTypeFragment<DATA> extends RefreshRecyclerFragment implements InitBehavior {
    private ObservableArrayList<DATA> dataList = new ObservableArrayList<>();
    private MultiTypeAdapter mAdapter;
    private FragmentBindingComponent mComponent;
    private ObservableList.OnListChangedCallback onListChangeCallback;

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onEmptyViewClick() {
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onLoadMore() {
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onRefresh() {
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
        MultiTypeAdapter multiTypeAdapter = new MultiTypeAdapter(this.dataList);
        this.mAdapter = multiTypeAdapter;
        setAdapter(multiTypeAdapter);
    }

    public BaseMultiTypeAdapter getAdapter() {
        return this.mAdapter;
    }

    public FragmentBindingComponent getComponent() {
        if (this.mComponent == null) {
            this.mComponent = new FragmentBindingComponent(this);
        }
        return this.mComponent;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowEmptyView() {
        return getDataList().size() == 0;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }
}
