package com.coolapk.market.view.cardlist;

import android.content.Context;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.cardlist.EntityListFragment$onRegisterCards$56;
import com.coolapk.market.widget.decoration.PaddingDividerItemDecoration;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\n¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/cardlist/EntityListFragment$onRegisterCards$56$1$onBindTo$1$1", "Lcom/coolapk/market/widget/decoration/PaddingDividerItemDecoration$SimpleCallBack;", "getDividerHeight", "", "position", "getItemCount", "getPaddingLeft", "getPaddingRight", "hasPadding", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
public final class EntityListFragment$onRegisterCards$56$1$onBindTo$$inlined$apply$lambda$1 extends PaddingDividerItemDecoration.SimpleCallBack {
    final /* synthetic */ EntityCard $card$inlined;
    final /* synthetic */ EntityListFragment$onRegisterCards$56.AnonymousClass1 this$0;

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public boolean hasPadding(int i) {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$onRegisterCards$56$1$onBindTo$$inlined$apply$lambda$1(Context context, EntityListFragment$onRegisterCards$56.AnonymousClass1 r2, EntityCard entityCard) {
        super(context);
        this.this$0 = r2;
        this.$card$inlined = entityCard;
    }

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public int getItemCount() {
        List<Entity> entities = this.$card$inlined.getEntities();
        int valueOf = entities != null ? Integer.valueOf(entities.size()) : null;
        if (valueOf == null) {
            valueOf = 0;
        }
        return valueOf.intValue();
    }

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public int getPaddingLeft() {
        return this.m12dp;
    }

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public int getPaddingRight() {
        return this.m12dp;
    }

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public int getDividerHeight(int i) {
        return this.m1dp;
    }
}
