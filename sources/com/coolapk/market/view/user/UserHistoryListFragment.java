package com.coolapk.market.view.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemFootBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.UserHistory;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.UserHistoryViewHolder;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;

public class UserHistoryListFragment extends NewAsyncListFragment<Result<List<Entity>>> {
    private static final String KEY_DATA = "DATA";
    public static final String TYPE_FOOT = "FOOT";
    private final ObservableArrayList<Entity> dataList = new ObservableArrayList<>();

    protected int getDataIndex(int i) {
        return i;
    }

    public static UserHistoryListFragment newInstance() {
        Bundle bundle = new Bundle();
        UserHistoryListFragment userHistoryListFragment = new UserHistoryListFragment();
        userHistoryListFragment.setArguments(bundle);
        return userHistoryListFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("DATA");
            if (parcelableArrayList != null) {
                this.dataList.addAll(parcelableArrayList);
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558973, 2131231052).last(2131231052).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        getRecyclerView().setClipToPadding(false);
        DataAdapter dataAdapter = new DataAdapter();
        setAdapter(dataAdapter);
        this.dataList.addOnListChangedCallback(new AdapterListChangedCallback(dataAdapter));
        setLoadMoreEnable(true);
        if (getUserVisibleHint()) {
            initData();
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
        boolean z2 = false;
        if (!CollectionUtils.isEmpty(result.getData())) {
            if (z) {
                this.dataList.addAll(0, result.getData());
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                this.dataList.addAll(result.getData());
            }
            z2 = true;
        } else if (!z) {
            this.dataList.add(HolderItem.newBuilder().entityType("FOOT").build());
        }
        updateContentUI();
        return z2;
    }

    public List<Entity> getDataList() {
        return this.dataList;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getUserHitHistory(i, findFirstItem(), findLastItem()).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult());
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return this.dataList.size() > 0;
    }

    public String findFirstItem() {
        UserHistory findFirstHistoryType = EntityUtils.findFirstHistoryType(getDataList());
        if (findFirstHistoryType != null) {
            return findFirstHistoryType.getId();
        }
        return null;
    }

    public String findLastItem() {
        UserHistory findLastHistoryType = EntityUtils.findLastHistoryType(getDataList());
        if (findLastHistoryType != null) {
            return findLastHistoryType.getId();
        }
        return null;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("DATA", this.dataList);
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private final FragmentBindingComponent component;

        public DataAdapter() {
            this.component = new FragmentBindingComponent(UserHistoryListFragment.this.getFragment());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            if (i == 2131558748) {
                return new LastViewHolder(inflate, null);
            }
            if (i == 2131558973) {
                return new UserHistoryViewHolder(inflate, this.component, null);
            }
            throw new IllegalStateException("Unknown view type " + i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            String entityType = ((Entity) UserHistoryListFragment.this.dataList.get(i)).getEntityType();
            entityType.hashCode();
            return !entityType.equals("FOOT") ? 2131558973 : 2131558748;
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(UserHistoryListFragment.this.dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return UserHistoryListFragment.this.dataList.size();
        }
    }

    private static class LastViewHolder extends GenericBindHolder<ItemFootBinding, Entity> {
        public static final int LAYOUT_ID = 2131558748;

        public LastViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
        }

        @Override // com.coolapk.market.viewholder.GenericBindHolder
        public void bindToContent(Entity entity) {
            ((ItemFootBinding) getBinding()).executePendingBindings();
        }
    }
}
