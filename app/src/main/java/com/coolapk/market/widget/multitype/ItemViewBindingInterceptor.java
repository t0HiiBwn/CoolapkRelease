package com.coolapk.market.widget.multitype;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.design.CoolapkCardView;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.cardlist.divider.SimpleAdapterDataObserver;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010%\u001a\u00020!H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/coolapk/market/widget/multitype/ItemViewBindingInterceptor;", "Lcom/coolapk/market/widget/multitype/BindDataInterceptor;", "dataList", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "fixRecordId", "", "(Ljava/util/List;Landroidx/recyclerview/widget/RecyclerView$Adapter;Ljava/lang/String;)V", "adapterObserver", "Lcom/coolapk/market/view/cardlist/divider/SimpleAdapterDataObserver;", "cardStyleArray", "Landroid/util/SparseIntArray;", "getDataList", "()Ljava/util/List;", "getFixRecordId", "()Ljava/lang/String;", "linkedCardStyleRule", "Lcom/coolapk/market/widget/multitype/LinkedCardStyleRule;", "addCardStyleRule", "", "loader", "Lcom/coolapk/market/widget/multitype/CardStyleRule;", "findCardView", "Lcom/coolapk/market/design/CoolapkCardView;", "itemView", "Landroid/view/View;", "getCachedCardStyle", "", "position", "getCardStyle", "onBindData", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "data", "", "onViewAttachedToWindow", "holder", "onViewDetachedFromWindow", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BindDataInterceptor.kt */
public final class ItemViewBindingInterceptor implements BindDataInterceptor {
    private final SimpleAdapterDataObserver adapterObserver;
    private final SparseIntArray cardStyleArray = new SparseIntArray();
    private final List<?> dataList;
    private final String fixRecordId;
    private LinkedCardStyleRule linkedCardStyleRule;

    public ItemViewBindingInterceptor(List<?> list, RecyclerView.Adapter<?> adapter, String str) {
        Intrinsics.checkNotNullParameter(list, "dataList");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(str, "fixRecordId");
        this.dataList = list;
        this.fixRecordId = str;
        SimpleAdapterDataObserver simpleAdapterDataObserver = new SimpleAdapterDataObserver(new ItemViewBindingInterceptor$adapterObserver$1(this));
        this.adapterObserver = simpleAdapterDataObserver;
        adapter.registerAdapterDataObserver(simpleAdapterDataObserver);
    }

    public final List<?> getDataList() {
        return this.dataList;
    }

    public final String getFixRecordId() {
        return this.fixRecordId;
    }

    @Override // com.coolapk.market.widget.multitype.BindDataInterceptor
    public void onBindData(RecyclerView.ViewHolder viewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        CoolapkCardView findCardView = findCardView(view);
        if (findCardView != null) {
            findCardView.bindWithViewHolder(viewHolder, obj);
            findCardView.setCardStyle(getCachedCardStyle(viewHolder.getAdapterPosition()));
            if (viewHolder instanceof CoolapkCardView.CardStyleCallback) {
                ((CoolapkCardView.CardStyleCallback) viewHolder).onCardStyleDetermined(findCardView.getCardStyle());
            }
        } else if (obj instanceof Entity) {
            StringBuilder sb = new StringBuilder();
            sb.append(viewHolder.getClass().getSimpleName());
            sb.append(" => ");
            Entity entity = (Entity) obj;
            sb.append(entity.getEntityType());
            String sb2 = sb.toString();
            if (entity.getEntityTemplate() != null) {
                sb2 = sb2 + " -> " + entity.getEntityTemplate();
            }
            LogUtils.d("Bind: " + sb2, new Object[0]);
        }
        if (obj instanceof Entity) {
            StatisticHelper instance = StatisticHelper.Companion.getInstance();
            View view2 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "viewHolder.itemView");
            instance.traceCardExposedIfNeed(view2, (Entity) obj, this.fixRecordId);
        }
    }

    @Override // com.coolapk.market.widget.multitype.BindDataInterceptor
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        boolean z = viewHolder instanceof BindingViewHolder;
        if (z) {
            if (!z) {
                viewHolder = null;
            }
            BindingViewHolder bindingViewHolder = (BindingViewHolder) viewHolder;
            if (bindingViewHolder != null) {
                bindingViewHolder.onViewAttachedToWindow();
            }
        }
    }

    @Override // com.coolapk.market.widget.multitype.BindDataInterceptor
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        boolean z = viewHolder instanceof BindingViewHolder;
        if (z) {
            if (!z) {
                viewHolder = null;
            }
            BindingViewHolder bindingViewHolder = (BindingViewHolder) viewHolder;
            if (bindingViewHolder != null) {
                bindingViewHolder.onViewDetachedFromWindow();
            }
        }
    }

    public final void addCardStyleRule(CardStyleRule cardStyleRule) {
        Intrinsics.checkNotNullParameter(cardStyleRule, "loader");
        this.linkedCardStyleRule = new LinkedCardStyleRule(cardStyleRule, this.linkedCardStyleRule);
    }

    private final int getCachedCardStyle(int i) {
        if (this.cardStyleArray.indexOfKey(i) >= 0) {
            return this.cardStyleArray.get(i);
        }
        int cardStyle = getCardStyle(i);
        this.cardStyleArray.put(i, cardStyle);
        return cardStyle;
    }

    private final int getCardStyle(int i) {
        LinkedCardStyleRule linkedCardStyleRule2 = this.linkedCardStyleRule;
        if (linkedCardStyleRule2 != null) {
            Object orNull = CollectionsKt.getOrNull(this.dataList, i - 1);
            Object orNull2 = CollectionsKt.getOrNull(this.dataList, i);
            Intrinsics.checkNotNull(orNull2);
            Integer cardStyleRule = linkedCardStyleRule2.getCardStyleRule(i, orNull, orNull2, CollectionsKt.getOrNull(this.dataList, i + 1));
            if (cardStyleRule != null) {
                return cardStyleRule.intValue();
            }
        }
        return 0;
    }

    private final CoolapkCardView findCardView(View view) {
        CoolapkCardView coolapkCardView = null;
        if (view instanceof CoolapkCardView) {
            return (CoolapkCardView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return coolapkCardView;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() <= 0) {
            return coolapkCardView;
        }
        View childAt = viewGroup.getChildAt(0);
        return childAt instanceof CoolapkCardView ? (CoolapkCardView) childAt : coolapkCardView;
    }
}
