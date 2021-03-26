package com.coolapk.market.view.collectionList;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.event.RemoveItemEvent;
import com.coolapk.market.event.SetTopEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.ItemPlaceHolder;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.collectionList.CollectionActionBarViewPart;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.view.user.EntityFollowEvent;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\"\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J$\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0015H\u0016J)\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u00010\u00152\b\u00101\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0002\u00103J)\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u00010\u00152\b\u00101\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0002\u00103J\u0010\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u001dH\u0014J\u0010\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020<H\u0007J \u0010=\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u0014J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020@H\u0007J\b\u0010A\u001a\u00020\u001dH\u0016J\u0006\u0010B\u001a\u00020\u001dJ\u0010\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020EH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionDetailFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "Lcom/coolapk/market/view/collectionList/CollectionDetailView;", "()V", "colId", "", "collection", "Lcom/coolapk/market/model/Collection;", "collectionBarViewPart", "Lcom/coolapk/market/view/collectionList/CollectionActionBarViewPart;", "collectionPresenter", "Lcom/coolapk/market/view/collectionList/CollectionDetailPresenter;", "getCollectionPresenter$presentation_coolapkAppRelease", "()Lcom/coolapk/market/view/collectionList/CollectionDetailPresenter;", "setCollectionPresenter$presentation_coolapkAppRelease", "(Lcom/coolapk/market/view/collectionList/CollectionDetailPresenter;)V", "isInit", "", "()Z", "isLoadHeader", "filterDataWhenRefresh", "", "originData", "", "index", "newDataByCardId", "", "getFirstNotTopIndex", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCollectionLoaded", "onCollectionUpdate", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "onFollowCollectionResult", "following", "result", "error", "", "(ZLjava/lang/Integer;Ljava/lang/Throwable;)V", "onLikeResult", "like", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRegisterCards", "onRemoveItemEventChange", "event", "Lcom/coolapk/market/event/RemoveItemEvent;", "onRequestResponse", "data", "onSetTop", "Lcom/coolapk/market/event/SetTopEvent;", "setupCommentBar", "setupToolbar", "updateRecyclerViewBottomInset", "rect", "Landroid/graphics/Rect;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionDetailFragment.kt */
public final class CollectionDetailFragment extends EntityListFragment implements CollectionDetailView {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_COLLECTION_HEADER = "COLLECTION_HEADER";
    private String colId;
    private Collection collection;
    private CollectionActionBarViewPart collectionBarViewPart;
    public CollectionDetailPresenter collectionPresenter;
    private boolean isLoadHeader;

    public static final /* synthetic */ String access$getColId$p(CollectionDetailFragment collectionDetailFragment) {
        String str = collectionDetailFragment.colId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colId");
        }
        return str;
    }

    public static final /* synthetic */ Collection access$getCollection$p(CollectionDetailFragment collectionDetailFragment) {
        Collection collection2 = collectionDetailFragment.collection;
        if (collection2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collection");
        }
        return collection2;
    }

    private final boolean isInit() {
        return !getDataList().isEmpty();
    }

    public final CollectionDetailPresenter getCollectionPresenter$presentation_coolapkAppRelease() {
        CollectionDetailPresenter collectionDetailPresenter = this.collectionPresenter;
        if (collectionDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionPresenter");
        }
        return collectionDetailPresenter;
    }

    public final void setCollectionPresenter$presentation_coolapkAppRelease(CollectionDetailPresenter collectionDetailPresenter) {
        Intrinsics.checkNotNullParameter(collectionDetailPresenter, "<set-?>");
        this.collectionPresenter = collectionDetailPresenter;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("EXTRA_COLLECTION_ID");
        Intrinsics.checkNotNull(string);
        this.colId = string;
        StatisticHelper.Companion.getInstance().recordNodeClickAction("收藏单");
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), 64.0f));
        getSwipeRefreshLayout().setProgressViewOffset(false, DisplayUtils.dp2px(getActivity(), 80.0f), DisplayUtils.dp2px(getActivity(), 120.0f));
        getVxDividerDecoration$presentation_coolapkAppRelease().addViewMarginRule(new CollectionDetailFragment$onActivityCreated$1());
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new CollectionDetailFragment$onActivityCreated$2());
        getDataBindingInterceptor$presentation_coolapkAppRelease().addCardStyleRule(new CollectionDetailFragment$onActivityCreated$3());
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected void onRegisterCards() {
        super.onRegisterCards();
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558655).suitedMethod(CollectionDetailFragment$onRegisterCards$1.INSTANCE).constructor(new CollectionDetailFragment$onRegisterCards$2(this)).build(), 0);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558858).suitedMethod(CollectionDetailFragment$onRegisterCards$3.INSTANCE).constructor(new CollectionDetailFragment$onRegisterCards$4(this)).build(), 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        menuInflater.inflate(2131623945, menu);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        MenuItem findItem = menu.findItem(2131361891);
        MenuItem findItem2 = menu.findItem(2131361901);
        MenuItem findItem3 = menu.findItem(2131361892);
        if (findItem != null) {
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            if (loginSession.isLogin()) {
                String uid = loginSession.getUid();
                Collection collection2 = this.collection;
                if (collection2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collection");
                }
                if (TextUtils.equals(uid, collection2.getUid())) {
                    findItem.setVisible(true);
                }
            }
        }
        if (findItem3 != null) {
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            if (loginSession.isLogin()) {
                String uid2 = loginSession.getUid();
                Collection collection3 = this.collection;
                if (collection3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collection");
                }
                if (TextUtils.equals(uid2, collection3.getUid())) {
                    findItem3.setVisible(true);
                }
            }
        }
        if (findItem != null) {
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            String uid3 = loginSession.getUid();
            Collection collection4 = this.collection;
            if (collection4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("collection");
            }
            if (TextUtils.equals(uid3, collection4.getUid())) {
                Intrinsics.checkNotNullExpressionValue(findItem2, "editMenuItem");
                findItem2.setVisible(true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        switch (menuItem.getItemId()) {
            case 2131361891:
                ConfirmDialog newInstance = ConfirmDialog.newInstance("", "确定要删除此收藏单么？删除后会取消收藏内部所有的内容", "确定", "取消");
                newInstance.setOnOkRunnable(new CollectionDetailFragment$onOptionsItemSelected$1(this));
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
                return true;
            case 2131361892:
                ConfirmDialog newInstance2 = ConfirmDialog.newInstance("", "你确定要清除这个收藏单内的所有失效收藏么？约在5分钟后完成清除", "确认清除", "取消");
                newInstance2.setOnOkRunnable(new CollectionDetailFragment$onOptionsItemSelected$2(this));
                FragmentActivity requireActivity2 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                FragmentManager supportFragmentManager2 = ContextExtendsKt.requireAppCompatActivity(requireActivity2).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "requireActivity().requir…().supportFragmentManager");
                newInstance2.show(supportFragmentManager2, (String) null);
                return true;
            case 2131361901:
                FragmentActivity activity = getActivity();
                Collection collection2 = this.collection;
                if (collection2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collection");
                }
                ActionManager.startCollectionEditActivity(activity, collection2);
                break;
            case 2131361968:
                Collection collection3 = this.collection;
                if (collection3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collection");
                }
                if (collection3.getIsOpened()) {
                    FragmentActivity activity2 = getActivity();
                    Collection collection4 = this.collection;
                    if (collection4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("collection");
                    }
                    ActionManager.shareText(activity2, collection4);
                    break;
                } else {
                    Toast.show$default(getActivity(), "该收藏单为私密收藏单，无法分享", 0, false, 12, null);
                    return false;
                }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<List<Entity>> defer = Observable.defer(new CollectionDetailFragment$onCreateRequest$loadCollrctionItemList$1(this, i));
        if (!isInit()) {
            DataManager instance = DataManager.getInstance();
            String str = this.colId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colId");
            }
            Observable<R> flatMap = instance.getCollectionDetail(str).compose(RxUtils.apiCommonToData()).doOnNext(new CollectionDetailFragment$onCreateRequest$1(this)).flatMap(new CollectionDetailFragment$onCreateRequest$2(defer));
            Intrinsics.checkNotNullExpressionValue(flatMap, "DataManager.getInstance(… loadCollrctionItemList }");
            return flatMap;
        }
        Intrinsics.checkNotNullExpressionValue(defer, "loadCollrctionItemList");
        return defer;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (CollectionUtils.isEmpty(list) && CollectionUtils.isEmpty(getDataList())) {
            addHintView("这里空空的", CollectionDetailFragment$onRequestResponse$1.INSTANCE);
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (obj instanceof Collection) {
            return -1;
        }
        return super.filterDataWhenRefresh(obj, i, map);
    }

    /* access modifiers changed from: private */
    public final void onCollectionLoaded(Collection collection2) {
        this.collection = collection2;
        if (!this.isLoadHeader) {
            getDataList().add(0, collection2);
            this.isLoadHeader = true;
        }
        updateContentUI();
        setupCommentBar();
        setupToolbar();
        this.collectionPresenter = new CollectionDetailPresenter(collection2, this);
        setHasOptionsMenu(true);
    }

    public final void setupToolbar() {
        FragmentActivity activity = getActivity();
        if (activity instanceof AlphableToolbar) {
            ((AlphableToolbar) activity).setToolbarAlpha(0.0f);
            FragmentActivity fragmentActivity = activity;
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(DisplayUtils.dp2px(fragmentActivity, 40.0f), new CollectionDetailFragment$setupToolbar$1(this, activity)));
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(DisplayUtils.dp2px(fragmentActivity, 80.0f), new CollectionDetailFragment$setupToolbar$2(this, activity)));
        }
    }

    public void setupCommentBar() {
        View view = getView();
        FrameLayout.LayoutParams layoutParams = null;
        if (!(view instanceof FrameLayout)) {
            view = null;
        }
        FrameLayout frameLayout = (FrameLayout) view;
        if (frameLayout != null) {
            CollectionActionBarViewPart.Companion companion = CollectionActionBarViewPart.Companion;
            Collection collection2 = this.collection;
            if (collection2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("collection");
            }
            CollectionActionBarViewPart newInstance = companion.newInstance(collection2, frameLayout);
            newInstance.setExternalListener(new CollectionDetailFragment$setupCommentBar$1(this));
            View view2 = newInstance.getView();
            frameLayout.addView(view2);
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                layoutParams = layoutParams2;
            }
            FrameLayout.LayoutParams layoutParams3 = layoutParams;
            if (layoutParams3 != null) {
                layoutParams3.gravity = 80;
            }
            view2.setVisibility(0);
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new CollectionDetailFragment$setupCommentBar$3(frameLayout, view2));
            this.collectionBarViewPart = newInstance;
            ViewExtents2Kt.tryListenWindowsInset(newInstance.getView(), new CollectionDetailFragment$setupCommentBar$4(newInstance));
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public void updateRecyclerViewBottomInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView recyclerView2 = recyclerView;
        recyclerView2.setPadding(recyclerView2.getPaddingLeft(), recyclerView2.getPaddingTop(), recyclerView2.getPaddingRight(), rect.bottom + NumberExtendsKt.getDp((Number) 52));
    }

    @Override // com.coolapk.market.view.collectionList.CollectionDetailView
    public void onFollowCollectionResult(boolean z, Integer num, Throwable th) {
        int i;
        if (th != null) {
            Toast.error(getActivity(), th);
            return;
        }
        CollectionDetailPresenter collectionDetailPresenter = this.collectionPresenter;
        if (collectionDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionPresenter");
        }
        Collection collection2 = collectionDetailPresenter.getCollection();
        if (num != null) {
            i = num.intValue();
        } else {
            int followNum = collection2.getFollowNum();
            i = z ? followNum + 1 : followNum - 1;
        }
        Collection build = Collection.newBuilder(collection2).userAction(UserAction.newBuilder(collection2.getUserAction()).follow(z ? 1 : 0).build()).followNum(i).build();
        CollectionDetailPresenter collectionDetailPresenter2 = this.collectionPresenter;
        if (collectionDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionPresenter");
        }
        Intrinsics.checkNotNullExpressionValue(build, "newCollection");
        collectionDetailPresenter2.updateCollection(build);
        EventBus eventBus = EventBus.getDefault();
        String id = collection2.getId();
        if (id == null) {
            id = "";
        }
        String entityType = collection2.getEntityType();
        Intrinsics.checkNotNullExpressionValue(entityType, "oldCollection.entityType");
        eventBus.post(new EntityFollowEvent(id, entityType, z));
    }

    @Override // com.coolapk.market.view.collectionList.CollectionDetailView
    public void onLikeResult(boolean z, Integer num, Throwable th) {
        int i;
        if (th != null) {
            Toast.error(getActivity(), th);
            return;
        }
        CollectionDetailPresenter collectionDetailPresenter = this.collectionPresenter;
        if (collectionDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionPresenter");
        }
        Collection collection2 = collectionDetailPresenter.getCollection();
        if (num != null) {
            i = num.intValue();
        } else {
            int likeNum = collection2.getLikeNum();
            i = z ? likeNum + 1 : likeNum - 1;
        }
        Collection build = Collection.newBuilder(collection2).userAction(UserAction.newBuilder(collection2.getUserAction()).like(z ? 1 : 0).build()).likeNum(i).build();
        CollectionDetailPresenter collectionDetailPresenter2 = this.collectionPresenter;
        if (collectionDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionPresenter");
        }
        Intrinsics.checkNotNullExpressionValue(build, "newCollection");
        collectionDetailPresenter2.updateCollection(build);
    }

    @Override // com.coolapk.market.view.collectionList.CollectionDetailView
    public void onCollectionUpdate(Collection collection2) {
        Intrinsics.checkNotNullParameter(collection2, "collection");
        CollectionActionBarViewPart collectionActionBarViewPart = this.collectionBarViewPart;
        Intrinsics.checkNotNull(collectionActionBarViewPart);
        collectionActionBarViewPart.bindToContent(collection2);
        this.collection = collection2;
        Collection build = Collection.newBuilder(collection2).entityFixed(1).extraData("{\"cardDividerBottom\":8}").build();
        List<Parcelable> dataList = getDataList();
        Intrinsics.checkNotNullExpressionValue(build, "mHeaderCollection");
        dataList.set(0, build);
    }

    @Subscribe
    public final void onRemoveItemEventChange(RemoveItemEvent removeItemEvent) {
        Intrinsics.checkNotNullParameter(removeItemEvent, "event");
        List<Parcelable> dataList = getDataList();
        int size = dataList.size();
        for (int i = 0; i < size; i++) {
            Parcelable parcelable = dataList.get(i);
            if (parcelable instanceof ServiceApp) {
                String apkId = ((ServiceApp) parcelable).getApkId();
                ServiceApp serviceApp = removeItemEvent.getServiceApp();
                Intrinsics.checkNotNullExpressionValue(serviceApp, "event.serviceApp");
                if (Intrinsics.areEqual(apkId, serviceApp.getApkId())) {
                    getDataList().remove(i);
                    return;
                }
            } else if (parcelable instanceof Album) {
                String id = ((Album) parcelable).getId();
                Album album = removeItemEvent.getAlbum();
                Intrinsics.checkNotNullExpressionValue(album, "event.album");
                if (Intrinsics.areEqual(id, album.getId())) {
                    getDataList().remove(i);
                    return;
                }
            } else if (parcelable instanceof ItemPlaceHolder) {
                String entityId = ((ItemPlaceHolder) parcelable).getEntityId();
                ItemPlaceHolder itemPlaceHolder = removeItemEvent.getItemPlaceHolder();
                Intrinsics.checkNotNullExpressionValue(itemPlaceHolder, "event.itemPlaceHolder");
                if (Intrinsics.areEqual(entityId, itemPlaceHolder.getEntityId())) {
                    getDataList().remove(i);
                    return;
                }
            } else {
                continue;
            }
        }
    }

    @Subscribe
    public final void onSetTop(SetTopEvent setTopEvent) {
        Intrinsics.checkNotNullParameter(setTopEvent, "event");
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof Feed) {
                T t2 = t;
                if (Intrinsics.areEqual(t2.getId(), setTopEvent.getId())) {
                    Feed handleFeedCollectionEvent = setTopEvent.handleFeedCollectionEvent(t2);
                    if (setTopEvent.isTop()) {
                        getDataList().remove(i);
                        List<Parcelable> dataList = getDataList();
                        Intrinsics.checkNotNullExpressionValue(handleFeedCollectionEvent, "feed");
                        dataList.add(1, handleFeedCollectionEvent);
                        return;
                    }
                    getDataList().remove(i);
                    List<Parcelable> dataList2 = getDataList();
                    int firstNotTopIndex = getFirstNotTopIndex();
                    Intrinsics.checkNotNullExpressionValue(handleFeedCollectionEvent, "feed");
                    dataList2.add(firstNotTopIndex, handleFeedCollectionEvent);
                    return;
                }
            } else if (t instanceof Album) {
                T t3 = t;
                if (Intrinsics.areEqual(t3.getId(), setTopEvent.getId())) {
                    Album handleAlbumCollectionEvent = setTopEvent.handleAlbumCollectionEvent(t3);
                    if (setTopEvent.isTop()) {
                        getDataList().remove(i);
                        List<Parcelable> dataList3 = getDataList();
                        Intrinsics.checkNotNullExpressionValue(handleAlbumCollectionEvent, "feed");
                        dataList3.add(1, handleAlbumCollectionEvent);
                        return;
                    }
                    getDataList().remove(i);
                    List<Parcelable> dataList4 = getDataList();
                    int firstNotTopIndex2 = getFirstNotTopIndex();
                    Intrinsics.checkNotNullExpressionValue(handleAlbumCollectionEvent, "feed");
                    dataList4.add(firstNotTopIndex2, handleAlbumCollectionEvent);
                    return;
                }
            } else if (t instanceof ServiceApp) {
                T t4 = t;
                if (Intrinsics.areEqual(t4.getId(), setTopEvent.getId())) {
                    ServiceApp handleAppCollectionEvent = setTopEvent.handleAppCollectionEvent(t4);
                    if (setTopEvent.isTop()) {
                        getDataList().remove(i);
                        List<Parcelable> dataList5 = getDataList();
                        Intrinsics.checkNotNullExpressionValue(handleAppCollectionEvent, "app");
                        dataList5.add(1, handleAppCollectionEvent);
                        return;
                    }
                    getDataList().remove(i);
                    List<Parcelable> dataList6 = getDataList();
                    int firstNotTopIndex3 = getFirstNotTopIndex();
                    Intrinsics.checkNotNullExpressionValue(handleAppCollectionEvent, "app");
                    dataList6.add(firstNotTopIndex3, handleAppCollectionEvent);
                    return;
                }
            } else if (t instanceof DyhArticle) {
                T t5 = t;
                if (Intrinsics.areEqual(t5.getId(), setTopEvent.getId())) {
                    DyhArticle handleArticlrCollectionEvent = setTopEvent.handleArticlrCollectionEvent(t5);
                    if (setTopEvent.isTop()) {
                        getDataList().remove(i);
                        List<Parcelable> dataList7 = getDataList();
                        Intrinsics.checkNotNullExpressionValue(handleArticlrCollectionEvent, "article");
                        dataList7.add(1, handleArticlrCollectionEvent);
                        return;
                    }
                    getDataList().remove(i);
                    List<Parcelable> dataList8 = getDataList();
                    int firstNotTopIndex4 = getFirstNotTopIndex();
                    Intrinsics.checkNotNullExpressionValue(handleArticlrCollectionEvent, "article");
                    dataList8.add(firstNotTopIndex4, handleArticlrCollectionEvent);
                    return;
                }
            } else {
                continue;
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
            if ((t instanceof ServiceApp) && !t.isCollectionTop()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionDetailFragment$Companion;", "", "()V", "KEY_COLLECTION_HEADER", "", "newInstance", "Lcom/coolapk/market/view/collectionList/CollectionDetailFragment;", "id", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CollectionDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CollectionDetailFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            Bundle bundle = new Bundle();
            CollectionDetailFragment collectionDetailFragment = new CollectionDetailFragment();
            bundle.putString("EXTRA_COLLECTION_ID", str);
            collectionDetailFragment.setArguments(bundle);
            return collectionDetailFragment;
        }
    }
}
