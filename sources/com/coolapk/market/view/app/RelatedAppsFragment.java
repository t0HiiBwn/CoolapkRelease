package com.coolapk.market.view.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.app.RelatedAppsContract;
import com.coolapk.market.view.base.asynclist.AsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.ServiceAppViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.List;

public class RelatedAppsFragment extends AsyncListFragment<Result<List<Entity>>, Entity> implements RelatedAppsContract.View {
    public static final String KEY_KEYWORD = "KEYWORD";
    private FragmentBindingComponent component;
    private String keyword;

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("KEYWORD");
        this.keyword = string;
        setPresenter(new RelatedAppsPresenter(this, string));
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.component = new FragmentBindingComponent(this);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        setEmptyData(getString(2131886828), 0);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        setAdapter(new DataAdapter());
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558931, 2131231062).last(2131231062).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        initData();
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, Result<List<Entity>> result) {
        if (z) {
            getDataList().clear();
        }
        if (!CollectionUtils.isEmpty(result.getData())) {
            getDataList().addAll(result.getData());
        }
        updateContentUI();
        return false;
    }

    @Override // com.coolapk.market.view.app.RelatedAppsContract.View
    public String findFirstItem() {
        if (CollectionUtils.isEmpty(getDataList())) {
            return null;
        }
        return ((ServiceApp) getDataList().get(0)).getApkId();
    }

    @Override // com.coolapk.market.view.app.RelatedAppsContract.View
    public String findLastItem() {
        if (CollectionUtils.isEmpty(getDataList())) {
            return null;
        }
        return ((ServiceApp) getDataList().get(getDataList().size() - 1)).getApkId();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558931;
        }

        private DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ServiceAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), RelatedAppsFragment.this.component, new ItemActionHandler() {
                /* class com.coolapk.market.view.app.RelatedAppsFragment.DataAdapter.AnonymousClass1 */

                /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00b6: APUT  (r4v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r0v9 java.lang.String) */
                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                        Entity entity = (Entity) RelatedAppsFragment.this.getDataList().get(viewHolder.getAdapterPosition());
                        int id = view.getId();
                        if (id != 2131361887) {
                            if (id == 2131362779 && EntityUtils.isApkType(entity.getEntityType())) {
                                ServiceApp serviceApp = (ServiceApp) entity;
                                ActionManager.startAppViewActivity(RelatedAppsFragment.this.getActivity(), ((ServiceAppBinding) ((BindingViewHolder) viewHolder).getBinding()).iconView, serviceApp.getPackageName(), serviceApp.getLogo(), serviceApp.getAppName(), serviceApp.getExtraAnalysisData(), serviceApp.getRequestContext(), serviceApp.getExtraFromApi());
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
                            StateUtils.handleClick(RelatedAppsFragment.this.getActivity(), targetUrl.downloadKeys(strArr).build(), view);
                        }
                    }
                }
            });
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(RelatedAppsFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RelatedAppsFragment.this.getDataList().size();
        }
    }
}
