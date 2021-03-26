package com.coolapk.market.view.main.channel;

import android.view.View;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemChannelTitleBinding;
import com.coolapk.market.util.Container;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChannelTitleViewHolder.kt */
public final class ChannelTitleViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558647;
    private final ItemChannelTitleBinding binding;
    private final Lazy channelManager$delegate = LazyKt.lazy(new ChannelTitleViewHolder$channelManager$2(this));
    private final Container container;

    public final ChannelManagerFragment getChannelManager() {
        return (ChannelManagerFragment) this.channelManager$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelTitleViewHolder(Container container2, View view) {
        super(view);
        Intrinsics.checkNotNullParameter(container2, "container");
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.container = container2;
        ItemChannelTitleBinding itemChannelTitleBinding = (ItemChannelTitleBinding) getBinding();
        this.binding = itemChannelTitleBinding;
        itemChannelTitleBinding.actionView.setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.view.main.channel.ChannelTitleViewHolder.AnonymousClass1 */
            final /* synthetic */ ChannelTitleViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getChannelManager().setEditMode(!this.this$0.isEditMode());
                if (!this.this$0.isEditMode()) {
                    this.this$0.getChannelManager().updateUserConfig();
                }
            }
        });
    }

    /* compiled from: ChannelTitleViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean isEditMode() {
        return getChannelManager().isEditMode();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.main.channel.ChannelTitle");
        int type = ((ChannelTitle) obj).getType();
        if (type == 0) {
            TextView textView = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText("我的频道");
            TextView textView2 = this.binding.subtitleView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.subtitleView");
            textView2.setText(isEditMode() ? "长按调整顺序" : "点击进入频道");
            TextView textView3 = this.binding.actionView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.actionView");
            textView3.setVisibility(0);
            TextView textView4 = this.binding.actionView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.actionView");
            textView4.setText(isEditMode() ? "完成" : "编辑");
        } else if (type == 1) {
            TextView textView5 = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.titleView");
            textView5.setText("更多频道");
            TextView textView6 = this.binding.subtitleView;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.subtitleView");
            textView6.setText(getChannelManager().getViewModel().isOtherChannelEmpty() ? "暂无更多" : "点击添加新频道");
            TextView textView7 = this.binding.actionView;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.actionView");
            textView7.setVisibility(8);
        }
        this.binding.executePendingBindings();
    }
}
