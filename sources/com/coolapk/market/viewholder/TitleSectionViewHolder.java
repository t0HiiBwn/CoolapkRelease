package com.coolapk.market.viewholder;

import android.view.View;
import com.coolapk.market.databinding.ItemTitleSectionBinding;
import com.coolapk.market.widget.SectionedAdapter;

public class TitleSectionViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558964;

    public TitleSectionViewHolder(View view) {
        super(view);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        ItemTitleSectionBinding itemTitleSectionBinding = (ItemTitleSectionBinding) getBinding();
        itemTitleSectionBinding.setTitle((String) ((SectionedAdapter.Section) obj).getObject());
        itemTitleSectionBinding.executePendingBindings();
    }
}
