package com.coolapk.market.view.node.topic;

import android.os.Parcelable;
import com.coolapk.market.model.ConfigPage;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/ConfigPage;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: TopicNodeDataListFragment.kt */
final class TopicNodeDataListFragment$configPage$2 extends Lambda implements Function0<ConfigPage> {
    final /* synthetic */ TopicNodeDataListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopicNodeDataListFragment$configPage$2(TopicNodeDataListFragment topicNodeDataListFragment) {
        super(0);
        this.this$0 = topicNodeDataListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ConfigPage invoke() {
        Parcelable parcelable = this.this$0.requireArguments().getParcelable("EXTRA_CONFIG_PAGE");
        Intrinsics.checkNotNull(parcelable);
        return (ConfigPage) parcelable;
    }
}
