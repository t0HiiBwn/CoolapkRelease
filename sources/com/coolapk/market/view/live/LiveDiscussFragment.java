package com.coolapk.market.view.live;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.cardlist.EntityDataFilter;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.decoration.CustomizedItemDecoration;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 H2\u00020\u0001:\u0002HIB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u0010 \u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J$\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0&0%2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001cH\u0016J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0007J\u0010\u0010/\u001a\u00020\u001c2\u0006\u0010-\u001a\u000200H\u0007J\b\u00101\u001a\u00020\u001cH\u0014J\b\u00102\u001a\u00020\u001cH\u0016J\b\u00103\u001a\u00020\u001cH\u0014J\b\u00104\u001a\u00020\u001cH\u0014J\u0018\u00105\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\u0006\u00106\u001a\u000207H\u0014J \u00108\u001a\u00020(2\u0006\u0010'\u001a\u00020(2\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010&H\u0014J\b\u0010:\u001a\u00020\u001cH\u0016J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\"H\u0016J\b\u0010=\u001a\u00020\u001cH\u0016J!\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020*2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020GH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0018\u0010\u0019¨\u0006J"}, d2 = {"Lcom/coolapk/market/view/live/LiveDiscussFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "commandHelper", "Lcom/coolapk/market/view/live/CommandHelper;", "handler", "Landroid/os/Handler;", "liveContext", "Lcom/coolapk/market/view/live/LiveContext;", "getLiveContext", "()Lcom/coolapk/market/view/live/LiveContext;", "liveContext$delegate", "Lkotlin/Lazy;", "liveId", "", "getLiveId", "()Ljava/lang/String;", "liveId$delegate", "liveUnreadMessageHelper", "Lcom/coolapk/market/view/live/LiveUnreadMessageHelper;", "notifyItemRunnable", "Ljava/lang/Runnable;", "viewModel", "Lcom/coolapk/market/view/live/LiveViewModel;", "getViewModel", "()Lcom/coolapk/market/view/live/LiveViewModel;", "viewModel$delegate", "autoScrollToBottom", "", "findFirstLiveEntity", "Lcom/coolapk/market/model/Entity;", "findLastLiveEntity", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateRequest", "Lrx/Observable;", "", "isRefresh", "", "page", "", "onDestroyView", "onLiveCommandEventChanged", "event", "Lcom/coolapk/market/view/live/LiveCommandEvent;", "onLiveMessageEventChanged", "Lcom/coolapk/market/view/live/LiveMessageEvent;", "onLoadMore", "onPause", "onRefresh", "onRegisterCards", "onRequestFailure", "error", "", "onRequestResponse", "data", "onResume", "onSaveInstanceState", "outState", "reloadData", "scrollTo", "position", "offset", "(ILjava/lang/Integer;)V", "updateRecyclerViewBottomInset", "rect", "Landroid/graphics/Rect;", "updateUnreadMessage", "liveMessage", "Lcom/coolapk/market/model/LiveMessage;", "Companion", "DividerCallback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveDiscussFragment.kt */
public final class LiveDiscussFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_LIVE_ID = "LIVE_ID";
    private final CommandHelper commandHelper = new CommandHelper();
    private final Handler handler = new Handler();
    private final Lazy liveContext$delegate = LazyKt.lazy(new LiveDiscussFragment$liveContext$2(this));
    private final Lazy liveId$delegate = LazyKt.lazy(new LiveDiscussFragment$liveId$2(this));
    private LiveUnreadMessageHelper liveUnreadMessageHelper;
    private Runnable notifyItemRunnable;
    private final Lazy viewModel$delegate = LazyKt.lazy(new LiveDiscussFragment$viewModel$2(this));

    /* access modifiers changed from: private */
    public final LiveContext getLiveContext() {
        return (LiveContext) this.liveContext$delegate.getValue();
    }

    private final String getLiveId() {
        return (String) this.liveId$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LiveViewModel getViewModel() {
        return (LiveViewModel) this.viewModel$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/live/LiveDiscussFragment$Companion;", "", "()V", "KEY_LIVE_ID", "", "newInstance", "Lcom/coolapk/market/view/live/LiveDiscussFragment;", "liveId", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveDiscussFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveDiscussFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "liveId");
            LiveDiscussFragment liveDiscussFragment = new LiveDiscussFragment();
            Bundle bundle = new Bundle();
            bundle.putString("LIVE_ID", str);
            Unit unit = Unit.INSTANCE;
            liveDiscussFragment.setArguments(bundle);
            return liveDiscussFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setAutoUpdateContentUiOnDataChanged(true);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setStackFromEnd(true);
        Unit unit = Unit.INSTANCE;
        recyclerView.setLayoutManager(linearLayoutManager);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        ViewExtendsKt.removeAllItemDecorations(recyclerView2);
        getRecyclerView().addItemDecoration(new CustomizedItemDecoration(getAdapter$presentation_coolapkAppRelease(), new DividerCallback()));
        setLoadMoreEnable(false);
        getEntityDataFilterList$presentation_coolapkAppRelease().add(new LiveUpdateTabHelper());
        View view = getView();
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.liveUnreadMessageHelper = new LiveUnreadMessageHelper((FrameLayout) view, new LiveDiscussFragment$onActivityCreated$2(this));
        ArrayList<EntityDataFilter> entityDataFilterList$presentation_coolapkAppRelease = getEntityDataFilterList$presentation_coolapkAppRelease();
        LiveUnreadMessageHelper liveUnreadMessageHelper2 = this.liveUnreadMessageHelper;
        if (liveUnreadMessageHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveUnreadMessageHelper");
        }
        entityDataFilterList$presentation_coolapkAppRelease.add(liveUnreadMessageHelper2);
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public void updateRecyclerViewBottomInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView recyclerView2 = recyclerView;
        recyclerView2.setPadding(recyclerView2.getPaddingLeft(), recyclerView2.getPaddingTop(), recyclerView2.getPaddingRight(), rect.bottom + NumberExtendsKt.getDp((Number) 48));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    public void reloadData() {
        super.reloadData();
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected void onRegisterCards() {
        super.onRegisterCards();
        addEntityTemplate("liveMessage");
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), createFactor(new String[]{"liveMessage"}, 2131558815, new LiveDiscussFragment$onRegisterCards$1(this)), 0, 2, null);
        addEntityTemplate("liveSystemMessage");
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), createFactor(new String[]{"liveSystemMessage"}, 2131558816, LiveDiscussFragment$onRegisterCards$2.INSTANCE), 0, 2, null);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onRefresh() {
        setStopLoadMore(false);
        super.onLoadMore();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onLoadMore() {
        super.onRefresh();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findFirstLiveEntity = findFirstLiveEntity();
        Entity findLastLiveEntity = findLastLiveEntity();
        String str = null;
        String entityId = (!z || findLastLiveEntity == null) ? null : findLastLiveEntity.getEntityId();
        if (!z && findFirstLiveEntity != null) {
            str = findFirstLiveEntity.getEntityId();
        }
        Observable<R> map = DataManager.getInstance().getLiveMessageList(getLiveId(), "0", i, entityId, str).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e A[EDGE_INSN: B:16:0x003e->B:13:0x003e ?: BREAK  , SYNTHETIC] */
    private final Entity findLastLiveEntity() {
        Parcelable parcelable;
        boolean z;
        List<Parcelable> dataList = getDataList();
        ListIterator<Parcelable> listIterator = dataList.listIterator(dataList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                parcelable = null;
                break;
            }
            parcelable = listIterator.previous();
            Parcelable parcelable2 = parcelable;
            if (parcelable2 instanceof Entity) {
                Entity entity = (Entity) parcelable2;
                if (Intrinsics.areEqual(entity.getEntityType(), "liveMessage") || Intrinsics.areEqual(entity.getEntityType(), "liveSystemMessage")) {
                    z = true;
                    continue;
                    if (z) {
                        break;
                    }
                }
            }
            z = false;
            continue;
            if (z) {
            }
        }
        return (Entity) parcelable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c A[EDGE_INSN: B:15:0x003c->B:13:0x003c ?: BREAK  , SYNTHETIC] */
    private final Entity findFirstLiveEntity() {
        T t;
        boolean z;
        Iterator<T> it2 = getDataList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            T t2 = t;
            if (t2 instanceof Entity) {
                T t3 = t2;
                if (Intrinsics.areEqual(t3.getEntityType(), "liveMessage") || Intrinsics.areEqual(t3.getEntityType(), "liveSystemMessage")) {
                    z = true;
                    continue;
                    if (z) {
                        break;
                    }
                }
            }
            z = false;
            continue;
            if (z) {
            }
        }
        return t;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean z2;
        removeHintOrRefreshView();
        SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
        if (swipeRefreshLayout.isRefreshing()) {
            SwipeRefreshLayout swipeRefreshLayout2 = getSwipeRefreshLayout();
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout2, "swipeRefreshLayout");
            swipeRefreshLayout2.setRefreshing(false);
        }
        if (list != null && (!list.isEmpty())) {
            List reversed = CollectionsKt.reversed(modifyDataBeforeHandle(list, z));
            if (z) {
                getDataList().addAll(reversed);
            } else {
                List list2 = reversed;
                getDataList().addAll(0, list2);
                if (!UiUtils.canScrollDown(getRecyclerView()) && (!list2.isEmpty())) {
                    scrollTo(reversed.size() - 1, Integer.valueOf(NumberExtendsKt.getDp((Number) 8)));
                }
            }
        }
        Entity entity = null;
        if (list != null) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                T next = it2.next();
                T t = next;
                if (Intrinsics.areEqual(t.getEntityType(), "liveMessage") || Intrinsics.areEqual(t.getEntityType(), "liveSystemMessage")) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    entity = next;
                    break;
                }
            }
            entity = entity;
        }
        if (entity != null) {
            return true;
        }
        return false;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        String str = null;
        String str2 = null;
        if (th instanceof RuntimeException) {
            if (th.getCause() instanceof ClientException) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    str = cause.getMessage();
                }
                str2 = str;
            }
        } else if (th instanceof ClientException) {
            str2 = th.getMessage();
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = getString(2131886416);
        }
        setEmptyData(str2, 0);
        th.printStackTrace();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onLiveCommandEventChanged(LiveCommandEvent liveCommandEvent) {
        Intrinsics.checkNotNullParameter(liveCommandEvent, "event");
        try {
            if (this.notifyItemRunnable == null) {
                this.notifyItemRunnable = new LiveDiscussFragment$onLiveCommandEventChanged$1(this);
            }
            Handler handler2 = this.handler;
            Runnable runnable = this.notifyItemRunnable;
            Intrinsics.checkNotNull(runnable);
            handler2.removeCallbacks(runnable);
            Handler handler3 = this.handler;
            Runnable runnable2 = this.notifyItemRunnable;
            Intrinsics.checkNotNull(runnable2);
            handler3.postDelayed(runnable2, 800);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onLiveMessageEventChanged(LiveMessageEvent liveMessageEvent) {
        String messageType;
        List<LiveMessage> liveMessages;
        List<LiveMessage> liveMessages2;
        Intrinsics.checkNotNullParameter(liveMessageEvent, "event");
        if (isDataLoaded()) {
            int action = liveMessageEvent.getAction();
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 4 && (liveMessages2 = liveMessageEvent.getLiveMessages()) != null) {
                            Iterator<T> it2 = liveMessages2.iterator();
                            while (it2.hasNext()) {
                                updateUnreadMessage(it2.next());
                            }
                        }
                    } else if (!isRefreshing() && (liveMessages = liveMessageEvent.getLiveMessages()) != null) {
                        for (T t : liveMessages) {
                            getDataList().add(t);
                            autoScrollToBottom();
                            updateUnreadMessage(t);
                        }
                    }
                } else if (liveMessageEvent.getUid() != null) {
                    CollectionsKt.removeAll((List) getDataList(), (Function1) new LiveDiscussFragment$onLiveMessageEventChanged$1(liveMessageEvent));
                } else if (liveMessageEvent.getMessageId() != null) {
                    Iterator<Parcelable> it3 = getDataList().iterator();
                    while (it3.hasNext()) {
                        Parcelable next = it3.next();
                        if (next instanceof Entity) {
                            Entity entity = (Entity) next;
                            if (Intrinsics.areEqual(entity.getEntityType(), "liveMessage") && Intrinsics.areEqual(entity.getId(), liveMessageEvent.getMessageId())) {
                                it3.remove();
                                return;
                            }
                        }
                    }
                }
            } else if (!isRefreshing() && !isLoadingMore() && (messageType = liveMessageEvent.getMessageType()) != null && messageType.hashCode() == 48 && messageType.equals("0") && !isRefreshing()) {
                reloadData();
            }
        }
    }

    private final void updateUnreadMessage(LiveMessage liveMessage) {
        LiveUnreadMessageHelper liveUnreadMessageHelper2 = this.liveUnreadMessageHelper;
        if (liveUnreadMessageHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveUnreadMessageHelper");
        }
        liveUnreadMessageHelper2.handleLiveMessageInsert(liveMessage);
    }

    private final void autoScrollToBottom() {
        if (!UiUtils.canScrollUp(getRecyclerView()) && CollectionsKt.getLastIndex(getDataList()) > 0) {
            scrollTo$default(this, CollectionsKt.getLastIndex(getDataList()), null, 2, null);
        }
    }

    static /* synthetic */ void scrollTo$default(LiveDiscussFragment liveDiscussFragment, int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        liveDiscussFragment.scrollTo(i, num);
    }

    private final void scrollTo(int i, Integer num) {
        if (num != null) {
            RecyclerView recyclerView = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, num.intValue());
            return;
        }
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        RecyclerView.LayoutManager layoutManager2 = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager2).scrollToPosition(i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/live/LiveDiscussFragment$DividerCallback;", "Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration$SimpleCallback;", "()V", "getBottomDividerHeight", "", "getDrawRect", "", "outRect", "Landroid/graphics/Rect;", "position", "getOutsideRectColor", "rect", "getRectColor", "getTopDividerHeight", "getTopOrBottomDividerColor", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveDiscussFragment.kt */
    private static final class DividerCallback extends CustomizedItemDecoration.SimpleCallback {
        @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.SimpleCallback, com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
        public int getOutsideRectColor(Rect rect, int i) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            return 0;
        }

        @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.SimpleCallback, com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
        public int getRectColor(Rect rect, int i) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            return 0;
        }

        @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.SimpleCallback, com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
        public int getTopOrBottomDividerColor() {
            return 0;
        }

        @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
        public void getDrawRect(Rect rect, int i) {
            Intrinsics.checkNotNullParameter(rect, "outRect");
            rect.set(0, 0, 0, getNormalDividerHeight());
        }

        @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.SimpleCallback, com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
        public int getTopDividerHeight() {
            return getNormalDividerHeight();
        }

        @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.SimpleCallback, com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
        public int getBottomDividerHeight() {
            return getNormalDividerHeight();
        }
    }
}
