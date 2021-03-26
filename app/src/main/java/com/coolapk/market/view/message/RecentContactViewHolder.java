package com.coolapk.market.view.message;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.message.MessageCardDialogFragment;
import com.coolapk.market.viewholder.ContactViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/message/RecentContactViewHolder;", "Lcom/coolapk/market/viewholder/ContactViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "listType", "", "entity", "Lcom/coolapk/market/model/Entity;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;ILcom/coolapk/market/model/Entity;)V", "contact", "Lcom/coolapk/market/model/Contacts;", "getEntity", "()Lcom/coolapk/market/model/Entity;", "bindToContent", "", "contacts", "onClick", "view", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RecentContactViewHolder.kt */
public final class RecentContactViewHolder extends ContactViewHolder {
    private Contacts contact;
    private final Entity entity;

    public final Entity getEntity() {
        return this.entity;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecentContactViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, int i, Entity entity2) {
        super(view, dataBindingComponent, itemActionHandler, i);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(entity2, "entity");
        this.entity = entity2;
    }

    @Override // com.coolapk.market.viewholder.ContactViewHolder
    public void bindToContent(Contacts contacts) {
        super.bindToContent(contacts);
        this.contact = contacts;
    }

    @Override // com.coolapk.market.viewholder.ContactViewHolder, com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == 2131362200) {
            MessageCardDialogFragment.Companion companion = MessageCardDialogFragment.Companion;
            Entity entity2 = this.entity;
            Contacts contacts = this.contact;
            Intrinsics.checkNotNull(contacts);
            MessageCardDialogFragment newInstance = companion.newInstance(entity2, contacts);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
        }
    }
}
