package com.coolapk.market.view.sencondhand;

import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.coolapk.market.model.ProductParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/view/sencondhand/SelectParamsFragment$showDoneButton$1$2"}, k = 3, mv = {1, 4, 2})
/* compiled from: SelectParamsFragment.kt */
final class SelectParamsFragment$showDoneButton$$inlined$apply$lambda$2 implements View.OnClickListener {
    final /* synthetic */ FrameLayout $parentView$inlined;
    final /* synthetic */ SelectParamsFragment this$0;

    SelectParamsFragment$showDoneButton$$inlined$apply$lambda$2(SelectParamsFragment selectParamsFragment, FrameLayout frameLayout) {
        this.this$0 = selectParamsFragment;
        this.$parentView$inlined = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!this.this$0.paramsMap.isEmpty() && this.this$0.isDoneBtnClickable()) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            Set<Map.Entry> entrySet = this.this$0.paramsMap.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "paramsMap.entries");
            int i = 0;
            for (Map.Entry entry : entrySet) {
                if (TextUtils.equals((CharSequence) entry.getKey(), "extra")) {
                    sb.append("\"extra\":{\"value\":[");
                    Object value = entry.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "entries.value");
                    Iterator it2 = ((Iterable) value).iterator();
                    int i2 = 0;
                    while (it2.hasNext()) {
                        sb.append('\"' + ((ProductParams) it2.next()).getTitle() + '\"');
                        if (i2 < ((List) entry.getValue()).size() - 1) {
                            sb.append(",");
                        }
                        i2++;
                    }
                    sb.append("]}");
                    if (i < this.this$0.paramsMap.entrySet().size() - 1) {
                        sb.append(",");
                    }
                } else {
                    sb.append('\"' + ((String) entry.getKey()) + "\":{\"value\":\"" + ((ProductParams) ((List) entry.getValue()).get(0)).getTitle() + "\",\"other\":\"" + ((ProductParams) ((List) entry.getValue()).get(0)).getItemType() + "\"}");
                    if (i < this.this$0.paramsMap.entrySet().size() - 1) {
                        sb.append(",");
                    }
                }
                i++;
            }
            sb.append("}");
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Collection<List> values = this.this$0.paramsMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "paramsMap.values");
            for (List list : values) {
                arrayList.addAll(list);
            }
            ArrayList<? extends Parcelable> arrayList2 = arrayList;
            if (arrayList2.size() > 1) {
                CollectionsKt.sortWith(arrayList2, new Comparator<T>() {
                    /* class com.coolapk.market.view.sencondhand.SelectParamsFragment$showDoneButton$$inlined$apply$lambda$2.AnonymousClass1 */

                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(t.getKeyIndex()), Integer.valueOf(t2.getKeyIndex()));
                    }
                });
            }
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("paramsList", arrayList);
            intent.putExtra("json", sb.toString());
            this.this$0.requireActivity().setResult(-1, intent);
            this.this$0.requireActivity().finish();
        }
    }
}
