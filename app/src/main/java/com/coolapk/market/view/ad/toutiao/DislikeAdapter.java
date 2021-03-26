package com.coolapk.market.view.ad.toutiao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/ad/toutiao/DislikeAdapter;", "Landroid/widget/BaseAdapter;", "list", "", "Lcom/bytedance/sdk/openadsdk/FilterWord;", "(Ljava/util/List;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DislikeDialog.kt */
final class DislikeAdapter extends BaseAdapter {
    private final List<FilterWord> list;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (long) i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.bytedance.sdk.openadsdk.FilterWord> */
    /* JADX WARN: Multi-variable type inference failed */
    public DislikeAdapter(List<? extends FilterWord> list2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        this.list = list2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        DislikeViewHolder dislikeViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(2131558542, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(view, "LayoutInflater.from(pare…alog_item, parent, false)");
            View findViewById = view.findViewById(2131363533);
            Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.text_view)");
            dislikeViewHolder = new DislikeViewHolder((TextView) findViewById);
            view.setTag(dislikeViewHolder);
        } else {
            Object tag = view.getTag();
            if (!(tag instanceof DislikeViewHolder)) {
                tag = null;
            }
            dislikeViewHolder = (DislikeViewHolder) tag;
            Intrinsics.checkNotNull(dislikeViewHolder);
        }
        Object item = getItem(i);
        Objects.requireNonNull(item, "null cannot be cast to non-null type com.bytedance.sdk.openadsdk.FilterWord");
        dislikeViewHolder.getTextView().setText(((FilterWord) item).getName());
        return view;
    }
}
