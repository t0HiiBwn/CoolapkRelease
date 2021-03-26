package com.coolapk.market.view.main.channel;

import android.view.View;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemChannelTitleBinding;
import com.coolapk.market.util.Container;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/main/channel/ChannelTitleViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "container", "Lcom/coolapk/market/util/Container;", "itemView", "Landroid/view/View;", "(Lcom/coolapk/market/util/Container;Landroid/view/View;)V", "binding", "Lcom/coolapk/market/databinding/ItemChannelTitleBinding;", "kotlin.jvm.PlatformType", "channelManager", "Lcom/coolapk/market/view/main/channel/ChannelManagerFragment;", "getChannelManager", "()Lcom/coolapk/market/view/main/channel/ChannelManagerFragment;", "channelManager$delegate", "Lkotlin/Lazy;", "isEditMode", "", "()Z", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChannelTitleViewHolder.kt */
public final class ChannelTitleViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558653;
    private final ItemChannelTitleBinding binding;
    private final Lazy channelManager$delegate = LazyKt.lazy(new ChannelTitleViewHolder$channelManager$2(this));
    private final Container container;

    /* access modifiers changed from: private */
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/main/channel/ChannelTitleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ChannelTitleViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
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
