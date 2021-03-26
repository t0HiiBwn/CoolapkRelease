package com.coolapk.market.view.feed;

import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.feed.CurrencyItemDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CurrencyItemDialog.kt */
final class CurrencyItemDialog$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ Entity $entity;
    final /* synthetic */ CurrencyItemDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CurrencyItemDialog$onActivityCreated$1(CurrencyItemDialog currencyItemDialog, Entity entity) {
        super(1);
        this.this$0 = currencyItemDialog;
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
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        MultiItemDialogFragmentKt.addItem(list, "用户管理", new Function0<Unit>(this) {
            /* class com.coolapk.market.view.feed.CurrencyItemDialog$onActivityCreated$1.AnonymousClass1 */
            final /* synthetic */ CurrencyItemDialog$onActivityCreated$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                FragmentActivity activity = this.this$0.this$0.getActivity();
                String entityId = this.this$0.$entity.getEntityId();
                if (entityId == null) {
                    entityId = "";
                }
                Intrinsics.checkNotNullExpressionValue(entityId, "entity.entityId\n                        ?: \"\"");
                ActionManager.startWebViewActivity(activity, UriUtils.getUserManageUrl(entityId));
            }
        });
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (loginSession.isLogin() && EntityExtendsKt.isShowCancelReportSpam(this.$entity) && loginSession.isAdmin()) {
            list.add(new CurrencyItemDialog.CancelReportSpamActionItem(this.$entity));
        }
    }
}
