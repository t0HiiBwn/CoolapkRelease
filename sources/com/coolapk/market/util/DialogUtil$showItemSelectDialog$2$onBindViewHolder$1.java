package com.coolapk.market.util;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.event.PageChangeEvent;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: DialogUtil.kt */
final class DialogUtil$showItemSelectDialog$2$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ DialogUtil.DialogItemData $data;
    final /* synthetic */ int $position;
    final /* synthetic */ DialogUtil$showItemSelectDialog$2 this$0;

    DialogUtil$showItemSelectDialog$2$onBindViewHolder$1(DialogUtil$showItemSelectDialog$2 dialogUtil$showItemSelectDialog$2, DialogUtil.DialogItemData dialogItemData, int i) {
        this.this$0 = dialogUtil$showItemSelectDialog$2;
        this.$data = dialogItemData;
        this.$position = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object obj;
        Ref.ObjectRef objectRef = this.this$0.$mutableData;
        T<DialogUtil.DialogItemData> t = this.this$0.$mutableData.element;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(t, 10));
        for (DialogUtil.DialogItemData dialogItemData : t) {
            arrayList.add(DialogUtil.DialogItemData.copy$default(dialogItemData, null, null, null, Boolean.valueOf(Intrinsics.areEqual(dialogItemData.getType(), this.$data.getType())), 7, null));
        }
        objectRef.element = (T) CollectionsKt.toMutableList((Collection) arrayList);
        Activity activity = this.this$0.$activity;
        Toast.show$default(activity, "已将 " + ((DialogUtil.DialogItemData) this.this$0.$mutableData.element.get(this.$position)).getTitle() + " 设为默认发现页", 0, false, 12, null);
        EventBus.getDefault().post(new PageChangeEvent(this.$position));
        RecyclerView.Adapter adapter = this.this$0.$recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        if (!this.this$0.$showConfirm) {
            this.this$0.$dialog.dismiss();
            Iterator it2 = this.this$0.$mutableData.element.iterator();
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
            DialogUtil.DialogItemData dialogItemData2 = (DialogUtil.DialogItemData) obj;
            if (dialogItemData2 != null) {
                this.this$0.$onItemCheck.invoke(dialogItemData2);
            }
        }
    }
}
