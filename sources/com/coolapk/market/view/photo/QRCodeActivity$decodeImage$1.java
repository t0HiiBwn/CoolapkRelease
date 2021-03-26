package com.coolapk.market.view.photo;

import cn.bertsir.zbar.utils.QRUtils;
import kotlin.Metadata;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "s", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: QRCodeActivity.kt */
final class QRCodeActivity$decodeImage$1<T, R> implements Func1<String, String> {
    public static final QRCodeActivity$decodeImage$1 INSTANCE = new QRCodeActivity$decodeImage$1();

    QRCodeActivity$decodeImage$1() {
    }

    public final String call(String str) {
        return QRUtils.getInstance().decodeQRcode(str);
    }
}
