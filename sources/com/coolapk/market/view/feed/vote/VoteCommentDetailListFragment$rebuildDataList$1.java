package com.coolapk.market.view.feed.vote;

import android.os.Parcelable;
import com.coolapk.market.model.HolderItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Landroid/os/Parcelable;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteCommentDetailListFragment.kt */
final class VoteCommentDetailListFragment$rebuildDataList$1 extends Lambda implements Function1<List<Parcelable>, Unit> {
    final /* synthetic */ VoteCommentDetailListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VoteCommentDetailListFragment$rebuildDataList$1(VoteCommentDetailListFragment voteCommentDetailListFragment) {
        super(1);
        this.this$0 = voteCommentDetailListFragment;
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
        VoteCommentDetailListFragment voteCommentDetailListFragment = this.this$0;
        List list2 = voteCommentDetailListFragment.filterDataListByOptionId(voteCommentDetailListFragment.getPkOptionId()[0]);
        VoteCommentDetailListFragment voteCommentDetailListFragment2 = this.this$0;
        List list3 = voteCommentDetailListFragment2.filterDataListByOptionId(voteCommentDetailListFragment2.getPkOptionId()[1]);
        if (!list2.isEmpty() || !list3.isEmpty()) {
            if (list2.isEmpty()) {
                list2 = CollectionsKt.mutableListOf(HolderItem.newBuilder().entityType("entity_no_comment_exist").intValue(Integer.valueOf(this.this$0.getConfig().getPkOptionColor()[0])).title("还没有正方观点").build());
            }
            if (list3.isEmpty()) {
                list3 = CollectionsKt.mutableListOf(HolderItem.newBuilder().entityType("entity_no_comment_exist").intValue(Integer.valueOf(this.this$0.getConfig().getPkOptionColor()[1])).title("还没有反方观点").build());
            }
            ArrayList arrayList = new ArrayList();
            HolderItem build = HolderItem.newBuilder().entityType("entity_title").build();
            Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().…NTITY_TYPE_TITLE).build()");
            arrayList.add(build);
            int max = Math.max(list2.size(), list3.size());
            for (int i = 0; i < max; i++) {
                if (i < list2.size()) {
                    arrayList.add(list2.get(i));
                }
                if (i < list3.size()) {
                    arrayList.add(list3.get(i));
                }
            }
            this.this$0.getDataList().clear();
            this.this$0.getDataList().addAll(arrayList);
        }
    }
}
