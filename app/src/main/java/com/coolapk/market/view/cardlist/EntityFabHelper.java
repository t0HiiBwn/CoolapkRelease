package com.coolapk.market.view.cardlist;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.widget.view.FabVerticalMenuLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0018H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityFabHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "entity", "Lcom/coolapk/market/model/EntityCard;", "fabMenuView", "Lcom/coolapk/market/widget/view/FabVerticalMenuLayout;", "getFabMenuView", "()Lcom/coolapk/market/widget/view/FabVerticalMenuLayout;", "setFabMenuView", "(Lcom/coolapk/market/widget/view/FabVerticalMenuLayout;)V", "getFragment", "()Lcom/coolapk/market/view/cardlist/EntityListFragment;", "modifyData", "", "Lcom/coolapk/market/model/Entity;", "list", "isRefresh", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onFabCardLoaded", "fabCard", "onSaveInstanceState", "outState", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityFabHelper.kt */
public final class EntityFabHelper extends EntityDataFilter {
    private EntityCard entity;
    private FabVerticalMenuLayout fabMenuView;
    private final EntityListFragment fragment;

    public EntityFabHelper(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
    }

    public final EntityListFragment getFragment() {
        return this.fragment;
    }

    protected final FabVerticalMenuLayout getFabMenuView() {
        return this.fabMenuView;
    }

    protected final void setFabMenuView(FabVerticalMenuLayout fabVerticalMenuLayout) {
        this.fabMenuView = fabVerticalMenuLayout;
    }

    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            EntityCard entityCard = (EntityCard) bundle.getParcelable("EntityFabHelperData");
            this.entity = entityCard;
            if (entityCard != null) {
                onFabCardLoaded(entityCard);
            }
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("EntityFabHelperData", this.entity);
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
            if (Intrinsics.areEqual(((Entity) obj).getEntityTemplate(), "fabCard")) {
                break;
            }
        }
        if (obj == null) {
            return list;
        }
        Entity entity2 = (Entity) obj;
        Objects.requireNonNull(entity2, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        EntityCard entityCard = (EntityCard) entity2;
        this.entity = entityCard;
        onFabCardLoaded(entityCard);
        return removeData$presentation_coolapkAppRelease(list, entity2);
    }

    private final void onFabCardLoaded(EntityCard entityCard) {
        View view = this.fragment.getView();
        String str = null;
        if (!(view instanceof ViewGroup)) {
            view = null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup != null) {
            Context context = viewGroup.getContext();
            FabVerticalMenuLayout fabVerticalMenuLayout = this.fabMenuView;
            if (fabVerticalMenuLayout != null) {
                viewGroup.removeView(fabVerticalMenuLayout);
            }
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FabVerticalMenuLayout fabVerticalMenuLayout2 = new FabVerticalMenuLayout(context);
            List<Entity> entities = entityCard.getEntities();
            if (entities == null || entities.isEmpty()) {
                JSONObject jsonExtraData = EntityExtendsKt.getJsonExtraData(entityCard);
                if (jsonExtraData != null) {
                    str = jsonExtraData.optString("backgroundColor", null);
                }
                String pic = entityCard.getPic();
                Intrinsics.checkNotNull(pic);
                Intrinsics.checkNotNullExpressionValue(pic, "fabCard.pic!!");
                fabVerticalMenuLayout2.setFabInfo(pic, str, new EntityFabHelper$onFabCardLoaded$3(context, entityCard));
            } else {
                JSONObject jsonExtraData2 = EntityExtendsKt.getJsonExtraData(entityCard);
                String optString = jsonExtraData2 != null ? jsonExtraData2.optString("backgroundColor", null) : null;
                String pic2 = entityCard.getPic();
                Intrinsics.checkNotNull(pic2);
                Intrinsics.checkNotNullExpressionValue(pic2, "fabCard.pic!!");
                FabVerticalMenuLayout.setFabInfo$default(fabVerticalMenuLayout2, pic2, optString, (View.OnClickListener) null, 4, (Object) null);
                fabVerticalMenuLayout2.setFabLongClickListener(new EntityFabHelper$onFabCardLoaded$1(context, entityCard));
                for (Entity entity2 : entities) {
                    Intrinsics.checkNotNullExpressionValue(entity2, "entity");
                    JSONObject jsonExtraData3 = EntityExtendsKt.getJsonExtraData(entity2);
                    String optString2 = jsonExtraData3 != null ? jsonExtraData3.optString("backgroundColor", null) : null;
                    String pic3 = entity2.getPic();
                    Intrinsics.checkNotNull(pic3);
                    Intrinsics.checkNotNullExpressionValue(pic3, "entity.pic!!");
                    String title = entity2.getTitle();
                    Intrinsics.checkNotNull(title);
                    Intrinsics.checkNotNullExpressionValue(title, "entity.title!!");
                    fabVerticalMenuLayout2.addSubFabInfo(pic3, optString2, title, new EntityFabHelper$onFabCardLoaded$2(context, entity2));
                }
            }
            JSONObject jsonExtraData4 = EntityExtendsKt.getJsonExtraData(entityCard);
            fabVerticalMenuLayout2.setCardMarginBottomPx(NumberExtendsKt.getDp(Integer.valueOf(jsonExtraData4 != null ? jsonExtraData4.optInt("cardMarginBottom") : 0)));
            viewGroup.addView(fabVerticalMenuLayout2, new FrameLayout.LayoutParams(-1, -1));
            this.fabMenuView = fabVerticalMenuLayout2;
        }
    }
}
