package com.coolapk.market.view.cardlist;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.view.base.SimpleDialog;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityDialogHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "getFragment", "()Lcom/coolapk/market/view/cardlist/EntityListFragment;", "modifyData", "", "Lcom/coolapk/market/model/Entity;", "list", "isRefresh", "", "onDialogCardLoaded", "", "dialogCard", "Lcom/coolapk/market/model/EntityCard;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityDialogHelper.kt */
public final class EntityDialogHelper extends EntityDataFilter {
    private final EntityListFragment fragment;

    public EntityDialogHelper(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
    }

    public final EntityListFragment getFragment() {
        return this.fragment;
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
            if (Intrinsics.areEqual(((Entity) obj).getEntityTemplate(), "dialogCard")) {
                break;
            }
        }
        if (obj == null) {
            return list;
        }
        Entity entity = (Entity) obj;
        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        onDialogCardLoaded((EntityCard) entity);
        return removeData$presentation_coolapkAppRelease(list, entity);
    }

    private final void onDialogCardLoaded(EntityCard entityCard) {
        String str = "DIALOG_CARD_ID_" + EntityExtendsKt.entityUniqueId(entityCard);
        if (DataManager.getInstance().getPreferencesBoolean(str, true)) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            int i = 0;
            instance.getPreferencesEditor().putBoolean(str, false).apply();
            String title = entityCard.getTitle();
            String description = entityCard.getDescription();
            String url = entityCard.getUrl();
            SimpleDialog newInstance = SimpleDialog.newInstance();
            newInstance.setTitle(title);
            newInstance.setMessage(description);
            newInstance.setNegativeButton(2131886115);
            FragmentActivity requireActivity = this.fragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
            if (CollectionUtils.isNotEmpty(entityCard.getEntities())) {
                List<Entity> entities = entityCard.getEntities();
                Intrinsics.checkNotNull(entities);
                Intrinsics.checkNotNullExpressionValue(entities, "dialogCard.entities!!");
                for (T t : entities) {
                    Intrinsics.checkNotNullExpressionValue(t, "entity");
                    String title2 = t.getTitle();
                    String url2 = t.getUrl();
                    if (i == 0) {
                        newInstance.setPositiveButton(title2, new EntityDialogHelper$onDialogCardLoaded$1(requireActivity, url2));
                    } else if (i == 1) {
                        newInstance.setNeutralButton(title2, new EntityDialogHelper$onDialogCardLoaded$2(requireActivity, url2));
                    }
                    i++;
                }
            } else {
                newInstance.setPositiveButton(2131886118, new EntityDialogHelper$onDialogCardLoaded$3(requireActivity, url));
            }
            FragmentManager childFragmentManager = this.fragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
        }
    }
}
