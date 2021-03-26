package com.coolapk.market.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemNotificationNaviBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.bubble.DragAndDropHelper;
import com.coolapk.market.widget.view.FatTextView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00172\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001\u0017B#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J \u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/viewholder/NotificationNavViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemNotificationNaviBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "holderItem", "onClick", "view", "setBubbleView", "textView", "Landroid/widget/TextView;", "page", "", "type", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NotificationNavViewHolder.kt */
public final class NotificationNavViewHolder extends GenericBindHolder<ItemNotificationNaviBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558853;

    public NotificationNavViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
    }

    public void bindToContent(HolderItem holderItem) {
        ItemNotificationNaviBinding itemNotificationNaviBinding = (ItemNotificationNaviBinding) getBinding();
        Intrinsics.checkNotNull(itemNotificationNaviBinding);
        itemNotificationNaviBinding.setClick(this);
        ItemNotificationNaviBinding itemNotificationNaviBinding2 = (ItemNotificationNaviBinding) getBinding();
        Intrinsics.checkNotNull(itemNotificationNaviBinding2);
        itemNotificationNaviBinding2.setNotification(AppHolder.getAppNotification());
        ItemNotificationNaviBinding itemNotificationNaviBinding3 = (ItemNotificationNaviBinding) getBinding();
        Intrinsics.checkNotNull(itemNotificationNaviBinding3);
        itemNotificationNaviBinding3.executePendingBindings();
        ItemNotificationNaviBinding itemNotificationNaviBinding4 = (ItemNotificationNaviBinding) getBinding();
        Intrinsics.checkNotNull(itemNotificationNaviBinding4);
        FatTextView fatTextView = itemNotificationNaviBinding4.textView1;
        Intrinsics.checkNotNullExpressionValue(fatTextView, "binding!!.textView1");
        setBubbleView(fatTextView, 1, "atme");
        ItemNotificationNaviBinding itemNotificationNaviBinding5 = (ItemNotificationNaviBinding) getBinding();
        Intrinsics.checkNotNull(itemNotificationNaviBinding5);
        FatTextView fatTextView2 = itemNotificationNaviBinding5.textView2;
        Intrinsics.checkNotNullExpressionValue(fatTextView2, "binding!!.textView2");
        setBubbleView(fatTextView2, 2, "atcommentme");
        ItemNotificationNaviBinding itemNotificationNaviBinding6 = (ItemNotificationNaviBinding) getBinding();
        Intrinsics.checkNotNull(itemNotificationNaviBinding6);
        FatTextView fatTextView3 = itemNotificationNaviBinding6.textView3;
        Intrinsics.checkNotNullExpressionValue(fatTextView3, "binding!!.textView3");
        setBubbleView(fatTextView3, 5, "feedlike");
        ItemNotificationNaviBinding itemNotificationNaviBinding7 = (ItemNotificationNaviBinding) getBinding();
        Intrinsics.checkNotNull(itemNotificationNaviBinding7);
        FatTextView fatTextView4 = itemNotificationNaviBinding7.textView4;
        Intrinsics.checkNotNullExpressionValue(fatTextView4, "binding!!.textView4");
        setBubbleView(fatTextView4, 6, "contacts_follow");
        ItemNotificationNaviBinding itemNotificationNaviBinding8 = (ItemNotificationNaviBinding) getBinding();
        Intrinsics.checkNotNull(itemNotificationNaviBinding8);
        FatTextView fatTextView5 = itemNotificationNaviBinding8.textView5;
        Intrinsics.checkNotNullExpressionValue(fatTextView5, "binding!!.textView5");
        setBubbleView(fatTextView5, 4, "message");
    }

    private final void setBubbleView(TextView textView, int i, String str) {
        String str2;
        int countByPage = AppHolder.getAppNotification().getCountByPage(i);
        TextView textView2 = textView;
        UiUtils.tintBackground(textView2, AppHolder.getAppTheme().getColorAccent());
        if (countByPage > 1000) {
            str2 = "999+";
        } else {
            str2 = String.valueOf(countByPage);
        }
        textView.setText(str2);
        textView.setVisibility(countByPage > 0 ? 0 : 8);
        if (textView.getVisibility() == 8) {
            ViewParent parent = textView.getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).setTouchDelegate(null);
            textView.setOnTouchListener(null);
            return;
        }
        textView.post(new NotificationNavViewHolder$setBubbleView$1(this, textView));
        DragAndDropHelper.withTarget(textView2).setDragListener(new NotificationNavViewHolder$setBubbleView$2(this, i, str)).setPaintColor(AppHolder.getAppTheme().getColorAccent()).apply();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        int id = view.getId();
        if (id != 2131362780) {
            switch (id) {
                case 2131362784:
                    ActionManager.startNotificationActivity(getContext(), 2);
                    return;
                case 2131362785:
                    ActionManager.startNotificationActivity(getContext(), 3);
                    return;
                case 2131362786:
                    ActionManager.startNotificationActivity(getContext(), 5);
                    return;
                case 2131362787:
                    ActionManager.startNotificationActivity(getContext(), 6);
                    return;
                case 2131362788:
                    ActionManager.startNotificationActivity(getContext(), 4);
                    return;
                default:
                    return;
            }
        } else {
            ActionManager.startNotificationActivity(getContext(), 1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/NotificationNavViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NotificationNavViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
