package com.coolapk.market.view.appmanager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.event.AppEvent;
import com.coolapk.market.event.CheckForUpgradeEvent;
import com.coolapk.market.event.DownloadEvent;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.appmanager.UpgradeContract;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.view.base.StateEventListFragment;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.OptionsTitleSectionViewHolder;
import com.coolapk.market.viewholder.UpgradeViewHolder;
import com.coolapk.market.widget.SectionedAdapter;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class UpgradeFragment extends StateEventListFragment<List<MobileApp>, MobileApp> implements UpgradeContract.View {
    private MySectionedAdapter adapter;
    private boolean isUpgrading;
    private UpgradeContract.Presenter presenter;

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onEmptyViewClick() {
    }

    public static UpgradeFragment newInstance() {
        Bundle bundle = new Bundle();
        UpgradeFragment upgradeFragment = new UpgradeFragment();
        upgradeFragment.setArguments(bundle);
        return upgradeFragment;
    }

    @Override // com.coolapk.market.view.base.StateEventListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setEmptyData(getString(2131886832), 0);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        getRecyclerView().setClipToPadding(false);
        getRecyclerView().setClipChildren(false);
        ViewExtents2Kt.tryListenWindowsInset(view, new Function1<Rect, Unit>() {
            /* class com.coolapk.market.view.appmanager.UpgradeFragment.AnonymousClass1 */

            public Unit invoke(Rect rect) {
                UpgradeFragment.this.getRecyclerView().setPadding(0, 0, 0, rect.bottom);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    public void setPresenter(AsyncListContract.Presenter presenter2) {
        super.setPresenter(presenter2);
        this.presenter = (UpgradeContract.Presenter) presenter2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (this.presenter == null) {
            setPresenter(new UpgradePresenter(this));
        }
        super.onActivityCreated(bundle);
        boolean z = false;
        getView().findViewById(2131362464).setClickable(false);
        setEmptyData(getString(2131887120), 0);
        NotificationManagerCompat.from(getActivity()).cancel(3);
        setNotifyAdapter(false);
        setAdapter(new DataAdapter(this));
        this.adapter = new MySectionedAdapter(getRecyclerView().getAdapter());
        getRecyclerView().setAdapter(this.adapter);
        if (bundle != null) {
            createSections();
        }
        UpgradeContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.setTaskLoading(AppHolder.getInstance().isCheckForUpgrading());
        }
        if (DataManager.getInstance().getDownloadTaskCount() > 0) {
            z = true;
        }
        this.isUpgrading = z;
        initData();
        EventBus.getDefault().register(this);
    }

    private void createSections() {
        UpgradeContract.Presenter presenter2;
        int i = 0;
        int i2 = -1;
        for (int i3 = 0; i3 < getDataList().size(); i3++) {
            MobileApp mobileApp = (MobileApp) getDataList().get(i3);
            if (mobileApp.getIgnoreInfo() == null || !mobileApp.getIgnoreInfo().isIgnore()) {
                i++;
            } else if (i2 == -1) {
                i2 = i3;
            }
        }
        if (i2 == -1 && (presenter2 = this.presenter) != null && presenter2.getIgnoreNum() > 0) {
            i2 = i;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UpgradeSection(i));
        if (i2 != -1) {
            arrayList.add(new IgnoreSection(i2, this.presenter.getIgnoreNum(), this.presenter.isContainIgnore()));
        }
        this.adapter.setSections(arrayList);
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowEmptyView() {
        return getDataList().isEmpty() && this.presenter.getIgnoreNum() == 0;
    }

    @Override // com.coolapk.market.view.base.StateEventListFragment, com.coolapk.market.view.base.asynclist.AsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAppEventChanged(AppEvent appEvent) {
        reloadData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDownloadEventChanged(DownloadEvent downloadEvent) {
        boolean z = DataManager.getInstance().getDownloadTaskCount() > 0;
        if (this.isUpgrading != z) {
            this.isUpgrading = z;
            createSections();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCheckForUpgradeEventChanged(CheckForUpgradeEvent checkForUpgradeEvent) {
        this.presenter.setTaskLoading(checkForUpgradeEvent.isLoading);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<MobileApp> list) {
        getDataList().clear();
        getDataList().addAll(list);
        this.adapter.notifyDataSetChanged();
        updateContentUI();
        createSections();
        return false;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return !AppHolder.getInstance().isCheckForUpgrading();
    }

    private class UpgradeSection extends SectionedAdapter.Section {
        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0029: APUT  
          (r0v1 java.lang.String[])
          (1 ??[boolean, int, float, short, byte, char])
          (wrap: java.lang.String : 0x0025: INVOKE  (r6v6 java.lang.String) = (r5v0 com.coolapk.market.view.appmanager.UpgradeFragment), (r6v5 int) type: VIRTUAL call: com.coolapk.market.view.appmanager.UpgradeFragment.getString(int):java.lang.String)
         */
        /* JADX WARNING: Illegal instructions before constructor call */
        public UpgradeSection(int i) {
            super(0, 2131558854, r0);
            String[] strArr = new String[3];
            strArr[0] = UpgradeFragment.this.getString(2131887121, Integer.valueOf(i));
            strArr[1] = UpgradeFragment.this.getString(UpgradeFragment.this.isUpgrading ? 2131886699 : 2131887118);
            strArr[2] = UpgradeFragment.this.getString(2131886916);
        }

        public void onClick(RecyclerView.ViewHolder viewHolder, View view) {
            DownloadState findLatestDownloadState;
            switch (view.getId()) {
                case 2131363065:
                    if (UpgradeFragment.this.isUpgrading) {
                        for (MobileApp mobileApp : DataManager.getInstance().getMobileAppUpgradeListFast(false)) {
                            if (!(mobileApp.getUpgradeInfo() == null || (findLatestDownloadState = StateUtils.findLatestDownloadState(mobileApp.getUpgradeInfo().getDownloadUrlMd5(0), mobileApp.getUpgradeInfo().getDownloadUrlMd5(1))) == null || !findLatestDownloadState.isRunning())) {
                                ActionManager.stopDownload(UpgradeFragment.this.getActivity(), findLatestDownloadState.getUrl());
                            }
                        }
                        return;
                    } else if (ActionManager.shouldAskUserDownloadIntent()) {
                        WifiDownloadIntentDialog.newInstance().show(UpgradeFragment.this.getChildFragmentManager(), (String) null);
                        return;
                    } else {
                        UpgradeFragment.this.upgradeAll();
                        return;
                    }
                case 2131363066:
                    DataManager.getInstance().ignoreAllUpgrade();
                    UpgradeFragment.this.reloadData();
                    return;
                default:
                    return;
            }
        }
    }

    public void upgradeAll() {
        for (MobileApp mobileApp : DataManager.getInstance().getMobileAppUpgradeListFast(false)) {
            if (mobileApp.getUpgradeInfo() != null) {
                DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(mobileApp.getUpgradeInfo().getDownloadUrlMd5(0), mobileApp.getUpgradeInfo().getDownloadUrlMd5(1));
                if (findLatestDownloadState == null || !findLatestDownloadState.isSuccess()) {
                    ActionManager.startDownload((Context) getActivity(), mobileApp, mobileApp.getUpgradeInfo().getDownloadUrlTypeSmart(), 0, true);
                } else {
                    ActionManager.install(getActivity(), findLatestDownloadState.getFilePath(), findLatestDownloadState.getUrl(), findLatestDownloadState.getExtra());
                }
            }
        }
    }

    public static class WifiDownloadIntentDialog extends BaseDialogFragment {
        public static WifiDownloadIntentDialog newInstance() {
            return new WifiDownloadIntentDialog();
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return new AlertDialog.Builder(getActivity()).setMessage(2131886953).setPositiveButton(2131886162, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.appmanager.UpgradeFragment.WifiDownloadIntentDialog.AnonymousClass3 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ((UpgradeFragment) WifiDownloadIntentDialog.this.getParentFragment()).upgradeAll();
                }
            }).setNeutralButton("不再提示", new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.appmanager.UpgradeFragment.WifiDownloadIntentDialog.AnonymousClass2 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DataManager.getInstance().getPreferencesEditor().putBoolean("download_only_when_wifi", false).apply();
                    ((UpgradeFragment) WifiDownloadIntentDialog.this.getParentFragment()).upgradeAll();
                }
            }).setNegativeButton(2131886140, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.appmanager.UpgradeFragment.WifiDownloadIntentDialog.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).create();
        }
    }

    private class IgnoreSection extends SectionedAdapter.Section {
        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002f: APUT  
          (r0v1 java.lang.String[])
          (2 ??[int, float, short, byte, char])
          (wrap: java.lang.String : 0x002a: INVOKE  (r5v1 java.lang.String) = (r5v0 com.coolapk.market.view.appmanager.UpgradeFragment), (r7v6 int) type: VIRTUAL call: com.coolapk.market.view.appmanager.UpgradeFragment.getString(int):java.lang.String)
         */
        /* JADX WARNING: Illegal instructions before constructor call */
        public IgnoreSection(int i, int i2, boolean z) {
            super(i, 2131558854, r0);
            String[] strArr = new String[3];
            strArr[0] = UpgradeFragment.this.getString(2131886918, Integer.valueOf(i2));
            strArr[1] = UpgradeFragment.this.getString(2131886698);
            strArr[2] = UpgradeFragment.this.getString(z ? 2131886897 : 2131887047);
        }

        public void onClick(RecyclerView.ViewHolder viewHolder, View view) {
            switch (view.getId()) {
                case 2131363065:
                    DataManager.getInstance().cancelAllIgnore();
                    UpgradeFragment.this.reloadData();
                    return;
                case 2131363066:
                    UpgradeFragment.this.presenter.setContainIgnore(!UpgradeFragment.this.presenter.isContainIgnore());
                    UpgradeFragment.this.reloadData();
                    return;
                default:
                    return;
            }
        }
    }

    private class MySectionedAdapter extends SectionedAdapter {
        public MySectionedAdapter(RecyclerView.Adapter adapter) {
            super(adapter);
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public RecyclerView.ViewHolder onCreateSectionViewHolder(ViewGroup viewGroup, int i) {
            return new OptionsTitleSectionViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), new ItemActionHandler() {
                /* class com.coolapk.market.view.appmanager.UpgradeFragment.MySectionedAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                        SectionedAdapter.Section section = MySectionedAdapter.this.getSection(viewHolder.getAdapterPosition());
                        if (section instanceof UpgradeSection) {
                            ((UpgradeSection) section).onClick(viewHolder, view);
                        } else if (section instanceof IgnoreSection) {
                            ((IgnoreSection) section).onClick(viewHolder, view);
                        }
                    }
                }
            });
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public void onBindSectionViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((BindingViewHolder) viewHolder).bindTo(getSection(i));
        }
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private HashMap<String, Boolean> collapsedStatus = new HashMap<>();
        private FragmentBindingComponent component;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558972;
        }

        public DataAdapter(Fragment fragment) {
            this.component = new FragmentBindingComponent(fragment);
            setHasStableIds(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new UpgradeViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), this.component, this.collapsedStatus, new ItemActionHandler() {
                /* class com.coolapk.market.view.appmanager.UpgradeFragment.DataAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                        MobileApp mobileApp = (MobileApp) UpgradeFragment.this.getDataList().get(UpgradeFragment.this.adapter.sectionedPositionToPosition(viewHolder.getAdapterPosition()));
                        int id = view.getId();
                        if (id != 2131361887) {
                            if (id == 2131362779) {
                                ActionManager.startAppViewActivity(UpgradeFragment.this.getActivity(), mobileApp.getPackageName());
                            } else if (id == 2131362982) {
                                String appName = mobileApp.getAppName();
                                final String packageName = mobileApp.getPackageName();
                                new OptionPopupMenu(UpgradeFragment.this.getActivity(), UpgradeFragment.this.getChildFragmentManager(), view, 2131623972, appName, packageName, mobileApp.getVersionName(), mobileApp.getVersionCode(), mobileApp.getApkPath(), new PopupMenu.OnMenuItemClickListener() {
                                    /* class com.coolapk.market.view.appmanager.UpgradeFragment.DataAdapter.AnonymousClass1.AnonymousClass1 */

                                    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        switch (menuItem.getItemId()) {
                                            case 2131361915:
                                                DataManager.getInstance().ignoreUpgrade(packageName, 1);
                                                return true;
                                            case 2131361916:
                                                DataManager.getInstance().ignoreUpgrade(packageName, -1);
                                                return true;
                                            default:
                                                return false;
                                        }
                                    }
                                }).show();
                            }
                        } else if (mobileApp.getIgnoreInfo() != null && mobileApp.getIgnoreInfo().getType() != 0) {
                            DataManager.getInstance().cancelIgnoreUpgrade(mobileApp.getPackageName());
                        } else if (mobileApp.getUpgradeInfo() != null) {
                            StateUtils.handleClick(UpgradeFragment.this.getActivity(), ClickInfo.newBuilder(mobileApp).packageName(mobileApp.getPackageName()).targetUrl(mobileApp.getUpgradeInfo().getDownloadUrlSmart()).downloadKeys(mobileApp.getUpgradeInfo().getDownloadUrlMd5(0), mobileApp.getUpgradeInfo().getDownloadUrlMd5(1)).build(), view);
                        }
                    }
                }
            });
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(UpgradeFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return UpgradeFragment.this.getDataList().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return ((MobileApp) UpgradeFragment.this.getDataList().get(i)).getDbId();
        }
    }
}
