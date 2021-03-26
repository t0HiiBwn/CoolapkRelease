package com.coolapk.market.view.center;

import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "l", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: MyCardListFragment.kt */
final class MyCardListFragment$onCreateRequest$1<T, R> implements Func1<List<Entity>, Observable<? extends List<? extends Entity>>> {
    public static final MyCardListFragment$onCreateRequest$1 INSTANCE = new MyCardListFragment$onCreateRequest$1();

    MyCardListFragment$onCreateRequest$1() {
    }

    public final Observable<? extends List<Entity>> call(List<Entity> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            arrayList.add(HolderItem.newBuilder().entityType("entity_type_user_no_card").entityFixed(1).build());
        } else {
            arrayList.add(HolderItem.newBuilder().entityType("entity_type_user_card_manager").entityFixed(1).build());
            arrayList.addAll(list);
            arrayList.add(HolderItem.newBuilder().entityType("entity_type_user_card_add").build());
        }
        return Observable.just(arrayList);
    }
}
