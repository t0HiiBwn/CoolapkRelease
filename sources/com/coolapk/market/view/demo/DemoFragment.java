package com.coolapk.market.view.demo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ServiceAppBinding;
import com.coolapk.market.event.RemoveItemEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.StateEventListFragment;
import com.coolapk.market.view.demo.DemoContract;
import com.coolapk.market.view.feed.CancelFollowItemDialog;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.ServiceAppViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DemoFragment extends StateEventListFragment<Result<List<Entity>>, Entity> implements DemoContract.View {
    private String uid;

    public static DemoFragment newInstance() {
        Bundle bundle = new Bundle();
        DemoFragment demoFragment = new DemoFragment();
        demoFragment.setArguments(bundle);
        return demoFragment;
    }

    public static DemoFragment newInstance(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("uid", str);
        DemoFragment demoFragment = new DemoFragment();
        demoFragment.setArguments(bundle);
        return demoFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uid = getArguments().getString("uid");
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

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(getString(2131886826), 0);
        setAdapter(new DataAdapter(this));
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558931, 2131231062).last(2131231062).create());
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

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private FragmentBindingComponent component;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558931;
        }

        public DataAdapter(Fragment fragment) {
            this.component = new FragmentBindingComponent(fragment);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new DataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), this.component, new ItemActionHandler() {
                /* class com.coolapk.market.view.demo.DemoFragment.DataAdapter.AnonymousClass1 */

                /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00b3: APUT  (r4v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r0v8 java.lang.String) */
                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    if (viewHolder.getAdapterPosition() != -1) {
                        Entity entity = (Entity) DemoFragment.this.getDataList().get(viewHolder.getAdapterPosition());
                        int id = view.getId();
                        if (id != 2131361887) {
                            if (id == 2131362779 && EntityUtils.isApkType(entity.getEntityType())) {
                                ServiceApp serviceApp = (ServiceApp) entity;
                                ActionManager.startAppViewActivity(DemoFragment.this.getActivity(), ((ServiceAppBinding) ((BindingViewHolder) viewHolder).getBinding()).iconView, serviceApp.getPackageName(), serviceApp.getLogo(), serviceApp.getAppName(), serviceApp.getExtraAnalysisData(), serviceApp.getRequestContext(), serviceApp.getExtraFromApi());
                            }
                        } else if (EntityUtils.isApkType(entity.getEntityType())) {
                            ServiceApp serviceApp2 = (ServiceApp) entity;
                            MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp2.getPackageName());
                            String str = null;
                            UpgradeInfo upgradeInfo = mobileAppExistFast != null ? mobileAppExistFast.getUpgradeInfo() : null;
                            ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp2).packageName(serviceApp2.getPackageName()).targetUrl(serviceApp2.getDownloadUrl(0));
                            String[] strArr = new String[4];
                            strArr[0] = serviceApp2.getDownloadUrlMd5(0);
                            strArr[1] = serviceApp2.getDownloadUrlMd5(2);
                            strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
                            if (upgradeInfo != null) {
                                str = upgradeInfo.getDownloadUrlMd5(1);
                            }
                            strArr[3] = str;
                            StateUtils.handleClick(DemoFragment.this.getActivity(), targetUrl.downloadKeys(strArr).build(), view);
                        }
                    }
                }

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public boolean onItemLongClick(RecyclerView.ViewHolder viewHolder, View view) {
                    if (viewHolder.getAdapterPosition() == -1 || TextUtils.isEmpty(DemoFragment.this.uid) || !TextUtils.equals(DataManager.getInstance().getLoginSession().getUid(), DemoFragment.this.uid)) {
                        return false;
                    }
                    CancelFollowItemDialog.newInstance((Entity) DemoFragment.this.getDataList().get(viewHolder.getAdapterPosition())).show(DemoFragment.this.requireActivity().getSupportFragmentManager(), (String) null);
                    return true;
                }
            });
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(DemoFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return DemoFragment.this.getDataList().size();
        }
    }

    public static class DataViewHolder extends ServiceAppViewHolder {
        public final ObservableField<String> imageLoad = new ObservableField<>();

        public DataViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        @Override // com.coolapk.market.viewholder.ServiceAppViewHolder, com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            super.bindTo(obj);
        }
    }
}
