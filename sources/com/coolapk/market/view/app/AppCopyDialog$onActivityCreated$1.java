package com.coolapk.market.view.app;

import android.os.Parcelable;
import android.text.TextUtils;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.CopyActionItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppCopyDialog.kt */
final class AppCopyDialog$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ AppCopyDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppCopyDialog$onActivityCreated$1(AppCopyDialog appCopyDialog) {
        super(1);
        this.this$0 = appCopyDialog;
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
        Parcelable parcelable = this.this$0.requireArguments().getParcelable("SERVICE_APP");
        Intrinsics.checkNotNull(parcelable);
        ServiceApp serviceApp = (ServiceApp) parcelable;
        String string = this.this$0.requireActivity().getString(2131886682);
        Intrinsics.checkNotNullExpressionValue(string, "requireActivity().getStr…r_app_view_copy_app_name)");
        String string2 = this.this$0.requireActivity().getString(2131886688);
        Intrinsics.checkNotNullExpressionValue(string2, "requireActivity().getStr…p_view_copy_package_name)");
        String string3 = this.this$0.requireActivity().getString(2131886684);
        Intrinsics.checkNotNullExpressionValue(string3, "requireActivity().getStr…pp_view_copy_description)");
        String string4 = this.this$0.requireActivity().getString(2131886685);
        Intrinsics.checkNotNullExpressionValue(string4, "requireActivity().getStr…_app_view_copy_developer)");
        String string5 = this.this$0.requireActivity().getString(2131886689);
        Intrinsics.checkNotNullExpressionValue(string5, "requireActivity().getStr…pp_view_copy_permissions)");
        String string6 = this.this$0.requireActivity().getString(2131886683);
        Intrinsics.checkNotNullExpressionValue(string6, "requireActivity().getStr…_app_view_copy_changelog)");
        String string7 = this.this$0.requireActivity().getString(2131886686);
        Intrinsics.checkNotNullExpressionValue(string7, "requireActivity().getStr…_app_view_copy_introduce)");
        String string8 = this.this$0.requireActivity().getString(2131886687);
        Intrinsics.checkNotNullExpressionValue(string8, "requireActivity().getStr…g.str_app_view_copy_link)");
        list.add(new CopyActionItem(string8, "https://www.coolapk.com" + serviceApp.getApkUrl()));
        list.add(new CopyActionItem(string, serviceApp.getAppName() + " " + serviceApp.getDisplayVersionName()));
        String packageName = serviceApp.getPackageName();
        String str = "";
        if (packageName == null) {
            packageName = str;
        }
        list.add(new CopyActionItem(string2, packageName));
        if (!TextUtils.isEmpty(serviceApp.getDescription())) {
            String description = serviceApp.getDescription();
            if (description == null) {
                description = str;
            }
            list.add(new CopyActionItem(string3, description));
        }
        if (!TextUtils.isEmpty(serviceApp.getDeveloperName())) {
            String developerName = serviceApp.getDeveloperName();
            if (developerName == null) {
                developerName = str;
            }
            list.add(new CopyActionItem(string4, developerName));
        }
        if (!CollectionUtils.isEmpty(serviceApp.getPermissions())) {
            List<String> permissions = serviceApp.getPermissions();
            Intrinsics.checkNotNull(permissions);
            String join = TextUtils.join(", ", permissions);
            Intrinsics.checkNotNullExpressionValue(join, "TextUtils.join(\", \", app.permissions!!)");
            list.add(new CopyActionItem(string5, join));
        }
        if (!TextUtils.isEmpty(serviceApp.getChangeLog())) {
            String changeLog = serviceApp.getChangeLog();
            if (changeLog != null) {
                str = changeLog;
            }
            list.add(new CopyActionItem(string6, str));
        }
        if (!TextUtils.isEmpty(serviceApp.getIntroduce())) {
            String introduce = serviceApp.getIntroduce();
            Intrinsics.checkNotNull(introduce);
            Intrinsics.checkNotNullExpressionValue(introduce, "app.introduce!!");
            list.add(new CopyActionItem(string7, LinkTextUtils.reconvert(introduce)));
        }
    }
}
