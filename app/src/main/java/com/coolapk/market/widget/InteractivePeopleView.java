package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;
import java.util.Locale;

public class InteractivePeopleView extends LinearLayout {
    private ImageView arrowView;
    private List<RelatedData> avatarList;
    private ImageView firstAvatarView;
    private ImageView iconView;
    private boolean inDyh;
    private TextView moreView;
    private ImageView secondAvatarView;
    private int sumNum;
    private TextView titleView;

    public InteractivePeopleView(Context context) {
        this(context, null);
    }

    public InteractivePeopleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InteractivePeopleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (!isInEditMode()) {
            init();
            return;
        }
        TextView textView = new TextView(getContext());
        this.titleView = textView;
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.titleView.setTextSize(2, 15.0f);
        this.titleView.setText("Interactive People View");
        addView(this.titleView);
        setMargin(this.titleView, DisplayUtils.dp2px(getContext(), 6.0f));
    }

    private void init() {
        setGravity(16);
        ImageView imageView = new ImageView(getContext());
        this.iconView = imageView;
        imageView.setVisibility(8);
        this.iconView.setLayoutParams(new LinearLayout.LayoutParams(DisplayUtils.dp2px(getContext(), 22.0f), DisplayUtils.dp2px(getContext(), 22.0f)));
        this.iconView.setImageTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getTextColorSecondary()));
        addView(this.iconView);
        TextView textView = new TextView(getContext());
        this.titleView = textView;
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.titleView.setTextSize(2, 15.0f);
        this.titleView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
        addView(this.titleView);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(relativeLayout);
        ImageView createAvatarView = createAvatarView();
        this.firstAvatarView = createAvatarView;
        relativeLayout.addView(createAvatarView);
        ImageView createAvatarView2 = createAvatarView();
        this.secondAvatarView = createAvatarView2;
        relativeLayout.addView(createAvatarView2);
        setMargin(this.secondAvatarView, DisplayUtils.dp2px(getContext(), 20.0f));
        this.moreView = new TextView(getContext());
        this.moreView.setLayoutParams(new ViewGroup.MarginLayoutParams(DisplayUtils.dp2px(getContext(), 32.0f), DisplayUtils.dp2px(getContext(), 32.0f)));
        this.moreView.setTextColor(AppHolder.getAppTheme().getTextColorPrimaryInverse());
        this.moreView.setTextSize(2, 12.0f);
        if (this.inDyh) {
            this.moreView.setBackgroundResource(2131230900);
        } else {
            this.moreView.setBackgroundResource(2131230902);
        }
        this.moreView.setGravity(17);
        relativeLayout.addView(this.moreView);
        setMargin(this.moreView, DisplayUtils.dp2px(getContext(), 40.0f));
        ImageView createArrowView = createArrowView(24);
        this.arrowView = createArrowView;
        addView(createArrowView);
        setMargin(this.arrowView, DisplayUtils.dp2px(getContext(), 2.0f));
    }

    public void setInDyh(boolean z) {
        this.inDyh = z;
        TextView textView = this.moreView;
        if (textView != null && z) {
            textView.setBackgroundResource(2131230900);
            this.moreView.setTextColor(AppHolder.getAppTheme().getMainTextColor());
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = DisplayUtils.dp2px(getContext(), 56.0f);
            setLayoutParams(layoutParams);
        }
    }

    private ImageView createAvatarView() {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(DisplayUtils.dp2px(getContext(), 32.0f), DisplayUtils.dp2px(getContext(), 32.0f));
        RoundedImageView roundedImageView = new RoundedImageView(getContext());
        roundedImageView.setLayoutParams(marginLayoutParams);
        roundedImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        roundedImageView.setOval(true);
        int dp2px = DisplayUtils.dp2px(getContext(), 2.0f);
        roundedImageView.setPadding(dp2px, dp2px, dp2px, dp2px);
        roundedImageView.setBackground(ResourceUtils.getDrawable(getContext(), 2131230902));
        return roundedImageView;
    }

    private ImageView createArrowView(int i) {
        float f = (float) i;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(DisplayUtils.dp2px(getContext(), f), DisplayUtils.dp2px(getContext(), f));
        ImageView imageView = new ImageView(getContext());
        if (i == 0) {
            imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        } else {
            imageView.setLayoutParams(marginLayoutParams);
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(2131231383);
        imageView.setImageTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getTextColorTertiary()));
        return imageView;
    }

    public void setIconDrawable(Drawable drawable) {
        this.iconView.setImageDrawable(drawable);
    }

    public void setTitle(String str) {
        this.titleView.setText(str);
    }

    public void setTitleTextSize(float f) {
        this.titleView.setTextSize(2, f);
    }

    public void setAvatarList(List<RelatedData> list) {
        this.avatarList = list;
        this.firstAvatarView.setImageDrawable(null);
        this.secondAvatarView.setImageDrawable(null);
        this.secondAvatarView.setVisibility(8);
        this.moreView.setVisibility(8);
        if (!CollectionUtils.isEmpty(list)) {
            AppHolder.getContextImageLoader().displayImage(getContext(), this.avatarList.get(0).getUserAvatar(), this.firstAvatarView, 2131231152);
            if (list.size() > 1) {
                this.secondAvatarView.setVisibility(0);
                AppHolder.getContextImageLoader().displayImage(getContext(), this.avatarList.get(1).getUserAvatar(), this.secondAvatarView, 2131231152);
                if (list.size() > 2) {
                    int i = this.sumNum;
                    if (i == 0) {
                        i = list.size();
                    }
                    int i2 = i - 2;
                    if (i2 > 99) {
                        i2 = 99;
                    }
                    this.moreView.setVisibility(0);
                    this.moreView.setText(String.format(Locale.getDefault(), "%d+", Integer.valueOf(i2)));
                }
            }
        }
    }

    public void setLogoList(List<String> list) {
        this.firstAvatarView.setImageDrawable(null);
        this.secondAvatarView.setImageDrawable(null);
        this.secondAvatarView.setVisibility(8);
        this.moreView.setVisibility(8);
        if (!CollectionUtils.isEmpty(list)) {
            AppHolder.getContextImageLoader().displayImage(getContext(), list.get(0), this.firstAvatarView, 2131231152);
            if (list.size() > 1) {
                this.secondAvatarView.setVisibility(0);
                AppHolder.getContextImageLoader().displayImage(getContext(), list.get(1), this.secondAvatarView, 2131231152);
                if (list.size() > 2 || this.sumNum > 2) {
                    int i = this.sumNum;
                    if (i == 0) {
                        i = list.size();
                    }
                    int i2 = i - 2;
                    if (i2 > 99) {
                        i2 = 99;
                    }
                    this.moreView.setVisibility(0);
                    this.moreView.setText(String.format(Locale.getDefault(), "%d+", Integer.valueOf(i2)));
                }
            }
        }
    }

    public void setSumNum(int i) {
        this.sumNum = i;
    }

    private void setMargin(View view, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }
}
