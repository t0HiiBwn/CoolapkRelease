package com.coolapk.market.view.user;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemServiceAppTimeBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.UserHistory;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.SectionedAdapter;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import rx.Subscriber;

public class HistoryTimeFragment extends UserHistoryListFragment {
    private TimeAdapter adapter;

    @Override // com.coolapk.market.view.user.UserHistoryListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.adapter = new TimeAdapter(getRecyclerView().getAdapter());
        getRecyclerView().setAdapter(this.adapter);
        updateSections();
    }

    @Override // com.coolapk.market.view.user.UserHistoryListFragment
    protected int getDataIndex(int i) {
        return this.adapter.sectionedPositionToPosition(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            MenuItemCompat.setShowAsAction(menu.add(0, 2131361892, 0, getString(2131886712)), 2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131361892) {
            return true;
        }
        ConfirmDialog newInstance = ConfirmDialog.newInstance(getString(2131886712), getString(2131886756));
        newInstance.setOnOkRunnable(new Runnable() {
            /* class com.coolapk.market.view.user.HistoryTimeFragment.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                DataManager.getInstance().delAllHistory().map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<String>() {
                    /* class com.coolapk.market.view.user.HistoryTimeFragment.AnonymousClass1.AnonymousClass1 */

                    @Override // rx.Observer
                    public void onCompleted() {
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        Toast.error(HistoryTimeFragment.this.getActivity(), th);
                    }

                    public void onNext(String str) {
                        HistoryTimeFragment.this.getDataList().clear();
                        HistoryTimeFragment.this.updateSections();
                        HistoryTimeFragment.this.setPage(1);
                        HistoryTimeFragment.this.reloadData();
                    }
                });
            }
        });
        newInstance.show(getChildFragmentManager(), (String) null);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.user.UserHistoryListFragment
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
        boolean onRequestResponse = super.onRequestResponse(z, result);
        updateSections();
        setHasOptionsMenu(getDataList().size() > 0);
        return onRequestResponse;
    }

    /* access modifiers changed from: private */
    public void updateSections() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getDataList().size() - 1; i++) {
            Entity entity = getDataList().get(i);
            if (EntityUtils.isHistoryType(entity.getEntityType())) {
                String timeDescription = getTimeDescription((UserHistory) entity);
                if (i == 0) {
                    arrayList.add(new SectionedAdapter.Section(i, 2131558932, timeDescription));
                } else {
                    Entity entity2 = getDataList().get(i - 1);
                    if (EntityUtils.isHistoryType(entity2.getEntityType()) && !TextUtils.equals(getTimeDescription((UserHistory) entity2), timeDescription)) {
                        arrayList.add(new SectionedAdapter.Section(i, 2131558932, timeDescription));
                    }
                }
            }
        }
        this.adapter.setSections(arrayList);
    }

    private String getTimeDescription(UserHistory userHistory) {
        return DateUtils.getHistoryTimeDescription(getActivity(), userHistory.getDateline());
    }

    private class TimeAdapter extends SectionedAdapter {
        public TimeAdapter(RecyclerView.Adapter adapter) {
            super(adapter);
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public RecyclerView.ViewHolder onCreateSectionViewHolder(ViewGroup viewGroup, int i) {
            return new TimeViewHolder(LayoutInflater.from(HistoryTimeFragment.this.getActivity()).inflate(2131558932, viewGroup, false));
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public void onBindSectionViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((BindingViewHolder) viewHolder).bindTo(getSection(i).getObject());
        }
    }

    private static class TimeViewHolder extends BindingViewHolder {
        public static final int LAYOUT_ID = 2131558932;

        public TimeViewHolder(View view) {
            super(view);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemServiceAppTimeBinding itemServiceAppTimeBinding = (ItemServiceAppTimeBinding) getBinding();
            itemServiceAppTimeBinding.setTime((String) obj);
            itemServiceAppTimeBinding.executePendingBindings();
        }
    }
}
