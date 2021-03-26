package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemLinkCardBinding;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.ViewUtil;

public class LinkCardViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558807;

    public LinkCardViewHolder(View view, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        EntityCard entityCard = (EntityCard) obj;
        if (!CollectionUtils.isEmpty(entityCard.getEntities())) {
            int size = entityCard.getEntities().size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = entityCard.getEntities().get(i).getTitle();
            }
            ItemLinkCardBinding itemLinkCardBinding = (ItemLinkCardBinding) getBinding();
            LayoutInflater from = LayoutInflater.from(getContext());
            int childCount = itemLinkCardBinding.tabLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                itemLinkCardBinding.tabLayout.getChildAt(i2).setVisibility(0);
            }
            boolean z = true;
            if (size > childCount) {
                while (childCount < size) {
                    itemLinkCardBinding.tabLayout.addView(from.inflate(2131558808, (ViewGroup) itemLinkCardBinding.tabLayout, false), new LinearLayout.LayoutParams(0, -1, 1.0f));
                    childCount++;
                }
            } else if (size < childCount) {
                for (int i3 = childCount - 1; i3 >= size; i3--) {
                    itemLinkCardBinding.tabLayout.getChildAt(i3).setVisibility(8);
                }
            }
            for (int i4 = 0; i4 < size; i4++) {
                View childAt = itemLinkCardBinding.tabLayout.getChildAt(i4);
                childAt.setTag(Integer.valueOf(i4));
                ViewUtil.clickListener(childAt, this);
                ((TextView) childAt.findViewById(2131363551)).setText(strArr[i4]);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                layoutParams.width = -2;
                childAt.setLayoutParams(layoutParams);
            }
            itemLinkCardBinding.tabLayout.measure(0, Integer.MIN_VALUE);
            int measuredWidth = itemLinkCardBinding.tabLayout.getMeasuredWidth();
            int paddingLeft = (getContext().getResources().getDisplayMetrics().widthPixels - itemLinkCardBinding.tabLayout.getPaddingLeft()) - itemLinkCardBinding.tabLayout.getPaddingRight();
            if (measuredWidth <= paddingLeft) {
                z = false;
            }
            if (!z) {
                for (int i5 = 0; i5 < size; i5++) {
                    View childAt2 = itemLinkCardBinding.tabLayout.getChildAt(i5);
                    childAt2.measure(0, Integer.MIN_VALUE);
                    int measuredWidth2 = childAt2.getMeasuredWidth() + ((int) (((float) ((paddingLeft - measuredWidth) / size)) + 0.5f));
                    ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
                    layoutParams2.width = measuredWidth2;
                    childAt2.setLayoutParams(layoutParams2);
                }
            }
        }
    }
}
