package com.coolapk.market.view.collectionList;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Collection;
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
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0014J \u0010&\u001a\u00020!2\u0006\u0010 \u001a\u00020!2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionSelectFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "bottomSheet", "Lcom/coolapk/market/widget/view/SlideUpView;", "cancelMap", "Ljava/util/LinkedHashMap;", "", "Lcom/coolapk/market/model/Collection;", "colId", "collectionMap", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "doneView", "Landroid/widget/TextView;", "feedId", "type", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "onRequestFailure", "error", "", "onRequestResponse", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionSelectFragment.kt */
public final class CollectionSelectFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_DATA = "DATA";
    private SlideUpView bottomSheet;
    private LinkedHashMap<String, Collection> cancelMap;
    private String colId;
    private LinkedHashMap<String, Collection> collectionMap;
    private FragmentBindingComponent component;
    private TextView doneView;
    private String feedId;
    private String type;

    @JvmStatic
    public static final CollectionSelectFragment newInstance(String str, String str2) {
        return Companion.newInstance(str, str2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionSelectFragment$Companion;", "", "()V", "KEY_DATA", "", "newInstance", "Lcom/coolapk/market/view/collectionList/CollectionSelectFragment;", "feedId", "type", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CollectionSelectFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CollectionSelectFragment newInstance(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "feedId");
            Intrinsics.checkNotNullParameter(str2, "type");
            CollectionSelectFragment collectionSelectFragment = new CollectionSelectFragment();
            Bundle bundle = new Bundle();
            bundle.putString("feedId", str);
            bundle.putString("type", str2);
            Unit unit = Unit.INSTANCE;
            collectionSelectFragment.setArguments(bundle);
            return collectionSelectFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.component = new FragmentBindingComponent(this);
        setEmptyData(getString(2131886765), 0);
        BaseMultiTypeAdapter adapter$presentation_coolapkAppRelease = getAdapter$presentation_coolapkAppRelease();
        SimpleHolderFactorBuilder constructor = SimpleViewHolderFactor.Companion.withLayoutId(2131558656).suitedMethod(CollectionSelectFragment$onActivityCreated$1.INSTANCE).constructor(new CollectionSelectFragment$onActivityCreated$2(this));
        Integer num = getItemViewTypeByEntityType().get("dyh");
        Intrinsics.checkNotNull(num);
        Intrinsics.checkNotNullExpressionValue(num, "itemViewTypeByEntityType…yUtils.ENTITY_TYPE_DYH]!!");
        adapter$presentation_coolapkAppRelease.register(constructor.resetItemViewType(num.intValue()).build(), 0);
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), 48.0f));
        setRefreshEnable(false);
        setLoadMoreEnable(true);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewExtendsKt.removeAllItemDecorations(recyclerView);
        if (getUserVisibleHint()) {
            initData();
        }
        if (isAdded()) {
            FragmentActivity activity = getActivity();
            CollectionSelectActivity collectionSelectActivity = null;
            if (!(activity instanceof CollectionSelectActivity)) {
                activity = null;
            }
            CollectionSelectActivity collectionSelectActivity2 = (CollectionSelectActivity) activity;
            Intrinsics.checkNotNull(collectionSelectActivity2);
            this.doneView = collectionSelectActivity2.getActionDoneView();
            FragmentActivity activity2 = getActivity();
            if (activity2 instanceof CollectionSelectActivity) {
                collectionSelectActivity = activity2;
            }
            CollectionSelectActivity collectionSelectActivity3 = collectionSelectActivity;
            Intrinsics.checkNotNull(collectionSelectActivity3);
            this.bottomSheet = collectionSelectActivity3.getBottomSheet();
        }
        View emptyView = getEmptyView();
        Intrinsics.checkNotNullExpressionValue(emptyView, "emptyView");
        emptyView.setTranslationY((float) (-DisplayUtils.dp2px(getActivity(), 142.0f)));
        View loadingView = getLoadingView();
        Intrinsics.checkNotNullExpressionValue(loadingView, "loadingView");
        loadingView.setTranslationY((float) (-DisplayUtils.dp2px(getActivity(), 142.0f)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 424) {
            Intrinsics.checkNotNull(intent);
            Bundle extras = intent.getExtras();
            Intrinsics.checkNotNull(extras);
            this.colId = extras.getString("KEY_ID");
            reloadData();
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.feedId = requireArguments().getString("feedId");
        this.type = requireArguments().getString("type");
        FragmentActivity activity = getActivity();
        CollectionSelectActivity collectionSelectActivity = null;
        if (!(activity instanceof CollectionSelectActivity)) {
            activity = null;
        }
        CollectionSelectActivity collectionSelectActivity2 = (CollectionSelectActivity) activity;
        Intrinsics.checkNotNull(collectionSelectActivity2);
        this.collectionMap = collectionSelectActivity2.getCollectionMap();
        FragmentActivity activity2 = getActivity();
        if (activity2 instanceof CollectionSelectActivity) {
            collectionSelectActivity = activity2;
        }
        CollectionSelectActivity collectionSelectActivity3 = collectionSelectActivity;
        Intrinsics.checkNotNull(collectionSelectActivity3);
        this.cancelMap = collectionSelectActivity3.getCancelMap();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        Observable<R> map = DataManager.getInstance().getCollectionList("", this.feedId, 1, this.type, i, (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId(), (z || (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) == null) ? null : findLastEntity$default.getEntityId()).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (z && CollectionUtils.isEmpty(list)) {
            setEmptyData(getString(2131886765), 0);
        }
        getAdapter$presentation_coolapkAppRelease().notifyDataSetChanged();
        Intrinsics.checkNotNull(list);
        int size = list.size();
        for (int i = 0; i < size && !TextUtils.isEmpty(this.colId); i++) {
            Object obj = list.get(i);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Collection");
            Collection collection = (Collection) obj;
            if (TextUtils.equals(this.colId, collection.getId())) {
                LinkedHashMap<String, Collection> linkedHashMap = this.collectionMap;
                Intrinsics.checkNotNull(linkedHashMap);
                String id = collection.getId();
                Intrinsics.checkNotNull(id);
                Intrinsics.checkNotNullExpressionValue(id, "item.id!!");
                linkedHashMap.put(id, collection);
                RecyclerView recyclerView = getRecyclerView();
                Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyItemChanged(i);
                }
                return onRequestResponse;
            }
        }
        return onRequestResponse;
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
