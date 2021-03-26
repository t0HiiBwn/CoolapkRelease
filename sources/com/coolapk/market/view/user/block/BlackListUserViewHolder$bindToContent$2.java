package com.coolapk.market.view.user.block;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.event.UserBlockedEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.User;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: BlackListUserViewHolder.kt */
final class BlackListUserViewHolder$bindToContent$2 implements View.OnClickListener {
    final /* synthetic */ User $user;
    final /* synthetic */ BlackListUserViewHolder this$0;

    BlackListUserViewHolder$bindToContent$2(BlackListUserViewHolder blackListUserViewHolder, User user) {
        this.this$0 = blackListUserViewHolder;
        this.$user = user;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!BlackListUserViewHolder.access$isRequesting$p(this.this$0)) {
            BlackListUserViewHolder.access$setRequesting$p(this.this$0, true);
            DataManager instance = DataManager.getInstance();
            User user = this.$user;
            instance.removeFromBlackList(user != null ? user.getUid() : null).compose(RxUtils.apiCommonToData()).subscribe(new Action1<String>(this) {
                /* class com.coolapk.market.view.user.block.BlackListUserViewHolder$bindToContent$2.AnonymousClass1 */
                final /* synthetic */ BlackListUserViewHolder$bindToContent$2 this$0;

                {
                    this.this$0 = r1;
                }

                public final void call(String str) {
                    DataBindingComponent component = this.this$0.this$0.getComponent();
                    LifecycleOwner lifecycleOwner = null;
                    if (!(component instanceof FragmentBindingComponent)) {
                        component = null;
                    }
                    FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                    LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                    if (lifecycleOwner2 instanceof UserBlackListFragment) {
                        lifecycleOwner = lifecycleOwner2;
                    }
                    UserBlackListFragment userBlackListFragment = (UserBlackListFragment) lifecycleOwner;
                    if (userBlackListFragment instanceof UserBlackListFragment) {
                        User user = this.this$0.$user;
                        Intrinsics.checkNotNull(user);
                        userBlackListFragment.removeUser(user);
                        EventBus.getDefault().post(new UserBlockedEvent(this.this$0.$user.getUid(), 0));
                    }
                }
            }, new Action1<Throwable>(this) {
                /* class com.coolapk.market.view.user.block.BlackListUserViewHolder$bindToContent$2.AnonymousClass2 */
                final /* synthetic */ BlackListUserViewHolder$bindToContent$2 this$0;

                {
                    this.this$0 = r1;
                }

                public final void call(Throwable th) {
                    BlackListUserViewHolder.access$setRequesting$p(this.this$0.this$0, false);
                    Toast.error(this.this$0.this$0.getContext(), th);
                }
            });
        }
    }
}
