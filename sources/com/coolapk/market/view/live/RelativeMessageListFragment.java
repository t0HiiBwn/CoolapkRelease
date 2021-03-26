package com.coolapk.market.view.live;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Live;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityDataFilter;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.decoration.CustomizedItemDecoration;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\fH\u0014J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0016H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/live/RelativeMessageListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "live", "Lcom/coolapk/market/model/Live;", "getLive", "()Lcom/coolapk/market/model/Live;", "live$delegate", "Lkotlin/Lazy;", "getLiveReplyContext", "Lcom/coolapk/market/view/live/LiveReplyContext;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "onDestroyView", "onLiveMessageEventChanged", "event", "Lcom/coolapk/market/view/live/LiveMessageEvent;", "onRegisterCards", "scrollTo", "position", "Companion", "DividerCallback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RelativeMessageListFragment.kt */
public final class RelativeMessageListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_LIVE = "LIVE";
    private final Lazy live$delegate = LazyKt.lazy(new RelativeMessageListFragment$live$2(this));

    /* access modifiers changed from: private */
    public final Live getLive() {
        return (Live) this.live$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/live/RelativeMessageListFragment$Companion;", "", "()V", "KEY_LIVE", "", "newInstance", "Lcom/coolapk/market/view/live/RelativeMessageListFragment;", "live", "Lcom/coolapk/market/model/Live;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RelativeMessageListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RelativeMessageListFragment newInstance(Live live) {
            Intrinsics.checkNotNullParameter(live, "live");
            RelativeMessageListFragment relativeMessageListFragment = new RelativeMessageListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("LIVE", live);
            Unit unit = Unit.INSTANCE;
            relativeMessageListFragment.setArguments(bundle);
            return relativeMessageListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ArrayList<EntityDataFilter> entityDataFilterList$presentation_coolapkAppRelease = getEntityDataFilterList$presentation_coolapkAppRelease();
        View view = getView();
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        entityDataFilterList$presentation_coolapkAppRelease.add(new LiveUnreadMessageHelper((FrameLayout) view, null));
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewExtendsKt.removeAllItemDecorations(recyclerView);
        getRecyclerView().addItemDecoration(new CustomizedItemDecoration(getAdapter$presentation_coolapkAppRelease(), new DividerCallback()));
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
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
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), createFactor(new String[]{"liveMessage"}, 2131558815, new RelativeMessageListFragment$onRegisterCards$1(this)), 0, 2, null);
        addEntityTemplate("liveSystemMessage");
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), createFactor(new String[]{"liveSystemMessage"}, 2131558816, RelativeMessageListFragment$onRegisterCards$2.INSTANCE), 0, 2, null);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        DataManager instance = DataManager.getInstance();
        Live live = getLive();
        Intrinsics.checkNotNullExpressionValue(live, "live");
        Observable<R> map = instance.getLiveMessageList(live.getId(), "2", i, (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId(), (z || (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) == null) ? null : findLastEntity$default.getEntityId()).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onLiveMessageEventChanged(LiveMessageEvent liveMessageEvent) {
        Intrinsics.checkNotNullParameter(liveMessageEvent, "event");
        if (!isRefreshing() && !isLoadingMore()) {
            reloadData();
        }
    }

    private final void scrollTo(int i) {
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPosition(i);
    }

    /* access modifiers changed from: private */
    public final LiveReplyContext getLiveReplyContext() {
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.live.LiveReplyContext");
        return (LiveReplyContext) activity;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/live/RelativeMessageListFragment$DividerCallback;", "Lcom/coolapk/market/widget/decoration/CustomizedItemDecoration$SimpleCallback;", "()V", "getBottomDividerHeight", "", "getDrawRect", "", "outRect", "Landroid/graphics/Rect;", "position", "getOutsideRectColor", "rect", "getRectColor", "getTopDividerHeight", "getTopOrBottomDividerColor", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RelativeMessageListFragment.kt */
    public static final class DividerCallback extends CustomizedItemDecoration.SimpleCallback {
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
