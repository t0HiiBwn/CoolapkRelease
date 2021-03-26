package com.coolapk.market.view.main.channel;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemChannelTabBinding;
import com.coolapk.market.event.ChannelTabEvent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.Container;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001b¨\u0006&"}, d2 = {"Lcom/coolapk/market/view/main/channel/ChannelTabViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "Lcom/coolapk/market/view/main/channel/ItemTouchHelperViewHolder;", "container", "Lcom/coolapk/market/util/Container;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Lcom/coolapk/market/util/Container;Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemChannelTabBinding;", "kotlin.jvm.PlatformType", "channel", "Lcom/coolapk/market/view/main/channel/Channel;", "getChannel", "()Lcom/coolapk/market/view/main/channel/Channel;", "setChannel", "(Lcom/coolapk/market/view/main/channel/Channel;)V", "channelManager", "Lcom/coolapk/market/view/main/channel/ChannelManagerFragment;", "getChannelManager", "()Lcom/coolapk/market/view/main/channel/ChannelManagerFragment;", "channelManager$delegate", "Lkotlin/Lazy;", "isEditMode", "", "()Z", "bindTo", "", "data", "", "onClick", "view", "onItemClear", "onItemSelected", "onLongClick", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChannelTabViewHolder.kt */
public final class ChannelTabViewHolder extends BindingViewHolder implements ItemTouchHelperViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558652;
    private final ItemChannelTabBinding binding = ((ItemChannelTabBinding) getBinding());
    public Channel channel;
    private final Lazy channelManager$delegate = LazyKt.lazy(new ChannelTabViewHolder$channelManager$2(this));
    private final Container container;

    /* access modifiers changed from: private */
    public final ChannelManagerFragment getChannelManager() {
        return (ChannelManagerFragment) this.channelManager$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelTabViewHolder(Container container2, View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(container2, "container");
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.container = container2;
        ViewUtil.clickListener(view, this);
        view.setOnLongClickListener(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/main/channel/ChannelTabViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ChannelTabViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final boolean isEditMode() {
        return getChannelManager().isEditMode();
    }

    public final Channel getChannel() {
        Channel channel2 = this.channel;
        if (channel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
        }
        return channel2;
    }

    public final void setChannel(Channel channel2) {
        Intrinsics.checkNotNullParameter(channel2, "<set-?>");
        this.channel = channel2;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.main.channel.Channel");
        Channel channel2 = (Channel) obj;
        this.channel = channel2;
        TextView textView = this.binding.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setText(channel2.getTitle());
        ItemChannelTabBinding itemChannelTabBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemChannelTabBinding, "binding");
        itemChannelTabBinding.setLogoUrl(channel2.getLogo());
        this.binding.executePendingBindings();
        if (!isEditMode() || !channel2.isFixed()) {
            this.binding.imageView.clearColorFilter();
            this.binding.textView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
        } else {
            this.binding.imageView.setColorFilter(AppHolder.getAppTheme().getTextColorTertiary(), PorterDuff.Mode.SRC_IN);
            this.binding.textView.setTextColor(AppHolder.getAppTheme().getTextColorTertiary());
        }
        int i = 0;
        if (channel2.getVisible()) {
            ImageView imageView = this.binding.deleteView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.deleteView");
            if (!isEditMode() || channel2.isFixed()) {
                i = 8;
            }
            imageView.setVisibility(i);
            ImageView imageView2 = this.binding.addView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.addView");
            imageView2.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.binding.addView;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.addView");
        if (!isEditMode() || channel2.isFixed()) {
            i = 8;
        }
        imageView3.setVisibility(i);
        ImageView imageView4 = this.binding.deleteView;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.deleteView");
        imageView4.setVisibility(8);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131362779) {
            super.onClick(view);
            return;
        }
        Channel channel2 = this.channel;
        if (channel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
        }
        if (!channel2.getVisible()) {
            getChannelManager().getViewModel().moveToMyChannel(getAdapterPosition());
            view.postDelayed(new ChannelTabViewHolder$onClick$1(this), 250);
        } else if (isEditMode()) {
            Channel channel3 = this.channel;
            if (channel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
            }
            if (!channel3.isFixed()) {
                getChannelManager().getViewModel().moveToOtherChannel(getAdapterPosition());
            }
        } else {
            Channel channel4 = this.channel;
            if (channel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
            }
            if (channel4.getVisible()) {
                EventBus eventBus = EventBus.getDefault();
                Channel channel5 = this.channel;
                if (channel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channel");
                }
                eventBus.post(new ChannelTabEvent(channel5));
                FragmentActivity activity = getChannelManager().getActivity();
                Intrinsics.checkNotNull(activity);
                activity.finish();
            }
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131362779) {
            return super.onLongClick(view);
        }
        Channel channel2 = this.channel;
        if (channel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
        }
        if (!channel2.getVisible()) {
            return false;
        }
        Channel channel3 = this.channel;
        if (channel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
        }
        if (channel3.isFixed()) {
            getChannelManager().setEditMode(true);
            return true;
        }
        getChannelManager().startDrag(getAdapterPosition());
        return true;
    }

    @Override // com.coolapk.market.view.main.channel.ItemTouchHelperViewHolder
    public void onItemSelected() {
        this.binding.backgroundView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        this.binding.backgroundView.animate().scaleX(1.1f).scaleY(1.1f).z((float) NumberExtendsKt.getDp((Number) 8)).setListener(null).start();
    }

    @Override // com.coolapk.market.view.main.channel.ItemTouchHelperViewHolder
    public void onItemClear() {
        this.binding.backgroundView.animate().scaleX(1.0f).scaleY(1.0f).z((float) NumberExtendsKt.getDp((Number) 0)).setListener(new ChannelTabViewHolder$onItemClear$1(this)).start();
    }
}
