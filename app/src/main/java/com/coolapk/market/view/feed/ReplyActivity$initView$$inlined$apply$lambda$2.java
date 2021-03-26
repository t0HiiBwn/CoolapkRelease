package com.coolapk.market.view.feed;

import android.text.Editable;
import android.widget.EditText;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.feedv8.ArticleContentHelper;
import com.coolapk.market.widget.LazyTextWatcher;
import com.coolapk.market.widget.emotion.EmotionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/feed/ReplyActivity$initView$2$2", "Lcom/coolapk/market/widget/LazyTextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReplyActivity.kt */
public final class ReplyActivity$initView$$inlined$apply$lambda$2 extends LazyTextWatcher {
    final /* synthetic */ ReplyActivity this$0;

    ReplyActivity$initView$$inlined$apply$lambda$2(ReplyActivity replyActivity) {
        this.this$0 = replyActivity;
    }

    @Override // com.coolapk.market.widget.LazyTextWatcher, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        super.afterTextChanged(editable);
        this.this$0.checkPostButtonState();
        EditText editText = ReplyActivity.access$getBinding$p(this.this$0).editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        int emotionCount = EmotionUtils.getEmotionCount(editText.getText().toString());
        ArticleContentHelper articleContentHelper = ArticleContentHelper.INSTANCE;
        BaseActivity activity = this.this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        articleContentHelper.checkEmotionCount(activity, emotionCount);
    }
}
