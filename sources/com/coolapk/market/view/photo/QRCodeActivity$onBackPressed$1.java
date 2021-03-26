package com.coolapk.market.view.photo;

import com.coolapk.market.databinding.QrCodeBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: QRCodeActivity.kt */
final /* synthetic */ class QRCodeActivity$onBackPressed$1 extends MutablePropertyReference0Impl {
    QRCodeActivity$onBackPressed$1(QRCodeActivity qRCodeActivity) {
        super(qRCodeActivity, QRCodeActivity.class, "binding", "getBinding()Lcom/coolapk/market/databinding/QrCodeBinding;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return QRCodeActivity.access$getBinding$p((QRCodeActivity) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((QRCodeActivity) this.receiver).binding = (QrCodeBinding) obj;
    }
}
