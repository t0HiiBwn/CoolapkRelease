package com.coolapk.market.viewholder;

import android.widget.RadioGroup;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "group", "Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "checkedId", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: AskFilterViewHolder.kt */
final class AskFilterViewHolder$onChecked$1 implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ AskFilterViewHolder this$0;

    AskFilterViewHolder$onChecked$1(AskFilterViewHolder askFilterViewHolder) {
        this.this$0 = askFilterViewHolder;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        this.this$0.getViewModel().setAskFeedType(i != 2131362538 ? i != 2131362544 ? "all" : "question" : "answer");
    }
}
