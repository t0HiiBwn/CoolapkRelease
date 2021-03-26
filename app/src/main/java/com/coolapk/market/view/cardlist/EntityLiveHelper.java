package com.coolapk.market.view.cardlist;

import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Live;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/cardlist/EntityLiveHelper;", "Lcom/coolapk/market/view/cardlist/EntityDataFilter;", "()V", "placeholder", "", "getPlaceholder", "()Ljava/lang/String;", "placeholder$delegate", "Lkotlin/Lazy;", "compareAndUpdate", "Lkotlin/Pair;", "Lcom/coolapk/market/model/Live;", "first", "second", "modifyData", "", "Lcom/coolapk/market/model/Entity;", "list", "isRefresh", "", "supplement", "title", "maxLength", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityLiveHelper.kt */
public final class EntityLiveHelper extends EntityDataFilter {
    private final Lazy placeholder$delegate = LazyKt.lazy(EntityLiveHelper$placeholder$2.INSTANCE);

    private final String getPlaceholder() {
        return (String) this.placeholder$delegate.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.cardlist.EntityDataFilter
    public List<Entity> modifyData(List<? extends Entity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList<Entity> arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((Entity) obj).getEntityTemplate(), "liveListCard")) {
                arrayList.add(obj);
            }
        }
        for (Entity entity : arrayList) {
            Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
            List<Entity> entities = ((EntityCard) entity).getEntities();
            Intrinsics.checkNotNull(entities);
            Intrinsics.checkNotNullExpressionValue(entities, "card.entities!!");
            if (entities.size() > 1) {
                IntProgression step = RangesKt.step(RangesKt.until(0, entities.size()), 2);
                int first = step.getFirst();
                int last = step.getLast();
                int step2 = step.getStep();
                if (step2 >= 0) {
                    if (first > last) {
                    }
                } else if (first < last) {
                }
                while (first != CollectionsKt.getLastIndex(entities)) {
                    Entity entity2 = entities.get(first);
                    int i = first + 1;
                    Entity entity3 = entities.get(i);
                    Objects.requireNonNull(entity2, "null cannot be cast to non-null type com.coolapk.market.model.Live");
                    Objects.requireNonNull(entity3, "null cannot be cast to non-null type com.coolapk.market.model.Live");
                    Pair<Live, Live> compareAndUpdate = compareAndUpdate((Live) entity2, (Live) entity3);
                    Live first2 = compareAndUpdate.getFirst();
                    if (first2 != null) {
                        entities.set(first, first2);
                    }
                    Live second = compareAndUpdate.getSecond();
                    if (second != null) {
                        entities.set(i, second);
                    }
                    if (first == last) {
                        break;
                    }
                    first += step2;
                }
            }
        }
        return list;
    }

    private final Pair<Live, Live> compareAndUpdate(Live live, Live live2) {
        String title = live.getTitle();
        Intrinsics.checkNotNull(title);
        Intrinsics.checkNotNullExpressionValue(title, "first.title!!");
        String title2 = live2.getTitle();
        Intrinsics.checkNotNull(title2);
        Intrinsics.checkNotNullExpressionValue(title2, "second.title!!");
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull(title, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = title.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        int length = bytes.length;
        Charset charset2 = Charsets.UTF_8;
        Objects.requireNonNull(title2, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes2 = title2.getBytes(charset2);
        Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
        int max = Math.max(length, bytes2.length);
        String supplement = supplement(title, max);
        Live live3 = null;
        Live build = supplement != null ? Live.builder(live).setTitle(supplement).build() : null;
        String supplement2 = supplement(title2, max);
        if (supplement2 != null) {
            live3 = Live.builder(live2).setTitle(supplement2).build();
        }
        return new Pair<>(build, live3);
    }

    private final String supplement(String str, int i) {
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        int length = bytes.length;
        if (length >= i) {
            return null;
        }
        int i2 = i - length;
        if (i2 <= 2) {
            return str + getPlaceholder();
        }
        return str + StringsKt.repeat(" ", i2 - 2) + getPlaceholder();
    }
}
