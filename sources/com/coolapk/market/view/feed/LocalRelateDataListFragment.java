package com.coolapk.market.view.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.coolapk.market.AppHolder;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.view.base.refresh.LocalDataFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.RelatedDataViewHolder;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.ArrayList;

public class LocalRelateDataListFragment extends LocalDataFragment<RelatedData> {
    public static final String DATA_LIST = "data";

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public int getItemViewType(int i) {
        return 2131558902;
    }

    public static LocalRelateDataListFragment newInstance(ArrayList<RelatedData> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data", arrayList);
        LocalRelateDataListFragment localRelateDataListFragment = new LocalRelateDataListFragment();
        localRelateDataListFragment.setArguments(bundle);
        return localRelateDataListFragment;
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558902, 2131231062).create());
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        initData();
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RelatedDataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), getComponent(), null);
    }

    @Override // com.coolapk.market.app.InitBehavior
    public void initData() {
        ArrayList parcelableArrayList = getArguments().getParcelableArrayList("data");
        if (parcelableArrayList != null) {
            getDataList().addAll(parcelableArrayList);
        }
    }
}
