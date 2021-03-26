package com.coolapk.market.view.album.albumv8;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.event.AlbumEditEvent;
import com.coolapk.market.event.AlbumItemAddDelEvent;
import com.coolapk.market.event.AlbumItemEditEvent;
import com.coolapk.market.event.AlbumLikeEvent;
import com.coolapk.market.event.FeedDeleteEvent;
import com.coolapk.market.event.FeedFavoriteEvent;
import com.coolapk.market.event.FeedReplyEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.RVStateEventChangedAdapter;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.viewholder.AlbumItemViewHolder;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.MultiFeedReplyViewHolder;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/* compiled from: AlbumDetailListFragment.kt */
public final class AlbumDetailListFragment extends NewAsyncListFragment<List<? extends AlbumItem>> {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_ALBUM = "ALBUM";
    private static final String KEY_ALBUM_REPLY_ID = "ALBUM_REPLY_ID";
    private static final String KEY_DATA = "DATA";
    private static final String TYPE_ITEM_ALBUMINTRO = "albumIntro";
    private final ObservableArrayList<Entity> dataList = new ObservableArrayList<>();
    private float downY;
    private boolean isLoadedHeader;
    private DataAdapter mAdapter;
    private Album mAlbum;
    private AlbumDetailViewModel mAlbumDetailViewModel;
    private String mAlbumId;
    private int mDistanceY;
    private final List<AlbumItem> mItems = new ArrayList();
    private LinearLayoutManager mLinearLayoutManager;
    private String mReplyId;
    private String mUid;
    private int replyNum;
    private RVStateEventChangedAdapter stateEventChangedAdapter;

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setAutoUpdateContentUiOnDataChanged(true);
        DataAdapter dataAdapter = new DataAdapter();
        this.mAdapter = dataAdapter;
        setAdapter(dataAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.mLinearLayoutManager = linearLayoutManager;
        setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator);
        Intrinsics.checkNotNullExpressionValue(itemAnimator, "recyclerView.itemAnimator!!");
        itemAnimator.setChangeDuration(0);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), 42.0f));
        setRefreshEnable(true);
        this.dataList.addOnListChangedCallback(new AdapterListChangedCallback(this.mAdapter));
        setLoadMoreEnable(true);
        getRecyclerView().addOnItemTouchListener(new AlbumDetailListFragment$onActivityCreated$1(this));
        getRecyclerView().addOnScrollListener(new AlbumDetailListFragment$onActivityCreated$2(this));
        RVStateEventChangedAdapter rVStateEventChangedAdapter = new RVStateEventChangedAdapter(getRecyclerView());
        this.stateEventChangedAdapter = rVStateEventChangedAdapter;
        Intrinsics.checkNotNull(rVStateEventChangedAdapter);
        rVStateEventChangedAdapter.onAttach();
        if (getUserVisibleHint()) {
            initData();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Album album = (Album) requireArguments().getParcelable(KEY_ALBUM);
        this.mAlbum = album;
        Intrinsics.checkNotNull(album);
        this.mAlbumId = album.getAlbumId();
        Album album2 = this.mAlbum;
        Intrinsics.checkNotNull(album2);
        this.mUid = album2.getUid();
        this.mReplyId = requireArguments().getString(KEY_ALBUM_REPLY_ID);
        this.mAlbumDetailViewModel = new AlbumDetailViewModel(getActivity());
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEY_DATA);
            if (parcelableArrayList != null) {
                this.dataList.addAll(parcelableArrayList);
            }
        }
        EventBus.getDefault().register(this);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList(KEY_DATA, this.dataList);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        RVStateEventChangedAdapter rVStateEventChangedAdapter = this.stateEventChangedAdapter;
        Intrinsics.checkNotNull(rVStateEventChangedAdapter);
        rVStateEventChangedAdapter.onDetach();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<AlbumItem>> onCreateRequest(boolean z, int i) {
        AlbumItem albumItem = (AlbumItem) EntityUtils.findFirstItem(this.dataList, "albumItem");
        AlbumItem albumItem2 = (AlbumItem) EntityUtils.findLastItem(this.dataList, "albumItem");
        DataManager instance = DataManager.getInstance();
        String str = this.mAlbumId;
        String str2 = null;
        String packageName = albumItem != null ? albumItem.getPackageName() : null;
        if (albumItem2 != null) {
            str2 = albumItem2.getPackageName();
        }
        Observable<R> compose = instance.getAlbumApkList(str, i, packageName, str2).compose(RxUtils.apiCommonToData());
        if (!this.isLoadedHeader) {
            Observable<List<AlbumItem>> flatMap = Observable.just(this.mAlbum).observeOn(AndroidSchedulers.mainThread()).doOnNext(new AlbumDetailListFragment$onCreateRequest$1(this)).flatMap(new AlbumDetailListFragment$onCreateRequest$2(compose));
            Intrinsics.checkNotNullExpressionValue(flatMap, "Observable.just<Album>(m… .flatMap { loadApkRows }");
            return flatMap;
        }
        Intrinsics.checkNotNullExpressionValue(compose, "loadApkRows");
        return compose;
    }

    public boolean onRequestResponse(boolean z, List<? extends AlbumItem> list) {
        List<? extends AlbumItem> list2 = list;
        boolean z2 = true;
        int i = 0;
        if (!CollectionUtils.isEmpty(list2)) {
            EntityUtils.removeReduplicatedEntity(list, this.dataList, null);
            if (z) {
                if (list != null) {
                    Album build = Album.newBuilder(this.mAlbum).albumItems(list).build();
                    this.mAlbum = build;
                    this.dataList.set(0, build);
                    this.dataList.addAll(1, list2);
                }
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else if (!CollectionUtils.isEmpty(list2)) {
                ObservableArrayList<Entity> observableArrayList = this.dataList;
                Intrinsics.checkNotNull(list);
                observableArrayList.addAll(list2);
                Album album = this.mAlbum;
                Intrinsics.checkNotNull(album);
                if (!album.getAlbumHotReplies().isEmpty()) {
                    this.dataList.add(HolderItem.newBuilder().entityType("hotReply").string(getString(2131886852)).build());
                    ObservableArrayList<Entity> observableArrayList2 = this.dataList;
                    Album album2 = this.mAlbum;
                    Intrinsics.checkNotNull(album2);
                    observableArrayList2.addAll(album2.getAlbumHotReplies());
                    this.dataList.add(HolderItem.newBuilder().string(getString(2131887148)).entityType("seemore").build());
                }
                Album album3 = this.mAlbum;
                Intrinsics.checkNotNull(album3);
                this.replyNum = album3.getReplyNum();
                this.mItems.addAll(list2);
            }
        } else {
            if (z && CollectionUtils.safeSize(this.dataList) <= 1) {
                this.dataList.add(Album.newBuilder(this.mAlbum).entityTemplate("albumEmpty").build());
            }
            z2 = false;
        }
        if (CollectionUtils.safeSize(this.dataList) > 0) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.album.albumv8.AlbumDetailActivity");
            ((AlbumDetailActivity) activity).listLoaded();
        }
        if (CollectionUtils.safeSize(this.dataList) > 2) {
            Iterator<Entity> it2 = this.dataList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Entity next = it2.next();
                if (i > 0 && (next instanceof Album)) {
                    this.dataList.remove(i);
                    break;
                }
                i++;
            }
        }
        updateContentUI();
        return z2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            menuInflater.inflate(2131623936, menu);
        }
    }

    public final void onAlbumEdited(AlbumEditEvent albumEditEvent) {
        Intrinsics.checkNotNullParameter(albumEditEvent, "event");
        Album album = this.mAlbum;
        if (album != null) {
            Intrinsics.checkNotNull(album);
            if (Intrinsics.areEqual(album.getAlbumId(), albumEditEvent.getId())) {
                this.dataList.set(0, Album.newBuilder(this.mAlbum).title(albumEditEvent.getTitle()).introduce(albumEditEvent.getDes()).build());
                DataAdapter dataAdapter = this.mAdapter;
                Intrinsics.checkNotNull(dataAdapter);
                dataAdapter.notifyItemChanged(0);
            }
        }
    }

    public final void onAlbumItemDelEventChanged(AlbumItemAddDelEvent albumItemAddDelEvent) {
        Intrinsics.checkNotNullParameter(albumItemAddDelEvent, "event");
        if (albumItemAddDelEvent.getAdd()) {
            int indexOf = this.dataList.indexOf(albumItemAddDelEvent.getAlbumItem());
            this.dataList.remove(indexOf);
            Album album = this.mAlbum;
            Intrinsics.checkNotNull(album);
            List<AlbumItem> albumItems = album.getAlbumItems();
            Intrinsics.checkNotNull(albumItems);
            albumItems.remove(albumItemAddDelEvent.getAlbumItem());
            Album.Builder newBuilder = Album.newBuilder(this.mAlbum);
            Album album2 = this.mAlbum;
            Intrinsics.checkNotNull(album2);
            List<AlbumItem> albumItems2 = album2.getAlbumItems();
            Intrinsics.checkNotNull(albumItems2);
            Album build = newBuilder.albumItems(albumItems2).build();
            this.mAlbum = build;
            this.dataList.set(0, build);
            DataAdapter dataAdapter = this.mAdapter;
            Intrinsics.checkNotNull(dataAdapter);
            dataAdapter.notifyItemRemoved(indexOf);
        }
    }

    public final void onLikeChange(AlbumLikeEvent albumLikeEvent) {
        Intrinsics.checkNotNullParameter(albumLikeEvent, "event");
        Object obj = this.dataList.get(0);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Album");
        Album album = (Album) obj;
        if (Intrinsics.areEqual(albumLikeEvent.getId(), album.getAlbumId())) {
            Album.Builder newBuilder = Album.newBuilder(album);
            if (albumLikeEvent.isLiked()) {
                newBuilder.userAction(UserAction.newBuilder(album.getUserAction()).like(1).build());
            } else {
                newBuilder.userAction(UserAction.newBuilder(album.getUserAction()).like(0).build());
            }
            LikeResult result = albumLikeEvent.getResult();
            Intrinsics.checkNotNullExpressionValue(result, "event.result");
            newBuilder.likeNum(result.getCount());
            Album build = newBuilder.build();
            this.mAlbum = build;
            this.dataList.set(0, build);
            DataAdapter dataAdapter = this.mAdapter;
            Intrinsics.checkNotNull(dataAdapter);
            dataAdapter.notifyItemChanged(0);
        }
    }

    public final void onAlbumFavoriteChagne(FeedFavoriteEvent feedFavoriteEvent) {
        Intrinsics.checkNotNullParameter(feedFavoriteEvent, "event");
        Object obj = this.dataList.get(0);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Album");
        Album album = (Album) obj;
        if (Intrinsics.areEqual(feedFavoriteEvent.getId(), album.getAlbumId())) {
            Album handleEvent = feedFavoriteEvent.handleEvent(album);
            this.mAlbum = handleEvent;
            this.dataList.set(0, handleEvent);
            DataAdapter dataAdapter = this.mAdapter;
            Intrinsics.checkNotNull(dataAdapter);
            dataAdapter.notifyItemChanged(0);
        }
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return isDataLoaded();
    }

    public final void onAlbumItemEdit(AlbumItemEditEvent albumItemEditEvent) {
        Intrinsics.checkNotNullParameter(albumItemEditEvent, "event");
        AlbumItem albumItem = albumItemEditEvent.getAlbumItem();
        Intrinsics.checkNotNullExpressionValue(albumItem, "event.albumItem");
        Album album = this.mAlbum;
        Intrinsics.checkNotNull(album);
        if (!TextUtils.equals(albumItem.getAlbumId(), album.getAlbumId())) {
            return;
        }
        if (TextUtils.equals(albumItemEditEvent.getEditType(), "order")) {
            this.isLoadedHeader = false;
            this.dataList.clear();
            setPage(1);
            reloadData();
            return;
        }
        int findIndexForAlbumItem = findIndexForAlbumItem(albumItemEditEvent);
        this.dataList.set(findIndexForAlbumItem, albumItemEditEvent.getAlbumItem());
        DataAdapter dataAdapter = this.mAdapter;
        Intrinsics.checkNotNull(dataAdapter);
        dataAdapter.notifyItemChanged(findIndexForAlbumItem);
    }

    private final int findIndexForAlbumItem(AlbumItemEditEvent albumItemEditEvent) {
        ObservableArrayList<Entity> observableArrayList = this.dataList;
        int size = observableArrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = observableArrayList.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "entities[i]");
            if (((Entity) obj).getEntityType() == "albumItem") {
                Object obj2 = observableArrayList.get(i);
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.coolapk.market.model.AlbumItem");
                AlbumItem albumItem = albumItemEditEvent.getAlbumItem();
                Intrinsics.checkNotNullExpressionValue(albumItem, "event.albumItem");
                if (TextUtils.equals(((AlbumItem) obj2).getPackageName(), albumItem.getPackageName())) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        Toast.error(getActivity(), th);
    }

    public final void onAlbumDeleted(FeedDeleteEvent feedDeleteEvent) {
        Intrinsics.checkNotNullParameter(feedDeleteEvent, "event");
        Album album = this.mAlbum;
        if (album != null) {
            Intrinsics.checkNotNull(album);
            if (Intrinsics.areEqual(album.getAlbumId(), feedDeleteEvent.id)) {
                requireActivity().finish();
            }
        }
    }

    public final void onFeedReply(FeedReplyEvent feedReplyEvent) {
        Intrinsics.checkNotNullParameter(feedReplyEvent, "event");
        feedReplyEvent.getFeedReply();
        Album.Builder newBuilder = Album.newBuilder(this.mAlbum);
        newBuilder.replyNum(this.replyNum + 1);
        Album build = newBuilder.build();
        this.mAlbum = build;
        Intrinsics.checkNotNull(build);
        this.replyNum = build.getReplyNum();
        DataAdapter dataAdapter = this.mAdapter;
        Intrinsics.checkNotNull(dataAdapter);
        dataAdapter.notifyDataSetChanged();
    }

    /* compiled from: AlbumDetailListFragment.kt */
    private final class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        private final FragmentBindingComponent component;

        public DataAdapter() {
            AlbumDetailListFragment.this = r2;
            this.component = new FragmentBindingComponent(r2.getFragment());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            switch (i) {
                case 2131558446:
                    Intrinsics.checkNotNullExpressionValue(inflate, "viewItem");
                    return new AlbumV8HeaderViewHolder(inflate, this.component, null);
                case 2131558579:
                    return new AlbumItemViewHolder(AlbumDetailListFragment.this.mAlbum, AlbumDetailListFragment.this.getFragmentManager(), inflate, this.component, new AlbumDetailListFragment$DataAdapter$onCreateViewHolder$1(this));
                case 2131558716:
                    Intrinsics.checkNotNullExpressionValue(inflate, "viewItem");
                    return new MultiFeedReplyViewHolder(inflate, this.component, new ItemActionHandler(), null, 8, null);
                case 2131558833:
                    Intrinsics.checkNotNullExpressionValue(inflate, "viewItem");
                    return new AlbumEmptyViewHolder(inflate, this.component, null);
                case 2131558899:
                    Intrinsics.checkNotNullExpressionValue(inflate, "viewItem");
                    return new FeedReplyMoreViewHolder(inflate, this.component, null);
                default:
                    throw new IllegalStateException("Unknown view type " + i);
            }
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            bindingViewHolder.bindTo(AlbumDetailListFragment.this.dataList.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AlbumDetailListFragment.this.dataList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            Entity entity = (Entity) AlbumDetailListFragment.this.dataList.get(i);
            if (entity instanceof AlbumItem) {
                return 2131558579;
            }
            Intrinsics.checkNotNullExpressionValue(entity, "entity");
            if (TextUtils.equals(entity.getEntityTemplate(), "albumEmpty")) {
                return 2131558833;
            }
            if (EntityUtils.isAlbumType(entity.getEntityType())) {
                return 2131558446;
            }
            if (EntityUtils.isFeedreply(entity.getEntityType())) {
                return 2131558716;
            }
            if (TextUtils.equals("seemore", entity.getEntityType())) {
                return 2131558899;
            }
            throw new RuntimeException("unknown viewType :" + entity.getEntityType());
        }
    }

    /* compiled from: AlbumDetailListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getKEY_ALBUM() {
            return AlbumDetailListFragment.KEY_ALBUM;
        }

        public final String getKEY_DATA() {
            return AlbumDetailListFragment.KEY_DATA;
        }

        public final String getKEY_ALBUM_REPLY_ID() {
            return AlbumDetailListFragment.KEY_ALBUM_REPLY_ID;
        }

        public final AlbumDetailListFragment newInstance(Album album) {
            Bundle bundle = new Bundle();
            AlbumDetailListFragment albumDetailListFragment = new AlbumDetailListFragment();
            bundle.putParcelable(getKEY_ALBUM(), album);
            albumDetailListFragment.setArguments(bundle);
            return albumDetailListFragment;
        }

        public final AlbumDetailListFragment newInstance(Album album, String str) {
            Bundle bundle = new Bundle();
            AlbumDetailListFragment albumDetailListFragment = new AlbumDetailListFragment();
            Companion companion = this;
            bundle.putParcelable(companion.getKEY_ALBUM(), album);
            bundle.putString(companion.getKEY_ALBUM_REPLY_ID(), str);
            albumDetailListFragment.setArguments(bundle);
            return albumDetailListFragment;
        }

        public final AlbumDetailListFragment newInstance() {
            Bundle bundle = new Bundle();
            AlbumDetailListFragment albumDetailListFragment = new AlbumDetailListFragment();
            albumDetailListFragment.setArguments(bundle);
            return albumDetailListFragment;
        }
    }
}
