package com.coolapk.market.view.feedv8;

import android.content.Context;
import android.view.View;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Topic;
import com.coolapk.market.view.feedv8.TopicPickFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: TopicPickFragment.kt */
final class TopicPickFragment$TopicPickerViewHolder$bindToContent$2 implements View.OnLongClickListener {
    final /* synthetic */ Topic $data;
    final /* synthetic */ TopicPickFragment.TopicPickerViewHolder this$0;

    TopicPickFragment$TopicPickerViewHolder$bindToContent$2(TopicPickFragment.TopicPickerViewHolder topicPickerViewHolder, Topic topic) {
        this.this$0 = topicPickerViewHolder;
        this.$data = topic;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ActionManagerCompat.startActivityByUrl(context, this.$data.getUrl(), this.$data.getTitle(), this.$data.getSubTitle());
        return true;
    }
}
