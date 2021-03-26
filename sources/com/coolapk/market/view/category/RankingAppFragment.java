package com.coolapk.market.view.category;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.PopupMenu;
import com.coolapk.market.databinding.ItemCategoryDetailRankBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

/* compiled from: RankingAppFragment.kt */
public final class RankingAppFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private final Lazy categoryId$delegate = LazyKt.lazy(new RankingAppFragment$categoryId$2(this));
    private String rankType;
    private final Lazy tagKeyword$delegate = LazyKt.lazy(new RankingAppFragment$tagKeyword$2(this));

    private final String getCategoryId() {
        return (String) this.categoryId$delegate.getValue();
    }

    private final String getTagKeyword() {
        return (String) this.tagKeyword$delegate.getValue();
    }

    public static final /* synthetic */ String access$getRankType$p(RankingAppFragment rankingAppFragment) {
        String str = rankingAppFragment.rankType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankType");
        }
        return str;
    }

    /* compiled from: RankingAppFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RankingAppFragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str3, "rankType");
            Bundle bundle = new Bundle();
            bundle.putString("categoryId", str);
            bundle.putString("tagKeyword", str2);
            bundle.putString("rankType", str3);
            RankingAppFragment rankingAppFragment = new RankingAppFragment();
            rankingAppFragment.setArguments(bundle);
            return rankingAppFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("rankType");
        Intrinsics.checkNotNull(string);
        this.rankType = string;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558931).suitedEntityType("apk").constructor(new RankingAppFragment$onActivityCreated$1(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558642).suitedEntityType("holder_order_selector").constructor(RankingAppFragment$onActivityCreated$2.INSTANCE).doBeforeBind(new RankingAppFragment$onActivityCreated$3(this)).build(), 0, 2, null);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<Result<List<Entity>>> observable;
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        String str = null;
        String entityId = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, "apk", null, false, false, 14, null)) == null) ? null : findFirstEntity$default.getEntityId();
        if (!z && (findLastEntity$default = EntityListFragment.findLastEntity$default(this, "apk", false, 2, null)) != null) {
            str = findLastEntity$default.getEntityId();
        }
        if (getCategoryId() != null) {
            DataManager instance = DataManager.getInstance();
            String categoryId = getCategoryId();
            String str2 = this.rankType;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rankType");
            }
            String str3 = this.rankType;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rankType");
            }
            observable = instance.getAppListWithCategory(categoryId, str2, str3, i, entityId, str);
            Intrinsics.checkNotNullExpressionValue(observable, "DataManager.getInstance(…age, firstItem, lastItem)");
        } else {
            DataManager instance2 = DataManager.getInstance();
            String tagKeyword = getTagKeyword();
            String str4 = this.rankType;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rankType");
            }
            String str5 = this.rankType;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rankType");
            }
            observable = instance2.getAppListWithTag(tagKeyword, str4, str5, i, entityId, str);
            Intrinsics.checkNotNullExpressionValue(observable, "DataManager.getInstance(…age, firstItem, lastItem)");
        }
        Observable<List<Entity>> map = observable.map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "observable.map(RxUtils.checkResultToData())");
        return map;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected List<Entity> modifyDataBeforeHandle(List<? extends Entity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "data");
        List<Entity> modifyDataBeforeHandle = super.modifyDataBeforeHandle(list, z);
        if (!z) {
            return modifyDataBeforeHandle;
        }
        ArrayList arrayList = new ArrayList(modifyDataBeforeHandle);
        if (!arrayList.isEmpty()) {
            arrayList.add(0, HolderItem.newBuilder().entityType("holder_order_selector").entityId("1").build());
        }
        return arrayList;
    }

    public final void resetRankType(String str) {
        this.rankType = str;
        getDataList().clear();
        setPage(1);
        reloadData(true);
    }

    /* compiled from: RankingAppFragment.kt */
    private static final class RankTypeViewHolder extends GenericBindHolder<ItemCategoryDetailRankBinding, HolderItem> implements PopupMenu.OnMenuItemClickListener {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558642;
        public String rankType;
        public Function1<? super String, Unit> resetRankTypeFunc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RankTypeViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }

        /* compiled from: RankingAppFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final String getRankType() {
            String str = this.rankType;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rankType");
            }
            return str;
        }

        public final void setRankType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.rankType = str;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> */
        public final Function1<String, Unit> getResetRankTypeFunc() {
            Function1 function1 = this.resetRankTypeFunc;
            if (function1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetRankTypeFunc");
            }
            return function1;
        }

        public final void setResetRankTypeFunc(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.resetRankTypeFunc = function1;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "data");
            ItemCategoryDetailRankBinding itemCategoryDetailRankBinding = (ItemCategoryDetailRankBinding) getBinding();
            Intrinsics.checkNotNull(itemCategoryDetailRankBinding);
            String str = this.rankType;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rankType");
            }
            switch (str.hashCode()) {
                case -1385954593:
                    if (str.equals("lastupdate")) {
                        itemCategoryDetailRankBinding.textView.setText(2131886662);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886659);
                    break;
                case -1268958287:
                    if (str.equals("follow")) {
                        itemCategoryDetailRankBinding.textView.setText(2131886661);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886659);
                    break;
                case -938102371:
                    if (str.equals("rating")) {
                        itemCategoryDetailRankBinding.textView.setText(2131886664);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886659);
                    break;
                case -235611093:
                    if (str.equals("pubdate")) {
                        itemCategoryDetailRankBinding.textView.setText(2131886663);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886659);
                    break;
                case 950398559:
                    if (str.equals("comment")) {
                        itemCategoryDetailRankBinding.textView.setText(2131886658);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886659);
                    break;
                case 1427818632:
                    if (str.equals("download")) {
                        itemCategoryDetailRankBinding.textView.setText(2131886660);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886659);
                    break;
                case 1544803905:
                    if (str.equals("default")) {
                        itemCategoryDetailRankBinding.textView.setText(2131886659);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886659);
                    break;
                default:
                    itemCategoryDetailRankBinding.textView.setText(2131886659);
                    break;
            }
            ViewUtil.clickListener(itemCategoryDetailRankBinding.getRoot(), new RankingAppFragment$RankTypeViewHolder$bindToContent$1(this, itemCategoryDetailRankBinding));
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            Intrinsics.checkNotNullParameter(menuItem, "item");
            String str = "default";
            switch (menuItem.getItemId()) {
                case 2131361950:
                    str = "comment";
                    break;
                case 2131361952:
                    str = "download";
                    break;
                case 2131361953:
                    str = "follow";
                    break;
                case 2131361954:
                    str = "lastupdate";
                    break;
                case 2131361955:
                    str = "pubdate";
                    break;
                case 2131361956:
                    str = "rating";
                    break;
            }
            String str2 = str;
            String str3 = this.rankType;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rankType");
            }
            if (TextUtils.equals(str2, str3)) {
                return true;
            }
            Function1<? super String, Unit> function1 = this.resetRankTypeFunc;
            if (function1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetRankTypeFunc");
            }
            function1.invoke(str);
            return true;
        }
    }
}
