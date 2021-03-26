package com.coolapk.market.view.node.app;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "app", "Lcom/coolapk/market/model/ServiceApp;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeFragment$onOptionsItemSelected$7 extends Lambda implements Function1<ServiceApp, Unit> {
    final /* synthetic */ AppNodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeFragment$onOptionsItemSelected$7(AppNodeFragment appNodeFragment) {
        super(1);
        this.this$0 = appNodeFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServiceApp serviceApp) {
        invoke(serviceApp);
        return Unit.INSTANCE;
    }

    public final void invoke(ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(serviceApp, "app");
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        if (TextUtils.equals(serviceApp.getPackageName(), requireActivity.getPackageName())) {
            FragmentActivity requireActivity2 = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            Toast.show(requireActivity2, 2131887216);
            return;
        }
        ActionManager.uninstall(this.this$0.getActivity(), serviceApp.getPackageName(), serviceApp.getAppName());
    }
}
