package com.coolapk.market.view.photo;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/photo/QRCodeActivity$processAppQrCode$2", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/ServiceApp;", "onError", "", "e", "", "onNext", "serviceApp", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QRCodeActivity.kt */
public final class QRCodeActivity$processAppQrCode$2 extends EmptySubscriber<ServiceApp> {
    final /* synthetic */ QRCodeActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    QRCodeActivity$processAppQrCode$2(QRCodeActivity qRCodeActivity) {
        this.this$0 = qRCodeActivity;
    }

    public void onNext(ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(serviceApp, "serviceApp");
        super.onNext((QRCodeActivity$processAppQrCode$2) serviceApp);
        ActionManager.startAppViewActivity(this.this$0.getActivity(), serviceApp.getPackageName());
        this.this$0.getActivity().finish();
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        Toast.error(this.this$0.getActivity(), th);
        QRCodeActivity.access$getBinding$p(this.this$0).getRoot().post(new QRCodeActivity$processAppQrCode$2$onError$1(this));
    }
}
