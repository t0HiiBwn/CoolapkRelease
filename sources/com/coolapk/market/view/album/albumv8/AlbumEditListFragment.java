package com.coolapk.market.view.album.albumv8;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.LayoutListEditButtonBinding;
import com.coolapk.market.event.AlbumItemEditEvent;
import com.coolapk.market.event.AlbumaddEvent;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.viewholder.AlbumItemEditViewHolder;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.touchhelper.ItemTouchHelperAdapter;
import com.coolapk.market.widget.touchhelper.OnStartDragListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u0000 H2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002HIB\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010)\u001a\u00020*J\u0012\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0007J\u0010\u00101\u001a\u00020*2\u0006\u0010/\u001a\u000202H\u0007J\u0012\u00103\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0018\u00104\u001a\u00020*2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J$\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020:2\u0006\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020*H\u0016J\u0010\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020AH\u0016J\u001a\u0010B\u001a\u00020*2\u0006\u0010;\u001a\u00020\u00102\b\u0010C\u001a\u0004\u0018\u00010DH\u0014J \u0010E\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u00102\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\b\u0010G\u001a\u00020\u0010H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000bj\b\u0012\u0004\u0012\u00020\u0003`\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R'\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\u00128BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\b\u0018\u00010\u0019R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumEditListFragment;", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "", "Lcom/coolapk/market/model/AlbumItem;", "()V", "callback", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "dataList", "Landroidx/databinding/ObservableArrayList;", "Lcom/coolapk/market/model/Entity;", "delList", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "editButtonBinding", "Lcom/coolapk/market/databinding/LayoutListEditButtonBinding;", "isLoadedHeader", "", "listCallback", "Lcom/coolapk/market/widget/AdapterListChangedCallback;", "Landroidx/databinding/ObservableList;", "getListCallback", "()Lcom/coolapk/market/widget/AdapterListChangedCallback;", "listCallback$delegate", "Lkotlin/Lazy;", "mAdapter", "Lcom/coolapk/market/view/album/albumv8/AlbumEditListFragment$DataAdapter;", "mAlbum", "Lcom/coolapk/market/model/Album;", "mAlbumDetailViewModel", "Lcom/coolapk/market/view/album/AlbumDetailViewModel;", "mAlbumId", "", "mItemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "mItems", "", "getMItems", "()Ljava/util/List;", "mLinearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mUid", "delListChange", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAlbumItemEdit", "event", "Lcom/coolapk/market/event/AlbumItemEditEvent;", "onAlbumaddEventChanged", "Lcom/coolapk/market/event/AlbumaddEvent;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "isRefresh", "page", "", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestFailure", "error", "", "onRequestResponse", "result", "shouldShowList", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumEditListFragment.kt */
public final class AlbumEditListFragment extends NewAsyncListFragment<List<? extends AlbumItem>> {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_DATA = "DATA";
    private static final String KEY_ID = "KEY_ID";
    private ItemTouchHelper.Callback callback;
    private ObservableArrayList<Entity> dataList = new ObservableArrayList<>();
    private HashSet<AlbumItem> delList = new HashSet<>();
    private LayoutListEditButtonBinding editButtonBinding;
    private boolean isLoadedHeader;
    private final Lazy listCallback$delegate = LazyKt.lazy(new AlbumEditListFragment$listCallback$2(this));
    private DataAdapter mAdapter;
    private Album mAlbum;
    private AlbumDetailViewModel mAlbumDetailViewModel;
    private String mAlbumId;
    private ItemTouchHelper mItemTouchHelper;
    private final List<AlbumItem> mItems = new ArrayList();
    private LinearLayoutManager mLinearLayoutManager;
    private String mUid;

    /* access modifiers changed from: private */
    public final AdapterListChangedCallback<ObservableList<Entity>> getListCallback() {
        return (AdapterListChangedCallback) this.listCallback$delegate.getValue();
    }

    @JvmStatic
    public static final AlbumEditListFragment newInstance(Album album) {
        return Companion.newInstance(album);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumEditListFragment$Companion;", "", "()V", "KEY_DATA", "", "KEY_ID", "newInstance", "Lcom/coolapk/market/view/album/albumv8/AlbumEditListFragment;", "album", "Lcom/coolapk/market/model/Album;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumEditListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AlbumEditListFragment newInstance(Album album) {
            Intrinsics.checkNotNullParameter(album, "album");
            AlbumEditListFragment albumEditListFragment = new AlbumEditListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("KEY_ID", album);
            Unit unit = Unit.INSTANCE;
            albumEditListFragment.setArguments(bundle);
            return albumEditListFragment;
        }
    }

    public final List<AlbumItem> getMItems() {
        return this.mItems;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Album album = (Album) requireArguments().getParcelable("KEY_ID");
        this.mAlbum = album;
        if (album != null) {
            String str = null;
            this.mAlbumId = album != null ? album.getAlbumId() : null;
            Album album2 = this.mAlbum;
            if (album2 != null) {
                str = album2.getUid();
            }
            this.mUid = str;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        FrameLayout frameLayout;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        super.onActivityCreated(bundle);
        setAutoUpdateContentUiOnDataChanged(true);
        DataAdapter dataAdapter = new DataAdapter();
        this.mAdapter = dataAdapter;
        setAdapter(dataAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.mLinearLayoutManager = linearLayoutManager;
        setLayoutManager(linearLayoutManager);
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558584, 2131231066).type(2131558585, 2131231066).create());
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        getRecyclerView().setPadding(0, 0, 0, NumberExtendsKt.getDp((Number) 64));
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipToPadding(false);
        this.dataList.addOnListChangedCallback(getListCallback());
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        this.callback = new AlbumEditListFragment$onActivityCreated$1(this, this.mAdapter);
        FrameLayout.LayoutParams layoutParams = null;
        LayoutListEditButtonBinding layoutListEditButtonBinding = (LayoutListEditButtonBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559004, null, false);
        this.editButtonBinding = layoutListEditButtonBinding;
        if (!(layoutListEditButtonBinding == null || (linearLayout3 = layoutListEditButtonBinding.actionAdd) == null)) {
            linearLayout3.setBackgroundColor(AppHolder.getAppTheme().getColorAccent());
        }
        View view = getView();
        if (view != null) {
            if (!(view instanceof FrameLayout)) {
                view = null;
            }
            frameLayout = (FrameLayout) view;
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            LayoutListEditButtonBinding layoutListEditButtonBinding2 = this.editButtonBinding;
            View root = layoutListEditButtonBinding2 != null ? layoutListEditButtonBinding2.getRoot() : null;
            frameLayout.addView(root);
            if (root != null) {
                ViewGroup.LayoutParams layoutParams2 = root.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2);
                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                    layoutParams = layoutParams2;
                }
                FrameLayout.LayoutParams layoutParams3 = layoutParams;
                if (layoutParams3 != null) {
                    layoutParams3.bottomMargin = NumberExtendsKt.getDp((Number) 24);
                    layoutParams3.gravity = 81;
                    layoutParams3.width = -2;
                    layoutParams3.height = NumberExtendsKt.getDp((Number) 40);
                }
                root.setElevation((float) DisplayUtils.dp2px(getActivity(), 0.5f));
                root.setVisibility(0);
            }
            if (root != null) {
                ViewExtents2Kt.tryListenWindowsInset(root, new AlbumEditListFragment$onActivityCreated$3(this, root));
            }
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new AlbumEditListFragment$onActivityCreated$4(frameLayout, root));
            LayoutListEditButtonBinding layoutListEditButtonBinding3 = this.editButtonBinding;
            if (!(layoutListEditButtonBinding3 == null || (linearLayout2 = layoutListEditButtonBinding3.actionAdd) == null)) {
                linearLayout2.setOnClickListener(new AlbumEditListFragment$onActivityCreated$5(this));
            }
            LayoutListEditButtonBinding layoutListEditButtonBinding4 = this.editButtonBinding;
            if (!(layoutListEditButtonBinding4 == null || (linearLayout = layoutListEditButtonBinding4.actionDel) == null)) {
                linearLayout.setOnClickListener(new AlbumEditListFragment$onActivityCreated$6(this));
            }
            if (getUserVisibleHint()) {
                initData();
            }
            ItemTouchHelper.Callback callback2 = this.callback;
            Intrinsics.checkNotNull(callback2);
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback2);
            this.mItemTouchHelper = itemTouchHelper;
            Intrinsics.checkNotNull(itemTouchHelper);
            itemTouchHelper.attachToRecyclerView(getRecyclerView());
            setHasOptionsMenu(true);
            EventBus eventBus = EventBus.getDefault();
            Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
            EventBusExtendsKt.safeRegister(eventBus, this);
        }
    }

    public final void delListChange() {
        int i;
        if (CollectionUtils.isNotEmpty(this.delList)) {
            i = Color.parseColor("#F44336");
        } else {
            i = Color.parseColor("#BDBDBD");
        }
        LayoutListEditButtonBinding layoutListEditButtonBinding = this.editButtonBinding;
        Intrinsics.checkNotNull(layoutListEditButtonBinding);
        LinearLayout linearLayout = layoutListEditButtonBinding.actionDel;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "editButtonBinding!!.actionDel");
        linearLayout.setBackground(new ColorDrawable(i));
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onAlbumaddEventChanged(AlbumaddEvent albumaddEvent) {
        Intrinsics.checkNotNullParameter(albumaddEvent, "event");
        requireActivity().finish();
    }

    @Subscribe
    public final void onAlbumItemEdit(AlbumItemEditEvent albumItemEditEvent) {
        Intrinsics.checkNotNullParameter(albumItemEditEvent, "event");
        AlbumItem albumItem = albumItemEditEvent.getAlbumItem();
        Intrinsics.checkNotNullExpressionValue(albumItem, "event.albumItem");
        Album album = this.mAlbum;
        Intrinsics.checkNotNull(album);
        if (TextUtils.equals(albumItem.getAlbumId(), album.getAlbumId())) {
            int i = 0;
            for (Entity entity : this.dataList) {
                if (entity instanceof AlbumItem) {
                    AlbumItem albumItem2 = (AlbumItem) entity;
                    if (Intrinsics.areEqual(albumItem2.getEntityType(), "albumItem")) {
                        String packageName = albumItem2.getPackageName();
                        AlbumItem albumItem3 = albumItemEditEvent.getAlbumItem();
                        Intrinsics.checkNotNullExpressionValue(albumItem3, "event.albumItem");
                        if (Intrinsics.areEqual(packageName, albumItem3.getPackageName())) {
                            this.dataList.set(i, albumItemEditEvent.getAlbumItem());
                        }
                    }
                }
                i++;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            MenuItem add = menu.add(0, 2131361900, 0, "完成");
            add.setVisible(true);
            add.setShowAsAction(2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (this.mAlbum == null) {
            return true;
        }
        if (menuItem.getItemId() != 2131361900) {
            return super.onOptionsItemSelected(menuItem);
        }
        requireActivity().finish();
        return true;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<AlbumItem>> onCreateRequest(boolean z, int i) {
        Observable<R> compose = DataManager.getInstance().getAlbumAllApkList(this.mAlbumId).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return this.dataList.size() > 0;
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<? extends AlbumItem> list) {
        boolean z2 = false;
        this.dataList.add(0, Album.newBuilder(this.mAlbum).entityTemplate("album").build());
        List<? extends AlbumItem> list2 = list;
        if (!CollectionUtils.isEmpty(list2)) {
            if (z) {
                ObservableArrayList<Entity> observableArrayList = this.dataList;
                Intrinsics.checkNotNull(list);
                observableArrayList.addAll(1, list2);
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                ObservableArrayList<Entity> observableArrayList2 = this.dataList;
                Intrinsics.checkNotNull(list);
                observableArrayList2.addAll(list2);
            }
            this.mItems.addAll(list2);
            this.mAlbum = Album.newBuilder(this.mAlbum).albumItems(list).build();
            z2 = true;
        } else {
            this.dataList.add(Album.newBuilder(this.mAlbum).entityTemplate("albumEmpty").build());
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumEditListFragment$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "Lcom/coolapk/market/widget/touchhelper/ItemTouchHelperAdapter;", "Lcom/coolapk/market/widget/touchhelper/OnStartDragListener;", "(Lcom/coolapk/market/view/album/albumv8/AlbumEditListFragment;)V", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "mLock", "", "touchCallBack", "Lcom/coolapk/market/viewholder/AlbumItemEditViewHolder$TouchCallBack;", "getTouchCallBack", "()Lcom/coolapk/market/viewholder/AlbumItemEditViewHolder$TouchCallBack;", "canMove", "", "position", "", "canSwipe", "getItemCount", "getItemViewType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onItemMove", "fromPosition", "toPosition", "onStartDrag", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumEditListFragment.kt */
    private final class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> implements ItemTouchHelperAdapter, OnStartDragListener {
        private final FragmentBindingComponent component;
        private final Object mLock = new Object();
        private final AlbumItemEditViewHolder.TouchCallBack touchCallBack;

        @Override // com.coolapk.market.widget.touchhelper.ItemTouchHelperAdapter
        public boolean canSwipe(int i) {
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
            this.component = new FragmentBindingComponent(AlbumEditListFragment.this.getFragment());
            this.touchCallBack = new AlbumEditListFragment$DataAdapter$touchCallBack$1(this);
        }

        public final AlbumItemEditViewHolder.TouchCallBack getTouchCallBack() {
            return this.touchCallBack;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            switch (i) {
                case 2131558584:
                    AlbumItemEditViewHolder.TouchCallBack touchCallBack2 = this.touchCallBack;
                    Album album = AlbumEditListFragment.this.mAlbum;
                    Intrinsics.checkNotNull(album);
                    List<AlbumItem> mItems = AlbumEditListFragment.this.getMItems();
                    FragmentManager childFragmentManager = AlbumEditListFragment.this.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    return new AlbumItemEditViewHolder(touchCallBack2, album, mItems, childFragmentManager, inflate, this.component, null, AlbumEditListFragment.this.delList);
                case 2131558585:
                    Intrinsics.checkNotNullExpressionValue(inflate, "viewItem");
                    return new AlbumEditHeaderViewHolder(inflate, this.component, null);
                case 2131558840:
                    Intrinsics.checkNotNullExpressionValue(inflate, "viewItem");
                    return new AlbumEmptyViewHolder(inflate, this.component, null);
                default:
                    throw new IllegalStateException("Unknown view type " + i);
            }
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            bindingViewHolder.bindTo(AlbumEditListFragment.this.dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AlbumEditListFragment.this.dataList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            Entity entity = (Entity) AlbumEditListFragment.this.dataList.get(i);
            if (entity instanceof AlbumItem) {
                return 2131558584;
            }
            if (entity instanceof Album) {
                return TextUtils.equals(((Album) entity).getEntityTemplate(), "albumEmpty") ? 2131558840 : 2131558585;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("unknown viewType :");
            Intrinsics.checkNotNullExpressionValue(entity, "entity");
            sb.append(entity.getEntityType());
            throw new RuntimeException(sb.toString());
        }

        @Override // com.coolapk.market.widget.touchhelper.ItemTouchHelperAdapter
        public boolean onItemMove(int i, int i2) {
            synchronized (this.mLock) {
                AlbumEditListFragment.this.dataList.removeOnListChangedCallback(AlbumEditListFragment.this.getListCallback());
                Collections.swap(AlbumEditListFragment.this.dataList, i, i2);
                Collections.swap(AlbumEditListFragment.this.getMItems(), i - 1, i2 - 1);
                AlbumEditListFragment.this.dataList.addOnListChangedCallback(AlbumEditListFragment.this.getListCallback());
                Unit unit = Unit.INSTANCE;
            }
            notifyItemMoved(i, i2);
            return true;
        }

        @Override // com.coolapk.market.widget.touchhelper.ItemTouchHelperAdapter
        public boolean canMove(int i) {
            DataAdapter dataAdapter = AlbumEditListFragment.this.mAdapter;
            Intrinsics.checkNotNull(dataAdapter);
            return dataAdapter.getItemViewType(i) == 2131558584;
        }

        @Override // com.coolapk.market.widget.touchhelper.OnStartDragListener
        public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            ItemTouchHelper itemTouchHelper = AlbumEditListFragment.this.mItemTouchHelper;
            Intrinsics.checkNotNull(itemTouchHelper);
            itemTouchHelper.startDrag(viewHolder);
        }
    }
}
