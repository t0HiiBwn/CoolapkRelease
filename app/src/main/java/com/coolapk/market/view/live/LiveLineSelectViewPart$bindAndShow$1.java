package com.coolapk.market.view.live;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r*\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"com/coolapk/market/view/live/LiveLineSelectViewPart$bindAndShow$1", "Landroid/widget/ArrayAdapter;", "", "createTextView", "Landroid/widget/TextView;", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "populateView", "", "title", "selected", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveLineSelectViewPart.kt */
public final class LiveLineSelectViewPart$bindAndShow$1 extends ArrayAdapter<String> {
    final /* synthetic */ String $activeKey;
    final /* synthetic */ Function1 $clickListener;
    final /* synthetic */ List $keys;
    final /* synthetic */ LiveLineSelectViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveLineSelectViewPart$bindAndShow$1(LiveLineSelectViewPart liveLineSelectViewPart, String str, Function1 function1, List list, Context context, int i, List list2) {
        super(context, i, list2);
        this.this$0 = liveLineSelectViewPart;
        this.$activeKey = str;
        this.$clickListener = function1;
        this.$keys = list;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (view == null) {
            textView = createTextView();
        } else {
            textView = (TextView) view;
        }
        Object item = getItem(i);
        Intrinsics.checkNotNull(item);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)!!");
        String str = (String) item;
        populateView(textView, str, Intrinsics.areEqual(str, this.$activeKey));
        textView.setOnClickListener(new LiveLineSelectViewPart$bindAndShow$1$getView$1(this, str));
        return textView;
    }

    private final void populateView(TextView textView, String str, boolean z) {
        int i;
        if (z) {
            i = AppHolder.getAppTheme().getColorAccent();
        } else {
            i = ResourceUtils.resolveData(textView.getContext(), 2130968793);
        }
        Context context = textView.getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(NumberExtendsKt.getDp((Number) 1), i);
        gradientDrawable.setCornerRadius(((float) textView.getMinHeight()) / ((float) 2));
        Unit unit = Unit.INSTANCE;
        textView.setBackground(ShapeUtils.createSelectableItemBackgroundWith(context, gradientDrawable));
        textView.setText(str);
        textView.setTextColor(i);
    }

    private final TextView createTextView() {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setMinWidth(NumberExtendsKt.getDp((Number) 84));
        textView.setMaxWidth(NumberExtendsKt.getDp((Number) 84));
        textView.setMinHeight(NumberExtendsKt.getDp((Number) 34));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        ViewExtendsKt.clipView$default(textView, 2, 0.0f, 2, null);
        return textView;
    }
}
