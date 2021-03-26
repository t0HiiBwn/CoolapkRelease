package com.coolapk.market.view.cardlist;

import android.os.Parcelable;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "oldEntity", "Landroid/os/Parcelable;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityRemoveHelper.kt */
final class EntityRemoveHelper$modifyData$1 extends Lambda implements Function1<Parcelable, Boolean> {
    final /* synthetic */ ArrayList $containRemoveDataSet;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityRemoveHelper$modifyData$1(ArrayList arrayList) {
        super(1);
        this.$containRemoveDataSet = arrayList;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Parcelable parcelable) {
        return Boolean.valueOf(invoke(parcelable));
    }

    public final boolean invoke(Parcelable parcelable) {
        Object obj;
        Intrinsics.checkNotNullParameter(parcelable, "oldEntity");
        if (!(parcelable instanceof Entity)) {
            return false;
        }
        Iterator it2 = this.$containRemoveDataSet.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (Intrinsics.areEqual((String) obj, EntityExtendsKt.entityUniqueId((Entity) parcelable))) {
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }
}
