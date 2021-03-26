package com.coolapk.market.view.center;

import androidx.databinding.ObservableList;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.AdapterListChangedCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/coolapk/market/widget/AdapterListChangedCallback;", "Landroidx/databinding/ObservableList;", "Lcom/coolapk/market/model/Entity;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: MyCardManagerFragment.kt */
final class MyCardManagerFragment$listCallback$2 extends Lambda implements Function0<AdapterListChangedCallback<ObservableList<Entity>>> {
    final /* synthetic */ MyCardManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyCardManagerFragment$listCallback$2(MyCardManagerFragment myCardManagerFragment) {
        super(0);
        this.this$0 = myCardManagerFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final AdapterListChangedCallback<ObservableList<Entity>> invoke() {
        return new AdapterListChangedCallback<>(MyCardManagerFragment.access$getAdapter$p(this.this$0));
    }
}
