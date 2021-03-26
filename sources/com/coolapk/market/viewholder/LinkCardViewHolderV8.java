package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemLinkCardV8Binding;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.viewholder.TitleViewPart;
import com.coolapk.market.widget.CoolapkTagsView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0016B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\n\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/viewholder/LinkCardViewHolderV8;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemLinkCardV8Binding;", "Lcom/coolapk/market/model/EntityCard;", "Lcom/coolapk/market/widget/CoolapkTagsView$OnTagClickListener;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "card", "viewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "bindToContent", "", "data", "onClick", "onTagClick", "position", "", "keyword", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LinkCardViewHolderV8.kt */
public final class LinkCardViewHolderV8 extends GenericBindHolder<ItemLinkCardV8Binding, EntityCard> implements CoolapkTagsView.OnTagClickListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558809;
    private EntityCard card;
    private final TitleViewPart viewPart;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkCardViewHolderV8(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        CoolapkTagsView coolapkTagsView = ((ItemLinkCardV8Binding) getBinding()).keywordsView;
        Intrinsics.checkNotNullExpressionValue(coolapkTagsView, "binding.keywordsView");
        this.viewPart = companion.newInstance(coolapkTagsView, this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/LinkCardViewHolderV8$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LinkCardViewHolderV8.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(EntityCard entityCard) {
        Intrinsics.checkNotNullParameter(entityCard, "data");
        this.card = entityCard;
        ItemLinkCardV8Binding itemLinkCardV8Binding = (ItemLinkCardV8Binding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemLinkCardV8Binding, "binding");
        EntityCard entityCard2 = this.card;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        itemLinkCardV8Binding.setTitle(entityCard2.getTitle());
        ((ItemLinkCardV8Binding) getBinding()).executePendingBindings();
        TitleViewPart titleViewPart = this.viewPart;
        EntityCard entityCard3 = this.card;
        if (entityCard3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        titleViewPart.bindToContent(entityCard3);
        EntityCard entityCard4 = this.card;
        if (entityCard4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard4.getEntities();
        Intrinsics.checkNotNull(entities);
        Intrinsics.checkNotNullExpressionValue(entities, "card.entities!!");
        List<Entity> list = entities;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            String title = t.getTitle();
            if (title == null) {
                title = "";
            }
            arrayList.add(title);
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() <= 5) {
            HorizontalScrollView horizontalScrollView = ((ItemLinkCardV8Binding) getBinding()).scrollView;
            Intrinsics.checkNotNullExpressionValue(horizontalScrollView, "binding.scrollView");
            horizontalScrollView.setVisibility(8);
            CoolapkTagsView coolapkTagsView = ((ItemLinkCardV8Binding) getBinding()).keywordsView;
            Intrinsics.checkNotNullExpressionValue(coolapkTagsView, "binding.keywordsView");
            coolapkTagsView.setVisibility(0);
            ((ItemLinkCardV8Binding) getBinding()).keywordsView.setKeywords(arrayList2);
            ((ItemLinkCardV8Binding) getBinding()).keywordsView.setOnTagClickListener(this);
            return;
        }
        HorizontalScrollView horizontalScrollView2 = ((ItemLinkCardV8Binding) getBinding()).scrollView;
        Intrinsics.checkNotNullExpressionValue(horizontalScrollView2, "binding.scrollView");
        horizontalScrollView2.setVisibility(0);
        CoolapkTagsView coolapkTagsView2 = ((ItemLinkCardV8Binding) getBinding()).keywordsView;
        Intrinsics.checkNotNullExpressionValue(coolapkTagsView2, "binding.keywordsView");
        coolapkTagsView2.setVisibility(8);
        ((ItemLinkCardV8Binding) getBinding()).keywordsScrollView.setKeywords(arrayList2);
        ((ItemLinkCardV8Binding) getBinding()).keywordsScrollView.setOnTagClickListener(this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131362982) {
            super.onClick(view);
            return;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        String url = entityCard.getUrl();
        EntityCard entityCard2 = this.card;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        String title = entityCard2.getTitle();
        EntityCard entityCard3 = this.card;
        if (entityCard3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        ActionManagerCompat.startActivityByUrl(context, url, title, entityCard3.getSubTitle());
    }

    @Override // com.coolapk.market.widget.CoolapkTagsView.OnTagClickListener
    public void onTagClick(View view, int i, String str) {
        Entity entity;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(str, "keyword");
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard.getEntities();
        if (entities != null && (entity = entities.get(i)) != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ActionManagerCompat.startActivityByUrl(context, entity.getUrl(), entity.getTitle(), entity.getSubTitle());
            StatisticHelper instance = StatisticHelper.Companion.getInstance();
            DataBindingComponent component = getComponent();
            String str2 = null;
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (!(fragment instanceof BaseFragment)) {
                fragment = null;
            }
            BaseFragment baseFragment = (BaseFragment) fragment;
            if (baseFragment != null) {
                str2 = baseFragment.getFixedRecordId();
            }
            int adapterPosition = getAdapterPosition();
            EntityCard entityCard2 = this.card;
            if (entityCard2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            StatisticHelper.recordEntityEvent$default(instance, str2, entity, adapterPosition, entityCard2, null, 16, null);
        }
    }
}
