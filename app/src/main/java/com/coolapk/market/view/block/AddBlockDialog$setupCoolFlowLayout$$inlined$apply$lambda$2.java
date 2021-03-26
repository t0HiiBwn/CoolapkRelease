package com.coolapk.market.view.block;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.FeedBlockItemsBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/block/AddBlockDialog$setupCoolFlowLayout$6$2", "Landroid/widget/ArrayAdapter;", "Lcom/coolapk/market/view/block/BlockItem;", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddBlockDialog.kt */
public final class AddBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$2 extends ArrayAdapter<BlockItem> {
    final /* synthetic */ Activity $activity$inlined;
    final /* synthetic */ List $blockItemList$inlined;
    final /* synthetic */ AddBlockDialog$setupCoolFlowLayout$5 $syncOKButtonUI$5$inlined;
    final /* synthetic */ AddBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$1 $toggleState$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$2(AddBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$1 addBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$1, Context context, int i, List list, List list2, AddBlockDialog$setupCoolFlowLayout$5 addBlockDialog$setupCoolFlowLayout$5, Activity activity) {
        super(context, i, list);
        this.$toggleState$1 = addBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$1;
        this.$blockItemList$inlined = list2;
        this.$syncOKButtonUI$5$inlined = addBlockDialog$setupCoolFlowLayout$5;
        this.$activity$inlined = activity;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        FeedBlockItemsBinding feedBlockItemsBinding;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Object item = getItem(i);
        Intrinsics.checkNotNull(item);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)!!");
        BlockItem blockItem = (BlockItem) item;
        if (view != null) {
            Object tag = view.getTag(2131363492);
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.databinding.FeedBlockItemsBinding");
            feedBlockItemsBinding = (FeedBlockItemsBinding) tag;
        } else {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getContext()), 2131558554, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ock_items, parent, false)");
            feedBlockItemsBinding = (FeedBlockItemsBinding) inflate;
        }
        feedBlockItemsBinding.getRoot().setTag(2131363492, feedBlockItemsBinding);
        if (blockItem.getActive()) {
            View root = feedBlockItemsBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "childBinding.root");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setColor(AppHolder.getAppTheme().getColorAccent());
            gradientDrawable.setCornerRadius(NumberExtendsKt.getDpf((Number) 4));
            Unit unit = Unit.INSTANCE;
            root.setBackground(gradientDrawable);
            feedBlockItemsBinding.textView.setTextColor(-1);
        } else {
            View root2 = feedBlockItemsBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "childBinding.root");
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setGradientType(0);
            gradientDrawable2.setColor(AppHolder.getAppTheme().getMainBackgroundColor());
            gradientDrawable2.setCornerRadius(NumberExtendsKt.getDpf((Number) 4));
            Unit unit2 = Unit.INSTANCE;
            root2.setBackground(gradientDrawable2);
            feedBlockItemsBinding.textView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        }
        TextView textView = feedBlockItemsBinding.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "childBinding.textView");
        textView.setText(blockItem.getTitle());
        feedBlockItemsBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.view.block.AddBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$2.AnonymousClass1 */
            final /* synthetic */ AddBlockDialog$setupCoolFlowLayout$$inlined$apply$lambda$2 this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.$toggleState$1.invoke(i);
            }
        });
        View root3 = feedBlockItemsBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "childBinding.root");
        return root3;
    }
}
