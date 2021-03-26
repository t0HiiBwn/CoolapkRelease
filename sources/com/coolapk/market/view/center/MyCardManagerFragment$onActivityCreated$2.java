package com.coolapk.market.view.center;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: MyCardManagerFragment.kt */
final class MyCardManagerFragment$onActivityCreated$2 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ MyCardManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyCardManagerFragment$onActivityCreated$2(MyCardManagerFragment myCardManagerFragment) {
        super(1);
        this.this$0 = myCardManagerFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        return new CardTitleViewHolder(view, new TouchCallBack(this) {
            /* class com.coolapk.market.view.center.MyCardManagerFragment$onActivityCreated$2.AnonymousClass1 */
            final /* synthetic */ MyCardManagerFragment$onActivityCreated$2 this$0;

            @Override // com.coolapk.market.view.center.TouchCallBack
            public void itemClear(int i, RecyclerView.ViewHolder viewHolder) {
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.view.center.TouchCallBack
            public void downTouch(View view, RecyclerView.ViewHolder viewHolder) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (viewHolder != null && view.getId() == 2131362426) {
                    this.this$0.this$0.startDrag(viewHolder.getAdapterPosition());
                }
            }

            @Override // com.coolapk.market.view.center.TouchCallBack
            public void upTouch(View view, RecyclerView.ViewHolder viewHolder) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (viewHolder != null) {
                    int adapterPosition = viewHolder.getAdapterPosition();
                    boolean z = false;
                    if (view.getId() == 2131362003) {
                        int adapterPosition2 = viewHolder.getAdapterPosition() - this.this$0.this$0.findTargetPosition();
                        int i = 0;
                        while (i < adapterPosition2) {
                            int i2 = adapterPosition - 1;
                            this.this$0.this$0.moveItem(adapterPosition, i2);
                            i++;
                            adapterPosition = i2;
                        }
                    } else if (view.getId() == 2131362838) {
                        int adapterPosition3 = this.this$0.this$0.findTargetPosition() - viewHolder.getAdapterPosition();
                        int i3 = 0;
                        while (i3 < adapterPosition3) {
                            int i4 = adapterPosition + 1;
                            this.this$0.this$0.moveItem(adapterPosition, i4);
                            i3++;
                            adapterPosition = i4;
                        }
                    }
                    int i5 = this.this$0.this$0.findTargetPosition();
                    if (viewHolder instanceof CardTitleViewHolder) {
                        CardTitleViewHolder cardTitleViewHolder = (CardTitleViewHolder) viewHolder;
                        if (cardTitleViewHolder.getAdapterPosition() < i5) {
                            z = true;
                        }
                        cardTitleViewHolder.itemAddOrLess(z);
                    }
                }
            }

            @Override // com.coolapk.market.view.center.TouchCallBack
            public void findPosition(int i, RecyclerView.ViewHolder viewHolder) {
                int i2 = this.this$0.this$0.findTargetPosition();
                if (viewHolder instanceof CardTitleViewHolder) {
                    ((CardTitleViewHolder) viewHolder).itemAddOrLess(i < i2);
                }
            }
        });
    }
}
