package com.coolapk.market.view.feedv8;

import android.text.Editable;
import android.widget.EditText;
import com.coolapk.market.widget.LazyTextWatcher;
import com.coolapk.market.widget.emotion.EmotionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/feedv8/NormalFeedContentHolder$onCreateContentView$4$2", "Lcom/coolapk/market/widget/LazyTextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NormalFeedContentHolder.kt */
public final class NormalFeedContentHolder$onCreateContentView$$inlined$apply$lambda$5 extends LazyTextWatcher {
    final /* synthetic */ NormalFeedContentHolder this$0;

    NormalFeedContentHolder$onCreateContentView$$inlined$apply$lambda$5(NormalFeedContentHolder normalFeedContentHolder) {
        this.this$0 = normalFeedContentHolder;
    }

    @Override // com.coolapk.market.widget.LazyTextWatcher, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "s");
        EditText editText = this.this$0.getBinding$presentation_coolapkAppRelease().editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        ArticleContentHelper.INSTANCE.checkEmotionCount(this.this$0.getActivity(), EmotionUtils.getEmotionCount(editText.getText().toString()));
        this.this$0.requestCheckSubmittable$presentation_coolapkAppRelease();
    }
}
