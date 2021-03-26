package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemAppForumBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.AppForum;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feed.CancelFollowItemDialog;

public class AppForumViewHolder extends GenericBindHolder<ItemAppForumBinding, AppForum> {
    public static final int LAYOUT_ID = 2131558595;
    private AppForum appForum;
    private boolean showCancelAction = false;

    public AppForumViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
    }

    public void bindToContent(final AppForum appForum2) {
        ItemAppForumBinding itemAppForumBinding = (ItemAppForumBinding) getBinding();
        this.appForum = appForum2;
        itemAppForumBinding.setClick(this);
        itemAppForumBinding.setModel(appForum2);
        this.showCancelAction = EntityExtendsKt.getIntExtraData(appForum2, "showCancelFollowMenu", 0) == 1;
        itemAppForumBinding.followView.setText(getContext().getString(2131886670, appForum2.followCount()));
        itemAppForumBinding.commentView.setText(getContext().getString(2131886669, appForum2.commentCount()));
        itemAppForumBinding.executePendingBindings();
        itemAppForumBinding.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.coolapk.market.viewholder.AppForumViewHolder.AnonymousClass1 */

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (!AppForumViewHolder.this.showCancelAction) {
                    return false;
                }
                CancelFollowItemDialog.newInstance(appForum2).show(ContextExtendsKt.requireAppCompatActivity(AppForumViewHolder.this.getContext()).getSupportFragmentManager(), (String) null);
                return true;
            }
        });
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == 2131362205) {
            ActionManager.startAppForumActivity(UiUtils.getActivity(getContext()), ((ItemAppForumBinding) getBinding()).iconView, this.appForum.packageName(), this.appForum.logo(), this.appForum.title(), null);
        }
    }
}
