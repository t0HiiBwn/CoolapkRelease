package com.coolapk.market.view.backupList;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.databinding.Bindable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemBackAppSwitchBinding;
import com.coolapk.market.event.AppEvent;
import com.coolapk.market.event.LoadMobileAppEvent;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.view.appmanager.MobileAppFragment;
import com.coolapk.market.view.backupList.BackupMobileAppContract;
import com.coolapk.market.view.base.StateEventListFragment;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.SectionedAdapter;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class BackupMobileAppFragment extends StateEventListFragment<List<MobileApp>, MobileApp> implements BackupMobileAppContract.View {
    private TitleAdapter adapter;
    private HashMap<String, String> appMap = new HashMap<>();
    private String backupTitle;
    private boolean menuState = true;
    private BackupMobileAppContract.Presenter presenter;

    public static MobileAppFragment newInstance() {
        Bundle bundle = new Bundle();
        MobileAppFragment mobileAppFragment = new MobileAppFragment();
        mobileAppFragment.setArguments(bundle);
        return mobileAppFragment;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        getActivity().setTitle(getString(2131887348));
        this.backupTitle = getArguments().getString("TITLE_BACKUP");
    }

    @Override // com.coolapk.market.view.base.StateEventListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setEmptyData(getString(2131886831), 0);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558819, 2131231062).type(2131558622, 2131231062).last(2131231062).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    public void setPresenter(AsyncListContract.Presenter presenter2) {
        super.setPresenter(presenter2);
        this.presenter = (BackupMobileAppContract.Presenter) presenter2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<MobileApp> parcelableArrayList;
        if (this.presenter == null) {
            setPresenter(new BackupMobileAppPresenter(this));
        }
        super.onActivityCreated(bundle);
        setNotifyAdapter(false);
        setAdapter(new DataAdapter(this));
        this.adapter = new TitleAdapter(getRecyclerView().getAdapter());
        getRecyclerView().setAdapter(this.adapter);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SectionedAdapter.Section(0, 2131558622, this.presenter));
        this.adapter.setSections(arrayList);
        this.presenter.setTaskLoading(AppHolder.getInstance().isMobileAppLoading());
        if (!(bundle == null || (parcelableArrayList = bundle.getParcelableArrayList("apps")) == null)) {
            for (MobileApp mobileApp : parcelableArrayList) {
                this.appMap.put(mobileApp.getPackageName(), mobileApp.getAppName());
            }
        }
        initData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            menu.add(0, 2131361966, 100, "全选").setShowAsAction(2);
            menu.add(0, 2131361900, 101, "创建").setShowAsAction(2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131361900) {
            Intent intent = new Intent();
            intent.putExtra("app_json", getJson());
            intent.putExtra("TITLE_BACKUP", this.backupTitle);
            getActivity().setResult(-1, intent);
            getActivity().finish();
            return true;
        } else if (itemId != 2131361966) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            onSelectAll(this.menuState);
            boolean z = !this.menuState;
            this.menuState = z;
            menuItem.setTitle(z ? 2131886648 : 2131886646);
            return true;
        }
    }

    private String getJson() {
        return new Gson().toJson(this.appMap);
    }

    private void onSelectAll(boolean z) {
        for (int i = 0; i < this.dataList.size(); i++) {
            MobileApp mobileApp = (MobileApp) this.dataList.get(i);
            if (z && !this.appMap.containsKey(mobileApp.getPackageName())) {
                this.appMap.put(mobileApp.getPackageName(), mobileApp.getAppName());
                getRecyclerView().getAdapter().notifyItemChanged(i);
            } else if (!z && this.appMap.containsKey(mobileApp.getPackageName())) {
                this.appMap.remove(mobileApp.getPackageName());
                getRecyclerView().getAdapter().notifyItemChanged(i);
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.appMap != null) {
            ArrayList<String> arrayList = new ArrayList<>(this.appMap.size());
            arrayList.addAll(this.appMap.keySet());
            bundle.putStringArrayList("apps", arrayList);
        }
    }

    @Override // com.coolapk.market.view.base.StateEventListFragment, com.coolapk.market.view.base.asynclist.AsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<MobileApp> list) {
        getDataList().clear();
        getDataList().addAll(list);
        getRecyclerView().getAdapter().notifyDataSetChanged();
        updateContentUI();
        return false;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return !this.presenter.isTaskLoading();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAppEventChanged(AppEvent appEvent) {
        reloadData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoadMobileAppEventChanged(LoadMobileAppEvent loadMobileAppEvent) {
        this.presenter.setTaskLoading(loadMobileAppEvent.isLoading);
    }

    private class TitleAdapter extends SectionedAdapter {
        public TitleAdapter(RecyclerView.Adapter adapter) {
            super(adapter);
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public RecyclerView.ViewHolder onCreateSectionViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558622, viewGroup, false);
            if (i == 2131558622) {
                return new SwitchViewHolder(inflate);
            }
            throw new RuntimeException("Unknown view type " + i);
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
            return 2131558819;
        }

        public DataAdapter(Fragment fragment) {
            this.component = new FragmentBindingComponent(fragment);
            setHasStableIds(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new AppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), this.component, null, BackupMobileAppFragment.this.appMap);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(BackupMobileAppFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return BackupMobileAppFragment.this.getDataList().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return ((MobileApp) BackupMobileAppFragment.this.getDataList().get(i)).getDbId();
        }
    }

    public static class SwitchViewHolder extends BindingViewHolder implements CompoundButton.OnCheckedChangeListener {
        private static final int LAYOUT_ID = 2131558622;
        private BackupMobileAppPresenter presenter;

        public SwitchViewHolder(View view) {
            super(view);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            this.presenter = (BackupMobileAppPresenter) ((SectionedAdapter.Section) obj).getObject();
            ((ItemBackAppSwitchBinding) getBinding()).setVh(this);
        }

        @Bindable
        public boolean isLoading() {
            return this.presenter.isRefreshing() || this.presenter.isLoadingMore();
        }

        @Bindable
        public boolean isChecked() {
            return this.presenter.isShowSystem();
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.presenter.isShowSystem() != z) {
                this.presenter.setShowSystem(z);
                this.presenter.reloadData();
            }
        }
    }
}
