package com.coolapk.market.view.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemSectionDemoTitleBinding;
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
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.StateEventListFragment;
import com.coolapk.market.view.demo.SectionDemoContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.ServiceAppViewHolder;
import com.coolapk.market.widget.SectionedAdapter;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.ArrayList;
import java.util.List;

public class SectionDemoFragment extends StateEventListFragment<Result<List<Entity>>, Entity> implements SectionDemoContract.View {
    private MySectionedAdapter adapter;

    public static SectionDemoFragment newInstance() {
        Bundle bundle = new Bundle();
        SectionDemoFragment sectionDemoFragment = new SectionDemoFragment();
        sectionDemoFragment.setArguments(bundle);
        return sectionDemoFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setAdapter(new DataAdapter(this));
        this.adapter = new MySectionedAdapter(getRecyclerView().getAdapter());
        getRecyclerView().setAdapter(this.adapter);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558921, 2131231052).type(2131558924, 2131231052).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        if (getUserVisibleHint()) {
            initData();
        }
        if (bundle != null) {
            createSections(getDataList());
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
        createSections(result.getData());
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

    private void createSections(List<Entity> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || i == 3 || i == 5) {
                arrayList.add(new SectionedAdapter.Section(i, 2131558921, "Section " + (i + 1)));
            }
        }
        this.adapter.setSections(arrayList);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Override // com.coolapk.market.view.demo.SectionDemoContract.View
    public String findFirstItem() {
        ServiceApp findFirstApkType = EntityUtils.findFirstApkType(getDataList());
        if (findFirstApkType != null) {
            return findFirstApkType.getApkId();
        }
        return null;
    }

    @Override // com.coolapk.market.view.demo.SectionDemoContract.View
    public String findLastItem() {
        ServiceApp findLastApkType = EntityUtils.findLastApkType(getDataList());
        if (findLastApkType != null) {
            return findLastApkType.getApkId();
        }
        return null;
    }

    private class MySectionedAdapter extends SectionedAdapter {
        public MySectionedAdapter(RecyclerView.Adapter adapter) {
            super(adapter);
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public RecyclerView.ViewHolder onCreateSectionViewHolder(ViewGroup viewGroup, int i) {
            return new SectionViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558921, viewGroup, false));
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public void onBindSectionViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((BindingViewHolder) viewHolder).bindTo(getSection(i));
        }
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private FragmentBindingComponent component;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558924;
        }

        public DataAdapter(Fragment fragment) {
            this.component = new FragmentBindingComponent(fragment);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new DataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), this.component, new ItemActionHandler() {
                /* class com.coolapk.market.view.demo.SectionDemoFragment.DataAdapter.AnonymousClass1 */

                /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00a4: APUT  (r4v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r8v7 java.lang.String) */
                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                        Entity entity = (Entity) SectionDemoFragment.this.getDataList().get(SectionDemoFragment.this.adapter.sectionedPositionToPosition(viewHolder.getAdapterPosition()));
                        int id = view.getId();
                        if (id != 2131361886) {
                            if (id == 2131362768 && EntityUtils.isApkType(entity.getEntityType())) {
                                ActionManager.startAppViewActivity(SectionDemoFragment.this.getActivity(), ((ServiceApp) entity).getPackageName());
                            }
                        } else if (EntityUtils.isApkType(entity.getEntityType())) {
                            ServiceApp serviceApp = (ServiceApp) entity;
                            MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
                            String str = null;
                            UpgradeInfo upgradeInfo = mobileAppExistFast != null ? mobileAppExistFast.getUpgradeInfo() : null;
                            ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp).packageName(serviceApp.getPackageName()).targetUrl(serviceApp.getDownloadUrl(0));
                            String[] strArr = new String[4];
                            strArr[0] = serviceApp.getDownloadUrlMd5(0);
                            strArr[1] = serviceApp.getDownloadUrlMd5(2);
                            strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
                            if (upgradeInfo != null) {
                                str = upgradeInfo.getDownloadUrlMd5(1);
                            }
                            strArr[3] = str;
                            StateUtils.handleClick(SectionDemoFragment.this.getActivity(), targetUrl.downloadKeys(strArr).build(), view);
                        }
                    }
                }

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public boolean onItemLongClick(RecyclerView.ViewHolder viewHolder, View view) {
                    if (UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                        return false;
                    }
                    Toast.show(SectionDemoFragment.this.getActivity(), ((Entity) SectionDemoFragment.this.getDataList().get(SectionDemoFragment.this.adapter.sectionedPositionToPosition(viewHolder.getAdapterPosition()))).getEntityType());
                    return true;
                }
            });
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(SectionDemoFragment.this.getDataList().get(SectionDemoFragment.this.adapter.sectionedPositionToPosition(bindingViewHolder.getAdapterPosition())));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SectionDemoFragment.this.getDataList().size();
        }
    }

    public static class SectionViewHolder extends BindingViewHolder {
        private static final int LAYOUT_ID = 2131558921;
        private String title;

        public SectionViewHolder(View view) {
            super(view);
            ((ItemSectionDemoTitleBinding) getBinding()).setVh(this);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            this.title = (String) ((SectionedAdapter.Section) obj).getObject();
            notifyPropertyChanged(278);
        }

        @Bindable
        public String getTitle() {
            return this.title;
        }
    }

    public static class DataViewHolder extends ServiceAppViewHolder {
        public DataViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            ViewUtil.clickListener(view, this);
        }

        @Override // com.coolapk.market.viewholder.ServiceAppViewHolder, com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            super.bindTo(obj);
        }
    }
}
