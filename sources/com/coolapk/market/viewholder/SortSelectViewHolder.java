package com.coolapk.market.viewholder;

import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemSortSelectBinding;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import com.coolapk.market.view.cardlist.EntityRequestArgHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/viewholder/SortSelectViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemSortSelectBinding;", "Lcom/coolapk/market/model/EntityCard;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "entityRequestArgHelper", "Lcom/coolapk/market/view/cardlist/EntityRequestArgHelper;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityRequestArgHelper;)V", "data", "getEntityRequestArgHelper", "()Lcom/coolapk/market/view/cardlist/EntityRequestArgHelper;", "bindToContent", "", "onClick", "view", "onItemClick", "entity", "Lcom/coolapk/market/model/Entity;", "showMoreOptionMenu", "anchor", "updateSelectedUrl", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SortSelectViewHolder.kt */
public final class SortSelectViewHolder extends GenericBindHolder<ItemSortSelectBinding, EntityCard> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558943;
    private EntityCard data;
    private final EntityRequestArgHelper entityRequestArgHelper;

    public final EntityRequestArgHelper getEntityRequestArgHelper() {
        return this.entityRequestArgHelper;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SortSelectViewHolder(View view, DataBindingComponent dataBindingComponent, EntityRequestArgHelper entityRequestArgHelper2) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(entityRequestArgHelper2, "entityRequestArgHelper");
        this.entityRequestArgHelper = entityRequestArgHelper2;
        ((ItemSortSelectBinding) getBinding()).selectView.setOnClickListener(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/SortSelectViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SortSelectViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(EntityCard entityCard) {
        Intrinsics.checkNotNullParameter(entityCard, "data");
        this.data = entityCard;
        TextView textView = ((ItemSortSelectBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(entityCard.getTitle());
        updateSelectedUrl();
        ((ItemSortSelectBinding) getBinding()).executePendingBindings();
    }

    private final void updateSelectedUrl() {
        List<Entity> entities;
        Entity requestArg = this.entityRequestArgHelper.getRequestArg();
        T t = null;
        String url = requestArg != null ? requestArg.getUrl() : null;
        EntityCard entityCard = this.data;
        if (entityCard != null && (entities = entityCard.getEntities()) != null) {
            Intrinsics.checkNotNullExpressionValue(entities, "data?.entities ?: return");
            Iterator<T> it2 = entities.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                T next = it2.next();
                T t2 = next;
                Intrinsics.checkNotNullExpressionValue(t2, "it");
                if (Intrinsics.areEqual(t2.getUrl(), url)) {
                    t = next;
                    break;
                }
            }
            T t3 = t;
            if (t3 == null) {
                t3 = (Entity) CollectionsKt.first((List<? extends Object>) entities);
            }
            TextView textView = ((ItemSortSelectBinding) getBinding()).selectTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.selectTextView");
            Intrinsics.checkNotNullExpressionValue(t3, "selected");
            textView.setText(t3.getTitle());
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == 2131363354) {
            showMoreOptionMenu(view);
        }
    }

    private final void showMoreOptionMenu(View view) {
        List<Entity> entities;
        EntityCard entityCard = this.data;
        if (!(entityCard == null || (entities = entityCard.getEntities()) == null)) {
            Intrinsics.checkNotNullExpressionValue(entities, "data?.entities ?: return");
            BasePopMenu basePopMenu = new BasePopMenu(AppHolder.getCurrentActivity(), view);
            int i = 0;
            for (T t : entities) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                Menu menu = basePopMenu.getMenu();
                Intrinsics.checkNotNullExpressionValue(t2, "entity");
                menu.add(0, i, 0, t2.getTitle());
                i = i2;
            }
            basePopMenu.setOnMenuItemClickListener(new SortSelectViewHolder$showMoreOptionMenu$2(this, entities));
            basePopMenu.show();
        }
    }

    /* access modifiers changed from: private */
    public final void onItemClick(Entity entity) {
        this.entityRequestArgHelper.setRequestArg(entity);
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        DataBindingComponent component = getComponent();
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (!(fragment instanceof BaseFragment)) {
            fragment = null;
        }
        BaseFragment baseFragment = (BaseFragment) fragment;
        StatisticHelper.recordEntityEvent$default(instance, baseFragment != null ? baseFragment.getFixedRecordId() : null, entity, getAdapterPosition(), null, null, 16, null);
        updateSelectedUrl();
        String url = entity.getUrl();
        if (url == null) {
            url = "";
        }
        if (StringsKt.contains$default((CharSequence) url, (CharSequence) "topic", false, 2, (Object) null)) {
            StatisticHelper.Companion.getInstance().recordTopicAction("点击切换排序");
        }
    }
}
