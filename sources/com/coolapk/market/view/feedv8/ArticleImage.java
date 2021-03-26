package com.coolapk.market.view.feedv8;

import com.coolapk.market.view.feedv8.ArticleModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleImage;", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "imageUrl", "", "text", "(Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "getText", "type", "Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "getType", "()Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleModel.kt */
public final class ArticleImage implements ArticleModel {
    public static final Companion Companion = new Companion(null);
    private final String imageUrl;
    private final String text;

    public static /* synthetic */ ArticleImage copy$default(ArticleImage articleImage, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = articleImage.imageUrl;
        }
        if ((i & 2) != 0) {
            str2 = articleImage.text;
        }
        return articleImage.copy(str, str2);
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final String component2() {
        return this.text;
    }

    public final ArticleImage copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        Intrinsics.checkNotNullParameter(str2, "text");
        return new ArticleImage(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArticleImage)) {
            return false;
        }
        ArticleImage articleImage = (ArticleImage) obj;
        return Intrinsics.areEqual(this.imageUrl, articleImage.imageUrl) && Intrinsics.areEqual(this.text, articleImage.text);
    }

    public int hashCode() {
        String str = this.imageUrl;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.text;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ArticleImage(imageUrl=" + this.imageUrl + ", text=" + this.text + ")";
    }

    public ArticleImage(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.imageUrl = str;
        this.text = str2;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getText() {
        return this.text;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleImage$Companion;", "", "()V", "fromJSONObject", "Lcom/coolapk/market/view/feedv8/ArticleImage;", "json", "Lorg/json/JSONObject;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ArticleImage fromJSONObject(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String optString = jSONObject.optString("url");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"url\")");
            String optString2 = jSONObject.optString("description");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"description\")");
            return new ArticleImage(optString, optString2);
        }
    }

    @Override // com.coolapk.market.view.feedv8.ArticleModel
    public ArticleModel.Type getType() {
        return ArticleModel.Type.Image;
    }

    @Override // com.coolapk.market.view.feedv8.ArticleModel
    public JSONObject toJSONObject() {
        JSONObject put = ArticleModel.DefaultImpls.toJSONObject(this).put("url", this.imageUrl).put("description", this.text);
        Intrinsics.checkNotNullExpressionValue(put, "super.toJSONObject()\n   ….put(\"description\", text)");
        return put;
    }
}
