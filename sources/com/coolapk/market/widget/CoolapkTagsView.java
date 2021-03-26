package com.coolapk.market.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.google.android.flexbox.FlexboxLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\u0006\u0010\u0013\u001a\u00020\u000eJ\u0014\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u0019\u001a\u00020\u000eH\u0002J\u0016\u0010\u001a\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/widget/CoolapkTagsView;", "Lcom/google/android/flexbox/FlexboxLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onTagClickListener", "Lcom/coolapk/market/widget/CoolapkTagsView$OnTagClickListener;", "addViewOrHide", "", "count", "createTagView", "Landroid/widget/TextView;", "getTextColor", "init", "setKeywords", "keywords", "", "", "setOnTagClickListener", "setTagClickListener", "setTagsText", "OnTagClickListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolapkTagsView.kt */
public final class CoolapkTagsView extends FlexboxLayout {
    private OnTagClickListener onTagClickListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/coolapk/market/widget/CoolapkTagsView$OnTagClickListener;", "", "onTagClick", "", "view", "Landroid/view/View;", "position", "", "keyword", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CoolapkTagsView.kt */
    public interface OnTagClickListener {
        void onTagClick(View view, int i, String str);
    }

    public CoolapkTagsView(Context context) {
        super(context);
        init();
    }

    public CoolapkTagsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CoolapkTagsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void init() {
        setFlexDirection(0);
        setFlexWrap(1);
        setJustifyContent(3);
    }

    public final void setKeywords(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "keywords");
        addViewOrHide(list.size());
        setTagsText(list);
        setTagClickListener();
    }

    private final void setTagClickListener() {
        int i = 0;
        for (View view : ViewGroupKt.getChildren(this)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view2 = view;
            view2.setOnClickListener(new CoolapkTagsView$setTagClickListener$$inlined$forEachIndexed$lambda$1(i, view2, this));
            i = i2;
        }
    }

    private final void addViewOrHide(int i) {
        int childCount = i - getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                addView(createTagView());
            }
        }
        int i3 = 0;
        for (View view : ViewGroupKt.getChildren(this)) {
            view.setVisibility(i3 < i ? 0 : 8);
            i3++;
        }
    }

    private final TextView createTagView() {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setMinWidth(NumberExtendsKt.getDp((Number) 48));
        textView.setBackground(ResourceUtils.getDrawable(getContext(), 2131231727));
        UiUtils.setDrawableSolidColors(textView.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorAccent());
        textView.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        textView.setPadding(NumberExtendsKt.getDp((Number) 10), 0, NumberExtendsKt.getDp((Number) 10), 0);
        return textView;
    }

    private final void setTagsText(List<String> list) {
        int i = 0;
        for (View view : ViewGroupKt.getChildren(this)) {
            if (view instanceof TextView) {
                String str = list.get(i);
                List split$default = StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null);
                TextView textView = (TextView) view;
                textView.setTag(str);
                textView.setTextColor(getTextColor());
                if (split$default.size() == 3) {
                    String str2 = (String) split$default.get(2);
                    String str3 = (String) split$default.get(1);
                    if (TextUtils.equals((String) split$default.get(0), "hot")) {
                        textView.setTextColor(ResourceUtils.getColorInt(getContext(), 2131100040));
                    }
                    textView.setTag(str2);
                    str = str3;
                }
                textView.setText(str);
            }
            i++;
        }
    }

    private final int getTextColor() {
        if (AppHolder.getAppTheme().isDarkTheme()) {
            return AppHolder.getAppTheme().getTextColorPrimary();
        }
        return -1;
    }

    public final void setOnTagClickListener(OnTagClickListener onTagClickListener2) {
        Intrinsics.checkNotNullParameter(onTagClickListener2, "onTagClickListener");
        this.onTagClickListener = onTagClickListener2;
    }
}
