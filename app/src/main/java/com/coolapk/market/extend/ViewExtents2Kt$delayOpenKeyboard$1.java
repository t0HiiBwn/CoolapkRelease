package com.coolapk.market.extend;

import android.app.Activity;
import android.widget.EditText;
import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ViewExtents2.kt */
final class ViewExtents2Kt$delayOpenKeyboard$1 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ EditText $this_delayOpenKeyboard;

    ViewExtents2Kt$delayOpenKeyboard$1(EditText editText, Activity activity) {
        this.$this_delayOpenKeyboard = editText;
        this.$activity = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity = this.$activity;
        if (activity == null || !activity.isFinishing()) {
            UiUtils.openKeyboard(this.$this_delayOpenKeyboard);
        }
    }
}
