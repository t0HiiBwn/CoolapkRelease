package com.coolapk.market.view.cardlist;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.TopBottomDividerRule;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.view.user.block.UserBlackListFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120%2\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\u0012H\u0002J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020,H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR\u001a\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\nR\u001e\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\b¨\u00061"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityConfigHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "blackListCurrent", "", "getBlackListCurrent", "()I", "setBlackListCurrent", "(I)V", "blackListTotal", "getBlackListTotal", "setBlackListTotal", "blockSpamWord", "getBlockSpamWord", "setBlockSpamWord", "entity", "Lcom/coolapk/market/model/Entity;", "getFragment", "()Lcom/coolapk/market/view/cardlist/EntityListFragment;", "fragmentBackgroundColor", "getFragmentBackgroundColor", "()Ljava/lang/Integer;", "setFragmentBackgroundColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "maxSize", "getMaxSize", "setMaxSize", "rankAwardCardIndex", "getRankAwardCardIndex", "setRankAwardCardIndex", "<set-?>", "spanCount", "getSpanCount", "modifyData", "", "list", "isRefresh", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onConfigCardLoaded", "data", "onSaveInstanceState", "outState", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityConfigHelper.kt */
public final class EntityConfigHelper extends EntityDataFilter {
    private int blackListCurrent;
    private int blackListTotal;
    private int blockSpamWord;
    private Entity entity;
    private final EntityListFragment fragment;
    private Integer fragmentBackgroundColor;
    private int maxSize = -1;
    private int rankAwardCardIndex = -1;
    private int spanCount = 2;

    public EntityConfigHelper(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
    }

    public final EntityListFragment getFragment() {
        return this.fragment;
    }

    public final int getRankAwardCardIndex() {
        return this.rankAwardCardIndex;
    }

    public final void setRankAwardCardIndex(int i) {
        this.rankAwardCardIndex = i;
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    public final void setMaxSize(int i) {
        this.maxSize = i;
    }

    public final int getSpanCount() {
        return this.spanCount;
    }

    public final Integer getFragmentBackgroundColor() {
        return this.fragmentBackgroundColor;
    }

    public final void setFragmentBackgroundColor(Integer num) {
        this.fragmentBackgroundColor = num;
    }

    public final int getBlockSpamWord() {
        return this.blockSpamWord;
    }

    public final void setBlockSpamWord(int i) {
        this.blockSpamWord = i;
    }

    public final int getBlackListTotal() {
        return this.blackListTotal;
    }

    public final void setBlackListTotal(int i) {
        this.blackListTotal = i;
    }

    public final int getBlackListCurrent() {
        return this.blackListCurrent;
    }

    public final void setBlackListCurrent(int i) {
        this.blackListCurrent = i;
    }

    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            Entity entity2 = (Entity) bundle.getParcelable("EntityConfigHelperData");
            this.entity = entity2;
            if (entity2 != null) {
                onConfigCardLoaded(entity2);
            }
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("EntityConfigHelperData", this.entity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public List<Entity> modifyData(List<? extends Entity> list, boolean z) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "list");
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (Intrinsics.areEqual(((Entity) obj).getEntityTemplate(), "configCard")) {
                break;
            }
        }
        if (obj == null) {
            return list;
        }
        Entity entity2 = (Entity) obj;
        this.entity = entity2;
        onConfigCardLoaded(entity2);
        return removeData$presentation_coolapkAppRelease(list, entity2);
    }

    private final void onConfigCardLoaded(Entity entity2) {
        Integer stringToColor;
        this.rankAwardCardIndex = EntityExtendsKt.getIntExtraData(entity2, "rankAwardCardIndex", -1);
        this.maxSize = EntityExtendsKt.getIntExtraData(entity2, "maxSize", -1);
        this.blockSpamWord = EntityExtendsKt.getIntExtraData(entity2, "blockSpamWord", this.blockSpamWord);
        this.blackListTotal = EntityExtendsKt.getIntExtraData(entity2, "total", 0);
        this.blackListCurrent = EntityExtendsKt.getIntExtraData(entity2, "current", 0);
        if (this.blackListTotal > 0) {
            EntityListFragment entityListFragment = this.fragment;
            if (entityListFragment instanceof UserBlackListFragment) {
                FragmentActivity requireActivity = entityListFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
                requireActivity.setTitle("黑名单管理（" + this.blackListCurrent + '/' + this.blackListTotal + (char) 65289);
            }
        }
        int intExtraData = EntityExtendsKt.getIntExtraData(entity2, "fragmentPaddingLeft", Integer.MIN_VALUE);
        int intExtraData2 = EntityExtendsKt.getIntExtraData(entity2, "fragmentPaddingRight", Integer.MIN_VALUE);
        if (!(intExtraData == Integer.MIN_VALUE && intExtraData2 == Integer.MIN_VALUE)) {
            this.fragment.getVxDividerDecoration$presentation_coolapkAppRelease().setDefaultMarginRule(ViewMarginData.Companion.createImmutable(NumberExtendsKt.getDp(Integer.valueOf(intExtraData)), NumberExtendsKt.getDp(Integer.valueOf(intExtraData2))));
        }
        String stringExtraData = EntityExtendsKt.getStringExtraData(entity2, "fragmentBackgroundColor", "");
        if (!(!(stringExtraData.length() > 0) || (stringToColor = ColorUtils.stringToColor(stringExtraData)) == null || this.fragment.getView() == null)) {
            this.fragmentBackgroundColor = stringToColor;
            this.fragment.getRecyclerView().setBackgroundColor(stringToColor.intValue());
        }
        int intExtraData3 = EntityExtendsKt.getIntExtraData(entity2, "fragmentPaddingTop", Integer.MIN_VALUE);
        int intExtraData4 = EntityExtendsKt.getIntExtraData(entity2, "fragmentPaddingBottom", Integer.MIN_VALUE);
        if (!(intExtraData3 == Integer.MIN_VALUE && intExtraData4 == Integer.MIN_VALUE)) {
            this.fragment.getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new TopBottomDividerRule(DividerData.Companion.createImmutable$default(DividerData.Companion, 0, 0, NumberExtendsKt.getDp(Integer.valueOf(intExtraData3)), null, 11, null), DividerData.Companion.createImmutable$default(DividerData.Companion, 0, 0, NumberExtendsKt.getDp(Integer.valueOf(intExtraData4)), null, 11, null)));
        }
        this.spanCount = EntityExtendsKt.getIntExtraData(entity2, "listSpanCount", 2);
        RecyclerView recyclerView = this.fragment.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "fragment.recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).setSpanCount(this.spanCount);
        }
        if (EntityExtendsKt.getIntExtraData(entity2, "fragmentTopDecoration", -1) == 1) {
            this.fragment.getRecyclerView().addItemDecoration(new ListTopBackgroundDecoration(0, 0, 3, null));
        }
    }
}
