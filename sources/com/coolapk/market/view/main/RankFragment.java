package com.coolapk.market.view.main;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckedTextView;
import com.coolapk.market.databinding.ItemRankHeaderBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\rH\u0014J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\bH\u0016J \u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/main/RankFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "apkType", "", "podiumCardIndex", "Ljava/util/concurrent/atomic/AtomicInteger;", "filterDataWhenRefresh", "", "originData", "", "index", "newDataByCardId", "", "modifyDataBeforeHandle", "", "Lcom/coolapk/market/model/Entity;", "data", "isRefresh", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateRequest", "Lrx/Observable;", "page", "onRequestResponse", "onSaveInstanceState", "outState", "reloadData", "Companion", "RankHeaderViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RankFragment.kt */
public final class RankFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private static final String HOLDER_TYPE_RANK_TAB = "HOLDER_TYPE_RANK_TAB";
    private static final String KEY_APK_TYPE = "APK_TYPE";
    private String apkType = "0";
    private AtomicInteger podiumCardIndex = new AtomicInteger(-1);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/main/RankFragment$Companion;", "", "()V", "HOLDER_TYPE_RANK_TAB", "", "KEY_APK_TYPE", "newInstance", "Lcom/coolapk/market/view/main/RankFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RankFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RankFragment newInstance() {
            Bundle bundle = new Bundle();
            RankFragment rankFragment = new RankFragment();
            rankFragment.setArguments(bundle);
            return rankFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            String string = bundle.getString("APK_TYPE", "0");
            Intrinsics.checkNotNullExpressionValue(string, "savedInstanceState.getSt…DataManager.APK_TYPE_ALL)");
            this.apkType = string;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558895).suitedEntityType("HOLDER_TYPE_RANK_TAB").constructor(new RankFragment$onActivityCreated$1(this)).build(), 0, 2, null);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558931).suitedEntityType("apk").constructor(new RankFragment$onActivityCreated$2(this)).build(), 0);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        int lastIndex;
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (z) {
            HolderItem build = HolderItem.newBuilder().entityType("HOLDER_TYPE_RANK_TAB").title(this.apkType).build();
            int findFirstEntityIndex$default = EntityListFragment.findFirstEntityIndex$default(this, "HOLDER_TYPE_RANK_TAB", null, false, false, 6, null);
            if (findFirstEntityIndex$default == -1) {
                List<Parcelable> dataList = getDataList();
                Intrinsics.checkNotNullExpressionValue(build, "holderItem");
                dataList.add(0, build);
            } else {
                List<Parcelable> dataList2 = getDataList();
                Intrinsics.checkNotNullExpressionValue(build, "holderItem");
                dataList2.set(findFirstEntityIndex$default, build);
            }
        }
        int findFirstEntityIndex$default2 = EntityListFragment.findFirstEntityIndex$default(this, "card", "rankAwardCard", false, false, 12, null);
        int i = this.podiumCardIndex.get();
        this.podiumCardIndex.set(findFirstEntityIndex$default2);
        if (!(findFirstEntityIndex$default2 == -1 || i == -1 || i == findFirstEntityIndex$default2 || (lastIndex = CollectionsKt.getLastIndex(getDataList()) - findFirstEntityIndex$default2) <= 0)) {
            getAdapter$presentation_coolapkAppRelease().notifyItemRangeChanged(findFirstEntityIndex$default2 + 1, lastIndex);
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected List<Entity> modifyDataBeforeHandle(List<? extends Entity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "data");
        List<Entity> modifyDataBeforeHandle = super.modifyDataBeforeHandle(list, z);
        if (getDataList().size() <= 1) {
            return modifyDataBeforeHandle;
        }
        int i = 101 - (this.podiumCardIndex.get() != -1 ? 2 : 0);
        if (getDataList().size() >= i) {
            return CollectionsKt.emptyList();
        }
        int size = (getDataList().size() + modifyDataBeforeHandle.size()) - i;
        if (size <= 0) {
            return modifyDataBeforeHandle;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(modifyDataBeforeHandle.subList(0, modifyDataBeforeHandle.size() - size));
        return arrayList;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (!(obj instanceof HolderItem) || !Intrinsics.areEqual(((HolderItem) obj).getEntityType(), "HOLDER_TYPE_RANK_TAB")) {
            return super.filterDataWhenRefresh(obj, i, map);
        }
        return -1;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString("APK_TYPE", this.apkType);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        DataManager instance = DataManager.getInstance();
        String str = this.apkType;
        String str2 = null;
        String entityId = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, "apk", null, false, false, 14, null)) == null) ? null : findFirstEntity$default.getEntityId();
        if (!z && (findLastEntity$default = EntityListFragment.findLastEntity$default(this, "apk", false, 2, null)) != null) {
            str2 = findLastEntity$default.getEntityId();
        }
        Observable<R> map = instance.getRankAppList(str, i, entityId, str2).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    public void reloadData() {
        CollectionsKt.removeAll((List) getDataList(), (Function1) RankFragment$reloadData$1.INSTANCE);
        setLoadMoreEnable(true);
        setPage(1);
        super.reloadData();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/main/RankFragment$RankHeaderViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "actionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RankFragment.kt */
    private static final class RankHeaderViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558895;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RankHeaderViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(itemActionHandler, "actionHandler");
            ItemRankHeaderBinding itemRankHeaderBinding = (ItemRankHeaderBinding) getBinding();
            RankHeaderViewHolder rankHeaderViewHolder = this;
            ViewUtil.clickListener(itemRankHeaderBinding.click1, rankHeaderViewHolder);
            ViewUtil.clickListener(itemRankHeaderBinding.click2, rankHeaderViewHolder);
            ViewUtil.clickListener(itemRankHeaderBinding.click3, rankHeaderViewHolder);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/main/RankFragment$RankHeaderViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: RankFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0054  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            char c;
            Intrinsics.checkNotNullParameter(obj, "data");
            String title = ((HolderItem) obj).getTitle();
            boolean z = true;
            if (title != null) {
                switch (title.hashCode()) {
                    case 48:
                        title.equals("0");
                        break;
                    case 49:
                        if (title.equals("1")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 50:
                        if (title.equals("2")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                ItemRankHeaderBinding itemRankHeaderBinding = (ItemRankHeaderBinding) getBinding();
                CheckedTextView checkedTextView = itemRankHeaderBinding.textView1;
                Intrinsics.checkNotNullExpressionValue(checkedTextView, "binding.textView1");
                checkedTextView.setChecked(c != 0);
                CheckedTextView checkedTextView2 = itemRankHeaderBinding.textView2;
                Intrinsics.checkNotNullExpressionValue(checkedTextView2, "binding.textView2");
                checkedTextView2.setChecked(c != 1);
                CheckedTextView checkedTextView3 = itemRankHeaderBinding.textView3;
                Intrinsics.checkNotNullExpressionValue(checkedTextView3, "binding.textView3");
                if (c != 2) {
                    z = false;
                }
                checkedTextView3.setChecked(z);
            }
            c = 0;
            ItemRankHeaderBinding itemRankHeaderBinding = (ItemRankHeaderBinding) getBinding();
            CheckedTextView checkedTextView = itemRankHeaderBinding.textView1;
            Intrinsics.checkNotNullExpressionValue(checkedTextView, "binding.textView1");
            checkedTextView.setChecked(c != 0);
            CheckedTextView checkedTextView2 = itemRankHeaderBinding.textView2;
            Intrinsics.checkNotNullExpressionValue(checkedTextView2, "binding.textView2");
            checkedTextView2.setChecked(c != 1);
            CheckedTextView checkedTextView3 = itemRankHeaderBinding.textView3;
            Intrinsics.checkNotNullExpressionValue(checkedTextView3, "binding.textView3");
            if (c != 2) {
            }
            checkedTextView3.setChecked(z);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ItemRankHeaderBinding itemRankHeaderBinding = (ItemRankHeaderBinding) getBinding();
            CheckedTextView checkedTextView = itemRankHeaderBinding.textView1;
            Intrinsics.checkNotNullExpressionValue(checkedTextView, "binding.textView1");
            boolean z = true;
            checkedTextView.setChecked(view == itemRankHeaderBinding.click1);
            CheckedTextView checkedTextView2 = itemRankHeaderBinding.textView2;
            Intrinsics.checkNotNullExpressionValue(checkedTextView2, "binding.textView2");
            checkedTextView2.setChecked(view == itemRankHeaderBinding.click2);
            CheckedTextView checkedTextView3 = itemRankHeaderBinding.textView3;
            Intrinsics.checkNotNullExpressionValue(checkedTextView3, "binding.textView3");
            if (view != itemRankHeaderBinding.click3) {
                z = false;
            }
            checkedTextView3.setChecked(z);
            super.onClick(view);
        }
    }
}
