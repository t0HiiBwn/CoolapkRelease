package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.databinding.ItemTopicViewBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Topic;
import com.coolapk.market.view.feed.CancelFollowItemDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: TopicViewHolder.kt */
final class TopicViewHolder$bindToContent$1 implements View.OnLongClickListener {
    final /* synthetic */ Topic $data;
    final /* synthetic */ TopicViewHolder this$0;

    TopicViewHolder$bindToContent$1(TopicViewHolder topicViewHolder, Topic topic) {
        this.this$0 = topicViewHolder;
        this.$data = topic;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (!(EntityExtendsKt.getIntExtraData(this.$data, "showCancelFollowMenu", 0) == 1)) {
            return false;
        }
        CancelFollowItemDialog.Companion companion = CancelFollowItemDialog.Companion;
        ItemTopicViewBinding itemTopicViewBinding = (ItemTopicViewBinding) this.this$0.getBinding();
        Intrinsics.checkNotNullExpressionValue(itemTopicViewBinding, "binding");
        Entity model = itemTopicViewBinding.getModel();
        Intrinsics.checkNotNull(model);
        Intrinsics.checkNotNullExpressionValue(model, "binding.model!!");
        CancelFollowItemDialog newInstance = companion.newInstance(model);
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        return true;
    }
}
