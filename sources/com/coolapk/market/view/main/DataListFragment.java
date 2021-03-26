package com.coolapk.market.view.main;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.RvInFragmentLayoutBinding;
import com.coolapk.market.event.CoolPicScrollEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.SimpleEntity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.wallpaper.coolpic.FallsListFragment;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001UB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020$H\u0002J$\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010-\u001a\u00020.H\u0014J\u0012\u0010/\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0018\u00103\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J$\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*092\u0006\u0010-\u001a\u00020.2\u0006\u0010:\u001a\u00020;H\u0016J\u0017\u0010<\u001a\u00020.2\b\u0010=\u001a\u0004\u0018\u00010+H\u0010¢\u0006\u0002\b>J\u0010\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020AH\u0017J\u0010\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u00020DH\u0016J \u0010E\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u0014J\u0010\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u000201H\u0016J\b\u0010H\u001a\u00020$H\u0002J\u001a\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020K2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u0010L\u001a\u00020$H\u0002J\u0010\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020.H\u0016J\b\u0010O\u001a\u00020.H\u0002J\b\u0010P\u001a\u00020.H\u0002J\b\u0010Q\u001a\u00020.H\u0002J\u0010\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020TH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!¨\u0006V"}, d2 = {"Lcom/coolapk/market/view/main/DataListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "Lcom/coolapk/market/view/main/ConvertViewPagerFragment;", "()V", "fallConvert", "Lcom/coolapk/market/view/main/DataListFallConvert;", "getFallConvert", "()Lcom/coolapk/market/view/main/DataListFallConvert;", "fallConvert$delegate", "Lkotlin/Lazy;", "flexUrl", "", "headerEntity", "Landroid/os/Parcelable;", "iconTab", "Lcom/coolapk/market/model/EntityCard;", "subTabLinkCardMap", "", "subTitle", "title", "translucentHeaderConverter", "Lcom/coolapk/market/view/main/TranslucentHeaderConverter;", "getTranslucentHeaderConverter", "()Lcom/coolapk/market/view/main/TranslucentHeaderConverter;", "translucentHeaderConverter$delegate", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "viewPagerConverter", "Lcom/coolapk/market/view/main/DataListViewPagerConverter;", "getViewPagerConverter", "()Lcom/coolapk/market/view/main/DataListViewPagerConverter;", "viewPagerConverter$delegate", "addSubMenuIfAvailable", "", "checkConvertToFallLayout", "checkConvertToViewPager", "checkLayoutHeader", "loadSecondPageIfHaveSpareSpace", "modifyDataBeforeHandle", "", "Lcom/coolapk/market/model/Entity;", "data", "isRefresh", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "page", "", "onExtraRequestArgsAssembled", "args", "onExtraRequestArgsAssembled$presentation_coolapkAppRelease", "onListScrollEventChanged", "event", "Lcom/coolapk/market/event/CoolPicScrollEvent;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestResponse", "onSaveInstanceState", "outState", "onShareActionClick", "onViewCreated", "view", "Landroid/view/View;", "oneFunctionThreeCheck", "scrollToTop", "fastScroll", "shouldCheckAutoLoadSecondPage", "shouldShowMenu", "shouldShowShareView", "updateRecyclerViewBottomInset", "rect", "Landroid/graphics/Rect;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DataListFragment.kt */
public class DataListFragment extends EntityListFragment implements ConvertViewPagerFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_SELECTED_TAB = "SELECTED_TAB";
    public static final String KEY_SUBTITLE = "SUBTITLE";
    public static final String KEY_TITLE = "TITLE";
    public static final String KEY_URL = "URL";
    private final Lazy fallConvert$delegate = LazyKt.lazy(new DataListFragment$fallConvert$2(this));
    private String flexUrl = "";
    private Parcelable headerEntity;
    private EntityCard iconTab;
    private Map<String, ? extends EntityCard> subTabLinkCardMap;
    private String subTitle;
    private String title;
    private final Lazy translucentHeaderConverter$delegate = LazyKt.lazy(new DataListFragment$translucentHeaderConverter$2(this));
    public String url;
    private final Lazy viewPagerConverter$delegate = LazyKt.lazy(new DataListFragment$viewPagerConverter$2(this));

    private final DataListFallConvert getFallConvert() {
        return (DataListFallConvert) this.fallConvert$delegate.getValue();
    }

    private final TranslucentHeaderConverter getTranslucentHeaderConverter() {
        return (TranslucentHeaderConverter) this.translucentHeaderConverter$delegate.getValue();
    }

    private final DataListViewPagerConverter getViewPagerConverter() {
        return (DataListViewPagerConverter) this.viewPagerConverter$delegate.getValue();
    }

    @JvmStatic
    public static final DataListFragment newInstance(String str, String str2, String str3, int i) {
        return Companion.newInstance(str, str2, str3, i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u000eJ2\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/main/DataListFragment$Companion;", "", "()V", "KEY_SELECTED_TAB", "", "KEY_SUBTITLE", "KEY_TITLE", "KEY_URL", "createArguments", "Landroid/os/Bundle;", "action", "title", "subTitle", "selectedTab", "", "newInstance", "Lcom/coolapk/market/view/main/DataListFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DataListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Bundle createArguments$default(Companion companion, String str, String str2, String str3, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str2 = null;
            }
            if ((i2 & 4) != 0) {
                str3 = null;
            }
            if ((i2 & 8) != 0) {
                i = -1;
            }
            return companion.createArguments(str, str2, str3, i);
        }

        public final Bundle createArguments(String str, String str2, String str3, int i) {
            Intrinsics.checkNotNullParameter(str, "action");
            Bundle bundle = new Bundle();
            bundle.putString("URL", str);
            bundle.putString("TITLE", str2);
            bundle.putString("SUBTITLE", str3);
            return bundle;
        }

        public static /* synthetic */ DataListFragment newInstance$default(Companion companion, String str, String str2, String str3, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str2 = null;
            }
            if ((i2 & 4) != 0) {
                str3 = null;
            }
            if ((i2 & 8) != 0) {
                i = -1;
            }
            return companion.newInstance(str, str2, str3, i);
        }

        @JvmStatic
        public final DataListFragment newInstance(String str, String str2, String str3, int i) {
            Intrinsics.checkNotNullParameter(str, "action");
            DataListFragment dataListFragment = new DataListFragment();
            dataListFragment.setArguments(DataListFragment.Companion.createArguments(str, str2, str3, i));
            return dataListFragment;
        }
    }

    public final String getUrl() {
        String str = this.url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        }
        return str;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("URL");
        Intrinsics.checkNotNull(string);
        this.url = string;
        this.title = requireArguments().getString("TITLE");
        this.subTitle = requireArguments().getString("SUBTITLE");
        StringBuilder sb = new StringBuilder();
        sb.append("url=");
        String str = this.url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        }
        sb.append(str);
        sb.append("&title=");
        sb.append(this.title);
        sb.append("&subTitle=");
        sb.append(this.subTitle);
        setUrlParams(sb.toString());
        String recordId = getRecordId();
        if (recordId == null || recordId.length() == 0) {
            setRecordId(this.title);
        }
        String str2 = null;
        this.iconTab = bundle != null ? (EntityCard) bundle.getParcelable("ICON_TAB") : null;
        if (bundle != null) {
            str2 = bundle.getString("FLEX_URL");
        }
        if (str2 == null) {
            str2 = "";
        }
        this.flexUrl = str2;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ViewGroup.MarginLayoutParams marginParams;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (getTranslucentHeaderConverter().getShouldHandleHeader() && (marginParams = ViewExtendsKt.getMarginParams(view)) != null) {
            marginParams.topMargin = getTranslucentHeaderConverter().getHeaderRange();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        DataManager instance = DataManager.getInstance();
        String str = this.url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        }
        String str2 = this.title;
        String str3 = this.subTitle;
        String str4 = null;
        String entityId = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
        String entityId2 = (z || (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) == null) ? null : findLastEntity$default.getEntityId();
        Entity findLastEntity$default2 = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        if (findLastEntity$default2 != null) {
            str4 = EntityExtendsKt.getPageContext(findLastEntity$default2);
        }
        Observable<R> map = instance.getDataList(str, str2, str3, i, entityId, entityId2, str4).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public void updateRecyclerViewBottomInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (isAdded() && !getViewPagerConverter().isTabInitialized() && !getFallConvert().isFallInitialized()) {
            super.updateRecyclerViewBottomInset(rect);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        oneFunctionThreeCheck();
        if (onRequestResponse && getPage() == 1 && shouldCheckAutoLoadSecondPage()) {
            AppHolder.getMainThreadHandler().post(new DataListFragment$sam$java_lang_Runnable$0(new DataListFragment$onRequestResponse$1(this)));
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            oneFunctionThreeCheck();
        }
        if (shouldShowMenu()) {
            setHasOptionsMenu(true);
        }
    }

    private final boolean shouldCheckAutoLoadSecondPage() {
        if (getActivity() != null && !isRefreshing() && !isLoadingMore() && getDataList().size() <= 18) {
            if (!(this.flexUrl.length() > 0) && this.iconTab == null) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void loadSecondPageIfHaveSpareSpace() {
        int findLastVisibleItemPosition;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        if (shouldCheckAutoLoadSecondPage() || getPage() != 2) {
            RecyclerView recyclerView = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null && (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()) >= 0 && (findViewHolderForAdapterPosition = getRecyclerView().findViewHolderForAdapterPosition(findLastVisibleItemPosition)) != null) {
                Intrinsics.checkNotNullExpressionValue(findViewHolderForAdapterPosition, "recyclerView.findViewHol…                ?: return");
                RecyclerView recyclerView2 = getRecyclerView();
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
                int height = recyclerView2.getHeight();
                View view = findViewHolderForAdapterPosition.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
                if (height - view.getBottom() > NumberExtendsKt.getDp((Number) 32)) {
                    loadMore();
                }
            }
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onExtraRequestArgsAssembled$presentation_coolapkAppRelease(Entity entity) {
        if (!(this.flexUrl.length() > 0) || entity == null) {
            return super.onExtraRequestArgsAssembled$presentation_coolapkAppRelease(entity);
        }
        String url2 = entity.getUrl();
        if (url2 == null) {
            url2 = "";
        }
        this.flexUrl = url2;
        if (getFallConvert().isFallInitialized()) {
            getFallConvert().convertToFlexLayout(this.flexUrl);
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (shouldShowShareView()) {
            MenuItem add = menu.add(0, 2131361968, 0, 2131886148);
            add.setIcon(2131689492);
            add.setShowAsAction(2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId != 2131361876) {
            if (itemId != 2131361968) {
                return super.onOptionsItemSelected(menuItem);
            }
            onShareActionClick();
        }
        return true;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("ICON_TAB", this.iconTab);
        bundle.putString("FLEX_URL", this.flexUrl);
    }

    private final void oneFunctionThreeCheck() {
        checkConvertToViewPager();
        checkLayoutHeader();
        checkConvertToFallLayout();
    }

    private final void checkConvertToViewPager() {
        EntityCard entityCard = this.iconTab;
        if (entityCard != null && !getViewPagerConverter().isTabInitialized()) {
            getViewPagerConverter().convertToViewPageMode(entityCard, requireArguments().getInt("SELECTED_TAB", -1));
            addSubMenuIfAvailable(entityCard);
        }
    }

    private final void checkLayoutHeader() {
        boolean z;
        if (getTranslucentHeaderConverter().getShouldHandleHeader()) {
            Parcelable parcelable = (Parcelable) CollectionsKt.firstOrNull((List<? extends Object>) getDataList());
            if (!Intrinsics.areEqual(this.headerEntity, parcelable) || !(!getDataList().isEmpty())) {
                this.headerEntity = parcelable;
                if (parcelable instanceof Entity) {
                    Entity entity = (Entity) parcelable;
                    if (Intrinsics.areEqual(entity.getEntityTemplate(), "headCard")) {
                        String pic = entity.getPic();
                        if (!(pic == null || pic.length() == 0)) {
                            z = true;
                            TranslucentHeaderConverter.resetToolbarHeader$default(getTranslucentHeaderConverter(), z, this.title, getViewPagerConverter(), false, 8, null);
                        }
                    }
                }
                z = false;
                TranslucentHeaderConverter.resetToolbarHeader$default(getTranslucentHeaderConverter(), z, this.title, getViewPagerConverter(), false, 8, null);
            }
        }
    }

    private final void checkConvertToFallLayout() {
        if ((this.flexUrl.length() > 0) && !(this instanceof FallsListFragment)) {
            getFallConvert().convertToFlexLayout(this.flexUrl);
        }
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, com.coolapk.market.view.base.refresh.ScrollableFragment
    public void scrollToTop(boolean z) {
        super.scrollToTop(z);
        getViewPagerConverter().dispatchScrollToTop(z);
        getFallConvert().dispatchScrollToTop(z);
    }

    private final void addSubMenuIfAvailable(EntityCard entityCard) {
        ConfigPage configPage;
        T t;
        Map<String, ? extends EntityCard> map = this.subTabLinkCardMap;
        if (map != null) {
            List<Entity> entities = entityCard.getEntities();
            Intrinsics.checkNotNull(entities);
            Intrinsics.checkNotNullExpressionValue(entities, "iconTab.entities!!");
            List<Entity> list = entities;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (true) {
                boolean z = false;
                if (it2.hasNext()) {
                    T next = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next, "tab");
                    EntityCard entityCard2 = (EntityCard) map.get(EntityExtendsKt.getStringExtraData(next, "subCardTitle", ""));
                    if (entityCard2 != null) {
                        List<Entity> entities2 = entityCard2.getEntities();
                        if (entities2 == null || entities2.isEmpty()) {
                            z = true;
                        }
                        if (!z) {
                            ConfigPage.Builder extraData = ConfigPage.newBuilder().entityType(next.getEntityType()).title(next.getTitle()).url(next.getUrl()).pic(next.getPic()).pageName(next.getTitle()).extraData(next.getExtraData());
                            List<Entity> entities3 = entityCard2.getEntities();
                            Intrinsics.checkNotNull(entities3);
                            Intrinsics.checkNotNullExpressionValue(entities3, "entityCard.entities!!");
                            List<Entity> list2 = entities3;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                            for (T t2 : list2) {
                                if (t2 instanceof SimpleEntity) {
                                    t = t2;
                                } else {
                                    SimpleEntity.Builder builder = SimpleEntity.builder();
                                    Intrinsics.checkNotNullExpressionValue(t2, "child");
                                    t = builder.setEntityType(t2.getEntityType()).setTitle(t2.getTitle()).setUrl(t2.getUrl()).setPic(t2.getPic()).build();
                                }
                                arrayList2.add(t);
                            }
                            extraData.rawEntities(arrayList2);
                            configPage = extraData.build();
                            arrayList.add(configPage);
                        }
                    }
                    configPage = null;
                    arrayList.add(configPage);
                } else {
                    DataListViewPagerConverter viewPagerConverter = getViewPagerConverter();
                    Object[] array = arrayList.toArray(new ConfigPage[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    viewPagerConverter.addSubConfigPageListener((ConfigPage[]) array);
                    return;
                }
            }
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected List<Entity> modifyDataBeforeHandle(List<? extends Entity> list, boolean z) {
        T t;
        T t2;
        T t3;
        Intrinsics.checkNotNullParameter(list, "data");
        Iterator<T> it2 = list.iterator();
        while (true) {
            t = null;
            if (!it2.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it2.next();
            if (Intrinsics.areEqual(t2.getEntityTemplate(), "configCard")) {
                break;
            }
        }
        T t4 = t2;
        if (t4 != null) {
            JSONObject jsonExtraData = EntityExtendsKt.getJsonExtraData(t4);
            if (Intrinsics.areEqual(jsonExtraData != null ? jsonExtraData.optString("flexList") : null, "1")) {
                String optString = jsonExtraData != null ? jsonExtraData.optString("url") : null;
                if (optString == null) {
                    optString = "";
                }
                this.flexUrl = optString;
            }
            String optString2 = jsonExtraData != null ? jsonExtraData.optString("pageTitle") : null;
            String str = optString2;
            if (!(str == null || str.length() == 0)) {
                this.title = optString2;
            }
        }
        List<Entity> modifyDataBeforeHandle = super.modifyDataBeforeHandle(list, z);
        if (!z) {
            return modifyDataBeforeHandle;
        }
        List<Entity> list2 = modifyDataBeforeHandle;
        Iterator<T> it3 = list2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it3.next();
            if (Intrinsics.areEqual(t3.getEntityTemplate(), "iconTabLinkGridCard")) {
                break;
            }
        }
        if (t3 instanceof EntityCard) {
            t = t3;
        }
        T t5 = t;
        if (t5 == null) {
            return modifyDataBeforeHandle;
        }
        ArrayList arrayList = new ArrayList();
        for (T t6 : list2) {
            if (Intrinsics.areEqual(t6.getEntityTemplate(), "subTabLinkCard")) {
                arrayList.add(t6);
            }
        }
        ArrayList<Entity> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Entity entity : arrayList2) {
            Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
            arrayList3.add((EntityCard) entity);
        }
        ArrayList arrayList4 = arrayList3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList4, 10)), 16));
        for (Object obj : arrayList4) {
            String title2 = ((EntityCard) obj).getTitle();
            if (title2 == null) {
                title2 = "";
            }
            linkedHashMap.put(title2, obj);
        }
        this.subTabLinkCardMap = linkedHashMap;
        if (modifyDataBeforeHandle instanceof ArrayList) {
            Intrinsics.checkNotNull(linkedHashMap);
            ((ArrayList) modifyDataBeforeHandle).removeAll(linkedHashMap.values());
        }
        this.iconTab = t5;
        return modifyDataBeforeHandle.subList(0, modifyDataBeforeHandle.indexOf(t5));
    }

    private final void onShareActionClick() {
        Uri.Builder buildUpon = Uri.parse("https://www.coolapk.com/page").buildUpon();
        String str = this.url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        }
        Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("url", str);
        String str2 = this.title;
        boolean z = false;
        if (!(str2 == null || str2.length() == 0)) {
            appendQueryParameter.appendQueryParameter("title", this.title);
        }
        String str3 = this.subTitle;
        if (str3 == null || str3.length() == 0) {
            z = true;
        }
        if (!z) {
            appendQueryParameter.appendQueryParameter("subTitle", this.subTitle);
        }
        String builder = appendQueryParameter.toString();
        Intrinsics.checkNotNullExpressionValue(builder, "Uri.parse(\"https://www.c…              .toString()");
        FragmentActivity activity = getActivity();
        String str4 = this.title;
        String str5 = "";
        if (str4 == null) {
            str4 = str5;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("分享专题：");
        String str6 = this.title;
        if (str6 != null) {
            str5 = str6;
        }
        sb.append(str5);
        sb.append("  ");
        sb.append(builder);
        sb.append(' ');
        sb.append(getString(2131886685));
        ActionManager.shareText(activity, str4, sb.toString());
    }

    private final boolean shouldShowShareView() {
        if (this.url != null) {
            String str = this.url;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("url");
            }
            if (new Regex("_(ZT|ZHUANTI|JINRI|HUODONG|ZHUNTI|ZHONGCE)_").containsMatchIn(str) && getTranslucentHeaderConverter().getShouldHandleHeader()) {
                return true;
            }
        }
        return false;
    }

    private final boolean shouldShowMenu() {
        return shouldShowShareView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onListScrollEventChanged(CoolPicScrollEvent coolPicScrollEvent) {
        RvInFragmentLayoutBinding obtainBinding;
        AppBarLayout appBarLayout;
        Intrinsics.checkNotNullParameter(coolPicScrollEvent, "event");
        if (coolPicScrollEvent.getIndex() > -1) {
            boolean z = coolPicScrollEvent.getIndex() > 1;
            if (getFallConvert().isFallInitialized() && (obtainBinding = getFallConvert().obtainBinding()) != null && (appBarLayout = obtainBinding.appBar) != null) {
                appBarLayout.setExpanded(!z);
            }
        }
    }
}
