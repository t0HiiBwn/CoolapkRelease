package com.coolapk.market.view.dyhv8;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.collectionList.CollectionDetailActivity;
import com.coolapk.market.view.dyhv8.DyhArticleAction;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhArticleAction.kt */
final class DyhArticleAction$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ DyhArticle $dyhArticle;
    final /* synthetic */ DyhArticleAction this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DyhArticleAction$onActivityCreated$1(DyhArticleAction dyhArticleAction, DyhArticle dyhArticle) {
        super(1);
        this.this$0 = dyhArticleAction;
        this.$dyhArticle = dyhArticle;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01a4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public final void invoke(List<ActionItem> list) {
        boolean z;
        boolean z2;
        boolean z3;
        Collection collectionInfo;
        boolean contains$default;
        boolean z4;
        Intrinsics.checkNotNullParameter(list, "it");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        boolean isFavorite = this.$dyhArticle.isFavorite();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (loginSession.isLogin()) {
            list.add(new DyhArticleAction.StarAction(this.this$0, isFavorite, this.$dyhArticle));
        }
        list.add(this.this$0.buildMultiActionItem(this.$dyhArticle));
        boolean z5 = this.$dyhArticle.getRecommend() > 0;
        String string = this.this$0.getString(2131886730);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_dialog_report)");
        MultiItemDialogFragmentKt.addItem(list, string, new Function0<Unit>(this) {
            /* class com.coolapk.market.view.dyhv8.DyhArticleAction$onActivityCreated$1.AnonymousClass1 */
            final /* synthetic */ DyhArticleAction$onActivityCreated$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                FragmentActivity activity = this.this$0.this$0.getActivity();
                String id = this.this$0.$dyhArticle.getId();
                if (id == null) {
                    id = "";
                }
                ActionManager.startWebViewActivity(activity, UriUtils.buildDyhArticleReportUrl(id));
            }
        });
        if (this.$dyhArticle.getDyhModel() != null) {
            DyhModel dyhModel = this.$dyhArticle.getDyhModel();
            Intrinsics.checkNotNull(dyhModel);
            Intrinsics.checkNotNullExpressionValue(dyhModel, "dyhArticle.dyhModel!!");
            List<String> editors = dyhModel.getEditors();
            DataManager instance2 = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
            LoginSession loginSession2 = instance2.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession2, "DataManager.getInstance().loginSession");
            if (editors.contains(loginSession2.getUid())) {
                z = true;
                z2 = !loginSession.isLogin() && loginSession.isAdmin();
                Activity currentActivity = AppHolder.getCurrentActivity();
                Intrinsics.checkNotNull(currentActivity);
                Intrinsics.checkNotNullExpressionValue(currentActivity, "AppHolder.getCurrentActivity()!!");
                String localClassName = currentActivity.getLocalClassName();
                Intrinsics.checkNotNullExpressionValue(localClassName, "AppHolder.getCurrentActivity()!!.localClassName");
                Objects.requireNonNull(localClassName, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = localClassName.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                boolean contains$default2 = StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "dyhdetail", false, 2, (Object) null);
                if (this.$dyhArticle.getDyhModel() != null) {
                    DyhModel dyhModel2 = this.$dyhArticle.getDyhModel();
                    Intrinsics.checkNotNull(dyhModel2);
                    Intrinsics.checkNotNullExpressionValue(dyhModel2, "dyhArticle.dyhModel!!");
                    DataManager instance3 = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
                    LoginSession loginSession3 = instance3.getLoginSession();
                    Intrinsics.checkNotNullExpressionValue(loginSession3, "DataManager.getInstance().loginSession");
                    if (TextUtils.equals(dyhModel2.getUid(), loginSession3.getUid())) {
                        z3 = true;
                        if (z3 && contains$default2) {
                            list.add(new DyhArticleAction.TopAction(this.this$0, this.$dyhArticle.isTop(), this.$dyhArticle));
                        }
                        if (z2) {
                            list.add(this.this$0.buildAdminActionItem(this.$dyhArticle));
                            list.add(new DyhArticleAction.RecommendAction(this.this$0, z5, this.$dyhArticle));
                        }
                        if (z || z2) {
                            list.add(new DyhArticleAction.DeleteAction(this.this$0, this.$dyhArticle));
                        }
                        collectionInfo = this.$dyhArticle.getCollectionInfo();
                        Activity currentActivity2 = AppHolder.getCurrentActivity();
                        Intrinsics.checkNotNull(currentActivity2);
                        Intrinsics.checkNotNullExpressionValue(currentActivity2, "AppHolder.getCurrentActivity()!!");
                        String localClassName2 = currentActivity2.getLocalClassName();
                        Intrinsics.checkNotNullExpressionValue(localClassName2, "AppHolder.getCurrentActivity()!!.localClassName");
                        Objects.requireNonNull(localClassName2, "null cannot be cast to non-null type java.lang.String");
                        String lowerCase2 = localClassName2.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                        contains$default = StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "collectiondetail", false, 2, (Object) null);
                        if (collectionInfo != null) {
                            DataManager instance4 = DataManager.getInstance();
                            Intrinsics.checkNotNullExpressionValue(instance4, "DataManager.getInstance()");
                            LoginSession loginSession4 = instance4.getLoginSession();
                            Intrinsics.checkNotNullExpressionValue(loginSession4, "DataManager.getInstance().loginSession");
                            if (TextUtils.equals(loginSession4.getUid(), collectionInfo.getUid())) {
                                z4 = true;
                                if (contains$default && z4) {
                                    if (AppHolder.getCurrentActivity() instanceof CollectionDetailActivity) {
                                        list.add(new DyhArticleAction.TopCollectionAction(this.this$0, this.$dyhArticle.isTop(), this.$dyhArticle));
                                    }
                                    list.add(new DyhArticleAction.RemoveFromCollectionAction(this.this$0, this.$dyhArticle));
                                    return;
                                }
                                return;
                            }
                        }
                        z4 = false;
                        if (contains$default) {
                            return;
                        }
                        return;
                    }
                }
                z3 = false;
                list.add(new DyhArticleAction.TopAction(this.this$0, this.$dyhArticle.isTop(), this.$dyhArticle));
                if (z2) {
                }
                list.add(new DyhArticleAction.DeleteAction(this.this$0, this.$dyhArticle));
                collectionInfo = this.$dyhArticle.getCollectionInfo();
                Activity currentActivity2 = AppHolder.getCurrentActivity();
                Intrinsics.checkNotNull(currentActivity2);
                Intrinsics.checkNotNullExpressionValue(currentActivity2, "AppHolder.getCurrentActivity()!!");
                String localClassName2 = currentActivity2.getLocalClassName();
                Intrinsics.checkNotNullExpressionValue(localClassName2, "AppHolder.getCurrentActivity()!!.localClassName");
                Objects.requireNonNull(localClassName2, "null cannot be cast to non-null type java.lang.String");
                String lowerCase2 = localClassName2.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                contains$default = StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "collectiondetail", false, 2, (Object) null);
                if (collectionInfo != null) {
                }
                z4 = false;
                if (contains$default) {
                }
            }
        }
        z = false;
        if (!loginSession.isLogin()) {
        }
        Activity currentActivity = AppHolder.getCurrentActivity();
        Intrinsics.checkNotNull(currentActivity);
        Intrinsics.checkNotNullExpressionValue(currentActivity, "AppHolder.getCurrentActivity()!!");
        String localClassName = currentActivity.getLocalClassName();
        Intrinsics.checkNotNullExpressionValue(localClassName, "AppHolder.getCurrentActivity()!!.localClassName");
        Objects.requireNonNull(localClassName, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = localClassName.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        boolean contains$default2 = StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "dyhdetail", false, 2, (Object) null);
        if (this.$dyhArticle.getDyhModel() != null) {
        }
        z3 = false;
        list.add(new DyhArticleAction.TopAction(this.this$0, this.$dyhArticle.isTop(), this.$dyhArticle));
        if (z2) {
        }
        list.add(new DyhArticleAction.DeleteAction(this.this$0, this.$dyhArticle));
        collectionInfo = this.$dyhArticle.getCollectionInfo();
        Activity currentActivity2 = AppHolder.getCurrentActivity();
        Intrinsics.checkNotNull(currentActivity2);
        Intrinsics.checkNotNullExpressionValue(currentActivity2, "AppHolder.getCurrentActivity()!!");
        String localClassName2 = currentActivity2.getLocalClassName();
        Intrinsics.checkNotNullExpressionValue(localClassName2, "AppHolder.getCurrentActivity()!!.localClassName");
        Objects.requireNonNull(localClassName2, "null cannot be cast to non-null type java.lang.String");
        String lowerCase2 = localClassName2.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
        contains$default = StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "collectiondetail", false, 2, (Object) null);
        if (collectionInfo != null) {
        }
        z4 = false;
        if (contains$default) {
        }
    }
}
