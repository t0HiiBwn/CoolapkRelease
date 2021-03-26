package com.coolapk.market.view.appmanager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.appcompat.view.ActionMode;
import androidx.databinding.Bindable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.selection.SelectionPredicates;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemMobileAppSwitchBinding;
import com.coolapk.market.event.AppEvent;
import com.coolapk.market.event.LoadMobileAppEvent;
import com.coolapk.market.event.MobileAppShowSystemEvent;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.view.appmanager.MobileAppContract;
import com.coolapk.market.view.base.StateEventListFragment;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.MobileAppViewHolder;
import com.coolapk.market.widget.SectionedAdapter;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 22\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00071234567B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0014J\u001e\u0010'\u001a\u00020 2\u0006\u0010$\u001a\u00020 2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0012H\u0016J\u001a\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020/H\u0016J\b\u00100\u001a\u00020 H\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppFragment;", "Lcom/coolapk/market/view/base/StateEventListFragment;", "", "Lcom/coolapk/market/model/MobileApp;", "Lcom/coolapk/market/view/appmanager/MobileAppContract$View;", "()V", "actionMode", "Landroidx/appcompat/view/ActionMode;", "adapter", "Lcom/coolapk/market/view/appmanager/MobileAppFragment$TitleAdapter;", "presenter", "Lcom/coolapk/market/view/appmanager/MobileAppContract$Presenter;", "tracker", "Landroidx/recyclerview/selection/SelectionTracker;", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onAppEventChanged", "event", "Lcom/coolapk/market/event/AppEvent;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onDestroyView", "onLoadMobileAppEventChanged", "Lcom/coolapk/market/event/LoadMobileAppEvent;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onRequestFailure", "isRefresh", "error", "", "onRequestResponse", "mobileApps", "onSaveInstanceState", "outState", "onViewCreated", "view", "Landroid/view/View;", "setPresenter", "Lcom/coolapk/market/view/base/asynclist/AsyncListContract$Presenter;", "shouldShowList", "ActionModeController", "Companion", "DataAdapter", "MyItemDetailsLookup", "MyItemKeyProvider", "SwitchViewHolder", "TitleAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MobileAppFragment.kt */
public final class MobileAppFragment extends StateEventListFragment<List<? extends MobileApp>, MobileApp> implements MobileAppContract.View {
    public static final Companion Companion = new Companion(null);
    private ActionMode actionMode;
    private TitleAdapter adapter;
    private MobileAppContract.Presenter presenter;
    private SelectionTracker<Long> tracker;

    @JvmStatic
    public static final MobileAppFragment newInstance() {
        return Companion.newInstance();
    }

    public static final /* synthetic */ TitleAdapter access$getAdapter$p(MobileAppFragment mobileAppFragment) {
        TitleAdapter titleAdapter = mobileAppFragment.adapter;
        if (titleAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return titleAdapter;
    }

    public static final /* synthetic */ MobileAppContract.Presenter access$getPresenter$p(MobileAppFragment mobileAppFragment) {
        MobileAppContract.Presenter presenter2 = mobileAppFragment.presenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return presenter2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/appmanager/MobileAppFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MobileAppFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MobileAppFragment newInstance() {
            Bundle bundle = new Bundle();
            MobileAppFragment mobileAppFragment = new MobileAppFragment();
            mobileAppFragment.setArguments(bundle);
            return mobileAppFragment;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        SelectionTracker<Long> selectionTracker;
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (bundle != null && (selectionTracker = this.tracker) != null) {
            selectionTracker.onRestoreInstanceState(bundle);
        }
    }

    @Override // com.coolapk.market.view.base.StateEventListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setEmptyData(getString(2131886831), 0);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0);
        }
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipToPadding(false);
        RecyclerView recyclerView3 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
        recyclerView3.setClipChildren(false);
        ViewExtents2Kt.tryListenWindowsInset(view, new MobileAppFragment$onViewCreated$1(this));
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    public void setPresenter(AsyncListContract.Presenter presenter2) {
        Intrinsics.checkNotNullParameter(presenter2, "presenter");
        super.setPresenter(presenter2);
        this.presenter = (MobileAppContract.Presenter) presenter2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (this.presenter == null) {
            setPresenter(new MobileAppPresenter(this));
        }
        super.onActivityCreated(bundle);
        setNotifyAdapter(false);
        setAdapter(new DataAdapter(this, this));
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter2);
        Intrinsics.checkNotNullExpressionValue(adapter2, "recyclerView.adapter!!");
        this.adapter = new TitleAdapter(this, adapter2);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        TitleAdapter titleAdapter = this.adapter;
        if (titleAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(titleAdapter);
        RecyclerView recyclerView3 = getRecyclerView();
        RecyclerView recyclerView4 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "recyclerView");
        RecyclerView recyclerView5 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView5, "recyclerView");
        SelectionTracker<Long> build = new SelectionTracker.Builder("mySelection", recyclerView3, new MyItemKeyProvider(recyclerView4), new MyItemDetailsLookup(recyclerView5), StorageStrategy.createLongStorage()).withSelectionPredicate(SelectionPredicates.createSelectAnything()).build();
        this.tracker = build;
        if (build != null) {
            build.addObserver(new MobileAppFragment$onActivityCreated$2(this));
        }
        ArrayList arrayList = new ArrayList();
        MobileAppContract.Presenter presenter2 = this.presenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        arrayList.add(new SectionedAdapter.Section(0, 2131558837, presenter2));
        TitleAdapter titleAdapter2 = this.adapter;
        if (titleAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        titleAdapter2.setSections(arrayList);
        MobileAppContract.Presenter presenter3 = this.presenter;
        if (presenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        AppHolder instance = AppHolder.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "AppHolder.getInstance()");
        presenter3.setTaskLoading(instance.isMobileAppLoading());
        initData();
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            menuInflater.inflate(2131623960, menu);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        SelectionTracker<Long> selectionTracker = this.tracker;
        if (selectionTracker != null) {
            selectionTracker.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        switch (menuItem.getItemId()) {
            case 2131361971:
                MobileAppContract.Presenter presenter2 = this.presenter;
                if (presenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                presenter2.setSortBy(3);
                MobileAppContract.Presenter presenter3 = this.presenter;
                if (presenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                presenter3.reloadData();
                return true;
            case 2131361972:
                MobileAppContract.Presenter presenter4 = this.presenter;
                if (presenter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                presenter4.setSortBy(1);
                MobileAppContract.Presenter presenter5 = this.presenter;
                if (presenter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                presenter5.reloadData();
                return true;
            case 2131361973:
                MobileAppContract.Presenter presenter6 = this.presenter;
                if (presenter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                presenter6.setSortBy(0);
                MobileAppContract.Presenter presenter7 = this.presenter;
                if (presenter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                presenter7.reloadData();
                return true;
            case 2131361974:
                MobileAppContract.Presenter presenter8 = this.presenter;
                if (presenter8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                presenter8.setSortBy(4);
                MobileAppContract.Presenter presenter9 = this.presenter;
                if (presenter9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                presenter9.reloadData();
                return true;
            case 2131361975:
                MobileAppContract.Presenter presenter10 = this.presenter;
                if (presenter10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                presenter10.setSortBy(2);
                MobileAppContract.Presenter presenter11 = this.presenter;
                if (presenter11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                presenter11.reloadData();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // com.coolapk.market.view.base.StateEventListFragment, com.coolapk.market.view.base.asynclist.AsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<? extends MobileApp> list) {
        Intrinsics.checkNotNullParameter(list, "mobileApps");
        getDataList().clear();
        getDataList().addAll(list);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        if (adapter2 != null) {
            adapter2.notifyDataSetChanged();
        }
        updateContentUI();
        return false;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        MobileAppContract.Presenter presenter2 = this.presenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return !presenter2.isTaskLoading();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onAppEventChanged(AppEvent appEvent) {
        Intrinsics.checkNotNullParameter(appEvent, "event");
        reloadData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onLoadMobileAppEventChanged(LoadMobileAppEvent loadMobileAppEvent) {
        Intrinsics.checkNotNullParameter(loadMobileAppEvent, "event");
        MobileAppContract.Presenter presenter2 = this.presenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        presenter2.setTaskLoading(loadMobileAppEvent.isLoading);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppFragment$TitleAdapter;", "Lcom/coolapk/market/widget/SectionedAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "(Lcom/coolapk/market/view/appmanager/MobileAppFragment;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "onBindSectionViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "sectionedPosition", "", "onCreateSectionViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MobileAppFragment.kt */
    private final class TitleAdapter extends SectionedAdapter {
        final /* synthetic */ MobileAppFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TitleAdapter(MobileAppFragment mobileAppFragment, RecyclerView.Adapter<?> adapter) {
            super(adapter);
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.this$0 = mobileAppFragment;
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public RecyclerView.ViewHolder onCreateSectionViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558837, viewGroup, false);
            if (i == 2131558837) {
                Intrinsics.checkNotNullExpressionValue(inflate, "viewItem");
                return new SwitchViewHolder(inflate);
            }
            throw new RuntimeException("Unknown view type " + i);
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public void onBindSectionViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            ((BindingViewHolder) viewHolder).bindTo(getSection(i));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppFragment$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "fragment", "Landroidx/fragment/app/Fragment;", "(Lcom/coolapk/market/view/appmanager/MobileAppFragment;Landroidx/fragment/app/Fragment;)V", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MobileAppFragment.kt */
    private final class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private final FragmentBindingComponent component;
        final /* synthetic */ MobileAppFragment this$0;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558836;
        }

        public DataAdapter(MobileAppFragment mobileAppFragment, Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.this$0 = mobileAppFragment;
            this.component = new FragmentBindingComponent(fragment);
            setHasStableIds(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "viewItem");
            SelectionTracker selectionTracker = this.this$0.tracker;
            Intrinsics.checkNotNull(selectionTracker);
            return new MobileAppViewHolder(inflate, this.component, selectionTracker, new MobileAppFragment$DataAdapter$onCreateViewHolder$1(this));
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            bindingViewHolder.bindTo(this.this$0.getDataList().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.this$0.getDataList().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            Object obj = this.this$0.getDataList().get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "getDataList()[position]");
            return ((MobileApp) obj).getDbId();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0011\u0010\u0006\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\t\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppFragment$SwitchViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "isChecked", "", "()Z", "isLoading", "presenter", "Lcom/coolapk/market/view/appmanager/MobileAppPresenter;", "bindTo", "", "data", "", "onCheckedChanged", "compoundButton", "Landroid/widget/CompoundButton;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MobileAppFragment.kt */
    public static final class SwitchViewHolder extends BindingViewHolder implements CompoundButton.OnCheckedChangeListener {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558837;
        private MobileAppPresenter presenter;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SwitchViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }

        @Bindable
        public final boolean isLoading() {
            MobileAppPresenter mobileAppPresenter = this.presenter;
            if (mobileAppPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            if (!mobileAppPresenter.isRefreshing()) {
                MobileAppPresenter mobileAppPresenter2 = this.presenter;
                if (mobileAppPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                if (!mobileAppPresenter2.isLoadingMore()) {
                    return false;
                }
            }
            return true;
        }

        @Bindable
        public final boolean isChecked() {
            MobileAppPresenter mobileAppPresenter = this.presenter;
            if (mobileAppPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            return mobileAppPresenter.isShowSystem();
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "data");
            Object object = ((SectionedAdapter.Section) obj).getObject();
            Objects.requireNonNull(object, "null cannot be cast to non-null type com.coolapk.market.view.appmanager.MobileAppPresenter");
            this.presenter = (MobileAppPresenter) object;
            ItemMobileAppSwitchBinding itemMobileAppSwitchBinding = (ItemMobileAppSwitchBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemMobileAppSwitchBinding, "binding");
            itemMobileAppSwitchBinding.setVh(this);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Intrinsics.checkNotNullParameter(compoundButton, "compoundButton");
            MobileAppPresenter mobileAppPresenter = this.presenter;
            if (mobileAppPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            if (mobileAppPresenter.isShowSystem() != z) {
                MobileAppPresenter mobileAppPresenter2 = this.presenter;
                if (mobileAppPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                mobileAppPresenter2.setShowSystem(z);
                MobileAppPresenter mobileAppPresenter3 = this.presenter;
                if (mobileAppPresenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                mobileAppPresenter3.reloadData();
                EventBus.getDefault().post(new MobileAppShowSystemEvent(z));
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppFragment$SwitchViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: MobileAppFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppFragment$MyItemDetailsLookup;", "Landroidx/recyclerview/selection/ItemDetailsLookup;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getItemDetails", "Landroidx/recyclerview/selection/ItemDetailsLookup$ItemDetails;", "event", "Landroid/view/MotionEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MobileAppFragment.kt */
    public static final class MyItemDetailsLookup extends ItemDetailsLookup<Long> {
        private final RecyclerView recyclerView;

        public MyItemDetailsLookup(RecyclerView recyclerView2) {
            Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
            this.recyclerView = recyclerView2;
        }

        @Override // androidx.recyclerview.selection.ItemDetailsLookup
        public ItemDetailsLookup.ItemDetails<Long> getItemDetails(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            View findChildViewUnder = this.recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder == null) {
                return null;
            }
            RecyclerView.ViewHolder childViewHolder = this.recyclerView.getChildViewHolder(findChildViewUnder);
            if (childViewHolder instanceof MobileAppViewHolder) {
                return ((MobileAppViewHolder) childViewHolder).getItemDetails();
            }
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppFragment$MyItemKeyProvider;", "Landroidx/recyclerview/selection/ItemKeyProvider;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getKey", "position", "", "(I)Ljava/lang/Long;", "getPosition", "key", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MobileAppFragment.kt */
    public static final class MyItemKeyProvider extends ItemKeyProvider<Long> {
        private final RecyclerView recyclerView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MyItemKeyProvider(RecyclerView recyclerView2) {
            super(0);
            Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
            this.recyclerView = recyclerView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.recyclerview.selection.ItemKeyProvider
        public /* bridge */ /* synthetic */ int getPosition(Long l) {
            return getPosition(l.longValue());
        }

        @Override // androidx.recyclerview.selection.ItemKeyProvider
        public Long getKey(int i) {
            RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
            if (adapter != null) {
                return Long.valueOf(adapter.getItemId(i));
            }
            return null;
        }

        public int getPosition(long j) {
            RecyclerView.ViewHolder findViewHolderForItemId = this.recyclerView.findViewHolderForItemId(j);
            if (findViewHolderForItemId != null) {
                return findViewHolderForItemId.getLayoutPosition();
            }
            return -1;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppFragment$ActionModeController;", "Landroidx/appcompat/view/ActionMode$Callback;", "(Lcom/coolapk/market/view/appmanager/MobileAppFragment;)V", "onActionItemClicked", "", "mode", "Landroidx/appcompat/view/ActionMode;", "item", "Landroid/view/MenuItem;", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onDestroyActionMode", "", "onPrepareActionMode", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MobileAppFragment.kt */
    private final class ActionModeController implements ActionMode.Callback {
        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            Intrinsics.checkNotNullParameter(actionMode, "mode");
            Intrinsics.checkNotNullParameter(menu, "menu");
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ActionModeController() {
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            Intrinsics.checkNotNullParameter(actionMode, "mode");
            Intrinsics.checkNotNullParameter(menuItem, "item");
            if (menuItem.getItemId() != 2131361892) {
                return false;
            }
            int itemCount = MobileAppFragment.access$getAdapter$p(MobileAppFragment.this).getItemCount();
            for (int i = 0; i < itemCount; i++) {
                SelectionTracker selectionTracker = MobileAppFragment.this.tracker;
                Intrinsics.checkNotNull(selectionTracker);
                if (selectionTracker.isSelected(Long.valueOf(MobileAppFragment.access$getAdapter$p(MobileAppFragment.this).getItemId(i)))) {
                    MobileApp mobileApp = (MobileApp) MobileAppFragment.this.getDataList().get(MobileAppFragment.access$getAdapter$p(MobileAppFragment.this).sectionedPositionToPosition(i));
                    Intrinsics.checkNotNullExpressionValue(mobileApp, "mobileApp");
                    FragmentActivity requireActivity = MobileAppFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    if (!TextUtils.equals(mobileApp.getPackageName(), requireActivity.getPackageName())) {
                        ActionManager.uninstall(MobileAppFragment.this.getActivity(), mobileApp.getPackageName(), mobileApp.getAppName());
                    }
                }
            }
            actionMode.finish();
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            Intrinsics.checkNotNullParameter(actionMode, "mode");
            Intrinsics.checkNotNullParameter(menu, "menu");
            FragmentActivity requireActivity = MobileAppFragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            requireActivity.getMenuInflater().inflate(2131623961, menu);
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Intrinsics.checkNotNullParameter(actionMode, "mode");
            SelectionTracker selectionTracker = MobileAppFragment.this.tracker;
            if (selectionTracker != null) {
                selectionTracker.clearSelection();
            }
        }
    }
}
