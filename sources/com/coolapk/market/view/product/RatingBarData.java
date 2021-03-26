package com.coolapk.market.view.product;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/product/RatingBarData;", "", "key", "", "name", "twoPointText", "fourPointText", "sixPointText", "eightPointText", "tenPointText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getName", "getPointText", "point", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductGlobalData.kt */
public final class RatingBarData {
    private final String eightPointText;
    private final String fourPointText;
    private final String key;
    private final String name;
    private final String sixPointText;
    private final String tenPointText;
    private final String twoPointText;

    public RatingBarData(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "twoPointText");
        Intrinsics.checkNotNullParameter(str4, "fourPointText");
        Intrinsics.checkNotNullParameter(str5, "sixPointText");
        Intrinsics.checkNotNullParameter(str6, "eightPointText");
        Intrinsics.checkNotNullParameter(str7, "tenPointText");
        this.key = str;
        this.name = str2;
        this.twoPointText = str3;
        this.fourPointText = str4;
        this.sixPointText = str5;
        this.eightPointText = str6;
        this.tenPointText = str7;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPointText(float f) {
        if (f >= ((float) 9)) {
            return this.tenPointText;
        }
        if (f >= ((float) 7)) {
            return this.eightPointText;
        }
        if (f >= ((float) 5)) {
            return this.sixPointText;
        }
        if (f >= ((float) 3)) {
            return this.fourPointText;
        }
        return f >= ((float) 2) ? this.twoPointText : "请评分";
    }
}
