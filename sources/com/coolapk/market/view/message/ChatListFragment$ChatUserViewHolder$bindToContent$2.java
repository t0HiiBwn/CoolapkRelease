package com.coolapk.market.view.message;

import android.content.Context;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.databinding.ItemChatingUserBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.model.Message;
import com.coolapk.market.view.message.ChatListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
final class ChatListFragment$ChatUserViewHolder$bindToContent$2 implements View.OnLongClickListener {
    final /* synthetic */ Message $message;
    final /* synthetic */ ChatListFragment.ChatUserViewHolder this$0;

    ChatListFragment$ChatUserViewHolder$bindToContent$2(ChatListFragment.ChatUserViewHolder chatUserViewHolder, Message message) {
        this.this$0 = chatUserViewHolder;
        this.$message = message;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        ChattingItemDialog chattingItemDialog = new ChattingItemDialog();
        chattingItemDialog.setMessage(this.$message);
        TextView textView = ((ItemChatingUserBinding) this.this$0.getBinding()).textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        URLSpan[] urls = textView.getUrls();
        Intrinsics.checkNotNullExpressionValue(urls, "binding.textView.urls");
        chattingItemDialog.setSpans(urls);
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
        chattingItemDialog.show(supportFragmentManager, (String) null);
        return true;
    }
}
