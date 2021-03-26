package com.coolapk.market.util;

import android.app.Activity;
import com.coolapk.market.view.user.UserProfileFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "com/coolapk/market/util/DialogUtil$showBottomSheetEditDialog$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: DialogUtil.kt */
final class DialogUtil$showBottomSheetEditDialog$$inlined$apply$lambda$1<T> implements Action1<String> {
    final /* synthetic */ Activity $activity$inlined;
    final /* synthetic */ Function1 $onDone$inlined;
    final /* synthetic */ UserProfileFragment.BottomEditTextDialog $this_apply;

    DialogUtil$showBottomSheetEditDialog$$inlined$apply$lambda$1(UserProfileFragment.BottomEditTextDialog bottomEditTextDialog, Function1 function1, Activity activity) {
        this.$this_apply = bottomEditTextDialog;
        this.$onDone$inlined = function1;
        this.$activity$inlined = activity;
    }

    public final void call(String str) {
        Function1 function1 = this.$onDone$inlined;
        Intrinsics.checkNotNullExpressionValue(str, "it");
        function1.invoke(str);
        this.$this_apply.dismiss();
    }
}
