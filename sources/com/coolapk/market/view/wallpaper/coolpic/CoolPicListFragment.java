package com.coolapk.market.view.wallpaper.coolpic;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.event.FeedFavoriteEvent;
import com.coolapk.market.event.FeedRecommendEvent;
import com.coolapk.market.event.FeedReplyEvent;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 `2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001`B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020%J\u0006\u0010:\u001a\u00020\u0012J\"\u0010;\u001a\u0002082\u0018\u0010<\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030>\u0012\u0004\u0012\u0002080=H\u0002J!\u0010?\u001a\u0002H@\"\u0004\b\u0000\u0010@2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H@0BH\u0002¢\u0006\u0002\u0010CJ\u0010\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\nH\u0002J\u0012\u0010F\u001a\u0002082\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J$\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020J2\u0006\u0010K\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\bH\u0016J\b\u0010M\u001a\u000208H\u0016J\u0010\u0010N\u001a\u0002082\u0006\u0010O\u001a\u00020PH\u0007J\u0010\u0010Q\u001a\u0002082\u0006\u0010O\u001a\u00020RH\u0007J\u0010\u0010S\u001a\u0002082\u0006\u0010O\u001a\u00020TH\u0007J\b\u0010U\u001a\u000208H\u0016J\u001a\u0010V\u001a\u0002082\u0006\u0010K\u001a\u00020\u00122\b\u0010W\u001a\u0004\u0018\u00010XH\u0014J \u0010Y\u001a\u00020\u00122\u0006\u0010K\u001a\u00020\u00122\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u0014\u0010[\u001a\u0002082\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\\H\u0016J\b\u0010]\u001a\u00020\u0012H\u0014J\b\u0010^\u001a\u000208H\u0002J\u000e\u0010_\u001a\u0002082\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u000e\u0010#\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001b\u0010)\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b*\u0010\fR\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0010\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b2\u0010,\u001a\u0004\b1\u0010\fR\u000e\u00103\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X.¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/CoolPicListFragment;", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "", "Lcom/coolapk/market/model/Entity;", "()V", "adapter", "Lcom/coolapk/market/widget/multitype/MultiTypeAdapter;", "curPage", "", "currentId", "", "getCurrentId", "()Ljava/lang/String;", "setCurrentId", "(Ljava/lang/String;)V", "dataList", "Landroidx/databinding/ObservableArrayList;", "detachedInCurrentView", "", "getDetachedInCurrentView", "()Z", "setDetachedInCurrentView", "(Z)V", "direction", "feed", "Lcom/coolapk/market/model/Feed;", "index", "getIndex", "()I", "setIndex", "(I)V", "isAddedCurrentEntity", "isFirstLoad", "isShown", "setShown", "itemIndex", "lastWindowsInset", "Landroid/graphics/Rect;", "listIndex", "getListIndex", "setListIndex", "listType", "getListType", "listType$delegate", "Lkotlin/Lazy;", "newDataList", "onListChangeCallback", "Lcom/coolapk/market/widget/AdapterListChangedCallback;", "params", "getParams", "params$delegate", "showHorizontal", "showVertical", "viewPagerLayoutManager", "Lcom/coolapk/market/view/wallpaper/coolpic/ViewPagerLayoutManager;", "applyWindowsInset", "", "rect", "canSwipe", "changeDataListAndAutoCalculateDiff", "change", "Lkotlin/Function1;", "", "changeDataListWithoutChangeCallback", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "findEntityIndexWithId", "id", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "isRefresh", "page", "onDestroy", "onFeedFavoriteChange", "event", "Lcom/coolapk/market/event/FeedFavoriteEvent;", "onFeedRecommendChange", "Lcom/coolapk/market/event/FeedRecommendEvent;", "onFeedReply", "Lcom/coolapk/market/event/FeedReplyEvent;", "onPause", "onRequestFailure", "error", "", "onRequestResponse", "result", "setAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "shouldShowList", "showTip", "updateFeed", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicListFragment.kt */
public final class CoolPicListFragment extends NewAsyncListFragment<List<? extends Entity>> {
    public static final Companion Companion = new Companion(null);
    public static final String DIRECTION_NEW = "new";
    public static final String DIRECTION_OLD = "old";
    private MultiTypeAdapter adapter;
    private int curPage = -1;
    private String currentId = "";
    private final ObservableArrayList<Entity> dataList = new ObservableArrayList<>();
    private boolean detachedInCurrentView;
    private String direction = "";
    private Feed feed;
    private int index;
    private boolean isAddedCurrentEntity;
    private boolean isFirstLoad = true;
    private boolean isShown = true;
    private int itemIndex;
    private Rect lastWindowsInset = new Rect();
    private int listIndex;
    private final Lazy listType$delegate = LazyKt.lazy(new CoolPicListFragment$listType$2(this));
    private List<? extends Entity> newDataList;
    private AdapterListChangedCallback<ObservableArrayList<Entity>> onListChangeCallback;
    private final Lazy params$delegate = LazyKt.lazy(new CoolPicListFragment$params$2(this));
    private boolean showHorizontal = true;
    private boolean showVertical = true;
    private ViewPagerLayoutManager viewPagerLayoutManager;

    private final String getListType() {
        return (String) this.listType$delegate.getValue();
    }

    private final String getParams() {
        return (String) this.params$delegate.getValue();
    }

    @JvmStatic
    public static final CoolPicListFragment newInstance(Feed feed2, String str, String str2, String str3, int i) {
        return Companion.newInstance(feed2, str, str2, str3, i);
    }

    @JvmStatic
    public static final CoolPicListFragment newInstance(Feed feed2, String str, String str2, String str3, int i, int i2) {
        return Companion.newInstance(feed2, str, str2, str3, i, i2);
    }

    @JvmStatic
    public static final CoolPicListFragment newInstance(Feed feed2, String str, String str2, String str3, ArrayList<Entity> arrayList) {
        return Companion.newInstance(feed2, str, str2, str3, arrayList);
    }

    public static final /* synthetic */ MultiTypeAdapter access$getAdapter$p(CoolPicListFragment coolPicListFragment) {
        MultiTypeAdapter multiTypeAdapter = coolPicListFragment.adapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return multiTypeAdapter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J<\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/CoolPicListFragment$Companion;", "", "()V", "DIRECTION_NEW", "", "DIRECTION_OLD", "newInstance", "Lcom/coolapk/market/view/wallpaper/coolpic/CoolPicListFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "listType", "direction", "params", "index", "", "listIndex", "data", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/Entity;", "Lkotlin/collections/ArrayList;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CoolPicListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CoolPicListFragment newInstance(Feed feed, String str, String str2, String str3, ArrayList<Entity> arrayList) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Intrinsics.checkNotNullParameter(str, "listType");
            Intrinsics.checkNotNullParameter(str2, "direction");
            Intrinsics.checkNotNullParameter(str3, "params");
            Intrinsics.checkNotNullParameter(arrayList, "data");
            CoolPicListFragment coolPicListFragment = new CoolPicListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("listType", str);
            bundle.putParcelable("feed", feed);
            bundle.putParcelableArrayList("dataList", arrayList);
            bundle.putString("params", str3);
            bundle.putString("direction", str2);
            Unit unit = Unit.INSTANCE;
            coolPicListFragment.setArguments(bundle);
            return coolPicListFragment;
        }

        public static /* synthetic */ CoolPicListFragment newInstance$default(Companion companion, Feed feed, String str, String str2, String str3, int i, int i2, Object obj) {
            return companion.newInstance(feed, str, str2, str3, (i2 & 16) != 0 ? 0 : i);
        }

        @JvmStatic
        public final CoolPicListFragment newInstance(Feed feed, String str, String str2, String str3, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Intrinsics.checkNotNullParameter(str, "listType");
            Intrinsics.checkNotNullParameter(str2, "direction");
            Intrinsics.checkNotNullParameter(str3, "params");
            CoolPicListFragment coolPicListFragment = new CoolPicListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("listType", str);
            bundle.putParcelable("feed", feed);
            bundle.putString("params", str3);
            bundle.putString("direction", str2);
            bundle.putInt("index", i);
            Unit unit = Unit.INSTANCE;
            coolPicListFragment.setArguments(bundle);
            return coolPicListFragment;
        }

        public static /* synthetic */ CoolPicListFragment newInstance$default(Companion companion, Feed feed, String str, String str2, String str3, int i, int i2, int i3, Object obj) {
            return companion.newInstance(feed, str, str2, str3, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? 0 : i2);
        }

        @JvmStatic
        public final CoolPicListFragment newInstance(Feed feed, String str, String str2, String str3, int i, int i2) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Intrinsics.checkNotNullParameter(str, "listType");
            Intrinsics.checkNotNullParameter(str2, "direction");
            Intrinsics.checkNotNullParameter(str3, "params");
            CoolPicListFragment coolPicListFragment = new CoolPicListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("listType", str);
            bundle.putParcelable("feed", feed);
            bundle.putString("params", str3);
            bundle.putString("direction", str2);
            bundle.putInt("index", i);
            bundle.putInt("list_index", i2);
            Unit unit = Unit.INSTANCE;
            coolPicListFragment.setArguments(bundle);
            return coolPicListFragment;
        }
    }

    public final String getCurrentId() {
        return this.currentId;
    }

    public final void setCurrentId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentId = str;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final int getListIndex() {
        return this.listIndex;
    }

    public final void setListIndex(int i) {
        this.listIndex = i;
    }

    public final boolean isShown() {
        return this.isShown;
    }

    public final void setShown(boolean z) {
        this.isShown = z;
    }

    public final boolean getDetachedInCurrentView() {
        return this.detachedInCurrentView;
    }

    public final void setDetachedInCurrentView(boolean z) {
        this.detachedInCurrentView = z;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.feed = (Feed) requireArguments().getParcelable("feed");
        this.direction = requireArguments().getString("direction");
        this.newDataList = requireArguments().getParcelableArrayList("dataList");
        this.index = requireArguments().getInt("index");
        this.listIndex = requireArguments().getInt("list_index");
        Feed feed2 = this.feed;
        String id = feed2 != null ? feed2.getId() : null;
        Intrinsics.checkNotNull(id);
        this.currentId = id;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewPagerLayoutManager viewPagerLayoutManager2 = new ViewPagerLayoutManager(requireActivity, 1);
        this.viewPagerLayoutManager = viewPagerLayoutManager2;
        if (viewPagerLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerLayoutManager");
        }
        setLayoutManager(viewPagerLayoutManager2);
        MultiTypeAdapter multiTypeAdapter = new MultiTypeAdapter(this.dataList);
        this.adapter = multiTypeAdapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        setAdapter(multiTypeAdapter);
        MultiTypeAdapter multiTypeAdapter2 = this.adapter;
        if (multiTypeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(multiTypeAdapter2, SimpleViewHolderFactor.Companion.withLayoutId(2131558669).suitedMethod(CoolPicListFragment$onActivityCreated$1.INSTANCE).constructor(new CoolPicListFragment$onActivityCreated$2(this)).doAfterBind(new CoolPicListFragment$onActivityCreated$3(this)).build(), 0, 2, null);
        getEmptyView().setBackgroundColor(-16777216);
        setRefreshEnable(false);
        getRecyclerView().setHasFixedSize(true);
        getRecyclerView().setRecyclerListener(CoolPicListFragment$onActivityCreated$5.INSTANCE);
        if (!this.isAddedCurrentEntity) {
            this.dataList.add(0, this.feed);
            this.isAddedCurrentEntity = !this.isAddedCurrentEntity;
        }
        ViewPagerLayoutManager viewPagerLayoutManager3 = this.viewPagerLayoutManager;
        if (viewPagerLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerLayoutManager");
        }
        viewPagerLayoutManager3.setOnViewPagerListener(new CoolPicListFragment$onActivityCreated$6(this));
        if (getUserVisibleHint()) {
            initData();
            setLoading(false);
        }
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
        getRecyclerView().requestApplyInsets();
    }

    public final void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.lastWindowsInset.set(rect);
        if (getView() != null) {
            ViewPagerLayoutManager viewPagerLayoutManager2 = this.viewPagerLayoutManager;
            if (viewPagerLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPagerLayoutManager");
            }
            int findFirstVisibleItemPosition = viewPagerLayoutManager2.findFirstVisibleItemPosition();
            ViewPagerLayoutManager viewPagerLayoutManager3 = this.viewPagerLayoutManager;
            if (viewPagerLayoutManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPagerLayoutManager");
            }
            int findLastVisibleItemPosition = viewPagerLayoutManager3.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1 && findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                while (true) {
                    RecyclerView.ViewHolder findViewHolderForLayoutPosition = getRecyclerView().findViewHolderForLayoutPosition(findFirstVisibleItemPosition);
                    if (findViewHolderForLayoutPosition != null) {
                        if (!(findViewHolderForLayoutPosition instanceof CoolPicDetailViewHolder)) {
                            findViewHolderForLayoutPosition = null;
                        }
                        CoolPicDetailViewHolder coolPicDetailViewHolder = (CoolPicDetailViewHolder) findViewHolderForLayoutPosition;
                        if (coolPicDetailViewHolder != null) {
                            coolPicDetailViewHolder.applyWindowsInset(rect);
                        }
                    }
                    if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                        findFirstVisibleItemPosition++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.detachedInCurrentView = true;
    }

    public final boolean canSwipe() {
        return !getRecyclerView().canScrollVertically(-1);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    public void setAdapter(RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "adapter");
        super.setAdapter(adapter2);
        AdapterListChangedCallback<ObservableArrayList<Entity>> adapterListChangedCallback = this.onListChangeCallback;
        if (adapterListChangedCallback != null) {
            this.dataList.removeOnListChangedCallback(adapterListChangedCallback);
            this.onListChangeCallback = null;
        }
        AdapterListChangedCallback<ObservableArrayList<Entity>> adapterListChangedCallback2 = new AdapterListChangedCallback<>(adapter2);
        this.onListChangeCallback = adapterListChangedCallback2;
        this.dataList.addOnListChangedCallback(adapterListChangedCallback2);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.detachedInCurrentView = false;
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    @Subscribe
    public final void onFeedFavoriteChange(FeedFavoriteEvent feedFavoriteEvent) {
        Intrinsics.checkNotNullParameter(feedFavoriteEvent, "event");
        String id = feedFavoriteEvent.getId();
        Intrinsics.checkNotNullExpressionValue(id, "event.id");
        int findEntityIndexWithId = findEntityIndexWithId(id);
        if (findEntityIndexWithId >= 0) {
            Object obj = this.dataList.get(findEntityIndexWithId);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
            this.dataList.set(findEntityIndexWithId, feedFavoriteEvent.handleEvent((Feed) obj));
        }
    }

    @Subscribe
    public final void onFeedRecommendChange(FeedRecommendEvent feedRecommendEvent) {
        Intrinsics.checkNotNullParameter(feedRecommendEvent, "event");
        String id = feedRecommendEvent.getId();
        Intrinsics.checkNotNullExpressionValue(id, "event.id");
        int findEntityIndexWithId = findEntityIndexWithId(id);
        if (findEntityIndexWithId >= 0) {
            Object obj = this.dataList.get(findEntityIndexWithId);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
            this.dataList.set(findEntityIndexWithId, feedRecommendEvent.handleEvent((Feed) obj));
        }
    }

    @Subscribe
    public final void onFeedReply(FeedReplyEvent feedReplyEvent) {
        Intrinsics.checkNotNullParameter(feedReplyEvent, "event");
        FeedReply feedReply = feedReplyEvent.getFeedReply();
        Intrinsics.checkNotNullExpressionValue(feedReply, "event.feedReply");
        String feedId = feedReply.getFeedId();
        Intrinsics.checkNotNullExpressionValue(feedId, "event.feedReply.feedId");
        int findEntityIndexWithId = findEntityIndexWithId(feedId);
        if (findEntityIndexWithId >= 0) {
            Object obj = this.dataList.get(findEntityIndexWithId);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
            this.dataList.set(findEntityIndexWithId, feedReplyEvent.handleEvent((Feed) obj));
        }
    }

    private final int findEntityIndexWithId(String str) {
        int i = 0;
        for (Entity entity : this.dataList) {
            if ((entity instanceof Feed) && TextUtils.equals(str, ((Feed) entity).getId())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private final <T> T changeDataListWithoutChangeCallback(Function0<? extends T> function0) {
        AdapterListChangedCallback<ObservableArrayList<Entity>> adapterListChangedCallback = this.onListChangeCallback;
        if (adapterListChangedCallback != null) {
            this.dataList.removeOnListChangedCallback(adapterListChangedCallback);
        }
        T t = (T) function0.invoke();
        AdapterListChangedCallback<ObservableArrayList<Entity>> adapterListChangedCallback2 = this.onListChangeCallback;
        if (adapterListChangedCallback2 != null) {
            this.dataList.addOnListChangedCallback(adapterListChangedCallback2);
        }
        return t;
    }

    private final void changeDataListAndAutoCalculateDiff(Function1<? super List<Entity>, Unit> function1) {
        changeDataListWithoutChangeCallback(new CoolPicListFragment$changeDataListAndAutoCalculateDiff$1(this, function1));
    }

    public final void updateFeed(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "feed");
        String id = feed2.getId();
        Intrinsics.checkNotNull(id);
        Intrinsics.checkNotNullExpressionValue(id, "feed.id!!");
        int findEntityIndexWithId = findEntityIndexWithId(id);
        if (findEntityIndexWithId >= 0) {
            this.dataList.set(findEntityIndexWithId, feed2);
        }
    }

    /* access modifiers changed from: private */
    public final void showTip() {
        this.showVertical = DataManager.getInstance().getPreferencesBoolean("SHOW_COOL_PIC_TIP_VERTICAL", true);
        this.showHorizontal = DataManager.getInstance().getPreferencesBoolean("SHOW_COOL_PIC_TIP_HORIZONTAL", true);
        Entity entity = (Entity) this.dataList.get(this.itemIndex);
        int size = this.dataList.size();
        if (!(entity instanceof Feed)) {
            return;
        }
        if (size > 1 && this.showVertical) {
            ActionManager.startPictureTipActivity(getActivity(), 0);
        } else if (this.showHorizontal && ((Feed) entity).getPicArray().size() > 1) {
            ActionManager.startPictureTipActivity(getActivity(), 1);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        FragmentActivity activity = getActivity();
        if (activity instanceof CoolPicDetailActivity) {
            ((CoolPicDetailActivity) activity).setLoadingFinished();
        }
        List<? extends Entity> list2 = list;
        boolean z2 = false;
        if (!CollectionUtils.isEmpty(list2)) {
            if (z) {
                ObservableArrayList<Entity> observableArrayList = this.dataList;
                boolean z3 = this.isFirstLoad;
                int size = observableArrayList.size();
                if (!z3) {
                    size = 0;
                }
                Intrinsics.checkNotNull(list);
                observableArrayList.addAll(size, list2);
            } else {
                ObservableArrayList<Entity> observableArrayList2 = this.dataList;
                Intrinsics.checkNotNull(list);
                observableArrayList2.addAll(list2);
            }
            this.isFirstLoad = false;
            z2 = true;
        }
        showTip();
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        if (!z) {
            ObservableArrayList<Entity> observableArrayList = this.dataList;
            Object obj = observableArrayList.get(observableArrayList.size() - 1);
            Intrinsics.checkNotNullExpressionValue(obj, "dataList[dataList.size - 1]");
            String id = ((Entity) obj).getId();
            Intrinsics.checkNotNull(id);
            this.currentId = id;
            this.direction = "old";
        } else if (i > this.curPage) {
            this.direction = "old";
            this.curPage = i;
        } else {
            this.direction = "new";
        }
        Observable<R> map = DataManager.getInstance().getCoolPicList(getListType(), this.currentId, this.direction, getParams()).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return isDataLoaded();
    }
}
