package com.coolapk.market.view.contact;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.User;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.message.MessageCardDialogFragment;
import com.coolapk.market.view.message.RecentContactsActivity;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/contact/UserPickFragment$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserPickFragment.kt */
public final class UserPickFragment$onCreateViewHolder$1 extends ItemActionHandler {
    final /* synthetic */ UserPickFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    UserPickFragment$onCreateViewHolder$1(UserPickFragment userPickFragment) {
        this.this$0 = userPickFragment;
    }

    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        super.onItemClick(viewHolder, view);
        if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition()) && view.getId() == 2131362205) {
            FragmentActivity activity = this.this$0.getActivity();
            if (activity instanceof OnUserPickListener) {
                Object obj = this.this$0.getDataList().get(viewHolder.getAdapterPosition());
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.User");
                ((OnUserPickListener) activity).onUserPick((User) obj);
            } else if (activity instanceof RecentContactsActivity) {
                Object obj2 = this.this$0.getDataList().get(viewHolder.getAdapterPosition());
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.coolapk.market.model.User");
                User user = (User) obj2;
                Contacts build = ((Contacts.Builder) Contacts.builder().setUid(user.getUid()).setDisplayUserName(user.getUserName())).setUserInfo(user.getUserInfo()).setEntityType("contact").setIsFriend(1).build();
                MessageCardDialogFragment.Companion companion = MessageCardDialogFragment.Companion;
                Entity entity = ((RecentContactsActivity) activity).getEntity();
                Intrinsics.checkNotNullExpressionValue(build, "contact");
                MessageCardDialogFragment newInstance = companion.newInstance(entity, build);
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "listener.requireAppCompa…().supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
            }
        }
    }
}
