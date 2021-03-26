package com.coolapk.market.view.feedv8;

import com.coolapk.market.view.feedv8.ArticleModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\t¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleShareUrl;", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "title", "", "subTitle", "url", "logo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLogo", "()Ljava/lang/String;", "getSubTitle", "getTitle", "type", "Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "getType", "()Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleModel.kt */
public final class ArticleShareUrl implements ArticleModel {
    public static final Companion Companion = new Companion(null);
    private final String logo;
    private final String subTitle;
    private final String title;
    private final String url;

    public static /* synthetic */ ArticleShareUrl copy$default(ArticleShareUrl articleShareUrl, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = articleShareUrl.title;
        }
        if ((i & 2) != 0) {
            str2 = articleShareUrl.subTitle;
        }
        if ((i & 4) != 0) {
            str3 = articleShareUrl.url;
        }
        if ((i & 8) != 0) {
            str4 = articleShareUrl.logo;
        }
        return articleShareUrl.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.logo;
    }

    public final ArticleShareUrl copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subTitle");
        Intrinsics.checkNotNullParameter(str3, "url");
        Intrinsics.checkNotNullParameter(str4, "logo");
        return new ArticleShareUrl(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArticleShareUrl)) {
            return false;
        }
        ArticleShareUrl articleShareUrl = (ArticleShareUrl) obj;
        return Intrinsics.areEqual(this.title, articleShareUrl.title) && Intrinsics.areEqual(this.subTitle, articleShareUrl.subTitle) && Intrinsics.areEqual(this.url, articleShareUrl.url) && Intrinsics.areEqual(this.logo, articleShareUrl.logo);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subTitle;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.logo;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ArticleShareUrl(title=" + this.title + ", subTitle=" + this.subTitle + ", url=" + this.url + ", logo=" + this.logo + ")";
    }

    public ArticleShareUrl(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subTitle");
        Intrinsics.checkNotNullParameter(str3, "url");
        Intrinsics.checkNotNullParameter(str4, "logo");
        this.title = str;
        this.subTitle = str2;
        this.url = str3;
        this.logo = str4;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleShareUrl$Companion;", "", "()V", "fromJSONObject", "Lcom/coolapk/market/view/feedv8/ArticleShareUrl;", "json", "Lorg/json/JSONObject;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ArticleShareUrl fromJSONObject(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String optString = jSONObject.optString("title");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"title\")");
            String optString2 = jSONObject.optString("subTitle");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"subTitle\")");
            String optString3 = jSONObject.optString("url");
            Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"url\")");
            String optString4 = jSONObject.optString("logo");
            Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"logo\")");
            return new ArticleShareUrl(optString, optString2, optString3, optString4);
        }
    }

    @Override // com.coolapk.market.view.feedv8.ArticleModel
    public ArticleModel.Type getType() {
        return ArticleModel.Type.ShareUrl;
    }

    @Override // com.coolapk.market.view.feedv8.ArticleModel
    public JSONObject toJSONObject() {
        JSONObject put = ArticleModel.DefaultImpls.toJSONObject(this).put("title", this.title).put("subTitle", this.subTitle).put("url", this.url).put("logo", this.logo);
        Intrinsics.checkNotNullExpressionValue(put, "super.toJSONObject()\n   …       .put(\"logo\", logo)");
        return put;
    }
}
