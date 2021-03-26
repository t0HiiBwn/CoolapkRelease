package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemUserBinding;
import com.coolapk.market.model.User;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.StringUtils;

public class UserViewHolder extends GenericBindHolder<ItemUserBinding, User> {
    public static final int LAYOUT_ID = 2131558967;

    public UserViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
    }

    public void bindToContent(User user) {
        ((ItemUserBinding) getBinding()).setModel(user);
        ((ItemUserBinding) getBinding()).setOnClick(this);
        ((ItemUserBinding) getBinding()).setTransformer(new CircleTransform());
        ((ItemUserBinding) getBinding()).setFans(StringUtils.emptyIfNull(getContext().getString(2131887088, user.getFans())));
        ((ItemUserBinding) getBinding()).setFollow(StringUtils.emptyIfNull(getContext().getString(2131887092, user.getFollow())));
        ((ItemUserBinding) getBinding()).executePendingBindings();
    }
}
