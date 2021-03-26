package com.coolapk.market.viewholder;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/coolapk/market/viewholder/GoodsSimpleInfo;", "", "title", "", "pic", "price", "category", "mallName", "extraUrl", "sellUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getExtraUrl", "getMallName", "getPic", "getPrice", "getSellUrl", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGoodsInfoViewPart.kt */
public final class GoodsSimpleInfo {
    private final String category;
    private final String extraUrl;
    private final String mallName;
    private final String pic;
    private final String price;
    private final String sellUrl;
    private final String title;

    public static /* synthetic */ GoodsSimpleInfo copy$default(GoodsSimpleInfo goodsSimpleInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = goodsSimpleInfo.title;
        }
        if ((i & 2) != 0) {
            str2 = goodsSimpleInfo.pic;
        }
        if ((i & 4) != 0) {
            str3 = goodsSimpleInfo.price;
        }
        if ((i & 8) != 0) {
            str4 = goodsSimpleInfo.category;
        }
        if ((i & 16) != 0) {
            str5 = goodsSimpleInfo.mallName;
        }
        if ((i & 32) != 0) {
            str6 = goodsSimpleInfo.extraUrl;
        }
        if ((i & 64) != 0) {
            str7 = goodsSimpleInfo.sellUrl;
        }
        return goodsSimpleInfo.copy(str, str2, str3, str4, str5, str6, str7);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.pic;
    }

    public final String component3() {
        return this.price;
    }

    public final String component4() {
        return this.category;
    }

    public final String component5() {
        return this.mallName;
    }

    public final String component6() {
        return this.extraUrl;
    }

    public final String component7() {
        return this.sellUrl;
    }

    public final GoodsSimpleInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "pic");
        Intrinsics.checkNotNullParameter(str3, "price");
        Intrinsics.checkNotNullParameter(str4, "category");
        Intrinsics.checkNotNullParameter(str5, "mallName");
        Intrinsics.checkNotNullParameter(str6, "extraUrl");
        Intrinsics.checkNotNullParameter(str7, "sellUrl");
        return new GoodsSimpleInfo(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsSimpleInfo)) {
            return false;
        }
        GoodsSimpleInfo goodsSimpleInfo = (GoodsSimpleInfo) obj;
        return Intrinsics.areEqual(this.title, goodsSimpleInfo.title) && Intrinsics.areEqual(this.pic, goodsSimpleInfo.pic) && Intrinsics.areEqual(this.price, goodsSimpleInfo.price) && Intrinsics.areEqual(this.category, goodsSimpleInfo.category) && Intrinsics.areEqual(this.mallName, goodsSimpleInfo.mallName) && Intrinsics.areEqual(this.extraUrl, goodsSimpleInfo.extraUrl) && Intrinsics.areEqual(this.sellUrl, goodsSimpleInfo.sellUrl);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.pic;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.price;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.category;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mallName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.extraUrl;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.sellUrl;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "GoodsSimpleInfo(title=" + this.title + ", pic=" + this.pic + ", price=" + this.price + ", category=" + this.category + ", mallName=" + this.mallName + ", extraUrl=" + this.extraUrl + ", sellUrl=" + this.sellUrl + ")";
    }

    public GoodsSimpleInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "pic");
        Intrinsics.checkNotNullParameter(str3, "price");
        Intrinsics.checkNotNullParameter(str4, "category");
        Intrinsics.checkNotNullParameter(str5, "mallName");
        Intrinsics.checkNotNullParameter(str6, "extraUrl");
        Intrinsics.checkNotNullParameter(str7, "sellUrl");
        this.title = str;
        this.pic = str2;
        this.price = str3;
        this.category = str4;
        this.mallName = str5;
        this.extraUrl = str6;
        this.sellUrl = str7;
    }

    public final String getPic() {
        return this.pic;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getMallName() {
        return this.mallName;
    }

    public final String getExtraUrl() {
        return this.extraUrl;
    }

    public final String getSellUrl() {
        return this.sellUrl;
    }
}
