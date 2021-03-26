package com.coolapk.market.view.node.app;

import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.view.block.AddBlockDialog;
import com.coolapk.market.view.block.BlockItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "app", "Lcom/coolapk/market/model/ServiceApp;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeFragment$onOptionsItemSelected$13 extends Lambda implements Function1<ServiceApp, Unit> {
    final /* synthetic */ AppNodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeFragment$onOptionsItemSelected$13(AppNodeFragment appNodeFragment) {
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

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x005a: APUT  
      (r2v2 com.coolapk.market.view.block.BlockItem[])
      (0 ??[int, short, byte, char])
      (wrap: com.coolapk.market.view.block.BlockItem : 0x0056: CONSTRUCTOR  (r13v0 com.coolapk.market.view.block.BlockItem) = 
      (r5v0 java.lang.String)
      (r6v0 java.lang.String)
      (r7v2 java.lang.String)
      (r15v2 java.lang.String)
      false
      (null java.lang.String)
      ("node")
      (48 int)
      (null kotlin.jvm.internal.DefaultConstructorMarker)
     call: com.coolapk.market.view.block.BlockItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void type: CONSTRUCTOR)
     */
    public final void invoke(ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(serviceApp, "app");
        AddBlockDialog addBlockDialog = AddBlockDialog.INSTANCE;
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FragmentActivity fragmentActivity = requireActivity;
        BlockItem[] blockItemArr = new BlockItem[1];
        String targetId = serviceApp.getTargetId();
        String str = targetId != null ? targetId : "";
        String title = serviceApp.getTitle();
        String str2 = title != null ? title : "";
        String str3 = "[应用] " + serviceApp.getTitle();
        String logo = serviceApp.getLogo();
        if (logo == null) {
            logo = "";
        }
        blockItemArr[0] = new BlockItem(str, str2, str3, logo, false, null, "node", 48, null);
        addBlockDialog.showBlockNodeDialog(fragmentActivity, CollectionsKt.mutableListOf(blockItemArr));
    }
}
