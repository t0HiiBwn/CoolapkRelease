package com.coolapk.market.view.dyhv8;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleHolderFactorBuilder;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.view.SlideUpView;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00172\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J \u0010 \u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00102\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0014J\u0016\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0010R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhEditorFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "bottomSheet", "Lcom/coolapk/market/widget/view/SlideUpView;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "currentKey", "", "doneView", "Landroid/widget/TextView;", "dyhMap", "Ljava/util/LinkedHashMap;", "Lcom/coolapk/market/model/DyhModel;", "feedId", "isSearchList", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "", "onRequestFailure", "error", "", "onRequestResponse", "data", "searchDyh", "searchKey", "isSearch", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhEditorFragment.kt */
public final class DyhEditorFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_DATA = "DATA";
    private SlideUpView bottomSheet;
    private FragmentBindingComponent component;
    private String currentKey = "";
    private TextView doneView;
    private LinkedHashMap<String, DyhModel> dyhMap;
    private String feedId;
    private boolean isSearchList;

    @JvmStatic
    public static final DyhEditorFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhEditorFragment$Companion;", "", "()V", "KEY_DATA", "", "newInstance", "Lcom/coolapk/market/view/dyhv8/DyhEditorFragment;", "feedId", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhEditorFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DyhEditorFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "feedId");
            DyhEditorFragment dyhEditorFragment = new DyhEditorFragment();
            Bundle bundle = new Bundle();
            bundle.putString("feedId", str);
            Unit unit = Unit.INSTANCE;
            dyhEditorFragment.setArguments(bundle);
            return dyhEditorFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.component = new FragmentBindingComponent(this);
        setEmptyData(getString(2131886827), 0);
        BaseMultiTypeAdapter adapter$presentation_coolapkAppRelease = getAdapter$presentation_coolapkAppRelease();
        SimpleHolderFactorBuilder constructor = SimpleViewHolderFactor.Companion.withLayoutId(2131558686).suitedMethod(DyhEditorFragment$onActivityCreated$1.INSTANCE).constructor(new DyhEditorFragment$onActivityCreated$2(this));
        Integer num = getItemViewTypeByEntityType().get("dyh");
        Intrinsics.checkNotNull(num);
        Intrinsics.checkNotNullExpressionValue(num, "itemViewTypeByEntityType…yUtils.ENTITY_TYPE_DYH]!!");
        adapter$presentation_coolapkAppRelease.register(constructor.resetItemViewType(num.intValue()).build(), 0);
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), 48.0f));
        setRefreshEnable(false);
        setLoadMoreEnable(true);
        if (getUserVisibleHint()) {
            initData();
        }
        if (isAdded()) {
            FragmentActivity activity = getActivity();
            DyhIncludActivity dyhIncludActivity = null;
            if (!(activity instanceof DyhIncludActivity)) {
                activity = null;
            }
            DyhIncludActivity dyhIncludActivity2 = (DyhIncludActivity) activity;
            Intrinsics.checkNotNull(dyhIncludActivity2);
            this.doneView = dyhIncludActivity2.getActionDoneView();
            FragmentActivity activity2 = getActivity();
            if (activity2 instanceof DyhIncludActivity) {
                dyhIncludActivity = activity2;
            }
            DyhIncludActivity dyhIncludActivity3 = dyhIncludActivity;
            Intrinsics.checkNotNull(dyhIncludActivity3);
            this.bottomSheet = dyhIncludActivity3.getBottomSheet();
        }
        View emptyView = getEmptyView();
        Intrinsics.checkNotNullExpressionValue(emptyView, "emptyView");
        emptyView.setTranslationY((float) (-DisplayUtils.dp2px(getActivity(), 142.0f)));
        View loadingView = getLoadingView();
        Intrinsics.checkNotNullExpressionValue(loadingView, "loadingView");
        loadingView.setTranslationY((float) (-DisplayUtils.dp2px(getActivity(), 142.0f)));
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.feedId = requireArguments().getString("feedId");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof DyhIncludActivity)) {
            activity = null;
        }
        DyhIncludActivity dyhIncludActivity = (DyhIncludActivity) activity;
        Intrinsics.checkNotNull(dyhIncludActivity);
        this.dyhMap = dyhIncludActivity.getDyhMap();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        Entity findLastEntity$default2;
        Entity findFirstEntity$default2;
        Entity findLastEntity$default3;
        Entity findFirstEntity$default3;
        String str = null;
        if (this.isSearchList) {
            DataManager instance = DataManager.getInstance();
            String str2 = this.currentKey;
            String entityId = (!z || (findFirstEntity$default3 = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default3.getEntityId();
            String entityId2 = (z || (findLastEntity$default3 = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) == null) ? null : findLastEntity$default3.getEntityId();
            Entity findLastEntity$default4 = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
            if (findLastEntity$default4 != null) {
                str = EntityExtendsKt.getPageContext(findLastEntity$default4);
            }
            Observable<R> map = instance.typeSearch("dyh", str2, i, entityId, entityId2, str).map(RxUtils.checkResultToData());
            Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
            return map;
        }
        FragmentActivity activity = getActivity();
        if (!(activity instanceof DyhIncludActivity)) {
            activity = null;
        }
        DyhIncludActivity dyhIncludActivity = (DyhIncludActivity) activity;
        Intrinsics.checkNotNull(dyhIncludActivity);
        if (dyhIncludActivity.getPage() == 0) {
            DataManager instance2 = DataManager.getInstance();
            String entityId3 = (!z || (findFirstEntity$default2 = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default2.getEntityId();
            if (!z && (findLastEntity$default2 = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
                str = findLastEntity$default2.getEntityId();
            }
            Observable<R> map2 = instance2.getMyEditorDyhList(1, i, entityId3, str).map(RxUtils.checkResultToData());
            Intrinsics.checkNotNullExpressionValue(map2, "DataManager.getInstance(…tils.checkResultToData())");
            return map2;
        }
        DataManager instance3 = DataManager.getInstance();
        String entityId4 = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
        if (!z && (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
            str = findLastEntity$default.getEntityId();
        }
        Observable<R> map3 = instance3.getDyhList("", "1", i, entityId4, str).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map3, "DataManager.getInstance(…tils.checkResultToData())");
        return map3;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        if (z && CollectionUtils.isEmpty(list)) {
            setEmptyData(getString(2131886827), 0);
        }
        return super.onRequestResponse(z, list);
    }

    public final void searchDyh(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "searchKey");
        this.isSearchList = z;
        if (!Intrinsics.areEqual(this.currentKey, str)) {
            cancelLoadData();
            getDataList().clear();
            this.currentKey = str;
            setPage(1);
            reloadData();
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        Throwable cause = th.getCause();
        setEmptyData(cause != null ? cause.getMessage() : null, 0);
        TextView textView = this.doneView;
        Intrinsics.checkNotNull(textView);
        textView.setEnabled(true);
    }
}
