package com.coolapk.market.view.album.pick;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.DialogAlbumMobileappNoteBinding;
import com.coolapk.market.databinding.ItemMobileAlbumAppNewBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.album.AlbumPickAPKViewModel;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.view.base.refresh.LocalDataFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.StateViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class NewAlbumPickFragment extends LocalDataFragment<MobileApp> {
    private final int MAX_ALBUM_NUM = 200;
    private Map<String, AlbumItem> appMap;
    private Album mAlbum;
    private boolean menuState = true;
    private List<String> packageNames = new ArrayList();

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public int getItemViewType(int i) {
        return 2131558828;
    }

    public static NewAlbumPickFragment newInstance(Album album) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("album", album);
        NewAlbumPickFragment newAlbumPickFragment = new NewAlbumPickFragment();
        newAlbumPickFragment.setArguments(bundle);
        return newAlbumPickFragment;
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList parcelableArrayList;
        super.onActivityCreated(bundle);
        getActivity().setTitle(getString(2131887286));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558828, 2131231052).last(2131231052).create());
        getRecyclerView().getItemAnimator().setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        this.mAlbum = (Album) getArguments().getParcelable("album");
        this.appMap = ((AlbumPickAppTabActivity) getActivity()).getCommitApps();
        if (!(bundle == null || (parcelableArrayList = bundle.getParcelableArrayList("albumItems")) == null)) {
            for (int i = 0; i < parcelableArrayList.size(); i++) {
                AlbumItem albumItem = (AlbumItem) parcelableArrayList.get(i);
                this.appMap.put(albumItem.getPackageName(), albumItem);
            }
        }
        initData();
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            menu.add(0, 2131361965, 100, "全选").setShowAsAction(2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131361965) {
            return super.onOptionsItemSelected(menuItem);
        }
        onSelectAll(this.menuState);
        boolean z = !this.menuState;
        this.menuState = z;
        menuItem.setTitle(z ? 2131886586 : 2131886584);
        return true;
    }

    public void onSelectAll(boolean z) {
        for (int i = 0; i < getDataList().size(); i++) {
            if (!z || 200 - this.appMap.size() > this.mAlbum.getTotalApkNum()) {
                MobileApp mobileApp = (MobileApp) getDataList().get(i);
                AlbumItem createNewAlbumItem = AlbumItem.createNewAlbumItem(mobileApp);
                if (z && !this.appMap.containsKey(createNewAlbumItem.getPackageName()) && !mobileApp.isSystemApp()) {
                    this.appMap.put(createNewAlbumItem.getPackageName(), createNewAlbumItem);
                    getRecyclerView().getAdapter().notifyItemChanged(i);
                } else if (!z && this.appMap.containsKey(createNewAlbumItem.getPackageName()) && !mobileApp.isSystemApp()) {
                    this.appMap.remove(createNewAlbumItem.getPackageName());
                    getRecyclerView().getAdapter().notifyItemChanged(i);
                }
            } else {
                Toast.show(getActivity(), "应用集最多容纳200个应用，以为你取消选中多余的应用");
                return;
            }
        }
    }

    @Override // com.coolapk.market.view.base.refresh.LocalDataFragment
    public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AlbumMobileAPPViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), getComponent(), new ItemActionHandler() {
            /* class com.coolapk.market.view.album.pick.NewAlbumPickFragment.AnonymousClass1 */

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                viewHolder.getAdapterPosition();
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public boolean onItemLongClick(RecyclerView.ViewHolder viewHolder, View view) {
                if (viewHolder.getAdapterPosition() == -1) {
                }
                return false;
            }
        });
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.appMap != null) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.appMap.size());
            arrayList.addAll(this.appMap.values());
            bundle.putParcelableArrayList("albumItems", arrayList);
        }
    }

    @Override // com.coolapk.market.app.InitBehavior
    public void initData() {
        List<MobileApp> mobileAppExistList = DataManager.getInstance().getMobileAppExistList();
        try {
            Collections.sort(mobileAppExistList, new Comparator<MobileApp>() {
                /* class com.coolapk.market.view.album.pick.NewAlbumPickFragment.AnonymousClass2 */

                public int compare(MobileApp mobileApp, MobileApp mobileApp2) {
                    return Long.signum(mobileApp2.getLastUpdateTime() - mobileApp.getLastUpdateTime());
                }
            });
        } catch (Exception e) {
            Toast.error(getActivity(), e);
        }
        this.packageNames = comList(this.mAlbum.getAlbumItems());
        Observable.from(mobileAppExistList).filter(new Func1<MobileApp, Boolean>() {
            /* class com.coolapk.market.view.album.pick.NewAlbumPickFragment.AnonymousClass4 */

            public Boolean call(MobileApp mobileApp) {
                return Boolean.valueOf(CollectionUtils.isEmpty(NewAlbumPickFragment.this.packageNames) || !NewAlbumPickFragment.this.packageNames.contains(mobileApp.getPackageName()));
            }
        }).toList().compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new EmptySubscriber<List<MobileApp>>() {
            /* class com.coolapk.market.view.album.pick.NewAlbumPickFragment.AnonymousClass3 */

            public void onNext(List<MobileApp> list) {
                super.onNext((AnonymousClass3) list);
                NewAlbumPickFragment.this.getDataList().addAll(list);
            }

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
                Toast.error(NewAlbumPickFragment.this.getActivity(), th);
            }
        });
    }

    private List<String> comList(List<AlbumItem> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(list.get(i).getPackageName());
        }
        return arrayList;
    }

    public static class EditDialog extends BaseDialogFragment implements View.OnClickListener {
        private AlbumItem albumItem;
        private Map<String, AlbumItem> appMap;
        private DialogAlbumMobileappNoteBinding binding;
        private MobileApp mMobileApp;
        private String mNote;
        private AlbumPickAPKViewModel viewModel;

        public static EditDialog newInstance(MobileApp mobileApp) {
            EditDialog editDialog = new EditDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("app", mobileApp);
            editDialog.setArguments(bundle);
            return editDialog;
        }

        public void setMap(Map<String, AlbumItem> map) {
            this.appMap = map;
        }

        public void setAlbumAppViewModel(AlbumPickAPKViewModel albumPickAPKViewModel) {
            this.viewModel = albumPickAPKViewModel;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            this.mMobileApp = (MobileApp) getArguments().getParcelable("app");
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            DialogAlbumMobileappNoteBinding dialogAlbumMobileappNoteBinding = (DialogAlbumMobileappNoteBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558514, null, false);
            this.binding = dialogAlbumMobileappNoteBinding;
            dialogAlbumMobileappNoteBinding.setApp(this.mMobileApp);
            AlbumItem albumItem2 = this.appMap.get(this.mMobileApp.getPackageName());
            this.albumItem = albumItem2;
            if (albumItem2 != null) {
                this.binding.apkNoteEditView.setText(TextUtils.isEmpty(this.albumItem.getNote()) ? "" : this.appMap.get(this.mMobileApp.getPackageName()).getNote());
                this.binding.apkNoteEditView.setSelection(this.binding.apkNoteEditView.getText().toString().length());
            }
            this.binding.ok.setTextColor(AppHolder.getAppTheme().getColorAccent());
            ViewUtil.clickListener(this.binding.ok, this);
            ViewUtil.clickListener(this.binding.cacel, this);
            return builder.setView(this.binding.getRoot()).create();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == 2131362192) {
                dismiss();
            } else if (id == 2131363036) {
                String obj = this.binding.apkNoteEditView.getText().toString();
                this.mNote = obj;
                this.viewModel.setPickAppNote(obj);
                AlbumItem build = AlbumItem.builder().setPackageName(this.mMobileApp.getPackageName()).setTitle(this.mMobileApp.getAppName()).setNote(this.mNote).setVersionCode(0).setDisplayOrder(1).build();
                if (this.appMap.containsKey(this.mMobileApp.getPackageName())) {
                    this.appMap.remove(build.getPackageName());
                    this.appMap.put(build.getPackageName(), build);
                }
                dismiss();
            }
        }
    }

    public class AlbumMobileAPPViewHolder extends StateViewHolder implements CompoundButton.OnCheckedChangeListener {
        public static final int LAYOUT_ID = 2131558828;
        private AlbumItem albumItem;
        private MobileApp app;
        private String appNote;
        private ItemMobileAlbumAppNewBinding binding;
        private CheckBox checkBox;
        private boolean hasTarget;
        private boolean isCheck;
        private String target;
        private final AlbumPickAPKViewModel viewModel = new AlbumPickAPKViewModel();

        public AlbumMobileAPPViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
        }

        @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
        public boolean onStateEventChanged(Event event) {
            return isEventBelongTo(event, this.app);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            String str;
            MobileApp mobileApp = (MobileApp) obj;
            this.app = mobileApp;
            this.viewModel.setPickApp(mobileApp);
            ItemMobileAlbumAppNewBinding itemMobileAlbumAppNewBinding = (ItemMobileAlbumAppNewBinding) getBinding();
            this.binding = itemMobileAlbumAppNewBinding;
            this.checkBox = itemMobileAlbumAppNewBinding.mobileAppCheckView;
            boolean containsKey = NewAlbumPickFragment.this.appMap.containsKey(this.app.getPackageName());
            this.isCheck = containsKey;
            this.viewModel.setCheck(containsKey);
            this.checkBox.setChecked(this.viewModel.getIsCheck());
            this.checkBox.setOnCheckedChangeListener(this);
            this.binding.setViewHolder(this);
            this.binding.setApp(this.app);
            this.binding.setViewModel(this.viewModel);
            if (!NewAlbumPickFragment.this.appMap.isEmpty() && NewAlbumPickFragment.this.appMap.containsKey(this.app.getPackageName())) {
                if (TextUtils.isEmpty(((AlbumItem) NewAlbumPickFragment.this.appMap.get(this.app.getPackageName())).getNote())) {
                    str = "点评 " + this.app.getAppName();
                } else {
                    str = ((AlbumItem) NewAlbumPickFragment.this.appMap.get(this.app.getPackageName())).getNote();
                }
                this.appNote = str;
                this.viewModel.setPickAppNote(str);
            }
            ViewUtil.clickListener(this.binding.contentView, new View.OnClickListener() {
                /* class com.coolapk.market.view.album.pick.NewAlbumPickFragment.AlbumMobileAPPViewHolder.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlbumMobileAPPViewHolder albumMobileAPPViewHolder = AlbumMobileAPPViewHolder.this;
                    albumMobileAPPViewHolder.checkBox = albumMobileAPPViewHolder.binding.mobileAppCheckView;
                    AlbumMobileAPPViewHolder.this.checkBox.setChecked(!AlbumMobileAPPViewHolder.this.checkBox.isChecked());
                }
            });
            ViewUtil.clickListener(this.binding.appEditText, new View.OnClickListener() {
                /* class com.coolapk.market.view.album.pick.NewAlbumPickFragment.AlbumMobileAPPViewHolder.AnonymousClass2 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EditDialog newInstance = EditDialog.newInstance(AlbumMobileAPPViewHolder.this.app);
                    newInstance.setAlbumAppViewModel(AlbumMobileAPPViewHolder.this.viewModel);
                    newInstance.setMap(NewAlbumPickFragment.this.appMap);
                    newInstance.show(NewAlbumPickFragment.this.getChildFragmentManager(), (String) null);
                }
            });
            this.binding.executePendingBindings();
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            String str;
            this.isCheck = z;
            if (!UiUtils.isInvalidPosition(getAdapterPosition())) {
                this.viewModel.setCheck(z);
                this.albumItem = AlbumItem.builder().setPackageName(this.app.getPackageName()).setTitle(this.app.getAppName()).setVersionCode(0).setDisplayOrder(1).build();
                this.target = this.app.getPackageName();
                boolean containsKey = NewAlbumPickFragment.this.appMap.containsKey(this.target);
                this.hasTarget = containsKey;
                if (z && !containsKey) {
                    NewAlbumPickFragment.this.appMap.put(this.app.getPackageName(), this.albumItem);
                } else if (!z && containsKey) {
                    NewAlbumPickFragment.this.appMap.remove(this.app.getPackageName());
                }
                if (!NewAlbumPickFragment.this.appMap.isEmpty() && NewAlbumPickFragment.this.appMap.containsKey(this.app.getPackageName())) {
                    if (TextUtils.isEmpty(((AlbumItem) NewAlbumPickFragment.this.appMap.get(this.app.getPackageName())).getNote())) {
                        str = "点评 " + this.app.getAppName();
                    } else {
                        str = ((AlbumItem) NewAlbumPickFragment.this.appMap.get(this.app.getPackageName())).getNote();
                    }
                    this.viewModel.setPickAppNote(str);
                }
            }
        }
    }
}
