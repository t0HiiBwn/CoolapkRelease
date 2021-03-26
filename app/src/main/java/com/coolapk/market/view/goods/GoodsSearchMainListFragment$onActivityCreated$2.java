package com.coolapk.market.view.goods;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.SearchHistoryViewHolder;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsSearchMainListFragment.kt */
final class GoodsSearchMainListFragment$onActivityCreated$2 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ GoodsSearchMainListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodsSearchMainListFragment$onActivityCreated$2(GoodsSearchMainListFragment goodsSearchMainListFragment) {
        super(1);
        this.this$0 = goodsSearchMainListFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new SearchHistoryViewHolder(view, this.this$0.historyDataSet, this.this$0.historyLines, this.this$0.showAllHistory, new ItemActionHandler(this) {
            /* class com.coolapk.market.view.goods.GoodsSearchMainListFragment$onActivityCreated$2.AnonymousClass1 */
            final /* synthetic */ GoodsSearchMainListFragment$onActivityCreated$2 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                int id = view.getId();
                if (id == 2131362257) {
                    GoodsSearchHistoryHelper.INSTANCE.clear();
                    this.this$0.this$0.loadHistory();
                } else if (id == 2131363587) {
                    this.this$0.this$0.showAllHistory.set(!this.this$0.this$0.showAllHistory.get());
                    this.this$0.this$0.loadHistory();
                }
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public boolean onItemLongClick(RecyclerView.ViewHolder viewHolder, View view) {
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                if (view.getId() == 2131362768) {
                    Object tag = view.getTag();
                    Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
                    String[] strArr = {(String) tag};
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    instance.getDataBase().delete("searchHistory", "keyword=?", (String[]) Arrays.copyOf(strArr, 1));
                    this.this$0.this$0.loadHistory();
                }
                return super.onItemLongClick(viewHolder, view);
            }
        }, new Function1<String, Unit>(this) {
            /* class com.coolapk.market.view.goods.GoodsSearchMainListFragment$onActivityCreated$2.AnonymousClass2 */
            final /* synthetic */ GoodsSearchMainListFragment$onActivityCreated$2 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke(str);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "it");
                FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                if (!(requireActivity instanceof GoodsCouponSearchActivity)) {
                    requireActivity = null;
                }
                GoodsCouponSearchActivity goodsCouponSearchActivity = (GoodsCouponSearchActivity) requireActivity;
                if (goodsCouponSearchActivity != null) {
                    GoodsCouponSearchActivity.inputKeywords$default(goodsCouponSearchActivity, str, false, 2, null);
                }
            }
        });
    }
}
