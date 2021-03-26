package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemTextImageCardBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.ViewUtil;

public class TextImageCardViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558949;
    private EntityCard card;
    private TitleViewPart viewPart;

    public TextImageCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        ItemTextImageCardBinding itemTextImageCardBinding = (ItemTextImageCardBinding) getBinding();
        ViewUtil.clickListener(itemTextImageCardBinding.getRoot(), this);
        this.viewPart = TitleViewPart.newInstance(itemTextImageCardBinding.linearView, this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        this.card = (EntityCard) obj;
        ItemTextImageCardBinding itemTextImageCardBinding = (ItemTextImageCardBinding) getBinding();
        itemTextImageCardBinding.setCard(this.card);
        itemTextImageCardBinding.executePendingBindings();
        this.viewPart.bindToContent(this.card);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == 2131362768) {
            ActionManager.startActivityByUrl(getContext(), this.card.getUrl());
            StatisticHelper.getInstance().recordEntityEvent("", this.card, getAdapterPosition(), null, "");
        }
    }
}
