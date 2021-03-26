package com.coolapk.market.view.main;

import androidx.fragment.app.Fragment;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.view.FloatExpandedMenuView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/Entity;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DiscoveryFragmentV11.kt */
final class DiscoveryFragmentV11$showPageMenu$1 extends Lambda implements Function1<Entity, Unit> {
    final /* synthetic */ ConfigPage $configPage;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ Function1 $onSelected;
    final /* synthetic */ FloatExpandedMenuView $pageMenuView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoveryFragmentV11$showPageMenu$1(Fragment fragment, FloatExpandedMenuView floatExpandedMenuView, ConfigPage configPage, Function1 function1) {
        super(1);
        this.$fragment = fragment;
        this.$pageMenuView = floatExpandedMenuView;
        this.$configPage = configPage;
        this.$onSelected = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Entity entity) {
        invoke(entity);
        return Unit.INSTANCE;
    }

    public final void invoke(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "it");
        ((EntityListFragment) this.$fragment).getEntityRequestArgHelper().setRequestArg(entity);
        FloatExpandedMenuView.hideWithAnimator$default(this.$pageMenuView, false, 1, null);
        String str = "";
        if (Intrinsics.areEqual(entity.getUrl(), this.$configPage.getUrl())) {
            Function1 function1 = this.$onSelected;
            if (function1 != null) {
                String title = this.$configPage.getTitle();
                if (title != null) {
                    str = title;
                }
                Unit unit = (Unit) function1.invoke(str);
            }
        } else {
            Function1 function12 = this.$onSelected;
            if (function12 != null) {
                String title2 = entity.getTitle();
                if (title2 != null) {
                    str = title2;
                }
                Unit unit2 = (Unit) function12.invoke(str);
            }
        }
        EntityExtendsKt.checkAndSaveLastSelectedSubPage(this.$configPage, entity.getUrl());
    }
}
