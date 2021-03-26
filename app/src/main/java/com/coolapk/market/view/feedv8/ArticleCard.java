package com.coolapk.market.view.feedv8;

import com.coolapk.market.view.feedv8.ArticleModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleCard;", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "urlKey", "", "(Ljava/lang/String;)V", "type", "Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "getType", "()Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "getUrlKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleModel.kt */
public final class ArticleCard implements ArticleModel {
    public static final Companion Companion = new Companion(null);
    private final String urlKey;

    public static /* synthetic */ ArticleCard copy$default(ArticleCard articleCard, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = articleCard.urlKey;
        }
        return articleCard.copy(str);
    }

    public final String component1() {
        return this.urlKey;
    }

    public final ArticleCard copy(String str) {
        Intrinsics.checkNotNullParameter(str, "urlKey");
        return new ArticleCard(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ArticleCard) && Intrinsics.areEqual(this.urlKey, ((ArticleCard) obj).urlKey);
        }
        return true;
    }

    public int hashCode() {
        String str = this.urlKey;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ArticleCard(urlKey=" + this.urlKey + ")";
    }

    public ArticleCard(String str) {
        Intrinsics.checkNotNullParameter(str, "urlKey");
        this.urlKey = str;
    }

    public final String getUrlKey() {
        return this.urlKey;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleCard$Companion;", "", "()V", "fromJSONObject", "Lcom/coolapk/market/view/feedv8/ArticleCard;", "json", "Lorg/json/JSONObject;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ArticleCard fromJSONObject(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String optString = jSONObject.optString("url");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"url\")");
            return new ArticleCard(optString);
        }
    }

    @Override // com.coolapk.market.view.feedv8.ArticleModel
    public ArticleModel.Type getType() {
        return ArticleModel.Type.Card;
    }

    @Override // com.coolapk.market.view.feedv8.ArticleModel
    public JSONObject toJSONObject() {
        JSONObject put = ArticleModel.DefaultImpls.toJSONObject(this).put("url", this.urlKey);
        Intrinsics.checkNotNullExpressionValue(put, "super.toJSONObject()\n   …      .put(\"url\", urlKey)");
        return put;
    }
}
