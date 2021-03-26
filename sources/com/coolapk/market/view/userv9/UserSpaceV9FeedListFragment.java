package com.coolapk.market.view.userv9;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.TopBottomDividerRule;
import com.coolapk.market.view.feed.dialog.SheetGroupModifierManager;
import com.coolapk.market.view.node.AlbumTopEvent;
import com.coolapk.market.view.node.AlbumUserSpaceSheetModifier;
import com.coolapk.market.view.node.FeedTopEvent;
import com.coolapk.market.view.node.NodeFeedDialogInterceptor;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00120\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J$\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001f2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0010H\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020%H\u0007J \u0010&\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0014J\b\u0010(\u001a\u00020\u0017H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006*"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceV9FeedListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "showTopIds", "", "getShowTopIds", "()Z", "topIds", "", "", "uid", "getUid", "()Ljava/lang/String;", "uid$delegate", "Lkotlin/Lazy;", "filterDataWhenRefresh", "", "originData", "", "index", "newDataByCardId", "", "generateTopIds", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAlbumTopEvent", "event", "Lcom/coolapk/market/view/node/AlbumTopEvent;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "onFeedTopEvent", "Lcom/coolapk/market/view/node/FeedTopEvent;", "onRequestResponse", "data", "removeOldTopData", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserFeedListFragment.kt */
public class UserSpaceV9FeedListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private final List<String> topIds = new ArrayList();
    private final Lazy uid$delegate = LazyKt.lazy(new UserSpaceV9FeedListFragment$uid$2(this));

    private final String getUid() {
        return (String) this.uid$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceV9FeedListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/userv9/UserSpaceV9FeedListFragment;", "uid", "", "num", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserFeedListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserSpaceV9FeedListFragment newInstance(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "uid");
            UserSpaceV9FeedListFragment userSpaceV9FeedListFragment = new UserSpaceV9FeedListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("UID", str);
            bundle.putInt("NUM", i);
            Unit unit = Unit.INSTANCE;
            userSpaceV9FeedListFragment.setArguments(bundle);
            return userSpaceV9FeedListFragment;
        }
    }

    private final boolean getShowTopIds() {
        String uid = getUid();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        return Intrinsics.areEqual(uid, loginSession.getUid());
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof UserSpaceV9Activity) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.userv9.UserSpaceV9Activity");
            if (((UserSpaceV9Activity) activity).isInBlackList()) {
                setEmptyData("由于你的黑名单设置，该用户动态对你不可见", 0);
            }
        }
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(TopBottomDividerRule.Companion.getEMPTY());
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558989).constructor(new UserSpaceV9FeedListFragment$onActivityCreated$1(this)).suitedEntityType("USER_SPACE_COUNT").build(), 0, 2, null);
        if (getShowTopIds()) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            List<String> list = this.topIds;
            String uid = getUid();
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            NodeFeedDialogInterceptor nodeFeedDialogInterceptor = new NodeFeedDialogInterceptor(requireActivity, list, "member", uid, true);
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            List<String> list2 = this.topIds;
            String uid2 = getUid();
            Intrinsics.checkNotNullExpressionValue(uid2, "uid");
            AlbumUserSpaceSheetModifier albumUserSpaceSheetModifier = new AlbumUserSpaceSheetModifier(requireActivity2, list2, "member", uid2);
            SheetGroupModifierManager.INSTANCE.addModifier(nodeFeedDialogInterceptor);
            SheetGroupModifierManager.INSTANCE.addModifier(albumUserSpaceSheetModifier);
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new UserSpaceV9FeedListFragment$onActivityCreated$2(nodeFeedDialogInterceptor, albumUserSpaceSheetModifier));
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String str;
        UserSpaceV9FeedListFragment userSpaceV9FeedListFragment;
        String str2 = null;
        Integer num = getActivity() instanceof UserSpaceV9Activity ? 1 : null;
        DataManager instance = DataManager.getInstance();
        String uid = getUid();
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, true, 7, null);
        if (findFirstEntity$default != null) {
            str = findFirstEntity$default.getId();
            userSpaceV9FeedListFragment = this;
        } else {
            userSpaceV9FeedListFragment = this;
            str = null;
        }
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(userSpaceV9FeedListFragment, null, true, 1, null);
        if (findLastEntity$default != null) {
            str2 = findLastEntity$default.getId();
        }
        Observable<R> compose = instance.getUserFeedList(uid, i, str, str2, 0, num).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        boolean z2 = true;
        if (!getDataList().isEmpty()) {
            Parcelable parcelable = (Parcelable) CollectionsKt.first((List<? extends Object>) getDataList());
            if (!(parcelable instanceof HolderItem) || !Intrinsics.areEqual(((HolderItem) parcelable).getEntityType(), "USER_SPACE_COUNT")) {
                z2 = false;
            }
            if (!z2) {
                int i = requireArguments().getInt("NUM", 0);
                List<Parcelable> dataList = getDataList();
                HolderItem.Builder entityType = HolderItem.newBuilder().entityType("USER_SPACE_COUNT");
                HolderItem build = entityType.string("全部动态（" + i + (char) 65289).build();
                Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().…                 .build()");
                dataList.add(0, build);
            }
        }
        if (getShowTopIds() && z) {
            generateTopIds();
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (obj instanceof HolderItem) {
            return -1;
        }
        return super.filterDataWhenRefresh(obj, i, map);
    }

    @Subscribe
    public final void onFeedTopEvent(FeedTopEvent feedTopEvent) {
        int i;
        Intrinsics.checkNotNullParameter(feedTopEvent, "event");
        if (Intrinsics.areEqual(feedTopEvent.getNodeType(), "member") && Intrinsics.areEqual(feedTopEvent.getNodeId(), getUid())) {
            List<Parcelable> dataList = getDataList();
            if (feedTopEvent.isTopNow()) {
                removeOldTopData();
                Iterator<Parcelable> it2 = dataList.iterator();
                int i2 = 0;
                while (true) {
                    i = -1;
                    if (!it2.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    Parcelable next = it2.next();
                    if ((next instanceof Feed) && Intrinsics.areEqual(((Feed) next).getId(), feedTopEvent.getData().getId())) {
                        break;
                    }
                    i2++;
                }
                if (i2 >= 0) {
                    Parcelable remove = dataList.remove(i2);
                    Objects.requireNonNull(remove, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
                    Feed feed = (Feed) remove;
                    Iterator<Parcelable> it3 = dataList.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        Parcelable next2 = it3.next();
                        if ((next2 instanceof Feed) || (next2 instanceof Album)) {
                            i = i3;
                            break;
                        }
                        i3++;
                    }
                    if (i < 0) {
                        i = dataList.size();
                    }
                    Feed build = Feed.newBuilder(feed).isStickTop(1).build();
                    Intrinsics.checkNotNullExpressionValue(build, "Feed.newBuilder(feed).isStickTop(1).build()");
                    dataList.add(i, build);
                }
            } else {
                removeOldTopData();
            }
            generateTopIds();
        }
    }

    @Subscribe
    public final void onAlbumTopEvent(AlbumTopEvent albumTopEvent) {
        int i;
        Intrinsics.checkNotNullParameter(albumTopEvent, "event");
        if (Intrinsics.areEqual(albumTopEvent.getNodeType(), "member") && Intrinsics.areEqual(albumTopEvent.getNodeId(), getUid())) {
            List<Parcelable> dataList = getDataList();
            if (albumTopEvent.isTopNow()) {
                removeOldTopData();
                Iterator<Parcelable> it2 = dataList.iterator();
                int i2 = 0;
                while (true) {
                    i = -1;
                    if (!it2.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    Parcelable next = it2.next();
                    if ((next instanceof Album) && Intrinsics.areEqual(((Album) next).getId(), albumTopEvent.getData().getId())) {
                        break;
                    }
                    i2++;
                }
                if (i2 >= 0) {
                    Parcelable remove = dataList.remove(i2);
                    Objects.requireNonNull(remove, "null cannot be cast to non-null type com.coolapk.market.model.Album");
                    Album album = (Album) remove;
                    Iterator<Parcelable> it3 = dataList.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        Parcelable next2 = it3.next();
                        if ((next2 instanceof Feed) || (next2 instanceof Album)) {
                            i = i3;
                            break;
                        }
                        i3++;
                    }
                    if (i < 0) {
                        i = dataList.size();
                    }
                    Album build = Album.newBuilder(album).isStickTop(1).build();
                    Intrinsics.checkNotNullExpressionValue(build, "Album.newBuilder(album).isStickTop(1).build()");
                    dataList.add(i, build);
                }
            } else {
                removeOldTopData();
            }
            generateTopIds();
        }
    }

    private final void removeOldTopData() {
        List<Parcelable> dataList = getDataList();
        Iterator<Parcelable> it2 = dataList.iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable next = it2.next();
            if ((next instanceof Album) || (next instanceof Feed)) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            Parcelable parcelable = dataList.get(i);
            if (parcelable instanceof Feed) {
                Feed feed = (Feed) parcelable;
                if (feed.getIsStickTop() > 0) {
                    Feed build = Feed.newBuilder(feed).isStickTop(0).build();
                    Intrinsics.checkNotNullExpressionValue(build, "Feed.newBuilder(feed).isStickTop(0).build()");
                    dataList.set(i, build);
                }
            } else if (parcelable instanceof Album) {
                Album album = (Album) parcelable;
                if (album.getIsStickTop() > 0) {
                    Album build2 = Album.newBuilder(album).isStickTop(0).build();
                    Intrinsics.checkNotNullExpressionValue(build2, "Album.newBuilder(album).isStickTop(0).build()");
                    dataList.set(i, build2);
                }
            }
        }
    }

    private final void generateTopIds() {
        ArrayList arrayList = new ArrayList();
        for (T t : getDataList()) {
            T t2 = t;
            boolean z = true;
            if ((!(t2 instanceof Feed) || t2.getIsStickTop() != 1) && (!(t2 instanceof Album) || t2.getIsStickTop() != 1)) {
                z = false;
            }
            if (z) {
                arrayList.add(t);
            }
        }
        List<Entity> filterIsInstance = CollectionsKt.filterIsInstance(arrayList, Entity.class);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(filterIsInstance, 10));
        for (Entity entity : filterIsInstance) {
            String id = entity.getId();
            if (id == null) {
                id = "";
            }
            arrayList2.add(id);
        }
        this.topIds.clear();
        this.topIds.addAll(arrayList2);
    }
}
