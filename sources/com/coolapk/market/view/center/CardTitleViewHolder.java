package com.coolapk.market.view.center;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemCardManagerBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.CardTitleItem;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.touchhelper.ItemTouchHelperViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0002\u001a\u001bB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/center/CardTitleViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "Lcom/coolapk/market/widget/touchhelper/ItemTouchHelperViewHolder;", "itemView", "Landroid/view/View;", "callBack", "Lcom/coolapk/market/view/center/TouchCallBack;", "(Landroid/view/View;Lcom/coolapk/market/view/center/TouchCallBack;)V", "binding", "Lcom/coolapk/market/databinding/ItemCardManagerBinding;", "kotlin.jvm.PlatformType", "getCallBack", "()Lcom/coolapk/market/view/center/TouchCallBack;", "bindTo", "", "data", "", "itemAddOrLess", "isAdd", "", "onClick", "view", "onItemClear", "position", "", "onItemSelected", "Companion", "ItemTouch", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardTitleViewHolder.kt */
public final class CardTitleViewHolder extends BindingViewHolder implements ItemTouchHelperViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558632;
    private final ItemCardManagerBinding binding = ((ItemCardManagerBinding) getBinding());
    private final TouchCallBack callBack;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardTitleViewHolder(View view, TouchCallBack touchCallBack) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(touchCallBack, "callBack");
        this.callBack = touchCallBack;
    }

    public final TouchCallBack getCallBack() {
        return this.callBack;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/CardTitleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CardTitleViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.CardTitleItem");
        CardTitleItem cardTitleItem = (CardTitleItem) obj;
        TextView textView = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(cardTitleItem.getTitle());
        ItemCardManagerBinding itemCardManagerBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemCardManagerBinding, "binding");
        itemCardManagerBinding.setClick(this);
        boolean z = true;
        int i = 0;
        if (cardTitleItem.getPageVisibility() != 1) {
            z = false;
        }
        ImageView imageView = this.binding.lessView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.lessView");
        imageView.setVisibility(z ? 0 : 8);
        ImageView imageView2 = this.binding.addView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.addView");
        if (z) {
            i = 8;
        }
        imageView2.setVisibility(i);
        this.binding.dragView.setOnTouchListener(new ItemTouch(this, this));
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if ((valueOf != null && valueOf.intValue() == 2131362838) || (valueOf != null && valueOf.intValue() == 2131362003)) {
            this.callBack.upTouch(view, this);
        }
    }

    @Override // com.coolapk.market.widget.touchhelper.ItemTouchHelperViewHolder
    public void onItemSelected() {
        this.binding.itemView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        this.binding.itemView.animate().scaleX(1.1f).scaleY(1.1f).z((float) NumberExtendsKt.getDp((Number) 8)).setListener(null).start();
    }

    public final void itemAddOrLess(boolean z) {
        ImageView imageView = this.binding.lessView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.lessView");
        int i = 8;
        imageView.setVisibility(z ? 0 : 8);
        ImageView imageView2 = this.binding.addView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.addView");
        if (!z) {
            i = 0;
        }
        imageView2.setVisibility(i);
    }

    @Override // com.coolapk.market.widget.touchhelper.ItemTouchHelperViewHolder
    public void onItemClear(int i) {
        this.callBack.findPosition(i, this);
        this.binding.itemView.animate().scaleX(1.0f).scaleY(1.0f).z((float) NumberExtendsKt.getDp((Number) 0)).setListener(new CardTitleViewHolder$onItemClear$1(this)).start();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/center/CardTitleViewHolder$ItemTouch;", "Landroid/view/View$OnTouchListener;", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/coolapk/market/view/center/CardTitleViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CardTitleViewHolder.kt */
    private final class ItemTouch implements View.OnTouchListener {
        private final RecyclerView.ViewHolder holder;
        final /* synthetic */ CardTitleViewHolder this$0;

        public ItemTouch(CardTitleViewHolder cardTitleViewHolder, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            this.this$0 = cardTitleViewHolder;
            this.holder = viewHolder;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(view, "v");
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            int action = motionEvent.getAction();
            if (action == 0) {
                this.this$0.getCallBack().downTouch(view, this.holder);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.this$0.getCallBack().upTouch(view, this.holder);
                return false;
            }
        }
    }
}
