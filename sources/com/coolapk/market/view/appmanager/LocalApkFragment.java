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
import com.coolapk.market.event.AppEvent;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.InstallState;
import com.coolapk.market.model.LocalApk;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.appmanager.LocalApkContract;
import com.coolapk.market.view.appmanager.LocalApkFragment;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.view.base.asynclist.AsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.LocalApkViewHolder;
import com.coolapk.market.viewholder.OptionsTitleSectionViewHolder;
import com.coolapk.market.widget.SectionedAdapter;
import com.coolapk.market.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class LocalApkFragment extends AsyncListFragment<List<LocalApk>, LocalApk> implements LocalApkContract.View {
    private MySectionedAdapter adapter;

    public static LocalApkFragment newInstance() {
        Bundle bundle = new Bundle();
        LocalApkFragment localApkFragment = new LocalApkFragment();
        localApkFragment.setArguments(bundle);
        return localApkFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setEmptyData(getString(2131886830), 0);
        setLoadMoreEnable(false);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        getRecyclerView().setClipToPadding(false);
        getRecyclerView().setClipChildren(false);
        ViewExtents2Kt.tryListenWindowsInset(view, new Function1<Rect, Unit>() {
            /* class com.coolapk.market.view.appmanager.LocalApkFragment.AnonymousClass1 */

            public Unit invoke(Rect rect) {
                LocalApkFragment.this.getRecyclerView().setPadding(0, 0, 0, rect.bottom);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setNotifyAdapter(false);
        setAdapter(new DataAdapter(this));
        this.adapter = new MySectionedAdapter(getRecyclerView().getAdapter());
        getRecyclerView().setAdapter(this.adapter);
        if (bundle != null) {
            updateSections();
        }
        if (getUserVisibleHint()) {
            initData();
        }
        EventBus.getDefault().register(this);
    }

    /* access modifiers changed from: private */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0027: APUT  
      (r3v1 java.lang.String[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.String : 0x0023: INVOKE  (r0v4 java.lang.String) = 
      (r7v0 'this' com.coolapk.market.view.appmanager.LocalApkFragment A[IMMUTABLE_TYPE, THIS])
      (2131886929 int)
      (r5v0 java.lang.Object[])
     type: VIRTUAL call: com.coolapk.market.view.appmanager.LocalApkFragment.getString(int, java.lang.Object[]):java.lang.String)
     */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001e: APUT  
      (r5v0 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Integer : 0x001a: INVOKE  (r0v2 java.lang.Integer) = (r0v1 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    public void updateSections() {
        List dataList = getDataList();
        ArrayList arrayList = new ArrayList();
        String[] strArr = new String[3];
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(dataList != null ? dataList.size() : 0);
        strArr[0] = getString(2131886929, objArr);
        strArr[1] = getString(2131886755);
        strArr[2] = null;
        arrayList.add(new SectionedAdapter.Section(0, 2131558854, strArr));
        this.adapter.setSections(arrayList);
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<LocalApk> list) {
        getDataList().clear();
        getDataList().addAll(list);
        getRecyclerView().getAdapter().notifyDataSetChanged();
        updateContentUI();
        updateSections();
        return false;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAppEventChanged(AppEvent appEvent) {
        getRecyclerView().getAdapter().notifyDataSetChanged();
    }

    private class MySectionedAdapter extends SectionedAdapter {
        public MySectionedAdapter(RecyclerView.Adapter adapter) {
            super(adapter);
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public RecyclerView.ViewHolder onCreateSectionViewHolder(ViewGroup viewGroup, int i) {
            return new OptionsTitleSectionViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), new ItemActionHandler() {
                /* class com.coolapk.market.view.appmanager.LocalApkFragment.MySectionedAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    if (view.getId() == 2131363065) {
                        DeleteConfirmDialog.newInstance().show(LocalApkFragment.this.getChildFragmentManager(), (String) null);
                    }
                }
            });
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public void onBindSectionViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((BindingViewHolder) viewHolder).bindTo(getSection(i));
        }
    }

    /* access modifiers changed from: private */
    public void deleteAllApk() {
        int i = 0;
        for (int size = getDataList().size() - 1; size >= 0; size--) {
            LocalApk localApk = (LocalApk) getDataList().get(size);
            if (new File(localApk.getFilePath()).delete()) {
                i = (int) (((long) i) + localApk.getApkLength());
                getDataList().remove(size);
            }
        }
        Toast.show(getActivity(), getString(2131887273, StringUtils.formatSize((long) i)));
        getRecyclerView().getAdapter().notifyDataSetChanged();
        updateSections();
    }

    private class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private FragmentBindingComponent component;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558818;
        }

        public DataAdapter(Fragment fragment) {
            this.component = new FragmentBindingComponent(fragment);
            setHasStableIds(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new LocalApkViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), this.component, new ItemActionHandler() {
                /* class com.coolapk.market.view.appmanager.LocalApkFragment.DataAdapter.AnonymousClass1 */

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                    super.onItemClick(viewHolder, view);
                    if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                        final LocalApk localApk = (LocalApk) LocalApkFragment.this.getDataList().get(LocalApkFragment.this.adapter.sectionedPositionToPosition(viewHolder.getAdapterPosition()));
                        int id = view.getId();
                        if (id == 2131361887) {
                            InstallState installState = DataManager.getInstance().getInstallState(localApk.getFilePathMd5());
                            if (installState != null) {
                                switch (installState.getState()) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                        return;
                                }
                            }
                            ActionManager.install(LocalApkFragment.this.getActivity(), localApk.getFilePath(), null, null);
                        } else if (id == 2131362779) {
                            ActionManager.startAppViewActivity(LocalApkFragment.this.getActivity(), localApk.getPackageName());
                        } else if (id == 2131362982) {
                            String appName = localApk.getAppName();
                            String packageName = localApk.getPackageName();
                            String versionName = localApk.getVersionName();
                            int versionCode = localApk.getVersionCode();
                            final String filePath = localApk.getFilePath();
                            new OptionPopupMenu(LocalApkFragment.this.getActivity(), LocalApkFragment.this.getChildFragmentManager(), view, 2131623946, appName, packageName, versionName, versionCode, filePath, new PopupMenu.OnMenuItemClickListener() {
                                /* class com.coolapk.market.view.appmanager.LocalApkFragment.DataAdapter.AnonymousClass1.AnonymousClass1 */

                                @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    if (menuItem.getItemId() != 2131361892) {
                                        return false;
                                    }
                                    if (new File(filePath).delete()) {
                                        int size = LocalApkFragment.this.getDataList().size() - 1;
                                        while (true) {
                                            if (size < 0) {
                                                break;
                                            } else if (TextUtils.equals(((LocalApk) LocalApkFragment.this.getDataList().get(size)).getFilePathMd5(), localApk.getFilePathMd5())) {
                                                LocalApkFragment.this.getDataList().remove(size);
                                                LocalApkFragment.this.getRecyclerView().getAdapter().notifyDataSetChanged();
                                                LocalApkFragment.this.updateSections();
                                                break;
                                            } else {
                                                size--;
                                            }
                                        }
                                    } else {
                                        Toast.show(LocalApkFragment.this.getActivity(), 2131887255);
                                    }
                                    return true;
                                }
                            }).show();
                        }
                    }
                }

                @Override // com.coolapk.market.viewholder.ItemActionHandler
                public boolean onItemLongClick(RecyclerView.ViewHolder viewHolder, View view) {
                    return super.onItemLongClick(viewHolder, view);
                }
            });
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            bindingViewHolder.bindTo(LocalApkFragment.this.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return LocalApkFragment.this.getDataList().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return (long) ((LocalApk) LocalApkFragment.this.getDataList().get(i)).getPackageNameHashCode();
        }
    }

    public static class DeleteConfirmDialog extends BaseDialogFragment {
        static /* synthetic */ void lambda$onCreateDialog$1(DialogInterface dialogInterface, int i) {
        }

        public static DeleteConfirmDialog newInstance() {
            Bundle bundle = new Bundle();
            DeleteConfirmDialog deleteConfirmDialog = new DeleteConfirmDialog();
            deleteConfirmDialog.setArguments(bundle);
            return deleteConfirmDialog;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return new AlertDialog.Builder(getActivity()).setMessage(2131886780).setPositiveButton(2131886162, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.appmanager.$$Lambda$LocalApkFragment$DeleteConfirmDialog$YuRRIbzQwbqkqbSsexLj3LREzc */

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    LocalApkFragment.DeleteConfirmDialog.this.lambda$onCreateDialog$0$LocalApkFragment$DeleteConfirmDialog(dialogInterface, i);
                }
            }).setNegativeButton(2131886140, $$Lambda$LocalApkFragment$DeleteConfirmDialog$Wg_qZGnV5mqB4KFmSY2WTCHrOc.INSTANCE).create();
        }

        public /* synthetic */ void lambda$onCreateDialog$0$LocalApkFragment$DeleteConfirmDialog(DialogInterface dialogInterface, int i) {
            ((LocalApkFragment) getParentFragment()).deleteAllApk();
        }
    }
}
