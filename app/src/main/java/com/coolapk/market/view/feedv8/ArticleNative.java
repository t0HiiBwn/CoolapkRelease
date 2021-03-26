package com.coolapk.market.view.feedv8;

import com.coolapk.market.view.feedv8.ArticleModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleNative;", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "type", "Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "imageUrl", "", "text", "(Lcom/coolapk/market/view/feedv8/ArticleModel$Type;Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "getText", "getType", "()Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleModel.kt */
public final class ArticleNative implements ArticleModel {
    public static final Companion Companion = new Companion(null);
    private final String imageUrl;
    private final String text;
    private final ArticleModel.Type type;

    public static /* synthetic */ ArticleNative copy$default(ArticleNative articleNative, ArticleModel.Type type2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            type2 = articleNative.getType();
        }
        if ((i & 2) != 0) {
            str = articleNative.imageUrl;
        }
        if ((i & 4) != 0) {
            str2 = articleNative.text;
        }
        return articleNative.copy(type2, str, str2);
    }

    public final ArticleModel.Type component1() {
        return getType();
    }

    public final String component2() {
        return this.imageUrl;
    }

    public final String component3() {
        return this.text;
    }

    public final ArticleNative copy(ArticleModel.Type type2, String str, String str2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        Intrinsics.checkNotNullParameter(str2, "text");
        return new ArticleNative(type2, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArticleNative)) {
            return false;
        }
        ArticleNative articleNative = (ArticleNative) obj;
        return Intrinsics.areEqual(getType(), articleNative.getType()) && Intrinsics.areEqual(this.imageUrl, articleNative.imageUrl) && Intrinsics.areEqual(this.text, articleNative.text);
    }

    public int hashCode() {
        ArticleModel.Type type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        String str = this.imageUrl;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.text;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ArticleNative(type=" + getType() + ", imageUrl=" + this.imageUrl + ", text=" + this.text + ")";
    }

    public ArticleNative(ArticleModel.Type type2, String str, String str2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.type = type2;
        this.imageUrl = str;
        this.text = str2;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.coolapk.market.view.feedv8.ArticleModel
    public ArticleModel.Type getType() {
        return this.type;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleNative$Companion;", "", "()V", "fromJSONObject", "Lcom/coolapk/market/view/feedv8/ArticleNative;", "type", "Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "json", "Lorg/json/JSONObject;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ArticleNative fromJSONObject(ArticleModel.Type type, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String optString = jSONObject.optString("url");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"url\")");
            String optString2 = jSONObject.optString("description");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"description\")");
            return new ArticleNative(type, optString, optString2);
        }
    }

    @Override // com.coolapk.market.view.feedv8.ArticleModel
    public JSONObject toJSONObject() {
        JSONObject put = ArticleModel.DefaultImpls.toJSONObject(this).put("url", this.imageUrl).put("description", this.text);
        Intrinsics.checkNotNullExpressionValue(put, "super.toJSONObject()\n   ….put(\"description\", text)");
        return put;
    }
}
