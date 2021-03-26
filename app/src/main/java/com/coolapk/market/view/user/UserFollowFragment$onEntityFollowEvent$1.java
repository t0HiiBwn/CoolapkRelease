package com.coolapk.market.view.user;

import android.os.Parcelable;
import com.coolapk.market.model.Entity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Landroid/os/Parcelable;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserFollowAppForumFragment.kt */
final class UserFollowFragment$onEntityFollowEvent$1 extends Lambda implements Function1<List<Parcelable>, Unit> {
    final /* synthetic */ EntityFollowEvent $event;
    final /* synthetic */ UserFollowFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserFollowFragment$onEntityFollowEvent$1(UserFollowFragment userFollowFragment, EntityFollowEvent entityFollowEvent) {
        super(1);
        this.this$0 = userFollowFragment;
        this.$event = entityFollowEvent;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<Parcelable> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<Parcelable> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        CollectionsKt.removeAll((List) this.this$0.getDataList(), (Function1) new Function1<Parcelable, Boolean>(this) {
            /* class com.coolapk.market.view.user.UserFollowFragment$onEntityFollowEvent$1.AnonymousClass1 */
            final /* synthetic */ UserFollowFragment$onEntityFollowEvent$1 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Parcelable parcelable) {
                return Boolean.valueOf(invoke(parcelable));
            }

            public final boolean invoke(Parcelable parcelable) {
                Intrinsics.checkNotNullParameter(parcelable, "it");
                if (parcelable instanceof Entity) {
                    Entity entity = (Entity) parcelable;
                    if (Intrinsics.areEqual(entity.getEntityType(), this.this$0.$event.getEntityType()) && Intrinsics.areEqual(entity.getId(), this.this$0.$event.getId())) {
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
