package com.coolapk.market.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.lankton.flowlayout.FlowLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ViewUtil;
import java.util.List;

public class TagsView extends FlowLayout {
    private OnTagClickListener onTagClickListener;

    public interface OnTagClickListener {
        void onTagClick(View view, int i, String str);
    }

    public TagsView(Context context) {
        this(context, null);
    }

    public TagsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            addView(createTagView("Tag View"));
            addView(createTagView("Tag View"));
        }
    }

    public void setKeywords(List<String> list) {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (list != null) {
            for (final int i = 0; i < list.size(); i++) {
                TextView createTagView = createTagView(list.get(i));
                ViewUtil.clickListener(createTagView, new View.OnClickListener() {
                    /* class com.coolapk.market.widget.TagsView.AnonymousClass1 */

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TagsView.this.onTagClickListener.onTagClick(view, i, ((TextView) view).getText().toString());
                    }
                });
                addView(createTagView);
            }
        }
    }

    @Override // cn.lankton.flowlayout.FlowLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int measuredWidth = getMeasuredWidth();
            int i3 = (measuredWidth - paddingLeft) - paddingRight;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i3 = ((i3 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin) - childAt.getMeasuredWidth();
            }
            if (i3 > 0) {
                if (childCount >= 2) {
                    for (int i5 = 0; i5 < childCount; i5++) {
                        measuredWidth -= getChildAt(i5).getMeasuredWidth();
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) getLayoutParams();
                    int paddingLeft2 = (measuredWidth + (((marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin) + getPaddingLeft()) + getPaddingRight())) / (childCount + 1);
                    for (int i6 = 0; i6 < childCount; i6++) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) getChildAt(i6).getLayoutParams();
                        if (i6 == 0) {
                            marginLayoutParams3.leftMargin = (paddingLeft2 - marginLayoutParams2.leftMargin) - getPaddingLeft();
                            marginLayoutParams3.rightMargin = 0;
                        } else if (i6 == childCount - 1) {
                            marginLayoutParams3.rightMargin = (paddingLeft2 - marginLayoutParams2.rightMargin) - getPaddingRight();
                            marginLayoutParams3.leftMargin = paddingLeft2;
                        } else {
                            marginLayoutParams3.leftMargin = paddingLeft2;
                            marginLayoutParams3.rightMargin = 0;
                        }
                    }
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) getChildAt(0).getLayoutParams();
                    int i7 = i3 / 2;
                    marginLayoutParams4.leftMargin += i7;
                    marginLayoutParams4.rightMargin += i7;
                }
                super.onMeasure(i, i2);
            }
        }
    }

    private TextView createTagView(String str) {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setMinWidth(DisplayUtils.dp2px(getContext(), 48.0f));
        textView.setBackground(ResourceUtils.getDrawable(getContext(), 2131231715));
        if (!isInEditMode()) {
            textView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
            textView.setTag(null);
            String[] split = str.split(":");
            if (split.length == 3) {
                String str2 = split[0];
                String str3 = split[2];
                String str4 = split[1];
                if (TextUtils.equals(str2, "hot")) {
                    textView.setTextColor(ResourceUtils.getColorInt(getContext(), 2131100035));
                }
                textView.setTag(str3);
                str = str4;
            }
        }
        textView.setText(str);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        int dp2px = DisplayUtils.dp2px(getContext(), 5.0f);
        marginLayoutParams.setMargins(dp2px, 0, dp2px, 0);
        textView.setLayoutParams(marginLayoutParams);
        int dp2px2 = DisplayUtils.dp2px(getContext(), 10.0f);
        textView.setPadding(dp2px2, 0, dp2px2, 0);
        return textView;
    }

    public void setOnTagClickListener(OnTagClickListener onTagClickListener2) {
        this.onTagClickListener = onTagClickListener2;
    }
}
