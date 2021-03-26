package com.coolapk.market.view.feedv8;

import com.coolapk.market.view.feedv8.ArticleModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleText;", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "type", "Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "getType", "()Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleModel.kt */
public final class ArticleText implements ArticleModel {
    public static final Companion Companion = new Companion(null);
    private final String text;

    public static /* synthetic */ ArticleText copy$default(ArticleText articleText, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = articleText.text;
        }
        return articleText.copy(str);
    }

    public final String component1() {
        return this.text;
    }

    public final ArticleText copy(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new ArticleText(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ArticleText) && Intrinsics.areEqual(this.text, ((ArticleText) obj).text);
        }
        return true;
    }

    public int hashCode() {
        String str = this.text;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ArticleText(text=" + this.text + ")";
    }

    public ArticleText(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
    }

    public final String getText() {
        return this.text;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleText$Companion;", "", "()V", "fromJSONObject", "Lcom/coolapk/market/view/feedv8/ArticleText;", "json", "Lorg/json/JSONObject;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ArticleText fromJSONObject(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String optString = jSONObject.optString("message");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"message\")");
            return new ArticleText(optString);
        }
    }

    @Override // com.coolapk.market.view.feedv8.ArticleModel
    public ArticleModel.Type getType() {
        return ArticleModel.Type.Text;
    }

    @Override // com.coolapk.market.view.feedv8.ArticleModel
    public JSONObject toJSONObject() {
        JSONObject put = ArticleModel.DefaultImpls.toJSONObject(this).put("message", this.text);
        Intrinsics.checkNotNullExpressionValue(put, "super.toJSONObject()\n   …    .put(\"message\", text)");
        return put;
    }
}
