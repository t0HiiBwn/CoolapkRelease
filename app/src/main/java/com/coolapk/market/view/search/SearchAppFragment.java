package com.coolapk.market.view.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ServiceAppBinding;
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
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.search.SearchAppContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.ServiceAppViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.List;

public class SearchAppFragment extends StateEventListFragment<Result<List<Entity>>, Entity> implements SearchAppContract.View {
    private SearchAppContract.Presenter presenter;

    public static SearchAppFragment newInstance() {
        Bundle bundle = new Bundle();
        SearchAppFragment searchAppFragment = new SearchAppFragment();
        searchAppFragment.setArguments(bundle);
        return searchAppFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    public void setPresenter(AsyncListContract.Presenter presenter2) {
        super.setPresenter(presenter2);
        this.presenter = (SearchAppContract.Presenter) presenter2;
    }

    public String getKeyword() {
        return this.presenter.getKeyword();
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

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(getString(2131886764), 0);
        setAdapter(new DataAdapter(this));
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558924, 2131231052).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        if (getUserVisibleHint()) {
            initData();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Override // com.coolapk.market.view.search.SearchAppContract.View
    public String findFirstItem() {
        ServiceApp findFirstApkType = EntityUtils.findFirstApkType(getDataList());
        if (findFirstApkType != null) {
            return findFirstApkType.getApkId();
        }
        return null;
    }

    @Override // com.coolapk.market.view.search.SearchAppContract.View
    public String findLastItem() {
        ServiceApp findLastApkType = EntityUtils.findLastApkType(getDataList());
        if (findLastApkType != null) {
            return findLastApkType.getApkId();
        }
        return null;
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
            return new ServiceAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), this.component, new ItemActionHandler() {
                /* class com.coolapk.market.view.search.SearchAppFragment.DataAdapter.AnonymousClass1 */

                /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00b6: APUT  (r4v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r0v9 java.lang.String) */
                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                        Entity entity = (Entity) SearchAppFragment.this.getDataList().get(viewHolder.getAdapterPosition());
                        int id = view.getId();
                        if (id != 2131361886) {
                            if (id == 2131362768 && EntityUtils.isApkType(entity.getEntityType())) {
                                ServiceApp serviceApp = (ServiceApp) entity;
                                ActionManager.startAppViewActivity(SearchAppFragment.this.getActivity(), ((ServiceAppBinding) ((BindingViewHolder) viewHolder).getBinding()).iconView, serviceApp.getPackageName(), serviceApp.getLogo(), serviceApp.getAppName(), serviceApp.getExtraAnalysisData(), serviceApp.getRequestContext(), serviceApp.getExtraFromApi());
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
                            StateUtils.handleClick(SearchAppFragment.this.getActivity(), targetUrl.downloadKeys(strArr).build(), view);
                        }
                    }
                }

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public boolean onItemLongClick(RecyclerView.ViewHolder viewHolder, View view) {
                    if (viewHolder.getAdapterPosition() == -1) {
                        return false;
                    }
                    Toast.show(SearchAppFragment.this.getActivity(), ((Entity) SearchAppFragment.this.getDataList().get(viewHolder.getAdapterPosition())).getEntityType());
                    return true;
                }
            });
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(SearchAppFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SearchAppFragment.this.getDataList().size();
        }
    }
}
