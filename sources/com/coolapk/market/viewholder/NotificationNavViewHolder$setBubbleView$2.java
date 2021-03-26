package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.view.notification.NotificationListFragment;
import com.coolapk.market.widget.bubble.DragAndDropHelper;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onTargetDrop"}, k = 3, mv = {1, 4, 2})
/* compiled from: NotificationNavViewHolder.kt */
final class NotificationNavViewHolder$setBubbleView$2 implements DragAndDropHelper.DragAndDrawListener {
    final /* synthetic */ int $page;
    final /* synthetic */ String $type;
    final /* synthetic */ NotificationNavViewHolder this$0;

    NotificationNavViewHolder$setBubbleView$2(NotificationNavViewHolder notificationNavViewHolder, int i, String str) {
        this.this$0 = notificationNavViewHolder;
        this.$page = i;
        this.$type = str;
    }

    @Override // com.coolapk.market.widget.bubble.DragAndDropHelper.DragAndDrawListener
    public final void onTargetDrop(View view) {
        AppNotification appNotification = AppHolder.getAppNotification();
        appNotification.clearByPage(this.$page);
        DataBindingComponent component = this.this$0.getComponent();
        LifecycleOwner lifecycleOwner = null;
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (lifecycleOwner2 instanceof NotificationListFragment) {
            lifecycleOwner = lifecycleOwner2;
        }
        NotificationListFragment notificationListFragment = (NotificationListFragment) lifecycleOwner;
        if (notificationListFragment != null) {
            notificationListFragment.notifyItemChanged(this.this$0.getAdapterPosition());
        }
        appNotification.clearOnlineCountByType(this.$type);
    }
}
