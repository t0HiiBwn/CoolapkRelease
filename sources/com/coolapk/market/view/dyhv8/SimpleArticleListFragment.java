package com.coolapk.market.view.dyhv8;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.event.DyhArticleSetTopEvent;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.event.SetTopEvent;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.DividerRule;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.view.cardlist.divider.ViewMarginRule;
import com.coolapk.market.widget.Toast;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0003$%&B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001cH\u0007J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J \u0010 \u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020#H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/coolapk/market/view/dyhv8/SimpleArticleListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "id", "", "loginSession", "Lcom/coolapk/market/local/LoginSession;", "kotlin.jvm.PlatformType", "status", "", "type", "getFirstNotTopIndex", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "onDyhArticleSetetTop", "event", "Lcom/coolapk/market/event/DyhArticleSetTopEvent;", "onFeedSetTop", "Lcom/coolapk/market/event/SetTopEvent;", "onRequestFailure", "error", "", "onRequestResponse", "data", "shouldInterceptFeedEvent", "", "CenterListDividerRule", "CenterListViewMarginRule", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleArticleListFragment.kt */
public final class SimpleArticleListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_DATA = "DATA";
    public static final String KEY_ID = "ID";
    public static final String KEY_STATUS = "STATUS";
    public static final String KEY_TYPE = "TYPE";
    private String id;
    private final LoginSession loginSession;
    private int status;
    private String type;

    @JvmStatic
    public static final SimpleArticleListFragment newInstance(String str, String str2, int i) {
        return Companion.newInstance(str, str2, i);
    }

    public SimpleArticleListFragment() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        this.loginSession = instance.getLoginSession();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/dyhv8/SimpleArticleListFragment$Companion;", "", "()V", "KEY_DATA", "", "KEY_ID", "KEY_STATUS", "KEY_TYPE", "newInstance", "Lcom/coolapk/market/view/dyhv8/SimpleArticleListFragment;", "id", "type", "status", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SimpleArticleListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final SimpleArticleListFragment newInstance(String str, String str2, int i) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "type");
            SimpleArticleListFragment simpleArticleListFragment = new SimpleArticleListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("ID", str);
            bundle.putString("TYPE", str2);
            bundle.putInt("STATUS", i);
            Unit unit = Unit.INSTANCE;
            simpleArticleListFragment.setArguments(bundle);
            return simpleArticleListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("ID");
        Intrinsics.checkNotNull(string);
        this.id = string;
        String string2 = requireArguments().getString("TYPE");
        Intrinsics.checkNotNull(string2);
        this.type = string2;
        this.status = requireArguments().getInt("STATUS");
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View emptyView = getEmptyView();
        Intrinsics.checkNotNullExpressionValue(emptyView, "emptyView");
        emptyView.setTranslationY((float) (-DisplayUtils.dp2px(getActivity(), 142.0f)));
        View loadingView = getLoadingView();
        Intrinsics.checkNotNullExpressionValue(loadingView, "loadingView");
        loadingView.setTranslationY((float) (-DisplayUtils.dp2px(getActivity(), 142.0f)));
        getVxDividerDecoration$presentation_coolapkAppRelease().addViewMarginRule(new CenterListViewMarginRule());
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new CenterListDividerRule());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/dyhv8/SimpleArticleListFragment$CenterListViewMarginRule;", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginRule;", "()V", "getViewMarginData", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginData;", "position", "", "current", "", "default", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SimpleArticleListFragment.kt */
    public static final class CenterListViewMarginRule implements ViewMarginRule {
        @Override // com.coolapk.market.view.cardlist.divider.ViewMarginRule
        public ViewMarginData getViewMarginData(int i, Object obj, ViewMarginData viewMarginData) {
            Intrinsics.checkNotNullParameter(obj, "current");
            Intrinsics.checkNotNullParameter(viewMarginData, "default");
            if (!(obj instanceof Entity)) {
                return ViewMarginData.Companion.getEMPTY();
            }
            return ViewMarginData.Companion.getDEFAULT();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/dyhv8/SimpleArticleListFragment$CenterListDividerRule;", "Lcom/coolapk/market/view/cardlist/divider/DividerRule;", "()V", "getDividerData", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "rawPosition", "", "current", "", "next", "getDividerHeight", "entity", "Lcom/coolapk/market/model/Entity;", "nextEntity", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SimpleArticleListFragment.kt */
    public static final class CenterListDividerRule implements DividerRule {
        @Override // com.coolapk.market.view.cardlist.divider.DividerRule
        public DividerData getDividerData(int i, Object obj, Object obj2) {
            if (!(obj instanceof Entity) || !(obj2 instanceof Entity)) {
                return null;
            }
            return getDividerHeight((Entity) obj, (Entity) obj2);
        }

        public final DividerData getDividerHeight(Entity entity, Entity entity2) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(entity2, "nextEntity");
            return DividerData.Companion.getH12DP();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        DataManager instance = DataManager.getInstance();
        String str = this.id;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("id");
        }
        String str2 = this.type;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
        }
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        Observable<R> compose = instance.getArticleList(str, str2, i, entityId, findLastEntity$default != null ? findLastEntity$default.getEntityId() : null).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        removeNoMoreDataView();
        if (list != null) {
            list.size();
        }
        boolean onRequestResponse = super.onRequestResponse(z, list);
        boolean z2 = true;
        boolean z3 = EntityListFragment.findFirstEntityIndex$default(this, "article", null, false, false, 14, null) < 0;
        if (EntityListFragment.findFirstEntityIndex$default(this, "feed", null, false, false, 14, null) >= 0) {
            z2 = false;
        }
        if (!onRequestResponse && z3 && z2) {
            setEmptyData(this.status == 0 ? "看看号信息待小编审核中…" : "这里空空的", 0);
        } else if (!onRequestResponse && !z) {
            addNoMoreDataView();
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        Toast.error(getActivity(), th);
    }

    @Subscribe
    public final void onDyhArticleSetetTop(DyhArticleSetTopEvent dyhArticleSetTopEvent) {
        Intrinsics.checkNotNullParameter(dyhArticleSetTopEvent, "event");
        if (getActivity() instanceof DyhDetailActivity) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.dyhv8.DyhDetailActivity");
            Integer page = ((DyhDetailActivity) activity).getPage();
            Intrinsics.checkNotNull(page);
            if (page.intValue() > 0) {
                return;
            }
        }
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof DyhArticle) {
                T t2 = t;
                if (Intrinsics.areEqual(t2.getId(), dyhArticleSetTopEvent.getDyhArticleId())) {
                    DyhArticle handleEvent = dyhArticleSetTopEvent.handleEvent(t2);
                    if (dyhArticleSetTopEvent.isTop()) {
                        getDataList().remove(i);
                        List<Parcelable> dataList = getDataList();
                        Intrinsics.checkNotNullExpressionValue(handleEvent, "dyhArticle");
                        dataList.add(0, handleEvent);
                        return;
                    }
                    getDataList().remove(i);
                    List<Parcelable> dataList2 = getDataList();
                    int firstNotTopIndex = getFirstNotTopIndex();
                    Intrinsics.checkNotNullExpressionValue(handleEvent, "dyhArticle");
                    dataList2.add(firstNotTopIndex, handleEvent);
                    return;
                }
            }
            i++;
        }
    }

    @Subscribe
    public final void onFeedSetTop(SetTopEvent setTopEvent) {
        Intrinsics.checkNotNullParameter(setTopEvent, "event");
        if (getActivity() instanceof DyhDetailActivity) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.dyhv8.DyhDetailActivity");
            Integer page = ((DyhDetailActivity) activity).getPage();
            Intrinsics.checkNotNull(page);
            if (page.intValue() > 0) {
                return;
            }
        }
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof Feed) {
                T t2 = t;
                if (Intrinsics.areEqual(t2.getId(), setTopEvent.getId())) {
                    Feed handleFeedEvent = setTopEvent.handleFeedEvent(t2);
                    if (setTopEvent.isTop()) {
                        getDataList().remove(i);
                        List<Parcelable> dataList = getDataList();
                        Intrinsics.checkNotNullExpressionValue(handleFeedEvent, "feed");
                        dataList.add(0, handleFeedEvent);
                        return;
                    }
                    getDataList().remove(i);
                    List<Parcelable> dataList2 = getDataList();
                    int firstNotTopIndex = getFirstNotTopIndex();
                    Intrinsics.checkNotNullExpressionValue(handleFeedEvent, "feed");
                    dataList2.add(firstNotTopIndex, handleFeedEvent);
                    return;
                }
            }
            i++;
        }
    }

    private final int getFirstNotTopIndex() {
        if (CollectionUtils.isEmpty(getDataList())) {
            return -1;
        }
        int i = 0;
        for (T t : getDataList()) {
            if ((t instanceof DyhArticle) && !t.isTop()) {
                return i;
            }
            if ((t instanceof Feed) && !t.isTop()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.feed.FeedEventProcessor.EventInterceptor
    public boolean shouldInterceptFeedEvent(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "event");
        if (!(obj instanceof FeedPostEvent)) {
            return super.shouldInterceptFeedEvent(obj);
        }
        Feed feed = ((FeedPostEvent) obj).getFeed();
        if (feed != null && Intrinsics.areEqual(feed.getFeedType(), "feed")) {
            LoginSession loginSession2 = this.loginSession;
            Intrinsics.checkNotNullExpressionValue(loginSession2, "loginSession");
            if (!loginSession2.isLogin() || EntityListFragment.findFirstEntityIndex$default(this, "REFRESH_PROGRESS_BAR", null, false, false, 6, null) >= 0) {
                return true;
            }
            String str = this.type;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("type");
            }
            if (TextUtils.equals(str, "square")) {
                getDataList().add(0, feed);
                getRecyclerView().scrollToPosition(0);
            }
        }
        return true;
    }
}
