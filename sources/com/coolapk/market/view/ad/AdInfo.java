package com.coolapk.market.view.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/ad/AdInfo;", "", "name", "", "appId", "posId", "id", "title", "desc", "pics", "info", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getDesc", "getId", "getInfo", "getName", "getPics", "getPosId", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AdInfo.kt */
public final class AdInfo {
    private final String appId;
    private final String desc;
    private final String id;
    private final String info;
    private final String name;
    private final String pics;
    private final String posId;
    private final String title;

    public static /* synthetic */ AdInfo copy$default(AdInfo adInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        return adInfo.copy((i & 1) != 0 ? adInfo.name : str, (i & 2) != 0 ? adInfo.appId : str2, (i & 4) != 0 ? adInfo.posId : str3, (i & 8) != 0 ? adInfo.id : str4, (i & 16) != 0 ? adInfo.title : str5, (i & 32) != 0 ? adInfo.desc : str6, (i & 64) != 0 ? adInfo.pics : str7, (i & 128) != 0 ? adInfo.info : str8);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.appId;
    }

    public final String component3() {
        return this.posId;
    }

    public final String component4() {
        return this.id;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.desc;
    }

    public final String component7() {
        return this.pics;
    }

    public final String component8() {
        return this.info;
    }

    public final AdInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, "posId");
        Intrinsics.checkNotNullParameter(str4, "id");
        Intrinsics.checkNotNullParameter(str5, "title");
        Intrinsics.checkNotNullParameter(str6, "desc");
        Intrinsics.checkNotNullParameter(str7, "pics");
        Intrinsics.checkNotNullParameter(str8, "info");
        return new AdInfo(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdInfo)) {
            return false;
        }
        AdInfo adInfo = (AdInfo) obj;
        return Intrinsics.areEqual(this.name, adInfo.name) && Intrinsics.areEqual(this.appId, adInfo.appId) && Intrinsics.areEqual(this.posId, adInfo.posId) && Intrinsics.areEqual(this.id, adInfo.id) && Intrinsics.areEqual(this.title, adInfo.title) && Intrinsics.areEqual(this.desc, adInfo.desc) && Intrinsics.areEqual(this.pics, adInfo.pics) && Intrinsics.areEqual(this.info, adInfo.info);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.appId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.posId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.id;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.title;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.desc;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.pics;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.info;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "AdInfo(name=" + this.name + ", appId=" + this.appId + ", posId=" + this.posId + ", id=" + this.id + ", title=" + this.title + ", desc=" + this.desc + ", pics=" + this.pics + ", info=" + this.info + ")";
    }

    public AdInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, "posId");
        Intrinsics.checkNotNullParameter(str4, "id");
        Intrinsics.checkNotNullParameter(str5, "title");
        Intrinsics.checkNotNullParameter(str6, "desc");
        Intrinsics.checkNotNullParameter(str7, "pics");
        Intrinsics.checkNotNullParameter(str8, "info");
        this.name = str;
        this.appId = str2;
        this.posId = str3;
        this.id = str4;
        this.title = str5;
        this.desc = str6;
        this.pics = str7;
        this.info = str8;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getPosId() {
        return this.posId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getPics() {
        return this.pics;
    }

    public final String getInfo() {
        return this.info;
    }
}
