package com.coolapk.market.view.center;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.RxUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u000120\u0010\u0005\u001a,\u0012\u0004\u0012\u00020\u0003 \u0004*\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "it", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterV9Fragment.kt */
final class CenterV9Fragment$onCreateRequest$5<T, R> implements Func1<ArrayList<Entity>, Observable<? extends List<? extends Entity>>> {
    public static final CenterV9Fragment$onCreateRequest$5 INSTANCE = new CenterV9Fragment$onCreateRequest$5();

    CenterV9Fragment$onCreateRequest$5() {
    }

    public final Observable<? extends List<Entity>> call(final ArrayList<Entity> arrayList) {
        return DataManager.getInstance().loadCardConfig("my_page_card_config").compose(RxUtils.apiCommonToData()).flatMap(new Func1<List<Entity>, Observable<? extends ArrayList<Entity>>>() {
            /* class com.coolapk.market.view.center.CenterV9Fragment$onCreateRequest$5.AnonymousClass1 */

            public final Observable<? extends ArrayList<Entity>> call(List<Entity> list) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(arrayList);
                if (list.isEmpty()) {
                    arrayList.add(HolderItem.newBuilder().entityType("entity_type_user_no_card").build());
                } else {
                    arrayList.addAll(list);
                    Entity entity = list.get(list.size() - 1);
                    Intrinsics.checkNotNullExpressionValue(entity, "lastItem");
                    if (EntityExtendsKt.getIntExtraData(entity, "position", 0) == -1) {
                        arrayList.add(HolderItem.newBuilder().entityType("entity_type_user_no_card").build());
                    }
                }
                return Observable.just(arrayList);
            }
        });
    }
}
