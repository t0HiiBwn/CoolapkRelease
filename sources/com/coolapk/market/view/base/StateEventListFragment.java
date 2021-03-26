package com.coolapk.market.view.base;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.coolapk.market.util.RVStateEventChangedAdapter;
import com.coolapk.market.view.base.asynclist.AsyncListFragment;

public abstract class StateEventListFragment<RESULT, DATA extends Parcelable> extends AsyncListFragment<RESULT, DATA> {
    private RVStateEventChangedAdapter rvStateEventChangedAdapter;

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RVStateEventChangedAdapter rVStateEventChangedAdapter = new RVStateEventChangedAdapter(getRecyclerView());
        this.rvStateEventChangedAdapter = rVStateEventChangedAdapter;
        rVStateEventChangedAdapter.onAttach();
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.rvStateEventChangedAdapter.onDetach();
        super.onDestroyView();
    }
}
