package com.coolapk.market.view.feedv8;

import android.app.Application;
import com.coolapk.market.AppHolder;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.HolderItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "entities", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: TopicPickFragment.kt */
final class TopicPickFragment$onCreateRequest$1<T, R> implements Func1<List<Entity>, Observable<? extends List<? extends Entity>>> {
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ int $page;
    final /* synthetic */ TopicPickFragment this$0;

    TopicPickFragment$onCreateRequest$1(TopicPickFragment topicPickFragment, boolean z, int i) {
        this.this$0 = topicPickFragment;
        this.$isRefresh = z;
        this.$page = i;
    }

    public final Observable<? extends List<Entity>> call(List<Entity> list) {
        T t;
        T t2;
        List<Entity> entities;
        boolean z = false;
        if ((this.this$0.currentKey.length() == 0) && list != null && this.$isRefresh && this.$page == 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(HolderItem.newBuilder().entityType("HOLDER_TYPE_ALERT").entityId("-3").build());
            Application application = AppHolder.getApplication();
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = null;
                    break;
                }
                t = it2.next();
                if (t instanceof EntityCard) {
                    break;
                }
            }
            T t3 = t;
            if ((t3 instanceof EntityCard) && (entities = (t2 = t3).getEntities()) != null) {
                List<Entity> list2 = entities;
                if (list2 == null || list2.isEmpty()) {
                    z = true;
                }
                if (!z) {
                    arrayList.add(HolderItem.newBuilder().entityType("HOLDER_TYPE_DELETE_RECENT").entityId("-1").string("最近参与").value(application.getString(2131886834)).build());
                    list.remove(t3);
                    List<Entity> entities2 = t2.getEntities();
                    Intrinsics.checkNotNull(entities2);
                    arrayList.addAll(entities2);
                }
            }
            arrayList.add(HolderItem.newBuilder().entityType("holder_title").entityId("-2").string("热门话题").build());
            arrayList.addAll(list);
            list = arrayList;
        }
        return Observable.just(list);
    }
}
