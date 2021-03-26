package com.coolapk.market.view.feedv8;

import android.content.Context;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleContentHelper;", "", "()V", "checkEmotionCount", "", "context", "Landroid/content/Context;", "inputTextCount", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleContentHelper.kt */
public final class ArticleContentHelper {
    public static final ArticleContentHelper INSTANCE = new ArticleContentHelper();

    private ArticleContentHelper() {
    }

    public final boolean checkEmotionCount(Context context, int i) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        if (i > 100) {
            str = "已超过表情上限" + (i - 100) + (char) 20010;
        } else if (i == 100) {
            str = "已达到表情上限";
        } else if (i == 80) {
            str = "还可以添加" + (100 - i) + "个表情";
        } else if (i == 90) {
            str = "还可以添加" + (100 - i) + "个表情";
        } else if (i >= 95) {
            str = "还可以添加" + (100 - i) + "个表情";
        } else {
            str = "";
        }
        String str2 = str;
        if (str2.length() > 0) {
            Toast.show$default(context, str, 0, false, 12, null);
        }
        if (str2.length() > 0) {
            return true;
        }
        return false;
    }
}
