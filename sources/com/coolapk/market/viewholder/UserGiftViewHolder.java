package com.coolapk.market.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemUserGiftBinding;
import com.coolapk.market.model.Gift;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.ViewUtil;

public class UserGiftViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558979;
    private Gift gift;

    public UserGiftViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        ItemUserGiftBinding itemUserGiftBinding = (ItemUserGiftBinding) getBinding();
        ViewUtil.clickListener(itemUserGiftBinding.giftGetText, this);
        ViewUtil.clickListener(itemUserGiftBinding.getRoot(), this);
        itemUserGiftBinding.getRoot().setOnLongClickListener(this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        String str;
        this.gift = (Gift) obj;
        ItemUserGiftBinding itemUserGiftBinding = (ItemUserGiftBinding) getBinding();
        itemUserGiftBinding.setGift(this.gift);
        TextView textView = itemUserGiftBinding.giftDateLine;
        if (this.gift.getDateline() == null) {
            str = "";
        } else {
            str = DateUtils.getTimeDescription(getContext(), this.gift.getDateline());
        }
        textView.setText(str);
    }
}
