package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.viewholder.IconMiniGridCardViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: IconMiniGridCardViewHolder.kt */
final class IconMiniGridCardViewHolder$DataViewHolder$bindTo$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Object $data;
    final /* synthetic */ Entity $entity1;
    final /* synthetic */ IconMiniGridCardViewHolder.DataViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IconMiniGridCardViewHolder$DataViewHolder$bindTo$1(IconMiniGridCardViewHolder.DataViewHolder dataViewHolder, Entity entity, Object obj) {
        super(1);
        this.this$0 = dataViewHolder;
        this.$entity1 = entity;
        this.$data = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke(view);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ActionManagerCompat.startActivityByUrl(context, this.$entity1.getUrl(), this.$entity1.getTitle(), this.$entity1.getSubTitle());
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        DataBindingComponent component = this.this$0.getComponent();
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (!(fragment instanceof BaseFragment)) {
            fragment = null;
        }
        BaseFragment baseFragment = (BaseFragment) fragment;
        StatisticHelper.recordEntityEvent$default(instance, baseFragment != null ? baseFragment.getFixedRecordId() : null, this.$entity1, this.this$0.getAdapterPosition(), (Entity) this.$data, null, 16, null);
    }
}
