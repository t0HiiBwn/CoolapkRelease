package com.coolapk.market.view.base.asynclist;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.viewholder.BindingViewHolder;

public abstract class SimpleAsyncListFragment<RESULT, DATA extends Parcelable> extends AsyncListFragment<RESULT, DATA> {
    private SimpleAsyncListFragment<RESULT, DATA>.DataAdapter mAdapter;
    private FragmentBindingComponent mComponent;

    public Filter getAdapterFilter() {
        return null;
    }

    public abstract int getItemViewType(int i);

    public abstract BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i);

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        SimpleAsyncListFragment<RESULT, DATA>.DataAdapter dataAdapter = new DataAdapter();
        this.mAdapter = dataAdapter;
        setAdapter(dataAdapter);
    }

    public SimpleAsyncListFragment<RESULT, DATA>.DataAdapter getAdapter() {
        return this.mAdapter;
    }

    public FragmentBindingComponent getComponent() {
        if (this.mComponent == null) {
            this.mComponent = new FragmentBindingComponent(this);
        }
        return this.mComponent;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    protected void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
        bindingViewHolder.bindTo(getDataList().get(i));
    }

    public class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> implements Filterable {
        public DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return SimpleAsyncListFragment.this.onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return SimpleAsyncListFragment.this.getItemViewType(i);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            SimpleAsyncListFragment.this.onBindViewHolder(bindingViewHolder, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SimpleAsyncListFragment.this.getDataList().size();
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            return SimpleAsyncListFragment.this.getAdapterFilter();
        }
    }
}
