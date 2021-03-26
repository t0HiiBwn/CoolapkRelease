package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.R;
import com.coolapk.market.databinding.ItemCommentbarChildViewBinding;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ViewUtil;

public class ActionView extends LinearLayout implements View.OnClickListener {
    private int actionType;
    private ItemCommentbarChildViewBinding binding;
    private DyhArticle dyhArticle;
    private int favNum;
    private boolean isFaved;
    private boolean isLiked;
    private int likeNum;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public ActionView(Context context, int i, DyhArticle dyhArticle2) {
        super(context);
        this.dyhArticle = dyhArticle2;
        initdefaultViews(DisplayUtils.dp2px(context, 4.0f), 0, DisplayUtils.dp2px(context, 8.0f), 0, 0, DisplayUtils.dp2px(context, 8.0f), DisplayUtils.dp2px(context, 8.0f), i);
    }

    public ActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        setOrientation(0);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.ActionView);
        int dimensionPixelOffset = obtainAttributes.getDimensionPixelOffset(2, 0);
        int dimensionPixelOffset2 = obtainAttributes.getDimensionPixelOffset(4, 0);
        int dimensionPixelOffset3 = obtainAttributes.getDimensionPixelOffset(7, 0);
        int dimensionPixelOffset4 = obtainAttributes.getDimensionPixelOffset(5, 0);
        int dimensionPixelOffset5 = obtainAttributes.getDimensionPixelOffset(6, 0);
        int dimensionPixelOffset6 = obtainAttributes.getDimensionPixelOffset(3, 0);
        int dimensionPixelOffset7 = obtainAttributes.getDimensionPixelOffset(1, 0);
        this.actionType = obtainAttributes.getInteger(0, -1);
        obtainAttributes.recycle();
        initdefaultViews(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3, dimensionPixelOffset4, dimensionPixelOffset5, dimensionPixelOffset6, dimensionPixelOffset7, this.actionType);
    }

    public void setActionType(int i) {
        this.actionType = i;
    }

    public void setDyhArtcile(DyhArticle dyhArticle2) {
        this.dyhArticle = dyhArticle2;
    }

    private void initdefaultViews(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean z = true;
        ItemCommentbarChildViewBinding itemCommentbarChildViewBinding = (ItemCommentbarChildViewBinding) DataBindingUtil.inflate(LayoutInflater.from(getContext()), 2131558665, this, true);
        this.binding = itemCommentbarChildViewBinding;
        itemCommentbarChildViewBinding.iconView.setPadding(i, 0, i, 0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.binding.iconView.getLayoutParams();
        layoutParams.width = i6;
        layoutParams.height = i7;
        this.binding.iconView.setLayoutParams(layoutParams);
        this.binding.textView.setTextSize((float) i3);
        if (i8 >= 0) {
            if (i8 == 0) {
                this.binding.textView.setText(String.valueOf(this.dyhArticle.getLikeNum()));
                DyhArticle dyhArticle2 = this.dyhArticle;
                if (dyhArticle2 == null || dyhArticle2.getUserAction().getLike() <= 0) {
                    z = false;
                }
                this.isLiked = z;
                this.binding.iconView.setImageResource(this.isLiked ? 2131231613 : 2131231615);
            } else if (i8 == 1) {
                this.binding.textView.setText(String.valueOf(this.dyhArticle.getFavNum()));
                DyhArticle dyhArticle3 = this.dyhArticle;
                if (dyhArticle3 == null || dyhArticle3.getUserAction().getFavorite() <= 0) {
                    z = false;
                }
                this.isFaved = z;
                this.binding.iconView.setImageResource(this.isFaved ? 2131231578 : 2131231584);
            }
        }
        ViewUtil.clickListener(this.binding.getRoot(), this);
    }
}
