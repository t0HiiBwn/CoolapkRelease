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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CardTitleViewHolder.kt */
public final class CardTitleViewHolder extends BindingViewHolder implements ItemTouchHelperViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558638;
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
        if ((valueOf != null && valueOf.intValue() == 2131362849) || (valueOf != null && valueOf.intValue() == 2131362004)) {
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
