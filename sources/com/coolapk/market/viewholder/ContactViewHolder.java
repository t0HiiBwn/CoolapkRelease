package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemContactBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Contacts;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.StringUtils;

public class ContactViewHolder extends GenericBindHolder<ItemContactBinding, Contacts> {
    public static final int LAYOUT_ID = 2131558666;
    public static final int LIST_TYPE_FANS = -1;
    public static final int LIST_TYPE_FOLLOW = 1;
    public static final int LIST_TYPE_RecentContact = 0;
    private int listType;

    public ContactViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, int i) {
        super(view, dataBindingComponent, itemActionHandler);
        this.listType = i;
    }

    public void bindToContent(Contacts contacts) {
        String str;
        String str2;
        ((ItemContactBinding) getBinding()).setModel(contacts);
        ((ItemContactBinding) getBinding()).setListType(this.listType);
        ((ItemContactBinding) getBinding()).setOnClick(this);
        ((ItemContactBinding) getBinding()).setTransformer(new CircleTransform());
        UserInfo followerUserInfo = contacts.getFollowerUserInfo();
        UserInfo userInfo = contacts.getUserInfo();
        long loginTime = this.listType > 0 ? followerUserInfo.getLoginTime() : userInfo.getLoginTime();
        if (DateUtils.getSomeDateTime() < loginTime) {
            ((ItemContactBinding) getBinding()).setLoginTime(getContext().getString(2131887162, DateUtils.getTimeDescription(getContext(), Long.valueOf(loginTime))));
        }
        ItemContactBinding itemContactBinding = (ItemContactBinding) getBinding();
        if (this.listType > 0) {
            str = StringUtils.emptyIfNull(getContext().getString(2131887154, followerUserInfo.getFollow()));
        } else {
            str = StringUtils.emptyIfNull(getContext().getString(2131887154, userInfo.getFollow()));
        }
        itemContactBinding.setFollow(str);
        ItemContactBinding itemContactBinding2 = (ItemContactBinding) getBinding();
        if (this.listType > 0) {
            str2 = StringUtils.emptyIfNull(getContext().getString(2131887150, followerUserInfo.getFans()));
        } else {
            str2 = StringUtils.emptyIfNull(getContext().getString(2131887150, userInfo.getFans()));
        }
        itemContactBinding2.setFans(str2);
        ((ItemContactBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Contacts model = ((ItemContactBinding) getBinding()).getModel();
        super.onClick(view);
        int id = view.getId();
        if ((id == 2131362205 || id == 2131362683) && this.listType != 0) {
            ActionManager.startUserSpaceActivity(this.itemView.findViewById(2131362683), this.listType > 0 ? model.getFollowUid() : model.getUid(), this.listType > 0 ? model.getFollowerUserAvatar() : model.getUserAvatar());
        }
    }
}
