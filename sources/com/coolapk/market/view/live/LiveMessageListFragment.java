package com.coolapk.market.view.live;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.util.RxUtils;
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
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u000b\u0018\u0000 72\u00020\u0001:\u000278B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160 0\u001f2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0007J\b\u0010(\u001a\u00020\u001bH\u0014J\b\u0010)\u001a\u00020\u001bH\u0016J\b\u0010*\u001a\u00020\u001bH\u0014J\b\u0010+\u001a\u00020\u001bH\u0014J\u0018\u0010,\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H\u0014J \u0010/\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 H\u0014J\b\u00101\u001a\u00020\u001bH\u0016J\b\u00102\u001a\u00020\u001bH\u0016J!\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020#2\n\b\u0002\u00105\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u00106R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000e\u0010\bR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013¨\u00069"}, d2 = {"Lcom/coolapk/market/view/live/LiveMessageListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "firstShowList", "", "liveId", "", "getLiveId", "()Ljava/lang/String;", "liveId$delegate", "Lkotlin/Lazy;", "liveUnreadMessageHelper", "Lcom/coolapk/market/view/live/LiveUnreadMessageHelper;", "messageType", "getMessageType", "messageType$delegate", "viewModel", "Lcom/coolapk/market/view/live/LiveViewModel;", "getViewModel", "()Lcom/coolapk/market/view/live/LiveViewModel;", "viewModel$delegate", "findFirstLiveEntity", "Lcom/coolapk/market/model/Entity;", "findLastLiveEntity", "getLiveContent", "Lcom/coolapk/market/view/live/LiveContext;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "isRefresh", "page", "", "onDestroyView", "onLiveMessageEventChanged", "event", "Lcom/coolapk/market/view/live/LiveMessageEvent;", "onLoadMore", "onPause", "onRefresh", "onRegisterCards", "onRequestFailure", "error", "", "onRequestResponse", "data", "onResume", "reloadData", "scrollTo", "position", "offset", "(ILjava/lang/Integer;)V", "Companion", "DividerCallback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveMessageListFragment.kt */
public final class LiveMessageListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_LIVE_ID = "LIVE_ID";
    public static final String KEY_MESSAGE_TYPE = "MESSAGE_TYPE";
    private boolean firstShowList = true;
    private final Lazy liveId$delegate = LazyKt.lazy(new LiveMessageListFragment$liveId$2(this));
    private LiveUnreadMessageHelper liveUnreadMessageHelper;
    private final Lazy messageType$delegate = LazyKt.lazy(new LiveMessageListFragment$messageType$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new LiveMessageListFragment$viewModel$2(this));

    private final String getLiveId() {
        return (String) this.liveId$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getMessageType() {
        return (String) this.messageType$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LiveViewModel getViewModel() {
        return (LiveViewModel) this.viewModel$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/live/LiveMessageListFragment$Companion;", "", "()V", "KEY_LIVE_ID", "", "KEY_MESSAGE_TYPE", "newInstance", "Lcom/coolapk/market/view/live/LiveMessageListFragment;", "liveId", "messageType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveMessageListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveMessageListFragment newInstance(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "liveId");
            Intrinsics.checkNotNullParameter(str2, "messageType");
            LiveMessageListFragment liveMessageListFragment = new LiveMessageListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("LIVE_ID", str);
            bundle.putString("MESSAGE_TYPE", str2);
            Unit unit = Unit.INSTANCE;
            liveMessageListFragment.setArguments(bundle);
            return liveMessageListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        String messageType = getMessageType();
        int hashCode = messageType.hashCode();
        if (hashCode != 48) {
            if (hashCode == 49 && messageType.equals("1")) {
                getRecyclerView().setBackgroundResource(AppHolder.getAppTheme().isDarkTheme() ? 2131231737 : 2131231736);
            }
        } else if (messageType.equals("0")) {
            getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
            setLoadMoreEnable(false);
        }
        getEntityDataFilterList$presentation_coolapkAppRelease().add(new LiveUpdateTabHelper());
        View view = getView();
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.liveUnreadMessageHelper = new LiveUnreadMessageHelper((FrameLayout) view, new LiveMessageListFragment$onActivityCreated$1(this));
        ArrayList<EntityDataFilter> entityDataFilterList$presentation_coolapkAppRelease = getEntityDataFilterList$presentation_coolapkAppRelease();
        LiveUnreadMessageHelper liveUnreadMessageHelper2 = this.liveUnreadMessageHelper;
        if (liveUnreadMessageHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveUnreadMessageHelper");
        }
        entityDataFilterList$presentation_coolapkAppRelease.add(liveUnreadMessageHelper2);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewExtendsKt.removeAllItemDecorations(recyclerView);
        RecyclerView recyclerView2 = getRecyclerView();
        String messageType2 = getMessageType();
        Intrinsics.checkNotNullExpressionValue(messageType2, "messageType");
        recyclerView2.addItemDecoration(new CustomizedItemDecoration(getAdapter$presentation_coolapkAppRelease(), new DividerCallback(messageType2, getViewModel())));
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        isDataLoaded();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    public void reloadData() {
        super.reloadData();
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
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), createFactor(new String[]{"liveMessage"}, 2131558815, new LiveMessageListFragment$onRegisterCards$1(this)), 0, 2, null);
        addEntityTemplate("liveSystemMessage");
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), createFactor(new String[]{"liveSystemMessage"}, 2131558816, LiveMessageListFragment$onRegisterCards$2.INSTANCE), 0, 2, null);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onRefresh() {
        String messageType = getMessageType();
        int hashCode = messageType.hashCode();
        if (hashCode != 48) {
            if (hashCode == 49 && messageType.equals("1")) {
                super.onRefresh();
            }
        } else if (messageType.equals("0")) {
            setStopLoadMore(false);
            super.onLoadMore();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onLoadMore() {
        String messageType = getMessageType();
        int hashCode = messageType.hashCode();
        if (hashCode != 48) {
            if (hashCode == 49 && messageType.equals("1")) {
                super.onLoadMore();
            }
        } else if (messageType.equals("0")) {
            super.onRefresh();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String str;
        String str2;
        String entityId;
        String str3 = null;
        String str4 = null;
        Entity findFirstLiveEntity = findFirstLiveEntity();
        Entity findLastLiveEntity = findLastLiveEntity();
        String messageType = getMessageType();
        int hashCode = messageType.hashCode();
        if (hashCode != 48) {
            if (hashCode == 49 && messageType.equals("1")) {
                entityId = (!z || findFirstLiveEntity == null) ? null : findFirstLiveEntity.getEntityId();
                if (!z && findLastLiveEntity != null) {
                    str3 = findLastLiveEntity.getEntityId();
                }
            }
            str2 = str4;
            str = str2;
            Observable<R> map = DataManager.getInstance().getLiveMessageList(getLiveId(), getMessageType(), i, str2, str).map(RxUtils.checkResultToData());
            Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
            return map;
        }
        if (messageType.equals("0")) {
            entityId = (!z || findLastLiveEntity == null) ? null : findLastLiveEntity.getEntityId();
            if (!z && findFirstLiveEntity != null) {
                str3 = findFirstLiveEntity.getEntityId();
            }
        }
        str2 = str4;
        str = str2;
        Observable<R> map = DataManager.getInstance().getLiveMessageList(getLiveId(), getMessageType(), i, str2, str).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
        str = str3;
        str2 = entityId;
        Observable<R> map = DataManager.getInstance().getLiveMessageList(getLiveId(), getMessageType(), i, str2, str).map(RxUtils.checkResultToData());
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
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        changeDataListAndAutoCalculateDiff(new LiveMessageListFragment$onRequestResponse$1(this, z, list, booleanRef));
        return booleanRef.element;
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
    public final void onLiveMessageEventChanged(LiveMessageEvent liveMessageEvent) {
        List<LiveMessage> liveMessages;
        Sequence asSequence;
        Sequence<LiveMessage> filter;
        Intrinsics.checkNotNullParameter(liveMessageEvent, "event");
        if (isDataLoaded()) {
            int action = liveMessageEvent.getAction();
            if (action != 1) {
                if (action != 2) {
                    if (!((action != 3 && action != 4) || isRefreshing() || (liveMessages = liveMessageEvent.getLiveMessages()) == null || (asSequence = CollectionsKt.asSequence(liveMessages)) == null || (filter = SequencesKt.filter(asSequence, LiveMessageListFragment$onLiveMessageEventChanged$2.INSTANCE)) == null)) {
                        for (LiveMessage liveMessage : filter) {
                            getDataList().add(0, liveMessage);
                            scrollTo$default(this, 0, null, 2, null);
                            LiveUnreadMessageHelper liveUnreadMessageHelper2 = this.liveUnreadMessageHelper;
                            if (liveUnreadMessageHelper2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("liveUnreadMessageHelper");
                            }
                            liveUnreadMessageHelper2.handleLiveMessageInsert(liveMessage);
                        }
                    }
                } else if (liveMessageEvent.getUid() != null) {
                    CollectionsKt.removeAll((List) getDataList(), (Function1) new LiveMessageListFragment$onLiveMessageEventChanged$1(liveMessageEvent));
                } else if (liveMessageEvent.getMessageId() != null) {
                    Iterator<Parcelable> it2 = getDataList().iterator();
                    while (it2.hasNext()) {
                        Parcelable next = it2.next();
                        if (next instanceof Entity) {
                            Entity entity = (Entity) next;
                            if (Intrinsics.areEqual(entity.getEntityType(), "liveMessage") && Intrinsics.areEqual(entity.getId(), liveMessageEvent.getMessageId())) {
                                it2.remove();
                                return;
                            }
                        }
                    }
                }
            } else if (!isRefreshing() && !isLoadingMore()) {
                String messageType = liveMessageEvent.getMessageType();
                if (messageType != null) {
                    int hashCode = messageType.hashCode();
                    if (hashCode != 48) {
                        if (hashCode == 49 && messageType.equals("1")) {
                            if (Intrinsics.areEqual(liveMessageEvent.getMessageType(), getMessageType()) && !isRefreshing()) {
                                reloadData();
                                scrollTo$default(this, 0, null, 2, null);
                                return;
                            }
                            return;
                        }
                    } else if (messageType.equals("0")) {
                        if (Intrinsics.areEqual(liveMessageEvent.getMessageType(), getMessageType()) && !isRefreshing()) {
                            reloadData();
                            if (CollectionsKt.getLastIndex(getDataList()) > 0) {
                                getAdapter$presentation_coolapkAppRelease().notifyItemChanged(CollectionsKt.getLastIndex(getDataList()) - 1);
                                scrollTo$default(this, CollectionsKt.getLastIndex(getDataList()), null, 2, null);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                if (!isRefreshing()) {
                    reloadData();
                    scrollTo$default(this, 0, null, 2, null);
                }
            }
        }
    }

    static /* synthetic */ void scrollTo$default(LiveMessageListFragment liveMessageListFragment, int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        liveMessageListFragment.scrollTo(i, num);
    }

    /* access modifiers changed from: private */
    public final void scrollTo(int i, Integer num) {
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

    /* access modifiers changed from: private */
    public final LiveContext getLiveContent() {
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.live.LiveContext");
        return (LiveContext) activity;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/live/LiveMessageListFragment$DividerCallback;", "Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration$SimpleCallback;", "messageType", "", "viewModel", "Lcom/coolapk/market/view/live/LiveViewModel;", "(Ljava/lang/String;Lcom/coolapk/market/view/live/LiveViewModel;)V", "getBottomDividerHeight", "", "getDrawRect", "", "outRect", "Landroid/graphics/Rect;", "position", "getOutsideRectColor", "rect", "getRectColor", "getTopDividerHeight", "getTopOrBottomDividerColor", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveMessageListFragment.kt */
    public static final class DividerCallback extends CustomizedItemDecoration.SimpleCallback {
        private final String messageType;
        private final LiveViewModel viewModel;

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

        public DividerCallback(String str, LiveViewModel liveViewModel) {
            Intrinsics.checkNotNullParameter(str, "messageType");
            Intrinsics.checkNotNullParameter(liveViewModel, "viewModel");
            this.messageType = str;
            this.viewModel = liveViewModel;
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
            int i;
            String str = this.messageType;
            int hashCode = str.hashCode();
            if (hashCode != 48) {
                if (hashCode == 49 && str.equals("1") && this.viewModel.currentUserIsPresenter()) {
                    i = NumberExtendsKt.getDp((Number) 48);
                    return getNormalDividerHeight() + i;
                }
            } else if (str.equals("0")) {
                i = NumberExtendsKt.getDp((Number) 48);
                return getNormalDividerHeight() + i;
            }
            i = 0;
            return getNormalDividerHeight() + i;
        }
    }
}
