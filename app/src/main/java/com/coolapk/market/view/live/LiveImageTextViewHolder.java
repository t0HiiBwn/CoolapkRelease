package com.coolapk.market.view.live;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemLiveImageTextCardBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Live;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import com.coolapk.market.viewholder.BindingViewHolder;
import group.infotech.drawable.dsl.ShapesKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/live/LiveImageTextViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "comp", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityListPresenter;)V", "binding", "Lcom/coolapk/market/databinding/ItemLiveImageTextCardBinding;", "kotlin.jvm.PlatformType", "live", "Lcom/coolapk/market/model/Live;", "bindTo", "", "data", "", "createTagBackground", "Landroid/graphics/drawable/GradientDrawable;", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveImageTextViewHolder.kt */
public final class LiveImageTextViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558805;
    private final ItemLiveImageTextCardBinding binding;
    private Live live;
    private final EntityListPresenter presenter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveImageTextViewHolder(View view, DataBindingComponent dataBindingComponent, EntityListPresenter entityListPresenter) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "comp");
        Intrinsics.checkNotNullParameter(entityListPresenter, "presenter");
        this.presenter = entityListPresenter;
        ItemLiveImageTextCardBinding itemLiveImageTextCardBinding = (ItemLiveImageTextCardBinding) getBinding();
        this.binding = itemLiveImageTextCardBinding;
        Intrinsics.checkNotNullExpressionValue(itemLiveImageTextCardBinding, "binding");
        LiveImageTextViewHolder liveImageTextViewHolder = this;
        itemLiveImageTextCardBinding.getRoot().setOnClickListener(liveImageTextViewHolder);
        itemLiveImageTextCardBinding.actionButton.setOnClickListener(liveImageTextViewHolder);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/live/LiveImageTextViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveImageTextViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0197  */
    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        String str;
        String str2;
        Live live2;
        int liveStatus;
        int i;
        Live live3;
        int liveStatus2;
        String str3;
        Live live4;
        int i2;
        Live live5;
        int intExtraData;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Live");
        this.live = (Live) obj;
        ItemLiveImageTextCardBinding itemLiveImageTextCardBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemLiveImageTextCardBinding, "binding");
        Live live6 = this.live;
        if (live6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        itemLiveImageTextCardBinding.setLive(live6);
        this.binding.executePendingBindings();
        TextView textView = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        Live live7 = this.live;
        if (live7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        textView.setText(live7.getTitle());
        TextView textView2 = this.binding.statusView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.statusView");
        Live live8 = this.live;
        if (live8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        int liveStatus3 = live8.getLiveStatus();
        if (liveStatus3 != -1) {
            if (liveStatus3 != 0) {
                if (liveStatus3 != 1) {
                }
            }
        }
        textView2.setText(str);
        TextView textView3 = this.binding.numView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.numView");
        Live live9 = this.live;
        if (live9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        int liveStatus4 = live9.getLiveStatus();
        if (liveStatus4 != -1) {
            if (liveStatus4 == 0) {
                StringBuilder sb = new StringBuilder();
                Live live10 = this.live;
                if (live10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("live");
                }
                sb.append(live10.getFollowNumFormat());
                sb.append(" 人预约");
                str2 = sb.toString();
            } else if (liveStatus4 != 1) {
            }
            textView3.setText(str2);
            TextView textView4 = this.binding.statusView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.statusView");
            textView4.setBackground(createTagBackground());
            TextView textView5 = this.binding.actionButton;
            live2 = this.live;
            if (live2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("live");
            }
            liveStatus = live2.getLiveStatus();
            int i3 = 0;
            if (liveStatus != -1) {
                i = 2131231721;
            } else if (liveStatus != 0) {
                i = liveStatus != 1 ? 0 : 2131231724;
            } else {
                Live live11 = this.live;
                if (live11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("live");
                }
                i = live11.isFollow() ? 2131231722 : 2131231723;
            }
            textView5.setBackgroundResource(i);
            TextView textView6 = this.binding.actionButton;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.actionButton");
            live3 = this.live;
            if (live3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("live");
            }
            liveStatus2 = live3.getLiveStatus();
            if (liveStatus2 == -1) {
                if (liveStatus2 != 0) {
                    str3 = liveStatus2 != 1 ? "" : "看直播";
                } else {
                    Live live12 = this.live;
                    if (live12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("live");
                    }
                    str3 = live12.isFollow() ? "已预约" : "预约";
                }
            }
            textView6.setText(str3);
            TextView textView7 = this.binding.actionButton;
            live4 = this.live;
            if (live4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("live");
            }
            String str4 = "#FFFFFF";
            if (live4.getLiveStatus() == 0) {
                i2 = Color.parseColor(str4);
            } else {
                Live live13 = this.live;
                if (live13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("live");
                }
                if (live13.isFollow()) {
                    str4 = "#757575";
                }
                i2 = Color.parseColor(str4);
            }
            textView7.setTextColor(i2);
            live5 = this.live;
            if (live5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("live");
            }
            intExtraData = EntityExtendsKt.getIntExtraData(live5, "cols", 1);
            TextView textView8 = this.binding.actionButton;
            Intrinsics.checkNotNullExpressionValue(textView8, "binding.actionButton");
            if (intExtraData != 1) {
                i3 = 8;
            }
            textView8.setVisibility(i3);
        }
        StringBuilder sb2 = new StringBuilder();
        Live live14 = this.live;
        if (live14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        sb2.append(live14.getVisitNumFormat());
        sb2.append(" 人气");
        str2 = sb2.toString();
        textView3.setText(str2);
        TextView textView4 = this.binding.statusView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.statusView");
        textView4.setBackground(createTagBackground());
        TextView textView5 = this.binding.actionButton;
        live2 = this.live;
        if (live2 == null) {
        }
        liveStatus = live2.getLiveStatus();
        int i3 = 0;
        if (liveStatus != -1) {
        }
        textView5.setBackgroundResource(i);
        TextView textView6 = this.binding.actionButton;
        Intrinsics.checkNotNullExpressionValue(textView6, "binding.actionButton");
        live3 = this.live;
        if (live3 == null) {
        }
        liveStatus2 = live3.getLiveStatus();
        if (liveStatus2 == -1) {
        }
        textView6.setText(str3);
        TextView textView7 = this.binding.actionButton;
        live4 = this.live;
        if (live4 == null) {
        }
        String str4 = "#FFFFFF";
        if (live4.getLiveStatus() == 0) {
        }
        textView7.setTextColor(i2);
        live5 = this.live;
        if (live5 == null) {
        }
        intExtraData = EntityExtendsKt.getIntExtraData(live5, "cols", 1);
        TextView textView8 = this.binding.actionButton;
        Intrinsics.checkNotNullExpressionValue(textView8, "binding.actionButton");
        if (intExtraData != 1) {
        }
        textView8.setVisibility(i3);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131361876) {
            Context context = getContext();
            Live live2 = this.live;
            if (live2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("live");
            }
            ActionManager.startLiveActivity(context, live2.getId());
            return;
        }
        Live live3 = this.live;
        if (live3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        int liveStatus = live3.getLiveStatus();
        if (liveStatus != -1) {
            if (liveStatus == 0) {
                Live live4 = this.live;
                if (live4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("live");
                }
                boolean isFollow = live4.isFollow();
                EntityListPresenter entityListPresenter = this.presenter;
                Live live5 = this.live;
                if (live5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("live");
                }
                String id = live5.getId();
                Intrinsics.checkNotNull(id);
                Intrinsics.checkNotNullExpressionValue(id, "live.id!!");
                entityListPresenter.followLive(id, !isFollow);
                return;
            } else if (liveStatus != 1) {
                return;
            }
        }
        Context context2 = getContext();
        Live live6 = this.live;
        if (live6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("live");
        }
        ActionManager.startLiveActivity(context2, live6.getId());
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
            i = Color.parseColor("#F44336");
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
