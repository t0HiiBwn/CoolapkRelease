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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0004H\u0002R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/view/category/RankingAppFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "categoryId", "", "getCategoryId", "()Ljava/lang/String;", "categoryId$delegate", "Lkotlin/Lazy;", "rankType", "tagKeyword", "getTagKeyword", "tagKeyword$delegate", "modifyDataBeforeHandle", "", "Lcom/coolapk/market/model/Entity;", "data", "isRefresh", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateRequest", "Lrx/Observable;", "page", "", "resetRankType", "Companion", "RankTypeViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/category/RankingAppFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/category/RankingAppFragment;", "categoryId", "", "tagKeyword", "rankType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558924).suitedEntityType("apk").constructor(new RankingAppFragment$onActivityCreated$1(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558636).suitedEntityType("holder_order_selector").constructor(RankingAppFragment$onActivityCreated$2.INSTANCE).doBeforeBind(new RankingAppFragment$onActivityCreated$3(this)).build(), 0, 2, null);
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

    /* access modifiers changed from: private */
    public final void resetRankType(String str) {
        this.rankType = str;
        getDataList().clear();
        setPage(1);
        reloadData(true);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001bB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/category/RankingAppFragment$RankTypeViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemCategoryDetailRankBinding;", "Lcom/coolapk/market/model/HolderItem;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "rankType", "", "getRankType", "()Ljava/lang/String;", "setRankType", "(Ljava/lang/String;)V", "resetRankTypeFunc", "Lkotlin/Function1;", "", "getResetRankTypeFunc", "()Lkotlin/jvm/functions/Function1;", "setResetRankTypeFunc", "(Lkotlin/jvm/functions/Function1;)V", "bindToContent", "data", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RankingAppFragment.kt */
    private static final class RankTypeViewHolder extends GenericBindHolder<ItemCategoryDetailRankBinding, HolderItem> implements PopupMenu.OnMenuItemClickListener {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558636;
        public String rankType;
        public Function1<? super String, Unit> resetRankTypeFunc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RankTypeViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/category/RankingAppFragment$RankTypeViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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
                        itemCategoryDetailRankBinding.textView.setText(2131886600);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886597);
                    break;
                case -1268958287:
                    if (str.equals("follow")) {
                        itemCategoryDetailRankBinding.textView.setText(2131886599);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886597);
                    break;
                case -938102371:
                    if (str.equals("rating")) {
                        itemCategoryDetailRankBinding.textView.setText(2131886602);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886597);
                    break;
                case -235611093:
                    if (str.equals("pubdate")) {
                        itemCategoryDetailRankBinding.textView.setText(2131886601);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886597);
                    break;
                case 950398559:
                    if (str.equals("comment")) {
                        itemCategoryDetailRankBinding.textView.setText(2131886596);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886597);
                    break;
                case 1427818632:
                    if (str.equals("download")) {
                        itemCategoryDetailRankBinding.textView.setText(2131886598);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886597);
                    break;
                case 1544803905:
                    if (str.equals("default")) {
                        itemCategoryDetailRankBinding.textView.setText(2131886597);
                        break;
                    }
                    itemCategoryDetailRankBinding.textView.setText(2131886597);
                    break;
                default:
                    itemCategoryDetailRankBinding.textView.setText(2131886597);
                    break;
            }
            ViewUtil.clickListener(itemCategoryDetailRankBinding.getRoot(), new RankingAppFragment$RankTypeViewHolder$bindToContent$1(this, itemCategoryDetailRankBinding));
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            Intrinsics.checkNotNullParameter(menuItem, "item");
            String str = "default";
            switch (menuItem.getItemId()) {
                case 2131361949:
                    str = "comment";
                    break;
                case 2131361951:
                    str = "download";
                    break;
                case 2131361952:
                    str = "follow";
                    break;
                case 2131361953:
                    str = "lastupdate";
                    break;
                case 2131361954:
                    str = "pubdate";
                    break;
                case 2131361955:
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
