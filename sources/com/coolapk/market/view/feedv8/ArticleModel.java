package com.coolapk.market.view.feedv8;

import com.coolapk.market.view.feedv8.ArticleCard;
import com.coolapk.market.view.feedv8.ArticleImage;
import com.coolapk.market.view.feedv8.ArticleNative;
import com.coolapk.market.view.feedv8.ArticleShareUrl;
import com.coolapk.market.view.feedv8.ArticleText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0002\b\tJ\b\u0010\u0006\u001a\u00020\u0007H\u0017R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleModel;", "", "type", "Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "getType", "()Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "toJSONObject", "Lorg/json/JSONObject;", "Companion", "Type", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ArticleModel.kt */
public interface ArticleModel {
    public static final Companion Companion = Companion.$$INSTANCE;

    Type getType();

    JSONObject toJSONObject();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleModel$Type;", "", "text", "", "longName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLongName", "()Ljava/lang/String;", "getText", "Top", "Text", "Image", "Card", "ShareUrl", "Bottom", "Else", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleModel.kt */
    public enum Type {
        Top("top", "article_top"),
        Text("text", "article_text"),
        Image("image", "article_image"),
        Card("card", "article_card"),
        ShareUrl("shareUrl", "article_share_url"),
        Bottom("bottom", "article_bottom"),
        Else("else", "article_else");
        
        private final String longName;
        private final String text;

        private Type(String str, String str2) {
            this.text = str;
            this.longName = str2;
        }

        public final String getLongName() {
            return this.longName;
        }

        public final String getText() {
            return this.text;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* compiled from: ArticleModel.kt */
    public static final class DefaultImpls {
        public static JSONObject toJSONObject(ArticleModel articleModel) {
            JSONObject put = new JSONObject().put("type", articleModel.getType().getText());
            Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …  .put(\"type\", type.text)");
            return put;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/feedv8/ArticleModel$Companion;", "", "()V", "fromJson", "", "Lcom/coolapk/market/view/feedv8/ArticleModel;", "json", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ArticleModel.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final List<ArticleModel> fromJson(String str) {
            ArticleModel articleModel;
            Intrinsics.checkNotNullParameter(str, "json");
            if (str.length() == 0) {
                return CollectionsKt.emptyList();
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                IntRange until = RangesKt.until(0, jSONArray.length());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                Iterator it2 = until.iterator();
                while (it2.hasNext()) {
                    arrayList.add(jSONArray.getJSONObject(((IntIterator) it2).nextInt()));
                }
                ArrayList<JSONObject> arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                for (JSONObject jSONObject : arrayList2) {
                    String optString = jSONObject.optString("type");
                    if (Intrinsics.areEqual(optString, Type.Text.getText())) {
                        ArticleText.Companion companion = ArticleText.Companion;
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "it");
                        articleModel = companion.fromJSONObject(jSONObject);
                    } else if (Intrinsics.areEqual(optString, Type.Card.getText())) {
                        ArticleCard.Companion companion2 = ArticleCard.Companion;
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "it");
                        articleModel = companion2.fromJSONObject(jSONObject);
                    } else if (Intrinsics.areEqual(optString, Type.Image.getText())) {
                        ArticleImage.Companion companion3 = ArticleImage.Companion;
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "it");
                        articleModel = companion3.fromJSONObject(jSONObject);
                    } else if (Intrinsics.areEqual(optString, Type.ShareUrl.getText())) {
                        ArticleShareUrl.Companion companion4 = ArticleShareUrl.Companion;
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "it");
                        articleModel = companion4.fromJSONObject(jSONObject);
                    } else if (Intrinsics.areEqual(optString, Type.Top.getText())) {
                        ArticleNative.Companion companion5 = ArticleNative.Companion;
                        Type type = Type.Top;
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "it");
                        articleModel = companion5.fromJSONObject(type, jSONObject);
                    } else if (Intrinsics.areEqual(optString, Type.Bottom.getText())) {
                        ArticleNative.Companion companion6 = ArticleNative.Companion;
                        Type type2 = Type.Bottom;
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "it");
                        articleModel = companion6.fromJSONObject(type2, jSONObject);
                    } else {
                        ArticleNative.Companion companion7 = ArticleNative.Companion;
                        Type type3 = Type.Else;
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "it");
                        articleModel = companion7.fromJSONObject(type3, jSONObject);
                    }
                    arrayList3.add(articleModel);
                }
                return arrayList3;
            } catch (Exception e) {
                e.printStackTrace();
                return CollectionsKt.emptyList();
            }
        }
    }
}
