package com.coolapk.market.view.node;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.TopicNodeHeaderLineBinding;
import com.coolapk.market.model.NewHeadLine;
import com.coolapk.market.util.ColorUtil2;
import com.coolapk.market.widget.LinearAdapterLayout;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/node/NodeHelper$setupRecommendRows$1", "Landroid/widget/ArrayAdapter;", "Lcom/coolapk/market/model/NewHeadLine;", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeHelper.kt */
public final class NodeHelper$setupRecommendRows$1 extends ArrayAdapter<NewHeadLine> {
    final /* synthetic */ LinearAdapterLayout $linearView;
    final /* synthetic */ List $rows;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NodeHelper$setupRecommendRows$1(LinearAdapterLayout linearAdapterLayout, List list, Context context, int i, List list2) {
        super(context, i, list2);
        this.$linearView = linearAdapterLayout;
        this.$rows = list;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TopicNodeHeaderLineBinding topicNodeHeaderLineBinding;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        int i2 = 0;
        if (view != null) {
            Object tag = view.getTag(2131363510);
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.databinding.TopicNodeHeaderLineBinding");
            topicNodeHeaderLineBinding = (TopicNodeHeaderLineBinding) tag;
        } else {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getContext()), 2131559211, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ader_line, parent, false)");
            topicNodeHeaderLineBinding = (TopicNodeHeaderLineBinding) inflate;
        }
        topicNodeHeaderLineBinding.itemView.setTag(2131363510, topicNodeHeaderLineBinding.getRoot());
        Object item = getItem(i);
        Intrinsics.checkNotNull(item);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)!!");
        NewHeadLine newHeadLine = (NewHeadLine) item;
        TextView textView = topicNodeHeaderLineBinding.descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView, "childBinding.descriptionView");
        textView.setText(newHeadLine.getTitle());
        TextView textView2 = topicNodeHeaderLineBinding.textView;
        Intrinsics.checkNotNullExpressionValue(textView2, "childBinding.textView");
        textView2.setText(newHeadLine.getEntityTypeName());
        topicNodeHeaderLineBinding.itemView.setOnClickListener(new NodeHelper$setupRecommendRows$1$getView$1(this, newHeadLine));
        topicNodeHeaderLineBinding.executePendingBindings();
        topicNodeHeaderLineBinding.textView.setTextColor(ColorUtil2.INSTANCE.getLightenColor(AppHolder.getAppTheme().getColorAccent(), 0.2f));
        String url = newHeadLine.getUrl();
        boolean z = !(url == null || url.length() == 0);
        ImageView imageView = topicNodeHeaderLineBinding.imageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "childBinding.imageView");
        ImageView imageView2 = imageView;
        if (!z) {
            i2 = 8;
        }
        imageView2.setVisibility(i2);
        LinearLayout linearLayout = topicNodeHeaderLineBinding.itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "childBinding.itemView");
        linearLayout.setClickable(z);
        LinearLayout linearLayout2 = topicNodeHeaderLineBinding.itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "childBinding.itemView");
        return linearLayout2;
    }
}
