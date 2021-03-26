package com.coolapk.market.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.AppCategory;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.ViewUtil;
import java.util.ArrayList;
import java.util.List;

public class TagView extends FlowLayout {
    private List<AppCategory> appCategories;

    public TagView(Context context) {
        this(context, null);
    }

    public TagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.appCategories = new ArrayList();
        if (isInEditMode()) {
            addView(createTagView("Tag View"));
        }
    }

    public void setTagListFromServiceApp(ServiceApp serviceApp) {
        if (serviceApp == null || TextUtils.isEmpty(serviceApp.getCategoryName())) {
            this.appCategories.clear();
            if (getChildCount() > 0) {
                removeAllViews();
                return;
            }
            return;
        }
        this.appCategories.clear();
        int i = 0;
        if (!CollectionUtils.isEmpty(serviceApp.getTagList())) {
            for (int i2 = 0; i2 < serviceApp.getTagList().size(); i2++) {
                this.appCategories.add(AppCategory.create(serviceApp.getCategoryId(), serviceApp.getCategoryName(), serviceApp.getTagList(), serviceApp.getApkType()));
            }
        }
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (!CollectionUtils.isEmpty(this.appCategories)) {
            while (i < this.appCategories.size()) {
                final AppCategory appCategory = this.appCategories.get(i);
                if (i == 0) {
                    TextView createTagView = createTagView(appCategory.getTitle());
                    ViewUtil.clickListener(createTagView, new View.OnClickListener() {
                        /* class com.coolapk.market.widget.TagView.AnonymousClass1 */

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ActionManager.startAppCategoryActivity(TagView.this.getContext(), appCategory, 0);
                        }
                    });
                    addView(createTagView);
                }
                final int i3 = i + 1;
                String str = appCategory.getTagList().get(i);
                if (!TextUtils.isEmpty(str)) {
                    TextView createTagView2 = createTagView(str);
                    ViewUtil.clickListener(createTagView2, new View.OnClickListener() {
                        /* class com.coolapk.market.widget.TagView.AnonymousClass2 */

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ActionManager.startAppCategoryActivity(TagView.this.getContext(), appCategory, i3);
                        }
                    });
                    addView(createTagView2);
                }
                i = i3;
            }
        }
    }

    private TextView createTagView(String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        int dp2px = ConvertUtils.dp2px(6.0f);
        int dp2px2 = ConvertUtils.dp2px(2.0f);
        textView.setPadding(dp2px, dp2px2, dp2px, dp2px2);
        if (!isInEditMode()) {
            textView.setTextColor(AppHolder.getAppTheme().getColorAccent());
        }
        return textView;
    }

    private Space createSpace() {
        Space space = new Space(getContext());
        space.setLayoutParams(new ViewGroup.MarginLayoutParams(ConvertUtils.dp2px(8.0f), -2));
        return space;
    }
}
