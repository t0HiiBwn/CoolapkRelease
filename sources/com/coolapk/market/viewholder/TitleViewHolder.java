package com.coolapk.market.viewholder;

import android.text.TextUtils;
import android.view.View;
import com.coolapk.market.databinding.ItemTitleBinding;
import com.coolapk.market.model.HolderItem;

public class TitleViewHolder extends GenericBindHolder<ItemTitleBinding, HolderItem> {
    public static final int LAYOUT_ID = 2131558961;

    public TitleViewHolder(View view, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
    }

    public void bindToContent(HolderItem holderItem) {
        ((ItemTitleBinding) getBinding()).textView.setText(holderItem.getString());
        if (TextUtils.equals(getContext().getString(2131887323), holderItem.getString()) || TextUtils.equals("热门话题", holderItem.getString())) {
            ((ItemTitleBinding) getBinding()).textView.setTextSize(12.0f);
        }
    }
}
