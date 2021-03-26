package com.coolapk.market.view.goodsList;

import android.os.Parcelable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.GoodsListItem;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.center.TouchCallBack;
import com.coolapk.market.view.goodsList.GoodGoodsEditListFragment;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodGoodsEditListFragment.kt */
final class GoodGoodsEditListFragment$onRegisterCards$4 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ GoodGoodsEditListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodGoodsEditListFragment$onRegisterCards$4(GoodGoodsEditListFragment goodGoodsEditListFragment) {
        super(1);
        this.this$0 = goodGoodsEditListFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        return new GoodsListEditViewHolder(view, new FragmentBindingComponent(this.this$0), new TouchCallBack(this) {
            /* class com.coolapk.market.view.goodsList.GoodGoodsEditListFragment$onRegisterCards$4.AnonymousClass1 */
            final /* synthetic */ GoodGoodsEditListFragment$onRegisterCards$4 this$0;

            @Override // com.coolapk.market.view.center.TouchCallBack
            public void findPosition(int i, RecyclerView.ViewHolder viewHolder) {
            }

            @Override // com.coolapk.market.view.center.TouchCallBack
            public void upTouch(View view, RecyclerView.ViewHolder viewHolder) {
                Intrinsics.checkNotNullParameter(view, "view");
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.view.center.TouchCallBack
            public void downTouch(View view, RecyclerView.ViewHolder viewHolder) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (viewHolder != null && view.getId() == 2131362433) {
                    this.this$0.this$0.startDrag(viewHolder.getAdapterPosition());
                }
            }

            @Override // com.coolapk.market.view.center.TouchCallBack
            public void itemClear(int i, RecyclerView.ViewHolder viewHolder) {
                ArrayList arrayList = new ArrayList();
                List<Parcelable> subList = this.this$0.this$0.getDataList().subList(1, this.this$0.this$0.getDataList().size());
                int size = subList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Parcelable parcelable = subList.get(i2);
                    if (parcelable instanceof GoodsListItem) {
                        String id = ((GoodsListItem) parcelable).getId();
                        Intrinsics.checkNotNull(id);
                        Intrinsics.checkNotNullExpressionValue(id, "goodsItem.id!!");
                        arrayList.add(new GoodGoodsEditListFragment.ItemOrder(id, String.valueOf(i2)));
                    }
                }
                DataManager.getInstance().editGoodsListDisplayOrder(this.this$0.this$0.getFeed().getId(), new Gson().toJson(arrayList)).compose(RxUtils.apiCommonToData()).subscribe(new GoodGoodsEditListFragment$onRegisterCards$4$1$itemClear$1(this, subList), new GoodGoodsEditListFragment$onRegisterCards$4$1$itemClear$2(this));
            }
        }, this.this$0.delList);
    }
}
