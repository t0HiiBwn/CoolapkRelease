package com.coolapk.market.view.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.Extra;
import com.coolapk.market.model.State;
import com.coolapk.market.model.VersionApp;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.app.HistoryVersionContract;
import com.coolapk.market.view.base.StateEventListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.List;

public class HistoryVersionFragment extends StateEventListFragment<List<VersionApp>, VersionApp> implements HistoryVersionContract.View {
    public static final String KEY_APK_ID = "APK_ID";
    public static final String KEY_LOGO = "LOGO";
    private String apkId;
    private String logo;

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.apkId = getArguments().getString("APK_ID");
        this.logo = getArguments().getString("LOGO");
        setPresenter(new HistoryVersionPresenter(this, this.apkId));
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        setEmptyData(getString(2131886766), 0);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        setAdapter(new DataAdapter());
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558983, 2131231052).last(2131231052).create());
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
    public boolean onRequestResponse(boolean z, List<VersionApp> list) {
        if (z) {
            getDataList().clear();
        }
        if (!CollectionUtils.isEmpty(list)) {
            getDataList().addAll(list);
        }
        updateContentUI();
        return false;
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558983;
        }

        private DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new VersionAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558983, viewGroup, false), new ItemActionHandler() {
                /* class com.coolapk.market.view.app.HistoryVersionFragment.DataAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    super.onItemClick(viewHolder, view);
                    if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                        final VersionApp versionApp = (VersionApp) HistoryVersionFragment.this.getDataList().get(viewHolder.getAdapterPosition());
                        StateUtils.handleClick(HistoryVersionFragment.this.getActivity(), ClickInfo.newBuilder(versionApp, HistoryVersionFragment.this.apkId, HistoryVersionFragment.this.logo).packageName(versionApp.getPackageName()).targetUrl(versionApp.getDownloadUrl(HistoryVersionFragment.this.apkId)).downloadKeys(versionApp.getDownloadUrlMd5(HistoryVersionFragment.this.apkId)).clickHandleListener(new ClickInfo.ClickHandleListenerAdapter() {
                            /* class com.coolapk.market.view.app.HistoryVersionFragment.DataAdapter.AnonymousClass1.AnonymousClass1 */

                            @Override // com.coolapk.market.model.ClickInfo.ClickHandleListenerAdapter, com.coolapk.market.model.ClickInfo.ClickHandleListener
                            public boolean onClickHandleNone(State state) {
                                if (state != null) {
                                    return false;
                                }
                                DataAdapter.this.downloadAction(versionApp);
                                return true;
                            }

                            @Override // com.coolapk.market.model.ClickInfo.ClickHandleListenerAdapter, com.coolapk.market.model.ClickInfo.ClickHandleListener
                            public boolean onClickHandleOpen(State state) {
                                DataAdapter.this.downloadAction(versionApp);
                                return true;
                            }
                        }).build(), view);
                    }
                }
            }, HistoryVersionFragment.this.apkId);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(HistoryVersionFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return HistoryVersionFragment.this.getDataList().size();
        }

        /* access modifiers changed from: private */
        public void downloadAction(VersionApp versionApp) {
            Extra extra = new Extra();
            extra.put("TITLE", versionApp.getAppName());
            extra.put("PACKAGE_NAME", versionApp.getPackageName());
            extra.put("VERSION_NAME", versionApp.getVersionName());
            extra.put("VERSION_CODE", 0);
            extra.put("APK_SIZE", versionApp.getVersionSize());
            extra.put("LOGO", HistoryVersionFragment.this.logo);
            extra.put("APK_ID", HistoryVersionFragment.this.apkId);
            extra.put("VERSION_ID", versionApp.getVersionId());
            extra.put("DOWNLOAD_FROM", versionApp.getDownloadFrom());
            ActionManager.startDownload(HistoryVersionFragment.this.getActivity(), versionApp.getDownloadUrl(HistoryVersionFragment.this.apkId), extra, 1);
        }
    }
}
