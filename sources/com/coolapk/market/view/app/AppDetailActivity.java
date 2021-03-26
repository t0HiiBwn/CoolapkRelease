package com.coolapk.market.view.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.AppDetailBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.PermissionItem;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.RVStateEventChangedAdapter;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.view.app.AppDetailContract;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.ToolbarActivity;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.CardDoubleViewHolder;
import com.coolapk.market.viewholder.CardTripleViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.ArrayList;
import java.util.List;

public class AppDetailActivity extends ToolbarActivity {
    public static final String KEY_APP = "APP";

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public Fragment onCreateFragment() {
        ServiceApp serviceApp = (ServiceApp) getIntent().getParcelableExtra("APP");
        setTitle(serviceApp.getAppName());
        return AppDetailFragment.newInstance(serviceApp);
    }

    public static class AppDetailFragment extends BaseFragment implements AppDetailContract.View {
        private static final int CARD_TYPE_DETAIL = 1;
        private static final int CARD_TYPE_DEVELOPER = 2;
        private static final int CARD_TYPE_RELATE_ALBUM = 4;
        private static final int CARD_TYPE_RELATE_APP = 3;
        private AppDetailBinding binding;
        private FragmentBindingComponent component;
        private AppDetailContract.Presenter presenter;
        private ServiceApp serviceApp;
        private RVStateEventChangedAdapter stateEventChangedAdapter;
        private List<Integer> typeList = new ArrayList();
        private AppDetailViewModel viewModel;

        public static AppDetailFragment newInstance(ServiceApp serviceApp2) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("APP", serviceApp2);
            AppDetailFragment appDetailFragment = new AppDetailFragment();
            appDetailFragment.setArguments(bundle);
            return appDetailFragment;
        }

        @Override // androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            AppDetailBinding appDetailBinding = (AppDetailBinding) DataBindingUtil.inflate(layoutInflater, 2131558458, viewGroup, false);
            this.binding = appDetailBinding;
            return appDetailBinding.getRoot();
        }

        @Override // androidx.fragment.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.serviceApp = (ServiceApp) getArguments().getParcelable("APP");
            this.component = new FragmentBindingComponent(this);
            AppDetailPresenter appDetailPresenter = new AppDetailPresenter(this);
            this.presenter = appDetailPresenter;
            appDetailPresenter.onInitPresenterState(bundle);
            this.viewModel = new AppDetailViewModel(getActivity(), this.serviceApp, this.presenter);
            this.presenter.loadPermission(this.serviceApp.getPermissions(), getActivity().getPackageManager());
            this.binding.recyclerView.setAdapter(new DataAdapter());
            this.binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            RVStateEventChangedAdapter rVStateEventChangedAdapter = new RVStateEventChangedAdapter(this.binding.recyclerView);
            this.stateEventChangedAdapter = rVStateEventChangedAdapter;
            rVStateEventChangedAdapter.onAttach();
            this.binding.recyclerView.addItemDecoration(ItemDecorations.vertical(getActivity()).type(1, 2131231062).type(2, 2131231062).type(3, 2131231062).type(4, 2131231062).last(2131231062).create());
            this.binding.recyclerView.getItemAnimator().setChangeDuration(0);
            this.binding.recyclerView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
            this.typeList.add(1);
            if (!CollectionUtils.isEmpty(this.viewModel.getDeveloperCard().getEntities())) {
                this.typeList.add(2);
            }
            if (!CollectionUtils.isEmpty(this.viewModel.getRelatedAlbumCard().getEntities())) {
                this.typeList.add(4);
            }
            if (!CollectionUtils.isEmpty(this.viewModel.getRelatedAppCard().getEntities())) {
                this.typeList.add(3);
            }
        }

        @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
        public void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);
            this.presenter.onSaveInstanceState(bundle);
        }

        @Override // androidx.fragment.app.Fragment
        public void onDestroyView() {
            this.stateEventChangedAdapter.onDetach();
            super.onDestroyView();
        }

        @Override // com.coolapk.market.view.app.AppDetailContract.View
        public void onLoadPermissionComplete(List<PermissionItem> list, Throwable th) {
            if (th != null) {
                Toast.error(getActivity(), th);
            } else {
                this.viewModel.notifyDataChanged();
            }
        }

        private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
            private DataAdapter() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                if (i == 1) {
                    return new AppDetailViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558594, viewGroup, false), AppDetailFragment.this.viewModel);
                }
                if (i == 2) {
                    return new CardTripleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558640, viewGroup, false), AppDetailFragment.this.component, new ItemActionHandler() {
                        /* class com.coolapk.market.view.app.AppDetailActivity.AppDetailFragment.DataAdapter.AnonymousClass1 */

                        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00d8: APUT  (r3v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r9v10 java.lang.String) */
                        @Override // com.coolapk.market.viewholder.ItemActionHandler
                        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                            super.onItemClick(viewHolder, view);
                            switch (view.getId()) {
                                case 2131361877:
                                    ServiceApp serviceApp = AppDetailFragment.this.viewModel.getDeveloperCard().getEntities().get(((Integer) view.getTag()).intValue());
                                    MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
                                    UpgradeInfo upgradeInfo = mobileAppExistFast != null ? mobileAppExistFast.getUpgradeInfo() : null;
                                    ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp).packageName(serviceApp.getPackageName()).targetUrl(serviceApp.getDownloadUrl(0));
                                    String[] strArr = new String[4];
                                    strArr[0] = serviceApp.getDownloadUrlMd5(0);
                                    strArr[1] = serviceApp.getDownloadUrlMd5(2);
                                    strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
                                    strArr[3] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(1) : null;
                                    StateUtils.handleClick(AppDetailFragment.this.getActivity(), targetUrl.downloadKeys(strArr).build(), null);
                                    return;
                                case 2131362780:
                                case 2131362784:
                                case 2131362785:
                                    View findViewById = view.findViewById(2131362683);
                                    ServiceApp serviceApp2 = AppDetailFragment.this.viewModel.getDeveloperCard().getEntities().get(((Integer) view.getTag()).intValue());
                                    ActionManager.startAppViewActivity(AppDetailFragment.this.getActivity(), findViewById, serviceApp2.getPackageName(), serviceApp2.getLogo(), serviceApp2.getAppName(), serviceApp2.getExtraAnalysisData(), serviceApp2.getRequestContext(), serviceApp2.getExtraFromApi());
                                    return;
                                case 2131362982:
                                    ActionManager.startDeveloperAppsActivity(AppDetailFragment.this.getActivity(), AppDetailFragment.this.viewModel.getServiceApp().getDeveloperName());
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                }
                if (i == 3) {
                    return new CardTripleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558640, viewGroup, false), AppDetailFragment.this.component, new ItemActionHandler() {
                        /* class com.coolapk.market.view.app.AppDetailActivity.AppDetailFragment.DataAdapter.AnonymousClass2 */

                        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00d8: APUT  (r3v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r9v10 java.lang.String) */
                        @Override // com.coolapk.market.viewholder.ItemActionHandler
                        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                            super.onItemClick(viewHolder, view);
                            switch (view.getId()) {
                                case 2131361877:
                                    ServiceApp serviceApp = AppDetailFragment.this.viewModel.getRelatedAppCard().getEntities().get(((Integer) view.getTag()).intValue());
                                    MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
                                    UpgradeInfo upgradeInfo = mobileAppExistFast != null ? mobileAppExistFast.getUpgradeInfo() : null;
                                    ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp).packageName(serviceApp.getPackageName()).targetUrl(serviceApp.getDownloadUrl(0));
                                    String[] strArr = new String[4];
                                    strArr[0] = serviceApp.getDownloadUrlMd5(0);
                                    strArr[1] = serviceApp.getDownloadUrlMd5(2);
                                    strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
                                    strArr[3] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(1) : null;
                                    StateUtils.handleClick(AppDetailFragment.this.getActivity(), targetUrl.downloadKeys(strArr).build(), null);
                                    return;
                                case 2131362780:
                                case 2131362784:
                                case 2131362785:
                                    View findViewById = view.findViewById(2131362683);
                                    ServiceApp serviceApp2 = AppDetailFragment.this.viewModel.getRelatedAppCard().getEntities().get(((Integer) view.getTag()).intValue());
                                    ActionManager.startAppViewActivity(AppDetailFragment.this.getActivity(), findViewById, serviceApp2.getPackageName(), serviceApp2.getLogo(), serviceApp2.getAppName(), serviceApp2.getExtraAnalysisData(), serviceApp2.getRequestContext(), serviceApp2.getExtraFromApi());
                                    return;
                                case 2131362982:
                                    ActionManager.startRelatedAppsActivity(AppDetailFragment.this.getActivity(), AppDetailFragment.this.viewModel.getServiceApp().getKeywords());
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                }
                if (i != 4) {
                    return null;
                }
                return new CardDoubleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558636, viewGroup, false), AppDetailFragment.this.component, new ItemActionHandler() {
                    /* class com.coolapk.market.view.app.AppDetailActivity.AppDetailFragment.DataAdapter.AnonymousClass3 */

                    @Override // com.coolapk.market.viewholder.ItemActionHandler
                    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                        super.onItemClick(viewHolder, view);
                        int id = view.getId();
                        if (id == 2131362780 || id == 2131362784) {
                            ActionManager.startV8AlbumDetailActivity(AppDetailFragment.this.getActivity(), AppDetailFragment.this.viewModel.getRelatedAlbumCard().getEntities().get(((Integer) view.getTag()).intValue()).getAlbumId());
                        } else if (id == 2131362982) {
                            ActionManager.startRelatedAlbumsActivity(AppDetailFragment.this.getActivity(), AppDetailFragment.this.viewModel.getServiceApp().getAppFullName());
                        }
                    }
                });
            }

            public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
                int itemViewType = bindingViewHolder.getItemViewType();
                if (itemViewType == 2) {
                    bindingViewHolder.bindTo(AppDetailFragment.this.viewModel.getDeveloperCard());
                } else if (itemViewType == 3) {
                    bindingViewHolder.bindTo(AppDetailFragment.this.viewModel.getRelatedAppCard());
                } else if (itemViewType != 4) {
                    bindingViewHolder.bindTo(null);
                } else {
                    bindingViewHolder.bindTo(AppDetailFragment.this.viewModel.getRelatedAlbumCard());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return AppDetailFragment.this.typeList.size();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemViewType(int i) {
                return ((Integer) AppDetailFragment.this.typeList.get(i)).intValue();
            }
        }
    }
}
