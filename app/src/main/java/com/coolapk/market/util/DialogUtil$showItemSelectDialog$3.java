package com.coolapk.market.util;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.coolapk.market.util.DialogUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: DialogUtil.kt */
final class DialogUtil$showItemSelectDialog$3 implements View.OnClickListener {
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ Ref.ObjectRef $mutableData;
    final /* synthetic */ Function1 $onItemCheck;

    DialogUtil$showItemSelectDialog$3(AlertDialog alertDialog, Ref.ObjectRef objectRef, Function1 function1) {
        this.$dialog = alertDialog;
        this.$mutableData = objectRef;
        this.$onItemCheck = function1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object obj;
        this.$dialog.dismiss();
        Iterator it2 = this.$mutableData.element.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (Intrinsics.areEqual((Object) ((DialogUtil.DialogItemData) obj).isChecked(), (Object) true)) {
                break;
            }
        }
        DialogUtil.DialogItemData dialogItemData = (DialogUtil.DialogItemData) obj;
        if (dialogItemData != null) {
            this.$onItemCheck.invoke(dialogItemData);
        }
    }
}
