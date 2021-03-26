package com.coolapk.market.view.collectionList;

import android.app.Activity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.model.CollectionItem;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.collectionList.AppViewForCollectionItemDialog;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppViewForCollectionItemDialog.kt */
final class AppViewForCollectionItemDialog$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ Ref.ObjectRef $app;
    final /* synthetic */ Entity $entity;
    final /* synthetic */ AppViewForCollectionItemDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppViewForCollectionItemDialog$onActivityCreated$1(AppViewForCollectionItemDialog appViewForCollectionItemDialog, Ref.ObjectRef objectRef, Entity entity) {
        super(1);
        this.this$0 = appViewForCollectionItemDialog;
        this.$app = objectRef;
        this.$entity = entity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<ActionItem> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        Activity currentActivity = AppHolder.getCurrentActivity();
        Intrinsics.checkNotNull(currentActivity);
        Intrinsics.checkNotNullExpressionValue(currentActivity, "AppHolder.getCurrentActivity()!!");
        String localClassName = currentActivity.getLocalClassName();
        Intrinsics.checkNotNullExpressionValue(localClassName, "AppHolder.getCurrentActivity()!!.localClassName");
        Objects.requireNonNull(localClassName, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = localClassName.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "collectiondetail", false, 2, (Object) null)) {
            if (this.$app.element != null) {
                AppViewForCollectionItemDialog appViewForCollectionItemDialog = this.this$0;
                CollectionItem collectionItem = this.$app.element.getCollectionItem();
                Intrinsics.checkNotNull(collectionItem);
                MultiItemDialogFragmentKt.addItem(list, new AppViewForCollectionItemDialog.CollectionTop(appViewForCollectionItemDialog, collectionItem.isTop(), this.$app.element));
            }
            MultiItemDialogFragmentKt.addItem(list, new AppViewForCollectionItemDialog.CollectionRemoveActionItem(this.this$0, this.$entity));
        }
    }
}
