package com.coolapk.market.view.appmanager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.event.DownloadEvent;
import com.coolapk.market.event.DownloadInfoEvent;
import com.coolapk.market.event.InstallEvent;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.DownloadInfo;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.InstallState;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.appmanager.DownloadManagerContract;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.view.base.StateEventListFragment;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.DownloadViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.OptionsTitleSectionViewHolder;
import com.coolapk.market.viewholder.TitleSectionViewHolder;
import com.coolapk.market.widget.SectionedAdapter;
import com.coolapk.market.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DownloadManagerFragment extends StateEventListFragment<List<DownloadInfo>, DownloadInfo> implements DownloadManagerContract.View {
    private MySectionedAdapter adapter;
    private boolean isDownloading;

    public static DownloadManagerFragment newInstance() {
        Bundle bundle = new Bundle();
        DownloadManagerFragment downloadManagerFragment = new DownloadManagerFragment();
        downloadManagerFragment.setArguments(bundle);
        return downloadManagerFragment;
    }

    @Override // com.coolapk.market.view.base.StateEventListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setEmptyData(getString(2131886828), 0);
        setNotifyAdapter(false);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        getRecyclerView().setClipToPadding(false);
        getRecyclerView().setClipChildren(false);
        ViewExtents2Kt.tryListenWindowsInset(view, new Function1<Rect, Unit>() {
            /* class com.coolapk.market.view.appmanager.DownloadManagerFragment.AnonymousClass1 */

            public Unit invoke(Rect rect) {
                DownloadManagerFragment.this.getRecyclerView().setPadding(0, 0, 0, rect.bottom);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setAdapter(new DataAdapter(this));
        this.adapter = new MySectionedAdapter(getRecyclerView().getAdapter());
        getRecyclerView().setAdapter(this.adapter);
        this.isDownloading = DataManager.getInstance().getDownloadTaskCount() > 0;
        if (bundle != null) {
            createSections();
        }
        initData();
        EventBus.getDefault().register(this);
    }

    private void createSections() {
        List dataList = getDataList();
        ArrayList arrayList = new ArrayList();
        long j = 0;
        for (int i = 0; i < dataList.size(); i++) {
            long createTime = ((DownloadInfo) dataList.get(i)).getCreateTime();
            int findTheDay = findTheDay(createTime);
            if (j == 0) {
                arrayList.add(new DownloadSection(createTime));
            } else if (((long) findTheDay) != j) {
                arrayList.add(new SectionedAdapter.Section(i, 2131558964, getDownloadTimeDescription(createTime)));
            }
            j = (long) findTheDay;
        }
        this.adapter.setSections(arrayList);
    }

    @Override // com.coolapk.market.view.base.StateEventListFragment, com.coolapk.market.view.base.asynclist.AsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onInstallEventChanged(InstallEvent installEvent) {
        InstallState installState = installEvent.installState;
        if (installState != null && installState.isComplete()) {
            reloadData();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDownloadEventChanged(DownloadEvent downloadEvent) {
        boolean z = false;
        boolean z2 = DataManager.getInstance().getDownloadTaskCount() > 0;
        if (this.isDownloading != z2) {
            this.isDownloading = z2;
            createSections();
        }
        DownloadState downloadState = DataManager.getInstance().getDownloadState(downloadEvent.key);
        if (downloadState != null && downloadState.getState() == 1) {
            Iterator it2 = getDataList().iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (TextUtils.equals(((DownloadInfo) it2.next()).getUrlMd5(), downloadEvent.key)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                reloadData();
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDownloadInfoChanged(DownloadInfoEvent downloadInfoEvent) {
        reloadData();
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<DownloadInfo> list) {
        getDataList().clear();
        getDataList().addAll(list);
        getRecyclerView().getAdapter().notifyDataSetChanged();
        updateContentUI();
        createSections();
        return false;
    }

    private int findTheDay(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        int i = (currentTimeMillis > 86400000 ? 1 : (currentTimeMillis == 86400000 ? 0 : -1));
        if (i < 0) {
            return 1;
        }
        return (i < 0 || currentTimeMillis >= 172800000) ? 3 : 2;
    }

    public String getDownloadTimeDescription(long j) {
        int findTheDay = findTheDay(j);
        if (findTheDay == 1) {
            return getActivity().getString(2131886817);
        }
        if (findTheDay != 2) {
            return getActivity().getString(2131886816);
        }
        return getActivity().getString(2131886815);
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    private class DownloadSection extends SectionedAdapter.Section {
        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001e: APUT  
          (r0v1 java.lang.String[])
          (1 ??[boolean, int, float, short, byte, char])
          (wrap: java.lang.String : 0x0019: INVOKE  (r4v4 java.lang.String) = (r3v0 com.coolapk.market.view.appmanager.DownloadManagerFragment), (r4v3 int) type: VIRTUAL call: com.coolapk.market.view.appmanager.DownloadManagerFragment.getString(int):java.lang.String)
         */
        /* JADX WARNING: Illegal instructions before constructor call */
        public DownloadSection(long j) {
            super(0, 2131558854, r0);
            String[] strArr = new String[3];
            strArr[0] = DownloadManagerFragment.this.getDownloadTimeDescription(j);
            strArr[1] = DownloadManagerFragment.this.getString(DownloadManagerFragment.this.isDownloading ? 2131886696 : 2131886743);
            strArr[2] = DownloadManagerFragment.this.getString(2131886755);
        }

        public void onClick(RecyclerView.ViewHolder viewHolder, View view) {
            switch (view.getId()) {
                case 2131363065:
                    if (DownloadManagerFragment.this.isDownloading) {
                        Iterator it2 = DownloadManagerFragment.this.getDataList().iterator();
                        while (it2.hasNext()) {
                            DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(((DownloadInfo) it2.next()).getUrlMd5());
                            if (findLatestDownloadState != null && findLatestDownloadState.isRunning()) {
                                ActionManager.stopDownload(DownloadManagerFragment.this.getActivity(), findLatestDownloadState.getUrl());
                            }
                        }
                        return;
                    }
                    Iterator it3 = DownloadManagerFragment.this.getDataList().iterator();
                    while (it3.hasNext()) {
                        DownloadState findLatestDownloadState2 = StateUtils.findLatestDownloadState(((DownloadInfo) it3.next()).getUrlMd5());
                        if (findLatestDownloadState2 != null && !findLatestDownloadState2.isSuccess()) {
                            ActionManager.startDownload(DownloadManagerFragment.this.getActivity(), findLatestDownloadState2.getUrl(), findLatestDownloadState2.getExtra(), 0);
                        }
                    }
                    return;
                case 2131363066:
                    DeleteDownloadLogConfirmDialog.newInstance().show(DownloadManagerFragment.this.getChildFragmentManager(), (String) null);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void deleteDownloadInfoList() {
        List<DownloadInfo> dataList = getDataList();
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        for (DownloadInfo downloadInfo : dataList) {
            if (!TextUtils.isEmpty(downloadInfo.getApkFilePath())) {
                arrayList2.add(downloadInfo.getApkFilePath());
            }
            DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(downloadInfo.getUrlMd5());
            if (findLatestDownloadState == null || !findLatestDownloadState.isRunning()) {
                arrayList.add(downloadInfo);
                if (findLatestDownloadState != null) {
                    arrayList2.add(findLatestDownloadState.getFilePath());
                }
            }
        }
        if (!arrayList.isEmpty()) {
            DataManager.getInstance().deleteDownloadInfoList(arrayList);
            for (String str : arrayList2) {
                if (!TextUtils.isEmpty(str)) {
                    LogUtils.d("Delete File: %s, %s", Boolean.valueOf(new File(str).delete()), str);
                }
            }
            reloadData();
        }
    }

    /* access modifiers changed from: private */
    public void deleteDownloadInfo(DownloadInfo downloadInfo) {
        ActionManager.stopDownload(getActivity(), downloadInfo.getUrl(), 2);
        if (!TextUtils.isEmpty(downloadInfo.getApkFilePath())) {
            LogUtils.v("File delete: %s, %s", Boolean.valueOf(new File(downloadInfo.getApkFilePath()).delete()), downloadInfo.getFileName());
        }
    }

    public static class DeleteDownloadLogConfirmDialog extends BaseDialogFragment {
        public static DeleteDownloadLogConfirmDialog newInstance() {
            Bundle bundle = new Bundle();
            DeleteDownloadLogConfirmDialog deleteDownloadLogConfirmDialog = new DeleteDownloadLogConfirmDialog();
            deleteDownloadLogConfirmDialog.setArguments(bundle);
            return deleteDownloadLogConfirmDialog;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return new AlertDialog.Builder(getActivity()).setMessage(2131886782).setPositiveButton(2131886162, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.appmanager.DownloadManagerFragment.DeleteDownloadLogConfirmDialog.AnonymousClass2 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    ((DownloadManagerFragment) DeleteDownloadLogConfirmDialog.this.getParentFragment()).deleteDownloadInfoList();
                }
            }).setNegativeButton(2131886140, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.appmanager.DownloadManagerFragment.DeleteDownloadLogConfirmDialog.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).create();
        }
    }

    private class MySectionedAdapter extends SectionedAdapter {
        public MySectionedAdapter(RecyclerView.Adapter adapter) {
            super(adapter);
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public RecyclerView.ViewHolder onCreateSectionViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            if (i == 2131558854) {
                return new OptionsTitleSectionViewHolder(inflate, new ItemActionHandler() {
                    /* class com.coolapk.market.view.appmanager.DownloadManagerFragment.MySectionedAdapter.AnonymousClass1 */

                    @Override // com.coolapk.market.viewholder.ItemActionHandler
                    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                        if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                            ((DownloadSection) MySectionedAdapter.this.getSection(viewHolder.getAdapterPosition())).onClick(viewHolder, view);
                        }
                    }
                });
            }
            if (i == 2131558964) {
                return new TitleSectionViewHolder(inflate);
            }
            throw new RuntimeException("Unknown view type: " + i);
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
            return 2131558681;
        }

        public DataAdapter(Fragment fragment) {
            this.component = new FragmentBindingComponent(fragment);
            setHasStableIds(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new DownloadViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), this.component, new ItemActionHandler() {
                /* class com.coolapk.market.view.appmanager.DownloadManagerFragment.DataAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                        final DownloadInfo downloadInfo = (DownloadInfo) DownloadManagerFragment.this.getDataList().get(DownloadManagerFragment.this.adapter.sectionedPositionToPosition(viewHolder.getAdapterPosition()));
                        int id = view.getId();
                        if (id != 2131361887) {
                            if (id != 2131362779) {
                                if (id != 2131362982 || downloadInfo.getExtra() == null) {
                                    return;
                                }
                                if (downloadInfo.getExtra().getString("PACKAGE_NAME") == null) {
                                    BasePopMenu basePopMenu = new BasePopMenu(DownloadManagerFragment.this.getActivity(), view);
                                    basePopMenu.inflate(2131623947);
                                    basePopMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        /* class com.coolapk.market.view.appmanager.DownloadManagerFragment.DataAdapter.AnonymousClass1.AnonymousClass1 */

                                        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            ConfirmDialog newInstance = ConfirmDialog.newInstance("", "确认要删除下载记录与本地文件么？", " 确认删除", "取消");
                                            newInstance.setOnOkRunnable(new Runnable() {
                                                /* class com.coolapk.market.view.appmanager.DownloadManagerFragment.DataAdapter.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    DownloadManagerFragment.this.deleteDownloadInfo(downloadInfo);
                                                }
                                            });
                                            newInstance.show(DownloadManagerFragment.this.getChildFragmentManager(), (String) null);
                                            return true;
                                        }
                                    });
                                    basePopMenu.show();
                                    return;
                                }
                                final View view2 = viewHolder.itemView;
                                final String string = downloadInfo.getExtra().getString("TITLE");
                                final String string2 = downloadInfo.getExtra().getString("PACKAGE_NAME");
                                String string3 = downloadInfo.getExtra().getString("VERSION_NAME");
                                int i = downloadInfo.getExtra().getInt("VERSION_CODE");
                                String apkFilePath = downloadInfo.getApkFilePath();
                                final String string4 = downloadInfo.getExtra().getString("LOGO");
                                final String string5 = downloadInfo.getExtra().getString("EXTRA_ANALYSIS_DATA");
                                new OptionPopupMenu(DownloadManagerFragment.this.getActivity(), DownloadManagerFragment.this.getChildFragmentManager(), view, 2131623946, string, string2, string3, i, apkFilePath, new PopupMenu.OnMenuItemClickListener() {
                                    /* class com.coolapk.market.view.appmanager.DownloadManagerFragment.DataAdapter.AnonymousClass1.AnonymousClass2 */

                                    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        int itemId = menuItem.getItemId();
                                        if (itemId == 2131361892) {
                                            ConfirmDialog newInstance = ConfirmDialog.newInstance("", "确认要删除下载记录与本地文件么？", " 确认删除", "取消");
                                            newInstance.setOnOkRunnable(new Runnable() {
                                                /* class com.coolapk.market.view.appmanager.DownloadManagerFragment.DataAdapter.AnonymousClass1.AnonymousClass2.AnonymousClass1 */

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    DownloadManagerFragment.this.deleteDownloadInfo(downloadInfo);
                                                }
                                            });
                                            newInstance.show(DownloadManagerFragment.this.getChildFragmentManager(), (String) null);
                                            return true;
                                        } else if (itemId != 2131361982) {
                                            return false;
                                        } else {
                                            ActionManager.startAppForumActivity(DownloadManagerFragment.this.getActivity(), view2.findViewById(2131362683), string2, string4, string, string5);
                                            return true;
                                        }
                                    }
                                }).show();
                            } else if (downloadInfo.getExtra() != null) {
                                String string6 = downloadInfo.getExtra().getString("PACKAGE_NAME");
                                if (!TextUtils.isEmpty(string6)) {
                                    View view3 = viewHolder.itemView;
                                    String string7 = downloadInfo.getExtra().getString("TITLE");
                                    ActionManager.startAppForumActivity(DownloadManagerFragment.this.getActivity(), view3.findViewById(2131362683), string6, downloadInfo.getExtra().getString("LOGO"), string7, downloadInfo.getExtra().getString("EXTRA_ANALYSIS_DATA"));
                                }
                            }
                        } else if (downloadInfo.getExtra() != null) {
                            StateUtils.handleClick(DownloadManagerFragment.this.getActivity(), ClickInfo.newBuilder(downloadInfo).targetUrl(downloadInfo.getUrl()).packageName(downloadInfo.getExtra().getString("PACKAGE_NAME")).downloadKeys(downloadInfo.getUrlMd5()).build(), view);
                        }
                    }
                }
            });
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(DownloadManagerFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return DownloadManagerFragment.this.getDataList().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return ((DownloadInfo) DownloadManagerFragment.this.getDataList().get(i)).getDbId();
        }
    }
}
