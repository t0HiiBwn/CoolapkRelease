package com.coolapk.market.view.node.rating;

import android.os.Parcelable;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.UserInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Landroid/os/Parcelable;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserNodeRatingListFragment.kt */
final class UserNodeRatingListFragment$onNodeRatingDeleteEvent$1 extends Lambda implements Function1<List<Parcelable>, Unit> {
    final /* synthetic */ NodeRatingDeleteEvent $event;
    final /* synthetic */ UserNodeRatingListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserNodeRatingListFragment$onNodeRatingDeleteEvent$1(UserNodeRatingListFragment userNodeRatingListFragment, NodeRatingDeleteEvent nodeRatingDeleteEvent) {
        super(1);
        this.this$0 = userNodeRatingListFragment;
        this.$event = nodeRatingDeleteEvent;
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
            /* class com.coolapk.market.view.node.rating.UserNodeRatingListFragment$onNodeRatingDeleteEvent$1.AnonymousClass1 */
            final /* synthetic */ UserNodeRatingListFragment$onNodeRatingDeleteEvent$1 this$0;

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
                if (parcelable instanceof NodeRating) {
                    NodeRating nodeRating = (NodeRating) parcelable;
                    UserInfo userInfo = nodeRating.getUserInfo();
                    if (Intrinsics.areEqual(userInfo != null ? userInfo.getUid() : null, this.this$0.$event.getUid()) && Intrinsics.areEqual(nodeRating.getTargetType(), this.this$0.$event.getTargetType()) && Intrinsics.areEqual(nodeRating.getTargetId(), this.this$0.$event.getTargetId())) {
                        return true;
                    }
                }
                return false;
            }
        });
        Iterator<Parcelable> it2 = this.this$0.getDataList().iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            } else if (it2.next() instanceof NodeRating) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            this.this$0.addFullHintView("还没有评分哦", null);
        }
    }
}
