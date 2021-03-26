package com.coolapk.market.view.node.topic;

import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Topic;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.node.NodeActivityBehavior;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: TopicNodeFragment.kt */
final class TopicNodeFragment$installTopicContent$2 implements Runnable {
    final /* synthetic */ NodeActivityBehavior $behavior;
    final /* synthetic */ Topic $model;
    final /* synthetic */ int $selectedPageIndex;
    final /* synthetic */ TopicNodeFragment this$0;

    TopicNodeFragment$installTopicContent$2(TopicNodeFragment topicNodeFragment, NodeActivityBehavior nodeActivityBehavior, Topic topic, int i) {
        this.this$0 = topicNodeFragment;
        this.$behavior = nodeActivityBehavior;
        this.$model = topic;
        this.$selectedPageIndex = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NodeActivityBehavior nodeActivityBehavior = this.$behavior;
        List<ConfigPage> tabApiList = this.$model.getTabApiList();
        Intrinsics.checkNotNullExpressionValue(tabApiList, "model.tabApiList");
        nodeActivityBehavior.installFloatingView(tabApiList, this.$selectedPageIndex, new Function1<ConfigPage, EntityListFragment>(this) {
            /* class com.coolapk.market.view.node.topic.TopicNodeFragment$installTopicContent$2.AnonymousClass1 */
            final /* synthetic */ TopicNodeFragment$installTopicContent$2 this$0;

            {
                this.this$0 = r1;
            }

            public final EntityListFragment invoke(ConfigPage configPage) {
                Intrinsics.checkNotNullParameter(configPage, "it");
                TopicNodeDataListFragment newInstance = TopicNodeDataListFragment.Companion.newInstance(configPage);
                newInstance.setViewModel$presentation_coolapkAppRelease(this.this$0.this$0.getViewModel());
                newInstance.setPresenter$presentation_coolapkAppRelease(this.this$0.this$0.getPresenter());
                return newInstance;
            }
        }, null);
    }
}
