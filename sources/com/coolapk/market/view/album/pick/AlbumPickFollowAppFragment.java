package com.coolapk.market.view.album.pick;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemPickServiceAppBinding;
import com.coolapk.market.event.RemoveItemEvent;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.StateEventListFragment;
import com.coolapk.market.view.demo.DemoContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.ServicePickAppViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class AlbumPickFollowAppFragment extends StateEventListFragment<Result<List<Entity>>, Entity> implements DemoContract.View {
    private Map<String, AlbumItem> commitApps;

    public static AlbumPickFollowAppFragment newInstance() {
        Bundle bundle = new Bundle();
        AlbumPickFollowAppFragment albumPickFollowAppFragment = new AlbumPickFollowAppFragment();
        albumPickFollowAppFragment.setArguments(bundle);
        return albumPickFollowAppFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.commitApps = ((AlbumPickAppTabActivity) getActivity()).getCommitApps();
        EventBus.getDefault().register(this);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
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

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(getString(2131886826), 0);
        setAdapter(new DataAdapter(this));
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558863, 2131231062).last(2131231062).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        if (getUserVisibleHint()) {
            initData();
        }
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Override // com.coolapk.market.view.demo.DemoContract.View
    public String findFirstItem() {
        ServiceApp findFirstApkType = EntityUtils.findFirstApkType(getDataList());
        if (findFirstApkType != null) {
            return findFirstApkType.getApkId();
        }
        return null;
    }

    @Override // com.coolapk.market.view.demo.DemoContract.View
    public String findLastItem() {
        ServiceApp findLastApkType = EntityUtils.findLastApkType(getDataList());
        if (findLastApkType != null) {
            return findLastApkType.getApkId();
        }
        return null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRemoveItemEventChange(RemoveItemEvent removeItemEvent) {
        List dataList = getDataList();
        for (int i = 0; i < dataList.size(); i++) {
            Entity entity = (Entity) dataList.get(i);
            if ((entity instanceof ServiceApp) && ((ServiceApp) entity).getApkId().equals(removeItemEvent.getServiceApp().getApkId())) {
                getDataList().remove(i);
            }
        }
    }

    public static class DataViewHolder extends ServicePickAppViewHolder implements CompoundButton.OnCheckedChangeListener {
        private ServiceApp app;
        private ItemPickServiceAppBinding binding;
        private CheckBox checkBox;
        private final Map<String, AlbumItem> commitApps;
        private boolean isCheck;

        public DataViewHolder(View view, DataBindingComponent dataBindingComponent, Map<String, AlbumItem> map, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, map, itemActionHandler);
            this.commitApps = map;
        }

        @Override // com.coolapk.market.viewholder.ServicePickAppViewHolder, com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            super.bindTo(obj);
            this.binding = (ItemPickServiceAppBinding) getBinding();
            ServiceApp serviceApp = (ServiceApp) obj;
            this.app = serviceApp;
            this.isCheck = this.commitApps.containsKey(serviceApp.getPackageName());
            this.binding.appCheckView.setChecked(this.isCheck);
            ItemPickServiceAppBinding itemPickServiceAppBinding = (ItemPickServiceAppBinding) getBinding();
            this.binding = itemPickServiceAppBinding;
            itemPickServiceAppBinding.itemView.setOnClickListener(this);
            this.binding.appCheckView.setOnCheckedChangeListener(this);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
            if (view.getId() == 2131362779) {
                CheckBox checkBox2 = this.binding.appCheckView;
                this.checkBox = checkBox2;
                checkBox2.setChecked(!checkBox2.isChecked());
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            boolean containsKey = this.commitApps.containsKey(this.app.getPackageName());
            if (z && !containsKey) {
                this.commitApps.put(this.app.getPackageName(), AlbumItem.createAlbumItemBySapp(this.app));
            } else if (!z && containsKey) {
                this.commitApps.remove(this.app.getPackageName());
            }
        }
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private final FragmentBindingComponent component;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558863;
        }

        public DataAdapter(Fragment fragment) {
            this.component = new FragmentBindingComponent(fragment);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new DataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), this.component, AlbumPickFollowAppFragment.this.commitApps, null);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(AlbumPickFollowAppFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AlbumPickFollowAppFragment.this.getDataList().size();
        }
    }
}
