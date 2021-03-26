package com.coolapk.market.view.app;

import android.content.Context;
import android.os.Parcelable;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.DataItem;
import com.coolapk.market.widget.decoration.PaddingDividerItemDecoration;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/app/AppViewListFragment$onActivityCreated$13", "Lcom/coolapk/market/widget/decoration/PaddingDividerItemDecoration$SimpleCallBack;", "getDividerHeight", "", "position", "getItemCount", "getPaddingLeft", "getPaddingRight", "hasPadding", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewListFragment.kt */
public final class AppViewListFragment$onActivityCreated$13 extends PaddingDividerItemDecoration.SimpleCallBack {
    final /* synthetic */ AppViewListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppViewListFragment$onActivityCreated$13(AppViewListFragment appViewListFragment, Context context) {
        super(context);
        this.this$0 = appViewListFragment;
    }

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public int getItemCount() {
        return this.this$0.getDataList().size();
    }

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public int getDividerHeight(int i) {
        if (this.this$0.getDataList().get(i) instanceof DataItem) {
            return NumberExtendsKt.getDp(Float.valueOf(0.5f));
        }
        return 0;
    }

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public boolean hasPadding(int i) {
        Parcelable parcelable = this.this$0.getDataList().get(i);
        if (!(parcelable instanceof DataItem) || ((DataItem) parcelable).getItemType() == 4) {
            return false;
        }
        return true;
    }

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public int getPaddingLeft() {
        return NumberExtendsKt.getDp((Number) 12);
    }

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public int getPaddingRight() {
        return NumberExtendsKt.getDp((Number) 12);
    }
}
