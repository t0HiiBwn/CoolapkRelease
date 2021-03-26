package com.coolapk.market.view.feedv8;

import android.content.res.ColorStateList;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bJ&\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bJ&\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/feedv8/RatingContentHelper;", "", "()V", "DESCRIPTIONS", "", "", "[Ljava/lang/String;", "SCORE_TINT_COLORS", "", "getSCORE_TINT_COLORS", "()[Ljava/lang/Integer;", "[Ljava/lang/Integer;", "setRatingBarBackgroundGreyColor", "", "ratingBar", "Landroid/widget/RatingBar;", "setRatingBarTintColor", "score", "setRatingUI", "scoreTextView", "Landroid/widget/TextView;", "targetType", "setTextViewHint", "advantage", "Landroid/widget/EditText;", "disadvantage", "summary", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RatingContentHelper.kt */
public final class RatingContentHelper {
    private static final String[] DESCRIPTIONS = {"请打分", "差劲", "一般", "还行", "推荐", "吹爆"};
    public static final RatingContentHelper INSTANCE = new RatingContentHelper();
    private static final Integer[] SCORE_TINT_COLORS = {Integer.valueOf((int) 4292335575L), Integer.valueOf((int) 4294198070L), Integer.valueOf((int) 4294930499L), Integer.valueOf((int) 4294278144L), Integer.valueOf((int) 4294951175L), Integer.valueOf((int) 4294948626L)};

    private RatingContentHelper() {
    }

    public final Integer[] getSCORE_TINT_COLORS() {
        return SCORE_TINT_COLORS;
    }

    public final void setRatingUI(RatingBar ratingBar, TextView textView, String str, int i) {
        Intrinsics.checkNotNullParameter(ratingBar, "ratingBar");
        Intrinsics.checkNotNullParameter(textView, "scoreTextView");
        Intrinsics.checkNotNullParameter(str, "targetType");
        textView.setText(DESCRIPTIONS[i]);
        Integer[] numArr = SCORE_TINT_COLORS;
        ratingBar.setProgressTintList(ColorStateList.valueOf(numArr[i].intValue()));
        if (i == 0) {
            textView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        } else {
            textView.setTextColor(numArr[i].intValue());
        }
    }

    public final void setRatingBarTintColor(RatingBar ratingBar, int i) {
        Intrinsics.checkNotNullParameter(ratingBar, "ratingBar");
        Integer[] numArr = SCORE_TINT_COLORS;
        ratingBar.setProgressTintList(ColorStateList.valueOf(numArr[i].intValue()));
        ratingBar.setIndeterminateTintList(ColorStateList.valueOf(numArr[i].intValue()));
        ratingBar.setSecondaryProgressTintList(ColorStateList.valueOf(numArr[i].intValue()));
        ratingBar.setProgressBackgroundTintList(ColorStateList.valueOf(numArr[i].intValue()));
    }

    public final void setRatingBarBackgroundGreyColor(RatingBar ratingBar) {
        Intrinsics.checkNotNullParameter(ratingBar, "ratingBar");
        ratingBar.setProgressBackgroundTintList(ColorStateList.valueOf((int) 4292335575L));
    }

    public final void setTextViewHint(EditText editText, EditText editText2, EditText editText3, String str) {
        Intrinsics.checkNotNullParameter(editText, "advantage");
        Intrinsics.checkNotNullParameter(editText2, "disadvantage");
        Intrinsics.checkNotNullParameter(editText3, "summary");
        Intrinsics.checkNotNullParameter(str, "targetType");
        int hashCode = str.hashCode();
        if (hashCode != 96796) {
            if (hashCode == 1382923806 && str.equals("product_phone")) {
                editText.setHint("说说该产品你最满意的地方");
                editText2.setHint("说说你认为该产品的不足和缺陷");
                editText3.setHint("值不值得买，说说你的理由");
            }
        } else if (str.equals("apk")) {
            editText.setHint("说说这个应用你最满意的地方");
            editText2.setHint("说说你认为这个应用的缺陷和不足");
            editText3.setHint("总结评价一下这个应用吧");
        }
    }
}
