package com.coolapk.market.view.live;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemLiveCardBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Live;
import com.coolapk.market.viewholder.BindingViewHolder;
import group.infotech.drawable.dsl.ShapesKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/live/LiveCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemLiveCardBinding;", "kotlin.jvm.PlatformType", "live", "Lcom/coolapk/market/model/Live;", "bindTo", "", "data", "", "createTagBackground", "Landroid/graphics/drawable/GradientDrawable;", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveCardViewHolder.kt */
public final class LiveCardViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558811;
    private final ItemLiveCardBinding binding;
    private Live live;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
        ItemLiveCardBinding itemLiveCardBinding = (ItemLiveCardBinding) getBinding();
        this.binding = itemLiveCardBinding;
        Intrinsics.checkNotNullExpressionValue(itemLiveCardBinding, "binding");
        itemLiveCardBinding.getRoot().setOnClickListener(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/live/LiveCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00df  */
    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        String str;
        String str2;
        Live live2;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Live");
        this.live = (Live) obj;
        ItemLiveCardBinding itemLiveCardBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemLiveCardBinding, "binding");
        Live live3 = this.live;
        if (live3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        itemLiveCardBinding.setLive(live3);
        this.binding.executePendingBindings();
        TextView textView = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        Live live4 = this.live;
        if (live4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        textView.setText(live4.getTitle());
        TextView textView2 = this.binding.statusView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.statusView");
        Live live5 = this.live;
        if (live5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        int liveStatus = live5.getLiveStatus();
        if (liveStatus != -1) {
            if (liveStatus != 0) {
                if (liveStatus != 1) {
                }
            }
        }
        textView2.setText(str);
        TextView textView3 = this.binding.numView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.numView");
        Live live6 = this.live;
        if (live6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        int liveStatus2 = live6.getLiveStatus();
        if (liveStatus2 != -1) {
            if (liveStatus2 == 0) {
                StringBuilder sb = new StringBuilder();
                Live live7 = this.live;
                if (live7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("live");
                }
                sb.append(live7.getFollowNumFormat());
                sb.append(" 人预约");
                str2 = sb.toString();
            } else if (liveStatus2 != 1) {
            }
            textView3.setText(str2);
            live2 = this.live;
            if (live2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("live");
            }
            if (TextUtils.isEmpty(live2.getPicUrl())) {
                this.binding.imageView.setImageBitmap(null);
            }
            TextView textView4 = this.binding.statusView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.statusView");
            textView4.setBackground(createTagBackground());
        }
        StringBuilder sb2 = new StringBuilder();
        Live live8 = this.live;
        if (live8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        sb2.append(live8.getVisitNumFormat());
        sb2.append(" 人气");
        str2 = sb2.toString();
        textView3.setText(str2);
        live2 = this.live;
        if (live2 == null) {
        }
        if (TextUtils.isEmpty(live2.getPicUrl())) {
        }
        TextView textView4 = this.binding.statusView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.statusView");
        textView4.setBackground(createTagBackground());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = getContext();
        Live live2 = this.live;
        if (live2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        ActionManager.startLiveActivity(context, live2.getId());
    }

    private final GradientDrawable createTagBackground() {
        int i;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        Live live2 = this.live;
        if (live2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        int liveStatus = live2.getLiveStatus();
        if (liveStatus == -1) {
            i = Color.parseColor("#BDBDBD");
        } else if (liveStatus == 0) {
            i = Color.parseColor("#2196F3");
        } else if (liveStatus != 1) {
            i = 0;
        } else {
            i = Color.parseColor("#0F9D58");
        }
        ShapesKt.setSolidColor(gradientDrawable, i);
        float dp = (float) NumberExtendsKt.getDp((Number) 2);
        gradientDrawable.setCornerRadii(new float[]{dp, dp, dp, dp, dp, dp, dp, dp});
        return gradientDrawable;
    }
}
