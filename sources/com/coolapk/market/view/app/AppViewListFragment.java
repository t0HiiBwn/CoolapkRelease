package com.coolapk.market.view.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DataItem;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.User;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.app.AppViewContract;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.decoration.PaddingDividerItemDecoration;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleHolderFactorBuilder;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 :2\u00020\u0001:\u0002:;B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010H\u0002J,\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J \u0010-\u001a\u00020%2\u0006\u0010$\u001a\u00020%2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0014J\u0006\u0010/\u001a\u00020\u001dJ\u000e\u00100\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\nJ\u000e\u00101\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u0014H\u0016J\b\u00104\u001a\u00020%H\u0014J\b\u00105\u001a\u00020%H\u0014J\u000e\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020(J\u000e\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/coolapk/market/view/app/AppViewListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "filterArgs", "Lcom/coolapk/market/view/app/AppViewListFragment$FilterArgs;", "getFilterArgs", "()Lcom/coolapk/market/view/app/AppViewListFragment$FilterArgs;", "setFilterArgs", "(Lcom/coolapk/market/view/app/AppViewListFragment$FilterArgs;)V", "presenter", "Lcom/coolapk/market/view/app/AppViewContract$Presenter;", "viewModel", "Lcom/coolapk/market/view/app/AppViewViewModel;", "createDataItem", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/DataItem;", "Lkotlin/collections/ArrayList;", "filterDataWhenRefresh", "", "originData", "", "index", "newDataByCardId", "", "", "findCommentTitlePosition", "getServiceApp", "Lcom/coolapk/market/model/ServiceApp;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onRequestResponse", "data", "scrollToComment", "setPresenter", "setViewModel", "shouldInterceptFeedEvent", "event", "shouldShowEmptyView", "shouldShowList", "showFilterPopMenu", "target", "switchFilterArgs", "type", "Companion", "FilterArgs", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewListFragment.kt */
public final class AppViewListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_TYPE_BASE_INFO = 1;
    public static final int ITEM_TYPE_COMMENT_TITLE = 4;
    public static final int ITEM_TYPE_DEVELOPER_CARD = 5;
    public static final int ITEM_TYPE_GIFT = 2;
    public static final int ITEM_TYPE_INTERACTIVE = 3;
    public static final int ITEM_TYPE_RELATE_APP = 6;
    public static final String KEY_APK_ID = "APK_ID";
    public static final String KEY_FROM_API = "FROM_API";
    private FilterArgs filterArgs = FilterArgs.FILTER_BY_RECENT_REPLY;
    private AppViewContract.Presenter presenter;
    private AppViewViewModel viewModel;

    @JvmStatic
    public static final AppViewListFragment newInstance(String str, String str2) {
        return Companion.newInstance(str, str2);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowEmptyView() {
        return false;
    }

    public static final /* synthetic */ AppViewContract.Presenter access$getPresenter$p(AppViewListFragment appViewListFragment) {
        AppViewContract.Presenter presenter2 = appViewListFragment.presenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return presenter2;
    }

    public static final /* synthetic */ AppViewViewModel access$getViewModel$p(AppViewListFragment appViewListFragment) {
        AppViewViewModel appViewViewModel = appViewListFragment.viewModel;
        if (appViewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return appViewViewModel;
    }

    public final FilterArgs getFilterArgs() {
        return this.filterArgs;
    }

    public final void setFilterArgs(FilterArgs filterArgs2) {
        Intrinsics.checkNotNullParameter(filterArgs2, "<set-?>");
        this.filterArgs = filterArgs2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B-\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/app/AppViewListFragment$FilterArgs;", "", "blockStatus", "", "listType", "", "fromAuthor", "textId", "(Ljava/lang/String;IILjava/lang/String;II)V", "getBlockStatus", "()I", "getFromAuthor", "getListType", "()Ljava/lang/String;", "getTextId", "validId", "FILTER_BY_RECENT_REPLY", "FILTER_BY_DATELINE_DESC", "FILTER_BY_POPULAR", "FILTER_BY_AUTHOR", "FILTER_BY_BLOCK_STATUS", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppViewListFragment.kt */
    public enum FilterArgs {
        FILTER_BY_RECENT_REPLY(0, "lastupdate_desc", 0, 2131886922, 5, null),
        FILTER_BY_DATELINE_DESC(0, "dateline_desc", 0, 2131886918, 5, null),
        FILTER_BY_POPULAR(0, "popular", 0, 2131886921, 5, null),
        FILTER_BY_AUTHOR(0, null, 1, 2131886916, 3, null),
        FILTER_BY_BLOCK_STATUS(1, null, 0, 2131887022, 6, null);
        
        private final int blockStatus;
        private final int fromAuthor;
        private final String listType;
        private final int textId;

        private FilterArgs(int i, String str, int i2, int i3) {
            this.blockStatus = i;
            this.listType = str;
            this.fromAuthor = i2;
            this.textId = i3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ FilterArgs(int i, String str, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? "lastupdate_desc" : str, (i4 & 4) != 0 ? 0 : i2, i3);
        }

        public final int getBlockStatus() {
            return this.blockStatus;
        }

        public final int getFromAuthor() {
            return this.fromAuthor;
        }

        public final String getListType() {
            return this.listType;
        }

        public final int getTextId() {
            return this.textId;
        }

        public final int validId() {
            return ordinal() + 100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/app/AppViewListFragment$Companion;", "", "()V", "ITEM_TYPE_BASE_INFO", "", "ITEM_TYPE_COMMENT_TITLE", "ITEM_TYPE_DEVELOPER_CARD", "ITEM_TYPE_GIFT", "ITEM_TYPE_INTERACTIVE", "ITEM_TYPE_RELATE_APP", "KEY_APK_ID", "", "KEY_FROM_API", "newInstance", "Lcom/coolapk/market/view/app/AppViewListFragment;", "apkId", "fromApi", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppViewListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ AppViewListFragment newInstance$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            return companion.newInstance(str, str2);
        }

        @JvmStatic
        public final AppViewListFragment newInstance(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "apkId");
            AppViewListFragment appViewListFragment = new AppViewListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("APK_ID", str);
            bundle.putString("FROM_API", str2);
            Unit unit = Unit.INSTANCE;
            appViewListFragment.setArguments(bundle);
            return appViewListFragment;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        Observable<R> map = DataManager.getInstance().getAppCommentList(requireArguments().getString("APK_ID"), this.filterArgs.getListType(), i, (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId(), (z || (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) == null) ? null : findLastEntity$default.getEntityId(), this.filterArgs.getBlockStatus(), this.filterArgs.getFromAuthor(), requireArguments().getString("FROM_API")).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Intrinsics.checkNotNull(onCreateView);
        View findViewById = onCreateView.findViewById(2131362882);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view!!.findViewById<View>(R.id.loading_view)");
        findViewById.setAlpha(0.0f);
        return onCreateView;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentBindingComponent fragmentBindingComponent = new FragmentBindingComponent(this);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558599).suitedMethod(AppViewListFragment$onActivityCreated$1.INSTANCE).constructor(new AppViewListFragment$onActivityCreated$2(this, fragmentBindingComponent)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558606).suitedMethod(AppViewListFragment$onActivityCreated$3.INSTANCE).constructor(new AppViewListFragment$onActivityCreated$4(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558668).suitedMethod(AppViewListFragment$onActivityCreated$5.INSTANCE).constructor(new AppViewListFragment$onActivityCreated$6(this, fragmentBindingComponent)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558894).suitedMethod(AppViewListFragment$onActivityCreated$7.INSTANCE).constructor(new AppViewListFragment$onActivityCreated$8(this, fragmentBindingComponent)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558602).suitedMethod(AppViewListFragment$onActivityCreated$9.INSTANCE).constructor(new AppViewListFragment$onActivityCreated$10(this, fragmentBindingComponent)).build(), 0, 2, null);
        BaseMultiTypeAdapter adapter$presentation_coolapkAppRelease = getAdapter$presentation_coolapkAppRelease();
        SimpleHolderFactorBuilder constructor = SimpleViewHolderFactor.Companion.withLayoutId(2131558708).suitedMethod(AppViewListFragment$onActivityCreated$11.INSTANCE).constructor(new AppViewListFragment$onActivityCreated$12(this));
        Integer num = getItemViewTypeByEntityType().get("feed");
        Intrinsics.checkNotNull(num);
        Intrinsics.checkNotNullExpressionValue(num, "itemViewTypeByEntityType…Utils.ENTITY_TYPE_FEED]!!");
        BaseMultiTypeAdapter.register$default(adapter$presentation_coolapkAppRelease, constructor.resetItemViewType(num.intValue()).build(), 0, 2, null);
        getRecyclerView().addItemDecoration(new PaddingDividerItemDecoration(new AppViewListFragment$onActivityCreated$13(this, getActivity())));
        float screenWidth = ((((float) ScreenUtils.getScreenWidth()) * 9.0f) / 16.0f) - ((float) BarUtils.getStatusBarHeight());
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        int actionBarSize = (int) (screenWidth - ((float) UiUtils.getActionBarSize(activity)));
        getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(actionBarSize, new AppViewListFragment$onActivityCreated$14(this)));
        getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(actionBarSize + ConvertUtils.dp2px(40.0f), new AppViewListFragment$onActivityCreated$15(this)));
        if (getServiceApp() != null && bundle == null) {
            getDataList().addAll(0, createDataItem());
            View view = getView();
            Intrinsics.checkNotNull(view);
            view.post(new AppViewListFragment$onActivityCreated$16(this));
        }
        setLoading(false);
    }

    public final void setViewModel(AppViewViewModel appViewViewModel) {
        Intrinsics.checkNotNullParameter(appViewViewModel, "viewModel");
        this.viewModel = appViewViewModel;
    }

    public final void setPresenter(AppViewContract.Presenter presenter2) {
        Intrinsics.checkNotNullParameter(presenter2, "presenter");
        this.presenter = presenter2;
    }

    public final void switchFilterArgs(FilterArgs filterArgs2) {
        Intrinsics.checkNotNullParameter(filterArgs2, "type");
        if (this.filterArgs != filterArgs2) {
            CollectionsKt.removeAll((List) getDataList(), (Function1) AppViewListFragment$switchFilterArgs$1.INSTANCE);
            getAdapter$presentation_coolapkAppRelease().notifyItemChanged(findCommentTitlePosition());
            addRefreshView();
            this.filterArgs = filterArgs2;
            setPage(1);
            reloadData();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c4  */
    public final void showFilterPopMenu(View view) {
        boolean z;
        ServiceApp serviceApp;
        MenuItem findItem;
        Intrinsics.checkNotNullParameter(view, "target");
        BasePopMenu basePopMenu = new BasePopMenu(getActivity(), view);
        FilterArgs[] values = FilterArgs.values();
        ArrayList<FilterArgs> arrayList = new ArrayList();
        int length = values.length;
        boolean z2 = false;
        int i = 0;
        while (true) {
            boolean z3 = true;
            if (i >= length) {
                break;
            }
            FilterArgs filterArgs2 = values[i];
            if (filterArgs2 == FilterArgs.FILTER_BY_BLOCK_STATUS) {
                z3 = false;
            }
            if (z3) {
                arrayList.add(filterArgs2);
            }
            i++;
        }
        for (FilterArgs filterArgs3 : arrayList) {
            basePopMenu.getMenu().add(0, filterArgs3.validId(), filterArgs3.validId(), filterArgs3.getTextId());
        }
        AppViewViewModel appViewViewModel = this.viewModel;
        if (appViewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        ServiceApp serviceApp2 = appViewViewModel.getServiceApp();
        Intrinsics.checkNotNull(serviceApp2);
        Intrinsics.checkNotNullExpressionValue(serviceApp2, "viewModel.serviceApp!!");
        if (serviceApp2.getCommentBlockNum() > 0) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            if (loginSession.isAdmin()) {
                z = true;
                if (z) {
                    FilterArgs filterArgs4 = FilterArgs.FILTER_BY_BLOCK_STATUS;
                    basePopMenu.getMenu().add(0, filterArgs4.validId(), filterArgs4.validId(), filterArgs4.getTextId());
                }
                serviceApp = getServiceApp();
                Intrinsics.checkNotNull(serviceApp);
                if (serviceApp.getDeveloperProfile() != null) {
                    z2 = true;
                }
                findItem = basePopMenu.getMenu().findItem(FilterArgs.FILTER_BY_AUTHOR.validId());
                if (findItem != null) {
                    findItem.setVisible(z2);
                }
                basePopMenu.setOnMenuItemClickListener(new AppViewListFragment$showFilterPopMenu$3(this));
                basePopMenu.show();
            }
        }
        z = false;
        if (z) {
        }
        serviceApp = getServiceApp();
        Intrinsics.checkNotNull(serviceApp);
        if (serviceApp.getDeveloperProfile() != null) {
        }
        findItem = basePopMenu.getMenu().findItem(FilterArgs.FILTER_BY_AUTHOR.validId());
        if (findItem != null) {
        }
        basePopMenu.setOnMenuItemClickListener(new AppViewListFragment$showFilterPopMenu$3(this));
        basePopMenu.show();
    }

    /* access modifiers changed from: private */
    public final ServiceApp getServiceApp() {
        AppViewContract.Presenter presenter2 = this.presenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return presenter2.getServiceApp();
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getServiceApp() != null;
    }

    public final void scrollToComment() {
        if (isAdded()) {
            int findCommentTitlePosition = findCommentTitlePosition();
            RecyclerView recyclerView = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(findCommentTitlePosition, UiUtils.getActionBarSize(activity) + BarUtils.getStatusBarHeight());
        }
    }

    private final int findCommentTitlePosition() {
        int i = 0;
        for (Parcelable parcelable : getDataList()) {
            if ((parcelable instanceof DataItem) && ((DataItem) parcelable).getItemType() == 4) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        removeNoMoreDataView();
        int size = list != null ? list.size() : 0;
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (EntityListFragment.findFirstEntityIndex$default(this, "feed", null, false, false, 14, null) <= 0) {
            if (this.filterArgs == FilterArgs.FILTER_BY_BLOCK_STATUS) {
                String string = getString(2131886833);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_has_not_reply)");
                addHintView(string, null);
            } else {
                ServiceApp serviceApp = getServiceApp();
                Intrinsics.checkNotNull(serviceApp);
                if (serviceApp.getCommentStatus() == -1) {
                    String string2 = getString(2131886673);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_comment_is_not_allowed)");
                    addHintView(string2, null);
                } else {
                    String string3 = getString(2131886865);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.str_left_a_comment)");
                    addHintView(string3, new AppViewListFragment$onRequestResponse$1(this));
                }
            }
        } else if (!onRequestResponse || size < 20) {
            addNoMoreDataView();
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (obj instanceof DataItem) {
            return -1;
        }
        return super.filterDataWhenRefresh(obj, i, map);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.feed.FeedEventProcessor.EventInterceptor
    public boolean shouldInterceptFeedEvent(Object obj) {
        int findCommentTitlePosition;
        Intrinsics.checkNotNullParameter(obj, "event");
        if (!(obj instanceof FeedPostEvent)) {
            return super.shouldInterceptFeedEvent(obj);
        }
        FeedPostEvent feedPostEvent = (FeedPostEvent) obj;
        Feed feed = feedPostEvent.getFeed();
        if (feed != null && Intrinsics.areEqual(feed.getFeedType(), "comment")) {
            AppViewContract.Presenter presenter2 = this.presenter;
            if (presenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            ServiceApp serviceApp = presenter2.getServiceApp();
            Intrinsics.checkNotNullExpressionValue(serviceApp, "presenter.serviceApp");
            if (StringsKt.equals$default(serviceApp.getTargetId(), feedPostEvent.getFeed().getTid(), false, 2, null)) {
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                LoginSession loginSession = instance.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                if (loginSession.isLogin() && EntityListFragment.findFirstEntityIndex$default(this, "REFRESH_PROGRESS_BAR", null, false, false, 6, null) < 0 && (findCommentTitlePosition = findCommentTitlePosition()) >= 0) {
                    getAdapter$presentation_coolapkAppRelease().notifyItemChanged(findCommentTitlePosition);
                    getDataList().add(findCommentTitlePosition + 1, feed);
                }
            }
        }
        return true;
    }

    private final ArrayList<DataItem> createDataItem() {
        ArrayList<DataItem> arrayList = new ArrayList<>();
        arrayList.add(new DataItem(1));
        ServiceApp serviceApp = getServiceApp();
        Intrinsics.checkNotNull(serviceApp);
        if (serviceApp.getDeveloperProfile() != null) {
            ServiceApp serviceApp2 = getServiceApp();
            Intrinsics.checkNotNull(serviceApp2);
            User developerProfile = serviceApp2.getDeveloperProfile();
            Intrinsics.checkNotNull(developerProfile);
            Intrinsics.checkNotNullExpressionValue(developerProfile, "getServiceApp()!!.developerProfile!!");
            if (developerProfile.getIsFollow() != -1) {
                arrayList.add(new DataItem(5));
            }
        }
        ServiceApp serviceApp3 = getServiceApp();
        Intrinsics.checkNotNull(serviceApp3);
        List<ServiceApp> relatedRows = serviceApp3.getRelatedRows();
        if (relatedRows != null && (!relatedRows.isEmpty())) {
            arrayList.add(new DataItem(6));
        }
        ServiceApp serviceApp4 = getServiceApp();
        Intrinsics.checkNotNull(serviceApp4);
        if (serviceApp4.getIsDownloadApp() == 1) {
            arrayList.add(new DataItem(3));
        }
        ServiceApp serviceApp5 = getServiceApp();
        Intrinsics.checkNotNull(serviceApp5);
        if (serviceApp5.getCommentStatus() != -1) {
            arrayList.add(new DataItem(4));
        }
        return arrayList;
    }
}
