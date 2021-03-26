package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.util.ResourceUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0002J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/feedv8/VoteCommentContentHolder;", "Lcom/coolapk/market/view/feedv8/NormalFeedContentHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "insertAnonymousHint", "", "layout", "Landroid/widget/FrameLayout;", "insertRelativeView", "Landroid/widget/LinearLayout;", "onCreateContentView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "onCreateContentView$presentation_coolapkAppRelease", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteCommentContentHolder.kt */
public final class VoteCommentContentHolder extends NormalFeedContentHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoteCommentContentHolder(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.coolapk.market.view.feedv8.NormalFeedContentHolder, com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View onCreateContentView$presentation_coolapkAppRelease(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        super.onCreateContentView$presentation_coolapkAppRelease(layoutInflater);
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(getBinding$presentation_coolapkAppRelease().getRoot());
        LinearLayout linearLayout = getBinding$presentation_coolapkAppRelease().relativeView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.relativeView");
        insertRelativeView(linearLayout);
        if (getMultiPart().isAnonymous()) {
            insertAnonymousHint(frameLayout);
        }
        return frameLayout;
    }

    private final void insertRelativeView(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        FeedUIConfig uiConfig = getUiConfig();
        String relativeTitle = uiConfig.relativeTitle();
        Intrinsics.checkNotNullExpressionValue(relativeTitle, "uiConfig.relativeTitle()");
        if (relativeTitle.length() > 0) {
            TextView textView = new TextView(getActivity());
            textView.setPadding(NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 12));
            textView.setBackgroundColor(ResourceUtils.resolveData(textView.getContext(), 2130968793));
            textView.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
            textView.setLineSpacing(0.0f, 1.2f);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            textView.setMaxLines(2);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setGravity(16);
            textView.setText(uiConfig.relativeTitle());
            linearLayout.addView(textView);
        }
    }

    private final void insertAnonymousHint(FrameLayout frameLayout) {
        int colorInt = ResourceUtils.getColorInt(getActivity(), 2131100035);
        Drawable drawable = ResourceUtils.getDrawable(getActivity(), 2131230844);
        Intrinsics.checkNotNullExpressionValue(drawable, "ResourceUtils.getDrawabl…aseline_error_outline_24)");
        Drawable tintColor = ViewExtendsKt.tintColor(drawable, colorInt);
        tintColor.setBounds(0, 0, NumberExtendsKt.getDp((Number) 18), NumberExtendsKt.getDp((Number) 18));
        TextView textView = new TextView(getActivity());
        textView.setPadding(NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 6), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 6));
        textView.setBackgroundColor((int) 4294896875L);
        textView.setTextColor(colorInt);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        Unit unit = Unit.INSTANCE;
        textView.setLayoutParams(layoutParams);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        textView.setText("匿名投票观点不会显示你的真实身份");
        textView.setCompoundDrawables(tintColor, null, null, null);
        textView.setCompoundDrawablePadding(NumberExtendsKt.getDp((Number) 4));
        frameLayout.addView(textView);
    }
}
