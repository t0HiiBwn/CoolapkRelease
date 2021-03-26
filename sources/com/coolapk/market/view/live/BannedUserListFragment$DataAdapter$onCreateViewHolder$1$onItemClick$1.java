package com.coolapk.market.view.live;

import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.LiveUser;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import java.util.Objects;
import kotlin.Metadata;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: BannedUserListFragment.kt */
final class BannedUserListFragment$DataAdapter$onCreateViewHolder$1$onItemClick$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ View $view;
    final /* synthetic */ BannedUserListFragment$DataAdapter$onCreateViewHolder$1 this$0;

    BannedUserListFragment$DataAdapter$onCreateViewHolder$1$onItemClick$1(BannedUserListFragment$DataAdapter$onCreateViewHolder$1 bannedUserListFragment$DataAdapter$onCreateViewHolder$1, View view) {
        this.this$0 = bannedUserListFragment$DataAdapter$onCreateViewHolder$1;
        this.$view = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Object tag = this.$view.getTag();
        Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.model.LiveUser");
        final LiveUser liveUser = (LiveUser) tag;
        DataManager.getInstance().disallowLiveUser(BannedUserListFragment.this.getLiveId(), liveUser.getUid(), BannedUserListFragment.this.getBanType() == 1 ? -1 : -2).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>(this) {
            /* class com.coolapk.market.view.live.BannedUserListFragment$DataAdapter$onCreateViewHolder$1$onItemClick$1.AnonymousClass1 */
            final /* synthetic */ BannedUserListFragment$DataAdapter$onCreateViewHolder$1$onItemClick$1 this$0;

            {
                this.this$0 = r1;
            }

            public void onNext(String str) {
                BannedUserListFragment.this.dataList.remove(liveUser);
                FragmentActivity activity = BannedUserListFragment.this.getActivity();
                if (str == null) {
                    str = "";
                }
                Toast.show$default(activity, str, 0, false, 12, null);
            }

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                Toast.error(BannedUserListFragment.this.getActivity(), th);
            }
        });
    }
}
