package com.coolapk.market.viewholder;

import android.view.View;
import com.coolapk.market.databinding.ItemOptionsTitleBinding;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.widget.SectionedAdapter;

public class OptionsTitleSectionViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558854;

    public OptionsTitleSectionViewHolder(View view, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
        ItemOptionsTitleBinding itemOptionsTitleBinding = (ItemOptionsTitleBinding) getBinding();
        ViewUtil.clickListener(itemOptionsTitleBinding.option1View, this);
        ViewUtil.clickListener(itemOptionsTitleBinding.option2View, this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        String[] strArr = (String[]) ((SectionedAdapter.Section) obj).getObject();
        ItemOptionsTitleBinding itemOptionsTitleBinding = (ItemOptionsTitleBinding) getBinding();
        itemOptionsTitleBinding.setTitle(strArr[0]);
        itemOptionsTitleBinding.setOption1(strArr[1]);
        itemOptionsTitleBinding.setOption2(strArr[2]);
        itemOptionsTitleBinding.executePendingBindings();
    }
}
