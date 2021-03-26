package com.coolapk.market.view.feed.pick;

import android.text.Editable;
import com.coolapk.market.widget.LazyTextWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/feed/pick/NodeRecommendPickerActivity$setupToolbar$4", "Lcom/coolapk/market/widget/LazyTextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeRecommendPickerActivity.kt */
public final class NodeRecommendPickerActivity$setupToolbar$4 extends LazyTextWatcher {
    final /* synthetic */ NodeRecommendPickerActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    NodeRecommendPickerActivity$setupToolbar$4(NodeRecommendPickerActivity nodeRecommendPickerActivity) {
        this.this$0 = nodeRecommendPickerActivity;
    }

    @Override // com.coolapk.market.widget.LazyTextWatcher, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "s");
        super.afterTextChanged(editable);
        this.this$0.subject.onNext(editable.toString());
    }
}
